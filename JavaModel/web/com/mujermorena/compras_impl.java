package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class compras_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel9"+"_"+"COMPRASID") == 0 )
      {
         AV7ComprasId = GXutil.lval( httpContext.GetPar( "ComprasId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ComprasId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOMPRASID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ComprasId), "ZZZZZZZZZZ9")));
         AV15Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx9asacomprasid0B11( AV7ComprasId, AV15Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel24"+"_"+"COMPRASDETALLEID") == 0 )
      {
         AV15Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx24asacomprasdetalleid0B12( AV15Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_30") == 0 )
      {
         A11ComprasId = GXutil.lval( httpContext.GetPar( "ComprasId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_30( A11ComprasId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A10ProveedorId = GXutil.lval( httpContext.GetPar( "ProveedorId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A10ProveedorId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_32") == 0 )
      {
         A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_32( A13ArticuloId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_33") == 0 )
      {
         A18ImpuestoId = GXutil.lval( httpContext.GetPar( "ImpuestoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_33( A18ImpuestoId) ;
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
            AV7ComprasId = GXutil.lval( httpContext.GetPar( "ComprasId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ComprasId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOMPRASID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ComprasId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Compras", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtProveedorId_Internalname ;
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
      nRC_GXsfl_80 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_80"))) ;
      nGXsfl_80_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_80_idx"))) ;
      sGXsfl_80_idx = httpContext.GetPar( "sGXsfl_80_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV15Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_detalle_newrow( ) ;
      /* End function gxnrGridlevel_detalle_newrow_invoke */
   }

   public compras_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public compras_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( compras_impl.class ));
   }

   public compras_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynComprasDetalleTallaID = new HTMLChoice();
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Compras", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Compras.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasId_Internalname, httpContext.getMessage( "Compras Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasId_Internalname, GXutil.ltrim( localUtil.ntoc( A11ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasFecha_Internalname, httpContext.getMessage( "Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtComprasFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasFecha_Internalname, localUtil.format(A74ComprasFecha, "99/99/99"), localUtil.format( A74ComprasFecha, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtComprasFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtComprasFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtComprasFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Compras.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProveedorId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtProveedorId_Internalname, httpContext.getMessage( "Proveedor Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtProveedorId_Internalname, GXutil.ltrim( localUtil.ntoc( A10ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A10ProveedorId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProveedorId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtProveedorId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Compras.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_10_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_10_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_10_Internalname, sImgUrl, imgprompt_10_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_10_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTimbrado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTimbrado_Internalname, httpContext.getMessage( "Timbrado", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTimbrado_Internalname, GXutil.ltrim( localUtil.ntoc( A226ComprasTimbrado, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTimbrado_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A226ComprasTimbrado), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A226ComprasTimbrado), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTimbrado_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTimbrado_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Timbrado", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasNumeroFactura_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasNumeroFactura_Internalname, httpContext.getMessage( "Numero Factura", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasNumeroFactura_Internalname, GXutil.ltrim( localUtil.ntoc( A227ComprasNumeroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasNumeroFactura_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasNumeroFactura_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasNumeroFactura_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalExento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalExento_Internalname, httpContext.getMessage( "Total Exento", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalExento_Internalname, GXutil.ltrim( localUtil.ntoc( A90ComprasTotalExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalExento_Enabled!=0) ? localUtil.format( A90ComprasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A90ComprasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalExento_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotalExento_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalIva5_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalIva5_Internalname, httpContext.getMessage( "Total Iva5", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A87ComprasTotalIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalIva5_Enabled!=0) ? localUtil.format( A87ComprasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A87ComprasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalIva5_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotalIva5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalIva10_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalIva10_Internalname, httpContext.getMessage( "Total Iva10", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A89ComprasTotalIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalIva10_Enabled!=0) ? localUtil.format( A89ComprasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A89ComprasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalIva10_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotalIva10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A229ComprasTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotal_Enabled!=0) ? localUtil.format( A229ComprasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A229ComprasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotal5_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotal5_Internalname, httpContext.getMessage( "Total5", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotal5_Internalname, GXutil.ltrim( localUtil.ntoc( A86ComprasTotal5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotal5_Enabled!=0) ? localUtil.format( A86ComprasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A86ComprasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotal5_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotal5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotal10_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotal10_Internalname, httpContext.getMessage( "Total10", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotal10_Internalname, GXutil.ltrim( localUtil.ntoc( A88ComprasTotal10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotal10_Enabled!=0) ? localUtil.format( A88ComprasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A88ComprasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotal10_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotal10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalIva_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalIva_Internalname, httpContext.getMessage( "Total Iva", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalIva_Internalname, GXutil.ltrim( localUtil.ntoc( A225ComprasTotalIva, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalIva_Enabled!=0) ? localUtil.format( A225ComprasTotalIva, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A225ComprasTotalIva, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalIva_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtComprasTotalIva_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Compras.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Compras.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Compras.htm");
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
      startgridcontrol80( ) ;
      nGXsfl_80_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount12 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_12 = (short)(1) ;
            scanStart0B12( ) ;
            while ( RcdFound12 != 0 )
            {
               init_level_properties12( ) ;
               getByPrimaryKey0B12( ) ;
               addRow0B12( ) ;
               scanNext0B12( ) ;
            }
            scanEnd0B12( ) ;
            nBlankRcdCount12 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B89ComprasTotalIva10 = A89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         B87ComprasTotalIva5 = A87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         B90ComprasTotalExento = A90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         standaloneNotModal0B12( ) ;
         standaloneModal0B12( ) ;
         sMode12 = Gx_mode ;
         while ( nGXsfl_80_idx < nRC_GXsfl_80 )
         {
            bGXsfl_80_Refreshing = true ;
            readRow0B12( ) ;
            edtComprasDetalleId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEID_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtComprasDetalleCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLECANTIDAD_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleCantidad_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtImpuestoPorcentaje_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "IMPUESTOPORCENTAJE_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtComprasCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASCANTIDAD_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasCantidad_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtComprasDetallePrecioCompra_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasDetallePrecioCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetallePrecioCompra_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtComprasDetalleExento_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEEXENTO_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleExento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleExento_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtComprasDetalleIva5_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEIVA5_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleIva5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleIva5_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            edtComprasDetalleIva10_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEIVA10_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleIva10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleIva10_Enabled), 5, 0), !bGXsfl_80_Refreshing);
            dynComprasDetalleTallaID.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLETALLAID_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynComprasDetalleTallaID.getInternalname(), "Enabled", GXutil.ltrimstr( dynComprasDetalleTallaID.getEnabled(), 5, 0), !bGXsfl_80_Refreshing);
            imgprompt_10_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_80_idx+"Link") ;
            if ( ( nRcdExists_12 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0B12( ) ;
            }
            sendRow0B12( ) ;
            bGXsfl_80_Refreshing = false ;
         }
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A89ComprasTotalIva10 = B89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         A87ComprasTotalIva5 = B87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A90ComprasTotalExento = B90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount12 = (short)(5) ;
         nRcdExists_12 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0B12( ) ;
            while ( RcdFound12 != 0 )
            {
               sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_8012( ) ;
               init_level_properties12( ) ;
               standaloneNotModal0B12( ) ;
               getByPrimaryKey0B12( ) ;
               standaloneModal0B12( ) ;
               addRow0B12( ) ;
               scanNext0B12( ) ;
            }
            scanEnd0B12( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode12 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_8012( ) ;
         initAll0B12( ) ;
         init_level_properties12( ) ;
         B89ComprasTotalIva10 = A89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         B87ComprasTotalIva5 = A87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         B90ComprasTotalExento = A90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         nRcdExists_12 = (short)(0) ;
         nIsMod_12 = (short)(0) ;
         nRcdDeleted_12 = (short)(0) ;
         nBlankRcdCount12 = (short)(nBlankRcdUsr12+nBlankRcdCount12) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount12 > 0 )
         {
            standaloneNotModal0B12( ) ;
            standaloneModal0B12( ) ;
            addRow0B12( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtComprasDetalleId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount12 = (short)(nBlankRcdCount12-1) ;
         }
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A89ComprasTotalIva10 = B89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         A87ComprasTotalIva5 = B87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A90ComprasTotalExento = B90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
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
      e110B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z11ComprasId = localUtil.ctol( httpContext.cgiGet( "Z11ComprasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z74ComprasFecha = localUtil.ctod( httpContext.cgiGet( "Z74ComprasFecha"), 0) ;
            Z226ComprasTimbrado = localUtil.ctol( httpContext.cgiGet( "Z226ComprasTimbrado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z227ComprasNumeroFactura = localUtil.ctol( httpContext.cgiGet( "Z227ComprasNumeroFactura"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z10ProveedorId = localUtil.ctol( httpContext.cgiGet( "Z10ProveedorId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            O89ComprasTotalIva10 = localUtil.ctond( httpContext.cgiGet( "O89ComprasTotalIva10")) ;
            O87ComprasTotalIva5 = localUtil.ctond( httpContext.cgiGet( "O87ComprasTotalIva5")) ;
            O90ComprasTotalExento = localUtil.ctond( httpContext.cgiGet( "O90ComprasTotalExento")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_80 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_80"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N10ProveedorId = localUtil.ctol( httpContext.cgiGet( "N10ProveedorId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7ComprasId = localUtil.ctol( httpContext.cgiGet( "vCOMPRASID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_ProveedorId = localUtil.ctol( httpContext.cgiGet( "vINSERT_PROVEEDORID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            A11ComprasId = localUtil.ctol( httpContext.cgiGet( edtComprasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
            A74ComprasFecha = localUtil.ctod( httpContext.cgiGet( edtComprasFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtProveedorId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtProveedorId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROVEEDORID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A10ProveedorId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
            }
            else
            {
               A10ProveedorId = localUtil.ctol( httpContext.cgiGet( edtProveedorId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtComprasTimbrado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtComprasTimbrado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COMPRASTIMBRADO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtComprasTimbrado_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A226ComprasTimbrado = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
            }
            else
            {
               A226ComprasTimbrado = localUtil.ctol( httpContext.cgiGet( edtComprasTimbrado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtComprasNumeroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtComprasNumeroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COMPRASNUMEROFACTURA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtComprasNumeroFactura_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A227ComprasNumeroFactura = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
            }
            else
            {
               A227ComprasNumeroFactura = localUtil.ctol( httpContext.cgiGet( edtComprasNumeroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
            }
            A90ComprasTotalExento = localUtil.ctond( httpContext.cgiGet( edtComprasTotalExento_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A87ComprasTotalIva5 = localUtil.ctond( httpContext.cgiGet( edtComprasTotalIva5_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            A89ComprasTotalIva10 = localUtil.ctond( httpContext.cgiGet( edtComprasTotalIva10_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            A229ComprasTotal = localUtil.ctond( httpContext.cgiGet( edtComprasTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
            A86ComprasTotal5 = localUtil.ctond( httpContext.cgiGet( edtComprasTotal5_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
            A88ComprasTotal10 = localUtil.ctond( httpContext.cgiGet( edtComprasTotal10_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
            A225ComprasTotalIva = localUtil.ctond( httpContext.cgiGet( edtComprasTotalIva_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Compras");
            A11ComprasId = localUtil.ctol( httpContext.cgiGet( edtComprasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
            forbiddenHiddens.add("ComprasId", localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            A74ComprasFecha = localUtil.ctod( httpContext.cgiGet( edtComprasFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
            forbiddenHiddens.add("ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A11ComprasId != Z11ComprasId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("compras:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A11ComprasId = GXutil.lval( httpContext.GetPar( "ComprasId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
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
                  sMode11 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode11 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound11 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0B0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "COMPRASID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtComprasId_Internalname ;
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
                        e110B2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120B2 ();
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
         e120B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0B11( ) ;
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
         disableAttributes0B11( ) ;
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

   public void confirm_0B0( )
   {
      beforeValidate0B11( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0B11( ) ;
         }
         else
         {
            checkExtendedTable0B11( ) ;
            closeExtendedTableCursors0B11( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode11 = Gx_mode ;
         confirm_0B12( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode11 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode11 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0B12( )
   {
      s89ComprasTotalIva10 = O89ComprasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      s87ComprasTotalIva5 = O87ComprasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      s90ComprasTotalExento = O90ComprasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      s88ComprasTotal10 = O88ComprasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      s86ComprasTotal5 = O86ComprasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      s225ComprasTotalIva = O225ComprasTotalIva ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      s229ComprasTotal = O229ComprasTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      nGXsfl_80_idx = 0 ;
      while ( nGXsfl_80_idx < nRC_GXsfl_80 )
      {
         readRow0B12( ) ;
         if ( ( nRcdExists_12 != 0 ) || ( nIsMod_12 != 0 ) )
         {
            getKey0B12( ) ;
            if ( ( nRcdExists_12 == 0 ) && ( nRcdDeleted_12 == 0 ) )
            {
               if ( RcdFound12 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0B12( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0B12( ) ;
                     closeExtendedTableCursors0B12( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                     O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
                     O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
                     O90ComprasTotalExento = A90ComprasTotalExento ;
                     httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
                     O88ComprasTotal10 = A88ComprasTotal10 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
                     O86ComprasTotal5 = A86ComprasTotal5 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
                     O225ComprasTotalIva = A225ComprasTotalIva ;
                     httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
                     O229ComprasTotal = A229ComprasTotal ;
                     httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
                  }
               }
               else
               {
                  GXCCtl = "COMPRASDETALLEID_" + sGXsfl_80_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtComprasDetalleId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound12 != 0 )
               {
                  if ( nRcdDeleted_12 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0B12( ) ;
                     load0B12( ) ;
                     beforeValidate0B12( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0B12( ) ;
                        O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
                        O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
                        O90ComprasTotalExento = A90ComprasTotalExento ;
                        httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
                        O88ComprasTotal10 = A88ComprasTotal10 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
                        O86ComprasTotal5 = A86ComprasTotal5 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
                        O225ComprasTotalIva = A225ComprasTotalIva ;
                        httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
                        O229ComprasTotal = A229ComprasTotal ;
                        httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
                     }
                  }
                  else
                  {
                     if ( nIsMod_12 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0B12( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0B12( ) ;
                           closeExtendedTableCursors0B12( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                           O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
                           O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
                           O90ComprasTotalExento = A90ComprasTotalExento ;
                           httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
                           O88ComprasTotal10 = A88ComprasTotal10 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
                           O86ComprasTotal5 = A86ComprasTotal5 ;
                           httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
                           O225ComprasTotalIva = A225ComprasTotalIva ;
                           httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
                           O229ComprasTotal = A229ComprasTotal ;
                           httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_12 == 0 )
                  {
                     GXCCtl = "COMPRASDETALLEID_" + sGXsfl_80_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtComprasDetalleId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtComprasDetalleId_Internalname, GXutil.ltrim( localUtil.ntoc( A12ComprasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A75ComprasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A82ComprasCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetallePrecioCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A80ComprasDetallePrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleExento_Internalname, GXutil.ltrim( localUtil.ntoc( A81ComprasDetalleExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A85ComprasDetalleIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A84ComprasDetalleIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynComprasDetalleTallaID.getInternalname(), GXutil.ltrim( localUtil.ntoc( A291ComprasDetalleTallaID, (byte)(11), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z12ComprasDetalleId_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z12ComprasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z75ComprasDetalleCantidad_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z75ComprasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z82ComprasCantidad_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z82ComprasCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z80ComprasDetallePrecioCompra_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z80ComprasDetallePrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z291ComprasDetalleTallaID_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z291ComprasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T84ComprasDetalleIva10_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( O84ComprasDetalleIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T85ComprasDetalleIva5_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( O85ComprasDetalleIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T81ComprasDetalleExento_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( O81ComprasDetalleExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_12_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_12_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_12_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_12 != 0 )
         {
            httpContext.changePostValue( "COMPRASDETALLEID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLECANTIDAD_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "IMPUESTOPORCENTAJE_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASCANTIDAD_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetallePrecioCompra_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEEXENTO_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEIVA5_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEIVA10_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLETALLAID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynComprasDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      O89ComprasTotalIva10 = s89ComprasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      O87ComprasTotalIva5 = s87ComprasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      O90ComprasTotalExento = s90ComprasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      O88ComprasTotal10 = s88ComprasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      O86ComprasTotal5 = s86ComprasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      O225ComprasTotalIva = s225ComprasTotalIva ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      O229ComprasTotal = s229ComprasTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0B0( )
   {
   }

   public void e110B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV15Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV16GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         while ( AV16GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV16GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ProveedorId") == 0 )
            {
               AV13Insert_ProveedorId = GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_ProveedorId), 11, 0));
            }
            AV16GXV1 = (int)(AV16GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         }
      }
   }

   public void e120B2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         new com.mujermorena.stockcompras(remoteHandle, context).execute( A11ComprasId) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.comprasww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0B11( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z74ComprasFecha = T000B7_A74ComprasFecha[0] ;
            Z226ComprasTimbrado = T000B7_A226ComprasTimbrado[0] ;
            Z227ComprasNumeroFactura = T000B7_A227ComprasNumeroFactura[0] ;
            Z10ProveedorId = T000B7_A10ProveedorId[0] ;
         }
         else
         {
            Z74ComprasFecha = A74ComprasFecha ;
            Z226ComprasTimbrado = A226ComprasTimbrado ;
            Z227ComprasNumeroFactura = A227ComprasNumeroFactura ;
            Z10ProveedorId = A10ProveedorId ;
         }
      }
      if ( GX_JID == -28 )
      {
         Z11ComprasId = A11ComprasId ;
         Z74ComprasFecha = A74ComprasFecha ;
         Z226ComprasTimbrado = A226ComprasTimbrado ;
         Z227ComprasNumeroFactura = A227ComprasNumeroFactura ;
         Z10ProveedorId = A10ProveedorId ;
         Z90ComprasTotalExento = A90ComprasTotalExento ;
         Z87ComprasTotalIva5 = A87ComprasTotalIva5 ;
         Z89ComprasTotalIva10 = A89ComprasTotalIva10 ;
      }
   }

   public void standaloneNotModal( )
   {
      edtComprasId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasId_Enabled), 5, 0), true);
      edtComprasFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasFecha_Enabled), 5, 0), true);
      AV15Pgmname = "Compras" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      imgprompt_10_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.proveedorprompt"+"',["+"{Ctrl:gx.dom.el('"+"PROVEEDORID"+"'), id:'"+"PROVEEDORID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtComprasId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasId_Enabled), 5, 0), true);
      edtComprasFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasFecha_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7ComprasId) )
      {
         A11ComprasId = AV7ComprasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A11ComprasId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
            compras_impl.this.GXt_int2 = GXv_int3[0] ;
            A11ComprasId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_ProveedorId) )
      {
         edtProveedorId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
      }
      else
      {
         edtProveedorId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         A74ComprasFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_ProveedorId) )
      {
         A10ProveedorId = AV13Insert_ProveedorId ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
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
         /* Using cursor T000B10 */
         pr_default.execute(7, new Object[] {Long.valueOf(A11ComprasId)});
         if ( (pr_default.getStatus(7) != 101) )
         {
            A90ComprasTotalExento = T000B10_A90ComprasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A87ComprasTotalIva5 = T000B10_A87ComprasTotalIva5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            A89ComprasTotalIva10 = T000B10_A89ComprasTotalIva10[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         else
         {
            A90ComprasTotalExento = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A87ComprasTotalIva5 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            A89ComprasTotalIva10 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         O90ComprasTotalExento = A90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         pr_default.close(7);
         A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
         A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      }
   }

   public void load0B11( )
   {
      /* Using cursor T000B12 */
      pr_default.execute(8, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A74ComprasFecha = T000B12_A74ComprasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
         A226ComprasTimbrado = T000B12_A226ComprasTimbrado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
         A227ComprasNumeroFactura = T000B12_A227ComprasNumeroFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
         A10ProveedorId = T000B12_A10ProveedorId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
         A90ComprasTotalExento = T000B12_A90ComprasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A87ComprasTotalIva5 = T000B12_A87ComprasTotalIva5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A89ComprasTotalIva10 = T000B12_A89ComprasTotalIva10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         zm0B11( -28) ;
      }
      pr_default.close(8);
      onLoadActions0B11( ) ;
   }

   public void onLoadActions0B11( )
   {
      O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      O90ComprasTotalExento = A90ComprasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
   }

   public void checkExtendedTable0B11( )
   {
      nIsDirty_11 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000B10 */
      pr_default.execute(7, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         A90ComprasTotalExento = T000B10_A90ComprasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A87ComprasTotalIva5 = T000B10_A87ComprasTotalIva5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A89ComprasTotalIva10 = T000B10_A89ComprasTotalIva10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      else
      {
         nIsDirty_11 = (short)(1) ;
         A90ComprasTotalExento = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         nIsDirty_11 = (short)(1) ;
         A87ComprasTotalIva5 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         nIsDirty_11 = (short)(1) ;
         A89ComprasTotalIva10 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      pr_default.close(7);
      nIsDirty_11 = (short)(1) ;
      A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      nIsDirty_11 = (short)(1) ;
      A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      nIsDirty_11 = (short)(1) ;
      A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      nIsDirty_11 = (short)(1) ;
      A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      /* Using cursor T000B8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Proveedor", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVEEDORID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0B11( )
   {
      pr_default.close(7);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_30( long A11ComprasId )
   {
      /* Using cursor T000B14 */
      pr_default.execute(9, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A90ComprasTotalExento = T000B14_A90ComprasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A87ComprasTotalIva5 = T000B14_A87ComprasTotalIva5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A89ComprasTotalIva10 = T000B14_A89ComprasTotalIva10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      else
      {
         A90ComprasTotalExento = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A87ComprasTotalIva5 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A89ComprasTotalIva10 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A90ComprasTotalExento, (byte)(17), (byte)(2), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A87ComprasTotalIva5, (byte)(17), (byte)(2), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A89ComprasTotalIva10, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_29( long A10ProveedorId )
   {
      /* Using cursor T000B15 */
      pr_default.execute(10, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Proveedor", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVEEDORID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void getKey0B11( )
   {
      /* Using cursor T000B16 */
      pr_default.execute(11, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound11 = (short)(1) ;
      }
      else
      {
         RcdFound11 = (short)(0) ;
      }
      pr_default.close(11);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000B7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm0B11( 28) ;
         RcdFound11 = (short)(1) ;
         A11ComprasId = T000B7_A11ComprasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
         A74ComprasFecha = T000B7_A74ComprasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
         A226ComprasTimbrado = T000B7_A226ComprasTimbrado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
         A227ComprasNumeroFactura = T000B7_A227ComprasNumeroFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
         A10ProveedorId = T000B7_A10ProveedorId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
         Z11ComprasId = A11ComprasId ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0B11( ) ;
         if ( AnyError == 1 )
         {
            RcdFound11 = (short)(0) ;
            initializeNonKey0B11( ) ;
         }
         Gx_mode = sMode11 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound11 = (short)(0) ;
         initializeNonKey0B11( ) ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode11 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(5);
   }

   public void getEqualNoModal( )
   {
      getKey0B11( ) ;
      if ( RcdFound11 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound11 = (short)(0) ;
      /* Using cursor T000B17 */
      pr_default.execute(12, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         while ( (pr_default.getStatus(12) != 101) && ( ( T000B17_A11ComprasId[0] < A11ComprasId ) ) )
         {
            pr_default.readNext(12);
         }
         if ( (pr_default.getStatus(12) != 101) && ( ( T000B17_A11ComprasId[0] > A11ComprasId ) ) )
         {
            A11ComprasId = T000B17_A11ComprasId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
            RcdFound11 = (short)(1) ;
         }
      }
      pr_default.close(12);
   }

   public void move_previous( )
   {
      RcdFound11 = (short)(0) ;
      /* Using cursor T000B18 */
      pr_default.execute(13, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T000B18_A11ComprasId[0] > A11ComprasId ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T000B18_A11ComprasId[0] < A11ComprasId ) ) )
         {
            A11ComprasId = T000B18_A11ComprasId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
            RcdFound11 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0B11( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A90ComprasTotalExento = O90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A88ComprasTotal10 = O88ComprasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
         A86ComprasTotal5 = O86ComprasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         A225ComprasTotalIva = O225ComprasTotalIva ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         A229ComprasTotal = O229ComprasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0B11( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound11 == 1 )
         {
            if ( A11ComprasId != Z11ComprasId )
            {
               A11ComprasId = Z11ComprasId ;
               httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "COMPRASID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtComprasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
               A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
               A90ComprasTotalExento = O90ComprasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
               A88ComprasTotal10 = O88ComprasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
               A86ComprasTotal5 = O86ComprasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
               A225ComprasTotalIva = O225ComprasTotalIva ;
               httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
               A229ComprasTotal = O229ComprasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
               A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
               A90ComprasTotalExento = O90ComprasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
               A88ComprasTotal10 = O88ComprasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
               A86ComprasTotal5 = O86ComprasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
               A225ComprasTotalIva = O225ComprasTotalIva ;
               httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
               A229ComprasTotal = O229ComprasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
               update0B11( ) ;
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A11ComprasId != Z11ComprasId )
            {
               /* Insert record */
               A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
               A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
               A90ComprasTotalExento = O90ComprasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
               A88ComprasTotal10 = O88ComprasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
               A86ComprasTotal5 = O86ComprasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
               A225ComprasTotalIva = O225ComprasTotalIva ;
               httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
               A229ComprasTotal = O229ComprasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0B11( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "COMPRASID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtComprasId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
                  A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
                  A90ComprasTotalExento = O90ComprasTotalExento ;
                  httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
                  A88ComprasTotal10 = O88ComprasTotal10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
                  A86ComprasTotal5 = O86ComprasTotal5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
                  A225ComprasTotalIva = O225ComprasTotalIva ;
                  httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
                  A229ComprasTotal = O229ComprasTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
                  GX_FocusControl = edtProveedorId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0B11( ) ;
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
      if ( A11ComprasId != Z11ComprasId )
      {
         A11ComprasId = Z11ComprasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "COMPRASID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtComprasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A90ComprasTotalExento = O90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A88ComprasTotal10 = O88ComprasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
         A86ComprasTotal5 = O86ComprasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         A225ComprasTotalIva = O225ComprasTotalIva ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         A229ComprasTotal = O229ComprasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0B11( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000B6 */
         pr_default.execute(4, new Object[] {Long.valueOf(A11ComprasId)});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Compras"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(4) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z74ComprasFecha), GXutil.resetTime(T000B6_A74ComprasFecha[0])) ) || ( Z226ComprasTimbrado != T000B6_A226ComprasTimbrado[0] ) || ( Z227ComprasNumeroFactura != T000B6_A227ComprasNumeroFactura[0] ) || ( Z10ProveedorId != T000B6_A10ProveedorId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z74ComprasFecha), GXutil.resetTime(T000B6_A74ComprasFecha[0])) ) )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasFecha");
               GXutil.writeLogRaw("Old: ",Z74ComprasFecha);
               GXutil.writeLogRaw("Current: ",T000B6_A74ComprasFecha[0]);
            }
            if ( Z226ComprasTimbrado != T000B6_A226ComprasTimbrado[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasTimbrado");
               GXutil.writeLogRaw("Old: ",Z226ComprasTimbrado);
               GXutil.writeLogRaw("Current: ",T000B6_A226ComprasTimbrado[0]);
            }
            if ( Z227ComprasNumeroFactura != T000B6_A227ComprasNumeroFactura[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasNumeroFactura");
               GXutil.writeLogRaw("Old: ",Z227ComprasNumeroFactura);
               GXutil.writeLogRaw("Current: ",T000B6_A227ComprasNumeroFactura[0]);
            }
            if ( Z10ProveedorId != T000B6_A10ProveedorId[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ProveedorId");
               GXutil.writeLogRaw("Old: ",Z10ProveedorId);
               GXutil.writeLogRaw("Current: ",T000B6_A10ProveedorId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Compras"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0B11( )
   {
      if ( ! IsAuthorized("compras_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0B11( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B11( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0B11( 0) ;
         checkOptimisticConcurrency0B11( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B11( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0B11( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000B19 */
                  pr_default.execute(14, new Object[] {Long.valueOf(A11ComprasId), A74ComprasFecha, Long.valueOf(A226ComprasTimbrado), Long.valueOf(A227ComprasNumeroFactura), Long.valueOf(A10ProveedorId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Compras");
                  if ( (pr_default.getStatus(14) == 1) )
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
                        processLevel0B11( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0B0( ) ;
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
            load0B11( ) ;
         }
         endLevel0B11( ) ;
      }
      closeExtendedTableCursors0B11( ) ;
   }

   public void update0B11( )
   {
      if ( ! IsAuthorized("compras_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0B11( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B11( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B11( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B11( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0B11( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000B20 */
                  pr_default.execute(15, new Object[] {A74ComprasFecha, Long.valueOf(A226ComprasTimbrado), Long.valueOf(A227ComprasNumeroFactura), Long.valueOf(A10ProveedorId), Long.valueOf(A11ComprasId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Compras");
                  if ( (pr_default.getStatus(15) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Compras"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0B11( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0B11( ) ;
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
         endLevel0B11( ) ;
      }
      closeExtendedTableCursors0B11( ) ;
   }

   public void deferredUpdate0B11( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("compras_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0B11( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B11( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0B11( ) ;
         afterConfirm0B11( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0B11( ) ;
            if ( AnyError == 0 )
            {
               A89ComprasTotalIva10 = O89ComprasTotalIva10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
               A87ComprasTotalIva5 = O87ComprasTotalIva5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
               A90ComprasTotalExento = O90ComprasTotalExento ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
               A88ComprasTotal10 = O88ComprasTotal10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
               A86ComprasTotal5 = O86ComprasTotal5 ;
               httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
               A225ComprasTotalIva = O225ComprasTotalIva ;
               httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
               A229ComprasTotal = O229ComprasTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
               scanStart0B12( ) ;
               while ( RcdFound12 != 0 )
               {
                  getByPrimaryKey0B12( ) ;
                  delete0B12( ) ;
                  scanNext0B12( ) ;
                  O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
                  O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
                  O90ComprasTotalExento = A90ComprasTotalExento ;
                  httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
                  O88ComprasTotal10 = A88ComprasTotal10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
                  O86ComprasTotal5 = A86ComprasTotal5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
                  O225ComprasTotalIva = A225ComprasTotalIva ;
                  httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
                  O229ComprasTotal = A229ComprasTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
               }
               scanEnd0B12( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000B21 */
                  pr_default.execute(16, new Object[] {Long.valueOf(A11ComprasId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Compras");
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
      sMode11 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0B11( ) ;
      Gx_mode = sMode11 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0B11( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000B23 */
         pr_default.execute(17, new Object[] {Long.valueOf(A11ComprasId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            A90ComprasTotalExento = T000B23_A90ComprasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A87ComprasTotalIva5 = T000B23_A87ComprasTotalIva5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            A89ComprasTotalIva10 = T000B23_A89ComprasTotalIva10[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         else
         {
            A90ComprasTotalExento = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A87ComprasTotalIva5 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            A89ComprasTotalIva10 = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         pr_default.close(17);
         A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
         A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      }
   }

   public void processNestedLevel0B12( )
   {
      s89ComprasTotalIva10 = O89ComprasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      s87ComprasTotalIva5 = O87ComprasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      s90ComprasTotalExento = O90ComprasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      s88ComprasTotal10 = O88ComprasTotal10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      s86ComprasTotal5 = O86ComprasTotal5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      s225ComprasTotalIva = O225ComprasTotalIva ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      s229ComprasTotal = O229ComprasTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      nGXsfl_80_idx = 0 ;
      while ( nGXsfl_80_idx < nRC_GXsfl_80 )
      {
         readRow0B12( ) ;
         if ( ( nRcdExists_12 != 0 ) || ( nIsMod_12 != 0 ) )
         {
            standaloneNotModal0B12( ) ;
            getKey0B12( ) ;
            if ( ( nRcdExists_12 == 0 ) && ( nRcdDeleted_12 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0B12( ) ;
            }
            else
            {
               if ( RcdFound12 != 0 )
               {
                  if ( ( nRcdDeleted_12 != 0 ) && ( nRcdExists_12 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0B12( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_12 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0B12( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_12 == 0 )
                  {
                     GXCCtl = "COMPRASDETALLEID_" + sGXsfl_80_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtComprasDetalleId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
            O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            O90ComprasTotalExento = A90ComprasTotalExento ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            O88ComprasTotal10 = A88ComprasTotal10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
            O86ComprasTotal5 = A86ComprasTotal5 ;
            httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
            O225ComprasTotalIva = A225ComprasTotalIva ;
            httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
            O229ComprasTotal = A229ComprasTotal ;
            httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
         }
         httpContext.changePostValue( edtComprasDetalleId_Internalname, GXutil.ltrim( localUtil.ntoc( A12ComprasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A75ComprasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A82ComprasCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetallePrecioCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A80ComprasDetallePrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleExento_Internalname, GXutil.ltrim( localUtil.ntoc( A81ComprasDetalleExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A85ComprasDetalleIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtComprasDetalleIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A84ComprasDetalleIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynComprasDetalleTallaID.getInternalname(), GXutil.ltrim( localUtil.ntoc( A291ComprasDetalleTallaID, (byte)(11), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z12ComprasDetalleId_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z12ComprasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z75ComprasDetalleCantidad_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z75ComprasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z82ComprasCantidad_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z82ComprasCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z80ComprasDetallePrecioCompra_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z80ComprasDetallePrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z291ComprasDetalleTallaID_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z291ComprasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T84ComprasDetalleIva10_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( O84ComprasDetalleIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T85ComprasDetalleIva5_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( O85ComprasDetalleIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T81ComprasDetalleExento_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( O81ComprasDetalleExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_12_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_12_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_12_"+sGXsfl_80_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_12 != 0 )
         {
            httpContext.changePostValue( "COMPRASDETALLEID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLECANTIDAD_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "IMPUESTOPORCENTAJE_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASCANTIDAD_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetallePrecioCompra_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEEXENTO_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEIVA5_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLEIVA10_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COMPRASDETALLETALLAID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynComprasDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0B12( ) ;
      if ( AnyError != 0 )
      {
         O89ComprasTotalIva10 = s89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         O87ComprasTotalIva5 = s87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         O90ComprasTotalExento = s90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         O88ComprasTotal10 = s88ComprasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
         O86ComprasTotal5 = s86ComprasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         O225ComprasTotalIva = s225ComprasTotalIva ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         O229ComprasTotal = s229ComprasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      }
      nRcdExists_12 = (short)(0) ;
      nIsMod_12 = (short)(0) ;
      nRcdDeleted_12 = (short)(0) ;
   }

   public void processLevel0B11( )
   {
      /* Save parent mode. */
      sMode11 = Gx_mode ;
      processNestedLevel0B12( ) ;
      if ( AnyError != 0 )
      {
         O89ComprasTotalIva10 = s89ComprasTotalIva10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         O87ComprasTotalIva5 = s87ComprasTotalIva5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         O90ComprasTotalExento = s90ComprasTotalExento ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         O88ComprasTotal10 = s88ComprasTotal10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
         O86ComprasTotal5 = s86ComprasTotal5 ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         O225ComprasTotalIva = s225ComprasTotalIva ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         O229ComprasTotal = s229ComprasTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      }
      /* Restore parent mode. */
      Gx_mode = sMode11 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0B11( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0B11( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(17);
         pr_default.close(2);
         pr_default.close(3);
         Application.commitDataStores(context, remoteHandle, pr_default, "compras");
         if ( AnyError == 0 )
         {
            confirmValues0B0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(17);
         pr_default.close(2);
         pr_default.close(3);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "compras");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0B11( )
   {
      /* Scan By routine */
      /* Using cursor T000B24 */
      pr_default.execute(18);
      RcdFound11 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A11ComprasId = T000B24_A11ComprasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0B11( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound11 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A11ComprasId = T000B24_A11ComprasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      }
   }

   public void scanEnd0B11( )
   {
      pr_default.close(18);
   }

   public void afterConfirm0B11( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0B11( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0B11( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0B11( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0B11( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0B11( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0B11( )
   {
      edtComprasId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasId_Enabled), 5, 0), true);
      edtComprasFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasFecha_Enabled), 5, 0), true);
      edtProveedorId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
      edtComprasTimbrado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTimbrado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTimbrado_Enabled), 5, 0), true);
      edtComprasNumeroFactura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasNumeroFactura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasNumeroFactura_Enabled), 5, 0), true);
      edtComprasTotalExento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotalExento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotalExento_Enabled), 5, 0), true);
      edtComprasTotalIva5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotalIva5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotalIva5_Enabled), 5, 0), true);
      edtComprasTotalIva10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotalIva10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotalIva10_Enabled), 5, 0), true);
      edtComprasTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotal_Enabled), 5, 0), true);
      edtComprasTotal5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotal5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotal5_Enabled), 5, 0), true);
      edtComprasTotal10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotal10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotal10_Enabled), 5, 0), true);
      edtComprasTotalIva_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasTotalIva_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasTotalIva_Enabled), 5, 0), true);
   }

   public void zm0B12( int GX_JID )
   {
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z75ComprasDetalleCantidad = T000B3_A75ComprasDetalleCantidad[0] ;
            Z82ComprasCantidad = T000B3_A82ComprasCantidad[0] ;
            Z80ComprasDetallePrecioCompra = T000B3_A80ComprasDetallePrecioCompra[0] ;
            Z291ComprasDetalleTallaID = T000B3_A291ComprasDetalleTallaID[0] ;
            Z13ArticuloId = T000B3_A13ArticuloId[0] ;
         }
         else
         {
            Z75ComprasDetalleCantidad = A75ComprasDetalleCantidad ;
            Z82ComprasCantidad = A82ComprasCantidad ;
            Z80ComprasDetallePrecioCompra = A80ComprasDetallePrecioCompra ;
            Z291ComprasDetalleTallaID = A291ComprasDetalleTallaID ;
            Z13ArticuloId = A13ArticuloId ;
         }
      }
      if ( GX_JID == -31 )
      {
         Z11ComprasId = A11ComprasId ;
         Z12ComprasDetalleId = A12ComprasDetalleId ;
         Z75ComprasDetalleCantidad = A75ComprasDetalleCantidad ;
         Z82ComprasCantidad = A82ComprasCantidad ;
         Z80ComprasDetallePrecioCompra = A80ComprasDetallePrecioCompra ;
         Z291ComprasDetalleTallaID = A291ComprasDetalleTallaID ;
         Z13ArticuloId = A13ArticuloId ;
         Z18ImpuestoId = A18ImpuestoId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
         Z83ImpuestoPorcentaje = A83ImpuestoPorcentaje ;
      }
   }

   public void standaloneNotModal0B12( )
   {
      edtComprasDetalleCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleCantidad_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A12ComprasDetalleId ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
         compras_impl.this.GXt_int2 = GXv_int3[0] ;
         A12ComprasDetalleId = GXt_int2 ;
      }
   }

   public void standaloneModal0B12( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtComprasDetalleId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      }
      else
      {
         edtComprasDetalleId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      }
   }

   public void load0B12( )
   {
      /* Using cursor T000B25 */
      pr_default.execute(19, new Object[] {Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A18ImpuestoId = T000B25_A18ImpuestoId[0] ;
         A75ComprasDetalleCantidad = T000B25_A75ComprasDetalleCantidad[0] ;
         A76ArticuloNombre = T000B25_A76ArticuloNombre[0] ;
         A83ImpuestoPorcentaje = T000B25_A83ImpuestoPorcentaje[0] ;
         A82ComprasCantidad = T000B25_A82ComprasCantidad[0] ;
         A80ComprasDetallePrecioCompra = T000B25_A80ComprasDetallePrecioCompra[0] ;
         A291ComprasDetalleTallaID = T000B25_A291ComprasDetalleTallaID[0] ;
         A13ArticuloId = T000B25_A13ArticuloId[0] ;
         zm0B12( -31) ;
      }
      pr_default.close(19);
      onLoadActions0B12( ) ;
   }

   public void onLoadActions0B12( )
   {
      if ( A83ImpuestoPorcentaje.doubleValue() == 5 )
      {
         A85ComprasDetalleIva5 = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
      }
      else
      {
         A85ComprasDetalleIva5 = DecimalUtil.doubleToDec(0) ;
      }
      O85ComprasDetalleIva5 = A85ComprasDetalleIva5 ;
      if ( isIns( )  )
      {
         A87ComprasTotalIva5 = O87ComprasTotalIva5.add(A85ComprasDetalleIva5) ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A87ComprasTotalIva5 = O87ComprasTotalIva5.add(A85ComprasDetalleIva5).subtract(O85ComprasDetalleIva5) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A87ComprasTotalIva5 = O87ComprasTotalIva5.subtract(O85ComprasDetalleIva5) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            }
         }
      }
      A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 10 )
      {
         A84ComprasDetalleIva10 = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
      }
      else
      {
         A84ComprasDetalleIva10 = DecimalUtil.doubleToDec(0) ;
      }
      O84ComprasDetalleIva10 = A84ComprasDetalleIva10 ;
      if ( isIns( )  )
      {
         A89ComprasTotalIva10 = O89ComprasTotalIva10.add(A84ComprasDetalleIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A89ComprasTotalIva10 = O89ComprasTotalIva10.add(A84ComprasDetalleIva10).subtract(O84ComprasDetalleIva10) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A89ComprasTotalIva10 = O89ComprasTotalIva10.subtract(O84ComprasDetalleIva10) ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            }
         }
      }
      A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 0 )
      {
         A81ComprasDetalleExento = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
      }
      else
      {
         A81ComprasDetalleExento = DecimalUtil.doubleToDec(0) ;
      }
      O81ComprasDetalleExento = A81ComprasDetalleExento ;
      if ( isIns( )  )
      {
         A90ComprasTotalExento = O90ComprasTotalExento.add(A81ComprasDetalleExento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A90ComprasTotalExento = O90ComprasTotalExento.add(A81ComprasDetalleExento).subtract(O81ComprasDetalleExento) ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A90ComprasTotalExento = O90ComprasTotalExento.subtract(O81ComprasDetalleExento) ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            }
         }
      }
      A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
   }

   public void checkExtendedTable0B12( )
   {
      nIsDirty_12 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0B12( ) ;
      /* Using cursor T000B4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18ImpuestoId = T000B4_A18ImpuestoId[0] ;
      A76ArticuloNombre = T000B4_A76ArticuloNombre[0] ;
      pr_default.close(2);
      /* Using cursor T000B5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T000B5_A83ImpuestoPorcentaje[0] ;
      pr_default.close(3);
      if ( A83ImpuestoPorcentaje.doubleValue() == 5 )
      {
         nIsDirty_12 = (short)(1) ;
         A85ComprasDetalleIva5 = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
      }
      else
      {
         nIsDirty_12 = (short)(1) ;
         A85ComprasDetalleIva5 = DecimalUtil.doubleToDec(0) ;
      }
      if ( isIns( )  )
      {
         nIsDirty_12 = (short)(1) ;
         A87ComprasTotalIva5 = O87ComprasTotalIva5.add(A85ComprasDetalleIva5) ;
         httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_12 = (short)(1) ;
            A87ComprasTotalIva5 = O87ComprasTotalIva5.add(A85ComprasDetalleIva5).subtract(O85ComprasDetalleIva5) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_12 = (short)(1) ;
               A87ComprasTotalIva5 = O87ComprasTotalIva5.subtract(O85ComprasDetalleIva5) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            }
         }
      }
      nIsDirty_12 = (short)(1) ;
      A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 10 )
      {
         nIsDirty_12 = (short)(1) ;
         A84ComprasDetalleIva10 = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
      }
      else
      {
         nIsDirty_12 = (short)(1) ;
         A84ComprasDetalleIva10 = DecimalUtil.doubleToDec(0) ;
      }
      if ( isIns( )  )
      {
         nIsDirty_12 = (short)(1) ;
         A89ComprasTotalIva10 = O89ComprasTotalIva10.add(A84ComprasDetalleIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_12 = (short)(1) ;
            A89ComprasTotalIva10 = O89ComprasTotalIva10.add(A84ComprasDetalleIva10).subtract(O84ComprasDetalleIva10) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_12 = (short)(1) ;
               A89ComprasTotalIva10 = O89ComprasTotalIva10.subtract(O84ComprasDetalleIva10) ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            }
         }
      }
      nIsDirty_12 = (short)(1) ;
      A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      nIsDirty_12 = (short)(1) ;
      A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      if ( A83ImpuestoPorcentaje.doubleValue() == 0 )
      {
         nIsDirty_12 = (short)(1) ;
         A81ComprasDetalleExento = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
      }
      else
      {
         nIsDirty_12 = (short)(1) ;
         A81ComprasDetalleExento = DecimalUtil.doubleToDec(0) ;
      }
      if ( isIns( )  )
      {
         nIsDirty_12 = (short)(1) ;
         A90ComprasTotalExento = O90ComprasTotalExento.add(A81ComprasDetalleExento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_12 = (short)(1) ;
            A90ComprasTotalExento = O90ComprasTotalExento.add(A81ComprasDetalleExento).subtract(O81ComprasDetalleExento) ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_12 = (short)(1) ;
               A90ComprasTotalExento = O90ComprasTotalExento.subtract(O81ComprasDetalleExento) ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            }
         }
      }
      nIsDirty_12 = (short)(1) ;
      A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      if ( (0==A82ComprasCantidad) )
      {
         GXCCtl = "COMPRASCANTIDAD_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Compras Cantidad", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtComprasCantidad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A80ComprasDetallePrecioCompra)==0) )
      {
         GXCCtl = "COMPRASDETALLEPRECIOCOMPRA_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Compras Detalle Precio Compra", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtComprasDetallePrecioCompra_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0B12( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable0B12( )
   {
   }

   public void gxload_32( long A13ArticuloId )
   {
      /* Using cursor T000B26 */
      pr_default.execute(20, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18ImpuestoId = T000B26_A18ImpuestoId[0] ;
      A76ArticuloNombre = T000B26_A76ArticuloNombre[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A76ArticuloNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(20) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(20);
   }

   public void gxload_33( long A18ImpuestoId )
   {
      /* Using cursor T000B27 */
      pr_default.execute(21, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T000B27_A83ImpuestoPorcentaje[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(21) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(21);
   }

   public void getKey0B12( )
   {
      /* Using cursor T000B28 */
      pr_default.execute(22, new Object[] {Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId)});
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound12 = (short)(1) ;
      }
      else
      {
         RcdFound12 = (short)(0) ;
      }
      pr_default.close(22);
   }

   public void getByPrimaryKey0B12( )
   {
      /* Using cursor T000B3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0B12( 31) ;
         RcdFound12 = (short)(1) ;
         initializeNonKey0B12( ) ;
         A12ComprasDetalleId = T000B3_A12ComprasDetalleId[0] ;
         A75ComprasDetalleCantidad = T000B3_A75ComprasDetalleCantidad[0] ;
         A82ComprasCantidad = T000B3_A82ComprasCantidad[0] ;
         A80ComprasDetallePrecioCompra = T000B3_A80ComprasDetallePrecioCompra[0] ;
         A291ComprasDetalleTallaID = T000B3_A291ComprasDetalleTallaID[0] ;
         A13ArticuloId = T000B3_A13ArticuloId[0] ;
         Z11ComprasId = A11ComprasId ;
         Z12ComprasDetalleId = A12ComprasDetalleId ;
         sMode12 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0B12( ) ;
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound12 = (short)(0) ;
         initializeNonKey0B12( ) ;
         sMode12 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0B12( ) ;
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0B12( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0B12( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000B2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ComprasDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z75ComprasDetalleCantidad != T000B2_A75ComprasDetalleCantidad[0] ) || ( Z82ComprasCantidad != T000B2_A82ComprasCantidad[0] ) || ( DecimalUtil.compareTo(Z80ComprasDetallePrecioCompra, T000B2_A80ComprasDetallePrecioCompra[0]) != 0 ) || ( Z291ComprasDetalleTallaID != T000B2_A291ComprasDetalleTallaID[0] ) || ( Z13ArticuloId != T000B2_A13ArticuloId[0] ) )
         {
            if ( Z75ComprasDetalleCantidad != T000B2_A75ComprasDetalleCantidad[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasDetalleCantidad");
               GXutil.writeLogRaw("Old: ",Z75ComprasDetalleCantidad);
               GXutil.writeLogRaw("Current: ",T000B2_A75ComprasDetalleCantidad[0]);
            }
            if ( Z82ComprasCantidad != T000B2_A82ComprasCantidad[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasCantidad");
               GXutil.writeLogRaw("Old: ",Z82ComprasCantidad);
               GXutil.writeLogRaw("Current: ",T000B2_A82ComprasCantidad[0]);
            }
            if ( DecimalUtil.compareTo(Z80ComprasDetallePrecioCompra, T000B2_A80ComprasDetallePrecioCompra[0]) != 0 )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasDetallePrecioCompra");
               GXutil.writeLogRaw("Old: ",Z80ComprasDetallePrecioCompra);
               GXutil.writeLogRaw("Current: ",T000B2_A80ComprasDetallePrecioCompra[0]);
            }
            if ( Z291ComprasDetalleTallaID != T000B2_A291ComprasDetalleTallaID[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ComprasDetalleTallaID");
               GXutil.writeLogRaw("Old: ",Z291ComprasDetalleTallaID);
               GXutil.writeLogRaw("Current: ",T000B2_A291ComprasDetalleTallaID[0]);
            }
            if ( Z13ArticuloId != T000B2_A13ArticuloId[0] )
            {
               GXutil.writeLogln("compras:[seudo value changed for attri]"+"ArticuloId");
               GXutil.writeLogRaw("Old: ",Z13ArticuloId);
               GXutil.writeLogRaw("Current: ",T000B2_A13ArticuloId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ComprasDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0B12( )
   {
      if ( ! IsAuthorized("compras_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0B12( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B12( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0B12( 0) ;
         checkOptimisticConcurrency0B12( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B12( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0B12( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000B29 */
                  pr_default.execute(23, new Object[] {Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId), Integer.valueOf(A75ComprasDetalleCantidad), Integer.valueOf(A82ComprasCantidad), A80ComprasDetallePrecioCompra, Long.valueOf(A291ComprasDetalleTallaID), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ComprasDetalle");
                  if ( (pr_default.getStatus(23) == 1) )
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
            load0B12( ) ;
         }
         endLevel0B12( ) ;
      }
      closeExtendedTableCursors0B12( ) ;
   }

   public void update0B12( )
   {
      if ( ! IsAuthorized("compras_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0B12( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B12( ) ;
      }
      if ( ( nIsMod_12 != 0 ) || ( nIsDirty_12 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0B12( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0B12( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0B12( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000B30 */
                     pr_default.execute(24, new Object[] {Integer.valueOf(A75ComprasDetalleCantidad), Integer.valueOf(A82ComprasCantidad), A80ComprasDetallePrecioCompra, Long.valueOf(A291ComprasDetalleTallaID), Long.valueOf(A13ArticuloId), Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ComprasDetalle");
                     if ( (pr_default.getStatus(24) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ComprasDetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0B12( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0B12( ) ;
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
            endLevel0B12( ) ;
         }
      }
      closeExtendedTableCursors0B12( ) ;
   }

   public void deferredUpdate0B12( )
   {
   }

   public void delete0B12( )
   {
      if ( ! IsAuthorized("compras_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0B12( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B12( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0B12( ) ;
         afterConfirm0B12( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0B12( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000B31 */
               pr_default.execute(25, new Object[] {Long.valueOf(A11ComprasId), Long.valueOf(A12ComprasDetalleId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ComprasDetalle");
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
      sMode12 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0B12( ) ;
      Gx_mode = sMode12 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0B12( )
   {
      standaloneModal0B12( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000B32 */
         pr_default.execute(26, new Object[] {Long.valueOf(A13ArticuloId)});
         A18ImpuestoId = T000B32_A18ImpuestoId[0] ;
         A76ArticuloNombre = T000B32_A76ArticuloNombre[0] ;
         pr_default.close(26);
         /* Using cursor T000B33 */
         pr_default.execute(27, new Object[] {Long.valueOf(A18ImpuestoId)});
         A83ImpuestoPorcentaje = T000B33_A83ImpuestoPorcentaje[0] ;
         pr_default.close(27);
         if ( A83ImpuestoPorcentaje.doubleValue() == 5 )
         {
            A85ComprasDetalleIva5 = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
         }
         else
         {
            A85ComprasDetalleIva5 = DecimalUtil.doubleToDec(0) ;
         }
         if ( isIns( )  )
         {
            A87ComprasTotalIva5 = O87ComprasTotalIva5.add(A85ComprasDetalleIva5) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A87ComprasTotalIva5 = O87ComprasTotalIva5.add(A85ComprasDetalleIva5).subtract(O85ComprasDetalleIva5) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A87ComprasTotalIva5 = O87ComprasTotalIva5.subtract(O85ComprasDetalleIva5) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
               }
            }
         }
         A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         if ( A83ImpuestoPorcentaje.doubleValue() == 10 )
         {
            A84ComprasDetalleIva10 = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
         }
         else
         {
            A84ComprasDetalleIva10 = DecimalUtil.doubleToDec(0) ;
         }
         if ( isIns( )  )
         {
            A89ComprasTotalIva10 = O89ComprasTotalIva10.add(A84ComprasDetalleIva10) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A89ComprasTotalIva10 = O89ComprasTotalIva10.add(A84ComprasDetalleIva10).subtract(O84ComprasDetalleIva10) ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A89ComprasTotalIva10 = O89ComprasTotalIva10.subtract(O84ComprasDetalleIva10) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
               }
            }
         }
         A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
         A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
         if ( A83ImpuestoPorcentaje.doubleValue() == 0 )
         {
            A81ComprasDetalleExento = DecimalUtil.doubleToDec(A82ComprasCantidad).multiply(A80ComprasDetallePrecioCompra) ;
         }
         else
         {
            A81ComprasDetalleExento = DecimalUtil.doubleToDec(0) ;
         }
         if ( isIns( )  )
         {
            A90ComprasTotalExento = O90ComprasTotalExento.add(A81ComprasDetalleExento) ;
            httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A90ComprasTotalExento = O90ComprasTotalExento.add(A81ComprasDetalleExento).subtract(O81ComprasDetalleExento) ;
               httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A90ComprasTotalExento = O90ComprasTotalExento.subtract(O81ComprasDetalleExento) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
               }
            }
         }
         A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
         httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      }
   }

   public void endLevel0B12( )
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

   public void scanStart0B12( )
   {
      /* Scan By routine */
      /* Using cursor T000B34 */
      pr_default.execute(28, new Object[] {Long.valueOf(A11ComprasId)});
      RcdFound12 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A12ComprasDetalleId = T000B34_A12ComprasDetalleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0B12( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound12 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A12ComprasDetalleId = T000B34_A12ComprasDetalleId[0] ;
      }
   }

   public void scanEnd0B12( )
   {
      pr_default.close(28);
   }

   public void afterConfirm0B12( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0B12( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0B12( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0B12( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0B12( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0B12( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0B12( )
   {
      edtComprasDetalleId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasDetalleCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleCantidad_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtImpuestoPorcentaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasCantidad_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasDetallePrecioCompra_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetallePrecioCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetallePrecioCompra_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasDetalleExento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleExento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleExento_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasDetalleIva5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleIva5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleIva5_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasDetalleIva10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleIva10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleIva10_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      dynComprasDetalleTallaID.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynComprasDetalleTallaID.getInternalname(), "Enabled", GXutil.ltrimstr( dynComprasDetalleTallaID.getEnabled(), 5, 0), !bGXsfl_80_Refreshing);
   }

   public void send_integrity_lvl_hashes0B12( )
   {
   }

   public void send_integrity_lvl_hashes0B11( )
   {
   }

   public void subsflControlProps_8012( )
   {
      edtComprasDetalleId_Internalname = "COMPRASDETALLEID_"+sGXsfl_80_idx ;
      edtComprasDetalleCantidad_Internalname = "COMPRASDETALLECANTIDAD_"+sGXsfl_80_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_80_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_80_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_80_idx ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE_"+sGXsfl_80_idx ;
      edtComprasCantidad_Internalname = "COMPRASCANTIDAD_"+sGXsfl_80_idx ;
      edtComprasDetallePrecioCompra_Internalname = "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_idx ;
      edtComprasDetalleExento_Internalname = "COMPRASDETALLEEXENTO_"+sGXsfl_80_idx ;
      edtComprasDetalleIva5_Internalname = "COMPRASDETALLEIVA5_"+sGXsfl_80_idx ;
      edtComprasDetalleIva10_Internalname = "COMPRASDETALLEIVA10_"+sGXsfl_80_idx ;
      dynComprasDetalleTallaID.setInternalname( "COMPRASDETALLETALLAID_"+sGXsfl_80_idx );
   }

   public void subsflControlProps_fel_8012( )
   {
      edtComprasDetalleId_Internalname = "COMPRASDETALLEID_"+sGXsfl_80_fel_idx ;
      edtComprasDetalleCantidad_Internalname = "COMPRASDETALLECANTIDAD_"+sGXsfl_80_fel_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_80_fel_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_80_fel_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_80_fel_idx ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE_"+sGXsfl_80_fel_idx ;
      edtComprasCantidad_Internalname = "COMPRASCANTIDAD_"+sGXsfl_80_fel_idx ;
      edtComprasDetallePrecioCompra_Internalname = "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_fel_idx ;
      edtComprasDetalleExento_Internalname = "COMPRASDETALLEEXENTO_"+sGXsfl_80_fel_idx ;
      edtComprasDetalleIva5_Internalname = "COMPRASDETALLEIVA5_"+sGXsfl_80_fel_idx ;
      edtComprasDetalleIva10_Internalname = "COMPRASDETALLEIVA10_"+sGXsfl_80_fel_idx ;
      dynComprasDetalleTallaID.setInternalname( "COMPRASDETALLETALLAID_"+sGXsfl_80_fel_idx );
   }

   public void addRow0B12( )
   {
      nGXsfl_80_idx = (int)(nGXsfl_80_idx+1) ;
      sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_8012( ) ;
      sendRow0B12( ) ;
   }

   public void sendRow0B12( )
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
         if ( ((int)((nGXsfl_80_idx) % (2))) == 0 )
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
      imgprompt_13_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.articuloprompt"+"',["+"{Ctrl:gx.dom.el('"+"ARTICULOID_"+sGXsfl_80_idx+"'), id:'"+"ARTICULOID_"+sGXsfl_80_idx+"'"+",IOType:'inout'}"+"],"+"gx.dom.form()."+"nIsMod_12_"+sGXsfl_80_idx+","+"'', false"+","+"false"+");") ;
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_80_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 81,'',false,'" + sGXsfl_80_idx + "',80)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasDetalleId_Internalname,GXutil.ltrim( localUtil.ntoc( A12ComprasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12ComprasDetalleId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,81);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasDetalleId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtComprasDetalleId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasDetalleCantidad_Internalname,GXutil.ltrim( localUtil.ntoc( A75ComprasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtComprasDetalleCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A75ComprasDetalleCantidad), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A75ComprasDetalleCantidad), "ZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasDetalleCantidad_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtComprasDetalleCantidad_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cantidad","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_80_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 83,'',false,'" + sGXsfl_80_idx + "',80)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloId_Internalname,GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,83);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_13_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_13_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      Gridlevel_detalleRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgprompt_13_Internalname,sImgUrl,imgprompt_13_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(imgprompt_13_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloNombre_Internalname,GXutil.rtrim( A76ArticuloNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpuestoPorcentaje_Internalname,GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtImpuestoPorcentaje_Enabled!=0) ? localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99") : localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtImpuestoPorcentaje_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtImpuestoPorcentaje_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Porcentaje","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_80_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 86,'',false,'" + sGXsfl_80_idx + "',80)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasCantidad_Internalname,GXutil.ltrim( localUtil.ntoc( A82ComprasCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtComprasCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A82ComprasCantidad), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A82ComprasCantidad), "ZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,86);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasCantidad_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtComprasCantidad_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cantidad","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_80_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 87,'',false,'" + sGXsfl_80_idx + "',80)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasDetallePrecioCompra_Internalname,GXutil.ltrim( localUtil.ntoc( A80ComprasDetallePrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtComprasDetallePrecioCompra_Enabled!=0) ? localUtil.format( A80ComprasDetallePrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A80ComprasDetallePrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,87);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasDetallePrecioCompra_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtComprasDetallePrecioCompra_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasDetalleExento_Internalname,GXutil.ltrim( localUtil.ntoc( A81ComprasDetalleExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtComprasDetalleExento_Enabled!=0) ? localUtil.format( A81ComprasDetalleExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A81ComprasDetalleExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasDetalleExento_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtComprasDetalleExento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasDetalleIva5_Internalname,GXutil.ltrim( localUtil.ntoc( A85ComprasDetalleIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtComprasDetalleIva5_Enabled!=0) ? localUtil.format( A85ComprasDetalleIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A85ComprasDetalleIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasDetalleIva5_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtComprasDetalleIva5_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtComprasDetalleIva10_Internalname,GXutil.ltrim( localUtil.ntoc( A84ComprasDetalleIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtComprasDetalleIva10_Enabled!=0) ? localUtil.format( A84ComprasDetalleIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A84ComprasDetalleIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtComprasDetalleIva10_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtComprasDetalleIva10_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_80_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 91,'',false,'" + sGXsfl_80_idx + "',80)\"" ;
      if ( ( dynComprasDetalleTallaID.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "COMPRASDETALLETALLAID_" + sGXsfl_80_idx ;
         dynComprasDetalleTallaID.setName( GXCCtl );
         dynComprasDetalleTallaID.setWebtags( "" );
         dynComprasDetalleTallaID.removeAllItems();
         /* Using cursor T000B35 */
         pr_default.execute(29);
         while ( (pr_default.getStatus(29) != 101) )
         {
            dynComprasDetalleTallaID.addItem(GXutil.trim( GXutil.str( T000B35_A286TallaID[0], 11, 0)), GXutil.str( T000B35_A288TallaNumero[0], 4, 0), (short)(0));
            pr_default.readNext(29);
         }
         pr_default.close(29);
         if ( dynComprasDetalleTallaID.getItemCount() > 0 )
         {
            A291ComprasDetalleTallaID = GXutil.lval( dynComprasDetalleTallaID.getValidValue(GXutil.trim( GXutil.str( A291ComprasDetalleTallaID, 11, 0)))) ;
         }
      }
      /* ComboBox */
      Gridlevel_detalleRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynComprasDetalleTallaID,dynComprasDetalleTallaID.getInternalname(),GXutil.trim( GXutil.str( A291ComprasDetalleTallaID, 11, 0)),Integer.valueOf(1),dynComprasDetalleTallaID.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(dynComprasDetalleTallaID.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,91);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynComprasDetalleTallaID.setValue( GXutil.trim( GXutil.str( A291ComprasDetalleTallaID, 11, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynComprasDetalleTallaID.getInternalname(), "Values", dynComprasDetalleTallaID.ToJavascriptSource(), !bGXsfl_80_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes0B12( ) ;
      GXCCtl = "Z12ComprasDetalleId_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z12ComprasDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z75ComprasDetalleCantidad_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z75ComprasDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z82ComprasCantidad_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z82ComprasCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z80ComprasDetallePrecioCompra_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z80ComprasDetallePrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z291ComprasDetalleTallaID_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z291ComprasDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z13ArticuloId_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O84ComprasDetalleIva10_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O84ComprasDetalleIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O85ComprasDetalleIva5_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O85ComprasDetalleIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O81ComprasDetalleExento_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O81ComprasDetalleExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_12_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_12_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_12_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_12, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_80_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV11TrnContext);
      }
      GXCCtl = "vCOMPRASID_" + sGXsfl_80_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLEID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLECANTIDAD_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULONOMBRE_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IMPUESTOPORCENTAJE_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASCANTIDAD_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetallePrecioCompra_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLEEXENTO_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLEIVA5_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLEIVA10_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMPRASDETALLETALLAID_"+sGXsfl_80_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynComprasDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PROMPT_13_"+sGXsfl_80_idx+"Link", GXutil.rtrim( imgprompt_13_Link));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow0B12( )
   {
      nGXsfl_80_idx = (int)(nGXsfl_80_idx+1) ;
      sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_8012( ) ;
      edtComprasDetalleId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEID_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtComprasDetalleCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLECANTIDAD_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtImpuestoPorcentaje_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "IMPUESTOPORCENTAJE_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtComprasCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASCANTIDAD_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtComprasDetallePrecioCompra_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEPRECIOCOMPRA_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtComprasDetalleExento_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEEXENTO_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtComprasDetalleIva5_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEIVA5_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtComprasDetalleIva10_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLEIVA10_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      dynComprasDetalleTallaID.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "COMPRASDETALLETALLAID_"+sGXsfl_80_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      imgprompt_10_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_80_idx+"Link") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtComprasDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtComprasDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "COMPRASDETALLEID_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtComprasDetalleId_Internalname ;
         wbErr = true ;
         A12ComprasDetalleId = 0 ;
      }
      else
      {
         A12ComprasDetalleId = localUtil.ctol( httpContext.cgiGet( edtComprasDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      A75ComprasDetalleCantidad = (int)(localUtil.ctol( httpContext.cgiGet( edtComprasDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_80_idx ;
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
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtComprasCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtComprasCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
      {
         GXCCtl = "COMPRASCANTIDAD_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtComprasCantidad_Internalname ;
         wbErr = true ;
         A82ComprasCantidad = 0 ;
      }
      else
      {
         A82ComprasCantidad = (int)(localUtil.ctol( httpContext.cgiGet( edtComprasCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtComprasDetallePrecioCompra_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtComprasDetallePrecioCompra_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
      {
         GXCCtl = "COMPRASDETALLEPRECIOCOMPRA_" + sGXsfl_80_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtComprasDetallePrecioCompra_Internalname ;
         wbErr = true ;
         A80ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      }
      else
      {
         A80ComprasDetallePrecioCompra = localUtil.ctond( httpContext.cgiGet( edtComprasDetallePrecioCompra_Internalname)) ;
      }
      A81ComprasDetalleExento = localUtil.ctond( httpContext.cgiGet( edtComprasDetalleExento_Internalname)) ;
      A85ComprasDetalleIva5 = localUtil.ctond( httpContext.cgiGet( edtComprasDetalleIva5_Internalname)) ;
      A84ComprasDetalleIva10 = localUtil.ctond( httpContext.cgiGet( edtComprasDetalleIva10_Internalname)) ;
      dynComprasDetalleTallaID.setName( dynComprasDetalleTallaID.getInternalname() );
      dynComprasDetalleTallaID.setValue( httpContext.cgiGet( dynComprasDetalleTallaID.getInternalname()) );
      A291ComprasDetalleTallaID = GXutil.lval( httpContext.cgiGet( dynComprasDetalleTallaID.getInternalname())) ;
      GXCCtl = "Z12ComprasDetalleId_" + sGXsfl_80_idx ;
      Z12ComprasDetalleId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z75ComprasDetalleCantidad_" + sGXsfl_80_idx ;
      Z75ComprasDetalleCantidad = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z82ComprasCantidad_" + sGXsfl_80_idx ;
      Z82ComprasCantidad = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z80ComprasDetallePrecioCompra_" + sGXsfl_80_idx ;
      Z80ComprasDetallePrecioCompra = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z291ComprasDetalleTallaID_" + sGXsfl_80_idx ;
      Z291ComprasDetalleTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z13ArticuloId_" + sGXsfl_80_idx ;
      Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "O84ComprasDetalleIva10_" + sGXsfl_80_idx ;
      O84ComprasDetalleIva10 = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "O85ComprasDetalleIva5_" + sGXsfl_80_idx ;
      O85ComprasDetalleIva5 = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "O81ComprasDetalleExento_" + sGXsfl_80_idx ;
      O81ComprasDetalleExento = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_12_" + sGXsfl_80_idx ;
      nRcdDeleted_12 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_12_" + sGXsfl_80_idx ;
      nRcdExists_12 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_12_" + sGXsfl_80_idx ;
      nIsMod_12 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtComprasDetalleCantidad_Enabled = edtComprasDetalleCantidad_Enabled ;
      defedtComprasDetalleId_Enabled = edtComprasDetalleId_Enabled ;
   }

   public void confirmValues0B0( )
   {
      nGXsfl_80_idx = 0 ;
      sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_8012( ) ;
      while ( nGXsfl_80_idx < nRC_GXsfl_80 )
      {
         nGXsfl_80_idx = (int)(nGXsfl_80_idx+1) ;
         sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_8012( ) ;
         httpContext.changePostValue( "Z12ComprasDetalleId_"+sGXsfl_80_idx, httpContext.cgiGet( "ZT_"+"Z12ComprasDetalleId_"+sGXsfl_80_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z12ComprasDetalleId_"+sGXsfl_80_idx) ;
         httpContext.changePostValue( "Z75ComprasDetalleCantidad_"+sGXsfl_80_idx, httpContext.cgiGet( "ZT_"+"Z75ComprasDetalleCantidad_"+sGXsfl_80_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z75ComprasDetalleCantidad_"+sGXsfl_80_idx) ;
         httpContext.changePostValue( "Z82ComprasCantidad_"+sGXsfl_80_idx, httpContext.cgiGet( "ZT_"+"Z82ComprasCantidad_"+sGXsfl_80_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z82ComprasCantidad_"+sGXsfl_80_idx) ;
         httpContext.changePostValue( "Z80ComprasDetallePrecioCompra_"+sGXsfl_80_idx, httpContext.cgiGet( "ZT_"+"Z80ComprasDetallePrecioCompra_"+sGXsfl_80_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z80ComprasDetallePrecioCompra_"+sGXsfl_80_idx) ;
         httpContext.changePostValue( "Z291ComprasDetalleTallaID_"+sGXsfl_80_idx, httpContext.cgiGet( "ZT_"+"Z291ComprasDetalleTallaID_"+sGXsfl_80_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z291ComprasDetalleTallaID_"+sGXsfl_80_idx) ;
         httpContext.changePostValue( "Z13ArticuloId_"+sGXsfl_80_idx, httpContext.cgiGet( "ZT_"+"Z13ArticuloId_"+sGXsfl_80_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_80_idx) ;
      }
      httpContext.changePostValue( "O84ComprasDetalleIva10", httpContext.cgiGet( "T84ComprasDetalleIva10")) ;
      httpContext.deletePostValue( "T84ComprasDetalleIva10") ;
      httpContext.changePostValue( "O85ComprasDetalleIva5", httpContext.cgiGet( "T85ComprasDetalleIva5")) ;
      httpContext.deletePostValue( "T85ComprasDetalleIva5") ;
      httpContext.changePostValue( "O81ComprasDetalleExento", httpContext.cgiGet( "T81ComprasDetalleExento")) ;
      httpContext.deletePostValue( "T81ComprasDetalleExento") ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.compras", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ComprasId,11,0))}, new String[] {"Gx_mode","ComprasId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Compras");
      forbiddenHiddens.add("ComprasId", localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("compras:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z11ComprasId", GXutil.ltrim( localUtil.ntoc( Z11ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z74ComprasFecha", localUtil.dtoc( Z74ComprasFecha, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z226ComprasTimbrado", GXutil.ltrim( localUtil.ntoc( Z226ComprasTimbrado, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z227ComprasNumeroFactura", GXutil.ltrim( localUtil.ntoc( Z227ComprasNumeroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z10ProveedorId", GXutil.ltrim( localUtil.ntoc( Z10ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O89ComprasTotalIva10", GXutil.ltrim( localUtil.ntoc( O89ComprasTotalIva10, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O87ComprasTotalIva5", GXutil.ltrim( localUtil.ntoc( O87ComprasTotalIva5, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O90ComprasTotalExento", GXutil.ltrim( localUtil.ntoc( O90ComprasTotalExento, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_80", GXutil.ltrim( localUtil.ntoc( nGXsfl_80_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N10ProveedorId", GXutil.ltrim( localUtil.ntoc( A10ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCOMPRASID", GXutil.ltrim( localUtil.ntoc( AV7ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOMPRASID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ComprasId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PROVEEDORID", GXutil.ltrim( localUtil.ntoc( AV13Insert_ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.compras", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ComprasId,11,0))}, new String[] {"Gx_mode","ComprasId"})  ;
   }

   public String getPgmname( )
   {
      return "Compras" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Compras", "") ;
   }

   public void initializeNonKey0B11( )
   {
      A10ProveedorId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
      A74ComprasFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
      A88ComprasTotal10 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      A86ComprasTotal5 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      A225ComprasTotalIva = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      A229ComprasTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      A226ComprasTimbrado = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
      A227ComprasNumeroFactura = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
      A90ComprasTotalExento = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      A87ComprasTotalIva5 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      A89ComprasTotalIva10 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      O89ComprasTotalIva10 = A89ComprasTotalIva10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      O87ComprasTotalIva5 = A87ComprasTotalIva5 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      O90ComprasTotalExento = A90ComprasTotalExento ;
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
      Z74ComprasFecha = GXutil.nullDate() ;
      Z226ComprasTimbrado = 0 ;
      Z227ComprasNumeroFactura = 0 ;
      Z10ProveedorId = 0 ;
   }

   public void initAll0B11( )
   {
      A11ComprasId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      initializeNonKey0B11( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0B12( )
   {
      A18ImpuestoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
      A81ComprasDetalleExento = DecimalUtil.ZERO ;
      A84ComprasDetalleIva10 = DecimalUtil.ZERO ;
      A85ComprasDetalleIva5 = DecimalUtil.ZERO ;
      A75ComprasDetalleCantidad = 0 ;
      A13ArticuloId = 0 ;
      A76ArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A82ComprasCantidad = 0 ;
      A80ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      A291ComprasDetalleTallaID = 0 ;
      O84ComprasDetalleIva10 = A84ComprasDetalleIva10 ;
      O85ComprasDetalleIva5 = A85ComprasDetalleIva5 ;
      O81ComprasDetalleExento = A81ComprasDetalleExento ;
      Z75ComprasDetalleCantidad = 0 ;
      Z82ComprasCantidad = 0 ;
      Z80ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      Z291ComprasDetalleTallaID = 0 ;
      Z13ArticuloId = 0 ;
   }

   public void initAll0B12( )
   {
      A12ComprasDetalleId = 0 ;
      initializeNonKey0B12( ) ;
   }

   public void standaloneModalInsert0B12( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211194051", true, true);
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
      httpContext.AddJavascriptSource("compras.js", "?20241211194051", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties12( )
   {
      edtComprasDetalleCantidad_Enabled = defedtComprasDetalleCantidad_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleCantidad_Enabled), 5, 0), !bGXsfl_80_Refreshing);
      edtComprasDetalleId_Enabled = defedtComprasDetalleId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtComprasDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComprasDetalleId_Enabled), 5, 0), !bGXsfl_80_Refreshing);
   }

   public void startgridcontrol80( )
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
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A12ComprasDetalleId, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A75ComprasDetalleCantidad, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A82ComprasCantidad, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A80ComprasDetallePrecioCompra, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetallePrecioCompra_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A81ComprasDetalleExento, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleExento_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A85ComprasDetalleIva5, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva5_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A84ComprasDetalleIva10, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtComprasDetalleIva10_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A291ComprasDetalleTallaID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynComprasDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", "")));
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
      edtComprasId_Internalname = "COMPRASID" ;
      edtComprasFecha_Internalname = "COMPRASFECHA" ;
      edtProveedorId_Internalname = "PROVEEDORID" ;
      edtComprasTimbrado_Internalname = "COMPRASTIMBRADO" ;
      edtComprasNumeroFactura_Internalname = "COMPRASNUMEROFACTURA" ;
      edtComprasTotalExento_Internalname = "COMPRASTOTALEXENTO" ;
      edtComprasTotalIva5_Internalname = "COMPRASTOTALIVA5" ;
      edtComprasTotalIva10_Internalname = "COMPRASTOTALIVA10" ;
      edtComprasTotal_Internalname = "COMPRASTOTAL" ;
      edtComprasTotal5_Internalname = "COMPRASTOTAL5" ;
      edtComprasTotal10_Internalname = "COMPRASTOTAL10" ;
      edtComprasTotalIva_Internalname = "COMPRASTOTALIVA" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtComprasDetalleId_Internalname = "COMPRASDETALLEID" ;
      edtComprasDetalleCantidad_Internalname = "COMPRASDETALLECANTIDAD" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE" ;
      edtComprasCantidad_Internalname = "COMPRASCANTIDAD" ;
      edtComprasDetallePrecioCompra_Internalname = "COMPRASDETALLEPRECIOCOMPRA" ;
      edtComprasDetalleExento_Internalname = "COMPRASDETALLEEXENTO" ;
      edtComprasDetalleIva5_Internalname = "COMPRASDETALLEIVA5" ;
      edtComprasDetalleIva10_Internalname = "COMPRASDETALLEIVA10" ;
      dynComprasDetalleTallaID.setInternalname( "COMPRASDETALLETALLAID" );
      divTableleaflevel_detalle_Internalname = "TABLELEAFLEVEL_DETALLE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_10_Internalname = "PROMPT_10" ;
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
      Form.setCaption( httpContext.getMessage( "Compras", "") );
      dynComprasDetalleTallaID.setJsonclick( "" );
      edtComprasDetalleIva10_Jsonclick = "" ;
      edtComprasDetalleIva5_Jsonclick = "" ;
      edtComprasDetalleExento_Jsonclick = "" ;
      edtComprasDetallePrecioCompra_Jsonclick = "" ;
      edtComprasCantidad_Jsonclick = "" ;
      edtImpuestoPorcentaje_Jsonclick = "" ;
      edtArticuloNombre_Jsonclick = "" ;
      imgprompt_13_Visible = 1 ;
      imgprompt_13_Link = "" ;
      imgprompt_10_Visible = 1 ;
      edtArticuloId_Jsonclick = "" ;
      edtComprasDetalleCantidad_Jsonclick = "" ;
      edtComprasDetalleId_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      dynComprasDetalleTallaID.setEnabled( 1 );
      edtComprasDetalleIva10_Enabled = 0 ;
      edtComprasDetalleIva5_Enabled = 0 ;
      edtComprasDetalleExento_Enabled = 0 ;
      edtComprasDetallePrecioCompra_Enabled = 1 ;
      edtComprasCantidad_Enabled = 1 ;
      edtImpuestoPorcentaje_Enabled = 0 ;
      edtArticuloNombre_Enabled = 0 ;
      edtArticuloId_Enabled = 1 ;
      edtComprasDetalleCantidad_Enabled = 0 ;
      edtComprasDetalleId_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtComprasTotalIva_Jsonclick = "" ;
      edtComprasTotalIva_Enabled = 0 ;
      edtComprasTotal10_Jsonclick = "" ;
      edtComprasTotal10_Enabled = 0 ;
      edtComprasTotal5_Jsonclick = "" ;
      edtComprasTotal5_Enabled = 0 ;
      edtComprasTotal_Jsonclick = "" ;
      edtComprasTotal_Enabled = 0 ;
      edtComprasTotalIva10_Jsonclick = "" ;
      edtComprasTotalIva10_Enabled = 0 ;
      edtComprasTotalIva5_Jsonclick = "" ;
      edtComprasTotalIva5_Enabled = 0 ;
      edtComprasTotalExento_Jsonclick = "" ;
      edtComprasTotalExento_Enabled = 0 ;
      edtComprasNumeroFactura_Jsonclick = "" ;
      edtComprasNumeroFactura_Enabled = 1 ;
      edtComprasTimbrado_Jsonclick = "" ;
      edtComprasTimbrado_Enabled = 1 ;
      imgprompt_10_Visible = 1 ;
      imgprompt_10_Link = "" ;
      edtProveedorId_Jsonclick = "" ;
      edtProveedorId_Enabled = 1 ;
      edtComprasFecha_Jsonclick = "" ;
      edtComprasFecha_Enabled = 0 ;
      edtComprasId_Jsonclick = "" ;
      edtComprasId_Enabled = 0 ;
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

   public void gx9asacomprasid0B11( long AV7ComprasId ,
                                    String AV15Pgmname )
   {
      if ( ! (0==AV7ComprasId) )
      {
         A11ComprasId = AV7ComprasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A11ComprasId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
            compras_impl.this.GXt_int2 = GXv_int3[0] ;
            A11ComprasId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A11ComprasId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx24asacomprasdetalleid0B12( String AV15Pgmname )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A12ComprasDetalleId ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
         compras_impl.this.GXt_int2 = GXv_int3[0] ;
         A12ComprasDetalleId = GXt_int2 ;
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A12ComprasDetalleId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
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
      subsflControlProps_8012( ) ;
      while ( nGXsfl_80_idx <= nRC_GXsfl_80 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0B12( ) ;
         standaloneModal0B12( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0B12( ) ;
         nGXsfl_80_idx = (int)(nGXsfl_80_idx+1) ;
         sGXsfl_80_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_80_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_8012( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_detalleContainer)) ;
      /* End function gxnrGridlevel_detalle_newrow */
   }

   public void init_web_controls( )
   {
      GXCCtl = "COMPRASDETALLETALLAID_" + sGXsfl_80_idx ;
      dynComprasDetalleTallaID.setName( GXCCtl );
      dynComprasDetalleTallaID.setWebtags( "" );
      dynComprasDetalleTallaID.removeAllItems();
      /* Using cursor T000B36 */
      pr_default.execute(30);
      while ( (pr_default.getStatus(30) != 101) )
      {
         dynComprasDetalleTallaID.addItem(GXutil.trim( GXutil.str( T000B36_A286TallaID[0], 11, 0)), GXutil.str( T000B36_A288TallaNumero[0], 4, 0), (short)(0));
         pr_default.readNext(30);
      }
      pr_default.close(30);
      if ( dynComprasDetalleTallaID.getItemCount() > 0 )
      {
         A291ComprasDetalleTallaID = GXutil.lval( dynComprasDetalleTallaID.getValidValue(GXutil.trim( GXutil.str( A291ComprasDetalleTallaID, 11, 0)))) ;
      }
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

   public void valid_Comprasid( )
   {
      /* Using cursor T000B23 */
      pr_default.execute(17, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         A90ComprasTotalExento = T000B23_A90ComprasTotalExento[0] ;
         A87ComprasTotalIva5 = T000B23_A87ComprasTotalIva5[0] ;
         A89ComprasTotalIva10 = T000B23_A89ComprasTotalIva10[0] ;
      }
      else
      {
         A90ComprasTotalExento = DecimalUtil.doubleToDec(0) ;
         A87ComprasTotalIva5 = DecimalUtil.doubleToDec(0) ;
         A89ComprasTotalIva10 = DecimalUtil.doubleToDec(0) ;
      }
      pr_default.close(17);
      A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
      A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
      A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A90ComprasTotalExento", GXutil.ltrim( localUtil.ntoc( A90ComprasTotalExento, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A87ComprasTotalIva5", GXutil.ltrim( localUtil.ntoc( A87ComprasTotalIva5, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A89ComprasTotalIva10", GXutil.ltrim( localUtil.ntoc( A89ComprasTotalIva10, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A86ComprasTotal5", GXutil.ltrim( localUtil.ntoc( A86ComprasTotal5, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A229ComprasTotal", GXutil.ltrim( localUtil.ntoc( A229ComprasTotal, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A225ComprasTotalIva", GXutil.ltrim( localUtil.ntoc( A225ComprasTotalIva, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A88ComprasTotal10", GXutil.ltrim( localUtil.ntoc( A88ComprasTotal10, (byte)(17), (byte)(2), ".", "")));
   }

   public void valid_Proveedorid( )
   {
      /* Using cursor T000B37 */
      pr_default.execute(31, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(31) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Proveedor", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVEEDORID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProveedorId_Internalname ;
      }
      pr_default.close(31);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Articuloid( )
   {
      /* Using cursor T000B32 */
      pr_default.execute(26, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(26) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
      }
      A18ImpuestoId = T000B32_A18ImpuestoId[0] ;
      A76ArticuloNombre = T000B32_A76ArticuloNombre[0] ;
      pr_default.close(26);
      /* Using cursor T000B33 */
      pr_default.execute(27, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T000B33_A83ImpuestoPorcentaje[0] ;
      pr_default.close(27);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", GXutil.rtrim( A76ArticuloNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ComprasId',fld:'vCOMPRASID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7ComprasId',fld:'vCOMPRASID',pic:'ZZZZZZZZZZ9',hsh:true},{av:'A11ComprasId',fld:'COMPRASID',pic:'ZZZZZZZZZZ9'},{av:'A74ComprasFecha',fld:'COMPRASFECHA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120B2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A11ComprasId',fld:'COMPRASID',pic:'ZZZZZZZZZZ9'},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_COMPRASID","{handler:'valid_Comprasid',iparms:[{av:'A11ComprasId',fld:'COMPRASID',pic:'ZZZZZZZZZZ9'},{av:'A87ComprasTotalIva5',fld:'COMPRASTOTALIVA5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A90ComprasTotalExento',fld:'COMPRASTOTALEXENTO',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A89ComprasTotalIva10',fld:'COMPRASTOTALIVA10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A86ComprasTotal5',fld:'COMPRASTOTAL5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A229ComprasTotal',fld:'COMPRASTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A225ComprasTotalIva',fld:'COMPRASTOTALIVA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A88ComprasTotal10',fld:'COMPRASTOTAL10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("VALID_COMPRASID",",oparms:[{av:'A90ComprasTotalExento',fld:'COMPRASTOTALEXENTO',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A87ComprasTotalIva5',fld:'COMPRASTOTALIVA5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A89ComprasTotalIva10',fld:'COMPRASTOTALIVA10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A86ComprasTotal5',fld:'COMPRASTOTAL5',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A229ComprasTotal',fld:'COMPRASTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A225ComprasTotalIva',fld:'COMPRASTOTALIVA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A88ComprasTotal10',fld:'COMPRASTOTAL10',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("VALID_PROVEEDORID","{handler:'valid_Proveedorid',iparms:[{av:'A10ProveedorId',fld:'PROVEEDORID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_PROVEEDORID",",oparms:[]}");
      setEventMetadata("VALID_COMPRASTOTALEXENTO","{handler:'valid_Comprastotalexento',iparms:[]");
      setEventMetadata("VALID_COMPRASTOTALEXENTO",",oparms:[]}");
      setEventMetadata("VALID_COMPRASTOTALIVA5","{handler:'valid_Comprastotaliva5',iparms:[]");
      setEventMetadata("VALID_COMPRASTOTALIVA5",",oparms:[]}");
      setEventMetadata("VALID_COMPRASTOTALIVA10","{handler:'valid_Comprastotaliva10',iparms:[]");
      setEventMetadata("VALID_COMPRASTOTALIVA10",",oparms:[]}");
      setEventMetadata("VALID_COMPRASDETALLEID","{handler:'valid_Comprasdetalleid',iparms:[]");
      setEventMetadata("VALID_COMPRASDETALLEID",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]}");
      setEventMetadata("VALID_IMPUESTOPORCENTAJE","{handler:'valid_Impuestoporcentaje',iparms:[]");
      setEventMetadata("VALID_IMPUESTOPORCENTAJE",",oparms:[]}");
      setEventMetadata("VALID_COMPRASCANTIDAD","{handler:'valid_Comprascantidad',iparms:[]");
      setEventMetadata("VALID_COMPRASCANTIDAD",",oparms:[]}");
      setEventMetadata("VALID_COMPRASDETALLEPRECIOCOMPRA","{handler:'valid_Comprasdetallepreciocompra',iparms:[]");
      setEventMetadata("VALID_COMPRASDETALLEPRECIOCOMPRA",",oparms:[]}");
      setEventMetadata("VALID_COMPRASDETALLEEXENTO","{handler:'valid_Comprasdetalleexento',iparms:[]");
      setEventMetadata("VALID_COMPRASDETALLEEXENTO",",oparms:[]}");
      setEventMetadata("VALID_COMPRASDETALLEIVA5","{handler:'valid_Comprasdetalleiva5',iparms:[]");
      setEventMetadata("VALID_COMPRASDETALLEIVA5",",oparms:[]}");
      setEventMetadata("VALID_COMPRASDETALLEIVA10","{handler:'valid_Comprasdetalleiva10',iparms:[]");
      setEventMetadata("VALID_COMPRASDETALLEIVA10",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Comprasdetalletallaid',iparms:[]");
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
      return "compras_Execute";
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
      pr_default.close(26);
      pr_default.close(27);
      pr_default.close(31);
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z74ComprasFecha = GXutil.nullDate() ;
      O89ComprasTotalIva10 = DecimalUtil.ZERO ;
      O87ComprasTotalIva5 = DecimalUtil.ZERO ;
      O90ComprasTotalExento = DecimalUtil.ZERO ;
      Z80ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      O84ComprasDetalleIva10 = DecimalUtil.ZERO ;
      O85ComprasDetalleIva5 = DecimalUtil.ZERO ;
      O81ComprasDetalleExento = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV15Pgmname = "" ;
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
      A74ComprasFecha = GXutil.nullDate() ;
      TempTags = "" ;
      imgprompt_10_gximage = "" ;
      sImgUrl = "" ;
      A90ComprasTotalExento = DecimalUtil.ZERO ;
      A87ComprasTotalIva5 = DecimalUtil.ZERO ;
      A89ComprasTotalIva10 = DecimalUtil.ZERO ;
      A229ComprasTotal = DecimalUtil.ZERO ;
      A86ComprasTotal5 = DecimalUtil.ZERO ;
      A88ComprasTotal10 = DecimalUtil.ZERO ;
      A225ComprasTotalIva = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      B89ComprasTotalIva10 = DecimalUtil.ZERO ;
      B87ComprasTotalIva5 = DecimalUtil.ZERO ;
      B90ComprasTotalExento = DecimalUtil.ZERO ;
      sMode12 = "" ;
      sStyleString = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode11 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      s89ComprasTotalIva10 = DecimalUtil.ZERO ;
      s87ComprasTotalIva5 = DecimalUtil.ZERO ;
      s90ComprasTotalExento = DecimalUtil.ZERO ;
      s88ComprasTotal10 = DecimalUtil.ZERO ;
      O88ComprasTotal10 = DecimalUtil.ZERO ;
      s86ComprasTotal5 = DecimalUtil.ZERO ;
      O86ComprasTotal5 = DecimalUtil.ZERO ;
      s225ComprasTotalIva = DecimalUtil.ZERO ;
      O225ComprasTotalIva = DecimalUtil.ZERO ;
      s229ComprasTotal = DecimalUtil.ZERO ;
      O229ComprasTotal = DecimalUtil.ZERO ;
      GXCCtl = "" ;
      A76ArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A80ComprasDetallePrecioCompra = DecimalUtil.ZERO ;
      A81ComprasDetalleExento = DecimalUtil.ZERO ;
      A85ComprasDetalleIva5 = DecimalUtil.ZERO ;
      A84ComprasDetalleIva10 = DecimalUtil.ZERO ;
      T84ComprasDetalleIva10 = DecimalUtil.ZERO ;
      T85ComprasDetalleIva5 = DecimalUtil.ZERO ;
      T81ComprasDetalleExento = DecimalUtil.ZERO ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z90ComprasTotalExento = DecimalUtil.ZERO ;
      Z87ComprasTotalIva5 = DecimalUtil.ZERO ;
      Z89ComprasTotalIva10 = DecimalUtil.ZERO ;
      T000B10_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B10_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B10_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B12_A11ComprasId = new long[1] ;
      T000B12_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000B12_A226ComprasTimbrado = new long[1] ;
      T000B12_A227ComprasNumeroFactura = new long[1] ;
      T000B12_A10ProveedorId = new long[1] ;
      T000B12_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B12_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B12_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B8_A10ProveedorId = new long[1] ;
      T000B14_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B14_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B14_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B15_A10ProveedorId = new long[1] ;
      T000B16_A11ComprasId = new long[1] ;
      T000B7_A11ComprasId = new long[1] ;
      T000B7_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000B7_A226ComprasTimbrado = new long[1] ;
      T000B7_A227ComprasNumeroFactura = new long[1] ;
      T000B7_A10ProveedorId = new long[1] ;
      T000B17_A11ComprasId = new long[1] ;
      T000B18_A11ComprasId = new long[1] ;
      T000B6_A11ComprasId = new long[1] ;
      T000B6_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000B6_A226ComprasTimbrado = new long[1] ;
      T000B6_A227ComprasNumeroFactura = new long[1] ;
      T000B6_A10ProveedorId = new long[1] ;
      T000B23_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B23_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B23_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B24_A11ComprasId = new long[1] ;
      Z76ArticuloNombre = "" ;
      Z83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      T000B25_A18ImpuestoId = new long[1] ;
      T000B25_A11ComprasId = new long[1] ;
      T000B25_A12ComprasDetalleId = new long[1] ;
      T000B25_A75ComprasDetalleCantidad = new int[1] ;
      T000B25_A76ArticuloNombre = new String[] {""} ;
      T000B25_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B25_A82ComprasCantidad = new int[1] ;
      T000B25_A80ComprasDetallePrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B25_A291ComprasDetalleTallaID = new long[1] ;
      T000B25_A13ArticuloId = new long[1] ;
      T000B4_A18ImpuestoId = new long[1] ;
      T000B4_A76ArticuloNombre = new String[] {""} ;
      T000B5_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B26_A18ImpuestoId = new long[1] ;
      T000B26_A76ArticuloNombre = new String[] {""} ;
      T000B27_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B28_A11ComprasId = new long[1] ;
      T000B28_A12ComprasDetalleId = new long[1] ;
      T000B3_A11ComprasId = new long[1] ;
      T000B3_A12ComprasDetalleId = new long[1] ;
      T000B3_A75ComprasDetalleCantidad = new int[1] ;
      T000B3_A82ComprasCantidad = new int[1] ;
      T000B3_A80ComprasDetallePrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B3_A291ComprasDetalleTallaID = new long[1] ;
      T000B3_A13ArticuloId = new long[1] ;
      T000B2_A11ComprasId = new long[1] ;
      T000B2_A12ComprasDetalleId = new long[1] ;
      T000B2_A75ComprasDetalleCantidad = new int[1] ;
      T000B2_A82ComprasCantidad = new int[1] ;
      T000B2_A80ComprasDetallePrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B2_A291ComprasDetalleTallaID = new long[1] ;
      T000B2_A13ArticuloId = new long[1] ;
      T000B32_A18ImpuestoId = new long[1] ;
      T000B32_A76ArticuloNombre = new String[] {""} ;
      T000B33_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000B34_A11ComprasId = new long[1] ;
      T000B34_A12ComprasDetalleId = new long[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      imgprompt_13_gximage = "" ;
      T000B35_A286TallaID = new long[1] ;
      T000B35_A288TallaNumero = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int3 = new long[1] ;
      T000B36_A286TallaID = new long[1] ;
      T000B36_A288TallaNumero = new short[1] ;
      Z86ComprasTotal5 = DecimalUtil.ZERO ;
      Z229ComprasTotal = DecimalUtil.ZERO ;
      Z225ComprasTotalIva = DecimalUtil.ZERO ;
      Z88ComprasTotal10 = DecimalUtil.ZERO ;
      T000B37_A10ProveedorId = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.compras__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.compras__default(),
         new Object[] {
             new Object[] {
            T000B2_A11ComprasId, T000B2_A12ComprasDetalleId, T000B2_A75ComprasDetalleCantidad, T000B2_A82ComprasCantidad, T000B2_A80ComprasDetallePrecioCompra, T000B2_A291ComprasDetalleTallaID, T000B2_A13ArticuloId
            }
            , new Object[] {
            T000B3_A11ComprasId, T000B3_A12ComprasDetalleId, T000B3_A75ComprasDetalleCantidad, T000B3_A82ComprasCantidad, T000B3_A80ComprasDetallePrecioCompra, T000B3_A291ComprasDetalleTallaID, T000B3_A13ArticuloId
            }
            , new Object[] {
            T000B4_A18ImpuestoId, T000B4_A76ArticuloNombre
            }
            , new Object[] {
            T000B5_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000B6_A11ComprasId, T000B6_A74ComprasFecha, T000B6_A226ComprasTimbrado, T000B6_A227ComprasNumeroFactura, T000B6_A10ProveedorId
            }
            , new Object[] {
            T000B7_A11ComprasId, T000B7_A74ComprasFecha, T000B7_A226ComprasTimbrado, T000B7_A227ComprasNumeroFactura, T000B7_A10ProveedorId
            }
            , new Object[] {
            T000B8_A10ProveedorId
            }
            , new Object[] {
            T000B10_A90ComprasTotalExento, T000B10_A87ComprasTotalIva5, T000B10_A89ComprasTotalIva10
            }
            , new Object[] {
            T000B12_A11ComprasId, T000B12_A74ComprasFecha, T000B12_A226ComprasTimbrado, T000B12_A227ComprasNumeroFactura, T000B12_A10ProveedorId, T000B12_A90ComprasTotalExento, T000B12_A87ComprasTotalIva5, T000B12_A89ComprasTotalIva10
            }
            , new Object[] {
            T000B14_A90ComprasTotalExento, T000B14_A87ComprasTotalIva5, T000B14_A89ComprasTotalIva10
            }
            , new Object[] {
            T000B15_A10ProveedorId
            }
            , new Object[] {
            T000B16_A11ComprasId
            }
            , new Object[] {
            T000B17_A11ComprasId
            }
            , new Object[] {
            T000B18_A11ComprasId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000B23_A90ComprasTotalExento, T000B23_A87ComprasTotalIva5, T000B23_A89ComprasTotalIva10
            }
            , new Object[] {
            T000B24_A11ComprasId
            }
            , new Object[] {
            T000B25_A18ImpuestoId, T000B25_A11ComprasId, T000B25_A12ComprasDetalleId, T000B25_A75ComprasDetalleCantidad, T000B25_A76ArticuloNombre, T000B25_A83ImpuestoPorcentaje, T000B25_A82ComprasCantidad, T000B25_A80ComprasDetallePrecioCompra, T000B25_A291ComprasDetalleTallaID, T000B25_A13ArticuloId
            }
            , new Object[] {
            T000B26_A18ImpuestoId, T000B26_A76ArticuloNombre
            }
            , new Object[] {
            T000B27_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000B28_A11ComprasId, T000B28_A12ComprasDetalleId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000B32_A18ImpuestoId, T000B32_A76ArticuloNombre
            }
            , new Object[] {
            T000B33_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000B34_A11ComprasId, T000B34_A12ComprasDetalleId
            }
            , new Object[] {
            T000B35_A286TallaID, T000B35_A288TallaNumero
            }
            , new Object[] {
            T000B36_A286TallaID, T000B36_A288TallaNumero
            }
            , new Object[] {
            T000B37_A10ProveedorId
            }
         }
      );
      AV15Pgmname = "Compras" ;
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
   private short nIsMod_12 ;
   private short nRcdDeleted_12 ;
   private short nRcdExists_12 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount12 ;
   private short RcdFound12 ;
   private short nBlankRcdUsr12 ;
   private short RcdFound11 ;
   private short nIsDirty_11 ;
   private short nIsDirty_12 ;
   private int nRC_GXsfl_80 ;
   private int nGXsfl_80_idx=1 ;
   private int Z75ComprasDetalleCantidad ;
   private int Z82ComprasCantidad ;
   private int trnEnded ;
   private int edtComprasId_Enabled ;
   private int edtComprasFecha_Enabled ;
   private int edtProveedorId_Enabled ;
   private int imgprompt_10_Visible ;
   private int edtComprasTimbrado_Enabled ;
   private int edtComprasNumeroFactura_Enabled ;
   private int edtComprasTotalExento_Enabled ;
   private int edtComprasTotalIva5_Enabled ;
   private int edtComprasTotalIva10_Enabled ;
   private int edtComprasTotal_Enabled ;
   private int edtComprasTotal5_Enabled ;
   private int edtComprasTotal10_Enabled ;
   private int edtComprasTotalIva_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtComprasDetalleId_Enabled ;
   private int edtComprasDetalleCantidad_Enabled ;
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtImpuestoPorcentaje_Enabled ;
   private int edtComprasCantidad_Enabled ;
   private int edtComprasDetallePrecioCompra_Enabled ;
   private int edtComprasDetalleExento_Enabled ;
   private int edtComprasDetalleIva5_Enabled ;
   private int edtComprasDetalleIva10_Enabled ;
   private int fRowAdded ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A75ComprasDetalleCantidad ;
   private int A82ComprasCantidad ;
   private int AV16GXV1 ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int imgprompt_13_Visible ;
   private int defedtComprasDetalleCantidad_Enabled ;
   private int defedtComprasDetalleId_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private long wcpOAV7ComprasId ;
   private long Z11ComprasId ;
   private long Z226ComprasTimbrado ;
   private long Z227ComprasNumeroFactura ;
   private long Z10ProveedorId ;
   private long N10ProveedorId ;
   private long Z12ComprasDetalleId ;
   private long Z291ComprasDetalleTallaID ;
   private long Z13ArticuloId ;
   private long AV7ComprasId ;
   private long A11ComprasId ;
   private long A10ProveedorId ;
   private long A13ArticuloId ;
   private long A18ImpuestoId ;
   private long A226ComprasTimbrado ;
   private long A227ComprasNumeroFactura ;
   private long AV13Insert_ProveedorId ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private long A12ComprasDetalleId ;
   private long A291ComprasDetalleTallaID ;
   private long Z18ImpuestoId ;
   private long GXt_int2 ;
   private long GXv_int3[] ;
   private java.math.BigDecimal O89ComprasTotalIva10 ;
   private java.math.BigDecimal O87ComprasTotalIva5 ;
   private java.math.BigDecimal O90ComprasTotalExento ;
   private java.math.BigDecimal Z80ComprasDetallePrecioCompra ;
   private java.math.BigDecimal O84ComprasDetalleIva10 ;
   private java.math.BigDecimal O85ComprasDetalleIva5 ;
   private java.math.BigDecimal O81ComprasDetalleExento ;
   private java.math.BigDecimal A90ComprasTotalExento ;
   private java.math.BigDecimal A87ComprasTotalIva5 ;
   private java.math.BigDecimal A89ComprasTotalIva10 ;
   private java.math.BigDecimal A229ComprasTotal ;
   private java.math.BigDecimal A86ComprasTotal5 ;
   private java.math.BigDecimal A88ComprasTotal10 ;
   private java.math.BigDecimal A225ComprasTotalIva ;
   private java.math.BigDecimal B89ComprasTotalIva10 ;
   private java.math.BigDecimal B87ComprasTotalIva5 ;
   private java.math.BigDecimal B90ComprasTotalExento ;
   private java.math.BigDecimal s89ComprasTotalIva10 ;
   private java.math.BigDecimal s87ComprasTotalIva5 ;
   private java.math.BigDecimal s90ComprasTotalExento ;
   private java.math.BigDecimal s88ComprasTotal10 ;
   private java.math.BigDecimal O88ComprasTotal10 ;
   private java.math.BigDecimal s86ComprasTotal5 ;
   private java.math.BigDecimal O86ComprasTotal5 ;
   private java.math.BigDecimal s225ComprasTotalIva ;
   private java.math.BigDecimal O225ComprasTotalIva ;
   private java.math.BigDecimal s229ComprasTotal ;
   private java.math.BigDecimal O229ComprasTotal ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
   private java.math.BigDecimal A80ComprasDetallePrecioCompra ;
   private java.math.BigDecimal A81ComprasDetalleExento ;
   private java.math.BigDecimal A85ComprasDetalleIva5 ;
   private java.math.BigDecimal A84ComprasDetalleIva10 ;
   private java.math.BigDecimal T84ComprasDetalleIva10 ;
   private java.math.BigDecimal T85ComprasDetalleIva5 ;
   private java.math.BigDecimal T81ComprasDetalleExento ;
   private java.math.BigDecimal Z90ComprasTotalExento ;
   private java.math.BigDecimal Z87ComprasTotalIva5 ;
   private java.math.BigDecimal Z89ComprasTotalIva10 ;
   private java.math.BigDecimal Z83ImpuestoPorcentaje ;
   private java.math.BigDecimal Z86ComprasTotal5 ;
   private java.math.BigDecimal Z229ComprasTotal ;
   private java.math.BigDecimal Z225ComprasTotalIva ;
   private java.math.BigDecimal Z88ComprasTotal10 ;
   private String sPrefix ;
   private String sGXsfl_80_idx="0001" ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV15Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtProveedorId_Internalname ;
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
   private String edtComprasId_Internalname ;
   private String edtComprasId_Jsonclick ;
   private String edtComprasFecha_Internalname ;
   private String edtComprasFecha_Jsonclick ;
   private String TempTags ;
   private String edtProveedorId_Jsonclick ;
   private String imgprompt_10_gximage ;
   private String sImgUrl ;
   private String imgprompt_10_Internalname ;
   private String imgprompt_10_Link ;
   private String edtComprasTimbrado_Internalname ;
   private String edtComprasTimbrado_Jsonclick ;
   private String edtComprasNumeroFactura_Internalname ;
   private String edtComprasNumeroFactura_Jsonclick ;
   private String edtComprasTotalExento_Internalname ;
   private String edtComprasTotalExento_Jsonclick ;
   private String edtComprasTotalIva5_Internalname ;
   private String edtComprasTotalIva5_Jsonclick ;
   private String edtComprasTotalIva10_Internalname ;
   private String edtComprasTotalIva10_Jsonclick ;
   private String edtComprasTotal_Internalname ;
   private String edtComprasTotal_Jsonclick ;
   private String edtComprasTotal5_Internalname ;
   private String edtComprasTotal5_Jsonclick ;
   private String edtComprasTotal10_Internalname ;
   private String edtComprasTotal10_Jsonclick ;
   private String edtComprasTotalIva_Internalname ;
   private String edtComprasTotalIva_Jsonclick ;
   private String divTableleaflevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode12 ;
   private String edtComprasDetalleId_Internalname ;
   private String edtComprasDetalleCantidad_Internalname ;
   private String edtArticuloId_Internalname ;
   private String edtArticuloNombre_Internalname ;
   private String edtImpuestoPorcentaje_Internalname ;
   private String edtComprasCantidad_Internalname ;
   private String edtComprasDetallePrecioCompra_Internalname ;
   private String edtComprasDetalleExento_Internalname ;
   private String edtComprasDetalleIva5_Internalname ;
   private String edtComprasDetalleIva10_Internalname ;
   private String sStyleString ;
   private String subGridlevel_detalle_Internalname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode11 ;
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
   private String sGXsfl_80_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String imgprompt_13_Link ;
   private String ROClassString ;
   private String edtComprasDetalleId_Jsonclick ;
   private String edtComprasDetalleCantidad_Jsonclick ;
   private String edtArticuloId_Jsonclick ;
   private String imgprompt_13_gximage ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtImpuestoPorcentaje_Jsonclick ;
   private String edtComprasCantidad_Jsonclick ;
   private String edtComprasDetallePrecioCompra_Jsonclick ;
   private String edtComprasDetalleExento_Jsonclick ;
   private String edtComprasDetalleIva5_Jsonclick ;
   private String edtComprasDetalleIva10_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_detalle_Header ;
   private java.util.Date Z74ComprasFecha ;
   private java.util.Date A74ComprasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_80_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynComprasDetalleTallaID ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T000B10_A90ComprasTotalExento ;
   private java.math.BigDecimal[] T000B10_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] T000B10_A89ComprasTotalIva10 ;
   private long[] T000B12_A11ComprasId ;
   private java.util.Date[] T000B12_A74ComprasFecha ;
   private long[] T000B12_A226ComprasTimbrado ;
   private long[] T000B12_A227ComprasNumeroFactura ;
   private long[] T000B12_A10ProveedorId ;
   private java.math.BigDecimal[] T000B12_A90ComprasTotalExento ;
   private java.math.BigDecimal[] T000B12_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] T000B12_A89ComprasTotalIva10 ;
   private long[] T000B8_A10ProveedorId ;
   private java.math.BigDecimal[] T000B14_A90ComprasTotalExento ;
   private java.math.BigDecimal[] T000B14_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] T000B14_A89ComprasTotalIva10 ;
   private long[] T000B15_A10ProveedorId ;
   private long[] T000B16_A11ComprasId ;
   private long[] T000B7_A11ComprasId ;
   private java.util.Date[] T000B7_A74ComprasFecha ;
   private long[] T000B7_A226ComprasTimbrado ;
   private long[] T000B7_A227ComprasNumeroFactura ;
   private long[] T000B7_A10ProveedorId ;
   private long[] T000B17_A11ComprasId ;
   private long[] T000B18_A11ComprasId ;
   private long[] T000B6_A11ComprasId ;
   private java.util.Date[] T000B6_A74ComprasFecha ;
   private long[] T000B6_A226ComprasTimbrado ;
   private long[] T000B6_A227ComprasNumeroFactura ;
   private long[] T000B6_A10ProveedorId ;
   private java.math.BigDecimal[] T000B23_A90ComprasTotalExento ;
   private java.math.BigDecimal[] T000B23_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] T000B23_A89ComprasTotalIva10 ;
   private long[] T000B24_A11ComprasId ;
   private long[] T000B25_A18ImpuestoId ;
   private long[] T000B25_A11ComprasId ;
   private long[] T000B25_A12ComprasDetalleId ;
   private int[] T000B25_A75ComprasDetalleCantidad ;
   private String[] T000B25_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000B25_A83ImpuestoPorcentaje ;
   private int[] T000B25_A82ComprasCantidad ;
   private java.math.BigDecimal[] T000B25_A80ComprasDetallePrecioCompra ;
   private long[] T000B25_A291ComprasDetalleTallaID ;
   private long[] T000B25_A13ArticuloId ;
   private long[] T000B4_A18ImpuestoId ;
   private String[] T000B4_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000B5_A83ImpuestoPorcentaje ;
   private long[] T000B26_A18ImpuestoId ;
   private String[] T000B26_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000B27_A83ImpuestoPorcentaje ;
   private long[] T000B28_A11ComprasId ;
   private long[] T000B28_A12ComprasDetalleId ;
   private long[] T000B3_A11ComprasId ;
   private long[] T000B3_A12ComprasDetalleId ;
   private int[] T000B3_A75ComprasDetalleCantidad ;
   private int[] T000B3_A82ComprasCantidad ;
   private java.math.BigDecimal[] T000B3_A80ComprasDetallePrecioCompra ;
   private long[] T000B3_A291ComprasDetalleTallaID ;
   private long[] T000B3_A13ArticuloId ;
   private long[] T000B2_A11ComprasId ;
   private long[] T000B2_A12ComprasDetalleId ;
   private int[] T000B2_A75ComprasDetalleCantidad ;
   private int[] T000B2_A82ComprasCantidad ;
   private java.math.BigDecimal[] T000B2_A80ComprasDetallePrecioCompra ;
   private long[] T000B2_A291ComprasDetalleTallaID ;
   private long[] T000B2_A13ArticuloId ;
   private long[] T000B32_A18ImpuestoId ;
   private String[] T000B32_A76ArticuloNombre ;
   private java.math.BigDecimal[] T000B33_A83ImpuestoPorcentaje ;
   private long[] T000B34_A11ComprasId ;
   private long[] T000B34_A12ComprasDetalleId ;
   private long[] T000B35_A286TallaID ;
   private short[] T000B35_A288TallaNumero ;
   private long[] T000B36_A286TallaID ;
   private short[] T000B36_A288TallaNumero ;
   private long[] T000B37_A10ProveedorId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class compras__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class compras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000B2", "SELECT [ComprasId], [ComprasDetalleId], [ComprasDetalleCantidad], [ComprasCantidad], [ComprasDetallePrecioCompra], [ComprasDetalleTallaID], [ArticuloId] FROM [ComprasDetalle] WITH (UPDLOCK) WHERE [ComprasId] = ? AND [ComprasDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B3", "SELECT [ComprasId], [ComprasDetalleId], [ComprasDetalleCantidad], [ComprasCantidad], [ComprasDetallePrecioCompra], [ComprasDetalleTallaID], [ArticuloId] FROM [ComprasDetalle] WHERE [ComprasId] = ? AND [ComprasDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B4", "SELECT [ImpuestoId], [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B5", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B6", "SELECT [ComprasId], [ComprasFecha], [ComprasTimbrado], [ComprasNumeroFactura], [ProveedorId] FROM [Compras] WITH (UPDLOCK) WHERE [ComprasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B7", "SELECT [ComprasId], [ComprasFecha], [ComprasTimbrado], [ComprasNumeroFactura], [ProveedorId] FROM [Compras] WHERE [ComprasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B8", "SELECT [ProveedorId] FROM [Proveedor] WHERE [ProveedorId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B10", "SELECT COALESCE( T1.[ComprasTotalExento], 0) AS ComprasTotalExento, COALESCE( T1.[ComprasTotalIva5], 0) AS ComprasTotalIva5, COALESCE( T1.[ComprasTotalIva10], 0) AS ComprasTotalIva10 FROM (SELECT SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento, T2.[ComprasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[ComprasId] ) T1 WHERE T1.[ComprasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B12", "SELECT TM1.[ComprasId], TM1.[ComprasFecha], TM1.[ComprasTimbrado], TM1.[ComprasNumeroFactura], TM1.[ProveedorId], COALESCE( T2.[ComprasTotalExento], 0) AS ComprasTotalExento, COALESCE( T2.[ComprasTotalIva5], 0) AS ComprasTotalIva5, COALESCE( T2.[ComprasTotalIva10], 0) AS ComprasTotalIva10 FROM ([Compras] TM1 LEFT JOIN (SELECT SUM(CASE  WHEN T5.[ImpuestoPorcentaje] = 0 THEN T3.[ComprasCantidad] * CAST(T3.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento, T3.[ComprasId], SUM(CASE  WHEN T5.[ImpuestoPorcentaje] = 5 THEN T3.[ComprasCantidad] * CAST(T3.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE  WHEN T5.[ImpuestoPorcentaje] = 10 THEN T3.[ComprasCantidad] * CAST(T3.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T3 INNER JOIN [Articulo] T4 ON T4.[ArticuloId] = T3.[ArticuloId]) INNER JOIN [Impuesto] T5 ON T5.[ImpuestoId] = T4.[ImpuestoId]) GROUP BY T3.[ComprasId] ) T2 ON T2.[ComprasId] = TM1.[ComprasId]) WHERE TM1.[ComprasId] = ? ORDER BY TM1.[ComprasId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B14", "SELECT COALESCE( T1.[ComprasTotalExento], 0) AS ComprasTotalExento, COALESCE( T1.[ComprasTotalIva5], 0) AS ComprasTotalIva5, COALESCE( T1.[ComprasTotalIva10], 0) AS ComprasTotalIva10 FROM (SELECT SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento, T2.[ComprasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[ComprasId] ) T1 WHERE T1.[ComprasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B15", "SELECT [ProveedorId] FROM [Proveedor] WHERE [ProveedorId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B16", "SELECT [ComprasId] FROM [Compras] WHERE [ComprasId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B17", "SELECT TOP 1 [ComprasId] FROM [Compras] WHERE ( [ComprasId] > ?) ORDER BY [ComprasId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000B18", "SELECT TOP 1 [ComprasId] FROM [Compras] WHERE ( [ComprasId] < ?) ORDER BY [ComprasId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000B19", "INSERT INTO [Compras]([ComprasId], [ComprasFecha], [ComprasTimbrado], [ComprasNumeroFactura], [ProveedorId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000B20", "UPDATE [Compras] SET [ComprasFecha]=?, [ComprasTimbrado]=?, [ComprasNumeroFactura]=?, [ProveedorId]=?  WHERE [ComprasId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000B21", "DELETE FROM [Compras]  WHERE [ComprasId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000B23", "SELECT COALESCE( T1.[ComprasTotalExento], 0) AS ComprasTotalExento, COALESCE( T1.[ComprasTotalIva5], 0) AS ComprasTotalIva5, COALESCE( T1.[ComprasTotalIva10], 0) AS ComprasTotalIva10 FROM (SELECT SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento, T2.[ComprasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[ComprasId] ) T1 WHERE T1.[ComprasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B24", "SELECT [ComprasId] FROM [Compras] ORDER BY [ComprasId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B25", "SELECT T2.[ImpuestoId], T1.[ComprasId], T1.[ComprasDetalleId], T1.[ComprasDetalleCantidad], T2.[ArticuloNombre], T3.[ImpuestoPorcentaje], T1.[ComprasCantidad], T1.[ComprasDetallePrecioCompra], T1.[ComprasDetalleTallaID], T1.[ArticuloId] FROM (([ComprasDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) INNER JOIN [Impuesto] T3 ON T3.[ImpuestoId] = T2.[ImpuestoId]) WHERE T1.[ComprasId] = ? and T1.[ComprasDetalleId] = ? ORDER BY T1.[ComprasId], T1.[ComprasDetalleId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B26", "SELECT [ImpuestoId], [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B27", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B28", "SELECT [ComprasId], [ComprasDetalleId] FROM [ComprasDetalle] WHERE [ComprasId] = ? AND [ComprasDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000B29", "INSERT INTO [ComprasDetalle]([ComprasId], [ComprasDetalleId], [ComprasDetalleCantidad], [ComprasCantidad], [ComprasDetallePrecioCompra], [ComprasDetalleTallaID], [ArticuloId]) VALUES(?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000B30", "UPDATE [ComprasDetalle] SET [ComprasDetalleCantidad]=?, [ComprasCantidad]=?, [ComprasDetallePrecioCompra]=?, [ComprasDetalleTallaID]=?, [ArticuloId]=?  WHERE [ComprasId] = ? AND [ComprasDetalleId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000B31", "DELETE FROM [ComprasDetalle]  WHERE [ComprasId] = ? AND [ComprasDetalleId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000B32", "SELECT [ImpuestoId], [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B33", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B34", "SELECT [ComprasId], [ComprasDetalleId] FROM [ComprasDetalle] WHERE [ComprasId] = ? ORDER BY [ComprasId], [ComprasDetalleId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B35", "SELECT [TallaID], [TallaNumero] FROM [Talla] ORDER BY [TallaNumero] ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B36", "SELECT [TallaID], [TallaNumero] FROM [Talla] ORDER BY [TallaNumero] ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B37", "SELECT [ProveedorId] FROM [Proveedor] WHERE [ProveedorId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 3 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               return;
            case 9 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 17 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 19 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               return;
            case 20 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 21 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 26 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 27 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 28 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 29 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 31 :
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 15 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 21 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 22 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 23 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               return;
            case 25 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 26 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 27 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 28 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 31 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

