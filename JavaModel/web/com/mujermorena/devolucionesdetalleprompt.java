package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devolucionesdetalleprompt", "/com.mujermorena.devolucionesdetalleprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devolucionesdetalleprompt extends GXWebObjectStub
{
   public devolucionesdetalleprompt( )
   {
   }

   public devolucionesdetalleprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devolucionesdetalleprompt.class ));
   }

   public devolucionesdetalleprompt( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devolucionesdetalleprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devolucionesdetalleprompt_impl(context).cleanup();
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
      return "devolucionesdetalleprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

