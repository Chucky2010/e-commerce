package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmgetproductdata extends GXProcedure
{
   public nmgetproductdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmgetproductdata.class ), "" );
   }

   public nmgetproductdata( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductData executeUdp( String aP0 )
   {
      nmgetproductdata.this.aP1 = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[] {new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[] aP1 )
   {
      nmgetproductdata.this.AV8ProductId = aP0;
      nmgetproductdata.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_SdtWWPProductData1 = AV10ProductDataListAll ;
      GXv_objcol_SdtWWPProductData2[0] = GXt_objcol_SdtWWPProductData1 ;
      new com.mujermorena.workwithplus.nativemobile.exampleproductslistdp(remoteHandle, context).execute( GXv_objcol_SdtWWPProductData2) ;
      GXt_objcol_SdtWWPProductData1 = GXv_objcol_SdtWWPProductData2[0] ;
      AV10ProductDataListAll = GXt_objcol_SdtWWPProductData1 ;
      AV14GXV1 = 1 ;
      while ( AV14GXV1 <= AV10ProductDataListAll.size() )
      {
         AV9ProductData = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)AV10ProductDataListAll.elementAt(-1+AV14GXV1));
         if ( GXutil.strcmp(AV9ProductData.getgxTv_SdtWWPProductData_Id(), AV8ProductId) == 0 )
         {
            if ( (GXutil.strcmp("", AV9ProductData.getgxTv_SdtWWPProductData_Description())==0) )
            {
               AV9ProductData.setgxTv_SdtWWPProductData_Description( AV9ProductData.getgxTv_SdtWWPProductData_Subtitle() );
            }
            if (true) break;
         }
         AV14GXV1 = (int)(AV14GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = nmgetproductdata.this.AV9ProductData;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProductData = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      AV10ProductDataListAll = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtWWPProductData1 = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtWWPProductData2 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14GXV1 ;
   private String AV8ProductId ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData[] aP1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> AV10ProductDataListAll ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> GXt_objcol_SdtWWPProductData1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> GXv_objcol_SdtWWPProductData2[] ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData AV9ProductData ;
}

