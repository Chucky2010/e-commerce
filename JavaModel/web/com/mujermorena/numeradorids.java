package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class numeradorids extends GXProcedure
{
   public numeradorids( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( numeradorids.class ), "" );
   }

   public numeradorids( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( String aP0 )
   {
      numeradorids.this.aP1 = new long[] {0};
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
      numeradorids.this.AV8NumeradorID = aP0;
      numeradorids.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9NumeradorUltimoNRO = 1 ;
      AV12GXLvl3 = (byte)(0) ;
      /* Using cursor P000O2 */
      pr_default.execute(0, new Object[] {AV8NumeradorID});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A49NumeradorID = P000O2_A49NumeradorID[0] ;
         A232NumeradorUltimoNRO = P000O2_A232NumeradorUltimoNRO[0] ;
         AV12GXLvl3 = (byte)(1) ;
         AV9NumeradorUltimoNRO = (long)(A232NumeradorUltimoNRO+1) ;
         A232NumeradorUltimoNRO = AV9NumeradorUltimoNRO ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P000O3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A232NumeradorUltimoNRO), A49NumeradorID});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Numerador");
         if (true) break;
         /* Using cursor P000O4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A232NumeradorUltimoNRO), A49NumeradorID});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Numerador");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV12GXLvl3 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Numerador

         */
         A49NumeradorID = AV8NumeradorID ;
         A232NumeradorUltimoNRO = AV9NumeradorUltimoNRO ;
         /* Using cursor P000O5 */
         pr_default.execute(3, new Object[] {A49NumeradorID, Long.valueOf(A232NumeradorUltimoNRO)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Numerador");
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
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = numeradorids.this.AV9NumeradorUltimoNRO;
      Application.commitDataStores(context, remoteHandle, pr_default, "numeradorids");
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
      P000O2_A49NumeradorID = new String[] {""} ;
      P000O2_A232NumeradorUltimoNRO = new long[1] ;
      A49NumeradorID = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.numeradorids__default(),
         new Object[] {
             new Object[] {
            P000O2_A49NumeradorID, P000O2_A232NumeradorUltimoNRO
            }
            , new Object[] {
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

   private byte AV12GXLvl3 ;
   private short Gx_err ;
   private int GX_INS46 ;
   private long AV9NumeradorUltimoNRO ;
   private long A232NumeradorUltimoNRO ;
   private String AV8NumeradorID ;
   private String scmdbuf ;
   private String A49NumeradorID ;
   private String Gx_emsg ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P000O2_A49NumeradorID ;
   private long[] P000O2_A232NumeradorUltimoNRO ;
}

final  class numeradorids__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000O2", "SELECT TOP 1 [NumeradorID], [NumeradorUltimoNRO] FROM [Numerador] WITH (UPDLOCK) WHERE [NumeradorID] = ? ORDER BY [NumeradorID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P000O3", "UPDATE [Numerador] SET [NumeradorUltimoNRO]=?  WHERE [NumeradorID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000O4", "UPDATE [Numerador] SET [NumeradorUltimoNRO]=?  WHERE [NumeradorID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000O5", "INSERT INTO [Numerador]([NumeradorID], [NumeradorUltimoNRO]) VALUES(?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
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
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 56);
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 56);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 56);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

