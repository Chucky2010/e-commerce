package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "LaunchpadOptions.Option", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtLaunchpadOptions_Option_RESTInterface extends GxGenericCollectionItem<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option>
{
   public SdtLaunchpadOptions_Option_RESTInterface( )
   {
      super(new com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option ());
   }

   public SdtLaunchpadOptions_Option_RESTInterface( com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option psdt )
   {
      super(psdt);
   }

   @JsonProperty("Name")
   public String getgxTv_SdtLaunchpadOptions_Option_Name( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Name()) ;
   }

   @JsonProperty("Name")
   public void setgxTv_SdtLaunchpadOptions_Option_Name(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Name(Value);
   }


   @JsonProperty("Description")
   public String getgxTv_SdtLaunchpadOptions_Option_Description( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Description()) ;
   }

   @JsonProperty("Description")
   public void setgxTv_SdtLaunchpadOptions_Option_Description(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Description(Value);
   }


   @JsonProperty("Information")
   public String getgxTv_SdtLaunchpadOptions_Option_Information( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Information()) ;
   }

   @JsonProperty("Information")
   public void setgxTv_SdtLaunchpadOptions_Option_Information(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Information(Value);
   }


   @JsonProperty("Link")
   public String getgxTv_SdtLaunchpadOptions_Option_Link( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Link()) ;
   }

   @JsonProperty("Link")
   public void setgxTv_SdtLaunchpadOptions_Option_Link(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Link(Value);
   }


   @JsonProperty("Icon")
   public String getgxTv_SdtLaunchpadOptions_Option_Icon( )
   {
      return GXutil.getRelativeURL(((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Icon()) ;
   }

   @JsonProperty("Icon")
   public void setgxTv_SdtLaunchpadOptions_Option_Icon(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Icon(Value);
   }


   @JsonProperty("OrderIndex")
   public Integer getgxTv_SdtLaunchpadOptions_Option_Orderindex( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Orderindex() ;
   }

   @JsonProperty("OrderIndex")
   public void setgxTv_SdtLaunchpadOptions_Option_Orderindex(  Integer Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Orderindex(Value);
   }


   @JsonProperty("TileSize")
   public Byte getgxTv_SdtLaunchpadOptions_Option_Tilesize( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Tilesize() ;
   }

   @JsonProperty("TileSize")
   public void setgxTv_SdtLaunchpadOptions_Option_Tilesize(  Byte Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Tilesize(Value);
   }


   @JsonProperty("TileType")
   public Byte getgxTv_SdtLaunchpadOptions_Option_Tiletype( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).getgxTv_SdtLaunchpadOptions_Option_Tiletype() ;
   }

   @JsonProperty("TileType")
   public void setgxTv_SdtLaunchpadOptions_Option_Tiletype(  Byte Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)getSdt()).setgxTv_SdtLaunchpadOptions_Option_Tiletype(Value);
   }


   int remoteHandle = -1;
}

