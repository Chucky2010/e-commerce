package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_SDTNotificationMetadata", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_SDTNotificationMetadata implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_SDTNotificationMetadata( )
   {
      this( -1, new ModelContext( StructSdtColWWP_SDTNotificationMetadata.class ));
   }

   public StructSdtColWWP_SDTNotificationMetadata( int remoteHandle ,
                                                   ModelContext context )
   {
   }

   public  StructSdtColWWP_SDTNotificationMetadata( java.util.Vector<StructSdtWWP_SDTNotificationMetadata> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_SDTNotificationMetadata",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_SDTNotificationMetadata> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_SDTNotificationMetadata> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_SDTNotificationMetadata> item = new java.util.Vector<>();
}

