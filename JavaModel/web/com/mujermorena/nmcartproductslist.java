package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartproductslist extends GXProcedure
{
   public nmcartproductslist( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartproductslist.class ), "" );
   }

   public nmcartproductslist( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.SdtNMCartProduct> executeUdp( )
   {
      nmcartproductslist.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.SdtNMCartProduct>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.SdtNMCartProduct>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.SdtNMCartProduct>[] aP0 )
   {
      nmcartproductslist.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ProductsInCartTxt = AV8WebSession.getValue("ProductsInCart") ;
      AV9ProductsInCart.fromJSonString(AV10ProductsInCartTxt, null);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = nmcartproductslist.this.AV9ProductsInCart;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProductsInCart = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      AV10ProductsInCartTxt = "" ;
      AV8WebSession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10ProductsInCartTxt ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct>[] aP0 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV9ProductsInCart ;
}

