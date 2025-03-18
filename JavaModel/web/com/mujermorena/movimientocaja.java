package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.movimientocaja", "/com.mujermorena.movimientocaja"})
@jakarta.servlet.annotation.MultipartConfig
public final  class movimientocaja extends GXWebObjectStub
{
   public movimientocaja( )
   {
   }

   public movimientocaja( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( movimientocaja.class ));
   }

   public movimientocaja( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new movimientocaja_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new movimientocaja_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Movimiento Caja";
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
      return "movimientocaja_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

