package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtWWPProductDataImages implements Cloneable, java.io.Serializable
{
   public StructSdtWWPProductDataImages( )
   {
      this( -1, new ModelContext( StructSdtWWPProductDataImages.class ));
   }

   public StructSdtWWPProductDataImages( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtWWPProductDataImages_Image = "" ;
      gxTv_SdtWWPProductDataImages_Image_gxi = "" ;
      gxTv_SdtWWPProductDataImages_Description = "" ;
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

   public String getImage( )
   {
      return gxTv_SdtWWPProductDataImages_Image ;
   }

   public void setImage( String value )
   {
      gxTv_SdtWWPProductDataImages_N = (byte)(0) ;
      gxTv_SdtWWPProductDataImages_Image = value ;
   }

   public String getImage_gxi( )
   {
      return gxTv_SdtWWPProductDataImages_Image_gxi ;
   }

   public void setImage_gxi( String value )
   {
      gxTv_SdtWWPProductDataImages_N = (byte)(0) ;
      gxTv_SdtWWPProductDataImages_Image_gxi = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtWWPProductDataImages_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtWWPProductDataImages_N = (byte)(0) ;
      gxTv_SdtWWPProductDataImages_Description = value ;
   }

   protected byte gxTv_SdtWWPProductDataImages_N ;
   protected String gxTv_SdtWWPProductDataImages_Image_gxi ;
   protected String gxTv_SdtWWPProductDataImages_Description ;
   protected String gxTv_SdtWWPProductDataImages_Image ;
}

