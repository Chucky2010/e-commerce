package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item implements Cloneable, java.io.Serializable
{
   public StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item( )
   {
      this( -1, new ModelContext( StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item.class ));
   }

   public StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item( int remoteHandle ,
                                                                   ModelContext context )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre = "" ;
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

   public long getPedidosdetalleid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid ;
   }

   public void setPedidosdetalleid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid = value ;
   }

   public long getArticuloid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid ;
   }

   public void setArticuloid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid = value ;
   }

   public String getArticulonombre( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre ;
   }

   public void setArticulonombre( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre = value ;
   }

   public long getPedidosdetalletallaid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid ;
   }

   public void setPedidosdetalletallaid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid = value ;
   }

   public int getPedidosdetallecantidad( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad ;
   }

   public void setPedidosdetallecantidad( int value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad = value ;
   }

   protected byte gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_N ;
   protected int gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre ;
}

