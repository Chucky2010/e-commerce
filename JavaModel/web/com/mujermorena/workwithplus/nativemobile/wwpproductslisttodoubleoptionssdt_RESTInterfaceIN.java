package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpproductslisttodoubleoptionssdt_RESTInterfaceIN
{
   Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> AV14ProductDataList ;
   @JsonProperty("ProductDataList")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> getProductDataList( )
   {
      return AV14ProductDataList ;
   }

   @JsonProperty("ProductDataList")
   public void setProductDataList(  Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> Value )
   {
      AV14ProductDataList= Value;
   }


}

