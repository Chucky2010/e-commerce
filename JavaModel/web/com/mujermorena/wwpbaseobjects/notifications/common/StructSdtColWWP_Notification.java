package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_Notification", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_Notification implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_Notification( )
   {
      this( -1, new ModelContext( StructSdtColWWP_Notification.class ));
   }

   public StructSdtColWWP_Notification( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColWWP_Notification( java.util.Vector<StructSdtWWP_Notification> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_Notification",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_Notification> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_Notification> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_Notification> item = new java.util.Vector<>();
}

