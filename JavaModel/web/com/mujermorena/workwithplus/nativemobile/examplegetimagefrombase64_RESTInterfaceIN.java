package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.examplegetimagefrombase64_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class examplegetimagefrombase64_RESTInterfaceIN
{
   String AV10ImageBase64;
   @JsonProperty("ImageBase64")
   public String getImageBase64( )
   {
      if ( GXutil.strcmp(AV10ImageBase64, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10ImageBase64 ;
      }
   }

   @JsonProperty("ImageBase64")
   public void setImageBase64(  String Value )
   {
      if ( Value == null )
      {
         AV10ImageBase64 = "" ;
      }
      else
      {
         AV10ImageBase64= Value;
      }
   }


}

