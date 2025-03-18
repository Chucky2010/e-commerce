package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtCartCheckoutData_Address implements Cloneable, java.io.Serializable
{
   public StructSdtCartCheckoutData_Address( )
   {
      this( -1, new ModelContext( StructSdtCartCheckoutData_Address.class ));
   }

   public StructSdtCartCheckoutData_Address( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtCartCheckoutData_Address_Name = "" ;
      gxTv_SdtCartCheckoutData_Address_Phone = "" ;
      gxTv_SdtCartCheckoutData_Address_Country = "" ;
      gxTv_SdtCartCheckoutData_Address_Department = "" ;
      gxTv_SdtCartCheckoutData_Address_Address = "" ;
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

   public String getName( )
   {
      return gxTv_SdtCartCheckoutData_Address_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Name = value ;
   }

   public String getPhone( )
   {
      return gxTv_SdtCartCheckoutData_Address_Phone ;
   }

   public void setPhone( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Phone = value ;
   }

   public String getCountry( )
   {
      return gxTv_SdtCartCheckoutData_Address_Country ;
   }

   public void setCountry( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Country = value ;
   }

   public String getDepartment( )
   {
      return gxTv_SdtCartCheckoutData_Address_Department ;
   }

   public void setDepartment( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Department = value ;
   }

   public String getAddress( )
   {
      return gxTv_SdtCartCheckoutData_Address_Address ;
   }

   public void setAddress( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Address = value ;
   }

   protected byte gxTv_SdtCartCheckoutData_Address_N ;
   protected String gxTv_SdtCartCheckoutData_Address_Name ;
   protected String gxTv_SdtCartCheckoutData_Address_Phone ;
   protected String gxTv_SdtCartCheckoutData_Address_Country ;
   protected String gxTv_SdtCartCheckoutData_Address_Department ;
   protected String gxTv_SdtCartCheckoutData_Address_Address ;
}

