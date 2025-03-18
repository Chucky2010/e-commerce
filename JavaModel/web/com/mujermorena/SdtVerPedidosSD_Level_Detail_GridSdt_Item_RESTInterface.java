package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "VerPedidosSD_Level_Detail_GridSdt.Item", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item>
{
   public SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface( )
   {
      super(new com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item ());
   }

   public SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface( com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item psdt )
   {
      super(psdt);
   }

   @JsonProperty("Pedidosid")
   public String getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid(), 11, 0)) ;
   }

   @JsonProperty("Pedidosid")
   public void setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid(  String Value )
   {
      sdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid( GXutil.lval( Value) );
   }


   @JsonProperty("Pedidosfecha")
   public String getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha( )
   {
      return GXutil.dateToCharREST( sdt.getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha()) ;
   }

   @JsonProperty("Pedidosfecha")
   public void setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha(  String Value )
   {
      sdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha( GXutil.charToDateREST( Value) );
   }


   @JsonProperty("Pedidostotal")
   public String getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal( )
   {
      return GXutil.ltrim( GXutil.strNoRound( sdt.getgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal(), 17, 2)) ;
   }

   @JsonProperty("Pedidostotal")
   public void setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal(  String Value )
   {
      sdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal( DecimalUtil.stringToDec( Value) );
   }


   int remoteHandle = -1;
}

