package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdoublemenufromlaunchpad_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdoublemenufromlaunchpad_RESTInterfaceOUT
{
   Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> AV8SDPDoubleMenuOptions ;
   @JsonProperty("SDPDoubleMenuOptions")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> getSDPDoubleMenuOptions( )
   {
      return AV8SDPDoubleMenuOptions ;
   }

   @JsonProperty("SDPDoubleMenuOptions")
   public void setSDPDoubleMenuOptions(  Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> Value )
   {
      AV8SDPDoubleMenuOptions= Value;
   }


}

