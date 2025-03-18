package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColMenuInformation", namespace ="Mujer_Morena")
public final  class StructSdtColMenuInformation implements Cloneable, java.io.Serializable
{
   public StructSdtColMenuInformation( )
   {
      this( -1, new ModelContext( StructSdtColMenuInformation.class ));
   }

   public StructSdtColMenuInformation( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColMenuInformation( java.util.Vector<StructSdtMenuInformation> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="MenuInformation",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtMenuInformation> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMenuInformation> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMenuInformation> item = new java.util.Vector<>();
}

