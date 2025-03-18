package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetrangedradialgauge_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetrangedradialgauge_RESTInterfaceIN
{
   short AV11Value;
   @JsonProperty("Value")
   public short getValue( )
   {
      return AV11Value ;
   }

   @JsonProperty("Value")
   public void setValue(  short Value )
   {
      AV11Value= Value;
   }


   String AV10Text;
   @JsonProperty("Text")
   public String getText( )
   {
      if ( GXutil.strcmp(AV10Text, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10Text ;
      }
   }

   @JsonProperty("Text")
   public void setText(  String Value )
   {
      if ( Value == null )
      {
         AV10Text = "" ;
      }
      else
      {
         AV10Text= Value;
      }
   }


}

