package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "WWP_SDTNotificationsData", namespace ="Mujer_Morena")
public final  class StructSdtWWP_SDTNotificationsData implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SDTNotificationsData( )
   {
      this( -1, new ModelContext( StructSdtWWP_SDTNotificationsData.class ));
   }

   public StructSdtWWP_SDTNotificationsData( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtWWP_SDTNotificationsData( java.util.Vector<StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_SDTNotificationsDataItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> item = new java.util.Vector<>();
}

