package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "gamsdupdateregisteruser_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gamsdupdateregisteruser_RESTInterfaceIN
{
   String AV19UserGUID;
   @JsonProperty("UserGUID")
   public String getUserGUID( )
   {
      if ( GXutil.strcmp(AV19UserGUID, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19UserGUID ;
      }
   }

   @JsonProperty("UserGUID")
   public void setUserGUID(  String Value )
   {
      if ( Value == null )
      {
         AV19UserGUID = "" ;
      }
      else
      {
         AV19UserGUID= Value;
      }
   }


   String AV18UserName;
   @JsonProperty("UserName")
   public String getUserName( )
   {
      if ( GXutil.strcmp(AV18UserName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV18UserName ;
      }
   }

   @JsonProperty("UserName")
   public void setUserName(  String Value )
   {
      if ( Value == null )
      {
         AV18UserName = "" ;
      }
      else
      {
         AV18UserName= Value;
      }
   }


   String AV10Email;
   @JsonProperty("Email")
   public String getEmail( )
   {
      if ( GXutil.strcmp(AV10Email, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10Email ;
      }
   }

   @JsonProperty("Email")
   public void setEmail(  String Value )
   {
      if ( Value == null )
      {
         AV10Email = "" ;
      }
      else
      {
         AV10Email= Value;
      }
   }


   String AV12FirstName;
   @JsonProperty("FirstName")
   public String getFirstName( )
   {
      if ( GXutil.strcmp(AV12FirstName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV12FirstName ;
      }
   }

   @JsonProperty("FirstName")
   public void setFirstName(  String Value )
   {
      if ( Value == null )
      {
         AV12FirstName = "" ;
      }
      else
      {
         AV12FirstName= Value;
      }
   }


   String AV14LastName;
   @JsonProperty("LastName")
   public String getLastName( )
   {
      if ( GXutil.strcmp(AV14LastName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV14LastName ;
      }
   }

   @JsonProperty("LastName")
   public void setLastName(  String Value )
   {
      if ( Value == null )
      {
         AV14LastName = "" ;
      }
      else
      {
         AV14LastName= Value;
      }
   }


}

