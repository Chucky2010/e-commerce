package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPDynamicFieldsToJSON")
public final  class wwpdynamicfieldstojson_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> AV9DynamicFormFields ;
      AV9DynamicFormFields= SdtDynamicField_RESTInterfacetoGXObjectCollection(entity.getDynamicFormFields());
      String [] AV10FormFieldsJson = new String[] { "" };
      permissionPrefix = "wwpdynamicfieldstojson_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpdynamicfieldstojson",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson_impl(remoteHandle, context);
         worker.execute_int(AV9DynamicFormFields,AV10FormFieldsJson );
         com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson_RESTInterfaceOUT();
         data.setFormFieldsJson(AV10FormFieldsJson[0]);
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

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

}

