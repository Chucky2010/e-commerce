package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "NMCartUserAddress", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtNMCartUserAddress_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtNMCartUserAddress>
{
   public SdtNMCartUserAddress_RESTInterface( )
   {
      super(new com.mujermorena.SdtNMCartUserAddress ());
   }

   public SdtNMCartUserAddress_RESTInterface( com.mujermorena.SdtNMCartUserAddress psdt )
   {
      super(psdt);
   }

   @JsonProperty("PersonName")
   public String getgxTv_SdtNMCartUserAddress_Personname( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Personname()) ;
   }

   @JsonProperty("PersonName")
   public void setgxTv_SdtNMCartUserAddress_Personname(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Personname(Value);
   }


   @JsonProperty("AddressLine1")
   public String getgxTv_SdtNMCartUserAddress_Addressline1( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Addressline1()) ;
   }

   @JsonProperty("AddressLine1")
   public void setgxTv_SdtNMCartUserAddress_Addressline1(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Addressline1(Value);
   }


   @JsonProperty("AddressLine2")
   public String getgxTv_SdtNMCartUserAddress_Addressline2( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Addressline2()) ;
   }

   @JsonProperty("AddressLine2")
   public void setgxTv_SdtNMCartUserAddress_Addressline2(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Addressline2(Value);
   }


   @JsonProperty("CountryName")
   public String getgxTv_SdtNMCartUserAddress_Countryname( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Countryname()) ;
   }

   @JsonProperty("CountryName")
   public void setgxTv_SdtNMCartUserAddress_Countryname(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Countryname(Value);
   }


   @JsonProperty("StateName")
   public String getgxTv_SdtNMCartUserAddress_Statename( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Statename()) ;
   }

   @JsonProperty("StateName")
   public void setgxTv_SdtNMCartUserAddress_Statename(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Statename(Value);
   }


   @JsonProperty("PhoneNumber")
   public String getgxTv_SdtNMCartUserAddress_Phonenumber( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Phonenumber()) ;
   }

   @JsonProperty("PhoneNumber")
   public void setgxTv_SdtNMCartUserAddress_Phonenumber(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Phonenumber(Value);
   }


   @JsonProperty("Ubicacion")
   public String getgxTv_SdtNMCartUserAddress_Ubicacion( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Ubicacion()) ;
   }

   @JsonProperty("Ubicacion")
   public void setgxTv_SdtNMCartUserAddress_Ubicacion(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Ubicacion(Value);
   }


   @JsonProperty("Id")
   public String getgxTv_SdtNMCartUserAddress_Id( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtNMCartUserAddress)getSdt()).getgxTv_SdtNMCartUserAddress_Id()) ;
   }

   @JsonProperty("Id")
   public void setgxTv_SdtNMCartUserAddress_Id(  String Value )
   {
      ((com.mujermorena.SdtNMCartUserAddress)getSdt()).setgxTv_SdtNMCartUserAddress_Id(Value);
   }


   int remoteHandle = -1;
}

