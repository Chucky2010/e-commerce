package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinsertarcalificacion extends GXProcedure
{
   public prcinsertarcalificacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinsertarcalificacion.class ), "" );
   }

   public prcinsertarcalificacion( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short[] aP0 )
   {
      prcinsertarcalificacion.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short[] aP0 ,
                             String[] aP1 )
   {
      prcinsertarcalificacion.this.AV9Calificacion = aP0[0];
      this.aP0 = aP0;
      prcinsertarcalificacion.this.AV10Comentario = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8CalificacionId ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "Calificacion", ""), GXv_int2) ;
      prcinsertarcalificacion.this.GXt_int1 = GXv_int2[0] ;
      AV8CalificacionId = GXt_int1 ;
      AV11GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV12UserName = AV11GAMUser.getgxTv_SdtGAMUser_Name() ;
      /*
         INSERT RECORD ON TABLE Calificacion

      */
      A298CalificacionId = AV8CalificacionId ;
      A299CalificacionNro = AV9Calificacion ;
      A300CalificacionDesc = AV10Comentario ;
      A301CalificacionUsuario = AV12UserName ;
      A302CalificacionFechaHora = GXutil.serverNow( context, remoteHandle, pr_default) ;
      /* Using cursor P00732 */
      pr_default.execute(0, new Object[] {Long.valueOf(A298CalificacionId), Short.valueOf(A299CalificacionNro), A300CalificacionDesc, A301CalificacionUsuario, A302CalificacionFechaHora});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Calificacion");
      if ( (pr_default.getStatus(0) == 1) )
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
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcinsertarcalificacion.this.AV9Calificacion;
      this.aP1[0] = prcinsertarcalificacion.this.AV10Comentario;
      Application.commitDataStores(context, remoteHandle, pr_default, "prcinsertarcalificacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new long[1] ;
      AV11GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV12UserName = "" ;
      A300CalificacionDesc = "" ;
      A301CalificacionUsuario = "" ;
      A302CalificacionFechaHora = GXutil.resetTime( GXutil.nullDate() );
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.prcinsertarcalificacion__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9Calificacion ;
   private short A299CalificacionNro ;
   private short Gx_err ;
   private int GX_INS59 ;
   private long AV8CalificacionId ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A298CalificacionId ;
   private String Gx_emsg ;
   private java.util.Date A302CalificacionFechaHora ;
   private String AV10Comentario ;
   private String AV12UserName ;
   private String A300CalificacionDesc ;
   private String A301CalificacionUsuario ;
   private String[] aP1 ;
   private short[] aP0 ;
   private IDataStoreProvider pr_default ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV11GAMUser ;
}

final  class prcinsertarcalificacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00732", "INSERT INTO [Calificacion]([CalificacionId], [CalificacionNro], [CalificacionDesc], [CalificacionUsuario], [CalificacionFechaHora]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setVarchar(3, (String)parms[2], 256, false);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setDateTime(5, (java.util.Date)parms[4], false);
               return;
      }
   }

}

