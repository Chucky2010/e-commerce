package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColGxMap.RoutePoint", namespace ="Mujer_Morena")
public final  class StructSdtColGxMap_RoutePoint implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_RoutePoint( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_RoutePoint.class ));
   }

   public StructSdtColGxMap_RoutePoint( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColGxMap_RoutePoint( java.util.Vector<StructSdtGxMap_RoutePoint> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="GxMap.RoutePoint",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtGxMap_RoutePoint> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_RoutePoint> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_RoutePoint> item = new java.util.Vector<>();
}

