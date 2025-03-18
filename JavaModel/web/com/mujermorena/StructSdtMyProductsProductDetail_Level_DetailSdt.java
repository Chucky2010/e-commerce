package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMyProductsProductDetail_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMyProductsProductDetail_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMyProductsProductDetail_Level_DetailSdt.class ));
   }

   public StructSdtMyProductsProductDetail_Level_DetailSdt( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid = "" ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop = "" ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle = "" ;
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

   public java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages> getProductdataimages( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages ;
   }

   public void setProductdataimages( java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages> value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages = value ;
   }

   public com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData getProductdata( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata ;
   }

   public void setProductdata( com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata = value;
   }

   public short getRating( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating ;
   }

   public void setRating( short value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating = value ;
   }

   public int getCantidad( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad ;
   }

   public void setCantidad( int value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad = value ;
   }

   public int getTalle( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle ;
   }

   public void setTalle( int value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle = value ;
   }

   public short getProductdispon( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon ;
   }

   public void setProductdispon( short value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon = value ;
   }

   public String getProductid( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid ;
   }

   public void setProductid( String value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop = value ;
   }

   public String getGxdesc_talle( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle ;
   }

   public void setGxdesc_talle( String value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle = value ;
   }

   protected byte gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N ;
   protected short gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating ;
   protected short gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon ;
   protected int gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad ;
   protected int gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle ;
   protected String gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop ;
   protected String gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid ;
   protected String gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle ;
   protected com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata=null ;
   protected java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages> gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages=null ;
}

