package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_Entity extends GxSilentTrnSdt
{
   public SdtWWP_Entity( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_Entity.class));
   }

   public SdtWWP_Entity( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_Entity");
      initialize( remoteHandle) ;
   }

   public SdtWWP_Entity( int remoteHandle ,
                         StructSdtWWP_Entity struct )
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

   public void Load( long AV33WWPEntityId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV33WWPEntityId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPEntityId", long.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\WWP_Entity");
      metadata.set("BT", "WWP_Entity");
      metadata.set("PK", "[ \"WWPEntityId\" ]");
      metadata.set("PKAssigned", "[ \"WWPEntityId\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityId") )
            {
               gxTv_SdtWWP_Entity_Wwpentityid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityName") )
            {
               gxTv_SdtWWP_Entity_Wwpentityname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_Entity_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_Entity_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityId_Z") )
            {
               gxTv_SdtWWP_Entity_Wwpentityid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPEntityName_Z") )
            {
               gxTv_SdtWWP_Entity_Wwpentityname_Z = oReader.getValue() ;
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
         sName = "WWP_Entity" ;
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
      oWriter.writeElement("WWPEntityId", GXutil.trim( GXutil.str( gxTv_SdtWWP_Entity_Wwpentityid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("WWPEntityName", gxTv_SdtWWP_Entity_Wwpentityname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_Entity_Mode);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_Entity_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPEntityId_Z", GXutil.trim( GXutil.str( gxTv_SdtWWP_Entity_Wwpentityid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         oWriter.writeElement("WWPEntityName_Z", gxTv_SdtWWP_Entity_Wwpentityname_Z);
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
      AddObjectProperty("WWPEntityId", gxTv_SdtWWP_Entity_Wwpentityid, false, includeNonInitialized);
      AddObjectProperty("WWPEntityName", gxTv_SdtWWP_Entity_Wwpentityname, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_Entity_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_Entity_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPEntityId_Z", gxTv_SdtWWP_Entity_Wwpentityid_Z, false, includeNonInitialized);
         AddObjectProperty("WWPEntityName_Z", gxTv_SdtWWP_Entity_Wwpentityname_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.mujermorena.wwpbaseobjects.SdtWWP_Entity sdt )
   {
      if ( sdt.IsDirty("WWPEntityId") )
      {
         gxTv_SdtWWP_Entity_N = (byte)(0) ;
         gxTv_SdtWWP_Entity_Wwpentityid = sdt.getgxTv_SdtWWP_Entity_Wwpentityid() ;
      }
      if ( sdt.IsDirty("WWPEntityName") )
      {
         gxTv_SdtWWP_Entity_N = (byte)(0) ;
         gxTv_SdtWWP_Entity_Wwpentityname = sdt.getgxTv_SdtWWP_Entity_Wwpentityname() ;
      }
   }

   public long getgxTv_SdtWWP_Entity_Wwpentityid( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityid ;
   }

   public void setgxTv_SdtWWP_Entity_Wwpentityid( long value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      if ( gxTv_SdtWWP_Entity_Wwpentityid != value )
      {
         gxTv_SdtWWP_Entity_Mode = "INS" ;
         this.setgxTv_SdtWWP_Entity_Wwpentityid_Z_SetNull( );
         this.setgxTv_SdtWWP_Entity_Wwpentityname_Z_SetNull( );
      }
      SetDirty("Wwpentityid");
      gxTv_SdtWWP_Entity_Wwpentityid = value ;
   }

   public String getgxTv_SdtWWP_Entity_Wwpentityname( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityname ;
   }

   public void setgxTv_SdtWWP_Entity_Wwpentityname( String value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      SetDirty("Wwpentityname");
      gxTv_SdtWWP_Entity_Wwpentityname = value ;
   }

   public String getgxTv_SdtWWP_Entity_Mode( )
   {
      return gxTv_SdtWWP_Entity_Mode ;
   }

   public void setgxTv_SdtWWP_Entity_Mode( String value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_Entity_Mode = value ;
   }

   public void setgxTv_SdtWWP_Entity_Mode_SetNull( )
   {
      gxTv_SdtWWP_Entity_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_Entity_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Entity_Initialized( )
   {
      return gxTv_SdtWWP_Entity_Initialized ;
   }

   public void setgxTv_SdtWWP_Entity_Initialized( short value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_Entity_Initialized = value ;
   }

   public void setgxTv_SdtWWP_Entity_Initialized_SetNull( )
   {
      gxTv_SdtWWP_Entity_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_Entity_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtWWP_Entity_Wwpentityid_Z( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityid_Z ;
   }

   public void setgxTv_SdtWWP_Entity_Wwpentityid_Z( long value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      SetDirty("Wwpentityid_Z");
      gxTv_SdtWWP_Entity_Wwpentityid_Z = value ;
   }

   public void setgxTv_SdtWWP_Entity_Wwpentityid_Z_SetNull( )
   {
      gxTv_SdtWWP_Entity_Wwpentityid_Z = 0 ;
      SetDirty("Wwpentityid_Z");
   }

   public boolean getgxTv_SdtWWP_Entity_Wwpentityid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Entity_Wwpentityname_Z( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityname_Z ;
   }

   public void setgxTv_SdtWWP_Entity_Wwpentityname_Z( String value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      SetDirty("Wwpentityname_Z");
      gxTv_SdtWWP_Entity_Wwpentityname_Z = value ;
   }

   public void setgxTv_SdtWWP_Entity_Wwpentityname_Z_SetNull( )
   {
      gxTv_SdtWWP_Entity_Wwpentityname_Z = "" ;
      SetDirty("Wwpentityname_Z");
   }

   public boolean getgxTv_SdtWWP_Entity_Wwpentityname_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.mujermorena.wwpbaseobjects.wwp_entity_bc obj;
      obj = new com.mujermorena.wwpbaseobjects.wwp_entity_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_Entity_N = (byte)(1) ;
      gxTv_SdtWWP_Entity_Wwpentityname = "" ;
      gxTv_SdtWWP_Entity_Mode = "" ;
      gxTv_SdtWWP_Entity_Wwpentityname_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_Entity_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtWWP_Entity Clone( )
   {
      com.mujermorena.wwpbaseobjects.SdtWWP_Entity sdt;
      com.mujermorena.wwpbaseobjects.wwp_entity_bc obj;
      sdt = (com.mujermorena.wwpbaseobjects.SdtWWP_Entity)(clone()) ;
      obj = (com.mujermorena.wwpbaseobjects.wwp_entity_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtWWP_Entity struct )
   {
      setgxTv_SdtWWP_Entity_Wwpentityid(struct.getWwpentityid());
      setgxTv_SdtWWP_Entity_Wwpentityname(struct.getWwpentityname());
      setgxTv_SdtWWP_Entity_Mode(struct.getMode());
      setgxTv_SdtWWP_Entity_Initialized(struct.getInitialized());
      setgxTv_SdtWWP_Entity_Wwpentityid_Z(struct.getWwpentityid_Z());
      setgxTv_SdtWWP_Entity_Wwpentityname_Z(struct.getWwpentityname_Z());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtWWP_Entity getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtWWP_Entity struct = new com.mujermorena.wwpbaseobjects.StructSdtWWP_Entity ();
      struct.setWwpentityid(getgxTv_SdtWWP_Entity_Wwpentityid());
      struct.setWwpentityname(getgxTv_SdtWWP_Entity_Wwpentityname());
      struct.setMode(getgxTv_SdtWWP_Entity_Mode());
      struct.setInitialized(getgxTv_SdtWWP_Entity_Initialized());
      struct.setWwpentityid_Z(getgxTv_SdtWWP_Entity_Wwpentityid_Z());
      struct.setWwpentityname_Z(getgxTv_SdtWWP_Entity_Wwpentityname_Z());
      return struct ;
   }

   private byte gxTv_SdtWWP_Entity_N ;
   private short gxTv_SdtWWP_Entity_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtWWP_Entity_Wwpentityid ;
   private long gxTv_SdtWWP_Entity_Wwpentityid_Z ;
   private String gxTv_SdtWWP_Entity_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_Entity_Wwpentityname ;
   private String gxTv_SdtWWP_Entity_Wwpentityname_Z ;
}

