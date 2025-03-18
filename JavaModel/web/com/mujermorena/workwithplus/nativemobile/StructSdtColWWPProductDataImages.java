package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPProductDataImages", namespace ="Mujer_Morena")
public final  class StructSdtColWWPProductDataImages implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPProductDataImages( )
   {
      this( -1, new ModelContext( StructSdtColWWPProductDataImages.class ));
   }

   public StructSdtColWWPProductDataImages( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColWWPProductDataImages( java.util.Vector<StructSdtWWPProductDataImages> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPProductDataImages",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPProductDataImages> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPProductDataImages> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPProductDataImages> item = new java.util.Vector<>();
}

