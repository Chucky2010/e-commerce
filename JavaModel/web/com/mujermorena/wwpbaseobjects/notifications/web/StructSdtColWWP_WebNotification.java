package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_WebNotification", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_WebNotification implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_WebNotification( )
   {
      this( -1, new ModelContext( StructSdtColWWP_WebNotification.class ));
   }

   public StructSdtColWWP_WebNotification( int remoteHandle ,
                                           ModelContext context )
   {
   }

   public  StructSdtColWWP_WebNotification( java.util.Vector<StructSdtWWP_WebNotification> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_WebNotification",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_WebNotification> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_WebNotification> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_WebNotification> item = new java.util.Vector<>();
}

