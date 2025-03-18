package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist", "/com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpcreatelocationslist extends GXWebObjectStub
{
   public wwpcreatelocationslist( )
   {
   }

   public wwpcreatelocationslist( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpcreatelocationslist.class ));
   }

   public wwpcreatelocationslist( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpcreatelocationslist_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpcreatelocationslist_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo>[] aP2 )
   {
      new wwpcreatelocationslist_impl(remoteHandle, context).execute_int(aP0, aP1, aP2);
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo> executeUdp( String aP0 ,
                                                                                          String aP1 )
   {
      GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo>[] aP2 = new GXBaseCollection[] {new GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo>()};
      execute(aP0, aP1, aP2);
      return aP2[0];
   }

   public String getServletInfo( )
   {
      return "Create Locations List";
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
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

