package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verpedidossd_level_detail_grid extends GXProcedure
{
   public verpedidossd_level_detail_grid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verpedidossd_level_detail_grid.class ), "" );
   }

   public verpedidossd_level_detail_grid( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item> executeUdp( long aP0 ,
                                                                                                  long aP1 ,
                                                                                                  int aP2 )
   {
      verpedidossd_level_detail_grid.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( long aP0 ,
                        long aP1 ,
                        int aP2 ,
                        GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( long aP0 ,
                             long aP1 ,
                             int aP2 ,
                             GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item>[] aP3 )
   {
      verpedidossd_level_detail_grid.this.AV22start = aP0;
      verpedidossd_level_detail_grid.this.AV23count = aP1;
      verpedidossd_level_detail_grid.this.AV19gxid = aP2;
      verpedidossd_level_detail_grid.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV19gxid, 8, 0) ;
      AV12ClienteUser = Gxwebsession.getValue(Gxids+"gxvar_Clienteuser") ;
      AV8PedidosID = GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Pedidosid")) ;
      AV9PedidosFecha = localUtil.ctod( Gxwebsession.getValue(Gxids+"gxvar_Pedidosfecha"), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      AV10PedidosTotal = CommonUtil.decimalVal( Gxwebsession.getValue(Gxids+"gxvar_Pedidostotal"), ".") ;
      AV24GXV1SkipCount = (int)(-(AV22start)) ;
      AV24GXV1SkipCount = (int)(AV24GXV1SkipCount+1) ;
      if ( AV24GXV1SkipCount > 0 )
      {
         AV26GXM2VerPedidosSD_Level_Detail_GridSdt = (com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item)new com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item(remoteHandle, context);
         /* Using cursor P00002 */
         pr_default.execute(0, new Object[] {AV12ClienteUser});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1PersonaId = P00002_A1PersonaId[0] ;
            A4ClienteId = P00002_A4ClienteId[0] ;
            A244ClienteUser = P00002_A244ClienteUser[0] ;
            A56PersonaApellido = P00002_A56PersonaApellido[0] ;
            A55PersonaNombre = P00002_A55PersonaNombre[0] ;
            A56PersonaApellido = P00002_A56PersonaApellido[0] ;
            A55PersonaNombre = P00002_A55PersonaNombre[0] ;
            A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
            AV13PersonaNombreCompleto = A59PersonaNombreCompleto ;
            /* Using cursor P00004 */
            pr_default.execute(1, new Object[] {Long.valueOf(A4ClienteId)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A246PedidosFecha = P00004_A246PedidosFecha[0] ;
               A51PedidosID = P00004_A51PedidosID[0] ;
               A248PedidosTotal = P00004_A248PedidosTotal[0] ;
               n248PedidosTotal = P00004_n248PedidosTotal[0] ;
               A248PedidosTotal = P00004_A248PedidosTotal[0] ;
               n248PedidosTotal = P00004_n248PedidosTotal[0] ;
               AV8PedidosID = A51PedidosID ;
               AV9PedidosFecha = A246PedidosFecha ;
               AV10PedidosTotal = A248PedidosTotal ;
               AV26GXM2VerPedidosSD_Level_Detail_GridSdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid( AV8PedidosID );
               AV26GXM2VerPedidosSD_Level_Detail_GridSdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha( AV9PedidosFecha );
               AV26GXM2VerPedidosSD_Level_Detail_GridSdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal( AV10PedidosTotal );
               AV25GXM3RootCol.add(AV26GXM2VerPedidosSD_Level_Detail_GridSdt, 0);
               AV26GXM2VerPedidosSD_Level_Detail_GridSdt = (com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item)new com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item(remoteHandle, context);
               pr_default.readNext(1);
            }
            pr_default.close(1);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV26GXM2VerPedidosSD_Level_Detail_GridSdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosid( AV8PedidosID );
         AV26GXM2VerPedidosSD_Level_Detail_GridSdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidosfecha( AV9PedidosFecha );
         AV26GXM2VerPedidosSD_Level_Detail_GridSdt.setgxTv_SdtVerPedidosSD_Level_Detail_GridSdt_Item_Pedidostotal( AV10PedidosTotal );
      }
      Gxwebsession.setValue(Gxids+"gxvar_Clienteuser", AV12ClienteUser);
      Gxwebsession.setValue(Gxids+"gxvar_Pedidosid", GXutil.str( AV8PedidosID, 11, 0));
      Gxwebsession.setValue(Gxids+"gxvar_Pedidosfecha", localUtil.dtoc( AV9PedidosFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"));
      Gxwebsession.setValue(Gxids+"gxvar_Pedidostotal", GXutil.str( AV10PedidosTotal, 17, 2));
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = verpedidossd_level_detail_grid.this.AV25GXM3RootCol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25GXM3RootCol = new GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item>(com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item.class, "VerPedidosSD_Level_Detail_GridSdt.Item", "http://tempuri.org/", remoteHandle);
      Gxids = "" ;
      AV12ClienteUser = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV9PedidosFecha = GXutil.nullDate() ;
      AV10PedidosTotal = DecimalUtil.ZERO ;
      AV26GXM2VerPedidosSD_Level_Detail_GridSdt = new com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item(remoteHandle, context);
      scmdbuf = "" ;
      P00002_A1PersonaId = new long[1] ;
      P00002_A4ClienteId = new long[1] ;
      P00002_A244ClienteUser = new String[] {""} ;
      P00002_A56PersonaApellido = new String[] {""} ;
      P00002_A55PersonaNombre = new String[] {""} ;
      A244ClienteUser = "" ;
      A56PersonaApellido = "" ;
      A55PersonaNombre = "" ;
      A59PersonaNombreCompleto = "" ;
      AV13PersonaNombreCompleto = "" ;
      P00004_A4ClienteId = new long[1] ;
      P00004_A246PedidosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00004_A51PedidosID = new long[1] ;
      P00004_A248PedidosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00004_n248PedidosTotal = new boolean[] {false} ;
      A246PedidosFecha = GXutil.nullDate() ;
      A248PedidosTotal = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.verpedidossd_level_detail_grid__default(),
         new Object[] {
             new Object[] {
            P00002_A1PersonaId, P00002_A4ClienteId, P00002_A244ClienteUser, P00002_A56PersonaApellido, P00002_A55PersonaNombre
            }
            , new Object[] {
            P00004_A4ClienteId, P00004_A246PedidosFecha, P00004_A51PedidosID, P00004_A248PedidosTotal, P00004_n248PedidosTotal
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV19gxid ;
   private int AV24GXV1SkipCount ;
   private long AV22start ;
   private long AV23count ;
   private long AV8PedidosID ;
   private long A1PersonaId ;
   private long A4ClienteId ;
   private long A51PedidosID ;
   private java.math.BigDecimal AV10PedidosTotal ;
   private java.math.BigDecimal A248PedidosTotal ;
   private String Gxids ;
   private String AV12ClienteUser ;
   private String scmdbuf ;
   private String A244ClienteUser ;
   private String A56PersonaApellido ;
   private String A55PersonaNombre ;
   private String A59PersonaNombreCompleto ;
   private String AV13PersonaNombreCompleto ;
   private java.util.Date AV9PedidosFecha ;
   private java.util.Date A246PedidosFecha ;
   private boolean n248PedidosTotal ;
   private GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private long[] P00002_A1PersonaId ;
   private long[] P00002_A4ClienteId ;
   private String[] P00002_A244ClienteUser ;
   private String[] P00002_A56PersonaApellido ;
   private String[] P00002_A55PersonaNombre ;
   private long[] P00004_A4ClienteId ;
   private java.util.Date[] P00004_A246PedidosFecha ;
   private long[] P00004_A51PedidosID ;
   private java.math.BigDecimal[] P00004_A248PedidosTotal ;
   private boolean[] P00004_n248PedidosTotal ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item> AV25GXM3RootCol ;
   private com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item AV26GXM2VerPedidosSD_Level_Detail_GridSdt ;
}

final  class verpedidossd_level_detail_grid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00002", "SELECT T1.[PersonaId], T1.[ClienteId], T1.[ClienteUser], T2.[PersonaApellido], T2.[PersonaNombre] FROM ([Cliente] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = T1.[PersonaId]) WHERE T1.[ClienteUser] = ? ORDER BY T1.[ClienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00004", "SELECT T1.[ClienteId], T1.[PedidosFecha], T1.[PedidosID], COALESCE( T2.[PedidosTotal], 0) AS PedidosTotal FROM ([Pedidos] T1 LEFT JOIN (SELECT SUM(T4.[ArticuloPrecioVenta] * CAST(T3.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosTotal, T3.[PedidosID] FROM ([PedidosDetalle] T3 INNER JOIN [Articulo] T4 ON T4.[ArticuloId] = T3.[ArticuloId]) GROUP BY T3.[PedidosID] ) T2 ON T2.[PedidosID] = T1.[PedidosID]) WHERE T1.[ClienteId] = ? ORDER BY T1.[PedidosID] DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

