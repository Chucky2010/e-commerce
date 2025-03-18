package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamchangerepository", "/com.mujermorena.gamchangerepository"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamchangerepository extends GXWebObjectStub
{
   public gamchangerepository( )
   {
   }

   public gamchangerepository( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamchangerepository.class ));
   }

   public gamchangerepository( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamchangerepository_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamchangerepository_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_ChangeRepository";
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
      return "gamchangerepository_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

