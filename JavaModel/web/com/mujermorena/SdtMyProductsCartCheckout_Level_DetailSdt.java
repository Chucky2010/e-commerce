package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMyProductsCartCheckout_Level_DetailSdt extends GxUserType
{
   public SdtMyProductsCartCheckout_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMyProductsCartCheckout_Level_DetailSdt.class));
   }

   public SdtMyProductsCartCheckout_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMyProductsCartCheckout_Level_DetailSdt");
   }

   public SdtMyProductsCartCheckout_Level_DetailSdt( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtMyProductsCartCheckout_Level_DetailSdt");
   }

   public SdtMyProductsCartCheckout_Level_DetailSdt( StructSdtMyProductsCartCheckout_Level_DetailSdt struct )
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
               gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Cartproductcollection") )
            {
               if ( gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection == null )
               {
                  gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection.readxml(oReader, "Cartproductcollection") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Cartproductcollection") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Isauthorized_continue") )
            {
               gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
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
         sName = "MyProductsCartCheckout_Level_DetailSdt" ;
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
      oWriter.writeElement("Cartsubtotaltxt", gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      if ( gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection != null )
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
         gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection.writexml(oWriter, "Cartproductcollection", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("Isauthorized_continue", GXutil.booltostr( gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("Cartsubtotaltxt", gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt, false, false);
      if ( gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection != null )
      {
         AddObjectProperty("Cartproductcollection", gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection, false, false);
      }
      AddObjectProperty("Isauthorized_continue", gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue, false, false);
      AddObjectProperty("Gxdynprop", gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop, false, false);
   }

   public String getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt ;
   }

   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt( String value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt = value ;
   }

   public GXBaseCollection<com.mujermorena.SdtNMCartProduct> getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection( )
   {
      if ( gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection == null )
      {
         gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection ;
   }

   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection( GXBaseCollection<com.mujermorena.SdtNMCartProduct> value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection = value ;
   }

   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_SetNull( )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection = null ;
   }

   public boolean getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_IsNull( )
   {
      if ( gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection == null )
      {
         return true ;
      }
      return false ;
   }

   public boolean getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue ;
   }

   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue( boolean value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue = value ;
   }

   public String getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt = "" ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMyProductsCartCheckout_Level_DetailSdt struct )
   {
      setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt(struct.getCartsubtotaltxt());
      GXBaseCollection<com.mujermorena.SdtNMCartProduct> gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtNMCartProduct> gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux1 = struct.getCartproductcollection();
      if (gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux1.size(); i++)
         {
            gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux.add(new com.mujermorena.SdtNMCartProduct(gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection(gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux);
      setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue(struct.getIsauthorized_continue());
      setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMyProductsCartCheckout_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMyProductsCartCheckout_Level_DetailSdt struct = new com.mujermorena.StructSdtMyProductsCartCheckout_Level_DetailSdt ();
      struct.setCartsubtotaltxt(getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt());
      struct.setCartproductcollection(getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection().getStruct());
      struct.setIsauthorized_continue(getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue());
      struct.setGxdynprop(getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop());
      return struct ;
   }

   protected byte gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt ;
   protected GXBaseCollection<com.mujermorena.SdtNMCartProduct> gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection_aux ;
   protected GXBaseCollection<com.mujermorena.SdtNMCartProduct> gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection=null ;
}

