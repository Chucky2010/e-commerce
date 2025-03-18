package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.calificaciongeneral", "/com.mujermorena.calificaciongeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class calificaciongeneral extends GXWebObjectStub
{
   public calificaciongeneral( )
   {
   }

   public calificaciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calificaciongeneral.class ));
   }

   public calificaciongeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calificaciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calificaciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calificacion General";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

