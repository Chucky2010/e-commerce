package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item extends GxUserType
{
   public SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item( )
   {
      this(  new ModelContext(SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item.class));
   }

   public SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item( ModelContext context )
   {
      super( context, "SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item");
   }

   public SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item( int remoteHandle ,
                                                             ModelContext context )
   {
      super( remoteHandle, context, "SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item");
   }

   public SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item( StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosdetalleid") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Articuloid") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Articulonombre") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosdetalletallaid") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosdetallecantidad") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "VerDetallesPedidosSD_Level_Detail_gridSdt.Item" ;
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
      oWriter.writeElement("Pedidosdetalleid", GXutil.trim( GXutil.str( gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Articuloid", GXutil.trim( GXutil.str( gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Articulonombre", gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Pedidosdetalletallaid", GXutil.trim( GXutil.str( gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Pedidosdetallecantidad", GXutil.trim( GXutil.str( gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad, 5, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
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
      AddObjectProperty("Pedidosdetalleid", gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid, false, false);
      AddObjectProperty("Articuloid", gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid, false, false);
      AddObjectProperty("Articulonombre", gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre, false, false);
      AddObjectProperty("Pedidosdetalletallaid", gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid, false, false);
      AddObjectProperty("Pedidosdetallecantidad", gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad, false, false);
   }

   public long getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid = value ;
   }

   public long getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid = value ;
   }

   public String getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre = value ;
   }

   public long getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid = value ;
   }

   public int getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad( int value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(1) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N ;
   }

   public com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item Clone( )
   {
      return (com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item struct )
   {
      setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid(struct.getPedidosdetalleid());
      setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid(struct.getArticuloid());
      setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre(struct.getArticulonombre());
      setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid(struct.getPedidosdetalletallaid());
      setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad(struct.getPedidosdetallecantidad());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item getStruct( )
   {
      com.mujermorena.StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item struct = new com.mujermorena.StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item ();
      struct.setPedidosdetalleid(getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid());
      struct.setArticuloid(getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid());
      struct.setArticulonombre(getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre());
      struct.setPedidosdetalletallaid(getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid());
      struct.setPedidosdetallecantidad(getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad());
      return struct ;
   }

   protected byte gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

