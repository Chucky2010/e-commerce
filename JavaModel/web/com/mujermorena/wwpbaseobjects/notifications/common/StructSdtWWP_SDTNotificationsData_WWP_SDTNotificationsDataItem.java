package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

public final  class StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem( )
   {
      this( -1, new ModelContext( StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem.class ));
   }

   public StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem( int remoteHandle ,
                                                                          ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationiconclass = "" ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationtitle = "" ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdescription = "" ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime = cal.getTime() ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationlink = "" ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime_N = (byte)(1) ;
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

   public int getNotificationid( )
   {
      return gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid ;
   }

   public void setNotificationid( int value )
   {
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid = value ;
   }

   public String getNotificationiconclass( )
   {
      return gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationiconclass ;
   }

   public void setNotificationiconclass( String value )
   {
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationiconclass = value ;
   }

   public String getNotificationtitle( )
   {
      return gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationtitle ;
   }

   public void setNotificationtitle( String value )
   {
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationtitle = value ;
   }

   public String getNotificationdescription( )
   {
      return gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdescription ;
   }

   public void setNotificationdescription( String value )
   {
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdescription = value ;
   }

   public java.util.Date getNotificationdatetime( )
   {
      return gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime ;
   }

   public void setNotificationdatetime( java.util.Date value )
   {
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime = value ;
   }

   public String getNotificationlink( )
   {
      return gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationlink ;
   }

   public void setNotificationlink( String value )
   {
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationlink = value ;
   }

   protected byte gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime_N ;
   protected byte gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_N ;
   protected int gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid ;
   protected String gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationiconclass ;
   protected String gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationtitle ;
   protected String gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdescription ;
   protected String gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationlink ;
   protected java.util.Date gxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime ;
}

