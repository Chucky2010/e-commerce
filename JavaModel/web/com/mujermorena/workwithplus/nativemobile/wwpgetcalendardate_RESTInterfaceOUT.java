package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetcalendardate_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetcalendardate_RESTInterfaceOUT
{
   String AV10DateJson;
   @JsonProperty("DateJson")
   public String getDateJson( )
   {
      return AV10DateJson ;
   }

   @JsonProperty("DateJson")
   public void setDateJson(  String Value )
   {
      AV10DateJson= Value;
   }


}

