package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "VerDetallesPedidosSD_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtVerDetallesPedidosSD_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt>
{
   public SdtVerDetallesPedidosSD_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt ());
   }

   public SdtVerDetallesPedidosSD_Level_DetailSdt_RESTInterface( com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Pedidosid")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid(), 11, 0)) ;
   }

   @JsonProperty("Pedidosid")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid(  String Value )
   {
      sdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid( GXutil.lval( Value) );
   }


   @JsonProperty("Pedidosfecha")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha( )
   {
      return GXutil.dateToCharREST( sdt.getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha()) ;
   }

   @JsonProperty("Pedidosfecha")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha(  String Value )
   {
      sdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha( GXutil.charToDateREST( Value) );
   }


   @JsonProperty("Tipopagoid")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid(), 11, 0)) ;
   }

   @JsonProperty("Tipopagoid")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid(  String Value )
   {
      sdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid( GXutil.lval( Value) );
   }


   @JsonProperty("Pedidosimagencomprobante")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante( )
   {
      if ( GXutil.strcmp(((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante(), "") != 0 )
      {
         return GXutil.getRelativeURL(((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante()) ;
      }
      else
      {
         return GXutil.rtrim(((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi()) ;
      }
   }

   @JsonProperty("Pedidosimagencomprobante")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante(  String Value )
   {
      ((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante(Value);
   }


   @JsonProperty("Pedidoscomprobanteobs")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs()) ;
   }

   @JsonProperty("Pedidoscomprobanteobs")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs(  String Value )
   {
      ((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs(Value);
   }


   @JsonProperty("Gxdesc_tipopagoid")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid()) ;
   }

   @JsonProperty("Gxdesc_tipopagoid")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid(  String Value )
   {
      ((com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt)getSdt()).setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid(Value);
   }


   int remoteHandle = -1;
}

