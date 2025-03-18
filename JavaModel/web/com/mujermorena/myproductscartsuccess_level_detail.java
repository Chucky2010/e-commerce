package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class myproductscartsuccess_level_detail extends GXProcedure
{
   public myproductscartsuccess_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( myproductscartsuccess_level_detail.class ), "" );
   }

   public myproductscartsuccess_level_detail( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt executeUdp( int aP0 )
   {
      myproductscartsuccess_level_detail.this.aP1 = new com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt[] {new com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt[] aP1 )
   {
      myproductscartsuccess_level_detail.this.AV15gxid = aP0;
      myproductscartsuccess_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV15gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxwebsession.setValue(Gxids, "true");
      }
      AV18GXM1MyProductsCartSuccess_Level_DetailSdt.setgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro( AV14CalificacionNro );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = myproductscartsuccess_level_detail.this.AV18GXM1MyProductsCartSuccess_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18GXM1MyProductsCartSuccess_Level_DetailSdt = new com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14CalificacionNro ;
   private short Gx_err ;
   private int AV15gxid ;
   private String Gxids ;
   private com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt AV18GXM1MyProductsCartSuccess_Level_DetailSdt ;
}

