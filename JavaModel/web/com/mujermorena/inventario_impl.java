package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class inventario_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"INVENTARIOID") == 0 )
      {
         AV7InventarioID = GXutil.lval( httpContext.GetPar( "InventarioID")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7InventarioID), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINVENTARIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7InventarioID), "ZZZZZZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asainventarioid1749( AV7InventarioID) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A13ArticuloId) ;
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
            AV7InventarioID = GXutil.lval( httpContext.GetPar( "InventarioID")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7InventarioID), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINVENTARIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7InventarioID), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Inventario", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtInventarioID_Internalname ;
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
      nRC_GXsfl_44 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_44"))) ;
      nGXsfl_44_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_44_idx"))) ;
      sGXsfl_44_idx = httpContext.GetPar( "sGXsfl_44_idx") ;
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

   public inventario_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public inventario_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inventario_impl.class ));
   }

   public inventario_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Inventario", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Inventario.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtInventarioID_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtInventarioID_Internalname, httpContext.getMessage( "Inventario ID", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtInventarioID_Internalname, GXutil.ltrim( localUtil.ntoc( A53InventarioID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A53InventarioID), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtInventarioID_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtInventarioID_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Inventario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtInventarioFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtInventarioFecha_Internalname, httpContext.getMessage( "Inventario Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtInventarioFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtInventarioFecha_Internalname, localUtil.format(A257InventarioFecha, "99/99/99"), localUtil.format( A257InventarioFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtInventarioFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtInventarioFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Inventario.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtInventarioFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtInventarioFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Inventario.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtInventarioDetalle_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtInventarioDetalle_Internalname, httpContext.getMessage( "Inventario Detalle", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtInventarioDetalle_Internalname, A258InventarioDetalle, GXutil.rtrim( localUtil.format( A258InventarioDetalle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtInventarioDetalle_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtInventarioDetalle_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Detalle", "left", true, "", "HLP_Inventario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtInventarioNumeroProceso_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtInventarioNumeroProceso_Internalname, httpContext.getMessage( "Numero Proceso", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtInventarioNumeroProceso_Internalname, GXutil.ltrim( localUtil.ntoc( A265InventarioNumeroProceso, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtInventarioNumeroProceso_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtInventarioNumeroProceso_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtInventarioNumeroProceso_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Inventario.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Inventario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Inventario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Inventario.htm");
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
      startgridcontrol44( ) ;
      nGXsfl_44_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount50 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_50 = (short)(1) ;
            scanStart1750( ) ;
            while ( RcdFound50 != 0 )
            {
               init_level_properties50( ) ;
               getByPrimaryKey1750( ) ;
               addRow1750( ) ;
               scanNext1750( ) ;
            }
            scanEnd1750( ) ;
            nBlankRcdCount50 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal1750( ) ;
         standaloneModal1750( ) ;
         sMode50 = Gx_mode ;
         while ( nGXsfl_44_idx < nRC_GXsfl_44 )
         {
            bGXsfl_44_Refreshing = true ;
            readRow1750( ) ;
            edtInventarioDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLEID_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtArticuloStock_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOSTOCK_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloStock_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtInventarioDetalleStock_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtInventarioDetalleDiferencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleDiferencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleDiferencia_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtInventarioDetalleStock2_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK2_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock2_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtInventarioDetalleStock3_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK3_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock3_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtInventarioDetalleStock4_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK4_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock4_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtInventarioDetalleStockOk_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStockOk_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStockOk_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            imgprompt_13_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_44_idx+"Link") ;
            if ( ( nRcdExists_50 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1750( ) ;
            }
            sendRow1750( ) ;
            bGXsfl_44_Refreshing = false ;
         }
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount50 = (short)(5) ;
         nRcdExists_50 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1750( ) ;
            while ( RcdFound50 != 0 )
            {
               sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_4450( ) ;
               init_level_properties50( ) ;
               standaloneNotModal1750( ) ;
               getByPrimaryKey1750( ) ;
               standaloneModal1750( ) ;
               addRow1750( ) ;
               scanNext1750( ) ;
            }
            scanEnd1750( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode50 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_4450( ) ;
         initAll1750( ) ;
         init_level_properties50( ) ;
         nRcdExists_50 = (short)(0) ;
         nIsMod_50 = (short)(0) ;
         nRcdDeleted_50 = (short)(0) ;
         nBlankRcdCount50 = (short)(nBlankRcdUsr50+nBlankRcdCount50) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount50 > 0 )
         {
            standaloneNotModal1750( ) ;
            standaloneModal1750( ) ;
            addRow1750( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtInventarioDetalleID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount50 = (short)(nBlankRcdCount50-1) ;
         }
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
      e11172 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z53InventarioID = localUtil.ctol( httpContext.cgiGet( "Z53InventarioID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z257InventarioFecha = localUtil.ctod( httpContext.cgiGet( "Z257InventarioFecha"), 0) ;
            Z258InventarioDetalle = httpContext.cgiGet( "Z258InventarioDetalle") ;
            Z265InventarioNumeroProceso = (short)(localUtil.ctol( httpContext.cgiGet( "Z265InventarioNumeroProceso"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_44 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_44"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7InventarioID = localUtil.ctol( httpContext.cgiGet( "vINVENTARIOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "INVENTARIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtInventarioID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A53InventarioID = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
            }
            else
            {
               A53InventarioID = localUtil.ctol( httpContext.cgiGet( edtInventarioID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtInventarioFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "INVENTARIOFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtInventarioFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A257InventarioFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A257InventarioFecha", localUtil.format(A257InventarioFecha, "99/99/99"));
            }
            else
            {
               A257InventarioFecha = localUtil.ctod( httpContext.cgiGet( edtInventarioFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A257InventarioFecha", localUtil.format(A257InventarioFecha, "99/99/99"));
            }
            A258InventarioDetalle = httpContext.cgiGet( edtInventarioDetalle_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A258InventarioDetalle", A258InventarioDetalle);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioNumeroProceso_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioNumeroProceso_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "INVENTARIONUMEROPROCESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtInventarioNumeroProceso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A265InventarioNumeroProceso = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A265InventarioNumeroProceso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), 4, 0));
            }
            else
            {
               A265InventarioNumeroProceso = (short)(localUtil.ctol( httpContext.cgiGet( edtInventarioNumeroProceso_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A265InventarioNumeroProceso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Inventario");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A53InventarioID != Z53InventarioID ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("inventario:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A53InventarioID = GXutil.lval( httpContext.GetPar( "InventarioID")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
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
                  sMode49 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode49 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound49 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_170( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "INVENTARIOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtInventarioID_Internalname ;
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
                        e11172 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12172 ();
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
         e12172 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1749( ) ;
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
         disableAttributes1749( ) ;
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

   public void confirm_170( )
   {
      beforeValidate1749( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1749( ) ;
         }
         else
         {
            checkExtendedTable1749( ) ;
            closeExtendedTableCursors1749( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode49 = Gx_mode ;
         confirm_1750( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode49 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_1750( )
   {
      nGXsfl_44_idx = 0 ;
      while ( nGXsfl_44_idx < nRC_GXsfl_44 )
      {
         readRow1750( ) ;
         if ( ( nRcdExists_50 != 0 ) || ( nIsMod_50 != 0 ) )
         {
            getKey1750( ) ;
            if ( ( nRcdExists_50 == 0 ) && ( nRcdDeleted_50 == 0 ) )
            {
               if ( RcdFound50 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1750( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1750( ) ;
                     closeExtendedTableCursors1750( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "INVENTARIODETALLEID_" + sGXsfl_44_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtInventarioDetalleID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound50 != 0 )
               {
                  if ( nRcdDeleted_50 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1750( ) ;
                     load1750( ) ;
                     beforeValidate1750( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1750( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_50 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1750( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1750( ) ;
                           closeExtendedTableCursors1750( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_50 == 0 )
                  {
                     GXCCtl = "INVENTARIODETALLEID_" + sGXsfl_44_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtInventarioDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtInventarioDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A54InventarioDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtArticuloStock_Internalname, GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock_Internalname, GXutil.ltrim( localUtil.ntoc( A259InventarioDetalleStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleDiferencia_Internalname, GXutil.ltrim( localUtil.ntoc( A260InventarioDetalleDiferencia, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock2_Internalname, GXutil.ltrim( localUtil.ntoc( A262InventarioDetalleStock2, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock3_Internalname, GXutil.ltrim( localUtil.ntoc( A263InventarioDetalleStock3, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock4_Internalname, GXutil.ltrim( localUtil.ntoc( A264InventarioDetalleStock4, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStockOk_Internalname, GXutil.ltrim( localUtil.ntoc( A261InventarioDetalleStockOk, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z54InventarioDetalleID_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z54InventarioDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z259InventarioDetalleStock_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z259InventarioDetalleStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z262InventarioDetalleStock2_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z262InventarioDetalleStock2, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z263InventarioDetalleStock3_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z263InventarioDetalleStock3, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z264InventarioDetalleStock4_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z264InventarioDetalleStock4, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z261InventarioDetalleStockOk_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z261InventarioDetalleStockOk, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_50_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_50_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_50_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_50 != 0 )
         {
            httpContext.changePostValue( "INVENTARIODETALLEID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOSTOCK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloStock_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleDiferencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK2_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock2_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK3_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock3_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK4_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock4_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStockOk_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption170( )
   {
   }

   public void e11172( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e12172( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXv_int2[0] = A53InventarioID ;
         new com.mujermorena.articulosinventario(remoteHandle, context).execute( GXv_int2) ;
         inventario_impl.this.A53InventarioID = GXv_int2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.inventarioww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void zm1749( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z257InventarioFecha = T00176_A257InventarioFecha[0] ;
            Z258InventarioDetalle = T00176_A258InventarioDetalle[0] ;
            Z265InventarioNumeroProceso = T00176_A265InventarioNumeroProceso[0] ;
         }
         else
         {
            Z257InventarioFecha = A257InventarioFecha ;
            Z258InventarioDetalle = A258InventarioDetalle ;
            Z265InventarioNumeroProceso = A265InventarioNumeroProceso ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z53InventarioID = A53InventarioID ;
         Z257InventarioFecha = A257InventarioFecha ;
         Z258InventarioDetalle = A258InventarioDetalle ;
         Z265InventarioNumeroProceso = A265InventarioNumeroProceso ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7InventarioID) )
      {
         A53InventarioID = AV7InventarioID ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int3 = A53InventarioID ;
            GXv_int2[0] = GXt_int3 ;
            new com.mujermorena.numeradorinv(remoteHandle, context).execute( GXv_int2) ;
            inventario_impl.this.GXt_int3 = GXv_int2[0] ;
            A53InventarioID = GXt_int3 ;
            httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
         }
      }
      if ( ! (0==AV7InventarioID) )
      {
         edtInventarioID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtInventarioID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioID_Enabled), 5, 0), true);
      }
      else
      {
         edtInventarioID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtInventarioID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioID_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7InventarioID) )
      {
         edtInventarioID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtInventarioID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioID_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
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
   }

   public void load1749( )
   {
      /* Using cursor T00177 */
      pr_default.execute(5, new Object[] {Long.valueOf(A53InventarioID)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A257InventarioFecha = T00177_A257InventarioFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A257InventarioFecha", localUtil.format(A257InventarioFecha, "99/99/99"));
         A258InventarioDetalle = T00177_A258InventarioDetalle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A258InventarioDetalle", A258InventarioDetalle);
         A265InventarioNumeroProceso = T00177_A265InventarioNumeroProceso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A265InventarioNumeroProceso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), 4, 0));
         zm1749( -6) ;
      }
      pr_default.close(5);
      onLoadActions1749( ) ;
   }

   public void onLoadActions1749( )
   {
   }

   public void checkExtendedTable1749( )
   {
      nIsDirty_49 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A257InventarioFecha)) || (( GXutil.resetTime(A257InventarioFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A257InventarioFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Inventario Fecha", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "INVENTARIOFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1749( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1749( )
   {
      /* Using cursor T00178 */
      pr_default.execute(6, new Object[] {Long.valueOf(A53InventarioID)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound49 = (short)(1) ;
      }
      else
      {
         RcdFound49 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00176 */
      pr_default.execute(4, new Object[] {Long.valueOf(A53InventarioID)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm1749( 6) ;
         RcdFound49 = (short)(1) ;
         A53InventarioID = T00176_A53InventarioID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
         A257InventarioFecha = T00176_A257InventarioFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A257InventarioFecha", localUtil.format(A257InventarioFecha, "99/99/99"));
         A258InventarioDetalle = T00176_A258InventarioDetalle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A258InventarioDetalle", A258InventarioDetalle);
         A265InventarioNumeroProceso = T00176_A265InventarioNumeroProceso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A265InventarioNumeroProceso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), 4, 0));
         Z53InventarioID = A53InventarioID ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1749( ) ;
         if ( AnyError == 1 )
         {
            RcdFound49 = (short)(0) ;
            initializeNonKey1749( ) ;
         }
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound49 = (short)(0) ;
         initializeNonKey1749( ) ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey1749( ) ;
      if ( RcdFound49 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound49 = (short)(0) ;
      /* Using cursor T00179 */
      pr_default.execute(7, new Object[] {Long.valueOf(A53InventarioID)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00179_A53InventarioID[0] < A53InventarioID ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00179_A53InventarioID[0] > A53InventarioID ) ) )
         {
            A53InventarioID = T00179_A53InventarioID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
            RcdFound49 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound49 = (short)(0) ;
      /* Using cursor T001710 */
      pr_default.execute(8, new Object[] {Long.valueOf(A53InventarioID)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001710_A53InventarioID[0] > A53InventarioID ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001710_A53InventarioID[0] < A53InventarioID ) ) )
         {
            A53InventarioID = T001710_A53InventarioID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
            RcdFound49 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1749( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtInventarioID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1749( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound49 == 1 )
         {
            if ( A53InventarioID != Z53InventarioID )
            {
               A53InventarioID = Z53InventarioID ;
               httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "INVENTARIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtInventarioID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtInventarioID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1749( ) ;
               GX_FocusControl = edtInventarioID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A53InventarioID != Z53InventarioID )
            {
               /* Insert record */
               GX_FocusControl = edtInventarioID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1749( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "INVENTARIOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtInventarioID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtInventarioID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1749( ) ;
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
      if ( A53InventarioID != Z53InventarioID )
      {
         A53InventarioID = Z53InventarioID ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "INVENTARIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtInventarioID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1749( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00175 */
         pr_default.execute(3, new Object[] {Long.valueOf(A53InventarioID)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Inventario"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(3) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z257InventarioFecha), GXutil.resetTime(T00175_A257InventarioFecha[0])) ) || ( GXutil.strcmp(Z258InventarioDetalle, T00175_A258InventarioDetalle[0]) != 0 ) || ( Z265InventarioNumeroProceso != T00175_A265InventarioNumeroProceso[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z257InventarioFecha), GXutil.resetTime(T00175_A257InventarioFecha[0])) ) )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioFecha");
               GXutil.writeLogRaw("Old: ",Z257InventarioFecha);
               GXutil.writeLogRaw("Current: ",T00175_A257InventarioFecha[0]);
            }
            if ( GXutil.strcmp(Z258InventarioDetalle, T00175_A258InventarioDetalle[0]) != 0 )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioDetalle");
               GXutil.writeLogRaw("Old: ",Z258InventarioDetalle);
               GXutil.writeLogRaw("Current: ",T00175_A258InventarioDetalle[0]);
            }
            if ( Z265InventarioNumeroProceso != T00175_A265InventarioNumeroProceso[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioNumeroProceso");
               GXutil.writeLogRaw("Old: ",Z265InventarioNumeroProceso);
               GXutil.writeLogRaw("Current: ",T00175_A265InventarioNumeroProceso[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Inventario"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1749( )
   {
      if ( ! IsAuthorized("inventario_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1749( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1749( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1749( 0) ;
         checkOptimisticConcurrency1749( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1749( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1749( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001711 */
                  pr_default.execute(9, new Object[] {Long.valueOf(A53InventarioID), A257InventarioFecha, A258InventarioDetalle, Short.valueOf(A265InventarioNumeroProceso)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Inventario");
                  if ( (pr_default.getStatus(9) == 1) )
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
                        processLevel1749( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption170( ) ;
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
            load1749( ) ;
         }
         endLevel1749( ) ;
      }
      closeExtendedTableCursors1749( ) ;
   }

   public void update1749( )
   {
      if ( ! IsAuthorized("inventario_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1749( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1749( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1749( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1749( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1749( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001712 */
                  pr_default.execute(10, new Object[] {A257InventarioFecha, A258InventarioDetalle, Short.valueOf(A265InventarioNumeroProceso), Long.valueOf(A53InventarioID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Inventario");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Inventario"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1749( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1749( ) ;
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
         endLevel1749( ) ;
      }
      closeExtendedTableCursors1749( ) ;
   }

   public void deferredUpdate1749( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("inventario_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1749( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1749( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1749( ) ;
         afterConfirm1749( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1749( ) ;
            if ( AnyError == 0 )
            {
               scanStart1750( ) ;
               while ( RcdFound50 != 0 )
               {
                  getByPrimaryKey1750( ) ;
                  delete1750( ) ;
                  scanNext1750( ) ;
               }
               scanEnd1750( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001713 */
                  pr_default.execute(11, new Object[] {Long.valueOf(A53InventarioID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Inventario");
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
      sMode49 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1749( ) ;
      Gx_mode = sMode49 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1749( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel1750( )
   {
      nGXsfl_44_idx = 0 ;
      while ( nGXsfl_44_idx < nRC_GXsfl_44 )
      {
         readRow1750( ) ;
         if ( ( nRcdExists_50 != 0 ) || ( nIsMod_50 != 0 ) )
         {
            standaloneNotModal1750( ) ;
            getKey1750( ) ;
            if ( ( nRcdExists_50 == 0 ) && ( nRcdDeleted_50 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1750( ) ;
            }
            else
            {
               if ( RcdFound50 != 0 )
               {
                  if ( ( nRcdDeleted_50 != 0 ) && ( nRcdExists_50 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1750( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_50 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1750( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_50 == 0 )
                  {
                     GXCCtl = "INVENTARIODETALLEID_" + sGXsfl_44_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtInventarioDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtInventarioDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A54InventarioDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtArticuloStock_Internalname, GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock_Internalname, GXutil.ltrim( localUtil.ntoc( A259InventarioDetalleStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleDiferencia_Internalname, GXutil.ltrim( localUtil.ntoc( A260InventarioDetalleDiferencia, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock2_Internalname, GXutil.ltrim( localUtil.ntoc( A262InventarioDetalleStock2, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock3_Internalname, GXutil.ltrim( localUtil.ntoc( A263InventarioDetalleStock3, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStock4_Internalname, GXutil.ltrim( localUtil.ntoc( A264InventarioDetalleStock4, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtInventarioDetalleStockOk_Internalname, GXutil.ltrim( localUtil.ntoc( A261InventarioDetalleStockOk, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z54InventarioDetalleID_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z54InventarioDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z259InventarioDetalleStock_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z259InventarioDetalleStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z262InventarioDetalleStock2_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z262InventarioDetalleStock2, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z263InventarioDetalleStock3_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z263InventarioDetalleStock3, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z264InventarioDetalleStock4_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z264InventarioDetalleStock4, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z261InventarioDetalleStockOk_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z261InventarioDetalleStockOk, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_50_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_50_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_50_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_50 != 0 )
         {
            httpContext.changePostValue( "INVENTARIODETALLEID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOSTOCK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloStock_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleDiferencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK2_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock2_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK3_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock3_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCK4_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock4_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStockOk_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1750( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_50 = (short)(0) ;
      nIsMod_50 = (short)(0) ;
      nRcdDeleted_50 = (short)(0) ;
   }

   public void processLevel1749( )
   {
      /* Save parent mode. */
      sMode49 = Gx_mode ;
      processNestedLevel1750( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode49 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1749( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1749( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.commitDataStores(context, remoteHandle, pr_default, "inventario");
         if ( AnyError == 0 )
         {
            confirmValues170( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "inventario");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1749( )
   {
      /* Scan By routine */
      /* Using cursor T001714 */
      pr_default.execute(12);
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A53InventarioID = T001714_A53InventarioID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1749( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A53InventarioID = T001714_A53InventarioID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
      }
   }

   public void scanEnd1749( )
   {
      pr_default.close(12);
   }

   public void afterConfirm1749( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1749( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1749( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1749( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1749( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1749( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1749( )
   {
      edtInventarioID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioID_Enabled), 5, 0), true);
      edtInventarioFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioFecha_Enabled), 5, 0), true);
      edtInventarioDetalle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalle_Enabled), 5, 0), true);
      edtInventarioNumeroProceso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioNumeroProceso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioNumeroProceso_Enabled), 5, 0), true);
   }

   public void zm1750( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z259InventarioDetalleStock = T00173_A259InventarioDetalleStock[0] ;
            Z262InventarioDetalleStock2 = T00173_A262InventarioDetalleStock2[0] ;
            Z263InventarioDetalleStock3 = T00173_A263InventarioDetalleStock3[0] ;
            Z264InventarioDetalleStock4 = T00173_A264InventarioDetalleStock4[0] ;
            Z261InventarioDetalleStockOk = T00173_A261InventarioDetalleStockOk[0] ;
            Z13ArticuloId = T00173_A13ArticuloId[0] ;
         }
         else
         {
            Z259InventarioDetalleStock = A259InventarioDetalleStock ;
            Z262InventarioDetalleStock2 = A262InventarioDetalleStock2 ;
            Z263InventarioDetalleStock3 = A263InventarioDetalleStock3 ;
            Z264InventarioDetalleStock4 = A264InventarioDetalleStock4 ;
            Z261InventarioDetalleStockOk = A261InventarioDetalleStockOk ;
            Z13ArticuloId = A13ArticuloId ;
         }
      }
      if ( GX_JID == -7 )
      {
         Z53InventarioID = A53InventarioID ;
         Z54InventarioDetalleID = A54InventarioDetalleID ;
         Z259InventarioDetalleStock = A259InventarioDetalleStock ;
         Z262InventarioDetalleStock2 = A262InventarioDetalleStock2 ;
         Z263InventarioDetalleStock3 = A263InventarioDetalleStock3 ;
         Z264InventarioDetalleStock4 = A264InventarioDetalleStock4 ;
         Z261InventarioDetalleStockOk = A261InventarioDetalleStockOk ;
         Z13ArticuloId = A13ArticuloId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
         Z79ArticuloStock = A79ArticuloStock ;
      }
   }

   public void standaloneNotModal1750( )
   {
   }

   public void standaloneModal1750( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtInventarioDetalleID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      }
      else
      {
         edtInventarioDetalleID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      }
   }

   public void load1750( )
   {
      /* Using cursor T001715 */
      pr_default.execute(13, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A76ArticuloNombre = T001715_A76ArticuloNombre[0] ;
         A79ArticuloStock = T001715_A79ArticuloStock[0] ;
         A259InventarioDetalleStock = T001715_A259InventarioDetalleStock[0] ;
         A262InventarioDetalleStock2 = T001715_A262InventarioDetalleStock2[0] ;
         A263InventarioDetalleStock3 = T001715_A263InventarioDetalleStock3[0] ;
         A264InventarioDetalleStock4 = T001715_A264InventarioDetalleStock4[0] ;
         A261InventarioDetalleStockOk = T001715_A261InventarioDetalleStockOk[0] ;
         A13ArticuloId = T001715_A13ArticuloId[0] ;
         zm1750( -7) ;
      }
      pr_default.close(13);
      onLoadActions1750( ) ;
   }

   public void onLoadActions1750( )
   {
      A260InventarioDetalleDiferencia = (long)(A79ArticuloStock-A261InventarioDetalleStockOk) ;
   }

   public void checkExtendedTable1750( )
   {
      nIsDirty_50 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1750( ) ;
      /* Using cursor T00174 */
      pr_default.execute(2, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A76ArticuloNombre = T00174_A76ArticuloNombre[0] ;
      A79ArticuloStock = T00174_A79ArticuloStock[0] ;
      pr_default.close(2);
      nIsDirty_50 = (short)(1) ;
      A260InventarioDetalleDiferencia = (long)(A79ArticuloStock-A261InventarioDetalleStockOk) ;
   }

   public void closeExtendedTableCursors1750( )
   {
      pr_default.close(2);
   }

   public void enableDisable1750( )
   {
   }

   public void gxload_8( long A13ArticuloId )
   {
      /* Using cursor T001716 */
      pr_default.execute(14, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A76ArticuloNombre = T001716_A76ArticuloNombre[0] ;
      A79ArticuloStock = T001716_A79ArticuloStock[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A76ArticuloNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey1750( )
   {
      /* Using cursor T001717 */
      pr_default.execute(15, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound50 = (short)(1) ;
      }
      else
      {
         RcdFound50 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey1750( )
   {
      /* Using cursor T00173 */
      pr_default.execute(1, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1750( 7) ;
         RcdFound50 = (short)(1) ;
         initializeNonKey1750( ) ;
         A54InventarioDetalleID = T00173_A54InventarioDetalleID[0] ;
         A259InventarioDetalleStock = T00173_A259InventarioDetalleStock[0] ;
         A262InventarioDetalleStock2 = T00173_A262InventarioDetalleStock2[0] ;
         A263InventarioDetalleStock3 = T00173_A263InventarioDetalleStock3[0] ;
         A264InventarioDetalleStock4 = T00173_A264InventarioDetalleStock4[0] ;
         A261InventarioDetalleStockOk = T00173_A261InventarioDetalleStockOk[0] ;
         A13ArticuloId = T00173_A13ArticuloId[0] ;
         Z53InventarioID = A53InventarioID ;
         Z54InventarioDetalleID = A54InventarioDetalleID ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1750( ) ;
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound50 = (short)(0) ;
         initializeNonKey1750( ) ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1750( ) ;
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1750( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1750( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00172 */
         pr_default.execute(0, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"InventarioDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z259InventarioDetalleStock != T00172_A259InventarioDetalleStock[0] ) || ( Z262InventarioDetalleStock2 != T00172_A262InventarioDetalleStock2[0] ) || ( Z263InventarioDetalleStock3 != T00172_A263InventarioDetalleStock3[0] ) || ( Z264InventarioDetalleStock4 != T00172_A264InventarioDetalleStock4[0] ) || ( Z261InventarioDetalleStockOk != T00172_A261InventarioDetalleStockOk[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z13ArticuloId != T00172_A13ArticuloId[0] ) )
         {
            if ( Z259InventarioDetalleStock != T00172_A259InventarioDetalleStock[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioDetalleStock");
               GXutil.writeLogRaw("Old: ",Z259InventarioDetalleStock);
               GXutil.writeLogRaw("Current: ",T00172_A259InventarioDetalleStock[0]);
            }
            if ( Z262InventarioDetalleStock2 != T00172_A262InventarioDetalleStock2[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioDetalleStock2");
               GXutil.writeLogRaw("Old: ",Z262InventarioDetalleStock2);
               GXutil.writeLogRaw("Current: ",T00172_A262InventarioDetalleStock2[0]);
            }
            if ( Z263InventarioDetalleStock3 != T00172_A263InventarioDetalleStock3[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioDetalleStock3");
               GXutil.writeLogRaw("Old: ",Z263InventarioDetalleStock3);
               GXutil.writeLogRaw("Current: ",T00172_A263InventarioDetalleStock3[0]);
            }
            if ( Z264InventarioDetalleStock4 != T00172_A264InventarioDetalleStock4[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioDetalleStock4");
               GXutil.writeLogRaw("Old: ",Z264InventarioDetalleStock4);
               GXutil.writeLogRaw("Current: ",T00172_A264InventarioDetalleStock4[0]);
            }
            if ( Z261InventarioDetalleStockOk != T00172_A261InventarioDetalleStockOk[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"InventarioDetalleStockOk");
               GXutil.writeLogRaw("Old: ",Z261InventarioDetalleStockOk);
               GXutil.writeLogRaw("Current: ",T00172_A261InventarioDetalleStockOk[0]);
            }
            if ( Z13ArticuloId != T00172_A13ArticuloId[0] )
            {
               GXutil.writeLogln("inventario:[seudo value changed for attri]"+"ArticuloId");
               GXutil.writeLogRaw("Old: ",Z13ArticuloId);
               GXutil.writeLogRaw("Current: ",T00172_A13ArticuloId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"InventarioDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1750( )
   {
      if ( ! IsAuthorized("inventario_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1750( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1750( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1750( 0) ;
         checkOptimisticConcurrency1750( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1750( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1750( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001718 */
                  pr_default.execute(16, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID), Long.valueOf(A259InventarioDetalleStock), Long.valueOf(A262InventarioDetalleStock2), Long.valueOf(A263InventarioDetalleStock3), Long.valueOf(A264InventarioDetalleStock4), Long.valueOf(A261InventarioDetalleStockOk), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("InventarioDetalle");
                  if ( (pr_default.getStatus(16) == 1) )
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
            load1750( ) ;
         }
         endLevel1750( ) ;
      }
      closeExtendedTableCursors1750( ) ;
   }

   public void update1750( )
   {
      if ( ! IsAuthorized("inventario_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1750( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1750( ) ;
      }
      if ( ( nIsMod_50 != 0 ) || ( nIsDirty_50 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1750( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1750( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1750( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001719 */
                     pr_default.execute(17, new Object[] {Long.valueOf(A259InventarioDetalleStock), Long.valueOf(A262InventarioDetalleStock2), Long.valueOf(A263InventarioDetalleStock3), Long.valueOf(A264InventarioDetalleStock4), Long.valueOf(A261InventarioDetalleStockOk), Long.valueOf(A13ArticuloId), Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("InventarioDetalle");
                     if ( (pr_default.getStatus(17) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"InventarioDetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1750( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1750( ) ;
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
            endLevel1750( ) ;
         }
      }
      closeExtendedTableCursors1750( ) ;
   }

   public void deferredUpdate1750( )
   {
   }

   public void delete1750( )
   {
      if ( ! IsAuthorized("inventario_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1750( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1750( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1750( ) ;
         afterConfirm1750( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1750( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001720 */
               pr_default.execute(18, new Object[] {Long.valueOf(A53InventarioID), Long.valueOf(A54InventarioDetalleID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("InventarioDetalle");
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
      sMode50 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1750( ) ;
      Gx_mode = sMode50 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1750( )
   {
      standaloneModal1750( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001721 */
         pr_default.execute(19, new Object[] {Long.valueOf(A13ArticuloId)});
         A76ArticuloNombre = T001721_A76ArticuloNombre[0] ;
         A79ArticuloStock = T001721_A79ArticuloStock[0] ;
         pr_default.close(19);
         A260InventarioDetalleDiferencia = (long)(A79ArticuloStock-A261InventarioDetalleStockOk) ;
      }
   }

   public void endLevel1750( )
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

   public void scanStart1750( )
   {
      /* Scan By routine */
      /* Using cursor T001722 */
      pr_default.execute(20, new Object[] {Long.valueOf(A53InventarioID)});
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A54InventarioDetalleID = T001722_A54InventarioDetalleID[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1750( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A54InventarioDetalleID = T001722_A54InventarioDetalleID[0] ;
      }
   }

   public void scanEnd1750( )
   {
      pr_default.close(20);
   }

   public void afterConfirm1750( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1750( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1750( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1750( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1750( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1750( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1750( )
   {
      edtInventarioDetalleID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtArticuloStock_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloStock_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtInventarioDetalleStock_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtInventarioDetalleDiferencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleDiferencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleDiferencia_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtInventarioDetalleStock2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock2_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtInventarioDetalleStock3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock3_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtInventarioDetalleStock4_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStock4_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStock4_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtInventarioDetalleStockOk_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleStockOk_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleStockOk_Enabled), 5, 0), !bGXsfl_44_Refreshing);
   }

   public void send_integrity_lvl_hashes1750( )
   {
   }

   public void send_integrity_lvl_hashes1749( )
   {
   }

   public void subsflControlProps_4450( )
   {
      edtInventarioDetalleID_Internalname = "INVENTARIODETALLEID_"+sGXsfl_44_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_44_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_44_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_44_idx ;
      edtArticuloStock_Internalname = "ARTICULOSTOCK_"+sGXsfl_44_idx ;
      edtInventarioDetalleStock_Internalname = "INVENTARIODETALLESTOCK_"+sGXsfl_44_idx ;
      edtInventarioDetalleDiferencia_Internalname = "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_idx ;
      edtInventarioDetalleStock2_Internalname = "INVENTARIODETALLESTOCK2_"+sGXsfl_44_idx ;
      edtInventarioDetalleStock3_Internalname = "INVENTARIODETALLESTOCK3_"+sGXsfl_44_idx ;
      edtInventarioDetalleStock4_Internalname = "INVENTARIODETALLESTOCK4_"+sGXsfl_44_idx ;
      edtInventarioDetalleStockOk_Internalname = "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_idx ;
   }

   public void subsflControlProps_fel_4450( )
   {
      edtInventarioDetalleID_Internalname = "INVENTARIODETALLEID_"+sGXsfl_44_fel_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_44_fel_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_44_fel_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_44_fel_idx ;
      edtArticuloStock_Internalname = "ARTICULOSTOCK_"+sGXsfl_44_fel_idx ;
      edtInventarioDetalleStock_Internalname = "INVENTARIODETALLESTOCK_"+sGXsfl_44_fel_idx ;
      edtInventarioDetalleDiferencia_Internalname = "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_fel_idx ;
      edtInventarioDetalleStock2_Internalname = "INVENTARIODETALLESTOCK2_"+sGXsfl_44_fel_idx ;
      edtInventarioDetalleStock3_Internalname = "INVENTARIODETALLESTOCK3_"+sGXsfl_44_fel_idx ;
      edtInventarioDetalleStock4_Internalname = "INVENTARIODETALLESTOCK4_"+sGXsfl_44_fel_idx ;
      edtInventarioDetalleStockOk_Internalname = "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_fel_idx ;
   }

   public void addRow1750( )
   {
      nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
      sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4450( ) ;
      sendRow1750( ) ;
   }

   public void sendRow1750( )
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
         if ( ((int)((nGXsfl_44_idx) % (2))) == 0 )
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
      imgprompt_13_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.articuloprompt"+"',["+"{Ctrl:gx.dom.el('"+"ARTICULOID_"+sGXsfl_44_idx+"'), id:'"+"ARTICULOID_"+sGXsfl_44_idx+"'"+",IOType:'inout'}"+"],"+"gx.dom.form()."+"nIsMod_50_"+sGXsfl_44_idx+","+"'', false"+","+"false"+");") ;
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleID_Internalname,GXutil.ltrim( localUtil.ntoc( A54InventarioDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A54InventarioDetalleID), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,45);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleID_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloId_Internalname,GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,46);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_13_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_13_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      Gridlevel_detalleRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgprompt_13_Internalname,sImgUrl,imgprompt_13_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(imgprompt_13_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloNombre_Internalname,GXutil.rtrim( A76ArticuloNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloStock_Internalname,GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloStock_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloStock_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloStock_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleStock_Internalname,GXutil.ltrim( localUtil.ntoc( A259InventarioDetalleStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtInventarioDetalleStock_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A259InventarioDetalleStock), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A259InventarioDetalleStock), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleStock_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleStock_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleDiferencia_Internalname,GXutil.ltrim( localUtil.ntoc( A260InventarioDetalleDiferencia, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtInventarioDetalleDiferencia_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A260InventarioDetalleDiferencia), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A260InventarioDetalleDiferencia), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleDiferencia_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleDiferencia_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 51,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleStock2_Internalname,GXutil.ltrim( localUtil.ntoc( A262InventarioDetalleStock2, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtInventarioDetalleStock2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A262InventarioDetalleStock2), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A262InventarioDetalleStock2), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,51);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleStock2_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleStock2_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleStock3_Internalname,GXutil.ltrim( localUtil.ntoc( A263InventarioDetalleStock3, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtInventarioDetalleStock3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A263InventarioDetalleStock3), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A263InventarioDetalleStock3), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleStock3_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleStock3_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleStock4_Internalname,GXutil.ltrim( localUtil.ntoc( A264InventarioDetalleStock4, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtInventarioDetalleStock4_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A264InventarioDetalleStock4), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A264InventarioDetalleStock4), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleStock4_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleStock4_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_50_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtInventarioDetalleStockOk_Internalname,GXutil.ltrim( localUtil.ntoc( A261InventarioDetalleStockOk, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtInventarioDetalleStockOk_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A261InventarioDetalleStockOk), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A261InventarioDetalleStockOk), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtInventarioDetalleStockOk_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtInventarioDetalleStockOk_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes1750( ) ;
      GXCCtl = "Z54InventarioDetalleID_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z54InventarioDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z259InventarioDetalleStock_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z259InventarioDetalleStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z262InventarioDetalleStock2_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z262InventarioDetalleStock2, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z263InventarioDetalleStock3_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z263InventarioDetalleStock3, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z264InventarioDetalleStock4_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z264InventarioDetalleStock4, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z261InventarioDetalleStockOk_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z261InventarioDetalleStockOk, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z13ArticuloId_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_50_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_50_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_50_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_50, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_44_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV11TrnContext);
      }
      GXCCtl = "vINVENTARIOID_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7InventarioID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLEID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULONOMBRE_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOSTOCK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloStock_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLESTOCK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleDiferencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLESTOCK2_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock2_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLESTOCK3_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock3_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLESTOCK4_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock4_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStockOk_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PROMPT_13_"+sGXsfl_44_idx+"Link", GXutil.rtrim( imgprompt_13_Link));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow1750( )
   {
      nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
      sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4450( ) ;
      edtInventarioDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLEID_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloStock_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOSTOCK_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtInventarioDetalleStock_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtInventarioDetalleDiferencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLEDIFERENCIA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtInventarioDetalleStock2_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK2_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtInventarioDetalleStock3_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK3_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtInventarioDetalleStock4_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCK4_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtInventarioDetalleStockOk_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "INVENTARIODETALLESTOCKOK_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      imgprompt_13_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_44_idx+"Link") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "INVENTARIODETALLEID_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioDetalleID_Internalname ;
         wbErr = true ;
         A54InventarioDetalleID = 0 ;
      }
      else
      {
         A54InventarioDetalleID = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_44_idx ;
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
      A79ArticuloStock = localUtil.ctol( httpContext.cgiGet( edtArticuloStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "INVENTARIODETALLESTOCK_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioDetalleStock_Internalname ;
         wbErr = true ;
         A259InventarioDetalleStock = 0 ;
      }
      else
      {
         A259InventarioDetalleStock = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      A260InventarioDetalleDiferencia = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleDiferencia_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "INVENTARIODETALLESTOCK2_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioDetalleStock2_Internalname ;
         wbErr = true ;
         A262InventarioDetalleStock2 = 0 ;
      }
      else
      {
         A262InventarioDetalleStock2 = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "INVENTARIODETALLESTOCK3_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioDetalleStock3_Internalname ;
         wbErr = true ;
         A263InventarioDetalleStock3 = 0 ;
      }
      else
      {
         A263InventarioDetalleStock3 = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock4_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock4_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "INVENTARIODETALLESTOCK4_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioDetalleStock4_Internalname ;
         wbErr = true ;
         A264InventarioDetalleStock4 = 0 ;
      }
      else
      {
         A264InventarioDetalleStock4 = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStock4_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStockOk_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStockOk_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "INVENTARIODETALLESTOCKOK_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtInventarioDetalleStockOk_Internalname ;
         wbErr = true ;
         A261InventarioDetalleStockOk = 0 ;
      }
      else
      {
         A261InventarioDetalleStockOk = localUtil.ctol( httpContext.cgiGet( edtInventarioDetalleStockOk_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      GXCCtl = "Z54InventarioDetalleID_" + sGXsfl_44_idx ;
      Z54InventarioDetalleID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z259InventarioDetalleStock_" + sGXsfl_44_idx ;
      Z259InventarioDetalleStock = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z262InventarioDetalleStock2_" + sGXsfl_44_idx ;
      Z262InventarioDetalleStock2 = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z263InventarioDetalleStock3_" + sGXsfl_44_idx ;
      Z263InventarioDetalleStock3 = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z264InventarioDetalleStock4_" + sGXsfl_44_idx ;
      Z264InventarioDetalleStock4 = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z261InventarioDetalleStockOk_" + sGXsfl_44_idx ;
      Z261InventarioDetalleStockOk = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z13ArticuloId_" + sGXsfl_44_idx ;
      Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "nRcdDeleted_50_" + sGXsfl_44_idx ;
      nRcdDeleted_50 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_50_" + sGXsfl_44_idx ;
      nRcdExists_50 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_50_" + sGXsfl_44_idx ;
      nIsMod_50 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtInventarioDetalleID_Enabled = edtInventarioDetalleID_Enabled ;
   }

   public void confirmValues170( )
   {
      nGXsfl_44_idx = 0 ;
      sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4450( ) ;
      while ( nGXsfl_44_idx < nRC_GXsfl_44 )
      {
         nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
         sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4450( ) ;
         httpContext.changePostValue( "Z54InventarioDetalleID_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z54InventarioDetalleID_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z54InventarioDetalleID_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z259InventarioDetalleStock_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z259InventarioDetalleStock_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z259InventarioDetalleStock_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z262InventarioDetalleStock2_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z262InventarioDetalleStock2_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z262InventarioDetalleStock2_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z263InventarioDetalleStock3_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z263InventarioDetalleStock3_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z263InventarioDetalleStock3_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z264InventarioDetalleStock4_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z264InventarioDetalleStock4_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z264InventarioDetalleStock4_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z261InventarioDetalleStockOk_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z261InventarioDetalleStockOk_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z261InventarioDetalleStockOk_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z13ArticuloId_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z13ArticuloId_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_44_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.inventario", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7InventarioID,11,0))}, new String[] {"Gx_mode","InventarioID"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Inventario");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("inventario:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z53InventarioID", GXutil.ltrim( localUtil.ntoc( Z53InventarioID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z257InventarioFecha", localUtil.dtoc( Z257InventarioFecha, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z258InventarioDetalle", Z258InventarioDetalle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z265InventarioNumeroProceso", GXutil.ltrim( localUtil.ntoc( Z265InventarioNumeroProceso, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_44", GXutil.ltrim( localUtil.ntoc( nGXsfl_44_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINVENTARIOID", GXutil.ltrim( localUtil.ntoc( AV7InventarioID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINVENTARIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7InventarioID), "ZZZZZZZZZZ9")));
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
      return formatLink("com.mujermorena.inventario", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7InventarioID,11,0))}, new String[] {"Gx_mode","InventarioID"})  ;
   }

   public String getPgmname( )
   {
      return "Inventario" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Inventario", "") ;
   }

   public void initializeNonKey1749( )
   {
      A257InventarioFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A257InventarioFecha", localUtil.format(A257InventarioFecha, "99/99/99"));
      A258InventarioDetalle = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A258InventarioDetalle", A258InventarioDetalle);
      A265InventarioNumeroProceso = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A265InventarioNumeroProceso", GXutil.ltrimstr( DecimalUtil.doubleToDec(A265InventarioNumeroProceso), 4, 0));
      Z257InventarioFecha = GXutil.nullDate() ;
      Z258InventarioDetalle = "" ;
      Z265InventarioNumeroProceso = (short)(0) ;
   }

   public void initAll1749( )
   {
      A53InventarioID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
      initializeNonKey1749( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey1750( )
   {
      A260InventarioDetalleDiferencia = 0 ;
      A13ArticuloId = 0 ;
      A76ArticuloNombre = "" ;
      A79ArticuloStock = 0 ;
      A259InventarioDetalleStock = 0 ;
      A262InventarioDetalleStock2 = 0 ;
      A263InventarioDetalleStock3 = 0 ;
      A264InventarioDetalleStock4 = 0 ;
      A261InventarioDetalleStockOk = 0 ;
      Z259InventarioDetalleStock = 0 ;
      Z262InventarioDetalleStock2 = 0 ;
      Z263InventarioDetalleStock3 = 0 ;
      Z264InventarioDetalleStock4 = 0 ;
      Z261InventarioDetalleStockOk = 0 ;
      Z13ArticuloId = 0 ;
   }

   public void initAll1750( )
   {
      A54InventarioDetalleID = 0 ;
      initializeNonKey1750( ) ;
   }

   public void standaloneModalInsert1750( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111105284", true, true);
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
      httpContext.AddJavascriptSource("inventario.js", "?202412111105285", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties50( )
   {
      edtInventarioDetalleID_Enabled = defedtInventarioDetalleID_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtInventarioDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtInventarioDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
   }

   public void startgridcontrol44( )
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
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A54InventarioDetalleID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloStock_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A259InventarioDetalleStock, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A260InventarioDetalleDiferencia, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleDiferencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A262InventarioDetalleStock2, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock2_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A263InventarioDetalleStock3, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock3_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A264InventarioDetalleStock4, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStock4_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A261InventarioDetalleStockOk, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtInventarioDetalleStockOk_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      edtInventarioID_Internalname = "INVENTARIOID" ;
      edtInventarioFecha_Internalname = "INVENTARIOFECHA" ;
      edtInventarioDetalle_Internalname = "INVENTARIODETALLE" ;
      edtInventarioNumeroProceso_Internalname = "INVENTARIONUMEROPROCESO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtInventarioDetalleID_Internalname = "INVENTARIODETALLEID" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtArticuloStock_Internalname = "ARTICULOSTOCK" ;
      edtInventarioDetalleStock_Internalname = "INVENTARIODETALLESTOCK" ;
      edtInventarioDetalleDiferencia_Internalname = "INVENTARIODETALLEDIFERENCIA" ;
      edtInventarioDetalleStock2_Internalname = "INVENTARIODETALLESTOCK2" ;
      edtInventarioDetalleStock3_Internalname = "INVENTARIODETALLESTOCK3" ;
      edtInventarioDetalleStock4_Internalname = "INVENTARIODETALLESTOCK4" ;
      edtInventarioDetalleStockOk_Internalname = "INVENTARIODETALLESTOCKOK" ;
      divTableleaflevel_detalle_Internalname = "TABLELEAFLEVEL_DETALLE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setCaption( httpContext.getMessage( "Inventario", "") );
      edtInventarioDetalleStockOk_Jsonclick = "" ;
      edtInventarioDetalleStock4_Jsonclick = "" ;
      edtInventarioDetalleStock3_Jsonclick = "" ;
      edtInventarioDetalleStock2_Jsonclick = "" ;
      edtInventarioDetalleDiferencia_Jsonclick = "" ;
      edtInventarioDetalleStock_Jsonclick = "" ;
      edtArticuloStock_Jsonclick = "" ;
      edtArticuloNombre_Jsonclick = "" ;
      imgprompt_13_Visible = 1 ;
      imgprompt_13_Link = "" ;
      imgprompt_13_Visible = 1 ;
      edtArticuloId_Jsonclick = "" ;
      edtInventarioDetalleID_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      edtInventarioDetalleStockOk_Enabled = 1 ;
      edtInventarioDetalleStock4_Enabled = 1 ;
      edtInventarioDetalleStock3_Enabled = 1 ;
      edtInventarioDetalleStock2_Enabled = 1 ;
      edtInventarioDetalleDiferencia_Enabled = 0 ;
      edtInventarioDetalleStock_Enabled = 1 ;
      edtArticuloStock_Enabled = 0 ;
      edtArticuloNombre_Enabled = 0 ;
      edtArticuloId_Enabled = 1 ;
      edtInventarioDetalleID_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtInventarioNumeroProceso_Jsonclick = "" ;
      edtInventarioNumeroProceso_Enabled = 1 ;
      edtInventarioDetalle_Jsonclick = "" ;
      edtInventarioDetalle_Enabled = 1 ;
      edtInventarioFecha_Jsonclick = "" ;
      edtInventarioFecha_Enabled = 1 ;
      edtInventarioID_Jsonclick = "" ;
      edtInventarioID_Enabled = 1 ;
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

   public void gx2asainventarioid1749( long AV7InventarioID )
   {
      if ( ! (0==AV7InventarioID) )
      {
         A53InventarioID = AV7InventarioID ;
         httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int3 = A53InventarioID ;
            GXv_int2[0] = GXt_int3 ;
            new com.mujermorena.numeradorinv(remoteHandle, context).execute( GXv_int2) ;
            inventario_impl.this.GXt_int3 = GXv_int2[0] ;
            A53InventarioID = GXt_int3 ;
            httpContext.ajax_rsp_assign_attri("", false, "A53InventarioID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A53InventarioID), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A53InventarioID, (byte)(11), (byte)(0), ".", "")))+"\"") ;
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
      subsflControlProps_4450( ) ;
      while ( nGXsfl_44_idx <= nRC_GXsfl_44 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1750( ) ;
         standaloneModal1750( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1750( ) ;
         nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
         sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4450( ) ;
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

   public void valid_Articuloid( )
   {
      /* Using cursor T001721 */
      pr_default.execute(19, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
      }
      A76ArticuloNombre = T001721_A76ArticuloNombre[0] ;
      A79ArticuloStock = T001721_A79ArticuloStock[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", GXutil.rtrim( A76ArticuloNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A79ArticuloStock", GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7InventarioID',fld:'vINVENTARIOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7InventarioID',fld:'vINVENTARIOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12172',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A53InventarioID',fld:'INVENTARIOID',pic:'ZZZZZZZZZZ9'},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A53InventarioID',fld:'INVENTARIOID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_INVENTARIOID","{handler:'valid_Inventarioid',iparms:[]");
      setEventMetadata("VALID_INVENTARIOID",",oparms:[]}");
      setEventMetadata("VALID_INVENTARIOFECHA","{handler:'valid_Inventariofecha',iparms:[]");
      setEventMetadata("VALID_INVENTARIOFECHA",",oparms:[]}");
      setEventMetadata("VALID_INVENTARIODETALLEID","{handler:'valid_Inventariodetalleid',iparms:[]");
      setEventMetadata("VALID_INVENTARIODETALLEID",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A79ArticuloStock',fld:'ARTICULOSTOCK',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A79ArticuloStock',fld:'ARTICULOSTOCK',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_ARTICULOSTOCK","{handler:'valid_Articulostock',iparms:[]");
      setEventMetadata("VALID_ARTICULOSTOCK",",oparms:[]}");
      setEventMetadata("VALID_INVENTARIODETALLESTOCKOK","{handler:'valid_Inventariodetallestockok',iparms:[]");
      setEventMetadata("VALID_INVENTARIODETALLESTOCKOK",",oparms:[]}");
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
      return "inventario_Execute";
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
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z257InventarioFecha = GXutil.nullDate() ;
      Z258InventarioDetalle = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
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
      A257InventarioFecha = GXutil.nullDate() ;
      A258InventarioDetalle = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode50 = "" ;
      sStyleString = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode49 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A76ArticuloNombre = "" ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      T00177_A53InventarioID = new long[1] ;
      T00177_A257InventarioFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00177_A258InventarioDetalle = new String[] {""} ;
      T00177_A265InventarioNumeroProceso = new short[1] ;
      T00178_A53InventarioID = new long[1] ;
      T00176_A53InventarioID = new long[1] ;
      T00176_A257InventarioFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00176_A258InventarioDetalle = new String[] {""} ;
      T00176_A265InventarioNumeroProceso = new short[1] ;
      T00179_A53InventarioID = new long[1] ;
      T001710_A53InventarioID = new long[1] ;
      T00175_A53InventarioID = new long[1] ;
      T00175_A257InventarioFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00175_A258InventarioDetalle = new String[] {""} ;
      T00175_A265InventarioNumeroProceso = new short[1] ;
      T001714_A53InventarioID = new long[1] ;
      Z76ArticuloNombre = "" ;
      T001715_A53InventarioID = new long[1] ;
      T001715_A54InventarioDetalleID = new long[1] ;
      T001715_A76ArticuloNombre = new String[] {""} ;
      T001715_A79ArticuloStock = new long[1] ;
      T001715_A259InventarioDetalleStock = new long[1] ;
      T001715_A262InventarioDetalleStock2 = new long[1] ;
      T001715_A263InventarioDetalleStock3 = new long[1] ;
      T001715_A264InventarioDetalleStock4 = new long[1] ;
      T001715_A261InventarioDetalleStockOk = new long[1] ;
      T001715_A13ArticuloId = new long[1] ;
      T00174_A76ArticuloNombre = new String[] {""} ;
      T00174_A79ArticuloStock = new long[1] ;
      T001716_A76ArticuloNombre = new String[] {""} ;
      T001716_A79ArticuloStock = new long[1] ;
      T001717_A53InventarioID = new long[1] ;
      T001717_A54InventarioDetalleID = new long[1] ;
      T00173_A53InventarioID = new long[1] ;
      T00173_A54InventarioDetalleID = new long[1] ;
      T00173_A259InventarioDetalleStock = new long[1] ;
      T00173_A262InventarioDetalleStock2 = new long[1] ;
      T00173_A263InventarioDetalleStock3 = new long[1] ;
      T00173_A264InventarioDetalleStock4 = new long[1] ;
      T00173_A261InventarioDetalleStockOk = new long[1] ;
      T00173_A13ArticuloId = new long[1] ;
      T00172_A53InventarioID = new long[1] ;
      T00172_A54InventarioDetalleID = new long[1] ;
      T00172_A259InventarioDetalleStock = new long[1] ;
      T00172_A262InventarioDetalleStock2 = new long[1] ;
      T00172_A263InventarioDetalleStock3 = new long[1] ;
      T00172_A264InventarioDetalleStock4 = new long[1] ;
      T00172_A261InventarioDetalleStockOk = new long[1] ;
      T00172_A13ArticuloId = new long[1] ;
      T001721_A76ArticuloNombre = new String[] {""} ;
      T001721_A79ArticuloStock = new long[1] ;
      T001722_A53InventarioID = new long[1] ;
      T001722_A54InventarioDetalleID = new long[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      imgprompt_13_gximage = "" ;
      sImgUrl = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int2 = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.inventario__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.inventario__default(),
         new Object[] {
             new Object[] {
            T00172_A53InventarioID, T00172_A54InventarioDetalleID, T00172_A259InventarioDetalleStock, T00172_A262InventarioDetalleStock2, T00172_A263InventarioDetalleStock3, T00172_A264InventarioDetalleStock4, T00172_A261InventarioDetalleStockOk, T00172_A13ArticuloId
            }
            , new Object[] {
            T00173_A53InventarioID, T00173_A54InventarioDetalleID, T00173_A259InventarioDetalleStock, T00173_A262InventarioDetalleStock2, T00173_A263InventarioDetalleStock3, T00173_A264InventarioDetalleStock4, T00173_A261InventarioDetalleStockOk, T00173_A13ArticuloId
            }
            , new Object[] {
            T00174_A76ArticuloNombre, T00174_A79ArticuloStock
            }
            , new Object[] {
            T00175_A53InventarioID, T00175_A257InventarioFecha, T00175_A258InventarioDetalle, T00175_A265InventarioNumeroProceso
            }
            , new Object[] {
            T00176_A53InventarioID, T00176_A257InventarioFecha, T00176_A258InventarioDetalle, T00176_A265InventarioNumeroProceso
            }
            , new Object[] {
            T00177_A53InventarioID, T00177_A257InventarioFecha, T00177_A258InventarioDetalle, T00177_A265InventarioNumeroProceso
            }
            , new Object[] {
            T00178_A53InventarioID
            }
            , new Object[] {
            T00179_A53InventarioID
            }
            , new Object[] {
            T001710_A53InventarioID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001714_A53InventarioID
            }
            , new Object[] {
            T001715_A53InventarioID, T001715_A54InventarioDetalleID, T001715_A76ArticuloNombre, T001715_A79ArticuloStock, T001715_A259InventarioDetalleStock, T001715_A262InventarioDetalleStock2, T001715_A263InventarioDetalleStock3, T001715_A264InventarioDetalleStock4, T001715_A261InventarioDetalleStockOk, T001715_A13ArticuloId
            }
            , new Object[] {
            T001716_A76ArticuloNombre, T001716_A79ArticuloStock
            }
            , new Object[] {
            T001717_A53InventarioID, T001717_A54InventarioDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001721_A76ArticuloNombre, T001721_A79ArticuloStock
            }
            , new Object[] {
            T001722_A53InventarioID, T001722_A54InventarioDetalleID
            }
         }
      );
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
   private short nIsMod_50 ;
   private short Z265InventarioNumeroProceso ;
   private short nRcdDeleted_50 ;
   private short nRcdExists_50 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A265InventarioNumeroProceso ;
   private short nBlankRcdCount50 ;
   private short RcdFound50 ;
   private short nBlankRcdUsr50 ;
   private short RcdFound49 ;
   private short nIsDirty_49 ;
   private short nIsDirty_50 ;
   private int nRC_GXsfl_44 ;
   private int nGXsfl_44_idx=1 ;
   private int trnEnded ;
   private int edtInventarioID_Enabled ;
   private int edtInventarioFecha_Enabled ;
   private int edtInventarioDetalle_Enabled ;
   private int edtInventarioNumeroProceso_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtInventarioDetalleID_Enabled ;
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtArticuloStock_Enabled ;
   private int edtInventarioDetalleStock_Enabled ;
   private int edtInventarioDetalleDiferencia_Enabled ;
   private int edtInventarioDetalleStock2_Enabled ;
   private int edtInventarioDetalleStock3_Enabled ;
   private int edtInventarioDetalleStock4_Enabled ;
   private int edtInventarioDetalleStockOk_Enabled ;
   private int fRowAdded ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int imgprompt_13_Visible ;
   private int defedtInventarioDetalleID_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private long wcpOAV7InventarioID ;
   private long Z53InventarioID ;
   private long Z54InventarioDetalleID ;
   private long Z259InventarioDetalleStock ;
   private long Z262InventarioDetalleStock2 ;
   private long Z263InventarioDetalleStock3 ;
   private long Z264InventarioDetalleStock4 ;
   private long Z261InventarioDetalleStockOk ;
   private long Z13ArticuloId ;
   private long AV7InventarioID ;
   private long A13ArticuloId ;
   private long A53InventarioID ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private long A54InventarioDetalleID ;
   private long A79ArticuloStock ;
   private long A259InventarioDetalleStock ;
   private long A260InventarioDetalleDiferencia ;
   private long A262InventarioDetalleStock2 ;
   private long A263InventarioDetalleStock3 ;
   private long A264InventarioDetalleStock4 ;
   private long A261InventarioDetalleStockOk ;
   private long Z79ArticuloStock ;
   private long GXt_int3 ;
   private long GXv_int2[] ;
   private String sPrefix ;
   private String sGXsfl_44_idx="0001" ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtInventarioID_Internalname ;
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
   private String edtInventarioID_Jsonclick ;
   private String edtInventarioFecha_Internalname ;
   private String edtInventarioFecha_Jsonclick ;
   private String edtInventarioDetalle_Internalname ;
   private String edtInventarioDetalle_Jsonclick ;
   private String edtInventarioNumeroProceso_Internalname ;
   private String edtInventarioNumeroProceso_Jsonclick ;
   private String divTableleaflevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode50 ;
   private String edtInventarioDetalleID_Internalname ;
   private String edtArticuloId_Internalname ;
   private String edtArticuloNombre_Internalname ;
   private String edtArticuloStock_Internalname ;
   private String edtInventarioDetalleStock_Internalname ;
   private String edtInventarioDetalleDiferencia_Internalname ;
   private String edtInventarioDetalleStock2_Internalname ;
   private String edtInventarioDetalleStock3_Internalname ;
   private String edtInventarioDetalleStock4_Internalname ;
   private String edtInventarioDetalleStockOk_Internalname ;
   private String imgprompt_13_Link ;
   private String sStyleString ;
   private String subGridlevel_detalle_Internalname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode49 ;
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
   private String sGXsfl_44_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String ROClassString ;
   private String edtInventarioDetalleID_Jsonclick ;
   private String edtArticuloId_Jsonclick ;
   private String imgprompt_13_gximage ;
   private String sImgUrl ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtArticuloStock_Jsonclick ;
   private String edtInventarioDetalleStock_Jsonclick ;
   private String edtInventarioDetalleDiferencia_Jsonclick ;
   private String edtInventarioDetalleStock2_Jsonclick ;
   private String edtInventarioDetalleStock3_Jsonclick ;
   private String edtInventarioDetalleStock4_Jsonclick ;
   private String edtInventarioDetalleStockOk_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_detalle_Header ;
   private java.util.Date Z257InventarioFecha ;
   private java.util.Date A257InventarioFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_44_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private String Z258InventarioDetalle ;
   private String A258InventarioDetalle ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T00177_A53InventarioID ;
   private java.util.Date[] T00177_A257InventarioFecha ;
   private String[] T00177_A258InventarioDetalle ;
   private short[] T00177_A265InventarioNumeroProceso ;
   private long[] T00178_A53InventarioID ;
   private long[] T00176_A53InventarioID ;
   private java.util.Date[] T00176_A257InventarioFecha ;
   private String[] T00176_A258InventarioDetalle ;
   private short[] T00176_A265InventarioNumeroProceso ;
   private long[] T00179_A53InventarioID ;
   private long[] T001710_A53InventarioID ;
   private long[] T00175_A53InventarioID ;
   private java.util.Date[] T00175_A257InventarioFecha ;
   private String[] T00175_A258InventarioDetalle ;
   private short[] T00175_A265InventarioNumeroProceso ;
   private long[] T001714_A53InventarioID ;
   private long[] T001715_A53InventarioID ;
   private long[] T001715_A54InventarioDetalleID ;
   private String[] T001715_A76ArticuloNombre ;
   private long[] T001715_A79ArticuloStock ;
   private long[] T001715_A259InventarioDetalleStock ;
   private long[] T001715_A262InventarioDetalleStock2 ;
   private long[] T001715_A263InventarioDetalleStock3 ;
   private long[] T001715_A264InventarioDetalleStock4 ;
   private long[] T001715_A261InventarioDetalleStockOk ;
   private long[] T001715_A13ArticuloId ;
   private String[] T00174_A76ArticuloNombre ;
   private long[] T00174_A79ArticuloStock ;
   private String[] T001716_A76ArticuloNombre ;
   private long[] T001716_A79ArticuloStock ;
   private long[] T001717_A53InventarioID ;
   private long[] T001717_A54InventarioDetalleID ;
   private long[] T00173_A53InventarioID ;
   private long[] T00173_A54InventarioDetalleID ;
   private long[] T00173_A259InventarioDetalleStock ;
   private long[] T00173_A262InventarioDetalleStock2 ;
   private long[] T00173_A263InventarioDetalleStock3 ;
   private long[] T00173_A264InventarioDetalleStock4 ;
   private long[] T00173_A261InventarioDetalleStockOk ;
   private long[] T00173_A13ArticuloId ;
   private long[] T00172_A53InventarioID ;
   private long[] T00172_A54InventarioDetalleID ;
   private long[] T00172_A259InventarioDetalleStock ;
   private long[] T00172_A262InventarioDetalleStock2 ;
   private long[] T00172_A263InventarioDetalleStock3 ;
   private long[] T00172_A264InventarioDetalleStock4 ;
   private long[] T00172_A261InventarioDetalleStockOk ;
   private long[] T00172_A13ArticuloId ;
   private String[] T001721_A76ArticuloNombre ;
   private long[] T001721_A79ArticuloStock ;
   private long[] T001722_A53InventarioID ;
   private long[] T001722_A54InventarioDetalleID ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class inventario__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class inventario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00172", "SELECT [InventarioID], [InventarioDetalleID], [InventarioDetalleStock], [InventarioDetalleStock2], [InventarioDetalleStock3], [InventarioDetalleStock4], [InventarioDetalleStockOk], [ArticuloId] FROM [InventarioDetalle] WITH (UPDLOCK) WHERE [InventarioID] = ? AND [InventarioDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00173", "SELECT [InventarioID], [InventarioDetalleID], [InventarioDetalleStock], [InventarioDetalleStock2], [InventarioDetalleStock3], [InventarioDetalleStock4], [InventarioDetalleStockOk], [ArticuloId] FROM [InventarioDetalle] WHERE [InventarioID] = ? AND [InventarioDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00174", "SELECT [ArticuloNombre], [ArticuloStock] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00175", "SELECT [InventarioID], [InventarioFecha], [InventarioDetalle], [InventarioNumeroProceso] FROM [Inventario] WITH (UPDLOCK) WHERE [InventarioID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00176", "SELECT [InventarioID], [InventarioFecha], [InventarioDetalle], [InventarioNumeroProceso] FROM [Inventario] WHERE [InventarioID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00177", "SELECT TM1.[InventarioID], TM1.[InventarioFecha], TM1.[InventarioDetalle], TM1.[InventarioNumeroProceso] FROM [Inventario] TM1 WHERE TM1.[InventarioID] = ? ORDER BY TM1.[InventarioID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00178", "SELECT [InventarioID] FROM [Inventario] WHERE [InventarioID] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00179", "SELECT TOP 1 [InventarioID] FROM [Inventario] WHERE ( [InventarioID] > ?) ORDER BY [InventarioID]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001710", "SELECT TOP 1 [InventarioID] FROM [Inventario] WHERE ( [InventarioID] < ?) ORDER BY [InventarioID] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001711", "INSERT INTO [Inventario]([InventarioID], [InventarioFecha], [InventarioDetalle], [InventarioNumeroProceso]) VALUES(?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001712", "UPDATE [Inventario] SET [InventarioFecha]=?, [InventarioDetalle]=?, [InventarioNumeroProceso]=?  WHERE [InventarioID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001713", "DELETE FROM [Inventario]  WHERE [InventarioID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001714", "SELECT [InventarioID] FROM [Inventario] ORDER BY [InventarioID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001715", "SELECT T1.[InventarioID], T1.[InventarioDetalleID], T2.[ArticuloNombre], T2.[ArticuloStock], T1.[InventarioDetalleStock], T1.[InventarioDetalleStock2], T1.[InventarioDetalleStock3], T1.[InventarioDetalleStock4], T1.[InventarioDetalleStockOk], T1.[ArticuloId] FROM ([InventarioDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) WHERE T1.[InventarioID] = ? and T1.[InventarioDetalleID] = ? ORDER BY T1.[InventarioID], T1.[InventarioDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001716", "SELECT [ArticuloNombre], [ArticuloStock] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001717", "SELECT [InventarioID], [InventarioDetalleID] FROM [InventarioDetalle] WHERE [InventarioID] = ? AND [InventarioDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001718", "INSERT INTO [InventarioDetalle]([InventarioID], [InventarioDetalleID], [InventarioDetalleStock], [InventarioDetalleStock2], [InventarioDetalleStock3], [InventarioDetalleStock4], [InventarioDetalleStockOk], [ArticuloId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001719", "UPDATE [InventarioDetalle] SET [InventarioDetalleStock]=?, [InventarioDetalleStock2]=?, [InventarioDetalleStock3]=?, [InventarioDetalleStock4]=?, [InventarioDetalleStockOk]=?, [ArticuloId]=?  WHERE [InventarioID] = ? AND [InventarioDetalleID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001720", "DELETE FROM [InventarioDetalle]  WHERE [InventarioID] = ? AND [InventarioDetalleID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001721", "SELECT [ArticuloNombre], [ArticuloStock] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001722", "SELECT [InventarioID], [InventarioDetalleID] FROM [InventarioDetalle] WHERE [InventarioID] = ? ORDER BY [InventarioID], [InventarioDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 20 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setVarchar(3, (String)parms[2], 80, false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 80, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

