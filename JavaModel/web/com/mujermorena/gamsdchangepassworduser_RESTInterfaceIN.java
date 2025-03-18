package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "gamsdchangepassworduser_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gamsdchangepassworduser_RESTInterfaceIN
{
   boolean AV10isPasswordExpires;
   @JsonProperty("isPasswordExpires")
   public boolean getisPasswordExpires( )
   {
      return AV10isPasswordExpires ;
   }

   @JsonProperty("isPasswordExpires")
   public void setisPasswordExpires(  boolean Value )
   {
      AV10isPasswordExpires= Value;
   }


   String AV13UserName;
   @JsonProperty("UserName")
   public String getUserName( )
   {
      if ( GXutil.strcmp(AV13UserName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV13UserName ;
      }
   }

   @JsonProperty("UserName")
   public void setUserName(  String Value )
   {
      if ( Value == null )
      {
         AV13UserName = "" ;
      }
      else
      {
         AV13UserName= Value;
      }
   }


   String AV14UserPassword;
   @JsonProperty("UserPassword")
   public String getUserPassword( )
   {
      if ( GXutil.strcmp(AV14UserPassword, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV14UserPassword ;
      }
   }

   @JsonProperty("UserPassword")
   public void setUserPassword(  String Value )
   {
      if ( Value == null )
      {
         AV14UserPassword = "" ;
      }
      else
      {
         AV14UserPassword= Value;
      }
   }


   String AV15UserPasswordNew;
   @JsonProperty("UserPasswordNew")
   public String getUserPasswordNew( )
   {
      if ( GXutil.strcmp(AV15UserPasswordNew, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15UserPasswordNew ;
      }
   }

   @JsonProperty("UserPasswordNew")
   public void setUserPasswordNew(  String Value )
   {
      if ( Value == null )
      {
         AV15UserPasswordNew = "" ;
      }
      else
      {
         AV15UserPasswordNew= Value;
      }
   }


   String AV16UserPasswordNewConf;
   @JsonProperty("UserPasswordNewConf")
   public String getUserPasswordNewConf( )
   {
      if ( GXutil.strcmp(AV16UserPasswordNewConf, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16UserPasswordNewConf ;
      }
   }

   @JsonProperty("UserPasswordNewConf")
   public void setUserPasswordNewConf(  String Value )
   {
      if ( Value == null )
      {
         AV16UserPasswordNewConf = "" ;
      }
      else
      {
         AV16UserPasswordNewConf= Value;
      }
   }


}

