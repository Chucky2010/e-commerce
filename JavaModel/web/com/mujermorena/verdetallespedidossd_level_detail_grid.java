package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verdetallespedidossd_level_detail_grid extends GXProcedure
{
   public verdetallespedidossd_level_detail_grid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verdetallespedidossd_level_detail_grid.class ), "" );
   }

   public verdetallespedidossd_level_detail_grid( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> executeUdp( long aP0 ,
                                                                                                          long aP1 ,
                                                                                                          long aP2 ,
                                                                                                          int aP3 )
   {
      verdetallespedidossd_level_detail_grid.this.aP4 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( long aP0 ,
                        long aP1 ,
                        long aP2 ,
                        int aP3 ,
                        GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( long aP0 ,
                             long aP1 ,
                             long aP2 ,
                             int aP3 ,
                             GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item>[] aP4 )
   {
      verdetallespedidossd_level_detail_grid.this.AV8PedidosID = aP0;
      verdetallespedidossd_level_detail_grid.this.AV20start = aP1;
      verdetallespedidossd_level_detail_grid.this.AV21count = aP2;
      verdetallespedidossd_level_detail_grid.this.AV17gxid = aP3;
      verdetallespedidossd_level_detail_grid.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV17gxid, 8, 0) ;
      AV7PedidosDetalleID = GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Pedidosdetalleid")) ;
      AV9ArticuloId = GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Articuloid")) ;
      AV10ArticuloNombre = Gxwebsession.getValue(Gxids+"gxvar_Articulonombre") ;
      AV11PedidosDetalleTallaID = GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Pedidosdetalletallaid")) ;
      AV12PedidosDetalleCantidad = (int)(GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Pedidosdetallecantidad"))) ;
      AV22GXV1SkipCount = (int)(-(AV20start)) ;
      AV22GXV1SkipCount = (int)(AV22GXV1SkipCount+1) ;
      if ( AV22GXV1SkipCount > 0 )
      {
         AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt = (com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)new com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item(remoteHandle, context);
         /* Using cursor P00002 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV8PedidosID)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A51PedidosID = P00002_A51PedidosID[0] ;
            /* Using cursor P00003 */
            pr_default.execute(1, new Object[] {Long.valueOf(A51PedidosID)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A52PedidosDetalleID = P00003_A52PedidosDetalleID[0] ;
               A13ArticuloId = P00003_A13ArticuloId[0] ;
               A76ArticuloNombre = P00003_A76ArticuloNombre[0] ;
               A293PedidosDetalleTallaID = P00003_A293PedidosDetalleTallaID[0] ;
               A245PedidosDetalleCantidad = P00003_A245PedidosDetalleCantidad[0] ;
               A76ArticuloNombre = P00003_A76ArticuloNombre[0] ;
               AV7PedidosDetalleID = A52PedidosDetalleID ;
               AV9ArticuloId = A13ArticuloId ;
               AV10ArticuloNombre = A76ArticuloNombre ;
               AV11PedidosDetalleTallaID = A293PedidosDetalleTallaID ;
               AV12PedidosDetalleCantidad = A245PedidosDetalleCantidad ;
               AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid( AV7PedidosDetalleID );
               AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid( AV9ArticuloId );
               AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre( AV10ArticuloNombre );
               AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid( AV11PedidosDetalleTallaID );
               AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad( AV12PedidosDetalleCantidad );
               AV23GXM3RootCol.add(AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt, 0);
               AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt = (com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)new com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item(remoteHandle, context);
               pr_default.readNext(1);
            }
            pr_default.close(1);
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalleid( AV7PedidosDetalleID );
         AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articuloid( AV9ArticuloId );
         AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Articulonombre( AV10ArticuloNombre );
         AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetalletallaid( AV11PedidosDetalleTallaID );
         AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt.setgxTv_SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_Pedidosdetallecantidad( AV12PedidosDetalleCantidad );
      }
      Gxwebsession.setValue(Gxids+"gxvar_Pedidosdetalleid", GXutil.str( AV7PedidosDetalleID, 11, 0));
      Gxwebsession.setValue(Gxids+"gxvar_Articuloid", GXutil.str( AV9ArticuloId, 11, 0));
      Gxwebsession.setValue(Gxids+"gxvar_Articulonombre", AV10ArticuloNombre);
      Gxwebsession.setValue(Gxids+"gxvar_Pedidosdetalletallaid", GXutil.str( AV11PedidosDetalleTallaID, 11, 0));
      Gxwebsession.setValue(Gxids+"gxvar_Pedidosdetallecantidad", GXutil.str( AV12PedidosDetalleCantidad, 5, 0));
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = verdetallespedidossd_level_detail_grid.this.AV23GXM3RootCol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23GXM3RootCol = new GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item>(com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item.class, "VerDetallesPedidosSD_Level_Detail_gridSdt.Item", "http://tempuri.org/", remoteHandle);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV10ArticuloNombre = "" ;
      AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt = new com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item(remoteHandle, context);
      scmdbuf = "" ;
      P00002_A51PedidosID = new long[1] ;
      P00003_A51PedidosID = new long[1] ;
      P00003_A52PedidosDetalleID = new long[1] ;
      P00003_A13ArticuloId = new long[1] ;
      P00003_A76ArticuloNombre = new String[] {""} ;
      P00003_A293PedidosDetalleTallaID = new long[1] ;
      P00003_A245PedidosDetalleCantidad = new int[1] ;
      A76ArticuloNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.verdetallespedidossd_level_detail_grid__default(),
         new Object[] {
             new Object[] {
            P00002_A51PedidosID
            }
            , new Object[] {
            P00003_A51PedidosID, P00003_A52PedidosDetalleID, P00003_A13ArticuloId, P00003_A76ArticuloNombre, P00003_A293PedidosDetalleTallaID, P00003_A245PedidosDetalleCantidad
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17gxid ;
   private int AV12PedidosDetalleCantidad ;
   private int AV22GXV1SkipCount ;
   private int A245PedidosDetalleCantidad ;
   private long AV8PedidosID ;
   private long AV20start ;
   private long AV21count ;
   private long AV7PedidosDetalleID ;
   private long AV9ArticuloId ;
   private long AV11PedidosDetalleTallaID ;
   private long A51PedidosID ;
   private long A52PedidosDetalleID ;
   private long A13ArticuloId ;
   private long A293PedidosDetalleTallaID ;
   private String Gxids ;
   private String AV10ArticuloNombre ;
   private String scmdbuf ;
   private String A76ArticuloNombre ;
   private GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private long[] P00002_A51PedidosID ;
   private long[] P00003_A51PedidosID ;
   private long[] P00003_A52PedidosDetalleID ;
   private long[] P00003_A13ArticuloId ;
   private String[] P00003_A76ArticuloNombre ;
   private long[] P00003_A293PedidosDetalleTallaID ;
   private int[] P00003_A245PedidosDetalleCantidad ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> AV23GXM3RootCol ;
   private com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item AV24GXM2VerDetallesPedidosSD_Level_Detail_gridSdt ;
}

final  class verdetallespedidossd_level_detail_grid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00002", "SELECT [PedidosID] FROM [Pedidos] WHERE [PedidosID] = ? ORDER BY [PedidosID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00003", "SELECT T1.[PedidosID], T1.[PedidosDetalleID], T1.[ArticuloId], T2.[ArticuloNombre], T1.[PedidosDetalleTallaID], T1.[PedidosDetalleCantidad] FROM ([PedidosDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) WHERE T1.[PedidosID] = ? ORDER BY T1.[PedidosID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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

