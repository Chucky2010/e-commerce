package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "workwithplus.nativemobile.wwpcreatelocationslist_RESTInterfaceIN", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wwpcreatelocationslist_RESTInterfaceIN
{
   String AV10SelectedItem;
   @JsonProperty("SelectedItem")
   public String getSelectedItem( )
   {
      if ( GXutil.strcmp(AV10SelectedItem, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10SelectedItem ;
      }
   }

   @JsonProperty("SelectedItem")
   public void setSelectedItem(  String Value )
   {
      if ( Value == null )
      {
         AV10SelectedItem = "" ;
      }
      else
      {
         AV10SelectedItem= Value;
      }
   }


   String AV11SelectedItemText;
   @JsonProperty("SelectedItemText")
   public String getSelectedItemText( )
   {
      if ( GXutil.strcmp(AV11SelectedItemText, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV11SelectedItemText ;
      }
   }

   @JsonProperty("SelectedItemText")
   public void setSelectedItemText(  String Value )
   {
      if ( Value == null )
      {
         AV11SelectedItemText = "" ;
      }
      else
      {
         AV11SelectedItemText= Value;
      }
   }


}

