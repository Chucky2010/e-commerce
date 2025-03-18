package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtMenuOptions_MenuOptionsItem implements Cloneable, java.io.Serializable
{
   public StructSdtMenuOptions_MenuOptionsItem( )
   {
      this( -1, new ModelContext( StructSdtMenuOptions_MenuOptionsItem.class ));
   }

   public StructSdtMenuOptions_MenuOptionsItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_Title = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Id = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Information = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass = "" ;
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

   public String getTitle( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Title ;
   }

   public void setTitle( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Title = value ;
   }

   public String getIcon( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Icon ;
   }

   public void setIcon( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon = value ;
   }

   public String getIcon_gxi( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi ;
   }

   public void setIcon_gxi( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi = value ;
   }

   public short getType( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Type ;
   }

   public void setType( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Type = value ;
   }

   public String getComponenttocall( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall ;
   }

   public void setComponenttocall( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall = value ;
   }

   public String getId( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Id = value ;
   }

   public short getIdnum( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Idnum ;
   }

   public void setIdnum( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Idnum = value ;
   }

   public short getOrderindex( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex ;
   }

   public void setOrderindex( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex = value ;
   }

   public short getBadgecount( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount ;
   }

   public void setBadgecount( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount = value ;
   }

   public String getInformation( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Information ;
   }

   public void setInformation( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Information = value ;
   }

   public String getFonticon( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon ;
   }

   public void setFonticon( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon = value ;
   }

   public String getFonticonclass( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass ;
   }

   public void setFonticonclass( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass = value ;
   }

   protected byte gxTv_SdtMenuOptions_MenuOptionsItem_N ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Type ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Idnum ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Title ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Id ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Information ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Icon ;
}

