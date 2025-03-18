package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_UserExtended extends GxSilentTrnSdt
{
   public SdtWWP_UserExtended( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_UserExtended.class));
   }

   public SdtWWP_UserExtended( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_UserExtended");
      initialize( remoteHandle) ;
   }

   public SdtWWP_UserExtended( int remoteHandle ,
                               StructSdtWWP_UserExtended struct )
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

   public void Load( String AV32WWPUserExtendedId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV32WWPUserExtendedId});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPUserExtendedId", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\WWP_UserExtended");
      metadata.set("BT", "WWP_UserExtended");
      metadata.set("PK", "[ \"WWPUserExtendedId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedPhoto") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedPhoto_GXI") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedName") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedFullName") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedPhone") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedphone = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedEmail") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedEmaiNotif") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedSMSNotif") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedMobileNotif") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDesktopNotif") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDeleted") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDeletedIn") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
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
               gxTv_SdtWWP_UserExtended_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_UserExtended_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedName_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedFullName_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedPhone_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedEmail_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedEmaiNotif_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedSMSNotif_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedMobileNotif_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDesktopNotif_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDeleted_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDeletedIn_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedPhoto_GXI_Z") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedId_N") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPUserExtendedDeletedIn_N") )
            {
               gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "WWP_UserExtended" ;
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
      oWriter.writeElement("WWPUserExtendedId", gxTv_SdtWWP_UserExtended_Wwpuserextendedid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedPhoto", gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedName", gxTv_SdtWWP_UserExtended_Wwpuserextendedname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedFullName", gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedPhone", gxTv_SdtWWP_UserExtended_Wwpuserextendedphone);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedEmail", gxTv_SdtWWP_UserExtended_Wwpuserextendedemail);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedEmaiNotif", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedSMSNotif", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedMobileNotif", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedDesktopNotif", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPUserExtendedDeleted", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("WWPUserExtendedDeletedIn", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("WWPUserExtendedPhoto_GXI", gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Mode", gxTv_SdtWWP_UserExtended_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_UserExtended_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedName_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedFullName_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedPhone_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedEmail_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedEmaiNotif_Z", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedSMSNotif_Z", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedMobileNotif_Z", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedDesktopNotif_Z", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedDeleted_Z", GXutil.booltostr( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("WWPUserExtendedDeletedIn_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedPhoto_GXI_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedId_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPUserExtendedDeletedIn_N", GXutil.trim( GXutil.str( gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N, 1, 0)));
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
      AddObjectProperty("WWPUserExtendedId", gxTv_SdtWWP_UserExtended_Wwpuserextendedid, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedPhoto", gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedName", gxTv_SdtWWP_UserExtended_Wwpuserextendedname, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedFullName", gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedPhone", gxTv_SdtWWP_UserExtended_Wwpuserextendedphone, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedEmail", gxTv_SdtWWP_UserExtended_Wwpuserextendedemail, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedEmaiNotif", gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedSMSNotif", gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedMobileNotif", gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedDesktopNotif", gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedDeleted", gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("WWPUserExtendedDeletedIn", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("WWPUserExtendedDeletedIn_N", gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("WWPUserExtendedPhoto_GXI", gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi, false, includeNonInitialized);
         AddObjectProperty("Mode", gxTv_SdtWWP_UserExtended_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_UserExtended_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedName_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedFullName_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedPhone_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedEmail_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedEmaiNotif_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedSMSNotif_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedMobileNotif_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedDesktopNotif_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedDeleted_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("WWPUserExtendedDeletedIn_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedPhoto_GXI_Z", gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedId_N", gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N, false, includeNonInitialized);
         AddObjectProperty("WWPUserExtendedDeletedIn_N", gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended sdt )
   {
      if ( sdt.IsDirty("WWPUserExtendedId") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedid = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedid() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedPhoto") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedPhoto") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedName") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedname = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedname() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedFullName") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedPhone") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedphone = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedEmail") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedemail = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedEmaiNotif") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedSMSNotif") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedMobileNotif") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedDesktopNotif") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedDeleted") )
      {
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted() ;
      }
      if ( sdt.IsDirty("WWPUserExtendedDeletedIn") )
      {
         gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N() ;
         gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
         gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = sdt.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin() ;
      }
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedid( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedid ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedid( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtWWP_UserExtended_Wwpuserextendedid, value) != 0 )
      {
         gxTv_SdtWWP_UserExtended_Mode = "INS" ;
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z_SetNull( );
         this.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z_SetNull( );
      }
      SetDirty("Wwpuserextendedid");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid = value ;
   }

   @GxUpload
   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedphoto");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto = value ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedphoto_gxi");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi = value ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedname( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedname ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedname( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedname");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname = value ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedfullname");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname = value ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphone ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedphone");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone = value ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemail ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedemail");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail = value ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedemainotif");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif = value ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedsmsnotif");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif = value ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedmobilenotif");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif = value ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddesktopnotif");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif = value ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddeleted");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted = value ;
   }

   public java.util.Date getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin( java.util.Date value )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddeletedin");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = (byte)(1) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpuserextendeddeletedin");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_IsNull( )
   {
      return (gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N==1) ;
   }

   public String getgxTv_SdtWWP_UserExtended_Mode( )
   {
      return gxTv_SdtWWP_UserExtended_Mode ;
   }

   public void setgxTv_SdtWWP_UserExtended_Mode( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_UserExtended_Mode = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Mode_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_UserExtended_Initialized( )
   {
      return gxTv_SdtWWP_UserExtended_Initialized ;
   }

   public void setgxTv_SdtWWP_UserExtended_Initialized( short value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_UserExtended_Initialized = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Initialized_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z = "" ;
      SetDirty("Wwpuserextendedid_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedname_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z = "" ;
      SetDirty("Wwpuserextendedname_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedfullname_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z = "" ;
      SetDirty("Wwpuserextendedfullname_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedphone_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z = "" ;
      SetDirty("Wwpuserextendedphone_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedemail_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z = "" ;
      SetDirty("Wwpuserextendedemail_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedemainotif_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z = false ;
      SetDirty("Wwpuserextendedemainotif_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedsmsnotif_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z = false ;
      SetDirty("Wwpuserextendedsmsnotif_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedmobilenotif_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z = false ;
      SetDirty("Wwpuserextendedmobilenotif_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddesktopnotif_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z = false ;
      SetDirty("Wwpuserextendeddesktopnotif_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddeleted_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z = false ;
      SetDirty("Wwpuserextendeddeleted_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z( java.util.Date value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddeletedin_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Wwpuserextendeddeletedin_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedphoto_gxi_Z");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z = "" ;
      SetDirty("Wwpuserextendedphoto_gxi_Z");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N = (byte)(0) ;
      SetDirty("Wwpuserextendedid_N");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N( byte value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddeletedin_N");
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = value ;
   }

   public void setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N_SetNull( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = (byte)(0) ;
      SetDirty("Wwpuserextendeddeletedin_N");
   }

   public boolean getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.wwp_userextended_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.wwp_userextended_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_UserExtended_N = (byte)(1) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_UserExtended_Mode = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_UserExtended_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended Clone( )
   {
      com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended sdt;
      com.mujermorena.wwpbaseobjects.wwp_userextended_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.wwp_userextended_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtWWP_UserExtended struct )
   {
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedid(struct.getWwpuserextendedid());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto(struct.getWwpuserextendedphoto());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi(struct.getWwpuserextendedphoto_gxi());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedname(struct.getWwpuserextendedname());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname(struct.getWwpuserextendedfullname());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone(struct.getWwpuserextendedphone());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail(struct.getWwpuserextendedemail());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif(struct.getWwpuserextendedemainotif());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif(struct.getWwpuserextendedsmsnotif());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif(struct.getWwpuserextendedmobilenotif());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif(struct.getWwpuserextendeddesktopnotif());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted(struct.getWwpuserextendeddeleted());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin(struct.getWwpuserextendeddeletedin());
      setgxTv_SdtWWP_UserExtended_Mode(struct.getMode());
      setgxTv_SdtWWP_UserExtended_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z(struct.getWwpuserextendedid_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z(struct.getWwpuserextendedname_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z(struct.getWwpuserextendedfullname_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z(struct.getWwpuserextendedphone_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z(struct.getWwpuserextendedemail_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z(struct.getWwpuserextendedemainotif_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z(struct.getWwpuserextendedsmsnotif_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z(struct.getWwpuserextendedmobilenotif_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z(struct.getWwpuserextendeddesktopnotif_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z(struct.getWwpuserextendeddeleted_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z(struct.getWwpuserextendeddeletedin_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z(struct.getWwpuserextendedphoto_gxi_Z());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N(struct.getWwpuserextendedid_N());
      setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N(struct.getWwpuserextendeddeletedin_N());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtWWP_UserExtended getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtWWP_UserExtended struct = new com.mujermorena.wwpbaseobjects.StructSdtWWP_UserExtended ();
      struct.setWwpuserextendedid(getgxTv_SdtWWP_UserExtended_Wwpuserextendedid());
      struct.setWwpuserextendedphoto(getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto());
      struct.setWwpuserextendedphoto_gxi(getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi());
      struct.setWwpuserextendedname(getgxTv_SdtWWP_UserExtended_Wwpuserextendedname());
      struct.setWwpuserextendedfullname(getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname());
      struct.setWwpuserextendedphone(getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone());
      struct.setWwpuserextendedemail(getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail());
      struct.setWwpuserextendedemainotif(getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif());
      struct.setWwpuserextendedsmsnotif(getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif());
      struct.setWwpuserextendedmobilenotif(getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif());
      struct.setWwpuserextendeddesktopnotif(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif());
      struct.setWwpuserextendeddeleted(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted());
      struct.setWwpuserextendeddeletedin(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin());
      struct.setMode(getgxTv_SdtWWP_UserExtended_Mode());
      struct.setInitialized(getgxTv_SdtWWP_UserExtended_Initialized());
      struct.setWwpuserextendedid_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z());
      struct.setWwpuserextendedname_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z());
      struct.setWwpuserextendedfullname_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z());
      struct.setWwpuserextendedphone_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z());
      struct.setWwpuserextendedemail_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z());
      struct.setWwpuserextendedemainotif_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z());
      struct.setWwpuserextendedsmsnotif_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z());
      struct.setWwpuserextendedmobilenotif_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z());
      struct.setWwpuserextendeddesktopnotif_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z());
      struct.setWwpuserextendeddeleted_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z());
      struct.setWwpuserextendeddeletedin_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z());
      struct.setWwpuserextendedphoto_gxi_Z(getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z());
      struct.setWwpuserextendedid_N(getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N());
      struct.setWwpuserextendeddeletedin_N(getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N());
      return struct ;
   }

   private byte gxTv_SdtWWP_UserExtended_N ;
   private byte gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N ;
   private byte gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N ;
   private short gxTv_SdtWWP_UserExtended_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedid ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedphone ;
   private String gxTv_SdtWWP_UserExtended_Mode ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin ;
   private java.util.Date gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z ;
   private java.util.Date datetime_STZ ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z ;
   private boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedname ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedemail ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z ;
   private String gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto ;
}

