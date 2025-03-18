package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "GAMSDChangePassword_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtGAMSDChangePassword_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt>
{
   public SdtGAMSDChangePassword_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt ());
   }

   public SdtGAMSDChangePassword_Level_DetailSdt_RESTInterface( com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Username")
   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username()) ;
   }

   @JsonProperty("Username")
   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username(  String Value )
   {
      ((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username(Value);
   }


   @JsonProperty("Userpassword")
   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword()) ;
   }

   @JsonProperty("Userpassword")
   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword(  String Value )
   {
      ((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword(Value);
   }


   @JsonProperty("Userpasswordnew")
   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew()) ;
   }

   @JsonProperty("Userpasswordnew")
   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew(  String Value )
   {
      ((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew(Value);
   }


   @JsonProperty("Userpasswordnewconf")
   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf()) ;
   }

   @JsonProperty("Userpasswordnewconf")
   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf(  String Value )
   {
      ((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf(Value);
   }


   @JsonProperty("Ispasswordexpires")
   public Boolean getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires( )
   {
      return ((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires() ;
   }

   @JsonProperty("Ispasswordexpires")
   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires(  Boolean Value )
   {
      ((com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)getSdt()).setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires(Value);
   }


   int remoteHandle = -1;
}

