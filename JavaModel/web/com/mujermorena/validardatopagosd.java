package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validardatopagosd extends GXProcedure
{
   public validardatopagosd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validardatopagosd.class ), "" );
   }

   public validardatopagosd( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( long aP0 )
   {
      validardatopagosd.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( long aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( long aP0 ,
                             String[] aP1 )
   {
      validardatopagosd.this.AV8TipoPagoId = aP0;
      validardatopagosd.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11Dato = "" ;
      /* Using cursor P007N2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8TipoPagoId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A9TipoPagoId = P007N2_A9TipoPagoId[0] ;
         A297TipoPagoDato = P007N2_A297TipoPagoDato[0] ;
         AV11Dato = A297TipoPagoDato ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = validardatopagosd.this.AV11Dato;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Dato = "" ;
      scmdbuf = "" ;
      P007N2_A9TipoPagoId = new long[1] ;
      P007N2_A297TipoPagoDato = new String[] {""} ;
      A297TipoPagoDato = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.validardatopagosd__default(),
         new Object[] {
             new Object[] {
            P007N2_A9TipoPagoId, P007N2_A297TipoPagoDato
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV8TipoPagoId ;
   private long A9TipoPagoId ;
   private String AV11Dato ;
   private String scmdbuf ;
   private String A297TipoPagoDato ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P007N2_A9TipoPagoId ;
   private String[] P007N2_A297TipoPagoDato ;
}

final  class validardatopagosd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007N2", "SELECT TOP 1 [TipoPagoId], [TipoPagoDato] FROM [TipoPago] WHERE [TipoPagoId] = ? ORDER BY [TipoPagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
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
      }
   }

}

