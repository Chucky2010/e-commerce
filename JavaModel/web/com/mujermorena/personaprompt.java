package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.personaprompt", "/com.mujermorena.personaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class personaprompt extends GXWebObjectStub
{
   public personaprompt( )
   {
   }

   public personaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( personaprompt.class ));
   }

   public personaprompt( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new personaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new personaprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Persona";
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
      return "personaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

