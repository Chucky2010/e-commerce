package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class movimientocaja_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"MOVIMIENTOCAJAID") == 0 )
      {
         AV7MovimientoCajaId = GXutil.lval( httpContext.GetPar( "MovimientoCajaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7MovimientoCajaId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMOVIMIENTOCAJAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7MovimientoCajaId), "ZZZZZZZZZZ9")));
         AV21Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asamovimientocajaid0O25( AV7MovimientoCajaId, AV21Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"vSALDOACTUAL") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx11asasaldoactual0O25( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A26CajeroId = GXutil.lval( httpContext.GetPar( "CajeroId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A26CajeroId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A25CajaId = GXutil.lval( httpContext.GetPar( "CajaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A25CajaId) ;
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
            AV7MovimientoCajaId = GXutil.lval( httpContext.GetPar( "MovimientoCajaId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7MovimientoCajaId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMOVIMIENTOCAJAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7MovimientoCajaId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Movimiento Caja", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMovimientoCajaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public movimientocaja_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public movimientocaja_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( movimientocaja_impl.class ));
   }

   public movimientocaja_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Movimiento Caja", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_MovimientoCaja.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaId_Internalname, httpContext.getMessage( "Caja Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaId_Internalname, GXutil.ltrim( localUtil.ntoc( A27MovimientoCajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A27MovimientoCajaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaHora_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaHora_Internalname, httpContext.getMessage( "Caja Hora", ""), " AttributeRealWidthDateTimeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMovimientoCajaHora_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaHora_Internalname, localUtil.ttoc( A116MovimientoCajaHora, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A116MovimientoCajaHora, "99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 0,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 0,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaHora_Jsonclick, 0, "AttributeRealWidthDateTime", "", "", "", "", 1, edtMovimientoCajaHora_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Time", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtMovimientoCajaHora_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMovimientoCajaHora_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_MovimientoCaja.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaIngreso_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaIngreso_Internalname, httpContext.getMessage( "Caja Ingreso", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaIngreso_Internalname, GXutil.ltrim( localUtil.ntoc( A117MovimientoCajaIngreso, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaIngreso_Enabled!=0) ? localUtil.format( A117MovimientoCajaIngreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A117MovimientoCajaIngreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaIngreso_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaIngreso_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaEgreso_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaEgreso_Internalname, httpContext.getMessage( "Caja Egreso", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaEgreso_Internalname, GXutil.ltrim( localUtil.ntoc( A118MovimientoCajaEgreso, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaEgreso_Enabled!=0) ? localUtil.format( A118MovimientoCajaEgreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A118MovimientoCajaEgreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaEgreso_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaEgreso_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaSaldo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaSaldo_Internalname, httpContext.getMessage( "Caja Saldo", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A119MovimientoCajaSaldo, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaSaldo_Enabled!=0) ? localUtil.format( A119MovimientoCajaSaldo, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A119MovimientoCajaSaldo, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaSaldo_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaSaldo_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaFecha_Internalname, httpContext.getMessage( "Caja Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMovimientoCajaFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaFecha_Internalname, localUtil.format(A120MovimientoCajaFecha, "99/99/99"), localUtil.format( A120MovimientoCajaFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtMovimientoCajaFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtMovimientoCajaFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMovimientoCajaFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_MovimientoCaja.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajeroId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajeroId_Internalname, httpContext.getMessage( "Cajero Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajeroId_Internalname, GXutil.ltrim( localUtil.ntoc( A26CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A26CajeroId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajeroId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCajeroId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_MovimientoCaja.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_26_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_26_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_26_Internalname, sImgUrl, imgprompt_26_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_26_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajeroNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajeroNombre_Internalname, httpContext.getMessage( "Cajero Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajeroNombre_Internalname, GXutil.rtrim( A112CajeroNombre), GXutil.rtrim( localUtil.format( A112CajeroNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajeroNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCajeroNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajaId_Internalname, httpContext.getMessage( "Caja Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajaId_Internalname, GXutil.ltrim( localUtil.ntoc( A25CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A25CajaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajaId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCajaId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_MovimientoCaja.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_25_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_25_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_25_Internalname, sImgUrl, imgprompt_25_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_25_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajaNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajaNumero_Internalname, httpContext.getMessage( "Caja Numero", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajaNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A110CajaNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCajaNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A110CajaNumero), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A110CajaNumero), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajaNumero_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCajaNumero_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Numero", "right", false, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaAsignacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaAsignacion_Internalname, httpContext.getMessage( "Caja Asignacion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaAsignacion_Internalname, GXutil.rtrim( A256MovimientoCajaAsignacion), GXutil.rtrim( localUtil.format( A256MovimientoCajaAsignacion, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaAsignacion_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaAsignacion_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaDocum_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaDocum_Internalname, httpContext.getMessage( "Informacion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaDocum_Internalname, A266MovimientoCajaDocum, GXutil.rtrim( localUtil.format( A266MovimientoCajaDocum, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaDocum_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaDocum_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaEstado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaEstado_Internalname, httpContext.getMessage( "Caja Estado", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaEstado_Internalname, GXutil.rtrim( A267MovimientoCajaEstado), GXutil.rtrim( localUtil.format( A267MovimientoCajaEstado, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaEstado_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMovimientoCajaEstado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSaldoactual_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSaldoactual_Internalname, httpContext.getMessage( "Saldo Actual", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSaldoactual_Internalname, GXutil.ltrim( localUtil.ntoc( AV20SaldoActual, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavSaldoactual_Enabled!=0) ? localUtil.format( AV20SaldoActual, "ZZZZZZZZZZZZZZ9.99") : localUtil.format( AV20SaldoActual, "ZZZZZZZZZZZZZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSaldoactual_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSaldoactual_Enabled, 0, "text", "", 18, "chr", 1, "row", 18, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MovimientoCaja.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MovimientoCaja.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MovimientoCaja.htm");
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
      e110O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z27MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( "Z27MovimientoCajaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z256MovimientoCajaAsignacion = httpContext.cgiGet( "Z256MovimientoCajaAsignacion") ;
            Z116MovimientoCajaHora = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( "Z116MovimientoCajaHora"), 0)) ;
            Z117MovimientoCajaIngreso = localUtil.ctond( httpContext.cgiGet( "Z117MovimientoCajaIngreso")) ;
            Z118MovimientoCajaEgreso = localUtil.ctond( httpContext.cgiGet( "Z118MovimientoCajaEgreso")) ;
            Z119MovimientoCajaSaldo = localUtil.ctond( httpContext.cgiGet( "Z119MovimientoCajaSaldo")) ;
            Z120MovimientoCajaFecha = localUtil.ctod( httpContext.cgiGet( "Z120MovimientoCajaFecha"), 0) ;
            Z266MovimientoCajaDocum = httpContext.cgiGet( "Z266MovimientoCajaDocum") ;
            Z267MovimientoCajaEstado = httpContext.cgiGet( "Z267MovimientoCajaEstado") ;
            Z268MovimientoCajaFechaCierre = localUtil.ctod( httpContext.cgiGet( "Z268MovimientoCajaFechaCierre"), 0) ;
            Z26CajeroId = localUtil.ctol( httpContext.cgiGet( "Z26CajeroId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z25CajaId = localUtil.ctol( httpContext.cgiGet( "Z25CajaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A268MovimientoCajaFechaCierre = localUtil.ctod( httpContext.cgiGet( "Z268MovimientoCajaFechaCierre"), 0) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N26CajeroId = localUtil.ctol( httpContext.cgiGet( "N26CajeroId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N25CajaId = localUtil.ctol( httpContext.cgiGet( "N25CajaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( "vMOVIMIENTOCAJAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV21Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_CajeroId = localUtil.ctol( httpContext.cgiGet( "vINSERT_CAJEROID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV14Insert_CajaId = localUtil.ctol( httpContext.cgiGet( "vINSERT_CAJAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV19UserName = httpContext.cgiGet( "vUSERNAME") ;
            A268MovimientoCajaFechaCierre = localUtil.ctod( httpContext.cgiGet( "MOVIMIENTOCAJAFECHACIERRE"), 0) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMovimientoCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMovimientoCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MOVIMIENTOCAJAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A27MovimientoCajaId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
            }
            else
            {
               A27MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( edtMovimientoCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtMovimientoCajaHora_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "MOVIMIENTOCAJAHORA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaHora_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
               httpContext.ajax_rsp_assign_attri("", false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
            else
            {
               A116MovimientoCajaHora = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtMovimientoCajaHora_Internalname))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaIngreso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaIngreso_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MOVIMIENTOCAJAINGRESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaIngreso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
            }
            else
            {
               A117MovimientoCajaIngreso = localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaIngreso_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaEgreso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaEgreso_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MOVIMIENTOCAJAEGRESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaEgreso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
            }
            else
            {
               A118MovimientoCajaEgreso = localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaEgreso_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaSaldo_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaSaldo_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MOVIMIENTOCAJASALDO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaSaldo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
            }
            else
            {
               A119MovimientoCajaSaldo = localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaSaldo_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtMovimientoCajaFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "MOVIMIENTOCAJAFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A120MovimientoCajaFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
            }
            else
            {
               A120MovimientoCajaFecha = localUtil.ctod( httpContext.cgiGet( edtMovimientoCajaFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CAJEROID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCajeroId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A26CajeroId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
            }
            else
            {
               A26CajeroId = localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
            }
            A112CajeroNombre = httpContext.cgiGet( edtCajeroNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CAJAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCajaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A25CajaId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
            }
            else
            {
               A25CajaId = localUtil.ctol( httpContext.cgiGet( edtCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
            }
            A110CajaNumero = localUtil.ctol( httpContext.cgiGet( edtCajaNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
            A256MovimientoCajaAsignacion = httpContext.cgiGet( edtMovimientoCajaAsignacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
            A266MovimientoCajaDocum = httpContext.cgiGet( edtMovimientoCajaDocum_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A266MovimientoCajaDocum", A266MovimientoCajaDocum);
            A267MovimientoCajaEstado = httpContext.cgiGet( edtMovimientoCajaEstado_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A267MovimientoCajaEstado", A267MovimientoCajaEstado);
            AV20SaldoActual = localUtil.ctond( httpContext.cgiGet( edtavSaldoactual_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20SaldoActual", GXutil.ltrimstr( AV20SaldoActual, 18, 2));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MovimientoCaja");
            A256MovimientoCajaAsignacion = httpContext.cgiGet( edtMovimientoCajaAsignacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
            forbiddenHiddens.add("MovimientoCajaAsignacion", GXutil.rtrim( localUtil.format( A256MovimientoCajaAsignacion, "")));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("MovimientoCajaFechaCierre", localUtil.format(A268MovimientoCajaFechaCierre, "99/99/99"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A27MovimientoCajaId != Z27MovimientoCajaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("movimientocaja:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A27MovimientoCajaId = GXutil.lval( httpContext.GetPar( "MovimientoCajaId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
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
                  sMode25 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode25 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound25 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0O0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "MOVIMIENTOCAJAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMovimientoCajaId_Internalname ;
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
                        e110O2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120O2 ();
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
         e120O2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0O25( ) ;
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
         disableAttributes0O25( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavSaldoactual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSaldoactual_Enabled), 5, 0), true);
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

   public void confirm_0O0( )
   {
      beforeValidate0O25( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0O25( ) ;
         }
         else
         {
            checkExtendedTable0O25( ) ;
            closeExtendedTableCursors0O25( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0O0( )
   {
   }

   public void e110O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV18GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV19UserName = AV18GAMUser.getgxTv_SdtGAMUser_Name() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19UserName", AV19UserName);
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV21Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV22GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GXV1), 8, 0));
         while ( AV22GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV22GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CajeroId") == 0 )
            {
               AV13Insert_CajeroId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_CajeroId), 11, 0));
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CajaId") == 0 )
            {
               AV14Insert_CajaId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_CajaId), 11, 0));
            }
            AV22GXV1 = (int)(AV22GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GXV1), 8, 0));
         }
      }
   }

   public void e120O2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      GXv_int2[0] = A27MovimientoCajaId ;
      new com.mujermorena.generaregreso(remoteHandle, context).execute( GXv_int2) ;
      movimientocaja_impl.this.A27MovimientoCajaId = GXv_int2[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.movimientocajaww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void zm0O25( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z256MovimientoCajaAsignacion = T000O3_A256MovimientoCajaAsignacion[0] ;
            Z116MovimientoCajaHora = T000O3_A116MovimientoCajaHora[0] ;
            Z117MovimientoCajaIngreso = T000O3_A117MovimientoCajaIngreso[0] ;
            Z118MovimientoCajaEgreso = T000O3_A118MovimientoCajaEgreso[0] ;
            Z119MovimientoCajaSaldo = T000O3_A119MovimientoCajaSaldo[0] ;
            Z120MovimientoCajaFecha = T000O3_A120MovimientoCajaFecha[0] ;
            Z266MovimientoCajaDocum = T000O3_A266MovimientoCajaDocum[0] ;
            Z267MovimientoCajaEstado = T000O3_A267MovimientoCajaEstado[0] ;
            Z268MovimientoCajaFechaCierre = T000O3_A268MovimientoCajaFechaCierre[0] ;
            Z26CajeroId = T000O3_A26CajeroId[0] ;
            Z25CajaId = T000O3_A25CajaId[0] ;
         }
         else
         {
            Z256MovimientoCajaAsignacion = A256MovimientoCajaAsignacion ;
            Z116MovimientoCajaHora = A116MovimientoCajaHora ;
            Z117MovimientoCajaIngreso = A117MovimientoCajaIngreso ;
            Z118MovimientoCajaEgreso = A118MovimientoCajaEgreso ;
            Z119MovimientoCajaSaldo = A119MovimientoCajaSaldo ;
            Z120MovimientoCajaFecha = A120MovimientoCajaFecha ;
            Z266MovimientoCajaDocum = A266MovimientoCajaDocum ;
            Z267MovimientoCajaEstado = A267MovimientoCajaEstado ;
            Z268MovimientoCajaFechaCierre = A268MovimientoCajaFechaCierre ;
            Z26CajeroId = A26CajeroId ;
            Z25CajaId = A25CajaId ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z27MovimientoCajaId = A27MovimientoCajaId ;
         Z256MovimientoCajaAsignacion = A256MovimientoCajaAsignacion ;
         Z116MovimientoCajaHora = A116MovimientoCajaHora ;
         Z117MovimientoCajaIngreso = A117MovimientoCajaIngreso ;
         Z118MovimientoCajaEgreso = A118MovimientoCajaEgreso ;
         Z119MovimientoCajaSaldo = A119MovimientoCajaSaldo ;
         Z120MovimientoCajaFecha = A120MovimientoCajaFecha ;
         Z266MovimientoCajaDocum = A266MovimientoCajaDocum ;
         Z267MovimientoCajaEstado = A267MovimientoCajaEstado ;
         Z268MovimientoCajaFechaCierre = A268MovimientoCajaFechaCierre ;
         Z26CajeroId = A26CajeroId ;
         Z25CajaId = A25CajaId ;
         Z112CajeroNombre = A112CajeroNombre ;
         Z110CajaNumero = A110CajaNumero ;
      }
   }

   public void standaloneNotModal( )
   {
      edtMovimientoCajaAsignacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaAsignacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaAsignacion_Enabled), 5, 0), true);
      GXt_decimal3 = AV20SaldoActual ;
      GXv_decimal4[0] = GXt_decimal3 ;
      new com.mujermorena.saldoactualcaja(remoteHandle, context).execute( GXv_decimal4) ;
      movimientocaja_impl.this.GXt_decimal3 = GXv_decimal4[0] ;
      AV20SaldoActual = GXt_decimal3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20SaldoActual", GXutil.ltrimstr( AV20SaldoActual, 18, 2));
      AV21Pgmname = "MovimientoCaja" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      imgprompt_26_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.cajeroprompt"+"',["+"{Ctrl:gx.dom.el('"+"CAJEROID"+"'), id:'"+"CAJEROID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_25_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.cajaprompt"+"',["+"{Ctrl:gx.dom.el('"+"CAJAID"+"'), id:'"+"CAJAID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtMovimientoCajaAsignacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaAsignacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaAsignacion_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7MovimientoCajaId) )
      {
         A27MovimientoCajaId = AV7MovimientoCajaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int5 = A27MovimientoCajaId ;
            GXv_int2[0] = GXt_int5 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV21Pgmname), GXv_int2) ;
            movimientocaja_impl.this.GXt_int5 = GXv_int2[0] ;
            A27MovimientoCajaId = GXt_int5 ;
            httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
         }
      }
      if ( ! (0==AV7MovimientoCajaId) )
      {
         edtMovimientoCajaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaId_Enabled), 5, 0), true);
      }
      else
      {
         edtMovimientoCajaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7MovimientoCajaId) )
      {
         edtMovimientoCajaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CajeroId) )
      {
         edtCajeroId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCajeroId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajeroId_Enabled), 5, 0), true);
      }
      else
      {
         edtCajeroId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCajeroId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajeroId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_CajaId) )
      {
         edtCajaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajaId_Enabled), 5, 0), true);
      }
      else
      {
         edtCajaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajaId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_CajaId) )
      {
         A25CajaId = AV14Insert_CajaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CajeroId) )
      {
         A26CajeroId = AV13Insert_CajeroId ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         A256MovimientoCajaAsignacion = AV19UserName ;
         httpContext.ajax_rsp_assign_attri("", false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
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
         /* Using cursor T000O5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A25CajaId)});
         A110CajaNumero = T000O5_A110CajaNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
         pr_default.close(3);
         /* Using cursor T000O4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A26CajeroId)});
         A112CajeroNombre = T000O4_A112CajeroNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
         pr_default.close(2);
      }
   }

   public void load0O25( )
   {
      /* Using cursor T000O6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A27MovimientoCajaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A256MovimientoCajaAsignacion = T000O6_A256MovimientoCajaAsignacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
         A116MovimientoCajaHora = T000O6_A116MovimientoCajaHora[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A117MovimientoCajaIngreso = T000O6_A117MovimientoCajaIngreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
         A118MovimientoCajaEgreso = T000O6_A118MovimientoCajaEgreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
         A119MovimientoCajaSaldo = T000O6_A119MovimientoCajaSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
         A120MovimientoCajaFecha = T000O6_A120MovimientoCajaFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
         A266MovimientoCajaDocum = T000O6_A266MovimientoCajaDocum[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A266MovimientoCajaDocum", A266MovimientoCajaDocum);
         A112CajeroNombre = T000O6_A112CajeroNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
         A110CajaNumero = T000O6_A110CajaNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
         A267MovimientoCajaEstado = T000O6_A267MovimientoCajaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A267MovimientoCajaEstado", A267MovimientoCajaEstado);
         A268MovimientoCajaFechaCierre = T000O6_A268MovimientoCajaFechaCierre[0] ;
         A26CajeroId = T000O6_A26CajeroId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         A25CajaId = T000O6_A25CajaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
         zm0O25( -18) ;
      }
      pr_default.close(4);
      onLoadActions0O25( ) ;
   }

   public void onLoadActions0O25( )
   {
   }

   public void checkExtendedTable0O25( )
   {
      nIsDirty_25 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( A118MovimientoCajaEgreso.doubleValue() < 0 )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "el valor del importe del egresod debe ser mayor a cero.", ""), 1, "MOVIMIENTOCAJAEGRESO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMovimientoCajaEgreso_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A120MovimientoCajaFecha)) || (( GXutil.resetTime(A120MovimientoCajaFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A120MovimientoCajaFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Movimiento Caja Fecha", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "MOVIMIENTOCAJAFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMovimientoCajaFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000O4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A26CajeroId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cajero", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJEROID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajeroId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A112CajeroNombre = T000O4_A112CajeroNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
      pr_default.close(2);
      /* Using cursor T000O5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A25CajaId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Caja", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A110CajaNumero = T000O5_A110CajaNumero[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
      pr_default.close(3);
      if ( DecimalUtil.compareTo(A118MovimientoCajaEgreso, AV20SaldoActual) > 0 )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "el egreso supera al saldo de tu caja", ""), 1, "MOVIMIENTOCAJAEGRESO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMovimientoCajaEgreso_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0O25( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( long A26CajeroId )
   {
      /* Using cursor T000O7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A26CajeroId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cajero", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJEROID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajeroId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A112CajeroNombre = T000O7_A112CajeroNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A112CajeroNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_20( long A25CajaId )
   {
      /* Using cursor T000O8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A25CajaId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Caja", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A110CajaNumero = T000O8_A110CajaNumero[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A110CajaNumero, (byte)(10), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0O25( )
   {
      /* Using cursor T000O9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A27MovimientoCajaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound25 = (short)(1) ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000O3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A27MovimientoCajaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0O25( 18) ;
         RcdFound25 = (short)(1) ;
         A27MovimientoCajaId = T000O3_A27MovimientoCajaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
         A256MovimientoCajaAsignacion = T000O3_A256MovimientoCajaAsignacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
         A116MovimientoCajaHora = T000O3_A116MovimientoCajaHora[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A117MovimientoCajaIngreso = T000O3_A117MovimientoCajaIngreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
         A118MovimientoCajaEgreso = T000O3_A118MovimientoCajaEgreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
         A119MovimientoCajaSaldo = T000O3_A119MovimientoCajaSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
         A120MovimientoCajaFecha = T000O3_A120MovimientoCajaFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
         A266MovimientoCajaDocum = T000O3_A266MovimientoCajaDocum[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A266MovimientoCajaDocum", A266MovimientoCajaDocum);
         A267MovimientoCajaEstado = T000O3_A267MovimientoCajaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A267MovimientoCajaEstado", A267MovimientoCajaEstado);
         A268MovimientoCajaFechaCierre = T000O3_A268MovimientoCajaFechaCierre[0] ;
         A26CajeroId = T000O3_A26CajeroId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         A25CajaId = T000O3_A25CajaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
         Z27MovimientoCajaId = A27MovimientoCajaId ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0O25( ) ;
         if ( AnyError == 1 )
         {
            RcdFound25 = (short)(0) ;
            initializeNonKey0O25( ) ;
         }
         Gx_mode = sMode25 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound25 = (short)(0) ;
         initializeNonKey0O25( ) ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode25 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0O25( ) ;
      if ( RcdFound25 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound25 = (short)(0) ;
      /* Using cursor T000O10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A27MovimientoCajaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000O10_A27MovimientoCajaId[0] < A27MovimientoCajaId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000O10_A27MovimientoCajaId[0] > A27MovimientoCajaId ) ) )
         {
            A27MovimientoCajaId = T000O10_A27MovimientoCajaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
            RcdFound25 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound25 = (short)(0) ;
      /* Using cursor T000O11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A27MovimientoCajaId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000O11_A27MovimientoCajaId[0] > A27MovimientoCajaId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000O11_A27MovimientoCajaId[0] < A27MovimientoCajaId ) ) )
         {
            A27MovimientoCajaId = T000O11_A27MovimientoCajaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
            RcdFound25 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0O25( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMovimientoCajaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0O25( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound25 == 1 )
         {
            if ( A27MovimientoCajaId != Z27MovimientoCajaId )
            {
               A27MovimientoCajaId = Z27MovimientoCajaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "MOVIMIENTOCAJAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMovimientoCajaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMovimientoCajaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0O25( ) ;
               GX_FocusControl = edtMovimientoCajaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A27MovimientoCajaId != Z27MovimientoCajaId )
            {
               /* Insert record */
               GX_FocusControl = edtMovimientoCajaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0O25( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "MOVIMIENTOCAJAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtMovimientoCajaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtMovimientoCajaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0O25( ) ;
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
      if ( A27MovimientoCajaId != Z27MovimientoCajaId )
      {
         A27MovimientoCajaId = Z27MovimientoCajaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "MOVIMIENTOCAJAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMovimientoCajaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMovimientoCajaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0O25( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000O2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A27MovimientoCajaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MovimientoCaja"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z256MovimientoCajaAsignacion, T000O2_A256MovimientoCajaAsignacion[0]) != 0 ) || !( GXutil.dateCompare(Z116MovimientoCajaHora, T000O2_A116MovimientoCajaHora[0]) ) || ( DecimalUtil.compareTo(Z117MovimientoCajaIngreso, T000O2_A117MovimientoCajaIngreso[0]) != 0 ) || ( DecimalUtil.compareTo(Z118MovimientoCajaEgreso, T000O2_A118MovimientoCajaEgreso[0]) != 0 ) || ( DecimalUtil.compareTo(Z119MovimientoCajaSaldo, T000O2_A119MovimientoCajaSaldo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z120MovimientoCajaFecha), GXutil.resetTime(T000O2_A120MovimientoCajaFecha[0])) ) || ( GXutil.strcmp(Z266MovimientoCajaDocum, T000O2_A266MovimientoCajaDocum[0]) != 0 ) || ( GXutil.strcmp(Z267MovimientoCajaEstado, T000O2_A267MovimientoCajaEstado[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z268MovimientoCajaFechaCierre), GXutil.resetTime(T000O2_A268MovimientoCajaFechaCierre[0])) ) || ( Z26CajeroId != T000O2_A26CajeroId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z25CajaId != T000O2_A25CajaId[0] ) )
         {
            if ( GXutil.strcmp(Z256MovimientoCajaAsignacion, T000O2_A256MovimientoCajaAsignacion[0]) != 0 )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaAsignacion");
               GXutil.writeLogRaw("Old: ",Z256MovimientoCajaAsignacion);
               GXutil.writeLogRaw("Current: ",T000O2_A256MovimientoCajaAsignacion[0]);
            }
            if ( !( GXutil.dateCompare(Z116MovimientoCajaHora, T000O2_A116MovimientoCajaHora[0]) ) )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaHora");
               GXutil.writeLogRaw("Old: ",Z116MovimientoCajaHora);
               GXutil.writeLogRaw("Current: ",T000O2_A116MovimientoCajaHora[0]);
            }
            if ( DecimalUtil.compareTo(Z117MovimientoCajaIngreso, T000O2_A117MovimientoCajaIngreso[0]) != 0 )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaIngreso");
               GXutil.writeLogRaw("Old: ",Z117MovimientoCajaIngreso);
               GXutil.writeLogRaw("Current: ",T000O2_A117MovimientoCajaIngreso[0]);
            }
            if ( DecimalUtil.compareTo(Z118MovimientoCajaEgreso, T000O2_A118MovimientoCajaEgreso[0]) != 0 )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaEgreso");
               GXutil.writeLogRaw("Old: ",Z118MovimientoCajaEgreso);
               GXutil.writeLogRaw("Current: ",T000O2_A118MovimientoCajaEgreso[0]);
            }
            if ( DecimalUtil.compareTo(Z119MovimientoCajaSaldo, T000O2_A119MovimientoCajaSaldo[0]) != 0 )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaSaldo");
               GXutil.writeLogRaw("Old: ",Z119MovimientoCajaSaldo);
               GXutil.writeLogRaw("Current: ",T000O2_A119MovimientoCajaSaldo[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z120MovimientoCajaFecha), GXutil.resetTime(T000O2_A120MovimientoCajaFecha[0])) ) )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaFecha");
               GXutil.writeLogRaw("Old: ",Z120MovimientoCajaFecha);
               GXutil.writeLogRaw("Current: ",T000O2_A120MovimientoCajaFecha[0]);
            }
            if ( GXutil.strcmp(Z266MovimientoCajaDocum, T000O2_A266MovimientoCajaDocum[0]) != 0 )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaDocum");
               GXutil.writeLogRaw("Old: ",Z266MovimientoCajaDocum);
               GXutil.writeLogRaw("Current: ",T000O2_A266MovimientoCajaDocum[0]);
            }
            if ( GXutil.strcmp(Z267MovimientoCajaEstado, T000O2_A267MovimientoCajaEstado[0]) != 0 )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaEstado");
               GXutil.writeLogRaw("Old: ",Z267MovimientoCajaEstado);
               GXutil.writeLogRaw("Current: ",T000O2_A267MovimientoCajaEstado[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z268MovimientoCajaFechaCierre), GXutil.resetTime(T000O2_A268MovimientoCajaFechaCierre[0])) ) )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"MovimientoCajaFechaCierre");
               GXutil.writeLogRaw("Old: ",Z268MovimientoCajaFechaCierre);
               GXutil.writeLogRaw("Current: ",T000O2_A268MovimientoCajaFechaCierre[0]);
            }
            if ( Z26CajeroId != T000O2_A26CajeroId[0] )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"CajeroId");
               GXutil.writeLogRaw("Old: ",Z26CajeroId);
               GXutil.writeLogRaw("Current: ",T000O2_A26CajeroId[0]);
            }
            if ( Z25CajaId != T000O2_A25CajaId[0] )
            {
               GXutil.writeLogln("movimientocaja:[seudo value changed for attri]"+"CajaId");
               GXutil.writeLogRaw("Old: ",Z25CajaId);
               GXutil.writeLogRaw("Current: ",T000O2_A25CajaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MovimientoCaja"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0O25( )
   {
      if ( ! IsAuthorized("movimientocaja_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0O25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0O25( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0O25( 0) ;
         checkOptimisticConcurrency0O25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0O25( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0O25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000O12 */
                  pr_default.execute(10, new Object[] {Long.valueOf(A27MovimientoCajaId), A256MovimientoCajaAsignacion, A116MovimientoCajaHora, A117MovimientoCajaIngreso, A118MovimientoCajaEgreso, A119MovimientoCajaSaldo, A120MovimientoCajaFecha, A266MovimientoCajaDocum, A267MovimientoCajaEstado, A268MovimientoCajaFechaCierre, Long.valueOf(A26CajeroId), Long.valueOf(A25CajaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MovimientoCaja");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0O0( ) ;
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
            load0O25( ) ;
         }
         endLevel0O25( ) ;
      }
      closeExtendedTableCursors0O25( ) ;
   }

   public void update0O25( )
   {
      if ( ! IsAuthorized("movimientocaja_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0O25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0O25( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0O25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0O25( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0O25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000O13 */
                  pr_default.execute(11, new Object[] {A256MovimientoCajaAsignacion, A116MovimientoCajaHora, A117MovimientoCajaIngreso, A118MovimientoCajaEgreso, A119MovimientoCajaSaldo, A120MovimientoCajaFecha, A266MovimientoCajaDocum, A267MovimientoCajaEstado, A268MovimientoCajaFechaCierre, Long.valueOf(A26CajeroId), Long.valueOf(A25CajaId), Long.valueOf(A27MovimientoCajaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MovimientoCaja");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MovimientoCaja"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0O25( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
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
         endLevel0O25( ) ;
      }
      closeExtendedTableCursors0O25( ) ;
   }

   public void deferredUpdate0O25( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("movimientocaja_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0O25( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0O25( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0O25( ) ;
         afterConfirm0O25( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0O25( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000O14 */
               pr_default.execute(12, new Object[] {Long.valueOf(A27MovimientoCajaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MovimientoCaja");
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
      sMode25 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0O25( ) ;
      Gx_mode = sMode25 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0O25( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000O15 */
         pr_default.execute(13, new Object[] {Long.valueOf(A26CajeroId)});
         A112CajeroNombre = T000O15_A112CajeroNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
         pr_default.close(13);
         /* Using cursor T000O16 */
         pr_default.execute(14, new Object[] {Long.valueOf(A25CajaId)});
         A110CajaNumero = T000O16_A110CajaNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
         pr_default.close(14);
      }
   }

   public void endLevel0O25( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0O25( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.commitDataStores(context, remoteHandle, pr_default, "movimientocaja");
         if ( AnyError == 0 )
         {
            confirmValues0O0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "movimientocaja");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0O25( )
   {
      /* Scan By routine */
      /* Using cursor T000O17 */
      pr_default.execute(15);
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A27MovimientoCajaId = T000O17_A27MovimientoCajaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0O25( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A27MovimientoCajaId = T000O17_A27MovimientoCajaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      }
   }

   public void scanEnd0O25( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0O25( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0O25( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0O25( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0O25( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0O25( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0O25( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0O25( )
   {
      edtMovimientoCajaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaId_Enabled), 5, 0), true);
      edtMovimientoCajaHora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaHora_Enabled), 5, 0), true);
      edtMovimientoCajaIngreso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaIngreso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaIngreso_Enabled), 5, 0), true);
      edtMovimientoCajaEgreso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaEgreso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaEgreso_Enabled), 5, 0), true);
      edtMovimientoCajaSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaSaldo_Enabled), 5, 0), true);
      edtMovimientoCajaFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaFecha_Enabled), 5, 0), true);
      edtCajeroId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCajeroId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajeroId_Enabled), 5, 0), true);
      edtCajeroNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCajeroNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajeroNombre_Enabled), 5, 0), true);
      edtCajaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCajaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajaId_Enabled), 5, 0), true);
      edtCajaNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCajaNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajaNumero_Enabled), 5, 0), true);
      edtMovimientoCajaAsignacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaAsignacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaAsignacion_Enabled), 5, 0), true);
      edtMovimientoCajaDocum_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaDocum_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaDocum_Enabled), 5, 0), true);
      edtMovimientoCajaEstado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMovimientoCajaEstado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMovimientoCajaEstado_Enabled), 5, 0), true);
      edtavSaldoactual_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSaldoactual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSaldoactual_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0O25( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0O0( )
   {
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.movimientocaja", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7MovimientoCajaId,11,0))}, new String[] {"Gx_mode","MovimientoCajaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"MovimientoCaja");
      forbiddenHiddens.add("MovimientoCajaAsignacion", GXutil.rtrim( localUtil.format( A256MovimientoCajaAsignacion, "")));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("MovimientoCajaFechaCierre", localUtil.format(A268MovimientoCajaFechaCierre, "99/99/99"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("movimientocaja:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z27MovimientoCajaId", GXutil.ltrim( localUtil.ntoc( Z27MovimientoCajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z256MovimientoCajaAsignacion", GXutil.rtrim( Z256MovimientoCajaAsignacion));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z116MovimientoCajaHora", localUtil.ttoc( Z116MovimientoCajaHora, 10, 8, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z117MovimientoCajaIngreso", GXutil.ltrim( localUtil.ntoc( Z117MovimientoCajaIngreso, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z118MovimientoCajaEgreso", GXutil.ltrim( localUtil.ntoc( Z118MovimientoCajaEgreso, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z119MovimientoCajaSaldo", GXutil.ltrim( localUtil.ntoc( Z119MovimientoCajaSaldo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z120MovimientoCajaFecha", localUtil.dtoc( Z120MovimientoCajaFecha, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z266MovimientoCajaDocum", Z266MovimientoCajaDocum);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z267MovimientoCajaEstado", GXutil.rtrim( Z267MovimientoCajaEstado));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z268MovimientoCajaFechaCierre", localUtil.dtoc( Z268MovimientoCajaFechaCierre, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z26CajeroId", GXutil.ltrim( localUtil.ntoc( Z26CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z25CajaId", GXutil.ltrim( localUtil.ntoc( Z25CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N26CajeroId", GXutil.ltrim( localUtil.ntoc( A26CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N25CajaId", GXutil.ltrim( localUtil.ntoc( A25CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV11TrnContext);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV11TrnContext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMOVIMIENTOCAJAID", GXutil.ltrim( localUtil.ntoc( AV7MovimientoCajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMOVIMIENTOCAJAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7MovimientoCajaId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV21Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CAJEROID", GXutil.ltrim( localUtil.ntoc( AV13Insert_CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CAJAID", GXutil.ltrim( localUtil.ntoc( AV14Insert_CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERNAME", GXutil.rtrim( AV19UserName));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "MOVIMIENTOCAJAFECHACIERRE", localUtil.dtoc( A268MovimientoCajaFechaCierre, 0, "/"));
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
      return formatLink("com.mujermorena.movimientocaja", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7MovimientoCajaId,11,0))}, new String[] {"Gx_mode","MovimientoCajaId"})  ;
   }

   public String getPgmname( )
   {
      return "MovimientoCaja" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Movimiento Caja", "") ;
   }

   public void initializeNonKey0O25( )
   {
      A26CajeroId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
      A25CajaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
      A256MovimientoCajaAsignacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
      A116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
      A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
      A120MovimientoCajaFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
      A266MovimientoCajaDocum = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A266MovimientoCajaDocum", A266MovimientoCajaDocum);
      A112CajeroNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
      A110CajaNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
      A267MovimientoCajaEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A267MovimientoCajaEstado", A267MovimientoCajaEstado);
      A268MovimientoCajaFechaCierre = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A268MovimientoCajaFechaCierre", localUtil.format(A268MovimientoCajaFechaCierre, "99/99/99"));
      Z256MovimientoCajaAsignacion = "" ;
      Z116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      Z117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      Z118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      Z119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      Z120MovimientoCajaFecha = GXutil.nullDate() ;
      Z266MovimientoCajaDocum = "" ;
      Z267MovimientoCajaEstado = "" ;
      Z268MovimientoCajaFechaCierre = GXutil.nullDate() ;
      Z26CajeroId = 0 ;
      Z25CajaId = 0 ;
   }

   public void initAll0O25( )
   {
      A27MovimientoCajaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      initializeNonKey0O25( ) ;
   }

   public void standaloneModalInsert( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211195463", true, true);
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
      httpContext.AddJavascriptSource("movimientocaja.js", "?20241211195466", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtMovimientoCajaId_Internalname = "MOVIMIENTOCAJAID" ;
      edtMovimientoCajaHora_Internalname = "MOVIMIENTOCAJAHORA" ;
      edtMovimientoCajaIngreso_Internalname = "MOVIMIENTOCAJAINGRESO" ;
      edtMovimientoCajaEgreso_Internalname = "MOVIMIENTOCAJAEGRESO" ;
      edtMovimientoCajaSaldo_Internalname = "MOVIMIENTOCAJASALDO" ;
      edtMovimientoCajaFecha_Internalname = "MOVIMIENTOCAJAFECHA" ;
      edtCajeroId_Internalname = "CAJEROID" ;
      edtCajeroNombre_Internalname = "CAJERONOMBRE" ;
      edtCajaId_Internalname = "CAJAID" ;
      edtCajaNumero_Internalname = "CAJANUMERO" ;
      edtMovimientoCajaAsignacion_Internalname = "MOVIMIENTOCAJAASIGNACION" ;
      edtMovimientoCajaDocum_Internalname = "MOVIMIENTOCAJADOCUM" ;
      edtMovimientoCajaEstado_Internalname = "MOVIMIENTOCAJAESTADO" ;
      edtavSaldoactual_Internalname = "vSALDOACTUAL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_26_Internalname = "PROMPT_26" ;
      imgprompt_25_Internalname = "PROMPT_25" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Movimiento Caja", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtavSaldoactual_Jsonclick = "" ;
      edtavSaldoactual_Enabled = 0 ;
      edtMovimientoCajaEstado_Jsonclick = "" ;
      edtMovimientoCajaEstado_Enabled = 1 ;
      edtMovimientoCajaDocum_Jsonclick = "" ;
      edtMovimientoCajaDocum_Enabled = 1 ;
      edtMovimientoCajaAsignacion_Jsonclick = "" ;
      edtMovimientoCajaAsignacion_Enabled = 0 ;
      edtCajaNumero_Jsonclick = "" ;
      edtCajaNumero_Enabled = 0 ;
      imgprompt_25_Visible = 1 ;
      imgprompt_25_Link = "" ;
      edtCajaId_Jsonclick = "" ;
      edtCajaId_Enabled = 1 ;
      edtCajeroNombre_Jsonclick = "" ;
      edtCajeroNombre_Enabled = 0 ;
      imgprompt_26_Visible = 1 ;
      imgprompt_26_Link = "" ;
      edtCajeroId_Jsonclick = "" ;
      edtCajeroId_Enabled = 1 ;
      edtMovimientoCajaFecha_Jsonclick = "" ;
      edtMovimientoCajaFecha_Enabled = 1 ;
      edtMovimientoCajaSaldo_Jsonclick = "" ;
      edtMovimientoCajaSaldo_Enabled = 1 ;
      edtMovimientoCajaEgreso_Jsonclick = "" ;
      edtMovimientoCajaEgreso_Enabled = 1 ;
      edtMovimientoCajaIngreso_Jsonclick = "" ;
      edtMovimientoCajaIngreso_Enabled = 1 ;
      edtMovimientoCajaHora_Jsonclick = "" ;
      edtMovimientoCajaHora_Enabled = 1 ;
      edtMovimientoCajaId_Jsonclick = "" ;
      edtMovimientoCajaId_Enabled = 1 ;
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

   public void gx5asamovimientocajaid0O25( long AV7MovimientoCajaId ,
                                           String AV21Pgmname )
   {
      if ( ! (0==AV7MovimientoCajaId) )
      {
         A27MovimientoCajaId = AV7MovimientoCajaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int5 = A27MovimientoCajaId ;
            GXv_int2[0] = GXt_int5 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV21Pgmname), GXv_int2) ;
            movimientocaja_impl.this.GXt_int5 = GXv_int2[0] ;
            A27MovimientoCajaId = GXt_int5 ;
            httpContext.ajax_rsp_assign_attri("", false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A27MovimientoCajaId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx11asasaldoactual0O25( )
   {
      GXt_decimal3 = AV20SaldoActual ;
      GXv_decimal4[0] = GXt_decimal3 ;
      new com.mujermorena.saldoactualcaja(remoteHandle, context).execute( GXv_decimal4) ;
      movimientocaja_impl.this.GXt_decimal3 = GXv_decimal4[0] ;
      AV20SaldoActual = GXt_decimal3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20SaldoActual", GXutil.ltrimstr( AV20SaldoActual, 18, 2));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV20SaldoActual, (byte)(18), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
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

   public void valid_Cajeroid( )
   {
      /* Using cursor T000O15 */
      pr_default.execute(13, new Object[] {Long.valueOf(A26CajeroId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cajero", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJEROID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajeroId_Internalname ;
      }
      A112CajeroNombre = T000O15_A112CajeroNombre[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", GXutil.rtrim( A112CajeroNombre));
   }

   public void valid_Cajaid( )
   {
      /* Using cursor T000O16 */
      pr_default.execute(14, new Object[] {Long.valueOf(A25CajaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Caja", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajaId_Internalname ;
      }
      A110CajaNumero = T000O16_A110CajaNumero[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A110CajaNumero", GXutil.ltrim( localUtil.ntoc( A110CajaNumero, (byte)(10), (byte)(0), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7MovimientoCajaId',fld:'vMOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7MovimientoCajaId',fld:'vMOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9',hsh:true},{av:'A256MovimientoCajaAsignacion',fld:'MOVIMIENTOCAJAASIGNACION',pic:''},{av:'A268MovimientoCajaFechaCierre',fld:'MOVIMIENTOCAJAFECHACIERRE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120O2',iparms:[{av:'A27MovimientoCajaId',fld:'MOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A27MovimientoCajaId',fld:'MOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_MOVIMIENTOCAJAID","{handler:'valid_Movimientocajaid',iparms:[]");
      setEventMetadata("VALID_MOVIMIENTOCAJAID",",oparms:[]}");
      setEventMetadata("VALID_MOVIMIENTOCAJAEGRESO","{handler:'valid_Movimientocajaegreso',iparms:[]");
      setEventMetadata("VALID_MOVIMIENTOCAJAEGRESO",",oparms:[]}");
      setEventMetadata("VALID_MOVIMIENTOCAJAFECHA","{handler:'valid_Movimientocajafecha',iparms:[]");
      setEventMetadata("VALID_MOVIMIENTOCAJAFECHA",",oparms:[]}");
      setEventMetadata("VALID_CAJEROID","{handler:'valid_Cajeroid',iparms:[{av:'A26CajeroId',fld:'CAJEROID',pic:'ZZZZZZZZZZ9'},{av:'A112CajeroNombre',fld:'CAJERONOMBRE',pic:''}]");
      setEventMetadata("VALID_CAJEROID",",oparms:[{av:'A112CajeroNombre',fld:'CAJERONOMBRE',pic:''}]}");
      setEventMetadata("VALID_CAJAID","{handler:'valid_Cajaid',iparms:[{av:'A25CajaId',fld:'CAJAID',pic:'ZZZZZZZZZZ9'},{av:'A110CajaNumero',fld:'CAJANUMERO',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VALID_CAJAID",",oparms:[{av:'A110CajaNumero',fld:'CAJANUMERO',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VALIDV_SALDOACTUAL","{handler:'validv_Saldoactual',iparms:[]");
      setEventMetadata("VALIDV_SALDOACTUAL",",oparms:[]}");
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
      return "movimientocaja_Execute";
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
      pr_default.close(13);
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z256MovimientoCajaAsignacion = "" ;
      Z116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      Z117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      Z118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      Z119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      Z120MovimientoCajaFecha = GXutil.nullDate() ;
      Z266MovimientoCajaDocum = "" ;
      Z267MovimientoCajaEstado = "" ;
      Z268MovimientoCajaFechaCierre = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV21Pgmname = "" ;
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
      A116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      A120MovimientoCajaFecha = GXutil.nullDate() ;
      imgprompt_26_gximage = "" ;
      sImgUrl = "" ;
      A112CajeroNombre = "" ;
      imgprompt_25_gximage = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A266MovimientoCajaDocum = "" ;
      A267MovimientoCajaEstado = "" ;
      AV20SaldoActual = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A268MovimientoCajaFechaCierre = GXutil.nullDate() ;
      AV19UserName = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode25 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV18GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z112CajeroNombre = "" ;
      T000O5_A110CajaNumero = new long[1] ;
      T000O4_A112CajeroNombre = new String[] {""} ;
      T000O6_A27MovimientoCajaId = new long[1] ;
      T000O6_A256MovimientoCajaAsignacion = new String[] {""} ;
      T000O6_A116MovimientoCajaHora = new java.util.Date[] {GXutil.nullDate()} ;
      T000O6_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O6_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O6_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O6_A120MovimientoCajaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000O6_A266MovimientoCajaDocum = new String[] {""} ;
      T000O6_A112CajeroNombre = new String[] {""} ;
      T000O6_A110CajaNumero = new long[1] ;
      T000O6_A267MovimientoCajaEstado = new String[] {""} ;
      T000O6_A268MovimientoCajaFechaCierre = new java.util.Date[] {GXutil.nullDate()} ;
      T000O6_A26CajeroId = new long[1] ;
      T000O6_A25CajaId = new long[1] ;
      T000O7_A112CajeroNombre = new String[] {""} ;
      T000O8_A110CajaNumero = new long[1] ;
      T000O9_A27MovimientoCajaId = new long[1] ;
      T000O3_A27MovimientoCajaId = new long[1] ;
      T000O3_A256MovimientoCajaAsignacion = new String[] {""} ;
      T000O3_A116MovimientoCajaHora = new java.util.Date[] {GXutil.nullDate()} ;
      T000O3_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O3_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O3_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O3_A120MovimientoCajaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000O3_A266MovimientoCajaDocum = new String[] {""} ;
      T000O3_A267MovimientoCajaEstado = new String[] {""} ;
      T000O3_A268MovimientoCajaFechaCierre = new java.util.Date[] {GXutil.nullDate()} ;
      T000O3_A26CajeroId = new long[1] ;
      T000O3_A25CajaId = new long[1] ;
      T000O10_A27MovimientoCajaId = new long[1] ;
      T000O11_A27MovimientoCajaId = new long[1] ;
      T000O2_A27MovimientoCajaId = new long[1] ;
      T000O2_A256MovimientoCajaAsignacion = new String[] {""} ;
      T000O2_A116MovimientoCajaHora = new java.util.Date[] {GXutil.nullDate()} ;
      T000O2_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O2_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O2_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000O2_A120MovimientoCajaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000O2_A266MovimientoCajaDocum = new String[] {""} ;
      T000O2_A267MovimientoCajaEstado = new String[] {""} ;
      T000O2_A268MovimientoCajaFechaCierre = new java.util.Date[] {GXutil.nullDate()} ;
      T000O2_A26CajeroId = new long[1] ;
      T000O2_A25CajaId = new long[1] ;
      T000O15_A112CajeroNombre = new String[] {""} ;
      T000O16_A110CajaNumero = new long[1] ;
      T000O17_A27MovimientoCajaId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int2 = new long[1] ;
      GXt_decimal3 = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.movimientocaja__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.movimientocaja__default(),
         new Object[] {
             new Object[] {
            T000O2_A27MovimientoCajaId, T000O2_A256MovimientoCajaAsignacion, T000O2_A116MovimientoCajaHora, T000O2_A117MovimientoCajaIngreso, T000O2_A118MovimientoCajaEgreso, T000O2_A119MovimientoCajaSaldo, T000O2_A120MovimientoCajaFecha, T000O2_A266MovimientoCajaDocum, T000O2_A267MovimientoCajaEstado, T000O2_A268MovimientoCajaFechaCierre,
            T000O2_A26CajeroId, T000O2_A25CajaId
            }
            , new Object[] {
            T000O3_A27MovimientoCajaId, T000O3_A256MovimientoCajaAsignacion, T000O3_A116MovimientoCajaHora, T000O3_A117MovimientoCajaIngreso, T000O3_A118MovimientoCajaEgreso, T000O3_A119MovimientoCajaSaldo, T000O3_A120MovimientoCajaFecha, T000O3_A266MovimientoCajaDocum, T000O3_A267MovimientoCajaEstado, T000O3_A268MovimientoCajaFechaCierre,
            T000O3_A26CajeroId, T000O3_A25CajaId
            }
            , new Object[] {
            T000O4_A112CajeroNombre
            }
            , new Object[] {
            T000O5_A110CajaNumero
            }
            , new Object[] {
            T000O6_A27MovimientoCajaId, T000O6_A256MovimientoCajaAsignacion, T000O6_A116MovimientoCajaHora, T000O6_A117MovimientoCajaIngreso, T000O6_A118MovimientoCajaEgreso, T000O6_A119MovimientoCajaSaldo, T000O6_A120MovimientoCajaFecha, T000O6_A266MovimientoCajaDocum, T000O6_A112CajeroNombre, T000O6_A110CajaNumero,
            T000O6_A267MovimientoCajaEstado, T000O6_A268MovimientoCajaFechaCierre, T000O6_A26CajeroId, T000O6_A25CajaId
            }
            , new Object[] {
            T000O7_A112CajeroNombre
            }
            , new Object[] {
            T000O8_A110CajaNumero
            }
            , new Object[] {
            T000O9_A27MovimientoCajaId
            }
            , new Object[] {
            T000O10_A27MovimientoCajaId
            }
            , new Object[] {
            T000O11_A27MovimientoCajaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000O15_A112CajeroNombre
            }
            , new Object[] {
            T000O16_A110CajaNumero
            }
            , new Object[] {
            T000O17_A27MovimientoCajaId
            }
         }
      );
      AV21Pgmname = "MovimientoCaja" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound25 ;
   private short nIsDirty_25 ;
   private int trnEnded ;
   private int edtMovimientoCajaId_Enabled ;
   private int edtMovimientoCajaHora_Enabled ;
   private int edtMovimientoCajaIngreso_Enabled ;
   private int edtMovimientoCajaEgreso_Enabled ;
   private int edtMovimientoCajaSaldo_Enabled ;
   private int edtMovimientoCajaFecha_Enabled ;
   private int edtCajeroId_Enabled ;
   private int imgprompt_26_Visible ;
   private int edtCajeroNombre_Enabled ;
   private int edtCajaId_Enabled ;
   private int imgprompt_25_Visible ;
   private int edtCajaNumero_Enabled ;
   private int edtMovimientoCajaAsignacion_Enabled ;
   private int edtMovimientoCajaDocum_Enabled ;
   private int edtMovimientoCajaEstado_Enabled ;
   private int edtavSaldoactual_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV22GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7MovimientoCajaId ;
   private long Z27MovimientoCajaId ;
   private long Z26CajeroId ;
   private long Z25CajaId ;
   private long N26CajeroId ;
   private long N25CajaId ;
   private long AV7MovimientoCajaId ;
   private long A26CajeroId ;
   private long A25CajaId ;
   private long A27MovimientoCajaId ;
   private long A110CajaNumero ;
   private long AV13Insert_CajeroId ;
   private long AV14Insert_CajaId ;
   private long Z110CajaNumero ;
   private long GXt_int5 ;
   private long GXv_int2[] ;
   private java.math.BigDecimal Z117MovimientoCajaIngreso ;
   private java.math.BigDecimal Z118MovimientoCajaEgreso ;
   private java.math.BigDecimal Z119MovimientoCajaSaldo ;
   private java.math.BigDecimal A117MovimientoCajaIngreso ;
   private java.math.BigDecimal A118MovimientoCajaEgreso ;
   private java.math.BigDecimal A119MovimientoCajaSaldo ;
   private java.math.BigDecimal AV20SaldoActual ;
   private java.math.BigDecimal GXt_decimal3 ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z256MovimientoCajaAsignacion ;
   private String Z267MovimientoCajaEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV21Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMovimientoCajaId_Internalname ;
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
   private String edtMovimientoCajaId_Jsonclick ;
   private String edtMovimientoCajaHora_Internalname ;
   private String edtMovimientoCajaHora_Jsonclick ;
   private String edtMovimientoCajaIngreso_Internalname ;
   private String edtMovimientoCajaIngreso_Jsonclick ;
   private String edtMovimientoCajaEgreso_Internalname ;
   private String edtMovimientoCajaEgreso_Jsonclick ;
   private String edtMovimientoCajaSaldo_Internalname ;
   private String edtMovimientoCajaSaldo_Jsonclick ;
   private String edtMovimientoCajaFecha_Internalname ;
   private String edtMovimientoCajaFecha_Jsonclick ;
   private String edtCajeroId_Internalname ;
   private String edtCajeroId_Jsonclick ;
   private String imgprompt_26_gximage ;
   private String sImgUrl ;
   private String imgprompt_26_Internalname ;
   private String imgprompt_26_Link ;
   private String edtCajeroNombre_Internalname ;
   private String A112CajeroNombre ;
   private String edtCajeroNombre_Jsonclick ;
   private String edtCajaId_Internalname ;
   private String edtCajaId_Jsonclick ;
   private String imgprompt_25_gximage ;
   private String imgprompt_25_Internalname ;
   private String imgprompt_25_Link ;
   private String edtCajaNumero_Internalname ;
   private String edtCajaNumero_Jsonclick ;
   private String edtMovimientoCajaAsignacion_Internalname ;
   private String A256MovimientoCajaAsignacion ;
   private String edtMovimientoCajaAsignacion_Jsonclick ;
   private String edtMovimientoCajaDocum_Internalname ;
   private String edtMovimientoCajaDocum_Jsonclick ;
   private String edtMovimientoCajaEstado_Internalname ;
   private String A267MovimientoCajaEstado ;
   private String edtMovimientoCajaEstado_Jsonclick ;
   private String edtavSaldoactual_Internalname ;
   private String edtavSaldoactual_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV19UserName ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode25 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z112CajeroNombre ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z116MovimientoCajaHora ;
   private java.util.Date A116MovimientoCajaHora ;
   private java.util.Date Z120MovimientoCajaFecha ;
   private java.util.Date Z268MovimientoCajaFechaCierre ;
   private java.util.Date A120MovimientoCajaFecha ;
   private java.util.Date A268MovimientoCajaFechaCierre ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private String Z266MovimientoCajaDocum ;
   private String A266MovimientoCajaDocum ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T000O5_A110CajaNumero ;
   private String[] T000O4_A112CajeroNombre ;
   private long[] T000O6_A27MovimientoCajaId ;
   private String[] T000O6_A256MovimientoCajaAsignacion ;
   private java.util.Date[] T000O6_A116MovimientoCajaHora ;
   private java.math.BigDecimal[] T000O6_A117MovimientoCajaIngreso ;
   private java.math.BigDecimal[] T000O6_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] T000O6_A119MovimientoCajaSaldo ;
   private java.util.Date[] T000O6_A120MovimientoCajaFecha ;
   private String[] T000O6_A266MovimientoCajaDocum ;
   private String[] T000O6_A112CajeroNombre ;
   private long[] T000O6_A110CajaNumero ;
   private String[] T000O6_A267MovimientoCajaEstado ;
   private java.util.Date[] T000O6_A268MovimientoCajaFechaCierre ;
   private long[] T000O6_A26CajeroId ;
   private long[] T000O6_A25CajaId ;
   private String[] T000O7_A112CajeroNombre ;
   private long[] T000O8_A110CajaNumero ;
   private long[] T000O9_A27MovimientoCajaId ;
   private long[] T000O3_A27MovimientoCajaId ;
   private String[] T000O3_A256MovimientoCajaAsignacion ;
   private java.util.Date[] T000O3_A116MovimientoCajaHora ;
   private java.math.BigDecimal[] T000O3_A117MovimientoCajaIngreso ;
   private java.math.BigDecimal[] T000O3_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] T000O3_A119MovimientoCajaSaldo ;
   private java.util.Date[] T000O3_A120MovimientoCajaFecha ;
   private String[] T000O3_A266MovimientoCajaDocum ;
   private String[] T000O3_A267MovimientoCajaEstado ;
   private java.util.Date[] T000O3_A268MovimientoCajaFechaCierre ;
   private long[] T000O3_A26CajeroId ;
   private long[] T000O3_A25CajaId ;
   private long[] T000O10_A27MovimientoCajaId ;
   private long[] T000O11_A27MovimientoCajaId ;
   private long[] T000O2_A27MovimientoCajaId ;
   private String[] T000O2_A256MovimientoCajaAsignacion ;
   private java.util.Date[] T000O2_A116MovimientoCajaHora ;
   private java.math.BigDecimal[] T000O2_A117MovimientoCajaIngreso ;
   private java.math.BigDecimal[] T000O2_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] T000O2_A119MovimientoCajaSaldo ;
   private java.util.Date[] T000O2_A120MovimientoCajaFecha ;
   private String[] T000O2_A266MovimientoCajaDocum ;
   private String[] T000O2_A267MovimientoCajaEstado ;
   private java.util.Date[] T000O2_A268MovimientoCajaFechaCierre ;
   private long[] T000O2_A26CajeroId ;
   private long[] T000O2_A25CajaId ;
   private String[] T000O15_A112CajeroNombre ;
   private long[] T000O16_A110CajaNumero ;
   private long[] T000O17_A27MovimientoCajaId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV18GAMUser ;
}

final  class movimientocaja__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class movimientocaja__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000O2", "SELECT [MovimientoCajaId], [MovimientoCajaAsignacion], [MovimientoCajaHora], [MovimientoCajaIngreso], [MovimientoCajaEgreso], [MovimientoCajaSaldo], [MovimientoCajaFecha], [MovimientoCajaDocum], [MovimientoCajaEstado], [MovimientoCajaFechaCierre], [CajeroId], [CajaId] FROM [MovimientoCaja] WITH (UPDLOCK) WHERE [MovimientoCajaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O3", "SELECT [MovimientoCajaId], [MovimientoCajaAsignacion], [MovimientoCajaHora], [MovimientoCajaIngreso], [MovimientoCajaEgreso], [MovimientoCajaSaldo], [MovimientoCajaFecha], [MovimientoCajaDocum], [MovimientoCajaEstado], [MovimientoCajaFechaCierre], [CajeroId], [CajaId] FROM [MovimientoCaja] WHERE [MovimientoCajaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O4", "SELECT [CajeroNombre] FROM [Cajero] WHERE [CajeroId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O5", "SELECT [CajaNumero] FROM [Caja] WHERE [CajaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O6", "SELECT TM1.[MovimientoCajaId], TM1.[MovimientoCajaAsignacion], TM1.[MovimientoCajaHora], TM1.[MovimientoCajaIngreso], TM1.[MovimientoCajaEgreso], TM1.[MovimientoCajaSaldo], TM1.[MovimientoCajaFecha], TM1.[MovimientoCajaDocum], T2.[CajeroNombre], T3.[CajaNumero], TM1.[MovimientoCajaEstado], TM1.[MovimientoCajaFechaCierre], TM1.[CajeroId], TM1.[CajaId] FROM (([MovimientoCaja] TM1 INNER JOIN [Cajero] T2 ON T2.[CajeroId] = TM1.[CajeroId]) INNER JOIN [Caja] T3 ON T3.[CajaId] = TM1.[CajaId]) WHERE TM1.[MovimientoCajaId] = ? ORDER BY TM1.[MovimientoCajaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O7", "SELECT [CajeroNombre] FROM [Cajero] WHERE [CajeroId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O8", "SELECT [CajaNumero] FROM [Caja] WHERE [CajaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O9", "SELECT [MovimientoCajaId] FROM [MovimientoCaja] WHERE [MovimientoCajaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O10", "SELECT TOP 1 [MovimientoCajaId] FROM [MovimientoCaja] WHERE ( [MovimientoCajaId] > ?) ORDER BY [MovimientoCajaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000O11", "SELECT TOP 1 [MovimientoCajaId] FROM [MovimientoCaja] WHERE ( [MovimientoCajaId] < ?) ORDER BY [MovimientoCajaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000O12", "INSERT INTO [MovimientoCaja]([MovimientoCajaId], [MovimientoCajaAsignacion], [MovimientoCajaHora], [MovimientoCajaIngreso], [MovimientoCajaEgreso], [MovimientoCajaSaldo], [MovimientoCajaFecha], [MovimientoCajaDocum], [MovimientoCajaEstado], [MovimientoCajaFechaCierre], [CajeroId], [CajaId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000O13", "UPDATE [MovimientoCaja] SET [MovimientoCajaAsignacion]=?, [MovimientoCajaHora]=?, [MovimientoCajaIngreso]=?, [MovimientoCajaEgreso]=?, [MovimientoCajaSaldo]=?, [MovimientoCajaFecha]=?, [MovimientoCajaDocum]=?, [MovimientoCajaEstado]=?, [MovimientoCajaFechaCierre]=?, [CajeroId]=?, [CajaId]=?  WHERE [MovimientoCajaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000O14", "DELETE FROM [MovimientoCaja]  WHERE [MovimientoCajaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000O15", "SELECT [CajeroNombre] FROM [Cajero] WHERE [CajeroId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O16", "SELECT [CajaNumero] FROM [Caja] WHERE [CajaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O17", "SELECT [MovimientoCajaId] FROM [MovimientoCaja] ORDER BY [MovimientoCajaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               ((long[]) buf[13])[0] = rslt.getLong(14);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
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
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
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
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setDateTime(3, (java.util.Date)parms[2], true);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setString(9, (String)parms[8], 20);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setDateTime(2, (java.util.Date)parms[1], true);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setLong(10, ((Number) parms[9]).longValue());
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
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
      }
   }

}

