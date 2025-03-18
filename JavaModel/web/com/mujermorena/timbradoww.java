package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.timbradoww", "/com.mujermorena.timbradoww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class timbradoww extends GXWebObjectStub
{
   public timbradoww( )
   {
   }

   public timbradoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( timbradoww.class ));
   }

   public timbradoww( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new timbradoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new timbradoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Timbrado";
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
      return "timbradoww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

