package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMyProductsCartAddress_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMyProductsCartAddress_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMyProductsCartAddress_Level_DetailSdt.class ));
   }

   public StructSdtMyProductsCartAddress_Level_DetailSdt( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection = "" ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid = "" ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop = "" ;
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

   public String getGxprops_cartuseraddresscollection( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection ;
   }

   public void setGxprops_cartuseraddresscollection( String value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtNMCartUserAddress> getCartuseraddresscollection( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection ;
   }

   public void setCartuseraddresscollection( java.util.Vector<com.mujermorena.StructSdtNMCartUserAddress> value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection = value ;
   }

   public String getSelectedid( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid ;
   }

   public void setSelectedid( String value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtMyProductsCartAddress_Level_DetailSdt_N ;
   protected String gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection ;
   protected String gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop ;
   protected String gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid ;
   protected java.util.Vector<com.mujermorena.StructSdtNMCartUserAddress> gxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection=null ;
}

