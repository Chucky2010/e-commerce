package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColGAMSDChangePassword_Level_DetailSdt", namespace ="http://tempuri.org/")
public final  class StructSdtColGAMSDChangePassword_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtColGAMSDChangePassword_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtColGAMSDChangePassword_Level_DetailSdt.class ));
   }

   public StructSdtColGAMSDChangePassword_Level_DetailSdt( int remoteHandle ,
                                                           ModelContext context )
   {
   }

   public  StructSdtColGAMSDChangePassword_Level_DetailSdt( java.util.Vector<StructSdtGAMSDChangePassword_Level_DetailSdt> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="GAMSDChangePassword_Level_DetailSdt",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtGAMSDChangePassword_Level_DetailSdt> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGAMSDChangePassword_Level_DetailSdt> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGAMSDChangePassword_Level_DetailSdt> item = new java.util.Vector<>();
}

