package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuestoarticulowc", "/com.mujermorena.impuestoarticulowc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuestoarticulowc extends GXWebObjectStub
{
   public impuestoarticulowc( )
   {
   }

   public impuestoarticulowc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuestoarticulowc.class ));
   }

   public impuestoarticulowc( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuestoarticulowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuestoarticulowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Impuesto Articulo WC";
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

