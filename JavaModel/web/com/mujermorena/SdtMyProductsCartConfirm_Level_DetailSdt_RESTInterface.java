package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MyProductsCartConfirm_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMyProductsCartConfirm_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt>
{
   public SdtMyProductsCartConfirm_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt ());
   }

   public SdtMyProductsCartConfirm_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Cartsubtotaltxt")
   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt()) ;
   }

   @JsonProperty("Cartsubtotaltxt")
   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt(Value);
   }


   @JsonProperty("Cartuseraddress")
   public com.mujermorena.SdtNMCartUserAddress_RESTInterface getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress( )
   {
      return new com.mujermorena.SdtNMCartUserAddress_RESTInterface(((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress()) ;
   }

   @JsonProperty("Cartuseraddress")
   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress(  com.mujermorena.SdtNMCartUserAddress_RESTInterface Value )
   {
      ((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress((com.mujermorena.SdtNMCartUserAddress)Value.getSdt());
   }


   @JsonProperty("Tipopagoid")
   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid(), 11, 0)) ;
   }

   @JsonProperty("Tipopagoid")
   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid(  String Value )
   {
      sdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid( GXutil.lval( Value) );
   }


   @JsonProperty("Datopago")
   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago()) ;
   }

   @JsonProperty("Datopago")
   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago(Value);
   }


   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop(Value);
   }


   @JsonProperty("Gxdesc_tipopagoid")
   public String getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid()) ;
   }

   @JsonProperty("Gxdesc_tipopagoid")
   public void setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid(  String Value )
   {
      ((com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid(Value);
   }


   int remoteHandle = -1;
}

