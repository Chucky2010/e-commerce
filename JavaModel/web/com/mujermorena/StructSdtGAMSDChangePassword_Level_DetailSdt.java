package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGAMSDChangePassword_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtGAMSDChangePassword_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtGAMSDChangePassword_Level_DetailSdt.class ));
   }

   public StructSdtGAMSDChangePassword_Level_DetailSdt( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username = "" ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword = "" ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew = "" ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf = "" ;
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

   public String getUsername( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username ;
   }

   public void setUsername( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username = value ;
   }

   public String getUserpassword( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword ;
   }

   public void setUserpassword( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword = value ;
   }

   public String getUserpasswordnew( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew ;
   }

   public void setUserpasswordnew( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew = value ;
   }

   public String getUserpasswordnewconf( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf ;
   }

   public void setUserpasswordnewconf( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf = value ;
   }

   public boolean getIspasswordexpires( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires ;
   }

   public void setIspasswordexpires( boolean value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires = value ;
   }

   protected byte gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf ;
   protected boolean gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username ;
}

