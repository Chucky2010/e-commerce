package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/GxAfterEventReplicator")
public final  class gxaftereventreplicator_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.gxaftereventreplicator_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> AV8EventResults ;
      AV8EventResults= SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterfacetoGXObjectCollection(entity.getEventResults());
      com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo GxSynchroInfo ;
      GxSynchroInfo= (com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo)entity.getGxSynchroInfo().getSdt();
      permissionPrefix = "gxaftereventreplicator_Services_Execute";
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
      if ( ! processHeaders("gxaftereventreplicator",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.gxaftereventreplicator worker = new com.mujermorena.gxaftereventreplicator(remoteHandle, context);
         worker.execute(AV8EventResults,GxSynchroInfo );
         builder = Response.okWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterfacetoGXObjectCollection( Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface> collection )
   {
      GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> result = new GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem>(com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem.class, "SynchronizationEventResultList.SynchronizationEventResultListItem", "GeneXus.SynchronizationEventResultList", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem)collection.elementAt(i).getSdt());
      }
      return result ;
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

