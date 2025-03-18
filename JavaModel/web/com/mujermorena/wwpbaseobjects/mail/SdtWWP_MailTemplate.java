package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_MailTemplate extends GxSilentTrnSdt
{
   public SdtWWP_MailTemplate( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_MailTemplate.class));
   }

   public SdtWWP_MailTemplate( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_MailTemplate");
      initialize( remoteHandle) ;
   }

   public SdtWWP_MailTemplate( int remoteHandle ,
                               StructSdtWWP_MailTemplate struct )
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

   public void Load( String AV41WWPMailTemplateName )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV41WWPMailTemplateName});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPMailTemplateName", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\Mail\\WWP_MailTemplate");
      metadata.set("BT", "WWP_MailTemplate");
      metadata.set("PK", "[ \"WWPMailTemplateName\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateName") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateDescription") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateSubject") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateBody") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateSenderAddress") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateSenderName") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_MailTemplate_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_MailTemplate_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateName_Z") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateDescription_Z") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailTemplateSubject_Z") )
            {
               gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z = oReader.getValue() ;
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
         sName = "WWP_MailTemplate" ;
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
      oWriter.writeElement("WWPMailTemplateName", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailTemplateDescription", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailTemplateSubject", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailTemplateBody", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailTemplateSenderAddress", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailTemplateSenderName", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_MailTemplate_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_MailTemplate_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailTemplateName_Z", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailTemplateDescription_Z", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailTemplateSubject_Z", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z);
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
      AddObjectProperty("WWPMailTemplateName", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename, false, includeNonInitialized);
      AddObjectProperty("WWPMailTemplateDescription", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription, false, includeNonInitialized);
      AddObjectProperty("WWPMailTemplateSubject", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject, false, includeNonInitialized);
      AddObjectProperty("WWPMailTemplateBody", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody, false, includeNonInitialized);
      AddObjectProperty("WWPMailTemplateSenderAddress", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress, false, includeNonInitialized);
      AddObjectProperty("WWPMailTemplateSenderName", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_MailTemplate_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_MailTemplate_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPMailTemplateName_Z", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z, false, includeNonInitialized);
         AddObjectProperty("WWPMailTemplateDescription_Z", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPMailTemplateSubject_Z", gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate sdt )
   {
      if ( sdt.IsDirty("WWPMailTemplateName") )
      {
         gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
         gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename = sdt.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename() ;
      }
      if ( sdt.IsDirty("WWPMailTemplateDescription") )
      {
         gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
         gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription = sdt.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription() ;
      }
      if ( sdt.IsDirty("WWPMailTemplateSubject") )
      {
         gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
         gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject = sdt.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject() ;
      }
      if ( sdt.IsDirty("WWPMailTemplateBody") )
      {
         gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
         gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody = sdt.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody() ;
      }
      if ( sdt.IsDirty("WWPMailTemplateSenderAddress") )
      {
         gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
         gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress = sdt.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress() ;
      }
      if ( sdt.IsDirty("WWPMailTemplateSenderName") )
      {
         gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
         gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername = sdt.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername() ;
      }
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename, value) != 0 )
      {
         gxTv_SdtWWP_MailTemplate_Mode = "INS" ;
         this.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z_SetNull( );
         this.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z_SetNull( );
         this.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z_SetNull( );
      }
      SetDirty("Wwpmailtemplatename");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename = value ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatedescription");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription = value ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatesubject");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject = value ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatebody");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody = value ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatesenderaddress");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress = value ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatesendername");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername = value ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Mode( )
   {
      return gxTv_SdtWWP_MailTemplate_Mode ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Mode( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_MailTemplate_Mode = value ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Mode_SetNull( )
   {
      gxTv_SdtWWP_MailTemplate_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_MailTemplate_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_MailTemplate_Initialized( )
   {
      return gxTv_SdtWWP_MailTemplate_Initialized ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Initialized( short value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_MailTemplate_Initialized = value ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Initialized_SetNull( )
   {
      gxTv_SdtWWP_MailTemplate_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_MailTemplate_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatename_Z");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z = value ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z_SetNull( )
   {
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z = "" ;
      SetDirty("Wwpmailtemplatename_Z");
   }

   public boolean getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatedescription_Z");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z = value ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z_SetNull( )
   {
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z = "" ;
      SetDirty("Wwpmailtemplatedescription_Z");
   }

   public boolean getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      SetDirty("Wwpmailtemplatesubject_Z");
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z = value ;
   }

   public void setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z_SetNull( )
   {
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z = "" ;
      SetDirty("Wwpmailtemplatesubject_Z");
   }

   public boolean getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename = "" ;
      gxTv_SdtWWP_MailTemplate_N = (byte)(1) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername = "" ;
      gxTv_SdtWWP_MailTemplate_Mode = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_MailTemplate_N ;
   }

   public com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate Clone( )
   {
      com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate sdt;
      com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_MailTemplate struct )
   {
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename(struct.getWwpmailtemplatename());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription(struct.getWwpmailtemplatedescription());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject(struct.getWwpmailtemplatesubject());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody(struct.getWwpmailtemplatebody());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress(struct.getWwpmailtemplatesenderaddress());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername(struct.getWwpmailtemplatesendername());
      setgxTv_SdtWWP_MailTemplate_Mode(struct.getMode());
      setgxTv_SdtWWP_MailTemplate_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z(struct.getWwpmailtemplatename_Z());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z(struct.getWwpmailtemplatedescription_Z());
      setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z(struct.getWwpmailtemplatesubject_Z());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_MailTemplate getStruct( )
   {
      com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_MailTemplate struct = new com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_MailTemplate ();
      struct.setWwpmailtemplatename(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename());
      struct.setWwpmailtemplatedescription(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription());
      struct.setWwpmailtemplatesubject(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject());
      struct.setWwpmailtemplatebody(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody());
      struct.setWwpmailtemplatesenderaddress(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress());
      struct.setWwpmailtemplatesendername(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername());
      struct.setMode(getgxTv_SdtWWP_MailTemplate_Mode());
      struct.setInitialized(getgxTv_SdtWWP_MailTemplate_Initialized());
      struct.setWwpmailtemplatename_Z(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z());
      struct.setWwpmailtemplatedescription_Z(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z());
      struct.setWwpmailtemplatesubject_Z(getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z());
      return struct ;
   }

   private byte gxTv_SdtWWP_MailTemplate_N ;
   private short gxTv_SdtWWP_MailTemplate_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtWWP_MailTemplate_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z ;
   private String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z ;
}

