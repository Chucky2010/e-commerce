package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stockview", "/com.mujermorena.stockview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stockview extends GXWebObjectStub
{
   public stockview( )
   {
   }

   public stockview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stockview.class ));
   }

   public stockview( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stockview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stockview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Stock View";
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
      return "stockview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

