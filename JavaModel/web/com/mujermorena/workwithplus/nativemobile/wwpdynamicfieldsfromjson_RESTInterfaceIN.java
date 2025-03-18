package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdynamicfieldsfromjson_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdynamicfieldsfromjson_RESTInterfaceIN
{
   String AV9FormFieldsJson;
   @JsonProperty("FormFieldsJson")
   public String getFormFieldsJson( )
   {
      if ( GXutil.strcmp(AV9FormFieldsJson, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9FormFieldsJson ;
      }
   }

   @JsonProperty("FormFieldsJson")
   public void setFormFieldsJson(  String Value )
   {
      if ( Value == null )
      {
         AV9FormFieldsJson = "" ;
      }
      else
      {
         AV9FormFieldsJson= Value;
      }
   }


}

