package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "generarfactura_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class generarfactura_RESTInterfaceOUT
{
   String A19VentasId;
   @JsonProperty("VentasId")
   public String getVentasId( )
   {
      return A19VentasId ;
   }

   @JsonProperty("VentasId")
   public void setVentasId(  String Value )
   {
      A19VentasId= Value;
   }


}

