package com.mujermorena.wwpbaseobjects.mail ;
import com.genexus.*;

public final  class StructSdtWWP_MailTemplate implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_MailTemplate( )
   {
      this( -1, new ModelContext( StructSdtWWP_MailTemplate.class ));
   }

   public StructSdtWWP_MailTemplate( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername = "" ;
      gxTv_SdtWWP_MailTemplate_Mode = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z = "" ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z = "" ;
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

   public String getWwpmailtemplatename( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename ;
   }

   public void setWwpmailtemplatename( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename = value ;
   }

   public String getWwpmailtemplatedescription( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription ;
   }

   public void setWwpmailtemplatedescription( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription = value ;
   }

   public String getWwpmailtemplatesubject( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject ;
   }

   public void setWwpmailtemplatesubject( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject = value ;
   }

   public String getWwpmailtemplatebody( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody ;
   }

   public void setWwpmailtemplatebody( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody = value ;
   }

   public String getWwpmailtemplatesenderaddress( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress ;
   }

   public void setWwpmailtemplatesenderaddress( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress = value ;
   }

   public String getWwpmailtemplatesendername( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername ;
   }

   public void setWwpmailtemplatesendername( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_MailTemplate_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_MailTemplate_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Initialized = value ;
   }

   public String getWwpmailtemplatename_Z( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z ;
   }

   public void setWwpmailtemplatename_Z( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z = value ;
   }

   public String getWwpmailtemplatedescription_Z( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z ;
   }

   public void setWwpmailtemplatedescription_Z( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z = value ;
   }

   public String getWwpmailtemplatesubject_Z( )
   {
      return gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z ;
   }

   public void setWwpmailtemplatesubject_Z( String value )
   {
      gxTv_SdtWWP_MailTemplate_N = (byte)(0) ;
      gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z = value ;
   }

   private byte gxTv_SdtWWP_MailTemplate_N ;
   protected short gxTv_SdtWWP_MailTemplate_Initialized ;
   protected String gxTv_SdtWWP_MailTemplate_Mode ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z ;
   protected String gxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z ;
}

