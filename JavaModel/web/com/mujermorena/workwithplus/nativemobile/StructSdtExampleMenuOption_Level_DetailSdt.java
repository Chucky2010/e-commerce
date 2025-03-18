package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtExampleMenuOption_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtExampleMenuOption_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtExampleMenuOption_Level_DetailSdt.class ));
   }

   public StructSdtExampleMenuOption_Level_DetailSdt( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop = "" ;
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
      return gxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtExampleMenuOption_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtExampleMenuOption_Level_DetailSdt_N ;
   protected String gxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop ;
}

