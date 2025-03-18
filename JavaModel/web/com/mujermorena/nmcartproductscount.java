package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartproductscount extends GXProcedure
{
   public nmcartproductscount( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartproductscount.class ), "" );
   }

   public nmcartproductscount( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      nmcartproductscount.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      nmcartproductscount.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_SdtNMCartProduct1 = AV9ProductsInCart ;
      GXv_objcol_SdtNMCartProduct2[0] = GXt_objcol_SdtNMCartProduct1 ;
      new com.mujermorena.nmcartproductslist(remoteHandle, context).execute( GXv_objcol_SdtNMCartProduct2) ;
      GXt_objcol_SdtNMCartProduct1 = GXv_objcol_SdtNMCartProduct2[0] ;
      AV9ProductsInCart = GXt_objcol_SdtNMCartProduct1 ;
      AV8Count = (short)(AV9ProductsInCart.size()) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = nmcartproductscount.this.AV8Count;
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
      GXt_objcol_SdtNMCartProduct1 = new GXBaseCollection<com.mujermorena.SdtNMCartProduct>(com.mujermorena.SdtNMCartProduct.class, "NMCartProduct", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtNMCartProduct2 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8Count ;
   private short Gx_err ;
   private short[] aP0 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> AV9ProductsInCart ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> GXt_objcol_SdtNMCartProduct1 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartProduct> GXv_objcol_SdtNMCartProduct2[] ;
}

