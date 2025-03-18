package com.mujermorena.wwpbaseobjects.mail ;
import com.genexus.*;

public final  class StructSdtWWP_Mail_Attachments implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_Mail_Attachments( )
   {
      this( -1, new ModelContext( StructSdtWWP_Mail_Attachments.class ));
   }

   public StructSdtWWP_Mail_Attachments( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname = "" ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile = "" ;
      gxTv_SdtWWP_Mail_Attachments_Mode = "" ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z = "" ;
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

   public String getWwpmailattachmentname( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname ;
   }

   public void setWwpmailattachmentname( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname = value ;
   }

   public String getWwpmailattachmentfile( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile ;
   }

   public void setWwpmailattachmentfile( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Initialized = value ;
   }

   public String getWwpmailattachmentname_Z( )
   {
      return gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z ;
   }

   public void setWwpmailattachmentname_Z( String value )
   {
      gxTv_SdtWWP_Mail_Attachments_N = (byte)(0) ;
      gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z = value ;
   }

   private byte gxTv_SdtWWP_Mail_Attachments_N ;
   protected short gxTv_SdtWWP_Mail_Attachments_Modified ;
   protected short gxTv_SdtWWP_Mail_Attachments_Initialized ;
   protected String gxTv_SdtWWP_Mail_Attachments_Mode ;
   protected String gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile ;
   protected String gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname ;
   protected String gxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z ;
}

