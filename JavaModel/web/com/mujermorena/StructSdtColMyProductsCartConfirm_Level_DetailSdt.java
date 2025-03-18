package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColMyProductsCartConfirm_Level_DetailSdt", namespace ="http://tempuri.org/")
public final  class StructSdtColMyProductsCartConfirm_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtColMyProductsCartConfirm_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtColMyProductsCartConfirm_Level_DetailSdt.class ));
   }

   public StructSdtColMyProductsCartConfirm_Level_DetailSdt( int remoteHandle ,
                                                             ModelContext context )
   {
   }

   public  StructSdtColMyProductsCartConfirm_Level_DetailSdt( java.util.Vector<StructSdtMyProductsCartConfirm_Level_DetailSdt> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="MyProductsCartConfirm_Level_DetailSdt",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtMyProductsCartConfirm_Level_DetailSdt> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMyProductsCartConfirm_Level_DetailSdt> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMyProductsCartConfirm_Level_DetailSdt> item = new java.util.Vector<>();
}

