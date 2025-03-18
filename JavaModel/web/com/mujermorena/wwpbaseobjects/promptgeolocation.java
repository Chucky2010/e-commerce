package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.promptgeolocation", "/com.mujermorena.wwpbaseobjects.promptgeolocation"})
@jakarta.servlet.annotation.MultipartConfig
public final  class promptgeolocation extends GXWebObjectStub
{
   public promptgeolocation( )
   {
   }

   public promptgeolocation( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( promptgeolocation.class ));
   }

   public promptgeolocation( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new promptgeolocation_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new promptgeolocation_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_PromptGeolocationSelect";
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
      return "promptgeolocation_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

