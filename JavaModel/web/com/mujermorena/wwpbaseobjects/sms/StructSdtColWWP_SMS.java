package com.mujermorena.wwpbaseobjects.sms ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_SMS", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_SMS implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_SMS( )
   {
      this( -1, new ModelContext( StructSdtColWWP_SMS.class ));
   }

   public StructSdtColWWP_SMS( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtColWWP_SMS( java.util.Vector<StructSdtWWP_SMS> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_SMS",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_SMS> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_SMS> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_SMS> item = new java.util.Vector<>();
}

