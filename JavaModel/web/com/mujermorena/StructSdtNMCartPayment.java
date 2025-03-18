package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtNMCartPayment implements Cloneable, java.io.Serializable
{
   public StructSdtNMCartPayment( )
   {
      this( -1, new ModelContext( StructSdtNMCartPayment.class ));
   }

   public StructSdtNMCartPayment( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtNMCartPayment_Visiblename = "" ;
      gxTv_SdtNMCartPayment_Owner = "" ;
      gxTv_SdtNMCartPayment_Valid = "" ;
      gxTv_SdtNMCartPayment_Imagen = "" ;
      gxTv_SdtNMCartPayment_Imagen_gxi = "" ;
      gxTv_SdtNMCartPayment_Nrocomprobante = "" ;
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

   public long getId( )
   {
      return gxTv_SdtNMCartPayment_Id ;
   }

   public void setId( long value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Id = value ;
   }

   public String getVisiblename( )
   {
      return gxTv_SdtNMCartPayment_Visiblename ;
   }

   public void setVisiblename( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Visiblename = value ;
   }

   public String getOwner( )
   {
      return gxTv_SdtNMCartPayment_Owner ;
   }

   public void setOwner( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Owner = value ;
   }

   public String getValid( )
   {
      return gxTv_SdtNMCartPayment_Valid ;
   }

   public void setValid( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Valid = value ;
   }

   public boolean getSelected( )
   {
      return gxTv_SdtNMCartPayment_Selected ;
   }

   public void setSelected( boolean value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Selected = value ;
   }

   public String getImagen( )
   {
      return gxTv_SdtNMCartPayment_Imagen ;
   }

   public void setImagen( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Imagen = value ;
   }

   public String getImagen_gxi( )
   {
      return gxTv_SdtNMCartPayment_Imagen_gxi ;
   }

   public void setImagen_gxi( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Imagen_gxi = value ;
   }

   public String getNrocomprobante( )
   {
      return gxTv_SdtNMCartPayment_Nrocomprobante ;
   }

   public void setNrocomprobante( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Nrocomprobante = value ;
   }

   protected byte gxTv_SdtNMCartPayment_N ;
   protected long gxTv_SdtNMCartPayment_Id ;
   protected boolean gxTv_SdtNMCartPayment_Selected ;
   protected String gxTv_SdtNMCartPayment_Visiblename ;
   protected String gxTv_SdtNMCartPayment_Owner ;
   protected String gxTv_SdtNMCartPayment_Valid ;
   protected String gxTv_SdtNMCartPayment_Imagen_gxi ;
   protected String gxTv_SdtNMCartPayment_Nrocomprobante ;
   protected String gxTv_SdtNMCartPayment_Imagen ;
}

