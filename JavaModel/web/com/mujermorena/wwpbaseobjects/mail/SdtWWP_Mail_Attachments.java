package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_Mail_Attachments extends GxSilentTrnSdt
{
   public SdtWWP_Mail_Attachments( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_Mail_Attachments.class));
   }

   public SdtWWP_Mail_Attachments( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_Mail_Attachments");
      initialize( remoteHandle) ;
   }

   public SdtWWP_Mail_Attachments( int remoteHandle ,
                                   StructSdtWWP_Mail_Attachments struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtWWP_Mail_Attachments( )
   {
      super( new ModelContext(SdtWWP_Mail_Attachments.class), "SdtWWP_Mail_Attachments");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPMailAttachmentName", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Attachments");
      metadata.set("BT", "WWP_MailAttachments");
      metadata.set("PK", "[ \"WWPMailAttachmentName\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"WWPMailId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailAttachmentName") )
            {
               gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailAttachmentFile") )
            {
               gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_Mail_Attachments_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtWWP_Mail_Attachments_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_Mail_Attachments_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPMailAttachmentName_Z") )
            {
               gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z = oReader.getValue() ;
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
         sName = "WWP_Mail.Attachments" ;
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
      oWriter.writeElement("WWPMailAttachmentName", gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPMailAttachmentFile", gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_Mail_Attachments_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Attachments_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_Mail_Attachments_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPMailAttachmentName_Z", gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z);
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
      AddObjectProperty("WWPMailAttachmentName", gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname, false, includeNonInitialized);
      AddObjectProperty("WWPMailAttachmentFile", gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_Mail_Attachments_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtWWP_Mail_Attachments_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_Mail_Attachments_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPMailAttachmentName_Z", gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments sdt )
   {
      if ( sdt.IsDirty("WWPMailAttachmentName") )
      {
         gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname = sdt.getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname() ;
      }
      if ( sdt.IsDirty("WWPMailAttachmentFile") )
      {
         gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
         gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile = sdt.getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile() ;
      }
   }

   public String getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Modified = (short)(1) ;
      SetDirty("Wwpmailattachmentname");
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname = value ;
   }

   public String getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Modified = (short)(1) ;
      SetDirty("Wwpmailattachmentfile");
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile = value ;
   }

   public String getgxTv_SdtWWP_Mail_Attachments_Mode( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Mode ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Mode( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_Mail_Attachments_Mode = value ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Mode_SetNull( )
   {
      gxTv_SdtWWP_Mail_Attachments_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_Mail_Attachments_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Mail_Attachments_Modified( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Modified ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Modified( short value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtWWP_Mail_Attachments_Modified = value ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Modified_SetNull( )
   {
      gxTv_SdtWWP_Mail_Attachments_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtWWP_Mail_Attachments_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Mail_Attachments_Initialized( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Initialized ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Initialized( short value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_Mail_Attachments_Initialized = value ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Initialized_SetNull( )
   {
      gxTv_SdtWWP_Mail_Attachments_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_Mail_Attachments_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Modified = (short)(1) ;
      SetDirty("Wwpmailattachmentname_Z");
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z = value ;
   }

   public void setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z_SetNull( )
   {
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z = "" ;
      SetDirty("Wwpmailattachmentname_Z");
   }

   public boolean getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname = "" ;
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile = "" ;
      gxTv_SdtWWP_Mail_Attachments_Mode = "" ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_Mail_Attachments_N ;
   }

   public com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments struct )
   {
      setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname(struct.getWwpmailattachmentname());
      setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile(struct.getWwpmailattachmentfile());
      setgxTv_SdtWWP_Mail_Attachments_Mode(struct.getMode());
      setgxTv_SdtWWP_Mail_Attachments_Modified(struct.getModified());
      setgxTv_SdtWWP_Mail_Attachments_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z(struct.getWwpmailattachmentname_Z());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments getStruct( )
   {
      com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments struct = new com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments ();
      struct.setWwpmailattachmentname(getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname());
      struct.setWwpmailattachmentfile(getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile());
      struct.setMode(getgxTv_SdtWWP_Mail_Attachments_Mode());
      struct.setModified(getgxTv_SdtWWP_Mail_Attachments_Modified());
      struct.setInitialized(getgxTv_SdtWWP_Mail_Attachments_Initialized());
      struct.setWwpmailattachmentname_Z(getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z());
      return struct ;
   }

   private byte gxTv_SdtWWP_Mail_Attachments_N ;
   private short gxTv_SdtWWP_Mail_Attachments_Modified ;
   private short gxTv_SdtWWP_Mail_Attachments_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtWWP_Mail_Attachments_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile ;
   private String gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname ;
   private String gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z ;
}

