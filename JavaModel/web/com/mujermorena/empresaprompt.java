package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.empresaprompt", "/com.mujermorena.empresaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class empresaprompt extends GXWebObjectStub
{
   public empresaprompt( )
   {
   }

   public empresaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresaprompt.class ));
   }

   public empresaprompt( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresaprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Empresa";
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
      return "empresaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

