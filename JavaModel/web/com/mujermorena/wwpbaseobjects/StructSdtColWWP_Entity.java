package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_Entity", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_Entity implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_Entity( )
   {
      this( -1, new ModelContext( StructSdtColWWP_Entity.class ));
   }

   public StructSdtColWWP_Entity( int remoteHandle ,
                                  ModelContext context )
   {
   }

   public  StructSdtColWWP_Entity( java.util.Vector<StructSdtWWP_Entity> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_Entity",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_Entity> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_Entity> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_Entity> item = new java.util.Vector<>();
}

