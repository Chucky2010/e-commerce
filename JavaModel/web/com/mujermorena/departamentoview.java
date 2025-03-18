package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.departamentoview", "/com.mujermorena.departamentoview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class departamentoview extends GXWebObjectStub
{
   public departamentoview( )
   {
   }

   public departamentoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( departamentoview.class ));
   }

   public departamentoview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new departamentoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new departamentoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Departamento View";
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
      return "departamentoview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

