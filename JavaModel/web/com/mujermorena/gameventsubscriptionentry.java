package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gameventsubscriptionentry", "/com.mujermorena.gameventsubscriptionentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gameventsubscriptionentry extends GXWebObjectStub
{
   public gameventsubscriptionentry( )
   {
   }

   public gameventsubscriptionentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gameventsubscriptionentry.class ));
   }

   public gameventsubscriptionentry( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gameventsubscriptionentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gameventsubscriptionentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_EventSubscription";
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
      return "gameventsubscriptionentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

