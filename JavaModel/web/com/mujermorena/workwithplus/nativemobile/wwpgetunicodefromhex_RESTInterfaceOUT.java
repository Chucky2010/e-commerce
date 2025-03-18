package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetunicodefromhex_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetunicodefromhex_RESTInterfaceOUT
{
   String AV9UnicodeCharacter;
   @JsonProperty("UnicodeCharacter")
   public String getUnicodeCharacter( )
   {
      return AV9UnicodeCharacter ;
   }

   @JsonProperty("UnicodeCharacter")
   public void setUnicodeCharacter(  String Value )
   {
      AV9UnicodeCharacter= Value;
   }


}

