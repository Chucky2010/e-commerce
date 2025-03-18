package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenasdoptionsdp extends GXProcedure
{
   public mujermorenasdoptionsdp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenasdoptionsdp.class ), "" );
   }

   public mujermorenasdoptionsdp( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> executeUdp( )
   {
      mujermorenasdoptionsdp.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>[] aP0 )
   {
      mujermorenasdoptionsdp.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( new com.mujermorena.workwithplus.nativemobile.gamisauthbyfunctionalitykey(remoteHandle, context).executeUdp( "MujerMorenaSDHome"+"_Execute") )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
         Gxm2rootcol.add(Gxm1menuoptions, 0);
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Id( "MujerMorenaSDHome" );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Home", "") );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:MujerMorenaSDHome" );
         GXt_char1 = "" ;
         GXv_char2[0] = GXt_char1 ;
         new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f015", GXv_char2) ;
         mujermorenasdoptionsdp.this.GXt_char1 = GXv_char2[0] ;
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(0) );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(0) );
      }
      if ( new com.mujermorena.workwithplus.nativemobile.gamisauthbyfunctionalitykey(remoteHandle, context).executeUdp( "VerPedidosSD"+"_Execute") )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         Gxm1menuoptions = (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(remoteHandle, context);
         Gxm2rootcol.add(Gxm1menuoptions, 0);
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Id( "VerPedidosSD" );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Title( httpContext.getMessage( "Lista de Pedidos", "") );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( "sd:VerPedidosSD" );
         GXt_char1 = "" ;
         GXv_char2[0] = GXt_char1 ;
         new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f015", GXv_char2) ;
         mujermorenasdoptionsdp.this.GXt_char1 = GXv_char2[0] ;
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( GXt_char1 );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Type( (short)(0) );
         Gxm1menuoptions.setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( (short)(1) );
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = mujermorenasdoptionsdp.this.Gxm2rootcol;
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
   private boolean Cond_result ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>[] aP0 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> Gxm2rootcol ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem Gxm1menuoptions ;
}

