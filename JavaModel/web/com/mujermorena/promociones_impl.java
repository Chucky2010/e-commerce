package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class promociones_impl extends GXDataArea
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
      gxfirstwebparm = httpContext.GetNextPar( ) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Promociones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPromocionesId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public promociones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public promociones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( promociones_impl.class ));
   }

   public promociones_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "WWAdvancedContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Promociones", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Promociones.htm");
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
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 ToolbarCellClass", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCellAdvanced", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPromocionesId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPromocionesId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPromocionesId_Internalname, GXutil.ltrim( localUtil.ntoc( A22PromocionesId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPromocionesId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A22PromocionesId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A22PromocionesId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPromocionesId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPromocionesId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPromocionesNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPromocionesNombre_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPromocionesNombre_Internalname, GXutil.rtrim( A104PromocionesNombre), GXutil.rtrim( localUtil.format( A104PromocionesNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPromocionesNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPromocionesNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPromocionesDetalle_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPromocionesDetalle_Internalname, httpContext.getMessage( "Detalle", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPromocionesDetalle_Internalname, A105PromocionesDetalle, GXutil.rtrim( localUtil.format( A105PromocionesDetalle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPromocionesDetalle_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPromocionesDetalle_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Detalle", "left", true, "", "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPromocionesPrecio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPromocionesPrecio_Internalname, httpContext.getMessage( "Precio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPromocionesPrecio_Internalname, GXutil.ltrim( localUtil.ntoc( A106PromocionesPrecio, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPromocionesPrecio_Enabled!=0) ? localUtil.format( A106PromocionesPrecio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A106PromocionesPrecio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPromocionesPrecio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPromocionesPrecio_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPromocionesCantidad_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPromocionesCantidad_Internalname, httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPromocionesCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A107PromocionesCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPromocionesCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A107PromocionesCantidad), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A107PromocionesCantidad), "ZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPromocionesCantidad_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPromocionesCantidad_Enabled, 0, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Cantidad", "right", false, "", "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Promociones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z22PromocionesId = localUtil.ctol( httpContext.cgiGet( "Z22PromocionesId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z104PromocionesNombre = httpContext.cgiGet( "Z104PromocionesNombre") ;
         Z105PromocionesDetalle = httpContext.cgiGet( "Z105PromocionesDetalle") ;
         Z106PromocionesPrecio = localUtil.ctond( httpContext.cgiGet( "Z106PromocionesPrecio")) ;
         Z107PromocionesCantidad = (int)(localUtil.ctol( httpContext.cgiGet( "Z107PromocionesCantidad"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPromocionesId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPromocionesId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROMOCIONESID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPromocionesId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A22PromocionesId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
         }
         else
         {
            A22PromocionesId = localUtil.ctol( httpContext.cgiGet( edtPromocionesId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
         }
         A104PromocionesNombre = httpContext.cgiGet( edtPromocionesNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PromocionesNombre", A104PromocionesNombre);
         A105PromocionesDetalle = httpContext.cgiGet( edtPromocionesDetalle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PromocionesDetalle", A105PromocionesDetalle);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPromocionesPrecio_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPromocionesPrecio_Internalname)), DecimalUtil.stringToDec("99999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROMOCIONESPRECIO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPromocionesPrecio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A106PromocionesPrecio = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A106PromocionesPrecio", GXutil.ltrimstr( A106PromocionesPrecio, 17, 2));
         }
         else
         {
            A106PromocionesPrecio = localUtil.ctond( httpContext.cgiGet( edtPromocionesPrecio_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A106PromocionesPrecio", GXutil.ltrimstr( A106PromocionesPrecio, 17, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPromocionesCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPromocionesCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROMOCIONESCANTIDAD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPromocionesCantidad_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A107PromocionesCantidad = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A107PromocionesCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A107PromocionesCantidad), 5, 0));
         }
         else
         {
            A107PromocionesCantidad = (int)(localUtil.ctol( httpContext.cgiGet( edtPromocionesCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A107PromocionesCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A107PromocionesCantidad), 5, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A22PromocionesId = GXutil.lval( httpContext.GetPar( "PromocionesId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
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
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0J20( ) ;
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
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes0J20( ) ;
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

   public void resetCaption0J0( )
   {
   }

   public void zm0J20( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z104PromocionesNombre = T000J3_A104PromocionesNombre[0] ;
            Z105PromocionesDetalle = T000J3_A105PromocionesDetalle[0] ;
            Z106PromocionesPrecio = T000J3_A106PromocionesPrecio[0] ;
            Z107PromocionesCantidad = T000J3_A107PromocionesCantidad[0] ;
         }
         else
         {
            Z104PromocionesNombre = A104PromocionesNombre ;
            Z105PromocionesDetalle = A105PromocionesDetalle ;
            Z106PromocionesPrecio = A106PromocionesPrecio ;
            Z107PromocionesCantidad = A107PromocionesCantidad ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z22PromocionesId = A22PromocionesId ;
         Z104PromocionesNombre = A104PromocionesNombre ;
         Z105PromocionesDetalle = A105PromocionesDetalle ;
         Z106PromocionesPrecio = A106PromocionesPrecio ;
         Z107PromocionesCantidad = A107PromocionesCantidad ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load0J20( )
   {
      /* Using cursor T000J4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A22PromocionesId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A104PromocionesNombre = T000J4_A104PromocionesNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PromocionesNombre", A104PromocionesNombre);
         A105PromocionesDetalle = T000J4_A105PromocionesDetalle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PromocionesDetalle", A105PromocionesDetalle);
         A106PromocionesPrecio = T000J4_A106PromocionesPrecio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PromocionesPrecio", GXutil.ltrimstr( A106PromocionesPrecio, 17, 2));
         A107PromocionesCantidad = T000J4_A107PromocionesCantidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A107PromocionesCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A107PromocionesCantidad), 5, 0));
         zm0J20( -1) ;
      }
      pr_default.close(2);
      onLoadActions0J20( ) ;
   }

   public void onLoadActions0J20( )
   {
   }

   public void checkExtendedTable0J20( )
   {
      nIsDirty_20 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors0J20( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0J20( )
   {
      /* Using cursor T000J5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A22PromocionesId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound20 = (short)(1) ;
      }
      else
      {
         RcdFound20 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000J3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A22PromocionesId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0J20( 1) ;
         RcdFound20 = (short)(1) ;
         A22PromocionesId = T000J3_A22PromocionesId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
         A104PromocionesNombre = T000J3_A104PromocionesNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PromocionesNombre", A104PromocionesNombre);
         A105PromocionesDetalle = T000J3_A105PromocionesDetalle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PromocionesDetalle", A105PromocionesDetalle);
         A106PromocionesPrecio = T000J3_A106PromocionesPrecio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PromocionesPrecio", GXutil.ltrimstr( A106PromocionesPrecio, 17, 2));
         A107PromocionesCantidad = T000J3_A107PromocionesCantidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A107PromocionesCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A107PromocionesCantidad), 5, 0));
         Z22PromocionesId = A22PromocionesId ;
         sMode20 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0J20( ) ;
         if ( AnyError == 1 )
         {
            RcdFound20 = (short)(0) ;
            initializeNonKey0J20( ) ;
         }
         Gx_mode = sMode20 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound20 = (short)(0) ;
         initializeNonKey0J20( ) ;
         sMode20 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode20 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0J20( ) ;
      if ( RcdFound20 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound20 = (short)(0) ;
      /* Using cursor T000J6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A22PromocionesId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T000J6_A22PromocionesId[0] < A22PromocionesId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T000J6_A22PromocionesId[0] > A22PromocionesId ) ) )
         {
            A22PromocionesId = T000J6_A22PromocionesId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
            RcdFound20 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound20 = (short)(0) ;
      /* Using cursor T000J7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A22PromocionesId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T000J7_A22PromocionesId[0] > A22PromocionesId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T000J7_A22PromocionesId[0] < A22PromocionesId ) ) )
         {
            A22PromocionesId = T000J7_A22PromocionesId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
            RcdFound20 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0J20( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPromocionesId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0J20( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound20 == 1 )
         {
            if ( A22PromocionesId != Z22PromocionesId )
            {
               A22PromocionesId = Z22PromocionesId ;
               httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PROMOCIONESID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPromocionesId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPromocionesId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0J20( ) ;
               GX_FocusControl = edtPromocionesId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A22PromocionesId != Z22PromocionesId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtPromocionesId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0J20( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PROMOCIONESID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPromocionesId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtPromocionesId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0J20( ) ;
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
   }

   public void btn_delete( )
   {
      if ( A22PromocionesId != Z22PromocionesId )
      {
         A22PromocionesId = Z22PromocionesId ;
         httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PROMOCIONESID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPromocionesId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPromocionesId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "PROMOCIONESID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPromocionesId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtPromocionesNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0J20( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPromocionesNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0J20( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPromocionesNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPromocionesNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0J20( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound20 != 0 )
         {
            scanNext0J20( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPromocionesNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0J20( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0J20( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000J2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A22PromocionesId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Promociones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z104PromocionesNombre, T000J2_A104PromocionesNombre[0]) != 0 ) || ( GXutil.strcmp(Z105PromocionesDetalle, T000J2_A105PromocionesDetalle[0]) != 0 ) || ( DecimalUtil.compareTo(Z106PromocionesPrecio, T000J2_A106PromocionesPrecio[0]) != 0 ) || ( Z107PromocionesCantidad != T000J2_A107PromocionesCantidad[0] ) )
         {
            if ( GXutil.strcmp(Z104PromocionesNombre, T000J2_A104PromocionesNombre[0]) != 0 )
            {
               GXutil.writeLogln("promociones:[seudo value changed for attri]"+"PromocionesNombre");
               GXutil.writeLogRaw("Old: ",Z104PromocionesNombre);
               GXutil.writeLogRaw("Current: ",T000J2_A104PromocionesNombre[0]);
            }
            if ( GXutil.strcmp(Z105PromocionesDetalle, T000J2_A105PromocionesDetalle[0]) != 0 )
            {
               GXutil.writeLogln("promociones:[seudo value changed for attri]"+"PromocionesDetalle");
               GXutil.writeLogRaw("Old: ",Z105PromocionesDetalle);
               GXutil.writeLogRaw("Current: ",T000J2_A105PromocionesDetalle[0]);
            }
            if ( DecimalUtil.compareTo(Z106PromocionesPrecio, T000J2_A106PromocionesPrecio[0]) != 0 )
            {
               GXutil.writeLogln("promociones:[seudo value changed for attri]"+"PromocionesPrecio");
               GXutil.writeLogRaw("Old: ",Z106PromocionesPrecio);
               GXutil.writeLogRaw("Current: ",T000J2_A106PromocionesPrecio[0]);
            }
            if ( Z107PromocionesCantidad != T000J2_A107PromocionesCantidad[0] )
            {
               GXutil.writeLogln("promociones:[seudo value changed for attri]"+"PromocionesCantidad");
               GXutil.writeLogRaw("Old: ",Z107PromocionesCantidad);
               GXutil.writeLogRaw("Current: ",T000J2_A107PromocionesCantidad[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Promociones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0J20( )
   {
      if ( ! IsAuthorized("promociones_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0J20( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0J20( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0J20( 0) ;
         checkOptimisticConcurrency0J20( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0J20( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0J20( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000J8 */
                  pr_default.execute(6, new Object[] {Long.valueOf(A22PromocionesId), A104PromocionesNombre, A105PromocionesDetalle, A106PromocionesPrecio, Integer.valueOf(A107PromocionesCantidad)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Promociones");
                  if ( (pr_default.getStatus(6) == 1) )
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
                        resetCaption0J0( ) ;
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
            load0J20( ) ;
         }
         endLevel0J20( ) ;
      }
      closeExtendedTableCursors0J20( ) ;
   }

   public void update0J20( )
   {
      if ( ! IsAuthorized("promociones_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0J20( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0J20( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0J20( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0J20( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0J20( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000J9 */
                  pr_default.execute(7, new Object[] {A104PromocionesNombre, A105PromocionesDetalle, A106PromocionesPrecio, Integer.valueOf(A107PromocionesCantidad), Long.valueOf(A22PromocionesId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Promociones");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Promociones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0J20( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0J0( ) ;
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
         endLevel0J20( ) ;
      }
      closeExtendedTableCursors0J20( ) ;
   }

   public void deferredUpdate0J20( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("promociones_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0J20( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0J20( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0J20( ) ;
         afterConfirm0J20( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0J20( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000J10 */
               pr_default.execute(8, new Object[] {Long.valueOf(A22PromocionesId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Promociones");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound20 == 0 )
                     {
                        initAll0J20( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption0J0( ) ;
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
      sMode20 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0J20( ) ;
      Gx_mode = sMode20 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0J20( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0J20( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0J20( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "promociones");
         if ( AnyError == 0 )
         {
            confirmValues0J0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "promociones");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0J20( )
   {
      /* Using cursor T000J11 */
      pr_default.execute(9);
      RcdFound20 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A22PromocionesId = T000J11_A22PromocionesId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0J20( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound20 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A22PromocionesId = T000J11_A22PromocionesId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
      }
   }

   public void scanEnd0J20( )
   {
      pr_default.close(9);
   }

   public void afterConfirm0J20( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0J20( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0J20( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0J20( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0J20( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0J20( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0J20( )
   {
      edtPromocionesId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPromocionesId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPromocionesId_Enabled), 5, 0), true);
      edtPromocionesNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPromocionesNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPromocionesNombre_Enabled), 5, 0), true);
      edtPromocionesDetalle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPromocionesDetalle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPromocionesDetalle_Enabled), 5, 0), true);
      edtPromocionesPrecio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPromocionesPrecio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPromocionesPrecio_Enabled), 5, 0), true);
      edtPromocionesCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPromocionesCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPromocionesCantidad_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0J20( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0J0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.promociones", new String[] {}, new String[] {}) +"\">") ;
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
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z22PromocionesId", GXutil.ltrim( localUtil.ntoc( Z22PromocionesId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z104PromocionesNombre", GXutil.rtrim( Z104PromocionesNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z105PromocionesDetalle", Z105PromocionesDetalle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z106PromocionesPrecio", GXutil.ltrim( localUtil.ntoc( Z106PromocionesPrecio, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z107PromocionesCantidad", GXutil.ltrim( localUtil.ntoc( Z107PromocionesCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
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
      return formatLink("com.mujermorena.promociones", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Promociones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Promociones", "") ;
   }

   public void initializeNonKey0J20( )
   {
      A104PromocionesNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PromocionesNombre", A104PromocionesNombre);
      A105PromocionesDetalle = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PromocionesDetalle", A105PromocionesDetalle);
      A106PromocionesPrecio = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A106PromocionesPrecio", GXutil.ltrimstr( A106PromocionesPrecio, 17, 2));
      A107PromocionesCantidad = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A107PromocionesCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A107PromocionesCantidad), 5, 0));
      Z104PromocionesNombre = "" ;
      Z105PromocionesDetalle = "" ;
      Z106PromocionesPrecio = DecimalUtil.ZERO ;
      Z107PromocionesCantidad = 0 ;
   }

   public void initAll0J20( )
   {
      A22PromocionesId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A22PromocionesId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A22PromocionesId), 11, 0));
      initializeNonKey0J20( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211193829", true, true);
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
      httpContext.AddJavascriptSource("promociones.js", "?20241211193829", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtPromocionesId_Internalname = "PROMOCIONESID" ;
      edtPromocionesNombre_Internalname = "PROMOCIONESNOMBRE" ;
      edtPromocionesDetalle_Internalname = "PROMOCIONESDETALLE" ;
      edtPromocionesPrecio_Internalname = "PROMOCIONESPRECIO" ;
      edtPromocionesCantidad_Internalname = "PROMOCIONESCANTIDAD" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setCaption( httpContext.getMessage( "Promociones", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtPromocionesCantidad_Jsonclick = "" ;
      edtPromocionesCantidad_Enabled = 1 ;
      edtPromocionesPrecio_Jsonclick = "" ;
      edtPromocionesPrecio_Enabled = 1 ;
      edtPromocionesDetalle_Jsonclick = "" ;
      edtPromocionesDetalle_Enabled = 1 ;
      edtPromocionesNombre_Jsonclick = "" ;
      edtPromocionesNombre_Enabled = 1 ;
      edtPromocionesId_Jsonclick = "" ;
      edtPromocionesId_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
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

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtPromocionesNombre_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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

   public void valid_Promocionesid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A104PromocionesNombre", GXutil.rtrim( A104PromocionesNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A105PromocionesDetalle", A105PromocionesDetalle);
      httpContext.ajax_rsp_assign_attri("", false, "A106PromocionesPrecio", GXutil.ltrim( localUtil.ntoc( A106PromocionesPrecio, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A107PromocionesCantidad", GXutil.ltrim( localUtil.ntoc( A107PromocionesCantidad, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z22PromocionesId", GXutil.ltrim( localUtil.ntoc( Z22PromocionesId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z104PromocionesNombre", GXutil.rtrim( Z104PromocionesNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z105PromocionesDetalle", Z105PromocionesDetalle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z106PromocionesPrecio", GXutil.ltrim( localUtil.ntoc( Z106PromocionesPrecio, (byte)(17), (byte)(2), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z107PromocionesCantidad", GXutil.ltrim( localUtil.ntoc( Z107PromocionesCantidad, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_PROMOCIONESID","{handler:'valid_Promocionesid',iparms:[{av:'A22PromocionesId',fld:'PROMOCIONESID',pic:'ZZZZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_PROMOCIONESID",",oparms:[{av:'A104PromocionesNombre',fld:'PROMOCIONESNOMBRE',pic:''},{av:'A105PromocionesDetalle',fld:'PROMOCIONESDETALLE',pic:''},{av:'A106PromocionesPrecio',fld:'PROMOCIONESPRECIO',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A107PromocionesCantidad',fld:'PROMOCIONESCANTIDAD',pic:'ZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z22PromocionesId'},{av:'Z104PromocionesNombre'},{av:'Z105PromocionesDetalle'},{av:'Z106PromocionesPrecio'},{av:'Z107PromocionesCantidad'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
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
      return "promociones_Execute";
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z104PromocionesNombre = "" ;
      Z105PromocionesDetalle = "" ;
      Z106PromocionesPrecio = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A104PromocionesNombre = "" ;
      A105PromocionesDetalle = "" ;
      A106PromocionesPrecio = DecimalUtil.ZERO ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      T000J4_A22PromocionesId = new long[1] ;
      T000J4_A104PromocionesNombre = new String[] {""} ;
      T000J4_A105PromocionesDetalle = new String[] {""} ;
      T000J4_A106PromocionesPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000J4_A107PromocionesCantidad = new int[1] ;
      T000J5_A22PromocionesId = new long[1] ;
      T000J3_A22PromocionesId = new long[1] ;
      T000J3_A104PromocionesNombre = new String[] {""} ;
      T000J3_A105PromocionesDetalle = new String[] {""} ;
      T000J3_A106PromocionesPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000J3_A107PromocionesCantidad = new int[1] ;
      sMode20 = "" ;
      T000J6_A22PromocionesId = new long[1] ;
      T000J7_A22PromocionesId = new long[1] ;
      T000J2_A22PromocionesId = new long[1] ;
      T000J2_A104PromocionesNombre = new String[] {""} ;
      T000J2_A105PromocionesDetalle = new String[] {""} ;
      T000J2_A106PromocionesPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000J2_A107PromocionesCantidad = new int[1] ;
      T000J11_A22PromocionesId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ104PromocionesNombre = "" ;
      ZZ105PromocionesDetalle = "" ;
      ZZ106PromocionesPrecio = DecimalUtil.ZERO ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.promociones__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.promociones__default(),
         new Object[] {
             new Object[] {
            T000J2_A22PromocionesId, T000J2_A104PromocionesNombre, T000J2_A105PromocionesDetalle, T000J2_A106PromocionesPrecio, T000J2_A107PromocionesCantidad
            }
            , new Object[] {
            T000J3_A22PromocionesId, T000J3_A104PromocionesNombre, T000J3_A105PromocionesDetalle, T000J3_A106PromocionesPrecio, T000J3_A107PromocionesCantidad
            }
            , new Object[] {
            T000J4_A22PromocionesId, T000J4_A104PromocionesNombre, T000J4_A105PromocionesDetalle, T000J4_A106PromocionesPrecio, T000J4_A107PromocionesCantidad
            }
            , new Object[] {
            T000J5_A22PromocionesId
            }
            , new Object[] {
            T000J6_A22PromocionesId
            }
            , new Object[] {
            T000J7_A22PromocionesId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000J11_A22PromocionesId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound20 ;
   private short nIsDirty_20 ;
   private int Z107PromocionesCantidad ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtPromocionesId_Enabled ;
   private int edtPromocionesNombre_Enabled ;
   private int edtPromocionesDetalle_Enabled ;
   private int edtPromocionesPrecio_Enabled ;
   private int A107PromocionesCantidad ;
   private int edtPromocionesCantidad_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ107PromocionesCantidad ;
   private long Z22PromocionesId ;
   private long A22PromocionesId ;
   private long ZZ22PromocionesId ;
   private java.math.BigDecimal Z106PromocionesPrecio ;
   private java.math.BigDecimal A106PromocionesPrecio ;
   private java.math.BigDecimal ZZ106PromocionesPrecio ;
   private String sPrefix ;
   private String Z104PromocionesNombre ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPromocionesId_Internalname ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtPromocionesId_Jsonclick ;
   private String edtPromocionesNombre_Internalname ;
   private String A104PromocionesNombre ;
   private String edtPromocionesNombre_Jsonclick ;
   private String edtPromocionesDetalle_Internalname ;
   private String edtPromocionesDetalle_Jsonclick ;
   private String edtPromocionesPrecio_Internalname ;
   private String edtPromocionesPrecio_Jsonclick ;
   private String edtPromocionesCantidad_Internalname ;
   private String edtPromocionesCantidad_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode20 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ104PromocionesNombre ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String Z105PromocionesDetalle ;
   private String A105PromocionesDetalle ;
   private String ZZ105PromocionesDetalle ;
   private IDataStoreProvider pr_default ;
   private long[] T000J4_A22PromocionesId ;
   private String[] T000J4_A104PromocionesNombre ;
   private String[] T000J4_A105PromocionesDetalle ;
   private java.math.BigDecimal[] T000J4_A106PromocionesPrecio ;
   private int[] T000J4_A107PromocionesCantidad ;
   private long[] T000J5_A22PromocionesId ;
   private long[] T000J3_A22PromocionesId ;
   private String[] T000J3_A104PromocionesNombre ;
   private String[] T000J3_A105PromocionesDetalle ;
   private java.math.BigDecimal[] T000J3_A106PromocionesPrecio ;
   private int[] T000J3_A107PromocionesCantidad ;
   private long[] T000J6_A22PromocionesId ;
   private long[] T000J7_A22PromocionesId ;
   private long[] T000J2_A22PromocionesId ;
   private String[] T000J2_A104PromocionesNombre ;
   private String[] T000J2_A105PromocionesDetalle ;
   private java.math.BigDecimal[] T000J2_A106PromocionesPrecio ;
   private int[] T000J2_A107PromocionesCantidad ;
   private long[] T000J11_A22PromocionesId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class promociones__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class promociones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000J2", "SELECT [PromocionesId], [PromocionesNombre], [PromocionesDetalle], [PromocionesPrecio], [PromocionesCantidad] FROM [Promociones] WITH (UPDLOCK) WHERE [PromocionesId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J3", "SELECT [PromocionesId], [PromocionesNombre], [PromocionesDetalle], [PromocionesPrecio], [PromocionesCantidad] FROM [Promociones] WHERE [PromocionesId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J4", "SELECT TM1.[PromocionesId], TM1.[PromocionesNombre], TM1.[PromocionesDetalle], TM1.[PromocionesPrecio], TM1.[PromocionesCantidad] FROM [Promociones] TM1 WHERE TM1.[PromocionesId] = ? ORDER BY TM1.[PromocionesId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J5", "SELECT [PromocionesId] FROM [Promociones] WHERE [PromocionesId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J6", "SELECT TOP 1 [PromocionesId] FROM [Promociones] WHERE ( [PromocionesId] > ?) ORDER BY [PromocionesId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000J7", "SELECT TOP 1 [PromocionesId] FROM [Promociones] WHERE ( [PromocionesId] < ?) ORDER BY [PromocionesId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000J8", "INSERT INTO [Promociones]([PromocionesId], [PromocionesNombre], [PromocionesDetalle], [PromocionesPrecio], [PromocionesCantidad]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000J9", "UPDATE [Promociones] SET [PromocionesNombre]=?, [PromocionesDetalle]=?, [PromocionesPrecio]=?, [PromocionesCantidad]=?  WHERE [PromocionesId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000J10", "DELETE FROM [Promociones]  WHERE [PromocionesId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000J11", "SELECT [PromocionesId] FROM [Promociones] ORDER BY [PromocionesId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 9 :
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
               stmt.setString(2, (String)parms[1], 80);
               stmt.setVarchar(3, (String)parms[2], 80, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 80);
               stmt.setVarchar(2, (String)parms[1], 80, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

