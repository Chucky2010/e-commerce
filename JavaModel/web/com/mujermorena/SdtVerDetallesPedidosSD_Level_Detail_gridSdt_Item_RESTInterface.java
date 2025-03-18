package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "VerDetallesPedidosSD_Level_Detail_gridSdt.Item", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item>
{
   public SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface( )
   {
      super(new com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item ());
   }

   public SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface( com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item psdt )
   {
      super(psdt);
   }

   @JsonProperty("Pedidosdetalleid")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid(), 11, 0)) ;
   }

   @JsonProperty("Pedidosdetalleid")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid(  String Value )
   {
      sdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid( GXutil.lval( Value) );
   }


   @JsonProperty("Articuloid")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid(), 11, 0)) ;
   }

   @JsonProperty("Articuloid")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid(  String Value )
   {
      sdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid( GXutil.lval( Value) );
   }


   @JsonProperty("Articulonombre")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre()) ;
   }

   @JsonProperty("Articulonombre")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre(  String Value )
   {
      ((com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)getSdt()).setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre(Value);
   }


   @JsonProperty("Pedidosdetalletallaid")
   public String getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid(), 11, 0)) ;
   }

   @JsonProperty("Pedidosdetalletallaid")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid(  String Value )
   {
      sdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid( GXutil.lval( Value) );
   }


   @JsonProperty("Pedidosdetallecantidad")
   public Integer getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad( )
   {
      return ((com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)getSdt()).getgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad() ;
   }

   @JsonProperty("Pedidosdetallecantidad")
   public void setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad(  Integer Value )
   {
      ((com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)getSdt()).setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad(Value);
   }


   int remoteHandle = -1;
}

