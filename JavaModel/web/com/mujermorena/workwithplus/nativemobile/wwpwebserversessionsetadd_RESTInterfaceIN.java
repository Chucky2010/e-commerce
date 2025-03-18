package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpwebserversessionsetadd_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpwebserversessionsetadd_RESTInterfaceIN
{
   com.mujermorena.SdtNMCartPayment_RESTInterface AV26CartPayment;
   @JsonProperty("CartPayment")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.mujermorena.SdtNMCartPayment_RESTInterface getCartPayment( )
   {
      return AV26CartPayment ;
   }

   @JsonProperty("CartPayment")
   public void setCartPayment(  com.mujermorena.SdtNMCartPayment_RESTInterface Value )
   {
      AV26CartPayment= Value;
   }


   com.mujermorena.SdtNMCartUserAddress_RESTInterface AV27CartUserAddress;
   @JsonProperty("CartUserAddress")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.mujermorena.SdtNMCartUserAddress_RESTInterface getCartUserAddress( )
   {
      return AV27CartUserAddress ;
   }

   @JsonProperty("CartUserAddress")
   public void setCartUserAddress(  com.mujermorena.SdtNMCartUserAddress_RESTInterface Value )
   {
      AV27CartUserAddress= Value;
   }


   String AV8ParameterKey;
   @JsonProperty("ParameterKey")
   public String getParameterKey( )
   {
      if ( GXutil.strcmp(AV8ParameterKey, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV8ParameterKey ;
      }
   }

   @JsonProperty("ParameterKey")
   public void setParameterKey(  String Value )
   {
      if ( Value == null )
      {
         AV8ParameterKey = "" ;
      }
      else
      {
         AV8ParameterKey= Value;
      }
   }


   String AV9ParameterValue;
   @JsonProperty("ParameterValue")
   public String getParameterValue( )
   {
      if ( GXutil.strcmp(AV9ParameterValue, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9ParameterValue ;
      }
   }

   @JsonProperty("ParameterValue")
   public void setParameterValue(  String Value )
   {
      if ( Value == null )
      {
         AV9ParameterValue = "" ;
      }
      else
      {
         AV9ParameterValue= Value;
      }
   }


}

