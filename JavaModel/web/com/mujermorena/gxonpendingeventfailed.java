package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gxonpendingeventfailed extends GXProcedure
{
   public gxonpendingeventfailed( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gxonpendingeventfailed.class ), "" );
   }

   public gxonpendingeventfailed( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem aP0 ,
                              String aP1 ,
                              String aP2 ,
                              com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem aP3 ,
                              com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP4 )
   {
      gxonpendingeventfailed.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem aP0 ,
                        String aP1 ,
                        String aP2 ,
                        com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem aP3 ,
                        com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem aP0 ,
                             String aP1 ,
                             String aP2 ,
                             com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem aP3 ,
                             com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo aP4 ,
                             boolean[] aP5 )
   {
      gxonpendingeventfailed.this.AV8PendingEvent = aP0;
      gxonpendingeventfailed.this.AV9BCName = aP1;
      gxonpendingeventfailed.this.AV10BCJson = aP2;
      gxonpendingeventfailed.this.AV12EventResult = aP3;
      gxonpendingeventfailed.this.GxSyncroInfo = aP4;
      gxonpendingeventfailed.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11Continue = true ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = gxonpendingeventfailed.this.AV11Continue;
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
   private boolean AV11Continue ;
   private String AV10BCJson ;
   private String AV9BCName ;
   private boolean[] aP5 ;
   private com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem AV8PendingEvent ;
   private com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem AV12EventResult ;
   private com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo GxSyncroInfo ;
}

