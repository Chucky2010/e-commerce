package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdynamicfieldstojson_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdynamicfieldstojson_RESTInterfaceIN
{
   Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface> AV9DynamicFormFields ;
   @JsonProperty("DynamicFormFields")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface> getDynamicFormFields( )
   {
      return AV9DynamicFormFields ;
   }

   @JsonProperty("DynamicFormFields")
   public void setDynamicFormFields(  Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface> Value )
   {
      AV9DynamicFormFields= Value;
   }


}

