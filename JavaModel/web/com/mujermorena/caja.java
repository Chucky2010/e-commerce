package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.caja", "/com.mujermorena.caja"})
@jakarta.servlet.annotation.MultipartConfig
public final  class caja extends GXWebObjectStub
{
   public caja( )
   {
   }

   public caja( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( caja.class ));
   }

   public caja( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new caja_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new caja_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Caja";
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
      return "caja_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

