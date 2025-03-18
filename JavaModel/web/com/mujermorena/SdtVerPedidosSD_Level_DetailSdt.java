package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtVerPedidosSD_Level_DetailSdt extends GxUserType
{
   public SdtVerPedidosSD_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtVerPedidosSD_Level_DetailSdt.class));
   }

   public SdtVerPedidosSD_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtVerPedidosSD_Level_DetailSdt");
   }

   public SdtVerPedidosSD_Level_DetailSdt( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "SdtVerPedidosSD_Level_DetailSdt");
   }

   public SdtVerPedidosSD_Level_DetailSdt( StructSdtVerPedidosSD_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Isauthorized_useraction1") )
            {
               gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
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
         sName = "VerPedidosSD_Level_DetailSdt" ;
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
      oWriter.writeElement("Isauthorized_useraction1", GXutil.booltostr( gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop);
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
      AddObjectProperty("Isauthorized_useraction1", gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1, false, false);
      AddObjectProperty("Gxdynprop", gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop, false, false);
   }

   public boolean getgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1( )
   {
      return gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 ;
   }

   public void setgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1( boolean value )
   {
      gxTv_SdtVerPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 = value ;
   }

   public String getgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtVerPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtVerPedidosSD_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtVerPedidosSD_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtVerPedidosSD_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtVerPedidosSD_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtVerPedidosSD_Level_DetailSdt struct )
   {
      setgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1(struct.getIsauthorized_useraction1());
      setgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtVerPedidosSD_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtVerPedidosSD_Level_DetailSdt struct = new com.mujermorena.StructSdtVerPedidosSD_Level_DetailSdt ();
      struct.setIsauthorized_useraction1(getgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1());
      struct.setGxdynprop(getgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop());
      return struct ;
   }

   protected byte gxTv_SdtVerPedidosSD_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 ;
   protected boolean readElement ;
   protected boolean formatError ;
}

