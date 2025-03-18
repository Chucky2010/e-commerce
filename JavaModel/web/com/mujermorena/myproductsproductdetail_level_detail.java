package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class myproductsproductdetail_level_detail extends GXProcedure
{
   public myproductsproductdetail_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( myproductsproductdetail_level_detail.class ), "" );
   }

   public myproductsproductdetail_level_detail( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt executeUdp( String aP0 ,
                                                                                 int aP1 )
   {
      myproductsproductdetail_level_detail.this.aP2 = new com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt[] {new com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt[] aP2 )
   {
      myproductsproductdetail_level_detail.this.AV6ProductId = aP0;
      myproductsproductdetail_level_detail.this.AV22gxid = aP1;
      myproductsproductdetail_level_detail.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV22gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         GXt_SdtWWPProductData1 = AV5ProductData;
         GXv_SdtWWPProductData2[0] = GXt_SdtWWPProductData1;
         new com.mujermorena.nmgetproductdata(remoteHandle, context).execute( AV6ProductId, GXv_SdtWWPProductData2) ;
         GXt_SdtWWPProductData1 = GXv_SdtWWPProductData2[0] ;
         AV5ProductData = GXt_SdtWWPProductData1;
         Gxdynprop1 = AV5ProductData.getgxTv_SdtWWPProductData_Title() ;
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Form\",\"Caption\",\"" + GXutil.encodeJSON( Gxdynprop1) + "\"]" ;
         AV7Rating = (short)(4) ;
         GXt_objcol_SdtWWPProductDataImages3 = AV9ProductDataImages ;
         GXv_objcol_SdtWWPProductDataImages4[0] = GXt_objcol_SdtWWPProductDataImages3 ;
         new com.mujermorena.nmcartproductimages(remoteHandle, context).execute( AV5ProductData.getgxTv_SdtWWPProductData_Id(), GXv_objcol_SdtWWPProductDataImages4) ;
         GXt_objcol_SdtWWPProductDataImages3 = GXv_objcol_SdtWWPProductDataImages4[0] ;
         AV9ProductDataImages = GXt_objcol_SdtWWPProductDataImages3 ;
         if ( AV9ProductDataImages.size() == 0 )
         {
            AV10ProductDataImage.setgxTv_SdtWWPProductDataImages_Image( AV5ProductData.getgxTv_SdtWWPProductData_Image() );
            AV10ProductDataImage.setgxTv_SdtWWPProductDataImages_Image_gxi( AV5ProductData.getgxTv_SdtWWPProductData_Image_gxi() );
            AV9ProductDataImages.add(AV10ProductDataImage, 1);
         }
         Gxwebsession.setValue(Gxids+"gxvar_Productdataimages", AV9ProductDataImages.toJSonString(false));
         Gxwebsession.setValue(Gxids+"gxvar_Productdata", AV5ProductData.toJSonString(false, true));
         Gxwebsession.setValue(Gxids+"gxvar_Rating", GXutil.str( AV7Rating, 4, 0));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV5ProductData.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Productdata"), null);
         AV7Rating = (short)(GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Rating"))) ;
         AV9ProductDataImages.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Productdataimages"), null);
      }
      AV32GXV1 = 1 ;
      while ( AV32GXV1 <= AV9ProductDataImages.size() )
      {
         AV9ProductDataImages.currentItem( ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)AV9ProductDataImages.elementAt(-1+AV32GXV1)) );
         AV32GXV1 = (int)(AV32GXV1+1) ;
      }
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages( AV9ProductDataImages );
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata(AV5ProductData);
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating( AV7Rating );
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad( AV16Cantidad );
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle( AV18Talle );
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon( AV19ProductDispon );
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid( AV6ProductId );
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      Gxval_talle = AV18Talle ;
      /* Execute user subroutine: Gxdesc_Talle */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV29GXM2MyProductsProductDetail_Level_DetailSdt.setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle( Gxdesc_talle );
      cleanup();
   }

   public void S111( )
   {
      /* Gxdesc_Talle Routine */
      returnInSub = false ;
      /* Using cursor P00002 */
      pr_default.execute(0, new Object[] {Long.valueOf(Gxval_talle)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A286TallaID = P00002_A286TallaID[0] ;
         A288TallaNumero = P00002_A288TallaNumero[0] ;
         Gxdesc_talle = GXutil.str( A288TallaNumero, 4, 0) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP2[0] = myproductsproductdetail_level_detail.this.AV29GXM2MyProductsProductDetail_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29GXM2MyProductsProductDetail_Level_DetailSdt = new com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV5ProductData = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      GXt_SdtWWPProductData1 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      GXv_SdtWWPProductData2 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[1] ;
      Gxdynprop1 = "" ;
      Gxdynprop = "" ;
      AV9ProductDataImages = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtWWPProductDataImages3 = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtWWPProductDataImages4 = new GXBaseCollection[1] ;
      AV10ProductDataImage = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages(remoteHandle, context);
      Gxdesc_talle = "" ;
      scmdbuf = "" ;
      P00002_A286TallaID = new long[1] ;
      P00002_A288TallaNumero = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.myproductsproductdetail_level_detail__default(),
         new Object[] {
             new Object[] {
            P00002_A286TallaID, P00002_A288TallaNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV7Rating ;
   private short AV19ProductDispon ;
   private short A288TallaNumero ;
   private short Gx_err ;
   private int AV22gxid ;
   private int AV32GXV1 ;
   private int AV16Cantidad ;
   private int AV18Talle ;
   private long Gxval_talle ;
   private long A286TallaID ;
   private String Gxids ;
   private String scmdbuf ;
   private boolean returnInSub ;
   private String AV6ProductId ;
   private String Gxdynprop1 ;
   private String Gxdynprop ;
   private String Gxdesc_talle ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages AV10ProductDataImage ;
   private com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt[] aP2 ;
   private IDataStoreProvider pr_default ;
   private long[] P00002_A286TallaID ;
   private short[] P00002_A288TallaNumero ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> AV9ProductDataImages ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> GXt_objcol_SdtWWPProductDataImages3 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> GXv_objcol_SdtWWPProductDataImages4[] ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData AV5ProductData ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData GXt_SdtWWPProductData1 ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData GXv_SdtWWPProductData2[] ;
   private com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt AV29GXM2MyProductsProductDetail_Level_DetailSdt ;
}

final  class myproductsproductdetail_level_detail__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00002", "SELECT TOP 1 [TallaID], [TallaNumero] FROM [Talla] WHERE [TallaID] = ? ORDER BY [TallaID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
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

