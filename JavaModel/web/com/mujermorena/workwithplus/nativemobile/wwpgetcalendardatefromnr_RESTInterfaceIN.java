package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetcalendardatefromnr_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetcalendardatefromnr_RESTInterfaceIN
{
   short AV12Year;
   @JsonProperty("Year")
   public short getYear( )
   {
      return AV12Year ;
   }

   @JsonProperty("Year")
   public void setYear(  short Value )
   {
      AV12Year= Value;
   }


   byte AV11Month;
   @JsonProperty("Month")
   public byte getMonth( )
   {
      return AV11Month ;
   }

   @JsonProperty("Month")
   public void setMonth(  byte Value )
   {
      AV11Month= Value;
   }


   byte AV10Day;
   @JsonProperty("Day")
   public byte getDay( )
   {
      return AV10Day ;
   }

   @JsonProperty("Day")
   public void setDay(  byte Value )
   {
      AV10Day= Value;
   }


}

