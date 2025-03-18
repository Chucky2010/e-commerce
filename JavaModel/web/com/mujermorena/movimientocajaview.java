package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.movimientocajaview", "/com.mujermorena.movimientocajaview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class movimientocajaview extends GXWebObjectStub
{
   public movimientocajaview( )
   {
   }

   public movimientocajaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( movimientocajaview.class ));
   }

   public movimientocajaview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new movimientocajaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new movimientocajaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Movimiento Caja View";
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
      return "movimientocajaview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

