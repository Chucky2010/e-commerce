package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class stockdevoluciones extends GXProcedure
{
   public stockdevoluciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stockdevoluciones.class ), "" );
   }

   public stockdevoluciones( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long aP0 )
   {
      stockdevoluciones.this.AV15DevolucionesID = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006R2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV15DevolucionesID)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A272DevolucionesID = P006R2_A272DevolucionesID[0] ;
         A275DevolucionesFecha = P006R2_A275DevolucionesFecha[0] ;
         AV16DevolucionesFecha = A275DevolucionesFecha ;
         /* Using cursor P006R3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A272DevolucionesID)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A13ArticuloId = P006R3_A13ArticuloId[0] ;
            A303DevolucionesDetalleTallaID = P006R3_A303DevolucionesDetalleTallaID[0] ;
            A278DevolucionesDetalleCant = P006R3_A278DevolucionesDetalleCant[0] ;
            A274DevolucionesDetalleID = P006R3_A274DevolucionesDetalleID[0] ;
            AV9ArticuloId = A13ArticuloId ;
            AV20DevolucionesDetalleTallaID = A303DevolucionesDetalleTallaID ;
            AV17DevolucionesDetalleCant = A278DevolucionesDetalleCant ;
            AV22ArticuloTallaStock = A278DevolucionesDetalleCant ;
            /* Execute user subroutine: 'ACTUALIZARSTOCKARTICULO' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'ACTUALIZARSTOCK' */
            S121 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'ACTUALIZARSTOCKARTICULO' Routine */
      returnInSub = false ;
      /* Using cursor P006R4 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A13ArticuloId = P006R4_A13ArticuloId[0] ;
         A79ArticuloStock = P006R4_A79ArticuloStock[0] ;
         A79ArticuloStock = (long)(A79ArticuloStock+AV17DevolucionesDetalleCant) ;
         /* Using cursor P006R5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(AV20DevolucionesDetalleTallaID)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A286TallaID = P006R5_A286TallaID[0] ;
            A290ArticuloTallaStock = P006R5_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P006R5_A285ArticuloTallaID[0] ;
            A290ArticuloTallaStock = (long)(A290ArticuloTallaStock+AV22ArticuloTallaStock) ;
            AV22ArticuloTallaStock = 0 ;
            /* Using cursor P006R6 */
            pr_default.execute(4, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
            pr_default.readNext(3);
         }
         pr_default.close(3);
         /* Using cursor P006R7 */
         pr_default.execute(5, new Object[] {Long.valueOf(A79ArticuloStock), Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
   }

   public void S121( )
   {
      /* 'ACTUALIZARSTOCK' Routine */
      returnInSub = false ;
      /* Using cursor P006R8 */
      pr_default.execute(6, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A46StockId = P006R8_A46StockId[0] ;
         A13ArticuloId = P006R8_A13ArticuloId[0] ;
         A233StockTotal = P006R8_A233StockTotal[0] ;
         A233StockTotal = (int)(A233StockTotal+AV17DevolucionesDetalleCant) ;
         /* Using cursor P006R9 */
         pr_default.execute(7, new Object[] {Long.valueOf(A46StockId), Long.valueOf(AV20DevolucionesDetalleTallaID)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A289StockDetalleTallaID = P006R9_A289StockDetalleTallaID[0] ;
            A218StockCantidad = P006R9_A218StockCantidad[0] ;
            A50StockDetalleID = P006R9_A50StockDetalleID[0] ;
            A218StockCantidad = (int)(A218StockCantidad+AV17DevolucionesDetalleCant) ;
            AV17DevolucionesDetalleCant = 0 ;
            /* Using cursor P006R10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(A218StockCantidad), Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
            pr_default.readNext(7);
         }
         pr_default.close(7);
         /* Using cursor P006R11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A46StockId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         pr_default.readNext(6);
      }
      pr_default.close(6);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "stockdevoluciones");
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
      P006R2_A272DevolucionesID = new long[1] ;
      P006R2_A275DevolucionesFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A275DevolucionesFecha = GXutil.nullDate() ;
      AV16DevolucionesFecha = GXutil.nullDate() ;
      P006R3_A272DevolucionesID = new long[1] ;
      P006R3_A13ArticuloId = new long[1] ;
      P006R3_A303DevolucionesDetalleTallaID = new long[1] ;
      P006R3_A278DevolucionesDetalleCant = new int[1] ;
      P006R3_A274DevolucionesDetalleID = new long[1] ;
      P006R4_A13ArticuloId = new long[1] ;
      P006R4_A79ArticuloStock = new long[1] ;
      P006R5_A13ArticuloId = new long[1] ;
      P006R5_A286TallaID = new long[1] ;
      P006R5_A290ArticuloTallaStock = new long[1] ;
      P006R5_A285ArticuloTallaID = new long[1] ;
      P006R8_A46StockId = new long[1] ;
      P006R8_A13ArticuloId = new long[1] ;
      P006R8_A233StockTotal = new int[1] ;
      P006R9_A46StockId = new long[1] ;
      P006R9_A289StockDetalleTallaID = new long[1] ;
      P006R9_A218StockCantidad = new int[1] ;
      P006R9_A50StockDetalleID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.stockdevoluciones__default(),
         new Object[] {
             new Object[] {
            P006R2_A272DevolucionesID, P006R2_A275DevolucionesFecha
            }
            , new Object[] {
            P006R3_A272DevolucionesID, P006R3_A13ArticuloId, P006R3_A303DevolucionesDetalleTallaID, P006R3_A278DevolucionesDetalleCant, P006R3_A274DevolucionesDetalleID
            }
            , new Object[] {
            P006R4_A13ArticuloId, P006R4_A79ArticuloStock
            }
            , new Object[] {
            P006R5_A13ArticuloId, P006R5_A286TallaID, P006R5_A290ArticuloTallaStock, P006R5_A285ArticuloTallaID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P006R8_A46StockId, P006R8_A13ArticuloId, P006R8_A233StockTotal
            }
            , new Object[] {
            P006R9_A46StockId, P006R9_A289StockDetalleTallaID, P006R9_A218StockCantidad, P006R9_A50StockDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A278DevolucionesDetalleCant ;
   private int AV17DevolucionesDetalleCant ;
   private int A233StockTotal ;
   private int A218StockCantidad ;
   private long AV15DevolucionesID ;
   private long A272DevolucionesID ;
   private long A13ArticuloId ;
   private long A303DevolucionesDetalleTallaID ;
   private long A274DevolucionesDetalleID ;
   private long AV9ArticuloId ;
   private long AV20DevolucionesDetalleTallaID ;
   private long AV22ArticuloTallaStock ;
   private long A79ArticuloStock ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long A285ArticuloTallaID ;
   private long A46StockId ;
   private long A289StockDetalleTallaID ;
   private long A50StockDetalleID ;
   private String scmdbuf ;
   private java.util.Date A275DevolucionesFecha ;
   private java.util.Date AV16DevolucionesFecha ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private long[] P006R2_A272DevolucionesID ;
   private java.util.Date[] P006R2_A275DevolucionesFecha ;
   private long[] P006R3_A272DevolucionesID ;
   private long[] P006R3_A13ArticuloId ;
   private long[] P006R3_A303DevolucionesDetalleTallaID ;
   private int[] P006R3_A278DevolucionesDetalleCant ;
   private long[] P006R3_A274DevolucionesDetalleID ;
   private long[] P006R4_A13ArticuloId ;
   private long[] P006R4_A79ArticuloStock ;
   private long[] P006R5_A13ArticuloId ;
   private long[] P006R5_A286TallaID ;
   private long[] P006R5_A290ArticuloTallaStock ;
   private long[] P006R5_A285ArticuloTallaID ;
   private long[] P006R8_A46StockId ;
   private long[] P006R8_A13ArticuloId ;
   private int[] P006R8_A233StockTotal ;
   private long[] P006R9_A46StockId ;
   private long[] P006R9_A289StockDetalleTallaID ;
   private int[] P006R9_A218StockCantidad ;
   private long[] P006R9_A50StockDetalleID ;
}

final  class stockdevoluciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006R2", "SELECT [DevolucionesID], [DevolucionesFecha] FROM [Devoluciones] WHERE [DevolucionesID] = ? ORDER BY [DevolucionesID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006R3", "SELECT [DevolucionesID], [ArticuloId], [DevolucionesDetalleTallaID], [DevolucionesDetalleCant], [DevolucionesDetalleID] FROM [DevolucionesDetalle] WHERE [DevolucionesID] = ? ORDER BY [DevolucionesID], [DevolucionesDetalleID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006R4", "SELECT [ArticuloId], [ArticuloStock] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006R5", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE ([ArticuloId] = ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P006R6", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P006R7", "UPDATE [Articulo] SET [ArticuloStock]=?  WHERE [ArticuloId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P006R8", "SELECT [StockId], [ArticuloId], [StockTotal] FROM [Stock] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [StockId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006R9", "SELECT [StockId], [StockDetalleTallaID], [StockCantidad], [StockDetalleID] FROM [StockDetalle] WITH (UPDLOCK) WHERE ([StockId] = ?) AND ([StockDetalleTallaID] = ?) ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P006R10", "UPDATE [StockDetalle] SET [StockCantidad]=?  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P006R11", "UPDATE [Stock] SET [StockTotal]=?  WHERE [StockId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

