package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtCartCheckoutData_PlaceOrder implements Cloneable, java.io.Serializable
{
   public StructSdtCartCheckoutData_PlaceOrder( )
   {
      this( -1, new ModelContext( StructSdtCartCheckoutData_PlaceOrder.class ));
   }

   public StructSdtCartCheckoutData_PlaceOrder( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N = (byte)(1) ;
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

   public java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item> getDvelop_ecommercecart( )
   {
      return gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart ;
   }

   public void setDvelop_ecommercecart( java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item> value )
   {
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart = value ;
   }

   protected byte gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N ;
   protected byte gxTv_SdtCartCheckoutData_PlaceOrder_N ;
   protected java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item> gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart=null ;
}

