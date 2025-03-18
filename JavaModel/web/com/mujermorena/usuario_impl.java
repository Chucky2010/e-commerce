package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class usuario_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A1PersonaId = GXutil.lval( httpContext.GetPar( "PersonaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A1PersonaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A15DeviceType = (byte)(GXutil.lval( httpContext.GetPar( "DeviceType"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
         A16DeviceId = httpContext.GetPar( "DeviceId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A16DeviceId", A16DeviceId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A15DeviceType, A16DeviceId) ;
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
            AV7UsuarioId = GXutil.lval( httpContext.GetPar( "UsuarioId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7UsuarioId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSUARIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7UsuarioId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Usuario", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtUsuarioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public usuario_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public usuario_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( usuario_impl.class ));
   }

   public usuario_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDeviceType = new HTMLChoice();
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
      if ( cmbDeviceType.getItemCount() > 0 )
      {
         A15DeviceType = (byte)(GXutil.lval( cmbDeviceType.getValidValue(GXutil.trim( GXutil.str( A15DeviceType, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDeviceType.setValue( GXutil.trim( GXutil.str( A15DeviceType, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDeviceType.getInternalname(), "Values", cmbDeviceType.ToJavascriptSource(), true);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Usuario", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Usuario.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUsuarioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtUsuarioId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtUsuarioId_Internalname, GXutil.ltrim( localUtil.ntoc( A14UsuarioId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A14UsuarioId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUsuarioId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtUsuarioId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Usuario.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaId_Internalname, GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1PersonaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Usuario.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_1_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_1_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_1_Internalname, sImgUrl, imgprompt_1_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_1_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Usuario.htm");
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
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPersonaCorreo_Internalname, httpContext.getMessage( "Persona Correo", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaCorreo_Internalname, A69PersonaCorreo, GXutil.rtrim( localUtil.format( A69PersonaCorreo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A69PersonaCorreo, "", "", "", edtPersonaCorreo_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Usuario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDeviceId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDeviceId_Internalname, httpContext.getMessage( "Device Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDeviceId_Internalname, GXutil.rtrim( A16DeviceId), GXutil.rtrim( localUtil.format( A16DeviceId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDeviceId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtDeviceId_Enabled, 1, "text", "", 80, "chr", 1, "row", 128, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Usuario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDeviceType.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbDeviceType.getInternalname(), httpContext.getMessage( "Device Type", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDeviceType, cmbDeviceType.getInternalname(), GXutil.trim( GXutil.str( A15DeviceType, 1, 0)), 1, cmbDeviceType.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbDeviceType.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_Usuario.htm");
      cmbDeviceType.setValue( GXutil.trim( GXutil.str( A15DeviceType, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDeviceType.getInternalname(), "Values", cmbDeviceType.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUsuarioNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtUsuarioNom_Internalname, httpContext.getMessage( "Nom", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtUsuarioNom_Internalname, GXutil.rtrim( A271UsuarioNom), GXutil.rtrim( localUtil.format( A271UsuarioNom, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUsuarioNom_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtUsuarioNom_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Usuario.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Usuario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Usuario.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Usuario.htm");
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
      e110D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z14UsuarioId = localUtil.ctol( httpContext.cgiGet( "Z14UsuarioId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z271UsuarioNom = httpContext.cgiGet( "Z271UsuarioNom") ;
            Z1PersonaId = localUtil.ctol( httpContext.cgiGet( "Z1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z15DeviceType = (byte)(localUtil.ctol( httpContext.cgiGet( "Z15DeviceType"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z16DeviceId = httpContext.cgiGet( "Z16DeviceId") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1PersonaId = localUtil.ctol( httpContext.cgiGet( "N1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N16DeviceId = httpContext.cgiGet( "N16DeviceId") ;
            N15DeviceType = (byte)(localUtil.ctol( httpContext.cgiGet( "N15DeviceType"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7UsuarioId = localUtil.ctol( httpContext.cgiGet( "vUSUARIOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV13Insert_PersonaId = localUtil.ctol( httpContext.cgiGet( "vINSERT_PERSONAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV14Insert_DeviceId = httpContext.cgiGet( "vINSERT_DEVICEID") ;
            AV15Insert_DeviceType = (byte)(localUtil.ctol( httpContext.cgiGet( "vINSERT_DEVICETYPE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtUsuarioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtUsuarioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "USUARIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtUsuarioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A14UsuarioId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
            }
            else
            {
               A14UsuarioId = localUtil.ctol( httpContext.cgiGet( edtUsuarioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
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
            A69PersonaCorreo = httpContext.cgiGet( edtPersonaCorreo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
            A16DeviceId = httpContext.cgiGet( edtDeviceId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A16DeviceId", A16DeviceId);
            cmbDeviceType.setValue( httpContext.cgiGet( cmbDeviceType.getInternalname()) );
            A15DeviceType = (byte)(GXutil.lval( httpContext.cgiGet( cmbDeviceType.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
            A271UsuarioNom = httpContext.cgiGet( edtUsuarioNom_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A271UsuarioNom", A271UsuarioNom);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Usuario");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A14UsuarioId != Z14UsuarioId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("usuario:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A14UsuarioId = GXutil.lval( httpContext.GetPar( "UsuarioId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
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
                  sMode13 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode13 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound13 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0D0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "USUARIOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtUsuarioId_Internalname ;
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
                        e110D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120D2 ();
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
         e120D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0D13( ) ;
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
         disableAttributes0D13( ) ;
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

   public void confirm_0D0( )
   {
      beforeValidate0D13( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0D13( ) ;
         }
         else
         {
            checkExtendedTable0D13( ) ;
            closeExtendedTableCursors0D13( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0D0( )
   {
   }

   public void e110D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV17Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV18GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18GXV1), 8, 0));
         while ( AV18GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV18GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PersonaId") == 0 )
            {
               AV13Insert_PersonaId = GXutil.lval( AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_PersonaId), 11, 0));
            }
            else if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "DeviceId") == 0 )
            {
               AV14Insert_DeviceId = AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_DeviceId", AV14Insert_DeviceId);
            }
            else if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "DeviceType") == 0 )
            {
               AV15Insert_DeviceType = (byte)(GXutil.lval( AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_DeviceType", GXutil.str( AV15Insert_DeviceType, 1, 0));
            }
            AV18GXV1 = (int)(AV18GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18GXV1), 8, 0));
         }
      }
   }

   public void e120D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.usuarioww", new String[] {}, new String[] {}) );
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
   }

   public void zm0D13( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z271UsuarioNom = T000D3_A271UsuarioNom[0] ;
            Z1PersonaId = T000D3_A1PersonaId[0] ;
            Z15DeviceType = T000D3_A15DeviceType[0] ;
            Z16DeviceId = T000D3_A16DeviceId[0] ;
         }
         else
         {
            Z271UsuarioNom = A271UsuarioNom ;
            Z1PersonaId = A1PersonaId ;
            Z15DeviceType = A15DeviceType ;
            Z16DeviceId = A16DeviceId ;
         }
      }
      if ( GX_JID == -16 )
      {
         Z14UsuarioId = A14UsuarioId ;
         Z271UsuarioNom = A271UsuarioNom ;
         Z1PersonaId = A1PersonaId ;
         Z15DeviceType = A15DeviceType ;
         Z16DeviceId = A16DeviceId ;
         Z69PersonaCorreo = A69PersonaCorreo ;
      }
   }

   public void standaloneNotModal( )
   {
      AV17Pgmname = "Usuario" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      imgprompt_1_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.personaprompt"+"',["+"{Ctrl:gx.dom.el('"+"PERSONAID"+"'), id:'"+"PERSONAID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7UsuarioId) )
      {
         A14UsuarioId = AV7UsuarioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
      }
      if ( ! (0==AV7UsuarioId) )
      {
         edtUsuarioId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUsuarioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUsuarioId_Enabled), 5, 0), true);
      }
      else
      {
         edtUsuarioId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUsuarioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUsuarioId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7UsuarioId) )
      {
         edtUsuarioId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUsuarioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUsuarioId_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_DeviceId)==0) )
      {
         edtDeviceId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDeviceId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDeviceId_Enabled), 5, 0), true);
      }
      else
      {
         edtDeviceId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDeviceId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDeviceId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_DeviceType) )
      {
         cmbDeviceType.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbDeviceType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDeviceType.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbDeviceType.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbDeviceType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDeviceType.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_DeviceType) )
      {
         A15DeviceType = AV15Insert_DeviceType ;
         httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_DeviceId)==0) )
      {
         A16DeviceId = AV14Insert_DeviceId ;
         httpContext.ajax_rsp_assign_attri("", false, "A16DeviceId", A16DeviceId);
      }
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
         /* Using cursor T000D4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A1PersonaId)});
         A69PersonaCorreo = T000D4_A69PersonaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
         pr_default.close(2);
      }
   }

   public void load0D13( )
   {
      /* Using cursor T000D6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A14UsuarioId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A271UsuarioNom = T000D6_A271UsuarioNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A271UsuarioNom", A271UsuarioNom);
         A69PersonaCorreo = T000D6_A69PersonaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
         A1PersonaId = T000D6_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         A15DeviceType = T000D6_A15DeviceType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
         A16DeviceId = T000D6_A16DeviceId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16DeviceId", A16DeviceId);
         zm0D13( -16) ;
      }
      pr_default.close(4);
      onLoadActions0D13( ) ;
   }

   public void onLoadActions0D13( )
   {
   }

   public void checkExtendedTable0D13( )
   {
      nIsDirty_13 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000D4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A69PersonaCorreo = T000D4_A69PersonaCorreo[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
      pr_default.close(2);
      /* Using cursor T000D5 */
      pr_default.execute(3, new Object[] {Byte.valueOf(A15DeviceType), A16DeviceId});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Devices", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEVICEID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDeviceType.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( ( A15DeviceType == 0 ) || ( A15DeviceType == 1 ) || ( A15DeviceType == 2 ) || ( A15DeviceType == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Device Type", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "DEVICETYPE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDeviceType.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0D13( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( long A1PersonaId )
   {
      /* Using cursor T000D7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A69PersonaCorreo = T000D7_A69PersonaCorreo[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A69PersonaCorreo)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_18( byte A15DeviceType ,
                          String A16DeviceId )
   {
      /* Using cursor T000D8 */
      pr_default.execute(6, new Object[] {Byte.valueOf(A15DeviceType), A16DeviceId});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Devices", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEVICEID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDeviceType.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0D13( )
   {
      /* Using cursor T000D9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A14UsuarioId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000D3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A14UsuarioId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0D13( 16) ;
         RcdFound13 = (short)(1) ;
         A14UsuarioId = T000D3_A14UsuarioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
         A271UsuarioNom = T000D3_A271UsuarioNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A271UsuarioNom", A271UsuarioNom);
         A1PersonaId = T000D3_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         A15DeviceType = T000D3_A15DeviceType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
         A16DeviceId = T000D3_A16DeviceId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16DeviceId", A16DeviceId);
         Z14UsuarioId = A14UsuarioId ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0D13( ) ;
         if ( AnyError == 1 )
         {
            RcdFound13 = (short)(0) ;
            initializeNonKey0D13( ) ;
         }
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey0D13( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0D13( ) ;
      if ( RcdFound13 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound13 = (short)(0) ;
      /* Using cursor T000D10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A14UsuarioId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000D10_A14UsuarioId[0] < A14UsuarioId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000D10_A14UsuarioId[0] > A14UsuarioId ) ) )
         {
            A14UsuarioId = T000D10_A14UsuarioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
            RcdFound13 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound13 = (short)(0) ;
      /* Using cursor T000D11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A14UsuarioId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000D11_A14UsuarioId[0] > A14UsuarioId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000D11_A14UsuarioId[0] < A14UsuarioId ) ) )
         {
            A14UsuarioId = T000D11_A14UsuarioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
            RcdFound13 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0D13( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtUsuarioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0D13( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound13 == 1 )
         {
            if ( A14UsuarioId != Z14UsuarioId )
            {
               A14UsuarioId = Z14UsuarioId ;
               httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "USUARIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtUsuarioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtUsuarioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0D13( ) ;
               GX_FocusControl = edtUsuarioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A14UsuarioId != Z14UsuarioId )
            {
               /* Insert record */
               GX_FocusControl = edtUsuarioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0D13( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "USUARIOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtUsuarioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtUsuarioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0D13( ) ;
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
      if ( A14UsuarioId != Z14UsuarioId )
      {
         A14UsuarioId = Z14UsuarioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "USUARIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUsuarioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtUsuarioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0D13( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000D2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A14UsuarioId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Usuario"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z271UsuarioNom, T000D2_A271UsuarioNom[0]) != 0 ) || ( Z1PersonaId != T000D2_A1PersonaId[0] ) || ( Z15DeviceType != T000D2_A15DeviceType[0] ) || ( GXutil.strcmp(Z16DeviceId, T000D2_A16DeviceId[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z271UsuarioNom, T000D2_A271UsuarioNom[0]) != 0 )
            {
               GXutil.writeLogln("usuario:[seudo value changed for attri]"+"UsuarioNom");
               GXutil.writeLogRaw("Old: ",Z271UsuarioNom);
               GXutil.writeLogRaw("Current: ",T000D2_A271UsuarioNom[0]);
            }
            if ( Z1PersonaId != T000D2_A1PersonaId[0] )
            {
               GXutil.writeLogln("usuario:[seudo value changed for attri]"+"PersonaId");
               GXutil.writeLogRaw("Old: ",Z1PersonaId);
               GXutil.writeLogRaw("Current: ",T000D2_A1PersonaId[0]);
            }
            if ( Z15DeviceType != T000D2_A15DeviceType[0] )
            {
               GXutil.writeLogln("usuario:[seudo value changed for attri]"+"DeviceType");
               GXutil.writeLogRaw("Old: ",Z15DeviceType);
               GXutil.writeLogRaw("Current: ",T000D2_A15DeviceType[0]);
            }
            if ( GXutil.strcmp(Z16DeviceId, T000D2_A16DeviceId[0]) != 0 )
            {
               GXutil.writeLogln("usuario:[seudo value changed for attri]"+"DeviceId");
               GXutil.writeLogRaw("Old: ",Z16DeviceId);
               GXutil.writeLogRaw("Current: ",T000D2_A16DeviceId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Usuario"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0D13( )
   {
      if ( ! IsAuthorized("usuario_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0D13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D13( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0D13( 0) ;
         checkOptimisticConcurrency0D13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D13( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0D13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000D12 */
                  pr_default.execute(10, new Object[] {Long.valueOf(A14UsuarioId), A271UsuarioNom, Long.valueOf(A1PersonaId), Byte.valueOf(A15DeviceType), A16DeviceId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Usuario");
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
                        resetCaption0D0( ) ;
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
            load0D13( ) ;
         }
         endLevel0D13( ) ;
      }
      closeExtendedTableCursors0D13( ) ;
   }

   public void update0D13( )
   {
      if ( ! IsAuthorized("usuario_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0D13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D13( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D13( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0D13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000D13 */
                  pr_default.execute(11, new Object[] {A271UsuarioNom, Long.valueOf(A1PersonaId), Byte.valueOf(A15DeviceType), A16DeviceId, Long.valueOf(A14UsuarioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Usuario");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Usuario"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0D13( ) ;
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
         endLevel0D13( ) ;
      }
      closeExtendedTableCursors0D13( ) ;
   }

   public void deferredUpdate0D13( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("usuario_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0D13( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D13( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0D13( ) ;
         afterConfirm0D13( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0D13( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000D14 */
               pr_default.execute(12, new Object[] {Long.valueOf(A14UsuarioId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Usuario");
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
      sMode13 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0D13( ) ;
      Gx_mode = sMode13 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0D13( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000D15 */
         pr_default.execute(13, new Object[] {Long.valueOf(A1PersonaId)});
         A69PersonaCorreo = T000D15_A69PersonaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
         pr_default.close(13);
      }
   }

   public void endLevel0D13( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0D13( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         Application.commitDataStores(context, remoteHandle, pr_default, "usuario");
         if ( AnyError == 0 )
         {
            confirmValues0D0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "usuario");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0D13( )
   {
      /* Scan By routine */
      /* Using cursor T000D16 */
      pr_default.execute(14);
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A14UsuarioId = T000D16_A14UsuarioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0D13( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A14UsuarioId = T000D16_A14UsuarioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
      }
   }

   public void scanEnd0D13( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0D13( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0D13( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0D13( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0D13( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0D13( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0D13( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0D13( )
   {
      edtUsuarioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUsuarioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUsuarioId_Enabled), 5, 0), true);
      edtPersonaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      edtPersonaCorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaCorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaCorreo_Enabled), 5, 0), true);
      edtDeviceId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDeviceId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDeviceId_Enabled), 5, 0), true);
      cmbDeviceType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDeviceType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDeviceType.getEnabled(), 5, 0), true);
      edtUsuarioNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUsuarioNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUsuarioNom_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0D13( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0D0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.usuario", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7UsuarioId,11,0))}, new String[] {"Gx_mode","UsuarioId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Usuario");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("usuario:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z14UsuarioId", GXutil.ltrim( localUtil.ntoc( Z14UsuarioId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z271UsuarioNom", GXutil.rtrim( Z271UsuarioNom));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z1PersonaId", GXutil.ltrim( localUtil.ntoc( Z1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z15DeviceType", GXutil.ltrim( localUtil.ntoc( Z15DeviceType, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z16DeviceId", GXutil.rtrim( Z16DeviceId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N1PersonaId", GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N16DeviceId", GXutil.rtrim( A16DeviceId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N15DeviceType", GXutil.ltrim( localUtil.ntoc( A15DeviceType, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSUARIOID", GXutil.ltrim( localUtil.ntoc( AV7UsuarioId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSUARIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7UsuarioId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PERSONAID", GXutil.ltrim( localUtil.ntoc( AV13Insert_PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_DEVICEID", GXutil.rtrim( AV14Insert_DeviceId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_DEVICETYPE", GXutil.ltrim( localUtil.ntoc( AV15Insert_DeviceType, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV17Pgmname));
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
      return formatLink("com.mujermorena.usuario", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7UsuarioId,11,0))}, new String[] {"Gx_mode","UsuarioId"})  ;
   }

   public String getPgmname( )
   {
      return "Usuario" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Usuario", "") ;
   }

   public void initializeNonKey0D13( )
   {
      A1PersonaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      A16DeviceId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A16DeviceId", A16DeviceId);
      A15DeviceType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
      A271UsuarioNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A271UsuarioNom", A271UsuarioNom);
      A69PersonaCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
      Z271UsuarioNom = "" ;
      Z1PersonaId = 0 ;
      Z15DeviceType = (byte)(0) ;
      Z16DeviceId = "" ;
   }

   public void initAll0D13( )
   {
      A14UsuarioId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A14UsuarioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14UsuarioId), 11, 0));
      initializeNonKey0D13( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211192050", true, true);
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
      httpContext.AddJavascriptSource("usuario.js", "?20241211192050", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtUsuarioId_Internalname = "USUARIOID" ;
      edtPersonaId_Internalname = "PERSONAID" ;
      edtPersonaCorreo_Internalname = "PERSONACORREO" ;
      edtDeviceId_Internalname = "DEVICEID" ;
      cmbDeviceType.setInternalname( "DEVICETYPE" );
      edtUsuarioNom_Internalname = "USUARIONOM" ;
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
      Form.setCaption( httpContext.getMessage( "Usuario", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtUsuarioNom_Jsonclick = "" ;
      edtUsuarioNom_Enabled = 1 ;
      cmbDeviceType.setJsonclick( "" );
      cmbDeviceType.setEnabled( 1 );
      edtDeviceId_Jsonclick = "" ;
      edtDeviceId_Enabled = 1 ;
      edtPersonaCorreo_Jsonclick = "" ;
      edtPersonaCorreo_Enabled = 0 ;
      imgprompt_1_Visible = 1 ;
      imgprompt_1_Link = "" ;
      edtPersonaId_Jsonclick = "" ;
      edtPersonaId_Enabled = 1 ;
      edtUsuarioId_Jsonclick = "" ;
      edtUsuarioId_Enabled = 1 ;
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

   public void init_web_controls( )
   {
      cmbDeviceType.setName( "DEVICETYPE" );
      cmbDeviceType.setWebtags( "" );
      cmbDeviceType.addItem("0", httpContext.getMessage( "iOS", ""), (short)(0));
      cmbDeviceType.addItem("1", httpContext.getMessage( "Android", ""), (short)(0));
      cmbDeviceType.addItem("2", httpContext.getMessage( "Blackberry", ""), (short)(0));
      cmbDeviceType.addItem("3", httpContext.getMessage( "Windows", ""), (short)(0));
      if ( cmbDeviceType.getItemCount() > 0 )
      {
         A15DeviceType = (byte)(GXutil.lval( cmbDeviceType.getValidValue(GXutil.trim( GXutil.str( A15DeviceType, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A15DeviceType", GXutil.str( A15DeviceType, 1, 0));
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

   public void valid_Personaid( )
   {
      /* Using cursor T000D15 */
      pr_default.execute(13, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
      }
      A69PersonaCorreo = T000D15_A69PersonaCorreo[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A69PersonaCorreo", A69PersonaCorreo);
   }

   public void valid_Devicetype( )
   {
      A15DeviceType = (byte)(GXutil.lval( cmbDeviceType.getValue())) ;
      /* Using cursor T000D17 */
      pr_default.execute(15, new Object[] {Byte.valueOf(A15DeviceType), A16DeviceId});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Devices", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEVICEID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDeviceType.getInternalname() ;
      }
      pr_default.close(15);
      if ( ! ( ( A15DeviceType == 0 ) || ( A15DeviceType == 1 ) || ( A15DeviceType == 2 ) || ( A15DeviceType == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Device Type", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "DEVICETYPE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDeviceType.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7UsuarioId',fld:'vUSUARIOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7UsuarioId',fld:'vUSUARIOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120D2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_USUARIOID","{handler:'valid_Usuarioid',iparms:[]");
      setEventMetadata("VALID_USUARIOID",",oparms:[]}");
      setEventMetadata("VALID_PERSONAID","{handler:'valid_Personaid',iparms:[{av:'A1PersonaId',fld:'PERSONAID',pic:'ZZZZZZZZZZ9'},{av:'A69PersonaCorreo',fld:'PERSONACORREO',pic:''}]");
      setEventMetadata("VALID_PERSONAID",",oparms:[{av:'A69PersonaCorreo',fld:'PERSONACORREO',pic:''}]}");
      setEventMetadata("VALID_DEVICEID","{handler:'valid_Deviceid',iparms:[]");
      setEventMetadata("VALID_DEVICEID",",oparms:[]}");
      setEventMetadata("VALID_DEVICETYPE","{handler:'valid_Devicetype',iparms:[{av:'cmbDeviceType'},{av:'A15DeviceType',fld:'DEVICETYPE',pic:'9'},{av:'A16DeviceId',fld:'DEVICEID',pic:''}]");
      setEventMetadata("VALID_DEVICETYPE",",oparms:[]}");
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
      return "usuario_Execute";
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
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z271UsuarioNom = "" ;
      Z16DeviceId = "" ;
      N16DeviceId = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A16DeviceId = "" ;
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
      A69PersonaCorreo = "" ;
      A271UsuarioNom = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV14Insert_DeviceId = "" ;
      AV17Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode13 = "" ;
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
      AV16TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z69PersonaCorreo = "" ;
      T000D4_A69PersonaCorreo = new String[] {""} ;
      T000D6_A14UsuarioId = new long[1] ;
      T000D6_A271UsuarioNom = new String[] {""} ;
      T000D6_A69PersonaCorreo = new String[] {""} ;
      T000D6_A1PersonaId = new long[1] ;
      T000D6_A15DeviceType = new byte[1] ;
      T000D6_A16DeviceId = new String[] {""} ;
      T000D5_A15DeviceType = new byte[1] ;
      T000D7_A69PersonaCorreo = new String[] {""} ;
      T000D8_A15DeviceType = new byte[1] ;
      T000D9_A14UsuarioId = new long[1] ;
      T000D3_A14UsuarioId = new long[1] ;
      T000D3_A271UsuarioNom = new String[] {""} ;
      T000D3_A1PersonaId = new long[1] ;
      T000D3_A15DeviceType = new byte[1] ;
      T000D3_A16DeviceId = new String[] {""} ;
      T000D10_A14UsuarioId = new long[1] ;
      T000D11_A14UsuarioId = new long[1] ;
      T000D2_A14UsuarioId = new long[1] ;
      T000D2_A271UsuarioNom = new String[] {""} ;
      T000D2_A1PersonaId = new long[1] ;
      T000D2_A15DeviceType = new byte[1] ;
      T000D2_A16DeviceId = new String[] {""} ;
      T000D15_A69PersonaCorreo = new String[] {""} ;
      T000D16_A14UsuarioId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000D17_A15DeviceType = new byte[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.usuario__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.usuario__default(),
         new Object[] {
             new Object[] {
            T000D2_A14UsuarioId, T000D2_A271UsuarioNom, T000D2_A1PersonaId, T000D2_A15DeviceType, T000D2_A16DeviceId
            }
            , new Object[] {
            T000D3_A14UsuarioId, T000D3_A271UsuarioNom, T000D3_A1PersonaId, T000D3_A15DeviceType, T000D3_A16DeviceId
            }
            , new Object[] {
            T000D4_A69PersonaCorreo
            }
            , new Object[] {
            T000D5_A15DeviceType
            }
            , new Object[] {
            T000D6_A14UsuarioId, T000D6_A271UsuarioNom, T000D6_A69PersonaCorreo, T000D6_A1PersonaId, T000D6_A15DeviceType, T000D6_A16DeviceId
            }
            , new Object[] {
            T000D7_A69PersonaCorreo
            }
            , new Object[] {
            T000D8_A15DeviceType
            }
            , new Object[] {
            T000D9_A14UsuarioId
            }
            , new Object[] {
            T000D10_A14UsuarioId
            }
            , new Object[] {
            T000D11_A14UsuarioId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000D15_A69PersonaCorreo
            }
            , new Object[] {
            T000D16_A14UsuarioId
            }
            , new Object[] {
            T000D17_A15DeviceType
            }
         }
      );
      AV17Pgmname = "Usuario" ;
   }

   private byte Z15DeviceType ;
   private byte N15DeviceType ;
   private byte GxWebError ;
   private byte A15DeviceType ;
   private byte nKeyPressed ;
   private byte AV15Insert_DeviceType ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound13 ;
   private short nIsDirty_13 ;
   private int trnEnded ;
   private int edtUsuarioId_Enabled ;
   private int edtPersonaId_Enabled ;
   private int imgprompt_1_Visible ;
   private int edtPersonaCorreo_Enabled ;
   private int edtDeviceId_Enabled ;
   private int edtUsuarioNom_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV18GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7UsuarioId ;
   private long Z14UsuarioId ;
   private long Z1PersonaId ;
   private long N1PersonaId ;
   private long A1PersonaId ;
   private long AV7UsuarioId ;
   private long A14UsuarioId ;
   private long AV13Insert_PersonaId ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z271UsuarioNom ;
   private String Z16DeviceId ;
   private String N16DeviceId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A16DeviceId ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtUsuarioId_Internalname ;
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
   private String edtUsuarioId_Jsonclick ;
   private String edtPersonaId_Internalname ;
   private String edtPersonaId_Jsonclick ;
   private String imgprompt_1_gximage ;
   private String sImgUrl ;
   private String imgprompt_1_Internalname ;
   private String imgprompt_1_Link ;
   private String edtPersonaCorreo_Internalname ;
   private String edtPersonaCorreo_Jsonclick ;
   private String edtDeviceId_Internalname ;
   private String edtDeviceId_Jsonclick ;
   private String edtUsuarioNom_Internalname ;
   private String A271UsuarioNom ;
   private String edtUsuarioNom_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV14Insert_DeviceId ;
   private String AV17Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode13 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
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
   private String A69PersonaCorreo ;
   private String Z69PersonaCorreo ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbDeviceType ;
   private IDataStoreProvider pr_default ;
   private String[] T000D4_A69PersonaCorreo ;
   private long[] T000D6_A14UsuarioId ;
   private String[] T000D6_A271UsuarioNom ;
   private String[] T000D6_A69PersonaCorreo ;
   private long[] T000D6_A1PersonaId ;
   private byte[] T000D6_A15DeviceType ;
   private String[] T000D6_A16DeviceId ;
   private byte[] T000D5_A15DeviceType ;
   private String[] T000D7_A69PersonaCorreo ;
   private byte[] T000D8_A15DeviceType ;
   private long[] T000D9_A14UsuarioId ;
   private long[] T000D3_A14UsuarioId ;
   private String[] T000D3_A271UsuarioNom ;
   private long[] T000D3_A1PersonaId ;
   private byte[] T000D3_A15DeviceType ;
   private String[] T000D3_A16DeviceId ;
   private long[] T000D10_A14UsuarioId ;
   private long[] T000D11_A14UsuarioId ;
   private long[] T000D2_A14UsuarioId ;
   private String[] T000D2_A271UsuarioNom ;
   private long[] T000D2_A1PersonaId ;
   private byte[] T000D2_A15DeviceType ;
   private String[] T000D2_A16DeviceId ;
   private String[] T000D15_A69PersonaCorreo ;
   private long[] T000D16_A14UsuarioId ;
   private byte[] T000D17_A15DeviceType ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
}

final  class usuario__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class usuario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000D2", "SELECT [UsuarioId], [UsuarioNom], [PersonaId], [DeviceType], [DeviceId] FROM [Usuario] WITH (UPDLOCK) WHERE [UsuarioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D3", "SELECT [UsuarioId], [UsuarioNom], [PersonaId], [DeviceType], [DeviceId] FROM [Usuario] WHERE [UsuarioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D4", "SELECT [PersonaCorreo] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D5", "SELECT [DeviceType] FROM [Devices] WHERE [DeviceType] = ? AND [DeviceId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D6", "SELECT TM1.[UsuarioId], TM1.[UsuarioNom], T2.[PersonaCorreo], TM1.[PersonaId], TM1.[DeviceType], TM1.[DeviceId] FROM ([Usuario] TM1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = TM1.[PersonaId]) WHERE TM1.[UsuarioId] = ? ORDER BY TM1.[UsuarioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D7", "SELECT [PersonaCorreo] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D8", "SELECT [DeviceType] FROM [Devices] WHERE [DeviceType] = ? AND [DeviceId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D9", "SELECT [UsuarioId] FROM [Usuario] WHERE [UsuarioId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D10", "SELECT TOP 1 [UsuarioId] FROM [Usuario] WHERE ( [UsuarioId] > ?) ORDER BY [UsuarioId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000D11", "SELECT TOP 1 [UsuarioId] FROM [Usuario] WHERE ( [UsuarioId] < ?) ORDER BY [UsuarioId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000D12", "INSERT INTO [Usuario]([UsuarioId], [UsuarioNom], [PersonaId], [DeviceType], [DeviceId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000D13", "UPDATE [Usuario] SET [UsuarioNom]=?, [PersonaId]=?, [DeviceType]=?, [DeviceId]=?  WHERE [UsuarioId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000D14", "DELETE FROM [Usuario]  WHERE [UsuarioId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000D15", "SELECT [PersonaCorreo] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D16", "SELECT [UsuarioId] FROM [Usuario] ORDER BY [UsuarioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D17", "SELECT [DeviceType] FROM [Devices] WHERE [DeviceType] = ? AND [DeviceId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 128);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 128);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 128);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 128);
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 6 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 128);
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
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 128);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 128);
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 128);
               return;
      }
   }

}

