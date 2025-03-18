package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.genexus.*;

public final  class StructSdtWWP_WebNotification implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_WebNotification( )
   {
      this( -1, new ModelContext( StructSdtWWP_WebNotification.class ));
   }

   public StructSdtWWP_WebNotification( int remoteHandle ,
                                        ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle = "" ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = "" ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = "" ;
      gxTv_SdtWWP_WebNotification_Mode = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z = "" ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = cal.getTime() ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = (byte)(1) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = (byte)(1) ;
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

   public long getWwpwebnotificationid( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationid ;
   }

   public void setWwpwebnotificationid( long value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationid = value ;
   }

   public String getWwpwebnotificationtitle( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle ;
   }

   public void setWwpwebnotificationtitle( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle = value ;
   }

   public long getWwpnotificationid( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationid ;
   }

   public void setWwpnotificationid( long value )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationid = value ;
   }

   public java.util.Date getWwpnotificationcreated( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationcreated ;
   }

   public void setWwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated = value ;
   }

   public String getWwpnotificationmetadata( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata ;
   }

   public void setWwpnotificationmetadata( String value )
   {
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata = value ;
   }

   public String getWwpnotificationdefinitionname( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname ;
   }

   public void setWwpnotificationdefinitionname( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname = value ;
   }

   public String getWwpwebnotificationtext( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext ;
   }

   public void setWwpwebnotificationtext( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext = value ;
   }

   public String getWwpwebnotificationicon( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon ;
   }

   public void setWwpwebnotificationicon( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon = value ;
   }

   public String getWwpwebnotificationclientid( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid ;
   }

   public void setWwpwebnotificationclientid( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid = value ;
   }

   public short getWwpwebnotificationstatus( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus ;
   }

   public void setWwpwebnotificationstatus( short value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus = value ;
   }

   public java.util.Date getWwpwebnotificationcreated( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated ;
   }

   public void setWwpwebnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated = value ;
   }

   public java.util.Date getWwpwebnotificationscheduled( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled ;
   }

   public void setWwpwebnotificationscheduled( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled = value ;
   }

   public java.util.Date getWwpwebnotificationprocessed( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed ;
   }

   public void setWwpwebnotificationprocessed( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed = value ;
   }

   public java.util.Date getWwpwebnotificationread( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationread ;
   }

   public void setWwpwebnotificationread( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread = value ;
   }

   public String getWwpwebnotificationdetail( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail ;
   }

   public void setWwpwebnotificationdetail( String value )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail = value ;
   }

   public boolean getWwpwebnotificationreceived( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived ;
   }

   public void setWwpwebnotificationreceived( boolean value )
   {
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_WebNotification_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_WebNotification_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Initialized = value ;
   }

   public long getWwpwebnotificationid_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z ;
   }

   public void setWwpwebnotificationid_Z( long value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z = value ;
   }

   public String getWwpwebnotificationtitle_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z ;
   }

   public void setWwpwebnotificationtitle_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z = value ;
   }

   public long getWwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z ;
   }

   public void setWwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z = value ;
   }

   public java.util.Date getWwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z ;
   }

   public void setWwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z = value ;
   }

   public String getWwpnotificationdefinitionname_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z ;
   }

   public void setWwpnotificationdefinitionname_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z = value ;
   }

   public String getWwpwebnotificationtext_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z ;
   }

   public void setWwpwebnotificationtext_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z = value ;
   }

   public String getWwpwebnotificationicon_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z ;
   }

   public void setWwpwebnotificationicon_Z( String value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z = value ;
   }

   public short getWwpwebnotificationstatus_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z ;
   }

   public void setWwpwebnotificationstatus_Z( short value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z = value ;
   }

   public java.util.Date getWwpwebnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z ;
   }

   public void setWwpwebnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z = value ;
   }

   public java.util.Date getWwpwebnotificationscheduled_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z ;
   }

   public void setWwpwebnotificationscheduled_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z = value ;
   }

   public java.util.Date getWwpwebnotificationprocessed_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z ;
   }

   public void setWwpwebnotificationprocessed_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z = value ;
   }

   public java.util.Date getWwpwebnotificationread_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z ;
   }

   public void setWwpwebnotificationread_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z = value ;
   }

   public boolean getWwpwebnotificationreceived_Z( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z ;
   }

   public void setWwpwebnotificationreceived_Z( boolean value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z = value ;
   }

   public byte getWwpnotificationid_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationid_N ;
   }

   public void setWwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationid_N = value ;
   }

   public byte getWwpnotificationmetadata_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N ;
   }

   public void setWwpnotificationmetadata_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N = value ;
   }

   public byte getWwpwebnotificationread_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N ;
   }

   public void setWwpwebnotificationread_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N = value ;
   }

   public byte getWwpwebnotificationdetail_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N ;
   }

   public void setWwpwebnotificationdetail_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N = value ;
   }

   public byte getWwpwebnotificationreceived_N( )
   {
      return gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N ;
   }

   public void setWwpwebnotificationreceived_N( byte value )
   {
      gxTv_SdtWWP_WebNotification_N = (byte)(0) ;
      gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N = value ;
   }

   protected byte gxTv_SdtWWP_WebNotification_Wwpnotificationid_N ;
   protected byte gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N ;
   protected byte gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N ;
   protected byte gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N ;
   protected byte gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N ;
   private byte gxTv_SdtWWP_WebNotification_N ;
   protected short gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus ;
   protected short gxTv_SdtWWP_WebNotification_Initialized ;
   protected short gxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z ;
   protected long gxTv_SdtWWP_WebNotification_Wwpwebnotificationid ;
   protected long gxTv_SdtWWP_WebNotification_Wwpnotificationid ;
   protected long gxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z ;
   protected long gxTv_SdtWWP_WebNotification_Wwpnotificationid_Z ;
   protected String gxTv_SdtWWP_WebNotification_Mode ;
   protected boolean gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived ;
   protected boolean gxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z ;
   protected String gxTv_SdtWWP_WebNotification_Wwpnotificationmetadata ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle ;
   protected String gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z ;
   protected String gxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z ;
   protected String gxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpnotificationcreated ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationread ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z ;
   protected java.util.Date gxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z ;
}

