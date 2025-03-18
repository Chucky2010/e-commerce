package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColWWP_SearchResults.WWP_SearchResultsItem.ResultItem", namespace ="Mujer_Morena")
public final  class StructSdtColWWP_SearchResults_WWP_SearchResultsItem_ResultItem implements Cloneable, java.io.Serializable
{
   public StructSdtColWWP_SearchResults_WWP_SearchResultsItem_ResultItem( )
   {
      this( -1, new ModelContext( StructSdtColWWP_SearchResults_WWP_SearchResultsItem_ResultItem.class ));
   }

   public StructSdtColWWP_SearchResults_WWP_SearchResultsItem_ResultItem( int remoteHandle ,
                                                                          ModelContext context )
   {
   }

   public  StructSdtColWWP_SearchResults_WWP_SearchResultsItem_ResultItem( java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WWP_SearchResults.WWP_SearchResultsItem.ResultItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> item = new java.util.Vector<>();
}

