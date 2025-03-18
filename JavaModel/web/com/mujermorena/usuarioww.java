package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.usuarioww", "/com.mujermorena.usuarioww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usuarioww extends GXWebObjectStub
{
   public usuarioww( )
   {
   }

   public usuarioww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usuarioww.class ));
   }

   public usuarioww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usuarioww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usuarioww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Usuario";
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
      return "usuarioww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

