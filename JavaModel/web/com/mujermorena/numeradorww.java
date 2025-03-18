package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.numeradorww", "/com.mujermorena.numeradorww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class numeradorww extends GXWebObjectStub
{
   public numeradorww( )
   {
   }

   public numeradorww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( numeradorww.class ));
   }

   public numeradorww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new numeradorww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new numeradorww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Numerador";
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
      return "numeradorww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

