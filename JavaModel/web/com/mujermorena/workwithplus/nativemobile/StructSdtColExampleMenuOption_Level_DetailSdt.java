package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColExampleMenuOption_Level_DetailSdt", namespace ="http://tempuri.org/")
public final  class StructSdtColExampleMenuOption_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtColExampleMenuOption_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtColExampleMenuOption_Level_DetailSdt.class ));
   }

   public StructSdtColExampleMenuOption_Level_DetailSdt( int remoteHandle ,
                                                         ModelContext context )
   {
   }

   public  StructSdtColExampleMenuOption_Level_DetailSdt( java.util.Vector<StructSdtExampleMenuOption_Level_DetailSdt> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="ExampleMenuOption_Level_DetailSdt",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtExampleMenuOption_Level_DetailSdt> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtExampleMenuOption_Level_DetailSdt> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtExampleMenuOption_Level_DetailSdt> item = new java.util.Vector<>();
}

