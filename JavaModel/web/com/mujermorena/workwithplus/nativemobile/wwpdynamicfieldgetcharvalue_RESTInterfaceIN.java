package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdynamicfieldgetcharvalue_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdynamicfieldgetcharvalue_RESTInterfaceIN
{
   com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface AV8DynamicFormField;
   @JsonProperty("DynamicFormField")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface getDynamicFormField( )
   {
      return AV8DynamicFormField ;
   }

   @JsonProperty("DynamicFormField")
   public void setDynamicFormField(  com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface Value )
   {
      AV8DynamicFormField= Value;
   }


}

