package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.motivodevolucionww", "/com.mujermorena.motivodevolucionww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class motivodevolucionww extends GXWebObjectStub
{
   public motivodevolucionww( )
   {
   }

   public motivodevolucionww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivodevolucionww.class ));
   }

   public motivodevolucionww( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivodevolucionww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivodevolucionww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Motivo Devolucion";
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
      return "motivodevolucionww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

