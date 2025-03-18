package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamhome", "/com.mujermorena.gamhome"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamhome extends GXWebObjectStub
{
   public gamhome( )
   {
   }

   public gamhome( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamhome.class ));
   }

   public gamhome( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamhome_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamhome_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "GAM Home";
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
      return "gamhome_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

