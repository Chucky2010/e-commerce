package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ciudadprompt", "/com.mujermorena.ciudadprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ciudadprompt extends GXWebObjectStub
{
   public ciudadprompt( )
   {
   }

   public ciudadprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ciudadprompt.class ));
   }

   public ciudadprompt( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ciudadprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ciudadprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Ciudad";
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
      return "ciudadprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

