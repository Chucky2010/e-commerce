package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMyProductsCartConfirm_Level_DetailSdt extends GxUserType
{
   public SdtMyProductsCartConfirm_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMyProductsCartConfirm_Level_DetailSdt.class));
   }

   public SdtMyProductsCartConfirm_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMyProductsCartConfirm_Level_DetailSdt");
   }

   public SdtMyProductsCartConfirm_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtMyProductsCartConfirm_Level_DetailSdt");
   }

   public SdtMyProductsCartConfirm_Level_DetailSdt( StructSdtMyProductsCartConfirm_Level_DetailSdt struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "Cartsubtotaltxt") )
            {
               gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Cartuseraddress") )
            {
               if ( gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress == null )
               {
                  gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress = new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress.readxml(oReader, "Cartuseraddress") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Tipopagoid") )
            {
               gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Datopago") )
            {
               gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdesc_tipopagoid") )
            {
               gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "MyProductsCartConfirm_Level_DetailSdt" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("Cartsubtotaltxt", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      if ( gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "http://tempuri.org/" ;
         }
         else
         {
            sNameSpace1 = "http://tempuri.org/" ;
         }
         gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress.writexml(oWriter, "Cartuseraddress", sNameSpace1);
      }
      oWriter.writeElement("Tipopagoid", GXutil.trim( GXutil.str( gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Datopago", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdesc_tipopagoid", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("Cartsubtotaltxt", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt, false, false);
      if ( gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress != null )
      {
         AddObjectProperty("Cartuseraddress", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress, false, false);
      }
      AddObjectProperty("Tipopagoid", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid, false, false);
      AddObjectProperty("Datopago", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago, false, false);
      AddObjectProperty("Gxdynprop", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop, false, false);
      AddObjectProperty("Gxdesc_tipopagoid", gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid, false, false);
   }

   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt ;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt = value ;
   }

   public com.mujermorena.SdtNMCartUserAddress getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress( )
   {
      if ( gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress == null )
      {
         gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress = new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
      }
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress ;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress( com.mujermorena.SdtNMCartUserAddress value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress = value;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress_SetNull( )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress = (com.mujermorena.SdtNMCartUserAddress)null;
   }

   public boolean getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress_IsNull( )
   {
      if ( gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress == null )
      {
         return true ;
      }
      return false ;
   }

   public long getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid ;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid( long value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid = value ;
   }

   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago ;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago = value ;
   }

   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop = value ;
   }

   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid ;
   }

   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt = "" ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago = "" ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop = "" ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMyProductsCartConfirm_Level_DetailSdt struct )
   {
      setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt(struct.getCartsubtotaltxt());
      setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress(new com.mujermorena.SdtNMCartUserAddress(struct.getCartuseraddress()));
      setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid(struct.getTipopagoid());
      setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago(struct.getDatopago());
      setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
      setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid(struct.getGxdesc_tipopagoid());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMyProductsCartConfirm_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMyProductsCartConfirm_Level_DetailSdt struct = new com.mujermorena.StructSdtMyProductsCartConfirm_Level_DetailSdt ();
      struct.setCartsubtotaltxt(getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt());
      struct.setCartuseraddress(getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress().getStruct());
      struct.setTipopagoid(getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid());
      struct.setDatopago(getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago());
      struct.setGxdynprop(getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop());
      struct.setGxdesc_tipopagoid(getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid());
      return struct ;
   }

   protected byte gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid ;
   protected com.mujermorena.SdtNMCartUserAddress gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress=null ;
}

