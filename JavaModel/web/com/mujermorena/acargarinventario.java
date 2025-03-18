package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class acargarinventario extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      acargarinventario pgm = new acargarinventario (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String[] aP0 = new String[] {""};
      String[] aP1 = new String[] {""};

      try
      {
         aP0[0] = (String) args[0];
         aP1[0] = (String) args[1];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1);
   }

   public acargarinventario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( acargarinventario.class ), "" );
   }

   public acargarinventario( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      acargarinventario.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      acargarinventario.this.AV9Direccion = aP0[0];
      this.aP0 = aP0;
      acargarinventario.this.AV10NombreArchivo = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Filename = GXutil.trim( AV9Direccion) + GXutil.trim( AV10NombreArchivo) ;
      httpContext.GX_msglist.addItem(AV8Filename);
      AV8Filename = GXutil.trim( AV8Filename) ;
      AV11ExcelDocument.Open(AV8Filename);
      AV11ExcelDocument.SelectSheet(httpContext.getMessage( "Listado", ""));
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV8Filename = "" ;
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Error en abrir documento", ""));
      }
      else
      {
         AV12ColumnIndex = 0 ;
         AV13fila = 3 ;
         AV14Bandera = (short)(0) ;
         while ( AV14Bandera == 0 )
         {
            if ( AV11ExcelDocument.Cells((int)(AV13fila), 1, 1, 1).getNumber() > 0 )
            {
               AV15InventarioID = (long)(AV11ExcelDocument.Cells(1, 7, 1, 1).getNumber()) ;
               AV17InventarioNumeroProceso = (short)(AV11ExcelDocument.Cells(1, 5, 1, 1).getNumber()) ;
               /* Using cursor P00512 */
               pr_default.execute(0, new Object[] {Long.valueOf(AV15InventarioID)});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A53InventarioID = P00512_A53InventarioID[0] ;
                  A257InventarioFecha = P00512_A257InventarioFecha[0] ;
                  A258InventarioDetalle = P00512_A258InventarioDetalle[0] ;
                  A257InventarioFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
                  A258InventarioDetalle = AV11ExcelDocument.Cells(1, 3, 1, 1).getText() ;
                  /* Using cursor P00513 */
                  pr_default.execute(1, new Object[] {Long.valueOf(A53InventarioID), Double.valueOf(AV11ExcelDocument.Cells((int)(AV13fila), 1, 1, 1).getNumber())});
                  while ( (pr_default.getStatus(1) != 101) )
                  {
                     A13ArticuloId = P00513_A13ArticuloId[0] ;
                     A259InventarioDetalleStock = P00513_A259InventarioDetalleStock[0] ;
                     A262InventarioDetalleStock2 = P00513_A262InventarioDetalleStock2[0] ;
                     A263InventarioDetalleStock3 = P00513_A263InventarioDetalleStock3[0] ;
                     A264InventarioDetalleStock4 = P00513_A264InventarioDetalleStock4[0] ;
                     A54InventarioDetalleID = P00513_A54InventarioDetalleID[0] ;
                     if ( AV17InventarioNumeroProceso == 1 )
                     {
                        A259InventarioDetalleStock = (long)(AV11ExcelDocument.Cells((int)(AV13fila), 3, 1, 1).getNumber()) ;
                     }
                     if ( AV17InventarioNumeroProceso == 2 )
                     {
                        A262InventarioDetalleStock2 = (long)(AV11ExcelDocument.Cells((int)(AV13fila), 3, 1, 1).getNumber()) ;
                     }
                     if ( AV17InventarioNumeroProceso == 3 )
                     {
                        A263InventarioDetalleStock3 = (long)(AV11ExcelDocument.Cells((int)(AV13fila), 3, 1, 1).getNumber()) ;
                     }
                     if ( AV17InventarioNumeroProceso == 4 )
                     {
                        A264InventarioDetalleStock4 = (long)(AV11ExcelDocument.Cells((int)(AV13fila), 3, 1, 1).getNumber()) ;
                     }
                     AV13fila = (long)(AV13fila+1) ;
                     /* Using cursor P00514 */
                     pr_default.execute(2, new Object[] {Long.valueOf(A259InventarioDetalleStock), Long.valueOf(A262InventarioDetalleStock2), Long.valueOf(A263InventarioDetalleStock3), Long.valueOf(A264InventarioDetalleStock4), Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("InventarioDetalle");
                     pr_default.readNext(1);
                  }
                  pr_default.close(1);
                  /* Using cursor P00515 */
                  pr_default.execute(3, new Object[] {A257InventarioFecha, A258InventarioDetalle, Long.valueOf(A53InventarioID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Inventario");
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
            }
            else
            {
               AV14Bandera = (short)(1) ;
            }
         }
      }
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(cargarinventario.class);
      return new com.mujermorena.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = acargarinventario.this.AV9Direccion;
      this.aP1[0] = acargarinventario.this.AV10NombreArchivo;
      Application.commitDataStores(context, remoteHandle, pr_default, "acargarinventario");
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Filename = "" ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      scmdbuf = "" ;
      P00512_A53InventarioID = new long[1] ;
      P00512_A257InventarioFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00512_A258InventarioDetalle = new String[] {""} ;
      A257InventarioFecha = GXutil.nullDate() ;
      A258InventarioDetalle = "" ;
      P00513_A53InventarioID = new long[1] ;
      P00513_A13ArticuloId = new long[1] ;
      P00513_A259InventarioDetalleStock = new long[1] ;
      P00513_A262InventarioDetalleStock2 = new long[1] ;
      P00513_A263InventarioDetalleStock3 = new long[1] ;
      P00513_A264InventarioDetalleStock4 = new long[1] ;
      P00513_A54InventarioDetalleID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.acargarinventario__default(),
         new Object[] {
             new Object[] {
            P00512_A53InventarioID, P00512_A257InventarioFecha, P00512_A258InventarioDetalle
            }
            , new Object[] {
            P00513_A53InventarioID, P00513_A13ArticuloId, P00513_A259InventarioDetalleStock, P00513_A262InventarioDetalleStock2, P00513_A263InventarioDetalleStock3, P00513_A264InventarioDetalleStock4, P00513_A54InventarioDetalleID
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

   private short AV14Bandera ;
   private short AV17InventarioNumeroProceso ;
   private short Gx_err ;
   private long AV12ColumnIndex ;
   private long AV13fila ;
   private long AV15InventarioID ;
   private long A53InventarioID ;
   private long A13ArticuloId ;
   private long A259InventarioDetalleStock ;
   private long A262InventarioDetalleStock2 ;
   private long A263InventarioDetalleStock3 ;
   private long A264InventarioDetalleStock4 ;
   private long A54InventarioDetalleID ;
   private String AV8Filename ;
   private String scmdbuf ;
   private java.util.Date A257InventarioFecha ;
   private String AV9Direccion ;
   private String AV10NombreArchivo ;
   private String A258InventarioDetalle ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P00512_A53InventarioID ;
   private java.util.Date[] P00512_A257InventarioFecha ;
   private String[] P00512_A258InventarioDetalle ;
   private long[] P00513_A53InventarioID ;
   private long[] P00513_A13ArticuloId ;
   private long[] P00513_A259InventarioDetalleStock ;
   private long[] P00513_A262InventarioDetalleStock2 ;
   private long[] P00513_A263InventarioDetalleStock3 ;
   private long[] P00513_A264InventarioDetalleStock4 ;
   private long[] P00513_A54InventarioDetalleID ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
}

final  class acargarinventario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00512", "SELECT [InventarioID], [InventarioFecha], [InventarioDetalle] FROM [Inventario] WITH (UPDLOCK) WHERE [InventarioID] = ? ORDER BY [InventarioID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00513", "SELECT [InventarioID], [ArticuloId], [InventarioDetalleStock], [InventarioDetalleStock2], [InventarioDetalleStock3], [InventarioDetalleStock4], [InventarioDetalleID] FROM [InventarioDetalle] WITH (UPDLOCK) WHERE ([InventarioID] = ?) AND ([ArticuloId] = ?) ORDER BY [InventarioID], [InventarioDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00514", "UPDATE [InventarioDetalle] SET [InventarioDetalleStock]=?, [InventarioDetalleStock2]=?, [InventarioDetalleStock3]=?, [InventarioDetalleStock4]=?  WHERE [InventarioID] = ? AND [InventarioDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00515", "UPDATE [Inventario] SET [InventarioFecha]=?, [InventarioDetalle]=?  WHERE [InventarioID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setBigDecimal(2, ((Number) parms[1]).doubleValue(), 2);
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               return;
            case 3 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 80, false);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

