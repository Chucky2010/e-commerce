package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPContext implements Cloneable, java.io.Serializable
{
   public StructSdtWWPContext( )
   {
      this( -1, new ModelContext( StructSdtWWPContext.class ));
   }

   public StructSdtWWPContext( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtWWPContext_Username = "" ;
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

   public short getUserid( )
   {
      return gxTv_SdtWWPContext_Userid ;
   }

   public void setUserid( short value )
   {
      gxTv_SdtWWPContext_N = (byte)(0) ;
      gxTv_SdtWWPContext_Userid = value ;
   }

   public String getUsername( )
   {
      return gxTv_SdtWWPContext_Username ;
   }

   public void setUsername( String value )
   {
      gxTv_SdtWWPContext_N = (byte)(0) ;
      gxTv_SdtWWPContext_Username = value ;
   }

   protected byte gxTv_SdtWWPContext_N ;
   protected short gxTv_SdtWWPContext_Userid ;
   protected String gxTv_SdtWWPContext_Username ;
}

