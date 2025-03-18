package com.mujermorena.wwpbaseobjects.sms ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_SMS extends GxSilentTrnSdt
{
   public SdtWWP_SMS( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_SMS.class));
   }

   public SdtWWP_SMS( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_SMS");
      initialize( remoteHandle) ;
   }

   public SdtWWP_SMS( int remoteHandle ,
                      StructSdtWWP_SMS struct )
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

   public void Load( long AV36WWPSMSId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV36WWPSMSId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPSMSId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\SMS\\WWP_SMS");
      metadata.set("BT", "WWP_SMS");
      metadata.set("PK", "[ \"WWPSMSId\" ]");
      metadata.set("PKAssigned", "[ \"WWPSMSId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"WWPNotificationId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSId") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSMessage") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsmessage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSSenderNumber") )
            {
               gxTv_SdtWWP_SMS_Wwpsmssendernumber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSRecipientNumbers") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSStatus") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsstatus = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSCreated") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SMS_Wwpsmscreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpsmscreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSScheduled") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SMS_Wwpsmsscheduled = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpsmsscheduled = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSProcessed") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SMS_Wwpsmsprocessed = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpsmsprocessed = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSDetail") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsdetail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId") )
            {
               gxTv_SdtWWP_SMS_Wwpnotificationid = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtWWP_SMS_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpnotificationcreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_SMS_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_SMS_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSId_Z") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSStatus_Z") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsstatus_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSCreated_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SMS_Wwpsmscreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpsmscreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSScheduled_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSProcessed_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_Z") )
            {
               gxTv_SdtWWP_SMS_Wwpnotificationid_Z = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSProcessed_N") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSMSDetail_N") )
            {
               gxTv_SdtWWP_SMS_Wwpsmsdetail_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_N") )
            {
               gxTv_SdtWWP_SMS_Wwpnotificationid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_SMS" ;
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
      oWriter.writeElement("WWPSMSId", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpsmsid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSMSMessage", gxTv_SdtWWP_SMS_Wwpsmsmessage);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSMSSenderNumber", gxTv_SdtWWP_SMS_Wwpsmssendernumber);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSMSRecipientNumbers", gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSMSStatus", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpsmsstatus, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpsmscreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPSMSCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpsmsscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPSMSScheduled", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpsmsprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPSMSProcessed", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSMSDetail", gxTv_SdtWWP_SMS_Wwpsmsdetail);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationId", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpnotificationid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPNotificationCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_SMS_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSMSId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpsmsid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSMSStatus_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpsmsstatus_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpsmscreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPSMSCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPSMSScheduled_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPSMSProcessed_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpnotificationid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPNotificationCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSMSProcessed_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpsmsprocessed_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSMSDetail_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpsmsdetail_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_SMS_Wwpnotificationid_N, 1, 0)));
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
      AddObjectProperty("WWPSMSId", gxTv_SdtWWP_SMS_Wwpsmsid, false, includeNonInitialized);
      AddObjectProperty("WWPSMSMessage", gxTv_SdtWWP_SMS_Wwpsmsmessage, false, includeNonInitialized);
      AddObjectProperty("WWPSMSSenderNumber", gxTv_SdtWWP_SMS_Wwpsmssendernumber, false, includeNonInitialized);
      AddObjectProperty("WWPSMSRecipientNumbers", gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers, false, includeNonInitialized);
      AddObjectProperty("WWPSMSStatus", gxTv_SdtWWP_SMS_Wwpsmsstatus, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpsmscreated ;
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
      AddObjectProperty("WWPSMSCreated", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpsmsscheduled ;
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
      AddObjectProperty("WWPSMSScheduled", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpsmsprocessed ;
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
      AddObjectProperty("WWPSMSProcessed", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("WWPSMSProcessed_N", gxTv_SdtWWP_SMS_Wwpsmsprocessed_N, false, includeNonInitialized);
      AddObjectProperty("WWPSMSDetail", gxTv_SdtWWP_SMS_Wwpsmsdetail, false, includeNonInitialized);
      AddObjectProperty("WWPSMSDetail_N", gxTv_SdtWWP_SMS_Wwpsmsdetail_N, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId", gxTv_SdtWWP_SMS_Wwpnotificationid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_SMS_Wwpnotificationid_N, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpnotificationcreated ;
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
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_SMS_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_SMS_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPSMSId_Z", gxTv_SdtWWP_SMS_Wwpsmsid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPSMSStatus_Z", gxTv_SdtWWP_SMS_Wwpsmsstatus_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpsmscreated_Z ;
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
         AddObjectProperty("WWPSMSCreated_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z ;
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
         AddObjectProperty("WWPSMSScheduled_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z ;
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
         AddObjectProperty("WWPSMSProcessed_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_Z", gxTv_SdtWWP_SMS_Wwpnotificationid_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z ;
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
         AddObjectProperty("WWPSMSProcessed_N", gxTv_SdtWWP_SMS_Wwpsmsprocessed_N, false, includeNonInitialized);
         AddObjectProperty("WWPSMSDetail_N", gxTv_SdtWWP_SMS_Wwpsmsdetail_N, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_SMS_Wwpnotificationid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS sdt )
   {
      if ( sdt.IsDirty("WWPSMSId") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsid = sdt.getgxTv_SdtWWP_SMS_Wwpsmsid() ;
      }
      if ( sdt.IsDirty("WWPSMSMessage") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsmessage = sdt.getgxTv_SdtWWP_SMS_Wwpsmsmessage() ;
      }
      if ( sdt.IsDirty("WWPSMSSenderNumber") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmssendernumber = sdt.getgxTv_SdtWWP_SMS_Wwpsmssendernumber() ;
      }
      if ( sdt.IsDirty("WWPSMSRecipientNumbers") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers = sdt.getgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers() ;
      }
      if ( sdt.IsDirty("WWPSMSStatus") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsstatus = sdt.getgxTv_SdtWWP_SMS_Wwpsmsstatus() ;
      }
      if ( sdt.IsDirty("WWPSMSCreated") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmscreated = sdt.getgxTv_SdtWWP_SMS_Wwpsmscreated() ;
      }
      if ( sdt.IsDirty("WWPSMSScheduled") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsscheduled = sdt.getgxTv_SdtWWP_SMS_Wwpsmsscheduled() ;
      }
      if ( sdt.IsDirty("WWPSMSProcessed") )
      {
         gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = sdt.getgxTv_SdtWWP_SMS_Wwpsmsprocessed_N() ;
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsprocessed = sdt.getgxTv_SdtWWP_SMS_Wwpsmsprocessed() ;
      }
      if ( sdt.IsDirty("WWPSMSDetail") )
      {
         gxTv_SdtWWP_SMS_Wwpsmsdetail_N = sdt.getgxTv_SdtWWP_SMS_Wwpsmsdetail_N() ;
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpsmsdetail = sdt.getgxTv_SdtWWP_SMS_Wwpsmsdetail() ;
      }
      if ( sdt.IsDirty("WWPNotificationId") )
      {
         gxTv_SdtWWP_SMS_Wwpnotificationid_N = sdt.getgxTv_SdtWWP_SMS_Wwpnotificationid_N() ;
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpnotificationid = sdt.getgxTv_SdtWWP_SMS_Wwpnotificationid() ;
      }
      if ( sdt.IsDirty("WWPNotificationCreated") )
      {
         gxTv_SdtWWP_SMS_N = (byte)(0) ;
         gxTv_SdtWWP_SMS_Wwpnotificationcreated = sdt.getgxTv_SdtWWP_SMS_Wwpnotificationcreated() ;
      }
   }

   public long getgxTv_SdtWWP_SMS_Wwpsmsid( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsid ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsid( long value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      if ( gxTv_SdtWWP_SMS_Wwpsmsid != value )
      {
         gxTv_SdtWWP_SMS_Mode = "INS" ;
         this.setgxTv_SdtWWP_SMS_Wwpsmsid_Z_SetNull( );
         this.setgxTv_SdtWWP_SMS_Wwpsmsstatus_Z_SetNull( );
         this.setgxTv_SdtWWP_SMS_Wwpsmscreated_Z_SetNull( );
         this.setgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z_SetNull( );
         this.setgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z_SetNull( );
         this.setgxTv_SdtWWP_SMS_Wwpnotificationid_Z_SetNull( );
         this.setgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z_SetNull( );
      }
      SetDirty("Wwpsmsid");
      gxTv_SdtWWP_SMS_Wwpsmsid = value ;
   }

   public String getgxTv_SdtWWP_SMS_Wwpsmsmessage( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsmessage ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsmessage( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsmessage");
      gxTv_SdtWWP_SMS_Wwpsmsmessage = value ;
   }

   public String getgxTv_SdtWWP_SMS_Wwpsmssendernumber( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmssendernumber ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmssendernumber( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmssendernumber");
      gxTv_SdtWWP_SMS_Wwpsmssendernumber = value ;
   }

   public String getgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsrecipientnumbers");
      gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers = value ;
   }

   public short getgxTv_SdtWWP_SMS_Wwpsmsstatus( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsstatus ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsstatus( short value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsstatus");
      gxTv_SdtWWP_SMS_Wwpsmsstatus = value ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpsmscreated( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmscreated ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmscreated( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmscreated");
      gxTv_SdtWWP_SMS_Wwpsmscreated = value ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpsmsscheduled( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsscheduled ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsscheduled( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsscheduled");
      gxTv_SdtWWP_SMS_Wwpsmsscheduled = value ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpsmsprocessed( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsprocessed ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsprocessed( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsprocessed");
      gxTv_SdtWWP_SMS_Wwpsmsprocessed = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsprocessed_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = (byte)(1) ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpsmsprocessed");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsprocessed_IsNull( )
   {
      return (gxTv_SdtWWP_SMS_Wwpsmsprocessed_N==1) ;
   }

   public String getgxTv_SdtWWP_SMS_Wwpsmsdetail( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsdetail ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsdetail( String value )
   {
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsdetail");
      gxTv_SdtWWP_SMS_Wwpsmsdetail = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsdetail_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = (byte)(1) ;
      gxTv_SdtWWP_SMS_Wwpsmsdetail = "" ;
      SetDirty("Wwpsmsdetail");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsdetail_IsNull( )
   {
      return (gxTv_SdtWWP_SMS_Wwpsmsdetail_N==1) ;
   }

   public long getgxTv_SdtWWP_SMS_Wwpnotificationid( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationid ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationid( long value )
   {
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpnotificationid");
      gxTv_SdtWWP_SMS_Wwpnotificationid = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationid_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = (byte)(1) ;
      gxTv_SdtWWP_SMS_Wwpnotificationid = 0 ;
      SetDirty("Wwpnotificationid");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpnotificationid_IsNull( )
   {
      return (gxTv_SdtWWP_SMS_Wwpnotificationid_N==1) ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpnotificationcreated( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationcreated ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated");
      gxTv_SdtWWP_SMS_Wwpnotificationcreated = value ;
   }

   public String getgxTv_SdtWWP_SMS_Mode( )
   {
      return gxTv_SdtWWP_SMS_Mode ;
   }

   public void setgxTv_SdtWWP_SMS_Mode( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_SMS_Mode = value ;
   }

   public void setgxTv_SdtWWP_SMS_Mode_SetNull( )
   {
      gxTv_SdtWWP_SMS_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_SMS_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_SMS_Initialized( )
   {
      return gxTv_SdtWWP_SMS_Initialized ;
   }

   public void setgxTv_SdtWWP_SMS_Initialized( short value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_SMS_Initialized = value ;
   }

   public void setgxTv_SdtWWP_SMS_Initialized_SetNull( )
   {
      gxTv_SdtWWP_SMS_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_SMS_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_SMS_Wwpsmsid_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsid_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsid_Z( long value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsid_Z");
      gxTv_SdtWWP_SMS_Wwpsmsid_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsid_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsid_Z = 0 ;
      SetDirty("Wwpsmsid_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_SMS_Wwpsmsstatus_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsstatus_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsstatus_Z( short value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsstatus_Z");
      gxTv_SdtWWP_SMS_Wwpsmsstatus_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsstatus_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsstatus_Z = (short)(0) ;
      SetDirty("Wwpsmsstatus_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsstatus_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpsmscreated_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmscreated_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmscreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmscreated_Z");
      gxTv_SdtWWP_SMS_Wwpsmscreated_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmscreated_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmscreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpsmscreated_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmscreated_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsscheduled_Z");
      gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpsmsscheduled_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsprocessed_Z");
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpsmsprocessed_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_SMS_Wwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationid_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_Z");
      gxTv_SdtWWP_SMS_Wwpnotificationid_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationid_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpnotificationid_Z = 0 ;
      SetDirty("Wwpnotificationid_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpnotificationid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated_Z");
      gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpnotificationcreated_Z");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_SMS_Wwpsmsprocessed_N( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsprocessed_N ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsprocessed_N( byte value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsprocessed_N");
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsprocessed_N_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = (byte)(0) ;
      SetDirty("Wwpsmsprocessed_N");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsprocessed_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_SMS_Wwpsmsdetail_N( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsdetail_N ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsdetail_N( byte value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpsmsdetail_N");
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpsmsdetail_N_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = (byte)(0) ;
      SetDirty("Wwpsmsdetail_N");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpsmsdetail_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_SMS_Wwpnotificationid_N( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationid_N ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = value ;
   }

   public void setgxTv_SdtWWP_SMS_Wwpnotificationid_N_SetNull( )
   {
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
   }

   public boolean getgxTv_SdtWWP_SMS_Wwpnotificationid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.sms.wwp_sms_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.sms.wwp_sms_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_SMS_N = (byte)(1) ;
      gxTv_SdtWWP_SMS_Wwpsmsmessage = "" ;
      gxTv_SdtWWP_SMS_Wwpsmssendernumber = "" ;
      gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers = "" ;
      gxTv_SdtWWP_SMS_Wwpsmscreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Wwpsmsscheduled = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Wwpsmsprocessed = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Wwpsmsdetail = "" ;
      gxTv_SdtWWP_SMS_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Mode = "" ;
      gxTv_SdtWWP_SMS_Wwpsmscreated_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetimemil_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_SMS_N ;
   }

   public com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS Clone( )
   {
      com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS sdt;
      com.mujermorena.wwpbaseobjects.sms.wwp_sms_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.sms.wwp_sms_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.sms.StructSdtWWP_SMS struct )
   {
      setgxTv_SdtWWP_SMS_Wwpsmsid(struct.getWwpsmsid());
      setgxTv_SdtWWP_SMS_Wwpsmsmessage(struct.getWwpsmsmessage());
      setgxTv_SdtWWP_SMS_Wwpsmssendernumber(struct.getWwpsmssendernumber());
      setgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers(struct.getWwpsmsrecipientnumbers());
      setgxTv_SdtWWP_SMS_Wwpsmsstatus(struct.getWwpsmsstatus());
      setgxTv_SdtWWP_SMS_Wwpsmscreated(struct.getWwpsmscreated());
      setgxTv_SdtWWP_SMS_Wwpsmsscheduled(struct.getWwpsmsscheduled());
      setgxTv_SdtWWP_SMS_Wwpsmsprocessed(struct.getWwpsmsprocessed());
      setgxTv_SdtWWP_SMS_Wwpsmsdetail(struct.getWwpsmsdetail());
      setgxTv_SdtWWP_SMS_Wwpnotificationid(struct.getWwpnotificationid());
      setgxTv_SdtWWP_SMS_Wwpnotificationcreated(struct.getWwpnotificationcreated());
      setgxTv_SdtWWP_SMS_Mode(struct.getMode());
      setgxTv_SdtWWP_SMS_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_SMS_Wwpsmsid_Z(struct.getWwpsmsid_Z());
      setgxTv_SdtWWP_SMS_Wwpsmsstatus_Z(struct.getWwpsmsstatus_Z());
      setgxTv_SdtWWP_SMS_Wwpsmscreated_Z(struct.getWwpsmscreated_Z());
      setgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z(struct.getWwpsmsscheduled_Z());
      setgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z(struct.getWwpsmsprocessed_Z());
      setgxTv_SdtWWP_SMS_Wwpnotificationid_Z(struct.getWwpnotificationid_Z());
      setgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z(struct.getWwpnotificationcreated_Z());
      setgxTv_SdtWWP_SMS_Wwpsmsprocessed_N(struct.getWwpsmsprocessed_N());
      setgxTv_SdtWWP_SMS_Wwpsmsdetail_N(struct.getWwpsmsdetail_N());
      setgxTv_SdtWWP_SMS_Wwpnotificationid_N(struct.getWwpnotificationid_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.sms.StructSdtWWP_SMS getStruct( )
   {
      com.mujermorena.wwpbaseobjects.sms.StructSdtWWP_SMS struct = new com.mujermorena.wwpbaseobjects.sms.StructSdtWWP_SMS ();
      struct.setWwpsmsid(getgxTv_SdtWWP_SMS_Wwpsmsid());
      struct.setWwpsmsmessage(getgxTv_SdtWWP_SMS_Wwpsmsmessage());
      struct.setWwpsmssendernumber(getgxTv_SdtWWP_SMS_Wwpsmssendernumber());
      struct.setWwpsmsrecipientnumbers(getgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers());
      struct.setWwpsmsstatus(getgxTv_SdtWWP_SMS_Wwpsmsstatus());
      struct.setWwpsmscreated(getgxTv_SdtWWP_SMS_Wwpsmscreated());
      struct.setWwpsmsscheduled(getgxTv_SdtWWP_SMS_Wwpsmsscheduled());
      struct.setWwpsmsprocessed(getgxTv_SdtWWP_SMS_Wwpsmsprocessed());
      struct.setWwpsmsdetail(getgxTv_SdtWWP_SMS_Wwpsmsdetail());
      struct.setWwpnotificationid(getgxTv_SdtWWP_SMS_Wwpnotificationid());
      struct.setWwpnotificationcreated(getgxTv_SdtWWP_SMS_Wwpnotificationcreated());
      struct.setMode(getgxTv_SdtWWP_SMS_Mode());
      struct.setInitialized(getgxTv_SdtWWP_SMS_Initialized());
      struct.setWwpsmsid_Z(getgxTv_SdtWWP_SMS_Wwpsmsid_Z());
      struct.setWwpsmsstatus_Z(getgxTv_SdtWWP_SMS_Wwpsmsstatus_Z());
      struct.setWwpsmscreated_Z(getgxTv_SdtWWP_SMS_Wwpsmscreated_Z());
      struct.setWwpsmsscheduled_Z(getgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z());
      struct.setWwpsmsprocessed_Z(getgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z());
      struct.setWwpnotificationid_Z(getgxTv_SdtWWP_SMS_Wwpnotificationid_Z());
      struct.setWwpnotificationcreated_Z(getgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z());
      struct.setWwpsmsprocessed_N(getgxTv_SdtWWP_SMS_Wwpsmsprocessed_N());
      struct.setWwpsmsdetail_N(getgxTv_SdtWWP_SMS_Wwpsmsdetail_N());
      struct.setWwpnotificationid_N(getgxTv_SdtWWP_SMS_Wwpnotificationid_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_SMS_N ;
   private byte gxTv_SdtWWP_SMS_Wwpsmsprocessed_N ;
   private byte gxTv_SdtWWP_SMS_Wwpsmsdetail_N ;
   private byte gxTv_SdtWWP_SMS_Wwpnotificationid_N ;
   private short gxTv_SdtWWP_SMS_Wwpsmsstatus ;
   private short gxTv_SdtWWP_SMS_Initialized ;
   private short gxTv_SdtWWP_SMS_Wwpsmsstatus_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_SMS_Wwpsmsid ;
   private long gxTv_SdtWWP_SMS_Wwpnotificationid ;
   private long gxTv_SdtWWP_SMS_Wwpsmsid_Z ;
   private long gxTv_SdtWWP_SMS_Wwpnotificationid_Z ;
   private String gxTv_SdtWWP_SMS_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpsmscreated ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpsmsscheduled ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpsmsprocessed ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpnotificationcreated ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpsmscreated_Z ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z ;
   private java.util.Date gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z ;
   private java.util.Date datetimemil_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_SMS_Wwpsmsmessage ;
   private String gxTv_SdtWWP_SMS_Wwpsmssendernumber ;
   private String gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers ;
   private String gxTv_SdtWWP_SMS_Wwpsmsdetail ;
}

