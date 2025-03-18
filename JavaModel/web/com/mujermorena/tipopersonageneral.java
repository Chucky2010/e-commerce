package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopersonageneral", "/com.mujermorena.tipopersonageneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopersonageneral extends GXWebObjectStub
{
   public tipopersonageneral( )
   {
   }

   public tipopersonageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopersonageneral.class ));
   }

   public tipopersonageneral( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopersonageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopersonageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Persona General";
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

