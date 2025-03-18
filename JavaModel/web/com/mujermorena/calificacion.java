package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.calificacion", "/com.mujermorena.calificacion"})
@jakarta.servlet.annotation.MultipartConfig
public final  class calificacion extends GXWebObjectStub
{
   public calificacion( )
   {
   }

   public calificacion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calificacion.class ));
   }

   public calificacion( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calificacion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calificacion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calificacion";
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
      return "calificacion_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

