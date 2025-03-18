package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "nmcartpaymentmethodsaddnew_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class nmcartpaymentmethodsaddnew_RESTInterfaceIN
{
   String AV10CardInformationJson;
   @JsonProperty("CardInformationJson")
   public String getCardInformationJson( )
   {
      if ( GXutil.strcmp(AV10CardInformationJson, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10CardInformationJson ;
      }
   }

   @JsonProperty("CardInformationJson")
   public void setCardInformationJson(  String Value )
   {
      if ( Value == null )
      {
         AV10CardInformationJson = "" ;
      }
      else
      {
         AV10CardInformationJson= Value;
      }
   }


}

