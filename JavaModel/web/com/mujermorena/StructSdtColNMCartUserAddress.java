package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColNMCartUserAddress", namespace ="Mujer_Morena")
public final  class StructSdtColNMCartUserAddress implements Cloneable, java.io.Serializable
{
   public StructSdtColNMCartUserAddress( )
   {
      this( -1, new ModelContext( StructSdtColNMCartUserAddress.class ));
   }

   public StructSdtColNMCartUserAddress( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtColNMCartUserAddress( java.util.Vector<StructSdtNMCartUserAddress> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="NMCartUserAddress",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtNMCartUserAddress> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtNMCartUserAddress> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtNMCartUserAddress> item = new java.util.Vector<>();
}

