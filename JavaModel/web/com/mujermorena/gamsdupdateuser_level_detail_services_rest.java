package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/GAMSDUpdateUser_Level_Detail")
public final  class gamsdupdateuser_level_detail_services_rest extends GxRestService
{
   @jakarta.ws.rs.GET
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( @jakarta.ws.rs.QueryParam("gxid") @jakarta.ws.rs.DefaultValue("") String sAV16gxid ) throws Exception
   {
      super.init( "GET" );
      if ( ! processHeaders("gamsdupdateuser_level_detail",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      int AV16gxid;
      AV16gxid = (int)(GXutil.lval( sAV16gxid)) ;
      com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt data;
      try
      {
         com.mujermorena.gamsdupdateuser_level_detail worker = new com.mujermorena.gamsdupdateuser_level_detail(remoteHandle, context);
         data = worker.executeUdp(AV16gxid );
         builder = Response.okWrapped(new com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt_RESTInterface(data));
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
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

}

