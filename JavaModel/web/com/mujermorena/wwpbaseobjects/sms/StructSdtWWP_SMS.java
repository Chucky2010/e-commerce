package com.mujermorena.wwpbaseobjects.sms ;
import com.genexus.*;

public final  class StructSdtWWP_SMS implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SMS( )
   {
      this( -1, new ModelContext( StructSdtWWP_SMS.class ));
   }

   public StructSdtWWP_SMS( int remoteHandle ,
                            ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_SMS_Wwpsmsmessage = "" ;
      gxTv_SdtWWP_SMS_Wwpsmssendernumber = "" ;
      gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers = "" ;
      gxTv_SdtWWP_SMS_Wwpsmscreated = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpsmsscheduled = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpsmsdetail = "" ;
      gxTv_SdtWWP_SMS_Wwpnotificationcreated = cal.getTime() ;
      gxTv_SdtWWP_SMS_Mode = "" ;
      gxTv_SdtWWP_SMS_Wwpsmscreated_Z = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = cal.getTime() ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = (byte)(1) ;
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = (byte)(1) ;
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = (byte)(1) ;
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

   public long getWwpsmsid( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsid ;
   }

   public void setWwpsmsid( long value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsid = value ;
   }

   public String getWwpsmsmessage( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsmessage ;
   }

   public void setWwpsmsmessage( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsmessage = value ;
   }

   public String getWwpsmssendernumber( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmssendernumber ;
   }

   public void setWwpsmssendernumber( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmssendernumber = value ;
   }

   public String getWwpsmsrecipientnumbers( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers ;
   }

   public void setWwpsmsrecipientnumbers( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers = value ;
   }

   public short getWwpsmsstatus( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsstatus ;
   }

   public void setWwpsmsstatus( short value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsstatus = value ;
   }

   public java.util.Date getWwpsmscreated( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmscreated ;
   }

   public void setWwpsmscreated( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmscreated = value ;
   }

   public java.util.Date getWwpsmsscheduled( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsscheduled ;
   }

   public void setWwpsmsscheduled( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsscheduled = value ;
   }

   public java.util.Date getWwpsmsprocessed( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsprocessed ;
   }

   public void setWwpsmsprocessed( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed = value ;
   }

   public String getWwpsmsdetail( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsdetail ;
   }

   public void setWwpsmsdetail( String value )
   {
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsdetail = value ;
   }

   public long getWwpnotificationid( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationid ;
   }

   public void setWwpnotificationid( long value )
   {
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpnotificationid = value ;
   }

   public java.util.Date getWwpnotificationcreated( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationcreated ;
   }

   public void setWwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpnotificationcreated = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_SMS_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_SMS_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Initialized = value ;
   }

   public long getWwpsmsid_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsid_Z ;
   }

   public void setWwpsmsid_Z( long value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsid_Z = value ;
   }

   public short getWwpsmsstatus_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsstatus_Z ;
   }

   public void setWwpsmsstatus_Z( short value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsstatus_Z = value ;
   }

   public java.util.Date getWwpsmscreated_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmscreated_Z ;
   }

   public void setWwpsmscreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmscreated_Z = value ;
   }

   public java.util.Date getWwpsmsscheduled_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z ;
   }

   public void setWwpsmsscheduled_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z = value ;
   }

   public java.util.Date getWwpsmsprocessed_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z ;
   }

   public void setWwpsmsprocessed_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z = value ;
   }

   public long getWwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationid_Z ;
   }

   public void setWwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpnotificationid_Z = value ;
   }

   public java.util.Date getWwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z ;
   }

   public void setWwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z = value ;
   }

   public byte getWwpsmsprocessed_N( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsprocessed_N ;
   }

   public void setWwpsmsprocessed_N( byte value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsprocessed_N = value ;
   }

   public byte getWwpsmsdetail_N( )
   {
      return gxTv_SdtWWP_SMS_Wwpsmsdetail_N ;
   }

   public void setWwpsmsdetail_N( byte value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpsmsdetail_N = value ;
   }

   public byte getWwpnotificationid_N( )
   {
      return gxTv_SdtWWP_SMS_Wwpnotificationid_N ;
   }

   public void setWwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_SMS_N = (byte)(0) ;
      gxTv_SdtWWP_SMS_Wwpnotificationid_N = value ;
   }

   protected byte gxTv_SdtWWP_SMS_Wwpsmsprocessed_N ;
   protected byte gxTv_SdtWWP_SMS_Wwpsmsdetail_N ;
   protected byte gxTv_SdtWWP_SMS_Wwpnotificationid_N ;
   private byte gxTv_SdtWWP_SMS_N ;
   protected short gxTv_SdtWWP_SMS_Wwpsmsstatus ;
   protected short gxTv_SdtWWP_SMS_Initialized ;
   protected short gxTv_SdtWWP_SMS_Wwpsmsstatus_Z ;
   protected long gxTv_SdtWWP_SMS_Wwpsmsid ;
   protected long gxTv_SdtWWP_SMS_Wwpnotificationid ;
   protected long gxTv_SdtWWP_SMS_Wwpsmsid_Z ;
   protected long gxTv_SdtWWP_SMS_Wwpnotificationid_Z ;
   protected String gxTv_SdtWWP_SMS_Mode ;
   protected String gxTv_SdtWWP_SMS_Wwpsmsmessage ;
   protected String gxTv_SdtWWP_SMS_Wwpsmssendernumber ;
   protected String gxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers ;
   protected String gxTv_SdtWWP_SMS_Wwpsmsdetail ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpsmscreated ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpsmsscheduled ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpsmsprocessed ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpnotificationcreated ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpsmscreated_Z ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpsmsscheduled_Z ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpsmsprocessed_Z ;
   protected java.util.Date gxTv_SdtWWP_SMS_Wwpnotificationcreated_Z ;
}

