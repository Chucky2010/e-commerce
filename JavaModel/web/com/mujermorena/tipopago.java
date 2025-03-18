package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopago", "/com.mujermorena.tipopago"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopago extends GXWebObjectStub
{
   public tipopago( )
   {
   }

   public tipopago( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopago.class ));
   }

   public tipopago( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopago_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopago_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Pago";
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
      return "tipopago_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

