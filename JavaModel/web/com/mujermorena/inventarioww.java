package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventarioww", "/com.mujermorena.inventarioww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventarioww extends GXWebObjectStub
{
   public inventarioww( )
   {
   }

   public inventarioww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventarioww.class ));
   }

   public inventarioww( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventarioww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventarioww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Inventario";
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
      return "inventarioww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

