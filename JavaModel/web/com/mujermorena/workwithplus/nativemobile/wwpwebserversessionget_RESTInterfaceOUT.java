package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpwebserversessionget_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpwebserversessionget_RESTInterfaceOUT
{
   String AV9ParameterValue;
   @JsonProperty("ParameterValue")
   public String getParameterValue( )
   {
      return AV9ParameterValue ;
   }

   @JsonProperty("ParameterValue")
   public void setParameterValue(  String Value )
   {
      AV9ParameterValue= Value;
   }


}

