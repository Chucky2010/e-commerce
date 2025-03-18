package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdynamicfieldstojson_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdynamicfieldstojson_RESTInterfaceOUT
{
   String AV10FormFieldsJson;
   @JsonProperty("FormFieldsJson")
   public String getFormFieldsJson( )
   {
      return AV10FormFieldsJson ;
   }

   @JsonProperty("FormFieldsJson")
   public void setFormFieldsJson(  String Value )
   {
      AV10FormFieldsJson= Value;
   }


}

