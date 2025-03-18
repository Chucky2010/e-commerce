package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtCartCheckoutData_Payment implements Cloneable, java.io.Serializable
{
   public StructSdtCartCheckoutData_Payment( )
   {
      this( -1, new ModelContext( StructSdtCartCheckoutData_Payment.class ));
   }

   public StructSdtCartCheckoutData_Payment( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtCartCheckoutData_Payment_Paymentdata_description = "" ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata = "" ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description = "" ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata3 = "" ;
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

   public String getPaymentdata_description( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata_description ;
   }

   public void setPaymentdata_description( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata_description = value ;
   }

   public String getPaymentdata( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata ;
   }

   public void setPaymentdata( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata = value ;
   }

   public String getPaymentdata2_description( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description ;
   }

   public void setPaymentdata2_description( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description = value ;
   }

   public short getPaymentdata2( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata2 ;
   }

   public void setPaymentdata2( short value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata2 = value ;
   }

   public String getPaymentdata3( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata3 ;
   }

   public void setPaymentdata3( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata3 = value ;
   }

   protected byte gxTv_SdtCartCheckoutData_Payment_N ;
   protected short gxTv_SdtCartCheckoutData_Payment_Paymentdata2 ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata3 ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata_description ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description ;
}

