package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetcalendardatefromnr_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetcalendardatefromnr_RESTInterfaceOUT
{
   String AV9DateJson;
   @JsonProperty("DateJson")
   public String getDateJson( )
   {
      return AV9DateJson ;
   }

   @JsonProperty("DateJson")
   public void setDateJson(  String Value )
   {
      AV9DateJson= Value;
   }


}

