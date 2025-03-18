package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "addcomprobantes_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class addcomprobantes_RESTInterfaceOUT
{
   short AV10ProductDispon;
   @JsonProperty("ProductDispon")
   public short getProductDispon( )
   {
      return AV10ProductDispon ;
   }

   @JsonProperty("ProductDispon")
   public void setProductDispon(  short Value )
   {
      AV10ProductDispon= Value;
   }


}

