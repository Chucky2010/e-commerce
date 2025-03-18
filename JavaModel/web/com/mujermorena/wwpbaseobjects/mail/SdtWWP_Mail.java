package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_Mail extends GxSilentTrnSdt
{
   public SdtWWP_Mail( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_Mail.class));
   }

   public SdtWWP_Mail( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_Mail");
      initialize( remoteHandle) ;
   }

   public SdtWWP_Mail( int remoteHandle ,
                       StructSdtWWP_Mail struct )
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

   public void Load( long AV42WWPMailId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV42WWPMailId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPMailId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Mail\\WWP_Mail");
      metadata.set("BT", "WWP_Mail");
      metadata.set("PK", "[ \"WWPMailId\" ]");
      metadata.set("PKAssigned", "[ \"WWPMailId\" ]");
      metadata.set("Levels", "[ \"Attachments\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailId") )
            {
               gxTv_SdtWWP_Mail_Wwpmailid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailSubject") )
            {
               gxTv_SdtWWP_Mail_Wwpmailsubject = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailBody") )
            {
               gxTv_SdtWWP_Mail_Wwpmailbody = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTo") )
            {
               gxTv_SdtWWP_Mail_Wwpmailto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailCC") )
            {
               gxTv_SdtWWP_Mail_Wwpmailcc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailBCC") )
            {
               gxTv_SdtWWP_Mail_Wwpmailbcc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailSenderAddress") )
            {
               gxTv_SdtWWP_Mail_Wwpmailsenderaddress = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailSenderName") )
            {
               gxTv_SdtWWP_Mail_Wwpmailsendername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailStatus") )
            {
               gxTv_SdtWWP_Mail_Wwpmailstatus = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailCreated") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Mail_Wwpmailcreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpmailcreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailScheduled") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Mail_Wwpmailscheduled = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpmailscheduled = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailProcessed") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Mail_Wwpmailprocessed = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpmailprocessed = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailDetail") )
            {
               gxTv_SdtWWP_Mail_Wwpmaildetail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId") )
            {
               gxTv_SdtWWP_Mail_Wwpnotificationid = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtWWP_Mail_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpnotificationcreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Attachments") )
            {
               if ( gxTv_SdtWWP_Mail_Attachments == null )
               {
                  gxTv_SdtWWP_Mail_Attachments = new GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments>(com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments.class, "WWP_Mail.Attachments", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtWWP_Mail_Attachments.readxml(oReader, "Attachments") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Attachments") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_Mail_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_Mail_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailId_Z") )
            {
               gxTv_SdtWWP_Mail_Wwpmailid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailSubject_Z") )
            {
               gxTv_SdtWWP_Mail_Wwpmailsubject_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailStatus_Z") )
            {
               gxTv_SdtWWP_Mail_Wwpmailstatus_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailCreated_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Mail_Wwpmailcreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpmailcreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailScheduled_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailProcessed_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
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
               gxTv_SdtWWP_Mail_Wwpnotificationid_Z = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTo_N") )
            {
               gxTv_SdtWWP_Mail_Wwpmailto_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailCC_N") )
            {
               gxTv_SdtWWP_Mail_Wwpmailcc_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailBCC_N") )
            {
               gxTv_SdtWWP_Mail_Wwpmailbcc_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailProcessed_N") )
            {
               gxTv_SdtWWP_Mail_Wwpmailprocessed_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailDetail_N") )
            {
               gxTv_SdtWWP_Mail_Wwpmaildetail_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_N") )
            {
               gxTv_SdtWWP_Mail_Wwpnotificationid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_Mail" ;
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
      oWriter.writeElement("WWPMailId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailSubject", gxTv_SdtWWP_Mail_Wwpmailsubject);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailBody", gxTv_SdtWWP_Mail_Wwpmailbody);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailTo", gxTv_SdtWWP_Mail_Wwpmailto);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailCC", gxTv_SdtWWP_Mail_Wwpmailcc);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailBCC", gxTv_SdtWWP_Mail_Wwpmailbcc);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailSenderAddress", gxTv_SdtWWP_Mail_Wwpmailsenderaddress);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailSenderName", gxTv_SdtWWP_Mail_Wwpmailsendername);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailStatus", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailstatus, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpmailcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPMailCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpmailscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPMailScheduled", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpmailprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPMailProcessed", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailDetail", gxTv_SdtWWP_Mail_Wwpmaildetail);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpnotificationid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPNotificationCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( gxTv_SdtWWP_Mail_Attachments != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtWWP_Mail_Attachments.writexml(oWriter, "Attachments", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_Mail_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailSubject_Z", gxTv_SdtWWP_Mail_Wwpmailsubject_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailStatus_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailstatus_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpmailcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPMailCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpmailscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPMailScheduled_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpmailprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPMailProcessed_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpnotificationid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPNotificationCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailTo_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailto_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailCC_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailcc_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailBCC_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailbcc_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailProcessed_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmailprocessed_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailDetail_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpmaildetail_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Wwpnotificationid_N, 1, 0)));
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
      AddObjectProperty("WWPMailId", gxTv_SdtWWP_Mail_Wwpmailid, false, includeNonInitialized);
      AddObjectProperty("WWPMailSubject", gxTv_SdtWWP_Mail_Wwpmailsubject, false, includeNonInitialized);
      AddObjectProperty("WWPMailBody", gxTv_SdtWWP_Mail_Wwpmailbody, false, includeNonInitialized);
      AddObjectProperty("WWPMailTo", gxTv_SdtWWP_Mail_Wwpmailto, false, includeNonInitialized);
      AddObjectProperty("WWPMailTo_N", gxTv_SdtWWP_Mail_Wwpmailto_N, false, includeNonInitialized);
      AddObjectProperty("WWPMailCC", gxTv_SdtWWP_Mail_Wwpmailcc, false, includeNonInitialized);
      AddObjectProperty("WWPMailCC_N", gxTv_SdtWWP_Mail_Wwpmailcc_N, false, includeNonInitialized);
      AddObjectProperty("WWPMailBCC", gxTv_SdtWWP_Mail_Wwpmailbcc, false, includeNonInitialized);
      AddObjectProperty("WWPMailBCC_N", gxTv_SdtWWP_Mail_Wwpmailbcc_N, false, includeNonInitialized);
      AddObjectProperty("WWPMailSenderAddress", gxTv_SdtWWP_Mail_Wwpmailsenderaddress, false, includeNonInitialized);
      AddObjectProperty("WWPMailSenderName", gxTv_SdtWWP_Mail_Wwpmailsendername, false, includeNonInitialized);
      AddObjectProperty("WWPMailStatus", gxTv_SdtWWP_Mail_Wwpmailstatus, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpmailcreated ;
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
      AddObjectProperty("WWPMailCreated", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpmailscheduled ;
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
      AddObjectProperty("WWPMailScheduled", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpmailprocessed ;
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
      AddObjectProperty("WWPMailProcessed", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("WWPMailProcessed_N", gxTv_SdtWWP_Mail_Wwpmailprocessed_N, false, includeNonInitialized);
      AddObjectProperty("WWPMailDetail", gxTv_SdtWWP_Mail_Wwpmaildetail, false, includeNonInitialized);
      AddObjectProperty("WWPMailDetail_N", gxTv_SdtWWP_Mail_Wwpmaildetail_N, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId", gxTv_SdtWWP_Mail_Wwpnotificationid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_Mail_Wwpnotificationid_N, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpnotificationcreated ;
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
      if ( gxTv_SdtWWP_Mail_Attachments != null )
      {
         AddObjectProperty("Attachments", gxTv_SdtWWP_Mail_Attachments, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_Mail_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_Mail_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPMailId_Z", gxTv_SdtWWP_Mail_Wwpmailid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPMailSubject_Z", gxTv_SdtWWP_Mail_Wwpmailsubject_Z, false, includeNonInitialized);
         AddObjectProperty("WWPMailStatus_Z", gxTv_SdtWWP_Mail_Wwpmailstatus_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpmailcreated_Z ;
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
         AddObjectProperty("WWPMailCreated_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpmailscheduled_Z ;
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
         AddObjectProperty("WWPMailScheduled_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpmailprocessed_Z ;
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
         AddObjectProperty("WWPMailProcessed_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_Z", gxTv_SdtWWP_Mail_Wwpnotificationid_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z ;
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
         AddObjectProperty("WWPMailTo_N", gxTv_SdtWWP_Mail_Wwpmailto_N, false, includeNonInitialized);
         AddObjectProperty("WWPMailCC_N", gxTv_SdtWWP_Mail_Wwpmailcc_N, false, includeNonInitialized);
         AddObjectProperty("WWPMailBCC_N", gxTv_SdtWWP_Mail_Wwpmailbcc_N, false, includeNonInitialized);
         AddObjectProperty("WWPMailProcessed_N", gxTv_SdtWWP_Mail_Wwpmailprocessed_N, false, includeNonInitialized);
         AddObjectProperty("WWPMailDetail_N", gxTv_SdtWWP_Mail_Wwpmaildetail_N, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_Mail_Wwpnotificationid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail sdt )
   {
      if ( sdt.IsDirty("WWPMailId") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailid = sdt.getgxTv_SdtWWP_Mail_Wwpmailid() ;
      }
      if ( sdt.IsDirty("WWPMailSubject") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailsubject = sdt.getgxTv_SdtWWP_Mail_Wwpmailsubject() ;
      }
      if ( sdt.IsDirty("WWPMailBody") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailbody = sdt.getgxTv_SdtWWP_Mail_Wwpmailbody() ;
      }
      if ( sdt.IsDirty("WWPMailTo") )
      {
         gxTv_SdtWWP_Mail_Wwpmailto_N = sdt.getgxTv_SdtWWP_Mail_Wwpmailto_N() ;
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailto = sdt.getgxTv_SdtWWP_Mail_Wwpmailto() ;
      }
      if ( sdt.IsDirty("WWPMailCC") )
      {
         gxTv_SdtWWP_Mail_Wwpmailcc_N = sdt.getgxTv_SdtWWP_Mail_Wwpmailcc_N() ;
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailcc = sdt.getgxTv_SdtWWP_Mail_Wwpmailcc() ;
      }
      if ( sdt.IsDirty("WWPMailBCC") )
      {
         gxTv_SdtWWP_Mail_Wwpmailbcc_N = sdt.getgxTv_SdtWWP_Mail_Wwpmailbcc_N() ;
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailbcc = sdt.getgxTv_SdtWWP_Mail_Wwpmailbcc() ;
      }
      if ( sdt.IsDirty("WWPMailSenderAddress") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailsenderaddress = sdt.getgxTv_SdtWWP_Mail_Wwpmailsenderaddress() ;
      }
      if ( sdt.IsDirty("WWPMailSenderName") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailsendername = sdt.getgxTv_SdtWWP_Mail_Wwpmailsendername() ;
      }
      if ( sdt.IsDirty("WWPMailStatus") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailstatus = sdt.getgxTv_SdtWWP_Mail_Wwpmailstatus() ;
      }
      if ( sdt.IsDirty("WWPMailCreated") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailcreated = sdt.getgxTv_SdtWWP_Mail_Wwpmailcreated() ;
      }
      if ( sdt.IsDirty("WWPMailScheduled") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailscheduled = sdt.getgxTv_SdtWWP_Mail_Wwpmailscheduled() ;
      }
      if ( sdt.IsDirty("WWPMailProcessed") )
      {
         gxTv_SdtWWP_Mail_Wwpmailprocessed_N = sdt.getgxTv_SdtWWP_Mail_Wwpmailprocessed_N() ;
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmailprocessed = sdt.getgxTv_SdtWWP_Mail_Wwpmailprocessed() ;
      }
      if ( sdt.IsDirty("WWPMailDetail") )
      {
         gxTv_SdtWWP_Mail_Wwpmaildetail_N = sdt.getgxTv_SdtWWP_Mail_Wwpmaildetail_N() ;
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpmaildetail = sdt.getgxTv_SdtWWP_Mail_Wwpmaildetail() ;
      }
      if ( sdt.IsDirty("WWPNotificationId") )
      {
         gxTv_SdtWWP_Mail_Wwpnotificationid_N = sdt.getgxTv_SdtWWP_Mail_Wwpnotificationid_N() ;
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpnotificationid = sdt.getgxTv_SdtWWP_Mail_Wwpnotificationid() ;
      }
      if ( sdt.IsDirty("WWPNotificationCreated") )
      {
         gxTv_SdtWWP_Mail_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Wwpnotificationcreated = sdt.getgxTv_SdtWWP_Mail_Wwpnotificationcreated() ;
      }
      if ( gxTv_SdtWWP_Mail_Attachments != null )
      {
         GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> newCollectionAttachments = sdt.getgxTv_SdtWWP_Mail_Attachments();
         com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments currItemAttachments;
         com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments newItemAttachments;
         short idx = 1;
         while ( idx <= newCollectionAttachments.size() )
         {
            newItemAttachments = (com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)((com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)newCollectionAttachments.elementAt(-1+idx));
            currItemAttachments = (com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)gxTv_SdtWWP_Mail_Attachments.getByKey(newItemAttachments.getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname());
            if ( GXutil.strcmp(currItemAttachments.getgxTv_SdtWWP_Mail_Attachments_Mode(), "UPD") == 0 )
            {
               currItemAttachments.updateDirties(newItemAttachments);
               if ( GXutil.strcmp(newItemAttachments.getgxTv_SdtWWP_Mail_Attachments_Mode(), "DLT") == 0 )
               {
                  currItemAttachments.setgxTv_SdtWWP_Mail_Attachments_Mode( "DLT" );
               }
               currItemAttachments.setgxTv_SdtWWP_Mail_Attachments_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtWWP_Mail_Attachments.add(newItemAttachments, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public long getgxTv_SdtWWP_Mail_Wwpmailid( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailid ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailid( long value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      if ( gxTv_SdtWWP_Mail_Wwpmailid != value )
      {
         gxTv_SdtWWP_Mail_Mode = "INS" ;
         this.setgxTv_SdtWWP_Mail_Wwpmailid_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpmailsubject_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpmailstatus_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpmailcreated_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpmailscheduled_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpmailprocessed_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpnotificationid_Z_SetNull( );
         this.setgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z_SetNull( );
         if ( gxTv_SdtWWP_Mail_Attachments != null )
         {
            GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> collectionAttachments = gxTv_SdtWWP_Mail_Attachments;
            com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments currItemAttachments;
            short idx = 1;
            while ( idx <= collectionAttachments.size() )
            {
               currItemAttachments = (com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)((com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)collectionAttachments.elementAt(-1+idx));
               currItemAttachments.setgxTv_SdtWWP_Mail_Attachments_Mode( "INS" );
               currItemAttachments.setgxTv_SdtWWP_Mail_Attachments_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Wwpmailid");
      gxTv_SdtWWP_Mail_Wwpmailid = value ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailsubject( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsubject ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailsubject( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailsubject");
      gxTv_SdtWWP_Mail_Wwpmailsubject = value ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailbody( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailbody ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailbody( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailbody");
      gxTv_SdtWWP_Mail_Wwpmailbody = value ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailto( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailto ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailto( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmailto_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailto");
      gxTv_SdtWWP_Mail_Wwpmailto = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailto_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailto_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailto = "" ;
      SetDirty("Wwpmailto");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailto_IsNull( )
   {
      return (gxTv_SdtWWP_Mail_Wwpmailto_N==1) ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailcc( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcc ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcc( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmailcc_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailcc");
      gxTv_SdtWWP_Mail_Wwpmailcc = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcc_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailcc_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailcc = "" ;
      SetDirty("Wwpmailcc");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailcc_IsNull( )
   {
      return (gxTv_SdtWWP_Mail_Wwpmailcc_N==1) ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailbcc( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailbcc ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailbcc( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailbcc");
      gxTv_SdtWWP_Mail_Wwpmailbcc = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailbcc_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailbcc = "" ;
      SetDirty("Wwpmailbcc");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailbcc_IsNull( )
   {
      return (gxTv_SdtWWP_Mail_Wwpmailbcc_N==1) ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailsenderaddress( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsenderaddress ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailsenderaddress( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailsenderaddress");
      gxTv_SdtWWP_Mail_Wwpmailsenderaddress = value ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailsendername( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsendername ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailsendername( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailsendername");
      gxTv_SdtWWP_Mail_Wwpmailsendername = value ;
   }

   public short getgxTv_SdtWWP_Mail_Wwpmailstatus( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailstatus ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailstatus( short value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailstatus");
      gxTv_SdtWWP_Mail_Wwpmailstatus = value ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpmailcreated( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcreated ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcreated( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailcreated");
      gxTv_SdtWWP_Mail_Wwpmailcreated = value ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpmailscheduled( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailscheduled ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailscheduled( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailscheduled");
      gxTv_SdtWWP_Mail_Wwpmailscheduled = value ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpmailprocessed( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailprocessed ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailprocessed( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailprocessed");
      gxTv_SdtWWP_Mail_Wwpmailprocessed = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailprocessed_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpmailprocessed");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailprocessed_IsNull( )
   {
      return (gxTv_SdtWWP_Mail_Wwpmailprocessed_N==1) ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmaildetail( )
   {
      return gxTv_SdtWWP_Mail_Wwpmaildetail ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmaildetail( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmaildetail");
      gxTv_SdtWWP_Mail_Wwpmaildetail = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmaildetail_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmaildetail = "" ;
      SetDirty("Wwpmaildetail");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmaildetail_IsNull( )
   {
      return (gxTv_SdtWWP_Mail_Wwpmaildetail_N==1) ;
   }

   public long getgxTv_SdtWWP_Mail_Wwpnotificationid( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationid ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationid( long value )
   {
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpnotificationid");
      gxTv_SdtWWP_Mail_Wwpnotificationid = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationid_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpnotificationid = 0 ;
      SetDirty("Wwpnotificationid");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpnotificationid_IsNull( )
   {
      return (gxTv_SdtWWP_Mail_Wwpnotificationid_N==1) ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpnotificationcreated( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationcreated ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated");
      gxTv_SdtWWP_Mail_Wwpnotificationcreated = value ;
   }

   public GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> getgxTv_SdtWWP_Mail_Attachments( )
   {
      if ( gxTv_SdtWWP_Mail_Attachments == null )
      {
         gxTv_SdtWWP_Mail_Attachments = new GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments>(com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments.class, "WWP_Mail.Attachments", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      return gxTv_SdtWWP_Mail_Attachments ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments( GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Attachments");
      gxTv_SdtWWP_Mail_Attachments = value ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_SetNull( )
   {
      gxTv_SdtWWP_Mail_Attachments = null ;
      SetDirty("Attachments");
   }

   public boolean getgxTv_SdtWWP_Mail_Attachments_IsNull( )
   {
      if ( gxTv_SdtWWP_Mail_Attachments == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtWWP_Mail_Mode( )
   {
      return gxTv_SdtWWP_Mail_Mode ;
   }

   public void setgxTv_SdtWWP_Mail_Mode( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_Mail_Mode = value ;
   }

   public void setgxTv_SdtWWP_Mail_Mode_SetNull( )
   {
      gxTv_SdtWWP_Mail_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_Mail_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Mail_Initialized( )
   {
      return gxTv_SdtWWP_Mail_Initialized ;
   }

   public void setgxTv_SdtWWP_Mail_Initialized( short value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_Mail_Initialized = value ;
   }

   public void setgxTv_SdtWWP_Mail_Initialized_SetNull( )
   {
      gxTv_SdtWWP_Mail_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_Mail_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Mail_Wwpmailid_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailid_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailid_Z( long value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailid_Z");
      gxTv_SdtWWP_Mail_Wwpmailid_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailid_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailid_Z = 0 ;
      SetDirty("Wwpmailid_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Mail_Wwpmailsubject_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsubject_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailsubject_Z( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailsubject_Z");
      gxTv_SdtWWP_Mail_Wwpmailsubject_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailsubject_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailsubject_Z = "" ;
      SetDirty("Wwpmailsubject_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailsubject_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Mail_Wwpmailstatus_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailstatus_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailstatus_Z( short value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailstatus_Z");
      gxTv_SdtWWP_Mail_Wwpmailstatus_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailstatus_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailstatus_Z = (short)(0) ;
      SetDirty("Wwpmailstatus_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailstatus_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpmailcreated_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcreated_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailcreated_Z");
      gxTv_SdtWWP_Mail_Wwpmailcreated_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcreated_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpmailcreated_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailcreated_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpmailscheduled_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailscheduled_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailscheduled_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailscheduled_Z");
      gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailscheduled_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpmailscheduled_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailscheduled_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpmailprocessed_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailprocessed_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailprocessed_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailprocessed_Z");
      gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailprocessed_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpmailprocessed_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailprocessed_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Mail_Wwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationid_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_Z");
      gxTv_SdtWWP_Mail_Wwpnotificationid_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationid_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpnotificationid_Z = 0 ;
      SetDirty("Wwpnotificationid_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpnotificationid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated_Z");
      gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpnotificationcreated_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Mail_Wwpmailto_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailto_N ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailto_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailto_N");
      gxTv_SdtWWP_Mail_Wwpmailto_N = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailto_N_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailto_N = (byte)(0) ;
      SetDirty("Wwpmailto_N");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailto_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Mail_Wwpmailcc_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcc_N ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcc_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailcc_N");
      gxTv_SdtWWP_Mail_Wwpmailcc_N = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailcc_N_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailcc_N = (byte)(0) ;
      SetDirty("Wwpmailcc_N");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailcc_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Mail_Wwpmailbcc_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailbcc_N ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailbcc_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailbcc_N");
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailbcc_N_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = (byte)(0) ;
      SetDirty("Wwpmailbcc_N");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailbcc_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Mail_Wwpmailprocessed_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailprocessed_N ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailprocessed_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmailprocessed_N");
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmailprocessed_N_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = (byte)(0) ;
      SetDirty("Wwpmailprocessed_N");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmailprocessed_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Mail_Wwpmaildetail_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmaildetail_N ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmaildetail_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpmaildetail_N");
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpmaildetail_N_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = (byte)(0) ;
      SetDirty("Wwpmaildetail_N");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpmaildetail_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Mail_Wwpnotificationid_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationid_N ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = value ;
   }

   public void setgxTv_SdtWWP_Mail_Wwpnotificationid_N_SetNull( )
   {
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
   }

   public boolean getgxTv_SdtWWP_Mail_Wwpnotificationid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.mail.wwp_mail_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.mail.wwp_mail_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_Mail_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailsubject = "" ;
      gxTv_SdtWWP_Mail_Wwpmailbody = "" ;
      gxTv_SdtWWP_Mail_Wwpmailto = "" ;
      gxTv_SdtWWP_Mail_Wwpmailcc = "" ;
      gxTv_SdtWWP_Mail_Wwpmailbcc = "" ;
      gxTv_SdtWWP_Mail_Wwpmailsenderaddress = "" ;
      gxTv_SdtWWP_Mail_Wwpmailsendername = "" ;
      gxTv_SdtWWP_Mail_Wwpmailcreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Wwpmailscheduled = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Wwpmailprocessed = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Wwpmaildetail = "" ;
      gxTv_SdtWWP_Mail_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Mode = "" ;
      gxTv_SdtWWP_Mail_Wwpmailsubject_Z = "" ;
      gxTv_SdtWWP_Mail_Wwpmailcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetimemil_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_Mail_N ;
   }

   public com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail Clone( )
   {
      com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail sdt;
      com.mujermorena.wwpbaseobjects.mail.wwp_mail_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.mail.wwp_mail_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail struct )
   {
      setgxTv_SdtWWP_Mail_Wwpmailid(struct.getWwpmailid());
      setgxTv_SdtWWP_Mail_Wwpmailsubject(struct.getWwpmailsubject());
      setgxTv_SdtWWP_Mail_Wwpmailbody(struct.getWwpmailbody());
      setgxTv_SdtWWP_Mail_Wwpmailto(struct.getWwpmailto());
      setgxTv_SdtWWP_Mail_Wwpmailcc(struct.getWwpmailcc());
      setgxTv_SdtWWP_Mail_Wwpmailbcc(struct.getWwpmailbcc());
      setgxTv_SdtWWP_Mail_Wwpmailsenderaddress(struct.getWwpmailsenderaddress());
      setgxTv_SdtWWP_Mail_Wwpmailsendername(struct.getWwpmailsendername());
      setgxTv_SdtWWP_Mail_Wwpmailstatus(struct.getWwpmailstatus());
      setgxTv_SdtWWP_Mail_Wwpmailcreated(struct.getWwpmailcreated());
      setgxTv_SdtWWP_Mail_Wwpmailscheduled(struct.getWwpmailscheduled());
      setgxTv_SdtWWP_Mail_Wwpmailprocessed(struct.getWwpmailprocessed());
      setgxTv_SdtWWP_Mail_Wwpmaildetail(struct.getWwpmaildetail());
      setgxTv_SdtWWP_Mail_Wwpnotificationid(struct.getWwpnotificationid());
      setgxTv_SdtWWP_Mail_Wwpnotificationcreated(struct.getWwpnotificationcreated());
      GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> gxTv_SdtWWP_Mail_Attachments_aux = new GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments>(com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments.class, "WWP_Mail.Attachments", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments> gxTv_SdtWWP_Mail_Attachments_aux1 = struct.getAttachments();
      if (gxTv_SdtWWP_Mail_Attachments_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtWWP_Mail_Attachments_aux1.size(); i++)
         {
            gxTv_SdtWWP_Mail_Attachments_aux.add(new com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments(remoteHandle, gxTv_SdtWWP_Mail_Attachments_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtWWP_Mail_Attachments(gxTv_SdtWWP_Mail_Attachments_aux);
      setgxTv_SdtWWP_Mail_Mode(struct.getMode());
      setgxTv_SdtWWP_Mail_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_Mail_Wwpmailid_Z(struct.getWwpmailid_Z());
      setgxTv_SdtWWP_Mail_Wwpmailsubject_Z(struct.getWwpmailsubject_Z());
      setgxTv_SdtWWP_Mail_Wwpmailstatus_Z(struct.getWwpmailstatus_Z());
      setgxTv_SdtWWP_Mail_Wwpmailcreated_Z(struct.getWwpmailcreated_Z());
      setgxTv_SdtWWP_Mail_Wwpmailscheduled_Z(struct.getWwpmailscheduled_Z());
      setgxTv_SdtWWP_Mail_Wwpmailprocessed_Z(struct.getWwpmailprocessed_Z());
      setgxTv_SdtWWP_Mail_Wwpnotificationid_Z(struct.getWwpnotificationid_Z());
      setgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z(struct.getWwpnotificationcreated_Z());
      setgxTv_SdtWWP_Mail_Wwpmailto_N(struct.getWwpmailto_N());
      setgxTv_SdtWWP_Mail_Wwpmailcc_N(struct.getWwpmailcc_N());
      setgxTv_SdtWWP_Mail_Wwpmailbcc_N(struct.getWwpmailbcc_N());
      setgxTv_SdtWWP_Mail_Wwpmailprocessed_N(struct.getWwpmailprocessed_N());
      setgxTv_SdtWWP_Mail_Wwpmaildetail_N(struct.getWwpmaildetail_N());
      setgxTv_SdtWWP_Mail_Wwpnotificationid_N(struct.getWwpnotificationid_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail getStruct( )
   {
      com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail struct = new com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail ();
      struct.setWwpmailid(getgxTv_SdtWWP_Mail_Wwpmailid());
      struct.setWwpmailsubject(getgxTv_SdtWWP_Mail_Wwpmailsubject());
      struct.setWwpmailbody(getgxTv_SdtWWP_Mail_Wwpmailbody());
      struct.setWwpmailto(getgxTv_SdtWWP_Mail_Wwpmailto());
      struct.setWwpmailcc(getgxTv_SdtWWP_Mail_Wwpmailcc());
      struct.setWwpmailbcc(getgxTv_SdtWWP_Mail_Wwpmailbcc());
      struct.setWwpmailsenderaddress(getgxTv_SdtWWP_Mail_Wwpmailsenderaddress());
      struct.setWwpmailsendername(getgxTv_SdtWWP_Mail_Wwpmailsendername());
      struct.setWwpmailstatus(getgxTv_SdtWWP_Mail_Wwpmailstatus());
      struct.setWwpmailcreated(getgxTv_SdtWWP_Mail_Wwpmailcreated());
      struct.setWwpmailscheduled(getgxTv_SdtWWP_Mail_Wwpmailscheduled());
      struct.setWwpmailprocessed(getgxTv_SdtWWP_Mail_Wwpmailprocessed());
      struct.setWwpmaildetail(getgxTv_SdtWWP_Mail_Wwpmaildetail());
      struct.setWwpnotificationid(getgxTv_SdtWWP_Mail_Wwpnotificationid());
      struct.setWwpnotificationcreated(getgxTv_SdtWWP_Mail_Wwpnotificationcreated());
      struct.setAttachments(getgxTv_SdtWWP_Mail_Attachments().getStruct());
      struct.setMode(getgxTv_SdtWWP_Mail_Mode());
      struct.setInitialized(getgxTv_SdtWWP_Mail_Initialized());
      struct.setWwpmailid_Z(getgxTv_SdtWWP_Mail_Wwpmailid_Z());
      struct.setWwpmailsubject_Z(getgxTv_SdtWWP_Mail_Wwpmailsubject_Z());
      struct.setWwpmailstatus_Z(getgxTv_SdtWWP_Mail_Wwpmailstatus_Z());
      struct.setWwpmailcreated_Z(getgxTv_SdtWWP_Mail_Wwpmailcreated_Z());
      struct.setWwpmailscheduled_Z(getgxTv_SdtWWP_Mail_Wwpmailscheduled_Z());
      struct.setWwpmailprocessed_Z(getgxTv_SdtWWP_Mail_Wwpmailprocessed_Z());
      struct.setWwpnotificationid_Z(getgxTv_SdtWWP_Mail_Wwpnotificationid_Z());
      struct.setWwpnotificationcreated_Z(getgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z());
      struct.setWwpmailto_N(getgxTv_SdtWWP_Mail_Wwpmailto_N());
      struct.setWwpmailcc_N(getgxTv_SdtWWP_Mail_Wwpmailcc_N());
      struct.setWwpmailbcc_N(getgxTv_SdtWWP_Mail_Wwpmailbcc_N());
      struct.setWwpmailprocessed_N(getgxTv_SdtWWP_Mail_Wwpmailprocessed_N());
      struct.setWwpmaildetail_N(getgxTv_SdtWWP_Mail_Wwpmaildetail_N());
      struct.setWwpnotificationid_N(getgxTv_SdtWWP_Mail_Wwpnotificationid_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_Mail_N ;
   private byte gxTv_SdtWWP_Mail_Wwpmailto_N ;
   private byte gxTv_SdtWWP_Mail_Wwpmailcc_N ;
   private byte gxTv_SdtWWP_Mail_Wwpmailbcc_N ;
   private byte gxTv_SdtWWP_Mail_Wwpmailprocessed_N ;
   private byte gxTv_SdtWWP_Mail_Wwpmaildetail_N ;
   private byte gxTv_SdtWWP_Mail_Wwpnotificationid_N ;
   private short gxTv_SdtWWP_Mail_Wwpmailstatus ;
   private short gxTv_SdtWWP_Mail_Initialized ;
   private short gxTv_SdtWWP_Mail_Wwpmailstatus_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_Mail_Wwpmailid ;
   private long gxTv_SdtWWP_Mail_Wwpnotificationid ;
   private long gxTv_SdtWWP_Mail_Wwpmailid_Z ;
   private long gxTv_SdtWWP_Mail_Wwpnotificationid_Z ;
   private String gxTv_SdtWWP_Mail_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpmailcreated ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpmailscheduled ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpmailprocessed ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpnotificationcreated ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpmailcreated_Z ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpmailscheduled_Z ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpmailprocessed_Z ;
   private java.util.Date gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z ;
   private java.util.Date datetimemil_STZ ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_Mail_Wwpmailbody ;
   private String gxTv_SdtWWP_Mail_Wwpmailto ;
   private String gxTv_SdtWWP_Mail_Wwpmailcc ;
   private String gxTv_SdtWWP_Mail_Wwpmailbcc ;
   private String gxTv_SdtWWP_Mail_Wwpmailsenderaddress ;
   private String gxTv_SdtWWP_Mail_Wwpmailsendername ;
   private String gxTv_SdtWWP_Mail_Wwpmaildetail ;
   private String gxTv_SdtWWP_Mail_Wwpmailsubject ;
   private String gxTv_SdtWWP_Mail_Wwpmailsubject_Z ;
   private GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> gxTv_SdtWWP_Mail_Attachments_aux ;
   private GXBCLevelCollection<com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments> gxTv_SdtWWP_Mail_Attachments=null ;
}

