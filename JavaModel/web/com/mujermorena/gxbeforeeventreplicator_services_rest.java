package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/GxBeforeEventReplicator")
public final  class gxbeforeeventreplicator_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.gxbeforeeventreplicator_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem> [] GxPendingEvents = new GXBaseCollection[] { new GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem>() };
      GxPendingEvents[0]= SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterfacetoGXObjectCollection(entity.getGxPendingEvents());
      com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo GxSyncroInfo ;
      GxSyncroInfo= (com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo)entity.getGxSyncroInfo().getSdt();
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> [] AV8EventResults = new GXBaseCollection[] { new GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem>() };
      AV8EventResults[0]= SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterfacetoGXObjectCollection(entity.getEventResults());
      permissionPrefix = "gxbeforeeventreplicator_Services_Execute";
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
      if ( ! processHeaders("gxbeforeeventreplicator",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.gxbeforeeventreplicator worker = new com.mujermorena.gxbeforeeventreplicator(remoteHandle, context);
         worker.execute(GxPendingEvents,GxSyncroInfo,AV8EventResults );
         com.mujermorena.gxbeforeeventreplicator_RESTInterfaceOUT data = new com.mujermorena.gxbeforeeventreplicator_RESTInterfaceOUT();
         data.setGxPendingEvents(SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterfacefromGXObjectCollection(GxPendingEvents[0]));
         data.setEventResults(SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterfacefromGXObjectCollection(AV8EventResults[0]));
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

   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem> SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterfacetoGXObjectCollection( Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface> collection )
   {
      GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem> result = new GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem>(com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem.class, "SynchronizationEventList.SynchronizationEventListItem", "GeneXus.SynchronizationEventList", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem)collection.elementAt(i).getSdt());
      }
      return result ;
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

   private Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface> SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem> collection )
   {
      Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface> result = new Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface((com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem)collection.elementAt(i)));
      }
      return result ;
   }

   private Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface> SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> collection )
   {
      Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface> result = new Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface((com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem)collection.elementAt(i)));
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

