package com.mujermorena.wwpbaseobjects.mail ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_Mail", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_Mail implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_Mail( )
   {
      this( -1, new ModelContext( StructSdtColWWP_Mail.class ));
   }

   public StructSdtColWWP_Mail( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColWWP_Mail( java.util.Vector<StructSdtWWP_Mail> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_Mail",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_Mail> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_Mail> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_Mail> item = new java.util.Vector<>();
}

