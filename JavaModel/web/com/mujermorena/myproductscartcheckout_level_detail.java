package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class myproductscartcheckout_level_detail extends GXProcedure
{
   public myproductscartcheckout_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( myproductscartcheckout_level_detail.class ), "" );
   }

   public myproductscartcheckout_level_detail( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt executeUdp( int aP0 )
   {
      myproductscartcheckout_level_detail.this.aP1 = new com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt[] {new com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt[] aP1 )
   {
      myproductscartcheckout_level_detail.this.AV18gxid = aP0;
      myproductscartcheckout_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV18gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxwebsession.setValue(Gxids+"gxvar_Cartsubtotaltxt", AV13CartSubtotalTxt);
         Gxwebsession.setValue(Gxids+"gxvar_Cartproductcollection", AV5CartProductCollection.toJSonString(false));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV5CartProductCollection.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Cartproductcollection"), null);
         AV13CartSubtotalTxt = Gxwebsession.getValue(Gxids+"gxvar_Cartsubtotaltxt") ;
      }
      GXt_objcol_SdtNMCartProduct1 = AV5CartProductCollection ;
      GXv_objcol_SdtNMCartProduct2[0] = GXt_objcol_SdtNMCartProduct1 ;
      new com.mujermorena.nmcartproductslist(remoteHandle, context).execute( GXv_objcol_SdtNMCartProduct2) ;
      GXt_objcol_SdtNMCartProduct1 = GXv_objcol_SdtNMCartProduct2[0] ;
      AV5CartProductCollection = GXt_objcol_SdtNMCartProduct1 ;
      AV9CartSubtotal = DecimalUtil.doubleToDec(0) ;
      AV25GXV1 = 1 ;
      while ( AV25GXV1 <= AV5CartProductCollection.size() )
      {
         AV10CartProduct = (com.mujermorena.SdtNMCartProduct)((com.mujermorena.SdtNMCartProduct)AV5CartProductCollection.elementAt(-1+AV25GXV1));
         GXt_SdtWWPProductData3 = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData();
         GXv_SdtWWPProductData4[0] = GXt_SdtWWPProductData3;
         new com.mujermorena.nmgetproductdata(remoteHandle, context).execute( AV10CartProduct.getgxTv_SdtNMCartProduct_Productid(), GXv_SdtWWPProductData4) ;
         GXt_SdtWWPProductData3 = GXv_SdtWWPProductData4[0] ;
         AV10CartProduct.setgxTv_SdtNMCartProduct_Productdata(GXt_SdtWWPProductData3);
         AV10CartProduct.setgxTv_SdtNMCartProduct_Productdatatitle( AV10CartProduct.getgxTv_SdtNMCartProduct_Productdata().getgxTv_SdtWWPProductData_Title() );
         AV10CartProduct.setgxTv_SdtNMCartProduct_Productdatainformation( AV10CartProduct.getgxTv_SdtNMCartProduct_Productdata().getgxTv_SdtWWPProductData_Information1() );
         AV10CartProduct.setgxTv_SdtNMCartProduct_Productdataimage( AV10CartProduct.getgxTv_SdtNMCartProduct_Productdata().getgxTv_SdtWWPProductData_Image() );
         AV10CartProduct.setgxTv_SdtNMCartProduct_Productdataimage_gxi( AV10CartProduct.getgxTv_SdtNMCartProduct_Productdata().getgxTv_SdtWWPProductData_Image_gxi() );
         AV12ProductPrice = CommonUtil.decimalVal( GXutil.trim( GXutil.strReplace( AV10CartProduct.getgxTv_SdtNMCartProduct_Productdata().getgxTv_SdtWWPProductData_Information1(), "Gs. ", "")), ".") ;
         AV9CartSubtotal = AV9CartSubtotal.add(DecimalUtil.doubleToDec(AV10CartProduct.getgxTv_SdtNMCartProduct_Count()).multiply(AV12ProductPrice)) ;
         AV17Cantidad = localUtil.format( DecimalUtil.doubleToDec(AV10CartProduct.getgxTv_SdtNMCartProduct_Count()), "ZZZ9") ;
         AV25GXV1 = (int)(AV25GXV1+1) ;
      }
      AV13CartSubtotalTxt = "   Gs. " + GXutil.trim( localUtil.format( AV9CartSubtotal, "ZZZZZZZZZZZZZ9.99")) ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV26GXV2 = 1 ;
      while ( AV26GXV2 <= AV5CartProductCollection.size() )
      {
         AV5CartProductCollection.currentItem( ((com.mujermorena.SdtNMCartProduct)AV5CartProductCollection.elementAt(-1+AV26GXV2)) );
         AV26GXV2 = (int)(AV26GXV2+1) ;
      }
      AV22GXM1MyProductsCartCheckout_Level_DetailSdt.setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartsubtotaltxt( AV13CartSubtotalTxt );
      AV22GXM1MyProductsCartCheckout_Level_DetailSdt.setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Cartproductcollection( AV5CartProductCollection );
      AV22GXM1MyProductsCartCheckout_Level_DetailSdt.setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Isauthorized_continue( AV16IsAuthorized_Continue );
      AV22GXM1MyProductsCartCheckout_Level_DetailSdt.setgxTv_SdtMyProductsCartCheckout_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      Gxwebsession.setValue(Gxids+"gxvar_Cartproductcollection", AV5CartProductCollection.toJSonString(false));
      Gxwebsession.setValue(Gxids+"gxvar_Cartsubtotaltxt", AV13CartSubtotalTxt);
      cleanup();
   }

   public void S111( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean5 = AV16IsAuthorized_Continue ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "myproductscartaddress_Execute", GXv_boolean6) ;
      myproductscartcheckout_level_detail.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV16IsAuthorized_Continue = GXt_boolean5 ;
      if ( ! ( AV16IsAuthorized_Continue ) )
      {
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Btncontinue\",\"Visible\",\"" + "False" + "\"]" ;
      }
   }

   protected void cleanup( )
   {
      this.aP1[0] = myproductscartcheckout_level_detail.this.AV22GXM1MyProductsCartCheckout_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22GXM1MyProductsCartCheckout_Level_DetailSdt = new com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV13CartSubtotalTxt = "" ;
      AV5CartProductCollection = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtNMCartProduct1 = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtNMCartProduct2 = new GXBaseCollection[1] ;
      AV9CartSubtotal = DecimalUtil.ZERO ;
      AV10CartProduct = new com.mujermorena.SdtNMCartProduct(remoteHandle, context);
      GXt_SdtWWPProductData3 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      GXv_SdtWWPProductData4 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[1] ;
      AV12ProductPrice = DecimalUtil.ZERO ;
      AV17Cantidad = "" ;
      Gxdynprop = "" ;
      GXv_boolean6 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18gxid ;
   private int AV25GXV1 ;
   private int AV26GXV2 ;
   private java.math.BigDecimal AV9CartSubtotal ;
   private java.math.BigDecimal AV12ProductPrice ;
   private String Gxids ;
   private String AV17Cantidad ;
   private boolean returnInSub ;
   private boolean AV16IsAuthorized_Continue ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private String AV13CartSubtotalTxt ;
   private String Gxdynprop ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV5CartProductCollection ;
   private com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> GXt_objcol_SdtNMCartProduct1 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> GXv_objcol_SdtNMCartProduct2[] ;
   private com.mujermorena.SdtNMCartProduct AV10CartProduct ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData GXt_SdtWWPProductData3 ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData GXv_SdtWWPProductData4[] ;
   private com.mujermorena.SdtMyProductsCartCheckout_Level_DetailSdt AV22GXM1MyProductsCartCheckout_Level_DetailSdt ;
}

