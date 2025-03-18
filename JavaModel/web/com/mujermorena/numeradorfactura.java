package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class numeradorfactura extends GXProcedure
{
   public numeradorfactura( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( numeradorfactura.class ), "" );
   }

   public numeradorfactura( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( String aP0 )
   {
      numeradorfactura.this.aP1 = new long[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        long[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             long[] aP1 )
   {
      numeradorfactura.this.AV11Tipo = aP0;
      numeradorfactura.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10TimbradoNroFactura = 1 ;
      if ( GXutil.strcmp(AV11Tipo, httpContext.getMessage( "FAC", "")) == 0 )
      {
         /* Using cursor P00762 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A308TimbradoEstado = P00762_A308TimbradoEstado[0] ;
            A128TimbradoNroFactura = P00762_A128TimbradoNroFactura[0] ;
            A29TimbradoId = P00762_A29TimbradoId[0] ;
            if ( GXutil.strcmp(A308TimbradoEstado, httpContext.getMessage( "ACT", "")) == 0 )
            {
               AV10TimbradoNroFactura = (long)(A128TimbradoNroFactura+1) ;
               A128TimbradoNroFactura = (long)(A128TimbradoNroFactura+1) ;
               /* Using cursor P00763 */
               pr_default.execute(1, new Object[] {Long.valueOf(A128TimbradoNroFactura), Long.valueOf(A29TimbradoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Timbrado");
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      if ( GXutil.strcmp(AV11Tipo, httpContext.getMessage( "TIM", "")) == 0 )
      {
         /* Using cursor P00764 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            A308TimbradoEstado = P00764_A308TimbradoEstado[0] ;
            A29TimbradoId = P00764_A29TimbradoId[0] ;
            if ( GXutil.strcmp(A308TimbradoEstado, httpContext.getMessage( "ACT", "")) == 0 )
            {
               AV10TimbradoNroFactura = A29TimbradoId ;
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      if ( GXutil.strcmp(AV11Tipo, httpContext.getMessage( "SE1", "")) == 0 )
      {
         /* Using cursor P00765 */
         pr_default.execute(3);
         while ( (pr_default.getStatus(3) != 101) )
         {
            A308TimbradoEstado = P00765_A308TimbradoEstado[0] ;
            A306TimbradoNroFacturaSerie1 = P00765_A306TimbradoNroFacturaSerie1[0] ;
            A29TimbradoId = P00765_A29TimbradoId[0] ;
            if ( GXutil.strcmp(A308TimbradoEstado, httpContext.getMessage( "ACT", "")) == 0 )
            {
               AV10TimbradoNroFactura = A306TimbradoNroFacturaSerie1 ;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
      }
      if ( GXutil.strcmp(AV11Tipo, httpContext.getMessage( "SE2", "")) == 0 )
      {
         /* Using cursor P00766 */
         pr_default.execute(4);
         while ( (pr_default.getStatus(4) != 101) )
         {
            A308TimbradoEstado = P00766_A308TimbradoEstado[0] ;
            A307TimbradoNroFacturaSerie2 = P00766_A307TimbradoNroFacturaSerie2[0] ;
            A29TimbradoId = P00766_A29TimbradoId[0] ;
            if ( GXutil.strcmp(A308TimbradoEstado, httpContext.getMessage( "ACT", "")) == 0 )
            {
               AV10TimbradoNroFactura = A307TimbradoNroFacturaSerie2 ;
            }
            pr_default.readNext(4);
         }
         pr_default.close(4);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = numeradorfactura.this.AV10TimbradoNroFactura;
      Application.commitDataStores(context, remoteHandle, pr_default, "numeradorfactura");
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
      P00762_A308TimbradoEstado = new String[] {""} ;
      P00762_A128TimbradoNroFactura = new long[1] ;
      P00762_A29TimbradoId = new long[1] ;
      A308TimbradoEstado = "" ;
      P00764_A308TimbradoEstado = new String[] {""} ;
      P00764_A29TimbradoId = new long[1] ;
      P00765_A308TimbradoEstado = new String[] {""} ;
      P00765_A306TimbradoNroFacturaSerie1 = new short[1] ;
      P00765_A29TimbradoId = new long[1] ;
      P00766_A308TimbradoEstado = new String[] {""} ;
      P00766_A307TimbradoNroFacturaSerie2 = new short[1] ;
      P00766_A29TimbradoId = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.numeradorfactura__default(),
         new Object[] {
             new Object[] {
            P00762_A308TimbradoEstado, P00762_A128TimbradoNroFactura, P00762_A29TimbradoId
            }
            , new Object[] {
            }
            , new Object[] {
            P00764_A308TimbradoEstado, P00764_A29TimbradoId
            }
            , new Object[] {
            P00765_A308TimbradoEstado, P00765_A306TimbradoNroFacturaSerie1, P00765_A29TimbradoId
            }
            , new Object[] {
            P00766_A308TimbradoEstado, P00766_A307TimbradoNroFacturaSerie2, P00766_A29TimbradoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A306TimbradoNroFacturaSerie1 ;
   private short A307TimbradoNroFacturaSerie2 ;
   private short Gx_err ;
   private long AV10TimbradoNroFactura ;
   private long A128TimbradoNroFactura ;
   private long A29TimbradoId ;
   private String AV11Tipo ;
   private String scmdbuf ;
   private String A308TimbradoEstado ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00762_A308TimbradoEstado ;
   private long[] P00762_A128TimbradoNroFactura ;
   private long[] P00762_A29TimbradoId ;
   private String[] P00764_A308TimbradoEstado ;
   private long[] P00764_A29TimbradoId ;
   private String[] P00765_A308TimbradoEstado ;
   private short[] P00765_A306TimbradoNroFacturaSerie1 ;
   private long[] P00765_A29TimbradoId ;
   private String[] P00766_A308TimbradoEstado ;
   private short[] P00766_A307TimbradoNroFacturaSerie2 ;
   private long[] P00766_A29TimbradoId ;
}

final  class numeradorfactura__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00762", "SELECT [TimbradoEstado], [TimbradoNroFactura], [TimbradoId] FROM [Timbrado] WITH (UPDLOCK) ORDER BY [TimbradoId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00763", "UPDATE [Timbrado] SET [TimbradoNroFactura]=?  WHERE [TimbradoId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00764", "SELECT [TimbradoEstado], [TimbradoId] FROM [Timbrado] ORDER BY [TimbradoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00765", "SELECT [TimbradoEstado], [TimbradoNroFacturaSerie1], [TimbradoId] FROM [Timbrado] ORDER BY [TimbradoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00766", "SELECT [TimbradoEstado], [TimbradoNroFacturaSerie2], [TimbradoId] FROM [Timbrado] ORDER BY [TimbradoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

