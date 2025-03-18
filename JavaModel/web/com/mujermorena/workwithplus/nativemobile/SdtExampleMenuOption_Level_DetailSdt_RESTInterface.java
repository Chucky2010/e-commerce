package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "ExampleMenuOption_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtExampleMenuOption_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt>
{
   public SdtExampleMenuOption_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt ());
   }

   public SdtExampleMenuOption_Level_DetailSdt_RESTInterface( com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt)getSdt()).getgxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt)getSdt()).setgxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
}

