package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamapppermissionchildren", "/com.mujermorena.gamapppermissionchildren"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamapppermissionchildren extends GXWebObjectStub
{
   public gamapppermissionchildren( )
   {
   }

   public gamapppermissionchildren( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamapppermissionchildren.class ));
   }

   public gamapppermissionchildren( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamapppermissionchildren_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamapppermissionchildren_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_PermissionApplicationChildren";
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
      return "gamapppermissionchildren_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

