package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajeroprompt", "/com.mujermorena.cajeroprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajeroprompt extends GXWebObjectStub
{
   public cajeroprompt( )
   {
   }

   public cajeroprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajeroprompt.class ));
   }

   public cajeroprompt( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajeroprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajeroprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Cajero";
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
      return "cajeroprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

