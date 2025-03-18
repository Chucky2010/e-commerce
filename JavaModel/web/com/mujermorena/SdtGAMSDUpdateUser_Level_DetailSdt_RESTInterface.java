package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "GAMSDUpdateUser_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtGAMSDUpdateUser_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt>
{
   public SdtGAMSDUpdateUser_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt ());
   }

   public SdtGAMSDUpdateUser_Level_DetailSdt_RESTInterface( com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Username")
   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username()) ;
   }

   @JsonProperty("Username")
   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username(  String Value )
   {
      ((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username(Value);
   }


   @JsonProperty("Email")
   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email()) ;
   }

   @JsonProperty("Email")
   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email(  String Value )
   {
      ((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email(Value);
   }


   @JsonProperty("Firstname")
   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname()) ;
   }

   @JsonProperty("Firstname")
   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname(  String Value )
   {
      ((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname(Value);
   }


   @JsonProperty("Lastname")
   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname()) ;
   }

   @JsonProperty("Lastname")
   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname(  String Value )
   {
      ((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname(Value);
   }


   @JsonProperty("Userguid")
   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid()) ;
   }

   @JsonProperty("Userguid")
   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid(  String Value )
   {
      ((com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid(Value);
   }


   int remoteHandle = -1;
}

