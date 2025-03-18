package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "validardatopagosd_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class validardatopagosd_RESTInterfaceOUT
{
   String AV11Dato;
   @JsonProperty("Dato")
   public String getDato( )
   {
      return AV11Dato ;
   }

   @JsonProperty("Dato")
   public void setDato(  String Value )
   {
      AV11Dato= Value;
   }


}

