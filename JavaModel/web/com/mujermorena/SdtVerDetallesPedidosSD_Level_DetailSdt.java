package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtVerDetallesPedidosSD_Level_DetailSdt extends GxUserType
{
   public SdtVerDetallesPedidosSD_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtVerDetallesPedidosSD_Level_DetailSdt.class));
   }

   public SdtVerDetallesPedidosSD_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtVerDetallesPedidosSD_Level_DetailSdt");
   }

   public SdtVerDetallesPedidosSD_Level_DetailSdt( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtVerDetallesPedidosSD_Level_DetailSdt");
   }

   public SdtVerDetallesPedidosSD_Level_DetailSdt( StructSdtVerDetallesPedidosSD_Level_DetailSdt struct )
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
               gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid = (long)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Tipopagoid") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosimagencomprobante") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidosimagencomprobante_GXI") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pedidoscomprobanteobs") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdesc_tipopagoid") )
            {
               gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid = oReader.getValue() ;
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
         sName = "VerDetallesPedidosSD_Level_DetailSdt" ;
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
      oWriter.writeElement("Pedidosid", GXutil.trim( GXutil.str( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("Pedidosfecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Tipopagoid", GXutil.trim( GXutil.str( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Pedidosimagencomprobante", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Pedidosimagencomprobante_GXI", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Pedidoscomprobanteobs", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdesc_tipopagoid", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid);
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
      AddObjectProperty("Pedidosid", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Pedidosfecha", sDateCnv, false, false);
      AddObjectProperty("Tipopagoid", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid, false, false);
      AddObjectProperty("Pedidosimagencomprobante", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante, false, false);
      AddObjectProperty("Pedidosimagencomprobante_GXI", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi, false, false);
      AddObjectProperty("Pedidoscomprobanteobs", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs, false, false);
      AddObjectProperty("Gxdesc_tipopagoid", gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid, false, false);
   }

   public long getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid = value ;
   }

   public java.util.Date getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha( java.util.Date value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha = value ;
   }

   public long getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid = value ;
   }

   @GxUpload
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante = value ;
   }

   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi = value ;
   }

   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs = value ;
   }

   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid ;
   }

   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha = GXutil.nullDate() ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante = "" ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi = "" ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs = "" ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtVerDetallesPedidosSD_Level_DetailSdt struct )
   {
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid(struct.getPedidosid());
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha(struct.getPedidosfecha());
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid(struct.getTipopagoid());
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante(struct.getPedidosimagencomprobante());
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi(struct.getPedidosimagencomprobante_gxi());
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs(struct.getPedidoscomprobanteobs());
      setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid(struct.getGxdesc_tipopagoid());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtVerDetallesPedidosSD_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtVerDetallesPedidosSD_Level_DetailSdt struct = new com.mujermorena.StructSdtVerDetallesPedidosSD_Level_DetailSdt ();
      struct.setPedidosid(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid());
      struct.setPedidosfecha(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha());
      struct.setTipopagoid(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid());
      struct.setPedidosimagencomprobante(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante());
      struct.setPedidosimagencomprobante_gxi(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi());
      struct.setPedidoscomprobanteobs(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs());
      struct.setGxdesc_tipopagoid(getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid());
      return struct ;
   }

   protected byte gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante ;
}

