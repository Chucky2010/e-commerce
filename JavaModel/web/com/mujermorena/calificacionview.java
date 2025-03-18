package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.calificacionview", "/com.mujermorena.calificacionview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class calificacionview extends GXWebObjectStub
{
   public calificacionview( )
   {
   }

   public calificacionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calificacionview.class ));
   }

   public calificacionview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calificacionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calificacionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calificacion View";
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
      return "calificacionview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

