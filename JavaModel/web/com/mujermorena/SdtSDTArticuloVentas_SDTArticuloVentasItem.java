package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTArticuloVentas_SDTArticuloVentasItem extends GxUserType
{
   public SdtSDTArticuloVentas_SDTArticuloVentasItem( )
   {
      this(  new ModelContext(SdtSDTArticuloVentas_SDTArticuloVentasItem.class));
   }

   public SdtSDTArticuloVentas_SDTArticuloVentasItem( ModelContext context )
   {
      super( context, "SdtSDTArticuloVentas_SDTArticuloVentasItem");
   }

   public SdtSDTArticuloVentas_SDTArticuloVentasItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTArticuloVentas_SDTArticuloVentasItem");
   }

   public SdtSDTArticuloVentas_SDTArticuloVentasItem( StructSdtSDTArticuloVentas_SDTArticuloVentasItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArticuloID") )
            {
               gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArticuloNombre") )
            {
               gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CantidadVendida") )
            {
               gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SDTArticuloVentas.SDTArticuloVentasItem" ;
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
      oWriter.writeElement("ArticuloID", GXutil.trim( GXutil.str( gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ArticuloNombre", gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CantidadVendida", GXutil.trim( GXutil.str( gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida, 4, 0)));
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
      AddObjectProperty("ArticuloID", gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid, false, false);
      AddObjectProperty("ArticuloNombre", gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre, false, false);
      AddObjectProperty("CantidadVendida", gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida, false, false);
   }

   public long getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid ;
   }

   public void setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid( long value )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(0) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid = value ;
   }

   public String getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre ;
   }

   public void setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre( String value )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(0) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre = value ;
   }

   public short getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida ;
   }

   public void setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida( short value )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(0) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(1) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N ;
   }

   public com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem Clone( )
   {
      return (com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtSDTArticuloVentas_SDTArticuloVentasItem struct )
   {
      setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid(struct.getArticuloid());
      setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre(struct.getArticulonombre());
      setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida(struct.getCantidadvendida());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtSDTArticuloVentas_SDTArticuloVentasItem getStruct( )
   {
      com.mujermorena.StructSdtSDTArticuloVentas_SDTArticuloVentasItem struct = new com.mujermorena.StructSdtSDTArticuloVentas_SDTArticuloVentasItem ();
      struct.setArticuloid(getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid());
      struct.setArticulonombre(getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre());
      struct.setCantidadvendida(getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida());
      return struct ;
   }

   protected byte gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N ;
   protected short gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid ;
   protected String gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

