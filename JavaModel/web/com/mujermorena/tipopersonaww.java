package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopersonaww", "/com.mujermorena.tipopersonaww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopersonaww extends GXWebObjectStub
{
   public tipopersonaww( )
   {
   }

   public tipopersonaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopersonaww.class ));
   }

   public tipopersonaww( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopersonaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopersonaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Tipo Persona";
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
      return "tipopersonaww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

