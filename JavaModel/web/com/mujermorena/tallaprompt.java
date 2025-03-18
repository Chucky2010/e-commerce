package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tallaprompt", "/com.mujermorena.tallaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tallaprompt extends GXWebObjectStub
{
   public tallaprompt( )
   {
   }

   public tallaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tallaprompt.class ));
   }

   public tallaprompt( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tallaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tallaprompt_impl(context).cleanup();
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
      return "tallaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

