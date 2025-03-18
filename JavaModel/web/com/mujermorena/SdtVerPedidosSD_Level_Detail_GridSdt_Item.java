package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtVerPedidosSD_Level_Detail_GridSdt_Item extends GxUserType
{
   public SdtVerPedidosSD_Level_Detail_GridSdt_Item( )
   {
      this(  new ModelContext(SdtVerPedidosSD_Level_Detail_GridSdt_Item.class));
   }

   public SdtVerPedidosSD_Level_Detail_GridSdt_Item( ModelContext context )
   {
      super( context, "SdtVerPedidosSD_Level_Detail_GridSdt_Item");
   }

   public SdtVerPedidosSD_Level_Detail_GridSdt_Item( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtVerPedidosSD_Level_Detail_GridSdt_Item");
   }

   public SdtVerPedidosSD_Level_Detail_GridSdt_Item( StructSdtVerPedidosSD_Level_Detail_GridSdt_Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosid") )
            {
               gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosfecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidostotal") )
            {
               gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "VerPedidosSD_Level_Detail_GridSdt.Item" ;
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
      oWriter.writeElement("Pedidosid", GXutil.trim( GXutil.str( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("Pedidosfecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Pedidostotal", GXutil.trim( GXutil.strNoRound( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal, 17, 2)));
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
      AddObjectProperty("Pedidosid", gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Pedidosfecha", sDateCnv, false, false);
      AddObjectProperty("Pedidostotal", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal, 17, 2)), false, false);
   }

   public long getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid ;
   }

   public void setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid( long value )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid = value ;
   }

   public java.util.Date getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha ;
   }

   public void setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha( java.util.Date value )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha = value ;
   }

   public java.math.BigDecimal getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal ;
   }

   public void setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal( java.math.BigDecimal value )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(1) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha = GXutil.nullDate() ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N ;
   }

   public com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item Clone( )
   {
      return (com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtVerPedidosSD_Level_Detail_GridSdt_Item struct )
   {
      setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid(struct.getPedidosid());
      setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha(struct.getPedidosfecha());
      setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal(struct.getPedidostotal());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtVerPedidosSD_Level_Detail_GridSdt_Item getStruct( )
   {
      com.mujermorena.StructSdtVerPedidosSD_Level_Detail_GridSdt_Item struct = new com.mujermorena.StructSdtVerPedidosSD_Level_Detail_GridSdt_Item ();
      struct.setPedidosid(getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid());
      struct.setPedidosfecha(getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha());
      struct.setPedidostotal(getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal());
      return struct ;
   }

   protected byte gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid ;
   protected java.math.BigDecimal gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha ;
   protected boolean readElement ;
   protected boolean formatError ;
}

