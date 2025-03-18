package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.personaww", "/com.mujermorena.personaww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class personaww extends GXWebObjectStub
{
   public personaww( )
   {
   }

   public personaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( personaww.class ));
   }

   public personaww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new personaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new personaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Persona";
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
      return "personaww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

