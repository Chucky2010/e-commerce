package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.pais", "/com.mujermorena.pais"})
@jakarta.servlet.annotation.MultipartConfig
public final  class pais extends GXWebObjectStub
{
   public pais( )
   {
   }

   public pais( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( pais.class ));
   }

   public pais( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pais_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pais_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais";
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
      return "pais_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

