package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopagogeneral", "/com.mujermorena.tipopagogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopagogeneral extends GXWebObjectStub
{
   public tipopagogeneral( )
   {
   }

   public tipopagogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopagogeneral.class ));
   }

   public tipopagogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopagogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopagogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Pago General";
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

