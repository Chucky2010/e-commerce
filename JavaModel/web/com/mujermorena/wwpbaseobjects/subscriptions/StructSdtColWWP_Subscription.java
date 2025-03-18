package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_Subscription", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_Subscription implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_Subscription( )
   {
      this( -1, new ModelContext( StructSdtColWWP_Subscription.class ));
   }

   public StructSdtColWWP_Subscription( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColWWP_Subscription( java.util.Vector<StructSdtWWP_Subscription> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_Subscription",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_Subscription> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_Subscription> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_Subscription> item = new java.util.Vector<>();
}

