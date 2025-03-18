package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MyProductsCartAddress_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMyProductsCartAddress_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt>
{
   public SdtMyProductsCartAddress_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt ());
   }

   public SdtMyProductsCartAddress_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Gxprops_cartuseraddresscollection")
   public String getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection()) ;
   }

   @JsonProperty("Gxprops_cartuseraddresscollection")
   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection(Value);
   }


   @JsonProperty("Cartuseraddresscollection")
   public Vector<com.mujermorena.SdtNMCartUserAddress_RESTInterface> getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection( )
   {
      return SdtNMCartUserAddress_RESTInterfacefromGXObjectCollection(((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection()) ;
   }

   @JsonProperty("Cartuseraddresscollection")
   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection(  Vector<com.mujermorena.SdtNMCartUserAddress_RESTInterface> Value )
   {
      ((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection(SdtNMCartUserAddress_RESTInterfacetoGXObjectCollection(Value));
   }


   @JsonProperty("Selectedid")
   public String getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid()) ;
   }

   @JsonProperty("Selectedid")
   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid(Value);
   }


   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> SdtNMCartUserAddress_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.SdtNMCartUserAddress_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> result = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.SdtNMCartUserAddress)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.mujermorena.SdtNMCartUserAddress_RESTInterface> SdtNMCartUserAddress_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> collection )
   {
      Vector<com.mujermorena.SdtNMCartUserAddress_RESTInterface> result = new Vector<com.mujermorena.SdtNMCartUserAddress_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.SdtNMCartUserAddress_RESTInterface((com.mujermorena.SdtNMCartUserAddress)collection.elementAt(i)));
      }
      return result ;
   }

}

