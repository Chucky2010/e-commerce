package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class persona_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"TIPOPERSONAID") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlatipopersonaid011( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"PERSONAID") == 0 )
      {
         AV7PersonaId = GXutil.lval( httpContext.GetPar( "PersonaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PersonaId), 11, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERSONAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PersonaId), "ZZZZZZZZZZ9")));
         AV16Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asapersonaid011( AV7PersonaId, AV16Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A2TipoPersonaId = GXutil.lval( httpContext.GetPar( "TipoPersonaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A2TipoPersonaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A3LocalidadId = GXutil.lval( httpContext.GetPar( "LocalidadId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A3LocalidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A7CiudadId = GXutil.lval( httpContext.GetPar( "CiudadId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A7CiudadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A6DepartamentoId = GXutil.lval( httpContext.GetPar( "DepartamentoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6DepartamentoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A6DepartamentoId) ;
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
            AV7PersonaId = GXutil.lval( httpContext.GetPar( "PersonaId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PersonaId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERSONAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PersonaId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Persona", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public persona_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public persona_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( persona_impl.class ));
   }

   public persona_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynTipoPersonaId = new HTMLChoice();
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
      if ( dynTipoPersonaId.getItemCount() > 0 )
      {
         A2TipoPersonaId = GXutil.lval( dynTipoPersonaId.getValidValue(GXutil.trim( GXutil.str( A2TipoPersonaId, 11, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTipoPersonaId.setValue( GXutil.trim( GXutil.str( A2TipoPersonaId, 11, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoPersonaId.getInternalname(), "Values", dynTipoPersonaId.ToJavascriptSource(), true);
      }
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Persona", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Persona.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaId_Internalname, httpContext.getMessage( "Persona Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaId_Internalname, GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1PersonaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTipoPersonaId.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, dynTipoPersonaId.getInternalname(), httpContext.getMessage( "Tipo Persona Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, dynTipoPersonaId, dynTipoPersonaId.getInternalname(), GXutil.trim( GXutil.str( A2TipoPersonaId, 11, 0)), 1, dynTipoPersonaId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynTipoPersonaId.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "", true, (byte)(0), "HLP_Persona.htm");
      dynTipoPersonaId.setValue( GXutil.trim( GXutil.str( A2TipoPersonaId, 11, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynTipoPersonaId.getInternalname(), "Values", dynTipoPersonaId.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaNombre_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaNombre_Internalname, GXutil.rtrim( A55PersonaNombre), GXutil.rtrim( localUtil.format( A55PersonaNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaApellido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaApellido_Internalname, httpContext.getMessage( "Apellido", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaApellido_Internalname, GXutil.rtrim( A56PersonaApellido), GXutil.rtrim( localUtil.format( A56PersonaApellido, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaApellido_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaApellido_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Apellido", "left", true, "", "HLP_Persona.htm");
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
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaNombreCompleto_Internalname, httpContext.getMessage( "Nombre Completo", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaNombreCompleto_Internalname, GXutil.rtrim( A59PersonaNombreCompleto), GXutil.rtrim( localUtil.format( A59PersonaNombreCompleto, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaNombreCompleto_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaDireccion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaDireccion_Internalname, httpContext.getMessage( "Direccion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtPersonaDireccion_Internalname, A57PersonaDireccion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", (short)(0), 1, edtPersonaDireccion_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "256", -1, 0, "", "", (byte)(-1), true, "Direccion", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLocalidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtLocalidadId_Internalname, httpContext.getMessage( "Localidad Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtLocalidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A3LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3LocalidadId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocalidadId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtLocalidadId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Persona.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_3_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_3_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_3_Internalname, sImgUrl, imgprompt_3_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_3_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Persona.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtLocalidadNombre_Internalname, GXutil.rtrim( A64LocalidadNombre), GXutil.rtrim( localUtil.format( A64LocalidadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocalidadNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtLocalidadNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Persona.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCiudadNombre_Internalname, GXutil.rtrim( A62CiudadNombre), GXutil.rtrim( localUtil.format( A62CiudadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCiudadNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCiudadNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Persona.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDepartamentoNombre_Internalname, GXutil.rtrim( A61DepartamentoNombre), GXutil.rtrim( localUtil.format( A61DepartamentoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDepartamentoNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtDepartamentoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaBarrio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaBarrio_Internalname, httpContext.getMessage( "Barrio", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaBarrio_Internalname, GXutil.rtrim( A65PersonaBarrio), GXutil.rtrim( localUtil.format( A65PersonaBarrio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaBarrio_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaBarrio_Enabled, 0, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Barrio", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaTelefono_Internalname, httpContext.getMessage( "Telefono", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaTelefono_Internalname, GXutil.rtrim( A66PersonaTelefono), GXutil.rtrim( localUtil.format( A66PersonaTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaTelefono_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaTelefono_Enabled, 0, "text", "", 25, "chr", 1, "row", 25, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Telefono", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaTelefono1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaTelefono1_Internalname, httpContext.getMessage( "Telefono1", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaTelefono1_Internalname, GXutil.rtrim( A67PersonaTelefono1), GXutil.rtrim( localUtil.format( A67PersonaTelefono1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaTelefono1_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaTelefono1_Enabled, 0, "text", "", 25, "chr", 1, "row", 25, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Telefono1", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaTelefono2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaTelefono2_Internalname, httpContext.getMessage( "Telefono2", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaTelefono2_Internalname, GXutil.rtrim( A68PersonaTelefono2), GXutil.rtrim( localUtil.format( A68PersonaTelefono2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaTelefono2_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaTelefono2_Enabled, 0, "text", "", 25, "chr", 1, "row", 25, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Telefono2", "left", true, "", "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPersonaCorreo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaCorreo_Internalname, httpContext.getMessage( "Correo", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaCorreo_Internalname, A69PersonaCorreo, GXutil.rtrim( localUtil.format( A69PersonaCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A69PersonaCorreo, "", "", "", edtPersonaCorreo_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Persona.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Persona.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Persona.htm");
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
      e11012 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z1PersonaId = localUtil.ctol( httpContext.cgiGet( "Z1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z55PersonaNombre = httpContext.cgiGet( "Z55PersonaNombre") ;
            Z56PersonaApellido = httpContext.cgiGet( "Z56PersonaApellido") ;
            Z57PersonaDireccion = httpContext.cgiGet( "Z57PersonaDireccion") ;
            Z63PersonaCI = localUtil.ctol( httpContext.cgiGet( "Z63PersonaCI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z65PersonaBarrio = httpContext.cgiGet( "Z65PersonaBarrio") ;
            Z66PersonaTelefono = httpContext.cgiGet( "Z66PersonaTelefono") ;
            Z67PersonaTelefono1 = httpContext.cgiGet( "Z67PersonaTelefono1") ;
            Z68PersonaTelefono2 = httpContext.cgiGet( "Z68PersonaTelefono2") ;
            Z69PersonaCorreo = httpContext.cgiGet( "Z69PersonaCorreo") ;
            Z2TipoPersonaId = localUtil.ctol( httpContext.cgiGet( "Z2TipoPersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z3LocalidadId = localUtil.ctol( httpContext.cgiGet( "Z3LocalidadId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A63PersonaCI = localUtil.ctol( httpContext.cgiGet( "Z63PersonaCI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N2TipoPersonaId = localUtil.ctol( httpContext.cgiGet( "N2TipoPersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N3LocalidadId = localUtil.ctol( httpContext.cgiGet( "N3LocalidadId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7PersonaId = localUtil.ctol( httpContext.cgiGet( "vPERSONAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_TipoPersonaId = localUtil.ctol( httpContext.cgiGet( "vINSERT_TIPOPERSONAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV14Insert_LocalidadId = localUtil.ctol( httpContext.cgiGet( "vINSERT_LOCALIDADID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A63PersonaCI = localUtil.ctol( httpContext.cgiGet( "PERSONACI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            dynTipoPersonaId.setValue( httpContext.cgiGet( dynTipoPersonaId.getInternalname()) );
            A2TipoPersonaId = GXutil.lval( httpContext.cgiGet( dynTipoPersonaId.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
            A55PersonaNombre = httpContext.cgiGet( edtPersonaNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", A55PersonaNombre);
            A56PersonaApellido = httpContext.cgiGet( edtPersonaApellido_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", A56PersonaApellido);
            A59PersonaNombreCompleto = httpContext.cgiGet( edtPersonaNombreCompleto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
            A57PersonaDireccion = httpContext.cgiGet( edtPersonaDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLocalidadId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLocalidadId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LOCALIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLocalidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3LocalidadId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
            }
            else
            {
               A3LocalidadId = localUtil.ctol( httpContext.cgiGet( edtLocalidadId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
            }
            A64LocalidadNombre = httpContext.cgiGet( edtLocalidadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
            A62CiudadNombre = httpContext.cgiGet( edtCiudadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
            A61DepartamentoNombre = httpContext.cgiGet( edtDepartamentoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
            A65PersonaBarrio = httpContext.cgiGet( edtPersonaBarrio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A65PersonaBarrio", A65PersonaBarrio);
            A66PersonaTelefono = httpContext.cgiGet( edtPersonaTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
            A67PersonaTelefono1 = httpContext.cgiGet( edtPersonaTelefono1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A67PersonaTelefono1", A67PersonaTelefono1);
            A68PersonaTelefono2 = httpContext.cgiGet( edtPersonaTelefono2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A68PersonaTelefono2", A68PersonaTelefono2);
            A69PersonaCorreo = httpContext.cgiGet( edtPersonaCorreo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Persona");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("PersonaCI", localUtil.format( DecimalUtil.doubleToDec(A63PersonaCI), "ZZZZZZZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1PersonaId != Z1PersonaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("persona:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1PersonaId = GXutil.lval( httpContext.GetPar( "PersonaId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
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
                  sMode1 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode1 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound1 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_010( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PERSONAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPersonaId_Internalname ;
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
                        e11012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12012 ();
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
         e12012 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll011( ) ;
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
         disableAttributes011( ) ;
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

   public void confirm_010( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls011( ) ;
         }
         else
         {
            checkExtendedTable011( ) ;
            closeExtendedTableCursors011( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption010( )
   {
   }

   public void e11012( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV16Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV17GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GXV1), 8, 0));
         while ( AV17GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV17GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoPersonaId") == 0 )
            {
               AV13Insert_TipoPersonaId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_TipoPersonaId), 11, 0));
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LocalidadId") == 0 )
            {
               AV14Insert_LocalidadId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_LocalidadId), 11, 0));
            }
            AV17GXV1 = (int)(AV17GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GXV1), 8, 0));
         }
      }
   }

   public void e12012( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.personaww", new String[] {}, new String[] {}) );
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

   public void zm011( int GX_JID )
   {
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z55PersonaNombre = T00013_A55PersonaNombre[0] ;
            Z56PersonaApellido = T00013_A56PersonaApellido[0] ;
            Z57PersonaDireccion = T00013_A57PersonaDireccion[0] ;
            Z63PersonaCI = T00013_A63PersonaCI[0] ;
            Z65PersonaBarrio = T00013_A65PersonaBarrio[0] ;
            Z66PersonaTelefono = T00013_A66PersonaTelefono[0] ;
            Z67PersonaTelefono1 = T00013_A67PersonaTelefono1[0] ;
            Z68PersonaTelefono2 = T00013_A68PersonaTelefono2[0] ;
            Z69PersonaCorreo = T00013_A69PersonaCorreo[0] ;
            Z2TipoPersonaId = T00013_A2TipoPersonaId[0] ;
            Z3LocalidadId = T00013_A3LocalidadId[0] ;
         }
         else
         {
            Z55PersonaNombre = A55PersonaNombre ;
            Z56PersonaApellido = A56PersonaApellido ;
            Z57PersonaDireccion = A57PersonaDireccion ;
            Z63PersonaCI = A63PersonaCI ;
            Z65PersonaBarrio = A65PersonaBarrio ;
            Z66PersonaTelefono = A66PersonaTelefono ;
            Z67PersonaTelefono1 = A67PersonaTelefono1 ;
            Z68PersonaTelefono2 = A68PersonaTelefono2 ;
            Z69PersonaCorreo = A69PersonaCorreo ;
            Z2TipoPersonaId = A2TipoPersonaId ;
            Z3LocalidadId = A3LocalidadId ;
         }
      }
      if ( GX_JID == -15 )
      {
         Z1PersonaId = A1PersonaId ;
         Z55PersonaNombre = A55PersonaNombre ;
         Z56PersonaApellido = A56PersonaApellido ;
         Z57PersonaDireccion = A57PersonaDireccion ;
         Z63PersonaCI = A63PersonaCI ;
         Z65PersonaBarrio = A65PersonaBarrio ;
         Z66PersonaTelefono = A66PersonaTelefono ;
         Z67PersonaTelefono1 = A67PersonaTelefono1 ;
         Z68PersonaTelefono2 = A68PersonaTelefono2 ;
         Z69PersonaCorreo = A69PersonaCorreo ;
         Z2TipoPersonaId = A2TipoPersonaId ;
         Z3LocalidadId = A3LocalidadId ;
         Z7CiudadId = A7CiudadId ;
         Z64LocalidadNombre = A64LocalidadNombre ;
         Z6DepartamentoId = A6DepartamentoId ;
         Z62CiudadNombre = A62CiudadNombre ;
         Z61DepartamentoNombre = A61DepartamentoNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      gxatipopersonaid_html011( ) ;
      AV16Pgmname = "Persona" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      imgprompt_3_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.localidadprompt"+"',["+"{Ctrl:gx.dom.el('"+"LOCALIDADID"+"'), id:'"+"LOCALIDADID"+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"LOCALIDADNOMBRE"+"'), id:'"+"LOCALIDADNOMBRE"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7PersonaId) )
      {
         A1PersonaId = AV7PersonaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A1PersonaId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int3) ;
            persona_impl.this.GXt_int2 = GXv_int3[0] ;
            A1PersonaId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         }
      }
      if ( ! (0==AV7PersonaId) )
      {
         edtPersonaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      }
      else
      {
         edtPersonaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7PersonaId) )
      {
         edtPersonaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoPersonaId) )
      {
         dynTipoPersonaId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoPersonaId.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoPersonaId.getEnabled(), 5, 0), true);
      }
      else
      {
         dynTipoPersonaId.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynTipoPersonaId.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoPersonaId.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_LocalidadId) )
      {
         edtLocalidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      }
      else
      {
         edtLocalidadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_LocalidadId) )
      {
         A3LocalidadId = AV14Insert_LocalidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoPersonaId) )
      {
         A2TipoPersonaId = AV13Insert_TipoPersonaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
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
         /* Using cursor T00015 */
         pr_default.execute(3, new Object[] {Long.valueOf(A3LocalidadId)});
         A7CiudadId = T00015_A7CiudadId[0] ;
         A64LocalidadNombre = T00015_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         pr_default.close(3);
         /* Using cursor T00016 */
         pr_default.execute(4, new Object[] {Long.valueOf(A7CiudadId)});
         A6DepartamentoId = T00016_A6DepartamentoId[0] ;
         A62CiudadNombre = T00016_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         pr_default.close(4);
         /* Using cursor T00017 */
         pr_default.execute(5, new Object[] {Long.valueOf(A6DepartamentoId)});
         A61DepartamentoNombre = T00017_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         pr_default.close(5);
      }
   }

   public void load011( )
   {
      /* Using cursor T00018 */
      pr_default.execute(6, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A7CiudadId = T00018_A7CiudadId[0] ;
         A6DepartamentoId = T00018_A6DepartamentoId[0] ;
         A55PersonaNombre = T00018_A55PersonaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", A55PersonaNombre);
         A56PersonaApellido = T00018_A56PersonaApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", A56PersonaApellido);
         A57PersonaDireccion = T00018_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A63PersonaCI = T00018_A63PersonaCI[0] ;
         A64LocalidadNombre = T00018_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         A62CiudadNombre = T00018_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         A61DepartamentoNombre = T00018_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         A65PersonaBarrio = T00018_A65PersonaBarrio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A65PersonaBarrio", A65PersonaBarrio);
         A66PersonaTelefono = T00018_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A67PersonaTelefono1 = T00018_A67PersonaTelefono1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67PersonaTelefono1", A67PersonaTelefono1);
         A68PersonaTelefono2 = T00018_A68PersonaTelefono2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68PersonaTelefono2", A68PersonaTelefono2);
         A69PersonaCorreo = T00018_A69PersonaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
         A2TipoPersonaId = T00018_A2TipoPersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
         A3LocalidadId = T00018_A3LocalidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
         zm011( -15) ;
      }
      pr_default.close(6);
      onLoadActions011( ) ;
   }

   public void onLoadActions011( )
   {
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
   }

   public void checkExtendedTable011( )
   {
      nIsDirty_1 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00014 */
      pr_default.execute(2, new Object[] {Long.valueOf(A2TipoPersonaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoPersonaId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      nIsDirty_1 = (short)(1) ;
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      /* Using cursor T00015 */
      pr_default.execute(3, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLocalidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A7CiudadId = T00015_A7CiudadId[0] ;
      A64LocalidadNombre = T00015_A64LocalidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
      pr_default.close(3);
      /* Using cursor T00016 */
      pr_default.execute(4, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
      }
      A6DepartamentoId = T00016_A6DepartamentoId[0] ;
      A62CiudadNombre = T00016_A62CiudadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      pr_default.close(4);
      /* Using cursor T00017 */
      pr_default.execute(5, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A61DepartamentoNombre = T00017_A61DepartamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      pr_default.close(5);
      if ( ! ( GxRegex.IsMatch(A69PersonaCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Persona Correo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PERSONACORREO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaCorreo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors011( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
   }

   public void enableDisable( )
   {
   }

   public void gxload_16( long A2TipoPersonaId )
   {
      /* Using cursor T00019 */
      pr_default.execute(7, new Object[] {Long.valueOf(A2TipoPersonaId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoPersonaId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_17( long A3LocalidadId )
   {
      /* Using cursor T000110 */
      pr_default.execute(8, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLocalidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A7CiudadId = T000110_A7CiudadId[0] ;
      A64LocalidadNombre = T000110_A64LocalidadNombre[0] ;
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

   public void gxload_18( long A7CiudadId )
   {
      /* Using cursor T000111 */
      pr_default.execute(9, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
      }
      A6DepartamentoId = T000111_A6DepartamentoId[0] ;
      A62CiudadNombre = T000111_A62CiudadNombre[0] ;
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

   public void gxload_19( long A6DepartamentoId )
   {
      /* Using cursor T000112 */
      pr_default.execute(10, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A61DepartamentoNombre = T000112_A61DepartamentoNombre[0] ;
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

   public void getKey011( )
   {
      /* Using cursor T000113 */
      pr_default.execute(11, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound1 = (short)(1) ;
      }
      else
      {
         RcdFound1 = (short)(0) ;
      }
      pr_default.close(11);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00013 */
      pr_default.execute(1, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm011( 15) ;
         RcdFound1 = (short)(1) ;
         A1PersonaId = T00013_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         A55PersonaNombre = T00013_A55PersonaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", A55PersonaNombre);
         A56PersonaApellido = T00013_A56PersonaApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", A56PersonaApellido);
         A57PersonaDireccion = T00013_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A63PersonaCI = T00013_A63PersonaCI[0] ;
         A65PersonaBarrio = T00013_A65PersonaBarrio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A65PersonaBarrio", A65PersonaBarrio);
         A66PersonaTelefono = T00013_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A67PersonaTelefono1 = T00013_A67PersonaTelefono1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67PersonaTelefono1", A67PersonaTelefono1);
         A68PersonaTelefono2 = T00013_A68PersonaTelefono2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68PersonaTelefono2", A68PersonaTelefono2);
         A69PersonaCorreo = T00013_A69PersonaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
         A2TipoPersonaId = T00013_A2TipoPersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
         A3LocalidadId = T00013_A3LocalidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
         Z1PersonaId = A1PersonaId ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load011( ) ;
         if ( AnyError == 1 )
         {
            RcdFound1 = (short)(0) ;
            initializeNonKey011( ) ;
         }
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound1 = (short)(0) ;
         initializeNonKey011( ) ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey011( ) ;
      if ( RcdFound1 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T000114 */
      pr_default.execute(12, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         while ( (pr_default.getStatus(12) != 101) && ( ( T000114_A1PersonaId[0] < A1PersonaId ) ) )
         {
            pr_default.readNext(12);
         }
         if ( (pr_default.getStatus(12) != 101) && ( ( T000114_A1PersonaId[0] > A1PersonaId ) ) )
         {
            A1PersonaId = T000114_A1PersonaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(12);
   }

   public void move_previous( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T000115 */
      pr_default.execute(13, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T000115_A1PersonaId[0] > A1PersonaId ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T000115_A1PersonaId[0] < A1PersonaId ) ) )
         {
            A1PersonaId = T000115_A1PersonaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey011( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert011( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound1 == 1 )
         {
            if ( A1PersonaId != Z1PersonaId )
            {
               A1PersonaId = Z1PersonaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PERSONAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPersonaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPersonaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update011( ) ;
               GX_FocusControl = edtPersonaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1PersonaId != Z1PersonaId )
            {
               /* Insert record */
               GX_FocusControl = edtPersonaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert011( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PERSONAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPersonaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtPersonaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert011( ) ;
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
      if ( A1PersonaId != Z1PersonaId )
      {
         A1PersonaId = Z1PersonaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency011( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00012 */
         pr_default.execute(0, new Object[] {Long.valueOf(A1PersonaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Persona"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z55PersonaNombre, T00012_A55PersonaNombre[0]) != 0 ) || ( GXutil.strcmp(Z56PersonaApellido, T00012_A56PersonaApellido[0]) != 0 ) || ( GXutil.strcmp(Z57PersonaDireccion, T00012_A57PersonaDireccion[0]) != 0 ) || ( Z63PersonaCI != T00012_A63PersonaCI[0] ) || ( GXutil.strcmp(Z65PersonaBarrio, T00012_A65PersonaBarrio[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z66PersonaTelefono, T00012_A66PersonaTelefono[0]) != 0 ) || ( GXutil.strcmp(Z67PersonaTelefono1, T00012_A67PersonaTelefono1[0]) != 0 ) || ( GXutil.strcmp(Z68PersonaTelefono2, T00012_A68PersonaTelefono2[0]) != 0 ) || ( GXutil.strcmp(Z69PersonaCorreo, T00012_A69PersonaCorreo[0]) != 0 ) || ( Z2TipoPersonaId != T00012_A2TipoPersonaId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z3LocalidadId != T00012_A3LocalidadId[0] ) )
         {
            if ( GXutil.strcmp(Z55PersonaNombre, T00012_A55PersonaNombre[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaNombre");
               GXutil.writeLogRaw("Old: ",Z55PersonaNombre);
               GXutil.writeLogRaw("Current: ",T00012_A55PersonaNombre[0]);
            }
            if ( GXutil.strcmp(Z56PersonaApellido, T00012_A56PersonaApellido[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaApellido");
               GXutil.writeLogRaw("Old: ",Z56PersonaApellido);
               GXutil.writeLogRaw("Current: ",T00012_A56PersonaApellido[0]);
            }
            if ( GXutil.strcmp(Z57PersonaDireccion, T00012_A57PersonaDireccion[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaDireccion");
               GXutil.writeLogRaw("Old: ",Z57PersonaDireccion);
               GXutil.writeLogRaw("Current: ",T00012_A57PersonaDireccion[0]);
            }
            if ( Z63PersonaCI != T00012_A63PersonaCI[0] )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaCI");
               GXutil.writeLogRaw("Old: ",Z63PersonaCI);
               GXutil.writeLogRaw("Current: ",T00012_A63PersonaCI[0]);
            }
            if ( GXutil.strcmp(Z65PersonaBarrio, T00012_A65PersonaBarrio[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaBarrio");
               GXutil.writeLogRaw("Old: ",Z65PersonaBarrio);
               GXutil.writeLogRaw("Current: ",T00012_A65PersonaBarrio[0]);
            }
            if ( GXutil.strcmp(Z66PersonaTelefono, T00012_A66PersonaTelefono[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaTelefono");
               GXutil.writeLogRaw("Old: ",Z66PersonaTelefono);
               GXutil.writeLogRaw("Current: ",T00012_A66PersonaTelefono[0]);
            }
            if ( GXutil.strcmp(Z67PersonaTelefono1, T00012_A67PersonaTelefono1[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaTelefono1");
               GXutil.writeLogRaw("Old: ",Z67PersonaTelefono1);
               GXutil.writeLogRaw("Current: ",T00012_A67PersonaTelefono1[0]);
            }
            if ( GXutil.strcmp(Z68PersonaTelefono2, T00012_A68PersonaTelefono2[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaTelefono2");
               GXutil.writeLogRaw("Old: ",Z68PersonaTelefono2);
               GXutil.writeLogRaw("Current: ",T00012_A68PersonaTelefono2[0]);
            }
            if ( GXutil.strcmp(Z69PersonaCorreo, T00012_A69PersonaCorreo[0]) != 0 )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"PersonaCorreo");
               GXutil.writeLogRaw("Old: ",Z69PersonaCorreo);
               GXutil.writeLogRaw("Current: ",T00012_A69PersonaCorreo[0]);
            }
            if ( Z2TipoPersonaId != T00012_A2TipoPersonaId[0] )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"TipoPersonaId");
               GXutil.writeLogRaw("Old: ",Z2TipoPersonaId);
               GXutil.writeLogRaw("Current: ",T00012_A2TipoPersonaId[0]);
            }
            if ( Z3LocalidadId != T00012_A3LocalidadId[0] )
            {
               GXutil.writeLogln("persona:[seudo value changed for attri]"+"LocalidadId");
               GXutil.writeLogRaw("Old: ",Z3LocalidadId);
               GXutil.writeLogRaw("Current: ",T00012_A3LocalidadId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Persona"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert011( )
   {
      if ( ! IsAuthorized("persona_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         zm011( 0) ;
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000116 */
                  pr_default.execute(14, new Object[] {Long.valueOf(A1PersonaId), A55PersonaNombre, A56PersonaApellido, A57PersonaDireccion, Long.valueOf(A63PersonaCI), A65PersonaBarrio, A66PersonaTelefono, A67PersonaTelefono1, A68PersonaTelefono2, A69PersonaCorreo, Long.valueOf(A2TipoPersonaId), Long.valueOf(A3LocalidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Persona");
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
                        resetCaption010( ) ;
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
            load011( ) ;
         }
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void update011( )
   {
      if ( ! IsAuthorized("persona_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000117 */
                  pr_default.execute(15, new Object[] {A55PersonaNombre, A56PersonaApellido, A57PersonaDireccion, Long.valueOf(A63PersonaCI), A65PersonaBarrio, A66PersonaTelefono, A67PersonaTelefono1, A68PersonaTelefono2, A69PersonaCorreo, Long.valueOf(A2TipoPersonaId), Long.valueOf(A3LocalidadId), Long.valueOf(A1PersonaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Persona");
                  if ( (pr_default.getStatus(15) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Persona"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate011( ) ;
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
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void deferredUpdate011( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("persona_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls011( ) ;
         afterConfirm011( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete011( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000118 */
               pr_default.execute(16, new Object[] {Long.valueOf(A1PersonaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Persona");
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
      sMode1 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel011( ) ;
      Gx_mode = sMode1 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls011( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
         /* Using cursor T000119 */
         pr_default.execute(17, new Object[] {Long.valueOf(A3LocalidadId)});
         A7CiudadId = T000119_A7CiudadId[0] ;
         A64LocalidadNombre = T000119_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         pr_default.close(17);
         /* Using cursor T000120 */
         pr_default.execute(18, new Object[] {Long.valueOf(A7CiudadId)});
         A6DepartamentoId = T000120_A6DepartamentoId[0] ;
         A62CiudadNombre = T000120_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         pr_default.close(18);
         /* Using cursor T000121 */
         pr_default.execute(19, new Object[] {Long.valueOf(A6DepartamentoId)});
         A61DepartamentoNombre = T000121_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         pr_default.close(19);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000122 */
         pr_default.execute(20, new Object[] {Long.valueOf(A1PersonaId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Usuario", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T000123 */
         pr_default.execute(21, new Object[] {Long.valueOf(A1PersonaId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Proveedor", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T000124 */
         pr_default.execute(22, new Object[] {Long.valueOf(A1PersonaId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
      }
   }

   public void endLevel011( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete011( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(17);
         pr_default.close(18);
         pr_default.close(19);
         Application.commitDataStores(context, remoteHandle, pr_default, "persona");
         if ( AnyError == 0 )
         {
            confirmValues010( ) ;
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
         Application.rollbackDataStores(context, remoteHandle, pr_default, "persona");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart011( )
   {
      /* Scan By routine */
      /* Using cursor T000125 */
      pr_default.execute(23);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1PersonaId = T000125_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext011( )
   {
      /* Scan next routine */
      pr_default.readNext(23);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1PersonaId = T000125_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      }
   }

   public void scanEnd011( )
   {
      pr_default.close(23);
   }

   public void afterConfirm011( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert011( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate011( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete011( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete011( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate011( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes011( )
   {
      edtPersonaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      dynTipoPersonaId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynTipoPersonaId.getInternalname(), "Enabled", GXutil.ltrimstr( dynTipoPersonaId.getEnabled(), 5, 0), true);
      edtPersonaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaNombre_Enabled), 5, 0), true);
      edtPersonaApellido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaApellido_Enabled), 5, 0), true);
      edtPersonaNombreCompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaNombreCompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaNombreCompleto_Enabled), 5, 0), true);
      edtPersonaDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaDireccion_Enabled), 5, 0), true);
      edtLocalidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      edtLocalidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocalidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadNombre_Enabled), 5, 0), true);
      edtCiudadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCiudadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCiudadNombre_Enabled), 5, 0), true);
      edtDepartamentoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDepartamentoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDepartamentoNombre_Enabled), 5, 0), true);
      edtPersonaBarrio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaBarrio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaBarrio_Enabled), 5, 0), true);
      edtPersonaTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaTelefono_Enabled), 5, 0), true);
      edtPersonaTelefono1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaTelefono1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaTelefono1_Enabled), 5, 0), true);
      edtPersonaTelefono2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaTelefono2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaTelefono2_Enabled), 5, 0), true);
      edtPersonaCorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaCorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaCorreo_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes011( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues010( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.persona", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PersonaId,11,0))}, new String[] {"Gx_mode","PersonaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Persona");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("PersonaCI", localUtil.format( DecimalUtil.doubleToDec(A63PersonaCI), "ZZZZZZZZZ9"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("persona:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z1PersonaId", GXutil.ltrim( localUtil.ntoc( Z1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z55PersonaNombre", GXutil.rtrim( Z55PersonaNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z56PersonaApellido", GXutil.rtrim( Z56PersonaApellido));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z57PersonaDireccion", Z57PersonaDireccion);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z63PersonaCI", GXutil.ltrim( localUtil.ntoc( Z63PersonaCI, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z65PersonaBarrio", GXutil.rtrim( Z65PersonaBarrio));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z66PersonaTelefono", GXutil.rtrim( Z66PersonaTelefono));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z67PersonaTelefono1", GXutil.rtrim( Z67PersonaTelefono1));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z68PersonaTelefono2", GXutil.rtrim( Z68PersonaTelefono2));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z69PersonaCorreo", Z69PersonaCorreo);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z2TipoPersonaId", GXutil.ltrim( localUtil.ntoc( Z2TipoPersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z3LocalidadId", GXutil.ltrim( localUtil.ntoc( Z3LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N2TipoPersonaId", GXutil.ltrim( localUtil.ntoc( A2TipoPersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N3LocalidadId", GXutil.ltrim( localUtil.ntoc( A3LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPERSONAID", GXutil.ltrim( localUtil.ntoc( AV7PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERSONAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PersonaId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOPERSONAID", GXutil.ltrim( localUtil.ntoc( AV13Insert_TipoPersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LOCALIDADID", GXutil.ltrim( localUtil.ntoc( AV14Insert_LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PERSONACI", GXutil.ltrim( localUtil.ntoc( A63PersonaCI, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.persona", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PersonaId,11,0))}, new String[] {"Gx_mode","PersonaId"})  ;
   }

   public String getPgmname( )
   {
      return "Persona" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Persona", "") ;
   }

   public void initializeNonKey011( )
   {
      A6DepartamentoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6DepartamentoId), 11, 0));
      A7CiudadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
      A2TipoPersonaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2TipoPersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2TipoPersonaId), 11, 0));
      A3LocalidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      A59PersonaNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      A55PersonaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", A55PersonaNombre);
      A56PersonaApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", A56PersonaApellido);
      A57PersonaDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A63PersonaCI = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A63PersonaCI", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63PersonaCI), 10, 0));
      A64LocalidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
      A62CiudadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      A61DepartamentoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      A65PersonaBarrio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A65PersonaBarrio", A65PersonaBarrio);
      A66PersonaTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A67PersonaTelefono1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A67PersonaTelefono1", A67PersonaTelefono1);
      A68PersonaTelefono2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A68PersonaTelefono2", A68PersonaTelefono2);
      A69PersonaCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
      Z55PersonaNombre = "" ;
      Z56PersonaApellido = "" ;
      Z57PersonaDireccion = "" ;
      Z63PersonaCI = 0 ;
      Z65PersonaBarrio = "" ;
      Z66PersonaTelefono = "" ;
      Z67PersonaTelefono1 = "" ;
      Z68PersonaTelefono2 = "" ;
      Z69PersonaCorreo = "" ;
      Z2TipoPersonaId = 0 ;
      Z3LocalidadId = 0 ;
   }

   public void initAll011( )
   {
      A1PersonaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      initializeNonKey011( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211185718", true, true);
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
      httpContext.AddJavascriptSource("persona.js", "?20241211185718", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtPersonaId_Internalname = "PERSONAID" ;
      dynTipoPersonaId.setInternalname( "TIPOPERSONAID" );
      edtPersonaNombre_Internalname = "PERSONANOMBRE" ;
      edtPersonaApellido_Internalname = "PERSONAAPELLIDO" ;
      edtPersonaNombreCompleto_Internalname = "PERSONANOMBRECOMPLETO" ;
      edtPersonaDireccion_Internalname = "PERSONADIRECCION" ;
      edtLocalidadId_Internalname = "LOCALIDADID" ;
      edtLocalidadNombre_Internalname = "LOCALIDADNOMBRE" ;
      edtCiudadNombre_Internalname = "CIUDADNOMBRE" ;
      edtDepartamentoNombre_Internalname = "DEPARTAMENTONOMBRE" ;
      edtPersonaBarrio_Internalname = "PERSONABARRIO" ;
      edtPersonaTelefono_Internalname = "PERSONATELEFONO" ;
      edtPersonaTelefono1_Internalname = "PERSONATELEFONO1" ;
      edtPersonaTelefono2_Internalname = "PERSONATELEFONO2" ;
      edtPersonaCorreo_Internalname = "PERSONACORREO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_3_Internalname = "PROMPT_3" ;
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
      Form.setCaption( httpContext.getMessage( "Persona", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPersonaCorreo_Jsonclick = "" ;
      edtPersonaCorreo_Enabled = 1 ;
      edtPersonaTelefono2_Jsonclick = "" ;
      edtPersonaTelefono2_Enabled = 1 ;
      edtPersonaTelefono1_Jsonclick = "" ;
      edtPersonaTelefono1_Enabled = 1 ;
      edtPersonaTelefono_Jsonclick = "" ;
      edtPersonaTelefono_Enabled = 1 ;
      edtPersonaBarrio_Jsonclick = "" ;
      edtPersonaBarrio_Enabled = 1 ;
      edtDepartamentoNombre_Jsonclick = "" ;
      edtDepartamentoNombre_Enabled = 0 ;
      edtCiudadNombre_Jsonclick = "" ;
      edtCiudadNombre_Enabled = 0 ;
      edtLocalidadNombre_Jsonclick = "" ;
      edtLocalidadNombre_Enabled = 0 ;
      imgprompt_3_Visible = 1 ;
      imgprompt_3_Link = "" ;
      edtLocalidadId_Jsonclick = "" ;
      edtLocalidadId_Enabled = 1 ;
      edtPersonaDireccion_Enabled = 1 ;
      edtPersonaNombreCompleto_Jsonclick = "" ;
      edtPersonaNombreCompleto_Enabled = 0 ;
      edtPersonaApellido_Jsonclick = "" ;
      edtPersonaApellido_Enabled = 1 ;
      edtPersonaNombre_Jsonclick = "" ;
      edtPersonaNombre_Enabled = 1 ;
      dynTipoPersonaId.setJsonclick( "" );
      dynTipoPersonaId.setEnabled( 1 );
      edtPersonaId_Jsonclick = "" ;
      edtPersonaId_Enabled = 1 ;
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

   public void gxdlatipopersonaid011( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatipopersonaid_data011( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxatipopersonaid_html011( )
   {
      long gxdynajaxvalue;
      gxdlatipopersonaid_data011( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTipoPersonaId.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex)) ;
         dynTipoPersonaId.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 11, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatipopersonaid_data011( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "::Seleccionar Tipo Persona::", ""));
      /* Using cursor T000126 */
      pr_default.execute(24);
      while ( (pr_default.getStatus(24) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T000126_A2TipoPersonaId[0], (byte)(11), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.rtrim( T000126_A58TipoPersonaNombre[0]));
         pr_default.readNext(24);
      }
      pr_default.close(24);
   }

   public void gx5asapersonaid011( long AV7PersonaId ,
                                   String AV16Pgmname )
   {
      if ( ! (0==AV7PersonaId) )
      {
         A1PersonaId = AV7PersonaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A1PersonaId ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int3) ;
            persona_impl.this.GXt_int2 = GXv_int3[0] ;
            A1PersonaId = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
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
      dynTipoPersonaId.setName( "TIPOPERSONAID" );
      dynTipoPersonaId.setWebtags( "" );
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

   public void valid_Tipopersonaid( )
   {
      A2TipoPersonaId = GXutil.lval( dynTipoPersonaId.getValue()) ;
      /* Using cursor T000127 */
      pr_default.execute(25, new Object[] {Long.valueOf(A2TipoPersonaId)});
      if ( (pr_default.getStatus(25) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynTipoPersonaId.getInternalname() ;
      }
      pr_default.close(25);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Localidadid( )
   {
      A2TipoPersonaId = GXutil.lval( dynTipoPersonaId.getValue()) ;
      /* Using cursor T000128 */
      pr_default.execute(26, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(26) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLocalidadId_Internalname ;
      }
      A7CiudadId = T000128_A7CiudadId[0] ;
      A64LocalidadNombre = T000128_A64LocalidadNombre[0] ;
      pr_default.close(26);
      /* Using cursor T000129 */
      pr_default.execute(27, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
      }
      A6DepartamentoId = T000129_A6DepartamentoId[0] ;
      A62CiudadNombre = T000129_A62CiudadNombre[0] ;
      pr_default.close(27);
      /* Using cursor T000130 */
      pr_default.execute(28, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(28) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A61DepartamentoNombre = T000130_A61DepartamentoNombre[0] ;
      pr_default.close(28);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrim( localUtil.ntoc( A7CiudadId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", GXutil.rtrim( A64LocalidadNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", GXutil.rtrim( A62CiudadNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", GXutil.rtrim( A61DepartamentoNombre));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PersonaId',fld:'vPERSONAID',pic:'ZZZZZZZZZZ9',hsh:true},{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7PersonaId',fld:'vPERSONAID',pic:'ZZZZZZZZZZ9',hsh:true},{av:'A63PersonaCI',fld:'PERSONACI',pic:'ZZZZZZZZZ9'},{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e12012',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_PERSONAID","{handler:'valid_Personaid',iparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_PERSONAID",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_TIPOPERSONAID","{handler:'valid_Tipopersonaid',iparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_TIPOPERSONAID",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_PERSONANOMBRE","{handler:'valid_Personanombre',iparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_PERSONANOMBRE",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_PERSONAAPELLIDO","{handler:'valid_Personaapellido',iparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_PERSONAAPELLIDO",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_LOCALIDADID","{handler:'valid_Localidadid',iparms:[{av:'A3LocalidadId',fld:'LOCALIDADID',pic:'ZZZZZZZZZZ9'},{av:'A7CiudadId',fld:'CIUDADID',pic:'ZZZZZZZZZZ9'},{av:'A6DepartamentoId',fld:'DEPARTAMENTOID',pic:'ZZZZZZZZZZ9'},{av:'A64LocalidadNombre',fld:'LOCALIDADNOMBRE',pic:''},{av:'A62CiudadNombre',fld:'CIUDADNOMBRE',pic:''},{av:'A61DepartamentoNombre',fld:'DEPARTAMENTONOMBRE',pic:''},{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_LOCALIDADID",",oparms:[{av:'A7CiudadId',fld:'CIUDADID',pic:'ZZZZZZZZZZ9'},{av:'A64LocalidadNombre',fld:'LOCALIDADNOMBRE',pic:''},{av:'A6DepartamentoId',fld:'DEPARTAMENTOID',pic:'ZZZZZZZZZZ9'},{av:'A62CiudadNombre',fld:'CIUDADNOMBRE',pic:''},{av:'A61DepartamentoNombre',fld:'DEPARTAMENTONOMBRE',pic:''},{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_PERSONACORREO","{handler:'valid_Personacorreo',iparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_PERSONACORREO",",oparms:[{av:'dynTipoPersonaId'},{av:'A2TipoPersonaId',fld:'TIPOPERSONAID',pic:'ZZZZZZZZZZ9'}]}");
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
      return "persona_Execute";
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
      pr_default.close(25);
      pr_default.close(26);
      pr_default.close(17);
      pr_default.close(27);
      pr_default.close(18);
      pr_default.close(28);
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z55PersonaNombre = "" ;
      Z56PersonaApellido = "" ;
      Z57PersonaDireccion = "" ;
      Z65PersonaBarrio = "" ;
      Z66PersonaTelefono = "" ;
      Z67PersonaTelefono1 = "" ;
      Z68PersonaTelefono2 = "" ;
      Z69PersonaCorreo = "" ;
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
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A55PersonaNombre = "" ;
      A56PersonaApellido = "" ;
      A59PersonaNombreCompleto = "" ;
      A57PersonaDireccion = "" ;
      imgprompt_3_gximage = "" ;
      sImgUrl = "" ;
      A64LocalidadNombre = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A65PersonaBarrio = "" ;
      A66PersonaTelefono = "" ;
      A67PersonaTelefono1 = "" ;
      A68PersonaTelefono2 = "" ;
      A69PersonaCorreo = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode1 = "" ;
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
      AV15TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z64LocalidadNombre = "" ;
      Z62CiudadNombre = "" ;
      Z61DepartamentoNombre = "" ;
      T00015_A7CiudadId = new long[1] ;
      T00015_A64LocalidadNombre = new String[] {""} ;
      T00016_A6DepartamentoId = new long[1] ;
      T00016_A62CiudadNombre = new String[] {""} ;
      T00017_A61DepartamentoNombre = new String[] {""} ;
      T00018_A7CiudadId = new long[1] ;
      T00018_A6DepartamentoId = new long[1] ;
      T00018_A1PersonaId = new long[1] ;
      T00018_A55PersonaNombre = new String[] {""} ;
      T00018_A56PersonaApellido = new String[] {""} ;
      T00018_A57PersonaDireccion = new String[] {""} ;
      T00018_A63PersonaCI = new long[1] ;
      T00018_A64LocalidadNombre = new String[] {""} ;
      T00018_A62CiudadNombre = new String[] {""} ;
      T00018_A61DepartamentoNombre = new String[] {""} ;
      T00018_A65PersonaBarrio = new String[] {""} ;
      T00018_A66PersonaTelefono = new String[] {""} ;
      T00018_A67PersonaTelefono1 = new String[] {""} ;
      T00018_A68PersonaTelefono2 = new String[] {""} ;
      T00018_A69PersonaCorreo = new String[] {""} ;
      T00018_A2TipoPersonaId = new long[1] ;
      T00018_A3LocalidadId = new long[1] ;
      T00014_A2TipoPersonaId = new long[1] ;
      T00019_A2TipoPersonaId = new long[1] ;
      T000110_A7CiudadId = new long[1] ;
      T000110_A64LocalidadNombre = new String[] {""} ;
      T000111_A6DepartamentoId = new long[1] ;
      T000111_A62CiudadNombre = new String[] {""} ;
      T000112_A61DepartamentoNombre = new String[] {""} ;
      T000113_A1PersonaId = new long[1] ;
      T00013_A1PersonaId = new long[1] ;
      T00013_A55PersonaNombre = new String[] {""} ;
      T00013_A56PersonaApellido = new String[] {""} ;
      T00013_A57PersonaDireccion = new String[] {""} ;
      T00013_A63PersonaCI = new long[1] ;
      T00013_A65PersonaBarrio = new String[] {""} ;
      T00013_A66PersonaTelefono = new String[] {""} ;
      T00013_A67PersonaTelefono1 = new String[] {""} ;
      T00013_A68PersonaTelefono2 = new String[] {""} ;
      T00013_A69PersonaCorreo = new String[] {""} ;
      T00013_A2TipoPersonaId = new long[1] ;
      T00013_A3LocalidadId = new long[1] ;
      T000114_A1PersonaId = new long[1] ;
      T000115_A1PersonaId = new long[1] ;
      T00012_A1PersonaId = new long[1] ;
      T00012_A55PersonaNombre = new String[] {""} ;
      T00012_A56PersonaApellido = new String[] {""} ;
      T00012_A57PersonaDireccion = new String[] {""} ;
      T00012_A63PersonaCI = new long[1] ;
      T00012_A65PersonaBarrio = new String[] {""} ;
      T00012_A66PersonaTelefono = new String[] {""} ;
      T00012_A67PersonaTelefono1 = new String[] {""} ;
      T00012_A68PersonaTelefono2 = new String[] {""} ;
      T00012_A69PersonaCorreo = new String[] {""} ;
      T00012_A2TipoPersonaId = new long[1] ;
      T00012_A3LocalidadId = new long[1] ;
      T000119_A7CiudadId = new long[1] ;
      T000119_A64LocalidadNombre = new String[] {""} ;
      T000120_A6DepartamentoId = new long[1] ;
      T000120_A62CiudadNombre = new String[] {""} ;
      T000121_A61DepartamentoNombre = new String[] {""} ;
      T000122_A14UsuarioId = new long[1] ;
      T000123_A10ProveedorId = new long[1] ;
      T000124_A4ClienteId = new long[1] ;
      T000125_A1PersonaId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T000126_A2TipoPersonaId = new long[1] ;
      T000126_A58TipoPersonaNombre = new String[] {""} ;
      GXv_int3 = new long[1] ;
      T000127_A2TipoPersonaId = new long[1] ;
      T000128_A7CiudadId = new long[1] ;
      T000128_A64LocalidadNombre = new String[] {""} ;
      T000129_A6DepartamentoId = new long[1] ;
      T000129_A62CiudadNombre = new String[] {""} ;
      T000130_A61DepartamentoNombre = new String[] {""} ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.persona__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.persona__default(),
         new Object[] {
             new Object[] {
            T00012_A1PersonaId, T00012_A55PersonaNombre, T00012_A56PersonaApellido, T00012_A57PersonaDireccion, T00012_A63PersonaCI, T00012_A65PersonaBarrio, T00012_A66PersonaTelefono, T00012_A67PersonaTelefono1, T00012_A68PersonaTelefono2, T00012_A69PersonaCorreo,
            T00012_A2TipoPersonaId, T00012_A3LocalidadId
            }
            , new Object[] {
            T00013_A1PersonaId, T00013_A55PersonaNombre, T00013_A56PersonaApellido, T00013_A57PersonaDireccion, T00013_A63PersonaCI, T00013_A65PersonaBarrio, T00013_A66PersonaTelefono, T00013_A67PersonaTelefono1, T00013_A68PersonaTelefono2, T00013_A69PersonaCorreo,
            T00013_A2TipoPersonaId, T00013_A3LocalidadId
            }
            , new Object[] {
            T00014_A2TipoPersonaId
            }
            , new Object[] {
            T00015_A7CiudadId, T00015_A64LocalidadNombre
            }
            , new Object[] {
            T00016_A6DepartamentoId, T00016_A62CiudadNombre
            }
            , new Object[] {
            T00017_A61DepartamentoNombre
            }
            , new Object[] {
            T00018_A7CiudadId, T00018_A6DepartamentoId, T00018_A1PersonaId, T00018_A55PersonaNombre, T00018_A56PersonaApellido, T00018_A57PersonaDireccion, T00018_A63PersonaCI, T00018_A64LocalidadNombre, T00018_A62CiudadNombre, T00018_A61DepartamentoNombre,
            T00018_A65PersonaBarrio, T00018_A66PersonaTelefono, T00018_A67PersonaTelefono1, T00018_A68PersonaTelefono2, T00018_A69PersonaCorreo, T00018_A2TipoPersonaId, T00018_A3LocalidadId
            }
            , new Object[] {
            T00019_A2TipoPersonaId
            }
            , new Object[] {
            T000110_A7CiudadId, T000110_A64LocalidadNombre
            }
            , new Object[] {
            T000111_A6DepartamentoId, T000111_A62CiudadNombre
            }
            , new Object[] {
            T000112_A61DepartamentoNombre
            }
            , new Object[] {
            T000113_A1PersonaId
            }
            , new Object[] {
            T000114_A1PersonaId
            }
            , new Object[] {
            T000115_A1PersonaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000119_A7CiudadId, T000119_A64LocalidadNombre
            }
            , new Object[] {
            T000120_A6DepartamentoId, T000120_A62CiudadNombre
            }
            , new Object[] {
            T000121_A61DepartamentoNombre
            }
            , new Object[] {
            T000122_A14UsuarioId
            }
            , new Object[] {
            T000123_A10ProveedorId
            }
            , new Object[] {
            T000124_A4ClienteId
            }
            , new Object[] {
            T000125_A1PersonaId
            }
            , new Object[] {
            T000126_A2TipoPersonaId, T000126_A58TipoPersonaNombre
            }
            , new Object[] {
            T000127_A2TipoPersonaId
            }
            , new Object[] {
            T000128_A7CiudadId, T000128_A64LocalidadNombre
            }
            , new Object[] {
            T000129_A6DepartamentoId, T000129_A62CiudadNombre
            }
            , new Object[] {
            T000130_A61DepartamentoNombre
            }
         }
      );
      AV16Pgmname = "Persona" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound1 ;
   private short nIsDirty_1 ;
   private int trnEnded ;
   private int edtPersonaId_Enabled ;
   private int edtPersonaNombre_Enabled ;
   private int edtPersonaApellido_Enabled ;
   private int edtPersonaNombreCompleto_Enabled ;
   private int edtPersonaDireccion_Enabled ;
   private int edtLocalidadId_Enabled ;
   private int imgprompt_3_Visible ;
   private int edtLocalidadNombre_Enabled ;
   private int edtCiudadNombre_Enabled ;
   private int edtDepartamentoNombre_Enabled ;
   private int edtPersonaBarrio_Enabled ;
   private int edtPersonaTelefono_Enabled ;
   private int edtPersonaTelefono1_Enabled ;
   private int edtPersonaTelefono2_Enabled ;
   private int edtPersonaCorreo_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV17GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private long wcpOAV7PersonaId ;
   private long Z1PersonaId ;
   private long Z63PersonaCI ;
   private long Z2TipoPersonaId ;
   private long Z3LocalidadId ;
   private long N2TipoPersonaId ;
   private long N3LocalidadId ;
   private long AV7PersonaId ;
   private long A2TipoPersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private long A1PersonaId ;
   private long A63PersonaCI ;
   private long AV13Insert_TipoPersonaId ;
   private long AV14Insert_LocalidadId ;
   private long Z7CiudadId ;
   private long Z6DepartamentoId ;
   private long GXt_int2 ;
   private long GXv_int3[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z55PersonaNombre ;
   private String Z56PersonaApellido ;
   private String Z65PersonaBarrio ;
   private String Z66PersonaTelefono ;
   private String Z67PersonaTelefono1 ;
   private String Z68PersonaTelefono2 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV16Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPersonaId_Internalname ;
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
   private String edtPersonaId_Jsonclick ;
   private String edtPersonaNombre_Internalname ;
   private String A55PersonaNombre ;
   private String edtPersonaNombre_Jsonclick ;
   private String edtPersonaApellido_Internalname ;
   private String A56PersonaApellido ;
   private String edtPersonaApellido_Jsonclick ;
   private String edtPersonaNombreCompleto_Internalname ;
   private String A59PersonaNombreCompleto ;
   private String edtPersonaNombreCompleto_Jsonclick ;
   private String edtPersonaDireccion_Internalname ;
   private String edtLocalidadId_Internalname ;
   private String edtLocalidadId_Jsonclick ;
   private String imgprompt_3_gximage ;
   private String sImgUrl ;
   private String imgprompt_3_Internalname ;
   private String imgprompt_3_Link ;
   private String edtLocalidadNombre_Internalname ;
   private String A64LocalidadNombre ;
   private String edtLocalidadNombre_Jsonclick ;
   private String edtCiudadNombre_Internalname ;
   private String A62CiudadNombre ;
   private String edtCiudadNombre_Jsonclick ;
   private String edtDepartamentoNombre_Internalname ;
   private String A61DepartamentoNombre ;
   private String edtDepartamentoNombre_Jsonclick ;
   private String edtPersonaBarrio_Internalname ;
   private String A65PersonaBarrio ;
   private String edtPersonaBarrio_Jsonclick ;
   private String edtPersonaTelefono_Internalname ;
   private String A66PersonaTelefono ;
   private String edtPersonaTelefono_Jsonclick ;
   private String edtPersonaTelefono1_Internalname ;
   private String A67PersonaTelefono1 ;
   private String edtPersonaTelefono1_Jsonclick ;
   private String edtPersonaTelefono2_Internalname ;
   private String A68PersonaTelefono2 ;
   private String edtPersonaTelefono2_Jsonclick ;
   private String edtPersonaCorreo_Internalname ;
   private String edtPersonaCorreo_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode1 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z64LocalidadNombre ;
   private String Z62CiudadNombre ;
   private String Z61DepartamentoNombre ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
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
   private boolean gxdyncontrolsrefreshing ;
   private String Z57PersonaDireccion ;
   private String Z69PersonaCorreo ;
   private String A57PersonaDireccion ;
   private String A69PersonaCorreo ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynTipoPersonaId ;
   private IDataStoreProvider pr_default ;
   private long[] T00015_A7CiudadId ;
   private String[] T00015_A64LocalidadNombre ;
   private long[] T00016_A6DepartamentoId ;
   private String[] T00016_A62CiudadNombre ;
   private String[] T00017_A61DepartamentoNombre ;
   private long[] T00018_A7CiudadId ;
   private long[] T00018_A6DepartamentoId ;
   private long[] T00018_A1PersonaId ;
   private String[] T00018_A55PersonaNombre ;
   private String[] T00018_A56PersonaApellido ;
   private String[] T00018_A57PersonaDireccion ;
   private long[] T00018_A63PersonaCI ;
   private String[] T00018_A64LocalidadNombre ;
   private String[] T00018_A62CiudadNombre ;
   private String[] T00018_A61DepartamentoNombre ;
   private String[] T00018_A65PersonaBarrio ;
   private String[] T00018_A66PersonaTelefono ;
   private String[] T00018_A67PersonaTelefono1 ;
   private String[] T00018_A68PersonaTelefono2 ;
   private String[] T00018_A69PersonaCorreo ;
   private long[] T00018_A2TipoPersonaId ;
   private long[] T00018_A3LocalidadId ;
   private long[] T00014_A2TipoPersonaId ;
   private long[] T00019_A2TipoPersonaId ;
   private long[] T000110_A7CiudadId ;
   private String[] T000110_A64LocalidadNombre ;
   private long[] T000111_A6DepartamentoId ;
   private String[] T000111_A62CiudadNombre ;
   private String[] T000112_A61DepartamentoNombre ;
   private long[] T000113_A1PersonaId ;
   private long[] T00013_A1PersonaId ;
   private String[] T00013_A55PersonaNombre ;
   private String[] T00013_A56PersonaApellido ;
   private String[] T00013_A57PersonaDireccion ;
   private long[] T00013_A63PersonaCI ;
   private String[] T00013_A65PersonaBarrio ;
   private String[] T00013_A66PersonaTelefono ;
   private String[] T00013_A67PersonaTelefono1 ;
   private String[] T00013_A68PersonaTelefono2 ;
   private String[] T00013_A69PersonaCorreo ;
   private long[] T00013_A2TipoPersonaId ;
   private long[] T00013_A3LocalidadId ;
   private long[] T000114_A1PersonaId ;
   private long[] T000115_A1PersonaId ;
   private long[] T00012_A1PersonaId ;
   private String[] T00012_A55PersonaNombre ;
   private String[] T00012_A56PersonaApellido ;
   private String[] T00012_A57PersonaDireccion ;
   private long[] T00012_A63PersonaCI ;
   private String[] T00012_A65PersonaBarrio ;
   private String[] T00012_A66PersonaTelefono ;
   private String[] T00012_A67PersonaTelefono1 ;
   private String[] T00012_A68PersonaTelefono2 ;
   private String[] T00012_A69PersonaCorreo ;
   private long[] T00012_A2TipoPersonaId ;
   private long[] T00012_A3LocalidadId ;
   private long[] T000119_A7CiudadId ;
   private String[] T000119_A64LocalidadNombre ;
   private long[] T000120_A6DepartamentoId ;
   private String[] T000120_A62CiudadNombre ;
   private String[] T000121_A61DepartamentoNombre ;
   private long[] T000122_A14UsuarioId ;
   private long[] T000123_A10ProveedorId ;
   private long[] T000124_A4ClienteId ;
   private long[] T000125_A1PersonaId ;
   private long[] T000126_A2TipoPersonaId ;
   private String[] T000126_A58TipoPersonaNombre ;
   private long[] T000127_A2TipoPersonaId ;
   private long[] T000128_A7CiudadId ;
   private String[] T000128_A64LocalidadNombre ;
   private long[] T000129_A6DepartamentoId ;
   private String[] T000129_A62CiudadNombre ;
   private String[] T000130_A61DepartamentoNombre ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class persona__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class persona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00012", "SELECT [PersonaId], [PersonaNombre], [PersonaApellido], [PersonaDireccion], [PersonaCI], [PersonaBarrio], [PersonaTelefono], [PersonaTelefono1], [PersonaTelefono2], [PersonaCorreo], [TipoPersonaId], [LocalidadId] FROM [Persona] WITH (UPDLOCK) WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00013", "SELECT [PersonaId], [PersonaNombre], [PersonaApellido], [PersonaDireccion], [PersonaCI], [PersonaBarrio], [PersonaTelefono], [PersonaTelefono1], [PersonaTelefono2], [PersonaCorreo], [TipoPersonaId], [LocalidadId] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00014", "SELECT [TipoPersonaId] FROM [TipoPersona] WHERE [TipoPersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00015", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00016", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00017", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00018", "SELECT T2.[CiudadId], T3.[DepartamentoId], TM1.[PersonaId], TM1.[PersonaNombre], TM1.[PersonaApellido], TM1.[PersonaDireccion], TM1.[PersonaCI], T2.[LocalidadNombre], T3.[CiudadNombre], T4.[DepartamentoNombre], TM1.[PersonaBarrio], TM1.[PersonaTelefono], TM1.[PersonaTelefono1], TM1.[PersonaTelefono2], TM1.[PersonaCorreo], TM1.[TipoPersonaId], TM1.[LocalidadId] FROM ((([Persona] TM1 INNER JOIN [Localidad] T2 ON T2.[LocalidadId] = TM1.[LocalidadId]) INNER JOIN [Ciudad] T3 ON T3.[CiudadId] = T2.[CiudadId]) INNER JOIN [Departamento] T4 ON T4.[DepartamentoId] = T3.[DepartamentoId]) WHERE TM1.[PersonaId] = ? ORDER BY TM1.[PersonaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00019", "SELECT [TipoPersonaId] FROM [TipoPersona] WHERE [TipoPersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000110", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000111", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000112", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000113", "SELECT [PersonaId] FROM [Persona] WHERE [PersonaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000114", "SELECT TOP 1 [PersonaId] FROM [Persona] WHERE ( [PersonaId] > ?) ORDER BY [PersonaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000115", "SELECT TOP 1 [PersonaId] FROM [Persona] WHERE ( [PersonaId] < ?) ORDER BY [PersonaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000116", "INSERT INTO [Persona]([PersonaId], [PersonaNombre], [PersonaApellido], [PersonaDireccion], [PersonaCI], [PersonaBarrio], [PersonaTelefono], [PersonaTelefono1], [PersonaTelefono2], [PersonaCorreo], [TipoPersonaId], [LocalidadId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000117", "UPDATE [Persona] SET [PersonaNombre]=?, [PersonaApellido]=?, [PersonaDireccion]=?, [PersonaCI]=?, [PersonaBarrio]=?, [PersonaTelefono]=?, [PersonaTelefono1]=?, [PersonaTelefono2]=?, [PersonaCorreo]=?, [TipoPersonaId]=?, [LocalidadId]=?  WHERE [PersonaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000118", "DELETE FROM [Persona]  WHERE [PersonaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000119", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000120", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000121", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000122", "SELECT TOP 1 [UsuarioId] FROM [Usuario] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000123", "SELECT TOP 1 [ProveedorId] FROM [Proveedor] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000124", "SELECT TOP 1 [ClienteId] FROM [Cliente] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000125", "SELECT [PersonaId] FROM [Persona] ORDER BY [PersonaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000126", "SELECT [TipoPersonaId], [TipoPersonaNombre] FROM [TipoPersona] ORDER BY [TipoPersonaNombre] ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000127", "SELECT [TipoPersonaId] FROM [TipoPersona] WHERE [TipoPersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000128", "SELECT [CiudadId], [LocalidadNombre] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000129", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000130", "SELECT [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 120);
               ((String[]) buf[6])[0] = rslt.getString(7, 25);
               ((String[]) buf[7])[0] = rslt.getString(8, 25);
               ((String[]) buf[8])[0] = rslt.getString(9, 25);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 120);
               ((String[]) buf[6])[0] = rslt.getString(7, 25);
               ((String[]) buf[7])[0] = rslt.getString(8, 25);
               ((String[]) buf[8])[0] = rslt.getString(9, 25);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 80);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((String[]) buf[9])[0] = rslt.getString(10, 80);
               ((String[]) buf[10])[0] = rslt.getString(11, 120);
               ((String[]) buf[11])[0] = rslt.getString(12, 25);
               ((String[]) buf[12])[0] = rslt.getString(13, 25);
               ((String[]) buf[13])[0] = rslt.getString(14, 25);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((long[]) buf[15])[0] = rslt.getLong(16);
               ((long[]) buf[16])[0] = rslt.getLong(17);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 20 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 25 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 26 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 27 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
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
               stmt.setString(2, (String)parms[1], 80);
               stmt.setString(3, (String)parms[2], 80);
               stmt.setVarchar(4, (String)parms[3], 256, false);
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setString(6, (String)parms[5], 120);
               stmt.setString(7, (String)parms[6], 25);
               stmt.setString(8, (String)parms[7], 25);
               stmt.setString(9, (String)parms[8], 25);
               stmt.setVarchar(10, (String)parms[9], 100, false);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 80);
               stmt.setString(2, (String)parms[1], 80);
               stmt.setVarchar(3, (String)parms[2], 256, false);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setString(5, (String)parms[4], 120);
               stmt.setString(6, (String)parms[5], 25);
               stmt.setString(7, (String)parms[6], 25);
               stmt.setString(8, (String)parms[7], 25);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setLong(10, ((Number) parms[9]).longValue());
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
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
            case 25 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
      }
   }

}

