package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clientefacturawc", "/com.mujermorena.clientefacturawc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clientefacturawc extends GXWebObjectStub
{
   public clientefacturawc( )
   {
   }

   public clientefacturawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientefacturawc.class ));
   }

   public clientefacturawc( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientefacturawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientefacturawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Factura WC";
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

