package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_WebClient extends GxSilentTrnSdt
{
   public SdtWWP_WebClient( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_WebClient.class));
   }

   public SdtWWP_WebClient( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_WebClient");
      initialize( remoteHandle) ;
   }

   public SdtWWP_WebClient( int remoteHandle ,
                            StructSdtWWP_WebClient struct )
   {
      this(remoteHandle);
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

   public void Load( String AV39WWPWebClientId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV39WWPWebClientId});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPWebClientId", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Notifications\\Web\\WWP_WebClient");
      metadata.set("BT", "WWP_WebClient");
      metadata.set("PK", "[ \"WWPWebClientId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"WWPUserExtendedId\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientId") )
            {
               gxTv_SdtWWP_WebClient_Wwpwebclientid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientBrowserId") )
            {
               gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientBrowserVersion") )
            {
               gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientFirstRegistered") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientLastRegistered") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId") )
            {
               gxTv_SdtWWP_WebClient_Wwpuserextendedid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_WebClient_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_WebClient_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientId_Z") )
            {
               gxTv_SdtWWP_WebClient_Wwpwebclientid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientBrowserId_Z") )
            {
               gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientFirstRegistered_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebClientLastRegistered_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_Z") )
            {
               gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_N") )
            {
               gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_WebClient" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "Mujer_Morena" ;
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
      oWriter.writeElement("WWPWebClientId", gxTv_SdtWWP_WebClient_Wwpwebclientid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebClientBrowserId", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebClientBrowserVersion", gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPWebClientFirstRegistered", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPWebClientLastRegistered", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedId", gxTv_SdtWWP_WebClient_Wwpuserextendedid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_WebClient_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebClient_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebClientId_Z", gxTv_SdtWWP_WebClient_Wwpwebclientid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebClientBrowserId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPWebClientFirstRegistered_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPWebClientLastRegistered_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_Z", gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebClient_Wwpuserextendedid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
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
      AddObjectProperty("WWPWebClientId", gxTv_SdtWWP_WebClient_Wwpwebclientid, false, includeNonInitialized);
      AddObjectProperty("WWPWebClientBrowserId", gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid, false, includeNonInitialized);
      AddObjectProperty("WWPWebClientBrowserVersion", gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("WWPWebClientFirstRegistered", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( datetimemil_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("WWPWebClientLastRegistered", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId", gxTv_SdtWWP_WebClient_Wwpuserextendedid, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_WebClient_Wwpuserextendedid_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_WebClient_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_WebClient_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPWebClientId_Z", gxTv_SdtWWP_WebClient_Wwpwebclientid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPWebClientBrowserId_Z", gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("WWPWebClientFirstRegistered_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( datetimemil_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("WWPWebClientLastRegistered_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_Z", gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_WebClient_Wwpuserextendedid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient sdt )
   {
      if ( sdt.IsDirty("WWPWebClientId") )
      {
         gxTv_SdtWWP_WebClient_N = (byte)(0) ;
         gxTv_SdtWWP_WebClient_Wwpwebclientid = sdt.getgxTv_SdtWWP_WebClient_Wwpwebclientid() ;
      }
      if ( sdt.IsDirty("WWPWebClientBrowserId") )
      {
         gxTv_SdtWWP_WebClient_N = (byte)(0) ;
         gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid = sdt.getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid() ;
      }
      if ( sdt.IsDirty("WWPWebClientBrowserVersion") )
      {
         gxTv_SdtWWP_WebClient_N = (byte)(0) ;
         gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion = sdt.getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion() ;
      }
      if ( sdt.IsDirty("WWPWebClientFirstRegistered") )
      {
         gxTv_SdtWWP_WebClient_N = (byte)(0) ;
         gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = sdt.getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered() ;
      }
      if ( sdt.IsDirty("WWPWebClientLastRegistered") )
      {
         gxTv_SdtWWP_WebClient_N = (byte)(0) ;
         gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = sdt.getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedId") )
      {
         gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = sdt.getgxTv_SdtWWP_WebClient_Wwpuserextendedid_N() ;
         gxTv_SdtWWP_WebClient_N = (byte)(0) ;
         gxTv_SdtWWP_WebClient_Wwpuserextendedid = sdt.getgxTv_SdtWWP_WebClient_Wwpuserextendedid() ;
      }
   }

   public String getgxTv_SdtWWP_WebClient_Wwpwebclientid( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientid ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientid( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtWWP_WebClient_Wwpwebclientid, value) != 0 )
      {
         gxTv_SdtWWP_WebClient_Mode = "INS" ;
         this.setgxTv_SdtWWP_WebClient_Wwpwebclientid_Z_SetNull( );
         this.setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z_SetNull( );
         this.setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z_SetNull( );
         this.setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z_SetNull( );
         this.setgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z_SetNull( );
      }
      SetDirty("Wwpwebclientid");
      gxTv_SdtWWP_WebClient_Wwpwebclientid = value ;
   }

   public short getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid( short value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientbrowserid");
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid = value ;
   }

   public String getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientbrowserversion");
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion = value ;
   }

   public java.util.Date getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientfirstregistered");
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = value ;
   }

   public java.util.Date getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientlastregistered");
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = value ;
   }

   public String getgxTv_SdtWWP_WebClient_Wwpuserextendedid( )
   {
      return gxTv_SdtWWP_WebClient_Wwpuserextendedid ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpuserextendedid( String value )
   {
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid");
      gxTv_SdtWWP_WebClient_Wwpuserextendedid = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpuserextendedid_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = (byte)(1) ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid = "" ;
      SetDirty("Wwpuserextendedid");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpuserextendedid_IsNull( )
   {
      return (gxTv_SdtWWP_WebClient_Wwpuserextendedid_N==1) ;
   }

   public String getgxTv_SdtWWP_WebClient_Mode( )
   {
      return gxTv_SdtWWP_WebClient_Mode ;
   }

   public void setgxTv_SdtWWP_WebClient_Mode( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_WebClient_Mode = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Mode_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_WebClient_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_WebClient_Initialized( )
   {
      return gxTv_SdtWWP_WebClient_Initialized ;
   }

   public void setgxTv_SdtWWP_WebClient_Initialized( short value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_WebClient_Initialized = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Initialized_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_WebClient_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_WebClient_Wwpwebclientid_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientid_Z ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientid_Z( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientid_Z");
      gxTv_SdtWWP_WebClient_Wwpwebclientid_Z = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientid_Z_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpwebclientid_Z = "" ;
      SetDirty("Wwpwebclientid_Z");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpwebclientid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z( short value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientbrowserid_Z");
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z = (short)(0) ;
      SetDirty("Wwpwebclientbrowserid_Z");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientfirstregistered_Z");
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebclientfirstregistered_Z");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpwebclientlastregistered_Z");
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebclientlastregistered_Z");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_Z");
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z = "" ;
      SetDirty("Wwpuserextendedid_Z");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_WebClient_Wwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_WebClient_Wwpuserextendedid_N ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = value ;
   }

   public void setgxTv_SdtWWP_WebClient_Wwpuserextendedid_N_SetNull( )
   {
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
   }

   public boolean getgxTv_SdtWWP_WebClient_Wwpuserextendedid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_WebClient_Wwpwebclientid = "" ;
      gxTv_SdtWWP_WebClient_N = (byte)(1) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebClient_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_WebClient_Mode = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientid_Z = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetimemil_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_WebClient_N ;
   }

   public com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient Clone( )
   {
      com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient sdt;
      com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebClient struct )
   {
      setgxTv_SdtWWP_WebClient_Wwpwebclientid(struct.getWwpwebclientid());
      setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid(struct.getWwpwebclientbrowserid());
      setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion(struct.getWwpwebclientbrowserversion());
      setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered(struct.getWwpwebclientfirstregistered());
      setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered(struct.getWwpwebclientlastregistered());
      setgxTv_SdtWWP_WebClient_Wwpuserextendedid(struct.getWwpuserextendedid());
      setgxTv_SdtWWP_WebClient_Mode(struct.getMode());
      setgxTv_SdtWWP_WebClient_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_WebClient_Wwpwebclientid_Z(struct.getWwpwebclientid_Z());
      setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z(struct.getWwpwebclientbrowserid_Z());
      setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z(struct.getWwpwebclientfirstregistered_Z());
      setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z(struct.getWwpwebclientlastregistered_Z());
      setgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z(struct.getWwpuserextendedid_Z());
      setgxTv_SdtWWP_WebClient_Wwpuserextendedid_N(struct.getWwpuserextendedid_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebClient getStruct( )
   {
      com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebClient struct = new com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebClient ();
      struct.setWwpwebclientid(getgxTv_SdtWWP_WebClient_Wwpwebclientid());
      struct.setWwpwebclientbrowserid(getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid());
      struct.setWwpwebclientbrowserversion(getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion());
      struct.setWwpwebclientfirstregistered(getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered());
      struct.setWwpwebclientlastregistered(getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered());
      struct.setWwpuserextendedid(getgxTv_SdtWWP_WebClient_Wwpuserextendedid());
      struct.setMode(getgxTv_SdtWWP_WebClient_Mode());
      struct.setInitialized(getgxTv_SdtWWP_WebClient_Initialized());
      struct.setWwpwebclientid_Z(getgxTv_SdtWWP_WebClient_Wwpwebclientid_Z());
      struct.setWwpwebclientbrowserid_Z(getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z());
      struct.setWwpwebclientfirstregistered_Z(getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z());
      struct.setWwpwebclientlastregistered_Z(getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z());
      struct.setWwpuserextendedid_Z(getgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z());
      struct.setWwpuserextendedid_N(getgxTv_SdtWWP_WebClient_Wwpuserextendedid_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_WebClient_N ;
   private byte gxTv_SdtWWP_WebClient_Wwpuserextendedid_N ;
   private short gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid ;
   private short gxTv_SdtWWP_WebClient_Initialized ;
   private short gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtWWP_WebClient_Wwpwebclientid ;
   private String gxTv_SdtWWP_WebClient_Wwpuserextendedid ;
   private String gxTv_SdtWWP_WebClient_Mode ;
   private String gxTv_SdtWWP_WebClient_Wwpwebclientid_Z ;
   private String gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered ;
   private java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered ;
   private java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z ;
   private java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z ;
   private java.util.Date datetimemil_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion ;
}

