package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MujerMorenaSDHomeTab1_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMujerMorenaSDHomeTab1_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt>
{
   public SdtMujerMorenaSDHomeTab1_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt ());
   }

   public SdtMujerMorenaSDHomeTab1_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Banner_items")
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface> getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items( )
   {
      return SdtSimpleListData_SimpleListDataItem_RESTInterfacefromGXObjectCollection(((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items()) ;
   }

   @JsonProperty("Banner_items")
   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items(  Vector<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface> Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items(SdtSimpleListData_SimpleListDataItem_RESTInterfacetoGXObjectCollection(Value));
   }


   @JsonProperty("Banner_chronometer")
   public Short getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer( )
   {
      return ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer() ;
   }

   @JsonProperty("Banner_chronometer")
   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer(  Short Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer(Value);
   }


   @JsonProperty("Products")
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products( )
   {
      return SdtWWPProductData_RESTInterfacefromGXObjectCollection(((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products()) ;
   }

   @JsonProperty("Products")
   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products(  Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products(SdtWWPProductData_RESTInterfacetoGXObjectCollection(Value));
   }


   @JsonProperty("A")
   public Short getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A( )
   {
      return ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A() ;
   }

   @JsonProperty("A")
   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A(  Short Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A(Value);
   }


   @JsonProperty("Banner_count")
   public Short getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count( )
   {
      return ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count() ;
   }

   @JsonProperty("Banner_count")
   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count(  Short Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count(Value);
   }


   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> SdtSimpleListData_SimpleListDataItem_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> result = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListData.SimpleListDataItem", "Mujer_Morena.SimpleListData", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> SdtWWPProductData_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> result = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface> SdtSimpleListData_SimpleListDataItem_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> collection )
   {
      Vector<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface> result = new Vector<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem_RESTInterface((com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)collection.elementAt(i)));
      }
      return result ;
   }

   private Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> SdtWWPProductData_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> collection )
   {
      Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> result = new Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)collection.elementAt(i)));
      }
      return result ;
   }

}

