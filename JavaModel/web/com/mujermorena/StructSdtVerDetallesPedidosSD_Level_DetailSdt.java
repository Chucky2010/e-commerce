package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtVerDetallesPedidosSD_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtVerDetallesPedidosSD_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtVerDetallesPedidosSD_Level_DetailSdt.class ));
   }

   public StructSdtVerDetallesPedidosSD_Level_DetailSdt( int remoteHandle ,
                                                         ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha = cal.getTime() ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante = "" ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi = "" ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs = "" ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid = "" ;
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
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid ;
   }

   public void setPedidosid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid = value ;
   }

   public java.util.Date getPedidosfecha( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha ;
   }

   public void setPedidosfecha( java.util.Date value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha = value ;
   }

   public long getTipopagoid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid ;
   }

   public void setTipopagoid( long value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid = value ;
   }

   public String getPedidosimagencomprobante( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante ;
   }

   public void setPedidosimagencomprobante( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante = value ;
   }

   public String getPedidosimagencomprobante_gxi( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi ;
   }

   public void setPedidosimagencomprobante_gxi( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi = value ;
   }

   public String getPedidoscomprobanteobs( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs ;
   }

   public void setPedidoscomprobanteobs( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs = value ;
   }

   public String getGxdesc_tipopagoid( )
   {
      return gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid ;
   }

   public void setGxdesc_tipopagoid( String value )
   {
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid = value ;
   }

   protected byte gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_N ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid ;
   protected long gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid ;
   protected String gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante ;
   protected java.util.Date gxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha ;
}

