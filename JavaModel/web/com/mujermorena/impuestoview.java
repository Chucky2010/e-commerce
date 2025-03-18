package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuestoview", "/com.mujermorena.impuestoview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuestoview extends GXWebObjectStub
{
   public impuestoview( )
   {
   }

   public impuestoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuestoview.class ));
   }

   public impuestoview( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuestoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuestoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Impuesto View";
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
      return "impuestoview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

