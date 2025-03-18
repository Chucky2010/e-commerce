package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLaunchpadOptions_Option extends GxUserType
{
   public SdtLaunchpadOptions_Option( )
   {
      this(  new ModelContext(SdtLaunchpadOptions_Option.class));
   }

   public SdtLaunchpadOptions_Option( ModelContext context )
   {
      super( context, "SdtLaunchpadOptions_Option");
   }

   public SdtLaunchpadOptions_Option( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtLaunchpadOptions_Option");
   }

   public SdtLaunchpadOptions_Option( StructSdtLaunchpadOptions_Option struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtLaunchpadOptions_Option_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtLaunchpadOptions_Option_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Information") )
            {
               gxTv_SdtLaunchpadOptions_Option_Information = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtLaunchpadOptions_Option_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon") )
            {
               gxTv_SdtLaunchpadOptions_Option_Icon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon_GXI") )
            {
               gxTv_SdtLaunchpadOptions_Option_Icon_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OrderIndex") )
            {
               gxTv_SdtLaunchpadOptions_Option_Orderindex = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TileSize") )
            {
               gxTv_SdtLaunchpadOptions_Option_Tilesize = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TileType") )
            {
               gxTv_SdtLaunchpadOptions_Option_Tiletype = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "LaunchpadOptions.Option" ;
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
      oWriter.writeElement("Name", gxTv_SdtLaunchpadOptions_Option_Name);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Description", gxTv_SdtLaunchpadOptions_Option_Description);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Information", gxTv_SdtLaunchpadOptions_Option_Information);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Link", gxTv_SdtLaunchpadOptions_Option_Link);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Icon", gxTv_SdtLaunchpadOptions_Option_Icon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Icon_GXI", gxTv_SdtLaunchpadOptions_Option_Icon_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("OrderIndex", GXutil.trim( GXutil.str( gxTv_SdtLaunchpadOptions_Option_Orderindex, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("TileSize", GXutil.trim( GXutil.str( gxTv_SdtLaunchpadOptions_Option_Tilesize, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("TileType", GXutil.trim( GXutil.str( gxTv_SdtLaunchpadOptions_Option_Tiletype, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
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
      AddObjectProperty("Name", gxTv_SdtLaunchpadOptions_Option_Name, false, false);
      AddObjectProperty("Description", gxTv_SdtLaunchpadOptions_Option_Description, false, false);
      AddObjectProperty("Information", gxTv_SdtLaunchpadOptions_Option_Information, false, false);
      AddObjectProperty("Link", gxTv_SdtLaunchpadOptions_Option_Link, false, false);
      AddObjectProperty("Icon", gxTv_SdtLaunchpadOptions_Option_Icon, false, false);
      AddObjectProperty("Icon_GXI", gxTv_SdtLaunchpadOptions_Option_Icon_gxi, false, false);
      AddObjectProperty("OrderIndex", gxTv_SdtLaunchpadOptions_Option_Orderindex, false, false);
      AddObjectProperty("TileSize", gxTv_SdtLaunchpadOptions_Option_Tilesize, false, false);
      AddObjectProperty("TileType", gxTv_SdtLaunchpadOptions_Option_Tiletype, false, false);
   }

   public String getgxTv_SdtLaunchpadOptions_Option_Name( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Name ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Name( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Name = value ;
   }

   public String getgxTv_SdtLaunchpadOptions_Option_Description( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Description ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Description( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Description = value ;
   }

   public String getgxTv_SdtLaunchpadOptions_Option_Information( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Information ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Information( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Information = value ;
   }

   public String getgxTv_SdtLaunchpadOptions_Option_Link( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Link ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Link( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Link = value ;
   }

   @GxUpload
   public String getgxTv_SdtLaunchpadOptions_Option_Icon( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Icon ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Icon( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Icon = value ;
   }

   public String getgxTv_SdtLaunchpadOptions_Option_Icon_gxi( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Icon_gxi ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Icon_gxi( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Icon_gxi = value ;
   }

   public int getgxTv_SdtLaunchpadOptions_Option_Orderindex( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Orderindex ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Orderindex( int value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Orderindex = value ;
   }

   public byte getgxTv_SdtLaunchpadOptions_Option_Tilesize( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Tilesize ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Tilesize( byte value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Tilesize = value ;
   }

   public byte getgxTv_SdtLaunchpadOptions_Option_Tiletype( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Tiletype ;
   }

   public void setgxTv_SdtLaunchpadOptions_Option_Tiletype( byte value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Tiletype = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLaunchpadOptions_Option_Name = "" ;
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(1) ;
      gxTv_SdtLaunchpadOptions_Option_Description = "" ;
      gxTv_SdtLaunchpadOptions_Option_Information = "" ;
      gxTv_SdtLaunchpadOptions_Option_Link = "" ;
      gxTv_SdtLaunchpadOptions_Option_Icon = "" ;
      gxTv_SdtLaunchpadOptions_Option_Icon_gxi = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLaunchpadOptions_Option_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtLaunchpadOptions_Option struct )
   {
      setgxTv_SdtLaunchpadOptions_Option_Name(struct.getName());
      setgxTv_SdtLaunchpadOptions_Option_Description(struct.getDescription());
      setgxTv_SdtLaunchpadOptions_Option_Information(struct.getInformation());
      setgxTv_SdtLaunchpadOptions_Option_Link(struct.getLink());
      setgxTv_SdtLaunchpadOptions_Option_Icon(struct.getIcon());
      setgxTv_SdtLaunchpadOptions_Option_Icon_gxi(struct.getIcon_gxi());
      setgxTv_SdtLaunchpadOptions_Option_Orderindex(struct.getOrderindex());
      setgxTv_SdtLaunchpadOptions_Option_Tilesize(struct.getTilesize());
      setgxTv_SdtLaunchpadOptions_Option_Tiletype(struct.getTiletype());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtLaunchpadOptions_Option getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtLaunchpadOptions_Option struct = new com.mujermorena.workwithplus.nativemobile.StructSdtLaunchpadOptions_Option ();
      struct.setName(getgxTv_SdtLaunchpadOptions_Option_Name());
      struct.setDescription(getgxTv_SdtLaunchpadOptions_Option_Description());
      struct.setInformation(getgxTv_SdtLaunchpadOptions_Option_Information());
      struct.setLink(getgxTv_SdtLaunchpadOptions_Option_Link());
      struct.setIcon(getgxTv_SdtLaunchpadOptions_Option_Icon());
      struct.setIcon_gxi(getgxTv_SdtLaunchpadOptions_Option_Icon_gxi());
      struct.setOrderindex(getgxTv_SdtLaunchpadOptions_Option_Orderindex());
      struct.setTilesize(getgxTv_SdtLaunchpadOptions_Option_Tilesize());
      struct.setTiletype(getgxTv_SdtLaunchpadOptions_Option_Tiletype());
      return struct ;
   }

   protected byte gxTv_SdtLaunchpadOptions_Option_N ;
   protected byte gxTv_SdtLaunchpadOptions_Option_Tilesize ;
   protected byte gxTv_SdtLaunchpadOptions_Option_Tiletype ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtLaunchpadOptions_Option_Orderindex ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtLaunchpadOptions_Option_Name ;
   protected String gxTv_SdtLaunchpadOptions_Option_Description ;
   protected String gxTv_SdtLaunchpadOptions_Option_Information ;
   protected String gxTv_SdtLaunchpadOptions_Option_Link ;
   protected String gxTv_SdtLaunchpadOptions_Option_Icon_gxi ;
   protected String gxTv_SdtLaunchpadOptions_Option_Icon ;
}

