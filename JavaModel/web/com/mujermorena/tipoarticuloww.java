package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipoarticuloww", "/com.mujermorena.tipoarticuloww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipoarticuloww extends GXWebObjectStub
{
   public tipoarticuloww( )
   {
   }

   public tipoarticuloww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoarticuloww.class ));
   }

   public tipoarticuloww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoarticuloww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoarticuloww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Tipo Articulo";
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
      return "tipoarticuloww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

