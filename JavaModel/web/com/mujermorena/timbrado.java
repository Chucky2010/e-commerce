package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.timbrado", "/com.mujermorena.timbrado"})
@jakarta.servlet.annotation.MultipartConfig
public final  class timbrado extends GXWebObjectStub
{
   public timbrado( )
   {
   }

   public timbrado( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( timbrado.class ));
   }

   public timbrado( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new timbrado_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new timbrado_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Timbrado";
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
      return "timbrado_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

