package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cajaasignada extends GXProcedure
{
   public cajaasignada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cajaasignada.class ), "" );
   }

   public cajaasignada( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      cajaasignada.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      cajaasignada.this.AV11CajaAsiganacion = aP0;
      cajaasignada.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Estado = httpContext.getMessage( "S", "") ;
      /* Using cursor P007D2 */
      pr_default.execute(0, new Object[] {AV11CajaAsiganacion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A255CajaAsiganacion = P007D2_A255CajaAsiganacion[0] ;
         A25CajaId = P007D2_A25CajaId[0] ;
         AV9Estado = httpContext.getMessage( "N", "") ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = cajaasignada.this.AV9Estado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Estado = "" ;
      scmdbuf = "" ;
      P007D2_A255CajaAsiganacion = new String[] {""} ;
      P007D2_A25CajaId = new long[1] ;
      A255CajaAsiganacion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.cajaasignada__default(),
         new Object[] {
             new Object[] {
            P007D2_A255CajaAsiganacion, P007D2_A25CajaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A25CajaId ;
   private String AV11CajaAsiganacion ;
   private String AV9Estado ;
   private String scmdbuf ;
   private String A255CajaAsiganacion ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P007D2_A255CajaAsiganacion ;
   private long[] P007D2_A25CajaId ;
}

final  class cajaasignada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007D2", "SELECT [CajaAsiganacion], [CajaId] FROM [Caja] WHERE [CajaAsiganacion] = ? ORDER BY [CajaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

