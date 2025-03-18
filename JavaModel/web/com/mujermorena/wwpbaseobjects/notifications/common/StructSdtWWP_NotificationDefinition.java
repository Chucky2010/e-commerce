package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

public final  class StructSdtWWP_NotificationDefinition implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_NotificationDefinition( )
   {
      this( -1, new ModelContext( StructSdtWWP_NotificationDefinition.class ));
   }

   public StructSdtWWP_NotificationDefinition( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality = "" ;
      gxTv_SdtWWP_NotificationDefinition_Mode = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z = "" ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z = "" ;
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

   public long getWwpnotificationdefinitionid( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid ;
   }

   public void setWwpnotificationdefinitionid( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid = value ;
   }

   public String getWwpnotificationdefinitionname( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname ;
   }

   public void setWwpnotificationdefinitionname( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname = value ;
   }

   public byte getWwpnotificationdefinitionappliesto( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto ;
   }

   public void setWwpnotificationdefinitionappliesto( byte value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto = value ;
   }

   public boolean getWwpnotificationdefinitionallowusersubscription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription ;
   }

   public void setWwpnotificationdefinitionallowusersubscription( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription = value ;
   }

   public String getWwpnotificationdefinitiondescription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription ;
   }

   public void setWwpnotificationdefinitiondescription( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription = value ;
   }

   public String getWwpnotificationdefinitionicon( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon ;
   }

   public void setWwpnotificationdefinitionicon( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon = value ;
   }

   public String getWwpnotificationdefinitiontitle( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle ;
   }

   public void setWwpnotificationdefinitiontitle( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle = value ;
   }

   public String getWwpnotificationdefinitionshortdescription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription ;
   }

   public void setWwpnotificationdefinitionshortdescription( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription = value ;
   }

   public String getWwpnotificationdefinitionlongdescription( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription ;
   }

   public void setWwpnotificationdefinitionlongdescription( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription = value ;
   }

   public String getWwpnotificationdefinitionlink( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink ;
   }

   public void setWwpnotificationdefinitionlink( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink = value ;
   }

   public long getWwpentityid( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityid ;
   }

   public void setWwpentityid( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityid = value ;
   }

   public String getWwpentityname( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityname ;
   }

   public void setWwpentityname( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname = value ;
   }

   public String getWwpnotificationdefinitionsecfuncionality( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality ;
   }

   public void setWwpnotificationdefinitionsecfuncionality( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality = value ;
   }

   public boolean getWwpnotificationdefinitionisauthorized( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized ;
   }

   public void setWwpnotificationdefinitionisauthorized( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Initialized = value ;
   }

   public long getWwpnotificationdefinitionid_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z ;
   }

   public void setWwpnotificationdefinitionid_Z( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z = value ;
   }

   public String getWwpnotificationdefinitionname_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z ;
   }

   public void setWwpnotificationdefinitionname_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z = value ;
   }

   public byte getWwpnotificationdefinitionappliesto_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z ;
   }

   public void setWwpnotificationdefinitionappliesto_Z( byte value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z = value ;
   }

   public boolean getWwpnotificationdefinitionallowusersubscription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z ;
   }

   public void setWwpnotificationdefinitionallowusersubscription_Z( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z = value ;
   }

   public String getWwpnotificationdefinitiondescription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z ;
   }

   public void setWwpnotificationdefinitiondescription_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z = value ;
   }

   public String getWwpnotificationdefinitionicon_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z ;
   }

   public void setWwpnotificationdefinitionicon_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z = value ;
   }

   public String getWwpnotificationdefinitiontitle_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z ;
   }

   public void setWwpnotificationdefinitiontitle_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z = value ;
   }

   public String getWwpnotificationdefinitionshortdescription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z ;
   }

   public void setWwpnotificationdefinitionshortdescription_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z = value ;
   }

   public String getWwpnotificationdefinitionlongdescription_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z ;
   }

   public void setWwpnotificationdefinitionlongdescription_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z = value ;
   }

   public String getWwpnotificationdefinitionlink_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z ;
   }

   public void setWwpnotificationdefinitionlink_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z = value ;
   }

   public long getWwpentityid_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z ;
   }

   public void setWwpentityid_Z( long value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z = value ;
   }

   public String getWwpentityname_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z ;
   }

   public void setWwpentityname_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z = value ;
   }

   public String getWwpnotificationdefinitionsecfuncionality_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z ;
   }

   public void setWwpnotificationdefinitionsecfuncionality_Z( String value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z = value ;
   }

   public boolean getWwpnotificationdefinitionisauthorized_Z( )
   {
      return gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z ;
   }

   public void setWwpnotificationdefinitionisauthorized_Z( boolean value )
   {
      gxTv_SdtWWP_NotificationDefinition_N = (byte)(0) ;
      gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z = value ;
   }

   protected byte gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto ;
   protected byte gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z ;
   private byte gxTv_SdtWWP_NotificationDefinition_N ;
   protected short gxTv_SdtWWP_NotificationDefinition_Initialized ;
   protected long gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid ;
   protected long gxTv_SdtWWP_NotificationDefinition_Wwpentityid ;
   protected long gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z ;
   protected long gxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Mode ;
   protected boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription ;
   protected boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized ;
   protected boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z ;
   protected boolean gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpentityname ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z ;
   protected String gxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z ;
}

