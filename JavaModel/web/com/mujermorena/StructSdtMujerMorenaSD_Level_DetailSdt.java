package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMujerMorenaSD_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMujerMorenaSD_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMujerMorenaSD_Level_DetailSdt.class ));
   }

   public StructSdtMujerMorenaSD_Level_DetailSdt( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation = "" ;
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
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions ;
   }

   public void setGxprops_menuoptions( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions = value ;
   }

   public String getUserinfo_userimage( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage ;
   }

   public void setUserinfo_userimage( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage = value ;
   }

   public String getUserinfo_userimage_gxi( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi ;
   }

   public void setUserinfo_userimage_gxi( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi = value ;
   }

   public String getUserinfo_usertitle( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle ;
   }

   public void setUserinfo_usertitle( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle = value ;
   }

   public String getUserinfo_userinformation( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation ;
   }

   public void setUserinfo_userinformation( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation = value ;
   }

   public java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> getMenuoptions( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions ;
   }

   public void setMenuoptions( java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions = value ;
   }

   protected byte gxTv_SdtMujerMorenaSD_Level_DetailSdt_N ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage ;
   protected java.util.Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions=null ;
}

