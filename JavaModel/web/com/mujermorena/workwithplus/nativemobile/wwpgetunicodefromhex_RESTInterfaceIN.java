package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetunicodefromhex_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetunicodefromhex_RESTInterfaceIN
{
   String AV8HexaUnicode;
   @JsonProperty("HexaUnicode")
   public String getHexaUnicode( )
   {
      if ( GXutil.strcmp(AV8HexaUnicode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV8HexaUnicode ;
      }
   }

   @JsonProperty("HexaUnicode")
   public void setHexaUnicode(  String Value )
   {
      if ( Value == null )
      {
         AV8HexaUnicode = "" ;
      }
      else
      {
         AV8HexaUnicode= Value;
      }
   }


}

