package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.personaview", "/com.mujermorena.personaview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class personaview extends GXWebObjectStub
{
   public personaview( )
   {
   }

   public personaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( personaview.class ));
   }

   public personaview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new personaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new personaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Persona View";
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
      return "personaview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

