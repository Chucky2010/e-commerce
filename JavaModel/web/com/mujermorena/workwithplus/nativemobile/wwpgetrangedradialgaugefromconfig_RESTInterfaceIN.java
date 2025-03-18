package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetrangedradialgaugefromconfig_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetrangedradialgaugefromconfig_RESTInterfaceIN
{
   com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig_RESTInterface AV9GaugeConfig;
   @JsonProperty("GaugeConfig")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig_RESTInterface getGaugeConfig( )
   {
      return AV9GaugeConfig ;
   }

   @JsonProperty("GaugeConfig")
   public void setGaugeConfig(  com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig_RESTInterface Value )
   {
      AV9GaugeConfig= Value;
   }


}

