package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartpaymentmethodsgetavailable extends GXProcedure
{
   public nmcartpaymentmethodsgetavailable( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartpaymentmethodsgetavailable.class ), "" );
   }

   public nmcartpaymentmethodsgetavailable( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.SdtNMCartPayment> executeUdp( )
   {
      nmcartpaymentmethodsgetavailable.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.SdtNMCartPayment>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.SdtNMCartPayment>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.SdtNMCartPayment>[] aP0 )
   {
      nmcartpaymentmethodsgetavailable.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11SessionTxt = AV8WebSession.getValue("PaymentMethods") ;
      AV10CartPaymentCollection.fromJSonString(AV11SessionTxt, null);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = nmcartpaymentmethodsgetavailable.this.AV10CartPaymentCollection;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10CartPaymentCollection = new GXBaseCollection<com.mujermorena.SdtNMCartPayment>(com.mujermorena.SdtNMCartPayment.class, "NMCartPayment", "Mujer_Morena", remoteHandle);
      AV11SessionTxt = "" ;
      AV8WebSession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV11SessionTxt ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartPayment>[] aP0 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartPayment> AV10CartPaymentCollection ;
}

