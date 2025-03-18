package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "nmcartproductsadd_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class nmcartproductsadd_RESTInterfaceOUT
{
   short AV17Result;
   @JsonProperty("Result")
   public short getResult( )
   {
      return AV17Result ;
   }

   @JsonProperty("Result")
   public void setResult(  short Value )
   {
      AV17Result= Value;
   }


   short AV19Saldo;
   @JsonProperty("Saldo")
   public short getSaldo( )
   {
      return AV19Saldo ;
   }

   @JsonProperty("Saldo")
   public void setSaldo(  short Value )
   {
      AV19Saldo= Value;
   }


}

