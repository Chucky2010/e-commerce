package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipoarticulogeneral", "/com.mujermorena.tipoarticulogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipoarticulogeneral extends GXWebObjectStub
{
   public tipoarticulogeneral( )
   {
   }

   public tipoarticulogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoarticulogeneral.class ));
   }

   public tipoarticulogeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoarticulogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoarticulogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Articulo General";
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

