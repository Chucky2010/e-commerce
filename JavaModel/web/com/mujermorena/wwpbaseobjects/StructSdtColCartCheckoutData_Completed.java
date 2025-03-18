package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColCartCheckoutData.Completed", namespace ="Mujer_Morena")
public final  class StructSdtColCartCheckoutData_Completed implements Cloneable, java.io.Serializable
{
   public StructSdtColCartCheckoutData_Completed( )
   {
      this( -1, new ModelContext( StructSdtColCartCheckoutData_Completed.class ));
   }

   public StructSdtColCartCheckoutData_Completed( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColCartCheckoutData_Completed( java.util.Vector<StructSdtCartCheckoutData_Completed> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="CartCheckoutData.Completed",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtCartCheckoutData_Completed> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCartCheckoutData_Completed> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCartCheckoutData_Completed> item = new java.util.Vector<>();
}

