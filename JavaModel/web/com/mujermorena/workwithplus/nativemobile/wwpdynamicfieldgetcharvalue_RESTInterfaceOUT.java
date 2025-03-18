package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdynamicfieldgetcharvalue_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdynamicfieldgetcharvalue_RESTInterfaceOUT
{
   String AV9FieldValue;
   @JsonProperty("FieldValue")
   public String getFieldValue( )
   {
      return AV9FieldValue ;
   }

   @JsonProperty("FieldValue")
   public void setFieldValue(  String Value )
   {
      AV9FieldValue= Value;
   }


}

