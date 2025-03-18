package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajeroww", "/com.mujermorena.cajeroww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajeroww extends GXWebObjectStub
{
   public cajeroww( )
   {
   }

   public cajeroww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajeroww.class ));
   }

   public cajeroww( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajeroww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajeroww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Cajero";
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
      return "cajeroww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

