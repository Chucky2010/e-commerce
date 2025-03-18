package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "WWPProductData", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtWWPProductData_RESTInterface extends GxGenericCollectionItem<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>
{
   public SdtWWPProductData_RESTInterface( )
   {
      super(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData ());
   }

   public SdtWWPProductData_RESTInterface( com.mujermorena.workwithplus.nativemobile.SdtWWPProductData psdt )
   {
      super(psdt);
   }

   @JsonProperty("Id")
   public String getgxTv_SdtWWPProductData_Id( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Id()) ;
   }

   @JsonProperty("Id")
   public void setgxTv_SdtWWPProductData_Id(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Id(Value);
   }


   @JsonProperty("Type")
   public Short getgxTv_SdtWWPProductData_Type( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Type() ;
   }

   @JsonProperty("Type")
   public void setgxTv_SdtWWPProductData_Type(  Short Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Type(Value);
   }


   @JsonProperty("Title")
   public String getgxTv_SdtWWPProductData_Title( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Title()) ;
   }

   @JsonProperty("Title")
   public void setgxTv_SdtWWPProductData_Title(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Title(Value);
   }


   @JsonProperty("Description")
   public String getgxTv_SdtWWPProductData_Description( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Description()) ;
   }

   @JsonProperty("Description")
   public void setgxTv_SdtWWPProductData_Description(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Description(Value);
   }


   @JsonProperty("Image")
   public String getgxTv_SdtWWPProductData_Image( )
   {
      return GXutil.getRelativeURL(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Image()) ;
   }

   @JsonProperty("Image")
   public void setgxTv_SdtWWPProductData_Image(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Image(Value);
   }


   @JsonProperty("Subtitle")
   public String getgxTv_SdtWWPProductData_Subtitle( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Subtitle()) ;
   }

   @JsonProperty("Subtitle")
   public void setgxTv_SdtWWPProductData_Subtitle(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Subtitle(Value);
   }


   @JsonProperty("Information1")
   public String getgxTv_SdtWWPProductData_Information1( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Information1()) ;
   }

   @JsonProperty("Information1")
   public void setgxTv_SdtWWPProductData_Information1(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Information1(Value);
   }


   @JsonProperty("Information2")
   public String getgxTv_SdtWWPProductData_Information2( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Information2()) ;
   }

   @JsonProperty("Information2")
   public void setgxTv_SdtWWPProductData_Information2(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Information2(Value);
   }


   @JsonProperty("ComponentToCall")
   public String getgxTv_SdtWWPProductData_Componenttocall( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).getgxTv_SdtWWPProductData_Componenttocall()) ;
   }

   @JsonProperty("ComponentToCall")
   public void setgxTv_SdtWWPProductData_Componenttocall(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)getSdt()).setgxTv_SdtWWPProductData_Componenttocall(Value);
   }


   int remoteHandle = -1;
}

