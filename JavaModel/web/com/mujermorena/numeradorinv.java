package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class numeradorinv extends GXProcedure
{
   public numeradorinv( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( numeradorinv.class ), "" );
   }

   public numeradorinv( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( )
   {
      numeradorinv.this.aP0 = new long[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( long[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long[] aP0 )
   {
      numeradorinv.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000S2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A53InventarioID = P000S2_A53InventarioID[0] ;
         AV10InventarioID = (long)(A53InventarioID+1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = numeradorinv.this.AV10InventarioID;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P000S2_A53InventarioID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.numeradorinv__default(),
         new Object[] {
             new Object[] {
            P000S2_A53InventarioID
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV10InventarioID ;
   private long A53InventarioID ;
   private String scmdbuf ;
   private long[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P000S2_A53InventarioID ;
}

final  class numeradorinv__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000S2", "SELECT TOP 1 [InventarioID] FROM [Inventario] ORDER BY [InventarioID] DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

