package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "NMCartPayment", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtNMCartPayment_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtNMCartPayment>
{
   public SdtNMCartPayment_RESTInterface( )
   {
      super(new com.mujermorena.SdtNMCartPayment ());
   }

   public SdtNMCartPayment_RESTInterface( com.mujermorena.SdtNMCartPayment psdt )
   {
      super(psdt);
   }

   @JsonProperty("Id")
   public String getgxTv_SdtNMCartPayment_Id( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtNMCartPayment_Id(), 11, 0)) ;
   }

   @JsonProperty("Id")
   public void setgxTv_SdtNMCartPayment_Id(  String Value )
   {
      sdt.setgxTv_SdtNMCartPayment_Id( GXutil.lval( Value) );
   }


   @JsonProperty("VisibleName")
   public String getgxTv_SdtNMCartPayment_Visiblename( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartPayment)getSdt()).getgxTv_SdtNMCartPayment_Visiblename()) ;
   }

   @JsonProperty("VisibleName")
   public void setgxTv_SdtNMCartPayment_Visiblename(  String Value )
   {
      ((com.mujermorena.SdtNMCartPayment)getSdt()).setgxTv_SdtNMCartPayment_Visiblename(Value);
   }


   @JsonProperty("Owner")
   public String getgxTv_SdtNMCartPayment_Owner( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartPayment)getSdt()).getgxTv_SdtNMCartPayment_Owner()) ;
   }

   @JsonProperty("Owner")
   public void setgxTv_SdtNMCartPayment_Owner(  String Value )
   {
      ((com.mujermorena.SdtNMCartPayment)getSdt()).setgxTv_SdtNMCartPayment_Owner(Value);
   }


   @JsonProperty("Valid")
   public String getgxTv_SdtNMCartPayment_Valid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartPayment)getSdt()).getgxTv_SdtNMCartPayment_Valid()) ;
   }

   @JsonProperty("Valid")
   public void setgxTv_SdtNMCartPayment_Valid(  String Value )
   {
      ((com.mujermorena.SdtNMCartPayment)getSdt()).setgxTv_SdtNMCartPayment_Valid(Value);
   }


   @JsonProperty("Selected")
   public Boolean getgxTv_SdtNMCartPayment_Selected( )
   {
      return ((com.mujermorena.SdtNMCartPayment)getSdt()).getgxTv_SdtNMCartPayment_Selected() ;
   }

   @JsonProperty("Selected")
   public void setgxTv_SdtNMCartPayment_Selected(  Boolean Value )
   {
      ((com.mujermorena.SdtNMCartPayment)getSdt()).setgxTv_SdtNMCartPayment_Selected(Value);
   }


   @JsonProperty("Imagen")
   public String getgxTv_SdtNMCartPayment_Imagen( )
   {
      return GXutil.getRelativeURL(((com.mujermorena.SdtNMCartPayment)getSdt()).getgxTv_SdtNMCartPayment_Imagen()) ;
   }

   @JsonProperty("Imagen")
   public void setgxTv_SdtNMCartPayment_Imagen(  String Value )
   {
      ((com.mujermorena.SdtNMCartPayment)getSdt()).setgxTv_SdtNMCartPayment_Imagen(Value);
   }


   @JsonProperty("NroComprobante")
   public String getgxTv_SdtNMCartPayment_Nrocomprobante( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartPayment)getSdt()).getgxTv_SdtNMCartPayment_Nrocomprobante()) ;
   }

   @JsonProperty("NroComprobante")
   public void setgxTv_SdtNMCartPayment_Nrocomprobante(  String Value )
   {
      ((com.mujermorena.SdtNMCartPayment)getSdt()).setgxTv_SdtNMCartPayment_Nrocomprobante(Value);
   }


   int remoteHandle = -1;
}

