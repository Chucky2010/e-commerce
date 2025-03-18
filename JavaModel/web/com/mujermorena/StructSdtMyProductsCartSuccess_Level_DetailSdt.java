package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtMyProductsCartSuccess_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtMyProductsCartSuccess_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtMyProductsCartSuccess_Level_DetailSdt.class ));
   }

   public StructSdtMyProductsCartSuccess_Level_DetailSdt( int remoteHandle ,
                                                          ModelContext context )
   {
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

   public short getCalificacionnro( )
   {
      return gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro ;
   }

   public void setCalificacionnro( short value )
   {
      gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro = value ;
   }

   protected byte gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_N ;
   protected short gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro ;
}

