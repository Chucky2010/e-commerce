package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.movimientocajaprompt", "/com.mujermorena.movimientocajaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class movimientocajaprompt extends GXWebObjectStub
{
   public movimientocajaprompt( )
   {
   }

   public movimientocajaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( movimientocajaprompt.class ));
   }

   public movimientocajaprompt( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new movimientocajaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new movimientocajaprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Movimiento Caja";
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
      return "movimientocajaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

