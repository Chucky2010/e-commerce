package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/PrcInsertarCalificacionSD")
public final  class prcinsertarcalificacionsd_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.prcinsertarcalificacionsd_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      short [] AV9Calificacion = new short[] { 0 };
      AV9Calificacion[0] = entity.getCalificacion() ;
      String [] AV10Comentario = new String[] { "" };
      AV10Comentario[0] = entity.getComentario() ;
      permissionPrefix = "prcinsertarcalificacionsd_Services_Execute";
      if ( ! isAuthenticated(myServletRequestWrapper) )
      {
         if ( forbidden )
         {
            builder = Response.forbidden();
         }
         else
         {
            setWWWAuthHeader(myServletRequestWrapper, myServletResponseWrapper);
            builder = Response.unauthorized();
         }
         builder.type("application/json");
         builder.entity(errorJson.toString());
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      if ( ! processHeaders("prcinsertarcalificacionsd",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.prcinsertarcalificacionsd worker = new com.mujermorena.prcinsertarcalificacionsd(remoteHandle, context);
         worker.execute(AV9Calificacion,AV10Comentario );
         com.mujermorena.prcinsertarcalificacionsd_RESTInterfaceOUT data = new com.mujermorena.prcinsertarcalificacionsd_RESTInterfaceOUT();
         data.setCalificacion(AV9Calificacion[0]);
         data.setComentario(AV10Comentario[0]);
         builder = Response.okWrapped(data);
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

}

