package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajeromovimientocajawc", "/com.mujermorena.cajeromovimientocajawc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajeromovimientocajawc extends GXWebObjectStub
{
   public cajeromovimientocajawc( )
   {
   }

   public cajeromovimientocajawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajeromovimientocajawc.class ));
   }

   public cajeromovimientocajawc( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajeromovimientocajawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajeromovimientocajawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cajero Movimiento Caja WC";
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

