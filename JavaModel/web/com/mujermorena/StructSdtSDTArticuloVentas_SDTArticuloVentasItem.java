package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtSDTArticuloVentas_SDTArticuloVentasItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTArticuloVentas_SDTArticuloVentasItem( )
   {
      this( -1, new ModelContext( StructSdtSDTArticuloVentas_SDTArticuloVentasItem.class ));
   }

   public StructSdtSDTArticuloVentas_SDTArticuloVentasItem( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre = "" ;
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

   public long getArticuloid( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid ;
   }

   public void setArticuloid( long value )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(0) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid = value ;
   }

   public String getArticulonombre( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre ;
   }

   public void setArticulonombre( String value )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(0) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre = value ;
   }

   public short getCantidadvendida( )
   {
      return gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida ;
   }

   public void setCantidadvendida( short value )
   {
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N = (byte)(0) ;
      gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida = value ;
   }

   protected byte gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_N ;
   protected short gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida ;
   protected long gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid ;
   protected String gxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre ;
}

