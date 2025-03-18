package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devolucionesww", "/com.mujermorena.devolucionesww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devolucionesww extends GXWebObjectStub
{
   public devolucionesww( )
   {
   }

   public devolucionesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devolucionesww.class ));
   }

   public devolucionesww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devolucionesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devolucionesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Devoluciones";
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
      return "devolucionesww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

