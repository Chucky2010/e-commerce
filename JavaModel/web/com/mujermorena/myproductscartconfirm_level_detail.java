package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class myproductscartconfirm_level_detail extends GXProcedure
{
   public myproductscartconfirm_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( myproductscartconfirm_level_detail.class ), "" );
   }

   public myproductscartconfirm_level_detail( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt executeUdp( int aP0 )
   {
      myproductscartconfirm_level_detail.this.aP1 = new com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt[] {new com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt[] aP1 )
   {
      myproductscartconfirm_level_detail.this.AV27gxid = aP0;
      myproductscartconfirm_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV27gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         AV18GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
         AV19ClienteUser = AV18GAMUser.getgxTv_SdtGAMUser_Name() ;
         GXt_objcol_SdtNMCartProduct1 = AV5CartProductCollection ;
         GXv_objcol_SdtNMCartProduct2[0] = GXt_objcol_SdtNMCartProduct1 ;
         new com.mujermorena.nmcartproductslist(remoteHandle, context).execute( GXv_objcol_SdtNMCartProduct2) ;
         GXt_objcol_SdtNMCartProduct1 = GXv_objcol_SdtNMCartProduct2[0] ;
         AV5CartProductCollection = GXt_objcol_SdtNMCartProduct1 ;
         AV7CartSubtotal = DecimalUtil.doubleToDec(0) ;
         AV36GXV1 = 1 ;
         while ( AV36GXV1 <= AV5CartProductCollection.size() )
         {
            AV15CartProduct = (com.mujermorena.SdtNMCartProduct)((com.mujermorena.SdtNMCartProduct)AV5CartProductCollection.elementAt(-1+AV36GXV1));
            GXt_SdtWWPProductData3 = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData();
            GXv_SdtWWPProductData4[0] = GXt_SdtWWPProductData3;
            new com.mujermorena.nmgetproductdata(remoteHandle, context).execute( AV15CartProduct.getgxTv_SdtNMCartProduct_Productid(), GXv_SdtWWPProductData4) ;
            GXt_SdtWWPProductData3 = GXv_SdtWWPProductData4[0] ;
            AV15CartProduct.setgxTv_SdtNMCartProduct_Productdata(GXt_SdtWWPProductData3);
            AV9ProductPrice = CommonUtil.decimalVal( GXutil.trim( GXutil.strReplace( AV15CartProduct.getgxTv_SdtNMCartProduct_Productdata().getgxTv_SdtWWPProductData_Information1(), "Gs. ", "")), ".") ;
            AV7CartSubtotal = AV7CartSubtotal.add(DecimalUtil.doubleToDec(AV15CartProduct.getgxTv_SdtNMCartProduct_Count()).multiply(AV9ProductPrice)) ;
            AV36GXV1 = (int)(AV36GXV1+1) ;
         }
         AV8CartSubtotalTxt = "   Gs. " + GXutil.trim( localUtil.format( AV7CartSubtotal, "ZZZZZZZZZZZZ9.99")) ;
         GXt_SdtNMCartUserAddress5 = AV10CartUserAddress;
         GXv_SdtNMCartUserAddress6[0] = GXt_SdtNMCartUserAddress5;
         new com.mujermorena.nmcartaddressgetselected(remoteHandle, context).execute( GXv_SdtNMCartUserAddress6) ;
         GXt_SdtNMCartUserAddress5 = GXv_SdtNMCartUserAddress6[0] ;
         AV10CartUserAddress = GXt_SdtNMCartUserAddress5;
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"&Datopago\",\"Visible\",\"" + "False" + "\"]" ;
         Gxwebsession.setValue(Gxids+"gxvar_Cartsubtotaltxt", AV8CartSubtotalTxt);
         Gxwebsession.setValue(Gxids+"gxvar_Cartuseraddress", AV10CartUserAddress.toJSonString(false, true));
         Gxwebsession.setValue(Gxids+"gxvar_Datopago", AV25DatoPago);
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV8CartSubtotalTxt = Gxwebsession.getValue(Gxids+"gxvar_Cartsubtotaltxt") ;
         AV10CartUserAddress.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Cartuseraddress"), null);
         AV25DatoPago = Gxwebsession.getValue(Gxids+"gxvar_Datopago") ;
      }
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartsubtotaltxt( AV8CartSubtotalTxt );
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Cartuseraddress(AV10CartUserAddress);
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Tipopagoid( AV22TipoPagoId );
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Datopago( AV25DatoPago );
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      Gxval_tipopagoid = AV22TipoPagoId ;
      /* Execute user subroutine: Gxdesc_Tipopagoid */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt.setgxTv_SdtMyProductsCartConfirm_Level_DetailSdt_Gxdesc_tipopagoid( Gxdesc_tipopagoid );
      cleanup();
   }

   public void S111( )
   {
      /* Gxdesc_Tipopagoid Routine */
      returnInSub = false ;
      /* Using cursor P00002 */
      pr_default.execute(0, new Object[] {Long.valueOf(Gxval_tipopagoid)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A9TipoPagoId = P00002_A9TipoPagoId[0] ;
         A71TipoPagoNombre = P00002_A71TipoPagoNombre[0] ;
         Gxdesc_tipopagoid = A71TipoPagoNombre ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP1[0] = myproductscartconfirm_level_detail.this.AV33GXM1MyProductsCartConfirm_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33GXM1MyProductsCartConfirm_Level_DetailSdt = new com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV18GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV19ClienteUser = "" ;
      AV5CartProductCollection = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtNMCartProduct1 = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtNMCartProduct2 = new GXBaseCollection[1] ;
      AV7CartSubtotal = DecimalUtil.ZERO ;
      AV15CartProduct = new com.mujermorena.SdtNMCartProduct(remoteHandle, context);
      GXt_SdtWWPProductData3 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      GXv_SdtWWPProductData4 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[1] ;
      AV9ProductPrice = DecimalUtil.ZERO ;
      AV8CartSubtotalTxt = "" ;
      AV10CartUserAddress = new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
      GXt_SdtNMCartUserAddress5 = new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
      GXv_SdtNMCartUserAddress6 = new com.mujermorena.SdtNMCartUserAddress[1] ;
      Gxdynprop = "" ;
      AV25DatoPago = "" ;
      Gxdesc_tipopagoid = "" ;
      scmdbuf = "" ;
      P00002_A9TipoPagoId = new long[1] ;
      P00002_A71TipoPagoNombre = new String[] {""} ;
      A71TipoPagoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.myproductscartconfirm_level_detail__default(),
         new Object[] {
             new Object[] {
            P00002_A9TipoPagoId, P00002_A71TipoPagoNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV27gxid ;
   private int AV36GXV1 ;
   private long AV22TipoPagoId ;
   private long Gxval_tipopagoid ;
   private long A9TipoPagoId ;
   private java.math.BigDecimal AV7CartSubtotal ;
   private java.math.BigDecimal AV9ProductPrice ;
   private String Gxids ;
   private String AV19ClienteUser ;
   private String scmdbuf ;
   private String A71TipoPagoNombre ;
   private boolean returnInSub ;
   private String AV8CartSubtotalTxt ;
   private String Gxdynprop ;
   private String AV25DatoPago ;
   private String Gxdesc_tipopagoid ;
   private com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P00002_A9TipoPagoId ;
   private String[] P00002_A71TipoPagoNombre ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV5CartProductCollection ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> GXt_objcol_SdtNMCartProduct1 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> GXv_objcol_SdtNMCartProduct2[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV18GAMUser ;
   private com.mujermorena.SdtNMCartProduct AV15CartProduct ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData GXt_SdtWWPProductData3 ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData GXv_SdtWWPProductData4[] ;
   private com.mujermorena.SdtNMCartUserAddress AV10CartUserAddress ;
   private com.mujermorena.SdtNMCartUserAddress GXt_SdtNMCartUserAddress5 ;
   private com.mujermorena.SdtNMCartUserAddress GXv_SdtNMCartUserAddress6[] ;
   private com.mujermorena.SdtMyProductsCartConfirm_Level_DetailSdt AV33GXM1MyProductsCartConfirm_Level_DetailSdt ;
}

final  class myproductscartconfirm_level_detail__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00002", "SELECT TOP 1 [TipoPagoId], [TipoPagoNombre] FROM [TipoPago] WHERE [TipoPagoId] = ? ORDER BY [TipoPagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

