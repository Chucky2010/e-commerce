package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipofactura", "/com.mujermorena.tipofactura"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipofactura extends GXWebObjectStub
{
   public tipofactura( )
   {
   }

   public tipofactura( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipofactura.class ));
   }

   public tipofactura( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipofactura_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipofactura_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Factura";
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
      return "tipofactura_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

