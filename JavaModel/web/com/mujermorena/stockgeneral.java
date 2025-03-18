package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stockgeneral", "/com.mujermorena.stockgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stockgeneral extends GXWebObjectStub
{
   public stockgeneral( )
   {
   }

   public stockgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stockgeneral.class ));
   }

   public stockgeneral( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stockgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stockgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Stock General";
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

