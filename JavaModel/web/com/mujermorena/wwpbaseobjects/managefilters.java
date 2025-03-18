package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.managefilters", "/com.mujermorena.wwpbaseobjects.managefilters"})
@jakarta.servlet.annotation.MultipartConfig
public final  class managefilters extends GXWebObjectStub
{
   public managefilters( )
   {
   }

   public managefilters( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( managefilters.class ));
   }

   public managefilters( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new managefilters_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new managefilters_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_ManageFiltersDescription";
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
      return "managefilters_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

