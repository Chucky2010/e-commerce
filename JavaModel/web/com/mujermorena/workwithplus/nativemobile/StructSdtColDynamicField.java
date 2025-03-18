package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColDynamicField", namespace ="Mujer_Morena")
public final  class StructSdtColDynamicField implements Cloneable, java.io.Serializable
{
   public StructSdtColDynamicField( )
   {
      this( -1, new ModelContext( StructSdtColDynamicField.class ));
   }

   public StructSdtColDynamicField( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColDynamicField( java.util.Vector<StructSdtDynamicField> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="DynamicField",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtDynamicField> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDynamicField> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDynamicField> item = new java.util.Vector<>();
}

