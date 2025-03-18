package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "DVelop_ECommerceCart", namespace ="Mujer_Morena")
public final  class StructSdtDVelop_ECommerceCart implements Cloneable, java.io.Serializable
{
   public StructSdtDVelop_ECommerceCart( )
   {
      this( -1, new ModelContext( StructSdtDVelop_ECommerceCart.class ));
   }

   public StructSdtDVelop_ECommerceCart( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtDVelop_ECommerceCart( java.util.Vector<StructSdtDVelop_ECommerceCart_Item> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="Item",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtDVelop_ECommerceCart_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVelop_ECommerceCart_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVelop_ECommerceCart_Item> item = new java.util.Vector<>();
}

