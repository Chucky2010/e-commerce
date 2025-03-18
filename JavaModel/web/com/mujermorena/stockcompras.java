package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class stockcompras extends GXProcedure
{
   public stockcompras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stockcompras.class ), "" );
   }

   public stockcompras( int remoteHandle ,
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
      stockcompras.this.AV8ComprasId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000P2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8ComprasId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11ComprasId = P000P2_A11ComprasId[0] ;
         A74ComprasFecha = P000P2_A74ComprasFecha[0] ;
         AV11ComprasFecha = A74ComprasFecha ;
         /* Using cursor P000P3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A11ComprasId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A13ArticuloId = P000P3_A13ArticuloId[0] ;
            A82ComprasCantidad = P000P3_A82ComprasCantidad[0] ;
            A80ComprasDetallePrecioCompra = P000P3_A80ComprasDetallePrecioCompra[0] ;
            A291ComprasDetalleTallaID = P000P3_A291ComprasDetalleTallaID[0] ;
            A12ComprasDetalleId = P000P3_A12ComprasDetalleId[0] ;
            AV9ArticuloId = A13ArticuloId ;
            AV12ComprasCantidad = A82ComprasCantidad ;
            AV13ComprasDetallePrecioCompra = A80ComprasDetallePrecioCompra ;
            AV15TallaID = A291ComprasDetalleTallaID ;
            /* Execute user subroutine: 'ACTUALIZARSTOCKCOMPRA' */
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
      /* 'ACTUALIZARSTOCKCOMPRA' Routine */
      returnInSub = false ;
      AV20GXLvl21 = (byte)(0) ;
      /* Using cursor P000P4 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A13ArticuloId = P000P4_A13ArticuloId[0] ;
         A233StockTotal = P000P4_A233StockTotal[0] ;
         A46StockId = P000P4_A46StockId[0] ;
         AV20GXLvl21 = (byte)(1) ;
         GXt_int1 = AV10StockDetalleID ;
         GXv_int2[0] = GXt_int1 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "StockDetalle", ""), GXv_int2) ;
         stockcompras.this.GXt_int1 = GXv_int2[0] ;
         AV10StockDetalleID = GXt_int1 ;
         AV14StockId = A46StockId ;
         A233StockTotal = (int)(A233StockTotal+AV12ComprasCantidad) ;
         /*
            INSERT RECORD ON TABLE StockDetalle

         */
         W46StockId = A46StockId ;
         A46StockId = AV14StockId ;
         A50StockDetalleID = AV10StockDetalleID ;
         A216StockIdCompra = AV8ComprasId ;
         A217StockFecha = AV11ComprasFecha ;
         A218StockCantidad = AV12ComprasCantidad ;
         A219StockSaldo = (short)(0) ;
         A220StockPrecioCompra = AV13ComprasDetallePrecioCompra ;
         A221StockPrecioVenta = DecimalUtil.doubleToDec(0) ;
         A289StockDetalleTallaID = AV15TallaID ;
         /* Using cursor P000P5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID), Long.valueOf(A216StockIdCompra), A217StockFecha, Integer.valueOf(A218StockCantidad), Short.valueOf(A219StockSaldo), A220StockPrecioCompra, A221StockPrecioVenta, Long.valueOf(A289StockDetalleTallaID)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         A46StockId = W46StockId ;
         /* End Insert */
         /* Using cursor P000P6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A46StockId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV20GXLvl21 == 0 )
      {
         GXt_int1 = AV14StockId ;
         GXv_int2[0] = GXt_int1 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "Stock", ""), GXv_int2) ;
         stockcompras.this.GXt_int1 = GXv_int2[0] ;
         AV14StockId = GXt_int1 ;
         /*
            INSERT RECORD ON TABLE Stock

         */
         A46StockId = AV14StockId ;
         A13ArticuloId = AV9ArticuloId ;
         A233StockTotal = AV12ComprasCantidad ;
         /* Using cursor P000P7 */
         pr_default.execute(5, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A13ArticuloId), Integer.valueOf(A233StockTotal)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         if ( (pr_default.getStatus(5) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         GXt_int1 = AV10StockDetalleID ;
         GXv_int2[0] = GXt_int1 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "StockDetalle", ""), GXv_int2) ;
         stockcompras.this.GXt_int1 = GXv_int2[0] ;
         AV10StockDetalleID = GXt_int1 ;
         /*
            INSERT RECORD ON TABLE StockDetalle

         */
         A46StockId = AV14StockId ;
         A50StockDetalleID = AV10StockDetalleID ;
         A216StockIdCompra = AV8ComprasId ;
         A217StockFecha = AV11ComprasFecha ;
         A218StockCantidad = AV12ComprasCantidad ;
         A219StockSaldo = (short)(0) ;
         A220StockPrecioCompra = AV13ComprasDetallePrecioCompra ;
         A221StockPrecioVenta = DecimalUtil.doubleToDec(0) ;
         A289StockDetalleTallaID = AV15TallaID ;
         /* Using cursor P000P8 */
         pr_default.execute(6, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID), Long.valueOf(A216StockIdCompra), A217StockFecha, Integer.valueOf(A218StockCantidad), Short.valueOf(A219StockSaldo), A220StockPrecioCompra, A221StockPrecioVenta, Long.valueOf(A289StockDetalleTallaID)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
         if ( (pr_default.getStatus(6) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
   }

   public void S121( )
   {
      /* 'ACTUALIZARSTOCKARTICULO' Routine */
      returnInSub = false ;
      /* Using cursor P000P9 */
      pr_default.execute(7, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A13ArticuloId = P000P9_A13ArticuloId[0] ;
         A79ArticuloStock = P000P9_A79ArticuloStock[0] ;
         A79ArticuloStock = (long)(A79ArticuloStock+AV12ComprasCantidad) ;
         /* Using cursor P000P10 */
         pr_default.execute(8, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(AV15TallaID)});
         while ( (pr_default.getStatus(8) != 101) )
         {
            A286TallaID = P000P10_A286TallaID[0] ;
            A290ArticuloTallaStock = P000P10_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P000P10_A285ArticuloTallaID[0] ;
            A290ArticuloTallaStock = (long)(A290ArticuloTallaStock+AV12ComprasCantidad) ;
            AV12ComprasCantidad = 0 ;
            /* Using cursor P000P11 */
            pr_default.execute(9, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
            pr_default.readNext(8);
         }
         pr_default.close(8);
         /* Using cursor P000P12 */
         pr_default.execute(10, new Object[] {Long.valueOf(A79ArticuloStock), Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(7);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "stockcompras");
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
      P000P2_A11ComprasId = new long[1] ;
      P000P2_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A74ComprasFecha = GXutil.nullDate() ;
      AV11ComprasFecha = GXutil.nullDate() ;
      P000P3_A11ComprasId = new long[1] ;
      P000P3_A13ArticuloId = new long[1] ;
      P000P3_A82ComprasCantidad = new int[1] ;
      P000P3_A80ComprasDetallePrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P000P3_A291ComprasDetalleTallaID = new long[1] ;
      P000P3_A12ComprasDetalleId = new long[1] ;
      A80ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      AV13ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      A217StockFecha = GXutil.nullDate() ;
      A220StockPrecioCompra = DecimalUtil.ZERO ;
      A221StockPrecioVenta = DecimalUtil.ZERO ;
      P000P4_A13ArticuloId = new long[1] ;
      P000P4_A233StockTotal = new int[1] ;
      P000P4_A46StockId = new long[1] ;
      Gx_emsg = "" ;
      GXv_int2 = new long[1] ;
      P000P9_A13ArticuloId = new long[1] ;
      P000P9_A79ArticuloStock = new long[1] ;
      P000P10_A13ArticuloId = new long[1] ;
      P000P10_A286TallaID = new long[1] ;
      P000P10_A290ArticuloTallaStock = new long[1] ;
      P000P10_A285ArticuloTallaID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.stockcompras__default(),
         new Object[] {
             new Object[] {
            P000P2_A11ComprasId, P000P2_A74ComprasFecha
            }
            , new Object[] {
            P000P3_A11ComprasId, P000P3_A13ArticuloId, P000P3_A82ComprasCantidad, P000P3_A80ComprasDetallePrecioCompra, P000P3_A291ComprasDetalleTallaID, P000P3_A12ComprasDetalleId
            }
            , new Object[] {
            P000P4_A13ArticuloId, P000P4_A233StockTotal, P000P4_A46StockId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P000P9_A13ArticuloId, P000P9_A79ArticuloStock
            }
            , new Object[] {
            P000P10_A13ArticuloId, P000P10_A286TallaID, P000P10_A290ArticuloTallaStock, P000P10_A285ArticuloTallaID
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

   private byte AV20GXLvl21 ;
   private short A219StockSaldo ;
   private short Gx_err ;
   private int A82ComprasCantidad ;
   private int AV12ComprasCantidad ;
   private int A233StockTotal ;
   private int A218StockCantidad ;
   private int GX_INS43 ;
   private int GX_INS42 ;
   private long AV8ComprasId ;
   private long A11ComprasId ;
   private long A13ArticuloId ;
   private long A291ComprasDetalleTallaID ;
   private long A12ComprasDetalleId ;
   private long AV9ArticuloId ;
   private long AV15TallaID ;
   private long A46StockId ;
   private long A50StockDetalleID ;
   private long A216StockIdCompra ;
   private long A289StockDetalleTallaID ;
   private long AV10StockDetalleID ;
   private long AV14StockId ;
   private long W46StockId ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A79ArticuloStock ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long A285ArticuloTallaID ;
   private java.math.BigDecimal A80ComprasDetallePrecioCompra ;
   private java.math.BigDecimal AV13ComprasDetallePrecioCompra ;
   private java.math.BigDecimal A220StockPrecioCompra ;
   private java.math.BigDecimal A221StockPrecioVenta ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private java.util.Date A74ComprasFecha ;
   private java.util.Date AV11ComprasFecha ;
   private java.util.Date A217StockFecha ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private long[] P000P2_A11ComprasId ;
   private java.util.Date[] P000P2_A74ComprasFecha ;
   private long[] P000P3_A11ComprasId ;
   private long[] P000P3_A13ArticuloId ;
   private int[] P000P3_A82ComprasCantidad ;
   private java.math.BigDecimal[] P000P3_A80ComprasDetallePrecioCompra ;
   private long[] P000P3_A291ComprasDetalleTallaID ;
   private long[] P000P3_A12ComprasDetalleId ;
   private long[] P000P4_A13ArticuloId ;
   private int[] P000P4_A233StockTotal ;
   private long[] P000P4_A46StockId ;
   private long[] P000P9_A13ArticuloId ;
   private long[] P000P9_A79ArticuloStock ;
   private long[] P000P10_A13ArticuloId ;
   private long[] P000P10_A286TallaID ;
   private long[] P000P10_A290ArticuloTallaStock ;
   private long[] P000P10_A285ArticuloTallaID ;
}

final  class stockcompras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000P2", "SELECT [ComprasId], [ComprasFecha] FROM [Compras] WHERE [ComprasId] = ? ORDER BY [ComprasId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000P3", "SELECT [ComprasId], [ArticuloId], [ComprasCantidad], [ComprasDetallePrecioCompra], [ComprasDetalleTallaID], [ComprasDetalleId] FROM [ComprasDetalle] WHERE [ComprasId] = ? ORDER BY [ComprasId], [ComprasDetalleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000P4", "SELECT [ArticuloId], [StockTotal], [StockId] FROM [Stock] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [StockId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P000P5", "INSERT INTO [StockDetalle]([StockId], [StockDetalleID], [StockIdCompra], [StockFecha], [StockCantidad], [StockSaldo], [StockPrecioCompra], [StockPrecioVenta], [StockDetalleTallaID]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000P6", "UPDATE [Stock] SET [StockTotal]=?  WHERE [StockId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000P7", "INSERT INTO [Stock]([StockId], [ArticuloId], [StockTotal]) VALUES(?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000P8", "INSERT INTO [StockDetalle]([StockId], [StockDetalleID], [StockIdCompra], [StockFecha], [StockCantidad], [StockSaldo], [StockPrecioCompra], [StockPrecioVenta], [StockDetalleTallaID]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P000P9", "SELECT [ArticuloId], [ArticuloStock] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000P10", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE ([ArticuloId] = ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P000P11", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000P12", "UPDATE [Articulo] SET [ArticuloStock]=?  WHERE [ArticuloId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 8 :
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
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setLong(9, ((Number) parms[8]).longValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setLong(9, ((Number) parms[8]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

