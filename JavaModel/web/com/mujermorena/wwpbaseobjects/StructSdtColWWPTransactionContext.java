package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPTransactionContext", namespace ="Mujer_Morena")
public final  class StructSdtColWWPTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPTransactionContext( )
   {
      this( -1, new ModelContext( StructSdtColWWPTransactionContext.class ));
   }

   public StructSdtColWWPTransactionContext( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColWWPTransactionContext( java.util.Vector<StructSdtWWPTransactionContext> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPTransactionContext",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPTransactionContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPTransactionContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPTransactionContext> item = new java.util.Vector<>();
}

