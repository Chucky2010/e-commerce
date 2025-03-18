package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpcreatelocationslist_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpcreatelocationslist_RESTInterfaceOUT
{
   Vector<com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface> AV9MapItems ;
   @JsonProperty("MapItems")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface> getMapItems( )
   {
      return AV9MapItems ;
   }

   @JsonProperty("MapItems")
   public void setMapItems(  Vector<com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface> Value )
   {
      AV9MapItems= Value;
   }


}

