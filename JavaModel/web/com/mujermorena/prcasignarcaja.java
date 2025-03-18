package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcasignarcaja extends GXProcedure
{
   public prcasignarcaja( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcasignarcaja.class ), "" );
   }

   public prcasignarcaja( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long aP0 )
   {
      prcasignarcaja.this.AV11CajaId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV9UserName = AV8GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P00552 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV11CajaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A25CajaId = P00552_A25CajaId[0] ;
         A253CajaEstado = P00552_A253CajaEstado[0] ;
         A255CajaAsiganacion = P00552_A255CajaAsiganacion[0] ;
         A253CajaEstado = httpContext.getMessage( "ASIGNADO", "") ;
         A255CajaAsiganacion = AV9UserName ;
         /* Using cursor P00553 */
         pr_default.execute(1, new Object[] {A253CajaEstado, A255CajaAsiganacion, Long.valueOf(A25CajaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Caja");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "prcasignarcaja");
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
      P00552_A25CajaId = new long[1] ;
      P00552_A253CajaEstado = new String[] {""} ;
      P00552_A255CajaAsiganacion = new String[] {""} ;
      A253CajaEstado = "" ;
      A255CajaAsiganacion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.prcasignarcaja__default(),
         new Object[] {
             new Object[] {
            P00552_A25CajaId, P00552_A253CajaEstado, P00552_A255CajaAsiganacion
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV11CajaId ;
   private long A25CajaId ;
   private String AV9UserName ;
   private String scmdbuf ;
   private String A253CajaEstado ;
   private String A255CajaAsiganacion ;
   private IDataStoreProvider pr_default ;
   private long[] P00552_A25CajaId ;
   private String[] P00552_A253CajaEstado ;
   private String[] P00552_A255CajaAsiganacion ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV8GAMUser ;
}

final  class prcasignarcaja__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00552", "SELECT [CajaId], [CajaEstado], [CajaAsiganacion] FROM [Caja] WITH (UPDLOCK) WHERE [CajaId] = ? ORDER BY [CajaId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00553", "UPDATE [Caja] SET [CajaEstado]=?, [CajaAsiganacion]=?  WHERE [CajaId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

