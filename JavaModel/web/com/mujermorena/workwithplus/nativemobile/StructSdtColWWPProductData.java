package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPProductData", namespace ="Mujer_Morena")
public final  class StructSdtColWWPProductData implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPProductData( )
   {
      this( -1, new ModelContext( StructSdtColWWPProductData.class ));
   }

   public StructSdtColWWPProductData( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtColWWPProductData( java.util.Vector<StructSdtWWPProductData> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPProductData",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPProductData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPProductData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPProductData> item = new java.util.Vector<>();
}

