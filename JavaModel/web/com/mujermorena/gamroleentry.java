package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamroleentry", "/com.mujermorena.gamroleentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamroleentry extends GXWebObjectStub
{
   public gamroleentry( )
   {
   }

   public gamroleentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamroleentry.class ));
   }

   public gamroleentry( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamroleentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamroleentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_Role";
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
      return "gamroleentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

