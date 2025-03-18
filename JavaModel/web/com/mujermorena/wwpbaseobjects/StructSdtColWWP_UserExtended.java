package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_UserExtended", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_UserExtended implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_UserExtended( )
   {
      this( -1, new ModelContext( StructSdtColWWP_UserExtended.class ));
   }

   public StructSdtColWWP_UserExtended( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColWWP_UserExtended( java.util.Vector<StructSdtWWP_UserExtended> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_UserExtended",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_UserExtended> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_UserExtended> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_UserExtended> item = new java.util.Vector<>();
}

