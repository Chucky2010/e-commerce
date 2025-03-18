package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class localidad_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
      {
         A7CiudadId = GXutil.lval( httpContext.GetPar( "CiudadId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_10( A7CiudadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A6DepartamentoId = GXutil.lval( httpContext.GetPar( "DepartamentoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6DepartamentoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A6DepartamentoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A5PaisId = GXutil.lval( httpContext.GetPar( "PaisId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A5PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5PaisId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A5PaisId) ;
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
            AV7LocalidadId = GXutil.lval( httpContext.GetPar( "LocalidadId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7LocalidadId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLOCALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LocalidadId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Localidad", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLocalidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public localidad_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public localidad_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( localidad_impl.class ));
   }

   public localidad_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Localidad", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Localidad.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLocalidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtLocalidadId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtLocalidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A3LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3LocalidadId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocalidadId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtLocalidadId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLocalidadNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtLocalidadNombre_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtLocalidadNombre_Internalname, GXutil.rtrim( A64LocalidadNombre), GXutil.rtrim( localUtil.format( A64LocalidadNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocalidadNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtLocalidadNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCiudadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCiudadId_Internalname, httpContext.getMessage( "Ciudad Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCiudadId_Internalname, GXutil.ltrim( localUtil.ntoc( A7CiudadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7CiudadId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCiudadId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCiudadId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Localidad.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_7_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_7_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_7_Internalname, sImgUrl, imgprompt_7_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_7_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCiudadNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCiudadNombre_Internalname, httpContext.getMessage( "Ciudad Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCiudadNombre_Internalname, GXutil.rtrim( A62CiudadNombre), GXutil.rtrim( localUtil.format( A62CiudadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCiudadNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtCiudadNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDepartamentoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDepartamentoNombre_Internalname, httpContext.getMessage( "Departamento Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDepartamentoNombre_Internalname, GXutil.rtrim( A61DepartamentoNombre), GXutil.rtrim( localUtil.format( A61DepartamentoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDepartamentoNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtDepartamentoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaisNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPaisNombre_Internalname, httpContext.getMessage( "Pais Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPaisNombre_Internalname, GXutil.rtrim( A60PaisNombre), GXutil.rtrim( localUtil.format( A60PaisNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaisNombre_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPaisNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Localidad.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Localidad.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Localidad.htm");
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
      e11022 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3LocalidadId = localUtil.ctol( httpContext.cgiGet( "Z3LocalidadId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z64LocalidadNombre = httpContext.cgiGet( "Z64LocalidadNombre") ;
            Z7CiudadId = localUtil.ctol( httpContext.cgiGet( "Z7CiudadId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N7CiudadId = localUtil.ctol( httpContext.cgiGet( "N7CiudadId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7LocalidadId = localUtil.ctol( httpContext.cgiGet( "vLOCALIDADID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV13Insert_CiudadId = localUtil.ctol( httpContext.cgiGet( "vINSERT_CIUDADID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A6DepartamentoId = localUtil.ctol( httpContext.cgiGet( "DEPARTAMENTOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A5PaisId = localUtil.ctol( httpContext.cgiGet( "PAISID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCiudadId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCiudadId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CIUDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCiudadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A7CiudadId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
            }
            else
            {
               A7CiudadId = localUtil.ctol( httpContext.cgiGet( edtCiudadId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
            }
            A62CiudadNombre = httpContext.cgiGet( edtCiudadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
            A61DepartamentoNombre = httpContext.cgiGet( edtDepartamentoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
            A60PaisNombre = httpContext.cgiGet( edtPaisNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Localidad");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3LocalidadId != Z3LocalidadId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("localidad:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A3LocalidadId = GXutil.lval( httpContext.GetPar( "LocalidadId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
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
                  sMode7 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode7 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound7 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_020( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "LOCALIDADID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLocalidadId_Internalname ;
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
                        e11022 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12022 ();
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
         e12022 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll027( ) ;
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
         disableAttributes027( ) ;
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

   public void confirm_020( )
   {
      beforeValidate027( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls027( ) ;
         }
         else
         {
            checkExtendedTable027( ) ;
            closeExtendedTableCursors027( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption020( )
   {
   }

   public void e11022( )
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
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CiudadId") == 0 )
            {
               AV13Insert_CiudadId = GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_CiudadId), 11, 0));
            }
            AV16GXV1 = (int)(AV16GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         }
      }
   }

   public void e12022( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.localidadww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm027( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z64LocalidadNombre = T00023_A64LocalidadNombre[0] ;
            Z7CiudadId = T00023_A7CiudadId[0] ;
         }
         else
         {
            Z64LocalidadNombre = A64LocalidadNombre ;
            Z7CiudadId = A7CiudadId ;
         }
      }
      if ( GX_JID == -9 )
      {
         Z3LocalidadId = A3LocalidadId ;
         Z64LocalidadNombre = A64LocalidadNombre ;
         Z7CiudadId = A7CiudadId ;
         Z6DepartamentoId = A6DepartamentoId ;
         Z62CiudadNombre = A62CiudadNombre ;
         Z5PaisId = A5PaisId ;
         Z61DepartamentoNombre = A61DepartamentoNombre ;
         Z60PaisNombre = A60PaisNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      AV15Pgmname = "Localidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      imgprompt_7_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.ciudadprompt"+"',["+"{Ctrl:gx.dom.el('"+"CIUDADID"+"'), id:'"+"CIUDADID"+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"CIUDADNOMBRE"+"'), id:'"+"CIUDADNOMBRE"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7LocalidadId) )
      {
         A3LocalidadId = AV7LocalidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      }
      if ( ! (0==AV7LocalidadId) )
      {
         edtLocalidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      }
      else
      {
         edtLocalidadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7LocalidadId) )
      {
         edtLocalidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CiudadId) )
      {
         edtCiudadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCiudadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCiudadId_Enabled), 5, 0), true);
      }
      else
      {
         edtCiudadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCiudadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCiudadId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CiudadId) )
      {
         A7CiudadId = AV13Insert_CiudadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
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
         /* Using cursor T00024 */
         pr_default.execute(2, new Object[] {Long.valueOf(A7CiudadId)});
         A6DepartamentoId = T00024_A6DepartamentoId[0] ;
         A62CiudadNombre = T00024_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         pr_default.close(2);
         /* Using cursor T00025 */
         pr_default.execute(3, new Object[] {Long.valueOf(A6DepartamentoId)});
         A5PaisId = T00025_A5PaisId[0] ;
         A61DepartamentoNombre = T00025_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         pr_default.close(3);
         /* Using cursor T00026 */
         pr_default.execute(4, new Object[] {Long.valueOf(A5PaisId)});
         A60PaisNombre = T00026_A60PaisNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
         pr_default.close(4);
      }
   }

   public void load027( )
   {
      /* Using cursor T00027 */
      pr_default.execute(5, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A6DepartamentoId = T00027_A6DepartamentoId[0] ;
         A5PaisId = T00027_A5PaisId[0] ;
         A64LocalidadNombre = T00027_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         A62CiudadNombre = T00027_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         A61DepartamentoNombre = T00027_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         A60PaisNombre = T00027_A60PaisNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
         A7CiudadId = T00027_A7CiudadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
         zm027( -9) ;
      }
      pr_default.close(5);
      onLoadActions027( ) ;
   }

   public void onLoadActions027( )
   {
   }

   public void checkExtendedTable027( )
   {
      nIsDirty_7 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00024 */
      pr_default.execute(2, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCiudadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A6DepartamentoId = T00024_A6DepartamentoId[0] ;
      A62CiudadNombre = T00024_A62CiudadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      pr_default.close(2);
      /* Using cursor T00025 */
      pr_default.execute(3, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A5PaisId = T00025_A5PaisId[0] ;
      A61DepartamentoNombre = T00025_A61DepartamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      pr_default.close(3);
      /* Using cursor T00026 */
      pr_default.execute(4, new Object[] {Long.valueOf(A5PaisId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
      }
      A60PaisNombre = T00026_A60PaisNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
      pr_default.close(4);
   }

   public void closeExtendedTableCursors027( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_10( long A7CiudadId )
   {
      /* Using cursor T00028 */
      pr_default.execute(6, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCiudadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A6DepartamentoId = T00028_A6DepartamentoId[0] ;
      A62CiudadNombre = T00028_A62CiudadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A62CiudadNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_11( long A6DepartamentoId )
   {
      /* Using cursor T00029 */
      pr_default.execute(7, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A5PaisId = T00029_A5PaisId[0] ;
      A61DepartamentoNombre = T00029_A61DepartamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A5PaisId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A61DepartamentoNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_12( long A5PaisId )
   {
      /* Using cursor T000210 */
      pr_default.execute(8, new Object[] {Long.valueOf(A5PaisId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
      }
      A60PaisNombre = T000210_A60PaisNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A60PaisNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey027( )
   {
      /* Using cursor T000211 */
      pr_default.execute(9, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound7 = (short)(1) ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00023 */
      pr_default.execute(1, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm027( 9) ;
         RcdFound7 = (short)(1) ;
         A3LocalidadId = T00023_A3LocalidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
         A64LocalidadNombre = T00023_A64LocalidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
         A7CiudadId = T00023_A7CiudadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
         Z3LocalidadId = A3LocalidadId ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load027( ) ;
         if ( AnyError == 1 )
         {
            RcdFound7 = (short)(0) ;
            initializeNonKey027( ) ;
         }
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound7 = (short)(0) ;
         initializeNonKey027( ) ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey027( ) ;
      if ( RcdFound7 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound7 = (short)(0) ;
      /* Using cursor T000212 */
      pr_default.execute(10, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000212_A3LocalidadId[0] < A3LocalidadId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000212_A3LocalidadId[0] > A3LocalidadId ) ) )
         {
            A3LocalidadId = T000212_A3LocalidadId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
            RcdFound7 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound7 = (short)(0) ;
      /* Using cursor T000213 */
      pr_default.execute(11, new Object[] {Long.valueOf(A3LocalidadId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000213_A3LocalidadId[0] > A3LocalidadId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000213_A3LocalidadId[0] < A3LocalidadId ) ) )
         {
            A3LocalidadId = T000213_A3LocalidadId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
            RcdFound7 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey027( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLocalidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert027( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound7 == 1 )
         {
            if ( A3LocalidadId != Z3LocalidadId )
            {
               A3LocalidadId = Z3LocalidadId ;
               httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "LOCALIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLocalidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLocalidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update027( ) ;
               GX_FocusControl = edtLocalidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A3LocalidadId != Z3LocalidadId )
            {
               /* Insert record */
               GX_FocusControl = edtLocalidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert027( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "LOCALIDADID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtLocalidadId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtLocalidadId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert027( ) ;
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
      if ( A3LocalidadId != Z3LocalidadId )
      {
         A3LocalidadId = Z3LocalidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "LOCALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLocalidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLocalidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency027( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00022 */
         pr_default.execute(0, new Object[] {Long.valueOf(A3LocalidadId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Localidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z64LocalidadNombre, T00022_A64LocalidadNombre[0]) != 0 ) || ( Z7CiudadId != T00022_A7CiudadId[0] ) )
         {
            if ( GXutil.strcmp(Z64LocalidadNombre, T00022_A64LocalidadNombre[0]) != 0 )
            {
               GXutil.writeLogln("localidad:[seudo value changed for attri]"+"LocalidadNombre");
               GXutil.writeLogRaw("Old: ",Z64LocalidadNombre);
               GXutil.writeLogRaw("Current: ",T00022_A64LocalidadNombre[0]);
            }
            if ( Z7CiudadId != T00022_A7CiudadId[0] )
            {
               GXutil.writeLogln("localidad:[seudo value changed for attri]"+"CiudadId");
               GXutil.writeLogRaw("Old: ",Z7CiudadId);
               GXutil.writeLogRaw("Current: ",T00022_A7CiudadId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Localidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert027( )
   {
      if ( ! IsAuthorized("localidad_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate027( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable027( ) ;
      }
      if ( AnyError == 0 )
      {
         zm027( 0) ;
         checkOptimisticConcurrency027( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm027( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert027( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000214 */
                  pr_default.execute(12, new Object[] {Long.valueOf(A3LocalidadId), A64LocalidadNombre, Long.valueOf(A7CiudadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
                  if ( (pr_default.getStatus(12) == 1) )
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
                        resetCaption020( ) ;
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
            load027( ) ;
         }
         endLevel027( ) ;
      }
      closeExtendedTableCursors027( ) ;
   }

   public void update027( )
   {
      if ( ! IsAuthorized("localidad_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate027( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable027( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency027( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm027( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate027( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000215 */
                  pr_default.execute(13, new Object[] {A64LocalidadNombre, Long.valueOf(A7CiudadId), Long.valueOf(A3LocalidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Localidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate027( ) ;
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
         endLevel027( ) ;
      }
      closeExtendedTableCursors027( ) ;
   }

   public void deferredUpdate027( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("localidad_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate027( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency027( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls027( ) ;
         afterConfirm027( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete027( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000216 */
               pr_default.execute(14, new Object[] {Long.valueOf(A3LocalidadId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
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
      sMode7 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel027( ) ;
      Gx_mode = sMode7 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls027( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000217 */
         pr_default.execute(15, new Object[] {Long.valueOf(A7CiudadId)});
         A6DepartamentoId = T000217_A6DepartamentoId[0] ;
         A62CiudadNombre = T000217_A62CiudadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
         pr_default.close(15);
         /* Using cursor T000218 */
         pr_default.execute(16, new Object[] {Long.valueOf(A6DepartamentoId)});
         A5PaisId = T000218_A5PaisId[0] ;
         A61DepartamentoNombre = T000218_A61DepartamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
         pr_default.close(16);
         /* Using cursor T000219 */
         pr_default.execute(17, new Object[] {Long.valueOf(A5PaisId)});
         A60PaisNombre = T000219_A60PaisNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
         pr_default.close(17);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000220 */
         pr_default.execute(18, new Object[] {Long.valueOf(A3LocalidadId)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Persona", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
   }

   public void endLevel027( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete027( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(15);
         pr_default.close(16);
         pr_default.close(17);
         Application.commitDataStores(context, remoteHandle, pr_default, "localidad");
         if ( AnyError == 0 )
         {
            confirmValues020( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(15);
         pr_default.close(16);
         pr_default.close(17);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "localidad");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart027( )
   {
      /* Scan By routine */
      /* Using cursor T000221 */
      pr_default.execute(19);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A3LocalidadId = T000221_A3LocalidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext027( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A3LocalidadId = T000221_A3LocalidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      }
   }

   public void scanEnd027( )
   {
      pr_default.close(19);
   }

   public void afterConfirm027( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert027( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate027( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete027( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete027( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate027( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes027( )
   {
      edtLocalidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocalidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadId_Enabled), 5, 0), true);
      edtLocalidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocalidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocalidadNombre_Enabled), 5, 0), true);
      edtCiudadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCiudadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCiudadId_Enabled), 5, 0), true);
      edtCiudadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCiudadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCiudadNombre_Enabled), 5, 0), true);
      edtDepartamentoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDepartamentoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDepartamentoNombre_Enabled), 5, 0), true);
      edtPaisNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisNombre_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes027( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues020( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.localidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7LocalidadId,11,0))}, new String[] {"Gx_mode","LocalidadId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Localidad");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("localidad:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z3LocalidadId", GXutil.ltrim( localUtil.ntoc( Z3LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z64LocalidadNombre", GXutil.rtrim( Z64LocalidadNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z7CiudadId", GXutil.ltrim( localUtil.ntoc( Z7CiudadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N7CiudadId", GXutil.ltrim( localUtil.ntoc( A7CiudadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vLOCALIDADID", GXutil.ltrim( localUtil.ntoc( AV7LocalidadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLOCALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LocalidadId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CIUDADID", GXutil.ltrim( localUtil.ntoc( AV13Insert_CiudadId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DEPARTAMENTOID", GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PAISID", GXutil.ltrim( localUtil.ntoc( A5PaisId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.localidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7LocalidadId,11,0))}, new String[] {"Gx_mode","LocalidadId"})  ;
   }

   public String getPgmname( )
   {
      return "Localidad" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Localidad", "") ;
   }

   public void initializeNonKey027( )
   {
      A5PaisId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A5PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5PaisId), 11, 0));
      A6DepartamentoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6DepartamentoId), 11, 0));
      A7CiudadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A7CiudadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CiudadId), 11, 0));
      A64LocalidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A64LocalidadNombre", A64LocalidadNombre);
      A62CiudadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", A62CiudadNombre);
      A61DepartamentoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", A61DepartamentoNombre);
      A60PaisNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", A60PaisNombre);
      Z64LocalidadNombre = "" ;
      Z7CiudadId = 0 ;
   }

   public void initAll027( )
   {
      A3LocalidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3LocalidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3LocalidadId), 11, 0));
      initializeNonKey027( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211185159", true, true);
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
      httpContext.AddJavascriptSource("localidad.js", "?20241211185159", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtLocalidadId_Internalname = "LOCALIDADID" ;
      edtLocalidadNombre_Internalname = "LOCALIDADNOMBRE" ;
      edtCiudadId_Internalname = "CIUDADID" ;
      edtCiudadNombre_Internalname = "CIUDADNOMBRE" ;
      edtDepartamentoNombre_Internalname = "DEPARTAMENTONOMBRE" ;
      edtPaisNombre_Internalname = "PAISNOMBRE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_7_Internalname = "PROMPT_7" ;
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
      Form.setCaption( httpContext.getMessage( "Localidad", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPaisNombre_Jsonclick = "" ;
      edtPaisNombre_Enabled = 0 ;
      edtDepartamentoNombre_Jsonclick = "" ;
      edtDepartamentoNombre_Enabled = 0 ;
      edtCiudadNombre_Jsonclick = "" ;
      edtCiudadNombre_Enabled = 0 ;
      imgprompt_7_Visible = 1 ;
      imgprompt_7_Link = "" ;
      edtCiudadId_Jsonclick = "" ;
      edtCiudadId_Enabled = 1 ;
      edtLocalidadNombre_Jsonclick = "" ;
      edtLocalidadNombre_Enabled = 1 ;
      edtLocalidadId_Jsonclick = "" ;
      edtLocalidadId_Enabled = 1 ;
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

   public void valid_Ciudadid( )
   {
      /* Using cursor T000217 */
      pr_default.execute(15, new Object[] {Long.valueOf(A7CiudadId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ciudad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CIUDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCiudadId_Internalname ;
      }
      A6DepartamentoId = T000217_A6DepartamentoId[0] ;
      A62CiudadNombre = T000217_A62CiudadNombre[0] ;
      pr_default.close(15);
      /* Using cursor T000218 */
      pr_default.execute(16, new Object[] {Long.valueOf(A6DepartamentoId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "DEPARTAMENTOID");
         AnyError = (short)(1) ;
      }
      A5PaisId = T000218_A5PaisId[0] ;
      A61DepartamentoNombre = T000218_A61DepartamentoNombre[0] ;
      pr_default.close(16);
      /* Using cursor T000219 */
      pr_default.execute(17, new Object[] {Long.valueOf(A5PaisId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
      }
      A60PaisNombre = T000219_A60PaisNombre[0] ;
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A6DepartamentoId", GXutil.ltrim( localUtil.ntoc( A6DepartamentoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A62CiudadNombre", GXutil.rtrim( A62CiudadNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A5PaisId", GXutil.ltrim( localUtil.ntoc( A5PaisId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A61DepartamentoNombre", GXutil.rtrim( A61DepartamentoNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A60PaisNombre", GXutil.rtrim( A60PaisNombre));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7LocalidadId',fld:'vLOCALIDADID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7LocalidadId',fld:'vLOCALIDADID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12022',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_LOCALIDADID","{handler:'valid_Localidadid',iparms:[]");
      setEventMetadata("VALID_LOCALIDADID",",oparms:[]}");
      setEventMetadata("VALID_CIUDADID","{handler:'valid_Ciudadid',iparms:[{av:'A7CiudadId',fld:'CIUDADID',pic:'ZZZZZZZZZZ9'},{av:'A6DepartamentoId',fld:'DEPARTAMENTOID',pic:'ZZZZZZZZZZ9'},{av:'A5PaisId',fld:'PAISID',pic:'ZZZZZZZZZZ9'},{av:'A62CiudadNombre',fld:'CIUDADNOMBRE',pic:''},{av:'A61DepartamentoNombre',fld:'DEPARTAMENTONOMBRE',pic:''},{av:'A60PaisNombre',fld:'PAISNOMBRE',pic:''}]");
      setEventMetadata("VALID_CIUDADID",",oparms:[{av:'A6DepartamentoId',fld:'DEPARTAMENTOID',pic:'ZZZZZZZZZZ9'},{av:'A62CiudadNombre',fld:'CIUDADNOMBRE',pic:''},{av:'A5PaisId',fld:'PAISID',pic:'ZZZZZZZZZZ9'},{av:'A61DepartamentoNombre',fld:'DEPARTAMENTONOMBRE',pic:''},{av:'A60PaisNombre',fld:'PAISNOMBRE',pic:''}]}");
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
      return "localidad_Execute";
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
      pr_default.close(15);
      pr_default.close(16);
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z64LocalidadNombre = "" ;
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
      A64LocalidadNombre = "" ;
      imgprompt_7_gximage = "" ;
      sImgUrl = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A60PaisNombre = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV15Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode7 = "" ;
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
      Z62CiudadNombre = "" ;
      Z61DepartamentoNombre = "" ;
      Z60PaisNombre = "" ;
      T00024_A6DepartamentoId = new long[1] ;
      T00024_A62CiudadNombre = new String[] {""} ;
      T00025_A5PaisId = new long[1] ;
      T00025_A61DepartamentoNombre = new String[] {""} ;
      T00026_A60PaisNombre = new String[] {""} ;
      T00027_A6DepartamentoId = new long[1] ;
      T00027_A5PaisId = new long[1] ;
      T00027_A3LocalidadId = new long[1] ;
      T00027_A64LocalidadNombre = new String[] {""} ;
      T00027_A62CiudadNombre = new String[] {""} ;
      T00027_A61DepartamentoNombre = new String[] {""} ;
      T00027_A60PaisNombre = new String[] {""} ;
      T00027_A7CiudadId = new long[1] ;
      T00028_A6DepartamentoId = new long[1] ;
      T00028_A62CiudadNombre = new String[] {""} ;
      T00029_A5PaisId = new long[1] ;
      T00029_A61DepartamentoNombre = new String[] {""} ;
      T000210_A60PaisNombre = new String[] {""} ;
      T000211_A3LocalidadId = new long[1] ;
      T00023_A3LocalidadId = new long[1] ;
      T00023_A64LocalidadNombre = new String[] {""} ;
      T00023_A7CiudadId = new long[1] ;
      T000212_A3LocalidadId = new long[1] ;
      T000213_A3LocalidadId = new long[1] ;
      T00022_A3LocalidadId = new long[1] ;
      T00022_A64LocalidadNombre = new String[] {""} ;
      T00022_A7CiudadId = new long[1] ;
      T000217_A6DepartamentoId = new long[1] ;
      T000217_A62CiudadNombre = new String[] {""} ;
      T000218_A5PaisId = new long[1] ;
      T000218_A61DepartamentoNombre = new String[] {""} ;
      T000219_A60PaisNombre = new String[] {""} ;
      T000220_A1PersonaId = new long[1] ;
      T000221_A3LocalidadId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.localidad__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.localidad__default(),
         new Object[] {
             new Object[] {
            T00022_A3LocalidadId, T00022_A64LocalidadNombre, T00022_A7CiudadId
            }
            , new Object[] {
            T00023_A3LocalidadId, T00023_A64LocalidadNombre, T00023_A7CiudadId
            }
            , new Object[] {
            T00024_A6DepartamentoId, T00024_A62CiudadNombre
            }
            , new Object[] {
            T00025_A5PaisId, T00025_A61DepartamentoNombre
            }
            , new Object[] {
            T00026_A60PaisNombre
            }
            , new Object[] {
            T00027_A6DepartamentoId, T00027_A5PaisId, T00027_A3LocalidadId, T00027_A64LocalidadNombre, T00027_A62CiudadNombre, T00027_A61DepartamentoNombre, T00027_A60PaisNombre, T00027_A7CiudadId
            }
            , new Object[] {
            T00028_A6DepartamentoId, T00028_A62CiudadNombre
            }
            , new Object[] {
            T00029_A5PaisId, T00029_A61DepartamentoNombre
            }
            , new Object[] {
            T000210_A60PaisNombre
            }
            , new Object[] {
            T000211_A3LocalidadId
            }
            , new Object[] {
            T000212_A3LocalidadId
            }
            , new Object[] {
            T000213_A3LocalidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000217_A6DepartamentoId, T000217_A62CiudadNombre
            }
            , new Object[] {
            T000218_A5PaisId, T000218_A61DepartamentoNombre
            }
            , new Object[] {
            T000219_A60PaisNombre
            }
            , new Object[] {
            T000220_A1PersonaId
            }
            , new Object[] {
            T000221_A3LocalidadId
            }
         }
      );
      AV15Pgmname = "Localidad" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound7 ;
   private short nIsDirty_7 ;
   private int trnEnded ;
   private int edtLocalidadId_Enabled ;
   private int edtLocalidadNombre_Enabled ;
   private int edtCiudadId_Enabled ;
   private int imgprompt_7_Visible ;
   private int edtCiudadNombre_Enabled ;
   private int edtDepartamentoNombre_Enabled ;
   private int edtPaisNombre_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV16GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7LocalidadId ;
   private long Z3LocalidadId ;
   private long Z7CiudadId ;
   private long N7CiudadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private long A5PaisId ;
   private long AV7LocalidadId ;
   private long A3LocalidadId ;
   private long AV13Insert_CiudadId ;
   private long Z6DepartamentoId ;
   private long Z5PaisId ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z64LocalidadNombre ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLocalidadId_Internalname ;
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
   private String edtLocalidadId_Jsonclick ;
   private String edtLocalidadNombre_Internalname ;
   private String A64LocalidadNombre ;
   private String edtLocalidadNombre_Jsonclick ;
   private String edtCiudadId_Internalname ;
   private String edtCiudadId_Jsonclick ;
   private String imgprompt_7_gximage ;
   private String sImgUrl ;
   private String imgprompt_7_Internalname ;
   private String imgprompt_7_Link ;
   private String edtCiudadNombre_Internalname ;
   private String A62CiudadNombre ;
   private String edtCiudadNombre_Jsonclick ;
   private String edtDepartamentoNombre_Internalname ;
   private String A61DepartamentoNombre ;
   private String edtDepartamentoNombre_Jsonclick ;
   private String edtPaisNombre_Internalname ;
   private String A60PaisNombre ;
   private String edtPaisNombre_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV15Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode7 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z62CiudadNombre ;
   private String Z61DepartamentoNombre ;
   private String Z60PaisNombre ;
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
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T00024_A6DepartamentoId ;
   private String[] T00024_A62CiudadNombre ;
   private long[] T00025_A5PaisId ;
   private String[] T00025_A61DepartamentoNombre ;
   private String[] T00026_A60PaisNombre ;
   private long[] T00027_A6DepartamentoId ;
   private long[] T00027_A5PaisId ;
   private long[] T00027_A3LocalidadId ;
   private String[] T00027_A64LocalidadNombre ;
   private String[] T00027_A62CiudadNombre ;
   private String[] T00027_A61DepartamentoNombre ;
   private String[] T00027_A60PaisNombre ;
   private long[] T00027_A7CiudadId ;
   private long[] T00028_A6DepartamentoId ;
   private String[] T00028_A62CiudadNombre ;
   private long[] T00029_A5PaisId ;
   private String[] T00029_A61DepartamentoNombre ;
   private String[] T000210_A60PaisNombre ;
   private long[] T000211_A3LocalidadId ;
   private long[] T00023_A3LocalidadId ;
   private String[] T00023_A64LocalidadNombre ;
   private long[] T00023_A7CiudadId ;
   private long[] T000212_A3LocalidadId ;
   private long[] T000213_A3LocalidadId ;
   private long[] T00022_A3LocalidadId ;
   private String[] T00022_A64LocalidadNombre ;
   private long[] T00022_A7CiudadId ;
   private long[] T000217_A6DepartamentoId ;
   private String[] T000217_A62CiudadNombre ;
   private long[] T000218_A5PaisId ;
   private String[] T000218_A61DepartamentoNombre ;
   private String[] T000219_A60PaisNombre ;
   private long[] T000220_A1PersonaId ;
   private long[] T000221_A3LocalidadId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class localidad__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class localidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00022", "SELECT [LocalidadId], [LocalidadNombre], [CiudadId] FROM [Localidad] WITH (UPDLOCK) WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00023", "SELECT [LocalidadId], [LocalidadNombre], [CiudadId] FROM [Localidad] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00024", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00025", "SELECT [PaisId], [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00026", "SELECT [PaisNombre] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00027", "SELECT T2.[DepartamentoId], T3.[PaisId], TM1.[LocalidadId], TM1.[LocalidadNombre], T2.[CiudadNombre], T3.[DepartamentoNombre], T4.[PaisNombre], TM1.[CiudadId] FROM ((([Localidad] TM1 INNER JOIN [Ciudad] T2 ON T2.[CiudadId] = TM1.[CiudadId]) INNER JOIN [Departamento] T3 ON T3.[DepartamentoId] = T2.[DepartamentoId]) INNER JOIN [Pais] T4 ON T4.[PaisId] = T3.[PaisId]) WHERE TM1.[LocalidadId] = ? ORDER BY TM1.[LocalidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00028", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00029", "SELECT [PaisId], [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000210", "SELECT [PaisNombre] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000211", "SELECT [LocalidadId] FROM [Localidad] WHERE [LocalidadId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000212", "SELECT TOP 1 [LocalidadId] FROM [Localidad] WHERE ( [LocalidadId] > ?) ORDER BY [LocalidadId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000213", "SELECT TOP 1 [LocalidadId] FROM [Localidad] WHERE ( [LocalidadId] < ?) ORDER BY [LocalidadId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000214", "INSERT INTO [Localidad]([LocalidadId], [LocalidadNombre], [CiudadId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000215", "UPDATE [Localidad] SET [LocalidadNombre]=?, [CiudadId]=?  WHERE [LocalidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000216", "DELETE FROM [Localidad]  WHERE [LocalidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000217", "SELECT [DepartamentoId], [CiudadNombre] FROM [Ciudad] WHERE [CiudadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000218", "SELECT [PaisId], [DepartamentoNombre] FROM [Departamento] WHERE [DepartamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000219", "SELECT [PaisNombre] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000220", "SELECT TOP 1 [PersonaId] FROM [Persona] WHERE [LocalidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000221", "SELECT [LocalidadId] FROM [Localidad] ORDER BY [LocalidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               ((String[]) buf[5])[0] = rslt.getString(6, 80);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 19 :
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
               stmt.setString(2, (String)parms[1], 80);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 80);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
      }
   }

}

