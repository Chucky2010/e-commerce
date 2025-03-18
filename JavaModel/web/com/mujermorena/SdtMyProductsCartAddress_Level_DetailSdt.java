package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMyProductsCartAddress_Level_DetailSdt extends GxUserType
{
   public SdtMyProductsCartAddress_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMyProductsCartAddress_Level_DetailSdt.class));
   }

   public SdtMyProductsCartAddress_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMyProductsCartAddress_Level_DetailSdt");
   }

   public SdtMyProductsCartAddress_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtMyProductsCartAddress_Level_DetailSdt");
   }

   public SdtMyProductsCartAddress_Level_DetailSdt( StructSdtMyProductsCartAddress_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxprops_cartuseraddresscollection") )
            {
               gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Cartuseraddresscollection") )
            {
               if ( gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection == null )
               {
                  gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection.readxml(oReader, "Cartuseraddresscollection") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Cartuseraddresscollection") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Selectedid") )
            {
               gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
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
         sName = "MyProductsCartAddress_Level_DetailSdt" ;
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
      oWriter.writeElement("Gxprops_cartuseraddresscollection", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      if ( gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection != null )
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
         gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection.writexml(oWriter, "Cartuseraddresscollection", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("Selectedid", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop);
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
      AddObjectProperty("Gxprops_cartuseraddresscollection", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection, false, false);
      if ( gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection != null )
      {
         AddObjectProperty("Cartuseraddresscollection", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection, false, false);
      }
      AddObjectProperty("Selectedid", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid, false, false);
      AddObjectProperty("Gxdynprop", gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop, false, false);
   }

   public String getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection ;
   }

   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection( String value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection = value ;
   }

   public GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection( )
   {
      if ( gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection == null )
      {
         gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection ;
   }

   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection( GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection = value ;
   }

   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_SetNull( )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection = null ;
   }

   public boolean getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_IsNull( )
   {
      if ( gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid ;
   }

   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid( String value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid = value ;
   }

   public String getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection = "" ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid = "" ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMyProductsCartAddress_Level_DetailSdt struct )
   {
      setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection(struct.getGxprops_cartuseraddresscollection());
      GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtNMCartUserAddress> gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux1 = struct.getCartuseraddresscollection();
      if (gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux1.size(); i++)
         {
            gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux.add(new com.mujermorena.SdtNMCartUserAddress(gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection(gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux);
      setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid(struct.getSelectedid());
      setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMyProductsCartAddress_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMyProductsCartAddress_Level_DetailSdt struct = new com.mujermorena.StructSdtMyProductsCartAddress_Level_DetailSdt ();
      struct.setGxprops_cartuseraddresscollection(getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection());
      struct.setCartuseraddresscollection(getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection().getStruct());
      struct.setSelectedid(getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid());
      struct.setGxdynprop(getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop());
      return struct ;
   }

   protected byte gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection ;
   protected String gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid ;
   protected GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection_aux ;
   protected GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection=null ;
}

