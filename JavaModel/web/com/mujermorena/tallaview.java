package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tallaview", "/com.mujermorena.tallaview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tallaview extends GXWebObjectStub
{
   public tallaview( )
   {
   }

   public tallaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tallaview.class ));
   }

   public tallaview( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tallaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tallaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Talla View";
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
      return "tallaview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

