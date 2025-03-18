package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetdecimalfromhex_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetdecimalfromhex_RESTInterfaceIN
{
   String AV12HexadecimalValueIn;
   @JsonProperty("HexadecimalValueIn")
   public String getHexadecimalValueIn( )
   {
      if ( GXutil.strcmp(AV12HexadecimalValueIn, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV12HexadecimalValueIn ;
      }
   }

   @JsonProperty("HexadecimalValueIn")
   public void setHexadecimalValueIn(  String Value )
   {
      if ( Value == null )
      {
         AV12HexadecimalValueIn = "" ;
      }
      else
      {
         AV12HexadecimalValueIn= Value;
      }
   }


}

