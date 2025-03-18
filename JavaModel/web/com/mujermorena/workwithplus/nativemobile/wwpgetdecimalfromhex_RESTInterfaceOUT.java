package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetdecimalfromhex_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetdecimalfromhex_RESTInterfaceOUT
{
   int AV9DecimalValue;
   @JsonProperty("DecimalValue")
   public int getDecimalValue( )
   {
      return AV9DecimalValue ;
   }

   @JsonProperty("DecimalValue")
   public void setDecimalValue(  int Value )
   {
      AV9DecimalValue= Value;
   }


}

