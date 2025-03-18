package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MyProductsCartCheckout_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMyProductsCartCheckout_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt>
{
   public SdtMyProductsCartCheckout_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt ());
   }

   public SdtMyProductsCartCheckout_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Cartsubtotaltxt")
   public String getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt()) ;
   }

   @JsonProperty("Cartsubtotaltxt")
   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt(Value);
   }


   @JsonProperty("Cartproductcollection")
   public Vector<com.mujermorena.SdtNMCartProduct_RESTInterface> getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection( )
   {
      return SdtNMCartProduct_RESTInterfacefromGXObjectCollection(((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection()) ;
   }

   @JsonProperty("Cartproductcollection")
   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection(  Vector<com.mujermorena.SdtNMCartProduct_RESTInterface> Value )
   {
      ((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection(SdtNMCartProduct_RESTInterfacetoGXObjectCollection(Value));
   }


   @JsonProperty("Isauthorized_continue")
   public Boolean getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue( )
   {
      return ((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue() ;
   }

   @JsonProperty("Isauthorized_continue")
   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue(  Boolean Value )
   {
      ((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue(Value);
   }


   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> SdtNMCartProduct_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.SdtNMCartProduct_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.SdtNMCartProduct> result = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.SdtNMCartProduct)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.mujermorena.SdtNMCartProduct_RESTInterface> SdtNMCartProduct_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.SdtNMCartProduct> collection )
   {
      Vector<com.mujermorena.SdtNMCartProduct_RESTInterface> result = new Vector<com.mujermorena.SdtNMCartProduct_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.SdtNMCartProduct_RESTInterface((com.mujermorena.SdtNMCartProduct)collection.elementAt(i)));
      }
      return result ;
   }

}

