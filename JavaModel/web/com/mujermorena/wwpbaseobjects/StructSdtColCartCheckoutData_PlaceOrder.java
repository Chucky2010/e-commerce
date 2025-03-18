package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColCartCheckoutData.PlaceOrder", namespace ="Mujer_Morena")
public final  class StructSdtColCartCheckoutData_PlaceOrder implements Cloneable, java.io.Serializable
{
   public StructSdtColCartCheckoutData_PlaceOrder( )
   {
      this( -1, new ModelContext( StructSdtColCartCheckoutData_PlaceOrder.class ));
   }

   public StructSdtColCartCheckoutData_PlaceOrder( int remoteHandle ,
                                                   ModelContext context )
   {
   }

   public  StructSdtColCartCheckoutData_PlaceOrder( java.util.Vector<StructSdtCartCheckoutData_PlaceOrder> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="CartCheckoutData.PlaceOrder",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtCartCheckoutData_PlaceOrder> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCartCheckoutData_PlaceOrder> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCartCheckoutData_PlaceOrder> item = new java.util.Vector<>();
}

