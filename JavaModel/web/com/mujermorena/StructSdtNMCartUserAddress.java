package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtNMCartUserAddress implements Cloneable, java.io.Serializable
{
   public StructSdtNMCartUserAddress( )
   {
      this( -1, new ModelContext( StructSdtNMCartUserAddress.class ));
   }

   public StructSdtNMCartUserAddress( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtNMCartUserAddress_Personname = "" ;
      gxTv_SdtNMCartUserAddress_Addressline1 = "" ;
      gxTv_SdtNMCartUserAddress_Addressline2 = "" ;
      gxTv_SdtNMCartUserAddress_Countryname = "" ;
      gxTv_SdtNMCartUserAddress_Statename = "" ;
      gxTv_SdtNMCartUserAddress_Phonenumber = "" ;
      gxTv_SdtNMCartUserAddress_Ubicacion = "" ;
      gxTv_SdtNMCartUserAddress_Id = "" ;
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

   public String getPersonname( )
   {
      return gxTv_SdtNMCartUserAddress_Personname ;
   }

   public void setPersonname( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Personname = value ;
   }

   public String getAddressline1( )
   {
      return gxTv_SdtNMCartUserAddress_Addressline1 ;
   }

   public void setAddressline1( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Addressline1 = value ;
   }

   public String getAddressline2( )
   {
      return gxTv_SdtNMCartUserAddress_Addressline2 ;
   }

   public void setAddressline2( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Addressline2 = value ;
   }

   public String getCountryname( )
   {
      return gxTv_SdtNMCartUserAddress_Countryname ;
   }

   public void setCountryname( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Countryname = value ;
   }

   public String getStatename( )
   {
      return gxTv_SdtNMCartUserAddress_Statename ;
   }

   public void setStatename( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Statename = value ;
   }

   public String getPhonenumber( )
   {
      return gxTv_SdtNMCartUserAddress_Phonenumber ;
   }

   public void setPhonenumber( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Phonenumber = value ;
   }

   public String getUbicacion( )
   {
      return gxTv_SdtNMCartUserAddress_Ubicacion ;
   }

   public void setUbicacion( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Ubicacion = value ;
   }

   public String getId( )
   {
      return gxTv_SdtNMCartUserAddress_Id ;
   }

   public void setId( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Id = value ;
   }

   protected byte gxTv_SdtNMCartUserAddress_N ;
   protected String gxTv_SdtNMCartUserAddress_Phonenumber ;
   protected String gxTv_SdtNMCartUserAddress_Ubicacion ;
   protected String gxTv_SdtNMCartUserAddress_Personname ;
   protected String gxTv_SdtNMCartUserAddress_Addressline1 ;
   protected String gxTv_SdtNMCartUserAddress_Addressline2 ;
   protected String gxTv_SdtNMCartUserAddress_Countryname ;
   protected String gxTv_SdtNMCartUserAddress_Statename ;
   protected String gxTv_SdtNMCartUserAddress_Id ;
}

