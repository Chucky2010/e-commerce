package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.persona", "/com.mujermorena.persona"})
@jakarta.servlet.annotation.MultipartConfig
public final  class persona extends GXWebObjectStub
{
   public persona( )
   {
   }

   public persona( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( persona.class ));
   }

   public persona( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new persona_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new persona_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Persona";
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
      return "persona_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

