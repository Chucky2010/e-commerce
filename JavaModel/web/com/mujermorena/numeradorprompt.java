package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.numeradorprompt", "/com.mujermorena.numeradorprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class numeradorprompt extends GXWebObjectStub
{
   public numeradorprompt( )
   {
   }

   public numeradorprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( numeradorprompt.class ));
   }

   public numeradorprompt( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new numeradorprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new numeradorprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Numerador";
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
      return "numeradorprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

