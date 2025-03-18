package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "generarfacturasd_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class generarfacturasd_RESTInterfaceOUT
{
   String AV12VentasPedido;
   @JsonProperty("VentasPedido")
   public String getVentasPedido( )
   {
      return AV12VentasPedido ;
   }

   @JsonProperty("VentasPedido")
   public void setVentasPedido(  String Value )
   {
      AV12VentasPedido= Value;
   }


}

