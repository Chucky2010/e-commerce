package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_WebNotification extends GxSilentTrnSdt
{
   public SdtWWP_WebNotification( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_WebNotification.class));
   }

   public SdtWWP_WebNotification( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_WebNotification");
      initialize( remoteHandle) ;
   }

   public SdtWWP_WebNotification( int remoteHandle ,
                                  StructSdtWWP_WebNotification struct )
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

   public void Load( long AV38WWPWebNotificationId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV38WWPWebNotificationId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPWebNotificationId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification");
      metadata.set("BT", "WWP_WebNotification");
      metadata.set("PK", "[ \"WWPWebNotificationId\" ]");
      metadata.set("PKAssigned", "[ \"WWPWebNotificationId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationId") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationTitle") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationid = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationMetadata") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionName") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationText") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationIcon") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationClientId") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationStatus") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationCreated") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationScheduled") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationProcessed") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationRead") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationDetail") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationReceived") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_WebNotification_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_WebNotification_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationId_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationTitle_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionName_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationText_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationIcon_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationStatus_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationCreated_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationScheduled_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationProcessed_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationRead_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))), (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 21, 3), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationReceived_Z") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationId_N") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationMetadata_N") )
            {
               gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationRead_N") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationDetail_N") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPWebNotificationReceived_N") )
            {
               gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_WebNotification" ;
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
      oWriter.writeElement("WWPWebNotificationId", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationTitle", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationId", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpnotificationid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPNotificationCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationMetadata", gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionName", gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationText", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationIcon", gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationClientId", gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationStatus", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPWebNotificationCreated", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPWebNotificationScheduled", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPWebNotificationProcessed", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "." ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread), 10, 0)) ;
      sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPWebNotificationRead", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationDetail", gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPWebNotificationReceived", GXutil.booltostr( gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_WebNotification_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationTitle_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPNotificationCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionName_Z", gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationText_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationIcon_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationStatus_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPWebNotificationCreated_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPWebNotificationScheduled_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPWebNotificationProcessed_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "." ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.millisecond( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "000", 1, 3-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPWebNotificationRead_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationReceived_Z", GXutil.booltostr( gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpnotificationid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationMetadata_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationRead_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationDetail_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPWebNotificationReceived_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N, 1, 0)));
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
      AddObjectProperty("WWPWebNotificationId", gxTv_SdtWWP_WebNotification_Wwpwebnotificationid, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationTitle", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId", gxTv_SdtWWP_WebNotification_Wwpnotificationid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_WebNotification_Wwpnotificationid_N, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpnotificationcreated ;
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
      AddObjectProperty("WWPNotificationMetadata", gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationMetadata_N", gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionName", gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationText", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationIcon", gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationClientId", gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationStatus", gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated ;
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
      AddObjectProperty("WWPWebNotificationCreated", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled ;
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
      AddObjectProperty("WWPWebNotificationScheduled", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed ;
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
      AddObjectProperty("WWPWebNotificationProcessed", sDateCnv, false, includeNonInitialized);
      datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationread ;
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
      AddObjectProperty("WWPWebNotificationRead", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationRead_N", gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationDetail", gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationDetail_N", gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationReceived", gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived, false, includeNonInitialized);
      AddObjectProperty("WWPWebNotificationReceived_N", gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_WebNotification_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_WebNotification_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationId_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationTitle_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_Z", gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z ;
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
         AddObjectProperty("WWPNotificationDefinitionName_Z", gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationText_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationIcon_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationStatus_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z ;
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
         AddObjectProperty("WWPWebNotificationCreated_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z ;
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
         AddObjectProperty("WWPWebNotificationScheduled_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z ;
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
         AddObjectProperty("WWPWebNotificationProcessed_Z", sDateCnv, false, includeNonInitialized);
         datetimemil_STZ = gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z ;
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
         AddObjectProperty("WWPWebNotificationRead_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationReceived_Z", gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationId_N", gxTv_SdtWWP_WebNotification_Wwpnotificationid_N, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationMetadata_N", gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationRead_N", gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationDetail_N", gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N, false, includeNonInitialized);
         AddObjectProperty("WWPWebNotificationReceived_N", gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification sdt )
   {
      if ( sdt.IsDirty("WWPWebNotificationId") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationid = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationTitle") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle() ;
      }
      if ( sdt.IsDirty("WWPNotificationId") )
      {
         gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = sdt.getgxTv_SdtWWP_WebNotification_Wwpnotificationid_N() ;
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpnotificationid = sdt.getgxTv_SdtWWP_WebNotification_Wwpnotificationid() ;
      }
      if ( sdt.IsDirty("WWPNotificationCreated") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = sdt.getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated() ;
      }
      if ( sdt.IsDirty("WWPNotificationMetadata") )
      {
         gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = sdt.getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N() ;
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = sdt.getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionName") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname = sdt.getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationText") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationIcon") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationClientId") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationStatus") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationCreated") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationScheduled") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationProcessed") )
      {
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationRead") )
      {
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N() ;
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationDetail") )
      {
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N() ;
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail() ;
      }
      if ( sdt.IsDirty("WWPWebNotificationReceived") )
      {
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N() ;
         gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
         gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived = sdt.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived() ;
      }
   }

   public long getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationid ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid( long value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      if ( gxTv_SdtWWP_WebNotification_Wwpwebnotificationid != value )
      {
         gxTv_SdtWWP_WebNotification_Mode = "INS" ;
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z_SetNull( );
         this.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z_SetNull( );
      }
      SetDirty("Wwpwebnotificationid");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationid = value ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationtitle");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle = value ;
   }

   public long getgxTv_SdtWWP_WebNotification_Wwpnotificationid( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationid ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationid( long value )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationid");
      gxTv_SdtWWP_WebNotification_Wwpnotificationid = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationid_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationid = 0 ;
      SetDirty("Wwpnotificationid");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationid_IsNull( )
   {
      return (gxTv_SdtWWP_WebNotification_Wwpnotificationid_N==1) ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationcreated ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated");
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = value ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata( String value )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationmetadata");
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = "" ;
      SetDirty("Wwpnotificationmetadata");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_IsNull( )
   {
      return (gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N==1) ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionname");
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname = value ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationtext");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext = value ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationicon");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon = value ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationclientid");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid = value ;
   }

   public short getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus( short value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationstatus");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus = value ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationcreated");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = value ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationscheduled");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = value ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationprocessed");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = value ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationread ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationread");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebnotificationread");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_IsNull( )
   {
      return (gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N==1) ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail( String value )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationdetail");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = "" ;
      SetDirty("Wwpwebnotificationdetail");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_IsNull( )
   {
      return (gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N==1) ;
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived( boolean value )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationreceived");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived = false ;
      SetDirty("Wwpwebnotificationreceived");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_IsNull( )
   {
      return (gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N==1) ;
   }

   public String getgxTv_SdtWWP_WebNotification_Mode( )
   {
      return gxTv_SdtWWP_WebNotification_Mode ;
   }

   public void setgxTv_SdtWWP_WebNotification_Mode( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_WebNotification_Mode = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Mode_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_WebNotification_Initialized( )
   {
      return gxTv_SdtWWP_WebNotification_Initialized ;
   }

   public void setgxTv_SdtWWP_WebNotification_Initialized( short value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_WebNotification_Initialized = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Initialized_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z( long value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationid_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z = 0 ;
      SetDirty("Wwpwebnotificationid_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationtitle_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z = "" ;
      SetDirty("Wwpwebnotificationtitle_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_Z");
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z = 0 ;
      SetDirty("Wwpnotificationid_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationcreated_Z");
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpnotificationcreated_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionname_Z");
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z = "" ;
      SetDirty("Wwpnotificationdefinitionname_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationtext_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z = "" ;
      SetDirty("Wwpwebnotificationtext_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationicon_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z = "" ;
      SetDirty("Wwpwebnotificationicon_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z( short value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationstatus_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z = (short)(0) ;
      SetDirty("Wwpwebnotificationstatus_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationcreated_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebnotificationcreated_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationscheduled_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebnotificationscheduled_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationprocessed_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebnotificationprocessed_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationread_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpwebnotificationread_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z( boolean value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationreceived_Z");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z = false ;
      SetDirty("Wwpwebnotificationreceived_Z");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_WebNotification_Wwpnotificationid_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationid_N ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationid_N_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = (byte)(0) ;
      SetDirty("Wwpnotificationid_N");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpnotificationmetadata_N");
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = (byte)(0) ;
      SetDirty("Wwpnotificationmetadata_N");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationread_N");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationread_N");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationdetail_N");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationdetail_N");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationreceived_N");
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = value ;
   }

   public void setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N_SetNull( )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = (byte)(0) ;
      SetDirty("Wwpwebnotificationreceived_N");
   }

   public boolean getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle = "" ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = "" ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = "" ;
      gxTv_SdtWWP_WebNotification_Mode = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetimemil_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_WebNotification_N ;
   }

   public com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification Clone( )
   {
      com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification sdt;
      com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebNotification struct )
   {
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid(struct.getWwpwebnotificationid());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle(struct.getWwpwebnotificationtitle());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationid(struct.getWwpnotificationid());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated(struct.getWwpnotificationcreated());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata(struct.getWwpnotificationmetadata());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname(struct.getWwpnotificationdefinitionname());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext(struct.getWwpwebnotificationtext());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon(struct.getWwpwebnotificationicon());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid(struct.getWwpwebnotificationclientid());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus(struct.getWwpwebnotificationstatus());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated(struct.getWwpwebnotificationcreated());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled(struct.getWwpwebnotificationscheduled());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed(struct.getWwpwebnotificationprocessed());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread(struct.getWwpwebnotificationread());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail(struct.getWwpwebnotificationdetail());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived(struct.getWwpwebnotificationreceived());
      setgxTv_SdtWWP_WebNotification_Mode(struct.getMode());
      setgxTv_SdtWWP_WebNotification_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z(struct.getWwpwebnotificationid_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z(struct.getWwpwebnotificationtitle_Z());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z(struct.getWwpnotificationid_Z());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z(struct.getWwpnotificationcreated_Z());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z(struct.getWwpnotificationdefinitionname_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z(struct.getWwpwebnotificationtext_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z(struct.getWwpwebnotificationicon_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z(struct.getWwpwebnotificationstatus_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z(struct.getWwpwebnotificationcreated_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z(struct.getWwpwebnotificationscheduled_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z(struct.getWwpwebnotificationprocessed_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z(struct.getWwpwebnotificationread_Z());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z(struct.getWwpwebnotificationreceived_Z());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationid_N(struct.getWwpnotificationid_N());
      setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N(struct.getWwpnotificationmetadata_N());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N(struct.getWwpwebnotificationread_N());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N(struct.getWwpwebnotificationdetail_N());
      setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N(struct.getWwpwebnotificationreceived_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebNotification getStruct( )
   {
      com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebNotification struct = new com.mujermorena.wwpbaseobjects.notifications.web.StructSdtWWP_WebNotification ();
      struct.setWwpwebnotificationid(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid());
      struct.setWwpwebnotificationtitle(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle());
      struct.setWwpnotificationid(getgxTv_SdtWWP_WebNotification_Wwpnotificationid());
      struct.setWwpnotificationcreated(getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated());
      struct.setWwpnotificationmetadata(getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata());
      struct.setWwpnotificationdefinitionname(getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname());
      struct.setWwpwebnotificationtext(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext());
      struct.setWwpwebnotificationicon(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon());
      struct.setWwpwebnotificationclientid(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid());
      struct.setWwpwebnotificationstatus(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus());
      struct.setWwpwebnotificationcreated(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated());
      struct.setWwpwebnotificationscheduled(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled());
      struct.setWwpwebnotificationprocessed(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed());
      struct.setWwpwebnotificationread(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread());
      struct.setWwpwebnotificationdetail(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail());
      struct.setWwpwebnotificationreceived(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived());
      struct.setMode(getgxTv_SdtWWP_WebNotification_Mode());
      struct.setInitialized(getgxTv_SdtWWP_WebNotification_Initialized());
      struct.setWwpwebnotificationid_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z());
      struct.setWwpwebnotificationtitle_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z());
      struct.setWwpnotificationid_Z(getgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z());
      struct.setWwpnotificationcreated_Z(getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z());
      struct.setWwpnotificationdefinitionname_Z(getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z());
      struct.setWwpwebnotificationtext_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z());
      struct.setWwpwebnotificationicon_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z());
      struct.setWwpwebnotificationstatus_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z());
      struct.setWwpwebnotificationcreated_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z());
      struct.setWwpwebnotificationscheduled_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z());
      struct.setWwpwebnotificationprocessed_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z());
      struct.setWwpwebnotificationread_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z());
      struct.setWwpwebnotificationreceived_Z(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z());
      struct.setWwpnotificationid_N(getgxTv_SdtWWP_WebNotification_Wwpnotificationid_N());
      struct.setWwpnotificationmetadata_N(getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N());
      struct.setWwpwebnotificationread_N(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N());
      struct.setWwpwebnotificationdetail_N(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N());
      struct.setWwpwebnotificationreceived_N(getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_WebNotification_N ;
   private byte gxTv_SdtWWP_WebNotification_Wwpnotificationid_N ;
   private byte gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N ;
   private byte gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N ;
   private byte gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N ;
   private byte gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N ;
   private short gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus ;
   private short gxTv_SdtWWP_WebNotification_Initialized ;
   private short gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_WebNotification_Wwpwebnotificationid ;
   private long gxTv_SdtWWP_WebNotification_Wwpnotificationid ;
   private long gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z ;
   private long gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z ;
   private String gxTv_SdtWWP_WebNotification_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpnotificationcreated ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationread ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z ;
   private java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z ;
   private java.util.Date datetimemil_STZ ;
   private boolean gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived ;
   private boolean gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle ;
   private String gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z ;
   private String gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z ;
   private String gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z ;
}

