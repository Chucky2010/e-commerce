package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "wwpbaseobjects.secgamisauthbyfunctionalitykey_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class secgamisauthbyfunctionalitykey_RESTInterfaceIN
{
   String AV10SecGAMFunctionalityKey;
   @JsonProperty("SecGAMFunctionalityKey")
   public String getSecGAMFunctionalityKey( )
   {
      if ( GXutil.strcmp(AV10SecGAMFunctionalityKey, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10SecGAMFunctionalityKey ;
      }
   }

   @JsonProperty("SecGAMFunctionalityKey")
   public void setSecGAMFunctionalityKey(  String Value )
   {
      if ( Value == null )
      {
         AV10SecGAMFunctionalityKey = "" ;
      }
      else
      {
         AV10SecGAMFunctionalityKey= Value;
      }
   }


}

