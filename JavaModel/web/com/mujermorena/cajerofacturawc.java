package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajerofacturawc", "/com.mujermorena.cajerofacturawc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajerofacturawc extends GXWebObjectStub
{
   public cajerofacturawc( )
   {
   }

   public cajerofacturawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajerofacturawc.class ));
   }

   public cajerofacturawc( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajerofacturawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajerofacturawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cajero Factura WC";
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

