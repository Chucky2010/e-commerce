package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ImagesData", namespace ="Mujer_Morena")
public final  class StructSdtImagesData implements Cloneable, java.io.Serializable
{
   public StructSdtImagesData( )
   {
      this( -1, new ModelContext( StructSdtImagesData.class ));
   }

   public StructSdtImagesData( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtImagesData( java.util.Vector<StructSdtImagesData_ImagesDataItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="ImagesDataItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtImagesData_ImagesDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtImagesData_ImagesDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtImagesData_ImagesDataItem> item = new java.util.Vector<>();
}

