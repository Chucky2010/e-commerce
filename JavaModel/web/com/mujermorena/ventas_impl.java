package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ventas_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"VENTASID") == 0 )
      {
         AV14VentasId = GXutil.lval( httpContext.GetPar( "VentasId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14VentasId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVENTASID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14VentasId), "ZZZZZZZZZZ9")));
         AV17Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx8asaventasid0H16( AV14VentasId, AV17Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"TIMBRADOID") == 0 )
      {
         AV16Insert_TimbradoId = GXutil.lval( httpContext.GetPar( "Insert_TimbradoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_TimbradoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx12asatimbradoid0H16( AV16Insert_TimbradoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel18"+"_"+"VENTASNROFACTURA") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx18asaventasnrofactura0H16( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel19"+"_"+"VENTASSERIE1") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx19asaventasserie10H16( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel20"+"_"+"VENTASSERIE2") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx20asaventasserie20H16( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_43") == 0 )
      {
         A19VentasId = GXutil.lval( httpContext.GetPar( "VentasId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_43( A19VentasId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_40") == 0 )
      {
         A4ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_40( A4ClienteId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_42") == 0 )
      {
         A29TimbradoId = GXutil.lval( httpContext.GetPar( "TimbradoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_42( A29TimbradoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_41") == 0 )
      {
         A9TipoPagoId = GXutil.lval( httpContext.GetPar( "TipoPagoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_41( A9TipoPagoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_45") == 0 )
      {
         A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_45( A13ArticuloId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_46") == 0 )
      {
         A18ImpuestoId = GXutil.lval( httpContext.GetPar( "ImpuestoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_46( A18ImpuestoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_detalle") == 0 )
      {
         gxnrgridlevel_detalle_newrow_invoke( ) ;
         return  ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV14VentasId = GXutil.lval( httpContext.GetPar( "VentasId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14VentasId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVENTASID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14VentasId), "ZZZZZZZZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Ventas", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtVentasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_detalle_newrow_invoke( )
   {
      nRC_GXsfl_107 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_107"))) ;
      nGXsfl_107_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_107_idx"))) ;
      sGXsfl_107_idx = httpContext.GetPar( "sGXsfl_107_idx") ;
      A242VentasSerial = GXutil.lval( httpContext.GetPar( "VentasSerial")) ;
      Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_detalle_newrow( ) ;
      /* End function gxnrGridlevel_detalle_newrow_invoke */
   }

   public ventas_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ventas_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ventas_impl.class ));
   }

   public ventas_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.mujermorena.wwpbaseobjects.workwithplusmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Ventas", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasId_Internalname, GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasFecha_Internalname, httpContext.getMessage( "Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtVentasFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasFecha_Internalname, localUtil.format(A91VentasFecha, "99/99/99"), localUtil.format( A91VentasFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtVentasFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtVentasFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtVentasFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Ventas.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteId_Internalname, httpContext.getMessage( "Cliente Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtClienteId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Ventas.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_4_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_4_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_4_Internalname, sImgUrl, imgprompt_4_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_4_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasSerial_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasSerial_Internalname, httpContext.getMessage( "Serial", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasSerial_Internalname, GXutil.ltrim( localUtil.ntoc( A242VentasSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasSerial_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A242VentasSerial), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A242VentasSerial), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasSerial_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasSerial_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Serial", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalExento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalExento_Internalname, httpContext.getMessage( "Total Exento", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalExento_Internalname, GXutil.ltrim( localUtil.ntoc( A239VentasTotalExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalExento_Enabled!=0) ? localUtil.format( A239VentasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A239VentasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalExento_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotalExento_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotal5_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotal5_Internalname, httpContext.getMessage( "Total5", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotal5_Internalname, GXutil.ltrim( localUtil.ntoc( A236VentasTotal5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotal5_Enabled!=0) ? localUtil.format( A236VentasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A236VentasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotal5_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotal5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotal10_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotal10_Internalname, httpContext.getMessage( "Total10", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotal10_Internalname, GXutil.ltrim( localUtil.ntoc( A238VentasTotal10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotal10_Enabled!=0) ? localUtil.format( A238VentasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A238VentasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotal10_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotal10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A240VentasTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotal_Enabled!=0) ? localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalIva5_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalIva5_Internalname, httpContext.getMessage( "Total Iva5", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A235VentasTotalIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalIva5_Enabled!=0) ? localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalIva5_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotalIva5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalIva10_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalIva10_Internalname, httpContext.getMessage( "Total Iva10", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A237VentasTotalIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalIva10_Enabled!=0) ? localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalIva10_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotalIva10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalIVA_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalIVA_Internalname, httpContext.getMessage( "Total IVA", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalIVA_Internalname, GXutil.ltrim( localUtil.ntoc( A241VentasTotalIVA, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalIVA_Enabled!=0) ? localUtil.format( A241VentasTotalIVA, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A241VentasTotalIVA, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalIVA_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasTotalIVA_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasPedido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasPedido_Internalname, httpContext.getMessage( "Pedido", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasPedido_Internalname, GXutil.ltrim( localUtil.ntoc( A251VentasPedido, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasPedido_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A251VentasPedido), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A251VentasPedido), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasPedido_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasPedido_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoPagoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoPagoId_Internalname, httpContext.getMessage( "Tipo Pago Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoPagoId_Internalname, GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoPagoId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTipoPagoId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Ventas.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_9_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_9_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_9_Internalname, sImgUrl, imgprompt_9_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_9_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoId_Internalname, httpContext.getMessage( "Timbrado Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoId_Internalname, GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Ventas.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_29_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_29_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_29_Internalname, sImgUrl, imgprompt_29_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_29_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNumero_Internalname, httpContext.getMessage( "Timbrado Numero", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNumero_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNumero_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Numero", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasSerie1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasSerie1_Internalname, httpContext.getMessage( "Serie1", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasSerie1_Internalname, GXutil.ltrim( localUtil.ntoc( A309VentasSerie1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasSerie1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A309VentasSerie1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A309VentasSerie1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,92);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasSerie1_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasSerie1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "SerieFac", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasSerie2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasSerie2_Internalname, httpContext.getMessage( "Serie2", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasSerie2_Internalname, GXutil.ltrim( localUtil.ntoc( A310VentasSerie2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasSerie2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A310VentasSerie2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A310VentasSerie2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasSerie2_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasSerie2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "SerieFac", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasNroFactura_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasNroFactura_Internalname, httpContext.getMessage( "Nro Factura", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasNroFactura_Internalname, GXutil.ltrim( localUtil.ntoc( A311VentasNroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasNroFactura_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,101);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasNroFactura_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasNroFactura_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableleaflevel_detalle_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridFixedColumnBorders", "left", "top", "", "", "div");
      gxdraw_gridlevel_detalle( ) ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Ventas.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridlevel_detalle( )
   {
      /*  Grid Control  */
      startgridcontrol107( ) ;
      nGXsfl_107_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount17 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_17 = (short)(1) ;
            scanStart0H17( ) ;
            while ( RcdFound17 != 0 )
            {
               init_level_properties17( ) ;
               getByPrimaryKey0H17( ) ;
               addRow0H17( ) ;
               scanNext0H17( ) ;
            }
            scanEnd0H17( ) ;
            nBlankRcdCount17 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B242VentasSerial = A242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         B238VentasTotal10 = A238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         B236VentasTotal5 = A236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         B239VentasTotalExento = A239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         standaloneNotModal0H17( ) ;
         standaloneModal0H17( ) ;
         sMode17 = Gx_mode ;
         while ( nGXsfl_107_idx < nRC_GXsfl_107 )
         {
            bGXsfl_107_Refreshing = true ;
            readRow0H17( ) ;
            edtVentasDetalleId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEID_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtImpuestoPorcentaje_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "IMPUESTOPORCENTAJE_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtVentasDetalleCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLECANTIDAD_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleCantidad_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtArticuloPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOPRECIOVENTA_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtVentasDetalleExento_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEEXENTO_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleExento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleExento_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtVentasDetalleIva5_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEIVA5_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleIva5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleIva5_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtVentasDetalleIva10_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEIVA10_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleIva10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleIva10_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtVentasDetalleSubTotal_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLESUBTOTAL_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleSubTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleSubTotal_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtVentasDetalleTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLETALLAID_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleTallaID_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            imgprompt_4_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_107_idx+"Link") ;
            if ( ( nRcdExists_17 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0H17( ) ;
            }
            sendRow0H17( ) ;
            bGXsfl_107_Refreshing = false ;
         }
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A242VentasSerial = B242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A238VentasTotal10 = B238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         A236VentasTotal5 = B236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A239VentasTotalExento = B239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount17 = (short)(5) ;
         nRcdExists_17 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0H17( ) ;
            while ( RcdFound17 != 0 )
            {
               sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_10717( ) ;
               init_level_properties17( ) ;
               standaloneNotModal0H17( ) ;
               getByPrimaryKey0H17( ) ;
               standaloneModal0H17( ) ;
               addRow0H17( ) ;
               scanNext0H17( ) ;
            }
            scanEnd0H17( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode17 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_10717( ) ;
         initAll0H17( ) ;
         init_level_properties17( ) ;
         B242VentasSerial = A242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         B238VentasTotal10 = A238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         B236VentasTotal5 = A236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         B239VentasTotalExento = A239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         nRcdExists_17 = (short)(0) ;
         nIsMod_17 = (short)(0) ;
         nRcdDeleted_17 = (short)(0) ;
         nBlankRcdCount17 = (short)(nBlankRcdUsr17+nBlankRcdCount17) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount17 > 0 )
         {
            standaloneNotModal0H17( ) ;
            standaloneModal0H17( ) ;
            addRow0H17( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtVentasDetalleId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount17 = (short)(nBlankRcdCount17-1) ;
         }
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A242VentasSerial = B242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A238VentasTotal10 = B238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         A236VentasTotal5 = B236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A239VentasTotalExento = B239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_detalleContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_detalle", Gridlevel_detalleContainer, subGridlevel_detalle_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_detalleContainerData", Gridlevel_detalleContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_detalleContainerData"+"V", Gridlevel_detalleContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_detalleContainerData"+"V"+"\" value='"+Gridlevel_detalleContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z19VentasId = localUtil.ctol( httpContext.cgiGet( "Z19VentasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z91VentasFecha = localUtil.ctod( httpContext.cgiGet( "Z91VentasFecha"), 0) ;
            Z311VentasNroFactura = localUtil.ctol( httpContext.cgiGet( "Z311VentasNroFactura"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z309VentasSerie1 = (short)(localUtil.ctol( httpContext.cgiGet( "Z309VentasSerie1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z310VentasSerie2 = (short)(localUtil.ctol( httpContext.cgiGet( "Z310VentasSerie2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z251VentasPedido = localUtil.ctol( httpContext.cgiGet( "Z251VentasPedido"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z242VentasSerial = localUtil.ctol( httpContext.cgiGet( "Z242VentasSerial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z4ClienteId = localUtil.ctol( httpContext.cgiGet( "Z4ClienteId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z9TipoPagoId = localUtil.ctol( httpContext.cgiGet( "Z9TipoPagoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z29TimbradoId = localUtil.ctol( httpContext.cgiGet( "Z29TimbradoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            O242VentasSerial = localUtil.ctol( httpContext.cgiGet( "O242VentasSerial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            O238VentasTotal10 = localUtil.ctond( httpContext.cgiGet( "O238VentasTotal10")) ;
            O236VentasTotal5 = localUtil.ctond( httpContext.cgiGet( "O236VentasTotal5")) ;
            O239VentasTotalExento = localUtil.ctond( httpContext.cgiGet( "O239VentasTotalExento")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_107 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_107"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N4ClienteId = localUtil.ctol( httpContext.cgiGet( "N4ClienteId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N29TimbradoId = localUtil.ctol( httpContext.cgiGet( "N29TimbradoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N9TipoPagoId = localUtil.ctol( httpContext.cgiGet( "N9TipoPagoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV14VentasId = localUtil.ctol( httpContext.cgiGet( "vVENTASID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV17Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV12Insert_ClienteId = localUtil.ctol( httpContext.cgiGet( "vINSERT_CLIENTEID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV16Insert_TimbradoId = localUtil.ctol( httpContext.cgiGet( "vINSERT_TIMBRADOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV15Insert_TipoPagoId = localUtil.ctol( httpContext.cgiGet( "vINSERT_TIPOPAGOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A18ImpuestoId = localUtil.ctol( httpContext.cgiGet( "IMPUESTOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VENTASID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A19VentasId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
            }
            else
            {
               A19VentasId = localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtVentasFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "VENTASFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A91VentasFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
            }
            else
            {
               A91VentasFecha = localUtil.ctod( httpContext.cgiGet( edtVentasFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtClienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A4ClienteId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
            }
            else
            {
               A4ClienteId = localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
            }
            A242VentasSerial = localUtil.ctol( httpContext.cgiGet( edtVentasSerial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
            A239VentasTotalExento = localUtil.ctond( httpContext.cgiGet( edtVentasTotalExento_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A236VentasTotal5 = localUtil.ctond( httpContext.cgiGet( edtVentasTotal5_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            A238VentasTotal10 = localUtil.ctond( httpContext.cgiGet( edtVentasTotal10_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            A240VentasTotal = localUtil.ctond( httpContext.cgiGet( edtVentasTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
            A235VentasTotalIva5 = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIva5_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
            A237VentasTotalIva10 = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIva10_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
            A241VentasTotalIVA = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIVA_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasPedido_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasPedido_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VENTASPEDIDO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasPedido_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A251VentasPedido = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
            }
            else
            {
               A251VentasPedido = localUtil.ctol( httpContext.cgiGet( edtVentasPedido_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOPAGOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoPagoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A9TipoPagoId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
            }
            else
            {
               A9TipoPagoId = localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A29TimbradoId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            }
            else
            {
               A29TimbradoId = localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            }
            A125TimbradoNumero = localUtil.ctol( httpContext.cgiGet( edtTimbradoNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VENTASSERIE1");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasSerie1_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A309VentasSerie1 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
            }
            else
            {
               A309VentasSerie1 = (short)(localUtil.ctol( httpContext.cgiGet( edtVentasSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VENTASSERIE2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasSerie2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A310VentasSerie2 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
            }
            else
            {
               A310VentasSerie2 = (short)(localUtil.ctol( httpContext.cgiGet( edtVentasSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VENTASNROFACTURA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasNroFactura_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A311VentasNroFactura = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
            }
            else
            {
               A311VentasNroFactura = localUtil.ctol( httpContext.cgiGet( edtVentasNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Ventas");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A19VentasId != Z19VentasId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("ventas:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A19VentasId = GXutil.lval( httpContext.GetPar( "VentasId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode16 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode16 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound16 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0H0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "VENTASID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtVentasId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e110H2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120H2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e120H2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0H16( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes0H16( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_0H0( )
   {
      beforeValidate0H16( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0H16( ) ;
         }
         else
         {
            checkExtendedTable0H16( ) ;
            closeExtendedTableCursors0H16( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode16 = Gx_mode ;
         confirm_0H17( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode16 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0H17( )
   {
      s242VentasSerial = O242VentasSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
      s238VentasTotal10 = O238VentasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      s236VentasTotal5 = O236VentasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      s239VentasTotalExento = O239VentasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      s237VentasTotalIva10 = O237VentasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      s241VentasTotalIVA = O241VentasTotalIVA ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      s235VentasTotalIva5 = O235VentasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      s240VentasTotal = O240VentasTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      nGXsfl_107_idx = 0 ;
      while ( nGXsfl_107_idx < nRC_GXsfl_107 )
      {
         readRow0H17( ) ;
         if ( ( nRcdExists_17 != 0 ) || ( nIsMod_17 != 0 ) )
         {
            getKey0H17( ) ;
            if ( ( nRcdExists_17 == 0 ) && ( nRcdDeleted_17 == 0 ) )
            {
               if ( RcdFound17 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0H17( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0H17( ) ;
                     closeExtendedTableCursors0H17( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                     O242VentasSerial = A242VentasSerial ;
                     httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
                     O238VentasTotal10 = A238VentasTotal10 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
                     O236VentasTotal5 = A236VentasTotal5 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
                     O239VentasTotalExento = A239VentasTotalExento ;
                     httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
                     O237VentasTotalIva10 = A237VentasTotalIva10 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
                     O241VentasTotalIVA = A241VentasTotalIVA ;
                     httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
                     O235VentasTotalIva5 = A235VentasTotalIva5 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
                     O240VentasTotal = A240VentasTotal ;
                     httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
                  }
               }
               else
               {
                  GXCCtl = "VENTASDETALLEID_" + sGXsfl_107_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtVentasDetalleId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound17 != 0 )
               {
                  if ( nRcdDeleted_17 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0H17( ) ;
                     load0H17( ) ;
                     beforeValidate0H17( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0H17( ) ;
                        O242VentasSerial = A242VentasSerial ;
                        httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
                        O238VentasTotal10 = A238VentasTotal10 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
                        O236VentasTotal5 = A236VentasTotal5 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
                        O239VentasTotalExento = A239VentasTotalExento ;
                        httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
                        O237VentasTotalIva10 = A237VentasTotalIva10 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
                        O241VentasTotalIVA = A241VentasTotalIVA ;
                        httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
                        O235VentasTotalIva5 = A235VentasTotalIva5 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
                        O240VentasTotal = A240VentasTotal ;
                        httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
                     }
                  }
                  else
                  {
                     if ( nIsMod_17 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0H17( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0H17( ) ;
                           closeExtendedTableCursors0H17( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                           O242VentasSerial = A242VentasSerial ;
                           httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
                           O238VentasTotal10 = A238VentasTotal10 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
                           O236VentasTotal5 = A236VentasTotal5 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
                           O239VentasTotalExento = A239VentasTotalExento ;
                           httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
                           O237VentasTotalIva10 = A237VentasTotalIva10 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
                           O241VentasTotalIVA = A241VentasTotalIVA ;
                           httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
                           O235VentasTotalIva5 = A235VentasTotalIva5 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
                           O240VentasTotal = A240VentasTotal ;
                           httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_17 == 0 )
                  {
                     GXCCtl = "VENTASDETALLEID_" + sGXsfl_107_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtVentasDetalleId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtVentasDetalleId_Internalname, GXutil.ltrim( localUtil.ntoc( A20VentasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A92VentasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleExento_Internalname, GXutil.ltrim( localUtil.ntoc( A94VentasDetalleExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A96VentasDetalleIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A95VentasDetalleIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleSubTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A252VentasDetalleSubTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A292VentasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z20VentasDetalleId_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z20VentasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z92VentasDetalleCantidad_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z92VentasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z292VentasDetalleTallaID_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z292VentasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T95VentasDetalleIva10_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( O95VentasDetalleIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T96VentasDetalleIva5_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( O96VentasDetalleIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T94VentasDetalleExento_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( O94VentasDetalleExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_17_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_17_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_17_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_17 != 0 )
         {
            httpContext.changePostValue( "VENTASDETALLEID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "IMPUESTOPORCENTAJE_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLECANTIDAD_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOPRECIOVENTA_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLEEXENTO_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLEIVA5_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLEIVA10_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLESUBTOTAL_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleSubTotal_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLETALLAID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      O242VentasSerial = s242VentasSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
      O238VentasTotal10 = s238VentasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      O236VentasTotal5 = s236VentasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      O239VentasTotalExento = s239VentasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      O237VentasTotalIva10 = s237VentasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      O241VentasTotalIVA = s241VentasTotalIVA ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      O235VentasTotalIva5 = s235VentasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      O240VentasTotal = s240VentasTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0H0( )
   {
   }

   public void e110H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV17Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV19GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GXV1), 8, 0));
         while ( AV19GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV19GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ClienteId") == 0 )
            {
               AV12Insert_ClienteId = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_ClienteId), 11, 0));
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TimbradoId") == 0 )
            {
               AV16Insert_TimbradoId = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_TimbradoId), 11, 0));
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoPagoId") == 0 )
            {
               AV15Insert_TipoPagoId = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Insert_TipoPagoId), 11, 0));
            }
            AV19GXV1 = (int)(AV19GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GXV1), 8, 0));
         }
      }
   }

   public void e120H2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         new com.mujermorena.stockventas(remoteHandle, context).execute( A19VentasId) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.ventasww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(9);
      pr_default.close(8);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0H16( int GX_JID )
   {
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z91VentasFecha = T000H7_A91VentasFecha[0] ;
            Z311VentasNroFactura = T000H7_A311VentasNroFactura[0] ;
            Z309VentasSerie1 = T000H7_A309VentasSerie1[0] ;
            Z310VentasSerie2 = T000H7_A310VentasSerie2[0] ;
            Z251VentasPedido = T000H7_A251VentasPedido[0] ;
            Z242VentasSerial = T000H7_A242VentasSerial[0] ;
            Z4ClienteId = T000H7_A4ClienteId[0] ;
            Z9TipoPagoId = T000H7_A9TipoPagoId[0] ;
            Z29TimbradoId = T000H7_A29TimbradoId[0] ;
         }
         else
         {
            Z91VentasFecha = A91VentasFecha ;
            Z311VentasNroFactura = A311VentasNroFactura ;
            Z309VentasSerie1 = A309VentasSerie1 ;
            Z310VentasSerie2 = A310VentasSerie2 ;
            Z251VentasPedido = A251VentasPedido ;
            Z242VentasSerial = A242VentasSerial ;
            Z4ClienteId = A4ClienteId ;
            Z9TipoPagoId = A9TipoPagoId ;
            Z29TimbradoId = A29TimbradoId ;
         }
      }
      if ( GX_JID == -39 )
      {
         Z19VentasId = A19VentasId ;
         Z91VentasFecha = A91VentasFecha ;
         Z311VentasNroFactura = A311VentasNroFactura ;
         Z309VentasSerie1 = A309VentasSerie1 ;
         Z310VentasSerie2 = A310VentasSerie2 ;
         Z251VentasPedido = A251VentasPedido ;
         Z242VentasSerial = A242VentasSerial ;
         Z4ClienteId = A4ClienteId ;
         Z9TipoPagoId = A9TipoPagoId ;
         Z29TimbradoId = A29TimbradoId ;
         Z239VentasTotalExento = A239VentasTotalExento ;
         Z236VentasTotal5 = A236VentasTotal5 ;
         Z238VentasTotal10 = A238VentasTotal10 ;
         Z125TimbradoNumero = A125TimbradoNumero ;
      }
   }

   public void standaloneNotModal( )
   {
      edtVentasSerial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerial_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      AV17Pgmname = "Ventas" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      imgprompt_4_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.clienteprompt"+"',["+"{Ctrl:gx.dom.el('"+"CLIENTEID"+"'), id:'"+"CLIENTEID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_9_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.tipopagoprompt"+"',["+"{Ctrl:gx.dom.el('"+"TIPOPAGOID"+"'), id:'"+"TIPOPAGOID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_29_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.timbradoprompt"+"',["+"{Ctrl:gx.dom.el('"+"TIMBRADOID"+"'), id:'"+"TIMBRADOID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtVentasSerial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerial_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV14VentasId) )
      {
         A19VentasId = AV14VentasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A19VentasId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV17Pgmname), GXv_int3) ;
            ventas_impl.this.GXt_int2 = GXv_int3[0] ;
            A19VentasId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         }
      }
      if ( ! (0==AV14VentasId) )
      {
         edtVentasId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      }
      else
      {
         edtVentasId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV14VentasId) )
      {
         edtVentasId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_ClienteId) )
      {
         edtClienteId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      }
      else
      {
         edtClienteId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_TimbradoId) )
      {
         edtTimbradoId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      }
      else
      {
         edtTimbradoId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_TipoPagoId) )
      {
         edtTipoPagoId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoPagoId_Enabled), 5, 0), true);
      }
      else
      {
         edtTipoPagoId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoPagoId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         A91VentasFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A311VentasNroFactura ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "FAC", ""), ""), GXv_int3) ;
         ventas_impl.this.GXt_int2 = GXv_int3[0] ;
         A311VentasNroFactura = GXt_int2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A309VentasSerie1 ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "SE1", ""), ""), GXv_int3) ;
         ventas_impl.this.GXt_int2 = GXv_int3[0] ;
         A309VentasSerie1 = (short)(GXt_int2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A310VentasSerie2 ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "SE2", ""), ""), GXv_int3) ;
         ventas_impl.this.GXt_int2 = GXv_int3[0] ;
         A310VentasSerie2 = (short)(GXt_int2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_TipoPagoId) )
      {
         A9TipoPagoId = AV15Insert_TipoPagoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_TimbradoId) )
      {
         A29TimbradoId = AV16Insert_TimbradoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A29TimbradoId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "TIM", ""), ""), GXv_int3) ;
            ventas_impl.this.GXt_int2 = GXv_int3[0] ;
            A29TimbradoId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_ClienteId) )
      {
         A4ClienteId = AV12Insert_ClienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T000H12 */
         pr_default.execute(9, new Object[] {Long.valueOf(A19VentasId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            A239VentasTotalExento = T000H12_A239VentasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A236VentasTotal5 = T000H12_A236VentasTotal5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            A238VentasTotal10 = T000H12_A238VentasTotal10[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         else
         {
            A239VentasTotalExento = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A236VentasTotal5 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            A238VentasTotal10 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         O239VentasTotalExento = A239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         O236VentasTotal5 = A236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         O238VentasTotal10 = A238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         pr_default.close(9);
         A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         /* Using cursor T000H10 */
         pr_default.execute(8, new Object[] {Long.valueOf(A29TimbradoId)});
         A125TimbradoNumero = T000H10_A125TimbradoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
         pr_default.close(8);
      }
   }

   public void load0H16( )
   {
      /* Using cursor T000H14 */
      pr_default.execute(10, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A91VentasFecha = T000H14_A91VentasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
         A311VentasNroFactura = T000H14_A311VentasNroFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
         A309VentasSerie1 = T000H14_A309VentasSerie1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
         A310VentasSerie2 = T000H14_A310VentasSerie2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
         A251VentasPedido = T000H14_A251VentasPedido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
         A125TimbradoNumero = T000H14_A125TimbradoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
         A242VentasSerial = T000H14_A242VentasSerial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A4ClienteId = T000H14_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T000H14_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         A29TimbradoId = T000H14_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         A239VentasTotalExento = T000H14_A239VentasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A236VentasTotal5 = T000H14_A236VentasTotal5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A238VentasTotal10 = T000H14_A238VentasTotal10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         zm0H16( -39) ;
      }
      pr_default.close(10);
      onLoadActions0H16( ) ;
   }

   public void onLoadActions0H16( )
   {
      O238VentasTotal10 = A238VentasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      O236VentasTotal5 = A236VentasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      O239VentasTotalExento = A239VentasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
   }

   public void checkExtendedTable0H16( )
   {
      nIsDirty_16 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      /* Using cursor T000H12 */
      pr_default.execute(9, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A239VentasTotalExento = T000H12_A239VentasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A236VentasTotal5 = T000H12_A236VentasTotal5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A238VentasTotal10 = T000H12_A238VentasTotal10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      else
      {
         nIsDirty_16 = (short)(1) ;
         A239VentasTotalExento = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         nIsDirty_16 = (short)(1) ;
         A236VentasTotal5 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         nIsDirty_16 = (short)(1) ;
         A238VentasTotal10 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      pr_default.close(9);
      nIsDirty_16 = (short)(1) ;
      A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      nIsDirty_16 = (short)(1) ;
      A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      nIsDirty_16 = (short)(1) ;
      A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      nIsDirty_16 = (short)(1) ;
      A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A91VentasFecha)) || (( GXutil.resetTime(A91VentasFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A91VentasFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Ventas Fecha", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "VENTASFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000H8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(6);
      /* Using cursor T000H10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Timbrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A125TimbradoNumero = T000H10_A125TimbradoNumero[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
      pr_default.close(8);
      /* Using cursor T000H9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A9TipoPagoId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoPagoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(7);
   }

   public void closeExtendedTableCursors0H16( )
   {
      pr_default.close(9);
      pr_default.close(6);
      pr_default.close(8);
      pr_default.close(7);
   }

   public void enableDisable( )
   {
   }

   public void gxload_43( long A19VentasId )
   {
      /* Using cursor T000H16 */
      pr_default.execute(11, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         A239VentasTotalExento = T000H16_A239VentasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A236VentasTotal5 = T000H16_A236VentasTotal5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A238VentasTotal10 = T000H16_A238VentasTotal10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      else
      {
         A239VentasTotalExento = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A236VentasTotal5 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A238VentasTotal10 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A239VentasTotalExento, (byte)(17), (byte)(2), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A236VentasTotal5, (byte)(17), (byte)(2), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A238VentasTotal10, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_40( long A4ClienteId )
   {
      /* Using cursor T000H17 */
      pr_default.execute(12, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_42( long A29TimbradoId )
   {
      /* Using cursor T000H18 */
      pr_default.execute(13, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Timbrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A125TimbradoNumero = T000H18_A125TimbradoNumero[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_41( long A9TipoPagoId )
   {
      /* Using cursor T000H19 */
      pr_default.execute(14, new Object[] {Long.valueOf(A9TipoPagoId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoPagoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey0H16( )
   {
      /* Using cursor T000H20 */
      pr_default.execute(15, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound16 = (short)(1) ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000H7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm0H16( 39) ;
         RcdFound16 = (short)(1) ;
         A19VentasId = T000H7_A19VentasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         A91VentasFecha = T000H7_A91VentasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
         A311VentasNroFactura = T000H7_A311VentasNroFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
         A309VentasSerie1 = T000H7_A309VentasSerie1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
         A310VentasSerie2 = T000H7_A310VentasSerie2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
         A251VentasPedido = T000H7_A251VentasPedido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
         A242VentasSerial = T000H7_A242VentasSerial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A4ClienteId = T000H7_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T000H7_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         A29TimbradoId = T000H7_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         O242VentasSerial = A242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         Z19VentasId = A19VentasId ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0H16( ) ;
         if ( AnyError == 1 )
         {
            RcdFound16 = (short)(0) ;
            initializeNonKey0H16( ) ;
         }
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound16 = (short)(0) ;
         initializeNonKey0H16( ) ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(5);
   }

   public void getEqualNoModal( )
   {
      getKey0H16( ) ;
      if ( RcdFound16 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound16 = (short)(0) ;
      /* Using cursor T000H21 */
      pr_default.execute(16, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T000H21_A19VentasId[0] < A19VentasId ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T000H21_A19VentasId[0] > A19VentasId ) ) )
         {
            A19VentasId = T000H21_A19VentasId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
            RcdFound16 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void move_previous( )
   {
      RcdFound16 = (short)(0) ;
      /* Using cursor T000H22 */
      pr_default.execute(17, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         while ( (pr_default.getStatus(17) != 101) && ( ( T000H22_A19VentasId[0] > A19VentasId ) ) )
         {
            pr_default.readNext(17);
         }
         if ( (pr_default.getStatus(17) != 101) && ( ( T000H22_A19VentasId[0] < A19VentasId ) ) )
         {
            A19VentasId = T000H22_A19VentasId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
            RcdFound16 = (short)(1) ;
         }
      }
      pr_default.close(17);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0H16( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         A242VentasSerial = O242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A238VentasTotal10 = O238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         A236VentasTotal5 = O236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A239VentasTotalExento = O239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A237VentasTotalIva10 = O237VentasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         A241VentasTotalIVA = O241VentasTotalIVA ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         A235VentasTotalIva5 = O235VentasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         A240VentasTotal = O240VentasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         GX_FocusControl = edtVentasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0H16( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound16 == 1 )
         {
            if ( A19VentasId != Z19VentasId )
            {
               A19VentasId = Z19VentasId ;
               httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "VENTASID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               A242VentasSerial = O242VentasSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
               A238VentasTotal10 = O238VentasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
               A236VentasTotal5 = O236VentasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
               A239VentasTotalExento = O239VentasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
               A237VentasTotalIva10 = O237VentasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
               A241VentasTotalIVA = O241VentasTotalIVA ;
               httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
               A235VentasTotalIva5 = O235VentasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
               A240VentasTotal = O240VentasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtVentasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               A242VentasSerial = O242VentasSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
               A238VentasTotal10 = O238VentasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
               A236VentasTotal5 = O236VentasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
               A239VentasTotalExento = O239VentasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
               A237VentasTotalIva10 = O237VentasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
               A241VentasTotalIVA = O241VentasTotalIVA ;
               httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
               A235VentasTotalIva5 = O235VentasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
               A240VentasTotal = O240VentasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
               update0H16( ) ;
               GX_FocusControl = edtVentasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A19VentasId != Z19VentasId )
            {
               /* Insert record */
               A242VentasSerial = O242VentasSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
               A238VentasTotal10 = O238VentasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
               A236VentasTotal5 = O236VentasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
               A239VentasTotalExento = O239VentasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
               A237VentasTotalIva10 = O237VentasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
               A241VentasTotalIVA = O241VentasTotalIVA ;
               httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
               A235VentasTotalIva5 = O235VentasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
               A240VentasTotal = O240VentasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
               GX_FocusControl = edtVentasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0H16( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "VENTASID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtVentasId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  A242VentasSerial = O242VentasSerial ;
                  httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
                  A238VentasTotal10 = O238VentasTotal10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
                  A236VentasTotal5 = O236VentasTotal5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
                  A239VentasTotalExento = O239VentasTotalExento ;
                  httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
                  A237VentasTotalIva10 = O237VentasTotalIva10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
                  A241VentasTotalIVA = O241VentasTotalIVA ;
                  httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
                  A235VentasTotalIva5 = O235VentasTotalIva5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
                  A240VentasTotal = O240VentasTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
                  GX_FocusControl = edtVentasId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0H16( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( A19VentasId != Z19VentasId )
      {
         A19VentasId = Z19VentasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "VENTASID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         A242VentasSerial = O242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A238VentasTotal10 = O238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         A236VentasTotal5 = O236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A239VentasTotalExento = O239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A237VentasTotalIva10 = O237VentasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         A241VentasTotalIVA = O241VentasTotalIVA ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         A235VentasTotalIva5 = O235VentasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         A240VentasTotal = O240VentasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtVentasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0H16( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000H6 */
         pr_default.execute(4, new Object[] {Long.valueOf(A19VentasId)});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Ventas"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(4) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z91VentasFecha), GXutil.resetTime(T000H6_A91VentasFecha[0])) ) || ( Z311VentasNroFactura != T000H6_A311VentasNroFactura[0] ) || ( Z309VentasSerie1 != T000H6_A309VentasSerie1[0] ) || ( Z310VentasSerie2 != T000H6_A310VentasSerie2[0] ) || ( Z251VentasPedido != T000H6_A251VentasPedido[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z242VentasSerial != T000H6_A242VentasSerial[0] ) || ( Z4ClienteId != T000H6_A4ClienteId[0] ) || ( Z9TipoPagoId != T000H6_A9TipoPagoId[0] ) || ( Z29TimbradoId != T000H6_A29TimbradoId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z91VentasFecha), GXutil.resetTime(T000H6_A91VentasFecha[0])) ) )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasFecha");
               GXutil.writeLogRaw("Old: ",Z91VentasFecha);
               GXutil.writeLogRaw("Current: ",T000H6_A91VentasFecha[0]);
            }
            if ( Z311VentasNroFactura != T000H6_A311VentasNroFactura[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasNroFactura");
               GXutil.writeLogRaw("Old: ",Z311VentasNroFactura);
               GXutil.writeLogRaw("Current: ",T000H6_A311VentasNroFactura[0]);
            }
            if ( Z309VentasSerie1 != T000H6_A309VentasSerie1[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasSerie1");
               GXutil.writeLogRaw("Old: ",Z309VentasSerie1);
               GXutil.writeLogRaw("Current: ",T000H6_A309VentasSerie1[0]);
            }
            if ( Z310VentasSerie2 != T000H6_A310VentasSerie2[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasSerie2");
               GXutil.writeLogRaw("Old: ",Z310VentasSerie2);
               GXutil.writeLogRaw("Current: ",T000H6_A310VentasSerie2[0]);
            }
            if ( Z251VentasPedido != T000H6_A251VentasPedido[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasPedido");
               GXutil.writeLogRaw("Old: ",Z251VentasPedido);
               GXutil.writeLogRaw("Current: ",T000H6_A251VentasPedido[0]);
            }
            if ( Z242VentasSerial != T000H6_A242VentasSerial[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasSerial");
               GXutil.writeLogRaw("Old: ",Z242VentasSerial);
               GXutil.writeLogRaw("Current: ",T000H6_A242VentasSerial[0]);
            }
            if ( Z4ClienteId != T000H6_A4ClienteId[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"ClienteId");
               GXutil.writeLogRaw("Old: ",Z4ClienteId);
               GXutil.writeLogRaw("Current: ",T000H6_A4ClienteId[0]);
            }
            if ( Z9TipoPagoId != T000H6_A9TipoPagoId[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"TipoPagoId");
               GXutil.writeLogRaw("Old: ",Z9TipoPagoId);
               GXutil.writeLogRaw("Current: ",T000H6_A9TipoPagoId[0]);
            }
            if ( Z29TimbradoId != T000H6_A29TimbradoId[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"TimbradoId");
               GXutil.writeLogRaw("Old: ",Z29TimbradoId);
               GXutil.writeLogRaw("Current: ",T000H6_A29TimbradoId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Ventas"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0H16( )
   {
      if ( ! IsAuthorized("ventas_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0H16( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0H16( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0H16( 0) ;
         checkOptimisticConcurrency0H16( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0H16( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0H16( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000H23 */
                  pr_default.execute(18, new Object[] {Long.valueOf(A19VentasId), A91VentasFecha, Long.valueOf(A311VentasNroFactura), Short.valueOf(A309VentasSerie1), Short.valueOf(A310VentasSerie2), Long.valueOf(A251VentasPedido), Long.valueOf(A242VentasSerial), Long.valueOf(A4ClienteId), Long.valueOf(A9TipoPagoId), Long.valueOf(A29TimbradoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Ventas");
                  if ( (pr_default.getStatus(18) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0H16( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0H0( ) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0H16( ) ;
         }
         endLevel0H16( ) ;
      }
      closeExtendedTableCursors0H16( ) ;
   }

   public void update0H16( )
   {
      if ( ! IsAuthorized("ventas_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0H16( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0H16( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0H16( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0H16( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0H16( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000H24 */
                  pr_default.execute(19, new Object[] {A91VentasFecha, Long.valueOf(A311VentasNroFactura), Short.valueOf(A309VentasSerie1), Short.valueOf(A310VentasSerie2), Long.valueOf(A251VentasPedido), Long.valueOf(A242VentasSerial), Long.valueOf(A4ClienteId), Long.valueOf(A9TipoPagoId), Long.valueOf(A29TimbradoId), Long.valueOf(A19VentasId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Ventas");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Ventas"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0H16( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0H16( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0H16( ) ;
      }
      closeExtendedTableCursors0H16( ) ;
   }

   public void deferredUpdate0H16( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("ventas_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0H16( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0H16( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0H16( ) ;
         afterConfirm0H16( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0H16( ) ;
            if ( AnyError == 0 )
            {
               A242VentasSerial = O242VentasSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
               A238VentasTotal10 = O238VentasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
               A236VentasTotal5 = O236VentasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
               A239VentasTotalExento = O239VentasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
               A237VentasTotalIva10 = O237VentasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
               A241VentasTotalIVA = O241VentasTotalIVA ;
               httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
               A235VentasTotalIva5 = O235VentasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
               A240VentasTotal = O240VentasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
               scanStart0H17( ) ;
               while ( RcdFound17 != 0 )
               {
                  getByPrimaryKey0H17( ) ;
                  delete0H17( ) ;
                  scanNext0H17( ) ;
                  O242VentasSerial = A242VentasSerial ;
                  httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
                  O238VentasTotal10 = A238VentasTotal10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
                  O236VentasTotal5 = A236VentasTotal5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
                  O239VentasTotalExento = A239VentasTotalExento ;
                  httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
                  O237VentasTotalIva10 = A237VentasTotalIva10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
                  O241VentasTotalIVA = A241VentasTotalIVA ;
                  httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
                  O235VentasTotalIva5 = A235VentasTotalIva5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
                  O240VentasTotal = A240VentasTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
               }
               scanEnd0H17( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000H25 */
                  pr_default.execute(20, new Object[] {Long.valueOf(A19VentasId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Ventas");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode16 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0H16( ) ;
      Gx_mode = sMode16 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0H16( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000H27 */
         pr_default.execute(21, new Object[] {Long.valueOf(A19VentasId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            A239VentasTotalExento = T000H27_A239VentasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A236VentasTotal5 = T000H27_A236VentasTotal5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            A238VentasTotal10 = T000H27_A238VentasTotal10[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         else
         {
            A239VentasTotalExento = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A236VentasTotal5 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            A238VentasTotal10 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         pr_default.close(21);
         A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         /* Using cursor T000H28 */
         pr_default.execute(22, new Object[] {Long.valueOf(A29TimbradoId)});
         A125TimbradoNumero = T000H28_A125TimbradoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
         pr_default.close(22);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000H29 */
         pr_default.execute(23, new Object[] {Long.valueOf(A19VentasId)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Devoluciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
      }
   }

   public void processNestedLevel0H17( )
   {
      s242VentasSerial = O242VentasSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
      s238VentasTotal10 = O238VentasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      s236VentasTotal5 = O236VentasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      s239VentasTotalExento = O239VentasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      s237VentasTotalIva10 = O237VentasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      s241VentasTotalIVA = O241VentasTotalIVA ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      s235VentasTotalIva5 = O235VentasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      s240VentasTotal = O240VentasTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      nGXsfl_107_idx = 0 ;
      while ( nGXsfl_107_idx < nRC_GXsfl_107 )
      {
         readRow0H17( ) ;
         if ( ( nRcdExists_17 != 0 ) || ( nIsMod_17 != 0 ) )
         {
            standaloneNotModal0H17( ) ;
            getKey0H17( ) ;
            if ( ( nRcdExists_17 == 0 ) && ( nRcdDeleted_17 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0H17( ) ;
            }
            else
            {
               if ( RcdFound17 != 0 )
               {
                  if ( ( nRcdDeleted_17 != 0 ) && ( nRcdExists_17 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0H17( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_17 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0H17( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_17 == 0 )
                  {
                     GXCCtl = "VENTASDETALLEID_" + sGXsfl_107_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtVentasDetalleId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
            O242VentasSerial = A242VentasSerial ;
            httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
            O238VentasTotal10 = A238VentasTotal10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            O236VentasTotal5 = A236VentasTotal5 ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            O239VentasTotalExento = A239VentasTotalExento ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            O237VentasTotalIva10 = A237VentasTotalIva10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
            O241VentasTotalIVA = A241VentasTotalIVA ;
            httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
            O235VentasTotalIva5 = A235VentasTotalIva5 ;
            httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
            O240VentasTotal = A240VentasTotal ;
            httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         }
         httpContext.changePostValue( edtVentasDetalleId_Internalname, GXutil.ltrim( localUtil.ntoc( A20VentasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A92VentasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleExento_Internalname, GXutil.ltrim( localUtil.ntoc( A94VentasDetalleExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A96VentasDetalleIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A95VentasDetalleIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleSubTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A252VentasDetalleSubTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtVentasDetalleTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A292VentasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z20VentasDetalleId_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z20VentasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z92VentasDetalleCantidad_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z92VentasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z292VentasDetalleTallaID_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z292VentasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T95VentasDetalleIva10_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( O95VentasDetalleIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T96VentasDetalleIva5_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( O96VentasDetalleIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T94VentasDetalleExento_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( O94VentasDetalleExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_17_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_17_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_17_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_17 != 0 )
         {
            httpContext.changePostValue( "VENTASDETALLEID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "IMPUESTOPORCENTAJE_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLECANTIDAD_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOPRECIOVENTA_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLEEXENTO_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLEIVA5_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLEIVA10_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLESUBTOTAL_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleSubTotal_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "VENTASDETALLETALLAID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0H17( ) ;
      if ( AnyError != 0 )
      {
         O242VentasSerial = s242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         O238VentasTotal10 = s238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         O236VentasTotal5 = s236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         O239VentasTotalExento = s239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         O237VentasTotalIva10 = s237VentasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         O241VentasTotalIVA = s241VentasTotalIVA ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         O235VentasTotalIva5 = s235VentasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         O240VentasTotal = s240VentasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      }
      nRcdExists_17 = (short)(0) ;
      nIsMod_17 = (short)(0) ;
      nRcdDeleted_17 = (short)(0) ;
   }

   public void processLevel0H16( )
   {
      /* Save parent mode. */
      sMode16 = Gx_mode ;
      processNestedLevel0H17( ) ;
      if ( AnyError != 0 )
      {
         O242VentasSerial = s242VentasSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         O238VentasTotal10 = s238VentasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         O236VentasTotal5 = s236VentasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         O239VentasTotalExento = s239VentasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         O237VentasTotalIva10 = s237VentasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         O241VentasTotalIVA = s241VentasTotalIVA ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         O235VentasTotalIva5 = s235VentasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         O240VentasTotal = s240VentasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      }
      /* Restore parent mode. */
      Gx_mode = sMode16 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
      /* Using cursor T000H30 */
      pr_default.execute(24, new Object[] {Long.valueOf(A242VentasSerial), Long.valueOf(A19VentasId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Ventas");
   }

   public void endLevel0H16( )
   {
      pr_default.close(4);
      if ( AnyError == 0 )
      {
         beforeComplete0H16( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(22);
         pr_default.close(21);
         pr_default.close(2);
         pr_default.close(3);
         Application.commitDataStores(context, remoteHandle, pr_default, "ventas");
         if ( AnyError == 0 )
         {
            confirmValues0H0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(22);
         pr_default.close(21);
         pr_default.close(2);
         pr_default.close(3);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "ventas");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0H16( )
   {
      /* Scan By routine */
      /* Using cursor T000H31 */
      pr_default.execute(25);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A19VentasId = T000H31_A19VentasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0H16( )
   {
      /* Scan next routine */
      pr_default.readNext(25);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A19VentasId = T000H31_A19VentasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      }
   }

   public void scanEnd0H16( )
   {
      pr_default.close(25);
   }

   public void afterConfirm0H16( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0H16( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0H16( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0H16( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0H16( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0H16( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0H16( )
   {
      edtVentasId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      edtVentasFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasFecha_Enabled), 5, 0), true);
      edtClienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      edtVentasSerial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerial_Enabled), 5, 0), true);
      edtVentasTotalExento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotalExento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotalExento_Enabled), 5, 0), true);
      edtVentasTotal5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotal5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotal5_Enabled), 5, 0), true);
      edtVentasTotal10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotal10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotal10_Enabled), 5, 0), true);
      edtVentasTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotal_Enabled), 5, 0), true);
      edtVentasTotalIva5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotalIva5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotalIva5_Enabled), 5, 0), true);
      edtVentasTotalIva10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotalIva10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotalIva10_Enabled), 5, 0), true);
      edtVentasTotalIVA_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasTotalIVA_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasTotalIVA_Enabled), 5, 0), true);
      edtVentasPedido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasPedido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasPedido_Enabled), 5, 0), true);
      edtTipoPagoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoPagoId_Enabled), 5, 0), true);
      edtTimbradoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      edtTimbradoNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNumero_Enabled), 5, 0), true);
      edtVentasSerie1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerie1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerie1_Enabled), 5, 0), true);
      edtVentasSerie2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerie2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerie2_Enabled), 5, 0), true);
      edtVentasNroFactura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasNroFactura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasNroFactura_Enabled), 5, 0), true);
   }

   public void zm0H17( int GX_JID )
   {
      if ( ( GX_JID == 44 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z92VentasDetalleCantidad = T000H3_A92VentasDetalleCantidad[0] ;
            Z292VentasDetalleTallaID = T000H3_A292VentasDetalleTallaID[0] ;
            Z13ArticuloId = T000H3_A13ArticuloId[0] ;
         }
         else
         {
            Z92VentasDetalleCantidad = A92VentasDetalleCantidad ;
            Z292VentasDetalleTallaID = A292VentasDetalleTallaID ;
            Z13ArticuloId = A13ArticuloId ;
         }
      }
      if ( GX_JID == -44 )
      {
         Z19VentasId = A19VentasId ;
         Z20VentasDetalleId = A20VentasDetalleId ;
         Z92VentasDetalleCantidad = A92VentasDetalleCantidad ;
         Z292VentasDetalleTallaID = A292VentasDetalleTallaID ;
         Z13ArticuloId = A13ArticuloId ;
         Z18ImpuestoId = A18ImpuestoId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
         Z78ArticuloPrecioVenta = A78ArticuloPrecioVenta ;
         Z83ImpuestoPorcentaje = A83ImpuestoPorcentaje ;
      }
   }

   public void standaloneNotModal0H17( )
   {
      edtVentasSerial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerial_Enabled), 5, 0), true);
      edtVentasSerial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasSerial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasSerial_Enabled), 5, 0), true);
   }

   public void standaloneModal0H17( )
   {
      if ( isIns( )  )
      {
         A242VentasSerial = (long)(O242VentasSerial+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
      }
      if ( isIns( )  && ( Gx_BScreen == 1 ) )
      {
         A20VentasDetalleId = A242VentasSerial ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtVentasDetalleId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      }
      else
      {
         edtVentasDetalleId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      }
   }

   public void load0H17( )
   {
      /* Using cursor T000H32 */
      pr_default.execute(26, new Object[] {Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId)});
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A18ImpuestoId = T000H32_A18ImpuestoId[0] ;
         A76ArticuloNombre = T000H32_A76ArticuloNombre[0] ;
         A83ImpuestoPorcentaje = T000H32_A83ImpuestoPorcentaje[0] ;
         A92VentasDetalleCantidad = T000H32_A92VentasDetalleCantidad[0] ;
         A78ArticuloPrecioVenta = T000H32_A78ArticuloPrecioVenta[0] ;
         A292VentasDetalleTallaID = T000H32_A292VentasDetalleTallaID[0] ;
         A13ArticuloId = T000H32_A13ArticuloId[0] ;
         zm0H17( -44) ;
      }
      pr_default.close(26);
      onLoadActions0H17( ) ;
   }

   public void onLoadActions0H17( )
   {
      if ( A83ImpuestoPorcentaje.doubleValue() == 5 )
      {
         A96VentasDetalleIva5 = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
      else
      {
         A96VentasDetalleIva5 = DecimalUtil.doubleToDec(0) ;
      }
      O96VentasDetalleIva5 = A96VentasDetalleIva5 ;
      if ( isIns( )  )
      {
         A236VentasTotal5 = O236VentasTotal5.add(A96VentasDetalleIva5) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A236VentasTotal5 = O236VentasTotal5.add(A96VentasDetalleIva5).subtract(O96VentasDetalleIva5) ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A236VentasTotal5 = O236VentasTotal5.subtract(O96VentasDetalleIva5) ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            }
         }
      }
      A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 10 )
      {
         A95VentasDetalleIva10 = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
      else
      {
         A95VentasDetalleIva10 = DecimalUtil.doubleToDec(0) ;
      }
      O95VentasDetalleIva10 = A95VentasDetalleIva10 ;
      if ( isIns( )  )
      {
         A238VentasTotal10 = O238VentasTotal10.add(A95VentasDetalleIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A238VentasTotal10 = O238VentasTotal10.add(A95VentasDetalleIva10).subtract(O95VentasDetalleIva10) ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A238VentasTotal10 = O238VentasTotal10.subtract(O95VentasDetalleIva10) ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            }
         }
      }
      A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 0 )
      {
         A94VentasDetalleExento = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
      else
      {
         A94VentasDetalleExento = DecimalUtil.doubleToDec(0) ;
      }
      O94VentasDetalleExento = A94VentasDetalleExento ;
      if ( isIns( )  )
      {
         A239VentasTotalExento = O239VentasTotalExento.add(A94VentasDetalleExento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A239VentasTotalExento = O239VentasTotalExento.add(A94VentasDetalleExento).subtract(O94VentasDetalleExento) ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A239VentasTotalExento = O239VentasTotalExento.subtract(O94VentasDetalleExento) ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            }
         }
      }
      A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      A252VentasDetalleSubTotal = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
   }

   public void checkExtendedTable0H17( )
   {
      nIsDirty_17 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0H17( ) ;
      /* Using cursor T000H4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18ImpuestoId = T000H4_A18ImpuestoId[0] ;
      A76ArticuloNombre = T000H4_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T000H4_A78ArticuloPrecioVenta[0] ;
      pr_default.close(2);
      /* Using cursor T000H5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T000H5_A83ImpuestoPorcentaje[0] ;
      pr_default.close(3);
      if ( A83ImpuestoPorcentaje.doubleValue() == 5 )
      {
         nIsDirty_17 = (short)(1) ;
         A96VentasDetalleIva5 = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
      else
      {
         nIsDirty_17 = (short)(1) ;
         A96VentasDetalleIva5 = DecimalUtil.doubleToDec(0) ;
      }
      if ( isIns( )  )
      {
         nIsDirty_17 = (short)(1) ;
         A236VentasTotal5 = O236VentasTotal5.add(A96VentasDetalleIva5) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_17 = (short)(1) ;
            A236VentasTotal5 = O236VentasTotal5.add(A96VentasDetalleIva5).subtract(O96VentasDetalleIva5) ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_17 = (short)(1) ;
               A236VentasTotal5 = O236VentasTotal5.subtract(O96VentasDetalleIva5) ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            }
         }
      }
      nIsDirty_17 = (short)(1) ;
      A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 10 )
      {
         nIsDirty_17 = (short)(1) ;
         A95VentasDetalleIva10 = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
      else
      {
         nIsDirty_17 = (short)(1) ;
         A95VentasDetalleIva10 = DecimalUtil.doubleToDec(0) ;
      }
      if ( isIns( )  )
      {
         nIsDirty_17 = (short)(1) ;
         A238VentasTotal10 = O238VentasTotal10.add(A95VentasDetalleIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_17 = (short)(1) ;
            A238VentasTotal10 = O238VentasTotal10.add(A95VentasDetalleIva10).subtract(O95VentasDetalleIva10) ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_17 = (short)(1) ;
               A238VentasTotal10 = O238VentasTotal10.subtract(O95VentasDetalleIva10) ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            }
         }
      }
      nIsDirty_17 = (short)(1) ;
      A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      nIsDirty_17 = (short)(1) ;
      A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 0 )
      {
         nIsDirty_17 = (short)(1) ;
         A94VentasDetalleExento = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
      else
      {
         nIsDirty_17 = (short)(1) ;
         A94VentasDetalleExento = DecimalUtil.doubleToDec(0) ;
      }
      if ( isIns( )  )
      {
         nIsDirty_17 = (short)(1) ;
         A239VentasTotalExento = O239VentasTotalExento.add(A94VentasDetalleExento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_17 = (short)(1) ;
            A239VentasTotalExento = O239VentasTotalExento.add(A94VentasDetalleExento).subtract(O94VentasDetalleExento) ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_17 = (short)(1) ;
               A239VentasTotalExento = O239VentasTotalExento.subtract(O94VentasDetalleExento) ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            }
         }
      }
      nIsDirty_17 = (short)(1) ;
      A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      nIsDirty_17 = (short)(1) ;
      A252VentasDetalleSubTotal = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
   }

   public void closeExtendedTableCursors0H17( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable0H17( )
   {
   }

   public void gxload_45( long A13ArticuloId )
   {
      /* Using cursor T000H33 */
      pr_default.execute(27, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18ImpuestoId = T000H33_A18ImpuestoId[0] ;
      A76ArticuloNombre = T000H33_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T000H33_A78ArticuloPrecioVenta[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A76ArticuloNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(27) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(27);
   }

   public void gxload_46( long A18ImpuestoId )
   {
      /* Using cursor T000H34 */
      pr_default.execute(28, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(28) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T000H34_A83ImpuestoPorcentaje[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(28) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(28);
   }

   public void getKey0H17( )
   {
      /* Using cursor T000H35 */
      pr_default.execute(29, new Object[] {Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId)});
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound17 = (short)(1) ;
      }
      else
      {
         RcdFound17 = (short)(0) ;
      }
      pr_default.close(29);
   }

   public void getByPrimaryKey0H17( )
   {
      /* Using cursor T000H3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0H17( 44) ;
         RcdFound17 = (short)(1) ;
         initializeNonKey0H17( ) ;
         A20VentasDetalleId = T000H3_A20VentasDetalleId[0] ;
         A92VentasDetalleCantidad = T000H3_A92VentasDetalleCantidad[0] ;
         A292VentasDetalleTallaID = T000H3_A292VentasDetalleTallaID[0] ;
         A13ArticuloId = T000H3_A13ArticuloId[0] ;
         Z19VentasId = A19VentasId ;
         Z20VentasDetalleId = A20VentasDetalleId ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0H17( ) ;
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound17 = (short)(0) ;
         initializeNonKey0H17( ) ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0H17( ) ;
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0H17( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0H17( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000H2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"VentasDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z92VentasDetalleCantidad != T000H2_A92VentasDetalleCantidad[0] ) || ( Z292VentasDetalleTallaID != T000H2_A292VentasDetalleTallaID[0] ) || ( Z13ArticuloId != T000H2_A13ArticuloId[0] ) )
         {
            if ( Z92VentasDetalleCantidad != T000H2_A92VentasDetalleCantidad[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasDetalleCantidad");
               GXutil.writeLogRaw("Old: ",Z92VentasDetalleCantidad);
               GXutil.writeLogRaw("Current: ",T000H2_A92VentasDetalleCantidad[0]);
            }
            if ( Z292VentasDetalleTallaID != T000H2_A292VentasDetalleTallaID[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"VentasDetalleTallaID");
               GXutil.writeLogRaw("Old: ",Z292VentasDetalleTallaID);
               GXutil.writeLogRaw("Current: ",T000H2_A292VentasDetalleTallaID[0]);
            }
            if ( Z13ArticuloId != T000H2_A13ArticuloId[0] )
            {
               GXutil.writeLogln("ventas:[seudo value changed for attri]"+"ArticuloId");
               GXutil.writeLogRaw("Old: ",Z13ArticuloId);
               GXutil.writeLogRaw("Current: ",T000H2_A13ArticuloId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"VentasDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0H17( )
   {
      if ( ! IsAuthorized("ventas_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0H17( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0H17( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0H17( 0) ;
         checkOptimisticConcurrency0H17( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0H17( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0H17( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000H36 */
                  pr_default.execute(30, new Object[] {Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId), Integer.valueOf(A92VentasDetalleCantidad), Long.valueOf(A292VentasDetalleTallaID), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("VentasDetalle");
                  if ( (pr_default.getStatus(30) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0H17( ) ;
         }
         endLevel0H17( ) ;
      }
      closeExtendedTableCursors0H17( ) ;
   }

   public void update0H17( )
   {
      if ( ! IsAuthorized("ventas_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0H17( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0H17( ) ;
      }
      if ( ( nIsMod_17 != 0 ) || ( nIsDirty_17 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0H17( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0H17( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0H17( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000H37 */
                     pr_default.execute(31, new Object[] {Integer.valueOf(A92VentasDetalleCantidad), Long.valueOf(A292VentasDetalleTallaID), Long.valueOf(A13ArticuloId), Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("VentasDetalle");
                     if ( (pr_default.getStatus(31) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"VentasDetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0H17( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0H17( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel0H17( ) ;
         }
      }
      closeExtendedTableCursors0H17( ) ;
   }

   public void deferredUpdate0H17( )
   {
   }

   public void delete0H17( )
   {
      if ( ! IsAuthorized("ventas_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0H17( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0H17( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0H17( ) ;
         afterConfirm0H17( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0H17( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000H38 */
               pr_default.execute(32, new Object[] {Long.valueOf(A19VentasId), Long.valueOf(A20VentasDetalleId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("VentasDetalle");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode17 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0H17( ) ;
      Gx_mode = sMode17 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0H17( )
   {
      standaloneModal0H17( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000H39 */
         pr_default.execute(33, new Object[] {Long.valueOf(A13ArticuloId)});
         A18ImpuestoId = T000H39_A18ImpuestoId[0] ;
         A76ArticuloNombre = T000H39_A76ArticuloNombre[0] ;
         A78ArticuloPrecioVenta = T000H39_A78ArticuloPrecioVenta[0] ;
         pr_default.close(33);
         /* Using cursor T000H40 */
         pr_default.execute(34, new Object[] {Long.valueOf(A18ImpuestoId)});
         A83ImpuestoPorcentaje = T000H40_A83ImpuestoPorcentaje[0] ;
         pr_default.close(34);
         if ( A83ImpuestoPorcentaje.doubleValue() == 5 )
         {
            A96VentasDetalleIva5 = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
         }
         else
         {
            A96VentasDetalleIva5 = DecimalUtil.doubleToDec(0) ;
         }
         if ( isIns( )  )
         {
            A236VentasTotal5 = O236VentasTotal5.add(A96VentasDetalleIva5) ;
            httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A236VentasTotal5 = O236VentasTotal5.add(A96VentasDetalleIva5).subtract(O96VentasDetalleIva5) ;
               httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A236VentasTotal5 = O236VentasTotal5.subtract(O96VentasDetalleIva5) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
               }
            }
         }
         A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         if ( A83ImpuestoPorcentaje.doubleValue() == 10 )
         {
            A95VentasDetalleIva10 = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
         }
         else
         {
            A95VentasDetalleIva10 = DecimalUtil.doubleToDec(0) ;
         }
         if ( isIns( )  )
         {
            A238VentasTotal10 = O238VentasTotal10.add(A95VentasDetalleIva10) ;
            httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A238VentasTotal10 = O238VentasTotal10.add(A95VentasDetalleIva10).subtract(O95VentasDetalleIva10) ;
               httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A238VentasTotal10 = O238VentasTotal10.subtract(O95VentasDetalleIva10) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
               }
            }
         }
         A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         if ( A83ImpuestoPorcentaje.doubleValue() == 0 )
         {
            A94VentasDetalleExento = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
         }
         else
         {
            A94VentasDetalleExento = DecimalUtil.doubleToDec(0) ;
         }
         if ( isIns( )  )
         {
            A239VentasTotalExento = O239VentasTotalExento.add(A94VentasDetalleExento) ;
            httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A239VentasTotalExento = O239VentasTotalExento.add(A94VentasDetalleExento).subtract(O94VentasDetalleExento) ;
               httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A239VentasTotalExento = O239VentasTotalExento.subtract(O94VentasDetalleExento) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
               }
            }
         }
         A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         A252VentasDetalleSubTotal = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
      }
   }

   public void endLevel0H17( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0H17( )
   {
      /* Scan By routine */
      /* Using cursor T000H41 */
      pr_default.execute(35, new Object[] {Long.valueOf(A19VentasId)});
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(35) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A20VentasDetalleId = T000H41_A20VentasDetalleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0H17( )
   {
      /* Scan next routine */
      pr_default.readNext(35);
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(35) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A20VentasDetalleId = T000H41_A20VentasDetalleId[0] ;
      }
   }

   public void scanEnd0H17( )
   {
      pr_default.close(35);
   }

   public void afterConfirm0H17( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0H17( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0H17( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0H17( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0H17( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0H17( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0H17( )
   {
      edtVentasDetalleId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtImpuestoPorcentaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtVentasDetalleCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleCantidad_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtArticuloPrecioVenta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtVentasDetalleExento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleExento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleExento_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtVentasDetalleIva5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleIva5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleIva5_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtVentasDetalleIva10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleIva10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleIva10_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtVentasDetalleSubTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleSubTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleSubTotal_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtVentasDetalleTallaID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleTallaID_Enabled), 5, 0), !bGXsfl_107_Refreshing);
   }

   public void send_integrity_lvl_hashes0H17( )
   {
   }

   public void send_integrity_lvl_hashes0H16( )
   {
   }

   public void subsflControlProps_10717( )
   {
      edtVentasDetalleId_Internalname = "VENTASDETALLEID_"+sGXsfl_107_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_107_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_107_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_107_idx ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE_"+sGXsfl_107_idx ;
      edtVentasDetalleCantidad_Internalname = "VENTASDETALLECANTIDAD_"+sGXsfl_107_idx ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA_"+sGXsfl_107_idx ;
      edtVentasDetalleExento_Internalname = "VENTASDETALLEEXENTO_"+sGXsfl_107_idx ;
      edtVentasDetalleIva5_Internalname = "VENTASDETALLEIVA5_"+sGXsfl_107_idx ;
      edtVentasDetalleIva10_Internalname = "VENTASDETALLEIVA10_"+sGXsfl_107_idx ;
      edtVentasDetalleSubTotal_Internalname = "VENTASDETALLESUBTOTAL_"+sGXsfl_107_idx ;
      edtVentasDetalleTallaID_Internalname = "VENTASDETALLETALLAID_"+sGXsfl_107_idx ;
   }

   public void subsflControlProps_fel_10717( )
   {
      edtVentasDetalleId_Internalname = "VENTASDETALLEID_"+sGXsfl_107_fel_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_107_fel_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_107_fel_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_107_fel_idx ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE_"+sGXsfl_107_fel_idx ;
      edtVentasDetalleCantidad_Internalname = "VENTASDETALLECANTIDAD_"+sGXsfl_107_fel_idx ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA_"+sGXsfl_107_fel_idx ;
      edtVentasDetalleExento_Internalname = "VENTASDETALLEEXENTO_"+sGXsfl_107_fel_idx ;
      edtVentasDetalleIva5_Internalname = "VENTASDETALLEIVA5_"+sGXsfl_107_fel_idx ;
      edtVentasDetalleIva10_Internalname = "VENTASDETALLEIVA10_"+sGXsfl_107_fel_idx ;
      edtVentasDetalleSubTotal_Internalname = "VENTASDETALLESUBTOTAL_"+sGXsfl_107_fel_idx ;
      edtVentasDetalleTallaID_Internalname = "VENTASDETALLETALLAID_"+sGXsfl_107_fel_idx ;
   }

   public void addRow0H17( )
   {
      nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
      sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_10717( ) ;
      sendRow0H17( ) ;
   }

   public void sendRow0H17( )
   {
      Gridlevel_detalleRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_detalle_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(0) ;
         subGridlevel_detalle_Backcolor = subGridlevel_detalle_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
         }
         subGridlevel_detalle_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_107_idx) % (2))) == 0 )
         {
            subGridlevel_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
            {
               subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
            {
               subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
            }
         }
      }
      imgprompt_13_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.articuloprompt"+"',["+"{Ctrl:gx.dom.el('"+"ARTICULOID_"+sGXsfl_107_idx+"'), id:'"+"ARTICULOID_"+sGXsfl_107_idx+"'"+",IOType:'inout'}"+"],"+"gx.dom.form()."+"nIsMod_17_"+sGXsfl_107_idx+","+"'', false"+","+"false"+");") ;
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_17_" + sGXsfl_107_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 108,'',false,'" + sGXsfl_107_idx + "',107)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleId_Internalname,GXutil.ltrim( localUtil.ntoc( A20VentasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20VentasDetalleId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_17_" + sGXsfl_107_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 109,'',false,'" + sGXsfl_107_idx + "',107)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloId_Internalname,GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,109);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_13_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_13_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      Gridlevel_detalleRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgprompt_13_Internalname,sImgUrl,imgprompt_13_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(imgprompt_13_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloNombre_Internalname,GXutil.rtrim( A76ArticuloNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpuestoPorcentaje_Internalname,GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtImpuestoPorcentaje_Enabled!=0) ? localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99") : localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtImpuestoPorcentaje_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtImpuestoPorcentaje_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Porcentaje","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_17_" + sGXsfl_107_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 112,'',false,'" + sGXsfl_107_idx + "',107)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleCantidad_Internalname,GXutil.ltrim( localUtil.ntoc( A92VentasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtVentasDetalleCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A92VentasDetalleCantidad), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A92VentasDetalleCantidad), "ZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,112);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleCantidad_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleCantidad_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cantidad","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloPrecioVenta_Internalname,GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloPrecioVenta_Enabled!=0) ? localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloPrecioVenta_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloPrecioVenta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleExento_Internalname,GXutil.ltrim( localUtil.ntoc( A94VentasDetalleExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtVentasDetalleExento_Enabled!=0) ? localUtil.format( A94VentasDetalleExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A94VentasDetalleExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleExento_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleExento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleIva5_Internalname,GXutil.ltrim( localUtil.ntoc( A96VentasDetalleIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtVentasDetalleIva5_Enabled!=0) ? localUtil.format( A96VentasDetalleIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A96VentasDetalleIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleIva5_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleIva5_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleIva10_Internalname,GXutil.ltrim( localUtil.ntoc( A95VentasDetalleIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtVentasDetalleIva10_Enabled!=0) ? localUtil.format( A95VentasDetalleIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A95VentasDetalleIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleIva10_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleIva10_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleSubTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A252VentasDetalleSubTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtVentasDetalleSubTotal_Enabled!=0) ? localUtil.format( A252VentasDetalleSubTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A252VentasDetalleSubTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleSubTotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleSubTotal_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_17_" + sGXsfl_107_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 118,'',false,'" + sGXsfl_107_idx + "',107)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasDetalleTallaID_Internalname,GXutil.ltrim( localUtil.ntoc( A292VentasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtVentasDetalleTallaID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A292VentasDetalleTallaID), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A292VentasDetalleTallaID), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,118);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasDetalleTallaID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtVentasDetalleTallaID_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes0H17( ) ;
      GXCCtl = "Z20VentasDetalleId_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z20VentasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z92VentasDetalleCantidad_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z92VentasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z292VentasDetalleTallaID_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z292VentasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z13ArticuloId_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O95VentasDetalleIva10_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O95VentasDetalleIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O96VentasDetalleIva5_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O96VentasDetalleIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O94VentasDetalleExento_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O94VentasDetalleExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_17_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_17_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_17_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_17, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_107_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV10TrnContext);
      }
      GXCCtl = "vVENTASID_" + sGXsfl_107_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV14VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLEID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULONOMBRE_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IMPUESTOPORCENTAJE_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLECANTIDAD_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOPRECIOVENTA_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLEEXENTO_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLEIVA5_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLEIVA10_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLESUBTOTAL_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleSubTotal_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "VENTASDETALLETALLAID_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PROMPT_13_"+sGXsfl_107_idx+"Link", GXutil.rtrim( imgprompt_13_Link));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow0H17( )
   {
      nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
      sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_10717( ) ;
      edtVentasDetalleId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEID_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtImpuestoPorcentaje_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "IMPUESTOPORCENTAJE_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtVentasDetalleCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLECANTIDAD_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOPRECIOVENTA_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtVentasDetalleExento_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEEXENTO_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtVentasDetalleIva5_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEIVA5_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtVentasDetalleIva10_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLEIVA10_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtVentasDetalleSubTotal_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLESUBTOTAL_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtVentasDetalleTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "VENTASDETALLETALLAID_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      imgprompt_4_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_107_idx+"Link") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "VENTASDETALLEID_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasDetalleId_Internalname ;
         wbErr = true ;
         A20VentasDetalleId = 0 ;
      }
      else
      {
         A20VentasDetalleId = localUtil.ctol( httpContext.cgiGet( edtVentasDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         wbErr = true ;
         A13ArticuloId = 0 ;
      }
      else
      {
         A13ArticuloId = localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      A76ArticuloNombre = httpContext.cgiGet( edtArticuloNombre_Internalname) ;
      A83ImpuestoPorcentaje = localUtil.ctond( httpContext.cgiGet( edtImpuestoPorcentaje_Internalname)) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
      {
         GXCCtl = "VENTASDETALLECANTIDAD_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasDetalleCantidad_Internalname ;
         wbErr = true ;
         A92VentasDetalleCantidad = 0 ;
      }
      else
      {
         A92VentasDetalleCantidad = (int)(localUtil.ctol( httpContext.cgiGet( edtVentasDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A78ArticuloPrecioVenta = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)) ;
      A94VentasDetalleExento = localUtil.ctond( httpContext.cgiGet( edtVentasDetalleExento_Internalname)) ;
      A96VentasDetalleIva5 = localUtil.ctond( httpContext.cgiGet( edtVentasDetalleIva5_Internalname)) ;
      A95VentasDetalleIva10 = localUtil.ctond( httpContext.cgiGet( edtVentasDetalleIva10_Internalname)) ;
      A252VentasDetalleSubTotal = localUtil.ctond( httpContext.cgiGet( edtVentasDetalleSubTotal_Internalname)) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasDetalleTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasDetalleTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "VENTASDETALLETALLAID_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasDetalleTallaID_Internalname ;
         wbErr = true ;
         A292VentasDetalleTallaID = 0 ;
      }
      else
      {
         A292VentasDetalleTallaID = localUtil.ctol( httpContext.cgiGet( edtVentasDetalleTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      GXCCtl = "Z20VentasDetalleId_" + sGXsfl_107_idx ;
      Z20VentasDetalleId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z92VentasDetalleCantidad_" + sGXsfl_107_idx ;
      Z92VentasDetalleCantidad = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z292VentasDetalleTallaID_" + sGXsfl_107_idx ;
      Z292VentasDetalleTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z13ArticuloId_" + sGXsfl_107_idx ;
      Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "O95VentasDetalleIva10_" + sGXsfl_107_idx ;
      O95VentasDetalleIva10 = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "O96VentasDetalleIva5_" + sGXsfl_107_idx ;
      O96VentasDetalleIva5 = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "O94VentasDetalleExento_" + sGXsfl_107_idx ;
      O94VentasDetalleExento = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_17_" + sGXsfl_107_idx ;
      nRcdDeleted_17 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_17_" + sGXsfl_107_idx ;
      nRcdExists_17 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_17_" + sGXsfl_107_idx ;
      nIsMod_17 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtVentasDetalleId_Enabled = edtVentasDetalleId_Enabled ;
   }

   public void confirmValues0H0( )
   {
      nGXsfl_107_idx = 0 ;
      sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_10717( ) ;
      while ( nGXsfl_107_idx < nRC_GXsfl_107 )
      {
         nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
         sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_10717( ) ;
         httpContext.changePostValue( "Z20VentasDetalleId_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z20VentasDetalleId_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z20VentasDetalleId_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z92VentasDetalleCantidad_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z92VentasDetalleCantidad_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z92VentasDetalleCantidad_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z292VentasDetalleTallaID_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z292VentasDetalleTallaID_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z292VentasDetalleTallaID_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z13ArticuloId_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z13ArticuloId_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_107_idx) ;
      }
      httpContext.changePostValue( "O95VentasDetalleIva10", httpContext.cgiGet( "T95VentasDetalleIva10")) ;
      httpContext.deletePostValue( "T95VentasDetalleIva10") ;
      httpContext.changePostValue( "O96VentasDetalleIva5", httpContext.cgiGet( "T96VentasDetalleIva5")) ;
      httpContext.deletePostValue( "T96VentasDetalleIva5") ;
      httpContext.changePostValue( "O94VentasDetalleExento", httpContext.cgiGet( "T94VentasDetalleExento")) ;
      httpContext.deletePostValue( "T94VentasDetalleExento") ;
   }

   public void renderHtmlHeaders( )
   {
      com.mujermorena.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.ventas", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV14VentasId,11,0))}, new String[] {"Gx_mode","VentasId"}) +"\">") ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Ventas");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("ventas:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z19VentasId", GXutil.ltrim( localUtil.ntoc( Z19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z91VentasFecha", localUtil.dtoc( Z91VentasFecha, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z311VentasNroFactura", GXutil.ltrim( localUtil.ntoc( Z311VentasNroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z309VentasSerie1", GXutil.ltrim( localUtil.ntoc( Z309VentasSerie1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z310VentasSerie2", GXutil.ltrim( localUtil.ntoc( Z310VentasSerie2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z251VentasPedido", GXutil.ltrim( localUtil.ntoc( Z251VentasPedido, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z242VentasSerial", GXutil.ltrim( localUtil.ntoc( Z242VentasSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z4ClienteId", GXutil.ltrim( localUtil.ntoc( Z4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z9TipoPagoId", GXutil.ltrim( localUtil.ntoc( Z9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z29TimbradoId", GXutil.ltrim( localUtil.ntoc( Z29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O242VentasSerial", GXutil.ltrim( localUtil.ntoc( O242VentasSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O238VentasTotal10", GXutil.ltrim( localUtil.ntoc( O238VentasTotal10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O236VentasTotal5", GXutil.ltrim( localUtil.ntoc( O236VentasTotal5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O239VentasTotalExento", GXutil.ltrim( localUtil.ntoc( O239VentasTotalExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_107", GXutil.ltrim( localUtil.ntoc( nGXsfl_107_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N4ClienteId", GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N29TimbradoId", GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N9TipoPagoId", GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV10TrnContext);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV10TrnContext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vVENTASID", GXutil.ltrim( localUtil.ntoc( AV14VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVENTASID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14VentasId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV17Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLIENTEID", GXutil.ltrim( localUtil.ntoc( AV12Insert_ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIMBRADOID", GXutil.ltrim( localUtil.ntoc( AV16Insert_TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOPAGOID", GXutil.ltrim( localUtil.ntoc( AV15Insert_TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IMPUESTOID", GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.mujermorena.ventas", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV14VentasId,11,0))}, new String[] {"Gx_mode","VentasId"})  ;
   }

   public String getPgmname( )
   {
      return "Ventas" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Ventas", "") ;
   }

   public void initializeNonKey0H16( )
   {
      A4ClienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      A29TimbradoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      A9TipoPagoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
      A91VentasFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
      A311VentasNroFactura = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
      A309VentasSerie1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
      A310VentasSerie2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
      A241VentasTotalIVA = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      A240VentasTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      A251VentasPedido = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
      A125TimbradoNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
      A242VentasSerial = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
      A239VentasTotalExento = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      A236VentasTotal5 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      A238VentasTotal10 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      O242VentasSerial = A242VentasSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
      O238VentasTotal10 = A238VentasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      O236VentasTotal5 = A236VentasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      O239VentasTotalExento = A239VentasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
      Z91VentasFecha = GXutil.nullDate() ;
      Z311VentasNroFactura = 0 ;
      Z309VentasSerie1 = (short)(0) ;
      Z310VentasSerie2 = (short)(0) ;
      Z251VentasPedido = 0 ;
      Z242VentasSerial = 0 ;
      Z4ClienteId = 0 ;
      Z9TipoPagoId = 0 ;
      Z29TimbradoId = 0 ;
   }

   public void initAll0H16( )
   {
      A19VentasId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      initializeNonKey0H16( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0H17( )
   {
      A18ImpuestoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
      A252VentasDetalleSubTotal = DecimalUtil.ZERO ;
      A94VentasDetalleExento = DecimalUtil.ZERO ;
      A95VentasDetalleIva10 = DecimalUtil.ZERO ;
      A96VentasDetalleIva5 = DecimalUtil.ZERO ;
      A13ArticuloId = 0 ;
      A76ArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A92VentasDetalleCantidad = 0 ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A292VentasDetalleTallaID = 0 ;
      O95VentasDetalleIva10 = A95VentasDetalleIva10 ;
      O96VentasDetalleIva5 = A96VentasDetalleIva5 ;
      O94VentasDetalleExento = A94VentasDetalleExento ;
      Z92VentasDetalleCantidad = 0 ;
      Z292VentasDetalleTallaID = 0 ;
      Z13ArticuloId = 0 ;
   }

   public void initAll0H17( )
   {
      A20VentasDetalleId = 0 ;
      initializeNonKey0H17( ) ;
   }

   public void standaloneModalInsert0H17( )
   {
      A242VentasSerial = i242VentasSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111101431", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("ventas.js", "?202412111101431", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties17( )
   {
      edtVentasDetalleId_Enabled = defedtVentasDetalleId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasDetalleId_Enabled), 5, 0), !bGXsfl_107_Refreshing);
   }

   public void startgridcontrol107( )
   {
      Gridlevel_detalleContainer.AddObjectProperty("GridName", "Gridlevel_detalle");
      Gridlevel_detalleContainer.AddObjectProperty("Header", subGridlevel_detalle_Header);
      Gridlevel_detalleContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_detalleContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_detalleContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A20VentasDetalleId, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.rtrim( A76ArticuloNombre));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A92VentasDetalleCantidad, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A94VentasDetalleExento, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A96VentasDetalleIva5, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A95VentasDetalleIva10, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A252VentasDetalleSubTotal, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleSubTotal_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A292VentasDetalleTallaID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtVentasDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtVentasId_Internalname = "VENTASID" ;
      edtVentasFecha_Internalname = "VENTASFECHA" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtVentasSerial_Internalname = "VENTASSERIAL" ;
      edtVentasTotalExento_Internalname = "VENTASTOTALEXENTO" ;
      edtVentasTotal5_Internalname = "VENTASTOTAL5" ;
      edtVentasTotal10_Internalname = "VENTASTOTAL10" ;
      edtVentasTotal_Internalname = "VENTASTOTAL" ;
      edtVentasTotalIva5_Internalname = "VENTASTOTALIVA5" ;
      edtVentasTotalIva10_Internalname = "VENTASTOTALIVA10" ;
      edtVentasTotalIVA_Internalname = "VENTASTOTALIVA" ;
      edtVentasPedido_Internalname = "VENTASPEDIDO" ;
      edtTipoPagoId_Internalname = "TIPOPAGOID" ;
      edtTimbradoId_Internalname = "TIMBRADOID" ;
      edtTimbradoNumero_Internalname = "TIMBRADONUMERO" ;
      edtVentasSerie1_Internalname = "VENTASSERIE1" ;
      edtVentasSerie2_Internalname = "VENTASSERIE2" ;
      edtVentasNroFactura_Internalname = "VENTASNROFACTURA" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtVentasDetalleId_Internalname = "VENTASDETALLEID" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE" ;
      edtVentasDetalleCantidad_Internalname = "VENTASDETALLECANTIDAD" ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA" ;
      edtVentasDetalleExento_Internalname = "VENTASDETALLEEXENTO" ;
      edtVentasDetalleIva5_Internalname = "VENTASDETALLEIVA5" ;
      edtVentasDetalleIva10_Internalname = "VENTASDETALLEIVA10" ;
      edtVentasDetalleSubTotal_Internalname = "VENTASDETALLESUBTOTAL" ;
      edtVentasDetalleTallaID_Internalname = "VENTASDETALLETALLAID" ;
      divTableleaflevel_detalle_Internalname = "TABLELEAFLEVEL_DETALLE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_4_Internalname = "PROMPT_4" ;
      imgprompt_9_Internalname = "PROMPT_9" ;
      imgprompt_29_Internalname = "PROMPT_29" ;
      imgprompt_13_Internalname = "PROMPT_13" ;
      subGridlevel_detalle_Internalname = "GRIDLEVEL_DETALLE" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridlevel_detalle_Allowcollapsing = (byte)(0) ;
      subGridlevel_detalle_Allowselection = (byte)(0) ;
      subGridlevel_detalle_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Ventas", "") );
      edtVentasDetalleTallaID_Jsonclick = "" ;
      edtVentasDetalleSubTotal_Jsonclick = "" ;
      edtVentasDetalleIva10_Jsonclick = "" ;
      edtVentasDetalleIva5_Jsonclick = "" ;
      edtVentasDetalleExento_Jsonclick = "" ;
      edtArticuloPrecioVenta_Jsonclick = "" ;
      edtVentasDetalleCantidad_Jsonclick = "" ;
      edtImpuestoPorcentaje_Jsonclick = "" ;
      edtArticuloNombre_Jsonclick = "" ;
      imgprompt_13_Visible = 1 ;
      imgprompt_13_Link = "" ;
      imgprompt_4_Visible = 1 ;
      edtArticuloId_Jsonclick = "" ;
      edtVentasDetalleId_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      edtVentasDetalleTallaID_Enabled = 1 ;
      edtVentasDetalleSubTotal_Enabled = 0 ;
      edtVentasDetalleIva10_Enabled = 0 ;
      edtVentasDetalleIva5_Enabled = 0 ;
      edtVentasDetalleExento_Enabled = 0 ;
      edtArticuloPrecioVenta_Enabled = 0 ;
      edtVentasDetalleCantidad_Enabled = 1 ;
      edtImpuestoPorcentaje_Enabled = 0 ;
      edtArticuloNombre_Enabled = 0 ;
      edtArticuloId_Enabled = 1 ;
      edtVentasDetalleId_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtVentasNroFactura_Jsonclick = "" ;
      edtVentasNroFactura_Enabled = 1 ;
      edtVentasSerie2_Jsonclick = "" ;
      edtVentasSerie2_Enabled = 1 ;
      edtVentasSerie1_Jsonclick = "" ;
      edtVentasSerie1_Enabled = 1 ;
      edtTimbradoNumero_Jsonclick = "" ;
      edtTimbradoNumero_Enabled = 0 ;
      imgprompt_29_Visible = 1 ;
      imgprompt_29_Link = "" ;
      edtTimbradoId_Jsonclick = "" ;
      edtTimbradoId_Enabled = 1 ;
      imgprompt_9_Visible = 1 ;
      imgprompt_9_Link = "" ;
      edtTipoPagoId_Jsonclick = "" ;
      edtTipoPagoId_Enabled = 1 ;
      edtVentasPedido_Jsonclick = "" ;
      edtVentasPedido_Enabled = 1 ;
      edtVentasTotalIVA_Jsonclick = "" ;
      edtVentasTotalIVA_Enabled = 0 ;
      edtVentasTotalIva10_Jsonclick = "" ;
      edtVentasTotalIva10_Enabled = 0 ;
      edtVentasTotalIva5_Jsonclick = "" ;
      edtVentasTotalIva5_Enabled = 0 ;
      edtVentasTotal_Jsonclick = "" ;
      edtVentasTotal_Enabled = 0 ;
      edtVentasTotal10_Jsonclick = "" ;
      edtVentasTotal10_Enabled = 0 ;
      edtVentasTotal5_Jsonclick = "" ;
      edtVentasTotal5_Enabled = 0 ;
      edtVentasTotalExento_Jsonclick = "" ;
      edtVentasTotalExento_Enabled = 0 ;
      edtVentasSerial_Jsonclick = "" ;
      edtVentasSerial_Enabled = 0 ;
      imgprompt_4_Visible = 1 ;
      imgprompt_4_Link = "" ;
      edtClienteId_Jsonclick = "" ;
      edtClienteId_Enabled = 1 ;
      edtVentasFecha_Jsonclick = "" ;
      edtVentasFecha_Enabled = 1 ;
      edtVentasId_Jsonclick = "" ;
      edtVentasId_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx8asaventasid0H16( long AV14VentasId ,
                                   String AV17Pgmname )
   {
      if ( ! (0==AV14VentasId) )
      {
         A19VentasId = AV14VentasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A19VentasId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV17Pgmname), GXv_int3) ;
            ventas_impl.this.GXt_int2 = GXv_int3[0] ;
            A19VentasId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx12asatimbradoid0H16( long AV16Insert_TimbradoId )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_TimbradoId) )
      {
         A29TimbradoId = AV16Insert_TimbradoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A29TimbradoId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "TIM", ""), ""), GXv_int3) ;
            ventas_impl.this.GXt_int2 = GXv_int3[0] ;
            A29TimbradoId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx18asaventasnrofactura0H16( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A311VentasNroFactura ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "FAC", ""), ""), GXv_int3) ;
         ventas_impl.this.GXt_int2 = GXv_int3[0] ;
         A311VentasNroFactura = GXt_int2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A311VentasNroFactura, (byte)(15), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx19asaventasserie10H16( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A309VentasSerie1 ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "SE1", ""), ""), GXv_int3) ;
         ventas_impl.this.GXt_int2 = GXv_int3[0] ;
         A309VentasSerie1 = (short)(GXt_int2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A309VentasSerie1, (byte)(3), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx20asaventasserie20H16( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A310VentasSerie2 ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorfactura(remoteHandle, context).execute( httpContext.getMessage( httpContext.getMessage( "SE2", ""), ""), GXv_int3) ;
         ventas_impl.this.GXt_int2 = GXv_int3[0] ;
         A310VentasSerie2 = (short)(GXt_int2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A310VentasSerie2, (byte)(3), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_detalle_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_10717( ) ;
      while ( nGXsfl_107_idx <= nRC_GXsfl_107 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0H17( ) ;
         standaloneModal0H17( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0H17( ) ;
         nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
         sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_10717( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_detalleContainer)) ;
      /* End function gxnrGridlevel_detalle_newrow */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Ventasid( )
   {
      /* Using cursor T000H27 */
      pr_default.execute(21, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(21) != 101) )
      {
         A239VentasTotalExento = T000H27_A239VentasTotalExento[0] ;
         A236VentasTotal5 = T000H27_A236VentasTotal5[0] ;
         A238VentasTotal10 = T000H27_A238VentasTotal10[0] ;
      }
      else
      {
         A239VentasTotalExento = DecimalUtil.doubleToDec(0) ;
         A236VentasTotal5 = DecimalUtil.doubleToDec(0) ;
         A238VentasTotal10 = DecimalUtil.doubleToDec(0) ;
      }
      pr_default.close(21);
      A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
      A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A239VentasTotalExento", GXutil.ltrim( localUtil.ntoc( A239VentasTotalExento, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A236VentasTotal5", GXutil.ltrim( localUtil.ntoc( A236VentasTotal5, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A238VentasTotal10", GXutil.ltrim( localUtil.ntoc( A238VentasTotal10, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A235VentasTotalIva5", GXutil.ltrim( localUtil.ntoc( A235VentasTotalIva5, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A240VentasTotal", GXutil.ltrim( localUtil.ntoc( A240VentasTotal, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A237VentasTotalIva10", GXutil.ltrim( localUtil.ntoc( A237VentasTotalIva10, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A241VentasTotalIVA", GXutil.ltrim( localUtil.ntoc( A241VentasTotalIVA, (byte)(17), (byte)(2), ".", "")));
   }

   public void valid_Clienteid( )
   {
      /* Using cursor T000H42 */
      pr_default.execute(36, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(36) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
      }
      pr_default.close(36);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Tipopagoid( )
   {
      /* Using cursor T000H43 */
      pr_default.execute(37, new Object[] {Long.valueOf(A9TipoPagoId)});
      if ( (pr_default.getStatus(37) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoPagoId_Internalname ;
      }
      pr_default.close(37);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Timbradoid( )
   {
      /* Using cursor T000H28 */
      pr_default.execute(22, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Timbrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
      }
      A125TimbradoNumero = T000H28_A125TimbradoNumero[0] ;
      pr_default.close(22);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), ".", "")));
   }

   public void valid_Articuloid( )
   {
      /* Using cursor T000H39 */
      pr_default.execute(33, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(33) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
      }
      A18ImpuestoId = T000H39_A18ImpuestoId[0] ;
      A76ArticuloNombre = T000H39_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T000H39_A78ArticuloPrecioVenta[0] ;
      pr_default.close(33);
      /* Using cursor T000H40 */
      pr_default.execute(34, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(34) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T000H40_A83ImpuestoPorcentaje[0] ;
      pr_default.close(34);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", GXutil.rtrim( A76ArticuloNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV14VentasId',fld:'vVENTASID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV14VentasId',fld:'vVENTASID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120H2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_VENTASID","{handler:'valid_Ventasid',iparms:[{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'},{av:'A236VentasTotal5',fld:'VENTASTOTAL5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A239VentasTotalExento',fld:'VENTASTOTALEXENTO',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A238VentasTotal10',fld:'VENTASTOTAL10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A235VentasTotalIva5',fld:'VENTASTOTALIVA5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A237VentasTotalIva10',fld:'VENTASTOTALIVA10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A240VentasTotal',fld:'VENTASTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A241VentasTotalIVA',fld:'VENTASTOTALIVA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("VALID_VENTASID",",oparms:[{av:'A239VentasTotalExento',fld:'VENTASTOTALEXENTO',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A236VentasTotal5',fld:'VENTASTOTAL5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A238VentasTotal10',fld:'VENTASTOTAL10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A235VentasTotalIva5',fld:'VENTASTOTALIVA5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A240VentasTotal',fld:'VENTASTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A237VentasTotalIva10',fld:'VENTASTOTALIVA10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A241VentasTotalIVA',fld:'VENTASTOTALIVA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("VALID_VENTASFECHA","{handler:'valid_Ventasfecha',iparms:[]");
      setEventMetadata("VALID_VENTASFECHA",",oparms:[]}");
      setEventMetadata("VALID_CLIENTEID","{handler:'valid_Clienteid',iparms:[{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_CLIENTEID",",oparms:[]}");
      setEventMetadata("VALID_VENTASSERIAL","{handler:'valid_Ventasserial',iparms:[]");
      setEventMetadata("VALID_VENTASSERIAL",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTALEXENTO","{handler:'valid_Ventastotalexento',iparms:[]");
      setEventMetadata("VALID_VENTASTOTALEXENTO",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTAL5","{handler:'valid_Ventastotal5',iparms:[]");
      setEventMetadata("VALID_VENTASTOTAL5",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTAL10","{handler:'valid_Ventastotal10',iparms:[]");
      setEventMetadata("VALID_VENTASTOTAL10",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTALIVA5","{handler:'valid_Ventastotaliva5',iparms:[]");
      setEventMetadata("VALID_VENTASTOTALIVA5",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTALIVA10","{handler:'valid_Ventastotaliva10',iparms:[]");
      setEventMetadata("VALID_VENTASTOTALIVA10",",oparms:[]}");
      setEventMetadata("VALID_TIPOPAGOID","{handler:'valid_Tipopagoid',iparms:[{av:'A9TipoPagoId',fld:'TIPOPAGOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_TIPOPAGOID",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOID","{handler:'valid_Timbradoid',iparms:[{av:'A29TimbradoId',fld:'TIMBRADOID',pic:'ZZZZZZZZZZ9'},{av:'A125TimbradoNumero',fld:'TIMBRADONUMERO',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VALID_TIMBRADOID",",oparms:[{av:'A125TimbradoNumero',fld:'TIMBRADONUMERO',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_VENTASDETALLEID","{handler:'valid_Ventasdetalleid',iparms:[]");
      setEventMetadata("VALID_VENTASDETALLEID",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A78ArticuloPrecioVenta',fld:'ARTICULOPRECIOVENTA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A78ArticuloPrecioVenta',fld:'ARTICULOPRECIOVENTA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]}");
      setEventMetadata("VALID_IMPUESTOPORCENTAJE","{handler:'valid_Impuestoporcentaje',iparms:[]");
      setEventMetadata("VALID_IMPUESTOPORCENTAJE",",oparms:[]}");
      setEventMetadata("VALID_VENTASDETALLECANTIDAD","{handler:'valid_Ventasdetallecantidad',iparms:[]");
      setEventMetadata("VALID_VENTASDETALLECANTIDAD",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOPRECIOVENTA","{handler:'valid_Articuloprecioventa',iparms:[]");
      setEventMetadata("VALID_ARTICULOPRECIOVENTA",",oparms:[]}");
      setEventMetadata("VALID_VENTASDETALLEEXENTO","{handler:'valid_Ventasdetalleexento',iparms:[]");
      setEventMetadata("VALID_VENTASDETALLEEXENTO",",oparms:[]}");
      setEventMetadata("VALID_VENTASDETALLEIVA5","{handler:'valid_Ventasdetalleiva5',iparms:[]");
      setEventMetadata("VALID_VENTASDETALLEIVA5",",oparms:[]}");
      setEventMetadata("VALID_VENTASDETALLEIVA10","{handler:'valid_Ventasdetalleiva10',iparms:[]");
      setEventMetadata("VALID_VENTASDETALLEIVA10",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Ventasdetalletallaid',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "ventas_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(33);
      pr_default.close(34);
      pr_default.close(36);
      pr_default.close(37);
      pr_default.close(22);
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z91VentasFecha = GXutil.nullDate() ;
      O238VentasTotal10 = DecimalUtil.ZERO ;
      O236VentasTotal5 = DecimalUtil.ZERO ;
      O239VentasTotalExento = DecimalUtil.ZERO ;
      O95VentasDetalleIva10 = DecimalUtil.ZERO ;
      O96VentasDetalleIva5 = DecimalUtil.ZERO ;
      O94VentasDetalleExento = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV17Pgmname = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A91VentasFecha = GXutil.nullDate() ;
      imgprompt_4_gximage = "" ;
      sImgUrl = "" ;
      A239VentasTotalExento = DecimalUtil.ZERO ;
      A236VentasTotal5 = DecimalUtil.ZERO ;
      A238VentasTotal10 = DecimalUtil.ZERO ;
      A240VentasTotal = DecimalUtil.ZERO ;
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      A241VentasTotalIVA = DecimalUtil.ZERO ;
      imgprompt_9_gximage = "" ;
      imgprompt_29_gximage = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      B238VentasTotal10 = DecimalUtil.ZERO ;
      B236VentasTotal5 = DecimalUtil.ZERO ;
      B239VentasTotalExento = DecimalUtil.ZERO ;
      sMode17 = "" ;
      sStyleString = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode16 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      s238VentasTotal10 = DecimalUtil.ZERO ;
      s236VentasTotal5 = DecimalUtil.ZERO ;
      s239VentasTotalExento = DecimalUtil.ZERO ;
      s237VentasTotalIva10 = DecimalUtil.ZERO ;
      O237VentasTotalIva10 = DecimalUtil.ZERO ;
      s241VentasTotalIVA = DecimalUtil.ZERO ;
      O241VentasTotalIVA = DecimalUtil.ZERO ;
      s235VentasTotalIva5 = DecimalUtil.ZERO ;
      O235VentasTotalIva5 = DecimalUtil.ZERO ;
      s240VentasTotal = DecimalUtil.ZERO ;
      O240VentasTotal = DecimalUtil.ZERO ;
      GXCCtl = "" ;
      A76ArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A94VentasDetalleExento = DecimalUtil.ZERO ;
      A96VentasDetalleIva5 = DecimalUtil.ZERO ;
      A95VentasDetalleIva10 = DecimalUtil.ZERO ;
      A252VentasDetalleSubTotal = DecimalUtil.ZERO ;
      T95VentasDetalleIva10 = DecimalUtil.ZERO ;
      T96VentasDetalleIva5 = DecimalUtil.ZERO ;
      T94VentasDetalleExento = DecimalUtil.ZERO ;
      AV7WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV10TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z239VentasTotalExento = DecimalUtil.ZERO ;
      Z236VentasTotal5 = DecimalUtil.ZERO ;
      Z238VentasTotal10 = DecimalUtil.ZERO ;
      T000H12_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H12_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H12_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H10_A125TimbradoNumero = new long[1] ;
      T000H14_A19VentasId = new long[1] ;
      T000H14_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000H14_A311VentasNroFactura = new long[1] ;
      T000H14_A309VentasSerie1 = new short[1] ;
      T000H14_A310VentasSerie2 = new short[1] ;
      T000H14_A251VentasPedido = new long[1] ;
      T000H14_A125TimbradoNumero = new long[1] ;
      T000H14_A242VentasSerial = new long[1] ;
      T000H14_A4ClienteId = new long[1] ;
      T000H14_A9TipoPagoId = new long[1] ;
      T000H14_A29TimbradoId = new long[1] ;
      T000H14_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H14_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H14_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H8_A4ClienteId = new long[1] ;
      T000H9_A9TipoPagoId = new long[1] ;
      T000H16_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H16_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H16_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H17_A4ClienteId = new long[1] ;
      T000H18_A125TimbradoNumero = new long[1] ;
      T000H19_A9TipoPagoId = new long[1] ;
      T000H20_A19VentasId = new long[1] ;
      T000H7_A19VentasId = new long[1] ;
      T000H7_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000H7_A311VentasNroFactura = new long[1] ;
      T000H7_A309VentasSerie1 = new short[1] ;
      T000H7_A310VentasSerie2 = new short[1] ;
      T000H7_A251VentasPedido = new long[1] ;
      T000H7_A242VentasSerial = new long[1] ;
      T000H7_A4ClienteId = new long[1] ;
      T000H7_A9TipoPagoId = new long[1] ;
      T000H7_A29TimbradoId = new long[1] ;
      T000H21_A19VentasId = new long[1] ;
      T000H22_A19VentasId = new long[1] ;
      T000H6_A19VentasId = new long[1] ;
      T000H6_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000H6_A311VentasNroFactura = new long[1] ;
      T000H6_A309VentasSerie1 = new short[1] ;
      T000H6_A310VentasSerie2 = new short[1] ;
      T000H6_A251VentasPedido = new long[1] ;
      T000H6_A242VentasSerial = new long[1] ;
      T000H6_A4ClienteId = new long[1] ;
      T000H6_A9TipoPagoId = new long[1] ;
      T000H6_A29TimbradoId = new long[1] ;
      T000H27_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H27_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H27_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H28_A125TimbradoNumero = new long[1] ;
      T000H29_A272DevolucionesID = new long[1] ;
      T000H31_A19VentasId = new long[1] ;
      Z76ArticuloNombre = "" ;
      Z78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      Z83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      T000H32_A18ImpuestoId = new long[1] ;
      T000H32_A19VentasId = new long[1] ;
      T000H32_A20VentasDetalleId = new long[1] ;
      T000H32_A76ArticuloNombre = new String[] {""} ;
      T000H32_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H32_A92VentasDetalleCantidad = new int[1] ;
      T000H32_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H32_A292VentasDetalleTallaID = new long[1] ;
      T000H32_A13ArticuloId = new long[1] ;
      T000H4_A18ImpuestoId = new long[1] ;
      T000H4_A76ArticuloNombre = new String[] {""} ;
      T000H4_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H5_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H33_A18ImpuestoId = new long[1] ;
      T000H33_A76ArticuloNombre = new String[] {""} ;
      T000H33_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H34_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H35_A19VentasId = new long[1] ;
      T000H35_A20VentasDetalleId = new long[1] ;
      T000H3_A19VentasId = new long[1] ;
      T000H3_A20VentasDetalleId = new long[1] ;
      T000H3_A92VentasDetalleCantidad = new int[1] ;
      T000H3_A292VentasDetalleTallaID = new long[1] ;
      T000H3_A13ArticuloId = new long[1] ;
      T000H2_A19VentasId = new long[1] ;
      T000H2_A20VentasDetalleId = new long[1] ;
      T000H2_A92VentasDetalleCantidad = new int[1] ;
      T000H2_A292VentasDetalleTallaID = new long[1] ;
      T000H2_A13ArticuloId = new long[1] ;
      T000H39_A18ImpuestoId = new long[1] ;
      T000H39_A76ArticuloNombre = new String[] {""} ;
      T000H39_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H40_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000H41_A19VentasId = new long[1] ;
      T000H41_A20VentasDetalleId = new long[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      imgprompt_13_gximage = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int3 = new long[1] ;
      Z235VentasTotalIva5 = DecimalUtil.ZERO ;
      Z240VentasTotal = DecimalUtil.ZERO ;
      Z237VentasTotalIva10 = DecimalUtil.ZERO ;
      Z241VentasTotalIVA = DecimalUtil.ZERO ;
      T000H42_A4ClienteId = new long[1] ;
      T000H43_A9TipoPagoId = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ventas__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ventas__default(),
         new Object[] {
             new Object[] {
            T000H2_A19VentasId, T000H2_A20VentasDetalleId, T000H2_A92VentasDetalleCantidad, T000H2_A292VentasDetalleTallaID, T000H2_A13ArticuloId
            }
            , new Object[] {
            T000H3_A19VentasId, T000H3_A20VentasDetalleId, T000H3_A92VentasDetalleCantidad, T000H3_A292VentasDetalleTallaID, T000H3_A13ArticuloId
            }
            , new Object[] {
            T000H4_A18ImpuestoId, T000H4_A76ArticuloNombre, T000H4_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T000H5_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000H6_A19VentasId, T000H6_A91VentasFecha, T000H6_A311VentasNroFactura, T000H6_A309VentasSerie1, T000H6_A310VentasSerie2, T000H6_A251VentasPedido, T000H6_A242VentasSerial, T000H6_A4ClienteId, T000H6_A9TipoPagoId, T000H6_A29TimbradoId
            }
            , new Object[] {
            T000H7_A19VentasId, T000H7_A91VentasFecha, T000H7_A311VentasNroFactura, T000H7_A309VentasSerie1, T000H7_A310VentasSerie2, T000H7_A251VentasPedido, T000H7_A242VentasSerial, T000H7_A4ClienteId, T000H7_A9TipoPagoId, T000H7_A29TimbradoId
            }
            , new Object[] {
            T000H8_A4ClienteId
            }
            , new Object[] {
            T000H9_A9TipoPagoId
            }
            , new Object[] {
            T000H10_A125TimbradoNumero
            }
            , new Object[] {
            T000H12_A239VentasTotalExento, T000H12_A236VentasTotal5, T000H12_A238VentasTotal10
            }
            , new Object[] {
            T000H14_A19VentasId, T000H14_A91VentasFecha, T000H14_A311VentasNroFactura, T000H14_A309VentasSerie1, T000H14_A310VentasSerie2, T000H14_A251VentasPedido, T000H14_A125TimbradoNumero, T000H14_A242VentasSerial, T000H14_A4ClienteId, T000H14_A9TipoPagoId,
            T000H14_A29TimbradoId, T000H14_A239VentasTotalExento, T000H14_A236VentasTotal5, T000H14_A238VentasTotal10
            }
            , new Object[] {
            T000H16_A239VentasTotalExento, T000H16_A236VentasTotal5, T000H16_A238VentasTotal10
            }
            , new Object[] {
            T000H17_A4ClienteId
            }
            , new Object[] {
            T000H18_A125TimbradoNumero
            }
            , new Object[] {
            T000H19_A9TipoPagoId
            }
            , new Object[] {
            T000H20_A19VentasId
            }
            , new Object[] {
            T000H21_A19VentasId
            }
            , new Object[] {
            T000H22_A19VentasId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000H27_A239VentasTotalExento, T000H27_A236VentasTotal5, T000H27_A238VentasTotal10
            }
            , new Object[] {
            T000H28_A125TimbradoNumero
            }
            , new Object[] {
            T000H29_A272DevolucionesID
            }
            , new Object[] {
            }
            , new Object[] {
            T000H31_A19VentasId
            }
            , new Object[] {
            T000H32_A18ImpuestoId, T000H32_A19VentasId, T000H32_A20VentasDetalleId, T000H32_A76ArticuloNombre, T000H32_A83ImpuestoPorcentaje, T000H32_A92VentasDetalleCantidad, T000H32_A78ArticuloPrecioVenta, T000H32_A292VentasDetalleTallaID, T000H32_A13ArticuloId
            }
            , new Object[] {
            T000H33_A18ImpuestoId, T000H33_A76ArticuloNombre, T000H33_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T000H34_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000H35_A19VentasId, T000H35_A20VentasDetalleId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000H39_A18ImpuestoId, T000H39_A76ArticuloNombre, T000H39_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T000H40_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000H41_A19VentasId, T000H41_A20VentasDetalleId
            }
            , new Object[] {
            T000H42_A4ClienteId
            }
            , new Object[] {
            T000H43_A9TipoPagoId
            }
         }
      );
      AV17Pgmname = "Ventas" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_detalle_Backcolorstyle ;
   private byte subGridlevel_detalle_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_detalle_Allowselection ;
   private byte subGridlevel_detalle_Allowhovering ;
   private byte subGridlevel_detalle_Allowcollapsing ;
   private byte subGridlevel_detalle_Collapsed ;
   private short nIsMod_17 ;
   private short Z309VentasSerie1 ;
   private short Z310VentasSerie2 ;
   private short nRcdDeleted_17 ;
   private short nRcdExists_17 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A309VentasSerie1 ;
   private short A310VentasSerie2 ;
   private short nBlankRcdCount17 ;
   private short RcdFound17 ;
   private short nBlankRcdUsr17 ;
   private short RcdFound16 ;
   private short nIsDirty_16 ;
   private short nIsDirty_17 ;
   private int nRC_GXsfl_107 ;
   private int nGXsfl_107_idx=1 ;
   private int Z92VentasDetalleCantidad ;
   private int trnEnded ;
   private int edtVentasId_Enabled ;
   private int edtVentasFecha_Enabled ;
   private int edtClienteId_Enabled ;
   private int imgprompt_4_Visible ;
   private int edtVentasSerial_Enabled ;
   private int edtVentasTotalExento_Enabled ;
   private int edtVentasTotal5_Enabled ;
   private int edtVentasTotal10_Enabled ;
   private int edtVentasTotal_Enabled ;
   private int edtVentasTotalIva5_Enabled ;
   private int edtVentasTotalIva10_Enabled ;
   private int edtVentasTotalIVA_Enabled ;
   private int edtVentasPedido_Enabled ;
   private int edtTipoPagoId_Enabled ;
   private int imgprompt_9_Visible ;
   private int edtTimbradoId_Enabled ;
   private int imgprompt_29_Visible ;
   private int edtTimbradoNumero_Enabled ;
   private int edtVentasSerie1_Enabled ;
   private int edtVentasSerie2_Enabled ;
   private int edtVentasNroFactura_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtVentasDetalleId_Enabled ;
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtImpuestoPorcentaje_Enabled ;
   private int edtVentasDetalleCantidad_Enabled ;
   private int edtArticuloPrecioVenta_Enabled ;
   private int edtVentasDetalleExento_Enabled ;
   private int edtVentasDetalleIva5_Enabled ;
   private int edtVentasDetalleIva10_Enabled ;
   private int edtVentasDetalleSubTotal_Enabled ;
   private int edtVentasDetalleTallaID_Enabled ;
   private int fRowAdded ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A92VentasDetalleCantidad ;
   private int AV19GXV1 ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int imgprompt_13_Visible ;
   private int defedtVentasDetalleId_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private long wcpOAV14VentasId ;
   private long Z19VentasId ;
   private long Z311VentasNroFactura ;
   private long Z251VentasPedido ;
   private long Z242VentasSerial ;
   private long Z4ClienteId ;
   private long Z9TipoPagoId ;
   private long Z29TimbradoId ;
   private long O242VentasSerial ;
   private long N4ClienteId ;
   private long N29TimbradoId ;
   private long N9TipoPagoId ;
   private long Z20VentasDetalleId ;
   private long Z292VentasDetalleTallaID ;
   private long Z13ArticuloId ;
   private long AV14VentasId ;
   private long AV16Insert_TimbradoId ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A29TimbradoId ;
   private long A9TipoPagoId ;
   private long A13ArticuloId ;
   private long A18ImpuestoId ;
   private long A242VentasSerial ;
   private long A251VentasPedido ;
   private long A125TimbradoNumero ;
   private long A311VentasNroFactura ;
   private long B242VentasSerial ;
   private long AV12Insert_ClienteId ;
   private long AV15Insert_TipoPagoId ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private long s242VentasSerial ;
   private long A20VentasDetalleId ;
   private long A292VentasDetalleTallaID ;
   private long Z125TimbradoNumero ;
   private long Z18ImpuestoId ;
   private long i242VentasSerial ;
   private long GXt_int2 ;
   private long GXv_int3[] ;
   private java.math.BigDecimal O238VentasTotal10 ;
   private java.math.BigDecimal O236VentasTotal5 ;
   private java.math.BigDecimal O239VentasTotalExento ;
   private java.math.BigDecimal O95VentasDetalleIva10 ;
   private java.math.BigDecimal O96VentasDetalleIva5 ;
   private java.math.BigDecimal O94VentasDetalleExento ;
   private java.math.BigDecimal A239VentasTotalExento ;
   private java.math.BigDecimal A236VentasTotal5 ;
   private java.math.BigDecimal A238VentasTotal10 ;
   private java.math.BigDecimal A240VentasTotal ;
   private java.math.BigDecimal A235VentasTotalIva5 ;
   private java.math.BigDecimal A237VentasTotalIva10 ;
   private java.math.BigDecimal A241VentasTotalIVA ;
   private java.math.BigDecimal B238VentasTotal10 ;
   private java.math.BigDecimal B236VentasTotal5 ;
   private java.math.BigDecimal B239VentasTotalExento ;
   private java.math.BigDecimal s238VentasTotal10 ;
   private java.math.BigDecimal s236VentasTotal5 ;
   private java.math.BigDecimal s239VentasTotalExento ;
   private java.math.BigDecimal s237VentasTotalIva10 ;
   private java.math.BigDecimal O237VentasTotalIva10 ;
   private java.math.BigDecimal s241VentasTotalIVA ;
   private java.math.BigDecimal O241VentasTotalIVA ;
   private java.math.BigDecimal s235VentasTotalIva5 ;
   private java.math.BigDecimal O235VentasTotalIva5 ;
   private java.math.BigDecimal s240VentasTotal ;
   private java.math.BigDecimal O240VentasTotal ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A94VentasDetalleExento ;
   private java.math.BigDecimal A96VentasDetalleIva5 ;
   private java.math.BigDecimal A95VentasDetalleIva10 ;
   private java.math.BigDecimal A252VentasDetalleSubTotal ;
   private java.math.BigDecimal T95VentasDetalleIva10 ;
   private java.math.BigDecimal T96VentasDetalleIva5 ;
   private java.math.BigDecimal T94VentasDetalleExento ;
   private java.math.BigDecimal Z239VentasTotalExento ;
   private java.math.BigDecimal Z236VentasTotal5 ;
   private java.math.BigDecimal Z238VentasTotal10 ;
   private java.math.BigDecimal Z78ArticuloPrecioVenta ;
   private java.math.BigDecimal Z83ImpuestoPorcentaje ;
   private java.math.BigDecimal Z235VentasTotalIva5 ;
   private java.math.BigDecimal Z240VentasTotal ;
   private java.math.BigDecimal Z237VentasTotalIva10 ;
   private java.math.BigDecimal Z241VentasTotalIVA ;
   private String sPrefix ;
   private String sGXsfl_107_idx="0001" ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV17Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtVentasId_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtVentasId_Jsonclick ;
   private String edtVentasFecha_Internalname ;
   private String edtVentasFecha_Jsonclick ;
   private String edtClienteId_Internalname ;
   private String edtClienteId_Jsonclick ;
   private String imgprompt_4_gximage ;
   private String sImgUrl ;
   private String imgprompt_4_Internalname ;
   private String imgprompt_4_Link ;
   private String edtVentasSerial_Internalname ;
   private String edtVentasSerial_Jsonclick ;
   private String edtVentasTotalExento_Internalname ;
   private String edtVentasTotalExento_Jsonclick ;
   private String edtVentasTotal5_Internalname ;
   private String edtVentasTotal5_Jsonclick ;
   private String edtVentasTotal10_Internalname ;
   private String edtVentasTotal10_Jsonclick ;
   private String edtVentasTotal_Internalname ;
   private String edtVentasTotal_Jsonclick ;
   private String edtVentasTotalIva5_Internalname ;
   private String edtVentasTotalIva5_Jsonclick ;
   private String edtVentasTotalIva10_Internalname ;
   private String edtVentasTotalIva10_Jsonclick ;
   private String edtVentasTotalIVA_Internalname ;
   private String edtVentasTotalIVA_Jsonclick ;
   private String edtVentasPedido_Internalname ;
   private String edtVentasPedido_Jsonclick ;
   private String edtTipoPagoId_Internalname ;
   private String edtTipoPagoId_Jsonclick ;
   private String imgprompt_9_gximage ;
   private String imgprompt_9_Internalname ;
   private String imgprompt_9_Link ;
   private String edtTimbradoId_Internalname ;
   private String edtTimbradoId_Jsonclick ;
   private String imgprompt_29_gximage ;
   private String imgprompt_29_Internalname ;
   private String imgprompt_29_Link ;
   private String edtTimbradoNumero_Internalname ;
   private String edtTimbradoNumero_Jsonclick ;
   private String edtVentasSerie1_Internalname ;
   private String edtVentasSerie1_Jsonclick ;
   private String edtVentasSerie2_Internalname ;
   private String edtVentasSerie2_Jsonclick ;
   private String edtVentasNroFactura_Internalname ;
   private String edtVentasNroFactura_Jsonclick ;
   private String divTableleaflevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode17 ;
   private String edtVentasDetalleId_Internalname ;
   private String edtArticuloId_Internalname ;
   private String edtArticuloNombre_Internalname ;
   private String edtImpuestoPorcentaje_Internalname ;
   private String edtVentasDetalleCantidad_Internalname ;
   private String edtArticuloPrecioVenta_Internalname ;
   private String edtVentasDetalleExento_Internalname ;
   private String edtVentasDetalleIva5_Internalname ;
   private String edtVentasDetalleIva10_Internalname ;
   private String edtVentasDetalleSubTotal_Internalname ;
   private String edtVentasDetalleTallaID_Internalname ;
   private String sStyleString ;
   private String subGridlevel_detalle_Internalname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode16 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A76ArticuloNombre ;
   private String Z76ArticuloNombre ;
   private String imgprompt_13_Internalname ;
   private String sGXsfl_107_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String imgprompt_13_Link ;
   private String ROClassString ;
   private String edtVentasDetalleId_Jsonclick ;
   private String edtArticuloId_Jsonclick ;
   private String imgprompt_13_gximage ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtImpuestoPorcentaje_Jsonclick ;
   private String edtVentasDetalleCantidad_Jsonclick ;
   private String edtArticuloPrecioVenta_Jsonclick ;
   private String edtVentasDetalleExento_Jsonclick ;
   private String edtVentasDetalleIva5_Jsonclick ;
   private String edtVentasDetalleIva10_Jsonclick ;
   private String edtVentasDetalleSubTotal_Jsonclick ;
   private String edtVentasDetalleTallaID_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_detalle_Header ;
   private java.util.Date Z91VentasFecha ;
   private java.util.Date A91VentasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_107_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T000H12_A239VentasTotalExento ;
   private java.math.BigDecimal[] T000H12_A236VentasTotal5 ;
   private java.math.BigDecimal[] T000H12_A238VentasTotal10 ;
   private long[] T000H10_A125TimbradoNumero ;
   private long[] T000H14_A19VentasId ;
   private java.util.Date[] T000H14_A91VentasFecha ;
   private long[] T000H14_A311VentasNroFactura ;
   private short[] T000H14_A309VentasSerie1 ;
   private short[] T000H14_A310VentasSerie2 ;
   private long[] T000H14_A251VentasPedido ;
   private long[] T000H14_A125TimbradoNumero ;
   private long[] T000H14_A242VentasSerial ;
   private long[] T000H14_A4ClienteId ;
   private long[] T000H14_A9TipoPagoId ;
   private long[] T000H14_A29TimbradoId ;
   private java.math.BigDecimal[] T000H14_A239VentasTotalExento ;
   private java.math.BigDecimal[] T000H14_A236VentasTotal5 ;
   private java.math.BigDecimal[] T000H14_A238VentasTotal10 ;
   private long[] T000H8_A4ClienteId ;
   private long[] T000H9_A9TipoPagoId ;
   private java.math.BigDecimal[] T000H16_A239VentasTotalExento ;
   private java.math.BigDecimal[] T000H16_A236VentasTotal5 ;
   private java.math.BigDecimal[] T000H16_A238VentasTotal10 ;
   private long[] T000H17_A4ClienteId ;
   private long[] T000H18_A125TimbradoNumero ;
   private long[] T000H19_A9TipoPagoId ;
   private long[] T000H20_A19VentasId ;
   private long[] T000H7_A19VentasId ;
   private java.util.Date[] T000H7_A91VentasFecha ;
   private long[] T000H7_A311VentasNroFactura ;
   private short[] T000H7_A309VentasSerie1 ;
   private short[] T000H7_A310VentasSerie2 ;
   private long[] T000H7_A251VentasPedido ;
   private long[] T000H7_A242VentasSerial ;
   private long[] T000H7_A4ClienteId ;
   private long[] T000H7_A9TipoPagoId ;
   private long[] T000H7_A29TimbradoId ;
   private long[] T000H21_A19VentasId ;
   private long[] T000H22_A19VentasId ;
   private long[] T000H6_A19VentasId ;
   private java.util.Date[] T000H6_A91VentasFecha ;
   private long[] T000H6_A311VentasNroFactura ;
   private short[] T000H6_A309VentasSerie1 ;
   private short[] T000H6_A310VentasSerie2 ;
   private long[] T000H6_A251VentasPedido ;
   private long[] T000H6_A242VentasSerial ;
   private long[] T000H6_A4ClienteId ;
   private long[] T000H6_A9TipoPagoId ;
   private long[] T000H6_A29TimbradoId ;
   private java.math.BigDecimal[] T000H27_A239VentasTotalExento ;
   private java.math.BigDecimal[] T000H27_A236VentasTotal5 ;
   private java.math.BigDecimal[] T000H27_A238VentasTotal10 ;
   private long[] T000H28_A125TimbradoNumero ;
   private long[] T000H29_A272DevolucionesID ;
   private long[] T000H31_A19VentasId ;
   private long[] T000H32_A18ImpuestoId ;
   private long[] T000H32_A19VentasId ;
   private long[] T000H32_A20VentasDetalleId ;
   private String[] T000H32_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000H32_A83ImpuestoPorcentaje ;
   private int[] T000H32_A92VentasDetalleCantidad ;
   private java.math.BigDecimal[] T000H32_A78ArticuloPrecioVenta ;
   private long[] T000H32_A292VentasDetalleTallaID ;
   private long[] T000H32_A13ArticuloId ;
   private long[] T000H4_A18ImpuestoId ;
   private String[] T000H4_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000H4_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T000H5_A83ImpuestoPorcentaje ;
   private long[] T000H33_A18ImpuestoId ;
   private String[] T000H33_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000H33_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T000H34_A83ImpuestoPorcentaje ;
   private long[] T000H35_A19VentasId ;
   private long[] T000H35_A20VentasDetalleId ;
   private long[] T000H3_A19VentasId ;
   private long[] T000H3_A20VentasDetalleId ;
   private int[] T000H3_A92VentasDetalleCantidad ;
   private long[] T000H3_A292VentasDetalleTallaID ;
   private long[] T000H3_A13ArticuloId ;
   private long[] T000H2_A19VentasId ;
   private long[] T000H2_A20VentasDetalleId ;
   private int[] T000H2_A92VentasDetalleCantidad ;
   private long[] T000H2_A292VentasDetalleTallaID ;
   private long[] T000H2_A13ArticuloId ;
   private long[] T000H39_A18ImpuestoId ;
   private String[] T000H39_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000H39_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T000H40_A83ImpuestoPorcentaje ;
   private long[] T000H41_A19VentasId ;
   private long[] T000H41_A20VentasDetalleId ;
   private long[] T000H42_A4ClienteId ;
   private long[] T000H43_A9TipoPagoId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class ventas__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public String getDataStoreName( )
   {
      return "GAM";
   }

}

final  class ventas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000H2", "SELECT [VentasId], [VentasDetalleId], [VentasDetalleCantidad], [VentasDetalleTallaID], [ArticuloId] FROM [VentasDetalle] WITH (UPDLOCK) WHERE [VentasId] = ? AND [VentasDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H3", "SELECT [VentasId], [VentasDetalleId], [VentasDetalleCantidad], [VentasDetalleTallaID], [ArticuloId] FROM [VentasDetalle] WHERE [VentasId] = ? AND [VentasDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H4", "SELECT [ImpuestoId], [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H5", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H6", "SELECT [VentasId], [VentasFecha], [VentasNroFactura], [VentasSerie1], [VentasSerie2], [VentasPedido], [VentasSerial], [ClienteId], [TipoPagoId], [TimbradoId] FROM [Ventas] WITH (UPDLOCK) WHERE [VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H7", "SELECT [VentasId], [VentasFecha], [VentasNroFactura], [VentasSerie1], [VentasSerie2], [VentasPedido], [VentasSerial], [ClienteId], [TipoPagoId], [TimbradoId] FROM [Ventas] WHERE [VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H8", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H9", "SELECT [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H10", "SELECT [TimbradoNumero] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H12", "SELECT COALESCE( T1.[VentasTotalExento], 0) AS VentasTotalExento, COALESCE( T1.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T1.[VentasTotal10], 0) AS VentasTotal10 FROM (SELECT SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T2.[VentasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10 FROM (([VentasDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[VentasId] ) T1 WHERE T1.[VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H14", "SELECT TM1.[VentasId], TM1.[VentasFecha], TM1.[VentasNroFactura], TM1.[VentasSerie1], TM1.[VentasSerie2], TM1.[VentasPedido], T3.[TimbradoNumero], TM1.[VentasSerial], TM1.[ClienteId], TM1.[TipoPagoId], TM1.[TimbradoId], COALESCE( T2.[VentasTotalExento], 0) AS VentasTotalExento, COALESCE( T2.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T2.[VentasTotal10], 0) AS VentasTotal10 FROM (([Ventas] TM1 LEFT JOIN (SELECT SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 0 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T4.[VentasId], SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 5 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 10 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10 FROM (([VentasDetalle] T4 INNER JOIN [Articulo] T5 ON T5.[ArticuloId] = T4.[ArticuloId]) INNER JOIN [Impuesto] T6 ON T6.[ImpuestoId] = T5.[ImpuestoId]) GROUP BY T4.[VentasId] ) T2 ON T2.[VentasId] = TM1.[VentasId]) INNER JOIN [Timbrado] T3 ON T3.[TimbradoId] = TM1.[TimbradoId]) WHERE TM1.[VentasId] = ? ORDER BY TM1.[VentasId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H16", "SELECT COALESCE( T1.[VentasTotalExento], 0) AS VentasTotalExento, COALESCE( T1.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T1.[VentasTotal10], 0) AS VentasTotal10 FROM (SELECT SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T2.[VentasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10 FROM (([VentasDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[VentasId] ) T1 WHERE T1.[VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H17", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H18", "SELECT [TimbradoNumero] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H19", "SELECT [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H20", "SELECT [VentasId] FROM [Ventas] WHERE [VentasId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H21", "SELECT TOP 1 [VentasId] FROM [Ventas] WHERE ( [VentasId] > ?) ORDER BY [VentasId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000H22", "SELECT TOP 1 [VentasId] FROM [Ventas] WHERE ( [VentasId] < ?) ORDER BY [VentasId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000H23", "INSERT INTO [Ventas]([VentasId], [VentasFecha], [VentasNroFactura], [VentasSerie1], [VentasSerie2], [VentasPedido], [VentasSerial], [ClienteId], [TipoPagoId], [TimbradoId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000H24", "UPDATE [Ventas] SET [VentasFecha]=?, [VentasNroFactura]=?, [VentasSerie1]=?, [VentasSerie2]=?, [VentasPedido]=?, [VentasSerial]=?, [ClienteId]=?, [TipoPagoId]=?, [TimbradoId]=?  WHERE [VentasId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000H25", "DELETE FROM [Ventas]  WHERE [VentasId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000H27", "SELECT COALESCE( T1.[VentasTotalExento], 0) AS VentasTotalExento, COALESCE( T1.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T1.[VentasTotal10], 0) AS VentasTotal10 FROM (SELECT SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T2.[VentasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10 FROM (([VentasDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[VentasId] ) T1 WHERE T1.[VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H28", "SELECT [TimbradoNumero] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H29", "SELECT TOP 1 [DevolucionesID] FROM [Devoluciones] WHERE [VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000H30", "UPDATE [Ventas] SET [VentasSerial]=?  WHERE [VentasId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000H31", "SELECT [VentasId] FROM [Ventas] ORDER BY [VentasId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H32", "SELECT T2.[ImpuestoId], T1.[VentasId], T1.[VentasDetalleId], T2.[ArticuloNombre], T3.[ImpuestoPorcentaje], T1.[VentasDetalleCantidad], T2.[ArticuloPrecioVenta], T1.[VentasDetalleTallaID], T1.[ArticuloId] FROM (([VentasDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) INNER JOIN [Impuesto] T3 ON T3.[ImpuestoId] = T2.[ImpuestoId]) WHERE T1.[VentasId] = ? and T1.[VentasDetalleId] = ? ORDER BY T1.[VentasId], T1.[VentasDetalleId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H33", "SELECT [ImpuestoId], [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H34", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H35", "SELECT [VentasId], [VentasDetalleId] FROM [VentasDetalle] WHERE [VentasId] = ? AND [VentasDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000H36", "INSERT INTO [VentasDetalle]([VentasId], [VentasDetalleId], [VentasDetalleCantidad], [VentasDetalleTallaID], [ArticuloId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000H37", "UPDATE [VentasDetalle] SET [VentasDetalleCantidad]=?, [VentasDetalleTallaID]=?, [ArticuloId]=?  WHERE [VentasId] = ? AND [VentasDetalleId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000H38", "DELETE FROM [VentasDetalle]  WHERE [VentasId] = ? AND [VentasDetalleId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000H39", "SELECT [ImpuestoId], [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H40", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H41", "SELECT [VentasId], [VentasDetalleId] FROM [VentasDetalle] WHERE [VentasId] = ? ORDER BY [VentasId], [VentasDetalleId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H42", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000H43", "SELECT [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 3 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 9 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               return;
            case 11 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 17 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 21 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 23 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 25 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 26 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               return;
            case 27 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 28 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 29 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 33 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 34 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 35 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 36 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 37 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               stmt.setLong(9, ((Number) parms[8]).longValue());
               stmt.setLong(10, ((Number) parms[9]).longValue());
               return;
            case 19 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               stmt.setLong(9, ((Number) parms[8]).longValue());
               stmt.setLong(10, ((Number) parms[9]).longValue());
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 21 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 22 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 23 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 24 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 26 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 27 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 28 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 29 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 32 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 33 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 34 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 35 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 36 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 37 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

