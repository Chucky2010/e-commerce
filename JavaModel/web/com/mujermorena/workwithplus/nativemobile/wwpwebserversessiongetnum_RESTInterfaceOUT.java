package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpwebserversessiongetnum_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpwebserversessiongetnum_RESTInterfaceOUT
{
   String AV11ParameterNumValue;
   @JsonProperty("ParameterNumValue")
   public String getParameterNumValue( )
   {
      return AV11ParameterNumValue ;
   }

   @JsonProperty("ParameterNumValue")
   public void setParameterNumValue(  String Value )
   {
      AV11ParameterNumValue= Value;
   }


}

