package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartproductsremove extends GXProcedure
{
   public nmcartproductsremove( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartproductsremove.class ), "" );
   }

   public nmcartproductsremove( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             short aP1 )
   {
      nmcartproductsremove.this.AV10ProductId = aP0;
      nmcartproductsremove.this.AV9Count = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13ProductsInCartTxt = AV8WebSession.getValue("ProductsInCart") ;
      AV11ProductsInCart.fromJSonString(AV13ProductsInCartTxt, null);
      AV14Index = (short)(0) ;
      AV17GXV1 = 1 ;
      while ( AV17GXV1 <= AV11ProductsInCart.size() )
      {
         AV12ProductsInCartItem = (com.mujermorena.SdtNMCartProduct)((com.mujermorena.SdtNMCartProduct)AV11ProductsInCart.elementAt(-1+AV17GXV1));
         AV14Index = (short)(AV14Index+1) ;
         if ( GXutil.strcmp(AV10ProductId, AV12ProductsInCartItem.getgxTv_SdtNMCartProduct_Productid()) == 0 )
         {
            AV11ProductsInCart.removeItem(AV14Index);
            if (true) break;
         }
         AV17GXV1 = (int)(AV17GXV1+1) ;
      }
      AV13ProductsInCartTxt = AV11ProductsInCart.toJSonString(false) ;
      AV8WebSession.setValue("ProductsInCart", AV13ProductsInCartTxt);
      cleanup();
   }

   protected void cleanup( )
   {
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
   private short AV14Index ;
   private short Gx_err ;
   private int AV17GXV1 ;
   private String AV10ProductId ;
   private String AV13ProductsInCartTxt ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV11ProductsInCart ;
   private com.mujermorena.SdtNMCartProduct AV12ProductsInCartItem ;
}

