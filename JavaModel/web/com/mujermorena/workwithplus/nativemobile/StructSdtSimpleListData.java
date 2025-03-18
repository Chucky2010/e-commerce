package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "SimpleListData", namespace ="Mujer_Morena")
public final  class StructSdtSimpleListData implements Cloneable, java.io.Serializable
{
   public StructSdtSimpleListData( )
   {
      this( -1, new ModelContext( StructSdtSimpleListData.class ));
   }

   public StructSdtSimpleListData( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtSimpleListData( java.util.Vector<StructSdtSimpleListData_SimpleListDataItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="SimpleListDataItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtSimpleListData_SimpleListDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSimpleListData_SimpleListDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSimpleListData_SimpleListDataItem> item = new java.util.Vector<>();
}

