/*
               File: GAMIsAuthInOfflineCache
        Description: GAMIs Auth In Offline Cache
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:31.84
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import java.sql.*;
import com.artech.base.services.*;

public final  class gamisauthinofflinecache extends GXProcedure implements IGxProcedure
{
   public boolean execute( IPropertiesObject androidPropertiesObject )
   {

      String aP0 = "";
      boolean[] aP1 = new boolean[] {false};

      aP0 = (String) androidPropertiesObject.optStringProperty("FunctionalityKey");

      execute(aP0, aP1);

      androidPropertiesObject.setProperty("IsAuthorized", GXutil.trim( GXutil.booltostr( aP1[0])));


      return true ;
   }

   public gamisauthinofflinecache( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamisauthinofflinecache.class ), "" );
   }

   public gamisauthinofflinecache( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public boolean executeUdp( String aP0 )
   {
      gamisauthinofflinecache.this.AV9FunctionalityKey = aP0;
      gamisauthinofflinecache.this.aP1 = new boolean[] {false};
      initialize();
      privateExecute();
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      gamisauthinofflinecache.this.AV9FunctionalityKey = aP0;
      gamisauthinofflinecache.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV9FunctionalityKey, "<Check_Is_Authenticated>") == 0 )
      {
         AV10IsAuthorized = (boolean)(!new com.gampackager.genexussecurity.SdtGAMUser(remoteHandle, context).isanonymous()) ;
      }
      else
      {
         AV8CachePermissions = new com.genexuscore.genexus.client.SdtClientStorage(remoteHandle, context).get("wwp_menu_cache") ;
         AV10IsAuthorized = GXutil.contains( AV8CachePermissions, "{"+AV9FunctionalityKey+"}") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamisauthinofflinecache.this.AV10IsAuthorized;
      CloseOpenCursors();
      exitApplication();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CachePermissions = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV10IsAuthorized ;
   private String AV9FunctionalityKey ;
   private String AV8CachePermissions ;
   private boolean[] aP1 ;
}

