package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verdisponsd extends GXProcedure
{
   public verdisponsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verdisponsd.class ), "" );
   }

   public verdisponsd( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            short aP1 )
   {
      verdisponsd.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             short[] aP2 )
   {
      verdisponsd.this.AV8ProductId = aP0;
      verdisponsd.this.AV9ProductTalla = aP1;
      verdisponsd.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11ProductsInCartTxt = AV12WebSession.getValue("ProductsInCart") ;
      AV13ProductsInCart.fromJSonString(AV11ProductsInCartTxt, null);
      /* Using cursor P007H2 */
      pr_default.execute(0, new Object[] {AV8ProductId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13ArticuloId = P007H2_A13ArticuloId[0] ;
         /* Using cursor P007H3 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV9ProductTalla), Long.valueOf(A13ArticuloId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A286TallaID = P007H3_A286TallaID[0] ;
            A290ArticuloTallaStock = P007H3_A290ArticuloTallaStock[0] ;
            A285ArticuloTallaID = P007H3_A285ArticuloTallaID[0] ;
            AV10ProductDispon = (short)(A290ArticuloTallaStock) ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV13ProductsInCart.size() )
      {
         AV14ProductsInCartItem = (com.mujermorena.SdtNMCartProduct)((com.mujermorena.SdtNMCartProduct)AV13ProductsInCart.elementAt(-1+AV20GXV1));
         if ( GXutil.strcmp(AV14ProductsInCartItem.getgxTv_SdtNMCartProduct_Productid(), AV8ProductId) == 0 )
         {
            if ( AV14ProductsInCartItem.getgxTv_SdtNMCartProduct_Talla() == AV9ProductTalla )
            {
               AV10ProductDispon = (short)(AV10ProductDispon-AV14ProductsInCartItem.getgxTv_SdtNMCartProduct_Count()) ;
            }
         }
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = verdisponsd.this.AV10ProductDispon;
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
      AV12WebSession = httpContext.getWebSession();
      AV13ProductsInCart = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      scmdbuf = "" ;
      P007H2_A13ArticuloId = new long[1] ;
      P007H3_A13ArticuloId = new long[1] ;
      P007H3_A286TallaID = new long[1] ;
      P007H3_A290ArticuloTallaStock = new long[1] ;
      P007H3_A285ArticuloTallaID = new long[1] ;
      AV14ProductsInCartItem = new com.mujermorena.SdtNMCartProduct(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.verdisponsd__default(),
         new Object[] {
             new Object[] {
            P007H2_A13ArticuloId
            }
            , new Object[] {
            P007H3_A13ArticuloId, P007H3_A286TallaID, P007H3_A290ArticuloTallaStock, P007H3_A285ArticuloTallaID
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9ProductTalla ;
   private short AV10ProductDispon ;
   private short Gx_err ;
   private int AV20GXV1 ;
   private long A13ArticuloId ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long A285ArticuloTallaID ;
   private String AV8ProductId ;
   private String scmdbuf ;
   private String AV11ProductsInCartTxt ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private long[] P007H2_A13ArticuloId ;
   private long[] P007H3_A13ArticuloId ;
   private long[] P007H3_A286TallaID ;
   private long[] P007H3_A290ArticuloTallaStock ;
   private long[] P007H3_A285ArticuloTallaID ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV13ProductsInCart ;
   private com.mujermorena.SdtNMCartProduct AV14ProductsInCartItem ;
}

final  class verdisponsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007H2", "SELECT [ArticuloId] FROM [Articulo] WHERE [ArticuloId] = CONVERT( DECIMAL(28,14), ?) ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007H3", "SELECT [ArticuloId], [TallaID], [ArticuloTallaStock], [ArticuloTallaID] FROM [ArticuloTalla] WHERE ([TallaID] = ?) AND ([ArticuloId] = ?) ORDER BY [TallaID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               stmt.setString(1, (String)parms[0], 40);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

