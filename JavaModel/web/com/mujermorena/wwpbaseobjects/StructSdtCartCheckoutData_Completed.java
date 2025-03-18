package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtCartCheckoutData_Completed implements Cloneable, java.io.Serializable
{
   public StructSdtCartCheckoutData_Completed( )
   {
      this( -1, new ModelContext( StructSdtCartCheckoutData_Completed.class ));
   }

   public StructSdtCartCheckoutData_Completed( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtCartCheckoutData_Completed_Comentario = "" ;
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

   public short getCalificacion( )
   {
      return gxTv_SdtCartCheckoutData_Completed_Calificacion ;
   }

   public void setCalificacion( short value )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Completed_Calificacion = value ;
   }

   public String getComentario( )
   {
      return gxTv_SdtCartCheckoutData_Completed_Comentario ;
   }

   public void setComentario( String value )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Completed_Comentario = value ;
   }

   protected byte gxTv_SdtCartCheckoutData_Completed_N ;
   protected short gxTv_SdtCartCheckoutData_Completed_Calificacion ;
   protected String gxTv_SdtCartCheckoutData_Completed_Comentario ;
}

