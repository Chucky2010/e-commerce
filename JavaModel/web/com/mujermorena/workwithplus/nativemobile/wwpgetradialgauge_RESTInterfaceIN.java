package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpgetradialgauge_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpgetradialgauge_RESTInterfaceIN
{
   short AV16Value;
   @JsonProperty("Value")
   public short getValue( )
   {
      return AV16Value ;
   }

   @JsonProperty("Value")
   public void setValue(  short Value )
   {
      AV16Value= Value;
   }


   String AV10InnerText;
   @JsonProperty("InnerText")
   public String getInnerText( )
   {
      if ( GXutil.strcmp(AV10InnerText, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10InnerText ;
      }
   }

   @JsonProperty("InnerText")
   public void setInnerText(  String Value )
   {
      if ( Value == null )
      {
         AV10InnerText = "" ;
      }
      else
      {
         AV10InnerText= Value;
      }
   }


   String AV11ProgressColor;
   @JsonProperty("ProgressColor")
   public String getProgressColor( )
   {
      if ( GXutil.strcmp(AV11ProgressColor, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV11ProgressColor ;
      }
   }

   @JsonProperty("ProgressColor")
   public void setProgressColor(  String Value )
   {
      if ( Value == null )
      {
         AV11ProgressColor = "" ;
      }
      else
      {
         AV11ProgressColor= Value;
      }
   }


   String AV15TextColor;
   @JsonProperty("TextColor")
   public String getTextColor( )
   {
      if ( GXutil.strcmp(AV15TextColor, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15TextColor ;
      }
   }

   @JsonProperty("TextColor")
   public void setTextColor(  String Value )
   {
      if ( Value == null )
      {
         AV15TextColor = "" ;
      }
      else
      {
         AV15TextColor= Value;
      }
   }


   String AV14ShadowColor;
   @JsonProperty("ShadowColor")
   public String getShadowColor( )
   {
      if ( GXutil.strcmp(AV14ShadowColor, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV14ShadowColor ;
      }
   }

   @JsonProperty("ShadowColor")
   public void setShadowColor(  String Value )
   {
      if ( Value == null )
      {
         AV14ShadowColor = "" ;
      }
      else
      {
         AV14ShadowColor= Value;
      }
   }


   boolean AV9AllowAnimation;
   @JsonProperty("AllowAnimation")
   public boolean getAllowAnimation( )
   {
      return AV9AllowAnimation ;
   }

   @JsonProperty("AllowAnimation")
   public void setAllowAnimation(  boolean Value )
   {
      AV9AllowAnimation= Value;
   }


}

