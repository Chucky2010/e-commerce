package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "LaunchpadOptions", namespace ="Mujer_Morena")
public final  class StructSdtLaunchpadOptions implements Cloneable, java.io.Serializable
{
   public StructSdtLaunchpadOptions( )
   {
      this( -1, new ModelContext( StructSdtLaunchpadOptions.class ));
   }

   public StructSdtLaunchpadOptions( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtLaunchpadOptions( java.util.Vector<StructSdtLaunchpadOptions_Option> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="Option",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtLaunchpadOptions_Option> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtLaunchpadOptions_Option> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtLaunchpadOptions_Option> item = new java.util.Vector<>();
}

