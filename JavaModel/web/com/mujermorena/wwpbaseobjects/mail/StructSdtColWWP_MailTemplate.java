package com.mujermorena.wwpbaseobjects.mail ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_MailTemplate", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_MailTemplate implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_MailTemplate( )
   {
      this( -1, new ModelContext( StructSdtColWWP_MailTemplate.class ));
   }

   public StructSdtColWWP_MailTemplate( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColWWP_MailTemplate( java.util.Vector<StructSdtWWP_MailTemplate> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_MailTemplate",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_MailTemplate> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_MailTemplate> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_MailTemplate> item = new java.util.Vector<>();
}

