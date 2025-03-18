package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColGxMap.Polygon.Path", namespace ="Mujer_Morena")
public final  class StructSdtColGxMap_Polygon_Path implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Polygon_Path( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Polygon_Path.class ));
   }

   public StructSdtColGxMap_Polygon_Path( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColGxMap_Polygon_Path( java.util.Vector<StructSdtGxMap_Polygon_Path> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="GxMap.Polygon.Path",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtGxMap_Polygon_Path> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Polygon_Path> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Polygon_Path> item = new java.util.Vector<>();
}

