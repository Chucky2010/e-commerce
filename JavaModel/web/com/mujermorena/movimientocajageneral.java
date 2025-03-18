package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.movimientocajageneral", "/com.mujermorena.movimientocajageneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class movimientocajageneral extends GXWebObjectStub
{
   public movimientocajageneral( )
   {
   }

   public movimientocajageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( movimientocajageneral.class ));
   }

   public movimientocajageneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new movimientocajageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new movimientocajageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Movimiento Caja General";
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

