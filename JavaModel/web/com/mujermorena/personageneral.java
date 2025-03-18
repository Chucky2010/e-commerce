package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.personageneral", "/com.mujermorena.personageneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class personageneral extends GXWebObjectStub
{
   public personageneral( )
   {
   }

   public personageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( personageneral.class ));
   }

   public personageneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new personageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new personageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Persona General";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

