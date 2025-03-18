package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventariodetalleprompt", "/com.mujermorena.inventariodetalleprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventariodetalleprompt extends GXWebObjectStub
{
   public inventariodetalleprompt( )
   {
   }

   public inventariodetalleprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventariodetalleprompt.class ));
   }

   public inventariodetalleprompt( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventariodetalleprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventariodetalleprompt_impl(context).cleanup();
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
      return "inventariodetalleprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

