package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "wwpbaseobjects.secgamisauthbyfunctionalitykey_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class secgamisauthbyfunctionalitykey_RESTInterfaceOUT
{
   boolean AV9IsAuthorized;
   @JsonProperty("IsAuthorized")
   public boolean getIsAuthorized( )
   {
      return AV9IsAuthorized ;
   }

   @JsonProperty("IsAuthorized")
   public void setIsAuthorized(  boolean Value )
   {
      AV9IsAuthorized= Value;
   }


}

