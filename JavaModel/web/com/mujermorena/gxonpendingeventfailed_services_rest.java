package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/GxOnPendingEventFailed")
public final  class gxonpendingeventfailed_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.gxonpendingeventfailed_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem AV8PendingEvent ;
      AV8PendingEvent= (com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem)entity.getPendingEvent().getSdt();
      String AV9BCName;
      AV9BCName = entity.getBCName() ;
      String AV10BCJson;
      AV10BCJson = entity.getBCJson() ;
      com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem AV12EventResult ;
      AV12EventResult= (com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem)entity.getEventResult().getSdt();
      com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo GxSyncroInfo ;
      GxSyncroInfo= (com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo)entity.getGxSyncroInfo().getSdt();
      boolean [] AV11Continue = new boolean[] { false };
      permissionPrefix = "gxonpendingeventfailed_Services_Execute";
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
      if ( ! processHeaders("gxonpendingeventfailed",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.gxonpendingeventfailed worker = new com.mujermorena.gxonpendingeventfailed(remoteHandle, context);
         worker.execute(AV8PendingEvent,AV9BCName,AV10BCJson,AV12EventResult,GxSyncroInfo,AV11Continue );
         com.mujermorena.gxonpendingeventfailed_RESTInterfaceOUT data = new com.mujermorena.gxonpendingeventfailed_RESTInterfaceOUT();
         data.setContinue(AV11Continue[0]);
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

