package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarsaldo extends GXProcedure
{
   public validarsaldo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarsaldo.class ), "" );
   }

   public validarsaldo( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( long aP0 ,
                             long[] aP1 ,
                             short[] aP2 )
   {
      validarsaldo.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( long aP0 ,
                        long[] aP1 ,
                        short[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( long aP0 ,
                             long[] aP1 ,
                             short[] aP2 ,
                             String[] aP3 )
   {
      validarsaldo.this.AV9ArticuloId = aP0;
      validarsaldo.this.AV17VentasDetalleTallaID = aP1[0];
      this.aP1 = aP1;
      validarsaldo.this.AV20varDispon = aP2[0];
      this.aP2 = aP2;
      validarsaldo.this.AV21Resp = aP3[0];
      this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21Resp = httpContext.getMessage( "NOk", "") ;
      /* Using cursor P007C2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV9ArticuloId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13ArticuloId = P007C2_A13ArticuloId[0] ;
         A76ArticuloNombre = P007C2_A76ArticuloNombre[0] ;
         AV22ArticuloNombre = A76ArticuloNombre ;
         AV26GXLvl10 = (byte)(0) ;
         /* Using cursor P007C3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A13ArticuloId), Short.valueOf(AV20varDispon), Long.valueOf(AV17VentasDetalleTallaID)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A290ArticuloTallaStock = P007C3_A290ArticuloTallaStock[0] ;
            A286TallaID = P007C3_A286TallaID[0] ;
            A285ArticuloTallaID = P007C3_A285ArticuloTallaID[0] ;
            AV26GXLvl10 = (byte)(1) ;
            AV21Resp = httpContext.getMessage( "OK", "") ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV26GXLvl10 == 0 )
         {
            AV21Resp = httpContext.getMessage( "NOK", "") + AV22ArticuloNombre ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = validarsaldo.this.AV17VentasDetalleTallaID;
      this.aP2[0] = validarsaldo.this.AV20varDispon;
      this.aP3[0] = validarsaldo.this.AV21Resp;
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
      P007C2_A13ArticuloId = new long[1] ;
      P007C2_A76ArticuloNombre = new String[] {""} ;
      A76ArticuloNombre = "" ;
      AV22ArticuloNombre = "" ;
      P007C3_A13ArticuloId = new long[1] ;
      P007C3_A290ArticuloTallaStock = new long[1] ;
      P007C3_A286TallaID = new long[1] ;
      P007C3_A285ArticuloTallaID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.validarsaldo__default(),
         new Object[] {
             new Object[] {
            P007C2_A13ArticuloId, P007C2_A76ArticuloNombre
            }
            , new Object[] {
            P007C3_A13ArticuloId, P007C3_A290ArticuloTallaStock, P007C3_A286TallaID, P007C3_A285ArticuloTallaID
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV26GXLvl10 ;
   private short AV20varDispon ;
   private short Gx_err ;
   private long AV9ArticuloId ;
   private long AV17VentasDetalleTallaID ;
   private long A13ArticuloId ;
   private long A290ArticuloTallaStock ;
   private long A286TallaID ;
   private long A285ArticuloTallaID ;
   private String AV21Resp ;
   private String scmdbuf ;
   private String A76ArticuloNombre ;
   private String AV22ArticuloNombre ;
   private String[] aP3 ;
   private long[] aP1 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private long[] P007C2_A13ArticuloId ;
   private String[] P007C2_A76ArticuloNombre ;
   private long[] P007C3_A13ArticuloId ;
   private long[] P007C3_A290ArticuloTallaStock ;
   private long[] P007C3_A286TallaID ;
   private long[] P007C3_A285ArticuloTallaID ;
}

final  class validarsaldo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007C2", "SELECT [ArticuloId], [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007C3", "SELECT [ArticuloId], [ArticuloTallaStock], [TallaID], [ArticuloTallaID] FROM [ArticuloTalla] WHERE ([ArticuloId] = ?) AND ([ArticuloTallaStock] >= ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 1 :
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

