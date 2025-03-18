package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devolucionesview", "/com.mujermorena.devolucionesview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devolucionesview extends GXWebObjectStub
{
   public devolucionesview( )
   {
   }

   public devolucionesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devolucionesview.class ));
   }

   public devolucionesview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devolucionesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devolucionesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devoluciones View";
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
      return "devolucionesview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

