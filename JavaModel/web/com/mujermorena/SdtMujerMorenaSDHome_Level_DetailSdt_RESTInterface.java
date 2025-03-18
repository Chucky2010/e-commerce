package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MujerMorenaSDHome_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMujerMorenaSDHome_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt>
{
   public SdtMujerMorenaSDHome_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt ());
   }

   public SdtMujerMorenaSDHome_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
}

