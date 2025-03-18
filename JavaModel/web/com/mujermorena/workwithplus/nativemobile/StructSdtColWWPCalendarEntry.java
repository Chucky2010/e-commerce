package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPCalendarEntry", namespace ="Mujer_Morena")
public final  class StructSdtColWWPCalendarEntry implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPCalendarEntry( )
   {
      this( -1, new ModelContext( StructSdtColWWPCalendarEntry.class ));
   }

   public StructSdtColWWPCalendarEntry( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColWWPCalendarEntry( java.util.Vector<StructSdtWWPCalendarEntry> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPCalendarEntry",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPCalendarEntry> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPCalendarEntry> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPCalendarEntry> item = new java.util.Vector<>();
}

