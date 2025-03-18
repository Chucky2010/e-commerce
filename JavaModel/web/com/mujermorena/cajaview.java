package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajaview", "/com.mujermorena.cajaview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajaview extends GXWebObjectStub
{
   public cajaview( )
   {
   }

   public cajaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajaview.class ));
   }

   public cajaview( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Caja View";
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
      return "cajaview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

