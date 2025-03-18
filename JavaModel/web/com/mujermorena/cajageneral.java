package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajageneral", "/com.mujermorena.cajageneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajageneral extends GXWebObjectStub
{
   public cajageneral( )
   {
   }

   public cajageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajageneral.class ));
   }

   public cajageneral( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Caja General";
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

