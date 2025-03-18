package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class generaregreso extends GXProcedure
{
   public generaregreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( generaregreso.class ), "" );
   }

   public generaregreso( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( )
   {
      generaregreso.this.aP0 = new long[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( long[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long[] aP0 )
   {
      generaregreso.this.AV15MovimientoCajaId = aP0[0];
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
      /* Using cursor P007A2 */
      pr_default.execute(0, new Object[] {AV18UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A255CajaAsiganacion = P007A2_A255CajaAsiganacion[0] ;
         A25CajaId = P007A2_A25CajaId[0] ;
         AV19CajaId = A25CajaId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P007A3 */
      pr_default.execute(1, new Object[] {AV18UserName});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A254CajeroUsuarioID = P007A3_A254CajeroUsuarioID[0] ;
         A26CajeroId = P007A3_A26CajeroId[0] ;
         AV20CajeroId = A26CajeroId ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      GXt_int1 = AV15MovimientoCajaId ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "MovimientoCaja", ""), GXv_int2) ;
      generaregreso.this.GXt_int1 = GXv_int2[0] ;
      AV15MovimientoCajaId = GXt_int1 ;
      AV29Contador = (short)(1) ;
      /* Using cursor P007A4 */
      pr_default.execute(2, new Object[] {AV18UserName});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A267MovimientoCajaEstado = P007A4_A267MovimientoCajaEstado[0] ;
         A256MovimientoCajaAsignacion = P007A4_A256MovimientoCajaAsignacion[0] ;
         A118MovimientoCajaEgreso = P007A4_A118MovimientoCajaEgreso[0] ;
         A117MovimientoCajaIngreso = P007A4_A117MovimientoCajaIngreso[0] ;
         A119MovimientoCajaSaldo = P007A4_A119MovimientoCajaSaldo[0] ;
         A27MovimientoCajaId = P007A4_A27MovimientoCajaId[0] ;
         if ( GXutil.strcmp(A267MovimientoCajaEstado, httpContext.getMessage( "ACT", "")) == 0 )
         {
            if ( AV29Contador == 1 )
            {
               if ( ( A117MovimientoCajaIngreso.doubleValue() > 0 ) && ( A118MovimientoCajaEgreso.doubleValue() == 0 ) )
               {
                  A119MovimientoCajaSaldo = A117MovimientoCajaIngreso ;
               }
               AV28MovimientoCajaIngreso = AV28MovimientoCajaIngreso.add(A117MovimientoCajaIngreso) ;
               AV26MovimientoCajaEgreso = AV26MovimientoCajaEgreso.add(A118MovimientoCajaEgreso) ;
               AV29Contador = (short)(AV29Contador+1) ;
            }
            else
            {
               AV28MovimientoCajaIngreso = AV28MovimientoCajaIngreso.add(A117MovimientoCajaIngreso) ;
               AV26MovimientoCajaEgreso = AV26MovimientoCajaEgreso.add(A118MovimientoCajaEgreso) ;
               if ( DecimalUtil.compareTo(AV26MovimientoCajaEgreso, AV28MovimientoCajaIngreso) > 0 )
               {
                  httpContext.GX_msglist.addItem(httpContext.getMessage( "errooooor", ""));
               }
               else
               {
                  A119MovimientoCajaSaldo = AV28MovimientoCajaIngreso.subtract(AV26MovimientoCajaEgreso) ;
                  AV29Contador = (short)(AV29Contador+1) ;
               }
            }
            /* Using cursor P007A5 */
            pr_default.execute(3, new Object[] {A119MovimientoCajaSaldo, Long.valueOf(A27MovimientoCajaId)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("MovimientoCaja");
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = generaregreso.this.AV15MovimientoCajaId;
      Application.commitDataStores(context, remoteHandle, pr_default, "generaregreso");
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
      P007A2_A255CajaAsiganacion = new String[] {""} ;
      P007A2_A25CajaId = new long[1] ;
      A255CajaAsiganacion = "" ;
      P007A3_A254CajeroUsuarioID = new String[] {""} ;
      P007A3_A26CajeroId = new long[1] ;
      A254CajeroUsuarioID = "" ;
      GXv_int2 = new long[1] ;
      P007A4_A267MovimientoCajaEstado = new String[] {""} ;
      P007A4_A256MovimientoCajaAsignacion = new String[] {""} ;
      P007A4_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007A4_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007A4_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007A4_A27MovimientoCajaId = new long[1] ;
      A267MovimientoCajaEstado = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      AV28MovimientoCajaIngreso = DecimalUtil.ZERO ;
      AV26MovimientoCajaEgreso = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.generaregreso__default(),
         new Object[] {
             new Object[] {
            P007A2_A255CajaAsiganacion, P007A2_A25CajaId
            }
            , new Object[] {
            P007A3_A254CajeroUsuarioID, P007A3_A26CajeroId
            }
            , new Object[] {
            P007A4_A267MovimientoCajaEstado, P007A4_A256MovimientoCajaAsignacion, P007A4_A118MovimientoCajaEgreso, P007A4_A117MovimientoCajaIngreso, P007A4_A119MovimientoCajaSaldo, P007A4_A27MovimientoCajaId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV29Contador ;
   private short Gx_err ;
   private long AV15MovimientoCajaId ;
   private long A25CajaId ;
   private long AV19CajaId ;
   private long A26CajeroId ;
   private long AV20CajeroId ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A27MovimientoCajaId ;
   private java.math.BigDecimal A118MovimientoCajaEgreso ;
   private java.math.BigDecimal A117MovimientoCajaIngreso ;
   private java.math.BigDecimal A119MovimientoCajaSaldo ;
   private java.math.BigDecimal AV28MovimientoCajaIngreso ;
   private java.math.BigDecimal AV26MovimientoCajaEgreso ;
   private String AV18UserName ;
   private String scmdbuf ;
   private String A255CajaAsiganacion ;
   private String A254CajeroUsuarioID ;
   private String A267MovimientoCajaEstado ;
   private String A256MovimientoCajaAsignacion ;
   private long[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P007A2_A255CajaAsiganacion ;
   private long[] P007A2_A25CajaId ;
   private String[] P007A3_A254CajeroUsuarioID ;
   private long[] P007A3_A26CajeroId ;
   private String[] P007A4_A267MovimientoCajaEstado ;
   private String[] P007A4_A256MovimientoCajaAsignacion ;
   private java.math.BigDecimal[] P007A4_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] P007A4_A117MovimientoCajaIngreso ;
   private java.math.BigDecimal[] P007A4_A119MovimientoCajaSaldo ;
   private long[] P007A4_A27MovimientoCajaId ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV17GAMUser ;
}

final  class generaregreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007A2", "SELECT [CajaAsiganacion], [CajaId] FROM [Caja] WHERE [CajaAsiganacion] = ? ORDER BY [CajaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007A3", "SELECT [CajeroUsuarioID], [CajeroId] FROM [Cajero] WHERE [CajeroUsuarioID] = ? ORDER BY [CajeroId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007A4", "SELECT [MovimientoCajaEstado], [MovimientoCajaAsignacion], [MovimientoCajaEgreso], [MovimientoCajaIngreso], [MovimientoCajaSaldo], [MovimientoCajaId] FROM [MovimientoCaja] WITH (UPDLOCK) WHERE [MovimientoCajaAsignacion] = ? ORDER BY [MovimientoCajaId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007A5", "UPDATE [MovimientoCaja] SET [MovimientoCajaSaldo]=?  WHERE [MovimientoCajaId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((long[]) buf[5])[0] = rslt.getLong(6);
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
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

