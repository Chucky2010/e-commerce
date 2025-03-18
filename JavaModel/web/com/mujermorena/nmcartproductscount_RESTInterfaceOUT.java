package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "nmcartproductscount_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class nmcartproductscount_RESTInterfaceOUT
{
   short AV8Count;
   @JsonProperty("Count")
   public short getCount( )
   {
      return AV8Count ;
   }

   @JsonProperty("Count")
   public void setCount(  short Value )
   {
      AV8Count= Value;
   }


}

