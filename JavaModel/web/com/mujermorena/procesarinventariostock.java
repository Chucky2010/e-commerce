package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesarinventariostock extends GXProcedure
{
   public procesarinventariostock( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesarinventariostock.class ), "" );
   }

   public procesarinventariostock( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( )
   {
      procesarinventariostock.this.aP0 = new long[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( long[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long[] aP0 )
   {
      procesarinventariostock.this.AV15InventarioID = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P004Z2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV15InventarioID)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A53InventarioID = P004Z2_A53InventarioID[0] ;
         /* Using cursor P004Z3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A53InventarioID)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A13ArticuloId = P004Z3_A13ArticuloId[0] ;
            A259InventarioDetalleStock = P004Z3_A259InventarioDetalleStock[0] ;
            A262InventarioDetalleStock2 = P004Z3_A262InventarioDetalleStock2[0] ;
            A263InventarioDetalleStock3 = P004Z3_A263InventarioDetalleStock3[0] ;
            A261InventarioDetalleStockOk = P004Z3_A261InventarioDetalleStockOk[0] ;
            A54InventarioDetalleID = P004Z3_A54InventarioDetalleID[0] ;
            AV18ArticuloId = A13ArticuloId ;
            AV19InventarioDetalleStock = A259InventarioDetalleStock ;
            AV20InventarioDetalleStock2 = A262InventarioDetalleStock2 ;
            AV21InventarioDetalleStock3 = A263InventarioDetalleStock3 ;
            if ( AV19InventarioDetalleStock == AV20InventarioDetalleStock2 )
            {
               A261InventarioDetalleStockOk = AV19InventarioDetalleStock ;
            }
            else
            {
               if ( AV19InventarioDetalleStock == AV21InventarioDetalleStock3 )
               {
                  A261InventarioDetalleStockOk = AV19InventarioDetalleStock ;
               }
               else
               {
                  if ( AV20InventarioDetalleStock2 == AV21InventarioDetalleStock3 )
                  {
                     A261InventarioDetalleStockOk = AV20InventarioDetalleStock2 ;
                  }
                  else
                  {
                     A261InventarioDetalleStockOk = 0 ;
                  }
               }
            }
            /* Using cursor P004Z4 */
            pr_default.execute(2, new Object[] {Long.valueOf(A261InventarioDetalleStockOk), Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("InventarioDetalle");
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = procesarinventariostock.this.AV15InventarioID;
      Application.commitDataStores(context, remoteHandle, pr_default, "procesarinventariostock");
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
      P004Z2_A53InventarioID = new long[1] ;
      P004Z3_A53InventarioID = new long[1] ;
      P004Z3_A13ArticuloId = new long[1] ;
      P004Z3_A259InventarioDetalleStock = new long[1] ;
      P004Z3_A262InventarioDetalleStock2 = new long[1] ;
      P004Z3_A263InventarioDetalleStock3 = new long[1] ;
      P004Z3_A261InventarioDetalleStockOk = new long[1] ;
      P004Z3_A54InventarioDetalleID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.procesarinventariostock__default(),
         new Object[] {
             new Object[] {
            P004Z2_A53InventarioID
            }
            , new Object[] {
            P004Z3_A53InventarioID, P004Z3_A13ArticuloId, P004Z3_A259InventarioDetalleStock, P004Z3_A262InventarioDetalleStock2, P004Z3_A263InventarioDetalleStock3, P004Z3_A261InventarioDetalleStockOk, P004Z3_A54InventarioDetalleID
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV15InventarioID ;
   private long A53InventarioID ;
   private long A13ArticuloId ;
   private long A259InventarioDetalleStock ;
   private long A262InventarioDetalleStock2 ;
   private long A263InventarioDetalleStock3 ;
   private long A261InventarioDetalleStockOk ;
   private long A54InventarioDetalleID ;
   private long AV18ArticuloId ;
   private long AV19InventarioDetalleStock ;
   private long AV20InventarioDetalleStock2 ;
   private long AV21InventarioDetalleStock3 ;
   private String scmdbuf ;
   private long[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P004Z2_A53InventarioID ;
   private long[] P004Z3_A53InventarioID ;
   private long[] P004Z3_A13ArticuloId ;
   private long[] P004Z3_A259InventarioDetalleStock ;
   private long[] P004Z3_A262InventarioDetalleStock2 ;
   private long[] P004Z3_A263InventarioDetalleStock3 ;
   private long[] P004Z3_A261InventarioDetalleStockOk ;
   private long[] P004Z3_A54InventarioDetalleID ;
}

final  class procesarinventariostock__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004Z2", "SELECT [InventarioID] FROM [Inventario] WHERE [InventarioID] = ? ORDER BY [InventarioID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P004Z3", "SELECT [InventarioID], [ArticuloId], [InventarioDetalleStock], [InventarioDetalleStock2], [InventarioDetalleStock3], [InventarioDetalleStockOk], [InventarioDetalleID] FROM [InventarioDetalle] WITH (UPDLOCK) WHERE [InventarioID] = ? ORDER BY [InventarioID], [InventarioDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004Z4", "UPDATE [InventarioDetalle] SET [InventarioDetalleStockOk]=?  WHERE [InventarioID] = ? AND [InventarioDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

