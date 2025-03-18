package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGAMSDNotAuthorized_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtGAMSDNotAuthorized_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtGAMSDNotAuthorized_Level_DetailSdt.class ));
   }

   public StructSdtGAMSDNotAuthorized_Level_DetailSdt( int remoteHandle ,
                                                       ModelContext context )
   {
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User = "" ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password = "" ;
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

   public String getUser( )
   {
      return gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User ;
   }

   public void setUser( String value )
   {
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User = value ;
   }

   public String getPassword( )
   {
      return gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password ;
   }

   public void setPassword( String value )
   {
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password = value ;
   }

   protected byte gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N ;
   protected String gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password ;
   protected String gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User ;
}

