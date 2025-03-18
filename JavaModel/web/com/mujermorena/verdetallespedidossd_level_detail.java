package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verdetallespedidossd_level_detail extends GXProcedure
{
   public verdetallespedidossd_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verdetallespedidossd_level_detail.class ), "" );
   }

   public verdetallespedidossd_level_detail( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt executeUdp( long aP0 ,
                                                                              int aP1 )
   {
      verdetallespedidossd_level_detail.this.aP2 = new com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt[] {new com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt[] aP2 )
   {
      verdetallespedidossd_level_detail.this.AV8PedidosID = aP0;
      verdetallespedidossd_level_detail.this.AV17gxid = aP1;
      verdetallespedidossd_level_detail.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV17gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         /* Using cursor P00002 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV8PedidosID)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A51PedidosID = P00002_A51PedidosID[0] ;
            A246PedidosFecha = P00002_A246PedidosFecha[0] ;
            A9TipoPagoId = P00002_A9TipoPagoId[0] ;
            AV13PedidosFecha = A246PedidosFecha ;
            AV14TipoPagoId = A9TipoPagoId ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         Gxwebsession.setValue(Gxids+"gxvar_Pedidosdetalleid", GXutil.str( AV7PedidosDetalleID, 11, 0));
         Gxwebsession.setValue(Gxids+"gxvar_Articuloid", GXutil.str( AV9ArticuloId, 11, 0));
         Gxwebsession.setValue(Gxids+"gxvar_Articulonombre", AV10ArticuloNombre);
         Gxwebsession.setValue(Gxids+"gxvar_Pedidosdetalletallaid", GXutil.str( AV11PedidosDetalleTallaID, 11, 0));
         Gxwebsession.setValue(Gxids+"gxvar_Pedidosdetallecantidad", GXutil.str( AV12PedidosDetalleCantidad, 5, 0));
         Gxwebsession.setValue(Gxids+"gxvar_Pedidosfecha", localUtil.dtoc( AV13PedidosFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"));
         Gxwebsession.setValue(Gxids+"gxvar_Tipopagoid", GXutil.str( AV14TipoPagoId, 11, 0));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV13PedidosFecha = localUtil.ctod( Gxwebsession.getValue(Gxids+"gxvar_Pedidosfecha"), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         AV14TipoPagoId = GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Tipopagoid")) ;
      }
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosid( AV8PedidosID );
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosfecha( AV13PedidosFecha );
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Tipopagoid( AV14TipoPagoId );
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante( AV15PedidosImagenComprobante );
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidosimagencomprobante_gxi( AV26Pedidosimagencomprobante_GXI );
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Pedidoscomprobanteobs( AV16PedidosComprobanteObs );
      Gxval_tipopagoid = AV14TipoPagoId ;
      /* Execute user subroutine: Gxdesc_Tipopagoid */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt.setgxTv_SdtVerDetallesPedidosSD_Level_DetailSdt_Gxdesc_tipopagoid( Gxdesc_tipopagoid );
      cleanup();
   }

   public void S111( )
   {
      /* Gxdesc_Tipopagoid Routine */
      returnInSub = false ;
      /* Using cursor P00003 */
      pr_default.execute(1, new Object[] {Long.valueOf(Gxval_tipopagoid)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A9TipoPagoId = P00003_A9TipoPagoId[0] ;
         A71TipoPagoNombre = P00003_A71TipoPagoNombre[0] ;
         Gxdesc_tipopagoid = A71TipoPagoNombre ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP2[0] = verdetallespedidossd_level_detail.this.AV22GXM1VerDetallesPedidosSD_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22GXM1VerDetallesPedidosSD_Level_DetailSdt = new com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      scmdbuf = "" ;
      P00002_A51PedidosID = new long[1] ;
      P00002_A246PedidosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00002_A9TipoPagoId = new long[1] ;
      A246PedidosFecha = GXutil.nullDate() ;
      AV13PedidosFecha = GXutil.nullDate() ;
      AV10ArticuloNombre = "" ;
      AV15PedidosImagenComprobante = "" ;
      AV26Pedidosimagencomprobante_GXI = "" ;
      AV16PedidosComprobanteObs = "" ;
      Gxdesc_tipopagoid = "" ;
      P00003_A9TipoPagoId = new long[1] ;
      P00003_A71TipoPagoNombre = new String[] {""} ;
      A71TipoPagoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.verdetallespedidossd_level_detail__default(),
         new Object[] {
             new Object[] {
            P00002_A51PedidosID, P00002_A246PedidosFecha, P00002_A9TipoPagoId
            }
            , new Object[] {
            P00003_A9TipoPagoId, P00003_A71TipoPagoNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17gxid ;
   private int AV12PedidosDetalleCantidad ;
   private long AV8PedidosID ;
   private long A51PedidosID ;
   private long A9TipoPagoId ;
   private long AV14TipoPagoId ;
   private long AV7PedidosDetalleID ;
   private long AV9ArticuloId ;
   private long AV11PedidosDetalleTallaID ;
   private long Gxval_tipopagoid ;
   private String Gxids ;
   private String scmdbuf ;
   private String AV10ArticuloNombre ;
   private String A71TipoPagoNombre ;
   private java.util.Date A246PedidosFecha ;
   private java.util.Date AV13PedidosFecha ;
   private boolean returnInSub ;
   private String AV26Pedidosimagencomprobante_GXI ;
   private String AV16PedidosComprobanteObs ;
   private String Gxdesc_tipopagoid ;
   private String AV15PedidosImagenComprobante ;
   private com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt[] aP2 ;
   private IDataStoreProvider pr_default ;
   private long[] P00002_A51PedidosID ;
   private java.util.Date[] P00002_A246PedidosFecha ;
   private long[] P00002_A9TipoPagoId ;
   private long[] P00003_A9TipoPagoId ;
   private String[] P00003_A71TipoPagoNombre ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private com.mujermorena.SdtVerDetallesPedidosSD_Level_DetailSdt AV22GXM1VerDetallesPedidosSD_Level_DetailSdt ;
}

final  class verdetallespedidossd_level_detail__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00002", "SELECT [PedidosID], [PedidosFecha], [TipoPagoId] FROM [Pedidos] WHERE [PedidosID] = ? ORDER BY [PedidosID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00003", "SELECT TOP 1 [TipoPagoId], [TipoPagoNombre] FROM [TipoPago] WHERE [TipoPagoId] = ? ORDER BY [TipoPagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
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
               return;
      }
   }

}

