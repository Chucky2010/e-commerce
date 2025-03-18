package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clienteprompt", "/com.mujermorena.clienteprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clienteprompt extends GXWebObjectStub
{
   public clienteprompt( )
   {
   }

   public clienteprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteprompt.class ));
   }

   public clienteprompt( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Cliente";
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
      return "clienteprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

