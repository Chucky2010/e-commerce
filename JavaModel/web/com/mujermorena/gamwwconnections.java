package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwconnections", "/com.mujermorena.gamwwconnections"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwconnections extends GXWebObjectStub
{
   public gamwwconnections( )
   {
   }

   public gamwwconnections( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwconnections.class ));
   }

   public gamwwconnections( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwconnections_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwconnections_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_Connections";
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
      return "gamwwconnections_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

