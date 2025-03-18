package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPContext", namespace ="Mujer_Morena")
public final  class StructSdtColWWPContext implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPContext( )
   {
      this( -1, new ModelContext( StructSdtColWWPContext.class ));
   }

   public StructSdtColWWPContext( int remoteHandle ,
                                  ModelContext context )
   {
   }

   public  StructSdtColWWPContext( java.util.Vector<StructSdtWWPContext> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPContext",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPContext> item = new java.util.Vector<>();
}

