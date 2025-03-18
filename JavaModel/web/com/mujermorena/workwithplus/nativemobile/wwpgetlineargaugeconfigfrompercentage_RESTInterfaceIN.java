package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetlineargaugeconfigfrompercentage_RESTInterfaceIN
{
   short AV9Percentage;
   @JsonProperty("Percentage")
   public short getPercentage( )
   {
      return AV9Percentage ;
   }

   @JsonProperty("Percentage")
   public void setPercentage(  short Value )
   {
      AV9Percentage= Value;
   }


}

