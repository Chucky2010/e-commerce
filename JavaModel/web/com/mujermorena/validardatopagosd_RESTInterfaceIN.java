package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "validardatopagosd_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class validardatopagosd_RESTInterfaceIN
{
   String AV8TipoPagoId;
   @JsonProperty("TipoPagoId")
   public String getTipoPagoId( )
   {
      return AV8TipoPagoId ;
   }

   @JsonProperty("TipoPagoId")
   public void setTipoPagoId(  String Value )
   {
      AV8TipoPagoId= Value;
   }


}

