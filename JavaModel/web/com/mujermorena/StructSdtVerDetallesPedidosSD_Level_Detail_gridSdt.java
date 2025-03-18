package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "VerDetallesPedidosSD_Level_Detail_gridSdt", namespace ="http://tempuri.org/")
public final  class StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt implements Cloneable, java.io.Serializable
{
   public StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt( )
   {
      this( -1, new ModelContext( StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt.class ));
   }

   public StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt( int remoteHandle ,
                                                              ModelContext context )
   {
   }

   public  StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt( java.util.Vector<StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="VerDetallesPedidosSD_Level_Detail_gridSdt.Item",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> item = new java.util.Vector<>();
}

