package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ciudadww", "/com.mujermorena.ciudadww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ciudadww extends GXWebObjectStub
{
   public ciudadww( )
   {
   }

   public ciudadww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ciudadww.class ));
   }

   public ciudadww( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ciudadww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ciudadww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Ciudad";
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
      return "ciudadww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

