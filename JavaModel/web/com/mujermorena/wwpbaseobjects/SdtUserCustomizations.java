package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtUserCustomizations extends GxSilentTrnSdt
{
   public SdtUserCustomizations( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtUserCustomizations.class));
   }

   public SdtUserCustomizations( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtUserCustomizations");
      initialize( remoteHandle) ;
   }

   public SdtUserCustomizations( int remoteHandle ,
                                 StructSdtUserCustomizations struct )
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

   public void Load( String AV44UserCustomizationsId ,
                     String AV45UserCustomizationsKey )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV44UserCustomizationsId,AV45UserCustomizationsKey});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"UserCustomizationsId", String.class}, new Object[]{"UserCustomizationsKey", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\UserCustomizations");
      metadata.set("BT", "UserCustomizations");
      metadata.set("PK", "[ \"UserCustomizationsId\",\"UserCustomizationsKey\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomizationsId") )
            {
               gxTv_SdtUserCustomizations_Usercustomizationsid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomizationsKey") )
            {
               gxTv_SdtUserCustomizations_Usercustomizationskey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomizationsValue") )
            {
               gxTv_SdtUserCustomizations_Usercustomizationsvalue = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtUserCustomizations_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtUserCustomizations_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomizationsId_Z") )
            {
               gxTv_SdtUserCustomizations_Usercustomizationsid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomizationsKey_Z") )
            {
               gxTv_SdtUserCustomizations_Usercustomizationskey_Z = oReader.getValue() ;
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
         sName = "UserCustomizations" ;
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
      oWriter.writeElement("UserCustomizationsId", gxTv_SdtUserCustomizations_Usercustomizationsid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("UserCustomizationsKey", gxTv_SdtUserCustomizations_Usercustomizationskey);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("UserCustomizationsValue", gxTv_SdtUserCustomizations_Usercustomizationsvalue);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtUserCustomizations_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtUserCustomizations_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("UserCustomizationsId_Z", gxTv_SdtUserCustomizations_Usercustomizationsid_Z);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("UserCustomizationsKey_Z", gxTv_SdtUserCustomizations_Usercustomizationskey_Z);
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
      AddObjectProperty("UserCustomizationsId", gxTv_SdtUserCustomizations_Usercustomizationsid, false, includeNonInitialized);
      AddObjectProperty("UserCustomizationsKey", gxTv_SdtUserCustomizations_Usercustomizationskey, false, includeNonInitialized);
      AddObjectProperty("UserCustomizationsValue", gxTv_SdtUserCustomizations_Usercustomizationsvalue, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtUserCustomizations_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtUserCustomizations_Initialized, false, includeNonInitialized);
         AddObjectProperty("UserCustomizationsId_Z", gxTv_SdtUserCustomizations_Usercustomizationsid_Z, false, includeNonInitialized);
         AddObjectProperty("UserCustomizationsKey_Z", gxTv_SdtUserCustomizations_Usercustomizationskey_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.SdtUserCustomizations sdt )
   {
      if ( sdt.IsDirty("UserCustomizationsId") )
      {
         gxTv_SdtUserCustomizations_N = (byte)(0) ;
         gxTv_SdtUserCustomizations_Usercustomizationsid = sdt.getgxTv_SdtUserCustomizations_Usercustomizationsid() ;
      }
      if ( sdt.IsDirty("UserCustomizationsKey") )
      {
         gxTv_SdtUserCustomizations_N = (byte)(0) ;
         gxTv_SdtUserCustomizations_Usercustomizationskey = sdt.getgxTv_SdtUserCustomizations_Usercustomizationskey() ;
      }
      if ( sdt.IsDirty("UserCustomizationsValue") )
      {
         gxTv_SdtUserCustomizations_N = (byte)(0) ;
         gxTv_SdtUserCustomizations_Usercustomizationsvalue = sdt.getgxTv_SdtUserCustomizations_Usercustomizationsvalue() ;
      }
   }

   public String getgxTv_SdtUserCustomizations_Usercustomizationsid( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationsid ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationsid( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtUserCustomizations_Usercustomizationsid, value) != 0 )
      {
         gxTv_SdtUserCustomizations_Mode = "INS" ;
         this.setgxTv_SdtUserCustomizations_Usercustomizationsid_Z_SetNull( );
         this.setgxTv_SdtUserCustomizations_Usercustomizationskey_Z_SetNull( );
      }
      SetDirty("Usercustomizationsid");
      gxTv_SdtUserCustomizations_Usercustomizationsid = value ;
   }

   public String getgxTv_SdtUserCustomizations_Usercustomizationskey( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationskey ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationskey( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtUserCustomizations_Usercustomizationskey, value) != 0 )
      {
         gxTv_SdtUserCustomizations_Mode = "INS" ;
         this.setgxTv_SdtUserCustomizations_Usercustomizationsid_Z_SetNull( );
         this.setgxTv_SdtUserCustomizations_Usercustomizationskey_Z_SetNull( );
      }
      SetDirty("Usercustomizationskey");
      gxTv_SdtUserCustomizations_Usercustomizationskey = value ;
   }

   public String getgxTv_SdtUserCustomizations_Usercustomizationsvalue( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationsvalue ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationsvalue( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      SetDirty("Usercustomizationsvalue");
      gxTv_SdtUserCustomizations_Usercustomizationsvalue = value ;
   }

   public String getgxTv_SdtUserCustomizations_Mode( )
   {
      return gxTv_SdtUserCustomizations_Mode ;
   }

   public void setgxTv_SdtUserCustomizations_Mode( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtUserCustomizations_Mode = value ;
   }

   public void setgxTv_SdtUserCustomizations_Mode_SetNull( )
   {
      gxTv_SdtUserCustomizations_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtUserCustomizations_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtUserCustomizations_Initialized( )
   {
      return gxTv_SdtUserCustomizations_Initialized ;
   }

   public void setgxTv_SdtUserCustomizations_Initialized( short value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtUserCustomizations_Initialized = value ;
   }

   public void setgxTv_SdtUserCustomizations_Initialized_SetNull( )
   {
      gxTv_SdtUserCustomizations_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtUserCustomizations_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtUserCustomizations_Usercustomizationsid_Z( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationsid_Z ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationsid_Z( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      SetDirty("Usercustomizationsid_Z");
      gxTv_SdtUserCustomizations_Usercustomizationsid_Z = value ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationsid_Z_SetNull( )
   {
      gxTv_SdtUserCustomizations_Usercustomizationsid_Z = "" ;
      SetDirty("Usercustomizationsid_Z");
   }

   public boolean getgxTv_SdtUserCustomizations_Usercustomizationsid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtUserCustomizations_Usercustomizationskey_Z( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationskey_Z ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationskey_Z( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      SetDirty("Usercustomizationskey_Z");
      gxTv_SdtUserCustomizations_Usercustomizationskey_Z = value ;
   }

   public void setgxTv_SdtUserCustomizations_Usercustomizationskey_Z_SetNull( )
   {
      gxTv_SdtUserCustomizations_Usercustomizationskey_Z = "" ;
      SetDirty("Usercustomizationskey_Z");
   }

   public boolean getgxTv_SdtUserCustomizations_Usercustomizationskey_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.usercustomizations_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.usercustomizations_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtUserCustomizations_Usercustomizationsid = "" ;
      gxTv_SdtUserCustomizations_N = (byte)(1) ;
      gxTv_SdtUserCustomizations_Usercustomizationskey = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationsvalue = "" ;
      gxTv_SdtUserCustomizations_Mode = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationsid_Z = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationskey_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtUserCustomizations_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtUserCustomizations Clone( )
   {
      com.mujermorena.wwpbaseobjects.SdtUserCustomizations sdt;
      com.mujermorena.wwpbaseobjects.usercustomizations_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.SdtUserCustomizations)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.usercustomizations_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtUserCustomizations struct )
   {
      setgxTv_SdtUserCustomizations_Usercustomizationsid(struct.getUsercustomizationsid());
      setgxTv_SdtUserCustomizations_Usercustomizationskey(struct.getUsercustomizationskey());
      setgxTv_SdtUserCustomizations_Usercustomizationsvalue(struct.getUsercustomizationsvalue());
      setgxTv_SdtUserCustomizations_Mode(struct.getMode());
      setgxTv_SdtUserCustomizations_Initialized(struct.getInitialized());
      setgxTv_SdtUserCustomizations_Usercustomizationsid_Z(struct.getUsercustomizationsid_Z());
      setgxTv_SdtUserCustomizations_Usercustomizationskey_Z(struct.getUsercustomizationskey_Z());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtUserCustomizations getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtUserCustomizations struct = new com.mujermorena.wwpbaseobjects.StructSdtUserCustomizations ();
      struct.setUsercustomizationsid(getgxTv_SdtUserCustomizations_Usercustomizationsid());
      struct.setUsercustomizationskey(getgxTv_SdtUserCustomizations_Usercustomizationskey());
      struct.setUsercustomizationsvalue(getgxTv_SdtUserCustomizations_Usercustomizationsvalue());
      struct.setMode(getgxTv_SdtUserCustomizations_Mode());
      struct.setInitialized(getgxTv_SdtUserCustomizations_Initialized());
      struct.setUsercustomizationsid_Z(getgxTv_SdtUserCustomizations_Usercustomizationsid_Z());
      struct.setUsercustomizationskey_Z(getgxTv_SdtUserCustomizations_Usercustomizationskey_Z());
      return struct ;
   }

   private byte gxTv_SdtUserCustomizations_N ;
   private short gxTv_SdtUserCustomizations_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtUserCustomizations_Usercustomizationsid ;
   private String gxTv_SdtUserCustomizations_Mode ;
   private String gxTv_SdtUserCustomizations_Usercustomizationsid_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtUserCustomizations_Usercustomizationsvalue ;
   private String gxTv_SdtUserCustomizations_Usercustomizationskey ;
   private String gxTv_SdtUserCustomizations_Usercustomizationskey_Z ;
}

