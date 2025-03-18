package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPDynamicFieldsFromJSON")
public final  class wwpdynamicfieldsfromjson_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV9FormFieldsJson;
      AV9FormFieldsJson = entity.getFormFieldsJson() ;
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> [] AV8DynamicFormFields = new GXBaseCollection[] { new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>() };
      permissionPrefix = "wwpdynamicfieldsfromjson_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpdynamicfieldsfromjson",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson_impl(remoteHandle, context);
         worker.execute_int(AV9FormFieldsJson,AV8DynamicFormFields );
         com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson_RESTInterfaceOUT();
         data.setDynamicFormFields(SdtDynamicField_RESTInterfacefromGXObjectCollection(AV8DynamicFormFields[0]));
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

   private Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface> SdtDynamicField_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> collection )
   {
      Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface> result = new Vector<com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.workwithplus.nativemobile.SdtDynamicField_RESTInterface((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)collection.elementAt(i)));
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

