package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ventasdetalleprompt", "/com.mujermorena.ventasdetalleprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ventasdetalleprompt extends GXWebObjectStub
{
   public ventasdetalleprompt( )
   {
   }

   public ventasdetalleprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ventasdetalleprompt.class ));
   }

   public ventasdetalleprompt( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ventasdetalleprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ventasdetalleprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Detalle";
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
      return "ventasdetalleprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

