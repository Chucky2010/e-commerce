package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "prcinsertarcalificacionsd_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class prcinsertarcalificacionsd_RESTInterfaceIN
{
   short AV9Calificacion;
   @JsonProperty("Calificacion")
   public short getCalificacion( )
   {
      return AV9Calificacion ;
   }

   @JsonProperty("Calificacion")
   public void setCalificacion(  short Value )
   {
      AV9Calificacion= Value;
   }


   String AV10Comentario;
   @JsonProperty("Comentario")
   public String getComentario( )
   {
      if ( GXutil.strcmp(AV10Comentario, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10Comentario ;
      }
   }

   @JsonProperty("Comentario")
   public void setComentario(  String Value )
   {
      if ( Value == null )
      {
         AV10Comentario = "" ;
      }
      else
      {
         AV10Comentario= Value;
      }
   }


}

