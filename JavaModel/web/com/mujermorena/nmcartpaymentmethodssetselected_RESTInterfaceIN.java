package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "nmcartpaymentmethodssetselected_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class nmcartpaymentmethodssetselected_RESTInterfaceIN
{
   String AV8Selected;
   @JsonProperty("Selected")
   public String getSelected( )
   {
      if ( GXutil.strcmp(AV8Selected, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV8Selected ;
      }
   }

   @JsonProperty("Selected")
   public void setSelected(  String Value )
   {
      if ( Value == null )
      {
         AV8Selected = "" ;
      }
      else
      {
         AV8Selected= Value;
      }
   }


}

