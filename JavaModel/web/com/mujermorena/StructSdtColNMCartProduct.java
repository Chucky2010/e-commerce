package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColNMCartProduct", namespace ="Mujer_Morena")
public final  class StructSdtColNMCartProduct implements Cloneable, java.io.Serializable
{
   public StructSdtColNMCartProduct( )
   {
      this( -1, new ModelContext( StructSdtColNMCartProduct.class ));
   }

   public StructSdtColNMCartProduct( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtColNMCartProduct( java.util.Vector<StructSdtNMCartProduct> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="NMCartProduct",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtNMCartProduct> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtNMCartProduct> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtNMCartProduct> item = new java.util.Vector<>();
}

