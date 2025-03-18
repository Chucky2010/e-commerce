package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColNMCartPayment", namespace ="Mujer_Morena")
public final  class StructSdtColNMCartPayment implements Cloneable, java.io.Serializable
{
   public StructSdtColNMCartPayment( )
   {
      this( -1, new ModelContext( StructSdtColNMCartPayment.class ));
   }

   public StructSdtColNMCartPayment( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtColNMCartPayment( java.util.Vector<StructSdtNMCartPayment> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="NMCartPayment",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtNMCartPayment> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtNMCartPayment> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtNMCartPayment> item = new java.util.Vector<>();
}

