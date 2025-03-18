package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class home_impl extends GXDataArea
{
   public home_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public home_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( home_impl.class ));
   }

   public home_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Banner") == 0 )
         {
            gxnrbanner_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Banner") == 0 )
         {
            gxgrbanner_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Bestsellers") == 0 )
         {
            gxnrbestsellers_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Bestsellers") == 0 )
         {
            gxgrbestsellers_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Bannersecondary") == 0 )
         {
            gxnrbannersecondary_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Bannersecondary") == 0 )
         {
            gxgrbannersecondary_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Otheritems") == 0 )
         {
            gxnrotheritems_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Otheritems") == 0 )
         {
            gxgrotheritems_refresh_invoke( ) ;
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
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrbanner_newrow_invoke( )
   {
      nRC_GXsfl_9 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_9"))) ;
      nGXsfl_9_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_9_idx"))) ;
      sGXsfl_9_idx = httpContext.GetPar( "sGXsfl_9_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrbanner_newrow( ) ;
      /* End function gxnrBanner_newrow_invoke */
   }

   public void gxgrbanner_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV8DVelop_ECommerceCart_OtherItems);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7DVelop_ECommerceCart);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrbanner_refresh( AV8DVelop_ECommerceCart_OtherItems, AV7DVelop_ECommerceCart) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrBanner_refresh_invoke */
   }

   public void gxnrbestsellers_newrow_invoke( )
   {
      nRC_GXsfl_20 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_20"))) ;
      nGXsfl_20_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_20_idx"))) ;
      sGXsfl_20_idx = httpContext.GetPar( "sGXsfl_20_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrbestsellers_newrow( ) ;
      /* End function gxnrBestsellers_newrow_invoke */
   }

   public void gxgrbestsellers_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7DVelop_ECommerceCart);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV8DVelop_ECommerceCart_OtherItems);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrbestsellers_refresh( AV7DVelop_ECommerceCart, AV8DVelop_ECommerceCart_OtherItems) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrBestsellers_refresh_invoke */
   }

   public void gxnrbannersecondary_newrow_invoke( )
   {
      nRC_GXsfl_60 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_60"))) ;
      nGXsfl_60_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_60_idx"))) ;
      sGXsfl_60_idx = httpContext.GetPar( "sGXsfl_60_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrbannersecondary_newrow( ) ;
      /* End function gxnrBannersecondary_newrow_invoke */
   }

   public void gxgrbannersecondary_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV8DVelop_ECommerceCart_OtherItems);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7DVelop_ECommerceCart);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrbannersecondary_refresh( AV8DVelop_ECommerceCart_OtherItems, AV7DVelop_ECommerceCart) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrBannersecondary_refresh_invoke */
   }

   public void gxnrotheritems_newrow_invoke( )
   {
      nRC_GXsfl_67 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_67"))) ;
      nGXsfl_67_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_67_idx"))) ;
      sGXsfl_67_idx = httpContext.GetPar( "sGXsfl_67_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrotheritems_newrow( ) ;
      /* End function gxnrOtheritems_newrow_invoke */
   }

   public void gxgrotheritems_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV8DVelop_ECommerceCart_OtherItems);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7DVelop_ECommerceCart);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrotheritems_refresh( AV8DVelop_ECommerceCart_OtherItems, AV7DVelop_ECommerceCart) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrOtheritems_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
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

   public byte executeStartEvent( )
   {
      pa0B2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0B2( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
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
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.home", new String[] {}, new String[] {}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART", getSecureSignedToken( "", AV7DVelop_ECommerceCart));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART_OTHERITEMS", getSecureSignedToken( "", AV8DVelop_ECommerceCart_OtherItems));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Dvelop_ecommercecart_otheritems", AV8DVelop_ECommerceCart_OtherItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Dvelop_ecommercecart_otheritems", AV8DVelop_ECommerceCart_OtherItems);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Dvelop_ecommercecart_otheritems", getSecureSignedToken( "", AV8DVelop_ECommerceCart_OtherItems));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Dvelop_ecommercecart", AV7DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Dvelop_ecommercecart", AV7DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Dvelop_ecommercecart", getSecureSignedToken( "", AV7DVelop_ECommerceCart));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_9", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_9, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_20", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_20, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_60", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_60, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_67", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_67, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECART", AV7DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECART", AV7DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART", getSecureSignedToken( "", AV7DVelop_ECommerceCart));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECART_OTHERITEMS", AV8DVelop_ECommerceCart_OtherItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECART_OTHERITEMS", AV8DVelop_ECommerceCart_OtherItems);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART_OTHERITEMS", getSecureSignedToken( "", AV8DVelop_ECommerceCart_OtherItems));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNER_Class", GXutil.rtrim( subBanner_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNER_Showarrows", GXutil.rtrim( subBanner_Showarrows));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNER_Autoplay", GXutil.rtrim( subBanner_Autoplay));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNER_Visible", GXutil.ltrim( localUtil.ntoc( subBanner_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BESTSELLERS_Class", GXutil.rtrim( subBestsellers_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BESTSELLERS_Showpagecontroller", GXutil.rtrim( subBestsellers_Showpagecontroller));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNERSECONDARY_Class", GXutil.rtrim( subBannersecondary_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNERSECONDARY_Showpagecontroller", GXutil.rtrim( subBannersecondary_Showpagecontroller));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNERSECONDARY_Showarrows", GXutil.rtrim( subBannersecondary_Showarrows));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Class", GXutil.rtrim( subOtheritems_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Showpagecontroller", GXutil.rtrim( subOtheritems_Showpagecontroller));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Showarrows", GXutil.rtrim( subOtheritems_Showarrows));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Multi_rows_xs", GXutil.rtrim( subOtheritems_Multi_rows_xs));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Multi_rows_sm", GXutil.rtrim( subOtheritems_Multi_rows_sm));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Multi_rows_md", GXutil.rtrim( subOtheritems_Multi_rows_md));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OTHERITEMS_Multi_rows_lg", GXutil.rtrim( subOtheritems_Multi_rows_lg));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0B2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0B2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.mujermorena.home", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Home" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_HomeTitle", "") ;
   }

   public void wb0B0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellNoPaddingHorizontal", "left", "top", "", "", "div");
         /*  Grid Control  */
         BannerContainer.SetIsFreestyle(true);
         BannerContainer.SetWrapped(nGXWrapped);
         startgridcontrol9( ) ;
      }
      if ( wbEnd == 9 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_9 = (int)(nGXsfl_9_idx-1) ;
         if ( BannerContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            if ( subBanner_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"BannerContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Banner", BannerContainer, subBanner_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannerContainerData", BannerContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannerContainerData"+"V", BannerContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"BannerContainerData"+"V"+"\" value='"+BannerContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellSubtitleECommerce", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblSubtitle_Internalname, httpContext.getMessage( "- LAS MEJORES PRENDAS LAS ENCONTRAS AQUI-", ""), "", "", lblSubtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SubtitleECommerce", 0, "", 1, 1, 0, (short)(0), "HLP_Home.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         BestsellersContainer.SetIsFreestyle(true);
         BestsellersContainer.SetWrapped(nGXWrapped);
         startgridcontrol20( ) ;
      }
      if ( wbEnd == 20 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_20 = (int)(nGXsfl_20_idx-1) ;
         if ( BestsellersContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV17GXV1 = nGXsfl_20_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"BestsellersContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Bestsellers", BestsellersContainer, subBestsellers_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BestsellersContainerData", BestsellersContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BestsellersContainerData"+"V", BestsellersContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"BestsellersContainerData"+"V"+"\" value='"+BestsellersContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellSubtitleECommerce", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblOthersubtitle_Internalname, httpContext.getMessage( "- ELIGE LO MEJOR PARA VOS-", ""), "", "", lblOthersubtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SubtitleECommerce", 0, "", 1, 1, 0, (short)(0), "HLP_Home.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 CellNoPaddingHorizontal", "left", "top", "", "", "div");
         /*  Grid Control  */
         BannersecondaryContainer.SetIsFreestyle(true);
         BannersecondaryContainer.SetWrapped(nGXWrapped);
         startgridcontrol60( ) ;
      }
      if ( wbEnd == 60 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_60 = (int)(nGXsfl_60_idx-1) ;
         if ( BannersecondaryContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"BannersecondaryContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Bannersecondary", BannersecondaryContainer, subBannersecondary_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannersecondaryContainerData", BannersecondaryContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannersecondaryContainerData"+"V", BannersecondaryContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"BannersecondaryContainerData"+"V"+"\" value='"+BannersecondaryContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /*  Grid Control  */
         OtheritemsContainer.SetIsFreestyle(true);
         OtheritemsContainer.SetWrapped(nGXWrapped);
         startgridcontrol67( ) ;
      }
      if ( wbEnd == 67 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_67 = (int)(nGXsfl_67_idx-1) ;
         if ( OtheritemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV21GXV5 = nGXsfl_67_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"OtheritemsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Otheritems", OtheritemsContainer, subOtheritems_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OtheritemsContainerData", OtheritemsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OtheritemsContainerData"+"V", OtheritemsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"OtheritemsContainerData"+"V"+"\" value='"+OtheritemsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      if ( wbEnd == 9 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( BannerContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               if ( subBanner_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"BannerContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Banner", BannerContainer, subBanner_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannerContainerData", BannerContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannerContainerData"+"V", BannerContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"BannerContainerData"+"V"+"\" value='"+BannerContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 20 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( BestsellersContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV17GXV1 = nGXsfl_20_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"BestsellersContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Bestsellers", BestsellersContainer, subBestsellers_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BestsellersContainerData", BestsellersContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BestsellersContainerData"+"V", BestsellersContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"BestsellersContainerData"+"V"+"\" value='"+BestsellersContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 60 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( BannersecondaryContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"BannersecondaryContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Bannersecondary", BannersecondaryContainer, subBannersecondary_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannersecondaryContainerData", BannersecondaryContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BannersecondaryContainerData"+"V", BannersecondaryContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"BannersecondaryContainerData"+"V"+"\" value='"+BannersecondaryContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 67 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( OtheritemsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV21GXV5 = nGXsfl_67_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"OtheritemsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Otheritems", OtheritemsContainer, subOtheritems_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OtheritemsContainerData", OtheritemsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "OtheritemsContainerData"+"V", OtheritemsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"OtheritemsContainerData"+"V"+"\" value='"+OtheritemsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0B2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_HomeTitle", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0B0( ) ;
   }

   public void ws0B2( )
   {
      start0B2( ) ;
      evt0B2( ) ;
   }

   public void evt0B2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "TABLECARDBESTSELLERS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e110B2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "TABLECARDOTHERITEMS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e120B2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "BANNER.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_9_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_92( ) ;
                           AV9ImageBanner = httpContext.cgiGet( edtavImagebanner_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagebanner_Internalname, "Bitmap", ((GXutil.strcmp("", AV9ImageBanner)==0) ? AV25Imagebanner_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV9ImageBanner))), !bGXsfl_9_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagebanner_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV9ImageBanner), true);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e130B2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "BANNER.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e140B2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 15), "OTHERITEMS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "TABLECARDOTHERITEMS.CLICK") == 0 ) )
                        {
                           nGXsfl_67_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_675( ) ;
                           AV21GXV5 = nGXsfl_67_idx ;
                           if ( ( AV8DVelop_ECommerceCart_OtherItems.size() >= AV21GXV5 ) && ( AV21GXV5 > 0 ) )
                           {
                              AV8DVelop_ECommerceCart_OtherItems.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)) );
                              AV11OtherItemsMainImage = httpContext.cgiGet( edtavOtheritemsmainimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop("", false, edtavOtheritemsmainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV11OtherItemsMainImage)==0) ? AV29Otheritemsmainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV11OtherItemsMainImage))), !bGXsfl_67_Refreshing);
                              httpContext.ajax_rsp_assign_prop("", false, edtavOtheritemsmainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV11OtherItemsMainImage), true);
                              AV12OtherItemsSecondaryImage = httpContext.cgiGet( edtavOtheritemssecondaryimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop("", false, edtavOtheritemssecondaryimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV12OtherItemsSecondaryImage)==0) ? AV30Otheritemssecondaryimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV12OtherItemsSecondaryImage))), !bGXsfl_67_Refreshing);
                              httpContext.ajax_rsp_assign_prop("", false, edtavOtheritemssecondaryimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV12OtherItemsSecondaryImage), true);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "OTHERITEMS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e150B5 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "TABLECARDOTHERITEMS.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e120B2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 20), "BANNERSECONDARY.LOAD") == 0 )
                        {
                           nGXsfl_60_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_60_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_60_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_604( ) ;
                           AV10ImageBanner2 = httpContext.cgiGet( edtavImagebanner2_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagebanner2_Internalname, "Bitmap", ((GXutil.strcmp("", AV10ImageBanner2)==0) ? AV26Imagebanner2_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV10ImageBanner2))), !bGXsfl_60_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagebanner2_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV10ImageBanner2), true);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "BANNERSECONDARY.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e160B4 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 16), "BESTSELLERS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "TABLECARDBESTSELLERS.CLICK") == 0 ) )
                        {
                           nGXsfl_20_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_203( ) ;
                           AV17GXV1 = nGXsfl_20_idx ;
                           if ( ( AV7DVelop_ECommerceCart.size() >= AV17GXV1 ) && ( AV17GXV1 > 0 ) )
                           {
                              AV7DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)) );
                              AV5BestSellersMainImage = httpContext.cgiGet( edtavBestsellersmainimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop("", false, edtavBestsellersmainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV5BestSellersMainImage)==0) ? AV27Bestsellersmainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV5BestSellersMainImage))), !bGXsfl_20_Refreshing);
                              httpContext.ajax_rsp_assign_prop("", false, edtavBestsellersmainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV5BestSellersMainImage), true);
                              AV6BestSellersSecondaryImage = httpContext.cgiGet( edtavBestsellerssecondaryimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop("", false, edtavBestsellerssecondaryimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV6BestSellersSecondaryImage)==0) ? AV28Bestsellerssecondaryimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV6BestSellersSecondaryImage))), !bGXsfl_20_Refreshing);
                              httpContext.ajax_rsp_assign_prop("", false, edtavBestsellerssecondaryimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV6BestSellersSecondaryImage), true);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "BESTSELLERS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e170B3 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "TABLECARDBESTSELLERS.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e110B2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0B2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa0B2( )
   {
      if ( nDonePA == 0 )
      {
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrbanner_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_92( ) ;
      while ( nGXsfl_9_idx <= nRC_GXsfl_9 )
      {
         sendrow_92( ) ;
         nGXsfl_9_idx = ((subBanner_Islastpage==1)&&(nGXsfl_9_idx+1>subbanner_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
         sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_92( ) ;
      }
      addString( httpContext.getJSONContainerResponse( BannerContainer)) ;
      /* End function gxnrBanner_newrow */
   }

   public void gxnrbestsellers_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_203( ) ;
      while ( nGXsfl_20_idx <= nRC_GXsfl_20 )
      {
         sendrow_203( ) ;
         nGXsfl_20_idx = ((subBestsellers_Islastpage==1)&&(nGXsfl_20_idx+1>subbestsellers_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
         sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_203( ) ;
      }
      addString( httpContext.getJSONContainerResponse( BestsellersContainer)) ;
      /* End function gxnrBestsellers_newrow */
   }

   public void gxnrbannersecondary_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_604( ) ;
      while ( nGXsfl_60_idx <= nRC_GXsfl_60 )
      {
         sendrow_604( ) ;
         nGXsfl_60_idx = ((subBannersecondary_Islastpage==1)&&(nGXsfl_60_idx+1>subbannersecondary_fnc_recordsperpage( )) ? 1 : nGXsfl_60_idx+1) ;
         sGXsfl_60_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_60_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_604( ) ;
      }
      addString( httpContext.getJSONContainerResponse( BannersecondaryContainer)) ;
      /* End function gxnrBannersecondary_newrow */
   }

   public void gxnrotheritems_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_675( ) ;
      while ( nGXsfl_67_idx <= nRC_GXsfl_67 )
      {
         sendrow_675( ) ;
         nGXsfl_67_idx = ((subOtheritems_Islastpage==1)&&(nGXsfl_67_idx+1>subotheritems_fnc_recordsperpage( )) ? 1 : nGXsfl_67_idx+1) ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_675( ) ;
      }
      addString( httpContext.getJSONContainerResponse( OtheritemsContainer)) ;
      /* End function gxnrOtheritems_newrow */
   }

   public void gxgrbanner_refresh( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart_OtherItems ,
                                   GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV7DVelop_ECommerceCart )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      BANNER_nCurrentRecord = 0 ;
      rf0B2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrBanner_refresh */
   }

   public void gxgrbestsellers_refresh( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV7DVelop_ECommerceCart ,
                                        GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart_OtherItems )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      BESTSELLERS_nCurrentRecord = 0 ;
      rf0B3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrBestsellers_refresh */
   }

   public void gxgrbannersecondary_refresh( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart_OtherItems ,
                                            GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV7DVelop_ECommerceCart )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      BANNERSECONDARY_nCurrentRecord = 0 ;
      rf0B4( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrBannersecondary_refresh */
   }

   public void gxgrotheritems_refresh( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart_OtherItems ,
                                       GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV7DVelop_ECommerceCart )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      OTHERITEMS_nCurrentRecord = 0 ;
      rf0B5( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrOtheritems_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0B2( ) ;
      rf0B3( ) ;
      rf0B4( ) ;
      rf0B5( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productname_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productsim_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productprice_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDvelop_ecommercecart_otheritems__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart_otheritems__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart_otheritems__productname_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDvelop_ecommercecart_otheritems__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart_otheritems__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart_otheritems__productsim_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDvelop_ecommercecart_otheritems__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart_otheritems__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart_otheritems__productprice_Enabled), 5, 0), !bGXsfl_67_Refreshing);
   }

   public void rf0B2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         BannerContainer.ClearRows();
      }
      wbStart = (short)(9) ;
      nGXsfl_9_idx = 1 ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      bGXsfl_9_Refreshing = true ;
      BannerContainer.AddObjectProperty("GridName", "Banner");
      BannerContainer.AddObjectProperty("CmpContext", "");
      BannerContainer.AddObjectProperty("InMasterPage", "false");
      BannerContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subBanner_Visible, (byte)(5), (byte)(0), ".", "")));
      BannerContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      BannerContainer.AddObjectProperty("Class", "FreeStyleGrid");
      BannerContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      BannerContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      BannerContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subBanner_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      BannerContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subBanner_Visible, (byte)(5), (byte)(0), ".", "")));
      BannerContainer.setPageSize( subbanner_fnc_recordsperpage( ) );
      if ( subBanner_Islastpage != 0 )
      {
         BANNER_nFirstRecordOnPage = (long)(subbanner_fnc_recordcount( )-subbanner_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNER_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( BANNER_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("BANNER_nFirstRecordOnPage", BANNER_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_92( ) ;
         e140B2 ();
         wbEnd = (short)(9) ;
         wb0B0( ) ;
      }
      bGXsfl_9_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0B2( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECART", AV7DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECART", AV7DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART", getSecureSignedToken( "", AV7DVelop_ECommerceCart));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECART_OTHERITEMS", AV8DVelop_ECommerceCart_OtherItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECART_OTHERITEMS", AV8DVelop_ECommerceCart_OtherItems);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART_OTHERITEMS", getSecureSignedToken( "", AV8DVelop_ECommerceCart_OtherItems));
   }

   public void rf0B3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         BestsellersContainer.ClearRows();
      }
      wbStart = (short)(20) ;
      nGXsfl_20_idx = 1 ;
      sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_203( ) ;
      bGXsfl_20_Refreshing = true ;
      BestsellersContainer.AddObjectProperty("GridName", "Bestsellers");
      BestsellersContainer.AddObjectProperty("CmpContext", "");
      BestsellersContainer.AddObjectProperty("InMasterPage", "false");
      BestsellersContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      BestsellersContainer.AddObjectProperty("Class", "FreeStyleGrid");
      BestsellersContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      BestsellersContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      BestsellersContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subBestsellers_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      BestsellersContainer.setPageSize( subbestsellers_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_203( ) ;
         e170B3 ();
         wbEnd = (short)(20) ;
         wb0B0( ) ;
      }
      bGXsfl_20_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0B3( )
   {
   }

   public void rf0B4( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         BannersecondaryContainer.ClearRows();
      }
      wbStart = (short)(60) ;
      nGXsfl_60_idx = 1 ;
      sGXsfl_60_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_60_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_604( ) ;
      bGXsfl_60_Refreshing = true ;
      BannersecondaryContainer.AddObjectProperty("GridName", "Bannersecondary");
      BannersecondaryContainer.AddObjectProperty("CmpContext", "");
      BannersecondaryContainer.AddObjectProperty("InMasterPage", "false");
      BannersecondaryContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      BannersecondaryContainer.AddObjectProperty("Class", "FreeStyleGrid");
      BannersecondaryContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      BannersecondaryContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      BannersecondaryContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      BannersecondaryContainer.setPageSize( subbannersecondary_fnc_recordsperpage( ) );
      if ( subBanner_Islastpage != 0 )
      {
         BANNER_nFirstRecordOnPage = (long)(subbanner_fnc_recordcount( )-subbanner_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "BANNER_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( BANNER_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("BANNER_nFirstRecordOnPage", BANNER_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_604( ) ;
         e160B4 ();
         wbEnd = (short)(60) ;
         wb0B0( ) ;
      }
      bGXsfl_60_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0B4( )
   {
   }

   public void rf0B5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         OtheritemsContainer.ClearRows();
      }
      wbStart = (short)(67) ;
      nGXsfl_67_idx = 1 ;
      sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_675( ) ;
      bGXsfl_67_Refreshing = true ;
      OtheritemsContainer.AddObjectProperty("GridName", "Otheritems");
      OtheritemsContainer.AddObjectProperty("CmpContext", "");
      OtheritemsContainer.AddObjectProperty("InMasterPage", "false");
      OtheritemsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      OtheritemsContainer.AddObjectProperty("Class", "FreeStyleGrid");
      OtheritemsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      OtheritemsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      OtheritemsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subOtheritems_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      OtheritemsContainer.setPageSize( subotheritems_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_675( ) ;
         e150B5 ();
         wbEnd = (short)(67) ;
         wb0B0( ) ;
      }
      bGXsfl_67_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0B5( )
   {
   }

   public int subbanner_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subbanner_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subbanner_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subbanner_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subbestsellers_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subbestsellers_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subbestsellers_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subbestsellers_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subbannersecondary_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subbannersecondary_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subbannersecondary_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subbannersecondary_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subotheritems_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subotheritems_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subotheritems_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subotheritems_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productname_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productsim_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productprice_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDvelop_ecommercecart_otheritems__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart_otheritems__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart_otheritems__productname_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDvelop_ecommercecart_otheritems__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart_otheritems__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart_otheritems__productsim_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDvelop_ecommercecart_otheritems__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart_otheritems__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart_otheritems__productprice_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup0B0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e130B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Dvelop_ecommercecart_otheritems"), AV8DVelop_ECommerceCart_OtherItems);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Dvelop_ecommercecart"), AV7DVelop_ECommerceCart);
         /* Read saved values. */
         nRC_GXsfl_9 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_9"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_20 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_20"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_60 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_60"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_67 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_67"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subBanner_Class = httpContext.cgiGet( "BANNER_Class") ;
         subBanner_Showarrows = httpContext.cgiGet( "BANNER_Showarrows") ;
         subBanner_Autoplay = httpContext.cgiGet( "BANNER_Autoplay") ;
         subBanner_Visible = (int)(localUtil.ctol( httpContext.cgiGet( "BANNER_Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subBestsellers_Class = httpContext.cgiGet( "BESTSELLERS_Class") ;
         subBestsellers_Showpagecontroller = httpContext.cgiGet( "BESTSELLERS_Showpagecontroller") ;
         subBannersecondary_Class = httpContext.cgiGet( "BANNERSECONDARY_Class") ;
         subBannersecondary_Showpagecontroller = httpContext.cgiGet( "BANNERSECONDARY_Showpagecontroller") ;
         subBannersecondary_Showarrows = httpContext.cgiGet( "BANNERSECONDARY_Showarrows") ;
         subOtheritems_Class = httpContext.cgiGet( "OTHERITEMS_Class") ;
         subOtheritems_Showpagecontroller = httpContext.cgiGet( "OTHERITEMS_Showpagecontroller") ;
         subOtheritems_Showarrows = httpContext.cgiGet( "OTHERITEMS_Showarrows") ;
         subOtheritems_Multi_rows_xs = httpContext.cgiGet( "OTHERITEMS_Multi_rows_xs") ;
         subOtheritems_Multi_rows_sm = httpContext.cgiGet( "OTHERITEMS_Multi_rows_sm") ;
         subOtheritems_Multi_rows_md = httpContext.cgiGet( "OTHERITEMS_Multi_rows_md") ;
         subOtheritems_Multi_rows_lg = httpContext.cgiGet( "OTHERITEMS_Multi_rows_lg") ;
         nRC_GXsfl_20 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_20"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_20_fel_idx = 0 ;
         while ( nGXsfl_20_fel_idx < nRC_GXsfl_20 )
         {
            nGXsfl_20_fel_idx = ((subBestsellers_Islastpage==1)&&(nGXsfl_20_fel_idx+1>subbestsellers_fnc_recordsperpage( )) ? 1 : nGXsfl_20_fel_idx+1) ;
            sGXsfl_20_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_203( ) ;
            AV17GXV1 = nGXsfl_20_fel_idx ;
            if ( ( AV7DVelop_ECommerceCart.size() >= AV17GXV1 ) && ( AV17GXV1 > 0 ) )
            {
               AV7DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)) );
               AV5BestSellersMainImage = httpContext.cgiGet( edtavBestsellersmainimage_Internalname) ;
               AV6BestSellersSecondaryImage = httpContext.cgiGet( edtavBestsellerssecondaryimage_Internalname) ;
            }
         }
         if ( nGXsfl_20_fel_idx == 0 )
         {
            nGXsfl_20_idx = 1 ;
            sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_203( ) ;
         }
         nGXsfl_20_fel_idx = 1 ;
         nRC_GXsfl_67 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_67"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_67_fel_idx = 0 ;
         while ( nGXsfl_67_fel_idx < nRC_GXsfl_67 )
         {
            nGXsfl_67_fel_idx = ((subOtheritems_Islastpage==1)&&(nGXsfl_67_fel_idx+1>subotheritems_fnc_recordsperpage( )) ? 1 : nGXsfl_67_fel_idx+1) ;
            sGXsfl_67_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_675( ) ;
            AV21GXV5 = nGXsfl_67_fel_idx ;
            if ( ( AV8DVelop_ECommerceCart_OtherItems.size() >= AV21GXV5 ) && ( AV21GXV5 > 0 ) )
            {
               AV8DVelop_ECommerceCart_OtherItems.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)) );
               AV11OtherItemsMainImage = httpContext.cgiGet( edtavOtheritemsmainimage_Internalname) ;
               AV12OtherItemsSecondaryImage = httpContext.cgiGet( edtavOtheritemssecondaryimage_Internalname) ;
            }
         }
         if ( nGXsfl_67_fel_idx == 0 )
         {
            nGXsfl_67_idx = 1 ;
            sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_675( ) ;
         }
         nGXsfl_67_fel_idx = 1 ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e130B2 ();
      if (returnInSub) return;
   }

   public void e130B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = AV7DVelop_ECommerceCart ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      new com.mujermorena.wwpbaseobjects.getproductssampledata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item2) ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] ;
      AV7DVelop_ECommerceCart = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      gx_BV20 = true ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = AV8DVelop_ECommerceCart_OtherItems ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      new com.mujermorena.wwpbaseobjects.getproductssampledata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item2) ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] ;
      AV8DVelop_ECommerceCart_OtherItems = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      gx_BV67 = true ;
      AV8DVelop_ECommerceCart_OtherItems.sort(httpContext.getMessage( "[ProductId]", ""));
      gx_BV67 = true ;
      subBanner_Showarrows = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "BannerContainerDiv", "ShowArrows", subBanner_Showarrows, true);
      subBanner_Autoplay = GXutil.booltostr( true) ;
      httpContext.ajax_rsp_assign_prop("", false, "BannerContainerDiv", "AutoPlay", subBanner_Autoplay, true);
      subBestsellers_Showpagecontroller = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "BestsellersContainerDiv", "ShowPageController", subBestsellers_Showpagecontroller, true);
      subBannersecondary_Showarrows = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "BannersecondaryContainerDiv", "ShowArrows", subBannersecondary_Showarrows, true);
      subBannersecondary_Showpagecontroller = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "BannersecondaryContainerDiv", "ShowPageController", subBannersecondary_Showpagecontroller, true);
      subBannersecondary_Showarrows = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "BannersecondaryContainerDiv", "ShowArrows", subBannersecondary_Showarrows, true);
      subOtheritems_Showpagecontroller = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "OtheritemsContainerDiv", "ShowPageController", subOtheritems_Showpagecontroller, true);
      subOtheritems_Showarrows = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "OtheritemsContainerDiv", "ShowArrows", subOtheritems_Showarrows, true);
      subBanner_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "BannerContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subBanner_Visible), 5, 0), true);
   }

   private void e140B2( )
   {
      /* Banner_Load Routine */
      returnInSub = false ;
      edtavImagebanner_gximage = "WWP_ECommerceSample_BannerSample1" ;
      AV9ImageBanner = context.getHttpContext().getImagePath( "0fa45103-4cfe-4d49-add8-b996730a7d53", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavImagebanner_Internalname, AV9ImageBanner);
      AV25Imagebanner_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "0fa45103-4cfe-4d49-add8-b996730a7d53", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(9) ;
      }
      sendrow_92( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
      {
         httpContext.doAjaxLoad(9, BannerRow);
      }
      edtavImagebanner_gximage = "WWP_ECommerceSample_BannerSample2" ;
      AV9ImageBanner = context.getHttpContext().getImagePath( "e3fa9a51-4cd3-4a28-b3a0-83d6fef291cb", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavImagebanner_Internalname, AV9ImageBanner);
      AV25Imagebanner_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "e3fa9a51-4cd3-4a28-b3a0-83d6fef291cb", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(9) ;
      }
      sendrow_92( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
      {
         httpContext.doAjaxLoad(9, BannerRow);
      }
      edtavImagebanner_gximage = "WWP_ECommerceSample_BannerSample3" ;
      AV9ImageBanner = context.getHttpContext().getImagePath( "c4c8b5b1-5cce-4cf2-acdc-3025392fc541", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavImagebanner_Internalname, AV9ImageBanner);
      AV25Imagebanner_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "c4c8b5b1-5cce-4cf2-acdc-3025392fc541", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(9) ;
      }
      sendrow_92( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
      {
         httpContext.doAjaxLoad(9, BannerRow);
      }
      /*  Sending Event outputs  */
   }

   public void e110B2( )
   {
      AV17GXV1 = nGXsfl_20_idx ;
      if ( ( AV17GXV1 > 0 ) && ( AV7DVelop_ECommerceCart.size() >= AV17GXV1 ) )
      {
         AV7DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)) );
      }
      /* Tablecardbestsellers_Click Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV7DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(),6,0))}, new String[] {"ProductId","ProductDispon"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e120B2( )
   {
      AV21GXV5 = nGXsfl_67_idx ;
      if ( ( AV21GXV5 > 0 ) && ( AV8DVelop_ECommerceCart_OtherItems.size() >= AV21GXV5 ) )
      {
         AV8DVelop_ECommerceCart_OtherItems.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)) );
      }
      /* Tablecardotheritems_Click Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart_OtherItems.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(),6,0))}, new String[] {"ProductId","ProductDispon"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   private void e170B3( )
   {
      /* Bestsellers_Load Routine */
      returnInSub = false ;
      AV17GXV1 = 1 ;
      while ( AV17GXV1 <= AV7DVelop_ECommerceCart.size() )
      {
         AV7DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)) );
         if ( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV7DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size() > 0 )
         {
            AV5BestSellersMainImage = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV7DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavBestsellersmainimage_Internalname, AV5BestSellersMainImage);
            AV6BestSellersSecondaryImage = ((((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV7DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size()>1) ? ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV7DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+2) : AV5BestSellersMainImage) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavBestsellerssecondaryimage_Internalname, AV6BestSellersSecondaryImage);
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(20) ;
         }
         sendrow_203( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_20_Refreshing )
         {
            httpContext.doAjaxLoad(20, BestsellersRow);
         }
         AV17GXV1 = (int)(AV17GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   private void e160B4( )
   {
      /* Bannersecondary_Load Routine */
      returnInSub = false ;
      AV26Imagebanner2_GXI = httpContext.convertURL( context.getHttpContext().getImagePath( "75cad04b-9c80-48d1-b63f-cd085f06c18f", "", context.getHttpContext().getTheme( ))) ;
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('"WWP_ECommerceSample_BannerVerticalSample1"',3) ]
         Target    : [ t('Imagebanner2_GXI',23),t(gximage,3) ]
         ForType   : 29
         Type      : []
      */
      AV10ImageBanner2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavImagebanner2_Internalname, AV10ImageBanner2);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(60) ;
      }
      sendrow_604( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_60_Refreshing )
      {
         httpContext.doAjaxLoad(60, BannersecondaryRow);
      }
      /*  Sending Event outputs  */
   }

   private void e150B5( )
   {
      /* Otheritems_Load Routine */
      returnInSub = false ;
      AV21GXV5 = 1 ;
      while ( AV21GXV5 <= AV8DVelop_ECommerceCart_OtherItems.size() )
      {
         AV8DVelop_ECommerceCart_OtherItems.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)) );
         if ( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart_OtherItems.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size() > 0 )
         {
            AV11OtherItemsMainImage = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart_OtherItems.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavOtheritemsmainimage_Internalname, AV11OtherItemsMainImage);
            AV12OtherItemsSecondaryImage = ((((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart_OtherItems.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size()>1) ? ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart_OtherItems.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+2) : AV11OtherItemsMainImage) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavOtheritemssecondaryimage_Internalname, AV12OtherItemsSecondaryImage);
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(67) ;
         }
         sendrow_675( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_67_Refreshing )
         {
            httpContext.doAjaxLoad(67, OtheritemsRow);
         }
         AV21GXV5 = (int)(AV21GXV5+1) ;
      }
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa0B2( ) ;
      ws0B2( ) ;
      we0B2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111113134", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("home.js", "?202412111113135", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
         httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_92( )
   {
      edtavImagebanner_Internalname = "vIMAGEBANNER_"+sGXsfl_9_idx ;
   }

   public void subsflControlProps_fel_92( )
   {
      edtavImagebanner_Internalname = "vIMAGEBANNER_"+sGXsfl_9_fel_idx ;
   }

   public void sendrow_92( )
   {
      subsflControlProps_92( ) ;
      wb0B0( ) ;
      BannerRow = GXWebRow.GetNew(context,BannerContainer) ;
      if ( subBanner_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subBanner_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subBanner_Class, "") != 0 )
         {
            subBanner_Linesclass = subBanner_Class+"Odd" ;
         }
      }
      else if ( subBanner_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subBanner_Backstyle = (byte)(0) ;
         subBanner_Backcolor = subBanner_Allbackcolor ;
         if ( GXutil.strcmp(subBanner_Class, "") != 0 )
         {
            subBanner_Linesclass = subBanner_Class+"Uniform" ;
         }
      }
      else if ( subBanner_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subBanner_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subBanner_Class, "") != 0 )
         {
            subBanner_Linesclass = subBanner_Class+"Odd" ;
         }
         subBanner_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subBanner_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subBanner_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_9_idx) % (2))) == 0 )
         {
            subBanner_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subBanner_Class, "") != 0 )
            {
               subBanner_Linesclass = subBanner_Class+"Even" ;
            }
         }
         else
         {
            subBanner_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subBanner_Class, "") != 0 )
            {
               subBanner_Linesclass = subBanner_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( BannerContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subBanner_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_9_idx+"\">") ;
      }
      /* Div Control */
      BannerRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsbanner_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      /* Div Control */
      BannerRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      /* Div Control */
      BannerRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      /* Div Control */
      BannerRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      /* Attribute/Variable Label */
      BannerRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image Banner", ""),"col-sm-3 AttributeBannerLabel ObjectFitCoverLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      /* Static Bitmap Variable */
      ClassString = "AttributeBanner ObjectFitCover" + " " + ((GXutil.strcmp(edtavImagebanner_gximage, "")==0) ? "" : "GX_Image_"+edtavImagebanner_gximage+"_Class") ;
      StyleString = "" ;
      AV9ImageBanner_IsBlob = (boolean)(((GXutil.strcmp("", AV9ImageBanner)==0)&&(GXutil.strcmp("", AV25Imagebanner_GXI)==0))||!(GXutil.strcmp("", AV9ImageBanner)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV9ImageBanner)==0) ? AV25Imagebanner_GXI : httpContext.getResourceRelative(AV9ImageBanner)) ;
      BannerRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImagebanner_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(edtavImagebanner_Enabled),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV9ImageBanner_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      BannerRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      BannerRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      BannerRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      BannerRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannerRow.AddRenderProperties(BannerColumn);
      send_integrity_lvl_hashes0B2( ) ;
      /* End of Columns property logic. */
      BannerContainer.AddRow(BannerRow);
      nGXsfl_9_idx = ((subBanner_Islastpage==1)&&(nGXsfl_9_idx+1>subbanner_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      /* End function sendrow_92 */
   }

   public void subsflControlProps_203( )
   {
      edtavBestsellersmainimage_Internalname = "vBESTSELLERSMAINIMAGE_"+sGXsfl_20_idx ;
      edtavBestsellerssecondaryimage_Internalname = "vBESTSELLERSSECONDARYIMAGE_"+sGXsfl_20_idx ;
      edtavDvelop_ecommercecart__productname_Internalname = "DVELOP_ECOMMERCECART__PRODUCTNAME_"+sGXsfl_20_idx ;
      edtavDvelop_ecommercecart__productsim_Internalname = "DVELOP_ECOMMERCECART__PRODUCTSIM_"+sGXsfl_20_idx ;
      edtavDvelop_ecommercecart__productprice_Internalname = "DVELOP_ECOMMERCECART__PRODUCTPRICE_"+sGXsfl_20_idx ;
   }

   public void subsflControlProps_fel_203( )
   {
      edtavBestsellersmainimage_Internalname = "vBESTSELLERSMAINIMAGE_"+sGXsfl_20_fel_idx ;
      edtavBestsellerssecondaryimage_Internalname = "vBESTSELLERSSECONDARYIMAGE_"+sGXsfl_20_fel_idx ;
      edtavDvelop_ecommercecart__productname_Internalname = "DVELOP_ECOMMERCECART__PRODUCTNAME_"+sGXsfl_20_fel_idx ;
      edtavDvelop_ecommercecart__productsim_Internalname = "DVELOP_ECOMMERCECART__PRODUCTSIM_"+sGXsfl_20_fel_idx ;
      edtavDvelop_ecommercecart__productprice_Internalname = "DVELOP_ECOMMERCECART__PRODUCTPRICE_"+sGXsfl_20_fel_idx ;
   }

   public void sendrow_203( )
   {
      subsflControlProps_203( ) ;
      wb0B0( ) ;
      BestsellersRow = GXWebRow.GetNew(context,BestsellersContainer) ;
      if ( subBestsellers_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subBestsellers_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subBestsellers_Class, "") != 0 )
         {
            subBestsellers_Linesclass = subBestsellers_Class+"Odd" ;
         }
      }
      else if ( subBestsellers_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subBestsellers_Backstyle = (byte)(0) ;
         subBestsellers_Backcolor = subBestsellers_Allbackcolor ;
         if ( GXutil.strcmp(subBestsellers_Class, "") != 0 )
         {
            subBestsellers_Linesclass = subBestsellers_Class+"Uniform" ;
         }
      }
      else if ( subBestsellers_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subBestsellers_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subBestsellers_Class, "") != 0 )
         {
            subBestsellers_Linesclass = subBestsellers_Class+"Odd" ;
         }
         subBestsellers_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subBestsellers_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subBestsellers_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_20_idx) % (2))) == 0 )
         {
            subBestsellers_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subBestsellers_Class, "") != 0 )
            {
               subBestsellers_Linesclass = subBestsellers_Class+"Even" ;
            }
         }
         else
         {
            subBestsellers_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subBestsellers_Class, "") != 0 )
            {
               subBestsellers_Linesclass = subBestsellers_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subBestsellers_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_20_idx+"\">") ;
      }
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsbestsellers_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 CellMarginTop CellMarginLeft15","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablecardbestsellers_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CardWithImageTableECommerce","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Table start */
      BestsellersRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablemergedbestsellersmainimage_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),"TableMerged","","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","MergeDataCell"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Attribute/Variable Label */
      BestsellersRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Best Sellers Main Image", ""),"gx-form-item CardImageAttributePrimaryECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Static Bitmap Variable */
      ClassString = "CardImageAttributePrimaryECommerce" + " " + ((GXutil.strcmp(edtavBestsellersmainimage_gximage, "")==0) ? "" : "GX_Image_"+edtavBestsellersmainimage_gximage+"_Class") ;
      StyleString = "" ;
      AV5BestSellersMainImage_IsBlob = (boolean)(((GXutil.strcmp("", AV5BestSellersMainImage)==0)&&(GXutil.strcmp("", AV27Bestsellersmainimage_GXI)==0))||!(GXutil.strcmp("", AV5BestSellersMainImage)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV5BestSellersMainImage)==0) ? AV27Bestsellersmainimage_GXI : httpContext.getResourceRelative(AV5BestSellersMainImage)) ;
      BestsellersRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavBestsellersmainimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV5BestSellersMainImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("cell");
      }
      BestsellersRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Attribute/Variable Label */
      BestsellersRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Best Sellers Secondary Image", ""),"gx-form-item CardImageAttributeSecondaryECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Static Bitmap Variable */
      ClassString = "CardImageAttributeSecondaryECommerce" + " " + ((GXutil.strcmp(edtavBestsellerssecondaryimage_gximage, "")==0) ? "" : "GX_Image_"+edtavBestsellerssecondaryimage_gximage+"_Class") ;
      StyleString = "" ;
      AV6BestSellersSecondaryImage_IsBlob = (boolean)(((GXutil.strcmp("", AV6BestSellersSecondaryImage)==0)&&(GXutil.strcmp("", AV28Bestsellerssecondaryimage_GXI)==0))||!(GXutil.strcmp("", AV6BestSellersSecondaryImage)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV6BestSellersSecondaryImage)==0) ? AV28Bestsellerssecondaryimage_GXI : httpContext.getResourceRelative(AV6BestSellersSecondaryImage)) ;
      BestsellersRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavBestsellerssecondaryimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV6BestSellersSecondaryImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("cell");
      }
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("row");
      }
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("table");
      }
      /* End of table */
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableimage_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Attribute/Variable Label */
      BestsellersRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productname_Internalname,httpContext.getMessage( "Product Name", ""),"col-sm-3 CardTitleECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Multiple line edit */
      ClassString = "CardTitleECommerce" ;
      StyleString = "" ;
      ClassString = "CardTitleECommerce" ;
      StyleString = "" ;
      BestsellersRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productname_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productname(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart__productname_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Table start */
      BestsellersRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablesubtitleinfo_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Attribute/Variable Label */
      BestsellersRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productsim_Internalname,httpContext.getMessage( "Product Sim", ""),"gx-form-item CardSubtitleECommercePrefixLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Single line edit */
      ROClassString = "CardSubtitleECommercePrefix" ;
      BestsellersRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productsim_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productsim(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productsim_Jsonclick,Integer.valueOf(0),"CardSubtitleECommercePrefix","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart__productsim_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("cell");
      }
      BestsellersRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Div Control */
      BestsellersRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Attribute/Variable Label */
      BestsellersRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productprice_Internalname,httpContext.getMessage( "Product Price", ""),"gx-form-item CardSubtitleECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      /* Single line edit */
      ROClassString = "CardSubtitleECommerce" ;
      BestsellersRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productprice_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productprice_Enabled!=0) ? localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99") : localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV7DVelop_ECommerceCart.elementAt(-1+AV17GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productprice_Jsonclick,Integer.valueOf(0),"CardSubtitleECommerce","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart__productprice_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(9),"chr",Integer.valueOf(1),"row",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("cell");
      }
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("row");
      }
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         BestsellersContainer.CloseTag("table");
      }
      /* End of table */
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      BestsellersRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BestsellersRow.AddRenderProperties(BestsellersColumn);
      send_integrity_lvl_hashes0B3( ) ;
      /* End of Columns property logic. */
      BestsellersContainer.AddRow(BestsellersRow);
      nGXsfl_20_idx = ((subBestsellers_Islastpage==1)&&(nGXsfl_20_idx+1>subbestsellers_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
      sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_203( ) ;
      /* End function sendrow_203 */
   }

   public void subsflControlProps_604( )
   {
      edtavImagebanner2_Internalname = "vIMAGEBANNER2_"+sGXsfl_60_idx ;
   }

   public void subsflControlProps_fel_604( )
   {
      edtavImagebanner2_Internalname = "vIMAGEBANNER2_"+sGXsfl_60_fel_idx ;
   }

   public void sendrow_604( )
   {
      subsflControlProps_604( ) ;
      wb0B0( ) ;
      BannersecondaryRow = GXWebRow.GetNew(context,BannersecondaryContainer) ;
      if ( subBannersecondary_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subBannersecondary_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subBannersecondary_Class, "") != 0 )
         {
            subBannersecondary_Linesclass = subBannersecondary_Class+"Odd" ;
         }
      }
      else if ( subBannersecondary_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subBannersecondary_Backstyle = (byte)(0) ;
         subBannersecondary_Backcolor = subBannersecondary_Allbackcolor ;
         if ( GXutil.strcmp(subBannersecondary_Class, "") != 0 )
         {
            subBannersecondary_Linesclass = subBannersecondary_Class+"Uniform" ;
         }
      }
      else if ( subBannersecondary_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subBannersecondary_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subBannersecondary_Class, "") != 0 )
         {
            subBannersecondary_Linesclass = subBannersecondary_Class+"Odd" ;
         }
         subBannersecondary_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subBannersecondary_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subBannersecondary_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_60_idx) % (2))) == 0 )
         {
            subBannersecondary_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subBannersecondary_Class, "") != 0 )
            {
               subBannersecondary_Linesclass = subBannersecondary_Class+"Even" ;
            }
         }
         else
         {
            subBannersecondary_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subBannersecondary_Class, "") != 0 )
            {
               subBannersecondary_Linesclass = subBannersecondary_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( BannersecondaryContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subBannersecondary_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_60_idx+"\">") ;
      }
      /* Div Control */
      BannersecondaryRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsbannersecondary_Internalname+"_"+sGXsfl_60_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      /* Div Control */
      BannersecondaryRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      /* Div Control */
      BannersecondaryRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      /* Div Control */
      BannersecondaryRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      /* Attribute/Variable Label */
      BannersecondaryRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image Banner2", ""),"col-sm-3 AttributeBannerLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      /* Static Bitmap Variable */
      ClassString = "AttributeBanner" + " " + ((GXutil.strcmp(edtavImagebanner2_gximage, "")==0) ? "" : "GX_Image_"+edtavImagebanner2_gximage+"_Class") ;
      StyleString = "" ;
      AV10ImageBanner2_IsBlob = (boolean)(((GXutil.strcmp("", AV10ImageBanner2)==0)&&(GXutil.strcmp("", AV26Imagebanner2_GXI)==0))||!(GXutil.strcmp("", AV10ImageBanner2)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV10ImageBanner2)==0) ? AV26Imagebanner2_GXI : httpContext.getResourceRelative(AV10ImageBanner2)) ;
      BannersecondaryRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImagebanner2_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(edtavImagebanner2_Enabled),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV10ImageBanner2_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      BannersecondaryRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      BannersecondaryRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      BannersecondaryRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      BannersecondaryRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      BannersecondaryRow.AddRenderProperties(BannersecondaryColumn);
      send_integrity_lvl_hashes0B4( ) ;
      /* End of Columns property logic. */
      BannersecondaryContainer.AddRow(BannersecondaryRow);
      nGXsfl_60_idx = ((subBannersecondary_Islastpage==1)&&(nGXsfl_60_idx+1>subbannersecondary_fnc_recordsperpage( )) ? 1 : nGXsfl_60_idx+1) ;
      sGXsfl_60_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_60_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_604( ) ;
      /* End function sendrow_604 */
   }

   public void subsflControlProps_675( )
   {
      edtavOtheritemsmainimage_Internalname = "vOTHERITEMSMAINIMAGE_"+sGXsfl_67_idx ;
      edtavOtheritemssecondaryimage_Internalname = "vOTHERITEMSSECONDARYIMAGE_"+sGXsfl_67_idx ;
      edtavDvelop_ecommercecart_otheritems__productname_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTNAME_"+sGXsfl_67_idx ;
      edtavDvelop_ecommercecart_otheritems__productsim_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTSIM_"+sGXsfl_67_idx ;
      edtavDvelop_ecommercecart_otheritems__productprice_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTPRICE_"+sGXsfl_67_idx ;
   }

   public void subsflControlProps_fel_675( )
   {
      edtavOtheritemsmainimage_Internalname = "vOTHERITEMSMAINIMAGE_"+sGXsfl_67_fel_idx ;
      edtavOtheritemssecondaryimage_Internalname = "vOTHERITEMSSECONDARYIMAGE_"+sGXsfl_67_fel_idx ;
      edtavDvelop_ecommercecart_otheritems__productname_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTNAME_"+sGXsfl_67_fel_idx ;
      edtavDvelop_ecommercecart_otheritems__productsim_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTSIM_"+sGXsfl_67_fel_idx ;
      edtavDvelop_ecommercecart_otheritems__productprice_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTPRICE_"+sGXsfl_67_fel_idx ;
   }

   public void sendrow_675( )
   {
      subsflControlProps_675( ) ;
      wb0B0( ) ;
      OtheritemsRow = GXWebRow.GetNew(context,OtheritemsContainer) ;
      if ( subOtheritems_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subOtheritems_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subOtheritems_Class, "") != 0 )
         {
            subOtheritems_Linesclass = subOtheritems_Class+"Odd" ;
         }
      }
      else if ( subOtheritems_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subOtheritems_Backstyle = (byte)(0) ;
         subOtheritems_Backcolor = subOtheritems_Allbackcolor ;
         if ( GXutil.strcmp(subOtheritems_Class, "") != 0 )
         {
            subOtheritems_Linesclass = subOtheritems_Class+"Uniform" ;
         }
      }
      else if ( subOtheritems_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subOtheritems_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subOtheritems_Class, "") != 0 )
         {
            subOtheritems_Linesclass = subOtheritems_Class+"Odd" ;
         }
         subOtheritems_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subOtheritems_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subOtheritems_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_67_idx) % (2))) == 0 )
         {
            subOtheritems_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subOtheritems_Class, "") != 0 )
            {
               subOtheritems_Linesclass = subOtheritems_Class+"Even" ;
            }
         }
         else
         {
            subOtheritems_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subOtheritems_Class, "") != 0 )
            {
               subOtheritems_Linesclass = subOtheritems_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subOtheritems_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_67_idx+"\">") ;
      }
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsotheritems_Internalname+"_"+sGXsfl_67_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 CellMarginLeft15 CellMarginBottom10","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablecardotheritems_Internalname+"_"+sGXsfl_67_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CardWithImageTableECommerce","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Table start */
      OtheritemsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablemergedotheritemsmainimage_Internalname+"_"+sGXsfl_67_idx,Integer.valueOf(1),"TableMerged","","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","MergeDataCell"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Attribute/Variable Label */
      OtheritemsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Other Items Main Image", ""),"gx-form-item CardImageAttributePrimaryECommerceLabel CardImageAttributeSmallECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Static Bitmap Variable */
      ClassString = "CardImageAttributePrimaryECommerce CardImageAttributeSmallECommerce" + " " + ((GXutil.strcmp(edtavOtheritemsmainimage_gximage, "")==0) ? "" : "GX_Image_"+edtavOtheritemsmainimage_gximage+"_Class") ;
      StyleString = "" ;
      AV11OtherItemsMainImage_IsBlob = (boolean)(((GXutil.strcmp("", AV11OtherItemsMainImage)==0)&&(GXutil.strcmp("", AV29Otheritemsmainimage_GXI)==0))||!(GXutil.strcmp("", AV11OtherItemsMainImage)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV11OtherItemsMainImage)==0) ? AV29Otheritemsmainimage_GXI : httpContext.getResourceRelative(AV11OtherItemsMainImage)) ;
      OtheritemsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavOtheritemsmainimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV11OtherItemsMainImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("cell");
      }
      OtheritemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Attribute/Variable Label */
      OtheritemsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Other Items Secondary Image", ""),"gx-form-item CardImageAttributeSecondaryECommerceLabel CardImageAttributeSmallECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Static Bitmap Variable */
      ClassString = "CardImageAttributeSecondaryECommerce CardImageAttributeSmallECommerce" + " " + ((GXutil.strcmp(edtavOtheritemssecondaryimage_gximage, "")==0) ? "" : "GX_Image_"+edtavOtheritemssecondaryimage_gximage+"_Class") ;
      StyleString = "" ;
      AV12OtherItemsSecondaryImage_IsBlob = (boolean)(((GXutil.strcmp("", AV12OtherItemsSecondaryImage)==0)&&(GXutil.strcmp("", AV30Otheritemssecondaryimage_GXI)==0))||!(GXutil.strcmp("", AV12OtherItemsSecondaryImage)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV12OtherItemsSecondaryImage)==0) ? AV30Otheritemssecondaryimage_GXI : httpContext.getResourceRelative(AV12OtherItemsSecondaryImage)) ;
      OtheritemsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavOtheritemssecondaryimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV12OtherItemsSecondaryImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("cell");
      }
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("row");
      }
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("table");
      }
      /* End of table */
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableimage2_Internalname+"_"+sGXsfl_67_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Attribute/Variable Label */
      OtheritemsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart_otheritems__productname_Internalname,httpContext.getMessage( "Product Name", ""),"col-sm-3 CardTitleECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Multiple line edit */
      ClassString = "CardTitleECommerce" ;
      StyleString = "" ;
      ClassString = "CardTitleECommerce" ;
      StyleString = "" ;
      OtheritemsRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart_otheritems__productname_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)).getgxTv_SdtDVelop_ECommerceCart_Item_Productname(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart_otheritems__productname_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Table start */
      OtheritemsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablesubtitleinfo2_Internalname+"_"+sGXsfl_67_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Attribute/Variable Label */
      OtheritemsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart_otheritems__productsim_Internalname,httpContext.getMessage( "Product Sim", ""),"gx-form-item CardSubtitleECommercePrefixLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Single line edit */
      ROClassString = "CardSubtitleECommercePrefix" ;
      OtheritemsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart_otheritems__productsim_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)).getgxTv_SdtDVelop_ECommerceCart_Item_Productsim(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart_otheritems__productsim_Jsonclick,Integer.valueOf(0),"CardSubtitleECommercePrefix","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart_otheritems__productsim_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("cell");
      }
      OtheritemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Div Control */
      OtheritemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Attribute/Variable Label */
      OtheritemsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart_otheritems__productprice_Internalname,httpContext.getMessage( "Product Price", ""),"gx-form-item CardSubtitleECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      /* Single line edit */
      ROClassString = "CardSubtitleECommerce" ;
      OtheritemsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart_otheritems__productprice_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart_otheritems__productprice_Enabled!=0) ? localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99") : localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart_OtherItems.elementAt(-1+AV21GXV5)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart_otheritems__productprice_Jsonclick,Integer.valueOf(0),"CardSubtitleECommerce","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart_otheritems__productprice_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(9),"chr",Integer.valueOf(1),"row",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("cell");
      }
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("row");
      }
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         OtheritemsContainer.CloseTag("table");
      }
      /* End of table */
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      OtheritemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      OtheritemsRow.AddRenderProperties(OtheritemsColumn);
      send_integrity_lvl_hashes0B5( ) ;
      /* End of Columns property logic. */
      OtheritemsContainer.AddRow(OtheritemsRow);
      nGXsfl_67_idx = ((subOtheritems_Islastpage==1)&&(nGXsfl_67_idx+1>subotheritems_fnc_recordsperpage( )) ? 1 : nGXsfl_67_idx+1) ;
      sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_675( ) ;
      /* End function sendrow_675 */
   }

   public void startgridcontrol9( )
   {
      if ( BannerContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"BannerContainer"+"DivS\" data-gxgridid=\"9\">") ;
         sStyleString = "" ;
         if ( subBanner_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subBanner_Internalname, subBanner_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         BannerContainer.AddObjectProperty("GridName", "Banner");
      }
      else
      {
         BannerContainer.AddObjectProperty("GridName", "Banner");
         BannerContainer.AddObjectProperty("Header", subBanner_Header);
         BannerContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subBanner_Visible, (byte)(5), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         BannerContainer.AddObjectProperty("Class", "FreeStyleGrid");
         BannerContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subBanner_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subBanner_Visible, (byte)(5), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("CmpContext", "");
         BannerContainer.AddObjectProperty("InMasterPage", "false");
         BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannerContainer.AddColumnProperties(BannerColumn);
         BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannerContainer.AddColumnProperties(BannerColumn);
         BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannerContainer.AddColumnProperties(BannerColumn);
         BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannerContainer.AddColumnProperties(BannerColumn);
         BannerColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannerColumn.AddObjectProperty("Value", httpContext.convertURL( AV9ImageBanner));
         BannerColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavImagebanner_Enabled, (byte)(5), (byte)(0), ".", "")));
         BannerContainer.AddColumnProperties(BannerColumn);
         BannerContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subBanner_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subBanner_Allowselection, (byte)(1), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subBanner_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subBanner_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subBanner_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subBanner_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         BannerContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subBanner_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol20( )
   {
      if ( BestsellersContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"BestsellersContainer"+"DivS\" data-gxgridid=\"20\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subBestsellers_Internalname, subBestsellers_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         BestsellersContainer.AddObjectProperty("GridName", "Bestsellers");
      }
      else
      {
         BestsellersContainer.AddObjectProperty("GridName", "Bestsellers");
         BestsellersContainer.AddObjectProperty("Header", subBestsellers_Header);
         BestsellersContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         BestsellersContainer.AddObjectProperty("Class", "FreeStyleGrid");
         BestsellersContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subBestsellers_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("CmpContext", "");
         BestsellersContainer.AddObjectProperty("InMasterPage", "false");
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersColumn.AddObjectProperty("Value", httpContext.convertURL( AV5BestSellersMainImage));
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersColumn.AddObjectProperty("Value", httpContext.convertURL( AV6BestSellersSecondaryImage));
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productname_Enabled, (byte)(5), (byte)(0), ".", "")));
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productsim_Enabled, (byte)(5), (byte)(0), ".", "")));
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BestsellersColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productprice_Enabled, (byte)(5), (byte)(0), ".", "")));
         BestsellersContainer.AddColumnProperties(BestsellersColumn);
         BestsellersContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subBestsellers_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subBestsellers_Allowselection, (byte)(1), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subBestsellers_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subBestsellers_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subBestsellers_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subBestsellers_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         BestsellersContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subBestsellers_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol60( )
   {
      if ( BannersecondaryContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"BannersecondaryContainer"+"DivS\" data-gxgridid=\"60\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subBannersecondary_Internalname, subBannersecondary_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         BannersecondaryContainer.AddObjectProperty("GridName", "Bannersecondary");
      }
      else
      {
         BannersecondaryContainer.AddObjectProperty("GridName", "Bannersecondary");
         BannersecondaryContainer.AddObjectProperty("Header", subBannersecondary_Header);
         BannersecondaryContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         BannersecondaryContainer.AddObjectProperty("Class", "FreeStyleGrid");
         BannersecondaryContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("CmpContext", "");
         BannersecondaryContainer.AddObjectProperty("InMasterPage", "false");
         BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannersecondaryContainer.AddColumnProperties(BannersecondaryColumn);
         BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannersecondaryContainer.AddColumnProperties(BannersecondaryColumn);
         BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannersecondaryContainer.AddColumnProperties(BannersecondaryColumn);
         BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannersecondaryContainer.AddColumnProperties(BannersecondaryColumn);
         BannersecondaryColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         BannersecondaryColumn.AddObjectProperty("Value", httpContext.convertURL( AV10ImageBanner2));
         BannersecondaryColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavImagebanner2_Enabled, (byte)(5), (byte)(0), ".", "")));
         BannersecondaryContainer.AddColumnProperties(BannersecondaryColumn);
         BannersecondaryContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Allowselection, (byte)(1), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         BannersecondaryContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subBannersecondary_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol67( )
   {
      if ( OtheritemsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"OtheritemsContainer"+"DivS\" data-gxgridid=\"67\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subOtheritems_Internalname, subOtheritems_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         OtheritemsContainer.AddObjectProperty("GridName", "Otheritems");
      }
      else
      {
         OtheritemsContainer.AddObjectProperty("GridName", "Otheritems");
         OtheritemsContainer.AddObjectProperty("Header", subOtheritems_Header);
         OtheritemsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         OtheritemsContainer.AddObjectProperty("Class", "FreeStyleGrid");
         OtheritemsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subOtheritems_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("CmpContext", "");
         OtheritemsContainer.AddObjectProperty("InMasterPage", "false");
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsColumn.AddObjectProperty("Value", httpContext.convertURL( AV11OtherItemsMainImage));
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsColumn.AddObjectProperty("Value", httpContext.convertURL( AV12OtherItemsSecondaryImage));
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart_otheritems__productname_Enabled, (byte)(5), (byte)(0), ".", "")));
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart_otheritems__productsim_Enabled, (byte)(5), (byte)(0), ".", "")));
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         OtheritemsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart_otheritems__productprice_Enabled, (byte)(5), (byte)(0), ".", "")));
         OtheritemsContainer.AddColumnProperties(OtheritemsColumn);
         OtheritemsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subOtheritems_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subOtheritems_Allowselection, (byte)(1), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subOtheritems_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subOtheritems_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subOtheritems_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subOtheritems_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         OtheritemsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subOtheritems_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavImagebanner_Internalname = "vIMAGEBANNER" ;
      divUnnamedtablefsbanner_Internalname = "UNNAMEDTABLEFSBANNER" ;
      lblSubtitle_Internalname = "SUBTITLE" ;
      edtavBestsellersmainimage_Internalname = "vBESTSELLERSMAINIMAGE" ;
      edtavBestsellerssecondaryimage_Internalname = "vBESTSELLERSSECONDARYIMAGE" ;
      tblTablemergedbestsellersmainimage_Internalname = "TABLEMERGEDBESTSELLERSMAINIMAGE" ;
      edtavDvelop_ecommercecart__productname_Internalname = "DVELOP_ECOMMERCECART__PRODUCTNAME" ;
      edtavDvelop_ecommercecart__productsim_Internalname = "DVELOP_ECOMMERCECART__PRODUCTSIM" ;
      edtavDvelop_ecommercecart__productprice_Internalname = "DVELOP_ECOMMERCECART__PRODUCTPRICE" ;
      tblTablesubtitleinfo_Internalname = "TABLESUBTITLEINFO" ;
      divTableimage_Internalname = "TABLEIMAGE" ;
      divTablecardbestsellers_Internalname = "TABLECARDBESTSELLERS" ;
      divUnnamedtablefsbestsellers_Internalname = "UNNAMEDTABLEFSBESTSELLERS" ;
      lblOthersubtitle_Internalname = "OTHERSUBTITLE" ;
      edtavImagebanner2_Internalname = "vIMAGEBANNER2" ;
      divUnnamedtablefsbannersecondary_Internalname = "UNNAMEDTABLEFSBANNERSECONDARY" ;
      edtavOtheritemsmainimage_Internalname = "vOTHERITEMSMAINIMAGE" ;
      edtavOtheritemssecondaryimage_Internalname = "vOTHERITEMSSECONDARYIMAGE" ;
      tblTablemergedotheritemsmainimage_Internalname = "TABLEMERGEDOTHERITEMSMAINIMAGE" ;
      edtavDvelop_ecommercecart_otheritems__productname_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTNAME" ;
      edtavDvelop_ecommercecart_otheritems__productsim_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTSIM" ;
      edtavDvelop_ecommercecart_otheritems__productprice_Internalname = "DVELOP_ECOMMERCECART_OTHERITEMS__PRODUCTPRICE" ;
      tblTablesubtitleinfo2_Internalname = "TABLESUBTITLEINFO2" ;
      divTableimage2_Internalname = "TABLEIMAGE2" ;
      divTablecardotheritems_Internalname = "TABLECARDOTHERITEMS" ;
      divUnnamedtablefsotheritems_Internalname = "UNNAMEDTABLEFSOTHERITEMS" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subBanner_Internalname = "BANNER" ;
      subBestsellers_Internalname = "BESTSELLERS" ;
      subBannersecondary_Internalname = "BANNERSECONDARY" ;
      subOtheritems_Internalname = "OTHERITEMS" ;
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
      subOtheritems_Allowcollapsing = (byte)(0) ;
      subBannersecondary_Allowcollapsing = (byte)(0) ;
      subBestsellers_Allowcollapsing = (byte)(0) ;
      subBanner_Allowcollapsing = (byte)(0) ;
      edtavDvelop_ecommercecart_otheritems__productprice_Jsonclick = "" ;
      edtavDvelop_ecommercecart_otheritems__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart_otheritems__productsim_Jsonclick = "" ;
      edtavDvelop_ecommercecart_otheritems__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart_otheritems__productname_Enabled = 0 ;
      edtavOtheritemssecondaryimage_gximage = "" ;
      edtavOtheritemsmainimage_gximage = "" ;
      edtavImagebanner2_gximage = "" ;
      edtavImagebanner2_Enabled = 0 ;
      edtavDvelop_ecommercecart__productprice_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavBestsellerssecondaryimage_gximage = "" ;
      edtavBestsellersmainimage_gximage = "" ;
      edtavImagebanner_gximage = "" ;
      edtavImagebanner_Enabled = 0 ;
      subOtheritems_Backcolorstyle = (byte)(0) ;
      subBannersecondary_Backcolorstyle = (byte)(0) ;
      subBestsellers_Backcolorstyle = (byte)(0) ;
      subBanner_Backcolorstyle = (byte)(0) ;
      edtavDvelop_ecommercecart_otheritems__productprice_Enabled = -1 ;
      edtavDvelop_ecommercecart_otheritems__productsim_Enabled = -1 ;
      edtavDvelop_ecommercecart_otheritems__productname_Enabled = -1 ;
      edtavDvelop_ecommercecart__productprice_Enabled = -1 ;
      edtavDvelop_ecommercecart__productsim_Enabled = -1 ;
      edtavDvelop_ecommercecart__productname_Enabled = -1 ;
      subBanner_Visible = 1 ;
      subOtheritems_Multi_rows_lg = GXutil.ltrimstr( DecimalUtil.doubleToDec(2), 9, 0) ;
      subOtheritems_Multi_rows_md = GXutil.ltrimstr( DecimalUtil.doubleToDec(2), 9, 0) ;
      subOtheritems_Multi_rows_sm = GXutil.ltrimstr( DecimalUtil.doubleToDec(2), 9, 0) ;
      subOtheritems_Multi_rows_xs = GXutil.ltrimstr( DecimalUtil.doubleToDec(2), 9, 0) ;
      subOtheritems_Showarrows = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subOtheritems_Showpagecontroller = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subOtheritems_Class = "FreeStyleGrid" ;
      subBannersecondary_Showarrows = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subBannersecondary_Showpagecontroller = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subBannersecondary_Class = "FreeStyleGrid" ;
      subBestsellers_Showpagecontroller = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subBestsellers_Class = "FreeStyleGrid" ;
      subBanner_Autoplay = GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0) ;
      subBanner_Showarrows = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subBanner_Class = "FreeStyleGrid" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_HomeTitle", "") );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'BANNER_nFirstRecordOnPage'},{av:'BANNER_nEOF'},{av:'BESTSELLERS_nFirstRecordOnPage'},{av:'BESTSELLERS_nEOF'},{av:'BANNERSECONDARY_nFirstRecordOnPage'},{av:'BANNERSECONDARY_nEOF'},{av:'OTHERITEMS_nFirstRecordOnPage'},{av:'OTHERITEMS_nEOF'},{av:'AV8DVelop_ECommerceCart_OtherItems',fld:'vDVELOP_ECOMMERCECART_OTHERITEMS',grid:67,pic:'',hsh:true},{av:'nGXsfl_67_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:67},{av:'nRC_GXsfl_67',ctrl:'OTHERITEMS',prop:'GridRC',grid:67},{av:'AV7DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:20,pic:'',hsh:true},{av:'nGXsfl_20_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:20},{av:'nRC_GXsfl_20',ctrl:'BESTSELLERS',prop:'GridRC',grid:20}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("BANNER.LOAD","{handler:'e140B2',iparms:[]");
      setEventMetadata("BANNER.LOAD",",oparms:[{av:'AV9ImageBanner',fld:'vIMAGEBANNER',pic:''}]}");
      setEventMetadata("BESTSELLERS.LOAD","{handler:'e170B3',iparms:[{av:'AV7DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:20,pic:'',hsh:true},{av:'nGXsfl_20_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:20},{av:'BESTSELLERS_nFirstRecordOnPage'},{av:'nRC_GXsfl_20',ctrl:'BESTSELLERS',prop:'GridRC',grid:20}]");
      setEventMetadata("BESTSELLERS.LOAD",",oparms:[{av:'AV5BestSellersMainImage',fld:'vBESTSELLERSMAINIMAGE',pic:''},{av:'AV6BestSellersSecondaryImage',fld:'vBESTSELLERSSECONDARYIMAGE',pic:''}]}");
      setEventMetadata("BANNERSECONDARY.LOAD","{handler:'e160B4',iparms:[]");
      setEventMetadata("BANNERSECONDARY.LOAD",",oparms:[{av:'AV10ImageBanner2',fld:'vIMAGEBANNER2',pic:''}]}");
      setEventMetadata("OTHERITEMS.LOAD","{handler:'e150B5',iparms:[{av:'AV8DVelop_ECommerceCart_OtherItems',fld:'vDVELOP_ECOMMERCECART_OTHERITEMS',grid:67,pic:'',hsh:true},{av:'nGXsfl_67_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:67},{av:'OTHERITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_67',ctrl:'OTHERITEMS',prop:'GridRC',grid:67}]");
      setEventMetadata("OTHERITEMS.LOAD",",oparms:[{av:'AV11OtherItemsMainImage',fld:'vOTHERITEMSMAINIMAGE',pic:''},{av:'AV12OtherItemsSecondaryImage',fld:'vOTHERITEMSSECONDARYIMAGE',pic:''}]}");
      setEventMetadata("TABLECARDBESTSELLERS.CLICK","{handler:'e110B2',iparms:[{av:'AV7DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:20,pic:'',hsh:true},{av:'nGXsfl_20_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:20},{av:'BESTSELLERS_nFirstRecordOnPage'},{av:'nRC_GXsfl_20',ctrl:'BESTSELLERS',prop:'GridRC',grid:20}]");
      setEventMetadata("TABLECARDBESTSELLERS.CLICK",",oparms:[]}");
      setEventMetadata("TABLECARDOTHERITEMS.CLICK","{handler:'e120B2',iparms:[{av:'AV8DVelop_ECommerceCart_OtherItems',fld:'vDVELOP_ECOMMERCECART_OTHERITEMS',grid:67,pic:'',hsh:true},{av:'nGXsfl_67_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:67},{av:'OTHERITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_67',ctrl:'OTHERITEMS',prop:'GridRC',grid:67}]");
      setEventMetadata("TABLECARDOTHERITEMS.CLICK",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Imagebanner',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Imagebanner2',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv8',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8DVelop_ECommerceCart_OtherItems = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      AV7DVelop_ECommerceCart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      BannerContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblSubtitle_Jsonclick = "" ;
      BestsellersContainer = new com.genexus.webpanels.GXWebGrid(context);
      lblOthersubtitle_Jsonclick = "" ;
      BannersecondaryContainer = new com.genexus.webpanels.GXWebGrid(context);
      OtheritemsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV9ImageBanner = "" ;
      AV25Imagebanner_GXI = "" ;
      AV11OtherItemsMainImage = "" ;
      AV29Otheritemsmainimage_GXI = "" ;
      AV12OtherItemsSecondaryImage = "" ;
      AV30Otheritemssecondaryimage_GXI = "" ;
      AV10ImageBanner2 = "" ;
      AV26Imagebanner2_GXI = "" ;
      AV5BestSellersMainImage = "" ;
      AV27Bestsellersmainimage_GXI = "" ;
      AV6BestSellersSecondaryImage = "" ;
      AV28Bestsellerssecondaryimage_GXI = "" ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtDVelop_ECommerceCart_Item2 = new GXBaseCollection[1] ;
      BannerRow = new com.genexus.webpanels.GXWebRow();
      BestsellersRow = new com.genexus.webpanels.GXWebRow();
      BannersecondaryRow = new com.genexus.webpanels.GXWebRow();
      OtheritemsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subBanner_Linesclass = "" ;
      BannerColumn = new com.genexus.webpanels.GXWebColumn();
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      subBestsellers_Linesclass = "" ;
      BestsellersColumn = new com.genexus.webpanels.GXWebColumn();
      ROClassString = "" ;
      subBannersecondary_Linesclass = "" ;
      BannersecondaryColumn = new com.genexus.webpanels.GXWebColumn();
      subOtheritems_Linesclass = "" ;
      OtheritemsColumn = new com.genexus.webpanels.GXWebColumn();
      subBanner_Header = "" ;
      subBestsellers_Header = "" ;
      subBannersecondary_Header = "" ;
      subOtheritems_Header = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart_otheritems__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart_otheritems__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart_otheritems__productprice_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subBanner_Backcolorstyle ;
   private byte subBestsellers_Backcolorstyle ;
   private byte subBannersecondary_Backcolorstyle ;
   private byte subOtheritems_Backcolorstyle ;
   private byte subBanner_Backstyle ;
   private byte subBestsellers_Backstyle ;
   private byte subBannersecondary_Backstyle ;
   private byte subOtheritems_Backstyle ;
   private byte subBanner_Allowselection ;
   private byte subBanner_Allowhovering ;
   private byte subBanner_Allowcollapsing ;
   private byte subBanner_Collapsed ;
   private byte subBestsellers_Allowselection ;
   private byte subBestsellers_Allowhovering ;
   private byte subBestsellers_Allowcollapsing ;
   private byte subBestsellers_Collapsed ;
   private byte subBannersecondary_Allowselection ;
   private byte subBannersecondary_Allowhovering ;
   private byte subBannersecondary_Allowcollapsing ;
   private byte subBannersecondary_Collapsed ;
   private byte subOtheritems_Allowselection ;
   private byte subOtheritems_Allowhovering ;
   private byte subOtheritems_Allowcollapsing ;
   private byte subOtheritems_Collapsed ;
   private byte BANNER_nEOF ;
   private byte BESTSELLERS_nEOF ;
   private byte BANNERSECONDARY_nEOF ;
   private byte OTHERITEMS_nEOF ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_9 ;
   private int nRC_GXsfl_20 ;
   private int nRC_GXsfl_60 ;
   private int nRC_GXsfl_67 ;
   private int nGXsfl_9_idx=1 ;
   private int nGXsfl_20_idx=1 ;
   private int nGXsfl_60_idx=1 ;
   private int nGXsfl_67_idx=1 ;
   private int subBanner_Visible ;
   private int AV17GXV1 ;
   private int AV21GXV5 ;
   private int subBanner_Islastpage ;
   private int subBestsellers_Islastpage ;
   private int subBannersecondary_Islastpage ;
   private int subOtheritems_Islastpage ;
   private int edtavDvelop_ecommercecart__productname_Enabled ;
   private int edtavDvelop_ecommercecart__productsim_Enabled ;
   private int edtavDvelop_ecommercecart__productprice_Enabled ;
   private int edtavDvelop_ecommercecart_otheritems__productname_Enabled ;
   private int edtavDvelop_ecommercecart_otheritems__productsim_Enabled ;
   private int edtavDvelop_ecommercecart_otheritems__productprice_Enabled ;
   private int nGXsfl_20_fel_idx=1 ;
   private int nGXsfl_67_fel_idx=1 ;
   private int idxLst ;
   private int subBanner_Backcolor ;
   private int subBanner_Allbackcolor ;
   private int edtavImagebanner_Enabled ;
   private int subBestsellers_Backcolor ;
   private int subBestsellers_Allbackcolor ;
   private int subBannersecondary_Backcolor ;
   private int subBannersecondary_Allbackcolor ;
   private int edtavImagebanner2_Enabled ;
   private int subOtheritems_Backcolor ;
   private int subOtheritems_Allbackcolor ;
   private int subBanner_Selectedindex ;
   private int subBanner_Selectioncolor ;
   private int subBanner_Hoveringcolor ;
   private int subBestsellers_Selectedindex ;
   private int subBestsellers_Selectioncolor ;
   private int subBestsellers_Hoveringcolor ;
   private int subBannersecondary_Selectedindex ;
   private int subBannersecondary_Selectioncolor ;
   private int subBannersecondary_Hoveringcolor ;
   private int subOtheritems_Selectedindex ;
   private int subOtheritems_Selectioncolor ;
   private int subOtheritems_Hoveringcolor ;
   private long BANNER_nCurrentRecord ;
   private long BESTSELLERS_nCurrentRecord ;
   private long BANNERSECONDARY_nCurrentRecord ;
   private long OTHERITEMS_nCurrentRecord ;
   private long BANNER_nFirstRecordOnPage ;
   private long BESTSELLERS_nFirstRecordOnPage ;
   private long BANNERSECONDARY_nFirstRecordOnPage ;
   private long OTHERITEMS_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_9_idx="0001" ;
   private String sGXsfl_20_idx="0001" ;
   private String sGXsfl_60_idx="0001" ;
   private String sGXsfl_67_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String subBanner_Class ;
   private String subBanner_Showarrows ;
   private String subBanner_Autoplay ;
   private String subBestsellers_Class ;
   private String subBestsellers_Showpagecontroller ;
   private String subBannersecondary_Class ;
   private String subBannersecondary_Showpagecontroller ;
   private String subBannersecondary_Showarrows ;
   private String subOtheritems_Class ;
   private String subOtheritems_Showpagecontroller ;
   private String subOtheritems_Showarrows ;
   private String subOtheritems_Multi_rows_xs ;
   private String subOtheritems_Multi_rows_sm ;
   private String subOtheritems_Multi_rows_md ;
   private String subOtheritems_Multi_rows_lg ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String subBanner_Internalname ;
   private String lblSubtitle_Internalname ;
   private String lblSubtitle_Jsonclick ;
   private String subBestsellers_Internalname ;
   private String lblOthersubtitle_Internalname ;
   private String lblOthersubtitle_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String subBannersecondary_Internalname ;
   private String subOtheritems_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavImagebanner_Internalname ;
   private String edtavOtheritemsmainimage_Internalname ;
   private String edtavOtheritemssecondaryimage_Internalname ;
   private String edtavImagebanner2_Internalname ;
   private String edtavBestsellersmainimage_Internalname ;
   private String edtavBestsellerssecondaryimage_Internalname ;
   private String edtavDvelop_ecommercecart__productname_Internalname ;
   private String edtavDvelop_ecommercecart__productsim_Internalname ;
   private String edtavDvelop_ecommercecart__productprice_Internalname ;
   private String edtavDvelop_ecommercecart_otheritems__productname_Internalname ;
   private String edtavDvelop_ecommercecart_otheritems__productsim_Internalname ;
   private String edtavDvelop_ecommercecart_otheritems__productprice_Internalname ;
   private String sGXsfl_20_fel_idx="0001" ;
   private String sGXsfl_67_fel_idx="0001" ;
   private String edtavImagebanner_gximage ;
   private String sGXsfl_9_fel_idx="0001" ;
   private String subBanner_Linesclass ;
   private String divUnnamedtablefsbanner_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String subBestsellers_Linesclass ;
   private String divUnnamedtablefsbestsellers_Internalname ;
   private String divTablecardbestsellers_Internalname ;
   private String tblTablemergedbestsellersmainimage_Internalname ;
   private String edtavBestsellersmainimage_gximage ;
   private String edtavBestsellerssecondaryimage_gximage ;
   private String divTableimage_Internalname ;
   private String tblTablesubtitleinfo_Internalname ;
   private String ROClassString ;
   private String edtavDvelop_ecommercecart__productsim_Jsonclick ;
   private String edtavDvelop_ecommercecart__productprice_Jsonclick ;
   private String sGXsfl_60_fel_idx="0001" ;
   private String subBannersecondary_Linesclass ;
   private String divUnnamedtablefsbannersecondary_Internalname ;
   private String edtavImagebanner2_gximage ;
   private String subOtheritems_Linesclass ;
   private String divUnnamedtablefsotheritems_Internalname ;
   private String divTablecardotheritems_Internalname ;
   private String tblTablemergedotheritemsmainimage_Internalname ;
   private String edtavOtheritemsmainimage_gximage ;
   private String edtavOtheritemssecondaryimage_gximage ;
   private String divTableimage2_Internalname ;
   private String tblTablesubtitleinfo2_Internalname ;
   private String edtavDvelop_ecommercecart_otheritems__productsim_Jsonclick ;
   private String edtavDvelop_ecommercecart_otheritems__productprice_Jsonclick ;
   private String subBanner_Header ;
   private String subBestsellers_Header ;
   private String subBannersecondary_Header ;
   private String subOtheritems_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_9_Refreshing=false ;
   private boolean bGXsfl_67_Refreshing=false ;
   private boolean bGXsfl_60_Refreshing=false ;
   private boolean bGXsfl_20_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV20 ;
   private boolean gx_BV67 ;
   private boolean AV9ImageBanner_IsBlob ;
   private boolean AV5BestSellersMainImage_IsBlob ;
   private boolean AV6BestSellersSecondaryImage_IsBlob ;
   private boolean AV10ImageBanner2_IsBlob ;
   private boolean AV11OtherItemsMainImage_IsBlob ;
   private boolean AV12OtherItemsSecondaryImage_IsBlob ;
   private String AV25Imagebanner_GXI ;
   private String AV29Otheritemsmainimage_GXI ;
   private String AV30Otheritemssecondaryimage_GXI ;
   private String AV26Imagebanner2_GXI ;
   private String AV27Bestsellersmainimage_GXI ;
   private String AV28Bestsellerssecondaryimage_GXI ;
   private String AV9ImageBanner ;
   private String AV11OtherItemsMainImage ;
   private String AV12OtherItemsSecondaryImage ;
   private String AV10ImageBanner2 ;
   private String AV5BestSellersMainImage ;
   private String AV6BestSellersSecondaryImage ;
   private com.genexus.webpanels.GXWebGrid BannerContainer ;
   private com.genexus.webpanels.GXWebGrid BestsellersContainer ;
   private com.genexus.webpanels.GXWebGrid BannersecondaryContainer ;
   private com.genexus.webpanels.GXWebGrid OtheritemsContainer ;
   private com.genexus.webpanels.GXWebRow BannerRow ;
   private com.genexus.webpanels.GXWebRow BestsellersRow ;
   private com.genexus.webpanels.GXWebRow BannersecondaryRow ;
   private com.genexus.webpanels.GXWebRow OtheritemsRow ;
   private com.genexus.webpanels.GXWebColumn BannerColumn ;
   private com.genexus.webpanels.GXWebColumn BestsellersColumn ;
   private com.genexus.webpanels.GXWebColumn BannersecondaryColumn ;
   private com.genexus.webpanels.GXWebColumn OtheritemsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart_OtherItems ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV7DVelop_ECommerceCart ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXv_objcol_SdtDVelop_ECommerceCart_Item2[] ;
}

