package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_Subscription extends GxSilentTrnSdt
{
   public SdtWWP_Subscription( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_Subscription.class));
   }

   public SdtWWP_Subscription( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_Subscription");
      initialize( remoteHandle) ;
   }

   public SdtWWP_Subscription( int remoteHandle ,
                               StructSdtWWP_Subscription struct )
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

   public void Load( long AV34WWPSubscriptionId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV34WWPSubscriptionId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPSubscriptionId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Subscriptions\\WWP_Subscription");
      metadata.set("BT", "WWP_Subscription");
      metadata.set("PK", "[ \"WWPSubscriptionId\" ]");
      metadata.set("PKAssigned", "[ \"WWPSubscriptionId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionId") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionId") )
            {
               gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionDescription") )
            {
               gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityName") )
            {
               gxTv_SdtWWP_Subscription_Wwpentityname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId") )
            {
               gxTv_SdtWWP_Subscription_Wwpuserextendedid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedFullName") )
            {
               gxTv_SdtWWP_Subscription_Wwpuserextendedfullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionEntityRecordId") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionEntityRecordDescription") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionRoleId") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionSubscribed") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_Subscription_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_Subscription_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionId_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionId_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionDescription_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityName_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpentityname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedFullName_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionEntityRecordId_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionEntityRecordDescription_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionRoleId_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionSubscribed_Z") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_N") )
            {
               gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPSubscriptionRoleId_N") )
            {
               gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_Subscription" ;
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
      oWriter.writeElement("WWPSubscriptionId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Wwpsubscriptionid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionDescription", gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPEntityName", gxTv_SdtWWP_Subscription_Wwpentityname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedId", gxTv_SdtWWP_Subscription_Wwpuserextendedid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedFullName", gxTv_SdtWWP_Subscription_Wwpuserextendedfullname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSubscriptionEntityRecordId", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSubscriptionEntityRecordDescription", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSubscriptionRoleId", gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPSubscriptionSubscribed", GXutil.booltostr( gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_Subscription_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSubscriptionId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionDescription_Z", gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPEntityName_Z", gxTv_SdtWWP_Subscription_Wwpentityname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_Z", gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedFullName_Z", gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSubscriptionEntityRecordId_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSubscriptionEntityRecordDescription_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSubscriptionRoleId_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSubscriptionSubscribed_Z", GXutil.booltostr( gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Wwpuserextendedid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPSubscriptionRoleId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N, 1, 0)));
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
      AddObjectProperty("WWPSubscriptionId", gxTv_SdtWWP_Subscription_Wwpsubscriptionid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionId", gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionDescription", gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription, false, includeNonInitialized);
      AddObjectProperty("WWPEntityName", gxTv_SdtWWP_Subscription_Wwpentityname, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId", gxTv_SdtWWP_Subscription_Wwpuserextendedid, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_Subscription_Wwpuserextendedid_N, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedFullName", gxTv_SdtWWP_Subscription_Wwpuserextendedfullname, false, includeNonInitialized);
      AddObjectProperty("WWPSubscriptionEntityRecordId", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid, false, includeNonInitialized);
      AddObjectProperty("WWPSubscriptionEntityRecordDescription", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription, false, includeNonInitialized);
      AddObjectProperty("WWPSubscriptionRoleId", gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid, false, includeNonInitialized);
      AddObjectProperty("WWPSubscriptionRoleId_N", gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N, false, includeNonInitialized);
      AddObjectProperty("WWPSubscriptionSubscribed", gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_Subscription_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_Subscription_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPSubscriptionId_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionId_Z", gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionDescription_Z", gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPEntityName_Z", gxTv_SdtWWP_Subscription_Wwpentityname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_Z", gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedFullName_Z", gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPSubscriptionEntityRecordId_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPSubscriptionEntityRecordDescription_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPSubscriptionRoleId_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPSubscriptionSubscribed_Z", gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_Subscription_Wwpuserextendedid_N, false, includeNonInitialized);
         AddObjectProperty("WWPSubscriptionRoleId_N", gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription sdt )
   {
      if ( sdt.IsDirty("WWPSubscriptionId") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpsubscriptionid = sdt.getgxTv_SdtWWP_Subscription_Wwpsubscriptionid() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionId") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid = sdt.getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionDescription") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription = sdt.getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription() ;
      }
      if ( sdt.IsDirty("WWPEntityName") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpentityname = sdt.getgxTv_SdtWWP_Subscription_Wwpentityname() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedId") )
      {
         gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = sdt.getgxTv_SdtWWP_Subscription_Wwpuserextendedid_N() ;
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpuserextendedid = sdt.getgxTv_SdtWWP_Subscription_Wwpuserextendedid() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedFullName") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpuserextendedfullname = sdt.getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname() ;
      }
      if ( sdt.IsDirty("WWPSubscriptionEntityRecordId") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid = sdt.getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid() ;
      }
      if ( sdt.IsDirty("WWPSubscriptionEntityRecordDescription") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription = sdt.getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription() ;
      }
      if ( sdt.IsDirty("WWPSubscriptionRoleId") )
      {
         gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = sdt.getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N() ;
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = sdt.getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid() ;
      }
      if ( sdt.IsDirty("WWPSubscriptionSubscribed") )
      {
         gxTv_SdtWWP_Subscription_N = (byte)(0) ;
         gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed = sdt.getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed() ;
      }
   }

   public long getgxTv_SdtWWP_Subscription_Wwpsubscriptionid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionid ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionid( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      if ( gxTv_SdtWWP_Subscription_Wwpsubscriptionid != value )
      {
         gxTv_SdtWWP_Subscription_Mode = "INS" ;
         this.setgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpentityname_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z_SetNull( );
         this.setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z_SetNull( );
      }
      SetDirty("Wwpsubscriptionid");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionid = value ;
   }

   public long getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionid");
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitiondescription");
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpentityname( )
   {
      return gxTv_SdtWWP_Subscription_Wwpentityname ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpentityname( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpentityname");
      gxTv_SdtWWP_Subscription_Wwpentityname = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpuserextendedid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedid ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedid( String value )
   {
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid");
      gxTv_SdtWWP_Subscription_Wwpuserextendedid = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedid_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = (byte)(1) ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid = "" ;
      SetDirty("Wwpuserextendedid");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpuserextendedid_IsNull( )
   {
      return (gxTv_SdtWWP_Subscription_Wwpuserextendedid_N==1) ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedfullname ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpuserextendedfullname");
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionentityrecordid");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionentityrecorddescription");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid( String value )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionroleid");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = (byte)(1) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = "" ;
      SetDirty("Wwpsubscriptionroleid");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_IsNull( )
   {
      return (gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N==1) ;
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed( boolean value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionsubscribed");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed = value ;
   }

   public String getgxTv_SdtWWP_Subscription_Mode( )
   {
      return gxTv_SdtWWP_Subscription_Mode ;
   }

   public void setgxTv_SdtWWP_Subscription_Mode( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_Subscription_Mode = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Mode_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_Subscription_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Subscription_Initialized( )
   {
      return gxTv_SdtWWP_Subscription_Initialized ;
   }

   public void setgxTv_SdtWWP_Subscription_Initialized( short value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_Subscription_Initialized = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Initialized_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_Subscription_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionid_Z");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z = 0 ;
      SetDirty("Wwpsubscriptionid_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionid_Z");
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z = 0 ;
      SetDirty("Wwpnotificationdefinitionid_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitiondescription_Z");
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z = "" ;
      SetDirty("Wwpnotificationdefinitiondescription_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpentityname_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpentityname_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpentityname_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpentityname_Z");
      gxTv_SdtWWP_Subscription_Wwpentityname_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpentityname_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpentityname_Z = "" ;
      SetDirty("Wwpentityname_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpentityname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_Z");
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z = "" ;
      SetDirty("Wwpuserextendedid_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpuserextendedfullname_Z");
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z = "" ;
      SetDirty("Wwpuserextendedfullname_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionentityrecordid_Z");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z = "" ;
      SetDirty("Wwpsubscriptionentityrecordid_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionentityrecorddescription_Z");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z = "" ;
      SetDirty("Wwpsubscriptionentityrecorddescription_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionroleid_Z");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z = "" ;
      SetDirty("Wwpsubscriptionroleid_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z( boolean value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionsubscribed_Z");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z = false ;
      SetDirty("Wwpsubscriptionsubscribed_Z");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Subscription_Wwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedid_N ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpuserextendedid_N_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpuserextendedid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N( byte value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionroleid_N");
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = value ;
   }

   public void setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N_SetNull( )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = (byte)(0) ;
      SetDirty("Wwpsubscriptionroleid_N");
   }

   public boolean getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(1) ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription = "" ;
      gxTv_SdtWWP_Subscription_Wwpentityname = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = "" ;
      gxTv_SdtWWP_Subscription_Mode = "" ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpentityname_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_Subscription_N ;
   }

   public com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription Clone( )
   {
      com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription sdt;
      com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.subscriptions.StructSdtWWP_Subscription struct )
   {
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionid(struct.getWwpsubscriptionid());
      setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid(struct.getWwpnotificationdefinitionid());
      setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription(struct.getWwpnotificationdefinitiondescription());
      setgxTv_SdtWWP_Subscription_Wwpentityname(struct.getWwpentityname());
      setgxTv_SdtWWP_Subscription_Wwpuserextendedid(struct.getWwpuserextendedid());
      setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname(struct.getWwpuserextendedfullname());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid(struct.getWwpsubscriptionentityrecordid());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription(struct.getWwpsubscriptionentityrecorddescription());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid(struct.getWwpsubscriptionroleid());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed(struct.getWwpsubscriptionsubscribed());
      setgxTv_SdtWWP_Subscription_Mode(struct.getMode());
      setgxTv_SdtWWP_Subscription_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z(struct.getWwpsubscriptionid_Z());
      setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z(struct.getWwpnotificationdefinitionid_Z());
      setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z(struct.getWwpnotificationdefinitiondescription_Z());
      setgxTv_SdtWWP_Subscription_Wwpentityname_Z(struct.getWwpentityname_Z());
      setgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z(struct.getWwpuserextendedid_Z());
      setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z(struct.getWwpuserextendedfullname_Z());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z(struct.getWwpsubscriptionentityrecordid_Z());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z(struct.getWwpsubscriptionentityrecorddescription_Z());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z(struct.getWwpsubscriptionroleid_Z());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z(struct.getWwpsubscriptionsubscribed_Z());
      setgxTv_SdtWWP_Subscription_Wwpuserextendedid_N(struct.getWwpuserextendedid_N());
      setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N(struct.getWwpsubscriptionroleid_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.subscriptions.StructSdtWWP_Subscription getStruct( )
   {
      com.mujermorena.wwpbaseobjects.subscriptions.StructSdtWWP_Subscription struct = new com.mujermorena.wwpbaseobjects.subscriptions.StructSdtWWP_Subscription ();
      struct.setWwpsubscriptionid(getgxTv_SdtWWP_Subscription_Wwpsubscriptionid());
      struct.setWwpnotificationdefinitionid(getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid());
      struct.setWwpnotificationdefinitiondescription(getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription());
      struct.setWwpentityname(getgxTv_SdtWWP_Subscription_Wwpentityname());
      struct.setWwpuserextendedid(getgxTv_SdtWWP_Subscription_Wwpuserextendedid());
      struct.setWwpuserextendedfullname(getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname());
      struct.setWwpsubscriptionentityrecordid(getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid());
      struct.setWwpsubscriptionentityrecorddescription(getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription());
      struct.setWwpsubscriptionroleid(getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid());
      struct.setWwpsubscriptionsubscribed(getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed());
      struct.setMode(getgxTv_SdtWWP_Subscription_Mode());
      struct.setInitialized(getgxTv_SdtWWP_Subscription_Initialized());
      struct.setWwpsubscriptionid_Z(getgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z());
      struct.setWwpnotificationdefinitionid_Z(getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z());
      struct.setWwpnotificationdefinitiondescription_Z(getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z());
      struct.setWwpentityname_Z(getgxTv_SdtWWP_Subscription_Wwpentityname_Z());
      struct.setWwpuserextendedid_Z(getgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z());
      struct.setWwpuserextendedfullname_Z(getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z());
      struct.setWwpsubscriptionentityrecordid_Z(getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z());
      struct.setWwpsubscriptionentityrecorddescription_Z(getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z());
      struct.setWwpsubscriptionroleid_Z(getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z());
      struct.setWwpsubscriptionsubscribed_Z(getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z());
      struct.setWwpuserextendedid_N(getgxTv_SdtWWP_Subscription_Wwpuserextendedid_N());
      struct.setWwpsubscriptionroleid_N(getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_Subscription_N ;
   private byte gxTv_SdtWWP_Subscription_Wwpuserextendedid_N ;
   private byte gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N ;
   private short gxTv_SdtWWP_Subscription_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_Subscription_Wwpsubscriptionid ;
   private long gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid ;
   private long gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z ;
   private long gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z ;
   private String gxTv_SdtWWP_Subscription_Wwpuserextendedid ;
   private String gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid ;
   private String gxTv_SdtWWP_Subscription_Mode ;
   private String gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z ;
   private String gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z ;
   private String sTagName ;
   private boolean gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed ;
   private boolean gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription ;
   private String gxTv_SdtWWP_Subscription_Wwpentityname ;
   private String gxTv_SdtWWP_Subscription_Wwpuserextendedfullname ;
   private String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid ;
   private String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription ;
   private String gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z ;
   private String gxTv_SdtWWP_Subscription_Wwpentityname_Z ;
   private String gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z ;
   private String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z ;
   private String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z ;
}

