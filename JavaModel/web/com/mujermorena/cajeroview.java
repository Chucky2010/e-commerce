package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajeroview", "/com.mujermorena.cajeroview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajeroview extends GXWebObjectStub
{
   public cajeroview( )
   {
   }

   public cajeroview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajeroview.class ));
   }

   public cajeroview( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajeroview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajeroview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cajero View";
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
      return "cajeroview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

