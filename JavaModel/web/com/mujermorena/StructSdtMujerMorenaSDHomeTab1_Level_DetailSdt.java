package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt.class ));
   }

   public StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop = "" ;
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

   public java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem> getBanner_items( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items ;
   }

   public void setBanner_items( java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem> value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items = value ;
   }

   public short getBanner_chronometer( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer ;
   }

   public void setBanner_chronometer( short value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer = value ;
   }

   public java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData> getProducts( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products ;
   }

   public void setProducts( java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData> value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products = value ;
   }

   public short getA( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A ;
   }

   public void setA( short value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A = value ;
   }

   public short getBanner_count( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count ;
   }

   public void setBanner_count( short value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N ;
   protected short gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer ;
   protected short gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A ;
   protected short gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count ;
   protected String gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop ;
   protected java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items=null ;
   protected java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products=null ;
}

