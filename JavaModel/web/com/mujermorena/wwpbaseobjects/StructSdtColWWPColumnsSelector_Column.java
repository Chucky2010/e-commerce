package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWPColumnsSelector.Column", namespace ="Mujer_Morena")
public final  class StructSdtColWWPColumnsSelector_Column implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPColumnsSelector_Column( )
   {
      this( -1, new ModelContext( StructSdtColWWPColumnsSelector_Column.class ));
   }

   public StructSdtColWWPColumnsSelector_Column( int remoteHandle ,
                                                 ModelContext context )
   {
   }

   public  StructSdtColWWPColumnsSelector_Column( java.util.Vector<StructSdtWWPColumnsSelector_Column> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWPColumnsSelector.Column",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWPColumnsSelector_Column> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPColumnsSelector_Column> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPColumnsSelector_Column> item = new java.util.Vector<>();
}

