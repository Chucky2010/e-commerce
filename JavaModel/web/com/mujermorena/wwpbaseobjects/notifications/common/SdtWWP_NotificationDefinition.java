package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_NotificationDefinition extends GxSilentTrnSdt
{
   public SdtWWP_NotificationDefinition( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_NotificationDefinition.class));
   }

   public SdtWWP_NotificationDefinition( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_NotificationDefinition");
      initialize( remoteHandle) ;
   }

   public SdtWWP_NotificationDefinition( int remoteHandle ,
                                         StructSdtWWP_NotificationDefinition struct )
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

   public void Load( long AV35WWPNotificationDefinitionId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV35WWPNotificationDefinitionId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPNotificationDefinitionId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition");
      metadata.set("BT", "WWP_NotificationDefinition");
      metadata.set("PK", "[ \"WWPNotificationDefinitionId\" ]");
      metadata.set("PKAssigned", "[ \"WWPNotificationDefinitionId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"WWPEntityId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionId") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionName") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionAppliesTo") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionAllowUserSubscription") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionDescription") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionIcon") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionTitle") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionShortDescription") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionLongDescription") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionLink") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityId") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpentityid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityName") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpentityname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionSecFuncionality") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionIsAuthorized") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_NotificationDefinition_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_NotificationDefinition_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionId_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionName_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionAppliesTo_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionAllowUserSubscription_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionDescription_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionIcon_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionTitle_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionShortDescription_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionLongDescription_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionLink_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityId_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityName_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionSecFuncionality_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPNotificationDefinitionIsAuthorized_Z") )
            {
               gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "WWP_NotificationDefinition" ;
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
      oWriter.writeElement("WWPNotificationDefinitionId", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionName", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionAppliesTo", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionAllowUserSubscription", GXutil.booltostr( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionDescription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionIcon", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionTitle", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionShortDescription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionLongDescription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionLink", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPEntityId", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Wwpentityid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPEntityName", gxTv_SdtWWP_NotificationDefinition_Wwpentityname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionSecFuncionality", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPNotificationDefinitionIsAuthorized", GXutil.booltostr( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_NotificationDefinition_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionName_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionAppliesTo_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionAllowUserSubscription_Z", GXutil.booltostr( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionDescription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionIcon_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionTitle_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionShortDescription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionLongDescription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionLink_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPEntityId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPEntityName_Z", gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionSecFuncionality_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPNotificationDefinitionIsAuthorized_Z", GXutil.booltostr( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z));
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
      AddObjectProperty("WWPNotificationDefinitionId", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionName", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionAppliesTo", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionAllowUserSubscription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionDescription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionIcon", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionTitle", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionShortDescription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionLongDescription", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionLink", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink, false, includeNonInitialized);
      AddObjectProperty("WWPEntityId", gxTv_SdtWWP_NotificationDefinition_Wwpentityid, false, includeNonInitialized);
      AddObjectProperty("WWPEntityName", gxTv_SdtWWP_NotificationDefinition_Wwpentityname, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionSecFuncionality", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality, false, includeNonInitialized);
      AddObjectProperty("WWPNotificationDefinitionIsAuthorized", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_NotificationDefinition_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_NotificationDefinition_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionId_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionName_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionAppliesTo_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionAllowUserSubscription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionDescription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionIcon_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionTitle_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionShortDescription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionLongDescription_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionLink_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z, false, includeNonInitialized);
         AddObjectProperty("WWPEntityId_Z", gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPEntityName_Z", gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionSecFuncionality_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z, false, includeNonInitialized);
         AddObjectProperty("WWPNotificationDefinitionIsAuthorized_Z", gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition sdt )
   {
      if ( sdt.IsDirty("WWPNotificationDefinitionId") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionName") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionAppliesTo") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionAllowUserSubscription") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionDescription") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionIcon") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionTitle") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionShortDescription") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionLongDescription") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionLink") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink() ;
      }
      if ( sdt.IsDirty("WWPEntityId") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpentityid = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpentityid() ;
      }
      if ( sdt.IsDirty("WWPEntityName") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpentityname = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpentityname() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionSecFuncionality") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality() ;
      }
      if ( sdt.IsDirty("WWPNotificationDefinitionIsAuthorized") )
      {
         gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
         gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized = sdt.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized() ;
      }
   }

   public long getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      if ( gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid != value )
      {
         gxTv_SdtWWP_NotificationDefinition_Mode = "INS" ;
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z_SetNull( );
         this.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z_SetNull( );
      }
      SetDirty("Wwpnotificationdefinitionid");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionname");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname = value ;
   }

   public byte getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto( byte value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionappliesto");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto = value ;
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionallowusersubscription");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitiondescription");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionicon");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitiontitle");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionshortdescription");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionlongdescription");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionlink");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink = value ;
   }

   public long getgxTv_SdtWWP_NotificationDefinition_Wwpentityid( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityid ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpentityid( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpentityid");
      gxTv_SdtWWP_NotificationDefinition_Wwpentityid = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpentityname( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityname ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpentityname( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpentityname");
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname = value ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionsecfuncionality");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality = value ;
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionisauthorized");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized = false ;
      SetDirty("Wwpnotificationdefinitionisauthorized");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Mode( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Mode ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Mode( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_NotificationDefinition_Mode = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Mode_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_NotificationDefinition_Initialized( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Initialized ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Initialized( short value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_NotificationDefinition_Initialized = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Initialized_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionid_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z = 0 ;
      SetDirty("Wwpnotificationdefinitionid_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionname_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z = "" ;
      SetDirty("Wwpnotificationdefinitionname_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z( byte value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionappliesto_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionappliesto_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionallowusersubscription_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z = false ;
      SetDirty("Wwpnotificationdefinitionallowusersubscription_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitiondescription_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z = "" ;
      SetDirty("Wwpnotificationdefinitiondescription_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionicon_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z = "" ;
      SetDirty("Wwpnotificationdefinitionicon_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitiontitle_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z = "" ;
      SetDirty("Wwpnotificationdefinitiontitle_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionshortdescription_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z = "" ;
      SetDirty("Wwpnotificationdefinitionshortdescription_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionlongdescription_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z = "" ;
      SetDirty("Wwpnotificationdefinitionlongdescription_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionlink_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z = "" ;
      SetDirty("Wwpnotificationdefinitionlink_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpentityid_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z = 0 ;
      SetDirty("Wwpentityid_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpentityname_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z = "" ;
      SetDirty("Wwpentityname_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionsecfuncionality_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z = "" ;
      SetDirty("Wwpnotificationdefinitionsecfuncionality_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      SetDirty("Wwpnotificationdefinitionisauthorized_Z");
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z = value ;
   }

   public void setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z_SetNull( )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z = false ;
      SetDirty("Wwpnotificationdefinitionisauthorized_Z");
   }

   public boolean getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(1) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality = "" ;
      gxTv_SdtWWP_NotificationDefinition_Mode = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_NotificationDefinition_N ;
   }

   public com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition Clone( )
   {
      com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition sdt;
      com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_NotificationDefinition struct )
   {
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid(struct.getWwpnotificationdefinitionid());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname(struct.getWwpnotificationdefinitionname());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto(struct.getWwpnotificationdefinitionappliesto());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription(struct.getWwpnotificationdefinitionallowusersubscription());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription(struct.getWwpnotificationdefinitiondescription());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon(struct.getWwpnotificationdefinitionicon());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle(struct.getWwpnotificationdefinitiontitle());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription(struct.getWwpnotificationdefinitionshortdescription());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription(struct.getWwpnotificationdefinitionlongdescription());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink(struct.getWwpnotificationdefinitionlink());
      setgxTv_SdtWWP_NotificationDefinition_Wwpentityid(struct.getWwpentityid());
      setgxTv_SdtWWP_NotificationDefinition_Wwpentityname(struct.getWwpentityname());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality(struct.getWwpnotificationdefinitionsecfuncionality());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized(struct.getWwpnotificationdefinitionisauthorized());
      setgxTv_SdtWWP_NotificationDefinition_Mode(struct.getMode());
      setgxTv_SdtWWP_NotificationDefinition_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z(struct.getWwpnotificationdefinitionid_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z(struct.getWwpnotificationdefinitionname_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z(struct.getWwpnotificationdefinitionappliesto_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z(struct.getWwpnotificationdefinitionallowusersubscription_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z(struct.getWwpnotificationdefinitiondescription_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z(struct.getWwpnotificationdefinitionicon_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z(struct.getWwpnotificationdefinitiontitle_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z(struct.getWwpnotificationdefinitionshortdescription_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z(struct.getWwpnotificationdefinitionlongdescription_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z(struct.getWwpnotificationdefinitionlink_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z(struct.getWwpentityid_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z(struct.getWwpentityname_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z(struct.getWwpnotificationdefinitionsecfuncionality_Z());
      setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z(struct.getWwpnotificationdefinitionisauthorized_Z());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_NotificationDefinition getStruct( )
   {
      com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_NotificationDefinition struct = new com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_NotificationDefinition ();
      struct.setWwpnotificationdefinitionid(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid());
      struct.setWwpnotificationdefinitionname(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname());
      struct.setWwpnotificationdefinitionappliesto(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto());
      struct.setWwpnotificationdefinitionallowusersubscription(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription());
      struct.setWwpnotificationdefinitiondescription(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription());
      struct.setWwpnotificationdefinitionicon(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon());
      struct.setWwpnotificationdefinitiontitle(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle());
      struct.setWwpnotificationdefinitionshortdescription(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription());
      struct.setWwpnotificationdefinitionlongdescription(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription());
      struct.setWwpnotificationdefinitionlink(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink());
      struct.setWwpentityid(getgxTv_SdtWWP_NotificationDefinition_Wwpentityid());
      struct.setWwpentityname(getgxTv_SdtWWP_NotificationDefinition_Wwpentityname());
      struct.setWwpnotificationdefinitionsecfuncionality(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality());
      struct.setWwpnotificationdefinitionisauthorized(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized());
      struct.setMode(getgxTv_SdtWWP_NotificationDefinition_Mode());
      struct.setInitialized(getgxTv_SdtWWP_NotificationDefinition_Initialized());
      struct.setWwpnotificationdefinitionid_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z());
      struct.setWwpnotificationdefinitionname_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z());
      struct.setWwpnotificationdefinitionappliesto_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z());
      struct.setWwpnotificationdefinitionallowusersubscription_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z());
      struct.setWwpnotificationdefinitiondescription_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z());
      struct.setWwpnotificationdefinitionicon_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z());
      struct.setWwpnotificationdefinitiontitle_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z());
      struct.setWwpnotificationdefinitionshortdescription_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z());
      struct.setWwpnotificationdefinitionlongdescription_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z());
      struct.setWwpnotificationdefinitionlink_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z());
      struct.setWwpentityid_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z());
      struct.setWwpentityname_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z());
      struct.setWwpnotificationdefinitionsecfuncionality_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z());
      struct.setWwpnotificationdefinitionisauthorized_Z(getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z());
      return struct ;
   }

   private byte gxTv_SdtWWP_NotificationDefinition_N ;
   private byte gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto ;
   private byte gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z ;
   private short gxTv_SdtWWP_NotificationDefinition_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid ;
   private long gxTv_SdtWWP_NotificationDefinition_Wwpentityid ;
   private long gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z ;
   private long gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Mode ;
   private String sTagName ;
   private boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription ;
   private boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized ;
   private boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z ;
   private boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpentityname ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z ;
   private String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z ;
}

