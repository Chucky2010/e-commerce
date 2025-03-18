package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.comprasview", "/com.mujermorena.comprasview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class comprasview extends GXWebObjectStub
{
   public comprasview( )
   {
   }

   public comprasview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( comprasview.class ));
   }

   public comprasview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new comprasview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new comprasview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Compras View";
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
      return "comprasview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

