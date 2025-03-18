package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColUserCustomizations", namespace ="Mujer_Morena")
public final  class StructSdtColUserCustomizations implements Cloneable, java.io.Serializable
{
   public StructSdtColUserCustomizations( )
   {
      this( -1, new ModelContext( StructSdtColUserCustomizations.class ));
   }

   public StructSdtColUserCustomizations( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColUserCustomizations( java.util.Vector<StructSdtUserCustomizations> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="UserCustomizations",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtUserCustomizations> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtUserCustomizations> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtUserCustomizations> item = new java.util.Vector<>();
}

