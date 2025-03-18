package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verpedidossd_level_detail extends GXProcedure
{
   public verpedidossd_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verpedidossd_level_detail.class ), "" );
   }

   public verpedidossd_level_detail( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtVerPedidosSD_Level_DetailSdt executeUdp( int aP0 )
   {
      verpedidossd_level_detail.this.aP1 = new com.mujermorena.SdtVerPedidosSD_Level_DetailSdt[] {new com.mujermorena.SdtVerPedidosSD_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtVerPedidosSD_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtVerPedidosSD_Level_DetailSdt[] aP1 )
   {
      verpedidossd_level_detail.this.AV19gxid = aP0;
      verpedidossd_level_detail.this.aP1 = aP1;
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
         AV11GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
         AV12ClienteUser = AV11GAMUser.getgxTv_SdtGAMUser_Name() ;
         Gxwebsession.setValue(Gxids+"gxvar_Clienteuser", AV12ClienteUser);
         Gxwebsession.setValue(Gxids+"gxvar_Pedidosid", GXutil.str( AV8PedidosID, 11, 0));
         Gxwebsession.setValue(Gxids+"gxvar_Pedidosfecha", localUtil.dtoc( AV9PedidosFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"));
         Gxwebsession.setValue(Gxids+"gxvar_Pedidostotal", GXutil.str( AV10PedidosTotal, 17, 2));
         Gxwebsession.setValue(Gxids, "true");
      }
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV23GXM1VerPedidosSD_Level_DetailSdt.setgxTv_SdtVerPedidosSD_Level_DetailSdt_Isauthorized_useraction1( AV18IsAuthorized_UserAction1 );
      AV23GXM1VerPedidosSD_Level_DetailSdt.setgxTv_SdtVerPedidosSD_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      cleanup();
   }

   public void S111( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean2 = AV18IsAuthorized_UserAction1 ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "generarfacturasd_Execute", GXv_boolean3) ;
      verpedidossd_level_detail.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV18IsAuthorized_UserAction1 = GXt_boolean2 ;
      if ( ! ( AV18IsAuthorized_UserAction1 ) )
      {
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Useraction1\",\"Visible\",\"" + "False" + "\"]" ;
      }
   }

   protected void cleanup( )
   {
      this.aP1[0] = verpedidossd_level_detail.this.AV23GXM1VerPedidosSD_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23GXM1VerPedidosSD_Level_DetailSdt = new com.mujermorena.SdtVerPedidosSD_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV11GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV12ClienteUser = "" ;
      AV9PedidosFecha = GXutil.nullDate() ;
      AV10PedidosTotal = DecimalUtil.ZERO ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      Gxdynprop = "" ;
      GXv_boolean3 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV19gxid ;
   private long AV8PedidosID ;
   private java.math.BigDecimal AV10PedidosTotal ;
   private String Gxids ;
   private String AV12ClienteUser ;
   private java.util.Date AV9PedidosFecha ;
   private boolean returnInSub ;
   private boolean AV18IsAuthorized_UserAction1 ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Gxdynprop ;
   private com.mujermorena.SdtVerPedidosSD_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV11GAMUser ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.SdtVerPedidosSD_Level_DetailSdt AV23GXM1VerPedidosSD_Level_DetailSdt ;
}

