package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpmappointfromstring_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpmappointfromstring_RESTInterfaceOUT
{
   String AV8Geopoint;
   @JsonProperty("Geopoint")
   public String getGeopoint( )
   {
      return AV8Geopoint ;
   }

   @JsonProperty("Geopoint")
   public void setGeopoint(  String Value )
   {
      AV8Geopoint= Value;
   }


}

