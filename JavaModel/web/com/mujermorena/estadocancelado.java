package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estadocancelado extends GXProcedure
{
   public estadocancelado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estadocancelado.class ), "" );
   }

   public estadocancelado( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( )
   {
      estadocancelado.this.aP0 = new long[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( long[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long[] aP0 )
   {
      estadocancelado.this.AV8PedidosID = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV18UserName = AV17GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P007F2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8PedidosID)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A51PedidosID = P007F2_A51PedidosID[0] ;
         A247PedidosEstado = P007F2_A247PedidosEstado[0] ;
         A247PedidosEstado = httpContext.getMessage( "CAN", "") ;
         /* Using cursor P007F3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A51PedidosID)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A13ArticuloId = P007F3_A13ArticuloId[0] ;
            A245PedidosDetalleCantidad = P007F3_A245PedidosDetalleCantidad[0] ;
            A293PedidosDetalleTallaID = P007F3_A293PedidosDetalleTallaID[0] ;
            A52PedidosDetalleID = P007F3_A52PedidosDetalleID[0] ;
            AV12ArticuloId = A13ArticuloId ;
            AV13PedidosDetalleCantidad = A245PedidosDetalleCantidad ;
            AV30ArticuloStock = A245PedidosDetalleCantidad ;
            AV31PedidosDetalleTallaID = A293PedidosDetalleTallaID ;
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
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Using cursor P007F4 */
         pr_default.execute(2, new Object[] {A247PedidosEstado, Long.valueOf(A51PedidosID)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
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
      /* Using cursor P007F5 */
      pr_default.execute(3, new Object[] {Long.valueOf(AV12ArticuloId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A13ArticuloId = P007F5_A13ArticuloId[0] ;
         A79ArticuloStock = P007F5_A79ArticuloStock[0] ;
         A79ArticuloStock = (long)(A79ArticuloStock+AV30ArticuloStock) ;
         /* Using cursor P007F6 */
         pr_default.execute(4, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(AV31PedidosDetalleTallaID)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A286TallaID = P007F6_A286TallaID[0] ;
            A290ArticuloTallaStock = P007F6_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P007F6_A285ArticuloTallaID[0] ;
            A290ArticuloTallaStock = (long)(A290ArticuloTallaStock+AV30ArticuloStock) ;
            AV30ArticuloStock = 0 ;
            /* Using cursor P007F7 */
            pr_default.execute(5, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
            pr_default.readNext(4);
         }
         pr_default.close(4);
         /* Using cursor P007F8 */
         pr_default.execute(6, new Object[] {Long.valueOf(A79ArticuloStock), Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
   }

   public void S121( )
   {
      /* 'ACTUALIZARSTOCK' Routine */
      returnInSub = false ;
      /* Using cursor P007F9 */
      pr_default.execute(7, new Object[] {Long.valueOf(AV12ArticuloId)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A46StockId = P007F9_A46StockId[0] ;
         A13ArticuloId = P007F9_A13ArticuloId[0] ;
         A233StockTotal = P007F9_A233StockTotal[0] ;
         A233StockTotal = (int)(A233StockTotal+AV13PedidosDetalleCantidad) ;
         /* Using cursor P007F10 */
         pr_default.execute(8, new Object[] {Long.valueOf(A46StockId), Long.valueOf(AV31PedidosDetalleTallaID)});
         while ( (pr_default.getStatus(8) != 101) )
         {
            A289StockDetalleTallaID = P007F10_A289StockDetalleTallaID[0] ;
            A218StockCantidad = P007F10_A218StockCantidad[0] ;
            A50StockDetalleID = P007F10_A50StockDetalleID[0] ;
            A218StockCantidad = (int)(A218StockCantidad+AV13PedidosDetalleCantidad) ;
            AV13PedidosDetalleCantidad = 0 ;
            /* Using cursor P007F11 */
            pr_default.execute(9, new Object[] {Integer.valueOf(A218StockCantidad), Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
            pr_default.readNext(8);
         }
         pr_default.close(8);
         /* Using cursor P007F12 */
         pr_default.execute(10, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A46StockId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         pr_default.readNext(7);
      }
      pr_default.close(7);
   }

   protected void cleanup( )
   {
      this.aP0[0] = estadocancelado.this.AV8PedidosID;
      Application.commitDataStores(context, remoteHandle, pr_default, "estadocancelado");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV18UserName = "" ;
      scmdbuf = "" ;
      P007F2_A51PedidosID = new long[1] ;
      P007F2_A247PedidosEstado = new String[] {""} ;
      A247PedidosEstado = "" ;
      P007F3_A51PedidosID = new long[1] ;
      P007F3_A13ArticuloId = new long[1] ;
      P007F3_A245PedidosDetalleCantidad = new int[1] ;
      P007F3_A293PedidosDetalleTallaID = new long[1] ;
      P007F3_A52PedidosDetalleID = new long[1] ;
      P007F5_A13ArticuloId = new long[1] ;
      P007F5_A79ArticuloStock = new long[1] ;
      P007F6_A13ArticuloId = new long[1] ;
      P007F6_A286TallaID = new long[1] ;
      P007F6_A290ArticuloTallaStock = new long[1] ;
      P007F6_A285ArticuloTallaID = new long[1] ;
      P007F9_A46StockId = new long[1] ;
      P007F9_A13ArticuloId = new long[1] ;
      P007F9_A233StockTotal = new int[1] ;
      P007F10_A46StockId = new long[1] ;
      P007F10_A289StockDetalleTallaID = new long[1] ;
      P007F10_A218StockCantidad = new int[1] ;
      P007F10_A50StockDetalleID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.estadocancelado__default(),
         new Object[] {
             new Object[] {
            P007F2_A51PedidosID, P007F2_A247PedidosEstado
            }
            , new Object[] {
            P007F3_A51PedidosID, P007F3_A13ArticuloId, P007F3_A245PedidosDetalleCantidad, P007F3_A293PedidosDetalleTallaID, P007F3_A52PedidosDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            P007F5_A13ArticuloId, P007F5_A79ArticuloStock
            }
            , new Object[] {
            P007F6_A13ArticuloId, P007F6_A286TallaID, P007F6_A290ArticuloTallaStock, P007F6_A285ArticuloTallaID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P007F9_A46StockId, P007F9_A13ArticuloId, P007F9_A233StockTotal
            }
            , new Object[] {
            P007F10_A46StockId, P007F10_A289StockDetalleTallaID, P007F10_A218StockCantidad, P007F10_A50StockDetalleID
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
   private int A245PedidosDetalleCantidad ;
   private int AV13PedidosDetalleCantidad ;
   private int A233StockTotal ;
   private int A218StockCantidad ;
   private long AV8PedidosID ;
   private long A51PedidosID ;
   private long A13ArticuloId ;
   private long A293PedidosDetalleTallaID ;
   private long A52PedidosDetalleID ;
   private long AV12ArticuloId ;
   private long AV30ArticuloStock ;
   private long AV31PedidosDetalleTallaID ;
   private long A79ArticuloStock ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long A285ArticuloTallaID ;
   private long A46StockId ;
   private long A289StockDetalleTallaID ;
   private long A50StockDetalleID ;
   private String AV18UserName ;
   private String scmdbuf ;
   private String A247PedidosEstado ;
   private boolean returnInSub ;
   private long[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P007F2_A51PedidosID ;
   private String[] P007F2_A247PedidosEstado ;
   private long[] P007F3_A51PedidosID ;
   private long[] P007F3_A13ArticuloId ;
   private int[] P007F3_A245PedidosDetalleCantidad ;
   private long[] P007F3_A293PedidosDetalleTallaID ;
   private long[] P007F3_A52PedidosDetalleID ;
   private long[] P007F5_A13ArticuloId ;
   private long[] P007F5_A79ArticuloStock ;
   private long[] P007F6_A13ArticuloId ;
   private long[] P007F6_A286TallaID ;
   private long[] P007F6_A290ArticuloTallaStock ;
   private long[] P007F6_A285ArticuloTallaID ;
   private long[] P007F9_A46StockId ;
   private long[] P007F9_A13ArticuloId ;
   private int[] P007F9_A233StockTotal ;
   private long[] P007F10_A46StockId ;
   private long[] P007F10_A289StockDetalleTallaID ;
   private int[] P007F10_A218StockCantidad ;
   private long[] P007F10_A50StockDetalleID ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV17GAMUser ;
}

final  class estadocancelado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007F2", "SELECT [PedidosID], [PedidosEstado] FROM [Pedidos] WITH (UPDLOCK) WHERE [PedidosID] = ? ORDER BY [PedidosID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007F3", "SELECT [PedidosID], [ArticuloId], [PedidosDetalleCantidad], [PedidosDetalleTallaID], [PedidosDetalleID] FROM [PedidosDetalle] WHERE [PedidosID] = ? ORDER BY [PedidosID], [PedidosDetalleID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007F4", "UPDATE [Pedidos] SET [PedidosEstado]=?  WHERE [PedidosID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P007F5", "SELECT [ArticuloId], [ArticuloStock] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007F6", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE ([ArticuloId] = ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007F7", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P007F8", "UPDATE [Articulo] SET [ArticuloStock]=?  WHERE [ArticuloId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P007F9", "SELECT [StockId], [ArticuloId], [StockTotal] FROM [Stock] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [StockId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007F10", "SELECT [StockId], [StockDetalleTallaID], [StockCantidad], [StockDetalleID] FROM [StockDetalle] WITH (UPDLOCK) WHERE ([StockId] = ?) AND ([StockDetalleTallaID] = ?) ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007F11", "UPDATE [StockDetalle] SET [StockCantidad]=?  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P007F12", "UPDATE [Stock] SET [StockTotal]=?  WHERE [StockId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 8 :
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

