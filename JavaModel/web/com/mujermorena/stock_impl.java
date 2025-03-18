package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class stock_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"STOCKID") == 0 )
      {
         AV7StockId = GXutil.lval( httpContext.GetPar( "StockId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7StockId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSTOCKID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7StockId), "ZZZZZZZZZZ9")));
         AV15Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asastockid1342( AV7StockId, AV15Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A13ArticuloId) ;
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
            AV7StockId = GXutil.lval( httpContext.GetPar( "StockId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7StockId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSTOCKID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7StockId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Stock", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtStockId_Internalname ;
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

   public stock_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public stock_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stock_impl.class ));
   }

   public stock_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Stock", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Stock.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtStockId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtStockId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtStockId_Internalname, GXutil.ltrim( localUtil.ntoc( A46StockId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46StockId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtStockId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtStockId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Stock.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloId_Internalname, httpContext.getMessage( "Articulo Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Stock.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_13_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_13_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_13_Internalname, sImgUrl, imgprompt_13_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_13_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Stock.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloNombre_Internalname, httpContext.getMessage( "Articulo Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre), GXutil.rtrim( localUtil.format( A76ArticuloNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Stock.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtStockTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtStockTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtStockTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A233StockTotal, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtStockTotal_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A233StockTotal), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A233StockTotal), "ZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtStockTotal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtStockTotal_Enabled, 0, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Cantidad", "right", false, "", "HLP_Stock.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Stock.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Stock.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Stock.htm");
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
         nBlankRcdCount43 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_43 = (short)(1) ;
            scanStart1343( ) ;
            while ( RcdFound43 != 0 )
            {
               init_level_properties43( ) ;
               getByPrimaryKey1343( ) ;
               addRow1343( ) ;
               scanNext1343( ) ;
            }
            scanEnd1343( ) ;
            nBlankRcdCount43 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal1343( ) ;
         standaloneModal1343( ) ;
         sMode43 = Gx_mode ;
         while ( nGXsfl_44_idx < nRC_GXsfl_44 )
         {
            bGXsfl_44_Refreshing = true ;
            readRow1343( ) ;
            edtStockIdCompra_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKIDCOMPRA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockIdCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockIdCompra_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtStockFecha_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKFECHA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockFecha_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtStockCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKCANTIDAD_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockCantidad_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtStockSaldo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKSALDO_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockSaldo_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtStockPrecioCompra_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKPRECIOCOMPRA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockPrecioCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockPrecioCompra_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtStockPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKPRECIOVENTA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockPrecioVenta_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            edtStockDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKDETALLEID_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtStockDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
            if ( ( nRcdExists_43 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1343( ) ;
            }
            sendRow1343( ) ;
            bGXsfl_44_Refreshing = false ;
         }
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount43 = (short)(5) ;
         nRcdExists_43 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1343( ) ;
            while ( RcdFound43 != 0 )
            {
               sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_4443( ) ;
               init_level_properties43( ) ;
               standaloneNotModal1343( ) ;
               getByPrimaryKey1343( ) ;
               standaloneModal1343( ) ;
               addRow1343( ) ;
               scanNext1343( ) ;
            }
            scanEnd1343( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode43 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_4443( ) ;
         initAll1343( ) ;
         init_level_properties43( ) ;
         nRcdExists_43 = (short)(0) ;
         nIsMod_43 = (short)(0) ;
         nRcdDeleted_43 = (short)(0) ;
         nBlankRcdCount43 = (short)(nBlankRcdUsr43+nBlankRcdCount43) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount43 > 0 )
         {
            standaloneNotModal1343( ) ;
            standaloneModal1343( ) ;
            addRow1343( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtStockIdCompra_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount43 = (short)(nBlankRcdCount43-1) ;
         }
         Gx_mode = sMode43 ;
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
      e11132 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46StockId = localUtil.ctol( httpContext.cgiGet( "Z46StockId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z233StockTotal = (int)(localUtil.ctol( httpContext.cgiGet( "Z233StockTotal"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( "Z13ArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_44 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_44"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N13ArticuloId = localUtil.ctol( httpContext.cgiGet( "N13ArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7StockId = localUtil.ctol( httpContext.cgiGet( "vSTOCKID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_ArticuloId = localUtil.ctol( httpContext.cgiGet( "vINSERT_ARTICULOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A289StockDetalleTallaID = localUtil.ctol( httpContext.cgiGet( "STOCKDETALLETALLAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtStockId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtStockId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "STOCKID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtStockId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46StockId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
            }
            else
            {
               A46StockId = localUtil.ctol( httpContext.cgiGet( edtStockId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTICULOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtArticuloId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A13ArticuloId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
            }
            else
            {
               A13ArticuloId = localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
            }
            A76ArticuloNombre = httpContext.cgiGet( edtArticuloNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtStockTotal_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtStockTotal_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "STOCKTOTAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtStockTotal_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A233StockTotal = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A233StockTotal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A233StockTotal), 5, 0));
            }
            else
            {
               A233StockTotal = (int)(localUtil.ctol( httpContext.cgiGet( edtStockTotal_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A233StockTotal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A233StockTotal), 5, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Stock");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46StockId != Z46StockId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("stock:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46StockId = GXutil.lval( httpContext.GetPar( "StockId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
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
                  sMode42 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode42 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound42 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_130( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "STOCKID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtStockId_Internalname ;
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
                        e11132 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12132 ();
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
         e12132 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1342( ) ;
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
         disableAttributes1342( ) ;
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

   public void confirm_130( )
   {
      beforeValidate1342( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1342( ) ;
         }
         else
         {
            checkExtendedTable1342( ) ;
            closeExtendedTableCursors1342( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode42 = Gx_mode ;
         confirm_1343( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode42 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_1343( )
   {
      nGXsfl_44_idx = 0 ;
      while ( nGXsfl_44_idx < nRC_GXsfl_44 )
      {
         readRow1343( ) ;
         if ( ( nRcdExists_43 != 0 ) || ( nIsMod_43 != 0 ) )
         {
            getKey1343( ) ;
            if ( ( nRcdExists_43 == 0 ) && ( nRcdDeleted_43 == 0 ) )
            {
               if ( RcdFound43 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1343( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1343( ) ;
                     closeExtendedTableCursors1343( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "STOCKDETALLEID_" + sGXsfl_44_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtStockDetalleID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound43 != 0 )
               {
                  if ( nRcdDeleted_43 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1343( ) ;
                     load1343( ) ;
                     beforeValidate1343( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1343( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_43 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1343( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1343( ) ;
                           closeExtendedTableCursors1343( ) ;
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
                  if ( nRcdDeleted_43 == 0 )
                  {
                     GXCCtl = "STOCKDETALLEID_" + sGXsfl_44_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtStockDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtStockIdCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A216StockIdCompra, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockFecha_Internalname, localUtil.format(A217StockFecha, "99/99/99")) ;
         httpContext.changePostValue( edtStockCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A218StockCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A219StockSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockPrecioCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A220StockPrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A221StockPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A50StockDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z50StockDetalleID_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z50StockDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z216StockIdCompra_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z216StockIdCompra, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z217StockFecha_"+sGXsfl_44_idx, localUtil.dtoc( Z217StockFecha, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z218StockCantidad_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z218StockCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z219StockSaldo_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z219StockSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z220StockPrecioCompra_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z220StockPrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z221StockPrecioVenta_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z221StockPrecioVenta, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z289StockDetalleTallaID_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z289StockDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_43_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_43_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_43_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_43 != 0 )
         {
            httpContext.changePostValue( "STOCKIDCOMPRA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockIdCompra_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKFECHA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockFecha_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKCANTIDAD_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKSALDO_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockSaldo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKPRECIOCOMPRA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioCompra_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKPRECIOVENTA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKDETALLEID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption130( )
   {
   }

   public void e11132( )
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
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ArticuloId") == 0 )
            {
               AV13Insert_ArticuloId = GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_ArticuloId), 11, 0));
            }
            AV16GXV1 = (int)(AV16GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         }
      }
   }

   public void e12132( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.stockww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1342( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z233StockTotal = T00135_A233StockTotal[0] ;
            Z13ArticuloId = T00135_A13ArticuloId[0] ;
         }
         else
         {
            Z233StockTotal = A233StockTotal ;
            Z13ArticuloId = A13ArticuloId ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z46StockId = A46StockId ;
         Z233StockTotal = A233StockTotal ;
         Z13ArticuloId = A13ArticuloId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      AV15Pgmname = "Stock" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      imgprompt_13_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.articuloprompt"+"',["+"{Ctrl:gx.dom.el('"+"ARTICULOID"+"'), id:'"+"ARTICULOID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7StockId) )
      {
         A46StockId = AV7StockId ;
         httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A46StockId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
            stock_impl.this.GXt_int2 = GXv_int3[0] ;
            A46StockId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
         }
      }
      if ( ! (0==AV7StockId) )
      {
         edtStockId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtStockId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockId_Enabled), 5, 0), true);
      }
      else
      {
         edtStockId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtStockId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7StockId) )
      {
         edtStockId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtStockId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_ArticuloId) )
      {
         edtArticuloId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      }
      else
      {
         edtArticuloId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_ArticuloId) )
      {
         A13ArticuloId = AV13Insert_ArticuloId ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
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
         /* Using cursor T00136 */
         pr_default.execute(4, new Object[] {Long.valueOf(A13ArticuloId)});
         A76ArticuloNombre = T00136_A76ArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
         pr_default.close(4);
      }
   }

   public void load1342( )
   {
      /* Using cursor T00137 */
      pr_default.execute(5, new Object[] {Long.valueOf(A46StockId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A76ArticuloNombre = T00137_A76ArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
         A233StockTotal = T00137_A233StockTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A233StockTotal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A233StockTotal), 5, 0));
         A13ArticuloId = T00137_A13ArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         zm1342( -10) ;
      }
      pr_default.close(5);
      onLoadActions1342( ) ;
   }

   public void onLoadActions1342( )
   {
   }

   public void checkExtendedTable1342( )
   {
      nIsDirty_42 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00136 */
      pr_default.execute(4, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A76ArticuloNombre = T00136_A76ArticuloNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
      pr_default.close(4);
   }

   public void closeExtendedTableCursors1342( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( long A13ArticuloId )
   {
      /* Using cursor T00138 */
      pr_default.execute(6, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A76ArticuloNombre = T00138_A76ArticuloNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A76ArticuloNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1342( )
   {
      /* Using cursor T00139 */
      pr_default.execute(7, new Object[] {Long.valueOf(A46StockId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound42 = (short)(1) ;
      }
      else
      {
         RcdFound42 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00135 */
      pr_default.execute(3, new Object[] {Long.valueOf(A46StockId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm1342( 10) ;
         RcdFound42 = (short)(1) ;
         A46StockId = T00135_A46StockId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
         A233StockTotal = T00135_A233StockTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A233StockTotal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A233StockTotal), 5, 0));
         A13ArticuloId = T00135_A13ArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         Z46StockId = A46StockId ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1342( ) ;
         if ( AnyError == 1 )
         {
            RcdFound42 = (short)(0) ;
            initializeNonKey1342( ) ;
         }
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound42 = (short)(0) ;
         initializeNonKey1342( ) ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey1342( ) ;
      if ( RcdFound42 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound42 = (short)(0) ;
      /* Using cursor T001310 */
      pr_default.execute(8, new Object[] {Long.valueOf(A46StockId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001310_A46StockId[0] < A46StockId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001310_A46StockId[0] > A46StockId ) ) )
         {
            A46StockId = T001310_A46StockId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
            RcdFound42 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound42 = (short)(0) ;
      /* Using cursor T001311 */
      pr_default.execute(9, new Object[] {Long.valueOf(A46StockId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001311_A46StockId[0] > A46StockId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001311_A46StockId[0] < A46StockId ) ) )
         {
            A46StockId = T001311_A46StockId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
            RcdFound42 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1342( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtStockId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1342( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound42 == 1 )
         {
            if ( A46StockId != Z46StockId )
            {
               A46StockId = Z46StockId ;
               httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "STOCKID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtStockId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtStockId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1342( ) ;
               GX_FocusControl = edtStockId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A46StockId != Z46StockId )
            {
               /* Insert record */
               GX_FocusControl = edtStockId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1342( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "STOCKID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtStockId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtStockId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1342( ) ;
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
      if ( A46StockId != Z46StockId )
      {
         A46StockId = Z46StockId ;
         httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "STOCKID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtStockId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1342( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00134 */
         pr_default.execute(2, new Object[] {Long.valueOf(A46StockId)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Stock"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( Z233StockTotal != T00134_A233StockTotal[0] ) || ( Z13ArticuloId != T00134_A13ArticuloId[0] ) )
         {
            if ( Z233StockTotal != T00134_A233StockTotal[0] )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockTotal");
               GXutil.writeLogRaw("Old: ",Z233StockTotal);
               GXutil.writeLogRaw("Current: ",T00134_A233StockTotal[0]);
            }
            if ( Z13ArticuloId != T00134_A13ArticuloId[0] )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"ArticuloId");
               GXutil.writeLogRaw("Old: ",Z13ArticuloId);
               GXutil.writeLogRaw("Current: ",T00134_A13ArticuloId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Stock"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1342( )
   {
      if ( ! IsAuthorized("stock_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1342( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1342( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1342( 0) ;
         checkOptimisticConcurrency1342( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1342( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1342( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001312 */
                  pr_default.execute(10, new Object[] {Long.valueOf(A46StockId), Integer.valueOf(A233StockTotal), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
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
                        processLevel1342( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption130( ) ;
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
            load1342( ) ;
         }
         endLevel1342( ) ;
      }
      closeExtendedTableCursors1342( ) ;
   }

   public void update1342( )
   {
      if ( ! IsAuthorized("stock_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1342( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1342( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1342( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1342( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1342( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001313 */
                  pr_default.execute(11, new Object[] {Integer.valueOf(A233StockTotal), Long.valueOf(A13ArticuloId), Long.valueOf(A46StockId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Stock"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1342( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1342( ) ;
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
         endLevel1342( ) ;
      }
      closeExtendedTableCursors1342( ) ;
   }

   public void deferredUpdate1342( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("stock_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1342( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1342( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1342( ) ;
         afterConfirm1342( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1342( ) ;
            if ( AnyError == 0 )
            {
               scanStart1343( ) ;
               while ( RcdFound43 != 0 )
               {
                  getByPrimaryKey1343( ) ;
                  delete1343( ) ;
                  scanNext1343( ) ;
               }
               scanEnd1343( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001314 */
                  pr_default.execute(12, new Object[] {Long.valueOf(A46StockId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Stock");
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
      sMode42 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1342( ) ;
      Gx_mode = sMode42 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1342( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001315 */
         pr_default.execute(13, new Object[] {Long.valueOf(A13ArticuloId)});
         A76ArticuloNombre = T001315_A76ArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
         pr_default.close(13);
      }
   }

   public void processNestedLevel1343( )
   {
      nGXsfl_44_idx = 0 ;
      while ( nGXsfl_44_idx < nRC_GXsfl_44 )
      {
         readRow1343( ) ;
         if ( ( nRcdExists_43 != 0 ) || ( nIsMod_43 != 0 ) )
         {
            standaloneNotModal1343( ) ;
            getKey1343( ) ;
            if ( ( nRcdExists_43 == 0 ) && ( nRcdDeleted_43 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1343( ) ;
            }
            else
            {
               if ( RcdFound43 != 0 )
               {
                  if ( ( nRcdDeleted_43 != 0 ) && ( nRcdExists_43 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1343( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_43 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1343( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_43 == 0 )
                  {
                     GXCCtl = "STOCKDETALLEID_" + sGXsfl_44_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtStockDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtStockIdCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A216StockIdCompra, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockFecha_Internalname, localUtil.format(A217StockFecha, "99/99/99")) ;
         httpContext.changePostValue( edtStockCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A218StockCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A219StockSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockPrecioCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A220StockPrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A221StockPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtStockDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A50StockDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z50StockDetalleID_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z50StockDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z216StockIdCompra_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z216StockIdCompra, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z217StockFecha_"+sGXsfl_44_idx, localUtil.dtoc( Z217StockFecha, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z218StockCantidad_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z218StockCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z219StockSaldo_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z219StockSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z220StockPrecioCompra_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z220StockPrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z221StockPrecioVenta_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z221StockPrecioVenta, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z289StockDetalleTallaID_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( Z289StockDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_43_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_43_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_43_"+sGXsfl_44_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_43 != 0 )
         {
            httpContext.changePostValue( "STOCKIDCOMPRA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockIdCompra_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKFECHA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockFecha_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKCANTIDAD_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKSALDO_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockSaldo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKPRECIOCOMPRA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioCompra_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKPRECIOVENTA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "STOCKDETALLEID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1343( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_43 = (short)(0) ;
      nIsMod_43 = (short)(0) ;
      nRcdDeleted_43 = (short)(0) ;
   }

   public void processLevel1342( )
   {
      /* Save parent mode. */
      sMode42 = Gx_mode ;
      processNestedLevel1343( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode42 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1342( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1342( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(13);
         Application.commitDataStores(context, remoteHandle, pr_default, "stock");
         if ( AnyError == 0 )
         {
            confirmValues130( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(13);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "stock");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1342( )
   {
      /* Scan By routine */
      /* Using cursor T001316 */
      pr_default.execute(14);
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A46StockId = T001316_A46StockId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1342( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A46StockId = T001316_A46StockId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
      }
   }

   public void scanEnd1342( )
   {
      pr_default.close(14);
   }

   public void afterConfirm1342( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1342( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1342( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1342( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1342( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1342( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1342( )
   {
      edtStockId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockId_Enabled), 5, 0), true);
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), true);
      edtStockTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockTotal_Enabled), 5, 0), true);
   }

   public void zm1343( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z216StockIdCompra = T00133_A216StockIdCompra[0] ;
            Z217StockFecha = T00133_A217StockFecha[0] ;
            Z218StockCantidad = T00133_A218StockCantidad[0] ;
            Z219StockSaldo = T00133_A219StockSaldo[0] ;
            Z220StockPrecioCompra = T00133_A220StockPrecioCompra[0] ;
            Z221StockPrecioVenta = T00133_A221StockPrecioVenta[0] ;
            Z289StockDetalleTallaID = T00133_A289StockDetalleTallaID[0] ;
         }
         else
         {
            Z216StockIdCompra = A216StockIdCompra ;
            Z217StockFecha = A217StockFecha ;
            Z218StockCantidad = A218StockCantidad ;
            Z219StockSaldo = A219StockSaldo ;
            Z220StockPrecioCompra = A220StockPrecioCompra ;
            Z221StockPrecioVenta = A221StockPrecioVenta ;
            Z289StockDetalleTallaID = A289StockDetalleTallaID ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z46StockId = A46StockId ;
         Z50StockDetalleID = A50StockDetalleID ;
         Z216StockIdCompra = A216StockIdCompra ;
         Z217StockFecha = A217StockFecha ;
         Z218StockCantidad = A218StockCantidad ;
         Z219StockSaldo = A219StockSaldo ;
         Z220StockPrecioCompra = A220StockPrecioCompra ;
         Z221StockPrecioVenta = A221StockPrecioVenta ;
         Z289StockDetalleTallaID = A289StockDetalleTallaID ;
      }
   }

   public void standaloneNotModal1343( )
   {
   }

   public void standaloneModal1343( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtStockDetalleID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtStockDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      }
      else
      {
         edtStockDetalleID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtStockDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      }
   }

   public void load1343( )
   {
      /* Using cursor T001317 */
      pr_default.execute(15, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A216StockIdCompra = T001317_A216StockIdCompra[0] ;
         A217StockFecha = T001317_A217StockFecha[0] ;
         A218StockCantidad = T001317_A218StockCantidad[0] ;
         A219StockSaldo = T001317_A219StockSaldo[0] ;
         A220StockPrecioCompra = T001317_A220StockPrecioCompra[0] ;
         A221StockPrecioVenta = T001317_A221StockPrecioVenta[0] ;
         A289StockDetalleTallaID = T001317_A289StockDetalleTallaID[0] ;
         zm1343( -12) ;
      }
      pr_default.close(15);
      onLoadActions1343( ) ;
   }

   public void onLoadActions1343( )
   {
   }

   public void checkExtendedTable1343( )
   {
      nIsDirty_43 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1343( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A217StockFecha)) || (( GXutil.resetTime(A217StockFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A217StockFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         GXCCtl = "STOCKFECHA_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Stock Fecha", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1343( )
   {
   }

   public void enableDisable1343( )
   {
   }

   public void getKey1343( )
   {
      /* Using cursor T001318 */
      pr_default.execute(16, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound43 = (short)(1) ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey1343( )
   {
      /* Using cursor T00133 */
      pr_default.execute(1, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1343( 12) ;
         RcdFound43 = (short)(1) ;
         initializeNonKey1343( ) ;
         A50StockDetalleID = T00133_A50StockDetalleID[0] ;
         A216StockIdCompra = T00133_A216StockIdCompra[0] ;
         A217StockFecha = T00133_A217StockFecha[0] ;
         A218StockCantidad = T00133_A218StockCantidad[0] ;
         A219StockSaldo = T00133_A219StockSaldo[0] ;
         A220StockPrecioCompra = T00133_A220StockPrecioCompra[0] ;
         A221StockPrecioVenta = T00133_A221StockPrecioVenta[0] ;
         A289StockDetalleTallaID = T00133_A289StockDetalleTallaID[0] ;
         Z46StockId = A46StockId ;
         Z50StockDetalleID = A50StockDetalleID ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1343( ) ;
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound43 = (short)(0) ;
         initializeNonKey1343( ) ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1343( ) ;
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1343( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1343( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00132 */
         pr_default.execute(0, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"StockDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z216StockIdCompra != T00132_A216StockIdCompra[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z217StockFecha), GXutil.resetTime(T00132_A217StockFecha[0])) ) || ( Z218StockCantidad != T00132_A218StockCantidad[0] ) || ( Z219StockSaldo != T00132_A219StockSaldo[0] ) || ( DecimalUtil.compareTo(Z220StockPrecioCompra, T00132_A220StockPrecioCompra[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z221StockPrecioVenta, T00132_A221StockPrecioVenta[0]) != 0 ) || ( Z289StockDetalleTallaID != T00132_A289StockDetalleTallaID[0] ) )
         {
            if ( Z216StockIdCompra != T00132_A216StockIdCompra[0] )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockIdCompra");
               GXutil.writeLogRaw("Old: ",Z216StockIdCompra);
               GXutil.writeLogRaw("Current: ",T00132_A216StockIdCompra[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z217StockFecha), GXutil.resetTime(T00132_A217StockFecha[0])) ) )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockFecha");
               GXutil.writeLogRaw("Old: ",Z217StockFecha);
               GXutil.writeLogRaw("Current: ",T00132_A217StockFecha[0]);
            }
            if ( Z218StockCantidad != T00132_A218StockCantidad[0] )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockCantidad");
               GXutil.writeLogRaw("Old: ",Z218StockCantidad);
               GXutil.writeLogRaw("Current: ",T00132_A218StockCantidad[0]);
            }
            if ( Z219StockSaldo != T00132_A219StockSaldo[0] )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockSaldo");
               GXutil.writeLogRaw("Old: ",Z219StockSaldo);
               GXutil.writeLogRaw("Current: ",T00132_A219StockSaldo[0]);
            }
            if ( DecimalUtil.compareTo(Z220StockPrecioCompra, T00132_A220StockPrecioCompra[0]) != 0 )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockPrecioCompra");
               GXutil.writeLogRaw("Old: ",Z220StockPrecioCompra);
               GXutil.writeLogRaw("Current: ",T00132_A220StockPrecioCompra[0]);
            }
            if ( DecimalUtil.compareTo(Z221StockPrecioVenta, T00132_A221StockPrecioVenta[0]) != 0 )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockPrecioVenta");
               GXutil.writeLogRaw("Old: ",Z221StockPrecioVenta);
               GXutil.writeLogRaw("Current: ",T00132_A221StockPrecioVenta[0]);
            }
            if ( Z289StockDetalleTallaID != T00132_A289StockDetalleTallaID[0] )
            {
               GXutil.writeLogln("stock:[seudo value changed for attri]"+"StockDetalleTallaID");
               GXutil.writeLogRaw("Old: ",Z289StockDetalleTallaID);
               GXutil.writeLogRaw("Current: ",T00132_A289StockDetalleTallaID[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"StockDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1343( )
   {
      if ( ! IsAuthorized("stock_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1343( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1343( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1343( 0) ;
         checkOptimisticConcurrency1343( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1343( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1343( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001319 */
                  pr_default.execute(17, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID), Long.valueOf(A216StockIdCompra), A217StockFecha, Integer.valueOf(A218StockCantidad), Short.valueOf(A219StockSaldo), A220StockPrecioCompra, A221StockPrecioVenta, Long.valueOf(A289StockDetalleTallaID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
                  if ( (pr_default.getStatus(17) == 1) )
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
            load1343( ) ;
         }
         endLevel1343( ) ;
      }
      closeExtendedTableCursors1343( ) ;
   }

   public void update1343( )
   {
      if ( ! IsAuthorized("stock_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1343( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1343( ) ;
      }
      if ( ( nIsMod_43 != 0 ) || ( nIsDirty_43 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1343( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1343( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1343( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001320 */
                     pr_default.execute(18, new Object[] {Long.valueOf(A216StockIdCompra), A217StockFecha, Integer.valueOf(A218StockCantidad), Short.valueOf(A219StockSaldo), A220StockPrecioCompra, A221StockPrecioVenta, Long.valueOf(A289StockDetalleTallaID), Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
                     if ( (pr_default.getStatus(18) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"StockDetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1343( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1343( ) ;
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
            endLevel1343( ) ;
         }
      }
      closeExtendedTableCursors1343( ) ;
   }

   public void deferredUpdate1343( )
   {
   }

   public void delete1343( )
   {
      if ( ! IsAuthorized("stock_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1343( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1343( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1343( ) ;
         afterConfirm1343( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1343( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001321 */
               pr_default.execute(19, new Object[] {Long.valueOf(A46StockId), Long.valueOf(A50StockDetalleID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("StockDetalle");
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
      sMode43 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1343( ) ;
      Gx_mode = sMode43 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1343( )
   {
      standaloneModal1343( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1343( )
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

   public void scanStart1343( )
   {
      /* Scan By routine */
      /* Using cursor T001322 */
      pr_default.execute(20, new Object[] {Long.valueOf(A46StockId)});
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A50StockDetalleID = T001322_A50StockDetalleID[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1343( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A50StockDetalleID = T001322_A50StockDetalleID[0] ;
      }
   }

   public void scanEnd1343( )
   {
      pr_default.close(20);
   }

   public void afterConfirm1343( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1343( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1343( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1343( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1343( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1343( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1343( )
   {
      edtStockIdCompra_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockIdCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockIdCompra_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtStockFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockFecha_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtStockCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockCantidad_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtStockSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockSaldo_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtStockPrecioCompra_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockPrecioCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockPrecioCompra_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtStockPrecioVenta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockPrecioVenta_Enabled), 5, 0), !bGXsfl_44_Refreshing);
      edtStockDetalleID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
   }

   public void send_integrity_lvl_hashes1343( )
   {
   }

   public void send_integrity_lvl_hashes1342( )
   {
   }

   public void subsflControlProps_4443( )
   {
      edtStockIdCompra_Internalname = "STOCKIDCOMPRA_"+sGXsfl_44_idx ;
      edtStockFecha_Internalname = "STOCKFECHA_"+sGXsfl_44_idx ;
      edtStockCantidad_Internalname = "STOCKCANTIDAD_"+sGXsfl_44_idx ;
      edtStockSaldo_Internalname = "STOCKSALDO_"+sGXsfl_44_idx ;
      edtStockPrecioCompra_Internalname = "STOCKPRECIOCOMPRA_"+sGXsfl_44_idx ;
      edtStockPrecioVenta_Internalname = "STOCKPRECIOVENTA_"+sGXsfl_44_idx ;
      edtStockDetalleID_Internalname = "STOCKDETALLEID_"+sGXsfl_44_idx ;
   }

   public void subsflControlProps_fel_4443( )
   {
      edtStockIdCompra_Internalname = "STOCKIDCOMPRA_"+sGXsfl_44_fel_idx ;
      edtStockFecha_Internalname = "STOCKFECHA_"+sGXsfl_44_fel_idx ;
      edtStockCantidad_Internalname = "STOCKCANTIDAD_"+sGXsfl_44_fel_idx ;
      edtStockSaldo_Internalname = "STOCKSALDO_"+sGXsfl_44_fel_idx ;
      edtStockPrecioCompra_Internalname = "STOCKPRECIOCOMPRA_"+sGXsfl_44_fel_idx ;
      edtStockPrecioVenta_Internalname = "STOCKPRECIOVENTA_"+sGXsfl_44_fel_idx ;
      edtStockDetalleID_Internalname = "STOCKDETALLEID_"+sGXsfl_44_fel_idx ;
   }

   public void addRow1343( )
   {
      nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
      sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4443( ) ;
      sendRow1343( ) ;
   }

   public void sendRow1343( )
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
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockIdCompra_Internalname,GXutil.ltrim( localUtil.ntoc( A216StockIdCompra, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtStockIdCompra_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A216StockIdCompra), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A216StockIdCompra), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,45);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockIdCompra_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockIdCompra_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidthDate" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockFecha_Internalname,localUtil.format(A217StockFecha, "99/99/99"),localUtil.format( A217StockFecha, "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,46);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockFecha_Jsonclick,Integer.valueOf(0),"AttributeRealWidthDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockFecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockCantidad_Internalname,GXutil.ltrim( localUtil.ntoc( A218StockCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtStockCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A218StockCantidad), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A218StockCantidad), "ZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockCantidad_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockCantidad_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cantidad","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 48,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockSaldo_Internalname,GXutil.ltrim( localUtil.ntoc( A219StockSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtStockSaldo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A219StockSaldo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A219StockSaldo), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,48);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockSaldo_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockSaldo_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Saldo","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockPrecioCompra_Internalname,GXutil.ltrim( localUtil.ntoc( A220StockPrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtStockPrecioCompra_Enabled!=0) ? localUtil.format( A220StockPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A220StockPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,49);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockPrecioCompra_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockPrecioCompra_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 50,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockPrecioVenta_Internalname,GXutil.ltrim( localUtil.ntoc( A221StockPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtStockPrecioVenta_Enabled!=0) ? localUtil.format( A221StockPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A221StockPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,50);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockPrecioVenta_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockPrecioVenta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_43_" + sGXsfl_44_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 51,'',false,'" + sGXsfl_44_idx + "',44)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtStockDetalleID_Internalname,GXutil.ltrim( localUtil.ntoc( A50StockDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A50StockDetalleID), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,51);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtStockDetalleID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtStockDetalleID_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(44),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes1343( ) ;
      GXCCtl = "Z50StockDetalleID_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z50StockDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z216StockIdCompra_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z216StockIdCompra, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z217StockFecha_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z217StockFecha, 0, "/"));
      GXCCtl = "Z218StockCantidad_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z218StockCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z219StockSaldo_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z219StockSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z220StockPrecioCompra_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z220StockPrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z221StockPrecioVenta_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z221StockPrecioVenta, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z289StockDetalleTallaID_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z289StockDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_43_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_43_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_43_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_43, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      GXCCtl = "vSTOCKID_" + sGXsfl_44_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7StockId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKIDCOMPRA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockIdCompra_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKFECHA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockFecha_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKCANTIDAD_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKSALDO_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockSaldo_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKPRECIOCOMPRA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioCompra_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKPRECIOVENTA_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKDETALLEID_"+sGXsfl_44_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtStockDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow1343( )
   {
      nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
      sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4443( ) ;
      edtStockIdCompra_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKIDCOMPRA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtStockFecha_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKFECHA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtStockCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKCANTIDAD_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtStockSaldo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKSALDO_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtStockPrecioCompra_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKPRECIOCOMPRA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtStockPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKPRECIOVENTA_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtStockDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "STOCKDETALLEID_"+sGXsfl_44_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtStockIdCompra_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtStockIdCompra_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "STOCKIDCOMPRA_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockIdCompra_Internalname ;
         wbErr = true ;
         A216StockIdCompra = 0 ;
      }
      else
      {
         A216StockIdCompra = localUtil.ctol( httpContext.cgiGet( edtStockIdCompra_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( localUtil.vcdate( httpContext.cgiGet( edtStockFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "STOCKFECHA_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockFecha_Internalname ;
         wbErr = true ;
         A217StockFecha = GXutil.nullDate() ;
      }
      else
      {
         A217StockFecha = localUtil.ctod( httpContext.cgiGet( edtStockFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtStockCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtStockCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
      {
         GXCCtl = "STOCKCANTIDAD_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockCantidad_Internalname ;
         wbErr = true ;
         A218StockCantidad = 0 ;
      }
      else
      {
         A218StockCantidad = (int)(localUtil.ctol( httpContext.cgiGet( edtStockCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtStockSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtStockSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "STOCKSALDO_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockSaldo_Internalname ;
         wbErr = true ;
         A219StockSaldo = (short)(0) ;
      }
      else
      {
         A219StockSaldo = (short)(localUtil.ctol( httpContext.cgiGet( edtStockSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtStockPrecioCompra_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtStockPrecioCompra_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
      {
         GXCCtl = "STOCKPRECIOCOMPRA_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockPrecioCompra_Internalname ;
         wbErr = true ;
         A220StockPrecioCompra = DecimalUtil.ZERO ;
      }
      else
      {
         A220StockPrecioCompra = localUtil.ctond( httpContext.cgiGet( edtStockPrecioCompra_Internalname)) ;
      }
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtStockPrecioVenta_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtStockPrecioVenta_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
      {
         GXCCtl = "STOCKPRECIOVENTA_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockPrecioVenta_Internalname ;
         wbErr = true ;
         A221StockPrecioVenta = DecimalUtil.ZERO ;
      }
      else
      {
         A221StockPrecioVenta = localUtil.ctond( httpContext.cgiGet( edtStockPrecioVenta_Internalname)) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtStockDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtStockDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "STOCKDETALLEID_" + sGXsfl_44_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtStockDetalleID_Internalname ;
         wbErr = true ;
         A50StockDetalleID = 0 ;
      }
      else
      {
         A50StockDetalleID = localUtil.ctol( httpContext.cgiGet( edtStockDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      GXCCtl = "Z50StockDetalleID_" + sGXsfl_44_idx ;
      Z50StockDetalleID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z216StockIdCompra_" + sGXsfl_44_idx ;
      Z216StockIdCompra = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z217StockFecha_" + sGXsfl_44_idx ;
      Z217StockFecha = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z218StockCantidad_" + sGXsfl_44_idx ;
      Z218StockCantidad = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z219StockSaldo_" + sGXsfl_44_idx ;
      Z219StockSaldo = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z220StockPrecioCompra_" + sGXsfl_44_idx ;
      Z220StockPrecioCompra = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z221StockPrecioVenta_" + sGXsfl_44_idx ;
      Z221StockPrecioVenta = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z289StockDetalleTallaID_" + sGXsfl_44_idx ;
      Z289StockDetalleTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z289StockDetalleTallaID_" + sGXsfl_44_idx ;
      A289StockDetalleTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "nRcdDeleted_43_" + sGXsfl_44_idx ;
      nRcdDeleted_43 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_43_" + sGXsfl_44_idx ;
      nRcdExists_43 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_43_" + sGXsfl_44_idx ;
      nIsMod_43 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtStockDetalleID_Enabled = edtStockDetalleID_Enabled ;
   }

   public void confirmValues130( )
   {
      nGXsfl_44_idx = 0 ;
      sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4443( ) ;
      while ( nGXsfl_44_idx < nRC_GXsfl_44 )
      {
         nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
         sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4443( ) ;
         httpContext.changePostValue( "Z50StockDetalleID_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z50StockDetalleID_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z50StockDetalleID_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z216StockIdCompra_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z216StockIdCompra_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z216StockIdCompra_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z217StockFecha_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z217StockFecha_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z217StockFecha_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z218StockCantidad_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z218StockCantidad_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z218StockCantidad_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z219StockSaldo_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z219StockSaldo_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z219StockSaldo_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z220StockPrecioCompra_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z220StockPrecioCompra_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z220StockPrecioCompra_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z221StockPrecioVenta_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z221StockPrecioVenta_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z221StockPrecioVenta_"+sGXsfl_44_idx) ;
         httpContext.changePostValue( "Z289StockDetalleTallaID_"+sGXsfl_44_idx, httpContext.cgiGet( "ZT_"+"Z289StockDetalleTallaID_"+sGXsfl_44_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z289StockDetalleTallaID_"+sGXsfl_44_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.stock", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7StockId,11,0))}, new String[] {"Gx_mode","StockId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Stock");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("stock:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z46StockId", GXutil.ltrim( localUtil.ntoc( Z46StockId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z233StockTotal", GXutil.ltrim( localUtil.ntoc( Z233StockTotal, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z13ArticuloId", GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_44", GXutil.ltrim( localUtil.ntoc( nGXsfl_44_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N13ArticuloId", GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSTOCKID", GXutil.ltrim( localUtil.ntoc( AV7StockId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSTOCKID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7StockId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ARTICULOID", GXutil.ltrim( localUtil.ntoc( AV13Insert_ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "STOCKDETALLETALLAID", GXutil.ltrim( localUtil.ntoc( A289StockDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.stock", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7StockId,11,0))}, new String[] {"Gx_mode","StockId"})  ;
   }

   public String getPgmname( )
   {
      return "Stock" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Stock", "") ;
   }

   public void initializeNonKey1342( )
   {
      A13ArticuloId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      A76ArticuloNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
      A233StockTotal = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A233StockTotal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A233StockTotal), 5, 0));
      Z233StockTotal = 0 ;
      Z13ArticuloId = 0 ;
   }

   public void initAll1342( )
   {
      A46StockId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
      initializeNonKey1342( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey1343( )
   {
      A216StockIdCompra = 0 ;
      A217StockFecha = GXutil.nullDate() ;
      A218StockCantidad = 0 ;
      A219StockSaldo = (short)(0) ;
      A220StockPrecioCompra = DecimalUtil.ZERO ;
      A221StockPrecioVenta = DecimalUtil.ZERO ;
      A289StockDetalleTallaID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A289StockDetalleTallaID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A289StockDetalleTallaID), 11, 0));
      Z216StockIdCompra = 0 ;
      Z217StockFecha = GXutil.nullDate() ;
      Z218StockCantidad = 0 ;
      Z219StockSaldo = (short)(0) ;
      Z220StockPrecioCompra = DecimalUtil.ZERO ;
      Z221StockPrecioVenta = DecimalUtil.ZERO ;
      Z289StockDetalleTallaID = 0 ;
   }

   public void initAll1343( )
   {
      A50StockDetalleID = 0 ;
      initializeNonKey1343( ) ;
   }

   public void standaloneModalInsert1343( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111104331", true, true);
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
      httpContext.AddJavascriptSource("stock.js", "?202412111104332", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties43( )
   {
      edtStockDetalleID_Enabled = defedtStockDetalleID_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtStockDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtStockDetalleID_Enabled), 5, 0), !bGXsfl_44_Refreshing);
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
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A216StockIdCompra, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockIdCompra_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", localUtil.format(A217StockFecha, "99/99/99"));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockFecha_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A218StockCantidad, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A219StockSaldo, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockSaldo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A220StockPrecioCompra, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioCompra_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A221StockPrecioVenta, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A50StockDetalleID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtStockDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      edtStockId_Internalname = "STOCKID" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtStockTotal_Internalname = "STOCKTOTAL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtStockIdCompra_Internalname = "STOCKIDCOMPRA" ;
      edtStockFecha_Internalname = "STOCKFECHA" ;
      edtStockCantidad_Internalname = "STOCKCANTIDAD" ;
      edtStockSaldo_Internalname = "STOCKSALDO" ;
      edtStockPrecioCompra_Internalname = "STOCKPRECIOCOMPRA" ;
      edtStockPrecioVenta_Internalname = "STOCKPRECIOVENTA" ;
      edtStockDetalleID_Internalname = "STOCKDETALLEID" ;
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
      Form.setCaption( httpContext.getMessage( "Stock", "") );
      edtStockDetalleID_Jsonclick = "" ;
      edtStockPrecioVenta_Jsonclick = "" ;
      edtStockPrecioCompra_Jsonclick = "" ;
      edtStockSaldo_Jsonclick = "" ;
      edtStockCantidad_Jsonclick = "" ;
      edtStockFecha_Jsonclick = "" ;
      edtStockIdCompra_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      edtStockDetalleID_Enabled = 1 ;
      edtStockPrecioVenta_Enabled = 1 ;
      edtStockPrecioCompra_Enabled = 1 ;
      edtStockSaldo_Enabled = 1 ;
      edtStockCantidad_Enabled = 1 ;
      edtStockFecha_Enabled = 1 ;
      edtStockIdCompra_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtStockTotal_Jsonclick = "" ;
      edtStockTotal_Enabled = 1 ;
      edtArticuloNombre_Jsonclick = "" ;
      edtArticuloNombre_Enabled = 0 ;
      imgprompt_13_Visible = 1 ;
      imgprompt_13_Link = "" ;
      edtArticuloId_Jsonclick = "" ;
      edtArticuloId_Enabled = 1 ;
      edtStockId_Jsonclick = "" ;
      edtStockId_Enabled = 1 ;
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

   public void gx3asastockid1342( long AV7StockId ,
                                  String AV15Pgmname )
   {
      if ( ! (0==AV7StockId) )
      {
         A46StockId = AV7StockId ;
         httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A46StockId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
            stock_impl.this.GXt_int2 = GXv_int3[0] ;
            A46StockId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46StockId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46StockId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A46StockId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
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
      subsflControlProps_4443( ) ;
      while ( nGXsfl_44_idx <= nRC_GXsfl_44 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1343( ) ;
         standaloneModal1343( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1343( ) ;
         nGXsfl_44_idx = (int)(nGXsfl_44_idx+1) ;
         sGXsfl_44_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_44_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4443( ) ;
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
      /* Using cursor T001315 */
      pr_default.execute(13, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
      }
      A76ArticuloNombre = T001315_A76ArticuloNombre[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", GXutil.rtrim( A76ArticuloNombre));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7StockId',fld:'vSTOCKID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7StockId',fld:'vSTOCKID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12132',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_STOCKID","{handler:'valid_Stockid',iparms:[]");
      setEventMetadata("VALID_STOCKID",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''}]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''}]}");
      setEventMetadata("VALID_STOCKFECHA","{handler:'valid_Stockfecha',iparms:[]");
      setEventMetadata("VALID_STOCKFECHA",",oparms:[]}");
      setEventMetadata("VALID_STOCKDETALLEID","{handler:'valid_Stockdetalleid',iparms:[]");
      setEventMetadata("VALID_STOCKDETALLEID",",oparms:[]}");
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
      return "stock_Execute";
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z217StockFecha = GXutil.nullDate() ;
      Z220StockPrecioCompra = DecimalUtil.ZERO ;
      Z221StockPrecioVenta = DecimalUtil.ZERO ;
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
      TempTags = "" ;
      imgprompt_13_gximage = "" ;
      sImgUrl = "" ;
      A76ArticuloNombre = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode43 = "" ;
      sStyleString = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode42 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A217StockFecha = GXutil.nullDate() ;
      A220StockPrecioCompra = DecimalUtil.ZERO ;
      A221StockPrecioVenta = DecimalUtil.ZERO ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z76ArticuloNombre = "" ;
      T00136_A76ArticuloNombre = new String[] {""} ;
      T00137_A46StockId = new long[1] ;
      T00137_A76ArticuloNombre = new String[] {""} ;
      T00137_A233StockTotal = new int[1] ;
      T00137_A13ArticuloId = new long[1] ;
      T00138_A76ArticuloNombre = new String[] {""} ;
      T00139_A46StockId = new long[1] ;
      T00135_A46StockId = new long[1] ;
      T00135_A233StockTotal = new int[1] ;
      T00135_A13ArticuloId = new long[1] ;
      T001310_A46StockId = new long[1] ;
      T001311_A46StockId = new long[1] ;
      T00134_A46StockId = new long[1] ;
      T00134_A233StockTotal = new int[1] ;
      T00134_A13ArticuloId = new long[1] ;
      T001315_A76ArticuloNombre = new String[] {""} ;
      T001316_A46StockId = new long[1] ;
      T001317_A46StockId = new long[1] ;
      T001317_A50StockDetalleID = new long[1] ;
      T001317_A216StockIdCompra = new long[1] ;
      T001317_A217StockFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T001317_A218StockCantidad = new int[1] ;
      T001317_A219StockSaldo = new short[1] ;
      T001317_A220StockPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001317_A221StockPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001317_A289StockDetalleTallaID = new long[1] ;
      T001318_A46StockId = new long[1] ;
      T001318_A50StockDetalleID = new long[1] ;
      T00133_A46StockId = new long[1] ;
      T00133_A50StockDetalleID = new long[1] ;
      T00133_A216StockIdCompra = new long[1] ;
      T00133_A217StockFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00133_A218StockCantidad = new int[1] ;
      T00133_A219StockSaldo = new short[1] ;
      T00133_A220StockPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00133_A221StockPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00133_A289StockDetalleTallaID = new long[1] ;
      T00132_A46StockId = new long[1] ;
      T00132_A50StockDetalleID = new long[1] ;
      T00132_A216StockIdCompra = new long[1] ;
      T00132_A217StockFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00132_A218StockCantidad = new int[1] ;
      T00132_A219StockSaldo = new short[1] ;
      T00132_A220StockPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00132_A221StockPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00132_A289StockDetalleTallaID = new long[1] ;
      T001322_A46StockId = new long[1] ;
      T001322_A50StockDetalleID = new long[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int3 = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.stock__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.stock__default(),
         new Object[] {
             new Object[] {
            T00132_A46StockId, T00132_A50StockDetalleID, T00132_A216StockIdCompra, T00132_A217StockFecha, T00132_A218StockCantidad, T00132_A219StockSaldo, T00132_A220StockPrecioCompra, T00132_A221StockPrecioVenta, T00132_A289StockDetalleTallaID
            }
            , new Object[] {
            T00133_A46StockId, T00133_A50StockDetalleID, T00133_A216StockIdCompra, T00133_A217StockFecha, T00133_A218StockCantidad, T00133_A219StockSaldo, T00133_A220StockPrecioCompra, T00133_A221StockPrecioVenta, T00133_A289StockDetalleTallaID
            }
            , new Object[] {
            T00134_A46StockId, T00134_A233StockTotal, T00134_A13ArticuloId
            }
            , new Object[] {
            T00135_A46StockId, T00135_A233StockTotal, T00135_A13ArticuloId
            }
            , new Object[] {
            T00136_A76ArticuloNombre
            }
            , new Object[] {
            T00137_A46StockId, T00137_A76ArticuloNombre, T00137_A233StockTotal, T00137_A13ArticuloId
            }
            , new Object[] {
            T00138_A76ArticuloNombre
            }
            , new Object[] {
            T00139_A46StockId
            }
            , new Object[] {
            T001310_A46StockId
            }
            , new Object[] {
            T001311_A46StockId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001315_A76ArticuloNombre
            }
            , new Object[] {
            T001316_A46StockId
            }
            , new Object[] {
            T001317_A46StockId, T001317_A50StockDetalleID, T001317_A216StockIdCompra, T001317_A217StockFecha, T001317_A218StockCantidad, T001317_A219StockSaldo, T001317_A220StockPrecioCompra, T001317_A221StockPrecioVenta, T001317_A289StockDetalleTallaID
            }
            , new Object[] {
            T001318_A46StockId, T001318_A50StockDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001322_A46StockId, T001322_A50StockDetalleID
            }
         }
      );
      AV15Pgmname = "Stock" ;
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
   private short Z219StockSaldo ;
   private short nRcdDeleted_43 ;
   private short nRcdExists_43 ;
   private short nIsMod_43 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount43 ;
   private short RcdFound43 ;
   private short nBlankRcdUsr43 ;
   private short RcdFound42 ;
   private short A219StockSaldo ;
   private short nIsDirty_42 ;
   private short nIsDirty_43 ;
   private int Z233StockTotal ;
   private int nRC_GXsfl_44 ;
   private int nGXsfl_44_idx=1 ;
   private int Z218StockCantidad ;
   private int trnEnded ;
   private int edtStockId_Enabled ;
   private int edtArticuloId_Enabled ;
   private int imgprompt_13_Visible ;
   private int edtArticuloNombre_Enabled ;
   private int A233StockTotal ;
   private int edtStockTotal_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtStockIdCompra_Enabled ;
   private int edtStockFecha_Enabled ;
   private int edtStockCantidad_Enabled ;
   private int edtStockSaldo_Enabled ;
   private int edtStockPrecioCompra_Enabled ;
   private int edtStockPrecioVenta_Enabled ;
   private int edtStockDetalleID_Enabled ;
   private int fRowAdded ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A218StockCantidad ;
   private int AV16GXV1 ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int defedtStockDetalleID_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private long wcpOAV7StockId ;
   private long Z46StockId ;
   private long Z13ArticuloId ;
   private long N13ArticuloId ;
   private long Z50StockDetalleID ;
   private long Z216StockIdCompra ;
   private long Z289StockDetalleTallaID ;
   private long AV7StockId ;
   private long A13ArticuloId ;
   private long A46StockId ;
   private long AV13Insert_ArticuloId ;
   private long A289StockDetalleTallaID ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private long A216StockIdCompra ;
   private long A50StockDetalleID ;
   private long GXt_int2 ;
   private long GXv_int3[] ;
   private java.math.BigDecimal Z220StockPrecioCompra ;
   private java.math.BigDecimal Z221StockPrecioVenta ;
   private java.math.BigDecimal A220StockPrecioCompra ;
   private java.math.BigDecimal A221StockPrecioVenta ;
   private String sPrefix ;
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
   private String edtStockId_Internalname ;
   private String sGXsfl_44_idx="0001" ;
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
   private String edtStockId_Jsonclick ;
   private String edtArticuloId_Internalname ;
   private String edtArticuloId_Jsonclick ;
   private String imgprompt_13_gximage ;
   private String sImgUrl ;
   private String imgprompt_13_Internalname ;
   private String imgprompt_13_Link ;
   private String edtArticuloNombre_Internalname ;
   private String A76ArticuloNombre ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtStockTotal_Internalname ;
   private String edtStockTotal_Jsonclick ;
   private String divTableleaflevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode43 ;
   private String edtStockIdCompra_Internalname ;
   private String edtStockFecha_Internalname ;
   private String edtStockCantidad_Internalname ;
   private String edtStockSaldo_Internalname ;
   private String edtStockPrecioCompra_Internalname ;
   private String edtStockPrecioVenta_Internalname ;
   private String edtStockDetalleID_Internalname ;
   private String sStyleString ;
   private String subGridlevel_detalle_Internalname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode42 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String Z76ArticuloNombre ;
   private String sGXsfl_44_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String ROClassString ;
   private String edtStockIdCompra_Jsonclick ;
   private String edtStockFecha_Jsonclick ;
   private String edtStockCantidad_Jsonclick ;
   private String edtStockSaldo_Jsonclick ;
   private String edtStockPrecioCompra_Jsonclick ;
   private String edtStockPrecioVenta_Jsonclick ;
   private String edtStockDetalleID_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_detalle_Header ;
   private java.util.Date Z217StockFecha ;
   private java.util.Date A217StockFecha ;
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
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00136_A76ArticuloNombre ;
   private long[] T00137_A46StockId ;
   private String[] T00137_A76ArticuloNombre ;
   private int[] T00137_A233StockTotal ;
   private long[] T00137_A13ArticuloId ;
   private String[] T00138_A76ArticuloNombre ;
   private long[] T00139_A46StockId ;
   private long[] T00135_A46StockId ;
   private int[] T00135_A233StockTotal ;
   private long[] T00135_A13ArticuloId ;
   private long[] T001310_A46StockId ;
   private long[] T001311_A46StockId ;
   private long[] T00134_A46StockId ;
   private int[] T00134_A233StockTotal ;
   private long[] T00134_A13ArticuloId ;
   private String[] T001315_A76ArticuloNombre ;
   private long[] T001316_A46StockId ;
   private long[] T001317_A46StockId ;
   private long[] T001317_A50StockDetalleID ;
   private long[] T001317_A216StockIdCompra ;
   private java.util.Date[] T001317_A217StockFecha ;
   private int[] T001317_A218StockCantidad ;
   private short[] T001317_A219StockSaldo ;
   private java.math.BigDecimal[] T001317_A220StockPrecioCompra ;
   private java.math.BigDecimal[] T001317_A221StockPrecioVenta ;
   private long[] T001317_A289StockDetalleTallaID ;
   private long[] T001318_A46StockId ;
   private long[] T001318_A50StockDetalleID ;
   private long[] T00133_A46StockId ;
   private long[] T00133_A50StockDetalleID ;
   private long[] T00133_A216StockIdCompra ;
   private java.util.Date[] T00133_A217StockFecha ;
   private int[] T00133_A218StockCantidad ;
   private short[] T00133_A219StockSaldo ;
   private java.math.BigDecimal[] T00133_A220StockPrecioCompra ;
   private java.math.BigDecimal[] T00133_A221StockPrecioVenta ;
   private long[] T00133_A289StockDetalleTallaID ;
   private long[] T00132_A46StockId ;
   private long[] T00132_A50StockDetalleID ;
   private long[] T00132_A216StockIdCompra ;
   private java.util.Date[] T00132_A217StockFecha ;
   private int[] T00132_A218StockCantidad ;
   private short[] T00132_A219StockSaldo ;
   private java.math.BigDecimal[] T00132_A220StockPrecioCompra ;
   private java.math.BigDecimal[] T00132_A221StockPrecioVenta ;
   private long[] T00132_A289StockDetalleTallaID ;
   private long[] T001322_A46StockId ;
   private long[] T001322_A50StockDetalleID ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class stock__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class stock__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00132", "SELECT [StockId], [StockDetalleID], [StockIdCompra], [StockFecha], [StockCantidad], [StockSaldo], [StockPrecioCompra], [StockPrecioVenta], [StockDetalleTallaID] FROM [StockDetalle] WITH (UPDLOCK) WHERE [StockId] = ? AND [StockDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00133", "SELECT [StockId], [StockDetalleID], [StockIdCompra], [StockFecha], [StockCantidad], [StockSaldo], [StockPrecioCompra], [StockPrecioVenta], [StockDetalleTallaID] FROM [StockDetalle] WHERE [StockId] = ? AND [StockDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00134", "SELECT [StockId], [StockTotal], [ArticuloId] FROM [Stock] WITH (UPDLOCK) WHERE [StockId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00135", "SELECT [StockId], [StockTotal], [ArticuloId] FROM [Stock] WHERE [StockId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00136", "SELECT [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00137", "SELECT TM1.[StockId], T2.[ArticuloNombre], TM1.[StockTotal], TM1.[ArticuloId] FROM ([Stock] TM1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = TM1.[ArticuloId]) WHERE TM1.[StockId] = ? ORDER BY TM1.[StockId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00138", "SELECT [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00139", "SELECT [StockId] FROM [Stock] WHERE [StockId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001310", "SELECT TOP 1 [StockId] FROM [Stock] WHERE ( [StockId] > ?) ORDER BY [StockId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001311", "SELECT TOP 1 [StockId] FROM [Stock] WHERE ( [StockId] < ?) ORDER BY [StockId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001312", "INSERT INTO [Stock]([StockId], [StockTotal], [ArticuloId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001313", "UPDATE [Stock] SET [StockTotal]=?, [ArticuloId]=?  WHERE [StockId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001314", "DELETE FROM [Stock]  WHERE [StockId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001315", "SELECT [ArticuloNombre] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001316", "SELECT [StockId] FROM [Stock] ORDER BY [StockId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001317", "SELECT [StockId], [StockDetalleID], [StockIdCompra], [StockFecha], [StockCantidad], [StockSaldo], [StockPrecioCompra], [StockPrecioVenta], [StockDetalleTallaID] FROM [StockDetalle] WHERE [StockId] = ? and [StockDetalleID] = ? ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001318", "SELECT [StockId], [StockDetalleID] FROM [StockDetalle] WHERE [StockId] = ? AND [StockDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001319", "INSERT INTO [StockDetalle]([StockId], [StockDetalleID], [StockIdCompra], [StockFecha], [StockCantidad], [StockSaldo], [StockPrecioCompra], [StockPrecioVenta], [StockDetalleTallaID]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001320", "UPDATE [StockDetalle] SET [StockIdCompra]=?, [StockFecha]=?, [StockCantidad]=?, [StockSaldo]=?, [StockPrecioCompra]=?, [StockPrecioVenta]=?, [StockDetalleTallaID]=?  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001321", "DELETE FROM [StockDetalle]  WHERE [StockId] = ? AND [StockDetalleID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001322", "SELECT [StockId], [StockDetalleID] FROM [StockDetalle] WHERE [StockId] = ? ORDER BY [StockId], [StockDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setLong(9, ((Number) parms[8]).longValue());
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               stmt.setLong(9, ((Number) parms[8]).longValue());
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

