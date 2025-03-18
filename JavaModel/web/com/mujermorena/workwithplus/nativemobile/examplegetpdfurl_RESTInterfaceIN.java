package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.examplegetpdfurl_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class examplegetpdfurl_RESTInterfaceIN
{
   String AV9ServerUrl;
   @JsonProperty("ServerUrl")
   public String getServerUrl( )
   {
      if ( GXutil.strcmp(AV9ServerUrl, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9ServerUrl ;
      }
   }

   @JsonProperty("ServerUrl")
   public void setServerUrl(  String Value )
   {
      if ( Value == null )
      {
         AV9ServerUrl = "" ;
      }
      else
      {
         AV9ServerUrl= Value;
      }
   }


   short AV14TransactionWithBlobId;
   @JsonProperty("TransactionWithBlobId")
   public short getTransactionWithBlobId( )
   {
      return AV14TransactionWithBlobId ;
   }

   @JsonProperty("TransactionWithBlobId")
   public void setTransactionWithBlobId(  short Value )
   {
      AV14TransactionWithBlobId= Value;
   }


}

