package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColGxMap.Polygon", namespace ="Mujer_Morena")
public final  class StructSdtColGxMap_Polygon implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Polygon( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Polygon.class ));
   }

   public StructSdtColGxMap_Polygon( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtColGxMap_Polygon( java.util.Vector<StructSdtGxMap_Polygon> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="GxMap.Polygon",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtGxMap_Polygon> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Polygon> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Polygon> item = new java.util.Vector<>();
}

