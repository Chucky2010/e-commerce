package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.paisview", "/com.mujermorena.paisview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class paisview extends GXWebObjectStub
{
   public paisview( )
   {
   }

   public paisview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisview.class ));
   }

   public paisview( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais View";
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
      return "paisview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

