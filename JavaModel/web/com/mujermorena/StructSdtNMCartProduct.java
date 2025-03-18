package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtNMCartProduct implements Cloneable, java.io.Serializable
{
   public StructSdtNMCartProduct( )
   {
      this( -1, new ModelContext( StructSdtNMCartProduct.class ));
   }

   public StructSdtNMCartProduct( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtNMCartProduct_Productid = "" ;
      gxTv_SdtNMCartProduct_Color = "" ;
      gxTv_SdtNMCartProduct_Variant = "" ;
      gxTv_SdtNMCartProduct_Promotion = "" ;
      gxTv_SdtNMCartProduct_Productdatatitle = "" ;
      gxTv_SdtNMCartProduct_Productdatainformation = "" ;
      gxTv_SdtNMCartProduct_Productdataimage = "" ;
      gxTv_SdtNMCartProduct_Productdataimage_gxi = "" ;
      gxTv_SdtNMCartProduct_Productdata_N = (byte)(1) ;
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

   public String getProductid( )
   {
      return gxTv_SdtNMCartProduct_Productid ;
   }

   public void setProductid( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productid = value ;
   }

   public short getCount( )
   {
      return gxTv_SdtNMCartProduct_Count ;
   }

   public void setCount( short value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Count = value ;
   }

   public String getColor( )
   {
      return gxTv_SdtNMCartProduct_Color ;
   }

   public void setColor( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Color = value ;
   }

   public String getVariant( )
   {
      return gxTv_SdtNMCartProduct_Variant ;
   }

   public void setVariant( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Variant = value ;
   }

   public String getPromotion( )
   {
      return gxTv_SdtNMCartProduct_Promotion ;
   }

   public void setPromotion( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Promotion = value ;
   }

   public com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData getProductdata( )
   {
      return gxTv_SdtNMCartProduct_Productdata ;
   }

   public void setProductdata( com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData value )
   {
      gxTv_SdtNMCartProduct_Productdata_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdata = value;
   }

   public String getProductdatatitle( )
   {
      return gxTv_SdtNMCartProduct_Productdatatitle ;
   }

   public void setProductdatatitle( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdatatitle = value ;
   }

   public String getProductdatainformation( )
   {
      return gxTv_SdtNMCartProduct_Productdatainformation ;
   }

   public void setProductdatainformation( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdatainformation = value ;
   }

   public String getProductdataimage( )
   {
      return gxTv_SdtNMCartProduct_Productdataimage ;
   }

   public void setProductdataimage( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdataimage = value ;
   }

   public String getProductdataimage_gxi( )
   {
      return gxTv_SdtNMCartProduct_Productdataimage_gxi ;
   }

   public void setProductdataimage_gxi( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdataimage_gxi = value ;
   }

   public long getTalla( )
   {
      return gxTv_SdtNMCartProduct_Talla ;
   }

   public void setTalla( long value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Talla = value ;
   }

   protected byte gxTv_SdtNMCartProduct_Productdata_N ;
   protected byte gxTv_SdtNMCartProduct_N ;
   protected short gxTv_SdtNMCartProduct_Count ;
   protected long gxTv_SdtNMCartProduct_Talla ;
   protected String gxTv_SdtNMCartProduct_Productid ;
   protected String gxTv_SdtNMCartProduct_Color ;
   protected String gxTv_SdtNMCartProduct_Variant ;
   protected String gxTv_SdtNMCartProduct_Promotion ;
   protected String gxTv_SdtNMCartProduct_Productdatatitle ;
   protected String gxTv_SdtNMCartProduct_Productdatainformation ;
   protected String gxTv_SdtNMCartProduct_Productdataimage_gxi ;
   protected String gxTv_SdtNMCartProduct_Productdataimage ;
   protected com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData gxTv_SdtNMCartProduct_Productdata=null ;
}

