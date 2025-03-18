package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "directionsservicerequest_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class directionsservicerequest_RESTInterfaceIN
{
   String AV9DirectionsServiceProvider;
   @JsonProperty("DirectionsServiceProvider")
   public String getDirectionsServiceProvider( )
   {
      if ( GXutil.strcmp(AV9DirectionsServiceProvider, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9DirectionsServiceProvider ;
      }
   }

   @JsonProperty("DirectionsServiceProvider")
   public void setDirectionsServiceProvider(  String Value )
   {
      if ( Value == null )
      {
         AV9DirectionsServiceProvider = "" ;
      }
      else
      {
         AV9DirectionsServiceProvider= Value;
      }
   }


   com.genexuscore.genexus.common.SdtDirectionsRequestParameters_RESTInterface AV8DirectionsRequestParameters;
   @JsonProperty("DirectionsRequestParameters")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.genexuscore.genexus.common.SdtDirectionsRequestParameters_RESTInterface getDirectionsRequestParameters( )
   {
      return AV8DirectionsRequestParameters ;
   }

   @JsonProperty("DirectionsRequestParameters")
   public void setDirectionsRequestParameters(  com.genexuscore.genexus.common.SdtDirectionsRequestParameters_RESTInterface Value )
   {
      AV8DirectionsRequestParameters= Value;
   }


}

