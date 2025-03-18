package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenasdhometab1_level_detail extends GXProcedure
{
   public mujermorenasdhometab1_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenasdhometab1_level_detail.class ), "" );
   }

   public mujermorenasdhometab1_level_detail( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt executeUdp( int aP0 )
   {
      mujermorenasdhometab1_level_detail.this.aP1 = new com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt[] {new com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt[] aP1 )
   {
      mujermorenasdhometab1_level_detail.this.AV19gxid = aP0;
      mujermorenasdhometab1_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV19gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         /* Execute user subroutine: 'FILTER1_SELECT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_objcol_SdtSimpleListData_SimpleListDataItem1 = AV17Banner_Items ;
         GXv_objcol_SdtSimpleListData_SimpleListDataItem2[0] = GXt_objcol_SdtSimpleListData_SimpleListDataItem1 ;
         new com.mujermorena.workwithplus.nativemobile.templatebannerdp(remoteHandle, context).execute( GXv_objcol_SdtSimpleListData_SimpleListDataItem2) ;
         GXt_objcol_SdtSimpleListData_SimpleListDataItem1 = GXv_objcol_SdtSimpleListData_SimpleListDataItem2[0] ;
         AV17Banner_Items = GXt_objcol_SdtSimpleListData_SimpleListDataItem1 ;
         AV10Banner_Count = (short)(AV17Banner_Items.size()) ;
         Gxdynpropparms = new GXSimpleCollection<String>(String.class, "internal", "") ;
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"&Banner_chronometer\",\"start\"," + Gxdynpropparms.toJSonString(false) + "]" ;
         AV18A = (short)(1) ;
         Gxwebsession.setValue(Gxids+"gxvar_Banner_items", AV17Banner_Items.toJSonString(false));
         Gxwebsession.setValue(Gxids+"gxvar_Banner_chronometer", GXutil.str( AV16Banner_Chronometer, 4, 0));
         Gxwebsession.setValue(Gxids+"gxvar_Products", AV14Products.toJSonString(false));
         Gxwebsession.setValue(Gxids+"gxvar_Banner_count", GXutil.str( AV10Banner_Count, 4, 0));
         Gxwebsession.setValue(Gxids+"gxvar_A", GXutil.str( AV18A, 4, 0));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV14Products.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Products"), null);
         AV17Banner_Items.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Banner_items"), null);
         AV10Banner_Count = (short)(GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Banner_count"))) ;
         AV16Banner_Chronometer = (short)(GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_Banner_chronometer"))) ;
         AV18A = (short)(GXutil.lval( Gxwebsession.getValue(Gxids+"gxvar_A"))) ;
      }
      GXt_char3 = AV8TabBarSelected ;
      GXv_char4[0] = GXt_char3 ;
      new com.mujermorena.workwithplus.nativemobile.wwpwebserversessionget(remoteHandle, context).execute( "&TabBarSelected", GXv_char4) ;
      mujermorenasdhometab1_level_detail.this.GXt_char3 = GXv_char4[0] ;
      AV8TabBarSelected = GXt_char3 ;
      GXt_objcol_SdtWWPProductData5 = AV14Products ;
      GXv_objcol_SdtWWPProductData6[0] = GXt_objcol_SdtWWPProductData5 ;
      new com.mujermorena.workwithplus.nativemobile.exampleproductslistdp(remoteHandle, context).execute( GXv_objcol_SdtWWPProductData6) ;
      GXt_objcol_SdtWWPProductData5 = GXv_objcol_SdtWWPProductData6[0] ;
      AV14Products = GXt_objcol_SdtWWPProductData5 ;
      AV13BannerImage = context.getHttpContext().getImagePath( "deee6e1a-b96e-4d67-94a1-0aa908137d42", "", context.getHttpContext().getTheme( )) ;
      AV27Bannerimage_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "deee6e1a-b96e-4d67-94a1-0aa908137d42", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      AV28GXV1 = 1 ;
      while ( AV28GXV1 <= AV17Banner_Items.size() )
      {
         AV17Banner_Items.currentItem( ((com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)AV17Banner_Items.elementAt(-1+AV28GXV1)) );
         AV28GXV1 = (int)(AV28GXV1+1) ;
      }
      AV29GXV2 = 1 ;
      while ( AV29GXV2 <= AV14Products.size() )
      {
         AV14Products.currentItem( ((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)AV14Products.elementAt(-1+AV29GXV2)) );
         AV29GXV2 = (int)(AV29GXV2+1) ;
      }
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items( AV17Banner_Items );
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer( AV16Banner_Chronometer );
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products( AV14Products );
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A( AV18A );
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count( AV10Banner_Count );
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      Gxwebsession.setValue(Gxids+"gxvar_Products", AV14Products.toJSonString(false));
      cleanup();
   }

   public void S111( )
   {
      /* 'FILTER1_SELECT' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = mujermorenasdhometab1_level_detail.this.AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt = new com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV17Banner_Items = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListDataItem", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtSimpleListData_SimpleListDataItem1 = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListDataItem", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtSimpleListData_SimpleListDataItem2 = new GXBaseCollection[1] ;
      Gxdynpropparms = new GXSimpleCollection<String>(String.class, "internal", "");
      Gxdynprop = "" ;
      AV14Products = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      AV8TabBarSelected = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      GXt_objcol_SdtWWPProductData5 = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtWWPProductData6 = new GXBaseCollection[1] ;
      AV13BannerImage = "" ;
      AV27Bannerimage_GXI = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10Banner_Count ;
   private short AV18A ;
   private short AV16Banner_Chronometer ;
   private short Gx_err ;
   private int AV19gxid ;
   private int AV28GXV1 ;
   private int AV29GXV2 ;
   private String Gxids ;
   private String AV8TabBarSelected ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private boolean returnInSub ;
   private String Gxdynprop ;
   private String AV27Bannerimage_GXI ;
   private String AV13BannerImage ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> AV14Products ;
   private com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXSimpleCollection<String> Gxdynpropparms ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> AV17Banner_Items ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> GXt_objcol_SdtSimpleListData_SimpleListDataItem1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> GXv_objcol_SdtSimpleListData_SimpleListDataItem2[] ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> GXt_objcol_SdtWWPProductData5 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> GXv_objcol_SdtWWPProductData6[] ;
   private com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt AV24GXM1MujerMorenaSDHomeTab1_Level_DetailSdt ;
}

