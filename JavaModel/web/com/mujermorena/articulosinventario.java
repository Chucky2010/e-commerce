package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class articulosinventario extends GXProcedure
{
   public articulosinventario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articulosinventario.class ), "" );
   }

   public articulosinventario( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( )
   {
      articulosinventario.this.aP0 = new long[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( long[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long[] aP0 )
   {
      articulosinventario.this.AV15InventarioID = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000T2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV15InventarioID)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A53InventarioID = P000T2_A53InventarioID[0] ;
         /* Using cursor P000T3 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            A79ArticuloStock = P000T3_A79ArticuloStock[0] ;
            A13ArticuloId = P000T3_A13ArticuloId[0] ;
            AV18ArticuloId = A13ArticuloId ;
            /* Execute user subroutine: 'CARGARDETALLE' */
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
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'CARGARDETALLE' Routine */
      returnInSub = false ;
      GXt_int1 = AV16InventarioDetalleID ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "InventarioDetalle", ""), GXv_int2) ;
      articulosinventario.this.GXt_int1 = GXv_int2[0] ;
      AV16InventarioDetalleID = GXt_int1 ;
      /*
         INSERT RECORD ON TABLE InventarioDetalle

      */
      A53InventarioID = AV15InventarioID ;
      A54InventarioDetalleID = AV16InventarioDetalleID ;
      A13ArticuloId = AV18ArticuloId ;
      /* Using cursor P000T4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID), Long.valueOf(A13ArticuloId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("InventarioDetalle");
      if ( (pr_default.getStatus(2) == 1) )
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

   protected void cleanup( )
   {
      this.aP0[0] = articulosinventario.this.AV15InventarioID;
      Application.commitDataStores(context, remoteHandle, pr_default, "articulosinventario");
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
      P000T2_A53InventarioID = new long[1] ;
      P000T3_A79ArticuloStock = new long[1] ;
      P000T3_A13ArticuloId = new long[1] ;
      GXv_int2 = new long[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articulosinventario__default(),
         new Object[] {
             new Object[] {
            P000T2_A53InventarioID
            }
            , new Object[] {
            P000T3_A79ArticuloStock, P000T3_A13ArticuloId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int GX_INS50 ;
   private long AV15InventarioID ;
   private long A53InventarioID ;
   private long A79ArticuloStock ;
   private long A13ArticuloId ;
   private long AV18ArticuloId ;
   private long AV16InventarioDetalleID ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A54InventarioDetalleID ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private boolean returnInSub ;
   private long[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P000T2_A53InventarioID ;
   private long[] P000T3_A79ArticuloStock ;
   private long[] P000T3_A13ArticuloId ;
}

final  class articulosinventario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000T2", "SELECT [InventarioID] FROM [Inventario] WHERE [InventarioID] = ? ORDER BY [InventarioID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000T3", "SELECT [ArticuloStock], [ArticuloId] FROM [Articulo] ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P000T4", "INSERT INTO [InventarioDetalle]([InventarioID], [InventarioDetalleID], [ArticuloId], [InventarioDetalleStock], [InventarioDetalleStock2], [InventarioDetalleStock3], [InventarioDetalleStock4], [InventarioDetalleStockOk]) VALUES(?, ?, ?, convert(int, 0), convert(int, 0), convert(int, 0), convert(int, 0), convert(int, 0))", GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

