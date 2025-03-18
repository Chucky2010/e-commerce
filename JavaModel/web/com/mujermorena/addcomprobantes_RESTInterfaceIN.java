package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "addcomprobantes_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class addcomprobantes_RESTInterfaceIN
{
   String AV16PedidosID;
   @JsonProperty("PedidosID")
   public String getPedidosID( )
   {
      return AV16PedidosID ;
   }

   @JsonProperty("PedidosID")
   public void setPedidosID(  String Value )
   {
      AV16PedidosID= Value;
   }


   String AV17PedidosImagenComprobante;
   @JsonProperty("PedidosImagenComprobante")
   public String getPedidosImagenComprobante( )
   {
      return AV17PedidosImagenComprobante ;
   }

   @JsonProperty("PedidosImagenComprobante")
   public void setPedidosImagenComprobante(  String Value )
   {
      AV17PedidosImagenComprobante= Value;
   }


   String AV18PedidosComprobanteObs;
   @JsonProperty("PedidosComprobanteObs")
   public String getPedidosComprobanteObs( )
   {
      if ( GXutil.strcmp(AV18PedidosComprobanteObs, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV18PedidosComprobanteObs ;
      }
   }

   @JsonProperty("PedidosComprobanteObs")
   public void setPedidosComprobanteObs(  String Value )
   {
      if ( Value == null )
      {
         AV18PedidosComprobanteObs = "" ;
      }
      else
      {
         AV18PedidosComprobanteObs= Value;
      }
   }


}

