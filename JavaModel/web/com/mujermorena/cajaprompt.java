package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajaprompt", "/com.mujermorena.cajaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajaprompt extends GXWebObjectStub
{
   public cajaprompt( )
   {
   }

   public cajaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajaprompt.class ));
   }

   public cajaprompt( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajaprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Caja";
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
      return "cajaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

