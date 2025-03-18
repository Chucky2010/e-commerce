package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "SDTArticuloVentas", namespace ="Mujer_Morena")
public final  class StructSdtSDTArticuloVentas implements Cloneable, java.io.Serializable
{
   public StructSdtSDTArticuloVentas( )
   {
      this( -1, new ModelContext( StructSdtSDTArticuloVentas.class ));
   }

   public StructSdtSDTArticuloVentas( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtSDTArticuloVentas( java.util.Vector<StructSdtSDTArticuloVentas_SDTArticuloVentasItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="SDTArticuloVentasItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtSDTArticuloVentas_SDTArticuloVentasItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTArticuloVentas_SDTArticuloVentasItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTArticuloVentas_SDTArticuloVentasItem> item = new java.util.Vector<>();
}

