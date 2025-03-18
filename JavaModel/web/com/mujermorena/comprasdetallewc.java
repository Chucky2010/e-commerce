package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.comprasdetallewc", "/com.mujermorena.comprasdetallewc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class comprasdetallewc extends GXWebObjectStub
{
   public comprasdetallewc( )
   {
   }

   public comprasdetallewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( comprasdetallewc.class ));
   }

   public comprasdetallewc( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new comprasdetallewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new comprasdetallewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Compras Detalle WC";
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

