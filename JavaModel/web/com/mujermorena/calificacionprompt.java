package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.calificacionprompt", "/com.mujermorena.calificacionprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class calificacionprompt extends GXWebObjectStub
{
   public calificacionprompt( )
   {
   }

   public calificacionprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calificacionprompt.class ));
   }

   public calificacionprompt( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calificacionprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calificacionprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Calificacion";
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
      return "calificacionprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

