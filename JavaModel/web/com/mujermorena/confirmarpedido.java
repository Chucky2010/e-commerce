package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class confirmarpedido extends GXProcedure
{
   public confirmarpedido( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( confirmarpedido.class ), "" );
   }

   public confirmarpedido( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData executeUdp( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 )
   {
      confirmarpedido.this.aP1 = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData[] {new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 ,
                        com.mujermorena.wwpbaseobjects.SdtCartCheckoutData[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 ,
                             com.mujermorena.wwpbaseobjects.SdtCartCheckoutData[] aP1 )
   {
      confirmarpedido.this.AV8DVelop_ECommerceCart = aP0[0];
      this.aP0 = aP0;
      confirmarpedido.this.AV9WizardData = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV10PedidosID ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "Pedidos", ""), GXv_int2) ;
      confirmarpedido.this.GXt_int1 = GXv_int2[0] ;
      AV10PedidosID = GXt_int1 ;
      AV11GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV12UserName = AV11GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P004K2 */
      pr_default.execute(0, new Object[] {AV12UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A244ClienteUser = P004K2_A244ClienteUser[0] ;
         A4ClienteId = P004K2_A4ClienteId[0] ;
         AV13ClienteId = A4ClienteId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV16TipoPagoNombre = AV9WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata() ;
      AV25GXLvl12 = (byte)(0) ;
      /* Using cursor P004K3 */
      pr_default.execute(1, new Object[] {AV16TipoPagoNombre});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A71TipoPagoNombre = P004K3_A71TipoPagoNombre[0] ;
         A9TipoPagoId = P004K3_A9TipoPagoId[0] ;
         AV25GXLvl12 = (byte)(1) ;
         AV17TipoPagoId = A9TipoPagoId ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV25GXLvl12 == 0 )
      {
         AV17TipoPagoId = 1 ;
      }
      /*
         INSERT RECORD ON TABLE Pedidos

      */
      A51PedidosID = AV10PedidosID ;
      A4ClienteId = AV13ClienteId ;
      A246PedidosFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
      A247PedidosEstado = httpContext.getMessage( "PEN", "") ;
      A9TipoPagoId = AV17TipoPagoId ;
      A283OpcionEnvioId = AV9WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata2() ;
      /* Using cursor P004K4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A4ClienteId), A246PedidosFecha, A247PedidosEstado, Long.valueOf(A9TipoPagoId), Long.valueOf(A283OpcionEnvioId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
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
      AV15PedidosDetalleID = 1 ;
      AV26GXV1 = 1 ;
      while ( AV26GXV1 <= AV8DVelop_ECommerceCart.size() )
      {
         AV14DVelop_ECommerceCartItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV26GXV1));
         AV18ArticuloId = AV14DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() ;
         AV19PedidosDetalleCantidad = AV14DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty() ;
         AV21ArticuloStock = AV19PedidosDetalleCantidad ;
         AV20PedidosDetalleTallaID = AV14DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() ;
         /*
            INSERT RECORD ON TABLE PedidosDetalle

         */
         A51PedidosID = AV10PedidosID ;
         A52PedidosDetalleID = AV15PedidosDetalleID ;
         A13ArticuloId = AV18ArticuloId ;
         A245PedidosDetalleCantidad = AV19PedidosDetalleCantidad ;
         A293PedidosDetalleTallaID = AV20PedidosDetalleTallaID ;
         /* Using cursor P004K5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID), Long.valueOf(A13ArticuloId), Integer.valueOf(A245PedidosDetalleCantidad), Long.valueOf(A293PedidosDetalleTallaID)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("PedidosDetalle");
         if ( (pr_default.getStatus(3) == 1) )
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
         AV15PedidosDetalleID = (long)(AV15PedidosDetalleID+1) ;
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
         AV26GXV1 = (int)(AV26GXV1+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ACTUALIZARSTOCKVENTA' Routine */
      returnInSub = false ;
      /* Using cursor P004K6 */
      pr_default.execute(4, new Object[] {Long.valueOf(AV18ArticuloId)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A46StockId = P004K6_A46StockId[0] ;
         A13ArticuloId = P004K6_A13ArticuloId[0] ;
         A233StockTotal = P004K6_A233StockTotal[0] ;
         A233StockTotal = (int)(A233StockTotal-AV19PedidosDetalleCantidad) ;
         /* Using cursor P004K7 */
         pr_default.execute(5, new Object[] {Long.valueOf(A46StockId), Long.valueOf(AV20PedidosDetalleTallaID)});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A289StockDetalleTallaID = P004K7_A289StockDetalleTallaID[0] ;
            A218StockCantidad = P004K7_A218StockCantidad[0] ;
            A50StockDetalleID = P004K7_A50StockDetalleID[0] ;
            if ( AV19PedidosDetalleCantidad > 0 )
            {
               if ( A218StockCantidad > AV19PedidosDetalleCantidad )
               {
                  A218StockCantidad = (int)(A218StockCantidad-AV19PedidosDetalleCantidad) ;
                  AV19PedidosDetalleCantidad = 0 ;
               }
               else
               {
                  AV19PedidosDetalleCantidad = (int)(AV19PedidosDetalleCantidad-A218StockCantidad) ;
                  A218StockCantidad = 0 ;
               }
            }
            /* Using cursor P004K8 */
            pr_default.execute(6, new Object[] {Integer.valueOf(A218StockCantidad), Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
            pr_default.readNext(5);
         }
         pr_default.close(5);
         /* Using cursor P004K9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A46StockId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void S121( )
   {
      /* 'ACTUALIZARSTOCKARTICULO' Routine */
      returnInSub = false ;
      /* Using cursor P004K10 */
      pr_default.execute(8, new Object[] {Long.valueOf(AV18ArticuloId)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A13ArticuloId = P004K10_A13ArticuloId[0] ;
         A79ArticuloStock = P004K10_A79ArticuloStock[0] ;
         A79ArticuloStock = (long)(A79ArticuloStock-AV21ArticuloStock) ;
         /* Using cursor P004K11 */
         pr_default.execute(9, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(AV20PedidosDetalleTallaID)});
         while ( (pr_default.getStatus(9) != 101) )
         {
            A286TallaID = P004K11_A286TallaID[0] ;
            A290ArticuloTallaStock = P004K11_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P004K11_A285ArticuloTallaID[0] ;
            A290ArticuloTallaStock = (long)(A290ArticuloTallaStock-AV21ArticuloStock) ;
            AV21ArticuloStock = 0 ;
            /* Using cursor P004K12 */
            pr_default.execute(10, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
            pr_default.readNext(9);
         }
         pr_default.close(9);
         /* Using cursor P004K13 */
         pr_default.execute(11, new Object[] {Long.valueOf(A79ArticuloStock), Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(8);
   }

   protected void cleanup( )
   {
      this.aP0[0] = confirmarpedido.this.AV8DVelop_ECommerceCart;
      this.aP1[0] = confirmarpedido.this.AV9WizardData;
      Application.commitDataStores(context, remoteHandle, pr_default, "confirmarpedido");
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
      scmdbuf = "" ;
      P004K2_A244ClienteUser = new String[] {""} ;
      P004K2_A4ClienteId = new long[1] ;
      A244ClienteUser = "" ;
      AV16TipoPagoNombre = "" ;
      P004K3_A71TipoPagoNombre = new String[] {""} ;
      P004K3_A9TipoPagoId = new long[1] ;
      A71TipoPagoNombre = "" ;
      A246PedidosFecha = GXutil.nullDate() ;
      A247PedidosEstado = "" ;
      Gx_emsg = "" ;
      AV14DVelop_ECommerceCartItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      P004K6_A46StockId = new long[1] ;
      P004K6_A13ArticuloId = new long[1] ;
      P004K6_A233StockTotal = new int[1] ;
      P004K7_A46StockId = new long[1] ;
      P004K7_A289StockDetalleTallaID = new long[1] ;
      P004K7_A218StockCantidad = new int[1] ;
      P004K7_A50StockDetalleID = new long[1] ;
      P004K10_A13ArticuloId = new long[1] ;
      P004K10_A79ArticuloStock = new long[1] ;
      P004K11_A13ArticuloId = new long[1] ;
      P004K11_A286TallaID = new long[1] ;
      P004K11_A290ArticuloTallaStock = new long[1] ;
      P004K11_A285ArticuloTallaID = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.confirmarpedido__default(),
         new Object[] {
             new Object[] {
            P004K2_A244ClienteUser, P004K2_A4ClienteId
            }
            , new Object[] {
            P004K3_A71TipoPagoNombre, P004K3_A9TipoPagoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P004K6_A46StockId, P004K6_A13ArticuloId, P004K6_A233StockTotal
            }
            , new Object[] {
            P004K7_A46StockId, P004K7_A289StockDetalleTallaID, P004K7_A218StockCantidad, P004K7_A50StockDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P004K10_A13ArticuloId, P004K10_A79ArticuloStock
            }
            , new Object[] {
            P004K11_A13ArticuloId, P004K11_A286TallaID, P004K11_A290ArticuloTallaStock, P004K11_A285ArticuloTallaID
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

   private byte AV25GXLvl12 ;
   private short Gx_err ;
   private int GX_INS47 ;
   private int AV26GXV1 ;
   private int AV19PedidosDetalleCantidad ;
   private int GX_INS48 ;
   private int A245PedidosDetalleCantidad ;
   private int A233StockTotal ;
   private int A218StockCantidad ;
   private long AV10PedidosID ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A4ClienteId ;
   private long AV13ClienteId ;
   private long A9TipoPagoId ;
   private long AV17TipoPagoId ;
   private long A51PedidosID ;
   private long A283OpcionEnvioId ;
   private long AV15PedidosDetalleID ;
   private long AV18ArticuloId ;
   private long AV21ArticuloStock ;
   private long AV20PedidosDetalleTallaID ;
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
   private String AV12UserName ;
   private String scmdbuf ;
   private String A244ClienteUser ;
   private String AV16TipoPagoNombre ;
   private String A71TipoPagoNombre ;
   private String A247PedidosEstado ;
   private String Gx_emsg ;
   private java.util.Date A246PedidosFecha ;
   private boolean returnInSub ;
   private com.mujermorena.wwpbaseobjects.SdtCartCheckoutData[] aP1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P004K2_A244ClienteUser ;
   private long[] P004K2_A4ClienteId ;
   private String[] P004K3_A71TipoPagoNombre ;
   private long[] P004K3_A9TipoPagoId ;
   private long[] P004K6_A46StockId ;
   private long[] P004K6_A13ArticuloId ;
   private int[] P004K6_A233StockTotal ;
   private long[] P004K7_A46StockId ;
   private long[] P004K7_A289StockDetalleTallaID ;
   private int[] P004K7_A218StockCantidad ;
   private long[] P004K7_A50StockDetalleID ;
   private long[] P004K10_A13ArticuloId ;
   private long[] P004K10_A79ArticuloStock ;
   private long[] P004K11_A13ArticuloId ;
   private long[] P004K11_A286TallaID ;
   private long[] P004K11_A290ArticuloTallaStock ;
   private long[] P004K11_A285ArticuloTallaID ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV14DVelop_ECommerceCartItem ;
   private com.mujermorena.wwpbaseobjects.SdtCartCheckoutData AV9WizardData ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV11GAMUser ;
}

final  class confirmarpedido__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004K2", "SELECT [ClienteUser], [ClienteId] FROM [Cliente] WHERE [ClienteUser] = ? ORDER BY [ClienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P004K3", "SELECT [TipoPagoNombre], [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoNombre] = ? ORDER BY [TipoPagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K4", "INSERT INTO [Pedidos]([PedidosID], [ClienteId], [PedidosFecha], [PedidosEstado], [TipoPagoId], [OpcionEnvioId], [PedidosComprobanteObs], [PedidosImagenComprobante], [PedidosImagenComprobante_GXI], [PedidosUbicacion]) VALUES(?, ?, ?, ?, ?, ?, '', CONVERT(varbinary(1), ''), '', '')", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K5", "INSERT INTO [PedidosDetalle]([PedidosID], [PedidosDetalleID], [ArticuloId], [PedidosDetalleCantidad], [PedidosDetalleTallaID]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K6", "SELECT [StockId], [ArticuloId], [StockTotal] FROM [Stock] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [StockId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P004K7", "SELECT [StockId], [StockDetalleTallaID], [StockCantidad], [StockDetalleID] FROM [StockDetalle] WITH (UPDLOCK) WHERE ([StockId] = ?) AND ([StockDetalleTallaID] = ?) ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K8", "UPDATE [StockDetalle] SET [StockCantidad]=?  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K9", "UPDATE [Stock] SET [StockTotal]=?  WHERE [StockId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K10", "SELECT [ArticuloId], [ArticuloStock] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P004K11", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE ([ArticuloId] = ?) AND ([TallaID] = ?) ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K12", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K13", "UPDATE [Articulo] SET [ArticuloStock]=?  WHERE [ArticuloId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 9 :
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
               stmt.setString(1, (String)parms[0], 80);
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

