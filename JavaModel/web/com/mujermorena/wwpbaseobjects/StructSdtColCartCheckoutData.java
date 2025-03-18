package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColCartCheckoutData", namespace ="Mujer_Morena")
public final  class StructSdtColCartCheckoutData implements Cloneable, java.io.Serializable
{
   public StructSdtColCartCheckoutData( )
   {
      this( -1, new ModelContext( StructSdtColCartCheckoutData.class ));
   }

   public StructSdtColCartCheckoutData( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColCartCheckoutData( java.util.Vector<StructSdtCartCheckoutData> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="CartCheckoutData",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtCartCheckoutData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCartCheckoutData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCartCheckoutData> item = new java.util.Vector<>();
}

