package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/ExampleMenuOption_Level_Detail")
public final  class examplemenuoption_level_detail_services_rest extends GxRestService
{
   @jakarta.ws.rs.GET
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( @jakarta.ws.rs.QueryParam("Optionnumber") @jakarta.ws.rs.DefaultValue("") String sAV5OptionNumber ,
                                               @jakarta.ws.rs.QueryParam("gxid") @jakarta.ws.rs.DefaultValue("") String sAV6gxid ) throws Exception
   {
      super.init( "GET" );
      permissionPrefix = "examplemenuoption_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.examplemenuoption_level_detail",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      short AV5OptionNumber;
      AV5OptionNumber = (short)(GXutil.lval( sAV5OptionNumber)) ;
      int AV6gxid;
      AV6gxid = (int)(GXutil.lval( sAV6gxid)) ;
      com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt data;
      try
      {
         com.mujermorena.workwithplus.nativemobile.examplemenuoption_level_detail worker = new com.mujermorena.workwithplus.nativemobile.examplemenuoption_level_detail(remoteHandle, context);
         data = worker.executeUdp(AV5OptionNumber,AV6gxid );
         builder = Response.okWrapped(new com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt_RESTInterface(data));
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

