package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "NMCartProduct", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtNMCartProduct_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtNMCartProduct>
{
   public SdtNMCartProduct_RESTInterface( )
   {
      super(new com.mujermorena.SdtNMCartProduct ());
   }

   public SdtNMCartProduct_RESTInterface( com.mujermorena.SdtNMCartProduct psdt )
   {
      super(psdt);
   }

   @JsonProperty("ProductId")
   public String getgxTv_SdtNMCartProduct_Productid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Productid()) ;
   }

   @JsonProperty("ProductId")
   public void setgxTv_SdtNMCartProduct_Productid(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Productid(Value);
   }


   @JsonProperty("Count")
   public Short getgxTv_SdtNMCartProduct_Count( )
   {
      return ((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Count() ;
   }

   @JsonProperty("Count")
   public void setgxTv_SdtNMCartProduct_Count(  Short Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Count(Value);
   }


   @JsonProperty("Color")
   public String getgxTv_SdtNMCartProduct_Color( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Color()) ;
   }

   @JsonProperty("Color")
   public void setgxTv_SdtNMCartProduct_Color(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Color(Value);
   }


   @JsonProperty("Variant")
   public String getgxTv_SdtNMCartProduct_Variant( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Variant()) ;
   }

   @JsonProperty("Variant")
   public void setgxTv_SdtNMCartProduct_Variant(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Variant(Value);
   }


   @JsonProperty("Promotion")
   public String getgxTv_SdtNMCartProduct_Promotion( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Promotion()) ;
   }

   @JsonProperty("Promotion")
   public void setgxTv_SdtNMCartProduct_Promotion(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Promotion(Value);
   }


   @JsonProperty("ProductData")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface getgxTv_SdtNMCartProduct_Productdata( )
   {
      if ( ((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Productdata_N() != 1 )
      {
         return new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Productdata()) ;
      }
      else
      {
         return null ;
      }
   }

   @JsonProperty("ProductData")
   public void setgxTv_SdtNMCartProduct_Productdata(  com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Productdata((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)Value.getSdt());
   }


   @JsonProperty("ProductDataTitle")
   public String getgxTv_SdtNMCartProduct_Productdatatitle( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Productdatatitle()) ;
   }

   @JsonProperty("ProductDataTitle")
   public void setgxTv_SdtNMCartProduct_Productdatatitle(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Productdatatitle(Value);
   }


   @JsonProperty("ProductDataInformation")
   public String getgxTv_SdtNMCartProduct_Productdatainformation( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Productdatainformation()) ;
   }

   @JsonProperty("ProductDataInformation")
   public void setgxTv_SdtNMCartProduct_Productdatainformation(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Productdatainformation(Value);
   }


   @JsonProperty("ProductDataImage")
   public String getgxTv_SdtNMCartProduct_Productdataimage( )
   {
      return GXutil.getRelativeURL(((com.mujermorena.SdtNMCartProduct)getSdt()).getgxTv_SdtNMCartProduct_Productdataimage()) ;
   }

   @JsonProperty("ProductDataImage")
   public void setgxTv_SdtNMCartProduct_Productdataimage(  String Value )
   {
      ((com.mujermorena.SdtNMCartProduct)getSdt()).setgxTv_SdtNMCartProduct_Productdataimage(Value);
   }


   @JsonProperty("Talla")
   public String getgxTv_SdtNMCartProduct_Talla( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtNMCartProduct_Talla(), 11, 0)) ;
   }

   @JsonProperty("Talla")
   public void setgxTv_SdtNMCartProduct_Talla(  String Value )
   {
      sdt.setgxTv_SdtNMCartProduct_Talla( GXutil.lval( Value) );
   }


   int remoteHandle = -1;
}

