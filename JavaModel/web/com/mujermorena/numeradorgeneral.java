package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.numeradorgeneral", "/com.mujermorena.numeradorgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class numeradorgeneral extends GXWebObjectStub
{
   public numeradorgeneral( )
   {
   }

   public numeradorgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( numeradorgeneral.class ));
   }

   public numeradorgeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new numeradorgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new numeradorgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Numerador General";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

