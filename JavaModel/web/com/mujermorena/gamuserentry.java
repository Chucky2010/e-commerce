package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamuserentry", "/com.mujermorena.gamuserentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamuserentry extends GXWebObjectStub
{
   public gamuserentry( )
   {
   }

   public gamuserentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamuserentry.class ));
   }

   public gamuserentry( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamuserentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamuserentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "User ";
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
      return "gamuserentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

