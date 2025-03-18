package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_subscriptionssettings_impl extends GXDataArea
{
   public wwp_subscriptionssettings_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_subscriptionssettings_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_subscriptionssettings_impl.class ));
   }

   public wwp_subscriptionssettings_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavMail = UIFactory.getCheckbox(this);
      chkavSms = UIFactory.getCheckbox(this);
      chkavDesktop = UIFactory.getCheckbox(this);
      chkavSd = UIFactory.getCheckbox(this);
      chkavNotifshowonlysubscribedevents = UIFactory.getCheckbox(this);
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_43 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_43"))) ;
      nGXsfl_43_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_43_idx"))) ;
      sGXsfl_43_idx = httpContext.GetPar( "sGXsfl_43_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV40Pgmname = httpContext.GetPar( "Pgmname") ;
      AV16NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.GetPar( "NotifShowOnlySubscribedEvents")) ;
      AV7FilterFullText = httpContext.GetPar( "FilterFullText") ;
      A150WWPEntityName = httpContext.GetPar( "WWPEntityName") ;
      A33WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
      A156WWPNotificationDefinitionAllow = GXutil.strtobool( httpContext.GetPar( "WWPNotificationDefinitionAllow")) ;
      A32WWPUserExtendedId = httpContext.GetPar( "WWPUserExtendedId") ;
      n32WWPUserExtendedId = false ;
      AV43Udparg2 = httpContext.GetPar( "Udparg2") ;
      A152WWPSubscriptionSubscribed = GXutil.strtobool( httpContext.GetPar( "WWPSubscriptionSubscribed")) ;
      A149WWPSubscriptionRoleId = httpContext.GetPar( "WWPSubscriptionRoleId") ;
      n149WWPSubscriptionRoleId = false ;
      A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
      AV15Mail = GXutil.strtobool( httpContext.GetPar( "Mail")) ;
      AV21Sms = GXutil.strtobool( httpContext.GetPar( "Sms")) ;
      AV5Desktop = GXutil.strtobool( httpContext.GetPar( "Desktop")) ;
      AV18SD = GXutil.strtobool( httpContext.GetPar( "SD")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV40Pgmname, AV16NotifShowOnlySubscribedEvents, AV7FilterFullText, A150WWPEntityName, A33WWPEntityId, A156WWPNotificationDefinitionAllow, A32WWPUserExtendedId, AV43Udparg2, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A35WWPNotificationDefinitionId, AV15Mail, AV21Sms, AV5Desktop, AV18SD) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
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
      pa1Q2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1Q2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUDPARG2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV43Udparg2, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_43", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_43, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV8GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV9GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV35GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV40Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPENTITYNAME", A150WWPEntityName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPENTITYID", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "WWPNOTIFICATIONDEFINITIONALLOW", A156WWPNotificationDefinitionAllow);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUSEREXTENDEDID", GXutil.rtrim( A32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUDPARG2", GXutil.rtrim( AV43Udparg2));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUDPARG2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV43Udparg2, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "WWPSUBSCRIPTIONSUBSCRIBED", A152WWPSubscriptionSubscribed);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPSUBSCRIPTIONROLEID", GXutil.rtrim( A149WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONDEFINITIONID", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      if ( ! ( WebComp_Grid_dwc == null ) )
      {
         WebComp_Grid_dwc.componentjscripts();
      }
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
         we1Q2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1Q2( ) ;
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
      return formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettings" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Manage my Subscriptions", "") ;
   }

   public void wb1Q0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;justify-content:space-between;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavMail.getInternalname(), httpContext.getMessage( "Mail", ""), "gx-form-item AttributeCheckNoBorderCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         ClassString = "AttributeCheckNoBorderCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavMail.getInternalname(), GXutil.booltostr( AV15Mail), "", httpContext.getMessage( "Mail", ""), 1, chkavMail.getEnabled(), "true", httpContext.getMessage( "Email", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,14);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavSms.getInternalname(), httpContext.getMessage( "Sms", ""), "gx-form-item AttributeCheckNoBorderCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         ClassString = "AttributeCheckNoBorderCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSms.getInternalname(), GXutil.booltostr( AV21Sms), "", httpContext.getMessage( "Sms", ""), 1, chkavSms.getEnabled(), "true", httpContext.getMessage( "SMS", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,17);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavDesktop.getInternalname(), httpContext.getMessage( "Desktop", ""), "gx-form-item AttributeCheckNoBorderCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         ClassString = "AttributeCheckNoBorderCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavDesktop.getInternalname(), GXutil.booltostr( AV5Desktop), "", httpContext.getMessage( "Desktop", ""), 1, chkavDesktop.getEnabled(), "true", httpContext.getMessage( "Desktop notifications", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,20);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavSd.getInternalname(), httpContext.getMessage( "SD", ""), "gx-form-item AttributeCheckNoBorderCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         ClassString = "AttributeCheckNoBorderCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSd.getInternalname(), GXutil.booltostr( AV18SD), "", httpContext.getMessage( "SD", ""), 1, chkavSd.getEnabled(), "true", httpContext.getMessage( "Mobile notifications", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,23);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable2.setProperty("Width", Dvpanel_unnamedtable2_Width);
         ucDvpanel_unnamedtable2.setProperty("AutoWidth", Dvpanel_unnamedtable2_Autowidth);
         ucDvpanel_unnamedtable2.setProperty("AutoHeight", Dvpanel_unnamedtable2_Autoheight);
         ucDvpanel_unnamedtable2.setProperty("Cls", Dvpanel_unnamedtable2_Cls);
         ucDvpanel_unnamedtable2.setProperty("Title", Dvpanel_unnamedtable2_Title);
         ucDvpanel_unnamedtable2.setProperty("Collapsible", Dvpanel_unnamedtable2_Collapsible);
         ucDvpanel_unnamedtable2.setProperty("Collapsed", Dvpanel_unnamedtable2_Collapsed);
         ucDvpanel_unnamedtable2.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable2_Showcollapseicon);
         ucDvpanel_unnamedtable2.setProperty("IconPosition", Dvpanel_unnamedtable2_Iconposition);
         ucDvpanel_unnamedtable2.setProperty("AutoScroll", Dvpanel_unnamedtable2_Autoscroll);
         ucDvpanel_unnamedtable2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable2_Internalname, "DVPANEL_UNNAMEDTABLE2Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE2Container"+"UnnamedTable2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;justify-content:space-between;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavNotifshowonlysubscribedevents.getInternalname(), httpContext.getMessage( "Notif Show Only Subscribed Events", ""), "gx-form-item AttributeCheckNoBorderCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         ClassString = "AttributeCheckNoBorderCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavNotifshowonlysubscribedevents.getInternalname(), GXutil.booltostr( AV16NotifShowOnlySubscribedEvents), "", httpContext.getMessage( "Notif Show Only Subscribed Events", ""), 1, chkavNotifshowonlysubscribedevents.getEnabled(), "true", httpContext.getMessage( "Show only my subscribed events", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,34);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, httpContext.getMessage( "Filter Full Text", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_43_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV7FilterFullText, GXutil.rtrim( localUtil.format( AV7FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_SubscriptionsSettings.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridNoTitleCell CellMarginTop HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol43( ) ;
      }
      if ( wbEnd == 43 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_43 = (int)(nGXsfl_43_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV8GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV9GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV35GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divCell_grid_dwc_Internalname, 1, 0, "px", 0, "px", divCell_grid_dwc_Class, "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0052"+"", GXutil.rtrim( WebComp_Grid_dwc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0052"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_43_Refreshing )
            {
               if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldGrid_dwc), GXutil.lower( WebComp_Grid_dwc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpW0052"+"");
                  }
                  WebComp_Grid_dwc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldGrid_dwc), GXutil.lower( WebComp_Grid_dwc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 43 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1Q2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Manage my Subscriptions", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1Q0( ) ;
   }

   public void ws1Q2( )
   {
      start1Q2( ) ;
      evt1Q2( ) ;
   }

   public void evt1Q2( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e111Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VMAIL.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VSMS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VSD.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDESKTOP.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e161Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VNOTIFSHOWONLYSUBSCRIBEDEVENTS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e171Q2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_43_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_432( ) ;
                           AV29WWPEntityName = httpContext.cgiGet( edtavWwpentityname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavWwpentityname_Internalname, AV29WWPEntityName);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpentityid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpentityid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPENTITYID");
                              GX_FocusControl = edtavWwpentityid_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV28WWPEntityId = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavWwpentityid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28WWPEntityId), 10, 0));
                              com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWWPENTITYID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9")));
                           }
                           else
                           {
                              AV28WWPEntityId = localUtil.ctol( httpContext.cgiGet( edtavWwpentityid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavWwpentityid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28WWPEntityId), 10, 0));
                              com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWWPENTITYID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9")));
                           }
                           AV6DetailWebComponent = httpContext.cgiGet( edtavDetailwebcomponent_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDetailwebcomponent_Internalname, AV6DetailWebComponent);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e181Q2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e191Q2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e201Q2 ();
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
                     }
                  }
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 52 )
                     {
                        OldGrid_dwc = httpContext.cgiGet( "W0052") ;
                        if ( ( GXutil.len( OldGrid_dwc) == 0 ) || ( GXutil.strcmp(OldGrid_dwc, WebComp_Grid_dwc_Component) != 0 ) )
                        {
                           WebComp_Grid_dwc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldGrid_dwc + "_impl", remoteHandle, context);
                           WebComp_Grid_dwc_Component = OldGrid_dwc ;
                        }
                        if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
                        {
                           WebComp_Grid_dwc.componentprocess("W0052", "", sEvt);
                        }
                        WebComp_Grid_dwc_Component = OldGrid_dwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1Q2( )
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

   public void pa1Q2( )
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
            GX_FocusControl = chkavMail.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_432( ) ;
      while ( nGXsfl_43_idx <= nRC_GXsfl_43 )
      {
         sendrow_432( ) ;
         nGXsfl_43_idx = ((subGrid_Islastpage==1)&&(nGXsfl_43_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV40Pgmname ,
                                 boolean AV16NotifShowOnlySubscribedEvents ,
                                 String AV7FilterFullText ,
                                 String A150WWPEntityName ,
                                 long A33WWPEntityId ,
                                 boolean A156WWPNotificationDefinitionAllow ,
                                 String A32WWPUserExtendedId ,
                                 String AV43Udparg2 ,
                                 boolean A152WWPSubscriptionSubscribed ,
                                 String A149WWPSubscriptionRoleId ,
                                 long A35WWPNotificationDefinitionId ,
                                 boolean AV15Mail ,
                                 boolean AV21Sms ,
                                 boolean AV5Desktop ,
                                 boolean AV18SD )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e191Q2 ();
      GRID_nCurrentRecord = 0 ;
      rf1Q2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWWPENTITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vWWPENTITYID", GXutil.ltrim( localUtil.ntoc( AV28WWPEntityId, (byte)(10), (byte)(0), ".", "")));
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
      AV15Mail = GXutil.strtobool( GXutil.booltostr( AV15Mail)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Mail", AV15Mail);
      AV21Sms = GXutil.strtobool( GXutil.booltostr( AV21Sms)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Sms", AV21Sms);
      AV5Desktop = GXutil.strtobool( GXutil.booltostr( AV5Desktop)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5Desktop", AV5Desktop);
      AV18SD = GXutil.strtobool( GXutil.booltostr( AV18SD)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18SD", AV18SD);
      AV16NotifShowOnlySubscribedEvents = GXutil.strtobool( GXutil.booltostr( AV16NotifShowOnlySubscribedEvents)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16NotifShowOnlySubscribedEvents", AV16NotifShowOnlySubscribedEvents);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1Q2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV40Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettings" ;
      Gx_err = (short)(0) ;
      edtavWwpentityname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavWwpentityname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpentityname_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavWwpentityid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavWwpentityid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpentityid_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDetailwebcomponent_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDetailwebcomponent_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDetailwebcomponent_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void rf1Q2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(43) ;
      /* Execute user event: Refresh */
      e191Q2 ();
      nGXsfl_43_idx = 1 ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_432( ) ;
      bGXsfl_43_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( subGrid_Islastpage != 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordcount( )-subgrid_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
            {
               WebComp_Grid_dwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_432( ) ;
         e201Q2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_43_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e201Q2 ();
         }
         wbEnd = (short)(43) ;
         wb1Q0( ) ;
      }
      bGXsfl_43_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1Q2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV40Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV40Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUDPARG2", GXutil.rtrim( AV43Udparg2));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUDPARG2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV43Udparg2, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWWPENTITYID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid_fnc_recordcount( )
   {
      return (int)(((subGrid_Recordcount==0) ? GRID_nFirstRecordOnPage+1 : subGrid_Recordcount)) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(((subGrid_Islastpage==1) ? subgrid_fnc_recordcount( )/ (double) (subgrid_fnc_recordsperpage( ))+((((int)((subgrid_fnc_recordcount( )) % (subgrid_fnc_recordsperpage( ))))==0) ? 0 : 1) : GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1)) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40Pgmname, AV16NotifShowOnlySubscribedEvents, AV7FilterFullText, A150WWPEntityName, A33WWPEntityId, A156WWPNotificationDefinitionAllow, A32WWPUserExtendedId, AV43Udparg2, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A35WWPNotificationDefinitionId, AV15Mail, AV21Sms, AV5Desktop, AV18SD) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      if ( GRID_nEOF == 0 )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40Pgmname, AV16NotifShowOnlySubscribedEvents, AV7FilterFullText, A150WWPEntityName, A33WWPEntityId, A156WWPNotificationDefinitionAllow, A32WWPUserExtendedId, AV43Udparg2, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A35WWPNotificationDefinitionId, AV15Mail, AV21Sms, AV5Desktop, AV18SD) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40Pgmname, AV16NotifShowOnlySubscribedEvents, AV7FilterFullText, A150WWPEntityName, A33WWPEntityId, A156WWPNotificationDefinitionAllow, A32WWPUserExtendedId, AV43Udparg2, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A35WWPNotificationDefinitionId, AV15Mail, AV21Sms, AV5Desktop, AV18SD) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40Pgmname, AV16NotifShowOnlySubscribedEvents, AV7FilterFullText, A150WWPEntityName, A33WWPEntityId, A156WWPNotificationDefinitionAllow, A32WWPUserExtendedId, AV43Udparg2, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A35WWPNotificationDefinitionId, AV15Mail, AV21Sms, AV5Desktop, AV18SD) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40Pgmname, AV16NotifShowOnlySubscribedEvents, AV7FilterFullText, A150WWPEntityName, A33WWPEntityId, A156WWPNotificationDefinitionAllow, A32WWPUserExtendedId, AV43Udparg2, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A35WWPNotificationDefinitionId, AV15Mail, AV21Sms, AV5Desktop, AV18SD) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV40Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettings" ;
      Gx_err = (short)(0) ;
      edtavWwpentityname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavWwpentityname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpentityname_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavWwpentityid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavWwpentityid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpentityid_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtavDetailwebcomponent_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDetailwebcomponent_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDetailwebcomponent_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1Q0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e181Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV8GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV9GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV35GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_unnamedtable2_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Width") ;
         Dvpanel_unnamedtable2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autowidth")) ;
         Dvpanel_unnamedtable2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoheight")) ;
         Dvpanel_unnamedtable2_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Cls") ;
         Dvpanel_unnamedtable2_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Title") ;
         Dvpanel_unnamedtable2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsible")) ;
         Dvpanel_unnamedtable2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsed")) ;
         Dvpanel_unnamedtable2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showcollapseicon")) ;
         Dvpanel_unnamedtable2_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Iconposition") ;
         Dvpanel_unnamedtable2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoscroll")) ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         AV15Mail = GXutil.strtobool( httpContext.cgiGet( chkavMail.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Mail", AV15Mail);
         AV21Sms = GXutil.strtobool( httpContext.cgiGet( chkavSms.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Sms", AV21Sms);
         AV5Desktop = GXutil.strtobool( httpContext.cgiGet( chkavDesktop.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5Desktop", AV5Desktop);
         AV18SD = GXutil.strtobool( httpContext.cgiGet( chkavSd.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18SD", AV18SD);
         AV16NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( chkavNotifshowonlysubscribedevents.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16NotifShowOnlySubscribedEvents", AV16NotifShowOnlySubscribedEvents);
         AV7FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7FilterFullText", AV7FilterFullText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e181Q2 ();
      if (returnInSub) return;
   }

   public void e181Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divCell_grid_dwc_Class = "Invisible WCD_"+GXutil.upper( subGrid_Internalname) ;
      httpContext.ajax_rsp_assign_prop("", false, divCell_grid_dwc_Internalname, "Class", divCell_grid_dwc_Class, true);
      subGrid_Rows = 50 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Form.setCaption( httpContext.getMessage( "Manage my Subscriptions", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S112 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      AV39Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /* Using cursor H001Q2 */
      pr_default.execute(0, new Object[] {AV39Udparg1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32WWPUserExtendedId = H001Q2_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = H001Q2_n32WWPUserExtendedId[0] ;
         A142WWPUserExtendedSMSNotif = H001Q2_A142WWPUserExtendedSMSNotif[0] ;
         A141WWPUserExtendedEmaiNotif = H001Q2_A141WWPUserExtendedEmaiNotif[0] ;
         A144WWPUserExtendedDesktopNotif = H001Q2_A144WWPUserExtendedDesktopNotif[0] ;
         A143WWPUserExtendedMobileNotif = H001Q2_A143WWPUserExtendedMobileNotif[0] ;
         AV21Sms = A142WWPUserExtendedSMSNotif ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Sms", AV21Sms);
         AV15Mail = A141WWPUserExtendedEmaiNotif ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Mail", AV15Mail);
         AV5Desktop = A144WWPUserExtendedDesktopNotif ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5Desktop", AV5Desktop);
         AV18SD = A143WWPUserExtendedMobileNotif ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18SD", AV18SD);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
   }

   public void e191Q2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV26WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV26WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      AV8GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8GridCurrentPage), 10, 0));
      GXt_char2 = AV35GridAppliedFilters ;
      GXv_char3[0] = GXt_char2 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV40Pgmname, GXv_char3) ;
      wwp_subscriptionssettings_impl.this.GXt_char2 = GXv_char3[0] ;
      AV35GridAppliedFilters = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35GridAppliedFilters", AV35GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e111Q2( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV17PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV17PageToGo) ;
      }
   }

   public void e121Q2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e201Q2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV10GridRecordCount = (short)(0) ;
      GXt_objcol_char4 = AV34WWPSubscriptionRoleIdCollection ;
      GXv_objcol_char5[0] = GXt_objcol_char4 ;
      new com.mujermorena.wwpbaseobjects.wwp_getloggeduserroles(remoteHandle, context).execute( GXv_objcol_char5) ;
      GXt_objcol_char4 = GXv_objcol_char5[0] ;
      AV34WWPSubscriptionRoleIdCollection = GXt_objcol_char4 ;
      /* Using cursor H001Q3 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         A33WWPEntityId = H001Q3_A33WWPEntityId[0] ;
         A150WWPEntityName = H001Q3_A150WWPEntityName[0] ;
         AV6DetailWebComponent = "<i class=\"fas fa-angle-right ArrowIcon\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDetailwebcomponent_Internalname, AV6DetailWebComponent);
         AV29WWPEntityName = A150WWPEntityName ;
         httpContext.ajax_rsp_assign_attri("", false, edtavWwpentityname_Internalname, AV29WWPEntityName);
         AV28WWPEntityId = A33WWPEntityId ;
         httpContext.ajax_rsp_assign_attri("", false, edtavWwpentityid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28WWPEntityId), 10, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vWWPENTITYID"+"_"+sGXsfl_43_idx, getSecureSignedToken( sGXsfl_43_idx, localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9")));
         AV30EntityHasItemsToShow = false ;
         if ( ( ! AV16NotifShowOnlySubscribedEvents ) && new com.mujermorena.wwpbaseobjects.subscriptions.wwp_hassubscriptionstodisplay(remoteHandle, context).executeUdp( AV29WWPEntityName, (byte)(1)) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV30EntityHasItemsToShow = true ;
         }
         else
         {
            AV43Udparg2 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
            pr_default.dynParam(2, new Object[]{ new Object[]{
                                                 A149WWPSubscriptionRoleId ,
                                                 AV34WWPSubscriptionRoleIdCollection ,
                                                 Long.valueOf(A33WWPEntityId) ,
                                                 Boolean.valueOf(A156WWPNotificationDefinitionAllow) ,
                                                 A32WWPUserExtendedId ,
                                                 AV43Udparg2 ,
                                                 Boolean.valueOf(A152WWPSubscriptionSubscribed) } ,
                                                 new int[]{
                                                 TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN
                                                 }
            });
            /* Using cursor H001Q4 */
            pr_default.execute(2, new Object[] {Long.valueOf(A33WWPEntityId), AV43Udparg2});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A149WWPSubscriptionRoleId = H001Q4_A149WWPSubscriptionRoleId[0] ;
               n149WWPSubscriptionRoleId = H001Q4_n149WWPSubscriptionRoleId[0] ;
               A152WWPSubscriptionSubscribed = H001Q4_A152WWPSubscriptionSubscribed[0] ;
               A32WWPUserExtendedId = H001Q4_A32WWPUserExtendedId[0] ;
               n32WWPUserExtendedId = H001Q4_n32WWPUserExtendedId[0] ;
               A156WWPNotificationDefinitionAllow = H001Q4_A156WWPNotificationDefinitionAllow[0] ;
               A35WWPNotificationDefinitionId = H001Q4_A35WWPNotificationDefinitionId[0] ;
               A156WWPNotificationDefinitionAllow = H001Q4_A156WWPNotificationDefinitionAllow[0] ;
               AV30EntityHasItemsToShow = true ;
               if ( ! (GXutil.strcmp("", A149WWPSubscriptionRoleId)==0) )
               {
                  GXv_int6[0] = 0 ;
                  GXv_boolean7[0] = AV30EntityHasItemsToShow ;
                  new com.mujermorena.wwpbaseobjects.subscriptions.wwp_checkuserisnotunsubscribed(remoteHandle, context).execute( A35WWPNotificationDefinitionId, GXv_int6, GXv_boolean7) ;
                  wwp_subscriptionssettings_impl.this.AV30EntityHasItemsToShow = GXv_boolean7[0] ;
               }
               if ( AV30EntityHasItemsToShow )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               pr_default.readNext(2);
            }
            pr_default.close(2);
         }
         if ( AV30EntityHasItemsToShow )
         {
            AV10GridRecordCount = (short)(AV10GridRecordCount+1) ;
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(43) ;
            }
            if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
            {
               sendrow_432( ) ;
               GRID_nEOF = (byte)(1) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
               if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
               {
                  GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
               }
            }
            if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
            {
               GRID_nEOF = (byte)(0) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
            GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
            if ( isFullAjaxMode( ) && ! bGXsfl_43_Refreshing )
            {
               httpContext.doAjaxLoad(43, GridRow);
            }
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      AV9GridPageCount = (long)(AV10GridRecordCount/ (double) (subGrid_Rows)+((((int)((AV10GridRecordCount) % (subGrid_Rows)))>0) ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9GridPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue(AV40Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV40Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV20Session.getValue(AV40Pgmname+"GridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "NOTIFSHOWONLYSUBSCRIBEDEVENTS") == 0 )
         {
            AV16NotifShowOnlySubscribedEvents = GXutil.boolval( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16NotifShowOnlySubscribedEvents", AV16NotifShowOnlySubscribedEvents);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV7FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7FilterFullText", AV7FilterFullText);
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S122( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV20Session.getValue(AV40Pgmname+"GridState"), null, null);
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState8[0] = AV11GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState8, "NOTIFSHOWONLYSUBSCRIBEDEVENTS", "", !(false==AV16NotifShowOnlySubscribedEvents), (short)(0), GXutil.trim( GXutil.booltostr( AV16NotifShowOnlySubscribedEvents)), "") ;
      AV11GridState = GXv_SdtWWPGridState8[0] ;
      GXv_SdtWWPGridState8[0] = AV11GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState8, "FILTERFULLTEXT", httpContext.getMessage( "WWP_FullTextFilterDescription", ""), !(GXutil.strcmp("", AV7FilterFullText)==0), (short)(0), AV7FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState8[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV40Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e131Q2( )
   {
      /* Mail_Click Routine */
      returnInSub = false ;
      AV33WWPUserExtended.Load(new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ));
      AV33WWPUserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif( AV15Mail );
      AV33WWPUserExtended.Save();
      if ( AV33WWPUserExtended.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscriptionssettings");
      }
   }

   public void e141Q2( )
   {
      /* Sms_Click Routine */
      returnInSub = false ;
      AV33WWPUserExtended.Load(new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ));
      AV33WWPUserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif( AV21Sms );
      AV33WWPUserExtended.Save();
      if ( AV33WWPUserExtended.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscriptionssettings");
      }
   }

   public void e151Q2( )
   {
      /* Sd_Click Routine */
      returnInSub = false ;
      AV33WWPUserExtended.Load(new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ));
      AV33WWPUserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif( AV18SD );
      AV33WWPUserExtended.Save();
      if ( AV33WWPUserExtended.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscriptionssettings");
      }
   }

   public void e161Q2( )
   {
      /* Desktop_Click Routine */
      returnInSub = false ;
      AV33WWPUserExtended.Load(new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ));
      AV33WWPUserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif( AV5Desktop );
      AV33WWPUserExtended.Save();
      if ( AV33WWPUserExtended.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscriptionssettings");
      }
   }

   public void e171Q2( )
   {
      /* Notifshowonlysubscribedevents_Click Routine */
      returnInSub = false ;
      httpContext.doAjaxRefreshCmp("W0052"+"");
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
      pa1Q2( ) ;
      ws1Q2( ) ;
      we1Q2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Grid_dwc == null ) )
      {
         if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
         {
            WebComp_Grid_dwc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211115086", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/subscriptions/wwp_subscriptionssettings.js", "?20241211115086", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_432( )
   {
      edtavWwpentityname_Internalname = "vWWPENTITYNAME_"+sGXsfl_43_idx ;
      edtavWwpentityid_Internalname = "vWWPENTITYID_"+sGXsfl_43_idx ;
      edtavDetailwebcomponent_Internalname = "vDETAILWEBCOMPONENT_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_432( )
   {
      edtavWwpentityname_Internalname = "vWWPENTITYNAME_"+sGXsfl_43_fel_idx ;
      edtavWwpentityid_Internalname = "vWWPENTITYID_"+sGXsfl_43_fel_idx ;
      edtavDetailwebcomponent_Internalname = "vDETAILWEBCOMPONENT_"+sGXsfl_43_fel_idx ;
   }

   public void sendrow_432( )
   {
      subsflControlProps_432( ) ;
      wb1Q0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_43_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_43_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_43_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavWwpentityname_Enabled!=0)&&(edtavWwpentityname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 44,'',false,'"+sGXsfl_43_idx+"',43)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpentityname_Internalname,AV29WWPEntityName,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavWwpentityname_Enabled!=0)&&(edtavWwpentityname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,44);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavWwpentityname_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavWwpentityname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavWwpentityid_Enabled!=0)&&(edtavWwpentityid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 45,'',false,'"+sGXsfl_43_idx+"',43)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpentityid_Internalname,GXutil.ltrim( localUtil.ntoc( AV28WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavWwpentityid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV28WWPEntityId), "ZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavWwpentityid_Enabled!=0)&&(edtavWwpentityid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,45);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavWwpentityid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavWwpentityid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDetailwebcomponent_Enabled!=0)&&(edtavDetailwebcomponent_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 46,'',false,'"+sGXsfl_43_idx+"',43)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDetailwebcomponent_Internalname,GXutil.rtrim( AV6DetailWebComponent),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDetailwebcomponent_Enabled!=0)&&(edtavDetailwebcomponent_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,46);\"" : " "),"'"+""+"'"+",false,"+"'"+"e211q2_client"+"'","","","","",edtavDetailwebcomponent_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWIconActionColumn WCD_ActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDetailwebcomponent_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1Q2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_43_idx = ((subGrid_Islastpage==1)&&(nGXsfl_43_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_432( ) ;
      }
      /* End function sendrow_432 */
   }

   public void startgridcontrol43( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"43\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Entity", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV29WWPEntityName);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWwpentityname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV28WWPEntityId, (byte)(10), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWwpentityid_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV6DetailWebComponent));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDetailwebcomponent_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      chkavMail.setInternalname( "vMAIL" );
      chkavSms.setInternalname( "vSMS" );
      chkavDesktop.setInternalname( "vDESKTOP" );
      chkavSd.setInternalname( "vSD" );
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      chkavNotifshowonlysubscribedevents.setInternalname( "vNOTIFSHOWONLYSUBSCRIBEDEVENTS" );
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavWwpentityname_Internalname = "vWWPENTITYNAME" ;
      edtavWwpentityid_Internalname = "vWWPENTITYID" ;
      edtavDetailwebcomponent_Internalname = "vDETAILWEBCOMPONENT" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divCell_grid_dwc_Internalname = "CELL_GRID_DWC" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      Dvpanel_unnamedtable2_Internalname = "DVPANEL_UNNAMEDTABLE2" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavDetailwebcomponent_Jsonclick = "" ;
      edtavDetailwebcomponent_Visible = -1 ;
      edtavDetailwebcomponent_Enabled = 1 ;
      edtavWwpentityid_Jsonclick = "" ;
      edtavWwpentityid_Visible = 0 ;
      edtavWwpentityid_Enabled = 1 ;
      edtavWwpentityname_Jsonclick = "" ;
      edtavWwpentityname_Visible = -1 ;
      edtavWwpentityname_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      divCell_grid_dwc_Class = "col-xs-12" ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      chkavNotifshowonlysubscribedevents.setEnabled( 1 );
      chkavSd.setEnabled( 1 );
      chkavDesktop.setEnabled( 1 );
      chkavSms.setEnabled( 1 );
      chkavMail.setEnabled( 1 );
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Title = "" ;
      Dvpanel_unnamedtable2_Cls = "PanelNoHeader" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Receive notifications by", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Manage my Subscriptions", "") );
      subGrid_Rows = 0 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavMail.setName( "vMAIL" );
      chkavMail.setWebtags( "" );
      chkavMail.setCaption( httpContext.getMessage( "Email", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavMail.getInternalname(), "TitleCaption", chkavMail.getCaption(), true);
      chkavMail.setCheckedValue( "false" );
      AV15Mail = GXutil.strtobool( GXutil.booltostr( AV15Mail)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Mail", AV15Mail);
      chkavSms.setName( "vSMS" );
      chkavSms.setWebtags( "" );
      chkavSms.setCaption( httpContext.getMessage( "SMS", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavSms.getInternalname(), "TitleCaption", chkavSms.getCaption(), true);
      chkavSms.setCheckedValue( "false" );
      AV21Sms = GXutil.strtobool( GXutil.booltostr( AV21Sms)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Sms", AV21Sms);
      chkavDesktop.setName( "vDESKTOP" );
      chkavDesktop.setWebtags( "" );
      chkavDesktop.setCaption( httpContext.getMessage( "Desktop notifications", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavDesktop.getInternalname(), "TitleCaption", chkavDesktop.getCaption(), true);
      chkavDesktop.setCheckedValue( "false" );
      AV5Desktop = GXutil.strtobool( GXutil.booltostr( AV5Desktop)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5Desktop", AV5Desktop);
      chkavSd.setName( "vSD" );
      chkavSd.setWebtags( "" );
      chkavSd.setCaption( httpContext.getMessage( "Mobile notifications", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavSd.getInternalname(), "TitleCaption", chkavSd.getCaption(), true);
      chkavSd.setCheckedValue( "false" );
      AV18SD = GXutil.strtobool( GXutil.booltostr( AV18SD)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18SD", AV18SD);
      chkavNotifshowonlysubscribedevents.setName( "vNOTIFSHOWONLYSUBSCRIBEDEVENTS" );
      chkavNotifshowonlysubscribedevents.setWebtags( "" );
      chkavNotifshowonlysubscribedevents.setCaption( httpContext.getMessage( "Show only my subscribed events", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavNotifshowonlysubscribedevents.getInternalname(), "TitleCaption", chkavNotifshowonlysubscribedevents.getCaption(), true);
      chkavNotifshowonlysubscribedevents.setCheckedValue( "false" );
      AV16NotifShowOnlySubscribedEvents = GXutil.strtobool( GXutil.booltostr( AV16NotifShowOnlySubscribedEvents)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16NotifShowOnlySubscribedEvents", AV16NotifShowOnlySubscribedEvents);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'AV7FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV43Udparg2',fld:'vUDPARG2',pic:'',hsh:true},{av:'AV15Mail',fld:'vMAIL',pic:''},{av:'AV21Sms',fld:'vSMS',pic:''},{av:'AV5Desktop',fld:'vDESKTOP',pic:''},{av:'AV18SD',fld:'vSD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV35GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e111Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'AV7FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV43Udparg2',fld:'vUDPARG2',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'AV15Mail',fld:'vMAIL',pic:''},{av:'AV21Sms',fld:'vSMS',pic:''},{av:'AV5Desktop',fld:'vDESKTOP',pic:''},{av:'AV18SD',fld:'vSD',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e121Q2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'AV7FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV43Udparg2',fld:'vUDPARG2',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'AV15Mail',fld:'vMAIL',pic:''},{av:'AV21Sms',fld:'vSMS',pic:''},{av:'AV5Desktop',fld:'vDESKTOP',pic:''},{av:'AV18SD',fld:'vSD',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e201Q2',iparms:[{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV43Udparg2',fld:'vUDPARG2',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV6DetailWebComponent',fld:'vDETAILWEBCOMPONENT',pic:''},{av:'AV29WWPEntityName',fld:'vWWPENTITYNAME',pic:''},{av:'AV28WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV9GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VDETAILWEBCOMPONENT.CLICK","{handler:'e211Q2',iparms:[{av:'AV28WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV16NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''}]");
      setEventMetadata("VDETAILWEBCOMPONENT.CLICK",",oparms:[{ctrl:'GRID_DWC'}]}");
      setEventMetadata("VMAIL.CLICK","{handler:'e131Q2',iparms:[{av:'AV15Mail',fld:'vMAIL',pic:''}]");
      setEventMetadata("VMAIL.CLICK",",oparms:[]}");
      setEventMetadata("VSMS.CLICK","{handler:'e141Q2',iparms:[{av:'AV21Sms',fld:'vSMS',pic:''}]");
      setEventMetadata("VSMS.CLICK",",oparms:[]}");
      setEventMetadata("VSD.CLICK","{handler:'e151Q2',iparms:[{av:'AV18SD',fld:'vSD',pic:''}]");
      setEventMetadata("VSD.CLICK",",oparms:[]}");
      setEventMetadata("VDESKTOP.CLICK","{handler:'e161Q2',iparms:[{av:'AV5Desktop',fld:'vDESKTOP',pic:''}]");
      setEventMetadata("VDESKTOP.CLICK",",oparms:[]}");
      setEventMetadata("VNOTIFSHOWONLYSUBSCRIBEDEVENTS.CLICK","{handler:'e171Q2',iparms:[]");
      setEventMetadata("VNOTIFSHOWONLYSUBSCRIBEDEVENTS.CLICK",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Detailwebcomponent',iparms:[]");
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
      return "wwpsubscriptionssettings_Execute";
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
      Gridpaginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV40Pgmname = "" ;
      AV7FilterFullText = "" ;
      A150WWPEntityName = "" ;
      A32WWPUserExtendedId = "" ;
      AV43Udparg2 = "" ;
      A149WWPSubscriptionRoleId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV35GridAppliedFilters = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      WebComp_Grid_dwc_Component = "" ;
      OldGrid_dwc = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV29WWPEntityName = "" ;
      AV6DetailWebComponent = "" ;
      AV39Udparg1 = "" ;
      scmdbuf = "" ;
      H001Q2_A32WWPUserExtendedId = new String[] {""} ;
      H001Q2_n32WWPUserExtendedId = new boolean[] {false} ;
      H001Q2_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      H001Q2_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      H001Q2_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      H001Q2_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      AV26WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV34WWPSubscriptionRoleIdCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_objcol_char4 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char5 = new GXSimpleCollection[1] ;
      H001Q3_A33WWPEntityId = new long[1] ;
      H001Q3_A150WWPEntityName = new String[] {""} ;
      H001Q4_A34WWPSubscriptionId = new long[1] ;
      H001Q4_A33WWPEntityId = new long[1] ;
      H001Q4_A149WWPSubscriptionRoleId = new String[] {""} ;
      H001Q4_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      H001Q4_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      H001Q4_A32WWPUserExtendedId = new String[] {""} ;
      H001Q4_n32WWPUserExtendedId = new boolean[] {false} ;
      H001Q4_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      H001Q4_A35WWPNotificationDefinitionId = new long[1] ;
      GXv_int6 = new long[1] ;
      GXv_boolean7 = new boolean[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV20Session = httpContext.getWebSession();
      AV11GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV12GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState8 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      AV33WWPUserExtended = new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended(remoteHandle);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings__default(),
         new Object[] {
             new Object[] {
            H001Q2_A32WWPUserExtendedId, H001Q2_A142WWPUserExtendedSMSNotif, H001Q2_A141WWPUserExtendedEmaiNotif, H001Q2_A144WWPUserExtendedDesktopNotif, H001Q2_A143WWPUserExtendedMobileNotif
            }
            , new Object[] {
            H001Q3_A33WWPEntityId, H001Q3_A150WWPEntityName
            }
            , new Object[] {
            H001Q4_A34WWPSubscriptionId, H001Q4_A33WWPEntityId, H001Q4_A149WWPSubscriptionRoleId, H001Q4_n149WWPSubscriptionRoleId, H001Q4_A152WWPSubscriptionSubscribed, H001Q4_A32WWPUserExtendedId, H001Q4_n32WWPUserExtendedId, H001Q4_A156WWPNotificationDefinitionAllow, H001Q4_A35WWPNotificationDefinitionId
            }
         }
      );
      AV40Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettings" ;
      /* GeneXus formulas. */
      AV40Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettings" ;
      Gx_err = (short)(0) ;
      edtavWwpentityname_Enabled = 0 ;
      edtavWwpentityid_Enabled = 0 ;
      edtavDetailwebcomponent_Enabled = 0 ;
      WebComp_Grid_dwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV10GridRecordCount ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int edtavFilterfulltext_Enabled ;
   private int subGrid_Islastpage ;
   private int edtavWwpentityname_Enabled ;
   private int edtavWwpentityid_Enabled ;
   private int edtavDetailwebcomponent_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV17PageToGo ;
   private int AV44GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavWwpentityname_Visible ;
   private int edtavWwpentityid_Visible ;
   private int edtavDetailwebcomponent_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long A33WWPEntityId ;
   private long A35WWPNotificationDefinitionId ;
   private long AV8GridCurrentPage ;
   private long AV9GridPageCount ;
   private long AV28WWPEntityId ;
   private long GRID_nCurrentRecord ;
   private long GXv_int6[] ;
   private String Gridpaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_43_idx="0001" ;
   private String AV40Pgmname ;
   private String A32WWPUserExtendedId ;
   private String AV43Udparg2 ;
   private String A149WWPSubscriptionRoleId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Dvpanel_unnamedtable2_Width ;
   private String Dvpanel_unnamedtable2_Cls ;
   private String Dvpanel_unnamedtable2_Title ;
   private String Dvpanel_unnamedtable2_Iconposition ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String divTableheader_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divCell_grid_dwc_Internalname ;
   private String divCell_grid_dwc_Class ;
   private String WebComp_Grid_dwc_Component ;
   private String OldGrid_dwc ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavWwpentityname_Internalname ;
   private String edtavWwpentityid_Internalname ;
   private String AV6DetailWebComponent ;
   private String edtavDetailwebcomponent_Internalname ;
   private String AV39Udparg1 ;
   private String scmdbuf ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavWwpentityname_Jsonclick ;
   private String edtavWwpentityid_Jsonclick ;
   private String edtavDetailwebcomponent_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV16NotifShowOnlySubscribedEvents ;
   private boolean A156WWPNotificationDefinitionAllow ;
   private boolean n32WWPUserExtendedId ;
   private boolean A152WWPSubscriptionSubscribed ;
   private boolean n149WWPSubscriptionRoleId ;
   private boolean AV15Mail ;
   private boolean AV21Sms ;
   private boolean AV5Desktop ;
   private boolean AV18SD ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_unnamedtable2_Autowidth ;
   private boolean Dvpanel_unnamedtable2_Autoheight ;
   private boolean Dvpanel_unnamedtable2_Collapsible ;
   private boolean Dvpanel_unnamedtable2_Collapsed ;
   private boolean Dvpanel_unnamedtable2_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable2_Autoscroll ;
   private boolean wbLoad ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean A142WWPUserExtendedSMSNotif ;
   private boolean A141WWPUserExtendedEmaiNotif ;
   private boolean A144WWPUserExtendedDesktopNotif ;
   private boolean A143WWPUserExtendedMobileNotif ;
   private boolean gx_refresh_fired ;
   private boolean AV30EntityHasItemsToShow ;
   private boolean Cond_result ;
   private boolean GXv_boolean7[] ;
   private String AV7FilterFullText ;
   private String A150WWPEntityName ;
   private String AV35GridAppliedFilters ;
   private String AV29WWPEntityName ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Grid_dwc ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private ICheckbox chkavMail ;
   private ICheckbox chkavSms ;
   private ICheckbox chkavDesktop ;
   private ICheckbox chkavSd ;
   private ICheckbox chkavNotifshowonlysubscribedevents ;
   private IDataStoreProvider pr_default ;
   private String[] H001Q2_A32WWPUserExtendedId ;
   private boolean[] H001Q2_n32WWPUserExtendedId ;
   private boolean[] H001Q2_A142WWPUserExtendedSMSNotif ;
   private boolean[] H001Q2_A141WWPUserExtendedEmaiNotif ;
   private boolean[] H001Q2_A144WWPUserExtendedDesktopNotif ;
   private boolean[] H001Q2_A143WWPUserExtendedMobileNotif ;
   private long[] H001Q3_A33WWPEntityId ;
   private String[] H001Q3_A150WWPEntityName ;
   private long[] H001Q4_A34WWPSubscriptionId ;
   private long[] H001Q4_A33WWPEntityId ;
   private String[] H001Q4_A149WWPSubscriptionRoleId ;
   private boolean[] H001Q4_n149WWPSubscriptionRoleId ;
   private boolean[] H001Q4_A152WWPSubscriptionSubscribed ;
   private String[] H001Q4_A32WWPUserExtendedId ;
   private boolean[] H001Q4_n32WWPUserExtendedId ;
   private boolean[] H001Q4_A156WWPNotificationDefinitionAllow ;
   private long[] H001Q4_A35WWPNotificationDefinitionId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV34WWPSubscriptionRoleIdCollection ;
   private GXSimpleCollection<String> GXt_objcol_char4 ;
   private GXSimpleCollection<String> GXv_objcol_char5[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState8[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV26WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended AV33WWPUserExtended ;
}

final  class wwp_subscriptionssettings__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_subscriptionssettings__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001Q4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A149WWPSubscriptionRoleId ,
                                          GXSimpleCollection<String> AV34WWPSubscriptionRoleIdCollection ,
                                          long A33WWPEntityId ,
                                          boolean A156WWPNotificationDefinitionAllow ,
                                          String A32WWPUserExtendedId ,
                                          String AV43Udparg2 ,
                                          boolean A152WWPSubscriptionSubscribed )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[2];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT T1.[WWPSubscriptionId], T2.[WWPEntityId], T1.[WWPSubscriptionRoleId], T1.[WWPSubscriptionSubscribed], T1.[WWPUserExtendedId], T2.[WWPNotificationDefinitionAllow]," ;
      scmdbuf += " T1.[WWPNotificationDefinitionId] FROM ([WWP_Subscription] T1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = T1.[WWPNotificationDefinitionId])" ;
      addWhere(sWhereString, "(T2.[WWPEntityId] = ?)");
      addWhere(sWhereString, "(T2.[WWPNotificationDefinitionAllow] = 1)");
      addWhere(sWhereString, "(( T1.[WWPUserExtendedId] = ? and T1.[WWPSubscriptionSubscribed] = 1) or "+GXutil.toValueList("sqlserver", AV34WWPSubscriptionRoleIdCollection, "T1.[WWPSubscriptionRoleId] IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[WWPSubscriptionId]" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_H001Q4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).longValue() , ((Boolean) dynConstraints[3]).booleanValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Boolean) dynConstraints[6]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001Q2", "SELECT [WWPUserExtendedId], [WWPUserExtendedSMSNotif], [WWPUserExtendedEmaiNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedMobileNotif] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ORDER BY [WWPUserExtendedId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H001Q3", "SELECT [WWPEntityId], [WWPEntityName] FROM [WWP_Entity] ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001Q4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((long[]) buf[8])[0] = rslt.getLong(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 40);
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 40);
               }
               return;
      }
   }

}

