package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColCartCheckoutData.Address", namespace ="Mujer_Morena")
public final  class StructSdtColCartCheckoutData_Address implements Cloneable, java.io.Serializable
{
   public StructSdtColCartCheckoutData_Address( )
   {
      this( -1, new ModelContext( StructSdtColCartCheckoutData_Address.class ));
   }

   public StructSdtColCartCheckoutData_Address( int remoteHandle ,
                                                ModelContext context )
   {
   }

   public  StructSdtColCartCheckoutData_Address( java.util.Vector<StructSdtCartCheckoutData_Address> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="CartCheckoutData.Address",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtCartCheckoutData_Address> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCartCheckoutData_Address> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCartCheckoutData_Address> item = new java.util.Vector<>();
}

