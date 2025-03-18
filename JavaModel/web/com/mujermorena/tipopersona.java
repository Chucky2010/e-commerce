package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopersona", "/com.mujermorena.tipopersona"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopersona extends GXWebObjectStub
{
   public tipopersona( )
   {
   }

   public tipopersona( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopersona.class ));
   }

   public tipopersona( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopersona_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopersona_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Persona";
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
      return "tipopersona_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

