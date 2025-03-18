package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwappmenuoptions", "/com.mujermorena.gamwwappmenuoptions"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwappmenuoptions extends GXWebObjectStub
{
   public gamwwappmenuoptions( )
   {
   }

   public gamwwappmenuoptions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwappmenuoptions.class ));
   }

   public gamwwappmenuoptions( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwappmenuoptions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwappmenuoptions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_MenuOptionsApplication";
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
      return "gamwwappmenuoptions_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

