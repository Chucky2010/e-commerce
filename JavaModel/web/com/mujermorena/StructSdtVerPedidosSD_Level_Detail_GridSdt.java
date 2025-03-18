package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "VerPedidosSD_Level_Detail_GridSdt", namespace ="http://tempuri.org/")
public final  class StructSdtVerPedidosSD_Level_Detail_GridSdt implements Cloneable, java.io.Serializable
{
   public StructSdtVerPedidosSD_Level_Detail_GridSdt( )
   {
      this( -1, new ModelContext( StructSdtVerPedidosSD_Level_Detail_GridSdt.class ));
   }

   public StructSdtVerPedidosSD_Level_Detail_GridSdt( int remoteHandle ,
                                                      ModelContext context )
   {
   }

   public  StructSdtVerPedidosSD_Level_Detail_GridSdt( java.util.Vector<StructSdtVerPedidosSD_Level_Detail_GridSdt_Item> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="VerPedidosSD_Level_Detail_GridSdt.Item",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtVerPedidosSD_Level_Detail_GridSdt_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtVerPedidosSD_Level_Detail_GridSdt_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtVerPedidosSD_Level_Detail_GridSdt_Item> item = new java.util.Vector<>();
}

