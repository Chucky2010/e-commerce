package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamapppermissionselect", "/com.mujermorena.gamapppermissionselect"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamapppermissionselect extends GXWebObjectStub
{
   public gamapppermissionselect( )
   {
   }

   public gamapppermissionselect( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamapppermissionselect.class ));
   }

   public gamapppermissionselect( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamapppermissionselect_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamapppermissionselect_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SelectPermissionsApplication";
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
      return "gamapppermissionselect_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

