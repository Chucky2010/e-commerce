package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.departamentoprompt", "/com.mujermorena.departamentoprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class departamentoprompt extends GXWebObjectStub
{
   public departamentoprompt( )
   {
   }

   public departamentoprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( departamentoprompt.class ));
   }

   public departamentoprompt( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new departamentoprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new departamentoprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Departamento";
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
      return "departamentoprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

