package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtWWPProductData implements Cloneable, java.io.Serializable
{
   public StructSdtWWPProductData( )
   {
      this( -1, new ModelContext( StructSdtWWPProductData.class ));
   }

   public StructSdtWWPProductData( int remoteHandle ,
                                   ModelContext context )
   {
      gxTv_SdtWWPProductData_Id = "" ;
      gxTv_SdtWWPProductData_Title = "" ;
      gxTv_SdtWWPProductData_Description = "" ;
      gxTv_SdtWWPProductData_Image = "" ;
      gxTv_SdtWWPProductData_Image_gxi = "" ;
      gxTv_SdtWWPProductData_Subtitle = "" ;
      gxTv_SdtWWPProductData_Information1 = "" ;
      gxTv_SdtWWPProductData_Information2 = "" ;
      gxTv_SdtWWPProductData_Componenttocall = "" ;
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
      return gxTv_SdtWWPProductData_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Id = value ;
   }

   public short getType( )
   {
      return gxTv_SdtWWPProductData_Type ;
   }

   public void setType( short value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Type = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtWWPProductData_Title ;
   }

   public void setTitle( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Title = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtWWPProductData_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Description = value ;
   }

   public String getImage( )
   {
      return gxTv_SdtWWPProductData_Image ;
   }

   public void setImage( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Image = value ;
   }

   public String getImage_gxi( )
   {
      return gxTv_SdtWWPProductData_Image_gxi ;
   }

   public void setImage_gxi( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Image_gxi = value ;
   }

   public String getSubtitle( )
   {
      return gxTv_SdtWWPProductData_Subtitle ;
   }

   public void setSubtitle( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Subtitle = value ;
   }

   public String getInformation1( )
   {
      return gxTv_SdtWWPProductData_Information1 ;
   }

   public void setInformation1( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Information1 = value ;
   }

   public String getInformation2( )
   {
      return gxTv_SdtWWPProductData_Information2 ;
   }

   public void setInformation2( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Information2 = value ;
   }

   public String getComponenttocall( )
   {
      return gxTv_SdtWWPProductData_Componenttocall ;
   }

   public void setComponenttocall( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Componenttocall = value ;
   }

   protected byte gxTv_SdtWWPProductData_N ;
   protected short gxTv_SdtWWPProductData_Type ;
   protected String gxTv_SdtWWPProductData_Id ;
   protected String gxTv_SdtWWPProductData_Title ;
   protected String gxTv_SdtWWPProductData_Description ;
   protected String gxTv_SdtWWPProductData_Image_gxi ;
   protected String gxTv_SdtWWPProductData_Subtitle ;
   protected String gxTv_SdtWWPProductData_Information1 ;
   protected String gxTv_SdtWWPProductData_Information2 ;
   protected String gxTv_SdtWWPProductData_Componenttocall ;
   protected String gxTv_SdtWWPProductData_Image ;
}

