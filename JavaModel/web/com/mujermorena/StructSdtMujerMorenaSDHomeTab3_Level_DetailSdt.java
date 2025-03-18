package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt.class ));
   }

   public StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt( int remoteHandle ,
                                                          ModelContext context )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions = "" ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage = "" ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi = "" ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop = "" ;
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

   public String getGxprops_menuoptions( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions ;
   }

   public void setGxprops_menuoptions( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions = value ;
   }

   public String getUserinfo_userimage( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage ;
   }

   public void setUserinfo_userimage( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage = value ;
   }

   public String getUserinfo_userimage_gxi( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi ;
   }

   public void setUserinfo_userimage_gxi( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi = value ;
   }

   public java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> getMenuoptions( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions ;
   }

   public void setMenuoptions( java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage ;
   protected java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions=null ;
}

