package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetradialgaugelight_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetradialgaugelight_RESTInterfaceIN
{
   short AV10Value;
   @JsonProperty("Value")
   public short getValue( )
   {
      return AV10Value ;
   }

   @JsonProperty("Value")
   public void setValue(  short Value )
   {
      AV10Value= Value;
   }


   String AV9ProgressColor;
   @JsonProperty("ProgressColor")
   public String getProgressColor( )
   {
      if ( GXutil.strcmp(AV9ProgressColor, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9ProgressColor ;
      }
   }

   @JsonProperty("ProgressColor")
   public void setProgressColor(  String Value )
   {
      if ( Value == null )
      {
         AV9ProgressColor = "" ;
      }
      else
      {
         AV9ProgressColor= Value;
      }
   }


}

