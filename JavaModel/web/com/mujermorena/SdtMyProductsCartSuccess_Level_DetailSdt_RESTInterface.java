package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MyProductsCartSuccess_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMyProductsCartSuccess_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt>
{
   public SdtMyProductsCartSuccess_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt ());
   }

   public SdtMyProductsCartSuccess_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Calificacionnro")
   public Short getgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro( )
   {
      return ((com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt)getSdt()).getgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro() ;
   }

   @JsonProperty("Calificacionnro")
   public void setgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro(  Short Value )
   {
      ((com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt)getSdt()).setgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro(Value);
   }


   int remoteHandle = -1;
}

