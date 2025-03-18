package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stockww", "/com.mujermorena.stockww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stockww extends GXWebObjectStub
{
   public stockww( )
   {
   }

   public stockww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stockww.class ));
   }

   public stockww( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stockww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stockww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Stock";
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
      return "stockww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

