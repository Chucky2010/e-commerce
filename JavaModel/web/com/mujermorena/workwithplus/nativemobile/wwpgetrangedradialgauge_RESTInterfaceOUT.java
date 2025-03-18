package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetrangedradialgauge_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetrangedradialgauge_RESTInterfaceOUT
{
   String AV8GaugeRegions;
   @JsonProperty("GaugeRegions")
   public String getGaugeRegions( )
   {
      return AV8GaugeRegions ;
   }

   @JsonProperty("GaugeRegions")
   public void setGaugeRegions(  String Value )
   {
      AV8GaugeRegions= Value;
   }


}

