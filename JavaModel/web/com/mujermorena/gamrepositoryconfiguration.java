package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamrepositoryconfiguration", "/com.mujermorena.gamrepositoryconfiguration"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamrepositoryconfiguration extends GXWebObjectStub
{
   public gamrepositoryconfiguration( )
   {
   }

   public gamrepositoryconfiguration( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamrepositoryconfiguration.class ));
   }

   public gamrepositoryconfiguration( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamrepositoryconfiguration_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamrepositoryconfiguration_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Repository configuration ";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "gamrepositoryconfiguration_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

