package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWP_Entity implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_Entity( )
   {
      this( -1, new ModelContext( StructSdtWWP_Entity.class ));
   }

   public StructSdtWWP_Entity( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtWWP_Entity_Wwpentityname = "" ;
      gxTv_SdtWWP_Entity_Mode = "" ;
      gxTv_SdtWWP_Entity_Wwpentityname_Z = "" ;
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

   public long getWwpentityid( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityid ;
   }

   public void setWwpentityid( long value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      gxTv_SdtWWP_Entity_Wwpentityid = value ;
   }

   public String getWwpentityname( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityname ;
   }

   public void setWwpentityname( String value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      gxTv_SdtWWP_Entity_Wwpentityname = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_Entity_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      gxTv_SdtWWP_Entity_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_Entity_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      gxTv_SdtWWP_Entity_Initialized = value ;
   }

   public long getWwpentityid_Z( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityid_Z ;
   }

   public void setWwpentityid_Z( long value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      gxTv_SdtWWP_Entity_Wwpentityid_Z = value ;
   }

   public String getWwpentityname_Z( )
   {
      return gxTv_SdtWWP_Entity_Wwpentityname_Z ;
   }

   public void setWwpentityname_Z( String value )
   {
      gxTv_SdtWWP_Entity_N = (byte)(0) ;
      gxTv_SdtWWP_Entity_Wwpentityname_Z = value ;
   }

   private byte gxTv_SdtWWP_Entity_N ;
   protected short gxTv_SdtWWP_Entity_Initialized ;
   protected long gxTv_SdtWWP_Entity_Wwpentityid ;
   protected long gxTv_SdtWWP_Entity_Wwpentityid_Z ;
   protected String gxTv_SdtWWP_Entity_Mode ;
   protected String gxTv_SdtWWP_Entity_Wwpentityname ;
   protected String gxTv_SdtWWP_Entity_Wwpentityname_Z ;
}

