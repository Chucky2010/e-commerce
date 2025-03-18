package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPDynamicFieldsRequiredCheck")
public final  class wwpdynamicfieldsrequiredcheck_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> AV9DynamicFormFields ;
      AV9DynamicFormFields= SdtDynamicField_RESTInterfacetoGXObjectCollection(entity.getDynamicFormFields());
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexus.SdtMessages_Message> [] AV12Messages = new GXBaseCollection[] { new GXBaseCollection<com.genexus.SdtMessages_Message>() };
      permissionPrefix = "wwpdynamicfieldsrequiredcheck_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck_impl(remoteHandle, context);
         worker.execute_int(AV9DynamicFormFields,AV12Messages );
         com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck_RESTInterfaceOUT();
         data.setMessages(SdtMessages_Message_RESTInterfacefromGXObjectCollection(AV12Messages[0]));
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

   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> SdtDynamicField_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> result = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>(com.mujermorena.workwithplus.nativemobile.SdtDynamicField.class, "DynamicField", "Mujer_Morena", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.genexus.SdtMessages_Message_RESTInterface> SdtMessages_Message_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.genexus.SdtMessages_Message> collection )
   {
      Vector<com.genexus.SdtMessages_Message_RESTInterface> result = new Vector<com.genexus.SdtMessages_Message_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.genexus.SdtMessages_Message_RESTInterface((com.genexus.SdtMessages_Message)collection.elementAt(i)));
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

