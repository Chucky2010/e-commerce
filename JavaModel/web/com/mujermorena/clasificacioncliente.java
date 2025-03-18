package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clasificacioncliente", "/com.mujermorena.clasificacioncliente"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clasificacioncliente extends GXWebObjectStub
{
   public clasificacioncliente( )
   {
   }

   public clasificacioncliente( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clasificacioncliente.class ));
   }

   public clasificacioncliente( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clasificacioncliente_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clasificacioncliente_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Clasificacion Cliente";
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
      return "clasificacioncliente_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

