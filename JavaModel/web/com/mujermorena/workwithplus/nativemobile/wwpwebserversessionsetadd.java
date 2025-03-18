package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwpwebserversessionsetadd extends GXProcedure
{
   public wwpwebserversessionsetadd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpwebserversessionsetadd.class ), "" );
   }

   public wwpwebserversessionsetadd( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( com.mujermorena.SdtNMCartPayment aP0 ,
                        com.mujermorena.SdtNMCartUserAddress aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( com.mujermorena.SdtNMCartPayment aP0 ,
                             com.mujermorena.SdtNMCartUserAddress aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      wwpwebserversessionsetadd.this.AV26CartPayment = aP0;
      wwpwebserversessionsetadd.this.AV27CartUserAddress = aP1;
      wwpwebserversessionsetadd.this.AV8ParameterKey = aP2;
      wwpwebserversessionsetadd.this.AV9ParameterValue = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11ProductsInCartTxt = AV10WebSession.getValue(AV8ParameterKey) ;
      AV12ProductsInCart.fromJSonString(AV11ProductsInCartTxt, null);
      AV10WebSession.setValue(AV8ParameterKey, AV9ParameterValue);
      GXt_int1 = AV15PedidosID ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "Pedidos", ""), GXv_int2) ;
      wwpwebserversessionsetadd.this.GXt_int1 = GXv_int2[0] ;
      AV15PedidosID = GXt_int1 ;
      AV14GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV24UserName = AV14GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P007G2 */
      pr_default.execute(0, new Object[] {AV24UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A244ClienteUser = P007G2_A244ClienteUser[0] ;
         A4ClienteId = P007G2_A4ClienteId[0] ;
         AV13ClienteId = A4ClienteId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /*
         INSERT RECORD ON TABLE Pedidos

      */
      A51PedidosID = AV15PedidosID ;
      A4ClienteId = AV13ClienteId ;
      A246PedidosFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
      A247PedidosEstado = httpContext.getMessage( "PEN", "") ;
      A9TipoPagoId = AV26CartPayment.getgxTv_SdtNMCartPayment_Id() ;
      A312PedidosUbicacion = AV27CartUserAddress.getgxTv_SdtNMCartUserAddress_Ubicacion() ;
      A295PedidosComprobanteObs = AV26CartPayment.getgxTv_SdtNMCartPayment_Nrocomprobante() ;
      A296PedidosImagenComprobante = AV26CartPayment.getgxTv_SdtNMCartPayment_Imagen() ;
      A40000PedidosImagenComprobante_GXI = AV26CartPayment.getgxTv_SdtNMCartPayment_Imagen_gxi() ;
      A283OpcionEnvioId = 2 ;
      /* Using cursor P007G3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A4ClienteId), A246PedidosFecha, A247PedidosEstado, Long.valueOf(A9TipoPagoId), Long.valueOf(A283OpcionEnvioId), A295PedidosComprobanteObs, A296PedidosImagenComprobante, A40000PedidosImagenComprobante_GXI, A312PedidosUbicacion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
      if ( (pr_default.getStatus(1) == 1) )
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
      AV18PedidosDetalleID = 1 ;
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV12ProductsInCart.size() )
      {
         AV35CartProduct = (com.mujermorena.SdtNMCartProduct)((com.mujermorena.SdtNMCartProduct)AV12ProductsInCart.elementAt(-1+AV47GXV1));
         AV40ArticuloId = GXutil.lval( AV35CartProduct.getgxTv_SdtNMCartProduct_Productid()) ;
         AV41PedidosDetalleCantidad = AV35CartProduct.getgxTv_SdtNMCartProduct_Count() ;
         AV42ArticuloStock = AV41PedidosDetalleCantidad ;
         AV43PedidosDetalleTallaID = AV35CartProduct.getgxTv_SdtNMCartProduct_Talla() ;
         /*
            INSERT RECORD ON TABLE PedidosDetalle

         */
         A51PedidosID = AV15PedidosID ;
         A52PedidosDetalleID = AV18PedidosDetalleID ;
         A13ArticuloId = AV40ArticuloId ;
         A245PedidosDetalleCantidad = AV41PedidosDetalleCantidad ;
         A293PedidosDetalleTallaID = AV43PedidosDetalleTallaID ;
         /* Using cursor P007G4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID), Long.valueOf(A13ArticuloId), Integer.valueOf(A245PedidosDetalleCantidad), Long.valueOf(A293PedidosDetalleTallaID)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("PedidosDetalle");
         if ( (pr_default.getStatus(2) == 1) )
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
         AV18PedidosDetalleID = (long)(AV18PedidosDetalleID+1) ;
         /* Execute user subroutine: 'ACTUALIZARSTOCKVENTA' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'ACTUALIZARSTOCKARTICULO' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ACTUALIZARSTOCKVENTA' Routine */
      returnInSub = false ;
      /* Using cursor P007G5 */
      pr_default.execute(3, new Object[] {Long.valueOf(AV40ArticuloId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A46StockId = P007G5_A46StockId[0] ;
         A13ArticuloId = P007G5_A13ArticuloId[0] ;
         A233StockTotal = P007G5_A233StockTotal[0] ;
         A233StockTotal = (int)(A233StockTotal-AV41PedidosDetalleCantidad) ;
         /* Using cursor P007G6 */
         pr_default.execute(4, new Object[] {Long.valueOf(A46StockId), Long.valueOf(AV43PedidosDetalleTallaID)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A289StockDetalleTallaID = P007G6_A289StockDetalleTallaID[0] ;
            A218StockCantidad = P007G6_A218StockCantidad[0] ;
            A50StockDetalleID = P007G6_A50StockDetalleID[0] ;
            if ( AV41PedidosDetalleCantidad > 0 )
            {
               if ( A218StockCantidad > AV41PedidosDetalleCantidad )
               {
                  A218StockCantidad = (int)(A218StockCantidad-AV41PedidosDetalleCantidad) ;
                  AV41PedidosDetalleCantidad = 0 ;
               }
               else
               {
                  AV41PedidosDetalleCantidad = (int)(AV41PedidosDetalleCantidad-A218StockCantidad) ;
                  A218StockCantidad = 0 ;
               }
            }
            /* Using cursor P007G7 */
            pr_default.execute(5, new Object[] {Integer.valueOf(A218StockCantidad), Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
            pr_default.readNext(4);
         }
         pr_default.close(4);
         /* Using cursor P007G8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A46StockId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void S121( )
   {
      /* 'ACTUALIZARSTOCKARTICULO' Routine */
      returnInSub = false ;
      /* Using cursor P007G9 */
      pr_default.execute(7, new Object[] {Long.valueOf(AV40ArticuloId)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A13ArticuloId = P007G9_A13ArticuloId[0] ;
         A79ArticuloStock = P007G9_A79ArticuloStock[0] ;
         A79ArticuloStock = (long)(A79ArticuloStock-AV42ArticuloStock) ;
         /* Using cursor P007G10 */
         pr_default.execute(8, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(AV43PedidosDetalleTallaID)});
         while ( (pr_default.getStatus(8) != 101) )
         {
            A286TallaID = P007G10_A286TallaID[0] ;
            A290ArticuloTallaStock = P007G10_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P007G10_A285ArticuloTallaID[0] ;
            A290ArticuloTallaStock = (long)(A290ArticuloTallaStock-AV42ArticuloStock) ;
            AV42ArticuloStock = 0 ;
            /* Using cursor P007G11 */
            pr_default.execute(9, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
            pr_default.readNext(8);
         }
         pr_default.close(8);
         /* Using cursor P007G12 */
         pr_default.execute(10, new Object[] {Long.valueOf(A79ArticuloStock), Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(7);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "workwithplus.nativemobile.wwpwebserversessionsetadd");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11ProductsInCartTxt = "" ;
      AV10WebSession = httpContext.getWebSession();
      AV12ProductsInCart = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      GXv_int2 = new long[1] ;
      AV14GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV24UserName = "" ;
      scmdbuf = "" ;
      P007G2_A244ClienteUser = new String[] {""} ;
      P007G2_A4ClienteId = new long[1] ;
      A244ClienteUser = "" ;
      A246PedidosFecha = GXutil.nullDate() ;
      A247PedidosEstado = "" ;
      A312PedidosUbicacion = "" ;
      A295PedidosComprobanteObs = "" ;
      A296PedidosImagenComprobante = "" ;
      A40000PedidosImagenComprobante_GXI = "" ;
      Gx_emsg = "" ;
      AV35CartProduct = new com.mujermorena.SdtNMCartProduct(remoteHandle, context);
      P007G5_A46StockId = new long[1] ;
      P007G5_A13ArticuloId = new long[1] ;
      P007G5_A233StockTotal = new int[1] ;
      P007G6_A46StockId = new long[1] ;
      P007G6_A289StockDetalleTallaID = new long[1] ;
      P007G6_A218StockCantidad = new int[1] ;
      P007G6_A50StockDetalleID = new long[1] ;
      P007G9_A13ArticuloId = new long[1] ;
      P007G9_A79ArticuloStock = new long[1] ;
      P007G10_A13ArticuloId = new long[1] ;
      P007G10_A286TallaID = new long[1] ;
      P007G10_A290ArticuloTallaStock = new long[1] ;
      P007G10_A285ArticuloTallaID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.workwithplus.nativemobile.wwpwebserversessionsetadd__default(),
         new Object[] {
             new Object[] {
            P007G2_A244ClienteUser, P007G2_A4ClienteId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P007G5_A46StockId, P007G5_A13ArticuloId, P007G5_A233StockTotal
            }
            , new Object[] {
            P007G6_A46StockId, P007G6_A289StockDetalleTallaID, P007G6_A218StockCantidad, P007G6_A50StockDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P007G9_A13ArticuloId, P007G9_A79ArticuloStock
            }
            , new Object[] {
            P007G10_A13ArticuloId, P007G10_A286TallaID, P007G10_A290ArticuloTallaStock, P007G10_A285ArticuloTallaID
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

   private short Gx_err ;
   private int GX_INS47 ;
   private int AV47GXV1 ;
   private int AV41PedidosDetalleCantidad ;
   private int GX_INS48 ;
   private int A245PedidosDetalleCantidad ;
   private int A233StockTotal ;
   private int A218StockCantidad ;
   private long AV15PedidosID ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A4ClienteId ;
   private long AV13ClienteId ;
   private long A51PedidosID ;
   private long A9TipoPagoId ;
   private long A283OpcionEnvioId ;
   private long AV18PedidosDetalleID ;
   private long AV40ArticuloId ;
   private long AV42ArticuloStock ;
   private long AV43PedidosDetalleTallaID ;
   private long A52PedidosDetalleID ;
   private long A13ArticuloId ;
   private long A293PedidosDetalleTallaID ;
   private long A46StockId ;
   private long A289StockDetalleTallaID ;
   private long A50StockDetalleID ;
   private long A79ArticuloStock ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long A285ArticuloTallaID ;
   private String AV8ParameterKey ;
   private String AV24UserName ;
   private String scmdbuf ;
   private String A244ClienteUser ;
   private String A247PedidosEstado ;
   private String A312PedidosUbicacion ;
   private String Gx_emsg ;
   private java.util.Date A246PedidosFecha ;
   private boolean returnInSub ;
   private String AV9ParameterValue ;
   private String AV11ProductsInCartTxt ;
   private String A295PedidosComprobanteObs ;
   private String A40000PedidosImagenComprobante_GXI ;
   private String A296PedidosImagenComprobante ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private IDataStoreProvider pr_default ;
   private String[] P007G2_A244ClienteUser ;
   private long[] P007G2_A4ClienteId ;
   private long[] P007G5_A46StockId ;
   private long[] P007G5_A13ArticuloId ;
   private int[] P007G5_A233StockTotal ;
   private long[] P007G6_A46StockId ;
   private long[] P007G6_A289StockDetalleTallaID ;
   private int[] P007G6_A218StockCantidad ;
   private long[] P007G6_A50StockDetalleID ;
   private long[] P007G9_A13ArticuloId ;
   private long[] P007G9_A79ArticuloStock ;
   private long[] P007G10_A13ArticuloId ;
   private long[] P007G10_A286TallaID ;
   private long[] P007G10_A290ArticuloTallaStock ;
   private long[] P007G10_A285ArticuloTallaID ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV12ProductsInCart ;
   private com.mujermorena.SdtNMCartProduct AV35CartProduct ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV14GAMUser ;
   private com.mujermorena.SdtNMCartPayment AV26CartPayment ;
   private com.mujermorena.SdtNMCartUserAddress AV27CartUserAddress ;
}

final  class wwpwebserversessionsetadd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007G2", "SELECT [ClienteUser], [ClienteId] FROM [Cliente] WHERE [ClienteUser] = ? ORDER BY [ClienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007G3", "INSERT INTO [Pedidos]([PedidosID], [ClienteId], [PedidosFecha], [PedidosEstado], [TipoPagoId], [OpcionEnvioId], [PedidosComprobanteObs], [PedidosImagenComprobante], [PedidosImagenComprobante_GXI], [PedidosUbicacion]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P007G4", "INSERT INTO [PedidosDetalle]([PedidosID], [PedidosDetalleID], [ArticuloId], [PedidosDetalleCantidad], [PedidosDetalleTallaID]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P007G5", "SELECT [StockId], [ArticuloId], [StockTotal] FROM [Stock] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [StockId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007G6", "SELECT [StockId], [StockDetalleTallaID], [StockCantidad], [StockDetalleID] FROM [StockDetalle] WITH (UPDLOCK) WHERE ([StockId] = ?) AND ([StockDetalleTallaID] = ?) ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007G7", "UPDATE [StockDetalle] SET [StockCantidad]=?  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P007G8", "UPDATE [Stock] SET [StockTotal]=?  WHERE [StockId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P007G9", "SELECT [ArticuloId], [ArticuloStock] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007G10", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE ([ArticuloId] = ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P007G11", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P007G12", "UPDATE [Articulo] SET [ArticuloStock]=?  WHERE [ArticuloId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 8 :
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
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setVarchar(7, (String)parms[6], 512, false);
               stmt.setBLOBFile(8, (String)parms[7], true);
               stmt.setGXDbFileURI(9, (String)parms[8], (String)parms[7], 2048,"Pedidos","PedidosImagenComprobante");
               stmt.setString(10, (String)parms[9], 50);
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

