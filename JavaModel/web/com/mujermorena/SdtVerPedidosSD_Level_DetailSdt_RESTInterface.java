package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "VerPedidosSD_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtVerPedidosSD_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtVerPedidosSD_Level_DetailSdt>
{
   public SdtVerPedidosSD_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtVerPedidosSD_Level_DetailSdt ());
   }

   public SdtVerPedidosSD_Level_DetailSdt_RESTInterface( com.mujermorena.SdtVerPedidosSD_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Isauthorized_useraction1")
   public Boolean getgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1( )
   {
      return ((com.mujermorena.SdtVerPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1() ;
   }

   @JsonProperty("Isauthorized_useraction1")
   public void setgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1(  Boolean Value )
   {
      ((com.mujermorena.SdtVerPedidosSD_Level_DetailSdt)getSdt()).setgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1(Value);
   }


   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtVerPedidosSD_Level_DetailSdt)getSdt()).getgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtVerPedidosSD_Level_DetailSdt)getSdt()).setgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
}

