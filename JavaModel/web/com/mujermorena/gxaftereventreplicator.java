package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gxaftereventreplicator extends GXProcedure
{
   public gxaftereventreplicator( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gxaftereventreplicator.class ), "" );
   }

   public gxaftereventreplicator( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> aP0 ,
                        com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> aP0 ,
                             com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP1 )
   {
      gxaftereventreplicator.this.AV8EventResults = aP0;
      gxaftereventreplicator.this.GxSynchroInfo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> AV8EventResults ;
   private com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo GxSynchroInfo ;
}

