package com.mujermorena ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "LinkList", namespace ="GeneXus")
public final  class StructSdtLinkList implements Cloneable, java.io.Serializable
{
   public StructSdtLinkList( )
   {
      this( -1, new ModelContext( StructSdtLinkList.class ));
   }

   public StructSdtLinkList( int remoteHandle ,
                             ModelContext context )
   {
   }

   public  StructSdtLinkList( java.util.Vector<StructSdtLinkList_LinkItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="LinkItem",namespace="GeneXus")
   public java.util.Vector<StructSdtLinkList_LinkItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtLinkList_LinkItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtLinkList_LinkItem> item = new java.util.Vector<>();
}

