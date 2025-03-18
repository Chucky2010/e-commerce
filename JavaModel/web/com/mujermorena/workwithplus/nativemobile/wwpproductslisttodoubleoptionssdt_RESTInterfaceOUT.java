package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_RESTInterfaceOUT", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpproductslisttodoubleoptionssdt_RESTInterfaceOUT
{
   Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> AV11DoubleMenuOptions ;
   @JsonProperty("DoubleMenuOptions")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> getDoubleMenuOptions( )
   {
      return AV11DoubleMenuOptions ;
   }

   @JsonProperty("DoubleMenuOptions")
   public void setDoubleMenuOptions(  Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> Value )
   {
      AV11DoubleMenuOptions= Value;
   }


}

