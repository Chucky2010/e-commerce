package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.paisprompt", "/com.mujermorena.paisprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class paisprompt extends GXWebObjectStub
{
   public paisprompt( )
   {
   }

   public paisprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisprompt.class ));
   }

   public paisprompt( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Pais";
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
      return "paisprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

