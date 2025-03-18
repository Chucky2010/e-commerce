package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

public final  class StructSdtWWP_Notification implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_Notification( )
   {
      this( -1, new ModelContext( StructSdtWWP_Notification.class ));
   }

   public StructSdtWWP_Notification( int remoteHandle ,
                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationcreated = cal.getTime() ;
      gxTv_SdtWWP_Notification_Wwpnotificationicon = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationtitle = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationlink = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata = "" ;
      gxTv_SdtWWP_Notification_Mode = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = cal.getTime() ;
      gxTv_SdtWWP_Notification_Wwpnotificationicon_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpnotificationlink_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z = "" ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = (byte)(1) ;
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = (byte)(1) ;
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

   public long getWwpnotificationid( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationid ;
   }

   public void setWwpnotificationid( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationid = value ;
   }

   public long getWwpnotificationdefinitionid( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid ;
   }

   public void setWwpnotificationdefinitionid( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid = value ;
   }

   public String getWwpnotificationdefinitionname( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname ;
   }

   public void setWwpnotificationdefinitionname( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname = value ;
   }

   public java.util.Date getWwpnotificationcreated( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationcreated ;
   }

   public void setWwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationcreated = value ;
   }

   public String getWwpnotificationicon( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationicon ;
   }

   public void setWwpnotificationicon( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationicon = value ;
   }

   public String getWwpnotificationtitle( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationtitle ;
   }

   public void setWwpnotificationtitle( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationtitle = value ;
   }

   public String getWwpnotificationshortdescription( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationshortdescription ;
   }

   public void setWwpnotificationshortdescription( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription = value ;
   }

   public String getWwpnotificationlink( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationlink ;
   }

   public void setWwpnotificationlink( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationlink = value ;
   }

   public boolean getWwpnotificationisread( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationisread ;
   }

   public void setWwpnotificationisread( boolean value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationisread = value ;
   }

   public String getWwpuserextendedid( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedid ;
   }

   public void setWwpuserextendedid( String value )
   {
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid = value ;
   }

   public String getWwpuserextendedfullname( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedfullname ;
   }

   public void setWwpuserextendedfullname( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname = value ;
   }

   public String getWwpnotificationmetadata( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationmetadata ;
   }

   public void setWwpnotificationmetadata( String value )
   {
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_Notification_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_Notification_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Initialized = value ;
   }

   public long getWwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationid_Z ;
   }

   public void setWwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationid_Z = value ;
   }

   public long getWwpnotificationdefinitionid_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z ;
   }

   public void setWwpnotificationdefinitionid_Z( long value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z = value ;
   }

   public String getWwpnotificationdefinitionname_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z ;
   }

   public void setWwpnotificationdefinitionname_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z = value ;
   }

   public java.util.Date getWwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z ;
   }

   public void setWwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z = value ;
   }

   public String getWwpnotificationicon_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationicon_Z ;
   }

   public void setWwpnotificationicon_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationicon_Z = value ;
   }

   public String getWwpnotificationtitle_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z ;
   }

   public void setWwpnotificationtitle_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z = value ;
   }

   public String getWwpnotificationshortdescription_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z ;
   }

   public void setWwpnotificationshortdescription_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z = value ;
   }

   public String getWwpnotificationlink_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationlink_Z ;
   }

   public void setWwpnotificationlink_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationlink_Z = value ;
   }

   public boolean getWwpnotificationisread_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationisread_Z ;
   }

   public void setWwpnotificationisread_Z( boolean value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationisread_Z = value ;
   }

   public String getWwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedid_Z ;
   }

   public void setWwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid_Z = value ;
   }

   public String getWwpuserextendedfullname_Z( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z ;
   }

   public void setWwpuserextendedfullname_Z( String value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z = value ;
   }

   public byte getWwpnotificationid_N( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationid_N ;
   }

   public void setWwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationid_N = value ;
   }

   public byte getWwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_Notification_Wwpuserextendedid_N ;
   }

   public void setWwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpuserextendedid_N = value ;
   }

   public byte getWwpnotificationmetadata_N( )
   {
      return gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N ;
   }

   public void setWwpnotificationmetadata_N( byte value )
   {
      gxTv_SdtWWP_Notification_N = (byte)(0) ;
      gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N = value ;
   }

   protected byte gxTv_SdtWWP_Notification_Wwpnotificationid_N ;
   protected byte gxTv_SdtWWP_Notification_Wwpuserextendedid_N ;
   protected byte gxTv_SdtWWP_Notification_Wwpnotificationmetadata_N ;
   private byte gxTv_SdtWWP_Notification_N ;
   protected short gxTv_SdtWWP_Notification_Initialized ;
   protected long gxTv_SdtWWP_Notification_Wwpnotificationid ;
   protected long gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid ;
   protected long gxTv_SdtWWP_Notification_Wwpnotificationid_Z ;
   protected long gxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpuserextendedid ;
   protected String gxTv_SdtWWP_Notification_Mode ;
   protected String gxTv_SdtWWP_Notification_Wwpuserextendedid_Z ;
   protected boolean gxTv_SdtWWP_Notification_Wwpnotificationisread ;
   protected boolean gxTv_SdtWWP_Notification_Wwpnotificationisread_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationmetadata ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationicon ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationtitle ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationshortdescription ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationlink ;
   protected String gxTv_SdtWWP_Notification_Wwpuserextendedfullname ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationicon_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationtitle_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpnotificationlink_Z ;
   protected String gxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z ;
   protected java.util.Date gxTv_SdtWWP_Notification_Wwpnotificationcreated ;
   protected java.util.Date gxTv_SdtWWP_Notification_Wwpnotificationcreated_Z ;
}

