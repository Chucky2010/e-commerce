package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColMujerMorenaSDHome_Level_DetailSdt", namespace ="http://tempuri.org/")
public final  class StructSdtColMujerMorenaSDHome_Level_DetailSdt implements Cloneable, java.io.Serializable
{
   public StructSdtColMujerMorenaSDHome_Level_DetailSdt( )
   {
      this( -1, new ModelContext( StructSdtColMujerMorenaSDHome_Level_DetailSdt.class ));
   }

   public StructSdtColMujerMorenaSDHome_Level_DetailSdt( int remoteHandle ,
                                                         ModelContext context )
   {
   }

   public  StructSdtColMujerMorenaSDHome_Level_DetailSdt( java.util.Vector<StructSdtMujerMorenaSDHome_Level_DetailSdt> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="MujerMorenaSDHome_Level_DetailSdt",namespace="http://tempuri.org/")
   public java.util.Vector<StructSdtMujerMorenaSDHome_Level_DetailSdt> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMujerMorenaSDHome_Level_DetailSdt> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMujerMorenaSDHome_Level_DetailSdt> item = new java.util.Vector<>();
}

