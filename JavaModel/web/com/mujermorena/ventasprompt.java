package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ventasprompt", "/com.mujermorena.ventasprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ventasprompt extends GXWebObjectStub
{
   public ventasprompt( )
   {
   }

   public ventasprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ventasprompt.class ));
   }

   public ventasprompt( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ventasprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ventasprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Ventas";
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
      return "ventasprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

