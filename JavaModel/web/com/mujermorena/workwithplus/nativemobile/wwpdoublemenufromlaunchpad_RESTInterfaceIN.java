package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpdoublemenufromlaunchpad_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpdoublemenufromlaunchpad_RESTInterfaceIN
{
   Vector<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option_RESTInterface> AV11SDPLaunchpadOptions ;
   @JsonProperty("SDPLaunchpadOptions")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option_RESTInterface> getSDPLaunchpadOptions( )
   {
      return AV11SDPLaunchpadOptions ;
   }

   @JsonProperty("SDPLaunchpadOptions")
   public void setSDPLaunchpadOptions(  Vector<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option_RESTInterface> Value )
   {
      AV11SDPLaunchpadOptions= Value;
   }


}

