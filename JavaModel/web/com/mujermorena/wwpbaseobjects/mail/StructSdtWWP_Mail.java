package com.mujermorena.wwpbaseobjects.mail ;
import com.genexus.*;

public final  class StructSdtWWP_Mail implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_Mail( )
   {
      this( -1, new ModelContext( StructSdtWWP_Mail.class ));
   }

   public StructSdtWWP_Mail( int remoteHandle ,
                             ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_Mail_Wwpmailsubject = "" ;
      gxTv_SdtWWP_Mail_Wwpmailbody = "" ;
      gxTv_SdtWWP_Mail_Wwpmailto = "" ;
      gxTv_SdtWWP_Mail_Wwpmailcc = "" ;
      gxTv_SdtWWP_Mail_Wwpmailbcc = "" ;
      gxTv_SdtWWP_Mail_Wwpmailsenderaddress = "" ;
      gxTv_SdtWWP_Mail_Wwpmailsendername = "" ;
      gxTv_SdtWWP_Mail_Wwpmailcreated = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpmailscheduled = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpmaildetail = "" ;
      gxTv_SdtWWP_Mail_Wwpnotificationcreated = cal.getTime() ;
      gxTv_SdtWWP_Mail_Mode = "" ;
      gxTv_SdtWWP_Mail_Wwpmailsubject_Z = "" ;
      gxTv_SdtWWP_Mail_Wwpmailcreated_Z = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = cal.getTime() ;
      gxTv_SdtWWP_Mail_Wwpmailto_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailcc_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = (byte)(1) ;
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = (byte)(1) ;
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

   public long getWwpmailid( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailid ;
   }

   public void setWwpmailid( long value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailid = value ;
   }

   public String getWwpmailsubject( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsubject ;
   }

   public void setWwpmailsubject( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailsubject = value ;
   }

   public String getWwpmailbody( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailbody ;
   }

   public void setWwpmailbody( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailbody = value ;
   }

   public String getWwpmailto( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailto ;
   }

   public void setWwpmailto( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmailto_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailto = value ;
   }

   public String getWwpmailcc( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcc ;
   }

   public void setWwpmailcc( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmailcc_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailcc = value ;
   }

   public String getWwpmailbcc( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailbcc ;
   }

   public void setWwpmailbcc( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailbcc = value ;
   }

   public String getWwpmailsenderaddress( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsenderaddress ;
   }

   public void setWwpmailsenderaddress( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailsenderaddress = value ;
   }

   public String getWwpmailsendername( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsendername ;
   }

   public void setWwpmailsendername( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailsendername = value ;
   }

   public short getWwpmailstatus( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailstatus ;
   }

   public void setWwpmailstatus( short value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailstatus = value ;
   }

   public java.util.Date getWwpmailcreated( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcreated ;
   }

   public void setWwpmailcreated( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailcreated = value ;
   }

   public java.util.Date getWwpmailscheduled( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailscheduled ;
   }

   public void setWwpmailscheduled( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailscheduled = value ;
   }

   public java.util.Date getWwpmailprocessed( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailprocessed ;
   }

   public void setWwpmailprocessed( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed = value ;
   }

   public String getWwpmaildetail( )
   {
      return gxTv_SdtWWP_Mail_Wwpmaildetail ;
   }

   public void setWwpmaildetail( String value )
   {
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmaildetail = value ;
   }

   public long getWwpnotificationid( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationid ;
   }

   public void setWwpnotificationid( long value )
   {
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpnotificationid = value ;
   }

   public java.util.Date getWwpnotificationcreated( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationcreated ;
   }

   public void setWwpnotificationcreated( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpnotificationcreated = value ;
   }

   public java.util.Vector<com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments> getAttachments( )
   {
      return gxTv_SdtWWP_Mail_Attachments ;
   }

   public void setAttachments( java.util.Vector<com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments> value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_Mail_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_Mail_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Initialized = value ;
   }

   public long getWwpmailid_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailid_Z ;
   }

   public void setWwpmailid_Z( long value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailid_Z = value ;
   }

   public String getWwpmailsubject_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailsubject_Z ;
   }

   public void setWwpmailsubject_Z( String value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailsubject_Z = value ;
   }

   public short getWwpmailstatus_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailstatus_Z ;
   }

   public void setWwpmailstatus_Z( short value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailstatus_Z = value ;
   }

   public java.util.Date getWwpmailcreated_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcreated_Z ;
   }

   public void setWwpmailcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailcreated_Z = value ;
   }

   public java.util.Date getWwpmailscheduled_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailscheduled_Z ;
   }

   public void setWwpmailscheduled_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailscheduled_Z = value ;
   }

   public java.util.Date getWwpmailprocessed_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailprocessed_Z ;
   }

   public void setWwpmailprocessed_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed_Z = value ;
   }

   public long getWwpnotificationid_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationid_Z ;
   }

   public void setWwpnotificationid_Z( long value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpnotificationid_Z = value ;
   }

   public java.util.Date getWwpnotificationcreated_Z( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z ;
   }

   public void setWwpnotificationcreated_Z( java.util.Date value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z = value ;
   }

   public byte getWwpmailto_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailto_N ;
   }

   public void setWwpmailto_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailto_N = value ;
   }

   public byte getWwpmailcc_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailcc_N ;
   }

   public void setWwpmailcc_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailcc_N = value ;
   }

   public byte getWwpmailbcc_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailbcc_N ;
   }

   public void setWwpmailbcc_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailbcc_N = value ;
   }

   public byte getWwpmailprocessed_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmailprocessed_N ;
   }

   public void setWwpmailprocessed_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmailprocessed_N = value ;
   }

   public byte getWwpmaildetail_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpmaildetail_N ;
   }

   public void setWwpmaildetail_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpmaildetail_N = value ;
   }

   public byte getWwpnotificationid_N( )
   {
      return gxTv_SdtWWP_Mail_Wwpnotificationid_N ;
   }

   public void setWwpnotificationid_N( byte value )
   {
      gxTv_SdtWWP_Mail_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Wwpnotificationid_N = value ;
   }

   protected byte gxTv_SdtWWP_Mail_Wwpmailto_N ;
   protected byte gxTv_SdtWWP_Mail_Wwpmailcc_N ;
   protected byte gxTv_SdtWWP_Mail_Wwpmailbcc_N ;
   protected byte gxTv_SdtWWP_Mail_Wwpmailprocessed_N ;
   protected byte gxTv_SdtWWP_Mail_Wwpmaildetail_N ;
   protected byte gxTv_SdtWWP_Mail_Wwpnotificationid_N ;
   private byte gxTv_SdtWWP_Mail_N ;
   protected short gxTv_SdtWWP_Mail_Wwpmailstatus ;
   protected short gxTv_SdtWWP_Mail_Initialized ;
   protected short gxTv_SdtWWP_Mail_Wwpmailstatus_Z ;
   protected long gxTv_SdtWWP_Mail_Wwpmailid ;
   protected long gxTv_SdtWWP_Mail_Wwpnotificationid ;
   protected long gxTv_SdtWWP_Mail_Wwpmailid_Z ;
   protected long gxTv_SdtWWP_Mail_Wwpnotificationid_Z ;
   protected String gxTv_SdtWWP_Mail_Mode ;
   protected String gxTv_SdtWWP_Mail_Wwpmailbody ;
   protected String gxTv_SdtWWP_Mail_Wwpmailto ;
   protected String gxTv_SdtWWP_Mail_Wwpmailcc ;
   protected String gxTv_SdtWWP_Mail_Wwpmailbcc ;
   protected String gxTv_SdtWWP_Mail_Wwpmailsenderaddress ;
   protected String gxTv_SdtWWP_Mail_Wwpmailsendername ;
   protected String gxTv_SdtWWP_Mail_Wwpmaildetail ;
   protected String gxTv_SdtWWP_Mail_Wwpmailsubject ;
   protected String gxTv_SdtWWP_Mail_Wwpmailsubject_Z ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpmailcreated ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpmailscheduled ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpmailprocessed ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpnotificationcreated ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpmailcreated_Z ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpmailscheduled_Z ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpmailprocessed_Z ;
   protected java.util.Date gxTv_SdtWWP_Mail_Wwpnotificationcreated_Z ;
   protected java.util.Vector<com.mujermorena.wwpbaseobjects.mail.StructSdtWWP_Mail_Attachments> gxTv_SdtWWP_Mail_Attachments=null ;
}

