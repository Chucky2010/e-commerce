package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarcajaabierta extends GXProcedure
{
   public validarcajaabierta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarcajaabierta.class ), "" );
   }

   public validarcajaabierta( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      validarcajaabierta.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      validarcajaabierta.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV9UserName = AV8GAMUser.getgxTv_SdtGAMUser_Name() ;
      AV10CajaEstado = httpContext.getMessage( "LIBRE", "") ;
      AV13GXLvl5 = (byte)(0) ;
      /* Using cursor P000R2 */
      pr_default.execute(0, new Object[] {AV9UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A255CajaAsiganacion = P000R2_A255CajaAsiganacion[0] ;
         A253CajaEstado = P000R2_A253CajaEstado[0] ;
         A25CajaId = P000R2_A25CajaId[0] ;
         AV13GXLvl5 = (byte)(1) ;
         AV10CajaEstado = A253CajaEstado ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV13GXLvl5 == 0 )
      {
         AV10CajaEstado = httpContext.getMessage( "LIBRE", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = validarcajaabierta.this.AV10CajaEstado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10CajaEstado = "" ;
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV9UserName = "" ;
      scmdbuf = "" ;
      P000R2_A255CajaAsiganacion = new String[] {""} ;
      P000R2_A253CajaEstado = new String[] {""} ;
      P000R2_A25CajaId = new long[1] ;
      A255CajaAsiganacion = "" ;
      A253CajaEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.validarcajaabierta__default(),
         new Object[] {
             new Object[] {
            P000R2_A255CajaAsiganacion, P000R2_A253CajaEstado, P000R2_A25CajaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl5 ;
   private short Gx_err ;
   private long A25CajaId ;
   private String AV10CajaEstado ;
   private String AV9UserName ;
   private String scmdbuf ;
   private String A255CajaAsiganacion ;
   private String A253CajaEstado ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P000R2_A255CajaAsiganacion ;
   private String[] P000R2_A253CajaEstado ;
   private long[] P000R2_A25CajaId ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV8GAMUser ;
}

final  class validarcajaabierta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000R2", "SELECT [CajaAsiganacion], [CajaEstado], [CajaId] FROM [Caja] WHERE [CajaAsiganacion] = ? ORDER BY [CajaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

