package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamauthenticationtypeentry", "/com.mujermorena.gamauthenticationtypeentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamauthenticationtypeentry extends GXWebObjectStub
{
   public gamauthenticationtypeentry( )
   {
   }

   public gamauthenticationtypeentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamauthenticationtypeentry.class ));
   }

   public gamauthenticationtypeentry( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamauthenticationtypeentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamauthenticationtypeentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_AuthenticationType";
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
      return "gamauthenticationtypeentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

