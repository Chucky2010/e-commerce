package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMyProductsCartCheckout_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMyProductsCartCheckout_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMyProductsCartCheckout_Level_DetailSdt.class ));
   }

   public StructSdtMyProductsCartCheckout_Level_DetailSdt( int remoteHandle ,
                                                           ModelContext context )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt = "" ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop = "" ;
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
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt ;
   }

   public void setCartsubtotaltxt( String value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtNMCartProduct> getCartproductcollection( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection ;
   }

   public void setCartproductcollection( java.util.Vector<com.mujermorena.StructSdtNMCartProduct> value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection = value ;
   }

   public boolean getIsauthorized_continue( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue ;
   }

   public void setIsauthorized_continue( boolean value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_N ;
   protected String gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop ;
   protected boolean gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue ;
   protected String gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt ;
   protected java.util.Vector<com.mujermorena.StructSdtNMCartProduct> gxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection=null ;
}

