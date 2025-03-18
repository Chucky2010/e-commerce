package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_NotificationDefinition", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_NotificationDefinition implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_NotificationDefinition( )
   {
      this( -1, new ModelContext( StructSdtColWWP_NotificationDefinition.class ));
   }

   public StructSdtColWWP_NotificationDefinition( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColWWP_NotificationDefinition( java.util.Vector<StructSdtWWP_NotificationDefinition> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_NotificationDefinition",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_NotificationDefinition> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_NotificationDefinition> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_NotificationDefinition> item = new java.util.Vector<>();
}

