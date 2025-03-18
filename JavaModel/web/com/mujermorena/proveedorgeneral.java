package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.proveedorgeneral", "/com.mujermorena.proveedorgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class proveedorgeneral extends GXWebObjectStub
{
   public proveedorgeneral( )
   {
   }

   public proveedorgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( proveedorgeneral.class ));
   }

   public proveedorgeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new proveedorgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new proveedorgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Proveedor General";
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

