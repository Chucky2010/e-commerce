package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_Notification extends GxSilentTrnSdt
{
   public SdtWWP_Notification( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_Notification.class));
   }

   public SdtWWP_Notification( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_Notification");
      initialize( remoteHandle) ;
   }

   public SdtWWP_Notification( int remoteHandle ,
                               StructSdtWWP_Notification struct )
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

   public void Load( long AV37WWPNotificationId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV37WWPNotificationId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPNotificationId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Notifications\\Common\\WWP_Notification");
      metadata.set("BT", "WWP_Notification");
      metadata.set("PK", "[ \"WWPNotificationId\" ]");
      metadata.set("PKAssigned", "[ \"WWPNotificationId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"WWPNotificationDefinitionId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"WWPUserExtendedId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionId") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionName") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationCreated") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Notification_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Notification_Wwpnotificationcreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationIcon") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationicon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationTitle") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationShortDescription") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationshortdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationLink") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationlink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationIsRead") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationisread = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId") )
            {
               gxTv_SdtWWP_Notification_Wwpuserextendedid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedFullName") )
            {
               gxTv_SdtWWP_Notification_Wwpuserextendedfullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationMetadata") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationmetadata = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_Notification_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_Notification_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionId_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionName_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationCreated_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationIcon_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationicon_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationTitle_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationShortDescription_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationLink_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationlink_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationIsRead_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationisread_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpuserextendedid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedFullName_Z") )
            {
               gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_N") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_N") )
            {
               gxTv_SdtWWP_Notification_Wwpuserextendedid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationMetadata_N") )
            {
               gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_Notification" ;
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
      oWriter.writeElement("WWPNotificationId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpnotificationid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionName", gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Notification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPNotificationCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationIcon", gxTv_SdtWWP_Notification_Wwpnotificationicon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationTitle", gxTv_SdtWWP_Notification_Wwpnotificationtitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationShortDescription", gxTv_SdtWWP_Notification_Wwpnotificationshortdescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationLink", gxTv_SdtWWP_Notification_Wwpnotificationlink);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationIsRead", GXutil.booltostr( gxTv_SdtWWP_Notification_Wwpnotificationisread));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedId", gxTv_SdtWWP_Notification_Wwpuserextendedid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedFullName", gxTv_SdtWWP_Notification_Wwpuserextendedfullname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationMetadata", gxTv_SdtWWP_Notification_Wwpnotificationmetadata);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_Notification_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpnotificationid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionName_Z", gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPNotificationCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationIcon_Z", gxTv_SdtWWP_Notification_Wwpnotificationicon_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationTitle_Z", gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationShortDescription_Z", gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationLink_Z", gxTv_SdtWWP_Notification_Wwpnotificationlink_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationIsRead_Z", GXutil.booltostr( gxTv_SdtWWP_Notification_Wwpnotificationisread_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_Z", gxTv_SdtWWP_Notification_Wwpuserextendedid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedFullName_Z", gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpnotificationid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpuserextendedid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationMetadata_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N, 1, 0)));
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
      AddObjectProperty("WWPNotificationId", gxTv_SdtWWP_Notification_Wwpnotificationid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_Notification_Wwpnotificationid_N, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionId", gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionName", gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_Notification_Wwpnotificationcreated ;
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
      AddObjectProperty("WWPNotificationCreated", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationIcon", gxTv_SdtWWP_Notification_Wwpnotificationicon, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationTitle", gxTv_SdtWWP_Notification_Wwpnotificationtitle, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationShortDescription", gxTv_SdtWWP_Notification_Wwpnotificationshortdescription, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationLink", gxTv_SdtWWP_Notification_Wwpnotificationlink, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationIsRead", gxTv_SdtWWP_Notification_Wwpnotificationisread, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId", gxTv_SdtWWP_Notification_Wwpuserextendedid, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_Notification_Wwpuserextendedid_N, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedFullName", gxTv_SdtWWP_Notification_Wwpuserextendedfullname, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationMetadata", gxTv_SdtWWP_Notification_Wwpnotificationmetadata, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationMetadata_N", gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_Notification_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_Notification_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_Z", gxTv_SdtWWP_Notification_Wwpnotificationid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionId_Z", gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionName_Z", gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z ;
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
         AddObjectProperty("WWPNotificationCreated_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationIcon_Z", gxTv_SdtWWP_Notification_Wwpnotificationicon_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationTitle_Z", gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationShortDescription_Z", gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationLink_Z", gxTv_SdtWWP_Notification_Wwpnotificationlink_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationIsRead_Z", gxTv_SdtWWP_Notification_Wwpnotificationisread_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_Z", gxTv_SdtWWP_Notification_Wwpuserextendedid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedFullName_Z", gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_Notification_Wwpnotificationid_N, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_Notification_Wwpuserextendedid_N, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationMetadata_N", gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification sdt )
   {
      if ( sdt.IsDirty("WWPNotificationId") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationid = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationid() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionId") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionName") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname() ;
      }
      if ( sdt.IsDirty("WWPNotificationCreated") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationcreated = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationcreated() ;
      }
      if ( sdt.IsDirty("WWPNotificationIcon") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationicon = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationicon() ;
      }
      if ( sdt.IsDirty("WWPNotificationTitle") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationtitle = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationtitle() ;
      }
      if ( sdt.IsDirty("WWPNotificationShortDescription") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationshortdescription = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription() ;
      }
      if ( sdt.IsDirty("WWPNotificationLink") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationlink = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationlink() ;
      }
      if ( sdt.IsDirty("WWPNotificationIsRead") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationisread = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationisread() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedId") )
      {
         gxTv_SdtWWP_Notification_Wwpuserextendedid_N = sdt.getgxTv_SdtWWP_Notification_Wwpuserextendedid_N() ;
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpuserextendedid = sdt.getgxTv_SdtWWP_Notification_Wwpuserextendedid() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedFullName") )
      {
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpuserextendedfullname = sdt.getgxTv_SdtWWP_Notification_Wwpuserextendedfullname() ;
      }
      if ( sdt.IsDirty("WWPNotificationMetadata") )
      {
         gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N() ;
         gxTv_SdtWWP_Notification_N = (byte)(0) ;
         gxTv_SdtWWP_Notification_Wwpnotificationmetadata = sdt.getgxTv_SdtWWP_Notification_Wwpnotificationmetadata() ;
      }
   }

   public long getgxTv_SdtWWP_Notification_Wwpnotificationid( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationid ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationid( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      if ( gxTv_SdtWWP_Notification_Wwpnotificationid != value )
      {
         gxTv_SdtWWP_Notification_Mode = "INS" ;
         this.setgxTv_SdtWWP_Notification_Wwpnotificationid_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationicon_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationlink_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpnotificationisread_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpuserextendedid_Z_SetNull( );
         this.setgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z_SetNull( );
      }
      SetDirty("Wwpnotificationid");
      gxTv_SdtWWP_Notification_Wwpnotificationid = value ;
   }

   public long getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionid");
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionname");
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname = value ;
   }

   public java.util.Date getgxTv_SdtWWP_Notification_Wwpnotificationcreated( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationcreated ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated");
      gxTv_SdtWWP_Notification_Wwpnotificationcreated = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationicon( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationicon ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationicon( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationicon");
      gxTv_SdtWWP_Notification_Wwpnotificationicon = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationtitle( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationtitle ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationtitle( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationtitle");
      gxTv_SdtWWP_Notification_Wwpnotificationtitle = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationshortdescription ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationshortdescription");
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationlink( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationlink ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationlink( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationlink");
      gxTv_SdtWWP_Notification_Wwpnotificationlink = value ;
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationisread( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationisread ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationisread( boolean value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationisread");
      gxTv_SdtWWP_Notification_Wwpnotificationisread = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpuserextendedid( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedid ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedid( String value )
   {
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid");
      gxTv_SdtWWP_Notification_Wwpuserextendedid = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedid_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = (byte)(1) ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid = "" ;
      SetDirty("Wwpuserextendedid");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpuserextendedid_IsNull( )
   {
      return (gxTv_SdtWWP_Notification_Wwpuserextendedid_N==1) ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpuserextendedfullname( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedfullname ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedfullname( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpuserextendedfullname");
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname = value ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationmetadata( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationmetadata ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationmetadata( String value )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationmetadata");
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationmetadata_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = (byte)(1) ;
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata = "" ;
      SetDirty("Wwpnotificationmetadata");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationmetadata_IsNull( )
   {
      return (gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N==1) ;
   }

   public String getgxTv_SdtWWP_Notification_Mode( )
   {
      return gxTv_SdtWWP_Notification_Mode ;
   }

   public void setgxTv_SdtWWP_Notification_Mode( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_Notification_Mode = value ;
   }

   public void setgxTv_SdtWWP_Notification_Mode_SetNull( )
   {
      gxTv_SdtWWP_Notification_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_Notification_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Notification_Initialized( )
   {
      return gxTv_SdtWWP_Notification_Initialized ;
   }

   public void setgxTv_SdtWWP_Notification_Initialized( short value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_Notification_Initialized = value ;
   }

   public void setgxTv_SdtWWP_Notification_Initialized_SetNull( )
   {
      gxTv_SdtWWP_Notification_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_Notification_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Notification_Wwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationid_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationid_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationid_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationid_Z = 0 ;
      SetDirty("Wwpnotificationid_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationid_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionid_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z = 0 ;
      SetDirty("Wwpnotificationdefinitionid_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionname_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z = "" ;
      SetDirty("Wwpnotificationdefinitionname_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpnotificationcreated_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationicon_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationicon_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationicon_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationicon_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationicon_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationicon_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationicon_Z = "" ;
      SetDirty("Wwpnotificationicon_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationicon_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationtitle_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z = "" ;
      SetDirty("Wwpnotificationtitle_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationshortdescription_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z = "" ;
      SetDirty("Wwpnotificationshortdescription_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpnotificationlink_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationlink_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationlink_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationlink_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationlink_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationlink_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationlink_Z = "" ;
      SetDirty("Wwpnotificationlink_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationlink_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationisread_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationisread_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationisread_Z( boolean value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationisread_Z");
      gxTv_SdtWWP_Notification_Wwpnotificationisread_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationisread_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationisread_Z = false ;
      SetDirty("Wwpnotificationisread_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationisread_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedid_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_Z");
      gxTv_SdtWWP_Notification_Wwpuserextendedid_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedid_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpuserextendedid_Z = "" ;
      SetDirty("Wwpuserextendedid_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpuserextendedid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpuserextendedfullname_Z");
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z = "" ;
      SetDirty("Wwpuserextendedfullname_Z");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Notification_Wwpnotificationid_N( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationid_N ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
      gxTv_SdtWWP_Notification_Wwpnotificationid_N = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationid_N_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationid_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Notification_Wwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedid_N ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpuserextendedid_N_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpuserextendedid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N( byte value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      SetDirty("Wwpnotificationmetadata_N");
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = value ;
   }

   public void setgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N_SetNull( )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = (byte)(0) ;
      SetDirty("Wwpnotificationmetadata_N");
   }

   public boolean getgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_Notification_N = (byte)(1) ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Notification_Wwpnotificationicon = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationtitle = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationlink = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata = "" ;
      gxTv_SdtWWP_Notification_Mode = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Notification_Wwpnotificationicon_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationlink_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetimemil_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_Notification_N ;
   }

   public com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification Clone( )
   {
      com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification sdt;
      com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_Notification struct )
   {
      setgxTv_SdtWWP_Notification_Wwpnotificationid(struct.getWwpnotificationid());
      setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid(struct.getWwpnotificationdefinitionid());
      setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname(struct.getWwpnotificationdefinitionname());
      setgxTv_SdtWWP_Notification_Wwpnotificationcreated(struct.getWwpnotificationcreated());
      setgxTv_SdtWWP_Notification_Wwpnotificationicon(struct.getWwpnotificationicon());
      setgxTv_SdtWWP_Notification_Wwpnotificationtitle(struct.getWwpnotificationtitle());
      setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription(struct.getWwpnotificationshortdescription());
      setgxTv_SdtWWP_Notification_Wwpnotificationlink(struct.getWwpnotificationlink());
      setgxTv_SdtWWP_Notification_Wwpnotificationisread(struct.getWwpnotificationisread());
      setgxTv_SdtWWP_Notification_Wwpuserextendedid(struct.getWwpuserextendedid());
      setgxTv_SdtWWP_Notification_Wwpuserextendedfullname(struct.getWwpuserextendedfullname());
      setgxTv_SdtWWP_Notification_Wwpnotificationmetadata(struct.getWwpnotificationmetadata());
      setgxTv_SdtWWP_Notification_Mode(struct.getMode());
      setgxTv_SdtWWP_Notification_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_Notification_Wwpnotificationid_Z(struct.getWwpnotificationid_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z(struct.getWwpnotificationdefinitionid_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z(struct.getWwpnotificationdefinitionname_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z(struct.getWwpnotificationcreated_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationicon_Z(struct.getWwpnotificationicon_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z(struct.getWwpnotificationtitle_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z(struct.getWwpnotificationshortdescription_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationlink_Z(struct.getWwpnotificationlink_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationisread_Z(struct.getWwpnotificationisread_Z());
      setgxTv_SdtWWP_Notification_Wwpuserextendedid_Z(struct.getWwpuserextendedid_Z());
      setgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z(struct.getWwpuserextendedfullname_Z());
      setgxTv_SdtWWP_Notification_Wwpnotificationid_N(struct.getWwpnotificationid_N());
      setgxTv_SdtWWP_Notification_Wwpuserextendedid_N(struct.getWwpuserextendedid_N());
      setgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N(struct.getWwpnotificationmetadata_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_Notification getStruct( )
   {
      com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_Notification struct = new com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_Notification ();
      struct.setWwpnotificationid(getgxTv_SdtWWP_Notification_Wwpnotificationid());
      struct.setWwpnotificationdefinitionid(getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid());
      struct.setWwpnotificationdefinitionname(getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname());
      struct.setWwpnotificationcreated(getgxTv_SdtWWP_Notification_Wwpnotificationcreated());
      struct.setWwpnotificationicon(getgxTv_SdtWWP_Notification_Wwpnotificationicon());
      struct.setWwpnotificationtitle(getgxTv_SdtWWP_Notification_Wwpnotificationtitle());
      struct.setWwpnotificationshortdescription(getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription());
      struct.setWwpnotificationlink(getgxTv_SdtWWP_Notification_Wwpnotificationlink());
      struct.setWwpnotificationisread(getgxTv_SdtWWP_Notification_Wwpnotificationisread());
      struct.setWwpuserextendedid(getgxTv_SdtWWP_Notification_Wwpuserextendedid());
      struct.setWwpuserextendedfullname(getgxTv_SdtWWP_Notification_Wwpuserextendedfullname());
      struct.setWwpnotificationmetadata(getgxTv_SdtWWP_Notification_Wwpnotificationmetadata());
      struct.setMode(getgxTv_SdtWWP_Notification_Mode());
      struct.setInitialized(getgxTv_SdtWWP_Notification_Initialized());
      struct.setWwpnotificationid_Z(getgxTv_SdtWWP_Notification_Wwpnotificationid_Z());
      struct.setWwpnotificationdefinitionid_Z(getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z());
      struct.setWwpnotificationdefinitionname_Z(getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z());
      struct.setWwpnotificationcreated_Z(getgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z());
      struct.setWwpnotificationicon_Z(getgxTv_SdtWWP_Notification_Wwpnotificationicon_Z());
      struct.setWwpnotificationtitle_Z(getgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z());
      struct.setWwpnotificationshortdescription_Z(getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z());
      struct.setWwpnotificationlink_Z(getgxTv_SdtWWP_Notification_Wwpnotificationlink_Z());
      struct.setWwpnotificationisread_Z(getgxTv_SdtWWP_Notification_Wwpnotificationisread_Z());
      struct.setWwpuserextendedid_Z(getgxTv_SdtWWP_Notification_Wwpuserextendedid_Z());
      struct.setWwpuserextendedfullname_Z(getgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z());
      struct.setWwpnotificationid_N(getgxTv_SdtWWP_Notification_Wwpnotificationid_N());
      struct.setWwpuserextendedid_N(getgxTv_SdtWWP_Notification_Wwpuserextendedid_N());
      struct.setWwpnotificationmetadata_N(getgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_Notification_N ;
   private byte gxTv_SdtWWP_Notification_Wwpnotificationid_N ;
   private byte gxTv_SdtWWP_Notification_Wwpuserextendedid_N ;
   private byte gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N ;
   private short gxTv_SdtWWP_Notification_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_Notification_Wwpnotificationid ;
   private long gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid ;
   private long gxTv_SdtWWP_Notification_Wwpnotificationid_Z ;
   private long gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z ;
   private String gxTv_SdtWWP_Notification_Wwpuserextendedid ;
   private String gxTv_SdtWWP_Notification_Mode ;
   private String gxTv_SdtWWP_Notification_Wwpuserextendedid_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtWWP_Notification_Wwpnotificationcreated ;
   private java.util.Date gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z ;
   private java.util.Date datetimemil_STZ ;
   private boolean gxTv_SdtWWP_Notification_Wwpnotificationisread ;
   private boolean gxTv_SdtWWP_Notification_Wwpnotificationisread_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationmetadata ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationicon ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationtitle ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationshortdescription ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationlink ;
   private String gxTv_SdtWWP_Notification_Wwpuserextendedfullname ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationicon_Z ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z ;
   private String gxTv_SdtWWP_Notification_Wwpnotificationlink_Z ;
   private String gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z ;
}

