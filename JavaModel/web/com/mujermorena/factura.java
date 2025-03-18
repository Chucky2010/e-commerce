package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.factura", "/com.mujermorena.factura"})
@jakarta.servlet.annotation.MultipartConfig
public final  class factura extends GXWebObjectStub
{
   public factura( )
   {
   }

   public factura( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( factura.class ));
   }

   public factura( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new factura_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new factura_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Factura";
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
      return "factura_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

