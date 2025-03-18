package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gxbeforeeventreplicator extends GXProcedure
{
   public gxbeforeeventreplicator( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gxbeforeeventreplicator.class ), "" );
   }

   public gxbeforeeventreplicator( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> executeUdp( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem>[] aP0 ,
                                                                                                                                                        com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP1 )
   {
      gxbeforeeventreplicator.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem>[] aP0 ,
                        com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP1 ,
                        GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem>[] aP0 ,
                             com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP1 ,
                             GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem>[] aP2 )
   {
      gxbeforeeventreplicator.this.GxPendingEvents = aP0[0];
      this.aP0 = aP0;
      gxbeforeeventreplicator.this.GxSyncroInfo = aP1;
      gxbeforeeventreplicator.this.AV8EventResults = aP2[0];
      this.aP2 = aP2;
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
      this.aP0[0] = gxbeforeeventreplicator.this.GxPendingEvents;
      this.aP2[0] = gxbeforeeventreplicator.this.AV8EventResults;
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
   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem>[] aP2 ;
   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem>[] aP0 ;
   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem> AV8EventResults ;
   private GXBaseCollection<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem> GxPendingEvents ;
   private com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo GxSyncroInfo ;
}

