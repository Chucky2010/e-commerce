package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "gamsdregisteruser_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gamsdregisteruser_RESTInterfaceIN
{
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


   String AV9Email;
   @JsonProperty("Email")
   public String getEmail( )
   {
      if ( GXutil.strcmp(AV9Email, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9Email ;
      }
   }

   @JsonProperty("Email")
   public void setEmail(  String Value )
   {
      if ( Value == null )
      {
         AV9Email = "" ;
      }
      else
      {
         AV9Email= Value;
      }
   }


   String AV11FirstName;
   @JsonProperty("FirstName")
   public String getFirstName( )
   {
      if ( GXutil.strcmp(AV11FirstName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV11FirstName ;
      }
   }

   @JsonProperty("FirstName")
   public void setFirstName(  String Value )
   {
      if ( Value == null )
      {
         AV11FirstName = "" ;
      }
      else
      {
         AV11FirstName= Value;
      }
   }


   String AV12LastName;
   @JsonProperty("LastName")
   public String getLastName( )
   {
      if ( GXutil.strcmp(AV12LastName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV12LastName ;
      }
   }

   @JsonProperty("LastName")
   public void setLastName(  String Value )
   {
      if ( Value == null )
      {
         AV12LastName = "" ;
      }
      else
      {
         AV12LastName= Value;
      }
   }


   String AV16Password;
   @JsonProperty("Password")
   public String getPassword( )
   {
      if ( GXutil.strcmp(AV16Password, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16Password ;
      }
   }

   @JsonProperty("Password")
   public void setPassword(  String Value )
   {
      if ( Value == null )
      {
         AV16Password = "" ;
      }
      else
      {
         AV16Password= Value;
      }
   }


   String AV8ConfirmPassword;
   @JsonProperty("ConfirmPassword")
   public String getConfirmPassword( )
   {
      if ( GXutil.strcmp(AV8ConfirmPassword, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV8ConfirmPassword ;
      }
   }

   @JsonProperty("ConfirmPassword")
   public void setConfirmPassword(  String Value )
   {
      if ( Value == null )
      {
         AV8ConfirmPassword = "" ;
      }
      else
      {
         AV8ConfirmPassword= Value;
      }
   }


}

