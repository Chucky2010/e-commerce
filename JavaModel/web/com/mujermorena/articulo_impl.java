package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class articulo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"ARTICULOID") == 0 )
      {
         AV7ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ArticuloId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ArticuloId), "ZZZZZZZZZZ9")));
         AV16Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asaarticuloid0C14( AV7ArticuloId, AV16Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A17TipoArticuloId = GXutil.lval( httpContext.GetPar( "TipoArticuloId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A17TipoArticuloId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A18ImpuestoId = GXutil.lval( httpContext.GetPar( "ImpuestoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A18ImpuestoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A286TallaID = GXutil.lval( httpContext.GetPar( "TallaID")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A286TallaID) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_talla") == 0 )
      {
         gxnrgridlevel_talla_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_galeria") == 0 )
      {
         gxnrgridlevel_galeria_newrow_invoke( ) ;
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
            AV7ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ArticuloId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ArticuloId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Articulo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_talla_newrow_invoke( )
   {
      nRC_GXsfl_90 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_90"))) ;
      nGXsfl_90_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_90_idx"))) ;
      sGXsfl_90_idx = httpContext.GetPar( "sGXsfl_90_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_talla_newrow( ) ;
      /* End function gxnrGridlevel_talla_newrow_invoke */
   }

   public void gxnrgridlevel_galeria_newrow_invoke( )
   {
      nRC_GXsfl_106 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_106"))) ;
      nGXsfl_106_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_106_idx"))) ;
      sGXsfl_106_idx = httpContext.GetPar( "sGXsfl_106_idx") ;
      A234ArticuloSerial = GXutil.lval( httpContext.GetPar( "ArticuloSerial")) ;
      Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_galeria_newrow( ) ;
      /* End function gxnrGridlevel_galeria_newrow_invoke */
   }

   public articulo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public articulo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articulo_impl.class ));
   }

   public articulo_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Articulo", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Articulo.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
      ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
      ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
      ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTabgeneral_title_Internalname, httpContext.getMessage( "WWP_TemplateDataPanelTitle", ""), "", "", lblTabgeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Articulo.htm");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
      httpContext.writeText( "tabGeneral") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloNombre_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre), GXutil.rtrim( localUtil.format( A76ArticuloNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloDescripcionCorta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloDescripcionCorta_Internalname, httpContext.getMessage( "Descripcion Corta", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtArticuloDescripcionCorta_Internalname, A214ArticuloDescripcionCorta, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", (short)(0), 1, edtArticuloDescripcionCorta_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloDescripcionLarga_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloDescripcionLarga_Internalname, httpContext.getMessage( "Descripcion Larga", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtArticuloDescripcionLarga_Internalname, A215ArticuloDescripcionLarga, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtArticuloDescripcionLarga_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloPrecioCompra_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloPrecioCompra_Internalname, httpContext.getMessage( "Precio Compra", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloPrecioCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A77ArticuloPrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloPrecioCompra_Enabled!=0) ? localUtil.format( A77ArticuloPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A77ArticuloPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloPrecioCompra_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloPrecioCompra_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloPrecioVenta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloPrecioVenta_Internalname, httpContext.getMessage( "Precio Venta", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloPrecioVenta_Enabled!=0) ? localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloPrecioVenta_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloPrecioVenta_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloPrecioPromedio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloPrecioPromedio_Internalname, httpContext.getMessage( "Precio Promedio", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloPrecioPromedio_Internalname, GXutil.ltrim( localUtil.ntoc( A222ArticuloPrecioPromedio, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloPrecioPromedio_Enabled!=0) ? localUtil.format( A222ArticuloPrecioPromedio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A222ArticuloPrecioPromedio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloPrecioPromedio_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloPrecioPromedio_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloStock_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloStock_Internalname, httpContext.getMessage( "Stock", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloStock_Internalname, GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloStock_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloStock_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtArticuloStock_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Stock", "right", false, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoArticuloId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoArticuloId_Internalname, httpContext.getMessage( "Tipo Articulo Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A17TipoArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A17TipoArticuloId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoArticuloId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTipoArticuloId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Articulo.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_17_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_17_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_17_Internalname, sImgUrl, imgprompt_17_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_17_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoArticuloNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoArticuloNombre_Internalname, httpContext.getMessage( "Tipo Articulo Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoArticuloNombre_Internalname, GXutil.rtrim( A103TipoArticuloNombre), GXutil.rtrim( localUtil.format( A103TipoArticuloNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoArticuloNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTipoArticuloNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpuestoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtImpuestoId_Internalname, httpContext.getMessage( "Impuesto Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtImpuestoId_Internalname, GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A18ImpuestoId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpuestoId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtImpuestoId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Articulo.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_18_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_18_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_18_Internalname, sImgUrl, imgprompt_18_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_18_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpuestoPorcentaje_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtImpuestoPorcentaje_Internalname, httpContext.getMessage( "Impuesto Porcentaje", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtImpuestoPorcentaje_Enabled!=0) ? localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99") : localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpuestoPorcentaje_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtImpuestoPorcentaje_Enabled, 0, "text", "", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Porcentaje", "right", false, "", "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgArticuloImagen_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Imagen", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      A231ArticuloImagen_IsBlob = (boolean)(((GXutil.strcmp("", A231ArticuloImagen)==0)&&(GXutil.strcmp("", A40000ArticuloImagen_GXI)==0))||!(GXutil.strcmp("", A231ArticuloImagen)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.getResourceRelative(A231ArticuloImagen)) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgArticuloImagen_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgArticuloImagen_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", "", "", 0, A231ArticuloImagen_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Articulo.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "URL", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.getResourceRelative(A231ArticuloImagen)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "IsBlob", GXutil.booltostr( A231ArticuloImagen_IsBlob), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTablevel_talla_title_Internalname, httpContext.getMessage( "Talla", ""), "", "", lblTablevel_talla_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Articulo.htm");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
      httpContext.writeText( "TabLevel_Talla") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTabtablelevel_talla_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableleaflevel_talla_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridFixedColumnBorders", "left", "top", "", "", "div");
      gxdraw_gridlevel_talla( ) ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTablevel_galeria_title_Internalname, httpContext.getMessage( "Galeria", ""), "", "", lblTablevel_galeria_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Articulo.htm");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
      httpContext.writeText( "TabLevel_Galeria") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTabtablelevel_galeria_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableleaflevel_galeria_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridFixedColumnBorders", "left", "top", "", "", "div");
      gxdraw_gridlevel_galeria( ) ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 115,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Articulo.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Articulo.htm");
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

   public void gxdraw_gridlevel_talla( )
   {
      /*  Grid Control  */
      startgridcontrol90( ) ;
      nGXsfl_90_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount57 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_57 = (short)(1) ;
            scanStart0C57( ) ;
            while ( RcdFound57 != 0 )
            {
               init_level_properties57( ) ;
               getByPrimaryKey0C57( ) ;
               addRow0C57( ) ;
               scanNext0C57( ) ;
            }
            scanEnd0C57( ) ;
            nBlankRcdCount57 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B234ArticuloSerial = A234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         standaloneNotModal0C57( ) ;
         standaloneModal0C57( ) ;
         sMode57 = Gx_mode ;
         while ( nGXsfl_90_idx < nRC_GXsfl_90 )
         {
            bGXsfl_90_Refreshing = true ;
            readRow0C57( ) ;
            edtArticuloTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOTALLAID_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
            edtTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TALLAID_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
            edtTallaNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TALLANOMBRE_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtTallaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTallaNombre_Enabled), 5, 0), !bGXsfl_90_Refreshing);
            edtTallaNumero_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TALLANUMERO_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtTallaNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTallaNumero_Enabled), 5, 0), !bGXsfl_90_Refreshing);
            edtArticuloTallaStock_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOTALLASTOCK_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaStock_Enabled), 5, 0), !bGXsfl_90_Refreshing);
            imgprompt_17_Link = httpContext.cgiGet( "PROMPT_286_"+sGXsfl_90_idx+"Link") ;
            if ( ( nRcdExists_57 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0C57( ) ;
            }
            sendRow0C57( ) ;
            bGXsfl_90_Refreshing = false ;
         }
         Gx_mode = sMode57 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A234ArticuloSerial = B234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount57 = (short)(5) ;
         nRcdExists_57 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0C57( ) ;
            while ( RcdFound57 != 0 )
            {
               sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_9057( ) ;
               init_level_properties57( ) ;
               standaloneNotModal0C57( ) ;
               getByPrimaryKey0C57( ) ;
               standaloneModal0C57( ) ;
               addRow0C57( ) ;
               scanNext0C57( ) ;
            }
            scanEnd0C57( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode57 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_9057( ) ;
         initAll0C57( ) ;
         init_level_properties57( ) ;
         B234ArticuloSerial = A234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         nRcdExists_57 = (short)(0) ;
         nIsMod_57 = (short)(0) ;
         nRcdDeleted_57 = (short)(0) ;
         nBlankRcdCount57 = (short)(nBlankRcdUsr57+nBlankRcdCount57) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount57 > 0 )
         {
            standaloneNotModal0C57( ) ;
            standaloneModal0C57( ) ;
            addRow0C57( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtArticuloTallaID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount57 = (short)(nBlankRcdCount57-1) ;
         }
         Gx_mode = sMode57 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A234ArticuloSerial = B234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_tallaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_talla", Gridlevel_tallaContainer, subGridlevel_talla_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_tallaContainerData", Gridlevel_tallaContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_tallaContainerData"+"V", Gridlevel_tallaContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_tallaContainerData"+"V"+"\" value='"+Gridlevel_tallaContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void gxdraw_gridlevel_galeria( )
   {
      /*  Grid Control  */
      startgridcontrol106( ) ;
      nGXsfl_106_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount15 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_15 = (short)(1) ;
            scanStart0C15( ) ;
            while ( RcdFound15 != 0 )
            {
               init_level_properties15( ) ;
               getByPrimaryKey0C15( ) ;
               addRow0C15( ) ;
               scanNext0C15( ) ;
            }
            scanEnd0C15( ) ;
            nBlankRcdCount15 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B234ArticuloSerial = A234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         standaloneNotModal0C15( ) ;
         standaloneModal0C15( ) ;
         sMode15 = Gx_mode ;
         while ( nGXsfl_106_idx < nRC_GXsfl_106 )
         {
            bGXsfl_106_Refreshing = true ;
            readRow0C15( ) ;
            edtArticuloGaleriaId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOGALERIAID_"+sGXsfl_106_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloGaleriaId_Enabled), 5, 0), !bGXsfl_106_Refreshing);
            edtArticuloGaleriaImagen_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloGaleriaImagen_Enabled), 5, 0), !bGXsfl_106_Refreshing);
            if ( ( nRcdExists_15 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0C15( ) ;
            }
            sendRow0C15( ) ;
            bGXsfl_106_Refreshing = false ;
         }
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A234ArticuloSerial = B234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount15 = (short)(5) ;
         nRcdExists_15 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0C15( ) ;
            while ( RcdFound15 != 0 )
            {
               sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_10615( ) ;
               init_level_properties15( ) ;
               standaloneNotModal0C15( ) ;
               getByPrimaryKey0C15( ) ;
               standaloneModal0C15( ) ;
               addRow0C15( ) ;
               scanNext0C15( ) ;
            }
            scanEnd0C15( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode15 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_10615( ) ;
         initAll0C15( ) ;
         init_level_properties15( ) ;
         B234ArticuloSerial = A234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         nRcdExists_15 = (short)(0) ;
         nIsMod_15 = (short)(0) ;
         nRcdDeleted_15 = (short)(0) ;
         nBlankRcdCount15 = (short)(nBlankRcdUsr15+nBlankRcdCount15) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount15 > 0 )
         {
            standaloneNotModal0C15( ) ;
            standaloneModal0C15( ) ;
            addRow0C15( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtArticuloGaleriaImagen_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount15 = (short)(nBlankRcdCount15-1) ;
         }
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A234ArticuloSerial = B234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_galeriaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_galeria", Gridlevel_galeriaContainer, subGridlevel_galeria_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_galeriaContainerData", Gridlevel_galeriaContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_galeriaContainerData"+"V", Gridlevel_galeriaContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_galeriaContainerData"+"V"+"\" value='"+Gridlevel_galeriaContainer.GridValuesHidden()+"'/>") ;
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
      e110C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( "Z13ArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z76ArticuloNombre = httpContext.cgiGet( "Z76ArticuloNombre") ;
            Z214ArticuloDescripcionCorta = httpContext.cgiGet( "Z214ArticuloDescripcionCorta") ;
            Z77ArticuloPrecioCompra = localUtil.ctond( httpContext.cgiGet( "Z77ArticuloPrecioCompra")) ;
            Z78ArticuloPrecioVenta = localUtil.ctond( httpContext.cgiGet( "Z78ArticuloPrecioVenta")) ;
            Z222ArticuloPrecioPromedio = localUtil.ctond( httpContext.cgiGet( "Z222ArticuloPrecioPromedio")) ;
            Z79ArticuloStock = localUtil.ctol( httpContext.cgiGet( "Z79ArticuloStock"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z234ArticuloSerial = localUtil.ctol( httpContext.cgiGet( "Z234ArticuloSerial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z17TipoArticuloId = localUtil.ctol( httpContext.cgiGet( "Z17TipoArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z18ImpuestoId = localUtil.ctol( httpContext.cgiGet( "Z18ImpuestoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A234ArticuloSerial = localUtil.ctol( httpContext.cgiGet( "Z234ArticuloSerial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            O234ArticuloSerial = localUtil.ctol( httpContext.cgiGet( "O234ArticuloSerial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_90 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_90"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_106 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_106"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N17TipoArticuloId = localUtil.ctol( httpContext.cgiGet( "N17TipoArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N18ImpuestoId = localUtil.ctol( httpContext.cgiGet( "N18ImpuestoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7ArticuloId = localUtil.ctol( httpContext.cgiGet( "vARTICULOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_TipoArticuloId = localUtil.ctol( httpContext.cgiGet( "vINSERT_TIPOARTICULOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV14Insert_ImpuestoId = localUtil.ctol( httpContext.cgiGet( "vINSERT_IMPUESTOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A40000ArticuloImagen_GXI = httpContext.cgiGet( "ARTICULOIMAGEN_GXI") ;
            A234ArticuloSerial = localUtil.ctol( httpContext.cgiGet( "ARTICULOSERIAL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A40001ArticuloGaleriaImagen_GXI = httpContext.cgiGet( "ARTICULOGALERIAIMAGEN_GXI") ;
            Gxuitabspanel_tabs_Objectcall = httpContext.cgiGet( "GXUITABSPANEL_TABS_Objectcall") ;
            Gxuitabspanel_tabs_Enabled = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Enabled")) ;
            Gxuitabspanel_tabs_Activepage = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Activepage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gxuitabspanel_tabs_Activepagecontrolname = httpContext.cgiGet( "GXUITABSPANEL_TABS_Activepagecontrolname") ;
            Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
            Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
            Gxuitabspanel_tabs_Visible = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Visible")) ;
            /* Read variables values. */
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
            A214ArticuloDescripcionCorta = httpContext.cgiGet( edtArticuloDescripcionCorta_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A214ArticuloDescripcionCorta", A214ArticuloDescripcionCorta);
            A215ArticuloDescripcionLarga = httpContext.cgiGet( edtArticuloDescripcionLarga_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A215ArticuloDescripcionLarga", A215ArticuloDescripcionLarga);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioCompra_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioCompra_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTICULOPRECIOCOMPRA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtArticuloPrecioCompra_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A77ArticuloPrecioCompra = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
            }
            else
            {
               A77ArticuloPrecioCompra = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioCompra_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTICULOPRECIOVENTA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtArticuloPrecioVenta_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
            }
            else
            {
               A78ArticuloPrecioVenta = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioPromedio_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioPromedio_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTICULOPRECIOPROMEDIO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtArticuloPrecioPromedio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
            }
            else
            {
               A222ArticuloPrecioPromedio = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioPromedio_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTICULOSTOCK");
               AnyError = (short)(1) ;
               GX_FocusControl = edtArticuloStock_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A79ArticuloStock = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
            }
            else
            {
               A79ArticuloStock = localUtil.ctol( httpContext.cgiGet( edtArticuloStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOARTICULOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoArticuloId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A17TipoArticuloId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
            }
            else
            {
               A17TipoArticuloId = localUtil.ctol( httpContext.cgiGet( edtTipoArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
            }
            A103TipoArticuloNombre = httpContext.cgiGet( edtTipoArticuloNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtImpuestoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtImpuestoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "IMPUESTOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtImpuestoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A18ImpuestoId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
            }
            else
            {
               A18ImpuestoId = localUtil.ctol( httpContext.cgiGet( edtImpuestoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
            }
            A83ImpuestoPorcentaje = localUtil.ctond( httpContext.cgiGet( edtImpuestoPorcentaje_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
            A231ArticuloImagen = httpContext.cgiGet( imgArticuloImagen_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A231ArticuloImagen", A231ArticuloImagen);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A231ArticuloImagen ;
            GXv_char2[0] = A40000ArticuloImagen_GXI ;
            httpContext.getMultimediaValue(imgArticuloImagen_Internalname, GXv_char1, GXv_char2);
            articulo_impl.this.A231ArticuloImagen = GXv_char1[0] ;
            articulo_impl.this.A40000ArticuloImagen_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Articulo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A13ArticuloId != Z13ArticuloId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("articulo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
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
                  sMode14 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode14 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound14 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0C0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ARTICULOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtArticuloId_Internalname ;
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
                        e110C2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120C2 ();
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
         e120C2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0C14( ) ;
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
         disableAttributes0C14( ) ;
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

   public void confirm_0C0( )
   {
      beforeValidate0C14( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0C14( ) ;
         }
         else
         {
            checkExtendedTable0C14( ) ;
            closeExtendedTableCursors0C14( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode14 = Gx_mode ;
         confirm_0C57( ) ;
         if ( AnyError == 0 )
         {
            confirm_0C15( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode14 ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               IsConfirmed = (short)(1) ;
               httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode14 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0C15( )
   {
      s234ArticuloSerial = O234ArticuloSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      nGXsfl_106_idx = 0 ;
      while ( nGXsfl_106_idx < nRC_GXsfl_106 )
      {
         readRow0C15( ) ;
         if ( ( nRcdExists_15 != 0 ) || ( nIsMod_15 != 0 ) )
         {
            getKey0C15( ) ;
            if ( ( nRcdExists_15 == 0 ) && ( nRcdDeleted_15 == 0 ) )
            {
               if ( RcdFound15 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0C15( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0C15( ) ;
                     closeExtendedTableCursors0C15( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                     O234ArticuloSerial = A234ArticuloSerial ;
                     httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "ARTICULOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtArticuloId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound15 != 0 )
               {
                  if ( nRcdDeleted_15 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0C15( ) ;
                     load0C15( ) ;
                     beforeValidate0C15( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0C15( ) ;
                        O234ArticuloSerial = A234ArticuloSerial ;
                        httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
                     }
                  }
                  else
                  {
                     if ( nIsMod_15 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0C15( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0C15( ) ;
                           closeExtendedTableCursors0C15( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                           O234ArticuloSerial = A234ArticuloSerial ;
                           httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_15 == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ARTICULOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtArticuloId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtArticuloGaleriaId_Internalname, GXutil.ltrim( localUtil.ntoc( A48ArticuloGaleriaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloGaleriaImagen_Internalname, A230ArticuloGaleriaImagen) ;
         httpContext.changePostValue( "ZT_"+"Z48ArticuloGaleriaId_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( Z48ArticuloGaleriaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_15_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_15_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_15_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_15 != 0 )
         {
            httpContext.changePostValue( "ARTICULOGALERIAID_"+sGXsfl_106_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaImagen_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      O234ArticuloSerial = s234ArticuloSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0C57( )
   {
      nGXsfl_90_idx = 0 ;
      while ( nGXsfl_90_idx < nRC_GXsfl_90 )
      {
         readRow0C57( ) ;
         if ( ( nRcdExists_57 != 0 ) || ( nIsMod_57 != 0 ) )
         {
            getKey0C57( ) ;
            if ( ( nRcdExists_57 == 0 ) && ( nRcdDeleted_57 == 0 ) )
            {
               if ( RcdFound57 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0C57( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0C57( ) ;
                     closeExtendedTableCursors0C57( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "ARTICULOTALLAID_" + sGXsfl_90_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtArticuloTallaID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound57 != 0 )
               {
                  if ( nRcdDeleted_57 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0C57( ) ;
                     load0C57( ) ;
                     beforeValidate0C57( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0C57( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_57 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0C57( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0C57( ) ;
                           closeExtendedTableCursors0C57( ) ;
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
                  if ( nRcdDeleted_57 == 0 )
                  {
                     GXCCtl = "ARTICULOTALLAID_" + sGXsfl_90_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtArticuloTallaID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtArticuloTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A285ArticuloTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtTallaNombre_Internalname, GXutil.rtrim( A287TallaNombre)) ;
         httpContext.changePostValue( edtTallaNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A288TallaNumero, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloTallaStock_Internalname, GXutil.ltrim( localUtil.ntoc( A290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z285ArticuloTallaID_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( Z285ArticuloTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z290ArticuloTallaStock_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( Z290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z286TallaID_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( Z286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_57_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_57_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_57_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_57 != 0 )
         {
            httpContext.changePostValue( "ARTICULOTALLAID_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TALLAID_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TALLANOMBRE_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TALLANUMERO_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNumero_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOTALLASTOCK_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaStock_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0C0( )
   {
   }

   public void e110C2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV8WWPContext = GXv_SdtWWPContext3[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV16Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV18GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18GXV1), 8, 0));
         while ( AV18GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV18GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoArticuloId") == 0 )
            {
               AV13Insert_TipoArticuloId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_TipoArticuloId), 11, 0));
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ImpuestoId") == 0 )
            {
               AV14Insert_ImpuestoId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_ImpuestoId), 11, 0));
            }
            AV18GXV1 = (int)(AV18GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18GXV1), 8, 0));
         }
      }
   }

   public void e120C2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.articuloww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(8);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0C14( int GX_JID )
   {
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z76ArticuloNombre = T000C8_A76ArticuloNombre[0] ;
            Z214ArticuloDescripcionCorta = T000C8_A214ArticuloDescripcionCorta[0] ;
            Z77ArticuloPrecioCompra = T000C8_A77ArticuloPrecioCompra[0] ;
            Z78ArticuloPrecioVenta = T000C8_A78ArticuloPrecioVenta[0] ;
            Z222ArticuloPrecioPromedio = T000C8_A222ArticuloPrecioPromedio[0] ;
            Z79ArticuloStock = T000C8_A79ArticuloStock[0] ;
            Z234ArticuloSerial = T000C8_A234ArticuloSerial[0] ;
            Z17TipoArticuloId = T000C8_A17TipoArticuloId[0] ;
            Z18ImpuestoId = T000C8_A18ImpuestoId[0] ;
         }
         else
         {
            Z76ArticuloNombre = A76ArticuloNombre ;
            Z214ArticuloDescripcionCorta = A214ArticuloDescripcionCorta ;
            Z77ArticuloPrecioCompra = A77ArticuloPrecioCompra ;
            Z78ArticuloPrecioVenta = A78ArticuloPrecioVenta ;
            Z222ArticuloPrecioPromedio = A222ArticuloPrecioPromedio ;
            Z79ArticuloStock = A79ArticuloStock ;
            Z234ArticuloSerial = A234ArticuloSerial ;
            Z17TipoArticuloId = A17TipoArticuloId ;
            Z18ImpuestoId = A18ImpuestoId ;
         }
      }
      if ( GX_JID == -15 )
      {
         Z13ArticuloId = A13ArticuloId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
         Z214ArticuloDescripcionCorta = A214ArticuloDescripcionCorta ;
         Z215ArticuloDescripcionLarga = A215ArticuloDescripcionLarga ;
         Z77ArticuloPrecioCompra = A77ArticuloPrecioCompra ;
         Z78ArticuloPrecioVenta = A78ArticuloPrecioVenta ;
         Z222ArticuloPrecioPromedio = A222ArticuloPrecioPromedio ;
         Z79ArticuloStock = A79ArticuloStock ;
         Z231ArticuloImagen = A231ArticuloImagen ;
         Z40000ArticuloImagen_GXI = A40000ArticuloImagen_GXI ;
         Z234ArticuloSerial = A234ArticuloSerial ;
         Z17TipoArticuloId = A17TipoArticuloId ;
         Z18ImpuestoId = A18ImpuestoId ;
         Z103TipoArticuloNombre = A103TipoArticuloNombre ;
         Z83ImpuestoPorcentaje = A83ImpuestoPorcentaje ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      AV16Pgmname = "Articulo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      imgprompt_17_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.tipoarticuloprompt"+"',["+"{Ctrl:gx.dom.el('"+"TIPOARTICULOID"+"'), id:'"+"TIPOARTICULOID"+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"TIPOARTICULONOMBRE"+"'), id:'"+"TIPOARTICULONOMBRE"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_18_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.impuestoprompt"+"',["+"{Ctrl:gx.dom.el('"+"IMPUESTOID"+"'), id:'"+"IMPUESTOID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7ArticuloId) )
      {
         A13ArticuloId = AV7ArticuloId ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int4 = A13ArticuloId ;
            GXv_int5[0] = GXt_int4 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int5) ;
            articulo_impl.this.GXt_int4 = GXv_int5[0] ;
            A13ArticuloId = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         }
      }
      if ( ! (0==AV7ArticuloId) )
      {
         edtArticuloId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      }
      else
      {
         edtArticuloId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7ArticuloId) )
      {
         edtArticuloId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoArticuloId) )
      {
         edtTipoArticuloId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoArticuloId_Enabled), 5, 0), true);
      }
      else
      {
         edtTipoArticuloId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoArticuloId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_ImpuestoId) )
      {
         edtImpuestoId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpuestoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoId_Enabled), 5, 0), true);
      }
      else
      {
         edtImpuestoId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpuestoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_ImpuestoId) )
      {
         A18ImpuestoId = AV14Insert_ImpuestoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoArticuloId) )
      {
         A17TipoArticuloId = AV13Insert_TipoArticuloId ;
         httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
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
         /* Using cursor T000C10 */
         pr_default.execute(8, new Object[] {Long.valueOf(A18ImpuestoId)});
         A83ImpuestoPorcentaje = T000C10_A83ImpuestoPorcentaje[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
         pr_default.close(8);
         /* Using cursor T000C9 */
         pr_default.execute(7, new Object[] {Long.valueOf(A17TipoArticuloId)});
         A103TipoArticuloNombre = T000C9_A103TipoArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
         pr_default.close(7);
      }
   }

   public void load0C14( )
   {
      /* Using cursor T000C11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A76ArticuloNombre = T000C11_A76ArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
         A214ArticuloDescripcionCorta = T000C11_A214ArticuloDescripcionCorta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A214ArticuloDescripcionCorta", A214ArticuloDescripcionCorta);
         A215ArticuloDescripcionLarga = T000C11_A215ArticuloDescripcionLarga[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A215ArticuloDescripcionLarga", A215ArticuloDescripcionLarga);
         A77ArticuloPrecioCompra = T000C11_A77ArticuloPrecioCompra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
         A78ArticuloPrecioVenta = T000C11_A78ArticuloPrecioVenta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
         A222ArticuloPrecioPromedio = T000C11_A222ArticuloPrecioPromedio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
         A79ArticuloStock = T000C11_A79ArticuloStock[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
         A103TipoArticuloNombre = T000C11_A103TipoArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
         A83ImpuestoPorcentaje = T000C11_A83ImpuestoPorcentaje[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
         A231ArticuloImagen = T000C11_A231ArticuloImagen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A231ArticuloImagen", A231ArticuloImagen);
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
         A40000ArticuloImagen_GXI = T000C11_A40000ArticuloImagen_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
         A234ArticuloSerial = T000C11_A234ArticuloSerial[0] ;
         A17TipoArticuloId = T000C11_A17TipoArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
         A18ImpuestoId = T000C11_A18ImpuestoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         zm0C14( -15) ;
      }
      pr_default.close(9);
      onLoadActions0C14( ) ;
   }

   public void onLoadActions0C14( )
   {
   }

   public void checkExtendedTable0C14( )
   {
      nIsDirty_14 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      /* Using cursor T000C9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A17TipoArticuloId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A103TipoArticuloNombre = T000C9_A103TipoArticuloNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
      pr_default.close(7);
      /* Using cursor T000C10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtImpuestoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A83ImpuestoPorcentaje = T000C10_A83ImpuestoPorcentaje[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
      pr_default.close(8);
   }

   public void closeExtendedTableCursors0C14( )
   {
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void gxload_16( long A17TipoArticuloId )
   {
      /* Using cursor T000C12 */
      pr_default.execute(10, new Object[] {Long.valueOf(A17TipoArticuloId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A103TipoArticuloNombre = T000C12_A103TipoArticuloNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A103TipoArticuloNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_17( long A18ImpuestoId )
   {
      /* Using cursor T000C13 */
      pr_default.execute(11, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtImpuestoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A83ImpuestoPorcentaje = T000C13_A83ImpuestoPorcentaje[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void getKey0C14( )
   {
      /* Using cursor T000C14 */
      pr_default.execute(12, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound14 = (short)(1) ;
      }
      else
      {
         RcdFound14 = (short)(0) ;
      }
      pr_default.close(12);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000C8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0C14( 15) ;
         RcdFound14 = (short)(1) ;
         A13ArticuloId = T000C8_A13ArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         A76ArticuloNombre = T000C8_A76ArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
         A214ArticuloDescripcionCorta = T000C8_A214ArticuloDescripcionCorta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A214ArticuloDescripcionCorta", A214ArticuloDescripcionCorta);
         A215ArticuloDescripcionLarga = T000C8_A215ArticuloDescripcionLarga[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A215ArticuloDescripcionLarga", A215ArticuloDescripcionLarga);
         A77ArticuloPrecioCompra = T000C8_A77ArticuloPrecioCompra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
         A78ArticuloPrecioVenta = T000C8_A78ArticuloPrecioVenta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
         A222ArticuloPrecioPromedio = T000C8_A222ArticuloPrecioPromedio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
         A79ArticuloStock = T000C8_A79ArticuloStock[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
         A231ArticuloImagen = T000C8_A231ArticuloImagen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A231ArticuloImagen", A231ArticuloImagen);
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
         A40000ArticuloImagen_GXI = T000C8_A40000ArticuloImagen_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
         A234ArticuloSerial = T000C8_A234ArticuloSerial[0] ;
         A17TipoArticuloId = T000C8_A17TipoArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
         A18ImpuestoId = T000C8_A18ImpuestoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         O234ArticuloSerial = A234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         Z13ArticuloId = A13ArticuloId ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0C14( ) ;
         if ( AnyError == 1 )
         {
            RcdFound14 = (short)(0) ;
            initializeNonKey0C14( ) ;
         }
         Gx_mode = sMode14 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound14 = (short)(0) ;
         initializeNonKey0C14( ) ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode14 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0C14( ) ;
      if ( RcdFound14 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound14 = (short)(0) ;
      /* Using cursor T000C15 */
      pr_default.execute(13, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T000C15_A13ArticuloId[0] < A13ArticuloId ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T000C15_A13ArticuloId[0] > A13ArticuloId ) ) )
         {
            A13ArticuloId = T000C15_A13ArticuloId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
            RcdFound14 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void move_previous( )
   {
      RcdFound14 = (short)(0) ;
      /* Using cursor T000C16 */
      pr_default.execute(14, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( T000C16_A13ArticuloId[0] > A13ArticuloId ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( T000C16_A13ArticuloId[0] < A13ArticuloId ) ) )
         {
            A13ArticuloId = T000C16_A13ArticuloId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
            RcdFound14 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0C14( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         A234ArticuloSerial = O234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0C14( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound14 == 1 )
         {
            if ( A13ArticuloId != Z13ArticuloId )
            {
               A13ArticuloId = Z13ArticuloId ;
               httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ARTICULOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtArticuloId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               A234ArticuloSerial = O234ArticuloSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtArticuloId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               A234ArticuloSerial = O234ArticuloSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
               update0C14( ) ;
               GX_FocusControl = edtArticuloId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A13ArticuloId != Z13ArticuloId )
            {
               /* Insert record */
               A234ArticuloSerial = O234ArticuloSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
               GX_FocusControl = edtArticuloId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0C14( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ARTICULOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtArticuloId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  A234ArticuloSerial = O234ArticuloSerial ;
                  httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
                  GX_FocusControl = edtArticuloId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0C14( ) ;
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
      if ( A13ArticuloId != Z13ArticuloId )
      {
         A13ArticuloId = Z13ArticuloId ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         A234ArticuloSerial = O234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0C14( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000C7 */
         pr_default.execute(5, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Articulo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z76ArticuloNombre, T000C7_A76ArticuloNombre[0]) != 0 ) || ( GXutil.strcmp(Z214ArticuloDescripcionCorta, T000C7_A214ArticuloDescripcionCorta[0]) != 0 ) || ( DecimalUtil.compareTo(Z77ArticuloPrecioCompra, T000C7_A77ArticuloPrecioCompra[0]) != 0 ) || ( DecimalUtil.compareTo(Z78ArticuloPrecioVenta, T000C7_A78ArticuloPrecioVenta[0]) != 0 ) || ( DecimalUtil.compareTo(Z222ArticuloPrecioPromedio, T000C7_A222ArticuloPrecioPromedio[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z79ArticuloStock != T000C7_A79ArticuloStock[0] ) || ( Z234ArticuloSerial != T000C7_A234ArticuloSerial[0] ) || ( Z17TipoArticuloId != T000C7_A17TipoArticuloId[0] ) || ( Z18ImpuestoId != T000C7_A18ImpuestoId[0] ) )
         {
            if ( GXutil.strcmp(Z76ArticuloNombre, T000C7_A76ArticuloNombre[0]) != 0 )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloNombre");
               GXutil.writeLogRaw("Old: ",Z76ArticuloNombre);
               GXutil.writeLogRaw("Current: ",T000C7_A76ArticuloNombre[0]);
            }
            if ( GXutil.strcmp(Z214ArticuloDescripcionCorta, T000C7_A214ArticuloDescripcionCorta[0]) != 0 )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloDescripcionCorta");
               GXutil.writeLogRaw("Old: ",Z214ArticuloDescripcionCorta);
               GXutil.writeLogRaw("Current: ",T000C7_A214ArticuloDescripcionCorta[0]);
            }
            if ( DecimalUtil.compareTo(Z77ArticuloPrecioCompra, T000C7_A77ArticuloPrecioCompra[0]) != 0 )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloPrecioCompra");
               GXutil.writeLogRaw("Old: ",Z77ArticuloPrecioCompra);
               GXutil.writeLogRaw("Current: ",T000C7_A77ArticuloPrecioCompra[0]);
            }
            if ( DecimalUtil.compareTo(Z78ArticuloPrecioVenta, T000C7_A78ArticuloPrecioVenta[0]) != 0 )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloPrecioVenta");
               GXutil.writeLogRaw("Old: ",Z78ArticuloPrecioVenta);
               GXutil.writeLogRaw("Current: ",T000C7_A78ArticuloPrecioVenta[0]);
            }
            if ( DecimalUtil.compareTo(Z222ArticuloPrecioPromedio, T000C7_A222ArticuloPrecioPromedio[0]) != 0 )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloPrecioPromedio");
               GXutil.writeLogRaw("Old: ",Z222ArticuloPrecioPromedio);
               GXutil.writeLogRaw("Current: ",T000C7_A222ArticuloPrecioPromedio[0]);
            }
            if ( Z79ArticuloStock != T000C7_A79ArticuloStock[0] )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloStock");
               GXutil.writeLogRaw("Old: ",Z79ArticuloStock);
               GXutil.writeLogRaw("Current: ",T000C7_A79ArticuloStock[0]);
            }
            if ( Z234ArticuloSerial != T000C7_A234ArticuloSerial[0] )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloSerial");
               GXutil.writeLogRaw("Old: ",Z234ArticuloSerial);
               GXutil.writeLogRaw("Current: ",T000C7_A234ArticuloSerial[0]);
            }
            if ( Z17TipoArticuloId != T000C7_A17TipoArticuloId[0] )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"TipoArticuloId");
               GXutil.writeLogRaw("Old: ",Z17TipoArticuloId);
               GXutil.writeLogRaw("Current: ",T000C7_A17TipoArticuloId[0]);
            }
            if ( Z18ImpuestoId != T000C7_A18ImpuestoId[0] )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ImpuestoId");
               GXutil.writeLogRaw("Old: ",Z18ImpuestoId);
               GXutil.writeLogRaw("Current: ",T000C7_A18ImpuestoId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Articulo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0C14( )
   {
      if ( ! IsAuthorized("articulo_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C14( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C14( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0C14( 0) ;
         checkOptimisticConcurrency0C14( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0C14( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0C14( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C17 */
                  pr_default.execute(15, new Object[] {Long.valueOf(A13ArticuloId), A76ArticuloNombre, A214ArticuloDescripcionCorta, A215ArticuloDescripcionLarga, A77ArticuloPrecioCompra, A78ArticuloPrecioVenta, A222ArticuloPrecioPromedio, Long.valueOf(A79ArticuloStock), A231ArticuloImagen, A40000ArticuloImagen_GXI, Long.valueOf(A234ArticuloSerial), Long.valueOf(A17TipoArticuloId), Long.valueOf(A18ImpuestoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
                  if ( (pr_default.getStatus(15) == 1) )
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
                        processLevel0C14( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0C0( ) ;
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
            load0C14( ) ;
         }
         endLevel0C14( ) ;
      }
      closeExtendedTableCursors0C14( ) ;
   }

   public void update0C14( )
   {
      if ( ! IsAuthorized("articulo_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C14( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C14( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0C14( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0C14( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0C14( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C18 */
                  pr_default.execute(16, new Object[] {A76ArticuloNombre, A214ArticuloDescripcionCorta, A215ArticuloDescripcionLarga, A77ArticuloPrecioCompra, A78ArticuloPrecioVenta, A222ArticuloPrecioPromedio, Long.valueOf(A79ArticuloStock), Long.valueOf(A234ArticuloSerial), Long.valueOf(A17TipoArticuloId), Long.valueOf(A18ImpuestoId), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
                  if ( (pr_default.getStatus(16) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Articulo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0C14( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0C14( ) ;
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
         endLevel0C14( ) ;
      }
      closeExtendedTableCursors0C14( ) ;
   }

   public void deferredUpdate0C14( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000C19 */
         pr_default.execute(17, new Object[] {A231ArticuloImagen, A40000ArticuloImagen_GXI, Long.valueOf(A13ArticuloId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
      }
   }

   public void delete( )
   {
      if ( ! IsAuthorized("articulo_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C14( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0C14( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0C14( ) ;
         afterConfirm0C14( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0C14( ) ;
            if ( AnyError == 0 )
            {
               scanStart0C57( ) ;
               while ( RcdFound57 != 0 )
               {
                  getByPrimaryKey0C57( ) ;
                  delete0C57( ) ;
                  scanNext0C57( ) ;
               }
               scanEnd0C57( ) ;
               A234ArticuloSerial = O234ArticuloSerial ;
               httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
               scanStart0C15( ) ;
               while ( RcdFound15 != 0 )
               {
                  getByPrimaryKey0C15( ) ;
                  delete0C15( ) ;
                  scanNext0C15( ) ;
                  O234ArticuloSerial = A234ArticuloSerial ;
                  httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
               }
               scanEnd0C15( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C20 */
                  pr_default.execute(18, new Object[] {Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
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
      sMode14 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0C14( ) ;
      Gx_mode = sMode14 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0C14( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000C21 */
         pr_default.execute(19, new Object[] {Long.valueOf(A17TipoArticuloId)});
         A103TipoArticuloNombre = T000C21_A103TipoArticuloNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
         pr_default.close(19);
         /* Using cursor T000C22 */
         pr_default.execute(20, new Object[] {Long.valueOf(A18ImpuestoId)});
         A83ImpuestoPorcentaje = T000C22_A83ImpuestoPorcentaje[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
         pr_default.close(20);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000C23 */
         pr_default.execute(21, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T000C24 */
         pr_default.execute(22, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T000C25 */
         pr_default.execute(23, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T000C26 */
         pr_default.execute(24, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Stock", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T000C27 */
         pr_default.execute(25, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T000C28 */
         pr_default.execute(26, new Object[] {Long.valueOf(A13ArticuloId)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
      }
   }

   public void processNestedLevel0C57( )
   {
      nGXsfl_90_idx = 0 ;
      while ( nGXsfl_90_idx < nRC_GXsfl_90 )
      {
         readRow0C57( ) ;
         if ( ( nRcdExists_57 != 0 ) || ( nIsMod_57 != 0 ) )
         {
            standaloneNotModal0C57( ) ;
            getKey0C57( ) ;
            if ( ( nRcdExists_57 == 0 ) && ( nRcdDeleted_57 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0C57( ) ;
            }
            else
            {
               if ( RcdFound57 != 0 )
               {
                  if ( ( nRcdDeleted_57 != 0 ) && ( nRcdExists_57 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0C57( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_57 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0C57( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_57 == 0 )
                  {
                     GXCCtl = "ARTICULOTALLAID_" + sGXsfl_90_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtArticuloTallaID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtArticuloTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A285ArticuloTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtTallaNombre_Internalname, GXutil.rtrim( A287TallaNombre)) ;
         httpContext.changePostValue( edtTallaNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A288TallaNumero, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloTallaStock_Internalname, GXutil.ltrim( localUtil.ntoc( A290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z285ArticuloTallaID_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( Z285ArticuloTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z290ArticuloTallaStock_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( Z290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z286TallaID_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( Z286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_57_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_57_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_57_"+sGXsfl_90_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_57 != 0 )
         {
            httpContext.changePostValue( "ARTICULOTALLAID_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TALLAID_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TALLANOMBRE_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TALLANUMERO_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNumero_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOTALLASTOCK_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaStock_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0C57( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_57 = (short)(0) ;
      nIsMod_57 = (short)(0) ;
      nRcdDeleted_57 = (short)(0) ;
   }

   public void processNestedLevel0C15( )
   {
      s234ArticuloSerial = O234ArticuloSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      nGXsfl_106_idx = 0 ;
      while ( nGXsfl_106_idx < nRC_GXsfl_106 )
      {
         readRow0C15( ) ;
         if ( ( nRcdExists_15 != 0 ) || ( nIsMod_15 != 0 ) )
         {
            standaloneNotModal0C15( ) ;
            getKey0C15( ) ;
            if ( ( nRcdExists_15 == 0 ) && ( nRcdDeleted_15 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0C15( ) ;
            }
            else
            {
               if ( RcdFound15 != 0 )
               {
                  if ( ( nRcdDeleted_15 != 0 ) && ( nRcdExists_15 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0C15( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_15 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0C15( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_15 == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ARTICULOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtArticuloId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
            O234ArticuloSerial = A234ArticuloSerial ;
            httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
         }
         httpContext.changePostValue( edtArticuloGaleriaId_Internalname, GXutil.ltrim( localUtil.ntoc( A48ArticuloGaleriaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloGaleriaImagen_Internalname, A230ArticuloGaleriaImagen) ;
         httpContext.changePostValue( "ZT_"+"Z48ArticuloGaleriaId_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( Z48ArticuloGaleriaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_15_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_15_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_15_"+sGXsfl_106_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_15 != 0 )
         {
            httpContext.changePostValue( "ARTICULOGALERIAID_"+sGXsfl_106_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaImagen_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0C15( ) ;
      if ( AnyError != 0 )
      {
         O234ArticuloSerial = s234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      nRcdExists_15 = (short)(0) ;
      nIsMod_15 = (short)(0) ;
      nRcdDeleted_15 = (short)(0) ;
   }

   public void processLevel0C14( )
   {
      /* Save parent mode. */
      sMode14 = Gx_mode ;
      processNestedLevel0C57( ) ;
      processNestedLevel0C15( ) ;
      if ( AnyError != 0 )
      {
         O234ArticuloSerial = s234ArticuloSerial ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      /* Restore parent mode. */
      Gx_mode = sMode14 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
      /* Using cursor T000C29 */
      pr_default.execute(27, new Object[] {Long.valueOf(A234ArticuloSerial), Long.valueOf(A13ArticuloId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Articulo");
   }

   public void endLevel0C14( )
   {
      pr_default.close(5);
      if ( AnyError == 0 )
      {
         beforeComplete0C14( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(19);
         pr_default.close(20);
         pr_default.close(4);
         Application.commitDataStores(context, remoteHandle, pr_default, "articulo");
         if ( AnyError == 0 )
         {
            confirmValues0C0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(19);
         pr_default.close(20);
         pr_default.close(4);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "articulo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0C14( )
   {
      /* Scan By routine */
      /* Using cursor T000C30 */
      pr_default.execute(28);
      RcdFound14 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A13ArticuloId = T000C30_A13ArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0C14( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound14 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A13ArticuloId = T000C30_A13ArticuloId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      }
   }

   public void scanEnd0C14( )
   {
      pr_default.close(28);
   }

   public void afterConfirm0C14( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0C14( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0C14( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0C14( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0C14( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0C14( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0C14( )
   {
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), true);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), true);
      edtArticuloDescripcionCorta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloDescripcionCorta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloDescripcionCorta_Enabled), 5, 0), true);
      edtArticuloDescripcionLarga_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloDescripcionLarga_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloDescripcionLarga_Enabled), 5, 0), true);
      edtArticuloPrecioCompra_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioCompra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioCompra_Enabled), 5, 0), true);
      edtArticuloPrecioVenta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), true);
      edtArticuloPrecioPromedio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioPromedio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioPromedio_Enabled), 5, 0), true);
      edtArticuloStock_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloStock_Enabled), 5, 0), true);
      edtTipoArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoArticuloId_Enabled), 5, 0), true);
      edtTipoArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoArticuloNombre_Enabled), 5, 0), true);
      edtImpuestoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpuestoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoId_Enabled), 5, 0), true);
      edtImpuestoPorcentaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), true);
      imgArticuloImagen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgArticuloImagen_Enabled), 5, 0), true);
   }

   public void zm0C57( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z290ArticuloTallaStock = T000C5_A290ArticuloTallaStock[0] ;
            Z286TallaID = T000C5_A286TallaID[0] ;
         }
         else
         {
            Z290ArticuloTallaStock = A290ArticuloTallaStock ;
            Z286TallaID = A286TallaID ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z13ArticuloId = A13ArticuloId ;
         Z285ArticuloTallaID = A285ArticuloTallaID ;
         Z290ArticuloTallaStock = A290ArticuloTallaStock ;
         Z286TallaID = A286TallaID ;
         Z287TallaNombre = A287TallaNombre ;
         Z288TallaNumero = A288TallaNumero ;
      }
   }

   public void standaloneNotModal0C57( )
   {
   }

   public void standaloneModal0C57( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtArticuloTallaID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
      }
      else
      {
         edtArticuloTallaID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
      }
   }

   public void load0C57( )
   {
      /* Using cursor T000C31 */
      pr_default.execute(29, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound57 = (short)(1) ;
         A287TallaNombre = T000C31_A287TallaNombre[0] ;
         A288TallaNumero = T000C31_A288TallaNumero[0] ;
         A290ArticuloTallaStock = T000C31_A290ArticuloTallaStock[0] ;
         A286TallaID = T000C31_A286TallaID[0] ;
         zm0C57( -18) ;
      }
      pr_default.close(29);
      onLoadActions0C57( ) ;
   }

   public void onLoadActions0C57( )
   {
   }

   public void checkExtendedTable0C57( )
   {
      nIsDirty_57 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0C57( ) ;
      /* Using cursor T000C6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A286TallaID)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         GXCCtl = "TALLAID_" + sGXsfl_90_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Talla", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtTallaID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A287TallaNombre = T000C6_A287TallaNombre[0] ;
      A288TallaNumero = T000C6_A288TallaNumero[0] ;
      pr_default.close(4);
   }

   public void closeExtendedTableCursors0C57( )
   {
      pr_default.close(4);
   }

   public void enableDisable0C57( )
   {
   }

   public void gxload_19( long A286TallaID )
   {
      /* Using cursor T000C32 */
      pr_default.execute(30, new Object[] {Long.valueOf(A286TallaID)});
      if ( (pr_default.getStatus(30) == 101) )
      {
         GXCCtl = "TALLAID_" + sGXsfl_90_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Talla", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtTallaID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A287TallaNombre = T000C32_A287TallaNombre[0] ;
      A288TallaNumero = T000C32_A288TallaNumero[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A287TallaNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A288TallaNumero, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(30) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(30);
   }

   public void getKey0C57( )
   {
      /* Using cursor T000C33 */
      pr_default.execute(31, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
      if ( (pr_default.getStatus(31) != 101) )
      {
         RcdFound57 = (short)(1) ;
      }
      else
      {
         RcdFound57 = (short)(0) ;
      }
      pr_default.close(31);
   }

   public void getByPrimaryKey0C57( )
   {
      /* Using cursor T000C5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm0C57( 18) ;
         RcdFound57 = (short)(1) ;
         initializeNonKey0C57( ) ;
         A285ArticuloTallaID = T000C5_A285ArticuloTallaID[0] ;
         A290ArticuloTallaStock = T000C5_A290ArticuloTallaStock[0] ;
         A286TallaID = T000C5_A286TallaID[0] ;
         Z13ArticuloId = A13ArticuloId ;
         Z285ArticuloTallaID = A285ArticuloTallaID ;
         sMode57 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0C57( ) ;
         Gx_mode = sMode57 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound57 = (short)(0) ;
         initializeNonKey0C57( ) ;
         sMode57 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0C57( ) ;
         Gx_mode = sMode57 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0C57( ) ;
      }
      pr_default.close(3);
   }

   public void checkOptimisticConcurrency0C57( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000C4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ArticuloTalla"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( Z290ArticuloTallaStock != T000C4_A290ArticuloTallaStock[0] ) || ( Z286TallaID != T000C4_A286TallaID[0] ) )
         {
            if ( Z290ArticuloTallaStock != T000C4_A290ArticuloTallaStock[0] )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"ArticuloTallaStock");
               GXutil.writeLogRaw("Old: ",Z290ArticuloTallaStock);
               GXutil.writeLogRaw("Current: ",T000C4_A290ArticuloTallaStock[0]);
            }
            if ( Z286TallaID != T000C4_A286TallaID[0] )
            {
               GXutil.writeLogln("articulo:[seudo value changed for attri]"+"TallaID");
               GXutil.writeLogRaw("Old: ",Z286TallaID);
               GXutil.writeLogRaw("Current: ",T000C4_A286TallaID[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ArticuloTalla"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0C57( )
   {
      if ( ! IsAuthorized("articulo_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C57( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C57( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0C57( 0) ;
         checkOptimisticConcurrency0C57( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0C57( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0C57( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C34 */
                  pr_default.execute(32, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID), Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A286TallaID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
                  if ( (pr_default.getStatus(32) == 1) )
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
            load0C57( ) ;
         }
         endLevel0C57( ) ;
      }
      closeExtendedTableCursors0C57( ) ;
   }

   public void update0C57( )
   {
      if ( ! IsAuthorized("articulo_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C57( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C57( ) ;
      }
      if ( ( nIsMod_57 != 0 ) || ( nIsDirty_57 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0C57( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0C57( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0C57( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000C35 */
                     pr_default.execute(33, new Object[] {Long.valueOf(A290ArticuloTallaStock), Long.valueOf(A286TallaID), Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
                     if ( (pr_default.getStatus(33) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ArticuloTalla"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0C57( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0C57( ) ;
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
            endLevel0C57( ) ;
         }
      }
      closeExtendedTableCursors0C57( ) ;
   }

   public void deferredUpdate0C57( )
   {
   }

   public void delete0C57( )
   {
      if ( ! IsAuthorized("articulo_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0C57( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0C57( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0C57( ) ;
         afterConfirm0C57( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0C57( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000C36 */
               pr_default.execute(34, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A285ArticuloTallaID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloTalla");
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
      sMode57 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0C57( ) ;
      Gx_mode = sMode57 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0C57( )
   {
      standaloneModal0C57( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000C37 */
         pr_default.execute(35, new Object[] {Long.valueOf(A286TallaID)});
         A287TallaNombre = T000C37_A287TallaNombre[0] ;
         A288TallaNumero = T000C37_A288TallaNumero[0] ;
         pr_default.close(35);
      }
   }

   public void endLevel0C57( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0C57( )
   {
      /* Scan By routine */
      /* Using cursor T000C38 */
      pr_default.execute(36, new Object[] {Long.valueOf(A13ArticuloId)});
      RcdFound57 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound57 = (short)(1) ;
         A285ArticuloTallaID = T000C38_A285ArticuloTallaID[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0C57( )
   {
      /* Scan next routine */
      pr_default.readNext(36);
      RcdFound57 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound57 = (short)(1) ;
         A285ArticuloTallaID = T000C38_A285ArticuloTallaID[0] ;
      }
   }

   public void scanEnd0C57( )
   {
      pr_default.close(36);
   }

   public void afterConfirm0C57( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0C57( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0C57( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0C57( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0C57( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0C57( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0C57( )
   {
      edtArticuloTallaID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
      edtTallaID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
      edtTallaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTallaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTallaNombre_Enabled), 5, 0), !bGXsfl_90_Refreshing);
      edtTallaNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTallaNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTallaNumero_Enabled), 5, 0), !bGXsfl_90_Refreshing);
      edtArticuloTallaStock_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaStock_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaStock_Enabled), 5, 0), !bGXsfl_90_Refreshing);
   }

   public void send_integrity_lvl_hashes0C57( )
   {
   }

   public void zm0C15( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -20 )
      {
         Z13ArticuloId = A13ArticuloId ;
         Z48ArticuloGaleriaId = A48ArticuloGaleriaId ;
         Z230ArticuloGaleriaImagen = A230ArticuloGaleriaImagen ;
         Z40001ArticuloGaleriaImagen_GXI = A40001ArticuloGaleriaImagen_GXI ;
      }
   }

   public void standaloneNotModal0C15( )
   {
      edtArticuloGaleriaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloGaleriaId_Enabled), 5, 0), !bGXsfl_106_Refreshing);
   }

   public void standaloneModal0C15( )
   {
      if ( isIns( )  )
      {
         A234ArticuloSerial = (long)(O234ArticuloSerial+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      }
      if ( isIns( )  && ( Gx_BScreen == 1 ) )
      {
         A48ArticuloGaleriaId = A234ArticuloSerial ;
      }
   }

   public void load0C15( )
   {
      /* Using cursor T000C39 */
      pr_default.execute(37, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId)});
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A230ArticuloGaleriaImagen = T000C39_A230ArticuloGaleriaImagen[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A230ArticuloGaleriaImagen))), !bGXsfl_106_Refreshing);
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A230ArticuloGaleriaImagen), true);
         A40001ArticuloGaleriaImagen_GXI = T000C39_A40001ArticuloGaleriaImagen_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A230ArticuloGaleriaImagen))), !bGXsfl_106_Refreshing);
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A230ArticuloGaleriaImagen), true);
         zm0C15( -20) ;
      }
      pr_default.close(37);
      onLoadActions0C15( ) ;
   }

   public void onLoadActions0C15( )
   {
   }

   public void checkExtendedTable0C15( )
   {
      nIsDirty_15 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0C15( ) ;
   }

   public void closeExtendedTableCursors0C15( )
   {
   }

   public void enableDisable0C15( )
   {
   }

   public void getKey0C15( )
   {
      /* Using cursor T000C40 */
      pr_default.execute(38, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId)});
      if ( (pr_default.getStatus(38) != 101) )
      {
         RcdFound15 = (short)(1) ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
      }
      pr_default.close(38);
   }

   public void getByPrimaryKey0C15( )
   {
      /* Using cursor T000C3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0C15( 20) ;
         RcdFound15 = (short)(1) ;
         initializeNonKey0C15( ) ;
         A48ArticuloGaleriaId = T000C3_A48ArticuloGaleriaId[0] ;
         A230ArticuloGaleriaImagen = T000C3_A230ArticuloGaleriaImagen[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A230ArticuloGaleriaImagen))), !bGXsfl_106_Refreshing);
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A230ArticuloGaleriaImagen), true);
         A40001ArticuloGaleriaImagen_GXI = T000C3_A40001ArticuloGaleriaImagen_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A230ArticuloGaleriaImagen))), !bGXsfl_106_Refreshing);
         httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A230ArticuloGaleriaImagen), true);
         Z13ArticuloId = A13ArticuloId ;
         Z48ArticuloGaleriaId = A48ArticuloGaleriaId ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0C15( ) ;
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound15 = (short)(0) ;
         initializeNonKey0C15( ) ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0C15( ) ;
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0C15( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0C15( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000C2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ArticuloGaleria"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ArticuloGaleria"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0C15( )
   {
      if ( ! IsAuthorized("articulo_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C15( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C15( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0C15( 0) ;
         checkOptimisticConcurrency0C15( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0C15( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0C15( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C41 */
                  pr_default.execute(39, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId), A230ArticuloGaleriaImagen, A40001ArticuloGaleriaImagen_GXI});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloGaleria");
                  if ( (pr_default.getStatus(39) == 1) )
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
            load0C15( ) ;
         }
         endLevel0C15( ) ;
      }
      closeExtendedTableCursors0C15( ) ;
   }

   public void update0C15( )
   {
      if ( ! IsAuthorized("articulo_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0C15( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C15( ) ;
      }
      if ( ( nIsMod_15 != 0 ) || ( nIsDirty_15 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0C15( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0C15( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0C15( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table [ArticuloGaleria] */
                     deferredUpdate0C15( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0C15( ) ;
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
            endLevel0C15( ) ;
         }
      }
      closeExtendedTableCursors0C15( ) ;
   }

   public void deferredUpdate0C15( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000C42 */
         pr_default.execute(40, new Object[] {A230ArticuloGaleriaImagen, A40001ArticuloGaleriaImagen_GXI, Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloGaleria");
      }
   }

   public void delete0C15( )
   {
      if ( ! IsAuthorized("articulo_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0C15( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0C15( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0C15( ) ;
         afterConfirm0C15( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0C15( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000C43 */
               pr_default.execute(41, new Object[] {Long.valueOf(A13ArticuloId), Long.valueOf(A48ArticuloGaleriaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ArticuloGaleria");
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
      sMode15 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0C15( ) ;
      Gx_mode = sMode15 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0C15( )
   {
      standaloneModal0C15( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0C15( )
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

   public void scanStart0C15( )
   {
      /* Scan By routine */
      /* Using cursor T000C44 */
      pr_default.execute(42, new Object[] {Long.valueOf(A13ArticuloId)});
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(42) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A48ArticuloGaleriaId = T000C44_A48ArticuloGaleriaId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0C15( )
   {
      /* Scan next routine */
      pr_default.readNext(42);
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(42) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A48ArticuloGaleriaId = T000C44_A48ArticuloGaleriaId[0] ;
      }
   }

   public void scanEnd0C15( )
   {
      pr_default.close(42);
   }

   public void afterConfirm0C15( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0C15( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0C15( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0C15( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0C15( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0C15( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0C15( )
   {
      edtArticuloGaleriaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloGaleriaId_Enabled), 5, 0), !bGXsfl_106_Refreshing);
      edtArticuloGaleriaImagen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloGaleriaImagen_Enabled), 5, 0), !bGXsfl_106_Refreshing);
   }

   public void send_integrity_lvl_hashes0C15( )
   {
   }

   public void send_integrity_lvl_hashes0C14( )
   {
   }

   public void subsflControlProps_9057( )
   {
      edtArticuloTallaID_Internalname = "ARTICULOTALLAID_"+sGXsfl_90_idx ;
      edtTallaID_Internalname = "TALLAID_"+sGXsfl_90_idx ;
      imgprompt_286_Internalname = "PROMPT_286_"+sGXsfl_90_idx ;
      edtTallaNombre_Internalname = "TALLANOMBRE_"+sGXsfl_90_idx ;
      edtTallaNumero_Internalname = "TALLANUMERO_"+sGXsfl_90_idx ;
      edtArticuloTallaStock_Internalname = "ARTICULOTALLASTOCK_"+sGXsfl_90_idx ;
   }

   public void subsflControlProps_fel_9057( )
   {
      edtArticuloTallaID_Internalname = "ARTICULOTALLAID_"+sGXsfl_90_fel_idx ;
      edtTallaID_Internalname = "TALLAID_"+sGXsfl_90_fel_idx ;
      imgprompt_286_Internalname = "PROMPT_286_"+sGXsfl_90_fel_idx ;
      edtTallaNombre_Internalname = "TALLANOMBRE_"+sGXsfl_90_fel_idx ;
      edtTallaNumero_Internalname = "TALLANUMERO_"+sGXsfl_90_fel_idx ;
      edtArticuloTallaStock_Internalname = "ARTICULOTALLASTOCK_"+sGXsfl_90_fel_idx ;
   }

   public void addRow0C57( )
   {
      nGXsfl_90_idx = (int)(nGXsfl_90_idx+1) ;
      sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_9057( ) ;
      sendRow0C57( ) ;
   }

   public void sendRow0C57( )
   {
      Gridlevel_tallaRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_talla_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_talla_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_talla_Class, "") != 0 )
         {
            subGridlevel_talla_Linesclass = subGridlevel_talla_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_talla_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_talla_Backstyle = (byte)(0) ;
         subGridlevel_talla_Backcolor = subGridlevel_talla_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_talla_Class, "") != 0 )
         {
            subGridlevel_talla_Linesclass = subGridlevel_talla_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_talla_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_talla_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_talla_Class, "") != 0 )
         {
            subGridlevel_talla_Linesclass = subGridlevel_talla_Class+"Odd" ;
         }
         subGridlevel_talla_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_talla_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_talla_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_90_idx) % (2))) == 0 )
         {
            subGridlevel_talla_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_talla_Class, "") != 0 )
            {
               subGridlevel_talla_Linesclass = subGridlevel_talla_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_talla_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_talla_Class, "") != 0 )
            {
               subGridlevel_talla_Linesclass = subGridlevel_talla_Class+"Odd" ;
            }
         }
      }
      imgprompt_286_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.tallaprompt"+"',["+"{Ctrl:gx.dom.el('"+"TALLAID_"+sGXsfl_90_idx+"'), id:'"+"TALLAID_"+sGXsfl_90_idx+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"TALLANOMBRE_"+sGXsfl_90_idx+"'), id:'"+"TALLANOMBRE_"+sGXsfl_90_idx+"'"+",IOType:'inout'}"+"],"+"gx.dom.form()."+"nIsMod_57_"+sGXsfl_90_idx+","+"'', false"+","+"false"+");") ;
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_57_" + sGXsfl_90_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 91,'',false,'" + sGXsfl_90_idx + "',90)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_tallaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloTallaID_Internalname,GXutil.ltrim( localUtil.ntoc( A285ArticuloTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A285ArticuloTallaID), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,91);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloTallaID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloTallaID_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(90),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_57_" + sGXsfl_90_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 92,'',false,'" + sGXsfl_90_idx + "',90)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_tallaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTallaID_Internalname,GXutil.ltrim( localUtil.ntoc( A286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtTallaID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A286TallaID), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A286TallaID), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,92);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTallaID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtTallaID_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(90),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_286_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_286_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      Gridlevel_tallaRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgprompt_286_Internalname,sImgUrl,imgprompt_286_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(imgprompt_286_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_tallaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTallaNombre_Internalname,GXutil.rtrim( A287TallaNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTallaNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtTallaNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(90),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_tallaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTallaNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A288TallaNumero, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtTallaNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A288TallaNumero), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A288TallaNumero), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTallaNumero_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtTallaNumero_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(90),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_57_" + sGXsfl_90_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 95,'',false,'" + sGXsfl_90_idx + "',90)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_tallaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloTallaStock_Internalname,GXutil.ltrim( localUtil.ntoc( A290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloTallaStock_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A290ArticuloTallaStock), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A290ArticuloTallaStock), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,95);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloTallaStock_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloTallaStock_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(90),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Stock","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_tallaRow);
      send_integrity_lvl_hashes0C57( ) ;
      GXCCtl = "Z285ArticuloTallaID_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z285ArticuloTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z290ArticuloTallaStock_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z286TallaID_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_57_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_57_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_57_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_57, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_90_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV11TrnContext);
      }
      GXCCtl = "vARTICULOID_" + sGXsfl_90_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOTALLAID_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TALLAID_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TALLANOMBRE_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TALLANUMERO_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNumero_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOTALLASTOCK_"+sGXsfl_90_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaStock_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PROMPT_286_"+sGXsfl_90_idx+"Link", GXutil.rtrim( imgprompt_286_Link));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_tallaContainer.AddRow(Gridlevel_tallaRow);
   }

   public void readRow0C57( )
   {
      nGXsfl_90_idx = (int)(nGXsfl_90_idx+1) ;
      sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_9057( ) ;
      edtArticuloTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOTALLAID_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TALLAID_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtTallaNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TALLANOMBRE_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtTallaNumero_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TALLANUMERO_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloTallaStock_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOTALLASTOCK_"+sGXsfl_90_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      imgprompt_17_Link = httpContext.cgiGet( "PROMPT_286_"+sGXsfl_90_idx+"Link") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "ARTICULOTALLAID_" + sGXsfl_90_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloTallaID_Internalname ;
         wbErr = true ;
         A285ArticuloTallaID = 0 ;
      }
      else
      {
         A285ArticuloTallaID = localUtil.ctol( httpContext.cgiGet( edtArticuloTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "TALLAID_" + sGXsfl_90_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtTallaID_Internalname ;
         wbErr = true ;
         A286TallaID = 0 ;
      }
      else
      {
         A286TallaID = localUtil.ctol( httpContext.cgiGet( edtTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      A287TallaNombre = httpContext.cgiGet( edtTallaNombre_Internalname) ;
      A288TallaNumero = (short)(localUtil.ctol( httpContext.cgiGet( edtTallaNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloTallaStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloTallaStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "ARTICULOTALLASTOCK_" + sGXsfl_90_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloTallaStock_Internalname ;
         wbErr = true ;
         A290ArticuloTallaStock = 0 ;
      }
      else
      {
         A290ArticuloTallaStock = localUtil.ctol( httpContext.cgiGet( edtArticuloTallaStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      GXCCtl = "Z285ArticuloTallaID_" + sGXsfl_90_idx ;
      Z285ArticuloTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z290ArticuloTallaStock_" + sGXsfl_90_idx ;
      Z290ArticuloTallaStock = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z286TallaID_" + sGXsfl_90_idx ;
      Z286TallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "nRcdDeleted_57_" + sGXsfl_90_idx ;
      nRcdDeleted_57 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_57_" + sGXsfl_90_idx ;
      nRcdExists_57 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_57_" + sGXsfl_90_idx ;
      nIsMod_57 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_10615( )
   {
      edtArticuloGaleriaId_Internalname = "ARTICULOGALERIAID_"+sGXsfl_106_idx ;
      edtArticuloGaleriaImagen_Internalname = "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_idx ;
   }

   public void subsflControlProps_fel_10615( )
   {
      edtArticuloGaleriaId_Internalname = "ARTICULOGALERIAID_"+sGXsfl_106_fel_idx ;
      edtArticuloGaleriaImagen_Internalname = "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_fel_idx ;
   }

   public void addRow0C15( )
   {
      nGXsfl_106_idx = (int)(nGXsfl_106_idx+1) ;
      sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_10615( ) ;
      sendRow0C15( ) ;
   }

   public void sendRow0C15( )
   {
      Gridlevel_galeriaRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_galeria_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_galeria_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_galeria_Class, "") != 0 )
         {
            subGridlevel_galeria_Linesclass = subGridlevel_galeria_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_galeria_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_galeria_Backstyle = (byte)(0) ;
         subGridlevel_galeria_Backcolor = subGridlevel_galeria_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_galeria_Class, "") != 0 )
         {
            subGridlevel_galeria_Linesclass = subGridlevel_galeria_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_galeria_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_galeria_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_galeria_Class, "") != 0 )
         {
            subGridlevel_galeria_Linesclass = subGridlevel_galeria_Class+"Odd" ;
         }
         subGridlevel_galeria_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_galeria_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_galeria_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_106_idx) % (2))) == 0 )
         {
            subGridlevel_galeria_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_galeria_Class, "") != 0 )
            {
               subGridlevel_galeria_Linesclass = subGridlevel_galeria_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_galeria_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_galeria_Class, "") != 0 )
            {
               subGridlevel_galeria_Linesclass = subGridlevel_galeria_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_galeriaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloGaleriaId_Internalname,GXutil.ltrim( localUtil.ntoc( A48ArticuloGaleriaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloGaleriaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A48ArticuloGaleriaId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A48ArticuloGaleriaId), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloGaleriaId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloGaleriaId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(106),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static Bitmap Variable */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_15_" + sGXsfl_106_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 108,'',false,'" + sGXsfl_106_idx + "',106)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      A230ArticuloGaleriaImagen_IsBlob = (boolean)(((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0)&&(GXutil.strcmp("", A40001ArticuloGaleriaImagen_GXI)==0))||!(GXutil.strcmp("", A230ArticuloGaleriaImagen)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.getResourceRelative(A230ArticuloGaleriaImagen)) ;
      Gridlevel_galeriaRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtArticuloGaleriaImagen_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(edtArticuloGaleriaImagen_Enabled),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"TrnColumn","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,108);\"","","","",Integer.valueOf(0),Boolean.valueOf(A230ArticuloGaleriaImagen_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "URL", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.getResourceRelative(A230ArticuloGaleriaImagen)), !bGXsfl_106_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "IsBlob", GXutil.booltostr( A230ArticuloGaleriaImagen_IsBlob), !bGXsfl_106_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_galeriaRow);
      send_integrity_lvl_hashes0C15( ) ;
      GXCCtl = "Z48ArticuloGaleriaId_" + sGXsfl_106_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z48ArticuloGaleriaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_15_" + sGXsfl_106_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_15_" + sGXsfl_106_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_15_" + sGXsfl_106_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_15, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_106_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_106_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV11TrnContext);
      }
      GXCCtl = "vARTICULOID_" + sGXsfl_106_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "ARTICULOGALERIAIMAGEN_" + sGXsfl_106_idx ;
      GXCCtlgxBlob = GXCCtl + "_gxBlob" ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A230ArticuloGaleriaImagen);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOGALERIAID_"+sGXsfl_106_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaImagen_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_galeriaContainer.AddRow(Gridlevel_galeriaRow);
   }

   public void readRow0C15( )
   {
      nGXsfl_106_idx = (int)(nGXsfl_106_idx+1) ;
      sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_10615( ) ;
      edtArticuloGaleriaId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOGALERIAID_"+sGXsfl_106_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloGaleriaImagen_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOGALERIAIMAGEN_"+sGXsfl_106_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A48ArticuloGaleriaId = localUtil.ctol( httpContext.cgiGet( edtArticuloGaleriaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      A230ArticuloGaleriaImagen = httpContext.cgiGet( edtArticuloGaleriaImagen_Internalname) ;
      GXCCtl = "Z48ArticuloGaleriaId_" + sGXsfl_106_idx ;
      Z48ArticuloGaleriaId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "nRcdDeleted_15_" + sGXsfl_106_idx ;
      nRcdDeleted_15 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_15_" + sGXsfl_106_idx ;
      nRcdExists_15 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_15_" + sGXsfl_106_idx ;
      nIsMod_15 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXv_char2[0] = A230ArticuloGaleriaImagen ;
      GXv_char1[0] = A40001ArticuloGaleriaImagen_GXI ;
      httpContext.getMultimediaValue(edtArticuloGaleriaImagen_Internalname, GXv_char2, GXv_char1);
      articulo_impl.this.A230ArticuloGaleriaImagen = GXv_char2[0] ;
      articulo_impl.this.A40001ArticuloGaleriaImagen_GXI = GXv_char1[0] ;
   }

   public void assign_properties_default( )
   {
      defedtArticuloGaleriaId_Enabled = edtArticuloGaleriaId_Enabled ;
      defedtArticuloTallaID_Enabled = edtArticuloTallaID_Enabled ;
   }

   public void confirmValues0C0( )
   {
      nGXsfl_90_idx = 0 ;
      sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_9057( ) ;
      while ( nGXsfl_90_idx < nRC_GXsfl_90 )
      {
         nGXsfl_90_idx = (int)(nGXsfl_90_idx+1) ;
         sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_9057( ) ;
         httpContext.changePostValue( "Z285ArticuloTallaID_"+sGXsfl_90_idx, httpContext.cgiGet( "ZT_"+"Z285ArticuloTallaID_"+sGXsfl_90_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z285ArticuloTallaID_"+sGXsfl_90_idx) ;
         httpContext.changePostValue( "Z290ArticuloTallaStock_"+sGXsfl_90_idx, httpContext.cgiGet( "ZT_"+"Z290ArticuloTallaStock_"+sGXsfl_90_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z290ArticuloTallaStock_"+sGXsfl_90_idx) ;
         httpContext.changePostValue( "Z286TallaID_"+sGXsfl_90_idx, httpContext.cgiGet( "ZT_"+"Z286TallaID_"+sGXsfl_90_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z286TallaID_"+sGXsfl_90_idx) ;
      }
      nGXsfl_106_idx = 0 ;
      sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_10615( ) ;
      while ( nGXsfl_106_idx < nRC_GXsfl_106 )
      {
         nGXsfl_106_idx = (int)(nGXsfl_106_idx+1) ;
         sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_10615( ) ;
         httpContext.changePostValue( "Z48ArticuloGaleriaId_"+sGXsfl_106_idx, httpContext.cgiGet( "ZT_"+"Z48ArticuloGaleriaId_"+sGXsfl_106_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z48ArticuloGaleriaId_"+sGXsfl_106_idx) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.articulo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ArticuloId,11,0))}, new String[] {"Gx_mode","ArticuloId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Articulo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("articulo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z13ArticuloId", GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z76ArticuloNombre", GXutil.rtrim( Z76ArticuloNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z214ArticuloDescripcionCorta", Z214ArticuloDescripcionCorta);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z77ArticuloPrecioCompra", GXutil.ltrim( localUtil.ntoc( Z77ArticuloPrecioCompra, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z78ArticuloPrecioVenta", GXutil.ltrim( localUtil.ntoc( Z78ArticuloPrecioVenta, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z222ArticuloPrecioPromedio", GXutil.ltrim( localUtil.ntoc( Z222ArticuloPrecioPromedio, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z79ArticuloStock", GXutil.ltrim( localUtil.ntoc( Z79ArticuloStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z234ArticuloSerial", GXutil.ltrim( localUtil.ntoc( Z234ArticuloSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z17TipoArticuloId", GXutil.ltrim( localUtil.ntoc( Z17TipoArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z18ImpuestoId", GXutil.ltrim( localUtil.ntoc( Z18ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O234ArticuloSerial", GXutil.ltrim( localUtil.ntoc( O234ArticuloSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_90", GXutil.ltrim( localUtil.ntoc( nGXsfl_90_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_106", GXutil.ltrim( localUtil.ntoc( nGXsfl_106_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N17TipoArticuloId", GXutil.ltrim( localUtil.ntoc( A17TipoArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N18ImpuestoId", GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vARTICULOID", GXutil.ltrim( localUtil.ntoc( AV7ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ArticuloId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOARTICULOID", GXutil.ltrim( localUtil.ntoc( AV13Insert_TipoArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_IMPUESTOID", GXutil.ltrim( localUtil.ntoc( AV14Insert_ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOIMAGEN_GXI", A40000ArticuloImagen_GXI);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOSERIAL", GXutil.ltrim( localUtil.ntoc( A234ArticuloSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOGALERIAIMAGEN_GXI", A40001ArticuloGaleriaImagen_GXI);
      GXCCtlgxBlob = "ARTICULOIMAGEN" + "_gxBlob" ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A231ArticuloImagen);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Objectcall", GXutil.rtrim( Gxuitabspanel_tabs_Objectcall));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Enabled", GXutil.booltostr( Gxuitabspanel_tabs_Enabled));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
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
      return formatLink("com.mujermorena.articulo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ArticuloId,11,0))}, new String[] {"Gx_mode","ArticuloId"})  ;
   }

   public String getPgmname( )
   {
      return "Articulo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Articulo", "") ;
   }

   public void initializeNonKey0C14( )
   {
      A17TipoArticuloId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
      A18ImpuestoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
      A76ArticuloNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", A76ArticuloNombre);
      A214ArticuloDescripcionCorta = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A214ArticuloDescripcionCorta", A214ArticuloDescripcionCorta);
      A215ArticuloDescripcionLarga = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A215ArticuloDescripcionLarga", A215ArticuloDescripcionLarga);
      A77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
      A222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
      A79ArticuloStock = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
      A103TipoArticuloNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
      A231ArticuloImagen = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A231ArticuloImagen", A231ArticuloImagen);
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
      A40000ArticuloImagen_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
      A234ArticuloSerial = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      O234ArticuloSerial = A234ArticuloSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
      Z76ArticuloNombre = "" ;
      Z214ArticuloDescripcionCorta = "" ;
      Z77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      Z78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      Z222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      Z79ArticuloStock = 0 ;
      Z234ArticuloSerial = 0 ;
      Z17TipoArticuloId = 0 ;
      Z18ImpuestoId = 0 ;
   }

   public void initAll0C14( )
   {
      A13ArticuloId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      initializeNonKey0C14( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0C57( )
   {
      A286TallaID = 0 ;
      A287TallaNombre = "" ;
      A288TallaNumero = (short)(0) ;
      A290ArticuloTallaStock = 0 ;
      Z290ArticuloTallaStock = 0 ;
      Z286TallaID = 0 ;
   }

   public void initAll0C57( )
   {
      A285ArticuloTallaID = 0 ;
      initializeNonKey0C57( ) ;
   }

   public void standaloneModalInsert0C57( )
   {
   }

   public void initializeNonKey0C15( )
   {
      A230ArticuloGaleriaImagen = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A230ArticuloGaleriaImagen))), !bGXsfl_106_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A230ArticuloGaleriaImagen), true);
      A40001ArticuloGaleriaImagen_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A230ArticuloGaleriaImagen)==0) ? A40001ArticuloGaleriaImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A230ArticuloGaleriaImagen))), !bGXsfl_106_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A230ArticuloGaleriaImagen), true);
   }

   public void initAll0C15( )
   {
      A48ArticuloGaleriaId = 0 ;
      initializeNonKey0C15( ) ;
   }

   public void standaloneModalInsert0C15( )
   {
      A234ArticuloSerial = i234ArticuloSerial ;
      httpContext.ajax_rsp_assign_attri("", false, "A234ArticuloSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A234ArticuloSerial), 10, 0));
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211192355", true, true);
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
      httpContext.AddJavascriptSource("articulo.js", "?20241211192355", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties57( )
   {
      edtArticuloTallaID_Enabled = defedtArticuloTallaID_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloTallaID_Enabled), 5, 0), !bGXsfl_90_Refreshing);
   }

   public void init_level_properties15( )
   {
      edtArticuloGaleriaId_Enabled = defedtArticuloGaleriaId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloGaleriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloGaleriaId_Enabled), 5, 0), !bGXsfl_106_Refreshing);
   }

   public void startgridcontrol90( )
   {
      Gridlevel_tallaContainer.AddObjectProperty("GridName", "Gridlevel_talla");
      Gridlevel_tallaContainer.AddObjectProperty("Header", subGridlevel_talla_Header);
      Gridlevel_tallaContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_tallaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_tallaContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_tallaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tallaColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A285ArticuloTallaID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_tallaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddColumnProperties(Gridlevel_tallaColumn);
      Gridlevel_tallaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tallaColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A286TallaID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_tallaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddColumnProperties(Gridlevel_tallaColumn);
      Gridlevel_tallaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tallaContainer.AddColumnProperties(Gridlevel_tallaColumn);
      Gridlevel_tallaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tallaColumn.AddObjectProperty("Value", GXutil.rtrim( A287TallaNombre));
      Gridlevel_tallaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddColumnProperties(Gridlevel_tallaColumn);
      Gridlevel_tallaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tallaColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A288TallaNumero, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tallaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtTallaNumero_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddColumnProperties(Gridlevel_tallaColumn);
      Gridlevel_tallaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_tallaColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A290ArticuloTallaStock, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_tallaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloTallaStock_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddColumnProperties(Gridlevel_tallaColumn);
      Gridlevel_tallaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tallaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_talla_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol106( )
   {
      Gridlevel_galeriaContainer.AddObjectProperty("GridName", "Gridlevel_galeria");
      Gridlevel_galeriaContainer.AddObjectProperty("Header", subGridlevel_galeria_Header);
      Gridlevel_galeriaContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_galeriaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_galeriaContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_galeriaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_galeriaColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A48ArticuloGaleriaId, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_galeriaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddColumnProperties(Gridlevel_galeriaColumn);
      Gridlevel_galeriaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_galeriaColumn.AddObjectProperty("Value", httpContext.convertURL( A230ArticuloGaleriaImagen));
      Gridlevel_galeriaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloGaleriaImagen_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddColumnProperties(Gridlevel_galeriaColumn);
      Gridlevel_galeriaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_galeriaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_galeria_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      lblTabgeneral_title_Internalname = "TABGENERAL_TITLE" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtArticuloDescripcionCorta_Internalname = "ARTICULODESCRIPCIONCORTA" ;
      edtArticuloDescripcionLarga_Internalname = "ARTICULODESCRIPCIONLARGA" ;
      edtArticuloPrecioCompra_Internalname = "ARTICULOPRECIOCOMPRA" ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA" ;
      edtArticuloPrecioPromedio_Internalname = "ARTICULOPRECIOPROMEDIO" ;
      edtArticuloStock_Internalname = "ARTICULOSTOCK" ;
      edtTipoArticuloId_Internalname = "TIPOARTICULOID" ;
      edtTipoArticuloNombre_Internalname = "TIPOARTICULONOMBRE" ;
      edtImpuestoId_Internalname = "IMPUESTOID" ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE" ;
      imgArticuloImagen_Internalname = "ARTICULOIMAGEN" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      lblTablevel_talla_title_Internalname = "TABLEVEL_TALLA_TITLE" ;
      edtArticuloTallaID_Internalname = "ARTICULOTALLAID" ;
      edtTallaID_Internalname = "TALLAID" ;
      edtTallaNombre_Internalname = "TALLANOMBRE" ;
      edtTallaNumero_Internalname = "TALLANUMERO" ;
      edtArticuloTallaStock_Internalname = "ARTICULOTALLASTOCK" ;
      divTableleaflevel_talla_Internalname = "TABLELEAFLEVEL_TALLA" ;
      divTabtablelevel_talla_Internalname = "TABTABLELEVEL_TALLA" ;
      lblTablevel_galeria_title_Internalname = "TABLEVEL_GALERIA_TITLE" ;
      edtArticuloGaleriaId_Internalname = "ARTICULOGALERIAID" ;
      edtArticuloGaleriaImagen_Internalname = "ARTICULOGALERIAIMAGEN" ;
      divTableleaflevel_galeria_Internalname = "TABLELEAFLEVEL_GALERIA" ;
      divTabtablelevel_galeria_Internalname = "TABTABLELEVEL_GALERIA" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_17_Internalname = "PROMPT_17" ;
      imgprompt_18_Internalname = "PROMPT_18" ;
      imgprompt_286_Internalname = "PROMPT_286" ;
      subGridlevel_talla_Internalname = "GRIDLEVEL_TALLA" ;
      subGridlevel_galeria_Internalname = "GRIDLEVEL_GALERIA" ;
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
      subGridlevel_galeria_Allowcollapsing = (byte)(0) ;
      subGridlevel_galeria_Allowselection = (byte)(0) ;
      subGridlevel_galeria_Header = "" ;
      subGridlevel_talla_Allowcollapsing = (byte)(0) ;
      subGridlevel_talla_Allowselection = (byte)(0) ;
      subGridlevel_talla_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Articulo", "") );
      edtArticuloGaleriaId_Jsonclick = "" ;
      subGridlevel_galeria_Class = "WorkWith" ;
      subGridlevel_galeria_Backcolorstyle = (byte)(0) ;
      edtArticuloTallaStock_Jsonclick = "" ;
      edtTallaNumero_Jsonclick = "" ;
      edtTallaNombre_Jsonclick = "" ;
      imgprompt_286_Visible = 1 ;
      imgprompt_286_Link = "" ;
      imgprompt_17_Visible = 1 ;
      edtTallaID_Jsonclick = "" ;
      edtArticuloTallaID_Jsonclick = "" ;
      subGridlevel_talla_Class = "WorkWith" ;
      subGridlevel_talla_Backcolorstyle = (byte)(0) ;
      edtArticuloGaleriaImagen_Enabled = 1 ;
      edtArticuloGaleriaId_Enabled = 0 ;
      edtArticuloTallaStock_Enabled = 1 ;
      edtTallaNumero_Enabled = 0 ;
      edtTallaNombre_Enabled = 0 ;
      edtTallaID_Enabled = 1 ;
      edtArticuloTallaID_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      imgArticuloImagen_Enabled = 1 ;
      edtImpuestoPorcentaje_Jsonclick = "" ;
      edtImpuestoPorcentaje_Enabled = 0 ;
      imgprompt_18_Visible = 1 ;
      imgprompt_18_Link = "" ;
      edtImpuestoId_Jsonclick = "" ;
      edtImpuestoId_Enabled = 1 ;
      edtTipoArticuloNombre_Jsonclick = "" ;
      edtTipoArticuloNombre_Enabled = 0 ;
      imgprompt_17_Visible = 1 ;
      imgprompt_17_Link = "" ;
      edtTipoArticuloId_Jsonclick = "" ;
      edtTipoArticuloId_Enabled = 1 ;
      edtArticuloStock_Jsonclick = "" ;
      edtArticuloStock_Enabled = 1 ;
      edtArticuloPrecioPromedio_Jsonclick = "" ;
      edtArticuloPrecioPromedio_Enabled = 1 ;
      edtArticuloPrecioVenta_Jsonclick = "" ;
      edtArticuloPrecioVenta_Enabled = 1 ;
      edtArticuloPrecioCompra_Jsonclick = "" ;
      edtArticuloPrecioCompra_Enabled = 1 ;
      edtArticuloDescripcionLarga_Enabled = 1 ;
      edtArticuloDescripcionCorta_Enabled = 1 ;
      edtArticuloNombre_Jsonclick = "" ;
      edtArticuloNombre_Enabled = 1 ;
      edtArticuloId_Jsonclick = "" ;
      edtArticuloId_Enabled = 1 ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "VerticalTabs" ;
      Gxuitabspanel_tabs_Pagecount = 3 ;
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

   public void gx3asaarticuloid0C14( long AV7ArticuloId ,
                                     String AV16Pgmname )
   {
      if ( ! (0==AV7ArticuloId) )
      {
         A13ArticuloId = AV7ArticuloId ;
         httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int4 = A13ArticuloId ;
            GXv_int5[0] = GXt_int4 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int5) ;
            articulo_impl.this.GXt_int4 = GXv_int5[0] ;
            A13ArticuloId = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_talla_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_9057( ) ;
      while ( nGXsfl_90_idx <= nRC_GXsfl_90 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0C57( ) ;
         standaloneModal0C57( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0C57( ) ;
         nGXsfl_90_idx = (int)(nGXsfl_90_idx+1) ;
         sGXsfl_90_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_90_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_9057( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_tallaContainer)) ;
      /* End function gxnrGridlevel_talla_newrow */
   }

   public void gxnrgridlevel_galeria_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_10615( ) ;
      while ( nGXsfl_106_idx <= nRC_GXsfl_106 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0C15( ) ;
         standaloneModal0C15( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0C15( ) ;
         nGXsfl_106_idx = (int)(nGXsfl_106_idx+1) ;
         sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_10615( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_galeriaContainer)) ;
      /* End function gxnrGridlevel_galeria_newrow */
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

   public void valid_Tipoarticuloid( )
   {
      /* Using cursor T000C21 */
      pr_default.execute(19, new Object[] {Long.valueOf(A17TipoArticuloId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoArticuloId_Internalname ;
      }
      A103TipoArticuloNombre = T000C21_A103TipoArticuloNombre[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A103TipoArticuloNombre", GXutil.rtrim( A103TipoArticuloNombre));
   }

   public void valid_Impuestoid( )
   {
      /* Using cursor T000C22 */
      pr_default.execute(20, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtImpuestoId_Internalname ;
      }
      A83ImpuestoPorcentaje = T000C22_A83ImpuestoPorcentaje[0] ;
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")));
   }

   public void valid_Tallaid( )
   {
      /* Using cursor T000C37 */
      pr_default.execute(35, new Object[] {Long.valueOf(A286TallaID)});
      if ( (pr_default.getStatus(35) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Talla", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TALLAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTallaID_Internalname ;
      }
      A287TallaNombre = T000C37_A287TallaNombre[0] ;
      A288TallaNumero = T000C37_A288TallaNumero[0] ;
      pr_default.close(35);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A287TallaNombre", GXutil.rtrim( A287TallaNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A288TallaNumero", GXutil.ltrim( localUtil.ntoc( A288TallaNumero, (byte)(4), (byte)(0), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ArticuloId',fld:'vARTICULOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7ArticuloId',fld:'vARTICULOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120C2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[]}");
      setEventMetadata("VALID_TIPOARTICULOID","{handler:'valid_Tipoarticuloid',iparms:[{av:'A17TipoArticuloId',fld:'TIPOARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A103TipoArticuloNombre',fld:'TIPOARTICULONOMBRE',pic:''}]");
      setEventMetadata("VALID_TIPOARTICULOID",",oparms:[{av:'A103TipoArticuloNombre',fld:'TIPOARTICULONOMBRE',pic:''}]}");
      setEventMetadata("VALID_IMPUESTOID","{handler:'valid_Impuestoid',iparms:[{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]");
      setEventMetadata("VALID_IMPUESTOID",",oparms:[{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]}");
      setEventMetadata("VALID_ARTICULOTALLAID","{handler:'valid_Articulotallaid',iparms:[]");
      setEventMetadata("VALID_ARTICULOTALLAID",",oparms:[]}");
      setEventMetadata("VALID_TALLAID","{handler:'valid_Tallaid',iparms:[{av:'A286TallaID',fld:'TALLAID',pic:'ZZZZZZZZZZ9'},{av:'A287TallaNombre',fld:'TALLANOMBRE',pic:''},{av:'A288TallaNumero',fld:'TALLANUMERO',pic:'ZZZ9'}]");
      setEventMetadata("VALID_TALLAID",",oparms:[{av:'A287TallaNombre',fld:'TALLANOMBRE',pic:''},{av:'A288TallaNumero',fld:'TALLANUMERO',pic:'ZZZ9'}]}");
      setEventMetadata("NULL","{handler:'valid_Articulotallastock',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOGALERIAID","{handler:'valid_Articulogaleriaid',iparms:[]");
      setEventMetadata("VALID_ARTICULOGALERIAID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Articulogaleriaimagen',iparms:[]");
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
      return "articulo_Execute";
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
      pr_default.close(35);
      pr_default.close(19);
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z76ArticuloNombre = "" ;
      Z214ArticuloDescripcionCorta = "" ;
      Z77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      Z78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      Z222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV16Pgmname = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblTabgeneral_title_Jsonclick = "" ;
      TempTags = "" ;
      A76ArticuloNombre = "" ;
      A214ArticuloDescripcionCorta = "" ;
      A215ArticuloDescripcionLarga = "" ;
      A77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      imgprompt_17_gximage = "" ;
      sImgUrl = "" ;
      A103TipoArticuloNombre = "" ;
      imgprompt_18_gximage = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A231ArticuloImagen = "" ;
      A40000ArticuloImagen_GXI = "" ;
      lblTablevel_talla_title_Jsonclick = "" ;
      lblTablevel_galeria_title_Jsonclick = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_tallaContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode57 = "" ;
      sStyleString = "" ;
      Gridlevel_galeriaContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode15 = "" ;
      A40001ArticuloGaleriaImagen_GXI = "" ;
      Gxuitabspanel_tabs_Objectcall = "" ;
      Gxuitabspanel_tabs_Activepagecontrolname = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode14 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      A230ArticuloGaleriaImagen = "" ;
      GXCCtl = "" ;
      A287TallaNombre = "" ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z215ArticuloDescripcionLarga = "" ;
      Z231ArticuloImagen = "" ;
      Z40000ArticuloImagen_GXI = "" ;
      Z103TipoArticuloNombre = "" ;
      Z83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      T000C10_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C9_A103TipoArticuloNombre = new String[] {""} ;
      T000C11_A13ArticuloId = new long[1] ;
      T000C11_A76ArticuloNombre = new String[] {""} ;
      T000C11_A214ArticuloDescripcionCorta = new String[] {""} ;
      T000C11_A215ArticuloDescripcionLarga = new String[] {""} ;
      T000C11_A77ArticuloPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C11_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C11_A222ArticuloPrecioPromedio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C11_A79ArticuloStock = new long[1] ;
      T000C11_A103TipoArticuloNombre = new String[] {""} ;
      T000C11_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C11_A231ArticuloImagen = new String[] {""} ;
      T000C11_A40000ArticuloImagen_GXI = new String[] {""} ;
      T000C11_A234ArticuloSerial = new long[1] ;
      T000C11_A17TipoArticuloId = new long[1] ;
      T000C11_A18ImpuestoId = new long[1] ;
      T000C12_A103TipoArticuloNombre = new String[] {""} ;
      T000C13_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C14_A13ArticuloId = new long[1] ;
      T000C8_A13ArticuloId = new long[1] ;
      T000C8_A76ArticuloNombre = new String[] {""} ;
      T000C8_A214ArticuloDescripcionCorta = new String[] {""} ;
      T000C8_A215ArticuloDescripcionLarga = new String[] {""} ;
      T000C8_A77ArticuloPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C8_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C8_A222ArticuloPrecioPromedio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C8_A79ArticuloStock = new long[1] ;
      T000C8_A231ArticuloImagen = new String[] {""} ;
      T000C8_A40000ArticuloImagen_GXI = new String[] {""} ;
      T000C8_A234ArticuloSerial = new long[1] ;
      T000C8_A17TipoArticuloId = new long[1] ;
      T000C8_A18ImpuestoId = new long[1] ;
      T000C15_A13ArticuloId = new long[1] ;
      T000C16_A13ArticuloId = new long[1] ;
      T000C7_A13ArticuloId = new long[1] ;
      T000C7_A76ArticuloNombre = new String[] {""} ;
      T000C7_A214ArticuloDescripcionCorta = new String[] {""} ;
      T000C7_A215ArticuloDescripcionLarga = new String[] {""} ;
      T000C7_A77ArticuloPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C7_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C7_A222ArticuloPrecioPromedio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C7_A79ArticuloStock = new long[1] ;
      T000C7_A231ArticuloImagen = new String[] {""} ;
      T000C7_A40000ArticuloImagen_GXI = new String[] {""} ;
      T000C7_A234ArticuloSerial = new long[1] ;
      T000C7_A17TipoArticuloId = new long[1] ;
      T000C7_A18ImpuestoId = new long[1] ;
      T000C21_A103TipoArticuloNombre = new String[] {""} ;
      T000C22_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000C23_A272DevolucionesID = new long[1] ;
      T000C23_A274DevolucionesDetalleID = new long[1] ;
      T000C24_A53InventarioID = new long[1] ;
      T000C24_A54InventarioDetalleID = new long[1] ;
      T000C25_A51PedidosID = new long[1] ;
      T000C25_A52PedidosDetalleID = new long[1] ;
      T000C26_A46StockId = new long[1] ;
      T000C27_A19VentasId = new long[1] ;
      T000C27_A20VentasDetalleId = new long[1] ;
      T000C28_A11ComprasId = new long[1] ;
      T000C28_A12ComprasDetalleId = new long[1] ;
      T000C30_A13ArticuloId = new long[1] ;
      Z287TallaNombre = "" ;
      T000C31_A13ArticuloId = new long[1] ;
      T000C31_A285ArticuloTallaID = new long[1] ;
      T000C31_A287TallaNombre = new String[] {""} ;
      T000C31_A288TallaNumero = new short[1] ;
      T000C31_A290ArticuloTallaStock = new long[1] ;
      T000C31_A286TallaID = new long[1] ;
      T000C6_A287TallaNombre = new String[] {""} ;
      T000C6_A288TallaNumero = new short[1] ;
      T000C32_A287TallaNombre = new String[] {""} ;
      T000C32_A288TallaNumero = new short[1] ;
      T000C33_A13ArticuloId = new long[1] ;
      T000C33_A285ArticuloTallaID = new long[1] ;
      T000C5_A13ArticuloId = new long[1] ;
      T000C5_A285ArticuloTallaID = new long[1] ;
      T000C5_A290ArticuloTallaStock = new long[1] ;
      T000C5_A286TallaID = new long[1] ;
      T000C4_A13ArticuloId = new long[1] ;
      T000C4_A285ArticuloTallaID = new long[1] ;
      T000C4_A290ArticuloTallaStock = new long[1] ;
      T000C4_A286TallaID = new long[1] ;
      T000C37_A287TallaNombre = new String[] {""} ;
      T000C37_A288TallaNumero = new short[1] ;
      T000C38_A13ArticuloId = new long[1] ;
      T000C38_A285ArticuloTallaID = new long[1] ;
      Z230ArticuloGaleriaImagen = "" ;
      Z40001ArticuloGaleriaImagen_GXI = "" ;
      T000C39_A13ArticuloId = new long[1] ;
      T000C39_A48ArticuloGaleriaId = new long[1] ;
      T000C39_A230ArticuloGaleriaImagen = new String[] {""} ;
      T000C39_A40001ArticuloGaleriaImagen_GXI = new String[] {""} ;
      T000C40_A13ArticuloId = new long[1] ;
      T000C40_A48ArticuloGaleriaId = new long[1] ;
      T000C3_A13ArticuloId = new long[1] ;
      T000C3_A48ArticuloGaleriaId = new long[1] ;
      T000C3_A230ArticuloGaleriaImagen = new String[] {""} ;
      T000C3_A40001ArticuloGaleriaImagen_GXI = new String[] {""} ;
      T000C2_A13ArticuloId = new long[1] ;
      T000C2_A48ArticuloGaleriaId = new long[1] ;
      T000C2_A230ArticuloGaleriaImagen = new String[] {""} ;
      T000C2_A40001ArticuloGaleriaImagen_GXI = new String[] {""} ;
      T000C44_A13ArticuloId = new long[1] ;
      T000C44_A48ArticuloGaleriaId = new long[1] ;
      Gridlevel_tallaRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_talla_Linesclass = "" ;
      ROClassString = "" ;
      imgprompt_286_gximage = "" ;
      Gridlevel_galeriaRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_galeria_Linesclass = "" ;
      GXCCtlgxBlob = "" ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_tallaColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_galeriaColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int5 = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articulo__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articulo__default(),
         new Object[] {
             new Object[] {
            T000C2_A13ArticuloId, T000C2_A48ArticuloGaleriaId, T000C2_A230ArticuloGaleriaImagen, T000C2_A40001ArticuloGaleriaImagen_GXI
            }
            , new Object[] {
            T000C3_A13ArticuloId, T000C3_A48ArticuloGaleriaId, T000C3_A230ArticuloGaleriaImagen, T000C3_A40001ArticuloGaleriaImagen_GXI
            }
            , new Object[] {
            T000C4_A13ArticuloId, T000C4_A285ArticuloTallaID, T000C4_A290ArticuloTallaStock, T000C4_A286TallaID
            }
            , new Object[] {
            T000C5_A13ArticuloId, T000C5_A285ArticuloTallaID, T000C5_A290ArticuloTallaStock, T000C5_A286TallaID
            }
            , new Object[] {
            T000C6_A287TallaNombre, T000C6_A288TallaNumero
            }
            , new Object[] {
            T000C7_A13ArticuloId, T000C7_A76ArticuloNombre, T000C7_A214ArticuloDescripcionCorta, T000C7_A215ArticuloDescripcionLarga, T000C7_A77ArticuloPrecioCompra, T000C7_A78ArticuloPrecioVenta, T000C7_A222ArticuloPrecioPromedio, T000C7_A79ArticuloStock, T000C7_A231ArticuloImagen, T000C7_A40000ArticuloImagen_GXI,
            T000C7_A234ArticuloSerial, T000C7_A17TipoArticuloId, T000C7_A18ImpuestoId
            }
            , new Object[] {
            T000C8_A13ArticuloId, T000C8_A76ArticuloNombre, T000C8_A214ArticuloDescripcionCorta, T000C8_A215ArticuloDescripcionLarga, T000C8_A77ArticuloPrecioCompra, T000C8_A78ArticuloPrecioVenta, T000C8_A222ArticuloPrecioPromedio, T000C8_A79ArticuloStock, T000C8_A231ArticuloImagen, T000C8_A40000ArticuloImagen_GXI,
            T000C8_A234ArticuloSerial, T000C8_A17TipoArticuloId, T000C8_A18ImpuestoId
            }
            , new Object[] {
            T000C9_A103TipoArticuloNombre
            }
            , new Object[] {
            T000C10_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000C11_A13ArticuloId, T000C11_A76ArticuloNombre, T000C11_A214ArticuloDescripcionCorta, T000C11_A215ArticuloDescripcionLarga, T000C11_A77ArticuloPrecioCompra, T000C11_A78ArticuloPrecioVenta, T000C11_A222ArticuloPrecioPromedio, T000C11_A79ArticuloStock, T000C11_A103TipoArticuloNombre, T000C11_A83ImpuestoPorcentaje,
            T000C11_A231ArticuloImagen, T000C11_A40000ArticuloImagen_GXI, T000C11_A234ArticuloSerial, T000C11_A17TipoArticuloId, T000C11_A18ImpuestoId
            }
            , new Object[] {
            T000C12_A103TipoArticuloNombre
            }
            , new Object[] {
            T000C13_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000C14_A13ArticuloId
            }
            , new Object[] {
            T000C15_A13ArticuloId
            }
            , new Object[] {
            T000C16_A13ArticuloId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000C21_A103TipoArticuloNombre
            }
            , new Object[] {
            T000C22_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T000C23_A272DevolucionesID, T000C23_A274DevolucionesDetalleID
            }
            , new Object[] {
            T000C24_A53InventarioID, T000C24_A54InventarioDetalleID
            }
            , new Object[] {
            T000C25_A51PedidosID, T000C25_A52PedidosDetalleID
            }
            , new Object[] {
            T000C26_A46StockId
            }
            , new Object[] {
            T000C27_A19VentasId, T000C27_A20VentasDetalleId
            }
            , new Object[] {
            T000C28_A11ComprasId, T000C28_A12ComprasDetalleId
            }
            , new Object[] {
            }
            , new Object[] {
            T000C30_A13ArticuloId
            }
            , new Object[] {
            T000C31_A13ArticuloId, T000C31_A285ArticuloTallaID, T000C31_A287TallaNombre, T000C31_A288TallaNumero, T000C31_A290ArticuloTallaStock, T000C31_A286TallaID
            }
            , new Object[] {
            T000C32_A287TallaNombre, T000C32_A288TallaNumero
            }
            , new Object[] {
            T000C33_A13ArticuloId, T000C33_A285ArticuloTallaID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000C37_A287TallaNombre, T000C37_A288TallaNumero
            }
            , new Object[] {
            T000C38_A13ArticuloId, T000C38_A285ArticuloTallaID
            }
            , new Object[] {
            T000C39_A13ArticuloId, T000C39_A48ArticuloGaleriaId, T000C39_A230ArticuloGaleriaImagen, T000C39_A40001ArticuloGaleriaImagen_GXI
            }
            , new Object[] {
            T000C40_A13ArticuloId, T000C40_A48ArticuloGaleriaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000C44_A13ArticuloId, T000C44_A48ArticuloGaleriaId
            }
         }
      );
      AV16Pgmname = "Articulo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_talla_Backcolorstyle ;
   private byte subGridlevel_talla_Backstyle ;
   private byte subGridlevel_galeria_Backcolorstyle ;
   private byte subGridlevel_galeria_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_talla_Allowselection ;
   private byte subGridlevel_talla_Allowhovering ;
   private byte subGridlevel_talla_Allowcollapsing ;
   private byte subGridlevel_talla_Collapsed ;
   private byte subGridlevel_galeria_Allowselection ;
   private byte subGridlevel_galeria_Allowhovering ;
   private byte subGridlevel_galeria_Allowcollapsing ;
   private byte subGridlevel_galeria_Collapsed ;
   private short nIsMod_57 ;
   private short nRcdDeleted_57 ;
   private short nRcdExists_57 ;
   private short nRcdDeleted_15 ;
   private short nRcdExists_15 ;
   private short nIsMod_15 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount57 ;
   private short RcdFound57 ;
   private short nBlankRcdUsr57 ;
   private short nBlankRcdCount15 ;
   private short RcdFound15 ;
   private short nBlankRcdUsr15 ;
   private short RcdFound14 ;
   private short A288TallaNumero ;
   private short nIsDirty_14 ;
   private short Z288TallaNumero ;
   private short nIsDirty_57 ;
   private short nIsDirty_15 ;
   private int nRC_GXsfl_90 ;
   private int nGXsfl_90_idx=1 ;
   private int nRC_GXsfl_106 ;
   private int nGXsfl_106_idx=1 ;
   private int trnEnded ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtArticuloDescripcionCorta_Enabled ;
   private int edtArticuloDescripcionLarga_Enabled ;
   private int edtArticuloPrecioCompra_Enabled ;
   private int edtArticuloPrecioVenta_Enabled ;
   private int edtArticuloPrecioPromedio_Enabled ;
   private int edtArticuloStock_Enabled ;
   private int edtTipoArticuloId_Enabled ;
   private int imgprompt_17_Visible ;
   private int edtTipoArticuloNombre_Enabled ;
   private int edtImpuestoId_Enabled ;
   private int imgprompt_18_Visible ;
   private int edtImpuestoPorcentaje_Enabled ;
   private int imgArticuloImagen_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtArticuloTallaID_Enabled ;
   private int edtTallaID_Enabled ;
   private int edtTallaNombre_Enabled ;
   private int edtTallaNumero_Enabled ;
   private int edtArticuloTallaStock_Enabled ;
   private int fRowAdded ;
   private int edtArticuloGaleriaId_Enabled ;
   private int edtArticuloGaleriaImagen_Enabled ;
   private int Gxuitabspanel_tabs_Activepage ;
   private int AV18GXV1 ;
   private int GX_JID ;
   private int subGridlevel_talla_Backcolor ;
   private int subGridlevel_talla_Allbackcolor ;
   private int imgprompt_286_Visible ;
   private int subGridlevel_galeria_Backcolor ;
   private int subGridlevel_galeria_Allbackcolor ;
   private int defedtArticuloGaleriaId_Enabled ;
   private int defedtArticuloTallaID_Enabled ;
   private int idxLst ;
   private int subGridlevel_talla_Selectedindex ;
   private int subGridlevel_talla_Selectioncolor ;
   private int subGridlevel_talla_Hoveringcolor ;
   private int subGridlevel_galeria_Selectedindex ;
   private int subGridlevel_galeria_Selectioncolor ;
   private int subGridlevel_galeria_Hoveringcolor ;
   private long wcpOAV7ArticuloId ;
   private long Z13ArticuloId ;
   private long Z79ArticuloStock ;
   private long Z234ArticuloSerial ;
   private long Z17TipoArticuloId ;
   private long Z18ImpuestoId ;
   private long O234ArticuloSerial ;
   private long N17TipoArticuloId ;
   private long N18ImpuestoId ;
   private long Z285ArticuloTallaID ;
   private long Z290ArticuloTallaStock ;
   private long Z286TallaID ;
   private long Z48ArticuloGaleriaId ;
   private long AV7ArticuloId ;
   private long A17TipoArticuloId ;
   private long A18ImpuestoId ;
   private long A286TallaID ;
   private long A234ArticuloSerial ;
   private long A13ArticuloId ;
   private long A79ArticuloStock ;
   private long B234ArticuloSerial ;
   private long AV13Insert_TipoArticuloId ;
   private long AV14Insert_ImpuestoId ;
   private long GRIDLEVEL_TALLA_nFirstRecordOnPage ;
   private long GRIDLEVEL_GALERIA_nFirstRecordOnPage ;
   private long s234ArticuloSerial ;
   private long A48ArticuloGaleriaId ;
   private long A285ArticuloTallaID ;
   private long A290ArticuloTallaStock ;
   private long i234ArticuloSerial ;
   private long GXt_int4 ;
   private long GXv_int5[] ;
   private java.math.BigDecimal Z77ArticuloPrecioCompra ;
   private java.math.BigDecimal Z78ArticuloPrecioVenta ;
   private java.math.BigDecimal Z222ArticuloPrecioPromedio ;
   private java.math.BigDecimal A77ArticuloPrecioCompra ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
   private java.math.BigDecimal Z83ImpuestoPorcentaje ;
   private String sPrefix ;
   private String sGXsfl_90_idx="0001" ;
   private String wcpOGx_mode ;
   private String Z76ArticuloNombre ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV16Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtArticuloId_Internalname ;
   private String sGXsfl_106_idx="0001" ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String Gxuitabspanel_tabs_Class ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblTabgeneral_title_Internalname ;
   private String lblTabgeneral_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtArticuloId_Jsonclick ;
   private String edtArticuloNombre_Internalname ;
   private String A76ArticuloNombre ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtArticuloDescripcionCorta_Internalname ;
   private String edtArticuloDescripcionLarga_Internalname ;
   private String edtArticuloPrecioCompra_Internalname ;
   private String edtArticuloPrecioCompra_Jsonclick ;
   private String edtArticuloPrecioVenta_Internalname ;
   private String edtArticuloPrecioVenta_Jsonclick ;
   private String edtArticuloPrecioPromedio_Internalname ;
   private String edtArticuloPrecioPromedio_Jsonclick ;
   private String edtArticuloStock_Internalname ;
   private String edtArticuloStock_Jsonclick ;
   private String edtTipoArticuloId_Internalname ;
   private String edtTipoArticuloId_Jsonclick ;
   private String imgprompt_17_gximage ;
   private String sImgUrl ;
   private String imgprompt_17_Internalname ;
   private String imgprompt_17_Link ;
   private String edtTipoArticuloNombre_Internalname ;
   private String A103TipoArticuloNombre ;
   private String edtTipoArticuloNombre_Jsonclick ;
   private String edtImpuestoId_Internalname ;
   private String edtImpuestoId_Jsonclick ;
   private String imgprompt_18_gximage ;
   private String imgprompt_18_Internalname ;
   private String imgprompt_18_Link ;
   private String edtImpuestoPorcentaje_Internalname ;
   private String edtImpuestoPorcentaje_Jsonclick ;
   private String imgArticuloImagen_Internalname ;
   private String lblTablevel_talla_title_Internalname ;
   private String lblTablevel_talla_title_Jsonclick ;
   private String divTabtablelevel_talla_Internalname ;
   private String divTableleaflevel_talla_Internalname ;
   private String lblTablevel_galeria_title_Internalname ;
   private String lblTablevel_galeria_title_Jsonclick ;
   private String divTabtablelevel_galeria_Internalname ;
   private String divTableleaflevel_galeria_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode57 ;
   private String edtArticuloTallaID_Internalname ;
   private String edtTallaID_Internalname ;
   private String edtTallaNombre_Internalname ;
   private String edtTallaNumero_Internalname ;
   private String edtArticuloTallaStock_Internalname ;
   private String sStyleString ;
   private String subGridlevel_talla_Internalname ;
   private String sMode15 ;
   private String edtArticuloGaleriaId_Internalname ;
   private String edtArticuloGaleriaImagen_Internalname ;
   private String subGridlevel_galeria_Internalname ;
   private String Gxuitabspanel_tabs_Objectcall ;
   private String Gxuitabspanel_tabs_Activepagecontrolname ;
   private String hsh ;
   private String sMode14 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A287TallaNombre ;
   private String Z103TipoArticuloNombre ;
   private String Z287TallaNombre ;
   private String imgprompt_286_Internalname ;
   private String sGXsfl_90_fel_idx="0001" ;
   private String subGridlevel_talla_Class ;
   private String subGridlevel_talla_Linesclass ;
   private String imgprompt_286_Link ;
   private String ROClassString ;
   private String edtArticuloTallaID_Jsonclick ;
   private String edtTallaID_Jsonclick ;
   private String imgprompt_286_gximage ;
   private String edtTallaNombre_Jsonclick ;
   private String edtTallaNumero_Jsonclick ;
   private String edtArticuloTallaStock_Jsonclick ;
   private String sGXsfl_106_fel_idx="0001" ;
   private String subGridlevel_galeria_Class ;
   private String subGridlevel_galeria_Linesclass ;
   private String edtArticuloGaleriaId_Jsonclick ;
   private String GXCCtlgxBlob ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_talla_Header ;
   private String subGridlevel_galeria_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean A231ArticuloImagen_IsBlob ;
   private boolean bGXsfl_90_Refreshing=false ;
   private boolean bGXsfl_106_Refreshing=false ;
   private boolean Gxuitabspanel_tabs_Enabled ;
   private boolean Gxuitabspanel_tabs_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private boolean A230ArticuloGaleriaImagen_IsBlob ;
   private String A215ArticuloDescripcionLarga ;
   private String Z215ArticuloDescripcionLarga ;
   private String Z214ArticuloDescripcionCorta ;
   private String A214ArticuloDescripcionCorta ;
   private String A40000ArticuloImagen_GXI ;
   private String A40001ArticuloGaleriaImagen_GXI ;
   private String Z40000ArticuloImagen_GXI ;
   private String Z40001ArticuloGaleriaImagen_GXI ;
   private String A231ArticuloImagen ;
   private String A230ArticuloGaleriaImagen ;
   private String Z231ArticuloImagen ;
   private String Z230ArticuloGaleriaImagen ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_tallaContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_galeriaContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_tallaRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_galeriaRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_tallaColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_galeriaColumn ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T000C10_A83ImpuestoPorcentaje ;
   private String[] T000C9_A103TipoArticuloNombre ;
   private long[] T000C11_A13ArticuloId ;
   private String[] T000C11_A76ArticuloNombre ;
   private String[] T000C11_A214ArticuloDescripcionCorta ;
   private String[] T000C11_A215ArticuloDescripcionLarga ;
   private java.math.BigDecimal[] T000C11_A77ArticuloPrecioCompra ;
   private java.math.BigDecimal[] T000C11_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T000C11_A222ArticuloPrecioPromedio ;
   private long[] T000C11_A79ArticuloStock ;
   private String[] T000C11_A103TipoArticuloNombre ;
   private java.math.BigDecimal[] T000C11_A83ImpuestoPorcentaje ;
   private String[] T000C11_A231ArticuloImagen ;
   private String[] T000C11_A40000ArticuloImagen_GXI ;
   private long[] T000C11_A234ArticuloSerial ;
   private long[] T000C11_A17TipoArticuloId ;
   private long[] T000C11_A18ImpuestoId ;
   private String[] T000C12_A103TipoArticuloNombre ;
   private java.math.BigDecimal[] T000C13_A83ImpuestoPorcentaje ;
   private long[] T000C14_A13ArticuloId ;
   private long[] T000C8_A13ArticuloId ;
   private String[] T000C8_A76ArticuloNombre ;
   private String[] T000C8_A214ArticuloDescripcionCorta ;
   private String[] T000C8_A215ArticuloDescripcionLarga ;
   private java.math.BigDecimal[] T000C8_A77ArticuloPrecioCompra ;
   private java.math.BigDecimal[] T000C8_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T000C8_A222ArticuloPrecioPromedio ;
   private long[] T000C8_A79ArticuloStock ;
   private String[] T000C8_A231ArticuloImagen ;
   private String[] T000C8_A40000ArticuloImagen_GXI ;
   private long[] T000C8_A234ArticuloSerial ;
   private long[] T000C8_A17TipoArticuloId ;
   private long[] T000C8_A18ImpuestoId ;
   private long[] T000C15_A13ArticuloId ;
   private long[] T000C16_A13ArticuloId ;
   private long[] T000C7_A13ArticuloId ;
   private String[] T000C7_A76ArticuloNombre ;
   private String[] T000C7_A214ArticuloDescripcionCorta ;
   private String[] T000C7_A215ArticuloDescripcionLarga ;
   private java.math.BigDecimal[] T000C7_A77ArticuloPrecioCompra ;
   private java.math.BigDecimal[] T000C7_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T000C7_A222ArticuloPrecioPromedio ;
   private long[] T000C7_A79ArticuloStock ;
   private String[] T000C7_A231ArticuloImagen ;
   private String[] T000C7_A40000ArticuloImagen_GXI ;
   private long[] T000C7_A234ArticuloSerial ;
   private long[] T000C7_A17TipoArticuloId ;
   private long[] T000C7_A18ImpuestoId ;
   private String[] T000C21_A103TipoArticuloNombre ;
   private java.math.BigDecimal[] T000C22_A83ImpuestoPorcentaje ;
   private long[] T000C23_A272DevolucionesID ;
   private long[] T000C23_A274DevolucionesDetalleID ;
   private long[] T000C24_A53InventarioID ;
   private long[] T000C24_A54InventarioDetalleID ;
   private long[] T000C25_A51PedidosID ;
   private long[] T000C25_A52PedidosDetalleID ;
   private long[] T000C26_A46StockId ;
   private long[] T000C27_A19VentasId ;
   private long[] T000C27_A20VentasDetalleId ;
   private long[] T000C28_A11ComprasId ;
   private long[] T000C28_A12ComprasDetalleId ;
   private long[] T000C30_A13ArticuloId ;
   private long[] T000C31_A13ArticuloId ;
   private long[] T000C31_A285ArticuloTallaID ;
   private String[] T000C31_A287TallaNombre ;
   private short[] T000C31_A288TallaNumero ;
   private long[] T000C31_A290ArticuloTallaStock ;
   private long[] T000C31_A286TallaID ;
   private String[] T000C6_A287TallaNombre ;
   private short[] T000C6_A288TallaNumero ;
   private String[] T000C32_A287TallaNombre ;
   private short[] T000C32_A288TallaNumero ;
   private long[] T000C33_A13ArticuloId ;
   private long[] T000C33_A285ArticuloTallaID ;
   private long[] T000C5_A13ArticuloId ;
   private long[] T000C5_A285ArticuloTallaID ;
   private long[] T000C5_A290ArticuloTallaStock ;
   private long[] T000C5_A286TallaID ;
   private long[] T000C4_A13ArticuloId ;
   private long[] T000C4_A285ArticuloTallaID ;
   private long[] T000C4_A290ArticuloTallaStock ;
   private long[] T000C4_A286TallaID ;
   private String[] T000C37_A287TallaNombre ;
   private short[] T000C37_A288TallaNumero ;
   private long[] T000C38_A13ArticuloId ;
   private long[] T000C38_A285ArticuloTallaID ;
   private long[] T000C39_A13ArticuloId ;
   private long[] T000C39_A48ArticuloGaleriaId ;
   private String[] T000C39_A230ArticuloGaleriaImagen ;
   private String[] T000C39_A40001ArticuloGaleriaImagen_GXI ;
   private long[] T000C40_A13ArticuloId ;
   private long[] T000C40_A48ArticuloGaleriaId ;
   private long[] T000C3_A13ArticuloId ;
   private long[] T000C3_A48ArticuloGaleriaId ;
   private String[] T000C3_A230ArticuloGaleriaImagen ;
   private String[] T000C3_A40001ArticuloGaleriaImagen_GXI ;
   private long[] T000C2_A13ArticuloId ;
   private long[] T000C2_A48ArticuloGaleriaId ;
   private String[] T000C2_A230ArticuloGaleriaImagen ;
   private String[] T000C2_A40001ArticuloGaleriaImagen_GXI ;
   private long[] T000C44_A13ArticuloId ;
   private long[] T000C44_A48ArticuloGaleriaId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class articulo__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class articulo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000C2", "SELECT [ArticuloId], [ArticuloGaleriaId], [ArticuloGaleriaImagen], [ArticuloGaleriaImagen_GXI] FROM [ArticuloGaleria] WITH (UPDLOCK) WHERE [ArticuloId] = ? AND [ArticuloGaleriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C3", "SELECT [ArticuloId], [ArticuloGaleriaId], [ArticuloGaleriaImagen], [ArticuloGaleriaImagen_GXI] FROM [ArticuloGaleria] WHERE [ArticuloId] = ? AND [ArticuloGaleriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C4", "SELECT [ArticuloId], [ArticuloTallaID], [ArticuloTallaStock], [TallaID] FROM [ArticuloTalla] WITH (UPDLOCK) WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C5", "SELECT [ArticuloId], [ArticuloTallaID], [ArticuloTallaStock], [TallaID] FROM [ArticuloTalla] WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C6", "SELECT [TallaNombre], [TallaNumero] FROM [Talla] WHERE [TallaID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C7", "SELECT [ArticuloId], [ArticuloNombre], [ArticuloDescripcionCorta], [ArticuloDescripcionLarga], [ArticuloPrecioCompra], [ArticuloPrecioVenta], [ArticuloPrecioPromedio], [ArticuloStock], [ArticuloImagen], [ArticuloImagen_GXI], [ArticuloSerial], [TipoArticuloId], [ImpuestoId] FROM [Articulo] WITH (UPDLOCK) WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C8", "SELECT [ArticuloId], [ArticuloNombre], [ArticuloDescripcionCorta], [ArticuloDescripcionLarga], [ArticuloPrecioCompra], [ArticuloPrecioVenta], [ArticuloPrecioPromedio], [ArticuloStock], [ArticuloImagen], [ArticuloImagen_GXI], [ArticuloSerial], [TipoArticuloId], [ImpuestoId] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C9", "SELECT [TipoArticuloNombre] FROM [TipoArticulo] WHERE [TipoArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C10", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C11", "SELECT TM1.[ArticuloId], TM1.[ArticuloNombre], TM1.[ArticuloDescripcionCorta], TM1.[ArticuloDescripcionLarga], TM1.[ArticuloPrecioCompra], TM1.[ArticuloPrecioVenta], TM1.[ArticuloPrecioPromedio], TM1.[ArticuloStock], T2.[TipoArticuloNombre], T3.[ImpuestoPorcentaje], TM1.[ArticuloImagen], TM1.[ArticuloImagen_GXI], TM1.[ArticuloSerial], TM1.[TipoArticuloId], TM1.[ImpuestoId] FROM (([Articulo] TM1 INNER JOIN [TipoArticulo] T2 ON T2.[TipoArticuloId] = TM1.[TipoArticuloId]) INNER JOIN [Impuesto] T3 ON T3.[ImpuestoId] = TM1.[ImpuestoId]) WHERE TM1.[ArticuloId] = ? ORDER BY TM1.[ArticuloId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C12", "SELECT [TipoArticuloNombre] FROM [TipoArticulo] WHERE [TipoArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C13", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C14", "SELECT [ArticuloId] FROM [Articulo] WHERE [ArticuloId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C15", "SELECT TOP 1 [ArticuloId] FROM [Articulo] WHERE ( [ArticuloId] > ?) ORDER BY [ArticuloId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C16", "SELECT TOP 1 [ArticuloId] FROM [Articulo] WHERE ( [ArticuloId] < ?) ORDER BY [ArticuloId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000C17", "INSERT INTO [Articulo]([ArticuloId], [ArticuloNombre], [ArticuloDescripcionCorta], [ArticuloDescripcionLarga], [ArticuloPrecioCompra], [ArticuloPrecioVenta], [ArticuloPrecioPromedio], [ArticuloStock], [ArticuloImagen], [ArticuloImagen_GXI], [ArticuloSerial], [TipoArticuloId], [ImpuestoId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000C18", "UPDATE [Articulo] SET [ArticuloNombre]=?, [ArticuloDescripcionCorta]=?, [ArticuloDescripcionLarga]=?, [ArticuloPrecioCompra]=?, [ArticuloPrecioVenta]=?, [ArticuloPrecioPromedio]=?, [ArticuloStock]=?, [ArticuloSerial]=?, [TipoArticuloId]=?, [ImpuestoId]=?  WHERE [ArticuloId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000C19", "UPDATE [Articulo] SET [ArticuloImagen]=?, [ArticuloImagen_GXI]=?  WHERE [ArticuloId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000C20", "DELETE FROM [Articulo]  WHERE [ArticuloId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000C21", "SELECT [TipoArticuloNombre] FROM [TipoArticulo] WHERE [TipoArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C22", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C23", "SELECT TOP 1 [DevolucionesID], [DevolucionesDetalleID] FROM [DevolucionesDetalle] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C24", "SELECT TOP 1 [InventarioID], [InventarioDetalleID] FROM [InventarioDetalle] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C25", "SELECT TOP 1 [PedidosID], [PedidosDetalleID] FROM [PedidosDetalle] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C26", "SELECT TOP 1 [StockId] FROM [Stock] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C27", "SELECT TOP 1 [VentasId], [VentasDetalleId] FROM [VentasDetalle] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C28", "SELECT TOP 1 [ComprasId], [ComprasDetalleId] FROM [ComprasDetalle] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000C29", "UPDATE [Articulo] SET [ArticuloSerial]=?  WHERE [ArticuloId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000C30", "SELECT [ArticuloId] FROM [Articulo] ORDER BY [ArticuloId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C31", "SELECT T1.[ArticuloId], T1.[ArticuloTallaID], T2.[TallaNombre], T2.[TallaNumero], T1.[ArticuloTallaStock], T1.[TallaID] FROM ([ArticuloTalla] T1 INNER JOIN [Talla] T2 ON T2.[TallaID] = T1.[TallaID]) WHERE T1.[ArticuloId] = ? and T1.[ArticuloTallaID] = ? ORDER BY T1.[ArticuloId], T1.[ArticuloTallaID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C32", "SELECT [TallaNombre], [TallaNumero] FROM [Talla] WHERE [TallaID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C33", "SELECT [ArticuloId], [ArticuloTallaID] FROM [ArticuloTalla] WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000C34", "INSERT INTO [ArticuloTalla]([ArticuloId], [ArticuloTallaID], [ArticuloTallaStock], [TallaID]) VALUES(?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000C35", "UPDATE [ArticuloTalla] SET [ArticuloTallaStock]=?, [TallaID]=?  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK)
         ,new UpdateCursor("T000C36", "DELETE FROM [ArticuloTalla]  WHERE [ArticuloId] = ? AND [ArticuloTallaID] = ?", GX_NOMASK)
         ,new ForEachCursor("T000C37", "SELECT [TallaNombre], [TallaNumero] FROM [Talla] WHERE [TallaID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C38", "SELECT [ArticuloId], [ArticuloTallaID] FROM [ArticuloTalla] WHERE [ArticuloId] = ? ORDER BY [ArticuloId], [ArticuloTallaID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C39", "SELECT [ArticuloId], [ArticuloGaleriaId], [ArticuloGaleriaImagen], [ArticuloGaleriaImagen_GXI] FROM [ArticuloGaleria] WHERE [ArticuloId] = ? and [ArticuloGaleriaId] = ? ORDER BY [ArticuloId], [ArticuloGaleriaId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C40", "SELECT [ArticuloId], [ArticuloGaleriaId] FROM [ArticuloGaleria] WHERE [ArticuloId] = ? AND [ArticuloGaleriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000C41", "INSERT INTO [ArticuloGaleria]([ArticuloId], [ArticuloGaleriaId], [ArticuloGaleriaImagen], [ArticuloGaleriaImagen_GXI]) VALUES(?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000C42", "UPDATE [ArticuloGaleria] SET [ArticuloGaleriaImagen]=?, [ArticuloGaleriaImagen_GXI]=?  WHERE [ArticuloId] = ? AND [ArticuloGaleriaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000C43", "DELETE FROM [ArticuloGaleria]  WHERE [ArticuloId] = ? AND [ArticuloGaleriaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000C44", "SELECT [ArticuloId], [ArticuloGaleriaId] FROM [ArticuloGaleria] WHERE [ArticuloId] = ? ORDER BY [ArticuloId], [ArticuloGaleriaId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getMultimediaFile(9, rslt.getVarchar(10));
               ((String[]) buf[9])[0] = rslt.getMultimediaUri(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getMultimediaFile(9, rslt.getVarchar(10));
               ((String[]) buf[9])[0] = rslt.getMultimediaUri(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 8 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[10])[0] = rslt.getMultimediaFile(11, rslt.getVarchar(12));
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               ((long[]) buf[13])[0] = rslt.getLong(14);
               ((long[]) buf[14])[0] = rslt.getLong(15);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 11 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
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
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 20 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 21 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 23 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 24 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 25 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 26 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 28 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 29 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
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
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 31 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 35 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 36 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 37 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               return;
            case 38 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 42 :
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
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
               stmt.setString(2, (String)parms[1], 80);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setLong(8, ((Number) parms[7]).longValue());
               stmt.setBLOBFile(9, (String)parms[8], true);
               stmt.setGXDbFileURI(10, (String)parms[9], (String)parms[8], 2048,"Articulo","ArticuloImagen");
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
               stmt.setLong(13, ((Number) parms[12]).longValue());
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 80);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               stmt.setLong(9, ((Number) parms[8]).longValue());
               stmt.setLong(10, ((Number) parms[9]).longValue());
               stmt.setLong(11, ((Number) parms[10]).longValue());
               return;
            case 17 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Articulo","ArticuloImagen");
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               return;
            case 25 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 26 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 27 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
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
               return;
            case 31 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 32 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 33 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 34 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 35 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 36 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 37 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 38 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 39 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setBLOBFile(3, (String)parms[2], true);
               stmt.setGXDbFileURI(4, (String)parms[3], (String)parms[2], 2048,"ArticuloGaleria","ArticuloGaleriaImagen");
               return;
            case 40 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"ArticuloGaleria","ArticuloGaleriaImagen");
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 41 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 42 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

