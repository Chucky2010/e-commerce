package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "WWPProductDataImages", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtWWPProductDataImages_RESTInterface extends GxGenericCollectionItem<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>
{
   public SdtWWPProductDataImages_RESTInterface( )
   {
      super(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages ());
   }

   public SdtWWPProductDataImages_RESTInterface( com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages psdt )
   {
      super(psdt);
   }

   @JsonProperty("Image")
   public String getgxTv_SdtWWPProductDataImages_Image( )
   {
      return GXutil.getRelativeURL(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)getSdt()).getgxTv_SdtWWPProductDataImages_Image()) ;
   }

   @JsonProperty("Image")
   public void setgxTv_SdtWWPProductDataImages_Image(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)getSdt()).setgxTv_SdtWWPProductDataImages_Image(Value);
   }


   @JsonProperty("Description")
   public String getgxTv_SdtWWPProductDataImages_Description( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)getSdt()).getgxTv_SdtWWPProductDataImages_Description()) ;
   }

   @JsonProperty("Description")
   public void setgxTv_SdtWWPProductDataImages_Description(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)getSdt()).setgxTv_SdtWWPProductDataImages_Description(Value);
   }


   int remoteHandle = -1;
}

