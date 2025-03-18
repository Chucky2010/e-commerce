package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "MenuOptions", namespace ="Mujer_Morena")
public final  class StructSdtMenuOptions implements Cloneable, java.io.Serializable
{
   public StructSdtMenuOptions( )
   {
      this( -1, new ModelContext( StructSdtMenuOptions.class ));
   }

   public StructSdtMenuOptions( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtMenuOptions( java.util.Vector<StructSdtMenuOptions_MenuOptionsItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="MenuOptionsItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtMenuOptions_MenuOptionsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMenuOptions_MenuOptionsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMenuOptions_MenuOptionsItem> item = new java.util.Vector<>();
}

