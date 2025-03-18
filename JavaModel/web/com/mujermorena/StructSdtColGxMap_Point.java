package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColGxMap.Point", namespace ="Mujer_Morena")
public final  class StructSdtColGxMap_Point implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Point( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Point.class ));
   }

   public StructSdtColGxMap_Point( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtColGxMap_Point( java.util.Vector<StructSdtGxMap_Point> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="GxMap.Point",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtGxMap_Point> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Point> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Point> item = new java.util.Vector<>();
}

