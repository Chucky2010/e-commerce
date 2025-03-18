package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class saldoactualcaja extends GXProcedure
{
   public saldoactualcaja( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( saldoactualcaja.class ), "" );
   }

   public saldoactualcaja( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( )
   {
      saldoactualcaja.this.aP0 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( java.math.BigDecimal[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( java.math.BigDecimal[] aP0 )
   {
      saldoactualcaja.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV18UserName = AV17GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P007B2 */
      pr_default.execute(0, new Object[] {AV18UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A267MovimientoCajaEstado = P007B2_A267MovimientoCajaEstado[0] ;
         A256MovimientoCajaAsignacion = P007B2_A256MovimientoCajaAsignacion[0] ;
         A119MovimientoCajaSaldo = P007B2_A119MovimientoCajaSaldo[0] ;
         A27MovimientoCajaId = P007B2_A27MovimientoCajaId[0] ;
         if ( GXutil.strcmp(A267MovimientoCajaEstado, httpContext.getMessage( "ACT", "")) == 0 )
         {
            AV26MovimientoCajaSaldo = A119MovimientoCajaSaldo ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = saldoactualcaja.this.AV26MovimientoCajaSaldo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26MovimientoCajaSaldo = DecimalUtil.ZERO ;
      AV17GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV18UserName = "" ;
      scmdbuf = "" ;
      P007B2_A267MovimientoCajaEstado = new String[] {""} ;
      P007B2_A256MovimientoCajaAsignacion = new String[] {""} ;
      P007B2_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007B2_A27MovimientoCajaId = new long[1] ;
      A267MovimientoCajaEstado = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.saldoactualcaja__default(),
         new Object[] {
             new Object[] {
            P007B2_A267MovimientoCajaEstado, P007B2_A256MovimientoCajaAsignacion, P007B2_A119MovimientoCajaSaldo, P007B2_A27MovimientoCajaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A27MovimientoCajaId ;
   private java.math.BigDecimal AV26MovimientoCajaSaldo ;
   private java.math.BigDecimal A119MovimientoCajaSaldo ;
   private String AV18UserName ;
   private String scmdbuf ;
   private String A267MovimientoCajaEstado ;
   private String A256MovimientoCajaAsignacion ;
   private java.math.BigDecimal[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P007B2_A267MovimientoCajaEstado ;
   private String[] P007B2_A256MovimientoCajaAsignacion ;
   private java.math.BigDecimal[] P007B2_A119MovimientoCajaSaldo ;
   private long[] P007B2_A27MovimientoCajaId ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV17GAMUser ;
}

final  class saldoactualcaja__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007B2", "SELECT [MovimientoCajaEstado], [MovimientoCajaAsignacion], [MovimientoCajaSaldo], [MovimientoCajaId] FROM [MovimientoCaja] WHERE [MovimientoCajaAsignacion] = ? ORDER BY [MovimientoCajaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

