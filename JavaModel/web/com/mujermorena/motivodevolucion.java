package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.motivodevolucion", "/com.mujermorena.motivodevolucion"})
@jakarta.servlet.annotation.MultipartConfig
public final  class motivodevolucion extends GXWebObjectStub
{
   public motivodevolucion( )
   {
   }

   public motivodevolucion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivodevolucion.class ));
   }

   public motivodevolucion( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivodevolucion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivodevolucion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Devolucion";
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
      return "motivodevolucion_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

