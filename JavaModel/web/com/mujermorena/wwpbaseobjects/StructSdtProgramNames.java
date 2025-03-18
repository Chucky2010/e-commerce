package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ProgramNames", namespace ="Mujer_Morena")
public final  class StructSdtProgramNames implements Cloneable, java.io.Serializable
{
   public StructSdtProgramNames( )
   {
      this( -1, new ModelContext( StructSdtProgramNames.class ));
   }

   public StructSdtProgramNames( int remoteHandle ,
                                 ModelContext context )
   {
   }

   public  StructSdtProgramNames( java.util.Vector<StructSdtProgramNames_ProgramName> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="ProgramName",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtProgramNames_ProgramName> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProgramNames_ProgramName> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProgramNames_ProgramName> item = new java.util.Vector<>();
}

