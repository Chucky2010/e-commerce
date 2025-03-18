package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MyProductsProductDetail_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMyProductsProductDetail_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt>
{
   public SdtMyProductsProductDetail_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt ());
   }

   public SdtMyProductsProductDetail_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Productdataimages")
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface> getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages( )
   {
      return SdtWWPProductDataImages_RESTInterfacefromGXObjectCollection(((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages()) ;
   }

   @JsonProperty("Productdataimages")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages(  Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface> Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages(SdtWWPProductDataImages_RESTInterfacetoGXObjectCollection(Value));
   }


   @JsonProperty("Productdata")
   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata( )
   {
      return new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface(((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata()) ;
   }

   @JsonProperty("Productdata")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata(  com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)Value.getSdt());
   }


   @JsonProperty("Rating")
   public Short getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating( )
   {
      return ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating() ;
   }

   @JsonProperty("Rating")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating(  Short Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating(Value);
   }


   @JsonProperty("Cantidad")
   public Integer getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad( )
   {
      return ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad() ;
   }

   @JsonProperty("Cantidad")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad(  Integer Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad(Value);
   }


   @JsonProperty("Talle")
   public Integer getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle( )
   {
      return ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle() ;
   }

   @JsonProperty("Talle")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle(  Integer Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle(Value);
   }


   @JsonProperty("Productdispon")
   public Short getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon( )
   {
      return ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon() ;
   }

   @JsonProperty("Productdispon")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon(  Short Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon(Value);
   }


   @JsonProperty("Productid")
   public String getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid()) ;
   }

   @JsonProperty("Productid")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid(  String Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid(Value);
   }


   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop(Value);
   }


   @JsonProperty("Gxdesc_talle")
   public String getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle()) ;
   }

   @JsonProperty("Gxdesc_talle")
   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle(  String Value )
   {
      ((com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle(Value);
   }


   int remoteHandle = -1;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> SdtWWPProductDataImages_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> result = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface> SdtWWPProductDataImages_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> collection )
   {
      Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface> result = new Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages_RESTInterface((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)collection.elementAt(i)));
      }
      return result ;
   }

}

