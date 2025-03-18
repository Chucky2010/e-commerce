package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtVerPedidosSD_Level_Detail_GridSdt_Item implements Cloneable, java.io.Serializable
{
   public StructSdtVerPedidosSD_Level_Detail_GridSdt_Item( )
   {
      this( -1, new ModelContext( StructSdtVerPedidosSD_Level_Detail_GridSdt_Item.class ));
   }

   public StructSdtVerPedidosSD_Level_Detail_GridSdt_Item( int remoteHandle ,
                                                           ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha = cal.getTime() ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal = new java.math.BigDecimal(0) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public long getPedidosid( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid ;
   }

   public void setPedidosid( long value )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid = value ;
   }

   public java.util.Date getPedidosfecha( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha ;
   }

   public void setPedidosfecha( java.util.Date value )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha = value ;
   }

   public java.math.BigDecimal getPedidostotal( )
   {
      return gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal ;
   }

   public void setPedidostotal( java.math.BigDecimal value )
   {
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal = value ;
   }

   protected byte gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_N ;
   protected long gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid ;
   protected java.util.Date gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha ;
   protected java.math.BigDecimal gxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal ;
}

