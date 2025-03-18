package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.exportoptions", "/com.mujermorena.wwpbaseobjects.exportoptions"})
@jakarta.servlet.annotation.MultipartConfig
public final  class exportoptions extends GXWebObjectStub
{
   public exportoptions( )
   {
   }

   public exportoptions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( exportoptions.class ));
   }

   public exportoptions( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new exportoptions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new exportoptions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_ExportOptionsDescription";
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
      return "exportoptions_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

