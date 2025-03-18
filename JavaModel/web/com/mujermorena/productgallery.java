package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.productgallery", "/com.mujermorena.productgallery"})
@jakarta.servlet.annotation.MultipartConfig
public final  class productgallery extends GXWebObjectStub
{
   public productgallery( )
   {
   }

   public productgallery( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( productgallery.class ));
   }

   public productgallery( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new productgallery_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new productgallery_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Product Gallery";
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
      return "productgallery_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

