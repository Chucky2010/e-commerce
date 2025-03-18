package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.calificacionww", "/com.mujermorena.calificacionww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class calificacionww extends GXWebObjectStub
{
   public calificacionww( )
   {
   }

   public calificacionww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calificacionww.class ));
   }

   public calificacionww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calificacionww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calificacionww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Calificacion";
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
      return "calificacionww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

