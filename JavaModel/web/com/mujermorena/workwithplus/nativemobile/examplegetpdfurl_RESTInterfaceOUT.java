package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.examplegetpdfurl_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class examplegetpdfurl_RESTInterfaceOUT
{
   String AV12PDFUrl;
   @JsonProperty("PDFUrl")
   public String getPDFUrl( )
   {
      return AV12PDFUrl ;
   }

   @JsonProperty("PDFUrl")
   public void setPDFUrl(  String Value )
   {
      AV12PDFUrl= Value;
   }


}

