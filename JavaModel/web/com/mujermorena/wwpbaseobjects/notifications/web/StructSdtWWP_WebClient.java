package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.genexus.*;

public final  class StructSdtWWP_WebClient implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_WebClient( )
   {
      this( -1, new ModelContext( StructSdtWWP_WebClient.class ));
   }

   public StructSdtWWP_WebClient( int remoteHandle ,
                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWP_WebClient_Wwpwebclientid = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = cal.getTime() ;
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = cal.getTime() ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_WebClient_Mode = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientid_Z = "" ;
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = cal.getTime() ;
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = cal.getTime() ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = (byte)(1) ;
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

   public String getWwpwebclientid( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientid ;
   }

   public void setWwpwebclientid( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientid = value ;
   }

   public short getWwpwebclientbrowserid( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid ;
   }

   public void setWwpwebclientbrowserid( short value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid = value ;
   }

   public String getWwpwebclientbrowserversion( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion ;
   }

   public void setWwpwebclientbrowserversion( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion = value ;
   }

   public java.util.Date getWwpwebclientfirstregistered( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered ;
   }

   public void setWwpwebclientfirstregistered( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered = value ;
   }

   public java.util.Date getWwpwebclientlastregistered( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered ;
   }

   public void setWwpwebclientlastregistered( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered = value ;
   }

   public String getWwpuserextendedid( )
   {
      return gxTv_SdtWWP_WebClient_Wwpuserextendedid ;
   }

   public void setWwpuserextendedid( String value )
   {
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_WebClient_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_WebClient_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Initialized = value ;
   }

   public String getWwpwebclientid_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientid_Z ;
   }

   public void setWwpwebclientid_Z( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientid_Z = value ;
   }

   public short getWwpwebclientbrowserid_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z ;
   }

   public void setWwpwebclientbrowserid_Z( short value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z = value ;
   }

   public java.util.Date getWwpwebclientfirstregistered_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z ;
   }

   public void setWwpwebclientfirstregistered_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z = value ;
   }

   public java.util.Date getWwpwebclientlastregistered_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z ;
   }

   public void setWwpwebclientlastregistered_Z( java.util.Date value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z = value ;
   }

   public String getWwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z ;
   }

   public void setWwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z = value ;
   }

   public byte getWwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_WebClient_Wwpuserextendedid_N ;
   }

   public void setWwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_WebClient_N = (byte)(0) ;
      gxTv_SdtWWP_WebClient_Wwpuserextendedid_N = value ;
   }

   protected byte gxTv_SdtWWP_WebClient_Wwpuserextendedid_N ;
   private byte gxTv_SdtWWP_WebClient_N ;
   protected short gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid ;
   protected short gxTv_SdtWWP_WebClient_Initialized ;
   protected short gxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z ;
   protected String gxTv_SdtWWP_WebClient_Wwpwebclientid ;
   protected String gxTv_SdtWWP_WebClient_Wwpuserextendedid ;
   protected String gxTv_SdtWWP_WebClient_Mode ;
   protected String gxTv_SdtWWP_WebClient_Wwpwebclientid_Z ;
   protected String gxTv_SdtWWP_WebClient_Wwpuserextendedid_Z ;
   protected String gxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion ;
   protected java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered ;
   protected java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered ;
   protected java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z ;
   protected java.util.Date gxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z ;
}

