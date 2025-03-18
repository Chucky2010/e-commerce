package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.genexus.*;

public final  class StructSdtWWP_Subscription implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_Subscription( )
   {
      this( -1, new ModelContext( StructSdtWWP_Subscription.class ));
   }

   public StructSdtWWP_Subscription( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription = "" ;
      gxTv_SdtWWP_Subscription_Wwpentityname = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = "" ;
      gxTv_SdtWWP_Subscription_Mode = "" ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpentityname_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z = "" ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = (byte)(1) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = (byte)(1) ;
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

   public long getWwpsubscriptionid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionid ;
   }

   public void setWwpsubscriptionid( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionid = value ;
   }

   public long getWwpnotificationdefinitionid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid ;
   }

   public void setWwpnotificationdefinitionid( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid = value ;
   }

   public String getWwpnotificationdefinitiondescription( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription ;
   }

   public void setWwpnotificationdefinitiondescription( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription = value ;
   }

   public String getWwpentityname( )
   {
      return gxTv_SdtWWP_Subscription_Wwpentityname ;
   }

   public void setWwpentityname( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpentityname = value ;
   }

   public String getWwpuserextendedid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedid ;
   }

   public void setWwpuserextendedid( String value )
   {
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid = value ;
   }

   public String getWwpuserextendedfullname( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedfullname ;
   }

   public void setWwpuserextendedfullname( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname = value ;
   }

   public String getWwpsubscriptionentityrecordid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid ;
   }

   public void setWwpsubscriptionentityrecordid( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid = value ;
   }

   public String getWwpsubscriptionentityrecorddescription( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription ;
   }

   public void setWwpsubscriptionentityrecorddescription( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription = value ;
   }

   public String getWwpsubscriptionroleid( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid ;
   }

   public void setWwpsubscriptionroleid( String value )
   {
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid = value ;
   }

   public boolean getWwpsubscriptionsubscribed( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed ;
   }

   public void setWwpsubscriptionsubscribed( boolean value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_Subscription_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_Subscription_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Initialized = value ;
   }

   public long getWwpsubscriptionid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z ;
   }

   public void setWwpsubscriptionid_Z( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z = value ;
   }

   public long getWwpnotificationdefinitionid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z ;
   }

   public void setWwpnotificationdefinitionid_Z( long value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z = value ;
   }

   public String getWwpnotificationdefinitiondescription_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z ;
   }

   public void setWwpnotificationdefinitiondescription_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z = value ;
   }

   public String getWwpentityname_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpentityname_Z ;
   }

   public void setWwpentityname_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpentityname_Z = value ;
   }

   public String getWwpuserextendedid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z ;
   }

   public void setWwpuserextendedid_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z = value ;
   }

   public String getWwpuserextendedfullname_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z ;
   }

   public void setWwpuserextendedfullname_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z = value ;
   }

   public String getWwpsubscriptionentityrecordid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z ;
   }

   public void setWwpsubscriptionentityrecordid_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z = value ;
   }

   public String getWwpsubscriptionentityrecorddescription_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z ;
   }

   public void setWwpsubscriptionentityrecorddescription_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z = value ;
   }

   public String getWwpsubscriptionroleid_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z ;
   }

   public void setWwpsubscriptionroleid_Z( String value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z = value ;
   }

   public boolean getWwpsubscriptionsubscribed_Z( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z ;
   }

   public void setWwpsubscriptionsubscribed_Z( boolean value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z = value ;
   }

   public byte getWwpuserextendedid_N( )
   {
      return gxTv_SdtWWP_Subscription_Wwpuserextendedid_N ;
   }

   public void setWwpuserextendedid_N( byte value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpuserextendedid_N = value ;
   }

   public byte getWwpsubscriptionroleid_N( )
   {
      return gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N ;
   }

   public void setWwpsubscriptionroleid_N( byte value )
   {
      gxTv_SdtWWP_Subscription_N = (byte)(0) ;
      gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N = value ;
   }

   protected byte gxTv_SdtWWP_Subscription_Wwpuserextendedid_N ;
   protected byte gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N ;
   private byte gxTv_SdtWWP_Subscription_N ;
   protected short gxTv_SdtWWP_Subscription_Initialized ;
   protected long gxTv_SdtWWP_Subscription_Wwpsubscriptionid ;
   protected long gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid ;
   protected long gxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z ;
   protected long gxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpuserextendedid ;
   protected String gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid ;
   protected String gxTv_SdtWWP_Subscription_Mode ;
   protected String gxTv_SdtWWP_Subscription_Wwpuserextendedid_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z ;
   protected boolean gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed ;
   protected boolean gxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription ;
   protected String gxTv_SdtWWP_Subscription_Wwpentityname ;
   protected String gxTv_SdtWWP_Subscription_Wwpuserextendedfullname ;
   protected String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid ;
   protected String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription ;
   protected String gxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpentityname_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z ;
   protected String gxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z ;
}

