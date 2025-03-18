package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

public final  class StructSdtWWP_SDTNotificationMetadata implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SDTNotificationMetadata( )
   {
      this( -1, new ModelContext( StructSdtWWP_SDTNotificationMetadata.class ));
   }

   public StructSdtWWP_SDTNotificationMetadata( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey = "" ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue = "" ;
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

   public int getTimeout( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_Timeout ;
   }

   public void setTimeout( int value )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Timeout = value ;
   }

   public String getSessionkey( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey ;
   }

   public void setSessionkey( String value )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey = value ;
   }

   public String getSessionvalue( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue ;
   }

   public void setSessionvalue( String value )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue = value ;
   }

   protected byte gxTv_SdtWWP_SDTNotificationMetadata_N ;
   protected int gxTv_SdtWWP_SDTNotificationMetadata_Timeout ;
   protected String gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey ;
   protected String gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue ;
}

