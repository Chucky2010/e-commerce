package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "DoubleItemListData", namespace ="Mujer_Morena")
public final  class StructSdtDoubleItemListData implements Cloneable, java.io.Serializable
{
   public StructSdtDoubleItemListData( )
   {
      this( -1, new ModelContext( StructSdtDoubleItemListData.class ));
   }

   public StructSdtDoubleItemListData( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtDoubleItemListData( java.util.Vector<StructSdtDoubleItemListData_DoubleItemListDataItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="DoubleItemListDataItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtDoubleItemListData_DoubleItemListDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDoubleItemListData_DoubleItemListDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDoubleItemListData_DoubleItemListDataItem> item = new java.util.Vector<>();
}

