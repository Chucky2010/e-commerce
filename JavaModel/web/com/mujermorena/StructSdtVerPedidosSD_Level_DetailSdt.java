package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtVerPedidosSD_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtVerPedidosSD_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtVerPedidosSD_Level_DetailSdt.class ));
   }

   public StructSdtVerPedidosSD_Level_DetailSdt( int remoteHandle ,
                                                 ModelContext context )
   {
      gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop = "" ;
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

   public boolean getIsauthorized_useraction1( )
   {
      return gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 ;
   }

   public void setIsauthorized_useraction1( boolean value )
   {
      gxTv_SdtVerPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 = value ;
   }

   public String getGxdynprop( )
   {
      return gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop ;
   }

   public void setGxdynprop( String value )
   {
      gxTv_SdtVerPedidosSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop = value ;
   }

   protected byte gxTv_SdtVerPedidosSD_Level_DetailSdt_N ;
   protected String gxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop ;
   protected boolean gxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1 ;
}

