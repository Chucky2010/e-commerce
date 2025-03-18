package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devolucionesprompt", "/com.mujermorena.devolucionesprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devolucionesprompt extends GXWebObjectStub
{
   public devolucionesprompt( )
   {
   }

   public devolucionesprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devolucionesprompt.class ));
   }

   public devolucionesprompt( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devolucionesprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devolucionesprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Devoluciones";
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
      return "devolucionesprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

