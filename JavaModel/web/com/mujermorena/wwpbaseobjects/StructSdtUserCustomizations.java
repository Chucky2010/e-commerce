package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtUserCustomizations implements Cloneable, java.io.Serializable
{
   public StructSdtUserCustomizations( )
   {
      this( -1, new ModelContext( StructSdtUserCustomizations.class ));
   }

   public StructSdtUserCustomizations( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtUserCustomizations_Usercustomizationsid = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationskey = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationsvalue = "" ;
      gxTv_SdtUserCustomizations_Mode = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationsid_Z = "" ;
      gxTv_SdtUserCustomizations_Usercustomizationskey_Z = "" ;
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

   public String getUsercustomizationsid( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationsid ;
   }

   public void setUsercustomizationsid( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Usercustomizationsid = value ;
   }

   public String getUsercustomizationskey( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationskey ;
   }

   public void setUsercustomizationskey( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Usercustomizationskey = value ;
   }

   public String getUsercustomizationsvalue( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationsvalue ;
   }

   public void setUsercustomizationsvalue( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Usercustomizationsvalue = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtUserCustomizations_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtUserCustomizations_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Initialized = value ;
   }

   public String getUsercustomizationsid_Z( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationsid_Z ;
   }

   public void setUsercustomizationsid_Z( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Usercustomizationsid_Z = value ;
   }

   public String getUsercustomizationskey_Z( )
   {
      return gxTv_SdtUserCustomizations_Usercustomizationskey_Z ;
   }

   public void setUsercustomizationskey_Z( String value )
   {
      gxTv_SdtUserCustomizations_N = (byte)(0) ;
      gxTv_SdtUserCustomizations_Usercustomizationskey_Z = value ;
   }

   private byte gxTv_SdtUserCustomizations_N ;
   protected short gxTv_SdtUserCustomizations_Initialized ;
   protected String gxTv_SdtUserCustomizations_Usercustomizationsid ;
   protected String gxTv_SdtUserCustomizations_Mode ;
   protected String gxTv_SdtUserCustomizations_Usercustomizationsid_Z ;
   protected String gxTv_SdtUserCustomizations_Usercustomizationsvalue ;
   protected String gxTv_SdtUserCustomizations_Usercustomizationskey ;
   protected String gxTv_SdtUserCustomizations_Usercustomizationskey_Z ;
}

