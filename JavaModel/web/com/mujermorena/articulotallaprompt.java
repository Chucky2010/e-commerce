package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulotallaprompt", "/com.mujermorena.articulotallaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulotallaprompt extends GXWebObjectStub
{
   public articulotallaprompt( )
   {
   }

   public articulotallaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulotallaprompt.class ));
   }

   public articulotallaprompt( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulotallaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulotallaprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Talla";
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
      return "articulotallaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

