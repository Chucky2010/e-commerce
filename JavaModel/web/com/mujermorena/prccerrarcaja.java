package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccerrarcaja extends GXProcedure
{
   public prccerrarcaja( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccerrarcaja.class ), "" );
   }

   public prccerrarcaja( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV9UserName = AV8GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P00562 */
      pr_default.execute(0, new Object[] {AV9UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A255CajaAsiganacion = P00562_A255CajaAsiganacion[0] ;
         A253CajaEstado = P00562_A253CajaEstado[0] ;
         A25CajaId = P00562_A25CajaId[0] ;
         AV11CajaId = A25CajaId ;
         A253CajaEstado = httpContext.getMessage( "LIBRE", "") ;
         A255CajaAsiganacion = "" ;
         /* Using cursor P00563 */
         pr_default.execute(1, new Object[] {A255CajaAsiganacion, A253CajaEstado, Long.valueOf(A25CajaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Caja");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P00564 */
      pr_default.execute(2, new Object[] {AV9UserName});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A267MovimientoCajaEstado = P00564_A267MovimientoCajaEstado[0] ;
         A256MovimientoCajaAsignacion = P00564_A256MovimientoCajaAsignacion[0] ;
         A268MovimientoCajaFechaCierre = P00564_A268MovimientoCajaFechaCierre[0] ;
         A27MovimientoCajaId = P00564_A27MovimientoCajaId[0] ;
         if ( GXutil.strcmp(A267MovimientoCajaEstado, httpContext.getMessage( "ACT", "")) == 0 )
         {
            A268MovimientoCajaFechaCierre = GXutil.serverDate( context, remoteHandle, pr_default) ;
            A267MovimientoCajaEstado = httpContext.getMessage( "CER", "") ;
            /* Using cursor P00565 */
            pr_default.execute(3, new Object[] {A267MovimientoCajaEstado, A268MovimientoCajaFechaCierre, Long.valueOf(A27MovimientoCajaId)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("MovimientoCaja");
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "prccerrarcaja");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV9UserName = "" ;
      scmdbuf = "" ;
      P00562_A255CajaAsiganacion = new String[] {""} ;
      P00562_A253CajaEstado = new String[] {""} ;
      P00562_A25CajaId = new long[1] ;
      A255CajaAsiganacion = "" ;
      A253CajaEstado = "" ;
      P00564_A267MovimientoCajaEstado = new String[] {""} ;
      P00564_A256MovimientoCajaAsignacion = new String[] {""} ;
      P00564_A268MovimientoCajaFechaCierre = new java.util.Date[] {GXutil.nullDate()} ;
      P00564_A27MovimientoCajaId = new long[1] ;
      A267MovimientoCajaEstado = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A268MovimientoCajaFechaCierre = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.prccerrarcaja__default(),
         new Object[] {
             new Object[] {
            P00562_A255CajaAsiganacion, P00562_A253CajaEstado, P00562_A25CajaId
            }
            , new Object[] {
            }
            , new Object[] {
            P00564_A267MovimientoCajaEstado, P00564_A256MovimientoCajaAsignacion, P00564_A268MovimientoCajaFechaCierre, P00564_A27MovimientoCajaId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A25CajaId ;
   private long AV11CajaId ;
   private long A27MovimientoCajaId ;
   private String AV9UserName ;
   private String scmdbuf ;
   private String A255CajaAsiganacion ;
   private String A253CajaEstado ;
   private String A267MovimientoCajaEstado ;
   private String A256MovimientoCajaAsignacion ;
   private java.util.Date A268MovimientoCajaFechaCierre ;
   private IDataStoreProvider pr_default ;
   private String[] P00562_A255CajaAsiganacion ;
   private String[] P00562_A253CajaEstado ;
   private long[] P00562_A25CajaId ;
   private String[] P00564_A267MovimientoCajaEstado ;
   private String[] P00564_A256MovimientoCajaAsignacion ;
   private java.util.Date[] P00564_A268MovimientoCajaFechaCierre ;
   private long[] P00564_A27MovimientoCajaId ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV8GAMUser ;
}

final  class prccerrarcaja__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00562", "SELECT [CajaAsiganacion], [CajaEstado], [CajaId] FROM [Caja] WITH (UPDLOCK) WHERE [CajaAsiganacion] = ? ORDER BY [CajaId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00563", "UPDATE [Caja] SET [CajaAsiganacion]=?, [CajaEstado]=?  WHERE [CajaId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00564", "SELECT [MovimientoCajaEstado], [MovimientoCajaAsignacion], [MovimientoCajaFechaCierre], [MovimientoCajaId] FROM [MovimientoCaja] WITH (UPDLOCK) WHERE [MovimientoCajaAsignacion] = ? ORDER BY [MovimientoCajaId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00565", "UPDATE [MovimientoCaja] SET [MovimientoCajaEstado]=?, [MovimientoCajaFechaCierre]=?  WHERE [MovimientoCajaId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
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
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

