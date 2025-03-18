package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtImagesData_ImagesDataItem implements Cloneable, java.io.Serializable
{
   public StructSdtImagesData_ImagesDataItem( )
   {
      this( -1, new ModelContext( StructSdtImagesData_ImagesDataItem.class ));
   }

   public StructSdtImagesData_ImagesDataItem( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtImagesData_ImagesDataItem_Id = "" ;
      gxTv_SdtImagesData_ImagesDataItem_Image = "" ;
      gxTv_SdtImagesData_ImagesDataItem_Thumbnail = "" ;
      gxTv_SdtImagesData_ImagesDataItem_Caption = "" ;
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

   public String getId( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Id = value ;
   }

   public String getImage( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Image ;
   }

   public void setImage( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Image = value ;
   }

   public String getThumbnail( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Thumbnail ;
   }

   public void setThumbnail( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Thumbnail = value ;
   }

   public String getCaption( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Caption ;
   }

   public void setCaption( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Caption = value ;
   }

   protected byte gxTv_SdtImagesData_ImagesDataItem_N ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Id ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Image ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Thumbnail ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Caption ;
}

