package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtDVelop_ECommerceCart_Item implements Cloneable, java.io.Serializable
{
   public StructSdtDVelop_ECommerceCart_Item( )
   {
      this( -1, new ModelContext( StructSdtDVelop_ECommerceCart_Item.class ));
   }

   public StructSdtDVelop_ECommerceCart_Item( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_Productname = "" ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productdescription = "" ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productsim = "" ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productprice = new java.math.BigDecimal(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images_N = (byte)(1) ;
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

   public int getProductid( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productid ;
   }

   public void setProductid( int value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productid = value ;
   }

   public String getProductname( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productname ;
   }

   public void setProductname( String value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productname = value ;
   }

   public String getProductdescription( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productdescription ;
   }

   public void setProductdescription( String value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productdescription = value ;
   }

   public String getProductsim( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productsim ;
   }

   public void setProductsim( String value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productsim = value ;
   }

   public java.math.BigDecimal getProductprice( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productprice ;
   }

   public void setProductprice( java.math.BigDecimal value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productprice = value ;
   }

   public short getProductqty( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productqty ;
   }

   public void setProductqty( short value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productqty = value ;
   }

   public short getProducttalle( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Producttalle ;
   }

   public void setProducttalle( short value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Producttalle = value ;
   }

   public java.util.Vector getImages( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Images ;
   }

   public void setImages( java.util.Vector value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_Images_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images = value ;
   }

   public java.util.Vector getImages_gxi( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi ;
   }

   public void setImages_gxi( java.util.Vector value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi = value ;
   }

   protected byte gxTv_SdtDVelop_ECommerceCart_Item_Images_N ;
   protected byte gxTv_SdtDVelop_ECommerceCart_Item_N ;
   protected short gxTv_SdtDVelop_ECommerceCart_Item_Productqty ;
   protected short gxTv_SdtDVelop_ECommerceCart_Item_Producttalle ;
   protected int gxTv_SdtDVelop_ECommerceCart_Item_Productid ;
   protected String gxTv_SdtDVelop_ECommerceCart_Item_Productname ;
   protected String gxTv_SdtDVelop_ECommerceCart_Item_Productdescription ;
   protected String gxTv_SdtDVelop_ECommerceCart_Item_Productsim ;
   protected java.math.BigDecimal gxTv_SdtDVelop_ECommerceCart_Item_Productprice ;
   protected java.util.Vector gxTv_SdtDVelop_ECommerceCart_Item_Images=null ;
   protected java.util.Vector gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi=null ;
}

