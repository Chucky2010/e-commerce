package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMujerMorenaSDOB_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMujerMorenaSDOB_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMujerMorenaSDOB_Level_DetailSdt.class ));
   }

   public StructSdtMujerMorenaSDOB_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop = "" ;
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

   public String getGxdynprop( )
   {
      return gxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMujerMorenaSDOB_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtMujerMorenaSDOB_Level_DetailSdt_N ;
   protected String gxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop ;
}

