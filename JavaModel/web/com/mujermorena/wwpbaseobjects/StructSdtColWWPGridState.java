package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPGridState", namespace ="Mujer_Morena")
public final  class StructSdtColWWPGridState implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPGridState( )
   {
      this( -1, new ModelContext( StructSdtColWWPGridState.class ));
   }

   public StructSdtColWWPGridState( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColWWPGridState( java.util.Vector<StructSdtWWPGridState> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPGridState",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPGridState> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState> item = new java.util.Vector<>();
}

