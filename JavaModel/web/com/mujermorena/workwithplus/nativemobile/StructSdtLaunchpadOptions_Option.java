package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtLaunchpadOptions_Option implements Cloneable, java.io.Serializable
{
   public StructSdtLaunchpadOptions_Option( )
   {
      this( -1, new ModelContext( StructSdtLaunchpadOptions_Option.class ));
   }

   public StructSdtLaunchpadOptions_Option( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtLaunchpadOptions_Option_Name = "" ;
      gxTv_SdtLaunchpadOptions_Option_Description = "" ;
      gxTv_SdtLaunchpadOptions_Option_Information = "" ;
      gxTv_SdtLaunchpadOptions_Option_Link = "" ;
      gxTv_SdtLaunchpadOptions_Option_Icon = "" ;
      gxTv_SdtLaunchpadOptions_Option_Icon_gxi = "" ;
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

   public String getName( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Name = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Description = value ;
   }

   public String getInformation( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Information ;
   }

   public void setInformation( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Information = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Link ;
   }

   public void setLink( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Link = value ;
   }

   public String getIcon( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Icon ;
   }

   public void setIcon( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Icon = value ;
   }

   public String getIcon_gxi( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Icon_gxi ;
   }

   public void setIcon_gxi( String value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Icon_gxi = value ;
   }

   public int getOrderindex( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Orderindex ;
   }

   public void setOrderindex( int value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Orderindex = value ;
   }

   public byte getTilesize( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Tilesize ;
   }

   public void setTilesize( byte value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Tilesize = value ;
   }

   public byte getTiletype( )
   {
      return gxTv_SdtLaunchpadOptions_Option_Tiletype ;
   }

   public void setTiletype( byte value )
   {
      gxTv_SdtLaunchpadOptions_Option_N = (byte)(0) ;
      gxTv_SdtLaunchpadOptions_Option_Tiletype = value ;
   }

   protected byte gxTv_SdtLaunchpadOptions_Option_Tilesize ;
   protected byte gxTv_SdtLaunchpadOptions_Option_Tiletype ;
   protected byte gxTv_SdtLaunchpadOptions_Option_N ;
   protected int gxTv_SdtLaunchpadOptions_Option_Orderindex ;
   protected String gxTv_SdtLaunchpadOptions_Option_Name ;
   protected String gxTv_SdtLaunchpadOptions_Option_Description ;
   protected String gxTv_SdtLaunchpadOptions_Option_Information ;
   protected String gxTv_SdtLaunchpadOptions_Option_Link ;
   protected String gxTv_SdtLaunchpadOptions_Option_Icon_gxi ;
   protected String gxTv_SdtLaunchpadOptions_Option_Icon ;
}

