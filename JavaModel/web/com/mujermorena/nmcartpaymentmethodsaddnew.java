package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartpaymentmethodsaddnew extends GXProcedure
{
   public nmcartpaymentmethodsaddnew( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartpaymentmethodsaddnew.class ), "" );
   }

   public nmcartpaymentmethodsaddnew( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      nmcartpaymentmethodsaddnew.this.AV10CardInformationJson = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9CardInformation.fromJSonString(AV10CardInformationJson, null);
      GXt_objcol_SdtNMCartPayment1 = AV12CartPaymentCollection ;
      GXv_objcol_SdtNMCartPayment2[0] = GXt_objcol_SdtNMCartPayment1 ;
      new com.mujermorena.nmcartpaymentmethodsgetavailable(remoteHandle, context).execute( GXv_objcol_SdtNMCartPayment2) ;
      GXt_objcol_SdtNMCartPayment1 = GXv_objcol_SdtNMCartPayment2[0] ;
      AV12CartPaymentCollection = GXt_objcol_SdtNMCartPayment1 ;
      AV13SessionTxt = AV12CartPaymentCollection.toJSonString(false) ;
      AV8WebSession.setValue("PaymentMethods", AV13SessionTxt);
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
      AV9CardInformation = new com.genexuscore.genexus.sd.SdtCardInformation(remoteHandle, context);
      AV12CartPaymentCollection = new GXBaseCollection<com.mujermorena.SdtNMCartPayment>(com.mujermorena.SdtNMCartPayment.class, "NMCartPayment", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtNMCartPayment1 = new GXBaseCollection<com.mujermorena.SdtNMCartPayment>(com.mujermorena.SdtNMCartPayment.class, "NMCartPayment", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtNMCartPayment2 = new GXBaseCollection[1] ;
      AV13SessionTxt = "" ;
      AV8WebSession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10CardInformationJson ;
   private String AV13SessionTxt ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartPayment> AV12CartPaymentCollection ;
   private GXBaseCollection<com.mujermorena.SdtNMCartPayment> GXt_objcol_SdtNMCartPayment1 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartPayment> GXv_objcol_SdtNMCartPayment2[] ;
   private com.genexuscore.genexus.sd.SdtCardInformation AV9CardInformation ;
}

