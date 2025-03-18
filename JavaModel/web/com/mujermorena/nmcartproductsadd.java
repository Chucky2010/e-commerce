package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartproductsadd extends GXProcedure
{
   public nmcartproductsadd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartproductsadd.class ), "" );
   }

   public nmcartproductsadd( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            short aP1 ,
                            short aP2 ,
                            short aP3 ,
                            short[] aP4 )
   {
      nmcartproductsadd.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        short aP2 ,
                        short aP3 ,
                        short[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             short aP2 ,
                             short aP3 ,
                             short[] aP4 ,
                             short[] aP5 )
   {
      nmcartproductsadd.this.AV10ProductId = aP0;
      nmcartproductsadd.this.AV9Count = aP1;
      nmcartproductsadd.this.AV15Talle = aP2;
      nmcartproductsadd.this.AV20ProductDispon = aP3;
      nmcartproductsadd.this.aP4 = aP4;
      nmcartproductsadd.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13ProductsInCartTxt = AV8WebSession.getValue("ProductsInCart") ;
      AV11ProductsInCart.fromJSonString(AV13ProductsInCartTxt, null);
      AV17Result = (short)(0) ;
      AV21Existe = (short)(0) ;
      AV24GXV1 = 1 ;
      while ( AV24GXV1 <= AV11ProductsInCart.size() )
      {
         AV12ProductsInCartItem = (com.mujermorena.SdtNMCartProduct)((com.mujermorena.SdtNMCartProduct)AV11ProductsInCart.elementAt(-1+AV24GXV1));
         if ( GXutil.strcmp(AV12ProductsInCartItem.getgxTv_SdtNMCartProduct_Productid(), AV10ProductId) == 0 )
         {
            if ( AV12ProductsInCartItem.getgxTv_SdtNMCartProduct_Talla() == AV15Talle )
            {
               AV12ProductsInCartItem.setgxTv_SdtNMCartProduct_Count( (short)(AV12ProductsInCartItem.getgxTv_SdtNMCartProduct_Count()+AV9Count) );
               AV21Existe = (short)(1) ;
               if (true) break;
            }
         }
         AV24GXV1 = (int)(AV24GXV1+1) ;
      }
      if ( AV21Existe == 0 )
      {
         AV12ProductsInCartItem = (com.mujermorena.SdtNMCartProduct)new com.mujermorena.SdtNMCartProduct(remoteHandle, context);
         AV12ProductsInCartItem.setgxTv_SdtNMCartProduct_Productid( AV10ProductId );
         AV12ProductsInCartItem.setgxTv_SdtNMCartProduct_Count( AV9Count );
         AV12ProductsInCartItem.setgxTv_SdtNMCartProduct_Talla( AV15Talle );
         AV11ProductsInCart.add(AV12ProductsInCartItem, 0);
      }
      AV13ProductsInCartTxt = AV11ProductsInCart.toJSonString(false) ;
      AV8WebSession.setValue("ProductsInCart", AV13ProductsInCartTxt);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = nmcartproductsadd.this.AV17Result;
      this.aP5[0] = nmcartproductsadd.this.AV19Saldo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ProductsInCartTxt = "" ;
      AV8WebSession = httpContext.getWebSession();
      AV11ProductsInCart = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      AV12ProductsInCartItem = new com.mujermorena.SdtNMCartProduct(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9Count ;
   private short AV15Talle ;
   private short AV20ProductDispon ;
   private short AV17Result ;
   private short AV19Saldo ;
   private short AV21Existe ;
   private short Gx_err ;
   private int AV24GXV1 ;
   private String AV10ProductId ;
   private String AV13ProductsInCartTxt ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private short[] aP5 ;
   private short[] aP4 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV11ProductsInCart ;
   private com.mujermorena.SdtNMCartProduct AV12ProductsInCartItem ;
}

