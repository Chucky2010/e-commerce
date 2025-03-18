package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtCartCheckoutData implements Cloneable, java.io.Serializable
{
   public StructSdtCartCheckoutData( )
   {
      this( -1, new ModelContext( StructSdtCartCheckoutData.class ));
   }

   public StructSdtCartCheckoutData( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Placeorder_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Auxiliardata_N = (byte)(1) ;
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

   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address getAddress( )
   {
      return gxTv_SdtCartCheckoutData_Address ;
   }

   public void setAddress( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address = value;
   }

   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment getPayment( )
   {
      return gxTv_SdtCartCheckoutData_Payment ;
   }

   public void setPayment( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment = value;
   }

   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder getPlaceorder( )
   {
      return gxTv_SdtCartCheckoutData_Placeorder ;
   }

   public void setPlaceorder( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder value )
   {
      gxTv_SdtCartCheckoutData_Placeorder_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Placeorder = value;
   }

   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed getCompleted( )
   {
      return gxTv_SdtCartCheckoutData_Completed ;
   }

   public void setCompleted( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed value )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Completed = value;
   }

   public java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> getAuxiliardata( )
   {
      return gxTv_SdtCartCheckoutData_Auxiliardata ;
   }

   public void setAuxiliardata( java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      gxTv_SdtCartCheckoutData_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Auxiliardata = value ;
   }

   protected byte gxTv_SdtCartCheckoutData_Address_N ;
   protected byte gxTv_SdtCartCheckoutData_Payment_N ;
   protected byte gxTv_SdtCartCheckoutData_Placeorder_N ;
   protected byte gxTv_SdtCartCheckoutData_Completed_N ;
   protected byte gxTv_SdtCartCheckoutData_Auxiliardata_N ;
   protected byte gxTv_SdtCartCheckoutData_N ;
   protected com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address gxTv_SdtCartCheckoutData_Address=null ;
   protected com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment gxTv_SdtCartCheckoutData_Payment=null ;
   protected com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder gxTv_SdtCartCheckoutData_Placeorder=null ;
   protected com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed gxTv_SdtCartCheckoutData_Completed=null ;
   protected java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtCartCheckoutData_Auxiliardata=null ;
}

