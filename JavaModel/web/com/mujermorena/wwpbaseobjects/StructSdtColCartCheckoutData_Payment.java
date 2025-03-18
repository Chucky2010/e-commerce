package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColCartCheckoutData.Payment", namespace ="Mujer_Morena")
public final  class StructSdtColCartCheckoutData_Payment implements Cloneable, java.io.Serializable
{
   public StructSdtColCartCheckoutData_Payment( )
   {
      this( -1, new ModelContext( StructSdtColCartCheckoutData_Payment.class ));
   }

   public StructSdtColCartCheckoutData_Payment( int remoteHandle ,
                                                ModelContext context )
   {
   }

   public  StructSdtColCartCheckoutData_Payment( java.util.Vector<StructSdtCartCheckoutData_Payment> value )
   {
      item = value;
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

   @jakarta.xml.bind.annotation.XmlElement(name="CartCheckoutData.Payment",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtCartCheckoutData_Payment> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCartCheckoutData_Payment> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCartCheckoutData_Payment> item = new java.util.Vector<>();
}

