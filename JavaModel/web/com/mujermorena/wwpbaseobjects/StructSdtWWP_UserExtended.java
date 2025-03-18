package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWP_UserExtended implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_UserExtended( )
   {
      this( -1, new ModelContext( StructSdtWWP_UserExtended.class ));
   }

   public StructSdtWWP_UserExtended( int remoteHandle ,
                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = cal.getTime() ;
      gxTv_SdtWWP_UserExtended_Mode = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = cal.getTime() ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z = "" ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = (byte)(1) ;
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

   public String getWwpuserextendedid( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedid ;
   }

   public void setWwpuserextendedid( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid = value ;
   }

   public String getWwpuserextendedphoto( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto ;
   }

   public void setWwpuserextendedphoto( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto = value ;
   }

   public String getWwpuserextendedphoto_gxi( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi ;
   }

   public void setWwpuserextendedphoto_gxi( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi = value ;
   }

   public String getWwpuserextendedname( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedname ;
   }

   public void setWwpuserextendedname( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname = value ;
   }

   public String getWwpuserextendedfullname( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname ;
   }

   public void setWwpuserextendedfullname( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname = value ;
   }

   public String getWwpuserextendedphone( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphone ;
   }

   public void setWwpuserextendedphone( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone = value ;
   }

   public String getWwpuserextendedemail( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemail ;
   }

   public void setWwpuserextendedemail( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail = value ;
   }

   public boolean getWwpuserextendedemainotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif ;
   }

   public void setWwpuserextendedemainotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif = value ;
   }

   public boolean getWwpuserextendedsmsnotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif ;
   }

   public void setWwpuserextendedsmsnotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif = value ;
   }

   public boolean getWwpuserextendedmobilenotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif ;
   }

   public void setWwpuserextendedmobilenotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif = value ;
   }

   public boolean getWwpuserextendeddesktopnotif( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif ;
   }

   public void setWwpuserextendeddesktopnotif( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif = value ;
   }

   public boolean getWwpuserextendeddeleted( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted ;
   }

   public void setWwpuserextendeddeleted( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted = value ;
   }

   public java.util.Date getWwpuserextendeddeletedin( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin ;
   }

   public void setWwpuserextendeddeletedin( java.util.Date value )
   {
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_UserExtended_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_UserExtended_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Initialized = value ;
   }

   public String getWwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z ;
   }

   public void setWwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z = value ;
   }

   public String getWwpuserextendedname_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z ;
   }

   public void setWwpuserextendedname_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z = value ;
   }

   public String getWwpuserextendedfullname_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z ;
   }

   public void setWwpuserextendedfullname_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z = value ;
   }

   public String getWwpuserextendedphone_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z ;
   }

   public void setWwpuserextendedphone_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z = value ;
   }

   public String getWwpuserextendedemail_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z ;
   }

   public void setWwpuserextendedemail_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z = value ;
   }

   public boolean getWwpuserextendedemainotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z ;
   }

   public void setWwpuserextendedemainotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z = value ;
   }

   public boolean getWwpuserextendedsmsnotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z ;
   }

   public void setWwpuserextendedsmsnotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z = value ;
   }

   public boolean getWwpuserextendedmobilenotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z ;
   }

   public void setWwpuserextendedmobilenotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z = value ;
   }

   public boolean getWwpuserextendeddesktopnotif_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z ;
   }

   public void setWwpuserextendeddesktopnotif_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z = value ;
   }

   public boolean getWwpuserextendeddeleted_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z ;
   }

   public void setWwpuserextendeddeleted_Z( boolean value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z = value ;
   }

   public java.util.Date getWwpuserextendeddeletedin_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z ;
   }

   public void setWwpuserextendeddeletedin_Z( java.util.Date value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z = value ;
   }

   public String getWwpuserextendedphoto_gxi_Z( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z ;
   }

   public void setWwpuserextendedphoto_gxi_Z( String value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z = value ;
   }

   public byte getWwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N ;
   }

   public void setWwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N = value ;
   }

   public byte getWwpuserextendeddeletedin_N( )
   {
      return gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N ;
   }

   public void setWwpuserextendeddeletedin_N( byte value )
   {
      gxTv_SdtWWP_UserExtended_N = (byte)(0) ;
      gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N = value ;
   }

   protected byte gxTv_SdtWWP_UserExtended_Wwpuserextendedid_N ;
   protected byte gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N ;
   private byte gxTv_SdtWWP_UserExtended_N ;
   protected short gxTv_SdtWWP_UserExtended_Initialized ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedid ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedphone ;
   protected String gxTv_SdtWWP_UserExtended_Mode ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z ;
   protected boolean gxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedname ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedemail ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z ;
   protected String gxTv_SdtWWP_UserExtended_Wwpuserextendedphoto ;
   protected java.util.Date gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin ;
   protected java.util.Date gxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z ;
}

