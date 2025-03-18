package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class templateusersettingsdp extends GXProcedure
{
   public templateusersettingsdp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( templateusersettingsdp.class ), "" );
   }

   public templateusersettingsdp( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> executeUdp( )
   {
      templateusersettingsdp.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>[] aP0 )
   {
      templateusersettingsdp.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(1) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Home", "") );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f015", GXv_char2) ;
      templateusersettingsdp.this.GXt_char1 = GXv_char2[0] ;
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?1" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(1) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount( (short)(1) );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(2) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Account balance", "") );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f24e", GXv_char2) ;
      templateusersettingsdp.this.GXt_char1 = GXv_char2[0] ;
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?2" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(0) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Information( "$ 1.000" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount( (short)(3) );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(3) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Settings", "") );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f085", GXv_char2) ;
      templateusersettingsdp.this.GXt_char1 = GXv_char2[0] ;
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?3" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(0) );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(4) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Credit", "") );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f53c", GXv_char2) ;
      templateusersettingsdp.this.GXt_char1 = GXv_char2[0] ;
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?4" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(0) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Information( "$ 990" );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(5) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Share", "") );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f1e0", GXv_char2) ;
      templateusersettingsdp.this.GXt_char1 = GXv_char2[0] ;
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?5" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(1) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount( (short)(5) );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(6) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Web site", "") );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?6" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(2) );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(7) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Twitter", "") );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?7" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(2) );
      Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1menuoptions, 0);
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(8) );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Other", "") );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?8" );
      Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(2) );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = templateusersettingsdp.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      Gxm1menuoptions = new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>[] aP0 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> Gxm2rootcol ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem Gxm1menuoptions ;
}

