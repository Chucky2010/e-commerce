package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class stockventas extends GXProcedure
{
   public stockventas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stockventas.class ), "" );
   }

   public stockventas( int remoteHandle ,
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
      stockventas.this.AV15VentasId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000Q2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV15VentasId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19VentasId = P000Q2_A19VentasId[0] ;
         /* Using cursor P000Q3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A19VentasId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A13ArticuloId = P000Q3_A13ArticuloId[0] ;
            A92VentasDetalleCantidad = P000Q3_A92VentasDetalleCantidad[0] ;
            A292VentasDetalleTallaID = P000Q3_A292VentasDetalleTallaID[0] ;
            A20VentasDetalleId = P000Q3_A20VentasDetalleId[0] ;
            AV9ArticuloId = A13ArticuloId ;
            AV16VentasDetalleCantidad = A92VentasDetalleCantidad ;
            AV17VentasDetalleTallaID = A292VentasDetalleTallaID ;
            AV18ArticuloTallaStock = A92VentasDetalleCantidad ;
            /* Execute user subroutine: 'ACTUALIZARSTOCKVENTA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'ACTUALIZARSTOCKARTICULO' */
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
      /* 'ACTUALIZARSTOCKVENTA' Routine */
      returnInSub = false ;
      /* Using cursor P000Q4 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A46StockId = P000Q4_A46StockId[0] ;
         A13ArticuloId = P000Q4_A13ArticuloId[0] ;
         A233StockTotal = P000Q4_A233StockTotal[0] ;
         A233StockTotal = (int)(A233StockTotal-AV16VentasDetalleCantidad) ;
         /* Using cursor P000Q5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A46StockId), Long.valueOf(AV17VentasDetalleTallaID)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A289StockDetalleTallaID = P000Q5_A289StockDetalleTallaID[0] ;
            A218StockCantidad = P000Q5_A218StockCantidad[0] ;
            A50StockDetalleID = P000Q5_A50StockDetalleID[0] ;
            if ( AV16VentasDetalleCantidad > 0 )
            {
               if ( A218StockCantidad > AV16VentasDetalleCantidad )
               {
                  A218StockCantidad = (int)(A218StockCantidad-AV16VentasDetalleCantidad) ;
                  AV16VentasDetalleCantidad = 0 ;
               }
               else
               {
                  AV16VentasDetalleCantidad = (int)(AV16VentasDetalleCantidad-A218StockCantidad) ;
                  A218StockCantidad = 0 ;
               }
            }
            /* Using cursor P000Q6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A218StockCantidad), Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
            pr_default.readNext(3);
         }
         pr_default.close(3);
         /* Using cursor P000Q7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A46StockId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void S121( )
   {
      /* 'ACTUALIZARSTOCKARTICULO' Routine */
      returnInSub = false ;
      /* Using cursor P000Q8 */
      pr_default.execute(6, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A13ArticuloId = P000Q8_A13ArticuloId[0] ;
         A79ArticuloStock = P000Q8_A79ArticuloStock[0] ;
         A79ArticuloStock = (long)(A79ArticuloStock-AV16VentasDetalleCantidad) ;
         /* Using cursor P000Q9 */
         pr_default.execute(7, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(AV17VentasDetalleTallaID)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A286TallaID = P000Q9_A286TallaID[0] ;
            A290ArticuloTallaStock = P000Q9_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P000Q9_A285ArticuloTallaID[0] ;
            A290ArticuloTallaStock = (long)(A290ArticuloTallaStock-AV18ArticuloTallaStock) ;
            AV18ArticuloTallaStock = 0 ;
            /* Using cursor P000Q10 */
            pr_default.execute(8, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
            pr_default.readNext(7);
         }
         pr_default.close(7);
         /* Using cursor P000Q11 */
         pr_default.execute(9, new Object[] {Long.valueOf(A79ArticuloStock), Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(6);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "stockventas");
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
      P000Q2_A19VentasId = new long[1] ;
      P000Q3_A19VentasId = new long[1] ;
      P000Q3_A13ArticuloId = new long[1] ;
      P000Q3_A92VentasDetalleCantidad = new int[1] ;
      P000Q3_A292VentasDetalleTallaID = new long[1] ;
      P000Q3_A20VentasDetalleId = new long[1] ;
      P000Q4_A46StockId = new long[1] ;
      P000Q4_A13ArticuloId = new long[1] ;
      P000Q4_A233StockTotal = new int[1] ;
      P000Q5_A46StockId = new long[1] ;
      P000Q5_A289StockDetalleTallaID = new long[1] ;
      P000Q5_A218StockCantidad = new int[1] ;
      P000Q5_A50StockDetalleID = new long[1] ;
      P000Q8_A13ArticuloId = new long[1] ;
      P000Q8_A79ArticuloStock = new long[1] ;
      P000Q9_A13ArticuloId = new long[1] ;
      P000Q9_A286TallaID = new long[1] ;
      P000Q9_A290ArticuloTallaStock = new long[1] ;
      P000Q9_A285ArticuloTallaID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.stockventas__default(),
         new Object[] {
             new Object[] {
            P000Q2_A19VentasId
            }
            , new Object[] {
            P000Q3_A19VentasId, P000Q3_A13ArticuloId, P000Q3_A92VentasDetalleCantidad, P000Q3_A292VentasDetalleTallaID, P000Q3_A20VentasDetalleId
            }
            , new Object[] {
            P000Q4_A46StockId, P000Q4_A13ArticuloId, P000Q4_A233StockTotal
            }
            , new Object[] {
            P000Q5_A46StockId, P000Q5_A289StockDetalleTallaID, P000Q5_A218StockCantidad, P000Q5_A50StockDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P000Q8_A13ArticuloId, P000Q8_A79ArticuloStock
            }
            , new Object[] {
            P000Q9_A13ArticuloId, P000Q9_A286TallaID, P000Q9_A290ArticuloTallaStock, P000Q9_A285ArticuloTallaID
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
   private int A92VentasDetalleCantidad ;
   private int AV16VentasDetalleCantidad ;
   private int A233StockTotal ;
   private int A218StockCantidad ;
   private long AV15VentasId ;
   private long A19VentasId ;
   private long A13ArticuloId ;
   private long A292VentasDetalleTallaID ;
   private long A20VentasDetalleId ;
   private long AV9ArticuloId ;
   private long AV17VentasDetalleTallaID ;
   private long AV18ArticuloTallaStock ;
   private long A46StockId ;
   private long A289StockDetalleTallaID ;
   private long A50StockDetalleID ;
   private long A79ArticuloStock ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long A285ArticuloTallaID ;
   private String scmdbuf ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private long[] P000Q2_A19VentasId ;
   private long[] P000Q3_A19VentasId ;
   private long[] P000Q3_A13ArticuloId ;
   private int[] P000Q3_A92VentasDetalleCantidad ;
   private long[] P000Q3_A292VentasDetalleTallaID ;
   private long[] P000Q3_A20VentasDetalleId ;
   private long[] P000Q4_A46StockId ;
   private long[] P000Q4_A13ArticuloId ;
   private int[] P000Q4_A233StockTotal ;
   private long[] P000Q5_A46StockId ;
   private long[] P000Q5_A289StockDetalleTallaID ;
   private int[] P000Q5_A218StockCantidad ;
   private long[] P000Q5_A50StockDetalleID ;
   private long[] P000Q8_A13ArticuloId ;
   private long[] P000Q8_A79ArticuloStock ;
   private long[] P000Q9_A13ArticuloId ;
   private long[] P000Q9_A286TallaID ;
   private long[] P000Q9_A290ArticuloTallaStock ;
   private long[] P000Q9_A285ArticuloTallaID ;
}

final  class stockventas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000Q2", "SELECT [VentasId] FROM [Ventas] WHERE [VentasId] = ? ORDER BY [VentasId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000Q3", "SELECT [VentasId], [ArticuloId], [VentasDetalleCantidad], [VentasDetalleTallaID], [VentasDetalleId] FROM [VentasDetalle] WHERE [VentasId] = ? ORDER BY [VentasId], [VentasDetalleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000Q4", "SELECT [StockId], [ArticuloId], [StockTotal] FROM [Stock] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [StockId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000Q5", "SELECT [StockId], [StockDetalleTallaID], [StockCantidad], [StockDetalleID] FROM [StockDetalle] WITH (UPDLOCK) WHERE ([StockId] = ?) AND ([StockDetalleTallaID] = ?) ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P000Q6", "UPDATE [StockDetalle] SET [StockCantidad]=?  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000Q7", "UPDATE [Stock] SET [StockTotal]=?  WHERE [StockId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P000Q8", "SELECT [ArticuloId], [ArticuloStock] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000Q9", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE ([ArticuloId] = ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P000Q10", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000Q11", "UPDATE [Articulo] SET [ArticuloStock]=?  WHERE [ArticuloId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

