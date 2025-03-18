package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.paisww", "/com.mujermorena.paisww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class paisww extends GXWebObjectStub
{
   public paisww( )
   {
   }

   public paisww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisww.class ));
   }

   public paisww( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Pais";
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
      return "paisww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

