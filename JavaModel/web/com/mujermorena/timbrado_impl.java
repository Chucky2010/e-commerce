package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class timbrado_impl extends GXDataArea
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
            AV7TimbradoId = GXutil.lval( httpContext.GetPar( "TimbradoId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7TimbradoId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIMBRADOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7TimbradoId), "ZZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Timbrado", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public timbrado_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public timbrado_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( timbrado_impl.class ));
   }

   public timbrado_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Timbrado", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Timbrado.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoId_Internalname, httpContext.getMessage( "Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoId_Internalname, GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNumero_Internalname, httpContext.getMessage( "Numero", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNumero_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNumero_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Numero", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoInicioVigencia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoInicioVigencia_Internalname, httpContext.getMessage( "Inicio Vigencia", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtTimbradoInicioVigencia_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoInicioVigencia_Internalname, localUtil.format(A126TimbradoInicioVigencia, "99/99/99"), localUtil.format( A126TimbradoInicioVigencia, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoInicioVigencia_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtTimbradoInicioVigencia_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Inicio", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtTimbradoInicioVigencia_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtTimbradoInicioVigencia_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Timbrado.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoFinVigencia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoFinVigencia_Internalname, httpContext.getMessage( "Fin Vigencia", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtTimbradoFinVigencia_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoFinVigencia_Internalname, localUtil.format(A127TimbradoFinVigencia, "99/99/99"), localUtil.format( A127TimbradoFinVigencia, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoFinVigencia_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtTimbradoFinVigencia_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fin", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtTimbradoFinVigencia_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtTimbradoFinVigencia_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Timbrado.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNroFactura_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNroFactura_Internalname, httpContext.getMessage( "Nro Factura", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNroFactura_Internalname, GXutil.ltrim( localUtil.ntoc( A128TimbradoNroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNroFactura_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A128TimbradoNroFactura), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A128TimbradoNroFactura), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNroFactura_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNroFactura_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNroFacturaInicial_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNroFacturaInicial_Internalname, httpContext.getMessage( "Factura Inicial", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNroFacturaInicial_Internalname, GXutil.ltrim( localUtil.ntoc( A304TimbradoNroFacturaInicial, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNroFacturaInicial_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNroFacturaInicial_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNroFacturaInicial_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNroFacturaFinal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNroFacturaFinal_Internalname, httpContext.getMessage( "Factura Final", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNroFacturaFinal_Internalname, GXutil.ltrim( localUtil.ntoc( A305TimbradoNroFacturaFinal, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNroFacturaFinal_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNroFacturaFinal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNroFacturaFinal_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNroFacturaSerie1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNroFacturaSerie1_Internalname, httpContext.getMessage( "Factura Serie1", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNroFacturaSerie1_Internalname, GXutil.ltrim( localUtil.ntoc( A306TimbradoNroFacturaSerie1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNroFacturaSerie1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNroFacturaSerie1_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNroFacturaSerie1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "SerieFac", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNroFacturaSerie2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNroFacturaSerie2_Internalname, httpContext.getMessage( "Factura Serie2", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNroFacturaSerie2_Internalname, GXutil.ltrim( localUtil.ntoc( A307TimbradoNroFacturaSerie2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNroFacturaSerie2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNroFacturaSerie2_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoNroFacturaSerie2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "SerieFac", "right", false, "", "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoEstado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoEstado_Internalname, httpContext.getMessage( "Estado", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoEstado_Internalname, GXutil.rtrim( A308TimbradoEstado), GXutil.rtrim( localUtil.format( A308TimbradoEstado, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoEstado_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTimbradoEstado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Timbrado.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Timbrado.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Timbrado.htm");
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
      e110Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z29TimbradoId = localUtil.ctol( httpContext.cgiGet( "Z29TimbradoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z125TimbradoNumero = localUtil.ctol( httpContext.cgiGet( "Z125TimbradoNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z126TimbradoInicioVigencia = localUtil.ctod( httpContext.cgiGet( "Z126TimbradoInicioVigencia"), 0) ;
            Z127TimbradoFinVigencia = localUtil.ctod( httpContext.cgiGet( "Z127TimbradoFinVigencia"), 0) ;
            Z128TimbradoNroFactura = localUtil.ctol( httpContext.cgiGet( "Z128TimbradoNroFactura"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z304TimbradoNroFacturaInicial = localUtil.ctol( httpContext.cgiGet( "Z304TimbradoNroFacturaInicial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z305TimbradoNroFacturaFinal = localUtil.ctol( httpContext.cgiGet( "Z305TimbradoNroFacturaFinal"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z306TimbradoNroFacturaSerie1 = (short)(localUtil.ctol( httpContext.cgiGet( "Z306TimbradoNroFacturaSerie1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z307TimbradoNroFacturaSerie2 = (short)(localUtil.ctol( httpContext.cgiGet( "Z307TimbradoNroFacturaSerie2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z308TimbradoEstado = httpContext.cgiGet( "Z308TimbradoEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7TimbradoId = localUtil.ctol( httpContext.cgiGet( "vTIMBRADOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A29TimbradoId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            }
            else
            {
               A29TimbradoId = localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADONUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A125TimbradoNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
            }
            else
            {
               A125TimbradoNumero = localUtil.ctol( httpContext.cgiGet( edtTimbradoNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtTimbradoInicioVigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "TIMBRADOINICIOVIGENCIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoInicioVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A126TimbradoInicioVigencia = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A126TimbradoInicioVigencia", localUtil.format(A126TimbradoInicioVigencia, "99/99/99"));
            }
            else
            {
               A126TimbradoInicioVigencia = localUtil.ctod( httpContext.cgiGet( edtTimbradoInicioVigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A126TimbradoInicioVigencia", localUtil.format(A126TimbradoInicioVigencia, "99/99/99"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtTimbradoFinVigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "TIMBRADOFINVIGENCIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoFinVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A127TimbradoFinVigencia = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A127TimbradoFinVigencia", localUtil.format(A127TimbradoFinVigencia, "99/99/99"));
            }
            else
            {
               A127TimbradoFinVigencia = localUtil.ctod( httpContext.cgiGet( edtTimbradoFinVigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A127TimbradoFinVigencia", localUtil.format(A127TimbradoFinVigencia, "99/99/99"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADONROFACTURA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoNroFactura_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A128TimbradoNroFactura = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A128TimbradoNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A128TimbradoNroFactura), 15, 0));
            }
            else
            {
               A128TimbradoNroFactura = localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A128TimbradoNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A128TimbradoNroFactura), 15, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaInicial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaInicial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADONROFACTURAINICIAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoNroFacturaInicial_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A304TimbradoNroFacturaInicial = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A304TimbradoNroFacturaInicial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), 15, 0));
            }
            else
            {
               A304TimbradoNroFacturaInicial = localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaInicial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A304TimbradoNroFacturaInicial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), 15, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaFinal_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaFinal_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADONROFACTURAFINAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoNroFacturaFinal_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A305TimbradoNroFacturaFinal = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A305TimbradoNroFacturaFinal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), 15, 0));
            }
            else
            {
               A305TimbradoNroFacturaFinal = localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaFinal_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A305TimbradoNroFacturaFinal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), 15, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADONROFACTURASERIE1");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoNroFacturaSerie1_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A306TimbradoNroFacturaSerie1 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A306TimbradoNroFacturaSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), 3, 0));
            }
            else
            {
               A306TimbradoNroFacturaSerie1 = (short)(localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A306TimbradoNroFacturaSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADONROFACTURASERIE2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoNroFacturaSerie2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A307TimbradoNroFacturaSerie2 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A307TimbradoNroFacturaSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), 3, 0));
            }
            else
            {
               A307TimbradoNroFacturaSerie2 = (short)(localUtil.ctol( httpContext.cgiGet( edtTimbradoNroFacturaSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A307TimbradoNroFacturaSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), 3, 0));
            }
            A308TimbradoEstado = httpContext.cgiGet( edtTimbradoEstado_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A308TimbradoEstado", A308TimbradoEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Timbrado");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A29TimbradoId != Z29TimbradoId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("timbrado:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A29TimbradoId = GXutil.lval( httpContext.GetPar( "TimbradoId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
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
                  sMode27 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode27 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound27 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0Q0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "TIMBRADOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtTimbradoId_Internalname ;
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
                        e110Q2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120Q2 ();
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
         e120Q2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0Q27( ) ;
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
         disableAttributes0Q27( ) ;
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

   public void confirm_0Q0( )
   {
      beforeValidate0Q27( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Q27( ) ;
         }
         else
         {
            checkExtendedTable0Q27( ) ;
            closeExtendedTableCursors0Q27( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0Q0( )
   {
   }

   public void e110Q2( )
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

   public void e120Q2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.timbradoww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0Q27( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z125TimbradoNumero = T000Q3_A125TimbradoNumero[0] ;
            Z126TimbradoInicioVigencia = T000Q3_A126TimbradoInicioVigencia[0] ;
            Z127TimbradoFinVigencia = T000Q3_A127TimbradoFinVigencia[0] ;
            Z128TimbradoNroFactura = T000Q3_A128TimbradoNroFactura[0] ;
            Z304TimbradoNroFacturaInicial = T000Q3_A304TimbradoNroFacturaInicial[0] ;
            Z305TimbradoNroFacturaFinal = T000Q3_A305TimbradoNroFacturaFinal[0] ;
            Z306TimbradoNroFacturaSerie1 = T000Q3_A306TimbradoNroFacturaSerie1[0] ;
            Z307TimbradoNroFacturaSerie2 = T000Q3_A307TimbradoNroFacturaSerie2[0] ;
            Z308TimbradoEstado = T000Q3_A308TimbradoEstado[0] ;
         }
         else
         {
            Z125TimbradoNumero = A125TimbradoNumero ;
            Z126TimbradoInicioVigencia = A126TimbradoInicioVigencia ;
            Z127TimbradoFinVigencia = A127TimbradoFinVigencia ;
            Z128TimbradoNroFactura = A128TimbradoNroFactura ;
            Z304TimbradoNroFacturaInicial = A304TimbradoNroFacturaInicial ;
            Z305TimbradoNroFacturaFinal = A305TimbradoNroFacturaFinal ;
            Z306TimbradoNroFacturaSerie1 = A306TimbradoNroFacturaSerie1 ;
            Z307TimbradoNroFacturaSerie2 = A307TimbradoNroFacturaSerie2 ;
            Z308TimbradoEstado = A308TimbradoEstado ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z29TimbradoId = A29TimbradoId ;
         Z125TimbradoNumero = A125TimbradoNumero ;
         Z126TimbradoInicioVigencia = A126TimbradoInicioVigencia ;
         Z127TimbradoFinVigencia = A127TimbradoFinVigencia ;
         Z128TimbradoNroFactura = A128TimbradoNroFactura ;
         Z304TimbradoNroFacturaInicial = A304TimbradoNroFacturaInicial ;
         Z305TimbradoNroFacturaFinal = A305TimbradoNroFacturaFinal ;
         Z306TimbradoNroFacturaSerie1 = A306TimbradoNroFacturaSerie1 ;
         Z307TimbradoNroFacturaSerie2 = A307TimbradoNroFacturaSerie2 ;
         Z308TimbradoEstado = A308TimbradoEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7TimbradoId) )
      {
         A29TimbradoId = AV7TimbradoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      }
      if ( ! (0==AV7TimbradoId) )
      {
         edtTimbradoId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      }
      else
      {
         edtTimbradoId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7TimbradoId) )
      {
         edtTimbradoId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
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

   public void load0Q27( )
   {
      /* Using cursor T000Q4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound27 = (short)(1) ;
         A125TimbradoNumero = T000Q4_A125TimbradoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
         A126TimbradoInicioVigencia = T000Q4_A126TimbradoInicioVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A126TimbradoInicioVigencia", localUtil.format(A126TimbradoInicioVigencia, "99/99/99"));
         A127TimbradoFinVigencia = T000Q4_A127TimbradoFinVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A127TimbradoFinVigencia", localUtil.format(A127TimbradoFinVigencia, "99/99/99"));
         A128TimbradoNroFactura = T000Q4_A128TimbradoNroFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A128TimbradoNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A128TimbradoNroFactura), 15, 0));
         A304TimbradoNroFacturaInicial = T000Q4_A304TimbradoNroFacturaInicial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A304TimbradoNroFacturaInicial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), 15, 0));
         A305TimbradoNroFacturaFinal = T000Q4_A305TimbradoNroFacturaFinal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A305TimbradoNroFacturaFinal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), 15, 0));
         A306TimbradoNroFacturaSerie1 = T000Q4_A306TimbradoNroFacturaSerie1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A306TimbradoNroFacturaSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), 3, 0));
         A307TimbradoNroFacturaSerie2 = T000Q4_A307TimbradoNroFacturaSerie2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A307TimbradoNroFacturaSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), 3, 0));
         A308TimbradoEstado = T000Q4_A308TimbradoEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A308TimbradoEstado", A308TimbradoEstado);
         zm0Q27( -6) ;
      }
      pr_default.close(2);
      onLoadActions0Q27( ) ;
   }

   public void onLoadActions0Q27( )
   {
   }

   public void checkExtendedTable0Q27( )
   {
      nIsDirty_27 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A126TimbradoInicioVigencia)) || (( GXutil.resetTime(A126TimbradoInicioVigencia).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A126TimbradoInicioVigencia), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Timbrado Inicio Vigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIMBRADOINICIOVIGENCIA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoInicioVigencia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A127TimbradoFinVigencia)) || (( GXutil.resetTime(A127TimbradoFinVigencia).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A127TimbradoFinVigencia), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Timbrado Fin Vigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIMBRADOFINVIGENCIA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoFinVigencia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0Q27( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0Q27( )
   {
      /* Using cursor T000Q5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound27 = (short)(1) ;
      }
      else
      {
         RcdFound27 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Q3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Q27( 6) ;
         RcdFound27 = (short)(1) ;
         A29TimbradoId = T000Q3_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         A125TimbradoNumero = T000Q3_A125TimbradoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
         A126TimbradoInicioVigencia = T000Q3_A126TimbradoInicioVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A126TimbradoInicioVigencia", localUtil.format(A126TimbradoInicioVigencia, "99/99/99"));
         A127TimbradoFinVigencia = T000Q3_A127TimbradoFinVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A127TimbradoFinVigencia", localUtil.format(A127TimbradoFinVigencia, "99/99/99"));
         A128TimbradoNroFactura = T000Q3_A128TimbradoNroFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A128TimbradoNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A128TimbradoNroFactura), 15, 0));
         A304TimbradoNroFacturaInicial = T000Q3_A304TimbradoNroFacturaInicial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A304TimbradoNroFacturaInicial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), 15, 0));
         A305TimbradoNroFacturaFinal = T000Q3_A305TimbradoNroFacturaFinal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A305TimbradoNroFacturaFinal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), 15, 0));
         A306TimbradoNroFacturaSerie1 = T000Q3_A306TimbradoNroFacturaSerie1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A306TimbradoNroFacturaSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), 3, 0));
         A307TimbradoNroFacturaSerie2 = T000Q3_A307TimbradoNroFacturaSerie2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A307TimbradoNroFacturaSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), 3, 0));
         A308TimbradoEstado = T000Q3_A308TimbradoEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A308TimbradoEstado", A308TimbradoEstado);
         Z29TimbradoId = A29TimbradoId ;
         sMode27 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0Q27( ) ;
         if ( AnyError == 1 )
         {
            RcdFound27 = (short)(0) ;
            initializeNonKey0Q27( ) ;
         }
         Gx_mode = sMode27 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound27 = (short)(0) ;
         initializeNonKey0Q27( ) ;
         sMode27 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode27 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Q27( ) ;
      if ( RcdFound27 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound27 = (short)(0) ;
      /* Using cursor T000Q6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T000Q6_A29TimbradoId[0] < A29TimbradoId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T000Q6_A29TimbradoId[0] > A29TimbradoId ) ) )
         {
            A29TimbradoId = T000Q6_A29TimbradoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            RcdFound27 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound27 = (short)(0) ;
      /* Using cursor T000Q7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T000Q7_A29TimbradoId[0] > A29TimbradoId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T000Q7_A29TimbradoId[0] < A29TimbradoId ) ) )
         {
            A29TimbradoId = T000Q7_A29TimbradoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            RcdFound27 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Q27( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Q27( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound27 == 1 )
         {
            if ( A29TimbradoId != Z29TimbradoId )
            {
               A29TimbradoId = Z29TimbradoId ;
               httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "TIMBRADOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTimbradoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtTimbradoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0Q27( ) ;
               GX_FocusControl = edtTimbradoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A29TimbradoId != Z29TimbradoId )
            {
               /* Insert record */
               GX_FocusControl = edtTimbradoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Q27( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "TIMBRADOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtTimbradoId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtTimbradoId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Q27( ) ;
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
      if ( A29TimbradoId != Z29TimbradoId )
      {
         A29TimbradoId = Z29TimbradoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0Q27( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Q2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A29TimbradoId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Timbrado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z125TimbradoNumero != T000Q2_A125TimbradoNumero[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z126TimbradoInicioVigencia), GXutil.resetTime(T000Q2_A126TimbradoInicioVigencia[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z127TimbradoFinVigencia), GXutil.resetTime(T000Q2_A127TimbradoFinVigencia[0])) ) || ( Z128TimbradoNroFactura != T000Q2_A128TimbradoNroFactura[0] ) || ( Z304TimbradoNroFacturaInicial != T000Q2_A304TimbradoNroFacturaInicial[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z305TimbradoNroFacturaFinal != T000Q2_A305TimbradoNroFacturaFinal[0] ) || ( Z306TimbradoNroFacturaSerie1 != T000Q2_A306TimbradoNroFacturaSerie1[0] ) || ( Z307TimbradoNroFacturaSerie2 != T000Q2_A307TimbradoNroFacturaSerie2[0] ) || ( GXutil.strcmp(Z308TimbradoEstado, T000Q2_A308TimbradoEstado[0]) != 0 ) )
         {
            if ( Z125TimbradoNumero != T000Q2_A125TimbradoNumero[0] )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoNumero");
               GXutil.writeLogRaw("Old: ",Z125TimbradoNumero);
               GXutil.writeLogRaw("Current: ",T000Q2_A125TimbradoNumero[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z126TimbradoInicioVigencia), GXutil.resetTime(T000Q2_A126TimbradoInicioVigencia[0])) ) )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoInicioVigencia");
               GXutil.writeLogRaw("Old: ",Z126TimbradoInicioVigencia);
               GXutil.writeLogRaw("Current: ",T000Q2_A126TimbradoInicioVigencia[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z127TimbradoFinVigencia), GXutil.resetTime(T000Q2_A127TimbradoFinVigencia[0])) ) )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoFinVigencia");
               GXutil.writeLogRaw("Old: ",Z127TimbradoFinVigencia);
               GXutil.writeLogRaw("Current: ",T000Q2_A127TimbradoFinVigencia[0]);
            }
            if ( Z128TimbradoNroFactura != T000Q2_A128TimbradoNroFactura[0] )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoNroFactura");
               GXutil.writeLogRaw("Old: ",Z128TimbradoNroFactura);
               GXutil.writeLogRaw("Current: ",T000Q2_A128TimbradoNroFactura[0]);
            }
            if ( Z304TimbradoNroFacturaInicial != T000Q2_A304TimbradoNroFacturaInicial[0] )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoNroFacturaInicial");
               GXutil.writeLogRaw("Old: ",Z304TimbradoNroFacturaInicial);
               GXutil.writeLogRaw("Current: ",T000Q2_A304TimbradoNroFacturaInicial[0]);
            }
            if ( Z305TimbradoNroFacturaFinal != T000Q2_A305TimbradoNroFacturaFinal[0] )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoNroFacturaFinal");
               GXutil.writeLogRaw("Old: ",Z305TimbradoNroFacturaFinal);
               GXutil.writeLogRaw("Current: ",T000Q2_A305TimbradoNroFacturaFinal[0]);
            }
            if ( Z306TimbradoNroFacturaSerie1 != T000Q2_A306TimbradoNroFacturaSerie1[0] )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoNroFacturaSerie1");
               GXutil.writeLogRaw("Old: ",Z306TimbradoNroFacturaSerie1);
               GXutil.writeLogRaw("Current: ",T000Q2_A306TimbradoNroFacturaSerie1[0]);
            }
            if ( Z307TimbradoNroFacturaSerie2 != T000Q2_A307TimbradoNroFacturaSerie2[0] )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoNroFacturaSerie2");
               GXutil.writeLogRaw("Old: ",Z307TimbradoNroFacturaSerie2);
               GXutil.writeLogRaw("Current: ",T000Q2_A307TimbradoNroFacturaSerie2[0]);
            }
            if ( GXutil.strcmp(Z308TimbradoEstado, T000Q2_A308TimbradoEstado[0]) != 0 )
            {
               GXutil.writeLogln("timbrado:[seudo value changed for attri]"+"TimbradoEstado");
               GXutil.writeLogRaw("Old: ",Z308TimbradoEstado);
               GXutil.writeLogRaw("Current: ",T000Q2_A308TimbradoEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Timbrado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Q27( )
   {
      if ( ! IsAuthorized("timbrado_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Q27( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q27( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Q27( 0) ;
         checkOptimisticConcurrency0Q27( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q27( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Q27( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Q8 */
                  pr_default.execute(6, new Object[] {Long.valueOf(A29TimbradoId), Long.valueOf(A125TimbradoNumero), A126TimbradoInicioVigencia, A127TimbradoFinVigencia, Long.valueOf(A128TimbradoNroFactura), Long.valueOf(A304TimbradoNroFacturaInicial), Long.valueOf(A305TimbradoNroFacturaFinal), Short.valueOf(A306TimbradoNroFacturaSerie1), Short.valueOf(A307TimbradoNroFacturaSerie2), A308TimbradoEstado});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Timbrado");
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
                        resetCaption0Q0( ) ;
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
            load0Q27( ) ;
         }
         endLevel0Q27( ) ;
      }
      closeExtendedTableCursors0Q27( ) ;
   }

   public void update0Q27( )
   {
      if ( ! IsAuthorized("timbrado_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Q27( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q27( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q27( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q27( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Q27( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Q9 */
                  pr_default.execute(7, new Object[] {Long.valueOf(A125TimbradoNumero), A126TimbradoInicioVigencia, A127TimbradoFinVigencia, Long.valueOf(A128TimbradoNroFactura), Long.valueOf(A304TimbradoNroFacturaInicial), Long.valueOf(A305TimbradoNroFacturaFinal), Short.valueOf(A306TimbradoNroFacturaSerie1), Short.valueOf(A307TimbradoNroFacturaSerie2), A308TimbradoEstado, Long.valueOf(A29TimbradoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Timbrado");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Timbrado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Q27( ) ;
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
         endLevel0Q27( ) ;
      }
      closeExtendedTableCursors0Q27( ) ;
   }

   public void deferredUpdate0Q27( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("timbrado_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Q27( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q27( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Q27( ) ;
         afterConfirm0Q27( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Q27( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Q10 */
               pr_default.execute(8, new Object[] {Long.valueOf(A29TimbradoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Timbrado");
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
      sMode27 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Q27( ) ;
      Gx_mode = sMode27 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Q27( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T000Q11 */
         pr_default.execute(9, new Object[] {Long.valueOf(A29TimbradoId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Factura", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor T000Q12 */
         pr_default.execute(10, new Object[] {Long.valueOf(A29TimbradoId)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Ventas", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel0Q27( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Q27( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "timbrado");
         if ( AnyError == 0 )
         {
            confirmValues0Q0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "timbrado");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Q27( )
   {
      /* Scan By routine */
      /* Using cursor T000Q13 */
      pr_default.execute(11);
      RcdFound27 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound27 = (short)(1) ;
         A29TimbradoId = T000Q13_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Q27( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound27 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound27 = (short)(1) ;
         A29TimbradoId = T000Q13_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      }
   }

   public void scanEnd0Q27( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0Q27( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Q27( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Q27( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Q27( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Q27( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Q27( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Q27( )
   {
      edtTimbradoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      edtTimbradoNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNumero_Enabled), 5, 0), true);
      edtTimbradoInicioVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoInicioVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoInicioVigencia_Enabled), 5, 0), true);
      edtTimbradoFinVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoFinVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoFinVigencia_Enabled), 5, 0), true);
      edtTimbradoNroFactura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNroFactura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNroFactura_Enabled), 5, 0), true);
      edtTimbradoNroFacturaInicial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNroFacturaInicial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNroFacturaInicial_Enabled), 5, 0), true);
      edtTimbradoNroFacturaFinal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNroFacturaFinal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNroFacturaFinal_Enabled), 5, 0), true);
      edtTimbradoNroFacturaSerie1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNroFacturaSerie1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNroFacturaSerie1_Enabled), 5, 0), true);
      edtTimbradoNroFacturaSerie2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoNroFacturaSerie2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoNroFacturaSerie2_Enabled), 5, 0), true);
      edtTimbradoEstado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoEstado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoEstado_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Q27( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Q0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.timbrado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7TimbradoId,11,0))}, new String[] {"Gx_mode","TimbradoId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Timbrado");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("timbrado:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z29TimbradoId", GXutil.ltrim( localUtil.ntoc( Z29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z125TimbradoNumero", GXutil.ltrim( localUtil.ntoc( Z125TimbradoNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z126TimbradoInicioVigencia", localUtil.dtoc( Z126TimbradoInicioVigencia, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z127TimbradoFinVigencia", localUtil.dtoc( Z127TimbradoFinVigencia, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z128TimbradoNroFactura", GXutil.ltrim( localUtil.ntoc( Z128TimbradoNroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z304TimbradoNroFacturaInicial", GXutil.ltrim( localUtil.ntoc( Z304TimbradoNroFacturaInicial, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z305TimbradoNroFacturaFinal", GXutil.ltrim( localUtil.ntoc( Z305TimbradoNroFacturaFinal, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z306TimbradoNroFacturaSerie1", GXutil.ltrim( localUtil.ntoc( Z306TimbradoNroFacturaSerie1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z307TimbradoNroFacturaSerie2", GXutil.ltrim( localUtil.ntoc( Z307TimbradoNroFacturaSerie2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z308TimbradoEstado", GXutil.rtrim( Z308TimbradoEstado));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vTIMBRADOID", GXutil.ltrim( localUtil.ntoc( AV7TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIMBRADOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7TimbradoId), "ZZZZZZZZZZ9")));
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
      return formatLink("com.mujermorena.timbrado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7TimbradoId,11,0))}, new String[] {"Gx_mode","TimbradoId"})  ;
   }

   public String getPgmname( )
   {
      return "Timbrado" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Timbrado", "") ;
   }

   public void initializeNonKey0Q27( )
   {
      A125TimbradoNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
      A126TimbradoInicioVigencia = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A126TimbradoInicioVigencia", localUtil.format(A126TimbradoInicioVigencia, "99/99/99"));
      A127TimbradoFinVigencia = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A127TimbradoFinVigencia", localUtil.format(A127TimbradoFinVigencia, "99/99/99"));
      A128TimbradoNroFactura = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A128TimbradoNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A128TimbradoNroFactura), 15, 0));
      A304TimbradoNroFacturaInicial = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A304TimbradoNroFacturaInicial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A304TimbradoNroFacturaInicial), 15, 0));
      A305TimbradoNroFacturaFinal = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A305TimbradoNroFacturaFinal", GXutil.ltrimstr( DecimalUtil.doubleToDec(A305TimbradoNroFacturaFinal), 15, 0));
      A306TimbradoNroFacturaSerie1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A306TimbradoNroFacturaSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A306TimbradoNroFacturaSerie1), 3, 0));
      A307TimbradoNroFacturaSerie2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A307TimbradoNroFacturaSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A307TimbradoNroFacturaSerie2), 3, 0));
      A308TimbradoEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A308TimbradoEstado", A308TimbradoEstado);
      Z125TimbradoNumero = 0 ;
      Z126TimbradoInicioVigencia = GXutil.nullDate() ;
      Z127TimbradoFinVigencia = GXutil.nullDate() ;
      Z128TimbradoNroFactura = 0 ;
      Z304TimbradoNroFacturaInicial = 0 ;
      Z305TimbradoNroFacturaFinal = 0 ;
      Z306TimbradoNroFacturaSerie1 = (short)(0) ;
      Z307TimbradoNroFacturaSerie2 = (short)(0) ;
      Z308TimbradoEstado = "" ;
   }

   public void initAll0Q27( )
   {
      A29TimbradoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      initializeNonKey0Q27( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211195977", true, true);
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
      httpContext.AddJavascriptSource("timbrado.js", "?20241211195977", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtTimbradoId_Internalname = "TIMBRADOID" ;
      edtTimbradoNumero_Internalname = "TIMBRADONUMERO" ;
      edtTimbradoInicioVigencia_Internalname = "TIMBRADOINICIOVIGENCIA" ;
      edtTimbradoFinVigencia_Internalname = "TIMBRADOFINVIGENCIA" ;
      edtTimbradoNroFactura_Internalname = "TIMBRADONROFACTURA" ;
      edtTimbradoNroFacturaInicial_Internalname = "TIMBRADONROFACTURAINICIAL" ;
      edtTimbradoNroFacturaFinal_Internalname = "TIMBRADONROFACTURAFINAL" ;
      edtTimbradoNroFacturaSerie1_Internalname = "TIMBRADONROFACTURASERIE1" ;
      edtTimbradoNroFacturaSerie2_Internalname = "TIMBRADONROFACTURASERIE2" ;
      edtTimbradoEstado_Internalname = "TIMBRADOESTADO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
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
      Form.setCaption( httpContext.getMessage( "Timbrado", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtTimbradoEstado_Jsonclick = "" ;
      edtTimbradoEstado_Enabled = 1 ;
      edtTimbradoNroFacturaSerie2_Jsonclick = "" ;
      edtTimbradoNroFacturaSerie2_Enabled = 1 ;
      edtTimbradoNroFacturaSerie1_Jsonclick = "" ;
      edtTimbradoNroFacturaSerie1_Enabled = 1 ;
      edtTimbradoNroFacturaFinal_Jsonclick = "" ;
      edtTimbradoNroFacturaFinal_Enabled = 1 ;
      edtTimbradoNroFacturaInicial_Jsonclick = "" ;
      edtTimbradoNroFacturaInicial_Enabled = 1 ;
      edtTimbradoNroFactura_Jsonclick = "" ;
      edtTimbradoNroFactura_Enabled = 1 ;
      edtTimbradoFinVigencia_Jsonclick = "" ;
      edtTimbradoFinVigencia_Enabled = 1 ;
      edtTimbradoInicioVigencia_Jsonclick = "" ;
      edtTimbradoInicioVigencia_Enabled = 1 ;
      edtTimbradoNumero_Jsonclick = "" ;
      edtTimbradoNumero_Enabled = 1 ;
      edtTimbradoId_Jsonclick = "" ;
      edtTimbradoId_Enabled = 1 ;
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

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7TimbradoId',fld:'vTIMBRADOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7TimbradoId',fld:'vTIMBRADOID',pic:'ZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120Q2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOID","{handler:'valid_Timbradoid',iparms:[]");
      setEventMetadata("VALID_TIMBRADOID",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOINICIOVIGENCIA","{handler:'valid_Timbradoiniciovigencia',iparms:[]");
      setEventMetadata("VALID_TIMBRADOINICIOVIGENCIA",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOFINVIGENCIA","{handler:'valid_Timbradofinvigencia',iparms:[]");
      setEventMetadata("VALID_TIMBRADOFINVIGENCIA",",oparms:[]}");
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
      return "timbrado_Execute";
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
      wcpOGx_mode = "" ;
      Z126TimbradoInicioVigencia = GXutil.nullDate() ;
      Z127TimbradoFinVigencia = GXutil.nullDate() ;
      Z308TimbradoEstado = "" ;
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
      A126TimbradoInicioVigencia = GXutil.nullDate() ;
      A127TimbradoFinVigencia = GXutil.nullDate() ;
      A308TimbradoEstado = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode27 = "" ;
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
      T000Q4_A29TimbradoId = new long[1] ;
      T000Q4_A125TimbradoNumero = new long[1] ;
      T000Q4_A126TimbradoInicioVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q4_A127TimbradoFinVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q4_A128TimbradoNroFactura = new long[1] ;
      T000Q4_A304TimbradoNroFacturaInicial = new long[1] ;
      T000Q4_A305TimbradoNroFacturaFinal = new long[1] ;
      T000Q4_A306TimbradoNroFacturaSerie1 = new short[1] ;
      T000Q4_A307TimbradoNroFacturaSerie2 = new short[1] ;
      T000Q4_A308TimbradoEstado = new String[] {""} ;
      T000Q5_A29TimbradoId = new long[1] ;
      T000Q3_A29TimbradoId = new long[1] ;
      T000Q3_A125TimbradoNumero = new long[1] ;
      T000Q3_A126TimbradoInicioVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q3_A127TimbradoFinVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q3_A128TimbradoNroFactura = new long[1] ;
      T000Q3_A304TimbradoNroFacturaInicial = new long[1] ;
      T000Q3_A305TimbradoNroFacturaFinal = new long[1] ;
      T000Q3_A306TimbradoNroFacturaSerie1 = new short[1] ;
      T000Q3_A307TimbradoNroFacturaSerie2 = new short[1] ;
      T000Q3_A308TimbradoEstado = new String[] {""} ;
      T000Q6_A29TimbradoId = new long[1] ;
      T000Q7_A29TimbradoId = new long[1] ;
      T000Q2_A29TimbradoId = new long[1] ;
      T000Q2_A125TimbradoNumero = new long[1] ;
      T000Q2_A126TimbradoInicioVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q2_A127TimbradoFinVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q2_A128TimbradoNroFactura = new long[1] ;
      T000Q2_A304TimbradoNroFacturaInicial = new long[1] ;
      T000Q2_A305TimbradoNroFacturaFinal = new long[1] ;
      T000Q2_A306TimbradoNroFacturaSerie1 = new short[1] ;
      T000Q2_A307TimbradoNroFacturaSerie2 = new short[1] ;
      T000Q2_A308TimbradoEstado = new String[] {""} ;
      T000Q11_A30FacturaId = new long[1] ;
      T000Q12_A19VentasId = new long[1] ;
      T000Q13_A29TimbradoId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.timbrado__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.timbrado__default(),
         new Object[] {
             new Object[] {
            T000Q2_A29TimbradoId, T000Q2_A125TimbradoNumero, T000Q2_A126TimbradoInicioVigencia, T000Q2_A127TimbradoFinVigencia, T000Q2_A128TimbradoNroFactura, T000Q2_A304TimbradoNroFacturaInicial, T000Q2_A305TimbradoNroFacturaFinal, T000Q2_A306TimbradoNroFacturaSerie1, T000Q2_A307TimbradoNroFacturaSerie2, T000Q2_A308TimbradoEstado
            }
            , new Object[] {
            T000Q3_A29TimbradoId, T000Q3_A125TimbradoNumero, T000Q3_A126TimbradoInicioVigencia, T000Q3_A127TimbradoFinVigencia, T000Q3_A128TimbradoNroFactura, T000Q3_A304TimbradoNroFacturaInicial, T000Q3_A305TimbradoNroFacturaFinal, T000Q3_A306TimbradoNroFacturaSerie1, T000Q3_A307TimbradoNroFacturaSerie2, T000Q3_A308TimbradoEstado
            }
            , new Object[] {
            T000Q4_A29TimbradoId, T000Q4_A125TimbradoNumero, T000Q4_A126TimbradoInicioVigencia, T000Q4_A127TimbradoFinVigencia, T000Q4_A128TimbradoNroFactura, T000Q4_A304TimbradoNroFacturaInicial, T000Q4_A305TimbradoNroFacturaFinal, T000Q4_A306TimbradoNroFacturaSerie1, T000Q4_A307TimbradoNroFacturaSerie2, T000Q4_A308TimbradoEstado
            }
            , new Object[] {
            T000Q5_A29TimbradoId
            }
            , new Object[] {
            T000Q6_A29TimbradoId
            }
            , new Object[] {
            T000Q7_A29TimbradoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Q11_A30FacturaId
            }
            , new Object[] {
            T000Q12_A19VentasId
            }
            , new Object[] {
            T000Q13_A29TimbradoId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z306TimbradoNroFacturaSerie1 ;
   private short Z307TimbradoNroFacturaSerie2 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A306TimbradoNroFacturaSerie1 ;
   private short A307TimbradoNroFacturaSerie2 ;
   private short RcdFound27 ;
   private short nIsDirty_27 ;
   private int trnEnded ;
   private int edtTimbradoId_Enabled ;
   private int edtTimbradoNumero_Enabled ;
   private int edtTimbradoInicioVigencia_Enabled ;
   private int edtTimbradoFinVigencia_Enabled ;
   private int edtTimbradoNroFactura_Enabled ;
   private int edtTimbradoNroFacturaInicial_Enabled ;
   private int edtTimbradoNroFacturaFinal_Enabled ;
   private int edtTimbradoNroFacturaSerie1_Enabled ;
   private int edtTimbradoNroFacturaSerie2_Enabled ;
   private int edtTimbradoEstado_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7TimbradoId ;
   private long Z29TimbradoId ;
   private long Z125TimbradoNumero ;
   private long Z128TimbradoNroFactura ;
   private long Z304TimbradoNroFacturaInicial ;
   private long Z305TimbradoNroFacturaFinal ;
   private long AV7TimbradoId ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A128TimbradoNroFactura ;
   private long A304TimbradoNroFacturaInicial ;
   private long A305TimbradoNroFacturaFinal ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z308TimbradoEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtTimbradoId_Internalname ;
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
   private String edtTimbradoId_Jsonclick ;
   private String edtTimbradoNumero_Internalname ;
   private String edtTimbradoNumero_Jsonclick ;
   private String edtTimbradoInicioVigencia_Internalname ;
   private String edtTimbradoInicioVigencia_Jsonclick ;
   private String edtTimbradoFinVigencia_Internalname ;
   private String edtTimbradoFinVigencia_Jsonclick ;
   private String edtTimbradoNroFactura_Internalname ;
   private String edtTimbradoNroFactura_Jsonclick ;
   private String edtTimbradoNroFacturaInicial_Internalname ;
   private String edtTimbradoNroFacturaInicial_Jsonclick ;
   private String edtTimbradoNroFacturaFinal_Internalname ;
   private String edtTimbradoNroFacturaFinal_Jsonclick ;
   private String edtTimbradoNroFacturaSerie1_Internalname ;
   private String edtTimbradoNroFacturaSerie1_Jsonclick ;
   private String edtTimbradoNroFacturaSerie2_Internalname ;
   private String edtTimbradoNroFacturaSerie2_Jsonclick ;
   private String edtTimbradoEstado_Internalname ;
   private String A308TimbradoEstado ;
   private String edtTimbradoEstado_Jsonclick ;
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
   private String sMode27 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z126TimbradoInicioVigencia ;
   private java.util.Date Z127TimbradoFinVigencia ;
   private java.util.Date A126TimbradoInicioVigencia ;
   private java.util.Date A127TimbradoFinVigencia ;
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
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] T000Q4_A29TimbradoId ;
   private long[] T000Q4_A125TimbradoNumero ;
   private java.util.Date[] T000Q4_A126TimbradoInicioVigencia ;
   private java.util.Date[] T000Q4_A127TimbradoFinVigencia ;
   private long[] T000Q4_A128TimbradoNroFactura ;
   private long[] T000Q4_A304TimbradoNroFacturaInicial ;
   private long[] T000Q4_A305TimbradoNroFacturaFinal ;
   private short[] T000Q4_A306TimbradoNroFacturaSerie1 ;
   private short[] T000Q4_A307TimbradoNroFacturaSerie2 ;
   private String[] T000Q4_A308TimbradoEstado ;
   private long[] T000Q5_A29TimbradoId ;
   private long[] T000Q3_A29TimbradoId ;
   private long[] T000Q3_A125TimbradoNumero ;
   private java.util.Date[] T000Q3_A126TimbradoInicioVigencia ;
   private java.util.Date[] T000Q3_A127TimbradoFinVigencia ;
   private long[] T000Q3_A128TimbradoNroFactura ;
   private long[] T000Q3_A304TimbradoNroFacturaInicial ;
   private long[] T000Q3_A305TimbradoNroFacturaFinal ;
   private short[] T000Q3_A306TimbradoNroFacturaSerie1 ;
   private short[] T000Q3_A307TimbradoNroFacturaSerie2 ;
   private String[] T000Q3_A308TimbradoEstado ;
   private long[] T000Q6_A29TimbradoId ;
   private long[] T000Q7_A29TimbradoId ;
   private long[] T000Q2_A29TimbradoId ;
   private long[] T000Q2_A125TimbradoNumero ;
   private java.util.Date[] T000Q2_A126TimbradoInicioVigencia ;
   private java.util.Date[] T000Q2_A127TimbradoFinVigencia ;
   private long[] T000Q2_A128TimbradoNroFactura ;
   private long[] T000Q2_A304TimbradoNroFacturaInicial ;
   private long[] T000Q2_A305TimbradoNroFacturaFinal ;
   private short[] T000Q2_A306TimbradoNroFacturaSerie1 ;
   private short[] T000Q2_A307TimbradoNroFacturaSerie2 ;
   private String[] T000Q2_A308TimbradoEstado ;
   private long[] T000Q11_A30FacturaId ;
   private long[] T000Q12_A19VentasId ;
   private long[] T000Q13_A29TimbradoId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class timbrado__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class timbrado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Q2", "SELECT [TimbradoId], [TimbradoNumero], [TimbradoInicioVigencia], [TimbradoFinVigencia], [TimbradoNroFactura], [TimbradoNroFacturaInicial], [TimbradoNroFacturaFinal], [TimbradoNroFacturaSerie1], [TimbradoNroFacturaSerie2], [TimbradoEstado] FROM [Timbrado] WITH (UPDLOCK) WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q3", "SELECT [TimbradoId], [TimbradoNumero], [TimbradoInicioVigencia], [TimbradoFinVigencia], [TimbradoNroFactura], [TimbradoNroFacturaInicial], [TimbradoNroFacturaFinal], [TimbradoNroFacturaSerie1], [TimbradoNroFacturaSerie2], [TimbradoEstado] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q4", "SELECT TM1.[TimbradoId], TM1.[TimbradoNumero], TM1.[TimbradoInicioVigencia], TM1.[TimbradoFinVigencia], TM1.[TimbradoNroFactura], TM1.[TimbradoNroFacturaInicial], TM1.[TimbradoNroFacturaFinal], TM1.[TimbradoNroFacturaSerie1], TM1.[TimbradoNroFacturaSerie2], TM1.[TimbradoEstado] FROM [Timbrado] TM1 WHERE TM1.[TimbradoId] = ? ORDER BY TM1.[TimbradoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q5", "SELECT [TimbradoId] FROM [Timbrado] WHERE [TimbradoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q6", "SELECT TOP 1 [TimbradoId] FROM [Timbrado] WHERE ( [TimbradoId] > ?) ORDER BY [TimbradoId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Q7", "SELECT TOP 1 [TimbradoId] FROM [Timbrado] WHERE ( [TimbradoId] < ?) ORDER BY [TimbradoId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000Q8", "INSERT INTO [Timbrado]([TimbradoId], [TimbradoNumero], [TimbradoInicioVigencia], [TimbradoFinVigencia], [TimbradoNroFactura], [TimbradoNroFacturaInicial], [TimbradoNroFacturaFinal], [TimbradoNroFacturaSerie1], [TimbradoNroFacturaSerie2], [TimbradoEstado]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000Q9", "UPDATE [Timbrado] SET [TimbradoNumero]=?, [TimbradoInicioVigencia]=?, [TimbradoFinVigencia]=?, [TimbradoNroFactura]=?, [TimbradoNroFacturaInicial]=?, [TimbradoNroFacturaFinal]=?, [TimbradoNroFacturaSerie1]=?, [TimbradoNroFacturaSerie2]=?, [TimbradoEstado]=?  WHERE [TimbradoId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Q10", "DELETE FROM [Timbrado]  WHERE [TimbradoId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000Q11", "SELECT TOP 1 [FacturaId] FROM [Factura] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Q12", "SELECT TOP 1 [VentasId] FROM [Ventas] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Q13", "SELECT [TimbradoId] FROM [Timbrado] ORDER BY [TimbradoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
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
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 20);
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setLong(10, ((Number) parms[9]).longValue());
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
      }
   }

}

