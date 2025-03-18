package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "notificationsregistrationhandler_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class notificationsregistrationhandler_RESTInterfaceIN
{
   byte AV11DeviceType;
   @JsonProperty("DeviceType")
   public byte getDeviceType( )
   {
      return AV11DeviceType ;
   }

   @JsonProperty("DeviceType")
   public void setDeviceType(  byte Value )
   {
      AV11DeviceType= Value;
   }


   String AV8DeviceId;
   @JsonProperty("DeviceId")
   public String getDeviceId( )
   {
      if ( GXutil.strcmp(AV8DeviceId, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV8DeviceId ;
      }
   }

   @JsonProperty("DeviceId")
   public void setDeviceId(  String Value )
   {
      if ( Value == null )
      {
         AV8DeviceId = "" ;
      }
      else
      {
         AV8DeviceId= Value;
      }
   }


   String AV10DeviceToken;
   @JsonProperty("DeviceToken")
   public String getDeviceToken( )
   {
      if ( GXutil.strcmp(AV10DeviceToken, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10DeviceToken ;
      }
   }

   @JsonProperty("DeviceToken")
   public void setDeviceToken(  String Value )
   {
      if ( Value == null )
      {
         AV10DeviceToken = "" ;
      }
      else
      {
         AV10DeviceToken= Value;
      }
   }


   String AV9DeviceName;
   @JsonProperty("DeviceName")
   public String getDeviceName( )
   {
      if ( GXutil.strcmp(AV9DeviceName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9DeviceName ;
      }
   }

   @JsonProperty("DeviceName")
   public void setDeviceName(  String Value )
   {
      if ( Value == null )
      {
         AV9DeviceName = "" ;
      }
      else
      {
         AV9DeviceName= Value;
      }
   }


}

