package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "nmcartproductsadd_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class nmcartproductsadd_RESTInterfaceIN
{
   String AV10ProductId;
   @JsonProperty("ProductId")
   public String getProductId( )
   {
      if ( GXutil.strcmp(AV10ProductId, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10ProductId ;
      }
   }

   @JsonProperty("ProductId")
   public void setProductId(  String Value )
   {
      if ( Value == null )
      {
         AV10ProductId = "" ;
      }
      else
      {
         AV10ProductId= Value;
      }
   }


   short AV9Count;
   @JsonProperty("Count")
   public short getCount( )
   {
      return AV9Count ;
   }

   @JsonProperty("Count")
   public void setCount(  short Value )
   {
      AV9Count= Value;
   }


   short AV15Talle;
   @JsonProperty("Talle")
   public short getTalle( )
   {
      return AV15Talle ;
   }

   @JsonProperty("Talle")
   public void setTalle(  short Value )
   {
      AV15Talle= Value;
   }


   short AV20ProductDispon;
   @JsonProperty("ProductDispon")
   public short getProductDispon( )
   {
      return AV20ProductDispon ;
   }

   @JsonProperty("ProductDispon")
   public void setProductDispon(  short Value )
   {
      AV20ProductDispon= Value;
   }


}

