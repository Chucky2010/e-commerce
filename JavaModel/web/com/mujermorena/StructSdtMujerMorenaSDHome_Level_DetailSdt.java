package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMujerMorenaSDHome_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMujerMorenaSDHome_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMujerMorenaSDHome_Level_DetailSdt.class ));
   }

   public StructSdtMujerMorenaSDHome_Level_DetailSdt( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop = "" ;
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
      return gxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtMujerMorenaSDHome_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtMujerMorenaSDHome_Level_DetailSdt_N ;
   protected String gxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop ;
}

