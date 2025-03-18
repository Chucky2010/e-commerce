package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpmappointfromstring_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpmappointfromstring_RESTInterfaceIN
{
   String AV12SelectedItem;
   @JsonProperty("SelectedItem")
   public String getSelectedItem( )
   {
      if ( GXutil.strcmp(AV12SelectedItem, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV12SelectedItem ;
      }
   }

   @JsonProperty("SelectedItem")
   public void setSelectedItem(  String Value )
   {
      if ( Value == null )
      {
         AV12SelectedItem = "" ;
      }
      else
      {
         AV12SelectedItem= Value;
      }
   }


}

