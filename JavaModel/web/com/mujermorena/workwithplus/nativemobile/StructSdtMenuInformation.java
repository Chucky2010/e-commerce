package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtMenuInformation implements Cloneable, java.io.Serializable
{
   public StructSdtMenuInformation( )
   {
      this( -1, new ModelContext( StructSdtMenuInformation.class ));
   }

   public StructSdtMenuInformation( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtMenuInformation_Image = "" ;
      gxTv_SdtMenuInformation_Image_gxi = "" ;
      gxTv_SdtMenuInformation_Titleinfo = "" ;
      gxTv_SdtMenuInformation_Secondaryinfo = "" ;
      gxTv_SdtMenuInformation_Componenttocall = "" ;
      gxTv_SdtMenuInformation_Id = "" ;
      gxTv_SdtMenuInformation_Infofield1 = "" ;
      gxTv_SdtMenuInformation_Infofield2 = "" ;
      gxTv_SdtMenuInformation_Infofield3 = "" ;
      gxTv_SdtMenuInformation_Infofield4 = "" ;
      gxTv_SdtMenuInformation_Infofieldnumeric1 = new java.math.BigDecimal(0) ;
      gxTv_SdtMenuInformation_Infofieldnumeric2 = new java.math.BigDecimal(0) ;
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
      return gxTv_SdtMenuInformation_Image ;
   }

   public void setImage( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Image = value ;
   }

   public String getImage_gxi( )
   {
      return gxTv_SdtMenuInformation_Image_gxi ;
   }

   public void setImage_gxi( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Image_gxi = value ;
   }

   public String getTitleinfo( )
   {
      return gxTv_SdtMenuInformation_Titleinfo ;
   }

   public void setTitleinfo( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Titleinfo = value ;
   }

   public String getSecondaryinfo( )
   {
      return gxTv_SdtMenuInformation_Secondaryinfo ;
   }

   public void setSecondaryinfo( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Secondaryinfo = value ;
   }

   public String getComponenttocall( )
   {
      return gxTv_SdtMenuInformation_Componenttocall ;
   }

   public void setComponenttocall( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Componenttocall = value ;
   }

   public String getId( )
   {
      return gxTv_SdtMenuInformation_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Id = value ;
   }

   public String getInfofield1( )
   {
      return gxTv_SdtMenuInformation_Infofield1 ;
   }

   public void setInfofield1( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield1 = value ;
   }

   public String getInfofield2( )
   {
      return gxTv_SdtMenuInformation_Infofield2 ;
   }

   public void setInfofield2( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield2 = value ;
   }

   public String getInfofield3( )
   {
      return gxTv_SdtMenuInformation_Infofield3 ;
   }

   public void setInfofield3( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield3 = value ;
   }

   public String getInfofield4( )
   {
      return gxTv_SdtMenuInformation_Infofield4 ;
   }

   public void setInfofield4( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield4 = value ;
   }

   public java.math.BigDecimal getInfofieldnumeric1( )
   {
      return gxTv_SdtMenuInformation_Infofieldnumeric1 ;
   }

   public void setInfofieldnumeric1( java.math.BigDecimal value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofieldnumeric1 = value ;
   }

   public java.math.BigDecimal getInfofieldnumeric2( )
   {
      return gxTv_SdtMenuInformation_Infofieldnumeric2 ;
   }

   public void setInfofieldnumeric2( java.math.BigDecimal value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofieldnumeric2 = value ;
   }

   protected byte gxTv_SdtMenuInformation_N ;
   protected String gxTv_SdtMenuInformation_Image_gxi ;
   protected String gxTv_SdtMenuInformation_Titleinfo ;
   protected String gxTv_SdtMenuInformation_Secondaryinfo ;
   protected String gxTv_SdtMenuInformation_Componenttocall ;
   protected String gxTv_SdtMenuInformation_Id ;
   protected String gxTv_SdtMenuInformation_Infofield1 ;
   protected String gxTv_SdtMenuInformation_Infofield2 ;
   protected String gxTv_SdtMenuInformation_Infofield3 ;
   protected String gxTv_SdtMenuInformation_Infofield4 ;
   protected String gxTv_SdtMenuInformation_Image ;
   protected java.math.BigDecimal gxTv_SdtMenuInformation_Infofieldnumeric1 ;
   protected java.math.BigDecimal gxTv_SdtMenuInformation_Infofieldnumeric2 ;
}

