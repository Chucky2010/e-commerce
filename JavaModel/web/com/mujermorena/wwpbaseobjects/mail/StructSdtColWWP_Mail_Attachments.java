package com.mujermorena.wwpbaseobjects.mail ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_Mail.Attachments", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_Mail_Attachments implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_Mail_Attachments( )
   {
      this( -1, new ModelContext( StructSdtColWWP_Mail_Attachments.class ));
   }

   public StructSdtColWWP_Mail_Attachments( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColWWP_Mail_Attachments( java.util.Vector<StructSdtWWP_Mail_Attachments> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_Mail.Attachments",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_Mail_Attachments> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_Mail_Attachments> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_Mail_Attachments> item = new java.util.Vector<>();
}

