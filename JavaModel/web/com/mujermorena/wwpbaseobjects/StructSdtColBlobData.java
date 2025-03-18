package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColBlobData", namespace ="Mujer_Morena")
public final  class StructSdtColBlobData implements Cloneable, java.io.Serializable
{
   public StructSdtColBlobData( )
   {
      this( -1, new ModelContext( StructSdtColBlobData.class ));
   }

   public StructSdtColBlobData( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColBlobData( java.util.Vector<StructSdtBlobData> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="BlobData",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtBlobData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtBlobData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtBlobData> item = new java.util.Vector<>();
}

