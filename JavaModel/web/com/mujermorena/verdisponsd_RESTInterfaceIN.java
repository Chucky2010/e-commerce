package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "verdisponsd_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class verdisponsd_RESTInterfaceIN
{
   String AV8ProductId;
   @JsonProperty("ProductId")
   public String getProductId( )
   {
      if ( GXutil.strcmp(AV8ProductId, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV8ProductId ;
      }
   }

   @JsonProperty("ProductId")
   public void setProductId(  String Value )
   {
      if ( Value == null )
      {
         AV8ProductId = "" ;
      }
      else
      {
         AV8ProductId= Value;
      }
   }


   short AV9ProductTalla;
   @JsonProperty("ProductTalla")
   public short getProductTalla( )
   {
      return AV9ProductTalla ;
   }

   @JsonProperty("ProductTalla")
   public void setProductTalla(  short Value )
   {
      AV9ProductTalla= Value;
   }


}

