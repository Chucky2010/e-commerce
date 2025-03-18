package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class proveedor_impl extends GXDataArea
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
            AV7ProveedorId = GXutil.lval( httpContext.GetPar( "ProveedorId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ProveedorId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROVEEDORID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ProveedorId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Proveedor", ""), (short)(0)) ;
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

   public proveedor_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public proveedor_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( proveedor_impl.class ));
   }

   public proveedor_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Proveedor", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Proveedor.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProveedorId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtProveedorId_Internalname, httpContext.getMessage( "Proveedor Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtProveedorId_Internalname, GXutil.ltrim( localUtil.ntoc( A10ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A10ProveedorId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProveedorId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtProveedorId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Proveedor.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaId_Internalname, GXutil.ltrim( localUtil.ntoc( A1PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1PersonaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Proveedor.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_1_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_1_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_1_Internalname, sImgUrl, imgprompt_1_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_1_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Proveedor.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaNombreCompleto_Internalname, GXutil.rtrim( A59PersonaNombreCompleto), GXutil.rtrim( localUtil.format( A59PersonaNombreCompleto, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaNombreCompleto_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Proveedor.htm");
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
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtPersonaDireccion_Internalname, A57PersonaDireccion, "", "", (short)(0), 1, edtPersonaDireccion_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "256", -1, 0, "", "", (byte)(-1), true, "Direccion", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Proveedor.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPersonaTelefono_Internalname, GXutil.rtrim( A66PersonaTelefono), GXutil.rtrim( localUtil.format( A66PersonaTelefono, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPersonaTelefono_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPersonaTelefono_Enabled, 0, "text", "", 25, "chr", 1, "row", 25, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Telefono", "left", true, "", "HLP_Proveedor.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Proveedor.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Proveedor.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Proveedor.htm");
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
      e110A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z10ProveedorId = localUtil.ctol( httpContext.cgiGet( "Z10ProveedorId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z1PersonaId = localUtil.ctol( httpContext.cgiGet( "Z1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1PersonaId = localUtil.ctol( httpContext.cgiGet( "N1PersonaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A55PersonaNombre = httpContext.cgiGet( "PERSONANOMBRE") ;
            A56PersonaApellido = httpContext.cgiGet( "PERSONAAPELLIDO") ;
            AV7ProveedorId = localUtil.ctol( httpContext.cgiGet( "vPROVEEDORID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV13Insert_PersonaId = localUtil.ctol( httpContext.cgiGet( "vINSERT_PERSONAID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Proveedor");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A10ProveedorId != Z10ProveedorId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("proveedor:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A10ProveedorId = GXutil.lval( httpContext.GetPar( "ProveedorId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
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
                  sMode10 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound10 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0A0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PROVEEDORID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtProveedorId_Internalname ;
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
                        e110A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120A2 ();
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
         e120A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0A10( ) ;
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
         disableAttributes0A10( ) ;
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

   public void confirm_0A0( )
   {
      beforeValidate0A10( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0A10( ) ;
         }
         else
         {
            checkExtendedTable0A10( ) ;
            closeExtendedTableCursors0A10( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0A0( )
   {
   }

   public void e110A2( )
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

   public void e120A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.proveedorww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0A10( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1PersonaId = T000A3_A1PersonaId[0] ;
         }
         else
         {
            Z1PersonaId = A1PersonaId ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z10ProveedorId = A10ProveedorId ;
         Z1PersonaId = A1PersonaId ;
         Z57PersonaDireccion = A57PersonaDireccion ;
         Z66PersonaTelefono = A66PersonaTelefono ;
         Z55PersonaNombre = A55PersonaNombre ;
         Z56PersonaApellido = A56PersonaApellido ;
      }
   }

   public void standaloneNotModal( )
   {
      AV15Pgmname = "Proveedor" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      imgprompt_1_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.personaprompt"+"',["+"{Ctrl:gx.dom.el('"+"PERSONAID"+"'), id:'"+"PERSONAID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7ProveedorId) )
      {
         A10ProveedorId = AV7ProveedorId ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
      }
      if ( ! (0==AV7ProveedorId) )
      {
         edtProveedorId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
      }
      else
      {
         edtProveedorId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7ProveedorId) )
      {
         edtProveedorId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
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
         /* Using cursor T000A4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A1PersonaId)});
         A57PersonaDireccion = T000A4_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A66PersonaTelefono = T000A4_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A55PersonaNombre = T000A4_A55PersonaNombre[0] ;
         A56PersonaApellido = T000A4_A56PersonaApellido[0] ;
         pr_default.close(2);
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      }
   }

   public void load0A10( )
   {
      /* Using cursor T000A5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A57PersonaDireccion = T000A5_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A66PersonaTelefono = T000A5_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A55PersonaNombre = T000A5_A55PersonaNombre[0] ;
         A56PersonaApellido = T000A5_A56PersonaApellido[0] ;
         A1PersonaId = T000A5_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         zm0A10( -10) ;
      }
      pr_default.close(3);
      onLoadActions0A10( ) ;
   }

   public void onLoadActions0A10( )
   {
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
   }

   public void checkExtendedTable0A10( )
   {
      nIsDirty_10 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000A4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A57PersonaDireccion = T000A4_A57PersonaDireccion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A66PersonaTelefono = T000A4_A66PersonaTelefono[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A55PersonaNombre = T000A4_A55PersonaNombre[0] ;
      A56PersonaApellido = T000A4_A56PersonaApellido[0] ;
      pr_default.close(2);
      nIsDirty_10 = (short)(1) ;
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
   }

   public void closeExtendedTableCursors0A10( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( long A1PersonaId )
   {
      /* Using cursor T000A6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A57PersonaDireccion = T000A6_A57PersonaDireccion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A66PersonaTelefono = T000A6_A66PersonaTelefono[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A55PersonaNombre = T000A6_A55PersonaNombre[0] ;
      A56PersonaApellido = T000A6_A56PersonaApellido[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A57PersonaDireccion)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A66PersonaTelefono))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A55PersonaNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A56PersonaApellido))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey0A10( )
   {
      /* Using cursor T000A7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound10 = (short)(1) ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000A3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0A10( 10) ;
         RcdFound10 = (short)(1) ;
         A10ProveedorId = T000A3_A10ProveedorId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
         A1PersonaId = T000A3_A1PersonaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
         Z10ProveedorId = A10ProveedorId ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0A10( ) ;
         if ( AnyError == 1 )
         {
            RcdFound10 = (short)(0) ;
            initializeNonKey0A10( ) ;
         }
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound10 = (short)(0) ;
         initializeNonKey0A10( ) ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0A10( ) ;
      if ( RcdFound10 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound10 = (short)(0) ;
      /* Using cursor T000A8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T000A8_A10ProveedorId[0] < A10ProveedorId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T000A8_A10ProveedorId[0] > A10ProveedorId ) ) )
         {
            A10ProveedorId = T000A8_A10ProveedorId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
            RcdFound10 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound10 = (short)(0) ;
      /* Using cursor T000A9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A10ProveedorId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000A9_A10ProveedorId[0] > A10ProveedorId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000A9_A10ProveedorId[0] < A10ProveedorId ) ) )
         {
            A10ProveedorId = T000A9_A10ProveedorId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
            RcdFound10 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0A10( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0A10( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound10 == 1 )
         {
            if ( A10ProveedorId != Z10ProveedorId )
            {
               A10ProveedorId = Z10ProveedorId ;
               httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PROVEEDORID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0A10( ) ;
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A10ProveedorId != Z10ProveedorId )
            {
               /* Insert record */
               GX_FocusControl = edtProveedorId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0A10( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PROVEEDORID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtProveedorId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtProveedorId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0A10( ) ;
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
      if ( A10ProveedorId != Z10ProveedorId )
      {
         A10ProveedorId = Z10ProveedorId ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PROVEEDORID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtProveedorId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0A10( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000A2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A10ProveedorId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Proveedor"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1PersonaId != T000A2_A1PersonaId[0] ) )
         {
            if ( Z1PersonaId != T000A2_A1PersonaId[0] )
            {
               GXutil.writeLogln("proveedor:[seudo value changed for attri]"+"PersonaId");
               GXutil.writeLogRaw("Old: ",Z1PersonaId);
               GXutil.writeLogRaw("Current: ",T000A2_A1PersonaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Proveedor"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A10( )
   {
      if ( ! IsAuthorized("proveedor_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0A10( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A10( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A10( 0) ;
         checkOptimisticConcurrency0A10( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A10( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A10( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A10 */
                  pr_default.execute(8, new Object[] {Long.valueOf(A10ProveedorId), Long.valueOf(A1PersonaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Proveedor");
                  if ( (pr_default.getStatus(8) == 1) )
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
                        resetCaption0A0( ) ;
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
            load0A10( ) ;
         }
         endLevel0A10( ) ;
      }
      closeExtendedTableCursors0A10( ) ;
   }

   public void update0A10( )
   {
      if ( ! IsAuthorized("proveedor_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0A10( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A10( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A10( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A10( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A10( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A11 */
                  pr_default.execute(9, new Object[] {Long.valueOf(A1PersonaId), Long.valueOf(A10ProveedorId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Proveedor");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Proveedor"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A10( ) ;
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
         endLevel0A10( ) ;
      }
      closeExtendedTableCursors0A10( ) ;
   }

   public void deferredUpdate0A10( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("proveedor_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0A10( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A10( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A10( ) ;
         afterConfirm0A10( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A10( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000A12 */
               pr_default.execute(10, new Object[] {Long.valueOf(A10ProveedorId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Proveedor");
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
      sMode10 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0A10( ) ;
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0A10( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000A13 */
         pr_default.execute(11, new Object[] {Long.valueOf(A1PersonaId)});
         A57PersonaDireccion = T000A13_A57PersonaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
         A66PersonaTelefono = T000A13_A66PersonaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
         A55PersonaNombre = T000A13_A55PersonaNombre[0] ;
         A56PersonaApellido = T000A13_A56PersonaApellido[0] ;
         pr_default.close(11);
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000A14 */
         pr_default.execute(12, new Object[] {Long.valueOf(A10ProveedorId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Compras", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel0A10( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0A10( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(11);
         Application.commitDataStores(context, remoteHandle, pr_default, "proveedor");
         if ( AnyError == 0 )
         {
            confirmValues0A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(11);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "proveedor");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0A10( )
   {
      /* Scan By routine */
      /* Using cursor T000A15 */
      pr_default.execute(13);
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A10ProveedorId = T000A15_A10ProveedorId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0A10( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A10ProveedorId = T000A15_A10ProveedorId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
      }
   }

   public void scanEnd0A10( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0A10( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A10( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A10( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A10( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A10( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A10( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A10( )
   {
      edtProveedorId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProveedorId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProveedorId_Enabled), 5, 0), true);
      edtPersonaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaId_Enabled), 5, 0), true);
      edtPersonaNombreCompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaNombreCompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaNombreCompleto_Enabled), 5, 0), true);
      edtPersonaDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaDireccion_Enabled), 5, 0), true);
      edtPersonaTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPersonaTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPersonaTelefono_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0A10( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0A0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.proveedor", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ProveedorId,11,0))}, new String[] {"Gx_mode","ProveedorId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Proveedor");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("proveedor:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z10ProveedorId", GXutil.ltrim( localUtil.ntoc( Z10ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPROVEEDORID", GXutil.ltrim( localUtil.ntoc( AV7ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROVEEDORID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ProveedorId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PERSONAID", GXutil.ltrim( localUtil.ntoc( AV13Insert_PersonaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
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
      return formatLink("com.mujermorena.proveedor", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ProveedorId,11,0))}, new String[] {"Gx_mode","ProveedorId"})  ;
   }

   public String getPgmname( )
   {
      return "Proveedor" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Proveedor", "") ;
   }

   public void initializeNonKey0A10( )
   {
      A1PersonaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1PersonaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1PersonaId), 11, 0));
      A59PersonaNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
      A57PersonaDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      A66PersonaTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", A66PersonaTelefono);
      A55PersonaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", A55PersonaNombre);
      A56PersonaApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", A56PersonaApellido);
      Z1PersonaId = 0 ;
   }

   public void initAll0A10( )
   {
      A10ProveedorId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
      initializeNonKey0A10( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211191169", true, true);
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
      httpContext.AddJavascriptSource("proveedor.js", "?20241211191169", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtProveedorId_Internalname = "PROVEEDORID" ;
      edtPersonaId_Internalname = "PERSONAID" ;
      edtPersonaNombreCompleto_Internalname = "PERSONANOMBRECOMPLETO" ;
      edtPersonaDireccion_Internalname = "PERSONADIRECCION" ;
      edtPersonaTelefono_Internalname = "PERSONATELEFONO" ;
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
      Form.setCaption( httpContext.getMessage( "Proveedor", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPersonaTelefono_Jsonclick = "" ;
      edtPersonaTelefono_Enabled = 0 ;
      edtPersonaDireccion_Enabled = 0 ;
      edtPersonaNombreCompleto_Jsonclick = "" ;
      edtPersonaNombreCompleto_Enabled = 0 ;
      imgprompt_1_Visible = 1 ;
      imgprompt_1_Link = "" ;
      edtPersonaId_Jsonclick = "" ;
      edtPersonaId_Enabled = 1 ;
      edtProveedorId_Jsonclick = "" ;
      edtProveedorId_Enabled = 1 ;
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
      /* Using cursor T000A13 */
      pr_default.execute(11, new Object[] {Long.valueOf(A1PersonaId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Persona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERSONAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPersonaId_Internalname ;
      }
      A57PersonaDireccion = T000A13_A57PersonaDireccion[0] ;
      A66PersonaTelefono = T000A13_A66PersonaTelefono[0] ;
      A55PersonaNombre = T000A13_A55PersonaNombre[0] ;
      A56PersonaApellido = T000A13_A56PersonaApellido[0] ;
      pr_default.close(11);
      A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A57PersonaDireccion", A57PersonaDireccion);
      httpContext.ajax_rsp_assign_attri("", false, "A66PersonaTelefono", GXutil.rtrim( A66PersonaTelefono));
      httpContext.ajax_rsp_assign_attri("", false, "A55PersonaNombre", GXutil.rtrim( A55PersonaNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A56PersonaApellido", GXutil.rtrim( A56PersonaApellido));
      httpContext.ajax_rsp_assign_attri("", false, "A59PersonaNombreCompleto", GXutil.rtrim( A59PersonaNombreCompleto));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ProveedorId',fld:'vPROVEEDORID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7ProveedorId',fld:'vPROVEEDORID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120A2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PROVEEDORID","{handler:'valid_Proveedorid',iparms:[]");
      setEventMetadata("VALID_PROVEEDORID",",oparms:[]}");
      setEventMetadata("VALID_PERSONAID","{handler:'valid_Personaid',iparms:[{av:'A1PersonaId',fld:'PERSONAID',pic:'ZZZZZZZZZZ9'},{av:'A55PersonaNombre',fld:'PERSONANOMBRE',pic:''},{av:'A56PersonaApellido',fld:'PERSONAAPELLIDO',pic:''},{av:'A57PersonaDireccion',fld:'PERSONADIRECCION',pic:''},{av:'A66PersonaTelefono',fld:'PERSONATELEFONO',pic:''},{av:'A59PersonaNombreCompleto',fld:'PERSONANOMBRECOMPLETO',pic:''}]");
      setEventMetadata("VALID_PERSONAID",",oparms:[{av:'A57PersonaDireccion',fld:'PERSONADIRECCION',pic:''},{av:'A66PersonaTelefono',fld:'PERSONATELEFONO',pic:''},{av:'A55PersonaNombre',fld:'PERSONANOMBRE',pic:''},{av:'A56PersonaApellido',fld:'PERSONAAPELLIDO',pic:''},{av:'A59PersonaNombreCompleto',fld:'PERSONANOMBRECOMPLETO',pic:''}]}");
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
      return "proveedor_Execute";
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
      pr_default.close(11);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
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
      imgprompt_1_gximage = "" ;
      sImgUrl = "" ;
      A59PersonaNombreCompleto = "" ;
      A57PersonaDireccion = "" ;
      A66PersonaTelefono = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A55PersonaNombre = "" ;
      A56PersonaApellido = "" ;
      AV15Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode10 = "" ;
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
      T000A4_A57PersonaDireccion = new String[] {""} ;
      T000A4_A66PersonaTelefono = new String[] {""} ;
      T000A4_A55PersonaNombre = new String[] {""} ;
      T000A4_A56PersonaApellido = new String[] {""} ;
      T000A5_A10ProveedorId = new long[1] ;
      T000A5_A57PersonaDireccion = new String[] {""} ;
      T000A5_A66PersonaTelefono = new String[] {""} ;
      T000A5_A55PersonaNombre = new String[] {""} ;
      T000A5_A56PersonaApellido = new String[] {""} ;
      T000A5_A1PersonaId = new long[1] ;
      T000A6_A57PersonaDireccion = new String[] {""} ;
      T000A6_A66PersonaTelefono = new String[] {""} ;
      T000A6_A55PersonaNombre = new String[] {""} ;
      T000A6_A56PersonaApellido = new String[] {""} ;
      T000A7_A10ProveedorId = new long[1] ;
      T000A3_A10ProveedorId = new long[1] ;
      T000A3_A1PersonaId = new long[1] ;
      T000A8_A10ProveedorId = new long[1] ;
      T000A9_A10ProveedorId = new long[1] ;
      T000A2_A10ProveedorId = new long[1] ;
      T000A2_A1PersonaId = new long[1] ;
      T000A13_A57PersonaDireccion = new String[] {""} ;
      T000A13_A66PersonaTelefono = new String[] {""} ;
      T000A13_A55PersonaNombre = new String[] {""} ;
      T000A13_A56PersonaApellido = new String[] {""} ;
      T000A14_A11ComprasId = new long[1] ;
      T000A15_A10ProveedorId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Z59PersonaNombreCompleto = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.proveedor__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.proveedor__default(),
         new Object[] {
             new Object[] {
            T000A2_A10ProveedorId, T000A2_A1PersonaId
            }
            , new Object[] {
            T000A3_A10ProveedorId, T000A3_A1PersonaId
            }
            , new Object[] {
            T000A4_A57PersonaDireccion, T000A4_A66PersonaTelefono, T000A4_A55PersonaNombre, T000A4_A56PersonaApellido
            }
            , new Object[] {
            T000A5_A10ProveedorId, T000A5_A57PersonaDireccion, T000A5_A66PersonaTelefono, T000A5_A55PersonaNombre, T000A5_A56PersonaApellido, T000A5_A1PersonaId
            }
            , new Object[] {
            T000A6_A57PersonaDireccion, T000A6_A66PersonaTelefono, T000A6_A55PersonaNombre, T000A6_A56PersonaApellido
            }
            , new Object[] {
            T000A7_A10ProveedorId
            }
            , new Object[] {
            T000A8_A10ProveedorId
            }
            , new Object[] {
            T000A9_A10ProveedorId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000A13_A57PersonaDireccion, T000A13_A66PersonaTelefono, T000A13_A55PersonaNombre, T000A13_A56PersonaApellido
            }
            , new Object[] {
            T000A14_A11ComprasId
            }
            , new Object[] {
            T000A15_A10ProveedorId
            }
         }
      );
      AV15Pgmname = "Proveedor" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound10 ;
   private short nIsDirty_10 ;
   private int trnEnded ;
   private int edtProveedorId_Enabled ;
   private int edtPersonaId_Enabled ;
   private int imgprompt_1_Visible ;
   private int edtPersonaNombreCompleto_Enabled ;
   private int edtPersonaDireccion_Enabled ;
   private int edtPersonaTelefono_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV16GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7ProveedorId ;
   private long Z10ProveedorId ;
   private long Z1PersonaId ;
   private long N1PersonaId ;
   private long A1PersonaId ;
   private long AV7ProveedorId ;
   private long A10ProveedorId ;
   private long AV13Insert_PersonaId ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
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
   private String TempTags ;
   private String edtProveedorId_Jsonclick ;
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
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String A55PersonaNombre ;
   private String A56PersonaApellido ;
   private String AV15Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode10 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z66PersonaTelefono ;
   private String Z55PersonaNombre ;
   private String Z56PersonaApellido ;
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
   private String[] T000A4_A57PersonaDireccion ;
   private String[] T000A4_A66PersonaTelefono ;
   private String[] T000A4_A55PersonaNombre ;
   private String[] T000A4_A56PersonaApellido ;
   private long[] T000A5_A10ProveedorId ;
   private String[] T000A5_A57PersonaDireccion ;
   private String[] T000A5_A66PersonaTelefono ;
   private String[] T000A5_A55PersonaNombre ;
   private String[] T000A5_A56PersonaApellido ;
   private long[] T000A5_A1PersonaId ;
   private String[] T000A6_A57PersonaDireccion ;
   private String[] T000A6_A66PersonaTelefono ;
   private String[] T000A6_A55PersonaNombre ;
   private String[] T000A6_A56PersonaApellido ;
   private long[] T000A7_A10ProveedorId ;
   private long[] T000A3_A10ProveedorId ;
   private long[] T000A3_A1PersonaId ;
   private long[] T000A8_A10ProveedorId ;
   private long[] T000A9_A10ProveedorId ;
   private long[] T000A2_A10ProveedorId ;
   private long[] T000A2_A1PersonaId ;
   private String[] T000A13_A57PersonaDireccion ;
   private String[] T000A13_A66PersonaTelefono ;
   private String[] T000A13_A55PersonaNombre ;
   private String[] T000A13_A56PersonaApellido ;
   private long[] T000A14_A11ComprasId ;
   private long[] T000A15_A10ProveedorId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class proveedor__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class proveedor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000A2", "SELECT [ProveedorId], [PersonaId] FROM [Proveedor] WITH (UPDLOCK) WHERE [ProveedorId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A3", "SELECT [ProveedorId], [PersonaId] FROM [Proveedor] WHERE [ProveedorId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A4", "SELECT [PersonaDireccion], [PersonaTelefono], [PersonaNombre], [PersonaApellido] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A5", "SELECT TM1.[ProveedorId], T2.[PersonaDireccion], T2.[PersonaTelefono], T2.[PersonaNombre], T2.[PersonaApellido], TM1.[PersonaId] FROM ([Proveedor] TM1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = TM1.[PersonaId]) WHERE TM1.[ProveedorId] = ? ORDER BY TM1.[ProveedorId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A6", "SELECT [PersonaDireccion], [PersonaTelefono], [PersonaNombre], [PersonaApellido] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A7", "SELECT [ProveedorId] FROM [Proveedor] WHERE [ProveedorId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A8", "SELECT TOP 1 [ProveedorId] FROM [Proveedor] WHERE ( [ProveedorId] > ?) ORDER BY [ProveedorId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A9", "SELECT TOP 1 [ProveedorId] FROM [Proveedor] WHERE ( [ProveedorId] < ?) ORDER BY [ProveedorId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000A10", "INSERT INTO [Proveedor]([ProveedorId], [PersonaId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000A11", "UPDATE [Proveedor] SET [PersonaId]=?  WHERE [ProveedorId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000A12", "DELETE FROM [Proveedor]  WHERE [ProveedorId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000A13", "SELECT [PersonaDireccion], [PersonaTelefono], [PersonaNombre], [PersonaApellido] FROM [Persona] WHERE [PersonaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A14", "SELECT TOP 1 [ComprasId] FROM [Compras] WHERE [ProveedorId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A15", "SELECT [ProveedorId] FROM [Proveedor] ORDER BY [ProveedorId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 25);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 25);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 25);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 25);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
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
      }
   }

}

