package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_WebClient", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_WebClient implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_WebClient( )
   {
      this( -1, new ModelContext( StructSdtColWWP_WebClient.class ));
   }

   public StructSdtColWWP_WebClient( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtColWWP_WebClient( java.util.Vector<StructSdtWWP_WebClient> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_WebClient",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_WebClient> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_WebClient> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_WebClient> item = new java.util.Vector<>();
}

