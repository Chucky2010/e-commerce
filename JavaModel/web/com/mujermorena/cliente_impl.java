package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cliente_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"CLIENTEID") == 0 )
      {
         AV7ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ClienteId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ClienteId), "ZZZZZZZZZZ9")));
         AV15Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asaclienteid043( AV7ClienteId, AV15Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A1PersonaId = GXutil.lval( httpContext.GetPar( "PersonaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A1PersonaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A3LocalidadId = GXutil.lval( httpContext.GetPar( "LocalidadId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A3LocalidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A7CiudadId = GXutil.lval( httpContext.GetPar( "CiudadId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A7CiudadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A6DepartamentoId = GXutil.lval( httpContext.GetPar( "DepartamentoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6DepartamentoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A6DepartamentoId) ;
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
            AV7ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ClienteId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ClienteId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Cliente", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public cliente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cliente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_impl.class ));
   }

   public cliente_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Cliente", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtClienteId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaId_Internalname, httpContext.getMessage( "Persona Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaId_Internalname, GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1PersonaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Cliente.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_1_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_1_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_1_Internalname, sImgUrl, imgprompt_1_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_1_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaNombreCompleto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaNombreCompleto_Internalname, httpContext.getMessage( "Persona Nombre Completo", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaNombreCompleto_Internalname, GXutil.rtrim( A59PersonaNombreCompleto), GXutil.rtrim( localUtil.format( A59PersonaNombreCompleto, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaNombreCompleto_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaDireccion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaDireccion_Internalname, httpContext.getMessage( "Persona Direccion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtPersonaDireccion_Internalname, A57PersonaDireccion, "", "", (short)(0), 1, edtPersonaDireccion_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "256", -1, 0, "", "", (byte)(-1), true, "Direccion", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaTelefono_Internalname, httpContext.getMessage( "Persona Telefono", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaTelefono_Internalname, GXutil.rtrim( A66PersonaTelefono), GXutil.rtrim( localUtil.format( A66PersonaTelefono, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaTelefono_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaTelefono_Enabled, 0, "text", "", 25, "chr", 1, "row", 25, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Telefono", "left", true, "", "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLocalidadNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtLocalidadNombre_Internalname, httpContext.getMessage( "Localidad Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtLocalidadNombre_Internalname, GXutil.rtrim( A64LocalidadNombre), GXutil.rtrim( localUtil.format( A64LocalidadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocalidadNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtLocalidadNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCiudadNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCiudadNombre_Internalname, httpContext.getMessage( "Ciudad Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCiudadNombre_Internalname, GXutil.rtrim( A62CiudadNombre), GXutil.rtrim( localUtil.format( A62CiudadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCiudadNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCiudadNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDepartamentoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDepartamentoNombre_Internalname, httpContext.getMessage( "Departamento Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDepartamentoNombre_Internalname, GXutil.rtrim( A61DepartamentoNombre), GXutil.rtrim( localUtil.format( A61DepartamentoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDepartamentoNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtDepartamentoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteUser_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteUser_Internalname, httpContext.getMessage( "User", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteUser_Internalname, GXutil.rtrim( A244ClienteUser), GXutil.rtrim( localUtil.format( A244ClienteUser, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteUser_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtClienteUser_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cliente.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente.htm");
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
      e11042 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z4ClienteId = localUtil.ctol( httpContext.cgiGet( "Z4ClienteId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z244ClienteUser = httpContext.cgiGet( "Z244ClienteUser") ;
            Z1PersonaId = localUtil.ctol( httpContext.cgiGet( "Z1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1PersonaId = localUtil.ctol( httpContext.cgiGet( "N1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A55PersonaNombre = httpContext.cgiGet( "PERSONANOMBRE") ;
            A56PersonaApellido = httpContext.cgiGet( "PERSONAAPELLIDO") ;
            AV7ClienteId = localUtil.ctol( httpContext.cgiGet( "vCLIENTEID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_PersonaId = localUtil.ctol( httpContext.cgiGet( "vINSERT_PERSONAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A3LocalidadId = localUtil.ctol( httpContext.cgiGet( "LOCALIDADID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A7CiudadId = localUtil.ctol( httpContext.cgiGet( "CIUDADID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A6DepartamentoId = localUtil.ctol( httpContext.cgiGet( "DEPARTAMENTOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPersonaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPersonaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PERSONAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPersonaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1PersonaId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
            }
            else
            {
               A1PersonaId = localUtil.ctol( httpContext.cgiGet( edtPersonaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
            }
            A59PersonaNombreCompleto = httpContext.cgiGet( edtPersonaNombreCompleto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
            A57PersonaDireccion = httpContext.cgiGet( edtPersonaDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
            A66PersonaTelefono = httpContext.cgiGet( edtPersonaTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
            A64LocalidadNombre = httpContext.cgiGet( edtLocalidadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
            A62CiudadNombre = httpContext.cgiGet( edtCiudadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
            A61DepartamentoNombre = httpContext.cgiGet( edtDepartamentoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
            A244ClienteUser = httpContext.cgiGet( edtClienteUser_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A244ClienteUser", A244ClienteUser);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Cliente");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A4ClienteId != Z4ClienteId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("cliente:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A4ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
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
                  sMode3 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode3 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound3 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_040( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLIENTEID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtClienteId_Internalname ;
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
                        e11042 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12042 ();
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
         e12042 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll043( ) ;
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
         disableAttributes043( ) ;
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

   public void confirm_040( )
   {
      beforeValidate043( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls043( ) ;
         }
         else
         {
            checkExtendedTable043( ) ;
            closeExtendedTableCursors043( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption040( )
   {
   }

   public void e11042( )
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
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PersonaId") == 0 )
            {
               AV13Insert_PersonaId = GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_PersonaId), 11, 0));
            }
            AV16GXV1 = (int)(AV16GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         }
      }
   }

   public void e12042( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.clienteww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm043( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z244ClienteUser = T00043_A244ClienteUser[0] ;
            Z1PersonaId = T00043_A1PersonaId[0] ;
         }
         else
         {
            Z244ClienteUser = A244ClienteUser ;
            Z1PersonaId = A1PersonaId ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z4ClienteId = A4ClienteId ;
         Z244ClienteUser = A244ClienteUser ;
         Z1PersonaId = A1PersonaId ;
         Z3LocalidadId = A3LocalidadId ;
         Z57PersonaDireccion = A57PersonaDireccion ;
         Z66PersonaTelefono = A66PersonaTelefono ;
         Z55PersonaNombre = A55PersonaNombre ;
         Z56PersonaApellido = A56PersonaApellido ;
         Z7CiudadId = A7CiudadId ;
         Z64LocalidadNombre = A64LocalidadNombre ;
         Z6DepartamentoId = A6DepartamentoId ;
         Z62CiudadNombre = A62CiudadNombre ;
         Z61DepartamentoNombre = A61DepartamentoNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      AV15Pgmname = "Cliente" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      imgprompt_1_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.personaprompt"+"',["+"{Ctrl:gx.dom.el('"+"PERSONAID"+"'), id:'"+"PERSONAID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7ClienteId) )
      {
         A4ClienteId = AV7ClienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A4ClienteId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
            cliente_impl.this.GXt_int2 = GXv_int3[0] ;
            A4ClienteId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         }
      }
      if ( ! (0==AV7ClienteId) )
      {
         edtClienteId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      }
      else
      {
         edtClienteId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7ClienteId) )
      {
         edtClienteId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_PersonaId) )
      {
         edtPersonaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      }
      else
      {
         edtPersonaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_PersonaId) )
      {
         A1PersonaId = AV13Insert_PersonaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
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
         /* Using cursor T00044 */
         pr_default.execute(2, new Object[] {Long.valueOf(A1PersonaId)});
         A3LocalidadId = T00044_A3LocalidadId[0] ;
         A57PersonaDireccion = T00044_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A66PersonaTelefono = T00044_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A55PersonaNombre = T00044_A55PersonaNombre[0] ;
         A56PersonaApellido = T00044_A56PersonaApellido[0] ;
         pr_default.close(2);
         /* Using cursor T00045 */
         pr_default.execute(3, new Object[] {Long.valueOf(A3LocalidadId)});
         A7CiudadId = T00045_A7CiudadId[0] ;
         A64LocalidadNombre = T00045_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         pr_default.close(3);
         /* Using cursor T00046 */
         pr_default.execute(4, new Object[] {Long.valueOf(A7CiudadId)});
         A6DepartamentoId = T00046_A6DepartamentoId[0] ;
         A62CiudadNombre = T00046_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         pr_default.close(4);
         /* Using cursor T00047 */
         pr_default.execute(5, new Object[] {Long.valueOf(A6DepartamentoId)});
         A61DepartamentoNombre = T00047_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         pr_default.close(5);
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      }
   }

   public void load043( )
   {
      /* Using cursor T00048 */
      pr_default.execute(6, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A3LocalidadId = T00048_A3LocalidadId[0] ;
         A7CiudadId = T00048_A7CiudadId[0] ;
         A6DepartamentoId = T00048_A6DepartamentoId[0] ;
         A57PersonaDireccion = T00048_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A66PersonaTelefono = T00048_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A64LocalidadNombre = T00048_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         A62CiudadNombre = T00048_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         A61DepartamentoNombre = T00048_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         A244ClienteUser = T00048_A244ClienteUser[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A244ClienteUser", A244ClienteUser);
         A55PersonaNombre = T00048_A55PersonaNombre[0] ;
         A56PersonaApellido = T00048_A56PersonaApellido[0] ;
         A1PersonaId = T00048_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         zm043( -10) ;
      }
      pr_default.close(6);
      onLoadActions043( ) ;
   }

   public void onLoadActions043( )
   {
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
   }

   public void checkExtendedTable043( )
   {
      nIsDirty_3 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00044 */
      pr_default.execute(2, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A3LocalidadId = T00044_A3LocalidadId[0] ;
      A57PersonaDireccion = T00044_A57PersonaDireccion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A66PersonaTelefono = T00044_A66PersonaTelefono[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A55PersonaNombre = T00044_A55PersonaNombre[0] ;
      A56PersonaApellido = T00044_A56PersonaApellido[0] ;
      pr_default.close(2);
      /* Using cursor T00045 */
      pr_default.execute(3, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCALIDADID");
         AnyError = (short)(1) ;
      }
      A7CiudadId = T00045_A7CiudadId[0] ;
      A64LocalidadNombre = T00045_A64LocalidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
      pr_default.close(3);
      /* Using cursor T00046 */
      pr_default.execute(4, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
      }
      A6DepartamentoId = T00046_A6DepartamentoId[0] ;
      A62CiudadNombre = T00046_A62CiudadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      pr_default.close(4);
      /* Using cursor T00047 */
      pr_default.execute(5, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A61DepartamentoNombre = T00047_A61DepartamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      pr_default.close(5);
      nIsDirty_3 = (short)(1) ;
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
   }

   public void closeExtendedTableCursors043( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( long A1PersonaId )
   {
      /* Using cursor T00049 */
      pr_default.execute(7, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A3LocalidadId = T00049_A3LocalidadId[0] ;
      A57PersonaDireccion = T00049_A57PersonaDireccion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A66PersonaTelefono = T00049_A66PersonaTelefono[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A55PersonaNombre = T00049_A55PersonaNombre[0] ;
      A56PersonaApellido = T00049_A56PersonaApellido[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3LocalidadId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A57PersonaDireccion)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A66PersonaTelefono))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A55PersonaNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A56PersonaApellido))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_12( long A3LocalidadId )
   {
      /* Using cursor T000410 */
      pr_default.execute(8, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCALIDADID");
         AnyError = (short)(1) ;
      }
      A7CiudadId = T000410_A7CiudadId[0] ;
      A64LocalidadNombre = T000410_A64LocalidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A7CiudadId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A64LocalidadNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void gxload_13( long A7CiudadId )
   {
      /* Using cursor T000411 */
      pr_default.execute(9, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
      }
      A6DepartamentoId = T000411_A6DepartamentoId[0] ;
      A62CiudadNombre = T000411_A62CiudadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A62CiudadNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_14( long A6DepartamentoId )
   {
      /* Using cursor T000412 */
      pr_default.execute(10, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A61DepartamentoNombre = T000412_A61DepartamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A61DepartamentoNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void getKey043( )
   {
      /* Using cursor T000413 */
      pr_default.execute(11, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(11);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00043 */
      pr_default.execute(1, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm043( 10) ;
         RcdFound3 = (short)(1) ;
         A4ClienteId = T00043_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A244ClienteUser = T00043_A244ClienteUser[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A244ClienteUser", A244ClienteUser);
         A1PersonaId = T00043_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         Z4ClienteId = A4ClienteId ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load043( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey043( ) ;
         }
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey043( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey043( ) ;
      if ( RcdFound3 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T000414 */
      pr_default.execute(12, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         while ( (pr_default.getStatus(12) != 101) && ( ( T000414_A4ClienteId[0] < A4ClienteId ) ) )
         {
            pr_default.readNext(12);
         }
         if ( (pr_default.getStatus(12) != 101) && ( ( T000414_A4ClienteId[0] > A4ClienteId ) ) )
         {
            A4ClienteId = T000414_A4ClienteId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(12);
   }

   public void move_previous( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T000415 */
      pr_default.execute(13, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T000415_A4ClienteId[0] > A4ClienteId ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T000415_A4ClienteId[0] < A4ClienteId ) ) )
         {
            A4ClienteId = T000415_A4ClienteId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey043( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert043( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( A4ClienteId != Z4ClienteId )
            {
               A4ClienteId = Z4ClienteId ;
               httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLIENTEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtClienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtClienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update043( ) ;
               GX_FocusControl = edtClienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A4ClienteId != Z4ClienteId )
            {
               /* Insert record */
               GX_FocusControl = edtClienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert043( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLIENTEID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtClienteId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtClienteId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert043( ) ;
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
      if ( A4ClienteId != Z4ClienteId )
      {
         A4ClienteId = Z4ClienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency043( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00042 */
         pr_default.execute(0, new Object[] {Long.valueOf(A4ClienteId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z244ClienteUser, T00042_A244ClienteUser[0]) != 0 ) || ( Z1PersonaId != T00042_A1PersonaId[0] ) )
         {
            if ( GXutil.strcmp(Z244ClienteUser, T00042_A244ClienteUser[0]) != 0 )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"ClienteUser");
               GXutil.writeLogRaw("Old: ",Z244ClienteUser);
               GXutil.writeLogRaw("Current: ",T00042_A244ClienteUser[0]);
            }
            if ( Z1PersonaId != T00042_A1PersonaId[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"PersonaId");
               GXutil.writeLogRaw("Old: ",Z1PersonaId);
               GXutil.writeLogRaw("Current: ",T00042_A1PersonaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Cliente"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert043( )
   {
      if ( ! IsAuthorized("cliente_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate043( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable043( ) ;
      }
      if ( AnyError == 0 )
      {
         zm043( 0) ;
         checkOptimisticConcurrency043( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm043( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert043( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000416 */
                  pr_default.execute(14, new Object[] {Long.valueOf(A4ClienteId), A244ClienteUser, Long.valueOf(A1PersonaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
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
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption040( ) ;
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
            load043( ) ;
         }
         endLevel043( ) ;
      }
      closeExtendedTableCursors043( ) ;
   }

   public void update043( )
   {
      if ( ! IsAuthorized("cliente_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate043( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable043( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency043( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm043( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate043( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000417 */
                  pr_default.execute(15, new Object[] {A244ClienteUser, Long.valueOf(A1PersonaId), Long.valueOf(A4ClienteId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
                  if ( (pr_default.getStatus(15) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate043( ) ;
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
         endLevel043( ) ;
      }
      closeExtendedTableCursors043( ) ;
   }

   public void deferredUpdate043( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("cliente_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate043( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency043( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls043( ) ;
         afterConfirm043( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete043( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000418 */
               pr_default.execute(16, new Object[] {Long.valueOf(A4ClienteId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
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
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel043( ) ;
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls043( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000419 */
         pr_default.execute(17, new Object[] {Long.valueOf(A1PersonaId)});
         A3LocalidadId = T000419_A3LocalidadId[0] ;
         A57PersonaDireccion = T000419_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A66PersonaTelefono = T000419_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A55PersonaNombre = T000419_A55PersonaNombre[0] ;
         A56PersonaApellido = T000419_A56PersonaApellido[0] ;
         pr_default.close(17);
         /* Using cursor T000420 */
         pr_default.execute(18, new Object[] {Long.valueOf(A3LocalidadId)});
         A7CiudadId = T000420_A7CiudadId[0] ;
         A64LocalidadNombre = T000420_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         pr_default.close(18);
         /* Using cursor T000421 */
         pr_default.execute(19, new Object[] {Long.valueOf(A7CiudadId)});
         A6DepartamentoId = T000421_A6DepartamentoId[0] ;
         A62CiudadNombre = T000421_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         pr_default.close(19);
         /* Using cursor T000422 */
         pr_default.execute(20, new Object[] {Long.valueOf(A6DepartamentoId)});
         A61DepartamentoNombre = T000422_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         pr_default.close(20);
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000423 */
         pr_default.execute(21, new Object[] {Long.valueOf(A4ClienteId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Pedidos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T000424 */
         pr_default.execute(22, new Object[] {Long.valueOf(A4ClienteId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Factura", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T000425 */
         pr_default.execute(23, new Object[] {Long.valueOf(A4ClienteId)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Ventas", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
      }
   }

   public void endLevel043( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete043( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(17);
         pr_default.close(18);
         pr_default.close(19);
         pr_default.close(20);
         Application.commitDataStores(context, remoteHandle, pr_default, "cliente");
         if ( AnyError == 0 )
         {
            confirmValues040( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(17);
         pr_default.close(18);
         pr_default.close(19);
         pr_default.close(20);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "cliente");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart043( )
   {
      /* Scan By routine */
      /* Using cursor T000426 */
      pr_default.execute(24);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A4ClienteId = T000426_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext043( )
   {
      /* Scan next routine */
      pr_default.readNext(24);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A4ClienteId = T000426_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      }
   }

   public void scanEnd043( )
   {
      pr_default.close(24);
   }

   public void afterConfirm043( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert043( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate043( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete043( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete043( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate043( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes043( )
   {
      edtClienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      edtPersonaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      edtPersonaNombreCompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaNombreCompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaNombreCompleto_Enabled), 5, 0), true);
      edtPersonaDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaDireccion_Enabled), 5, 0), true);
      edtPersonaTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaTelefono_Enabled), 5, 0), true);
      edtLocalidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocalidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadNombre_Enabled), 5, 0), true);
      edtCiudadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCiudadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCiudadNombre_Enabled), 5, 0), true);
      edtDepartamentoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDepartamentoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDepartamentoNombre_Enabled), 5, 0), true);
      edtClienteUser_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteUser_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteUser_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes043( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues040( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.cliente", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ClienteId,11,0))}, new String[] {"Gx_mode","ClienteId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Cliente");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("cliente:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z4ClienteId", GXutil.ltrim( localUtil.ntoc( Z4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z244ClienteUser", GXutil.rtrim( Z244ClienteUser));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z1PersonaId", GXutil.ltrim( localUtil.ntoc( Z1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N1PersonaId", GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PERSONANOMBRE", GXutil.rtrim( A55PersonaNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PERSONAAPELLIDO", GXutil.rtrim( A56PersonaApellido));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCLIENTEID", GXutil.ltrim( localUtil.ntoc( AV7ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ClienteId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PERSONAID", GXutil.ltrim( localUtil.ntoc( AV13Insert_PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "LOCALIDADID", GXutil.ltrim( localUtil.ntoc( A3LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "CIUDADID", GXutil.ltrim( localUtil.ntoc( A7CiudadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DEPARTAMENTOID", GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.cliente", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ClienteId,11,0))}, new String[] {"Gx_mode","ClienteId"})  ;
   }

   public String getPgmname( )
   {
      return "Cliente" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cliente", "") ;
   }

   public void initializeNonKey043( )
   {
      A6DepartamentoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6DepartamentoId), 11, 0));
      A7CiudadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
      A3LocalidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      A1PersonaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      A59PersonaNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      A57PersonaDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A66PersonaTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A64LocalidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
      A62CiudadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      A61DepartamentoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      A244ClienteUser = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A244ClienteUser", A244ClienteUser);
      A55PersonaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", A55PersonaNombre);
      A56PersonaApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", A56PersonaApellido);
      Z244ClienteUser = "" ;
      Z1PersonaId = 0 ;
   }

   public void initAll043( )
   {
      A4ClienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      initializeNonKey043( ) ;
   }

   public void standaloneModalInsert( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024121119839", true, true);
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
      httpContext.AddJavascriptSource("cliente.js", "?2024121119839", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtPersonaId_Internalname = "PERSONAID" ;
      edtPersonaNombreCompleto_Internalname = "PERSONANOMBRECOMPLETO" ;
      edtPersonaDireccion_Internalname = "PERSONADIRECCION" ;
      edtPersonaTelefono_Internalname = "PERSONATELEFONO" ;
      edtLocalidadNombre_Internalname = "LOCALIDADNOMBRE" ;
      edtCiudadNombre_Internalname = "CIUDADNOMBRE" ;
      edtDepartamentoNombre_Internalname = "DEPARTAMENTONOMBRE" ;
      edtClienteUser_Internalname = "CLIENTEUSER" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_1_Internalname = "PROMPT_1" ;
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
      Form.setCaption( httpContext.getMessage( "Cliente", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtClienteUser_Jsonclick = "" ;
      edtClienteUser_Enabled = 1 ;
      edtDepartamentoNombre_Jsonclick = "" ;
      edtDepartamentoNombre_Enabled = 0 ;
      edtCiudadNombre_Jsonclick = "" ;
      edtCiudadNombre_Enabled = 0 ;
      edtLocalidadNombre_Jsonclick = "" ;
      edtLocalidadNombre_Enabled = 0 ;
      edtPersonaTelefono_Jsonclick = "" ;
      edtPersonaTelefono_Enabled = 0 ;
      edtPersonaDireccion_Enabled = 0 ;
      edtPersonaNombreCompleto_Jsonclick = "" ;
      edtPersonaNombreCompleto_Enabled = 0 ;
      imgprompt_1_Visible = 1 ;
      imgprompt_1_Link = "" ;
      edtPersonaId_Jsonclick = "" ;
      edtPersonaId_Enabled = 1 ;
      edtClienteId_Jsonclick = "" ;
      edtClienteId_Enabled = 1 ;
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

   public void gx4asaclienteid043( long AV7ClienteId ,
                                   String AV15Pgmname )
   {
      if ( ! (0==AV7ClienteId) )
      {
         A4ClienteId = AV7ClienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A4ClienteId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV15Pgmname), GXv_int3) ;
            cliente_impl.this.GXt_int2 = GXv_int3[0] ;
            A4ClienteId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
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

   public void valid_Personaid( )
   {
      /* Using cursor T000419 */
      pr_default.execute(17, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
      }
      A3LocalidadId = T000419_A3LocalidadId[0] ;
      A57PersonaDireccion = T000419_A57PersonaDireccion[0] ;
      A66PersonaTelefono = T000419_A66PersonaTelefono[0] ;
      A55PersonaNombre = T000419_A55PersonaNombre[0] ;
      A56PersonaApellido = T000419_A56PersonaApellido[0] ;
      pr_default.close(17);
      /* Using cursor T000420 */
      pr_default.execute(18, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCALIDADID");
         AnyError = (short)(1) ;
      }
      A7CiudadId = T000420_A7CiudadId[0] ;
      A64LocalidadNombre = T000420_A64LocalidadNombre[0] ;
      pr_default.close(18);
      /* Using cursor T000421 */
      pr_default.execute(19, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
      }
      A6DepartamentoId = T000421_A6DepartamentoId[0] ;
      A62CiudadNombre = T000421_A62CiudadNombre[0] ;
      pr_default.close(19);
      /* Using cursor T000422 */
      pr_default.execute(20, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A61DepartamentoNombre = T000422_A61DepartamentoNombre[0] ;
      pr_default.close(20);
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrim( localUtil.ntoc( A3LocalidadId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", GXutil.rtrim( A66PersonaTelefono));
      httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", GXutil.rtrim( A55PersonaNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", GXutil.rtrim( A56PersonaApellido));
      httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrim( localUtil.ntoc( A7CiudadId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", GXutil.rtrim( A64LocalidadNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", GXutil.rtrim( A62CiudadNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", GXutil.rtrim( A61DepartamentoNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", GXutil.rtrim( A59PersonaNombreCompleto));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12042',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLIENTEID","{handler:'valid_Clienteid',iparms:[]");
      setEventMetadata("VALID_CLIENTEID",",oparms:[]}");
      setEventMetadata("VALID_PERSONAID","{handler:'valid_Personaid',iparms:[{av:'A1PersonaId',fld:'PERSONAID',pic:'ZZZZZZZZZZ9'},{av:'A3LocalidadId',fld:'LOCALIDADID',pic:'ZZZZZZZZZZ9'},{av:'A7CiudadId',fld:'CIUDADID',pic:'ZZZZZZZZZZ9'},{av:'A6DepartamentoId',fld:'DEPARTAMENTOID',pic:'ZZZZZZZZZZ9'},{av:'A55PersonaNombre',fld:'PERSONANOMBRE',pic:''},{av:'A56PersonaApellido',fld:'PERSONAAPELLIDO',pic:''},{av:'A57PersonaDireccion',fld:'PERSONADIRECCION',pic:''},{av:'A66PersonaTelefono',fld:'PERSONATELEFONO',pic:''},{av:'A64LocalidadNombre',fld:'LOCALIDADNOMBRE',pic:''},{av:'A62CiudadNombre',fld:'CIUDADNOMBRE',pic:''},{av:'A61DepartamentoNombre',fld:'DEPARTAMENTONOMBRE',pic:''},{av:'A59PersonaNombreCompleto',fld:'PERSONANOMBRECOMPLETO',pic:''}]");
      setEventMetadata("VALID_PERSONAID",",oparms:[{av:'A3LocalidadId',fld:'LOCALIDADID',pic:'ZZZZZZZZZZ9'},{av:'A57PersonaDireccion',fld:'PERSONADIRECCION',pic:''},{av:'A66PersonaTelefono',fld:'PERSONATELEFONO',pic:''},{av:'A55PersonaNombre',fld:'PERSONANOMBRE',pic:''},{av:'A56PersonaApellido',fld:'PERSONAAPELLIDO',pic:''},{av:'A7CiudadId',fld:'CIUDADID',pic:'ZZZZZZZZZZ9'},{av:'A64LocalidadNombre',fld:'LOCALIDADNOMBRE',pic:''},{av:'A6DepartamentoId',fld:'DEPARTAMENTOID',pic:'ZZZZZZZZZZ9'},{av:'A62CiudadNombre',fld:'CIUDADNOMBRE',pic:''},{av:'A61DepartamentoNombre',fld:'DEPARTAMENTONOMBRE',pic:''},{av:'A59PersonaNombreCompleto',fld:'PERSONANOMBRECOMPLETO',pic:''}]}");
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
      return "cliente_Execute";
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
      pr_default.close(17);
      pr_default.close(18);
      pr_default.close(19);
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z244ClienteUser = "" ;
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
      imgprompt_1_gximage = "" ;
      sImgUrl = "" ;
      A59PersonaNombreCompleto = "" ;
      A57PersonaDireccion = "" ;
      A66PersonaTelefono = "" ;
      A64LocalidadNombre = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A244ClienteUser = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A55PersonaNombre = "" ;
      A56PersonaApellido = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode3 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z57PersonaDireccion = "" ;
      Z66PersonaTelefono = "" ;
      Z55PersonaNombre = "" ;
      Z56PersonaApellido = "" ;
      Z64LocalidadNombre = "" ;
      Z62CiudadNombre = "" ;
      Z61DepartamentoNombre = "" ;
      T00044_A3LocalidadId = new long[1] ;
      T00044_A57PersonaDireccion = new String[] {""} ;
      T00044_A66PersonaTelefono = new String[] {""} ;
      T00044_A55PersonaNombre = new String[] {""} ;
      T00044_A56PersonaApellido = new String[] {""} ;
      T00045_A7CiudadId = new long[1] ;
      T00045_A64LocalidadNombre = new String[] {""} ;
      T00046_A6DepartamentoId = new long[1] ;
      T00046_A62CiudadNombre = new String[] {""} ;
      T00047_A61DepartamentoNombre = new String[] {""} ;
      T00048_A3LocalidadId = new long[1] ;
      T00048_A7CiudadId = new long[1] ;
      T00048_A6DepartamentoId = new long[1] ;
      T00048_A4ClienteId = new long[1] ;
      T00048_A57PersonaDireccion = new String[] {""} ;
      T00048_A66PersonaTelefono = new String[] {""} ;
      T00048_A64LocalidadNombre = new String[] {""} ;
      T00048_A62CiudadNombre = new String[] {""} ;
      T00048_A61DepartamentoNombre = new String[] {""} ;
      T00048_A244ClienteUser = new String[] {""} ;
      T00048_A55PersonaNombre = new String[] {""} ;
      T00048_A56PersonaApellido = new String[] {""} ;
      T00048_A1PersonaId = new long[1] ;
      T00049_A3LocalidadId = new long[1] ;
      T00049_A57PersonaDireccion = new String[] {""} ;
      T00049_A66PersonaTelefono = new String[] {""} ;
      T00049_A55PersonaNombre = new String[] {""} ;
      T00049_A56PersonaApellido = new String[] {""} ;
      T000410_A7CiudadId = new long[1] ;
      T000410_A64LocalidadNombre = new String[] {""} ;
      T000411_A6DepartamentoId = new long[1] ;
      T000411_A62CiudadNombre = new String[] {""} ;
      T000412_A61DepartamentoNombre = new String[] {""} ;
      T000413_A4ClienteId = new long[1] ;
      T00043_A4ClienteId = new long[1] ;
      T00043_A244ClienteUser = new String[] {""} ;
      T00043_A1PersonaId = new long[1] ;
      T000414_A4ClienteId = new long[1] ;
      T000415_A4ClienteId = new long[1] ;
      T00042_A4ClienteId = new long[1] ;
      T00042_A244ClienteUser = new String[] {""} ;
      T00042_A1PersonaId = new long[1] ;
      T000419_A3LocalidadId = new long[1] ;
      T000419_A57PersonaDireccion = new String[] {""} ;
      T000419_A66PersonaTelefono = new String[] {""} ;
      T000419_A55PersonaNombre = new String[] {""} ;
      T000419_A56PersonaApellido = new String[] {""} ;
      T000420_A7CiudadId = new long[1] ;
      T000420_A64LocalidadNombre = new String[] {""} ;
      T000421_A6DepartamentoId = new long[1] ;
      T000421_A62CiudadNombre = new String[] {""} ;
      T000422_A61DepartamentoNombre = new String[] {""} ;
      T000423_A51PedidosID = new long[1] ;
      T000424_A30FacturaId = new long[1] ;
      T000425_A19VentasId = new long[1] ;
      T000426_A4ClienteId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int3 = new long[1] ;
      Z59PersonaNombreCompleto = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.cliente__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.cliente__default(),
         new Object[] {
             new Object[] {
            T00042_A4ClienteId, T00042_A244ClienteUser, T00042_A1PersonaId
            }
            , new Object[] {
            T00043_A4ClienteId, T00043_A244ClienteUser, T00043_A1PersonaId
            }
            , new Object[] {
            T00044_A3LocalidadId, T00044_A57PersonaDireccion, T00044_A66PersonaTelefono, T00044_A55PersonaNombre, T00044_A56PersonaApellido
            }
            , new Object[] {
            T00045_A7CiudadId, T00045_A64LocalidadNombre
            }
            , new Object[] {
            T00046_A6DepartamentoId, T00046_A62CiudadNombre
            }
            , new Object[] {
            T00047_A61DepartamentoNombre
            }
            , new Object[] {
            T00048_A3LocalidadId, T00048_A7CiudadId, T00048_A6DepartamentoId, T00048_A4ClienteId, T00048_A57PersonaDireccion, T00048_A66PersonaTelefono, T00048_A64LocalidadNombre, T00048_A62CiudadNombre, T00048_A61DepartamentoNombre, T00048_A244ClienteUser,
            T00048_A55PersonaNombre, T00048_A56PersonaApellido, T00048_A1PersonaId
            }
            , new Object[] {
            T00049_A3LocalidadId, T00049_A57PersonaDireccion, T00049_A66PersonaTelefono, T00049_A55PersonaNombre, T00049_A56PersonaApellido
            }
            , new Object[] {
            T000410_A7CiudadId, T000410_A64LocalidadNombre
            }
            , new Object[] {
            T000411_A6DepartamentoId, T000411_A62CiudadNombre
            }
            , new Object[] {
            T000412_A61DepartamentoNombre
            }
            , new Object[] {
            T000413_A4ClienteId
            }
            , new Object[] {
            T000414_A4ClienteId
            }
            , new Object[] {
            T000415_A4ClienteId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000419_A3LocalidadId, T000419_A57PersonaDireccion, T000419_A66PersonaTelefono, T000419_A55PersonaNombre, T000419_A56PersonaApellido
            }
            , new Object[] {
            T000420_A7CiudadId, T000420_A64LocalidadNombre
            }
            , new Object[] {
            T000421_A6DepartamentoId, T000421_A62CiudadNombre
            }
            , new Object[] {
            T000422_A61DepartamentoNombre
            }
            , new Object[] {
            T000423_A51PedidosID
            }
            , new Object[] {
            T000424_A30FacturaId
            }
            , new Object[] {
            T000425_A19VentasId
            }
            , new Object[] {
            T000426_A4ClienteId
            }
         }
      );
      AV15Pgmname = "Cliente" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private int trnEnded ;
   private int edtClienteId_Enabled ;
   private int edtPersonaId_Enabled ;
   private int imgprompt_1_Visible ;
   private int edtPersonaNombreCompleto_Enabled ;
   private int edtPersonaDireccion_Enabled ;
   private int edtPersonaTelefono_Enabled ;
   private int edtLocalidadNombre_Enabled ;
   private int edtCiudadNombre_Enabled ;
   private int edtDepartamentoNombre_Enabled ;
   private int edtClienteUser_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV16GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7ClienteId ;
   private long Z4ClienteId ;
   private long Z1PersonaId ;
   private long N1PersonaId ;
   private long AV7ClienteId ;
   private long A1PersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private long A4ClienteId ;
   private long AV13Insert_PersonaId ;
   private long Z3LocalidadId ;
   private long Z7CiudadId ;
   private long Z6DepartamentoId ;
   private long GXt_int2 ;
   private long GXv_int3[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z244ClienteUser ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV15Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtClienteId_Internalname ;
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
   private String edtClienteId_Jsonclick ;
   private String edtPersonaId_Internalname ;
   private String edtPersonaId_Jsonclick ;
   private String imgprompt_1_gximage ;
   private String sImgUrl ;
   private String imgprompt_1_Internalname ;
   private String imgprompt_1_Link ;
   private String edtPersonaNombreCompleto_Internalname ;
   private String A59PersonaNombreCompleto ;
   private String edtPersonaNombreCompleto_Jsonclick ;
   private String edtPersonaDireccion_Internalname ;
   private String edtPersonaTelefono_Internalname ;
   private String A66PersonaTelefono ;
   private String edtPersonaTelefono_Jsonclick ;
   private String edtLocalidadNombre_Internalname ;
   private String A64LocalidadNombre ;
   private String edtLocalidadNombre_Jsonclick ;
   private String edtCiudadNombre_Internalname ;
   private String A62CiudadNombre ;
   private String edtCiudadNombre_Jsonclick ;
   private String edtDepartamentoNombre_Internalname ;
   private String A61DepartamentoNombre ;
   private String edtDepartamentoNombre_Jsonclick ;
   private String edtClienteUser_Internalname ;
   private String A244ClienteUser ;
   private String edtClienteUser_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String A55PersonaNombre ;
   private String A56PersonaApellido ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode3 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z66PersonaTelefono ;
   private String Z55PersonaNombre ;
   private String Z56PersonaApellido ;
   private String Z64LocalidadNombre ;
   private String Z62CiudadNombre ;
   private String Z61DepartamentoNombre ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String Z59PersonaNombreCompleto ;
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
   private String A57PersonaDireccion ;
   private String Z57PersonaDireccion ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T00044_A3LocalidadId ;
   private String[] T00044_A57PersonaDireccion ;
   private String[] T00044_A66PersonaTelefono ;
   private String[] T00044_A55PersonaNombre ;
   private String[] T00044_A56PersonaApellido ;
   private long[] T00045_A7CiudadId ;
   private String[] T00045_A64LocalidadNombre ;
   private long[] T00046_A6DepartamentoId ;
   private String[] T00046_A62CiudadNombre ;
   private String[] T00047_A61DepartamentoNombre ;
   private long[] T00048_A3LocalidadId ;
   private long[] T00048_A7CiudadId ;
   private long[] T00048_A6DepartamentoId ;
   private long[] T00048_A4ClienteId ;
   private String[] T00048_A57PersonaDireccion ;
   private String[] T00048_A66PersonaTelefono ;
   private String[] T00048_A64LocalidadNombre ;
   private String[] T00048_A62CiudadNombre ;
   private String[] T00048_A61DepartamentoNombre ;
   private String[] T00048_A244ClienteUser ;
   private String[] T00048_A55PersonaNombre ;
   private String[] T00048_A56PersonaApellido ;
   private long[] T00048_A1PersonaId ;
   private long[] T00049_A3LocalidadId ;
   private String[] T00049_A57PersonaDireccion ;
   private String[] T00049_A66PersonaTelefono ;
   private String[] T00049_A55PersonaNombre ;
   private String[] T00049_A56PersonaApellido ;
   private long[] T000410_A7CiudadId ;
   private String[] T000410_A64LocalidadNombre ;
   private long[] T000411_A6DepartamentoId ;
   private String[] T000411_A62CiudadNombre ;
   private String[] T000412_A61DepartamentoNombre ;
   private long[] T000413_A4ClienteId ;
   private long[] T00043_A4ClienteId ;
   private String[] T00043_A244ClienteUser ;
   private long[] T00043_A1PersonaId ;
   private long[] T000414_A4ClienteId ;
   private long[] T000415_A4ClienteId ;
   private long[] T00042_A4ClienteId ;
   private String[] T00042_A244ClienteUser ;
   private long[] T00042_A1PersonaId ;
   private long[] T000419_A3LocalidadId ;
   private String[] T000419_A57PersonaDireccion ;
   private String[] T000419_A66PersonaTelefono ;
   private String[] T000419_A55PersonaNombre ;
   private String[] T000419_A56PersonaApellido ;
   private long[] T000420_A7CiudadId ;
   private String[] T000420_A64LocalidadNombre ;
   private long[] T000421_A6DepartamentoId ;
   private String[] T000421_A62CiudadNombre ;
   private String[] T000422_A61DepartamentoNombre ;
   private long[] T000423_A51PedidosID ;
   private long[] T000424_A30FacturaId ;
   private long[] T000425_A19VentasId ;
   private long[] T000426_A4ClienteId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class cliente__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class cliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00042", "SELECT [ClienteId], [ClienteUser], [PersonaId] FROM [Cliente] WITH (UPDLOCK) WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00043", "SELECT [ClienteId], [ClienteUser], [PersonaId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00044", "SELECT [LocalidadId], [PersonaDireccion], [PersonaTelefono], [PersonaNombre], [PersonaApellido] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00045", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00046", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00047", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00048", "SELECT T2.[LocalidadId], T3.[CiudadId], T4.[DepartamentoId], TM1.[ClienteId], T2.[PersonaDireccion], T2.[PersonaTelefono], T3.[LocalidadNombre], T4.[CiudadNombre], T5.[DepartamentoNombre], TM1.[ClienteUser], T2.[PersonaNombre], T2.[PersonaApellido], TM1.[PersonaId] FROM (((([Cliente] TM1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = TM1.[PersonaId]) INNER JOIN [Localidad] T3 ON T3.[LocalidadId] = T2.[LocalidadId]) INNER JOIN [Ciudad] T4 ON T4.[CiudadId] = T3.[CiudadId]) INNER JOIN [Departamento] T5 ON T5.[DepartamentoId] = T4.[DepartamentoId]) WHERE TM1.[ClienteId] = ? ORDER BY TM1.[ClienteId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00049", "SELECT [LocalidadId], [PersonaDireccion], [PersonaTelefono], [PersonaNombre], [PersonaApellido] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000410", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000411", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000412", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000413", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000414", "SELECT TOP 1 [ClienteId] FROM [Cliente] WHERE ( [ClienteId] > ?) ORDER BY [ClienteId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000415", "SELECT TOP 1 [ClienteId] FROM [Cliente] WHERE ( [ClienteId] < ?) ORDER BY [ClienteId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000416", "INSERT INTO [Cliente]([ClienteId], [ClienteUser], [PersonaId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000417", "UPDATE [Cliente] SET [ClienteUser]=?, [PersonaId]=?  WHERE [ClienteId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000418", "DELETE FROM [Cliente]  WHERE [ClienteId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000419", "SELECT [LocalidadId], [PersonaDireccion], [PersonaTelefono], [PersonaNombre], [PersonaApellido] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000420", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000421", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000422", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000423", "SELECT TOP 1 [PedidosID] FROM [Pedidos] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000424", "SELECT TOP 1 [FacturaId] FROM [Factura] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000425", "SELECT TOP 1 [VentasId] FROM [Ventas] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000426", "SELECT [ClienteId] FROM [Cliente] ORDER BY [ClienteId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 25);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 25);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((String[]) buf[7])[0] = rslt.getString(8, 80);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getString(11, 80);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 25);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
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
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 25);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 19 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 21 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 23 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 24 :
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
      }
   }

}

