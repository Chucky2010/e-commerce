package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetlineargaugeconfigfrompercentage_RESTInterfaceOUT
{
   String AV8GaugeData;
   @JsonProperty("GaugeData")
   public String getGaugeData( )
   {
      return AV8GaugeData ;
   }

   @JsonProperty("GaugeData")
   public void setGaugeData(  String Value )
   {
      AV8GaugeData= Value;
   }


}

