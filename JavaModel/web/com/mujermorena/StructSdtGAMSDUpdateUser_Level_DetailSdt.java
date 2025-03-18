package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGAMSDUpdateUser_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtGAMSDUpdateUser_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtGAMSDUpdateUser_Level_DetailSdt.class ));
   }

   public StructSdtGAMSDUpdateUser_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid = "" ;
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
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username ;
   }

   public void setUsername( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username = value ;
   }

   public String getEmail( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email ;
   }

   public void setEmail( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email = value ;
   }

   public String getFirstname( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname ;
   }

   public void setFirstname( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname = value ;
   }

   public String getLastname( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname ;
   }

   public void setLastname( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname = value ;
   }

   public String getUserguid( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid ;
   }

   public void setUserguid( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid = value ;
   }

   protected byte gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email ;
}

