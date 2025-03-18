package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class productdetail_impl extends GXDataArea
{
   public productdetail_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public productdetail_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( productdetail_impl.class ));
   }

   public productdetail_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV14ProductId = (int) GXutil.lval( args[0]);
         AV26ProductDispon = (short) GXutil.lval( args[1]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

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
         gxfirstwebparm = httpContext.GetFirstPar( "ProductId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ProductId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ProductId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Images") == 0 )
         {
            gxnrimages_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Images") == 0 )
         {
            gxgrimages_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Relatedproducts") == 0 )
         {
            gxnrrelatedproducts_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Relatedproducts") == 0 )
         {
            gxgrrelatedproducts_refresh_invoke( ) ;
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
            AV14ProductId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14ProductId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ProductId), 6, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRODUCTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProductId), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV26ProductDispon = (short)(GXutil.lval( httpContext.GetPar( "ProductDispon"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
            }
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

   public void gxnrimages_newrow_invoke( )
   {
      nRC_GXsfl_18 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_18"))) ;
      nGXsfl_18_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_18_idx"))) ;
      sGXsfl_18_idx = httpContext.GetPar( "sGXsfl_18_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrimages_newrow( ) ;
      /* End function gxnrImages_newrow_invoke */
   }

   public void gxgrimages_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV9DVelop_ECommerceCartItem);
      AV39Cartimage_GXI = httpContext.GetPar( "Cartimage_GXI") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV5DVelop_ECommerceCart);
      AV14ProductId = (int)(GXutil.lval( httpContext.GetPar( "ProductId"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrimages_refresh( AV9DVelop_ECommerceCartItem, AV39Cartimage_GXI, AV5DVelop_ECommerceCart, AV14ProductId) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrImages_refresh_invoke */
   }

   public void gxnrrelatedproducts_newrow_invoke( )
   {
      nRC_GXsfl_79 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_79"))) ;
      nGXsfl_79_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_79_idx"))) ;
      sGXsfl_79_idx = httpContext.GetPar( "sGXsfl_79_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrrelatedproducts_newrow( ) ;
      /* End function gxnrRelatedproducts_newrow_invoke */
   }

   public void gxgrrelatedproducts_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV5DVelop_ECommerceCart);
      AV14ProductId = (int)(GXutil.lval( httpContext.GetPar( "ProductId"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrrelatedproducts_refresh( AV5DVelop_ECommerceCart, AV14ProductId) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrRelatedproducts_refresh_invoke */
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
      pa282( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start282( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVImageZoom/DVImageZoomRender.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ProductId,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV26ProductDispon,4,0))}, new String[] {"ProductId","ProductDispon"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART", getSecureSignedToken( "", AV5DVelop_ECommerceCart));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRODUCTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProductId), "ZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Dvelop_ecommercecart", AV5DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Dvelop_ecommercecart", AV5DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Dvelop_ecommercecart", getSecureSignedToken( "", AV5DVelop_ECommerceCart));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_18", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_18, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_79", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_79, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPRODUCTTALLA_DATA", AV22ProductTalla_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPRODUCTTALLA_DATA", AV22ProductTalla_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECART", AV5DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECART", AV5DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART", getSecureSignedToken( "", AV5DVelop_ECommerceCart));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECARTITEM", AV9DVelop_ECommerceCartItem);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECARTITEM", AV9DVelop_ECommerceCartItem);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCARTIMAGE_GXI", AV39Cartimage_GXI);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOID", GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPRODUCTID", GXutil.ltrim( localUtil.ntoc( AV14ProductId, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRODUCTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProductId), "ZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TALLAID", GXutil.ltrim( localUtil.ntoc( A286TallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOTALLASTOCK", GXutil.ltrim( localUtil.ntoc( A290ArticuloTallaStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMAINIMAGE_GXI", AV38Mainimage_GXI);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_PRODUCTTALLA_Cls", GXutil.rtrim( Combo_producttalla_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_PRODUCTTALLA_Selectedvalue_set", GXutil.rtrim( Combo_producttalla_Selectedvalue_set));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_PRODUCTTALLA_Emptyitemtext", GXutil.rtrim( Combo_producttalla_Emptyitemtext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVIMAGEZOOM_Imageinternalname", GXutil.rtrim( Dvimagezoom_Imageinternalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVIMAGEZOOM_Largeimage", GXutil.rtrim( Dvimagezoom_Largeimage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "RELATEDPRODUCTS_Class", GXutil.rtrim( subRelatedproducts_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "RELATEDPRODUCTS_Showpagecontroller", GXutil.rtrim( subRelatedproducts_Showpagecontroller));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_PRODUCTTALLA_Selectedvalue_get", GXutil.rtrim( Combo_producttalla_Selectedvalue_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_PRODUCTTALLA_Selectedvalue_get", GXutil.rtrim( Combo_producttalla_Selectedvalue_get));
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we282( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt282( ) ;
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
      return formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ProductId,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV26ProductDispon,4,0))}, new String[] {"ProductId","ProductDispon"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.ProductDetail" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Product Detail", "") ;
   }

   public void wb280( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5 CellMarginBottom10", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Main Image", ""), "col-sm-3 AttributeECommerceLargeImageLabel", 0, true, "");
         /* Static Bitmap Variable */
         ClassString = "AttributeECommerceLargeImage" + " " + ((GXutil.strcmp(imgavMainimage_gximage, "")==0) ? "" : "GX_Image_"+imgavMainimage_gximage+"_Class") ;
         StyleString = "" ;
         AV12MainImage_IsBlob = (boolean)(((GXutil.strcmp("", AV12MainImage)==0)&&(GXutil.strcmp("", AV38Mainimage_GXI)==0))||!(GXutil.strcmp("", AV12MainImage)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV12MainImage)==0) ? AV38Mainimage_GXI : httpContext.getResourceRelative(AV12MainImage)) ;
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgavMainimage_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV12MainImage_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 CellECommerceImageSmall", "Center", "top", "", "", "div");
         /*  Grid Control  */
         ImagesContainer.SetIsFreestyle(true);
         ImagesContainer.SetWrapped(nGXWrapped);
         startgridcontrol18( ) ;
      }
      if ( wbEnd == 18 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_18 = (int)(nGXsfl_18_idx-1) ;
         if ( ImagesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"ImagesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Images", ImagesContainer, subImages_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ImagesContainerData", ImagesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ImagesContainerData"+"V", ImagesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"ImagesContainerData"+"V"+"\" value='"+ImagesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableinfo_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavProducttitle_Internalname, httpContext.getMessage( "Product Title", ""), "col-sm-3 AttributeECommerceDetailTitleLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'" + sGXsfl_18_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavProducttitle_Internalname, AV17ProductTitle, GXutil.rtrim( localUtil.format( AV17ProductTitle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProducttitle_Jsonclick, 0, "AttributeECommerceDetailTitle", "", "", "", "", 1, edtavProducttitle_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavProductprice_Internalname, httpContext.getMessage( "Product Price", ""), "col-sm-3 AttributeECommerceDetailPriceLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'" + sGXsfl_18_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavProductprice_Internalname, GXutil.ltrim( localUtil.ntoc( AV15ProductPrice, (byte)(22), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavProductprice_Enabled!=0) ? localUtil.format( AV15ProductPrice, "GS. ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV15ProductPrice, "GS. ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProductprice_Jsonclick, 0, "AttributeECommerceDetailPrice", "", "", "", "", 1, edtavProductprice_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "KPIPrice", "right", false, "", "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavProductdescription_Internalname, httpContext.getMessage( "Product Description", ""), "col-sm-3 AttributeECommerceDetailDescriptionLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_18_idx + "',0)\"" ;
         ClassString = "AttributeECommerceDetailDescription" ;
         StyleString = "" ;
         ClassString = "AttributeECommerceDetailDescription" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavProductdescription_Internalname, AV13ProductDescription, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", (short)(0), 1, edtavProductdescription_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellECommerceQty", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedproductqty_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockproductqty_Internalname, httpContext.getMessage( "Cantidad", ""), "", "", lblTextblockproductqty_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table1_45_282( true) ;
      }
      else
      {
         wb_table1_45_282( false) ;
      }
      return  ;
   }

   public void wb_table1_45_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellECommerceQty ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedproducttalla_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_producttalla_Internalname, httpContext.getMessage( "Talla", ""), "", "", lblTextblockcombo_producttalla_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_producttalla.setProperty("Caption", Combo_producttalla_Caption);
         ucCombo_producttalla.setProperty("Cls", Combo_producttalla_Cls);
         ucCombo_producttalla.setProperty("EmptyItemText", Combo_producttalla_Emptyitemtext);
         ucCombo_producttalla.setProperty("DropDownOptionsData", AV22ProductTalla_Data);
         ucCombo_producttalla.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_producttalla_Internalname, "COMBO_PRODUCTTALLAContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellECommerceQty", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProductdispon_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavProductdispon_Internalname, httpContext.getMessage( "Disponible", ""), "col-sm-3 AttributeECommerceDetailDescriptionLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavProductdispon_Internalname, GXutil.ltrim( localUtil.ntoc( AV26ProductDispon, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavProductdispon_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV26ProductDispon), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV26ProductDispon), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProductdispon_Jsonclick, 0, "AttributeECommerceDetailDescription", "", "", "", "", 1, edtavProductdispon_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
         ClassString = "Button ButtonECommerce" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnaddtocart_Internalname, "gx.evt.setGridEvt("+GXutil.str( 18, 2, 0)+","+"null"+");", httpContext.getMessage( "Añadir al Carrito", ""), bttBtnaddtocart_Jsonclick, 5, httpContext.getMessage( "Añadir al Carrito", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOADDTOCART\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellSubtitleSecondaryECommerce", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblSubtitle_Internalname, httpContext.getMessage( "- PRODUCTOS RELACIONADOS -", ""), "", "", lblSubtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SubtitleSecondaryECommerce", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         RelatedproductsContainer.SetIsFreestyle(true);
         RelatedproductsContainer.SetWrapped(nGXWrapped);
         startgridcontrol79( ) ;
      }
      if ( wbEnd == 79 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_79 = (int)(nGXsfl_79_idx-1) ;
         if ( RelatedproductsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV32GXV1 = nGXsfl_79_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"RelatedproductsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Relatedproducts", RelatedproductsContainer, subRelatedproducts_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "RelatedproductsContainerData", RelatedproductsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "RelatedproductsContainerData"+"V", RelatedproductsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"RelatedproductsContainerData"+"V"+"\" value='"+RelatedproductsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvimagezoom.render(context, "dvelop.dvimagezoom", Dvimagezoom_Internalname, "DVIMAGEZOOMContainer");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'" + sGXsfl_18_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavProducttalla_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ProductTalla, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21ProductTalla), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,117);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProducttalla_Jsonclick, 0, "Attribute", "", "", "", "", edtavProducttalla_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\ProductDetail.htm");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'" + sGXsfl_18_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavCartitemjson_Internalname, AV7CartItemJson, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", (short)(0), edtavCartitemjson_Visible, 1, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 18 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( ImagesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"ImagesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Images", ImagesContainer, subImages_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ImagesContainerData", ImagesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ImagesContainerData"+"V", ImagesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"ImagesContainerData"+"V"+"\" value='"+ImagesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 79 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( RelatedproductsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV32GXV1 = nGXsfl_79_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"RelatedproductsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Relatedproducts", RelatedproductsContainer, subRelatedproducts_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "RelatedproductsContainerData", RelatedproductsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "RelatedproductsContainerData"+"V", RelatedproductsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"RelatedproductsContainerData"+"V"+"\" value='"+RelatedproductsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start282( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Product Detail", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup280( ) ;
   }

   public void ws282( )
   {
      start282( ) ;
      evt282( ) ;
   }

   public void evt282( )
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_PRODUCTTALLA.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOADDTOCART'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoAddtoCart' */
                           e12282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPRODUCTTALLA.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "TABLECARD.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14282 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "IMAGES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "VIMAGE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "VIMAGE.CLICK") == 0 ) )
                        {
                           nGXsfl_18_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_182( ) ;
                           AV10Image = httpContext.cgiGet( edtavImage_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImage_Internalname, "Bitmap", ((GXutil.strcmp("", AV10Image)==0) ? AV41Image_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV10Image))), !bGXsfl_18_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV10Image), true);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e15282 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "IMAGES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e16282 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VIMAGE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17282 ();
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
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 20), "RELATEDPRODUCTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "TABLECARD.CLICK") == 0 ) )
                        {
                           nGXsfl_79_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_79_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_79_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_793( ) ;
                           AV32GXV1 = nGXsfl_79_idx ;
                           if ( ( AV5DVelop_ECommerceCart.size() >= AV32GXV1 ) && ( AV32GXV1 > 0 ) )
                           {
                              AV5DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)) );
                              AV18RelatedProductsMainImage = httpContext.cgiGet( edtavRelatedproductsmainimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop("", false, edtavRelatedproductsmainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV18RelatedProductsMainImage)==0) ? AV47Relatedproductsmainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV18RelatedProductsMainImage))), !bGXsfl_79_Refreshing);
                              httpContext.ajax_rsp_assign_prop("", false, edtavRelatedproductsmainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV18RelatedProductsMainImage), true);
                              AV19RelatedProductsSecondaryImage = httpContext.cgiGet( edtavRelatedproductssecondaryimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop("", false, edtavRelatedproductssecondaryimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV19RelatedProductsSecondaryImage)==0) ? AV48Relatedproductssecondaryimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV19RelatedProductsSecondaryImage))), !bGXsfl_79_Refreshing);
                              httpContext.ajax_rsp_assign_prop("", false, edtavRelatedproductssecondaryimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV19RelatedProductsSecondaryImage), true);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "RELATEDPRODUCTS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e18283 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "TABLECARD.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14282 ();
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

   public void we282( )
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

   public void pa282( )
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
            GX_FocusControl = edtavProducttitle_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrimages_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_182( ) ;
      while ( nGXsfl_18_idx <= nRC_GXsfl_18 )
      {
         sendrow_182( ) ;
         nGXsfl_18_idx = ((subImages_Islastpage==1)&&(nGXsfl_18_idx+1>subimages_fnc_recordsperpage( )) ? 1 : nGXsfl_18_idx+1) ;
         sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_182( ) ;
      }
      addString( httpContext.getJSONContainerResponse( ImagesContainer)) ;
      /* End function gxnrImages_newrow */
   }

   public void gxnrrelatedproducts_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_793( ) ;
      while ( nGXsfl_79_idx <= nRC_GXsfl_79 )
      {
         sendrow_793( ) ;
         nGXsfl_79_idx = ((subRelatedproducts_Islastpage==1)&&(nGXsfl_79_idx+1>subrelatedproducts_fnc_recordsperpage( )) ? 1 : nGXsfl_79_idx+1) ;
         sGXsfl_79_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_79_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_793( ) ;
      }
      addString( httpContext.getJSONContainerResponse( RelatedproductsContainer)) ;
      /* End function gxnrRelatedproducts_newrow */
   }

   public void gxgrimages_refresh( com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV9DVelop_ECommerceCartItem ,
                                   String AV39Cartimage_GXI ,
                                   GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV5DVelop_ECommerceCart ,
                                   int AV14ProductId )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      IMAGES_nCurrentRecord = 0 ;
      rf282( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrImages_refresh */
   }

   public void gxgrrelatedproducts_refresh( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV5DVelop_ECommerceCart ,
                                            int AV14ProductId )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      RELATEDPRODUCTS_nCurrentRecord = 0 ;
      rf283( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrRelatedproducts_refresh */
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
      rf282( ) ;
      rf283( ) ;
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
      edtavProducttitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProducttitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttitle_Enabled), 5, 0), true);
      edtavProductprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProductprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProductprice_Enabled), 5, 0), true);
      edtavProductdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProductdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProductdescription_Enabled), 5, 0), true);
      edtavProductdispon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProductdispon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProductdispon_Enabled), 5, 0), true);
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productname_Enabled), 5, 0), !bGXsfl_79_Refreshing);
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productsim_Enabled), 5, 0), !bGXsfl_79_Refreshing);
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productprice_Enabled), 5, 0), !bGXsfl_79_Refreshing);
   }

   public void rf282( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         ImagesContainer.ClearRows();
      }
      wbStart = (short)(18) ;
      nGXsfl_18_idx = 1 ;
      sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_182( ) ;
      bGXsfl_18_Refreshing = true ;
      ImagesContainer.AddObjectProperty("GridName", "Images");
      ImagesContainer.AddObjectProperty("CmpContext", "");
      ImagesContainer.AddObjectProperty("InMasterPage", "false");
      ImagesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      ImagesContainer.AddObjectProperty("Class", "FreeStyleGrid");
      ImagesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      ImagesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      ImagesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subImages_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      ImagesContainer.setPageSize( subimages_fnc_recordsperpage( ) );
      if ( subImages_Islastpage != 0 )
      {
         IMAGES_nFirstRecordOnPage = (long)(subimages_fnc_recordcount( )-subimages_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IMAGES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( IMAGES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("IMAGES_nFirstRecordOnPage", IMAGES_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_182( ) ;
         e16282 ();
         wbEnd = (short)(18) ;
         wb280( ) ;
      }
      bGXsfl_18_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes282( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDVELOP_ECOMMERCECART", AV5DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_ECOMMERCECART", AV5DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDVELOP_ECOMMERCECART", getSecureSignedToken( "", AV5DVelop_ECommerceCart));
   }

   public void rf283( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         RelatedproductsContainer.ClearRows();
      }
      wbStart = (short)(79) ;
      nGXsfl_79_idx = 1 ;
      sGXsfl_79_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_79_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_793( ) ;
      bGXsfl_79_Refreshing = true ;
      RelatedproductsContainer.AddObjectProperty("GridName", "Relatedproducts");
      RelatedproductsContainer.AddObjectProperty("CmpContext", "");
      RelatedproductsContainer.AddObjectProperty("InMasterPage", "false");
      RelatedproductsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      RelatedproductsContainer.AddObjectProperty("Class", "FreeStyleGrid");
      RelatedproductsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      RelatedproductsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      RelatedproductsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      RelatedproductsContainer.setPageSize( subrelatedproducts_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_793( ) ;
         e18283 ();
         wbEnd = (short)(79) ;
         wb280( ) ;
      }
      bGXsfl_79_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes283( )
   {
   }

   public int subimages_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subimages_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subimages_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subimages_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subrelatedproducts_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subrelatedproducts_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subrelatedproducts_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subrelatedproducts_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavProducttitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProducttitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttitle_Enabled), 5, 0), true);
      edtavProductprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProductprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProductprice_Enabled), 5, 0), true);
      edtavProductdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProductdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProductdescription_Enabled), 5, 0), true);
      edtavProductdispon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProductdispon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProductdispon_Enabled), 5, 0), true);
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productname_Enabled), 5, 0), !bGXsfl_79_Refreshing);
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productsim_Enabled), 5, 0), !bGXsfl_79_Refreshing);
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDvelop_ecommercecart__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productprice_Enabled), 5, 0), !bGXsfl_79_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup280( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15282 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Dvelop_ecommercecart"), AV5DVelop_ECommerceCart);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPRODUCTTALLA_DATA"), AV22ProductTalla_Data);
         /* Read saved values. */
         nRC_GXsfl_18 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_18"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_79 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_79"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Combo_producttalla_Cls = httpContext.cgiGet( "COMBO_PRODUCTTALLA_Cls") ;
         Combo_producttalla_Selectedvalue_set = httpContext.cgiGet( "COMBO_PRODUCTTALLA_Selectedvalue_set") ;
         Combo_producttalla_Emptyitemtext = httpContext.cgiGet( "COMBO_PRODUCTTALLA_Emptyitemtext") ;
         Dvimagezoom_Imageinternalname = httpContext.cgiGet( "DVIMAGEZOOM_Imageinternalname") ;
         Dvimagezoom_Largeimage = httpContext.cgiGet( "DVIMAGEZOOM_Largeimage") ;
         subRelatedproducts_Class = httpContext.cgiGet( "RELATEDPRODUCTS_Class") ;
         subRelatedproducts_Showpagecontroller = httpContext.cgiGet( "RELATEDPRODUCTS_Showpagecontroller") ;
         Combo_producttalla_Selectedvalue_get = httpContext.cgiGet( "COMBO_PRODUCTTALLA_Selectedvalue_get") ;
         nRC_GXsfl_79 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_79"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_79_fel_idx = 0 ;
         while ( nGXsfl_79_fel_idx < nRC_GXsfl_79 )
         {
            nGXsfl_79_fel_idx = ((subRelatedproducts_Islastpage==1)&&(nGXsfl_79_fel_idx+1>subrelatedproducts_fnc_recordsperpage( )) ? 1 : nGXsfl_79_fel_idx+1) ;
            sGXsfl_79_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_79_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_793( ) ;
            AV32GXV1 = nGXsfl_79_fel_idx ;
            if ( ( AV5DVelop_ECommerceCart.size() >= AV32GXV1 ) && ( AV32GXV1 > 0 ) )
            {
               AV5DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)) );
               AV18RelatedProductsMainImage = httpContext.cgiGet( edtavRelatedproductsmainimage_Internalname) ;
               AV19RelatedProductsSecondaryImage = httpContext.cgiGet( edtavRelatedproductssecondaryimage_Internalname) ;
            }
         }
         if ( nGXsfl_79_fel_idx == 0 )
         {
            nGXsfl_79_idx = 1 ;
            sGXsfl_79_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_79_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_793( ) ;
         }
         nGXsfl_79_fel_idx = 1 ;
         /* Read variables values. */
         AV12MainImage = httpContext.cgiGet( imgavMainimage_Internalname) ;
         AV17ProductTitle = httpContext.cgiGet( edtavProducttitle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17ProductTitle", AV17ProductTitle);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavProductprice_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavProductprice_Internalname)), DecimalUtil.stringToDec("999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTPRICE");
            GX_FocusControl = edtavProductprice_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV15ProductPrice = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15ProductPrice", GXutil.ltrimstr( AV15ProductPrice, 15, 2));
         }
         else
         {
            AV15ProductPrice = localUtil.ctond( httpContext.cgiGet( edtavProductprice_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15ProductPrice", GXutil.ltrimstr( AV15ProductPrice, 15, 2));
         }
         AV13ProductDescription = httpContext.cgiGet( edtavProductdescription_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ProductDescription", AV13ProductDescription);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavProductqty_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavProductqty_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTQTY");
            GX_FocusControl = edtavProductqty_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16ProductQty = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16ProductQty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProductQty), 4, 0));
         }
         else
         {
            AV16ProductQty = (short)(localUtil.ctol( httpContext.cgiGet( edtavProductqty_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16ProductQty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProductQty), 4, 0));
         }
         AV26ProductDispon = (short)(localUtil.ctol( httpContext.cgiGet( edtavProductdispon_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavProducttalla_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavProducttalla_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTTALLA");
            GX_FocusControl = edtavProducttalla_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV21ProductTalla = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ProductTalla", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ProductTalla), 4, 0));
         }
         else
         {
            AV21ProductTalla = (short)(localUtil.ctol( httpContext.cgiGet( edtavProducttalla_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ProductTalla", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ProductTalla), 4, 0));
         }
         AV7CartItemJson = httpContext.cgiGet( edtavCartitemjson_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CartItemJson", AV7CartItemJson);
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
      e15282 ();
      if (returnInSub) return;
   }

   public void e15282( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = AV5DVelop_ECommerceCart ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      new com.mujermorena.wwpbaseobjects.getproductssampledata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item2) ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] ;
      AV5DVelop_ECommerceCart = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      gx_BV79 = true ;
      AV36GXV5 = 1 ;
      while ( AV36GXV5 <= AV5DVelop_ECommerceCart.size() )
      {
         AV9DVelop_ECommerceCartItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV36GXV5));
         if ( AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() == AV14ProductId )
         {
            AV27Cantidad = AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty() ;
            if (true) break;
         }
         AV36GXV5 = (int)(AV36GXV5+1) ;
      }
      AV7CartItemJson = AV9DVelop_ECommerceCartItem.toJSonString(false, true) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CartItemJson", AV7CartItemJson);
      edtavProducttalla_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProducttalla_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttalla_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPRODUCTTALLA' */
      S112 ();
      if (returnInSub) return;
      edtavCartitemjson_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCartitemjson_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCartitemjson_Visible), 5, 0), true);
      AV37GXV6 = 1 ;
      while ( AV37GXV6 <= AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Images().size() )
      {
         AV6CartImage = AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+AV37GXV6) ;
         AV12MainImage = AV6CartImage ;
         httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV12MainImage)==0) ? AV38Mainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV12MainImage))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV12MainImage), true);
         AV38Mainimage_GXI = AV39Cartimage_GXI ;
         httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV12MainImage)==0) ? AV38Mainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV12MainImage))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV12MainImage), true);
         Dvimagezoom_Imageinternalname = imgavMainimage_Internalname ;
         ucDvimagezoom.sendProperty(context, "", false, Dvimagezoom_Internalname, "ImageInternalName", Dvimagezoom_Imageinternalname);
         Dvimagezoom_Largeimage = AV38Mainimage_GXI ;
         ucDvimagezoom.sendProperty(context, "", false, Dvimagezoom_Internalname, "LargeImage", Dvimagezoom_Largeimage);
         if (true) break;
         AV37GXV6 = (int)(AV37GXV6+1) ;
      }
      AV17ProductTitle = AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productname() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ProductTitle", AV17ProductTitle);
      AV13ProductDescription = AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productdescription() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13ProductDescription", AV13ProductDescription);
      AV15ProductPrice = AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productprice() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15ProductPrice", GXutil.ltrimstr( AV15ProductPrice, 15, 2));
      AV16ProductQty = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ProductQty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProductQty), 4, 0));
      subRelatedproducts_Showpagecontroller = GXutil.booltostr( false) ;
      httpContext.ajax_rsp_assign_prop("", false, "RelatedproductsContainerDiv", "ShowPageController", subRelatedproducts_Showpagecontroller, true);
   }

   private void e16282( )
   {
      /* Images_Load Routine */
      returnInSub = false ;
      AV8CountImages = (short)(0) ;
      AV40GXV7 = 1 ;
      while ( AV40GXV7 <= AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Images().size() )
      {
         AV6CartImage = AV9DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+AV40GXV7) ;
         AV10Image = AV6CartImage ;
         httpContext.ajax_rsp_assign_attri("", false, edtavImage_Internalname, AV10Image);
         AV41Image_GXI = AV39Cartimage_GXI ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(18) ;
         }
         sendrow_182( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_18_Refreshing )
         {
            httpContext.doAjaxLoad(18, ImagesRow);
         }
         AV8CountImages = (short)(AV8CountImages+1) ;
         if ( AV8CountImages == 5 )
         {
            if (true) break;
         }
         AV40GXV7 = (int)(AV40GXV7+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e12282( )
   {
      /* 'DoAddtoCart' Routine */
      returnInSub = false ;
      if ( AV16ProductQty > AV26ProductDispon )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "tu cantidad supera lo disponible", ""));
      }
      else
      {
         if ( AV16ProductQty == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "cantidad CERO", ""));
         }
         else
         {
            AV9DVelop_ECommerceCartItem.fromJSonString(AV7CartItemJson, null);
            AV9DVelop_ECommerceCartItem.setgxTv_SdtDVelop_ECommerceCart_Item_Productqty( AV16ProductQty );
            AV9DVelop_ECommerceCartItem.setgxTv_SdtDVelop_ECommerceCart_Item_Producttalle( AV21ProductTalla );
            GXv_int3[0] = AV28Result ;
            GXv_int4[0] = AV29Saldo ;
            new com.mujermorena.wwpbaseobjects.additemtocart(remoteHandle, context).execute( AV9DVelop_ECommerceCartItem, AV26ProductDispon, GXv_int3, GXv_int4) ;
            productdetail_impl.this.AV28Result = GXv_int3[0] ;
            productdetail_impl.this.AV29Saldo = GXv_int4[0] ;
            if ( AV28Result == 0 )
            {
               this.executeExternalObjectMethod("", false, "GlobalEvents", "CartChanged", new Object[] {}, true);
               callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV26ProductDispon,4,0))}, new String[] {"ProductDispon"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else
            {
               httpContext.GX_msglist.addItem(httpContext.getMessage( "saldo disponible ha seleccionar es de: ", "")+GXutil.str( AV29Saldo, 4, 0)+httpContext.getMessage( " Articulos", ""));
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV9DVelop_ECommerceCartItem", AV9DVelop_ECommerceCartItem);
   }

   public void e11282( )
   {
      /* Combo_producttalla_Onoptionclicked Routine */
      returnInSub = false ;
      AV21ProductTalla = (short)(GXutil.lval( Combo_producttalla_Selectedvalue_get)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ProductTalla", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ProductTalla), 4, 0));
      /* Using cursor H00282 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14ProductId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13ArticuloId = H00282_A13ArticuloId[0] ;
         AV43GXLvl140 = (byte)(0) ;
         /* Using cursor H00283 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV21ProductTalla), Long.valueOf(A13ArticuloId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A286TallaID = H00283_A286TallaID[0] ;
            A290ArticuloTallaStock = H00283_A290ArticuloTallaStock[0] ;
            AV43GXLvl140 = (byte)(1) ;
            AV26ProductDispon = (short)(A290ArticuloTallaStock) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV43GXLvl140 == 0 )
         {
            AV26ProductDispon = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADCOMBOPRODUCTTALLA' Routine */
      returnInSub = false ;
      /* Using cursor H00284 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV14ProductId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A13ArticuloId = H00284_A13ArticuloId[0] ;
         A286TallaID = H00284_A286TallaID[0] ;
         A287TallaNombre = H00284_A287TallaNombre[0] ;
         A287TallaNombre = H00284_A287TallaNombre[0] ;
         AV25Combo_DataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV25Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A286TallaID, 11, 0)) );
         AV25Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A287TallaNombre );
         AV22ProductTalla_Data.add(AV25Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_producttalla_Selectedvalue_set = ((0==AV21ProductTalla) ? "" : GXutil.trim( GXutil.str( AV21ProductTalla, 4, 0))) ;
      ucCombo_producttalla.sendProperty(context, "", false, Combo_producttalla_Internalname, "SelectedValue_set", Combo_producttalla_Selectedvalue_set);
   }

   public void e14282( )
   {
      AV32GXV1 = nGXsfl_79_idx ;
      if ( ( AV32GXV1 > 0 ) && ( AV5DVelop_ECommerceCart.size() >= AV32GXV1 ) )
      {
         AV5DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)) );
      }
      /* Tablecard_Click Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV5DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(),6,0))}, new String[] {"ProductId","ProductDispon"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e17282( )
   {
      /* Image_Click Routine */
      returnInSub = false ;
      AV38Mainimage_GXI = AV10Image ;
      httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV12MainImage)==0) ? AV38Mainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV12MainImage))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV12MainImage), true);
      AV12MainImage = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV12MainImage)==0) ? AV38Mainimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV12MainImage))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavMainimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV12MainImage), true);
      Dvimagezoom_Imageinternalname = imgavMainimage_Internalname ;
      ucDvimagezoom.sendProperty(context, "", false, Dvimagezoom_Internalname, "ImageInternalName", Dvimagezoom_Imageinternalname);
      Dvimagezoom_Largeimage = AV38Mainimage_GXI ;
      ucDvimagezoom.sendProperty(context, "", false, Dvimagezoom_Internalname, "LargeImage", Dvimagezoom_Largeimage);
      /*  Sending Event outputs  */
   }

   public void e13282( )
   {
      /* Producttalla_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Using cursor H00285 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV14ProductId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A13ArticuloId = H00285_A13ArticuloId[0] ;
         AV46GXLvl187 = (byte)(0) ;
         /* Using cursor H00286 */
         pr_default.execute(4, new Object[] {Short.valueOf(AV21ProductTalla), Long.valueOf(A13ArticuloId)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A286TallaID = H00286_A286TallaID[0] ;
            A290ArticuloTallaStock = H00286_A290ArticuloTallaStock[0] ;
            AV46GXLvl187 = (byte)(1) ;
            AV26ProductDispon = (short)(A290ArticuloTallaStock) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
            pr_default.readNext(4);
         }
         pr_default.close(4);
         if ( AV46GXLvl187 == 0 )
         {
            AV26ProductDispon = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      /*  Sending Event outputs  */
   }

   private void e18283( )
   {
      /* Relatedproducts_Load Routine */
      returnInSub = false ;
      AV32GXV1 = 1 ;
      while ( AV32GXV1 <= AV5DVelop_ECommerceCart.size() )
      {
         AV5DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)) );
         if ( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV5DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size() > 0 )
         {
            AV18RelatedProductsMainImage = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV5DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavRelatedproductsmainimage_Internalname, AV18RelatedProductsMainImage);
            AV19RelatedProductsSecondaryImage = ((((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV5DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size()>1) ? ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV5DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+2) : AV18RelatedProductsMainImage) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavRelatedproductssecondaryimage_Internalname, AV19RelatedProductsSecondaryImage);
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(79) ;
         }
         sendrow_793( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_79_Refreshing )
         {
            httpContext.doAjaxLoad(79, RelatedproductsRow);
         }
         AV32GXV1 = (int)(AV32GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_45_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedproductqty_Internalname, tblTablemergedproductqty_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavProductqty_Internalname, httpContext.getMessage( "Product Qty", ""), "gx-form-item AttributeECommerceDetailQtyLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_18_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavProductqty_Internalname, GXutil.ltrim( localUtil.ntoc( AV16ProductQty, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavProductqty_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV16ProductQty), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV16ProductQty), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProductqty_Jsonclick, 0, "AttributeECommerceDetailQty", "", "", "", "", 1, edtavProductqty_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "ECommerceQtyArrowsTable", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblQtyup_Internalname, httpContext.getMessage( "<i class=\"fa fa-angle-up ECommerceQtyArrows\"></i>", ""), "", "", lblQtyup_Jsonclick, "'"+""+"'"+",false,"+"'"+"e19281_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblQtydown_Internalname, httpContext.getMessage( "<i class=\"fa fa-angle-down ECommerceQtyArrows\"></i>", ""), "", "", lblQtydown_Jsonclick, "'"+""+"'"+",false,"+"'"+"e20281_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\ProductDetail.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_45_282e( true) ;
      }
      else
      {
         wb_table1_45_282e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV14ProductId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ProductId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ProductId), 6, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRODUCTID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14ProductId), "ZZZZZ9")));
      AV26ProductDispon = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ProductDispon", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ProductDispon), 4, 0));
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
      pa282( ) ;
      ws282( ) ;
      we282( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111172646", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/productdetail.js", "?202412111172648", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVImageZoom/DVImageZoomRender.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_182( )
   {
      edtavImage_Internalname = "vIMAGE_"+sGXsfl_18_idx ;
   }

   public void subsflControlProps_fel_182( )
   {
      edtavImage_Internalname = "vIMAGE_"+sGXsfl_18_fel_idx ;
   }

   public void sendrow_182( )
   {
      subsflControlProps_182( ) ;
      wb280( ) ;
      ImagesRow = GXWebRow.GetNew(context,ImagesContainer) ;
      if ( subImages_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subImages_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subImages_Class, "") != 0 )
         {
            subImages_Linesclass = subImages_Class+"Odd" ;
         }
      }
      else if ( subImages_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subImages_Backstyle = (byte)(0) ;
         subImages_Backcolor = subImages_Allbackcolor ;
         if ( GXutil.strcmp(subImages_Class, "") != 0 )
         {
            subImages_Linesclass = subImages_Class+"Uniform" ;
         }
      }
      else if ( subImages_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subImages_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subImages_Class, "") != 0 )
         {
            subImages_Linesclass = subImages_Class+"Odd" ;
         }
         subImages_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subImages_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subImages_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_18_idx) % (2))) == 0 )
         {
            subImages_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subImages_Class, "") != 0 )
            {
               subImages_Linesclass = subImages_Class+"Even" ;
            }
         }
         else
         {
            subImages_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subImages_Class, "") != 0 )
            {
               subImages_Linesclass = subImages_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( ImagesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subImages_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_18_idx+"\">") ;
      }
      /* Div Control */
      ImagesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsimages_Internalname+"_"+sGXsfl_18_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      ImagesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      ImagesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 CellMarginBottom10","left","top","","","div"});
      /* Div Control */
      ImagesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      ImagesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image", ""),"col-sm-3 AttributeECommerceSmallImageLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Active Bitmap Variable */
      TempTags = " " + ((edtavImage_Enabled!=0)&&(edtavImage_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 23,'',false,'',18)\"" : " ") ;
      ClassString = "AttributeECommerceSmallImage" + " " + ((GXutil.strcmp(edtavImage_gximage, "")==0) ? "" : "GX_Image_"+edtavImage_gximage+"_Class") ;
      StyleString = "" ;
      AV10Image_IsBlob = (boolean)(((GXutil.strcmp("", AV10Image)==0)&&(GXutil.strcmp("", AV41Image_GXI)==0))||!(GXutil.strcmp("", AV10Image)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV10Image)==0) ? AV41Image_GXI : httpContext.getResourceRelative(AV10Image)) ;
      ImagesRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavImage_Jsonclick,"'"+""+"'"+",false,"+"'"+"EVIMAGE.CLICK."+sGXsfl_18_idx+"'",StyleString,ClassString,"","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV10Image_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      ImagesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      ImagesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      ImagesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      ImagesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes282( ) ;
      /* End of Columns property logic. */
      ImagesContainer.AddRow(ImagesRow);
      nGXsfl_18_idx = ((subImages_Islastpage==1)&&(nGXsfl_18_idx+1>subimages_fnc_recordsperpage( )) ? 1 : nGXsfl_18_idx+1) ;
      sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_182( ) ;
      /* End function sendrow_182 */
   }

   public void subsflControlProps_793( )
   {
      edtavRelatedproductsmainimage_Internalname = "vRELATEDPRODUCTSMAINIMAGE_"+sGXsfl_79_idx ;
      edtavRelatedproductssecondaryimage_Internalname = "vRELATEDPRODUCTSSECONDARYIMAGE_"+sGXsfl_79_idx ;
      edtavDvelop_ecommercecart__productname_Internalname = "DVELOP_ECOMMERCECART__PRODUCTNAME_"+sGXsfl_79_idx ;
      edtavDvelop_ecommercecart__productsim_Internalname = "DVELOP_ECOMMERCECART__PRODUCTSIM_"+sGXsfl_79_idx ;
      edtavDvelop_ecommercecart__productprice_Internalname = "DVELOP_ECOMMERCECART__PRODUCTPRICE_"+sGXsfl_79_idx ;
   }

   public void subsflControlProps_fel_793( )
   {
      edtavRelatedproductsmainimage_Internalname = "vRELATEDPRODUCTSMAINIMAGE_"+sGXsfl_79_fel_idx ;
      edtavRelatedproductssecondaryimage_Internalname = "vRELATEDPRODUCTSSECONDARYIMAGE_"+sGXsfl_79_fel_idx ;
      edtavDvelop_ecommercecart__productname_Internalname = "DVELOP_ECOMMERCECART__PRODUCTNAME_"+sGXsfl_79_fel_idx ;
      edtavDvelop_ecommercecart__productsim_Internalname = "DVELOP_ECOMMERCECART__PRODUCTSIM_"+sGXsfl_79_fel_idx ;
      edtavDvelop_ecommercecart__productprice_Internalname = "DVELOP_ECOMMERCECART__PRODUCTPRICE_"+sGXsfl_79_fel_idx ;
   }

   public void sendrow_793( )
   {
      subsflControlProps_793( ) ;
      wb280( ) ;
      RelatedproductsRow = GXWebRow.GetNew(context,RelatedproductsContainer) ;
      if ( subRelatedproducts_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subRelatedproducts_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subRelatedproducts_Class, "") != 0 )
         {
            subRelatedproducts_Linesclass = subRelatedproducts_Class+"Odd" ;
         }
      }
      else if ( subRelatedproducts_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subRelatedproducts_Backstyle = (byte)(0) ;
         subRelatedproducts_Backcolor = subRelatedproducts_Allbackcolor ;
         if ( GXutil.strcmp(subRelatedproducts_Class, "") != 0 )
         {
            subRelatedproducts_Linesclass = subRelatedproducts_Class+"Uniform" ;
         }
      }
      else if ( subRelatedproducts_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subRelatedproducts_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subRelatedproducts_Class, "") != 0 )
         {
            subRelatedproducts_Linesclass = subRelatedproducts_Class+"Odd" ;
         }
         subRelatedproducts_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subRelatedproducts_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subRelatedproducts_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_79_idx) % (2))) == 0 )
         {
            subRelatedproducts_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subRelatedproducts_Class, "") != 0 )
            {
               subRelatedproducts_Linesclass = subRelatedproducts_Class+"Even" ;
            }
         }
         else
         {
            subRelatedproducts_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subRelatedproducts_Class, "") != 0 )
            {
               subRelatedproducts_Linesclass = subRelatedproducts_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subRelatedproducts_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_79_idx+"\">") ;
      }
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsrelatedproducts_Internalname+"_"+sGXsfl_79_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 CellMarginTop CellMarginLeft15","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablecard_Internalname+"_"+sGXsfl_79_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CardWithImageTableECommerce","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Table start */
      RelatedproductsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablemergedrelatedproductsmainimage_Internalname+"_"+sGXsfl_79_idx,Integer.valueOf(1),"TableMerged","","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","MergeDataCell"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Attribute/Variable Label */
      RelatedproductsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Related Products Main Image", ""),"gx-form-item CardImageAttributePrimaryECommerceLabel CardImageAttributeSmallECommerceLabel ObjectFitCoverLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Static Bitmap Variable */
      ClassString = "CardImageAttributePrimaryECommerce CardImageAttributeSmallECommerce ObjectFitCover" + " " + ((GXutil.strcmp(edtavRelatedproductsmainimage_gximage, "")==0) ? "" : "GX_Image_"+edtavRelatedproductsmainimage_gximage+"_Class") ;
      StyleString = "" ;
      AV18RelatedProductsMainImage_IsBlob = (boolean)(((GXutil.strcmp("", AV18RelatedProductsMainImage)==0)&&(GXutil.strcmp("", AV47Relatedproductsmainimage_GXI)==0))||!(GXutil.strcmp("", AV18RelatedProductsMainImage)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV18RelatedProductsMainImage)==0) ? AV47Relatedproductsmainimage_GXI : httpContext.getResourceRelative(AV18RelatedProductsMainImage)) ;
      RelatedproductsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavRelatedproductsmainimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV18RelatedProductsMainImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("cell");
      }
      RelatedproductsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Attribute/Variable Label */
      RelatedproductsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Related Products Secondary Image", ""),"gx-form-item CardImageAttributeSecondaryECommerceLabel CardImageAttributeSmallECommerceLabel ObjectFitCoverLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Static Bitmap Variable */
      ClassString = "CardImageAttributeSecondaryECommerce CardImageAttributeSmallECommerce ObjectFitCover" + " " + ((GXutil.strcmp(edtavRelatedproductssecondaryimage_gximage, "")==0) ? "" : "GX_Image_"+edtavRelatedproductssecondaryimage_gximage+"_Class") ;
      StyleString = "" ;
      AV19RelatedProductsSecondaryImage_IsBlob = (boolean)(((GXutil.strcmp("", AV19RelatedProductsSecondaryImage)==0)&&(GXutil.strcmp("", AV48Relatedproductssecondaryimage_GXI)==0))||!(GXutil.strcmp("", AV19RelatedProductsSecondaryImage)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV19RelatedProductsSecondaryImage)==0) ? AV48Relatedproductssecondaryimage_GXI : httpContext.getResourceRelative(AV19RelatedProductsSecondaryImage)) ;
      RelatedproductsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavRelatedproductssecondaryimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV19RelatedProductsSecondaryImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("cell");
      }
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("row");
      }
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("table");
      }
      /* End of table */
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableimage_Internalname+"_"+sGXsfl_79_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Attribute/Variable Label */
      RelatedproductsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productname_Internalname,httpContext.getMessage( "Product Name", ""),"col-sm-3 CardTitleECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Multiple line edit */
      ClassString = "CardTitleECommerce" ;
      StyleString = "" ;
      ClassString = "CardTitleECommerce" ;
      StyleString = "" ;
      RelatedproductsRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productname_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productname(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart__productname_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Table start */
      RelatedproductsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablesubtitleinfo_Internalname+"_"+sGXsfl_79_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","CellAlignBottom"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Attribute/Variable Label */
      RelatedproductsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productsim_Internalname,httpContext.getMessage( "Product Sim", ""),"gx-form-item CardSubtitleECommercePrefixLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Single line edit */
      ROClassString = "CardSubtitleECommercePrefix" ;
      RelatedproductsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productsim_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productsim(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productsim_Jsonclick,Integer.valueOf(0),"CardSubtitleECommercePrefix","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart__productsim_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(79),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("cell");
      }
      RelatedproductsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Div Control */
      RelatedproductsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Attribute/Variable Label */
      RelatedproductsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productprice_Internalname,httpContext.getMessage( "Product Price", ""),"gx-form-item CardSubtitleECommerceLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      /* Single line edit */
      ROClassString = "CardSubtitleECommerce" ;
      RelatedproductsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productprice_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productprice_Enabled!=0) ? localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99") : localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV5DVelop_ECommerceCart.elementAt(-1+AV32GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productprice_Jsonclick,Integer.valueOf(0),"CardSubtitleECommerce","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavDvelop_ecommercecart__productprice_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(9),"chr",Integer.valueOf(1),"row",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(79),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("cell");
      }
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("row");
      }
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         RelatedproductsContainer.CloseTag("table");
      }
      /* End of table */
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      RelatedproductsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      RelatedproductsRow.AddRenderProperties(RelatedproductsColumn);
      send_integrity_lvl_hashes283( ) ;
      /* End of Columns property logic. */
      RelatedproductsContainer.AddRow(RelatedproductsRow);
      nGXsfl_79_idx = ((subRelatedproducts_Islastpage==1)&&(nGXsfl_79_idx+1>subrelatedproducts_fnc_recordsperpage( )) ? 1 : nGXsfl_79_idx+1) ;
      sGXsfl_79_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_79_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_793( ) ;
      /* End function sendrow_793 */
   }

   public void startgridcontrol18( )
   {
      if ( ImagesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"ImagesContainer"+"DivS\" data-gxgridid=\"18\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subImages_Internalname, subImages_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         ImagesContainer.AddObjectProperty("GridName", "Images");
      }
      else
      {
         ImagesContainer.AddObjectProperty("GridName", "Images");
         ImagesContainer.AddObjectProperty("Header", subImages_Header);
         ImagesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         ImagesContainer.AddObjectProperty("Class", "FreeStyleGrid");
         ImagesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subImages_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("CmpContext", "");
         ImagesContainer.AddObjectProperty("InMasterPage", "false");
         ImagesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         ImagesContainer.AddColumnProperties(ImagesColumn);
         ImagesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         ImagesContainer.AddColumnProperties(ImagesColumn);
         ImagesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         ImagesContainer.AddColumnProperties(ImagesColumn);
         ImagesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         ImagesContainer.AddColumnProperties(ImagesColumn);
         ImagesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         ImagesColumn.AddObjectProperty("Value", httpContext.convertURL( AV10Image));
         ImagesContainer.AddColumnProperties(ImagesColumn);
         ImagesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subImages_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subImages_Allowselection, (byte)(1), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subImages_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subImages_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subImages_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subImages_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         ImagesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subImages_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol79( )
   {
      if ( RelatedproductsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"RelatedproductsContainer"+"DivS\" data-gxgridid=\"79\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subRelatedproducts_Internalname, subRelatedproducts_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         RelatedproductsContainer.AddObjectProperty("GridName", "Relatedproducts");
      }
      else
      {
         RelatedproductsContainer.AddObjectProperty("GridName", "Relatedproducts");
         RelatedproductsContainer.AddObjectProperty("Header", subRelatedproducts_Header);
         RelatedproductsContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         RelatedproductsContainer.AddObjectProperty("Class", "FreeStyleGrid");
         RelatedproductsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("CmpContext", "");
         RelatedproductsContainer.AddObjectProperty("InMasterPage", "false");
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsColumn.AddObjectProperty("Value", httpContext.convertURL( AV18RelatedProductsMainImage));
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsColumn.AddObjectProperty("Value", httpContext.convertURL( AV19RelatedProductsSecondaryImage));
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productname_Enabled, (byte)(5), (byte)(0), ".", "")));
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productsim_Enabled, (byte)(5), (byte)(0), ".", "")));
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         RelatedproductsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productprice_Enabled, (byte)(5), (byte)(0), ".", "")));
         RelatedproductsContainer.AddColumnProperties(RelatedproductsColumn);
         RelatedproductsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Allowselection, (byte)(1), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         RelatedproductsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subRelatedproducts_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      imgavMainimage_Internalname = "vMAINIMAGE" ;
      edtavImage_Internalname = "vIMAGE" ;
      divUnnamedtablefsimages_Internalname = "UNNAMEDTABLEFSIMAGES" ;
      edtavProducttitle_Internalname = "vPRODUCTTITLE" ;
      edtavProductprice_Internalname = "vPRODUCTPRICE" ;
      edtavProductdescription_Internalname = "vPRODUCTDESCRIPTION" ;
      lblTextblockproductqty_Internalname = "TEXTBLOCKPRODUCTQTY" ;
      edtavProductqty_Internalname = "vPRODUCTQTY" ;
      lblQtyup_Internalname = "QTYUP" ;
      lblQtydown_Internalname = "QTYDOWN" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      tblTablemergedproductqty_Internalname = "TABLEMERGEDPRODUCTQTY" ;
      divTablesplittedproductqty_Internalname = "TABLESPLITTEDPRODUCTQTY" ;
      lblTextblockcombo_producttalla_Internalname = "TEXTBLOCKCOMBO_PRODUCTTALLA" ;
      Combo_producttalla_Internalname = "COMBO_PRODUCTTALLA" ;
      divTablesplittedproducttalla_Internalname = "TABLESPLITTEDPRODUCTTALLA" ;
      edtavProductdispon_Internalname = "vPRODUCTDISPON" ;
      bttBtnaddtocart_Internalname = "BTNADDTOCART" ;
      divTableinfo_Internalname = "TABLEINFO" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      lblSubtitle_Internalname = "SUBTITLE" ;
      edtavRelatedproductsmainimage_Internalname = "vRELATEDPRODUCTSMAINIMAGE" ;
      edtavRelatedproductssecondaryimage_Internalname = "vRELATEDPRODUCTSSECONDARYIMAGE" ;
      tblTablemergedrelatedproductsmainimage_Internalname = "TABLEMERGEDRELATEDPRODUCTSMAINIMAGE" ;
      edtavDvelop_ecommercecart__productname_Internalname = "DVELOP_ECOMMERCECART__PRODUCTNAME" ;
      edtavDvelop_ecommercecart__productsim_Internalname = "DVELOP_ECOMMERCECART__PRODUCTSIM" ;
      edtavDvelop_ecommercecart__productprice_Internalname = "DVELOP_ECOMMERCECART__PRODUCTPRICE" ;
      tblTablesubtitleinfo_Internalname = "TABLESUBTITLEINFO" ;
      divTableimage_Internalname = "TABLEIMAGE" ;
      divTablecard_Internalname = "TABLECARD" ;
      divUnnamedtablefsrelatedproducts_Internalname = "UNNAMEDTABLEFSRELATEDPRODUCTS" ;
      Dvimagezoom_Internalname = "DVIMAGEZOOM" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavProducttalla_Internalname = "vPRODUCTTALLA" ;
      edtavCartitemjson_Internalname = "vCARTITEMJSON" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subImages_Internalname = "IMAGES" ;
      subRelatedproducts_Internalname = "RELATEDPRODUCTS" ;
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
      subRelatedproducts_Allowcollapsing = (byte)(0) ;
      subImages_Allowcollapsing = (byte)(0) ;
      edtavDvelop_ecommercecart__productprice_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavRelatedproductssecondaryimage_gximage = "" ;
      edtavRelatedproductsmainimage_gximage = "" ;
      edtavImage_Jsonclick = "" ;
      edtavImage_gximage = "" ;
      edtavImage_Visible = 1 ;
      edtavImage_Enabled = 1 ;
      subImages_Class = "FreeStyleGrid" ;
      edtavProductqty_Jsonclick = "" ;
      edtavProductqty_Enabled = 1 ;
      subRelatedproducts_Backcolorstyle = (byte)(0) ;
      subImages_Backcolorstyle = (byte)(0) ;
      edtavDvelop_ecommercecart__productprice_Enabled = -1 ;
      edtavDvelop_ecommercecart__productsim_Enabled = -1 ;
      edtavDvelop_ecommercecart__productname_Enabled = -1 ;
      edtavCartitemjson_Visible = 1 ;
      edtavProducttalla_Jsonclick = "" ;
      edtavProducttalla_Visible = 1 ;
      edtavProductdispon_Jsonclick = "" ;
      edtavProductdispon_Enabled = 0 ;
      edtavProductdescription_Enabled = 1 ;
      edtavProductprice_Jsonclick = "" ;
      edtavProductprice_Enabled = 1 ;
      edtavProducttitle_Jsonclick = "" ;
      edtavProducttitle_Enabled = 1 ;
      imgavMainimage_gximage = "" ;
      subRelatedproducts_Showpagecontroller = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subRelatedproducts_Class = "FreeStyleGrid" ;
      Dvimagezoom_Largeimage = "" ;
      Combo_producttalla_Emptyitemtext = "Talla" ;
      Combo_producttalla_Cls = "ExtendedCombo AttributeECommerceDetailDescription" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Product Detail", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'IMAGES_nFirstRecordOnPage'},{av:'IMAGES_nEOF'},{av:'AV9DVelop_ECommerceCartItem',fld:'vDVELOP_ECOMMERCECARTITEM',pic:''},{av:'AV39Cartimage_GXI',fld:'vCARTIMAGE_GXI',pic:''},{av:'RELATEDPRODUCTS_nFirstRecordOnPage'},{av:'RELATEDPRODUCTS_nEOF'},{av:'AV5DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:79,pic:'',hsh:true},{av:'nGXsfl_79_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:79},{av:'nRC_GXsfl_79',ctrl:'RELATEDPRODUCTS',prop:'GridRC',grid:79},{av:'AV14ProductId',fld:'vPRODUCTID',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("RELATEDPRODUCTS.LOAD","{handler:'e18283',iparms:[{av:'AV5DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:79,pic:'',hsh:true},{av:'nGXsfl_79_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:79},{av:'RELATEDPRODUCTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_79',ctrl:'RELATEDPRODUCTS',prop:'GridRC',grid:79}]");
      setEventMetadata("RELATEDPRODUCTS.LOAD",",oparms:[{av:'AV18RelatedProductsMainImage',fld:'vRELATEDPRODUCTSMAINIMAGE',pic:''},{av:'AV19RelatedProductsSecondaryImage',fld:'vRELATEDPRODUCTSSECONDARYIMAGE',pic:''}]}");
      setEventMetadata("IMAGES.LOAD","{handler:'e16282',iparms:[{av:'AV9DVelop_ECommerceCartItem',fld:'vDVELOP_ECOMMERCECARTITEM',pic:''},{av:'AV39Cartimage_GXI',fld:'vCARTIMAGE_GXI',pic:''}]");
      setEventMetadata("IMAGES.LOAD",",oparms:[{av:'AV10Image',fld:'vIMAGE',pic:''}]}");
      setEventMetadata("'DOADDTOCART'","{handler:'e12282',iparms:[{av:'AV16ProductQty',fld:'vPRODUCTQTY',pic:'ZZZ9'},{av:'AV26ProductDispon',fld:'vPRODUCTDISPON',pic:'ZZZ9'},{av:'AV7CartItemJson',fld:'vCARTITEMJSON',pic:''},{av:'AV21ProductTalla',fld:'vPRODUCTTALLA',pic:'ZZZ9'}]");
      setEventMetadata("'DOADDTOCART'",",oparms:[{av:'AV9DVelop_ECommerceCartItem',fld:'vDVELOP_ECOMMERCECARTITEM',pic:''}]}");
      setEventMetadata("'DOQTYUP'","{handler:'e19281',iparms:[{av:'AV16ProductQty',fld:'vPRODUCTQTY',pic:'ZZZ9'}]");
      setEventMetadata("'DOQTYUP'",",oparms:[{av:'AV16ProductQty',fld:'vPRODUCTQTY',pic:'ZZZ9'}]}");
      setEventMetadata("'DOQTYDOWN'","{handler:'e20281',iparms:[{av:'AV16ProductQty',fld:'vPRODUCTQTY',pic:'ZZZ9'}]");
      setEventMetadata("'DOQTYDOWN'",",oparms:[{av:'AV16ProductQty',fld:'vPRODUCTQTY',pic:'ZZZ9'}]}");
      setEventMetadata("COMBO_PRODUCTTALLA.ONOPTIONCLICKED","{handler:'e11282',iparms:[{av:'Combo_producttalla_Selectedvalue_get',ctrl:'COMBO_PRODUCTTALLA',prop:'SelectedValue_get'},{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'AV14ProductId',fld:'vPRODUCTID',pic:'ZZZZZ9',hsh:true},{av:'A286TallaID',fld:'TALLAID',pic:'ZZZZZZZZZZ9'},{av:'A290ArticuloTallaStock',fld:'ARTICULOTALLASTOCK',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("COMBO_PRODUCTTALLA.ONOPTIONCLICKED",",oparms:[{av:'AV21ProductTalla',fld:'vPRODUCTTALLA',pic:'ZZZ9'},{av:'AV26ProductDispon',fld:'vPRODUCTDISPON',pic:'ZZZ9'}]}");
      setEventMetadata("TABLECARD.CLICK","{handler:'e14282',iparms:[{av:'AV5DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:79,pic:'',hsh:true},{av:'nGXsfl_79_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:79},{av:'RELATEDPRODUCTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_79',ctrl:'RELATEDPRODUCTS',prop:'GridRC',grid:79}]");
      setEventMetadata("TABLECARD.CLICK",",oparms:[]}");
      setEventMetadata("VIMAGE.CLICK","{handler:'e17282',iparms:[{av:'AV10Image',fld:'vIMAGE',pic:''},{av:'AV38Mainimage_GXI',fld:'vMAINIMAGE_GXI',pic:''}]");
      setEventMetadata("VIMAGE.CLICK",",oparms:[{av:'AV12MainImage',fld:'vMAINIMAGE',pic:''},{av:'Dvimagezoom_Imageinternalname',ctrl:'DVIMAGEZOOM',prop:'ImageInternalName'},{av:'Dvimagezoom_Largeimage',ctrl:'DVIMAGEZOOM',prop:'LargeImage'}]}");
      setEventMetadata("VPRODUCTTALLA.CONTROLVALUECHANGED","{handler:'e13282',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'AV14ProductId',fld:'vPRODUCTID',pic:'ZZZZZ9',hsh:true},{av:'A286TallaID',fld:'TALLAID',pic:'ZZZZZZZZZZ9'},{av:'AV21ProductTalla',fld:'vPRODUCTTALLA',pic:'ZZZ9'},{av:'A290ArticuloTallaStock',fld:'ARTICULOTALLASTOCK',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VPRODUCTTALLA.CONTROLVALUECHANGED",",oparms:[{av:'AV26ProductDispon',fld:'vPRODUCTDISPON',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PRODUCTTALLA","{handler:'validv_Producttalla',iparms:[]");
      setEventMetadata("VALIDV_PRODUCTTALLA",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Image',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[]");
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
      Combo_producttalla_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV9DVelop_ECommerceCartItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      AV39Cartimage_GXI = "" ;
      AV5DVelop_ECommerceCart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV22ProductTalla_Data = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV38Mainimage_GXI = "" ;
      Combo_producttalla_Selectedvalue_set = "" ;
      Dvimagezoom_Imageinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV12MainImage = "" ;
      sImgUrl = "" ;
      ImagesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      TempTags = "" ;
      AV17ProductTitle = "" ;
      AV15ProductPrice = DecimalUtil.ZERO ;
      AV13ProductDescription = "" ;
      lblTextblockproductqty_Jsonclick = "" ;
      lblTextblockcombo_producttalla_Jsonclick = "" ;
      ucCombo_producttalla = new com.genexus.webpanels.GXUserControl();
      Combo_producttalla_Caption = "" ;
      bttBtnaddtocart_Jsonclick = "" ;
      lblSubtitle_Jsonclick = "" ;
      RelatedproductsContainer = new com.genexus.webpanels.GXWebGrid(context);
      ucDvimagezoom = new com.genexus.webpanels.GXUserControl();
      AV7CartItemJson = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10Image = "" ;
      AV41Image_GXI = "" ;
      AV18RelatedProductsMainImage = "" ;
      AV47Relatedproductsmainimage_GXI = "" ;
      AV19RelatedProductsSecondaryImage = "" ;
      AV48Relatedproductssecondaryimage_GXI = "" ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtDVelop_ECommerceCart_Item2 = new GXBaseCollection[1] ;
      AV6CartImage = "" ;
      ImagesRow = new com.genexus.webpanels.GXWebRow();
      GXv_int3 = new short[1] ;
      GXv_int4 = new short[1] ;
      scmdbuf = "" ;
      H00282_A13ArticuloId = new long[1] ;
      H00283_A285ArticuloTallaID = new long[1] ;
      H00283_A13ArticuloId = new long[1] ;
      H00283_A286TallaID = new long[1] ;
      H00283_A290ArticuloTallaStock = new long[1] ;
      H00284_A285ArticuloTallaID = new long[1] ;
      H00284_A13ArticuloId = new long[1] ;
      H00284_A286TallaID = new long[1] ;
      H00284_A287TallaNombre = new String[] {""} ;
      A287TallaNombre = "" ;
      AV25Combo_DataItem = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      H00285_A13ArticuloId = new long[1] ;
      H00286_A285ArticuloTallaID = new long[1] ;
      H00286_A13ArticuloId = new long[1] ;
      H00286_A286TallaID = new long[1] ;
      H00286_A290ArticuloTallaStock = new long[1] ;
      RelatedproductsRow = new com.genexus.webpanels.GXWebRow();
      lblQtyup_Jsonclick = "" ;
      lblQtydown_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subImages_Linesclass = "" ;
      subRelatedproducts_Linesclass = "" ;
      RelatedproductsColumn = new com.genexus.webpanels.GXWebColumn();
      ROClassString = "" ;
      subImages_Header = "" ;
      ImagesColumn = new com.genexus.webpanels.GXWebColumn();
      subRelatedproducts_Header = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.productdetail__default(),
         new Object[] {
             new Object[] {
            H00282_A13ArticuloId
            }
            , new Object[] {
            H00283_A285ArticuloTallaID, H00283_A13ArticuloId, H00283_A286TallaID, H00283_A290ArticuloTallaStock
            }
            , new Object[] {
            H00284_A285ArticuloTallaID, H00284_A13ArticuloId, H00284_A286TallaID, H00284_A287TallaNombre
            }
            , new Object[] {
            H00285_A13ArticuloId
            }
            , new Object[] {
            H00286_A285ArticuloTallaID, H00286_A13ArticuloId, H00286_A286TallaID, H00286_A290ArticuloTallaStock
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavProducttitle_Enabled = 0 ;
      edtavProductprice_Enabled = 0 ;
      edtavProductdescription_Enabled = 0 ;
      edtavProductdispon_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subImages_Backcolorstyle ;
   private byte subRelatedproducts_Backcolorstyle ;
   private byte AV43GXLvl140 ;
   private byte AV46GXLvl187 ;
   private byte nGXWrapped ;
   private byte subImages_Backstyle ;
   private byte subRelatedproducts_Backstyle ;
   private byte subImages_Allowselection ;
   private byte subImages_Allowhovering ;
   private byte subImages_Allowcollapsing ;
   private byte subImages_Collapsed ;
   private byte subRelatedproducts_Allowselection ;
   private byte subRelatedproducts_Allowhovering ;
   private byte subRelatedproducts_Allowcollapsing ;
   private byte subRelatedproducts_Collapsed ;
   private byte IMAGES_nEOF ;
   private byte RELATEDPRODUCTS_nEOF ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV26ProductDispon ;
   private short wbEnd ;
   private short wbStart ;
   private short AV21ProductTalla ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV16ProductQty ;
   private short AV8CountImages ;
   private short AV28Result ;
   private short GXv_int3[] ;
   private short AV29Saldo ;
   private short GXv_int4[] ;
   private int wcpOAV14ProductId ;
   private int nRC_GXsfl_18 ;
   private int nRC_GXsfl_79 ;
   private int AV14ProductId ;
   private int nGXsfl_18_idx=1 ;
   private int nGXsfl_79_idx=1 ;
   private int edtavProducttitle_Enabled ;
   private int edtavProductprice_Enabled ;
   private int edtavProductdescription_Enabled ;
   private int edtavProductdispon_Enabled ;
   private int AV32GXV1 ;
   private int edtavProducttalla_Visible ;
   private int edtavCartitemjson_Visible ;
   private int subImages_Islastpage ;
   private int subRelatedproducts_Islastpage ;
   private int edtavDvelop_ecommercecart__productname_Enabled ;
   private int edtavDvelop_ecommercecart__productsim_Enabled ;
   private int edtavDvelop_ecommercecart__productprice_Enabled ;
   private int nGXsfl_79_fel_idx=1 ;
   private int AV36GXV5 ;
   private int AV27Cantidad ;
   private int AV37GXV6 ;
   private int AV40GXV7 ;
   private int edtavProductqty_Enabled ;
   private int idxLst ;
   private int subImages_Backcolor ;
   private int subImages_Allbackcolor ;
   private int edtavImage_Enabled ;
   private int edtavImage_Visible ;
   private int subRelatedproducts_Backcolor ;
   private int subRelatedproducts_Allbackcolor ;
   private int subImages_Selectedindex ;
   private int subImages_Selectioncolor ;
   private int subImages_Hoveringcolor ;
   private int subRelatedproducts_Selectedindex ;
   private int subRelatedproducts_Selectioncolor ;
   private int subRelatedproducts_Hoveringcolor ;
   private long A13ArticuloId ;
   private long A286TallaID ;
   private long A290ArticuloTallaStock ;
   private long IMAGES_nCurrentRecord ;
   private long RELATEDPRODUCTS_nCurrentRecord ;
   private long IMAGES_nFirstRecordOnPage ;
   private long RELATEDPRODUCTS_nFirstRecordOnPage ;
   private java.math.BigDecimal AV15ProductPrice ;
   private String Combo_producttalla_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_18_idx="0001" ;
   private String sGXsfl_79_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Combo_producttalla_Cls ;
   private String Combo_producttalla_Selectedvalue_set ;
   private String Combo_producttalla_Emptyitemtext ;
   private String Dvimagezoom_Imageinternalname ;
   private String Dvimagezoom_Largeimage ;
   private String subRelatedproducts_Class ;
   private String subRelatedproducts_Showpagecontroller ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String imgavMainimage_gximage ;
   private String sImgUrl ;
   private String imgavMainimage_Internalname ;
   private String sStyleString ;
   private String subImages_Internalname ;
   private String divTableinfo_Internalname ;
   private String edtavProducttitle_Internalname ;
   private String TempTags ;
   private String edtavProducttitle_Jsonclick ;
   private String edtavProductprice_Internalname ;
   private String edtavProductprice_Jsonclick ;
   private String edtavProductdescription_Internalname ;
   private String divTablesplittedproductqty_Internalname ;
   private String lblTextblockproductqty_Internalname ;
   private String lblTextblockproductqty_Jsonclick ;
   private String divTablesplittedproducttalla_Internalname ;
   private String lblTextblockcombo_producttalla_Internalname ;
   private String lblTextblockcombo_producttalla_Jsonclick ;
   private String Combo_producttalla_Caption ;
   private String Combo_producttalla_Internalname ;
   private String edtavProductdispon_Internalname ;
   private String edtavProductdispon_Jsonclick ;
   private String bttBtnaddtocart_Internalname ;
   private String bttBtnaddtocart_Jsonclick ;
   private String lblSubtitle_Internalname ;
   private String lblSubtitle_Jsonclick ;
   private String subRelatedproducts_Internalname ;
   private String Dvimagezoom_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavProducttalla_Internalname ;
   private String edtavProducttalla_Jsonclick ;
   private String edtavCartitemjson_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavImage_Internalname ;
   private String edtavRelatedproductsmainimage_Internalname ;
   private String edtavRelatedproductssecondaryimage_Internalname ;
   private String edtavDvelop_ecommercecart__productname_Internalname ;
   private String edtavDvelop_ecommercecart__productsim_Internalname ;
   private String edtavDvelop_ecommercecart__productprice_Internalname ;
   private String sGXsfl_79_fel_idx="0001" ;
   private String edtavProductqty_Internalname ;
   private String scmdbuf ;
   private String A287TallaNombre ;
   private String tblTablemergedproductqty_Internalname ;
   private String edtavProductqty_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String lblQtyup_Internalname ;
   private String lblQtyup_Jsonclick ;
   private String lblQtydown_Internalname ;
   private String lblQtydown_Jsonclick ;
   private String sGXsfl_18_fel_idx="0001" ;
   private String subImages_Class ;
   private String subImages_Linesclass ;
   private String divUnnamedtablefsimages_Internalname ;
   private String edtavImage_gximage ;
   private String edtavImage_Jsonclick ;
   private String subRelatedproducts_Linesclass ;
   private String divUnnamedtablefsrelatedproducts_Internalname ;
   private String divTablecard_Internalname ;
   private String tblTablemergedrelatedproductsmainimage_Internalname ;
   private String edtavRelatedproductsmainimage_gximage ;
   private String edtavRelatedproductssecondaryimage_gximage ;
   private String divTableimage_Internalname ;
   private String tblTablesubtitleinfo_Internalname ;
   private String ROClassString ;
   private String edtavDvelop_ecommercecart__productsim_Jsonclick ;
   private String edtavDvelop_ecommercecart__productprice_Jsonclick ;
   private String subImages_Header ;
   private String subRelatedproducts_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean AV12MainImage_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_18_Refreshing=false ;
   private boolean bGXsfl_79_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV79 ;
   private boolean AV10Image_IsBlob ;
   private boolean AV18RelatedProductsMainImage_IsBlob ;
   private boolean AV19RelatedProductsSecondaryImage_IsBlob ;
   private String AV7CartItemJson ;
   private String AV39Cartimage_GXI ;
   private String AV38Mainimage_GXI ;
   private String AV17ProductTitle ;
   private String AV13ProductDescription ;
   private String AV41Image_GXI ;
   private String AV47Relatedproductsmainimage_GXI ;
   private String AV48Relatedproductssecondaryimage_GXI ;
   private String AV12MainImage ;
   private String AV10Image ;
   private String AV18RelatedProductsMainImage ;
   private String AV19RelatedProductsSecondaryImage ;
   private String AV6CartImage ;
   private com.genexus.webpanels.GXWebGrid ImagesContainer ;
   private com.genexus.webpanels.GXWebGrid RelatedproductsContainer ;
   private com.genexus.webpanels.GXWebRow ImagesRow ;
   private com.genexus.webpanels.GXWebRow RelatedproductsRow ;
   private com.genexus.webpanels.GXWebColumn RelatedproductsColumn ;
   private com.genexus.webpanels.GXWebColumn ImagesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucCombo_producttalla ;
   private com.genexus.webpanels.GXUserControl ucDvimagezoom ;
   private IDataStoreProvider pr_default ;
   private long[] H00282_A13ArticuloId ;
   private long[] H00283_A285ArticuloTallaID ;
   private long[] H00283_A13ArticuloId ;
   private long[] H00283_A286TallaID ;
   private long[] H00283_A290ArticuloTallaStock ;
   private long[] H00284_A285ArticuloTallaID ;
   private long[] H00284_A13ArticuloId ;
   private long[] H00284_A286TallaID ;
   private String[] H00284_A287TallaNombre ;
   private long[] H00285_A13ArticuloId ;
   private long[] H00286_A285ArticuloTallaID ;
   private long[] H00286_A13ArticuloId ;
   private long[] H00286_A286TallaID ;
   private long[] H00286_A290ArticuloTallaStock ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV5DVelop_ECommerceCart ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXv_objcol_SdtDVelop_ECommerceCart_Item2[] ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22ProductTalla_Data ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV9DVelop_ECommerceCartItem ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item AV25Combo_DataItem ;
}

final  class productdetail__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00282", "SELECT [ArticuloId] FROM [Articulo] WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00283", "SELECT [ArticuloTallaID], [ArticuloId], [TallaID], [ArticuloTallaStock] FROM [ArticuloTalla] WHERE ([TallaID] = ?) AND ([ArticuloId] = ?) ORDER BY [TallaID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00284", "SELECT T1.[ArticuloTallaID], T1.[ArticuloId], T1.[TallaID], T2.[TallaNombre] FROM ([ArticuloTalla] T1 INNER JOIN [Talla] T2 ON T2.[TallaID] = T1.[TallaID]) WHERE T1.[ArticuloId] = ? ORDER BY T2.[TallaNombre] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00285", "SELECT [ArticuloId] FROM [Articulo] WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00286", "SELECT [ArticuloTallaID], [ArticuloId], [TallaID], [ArticuloTallaStock] FROM [ArticuloTalla] WHERE ([TallaID] = ?) AND ([ArticuloId] = ?) ORDER BY [TallaID] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

