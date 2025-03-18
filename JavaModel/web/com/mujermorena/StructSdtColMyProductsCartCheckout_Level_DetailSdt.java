package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColMyProductsCartCheckout_Level_DetailSdt", namespace ="http://tempuri.org/")
public final  class StructSdtColMyProductsCartCheckout_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtColMyProductsCartCheckout_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtColMyProductsCartCheckout_Level_DetailSdt.class ));
   }

   public StructSdtColMyProductsCartCheckout_Level_DetailSdt( int remoteHandle ,
                                                              ModelContext context )
   {
   }

   public  StructSdtColMyProductsCartCheckout_Level_DetailSdt( java.util.Vector<StructSdtMyProductsCartCheckout_Level_DetailSdt> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="MyProductsCartCheckout_Level_DetailSdt",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtMyProductsCartCheckout_Level_DetailSdt> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMyProductsCartCheckout_Level_DetailSdt> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMyProductsCartCheckout_Level_DetailSdt> item = new java.util.Vector<>();
}

