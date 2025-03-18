package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MujerMorenaSDOB_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMujerMorenaSDOB_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt>
{
   public SdtMujerMorenaSDOB_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt ());
   }

   public SdtMujerMorenaSDOB_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Gxdynprop")
   public String getgxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop()) ;
   }

   @JsonProperty("Gxdynprop")
   public void setgxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop(Value);
   }


   int remoteHandle = -1;
}

