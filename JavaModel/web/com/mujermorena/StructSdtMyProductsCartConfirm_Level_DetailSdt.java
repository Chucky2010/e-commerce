package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMyProductsCartConfirm_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMyProductsCartConfirm_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMyProductsCartConfirm_Level_DetailSdt.class ));
   }

   public StructSdtMyProductsCartConfirm_Level_DetailSdt( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt = "" ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago = "" ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop = "" ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid = "" ;
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

   public String getCartsubtotaltxt( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt ;
   }

   public void setCartsubtotaltxt( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt = value ;
   }

   public com.mujermorena.StructSdtNMCartUserAddress getCartuseraddress( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress ;
   }

   public void setCartuseraddress( com.mujermorena.StructSdtNMCartUserAddress value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress = value;
   }

   public long getTipopagoid( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid ;
   }

   public void setTipopagoid( long value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid = value ;
   }

   public String getDatopago( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago ;
   }

   public void setDatopago( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop = value ;
   }

   public String getGxdesc_tipopagoid( )
   {
      return gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid ;
   }

   public void setGxdesc_tipopagoid( String value )
   {
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid = value ;
   }

   protected byte gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_N ;
   protected long gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago ;
   protected String gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid ;
   protected com.mujermorena.StructSdtNMCartUserAddress gxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress=null ;
}

