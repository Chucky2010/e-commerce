package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_subscriptionssettingsbyrolewc_impl extends GXWebComponent
{
   public wwp_subscriptionssettingsbyrolewc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_subscriptionssettingsbyrolewc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_subscriptionssettingsbyrolewc_impl.class ));
   }

   public wwp_subscriptionssettingsbyrolewc_impl( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
      chkavIncludenotification = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "WWPEntityId") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV13WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13WWPEntityId), 10, 0));
               AV10NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.GetPar( "NotifShowOnlySubscribedEvents")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10NotifShowOnlySubscribedEvents", AV10NotifShowOnlySubscribedEvents);
               AV16WWPSubscriptionRoleId = httpContext.GetPar( "WWPSubscriptionRoleId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPSubscriptionRoleId", AV16WWPSubscriptionRoleId);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Long.valueOf(AV13WWPEntityId),Boolean.valueOf(AV10NotifShowOnlySubscribedEvents),AV16WWPSubscriptionRoleId});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "WWPEntityId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WWPEntityId") ;
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_14 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_14"))) ;
      nGXsfl_14_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_14_idx"))) ;
      sGXsfl_14_idx = httpContext.GetPar( "sGXsfl_14_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      edtavWwpnotificationdefinitionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdefinitionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
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
      AV28Pgmname = httpContext.GetPar( "Pgmname") ;
      edtavWwpnotificationdefinitionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdefinitionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      A33WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
      AV13WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
      A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionAppli"))) ;
      A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
      A154WWPNotificationDefinitionDescr = httpContext.GetPar( "WWPNotificationDefinitionDescr") ;
      A149WWPSubscriptionRoleId = httpContext.GetPar( "WWPSubscriptionRoleId") ;
      n149WWPSubscriptionRoleId = false ;
      AV16WWPSubscriptionRoleId = httpContext.GetPar( "WWPSubscriptionRoleId") ;
      A34WWPSubscriptionId = GXutil.lval( httpContext.GetPar( "WWPSubscriptionId")) ;
      AV10NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.GetPar( "NotifShowOnlySubscribedEvents")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV28Pgmname, A33WWPEntityId, AV13WWPEntityId, A155WWPNotificationDefinitionAppli, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A149WWPSubscriptionRoleId, AV16WWPSubscriptionRoleId, A34WWPSubscriptionId, AV10NotifShowOnlySubscribedEvents, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa3P2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.mujermorena.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Subscriptions Settings by Role", "")) ;
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrolewc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13WWPEntityId,10,0)),GXutil.URLEncode(GXutil.booltostr(AV10NotifShowOnlySubscribedEvents)),GXutil.URLEncode(GXutil.rtrim(AV16WWPSubscriptionRoleId))}, new String[] {"WWPEntityId","NotifShowOnlySubscribedEvents","WWPSubscriptionRoleId"}) +"\">") ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
         }
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_14", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_14, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV13WWPEntityId", GXutil.ltrim( localUtil.ntoc( wcpOAV13WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV10NotifShowOnlySubscribedEvents", wcpOAV10NotifShowOnlySubscribedEvents);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV16WWPSubscriptionRoleId", GXutil.rtrim( wcpOAV16WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV28Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPENTITYID", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPENTITYID", GXutil.ltrim( localUtil.ntoc( AV13WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONAPPLI", GXutil.ltrim( localUtil.ntoc( A155WWPNotificationDefinitionAppli, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONID", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONDESCR", A154WWPNotificationDefinitionDescr);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONROLEID", GXutil.rtrim( A149WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPSUBSCRIPTIONROLEID", GXutil.rtrim( AV16WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONID", GXutil.ltrim( localUtil.ntoc( A34WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vNOTIFSHOWONLYSUBSCRIBEDEVENTS", AV10NotifShowOnlySubscribedEvents);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPNOTIFICATIONDEFINITIONID_Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpnotificationdefinitionid_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPSUBSCRIPTIONID_Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionid_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm3P2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsByRoleWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Subscriptions Settings by Role", "") ;
   }

   public void wb3P0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrolewc");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         }
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain TableSubscriptions", "left", "top", "", "", "div");
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
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         wb_table1_11_3P2( true) ;
      }
      else
      {
         wb_table1_11_3P2( false) ;
      }
      return  ;
   }

   public void wb_table1_11_3P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 14 )
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
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start3P2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Subscriptions Settings by Role", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup3P0( ) ;
         }
      }
   }

   public void ws3P2( )
   {
      start3P2( ) ;
      evt3P2( ) ;
   }

   public void evt3P2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "TABLESUBSCRIPTIONITEM.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e113P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = chkavIncludenotification.getInternalname() ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 27), "TABLESUBSCRIPTIONITEM.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
                           }
                           nGXsfl_14_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_142( ) ;
                           AV9IncludeNotification = GXutil.strtobool( httpContext.cgiGet( chkavIncludenotification.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV9IncludeNotification);
                           AV14WWPNotificationDescription = httpContext.cgiGet( edtavWwpnotificationdescription_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdescription_Internalname, AV14WWPNotificationDescription);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpnotificationdefinitionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpnotificationdefinitionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPNOTIFICATIONDEFINITIONID");
                              GX_FocusControl = edtavWwpnotificationdefinitionid_Internalname ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV5WWPNotificationDefinitionId = 0 ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5WWPNotificationDefinitionId), 10, 0));
                           }
                           else
                           {
                              AV5WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( edtavWwpnotificationdefinitionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5WWPNotificationDefinitionId), 10, 0));
                           }
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPSUBSCRIPTIONID");
                              GX_FocusControl = edtavWwpsubscriptionid_Internalname ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV6WWPSubscriptionId = 0 ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6WWPSubscriptionId), 10, 0));
                           }
                           else
                           {
                              AV6WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6WWPSubscriptionId), 10, 0));
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = chkavIncludenotification.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e123P2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = chkavIncludenotification.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e133P2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = chkavIncludenotification.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e143P2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "TABLESUBSCRIPTIONITEM.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = chkavIncludenotification.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e113P2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup3P0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = chkavIncludenotification.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
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

   public void we3P2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3P2( ) ;
         }
      }
   }

   public void pa3P2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
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

   public void gxnrgrid_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_142( ) ;
      while ( nGXsfl_14_idx <= nRC_GXsfl_14 )
      {
         sendrow_142( ) ;
         nGXsfl_14_idx = ((subGrid_Islastpage==1)&&(nGXsfl_14_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_14_idx+1) ;
         sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_142( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV28Pgmname ,
                                 long A33WWPEntityId ,
                                 long AV13WWPEntityId ,
                                 byte A155WWPNotificationDefinitionAppli ,
                                 long A35WWPNotificationDefinitionId ,
                                 String A154WWPNotificationDefinitionDescr ,
                                 String A149WWPSubscriptionRoleId ,
                                 String AV16WWPSubscriptionRoleId ,
                                 long A34WWPSubscriptionId ,
                                 boolean AV10NotifShowOnlySubscribedEvents ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e133P2 ();
      GRID_nCurrentRecord = 0 ;
      rf3P2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
      rf3P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsByRoleWC" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdescription_Enabled), 5, 0), !bGXsfl_14_Refreshing);
   }

   public void rf3P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(14) ;
      /* Execute user event: Refresh */
      e133P2 ();
      nGXsfl_14_idx = 1 ;
      sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_142( ) ;
      bGXsfl_14_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( subGrid_Islastpage != 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordcount( )-subgrid_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_142( ) ;
         e143P2 ();
         wbEnd = (short)(14) ;
         wb3P0( ) ;
      }
      bGXsfl_14_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes3P2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV28Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28Pgmname, ""))));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV28Pgmname, A33WWPEntityId, AV13WWPEntityId, A155WWPNotificationDefinitionAppli, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A149WWPSubscriptionRoleId, AV16WWPSubscriptionRoleId, A34WWPSubscriptionId, AV10NotifShowOnlySubscribedEvents, sPrefix) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV28Pgmname, A33WWPEntityId, AV13WWPEntityId, A155WWPNotificationDefinitionAppli, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A149WWPSubscriptionRoleId, AV16WWPSubscriptionRoleId, A34WWPSubscriptionId, AV10NotifShowOnlySubscribedEvents, sPrefix) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV28Pgmname, A33WWPEntityId, AV13WWPEntityId, A155WWPNotificationDefinitionAppli, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A149WWPSubscriptionRoleId, AV16WWPSubscriptionRoleId, A34WWPSubscriptionId, AV10NotifShowOnlySubscribedEvents, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV28Pgmname, A33WWPEntityId, AV13WWPEntityId, A155WWPNotificationDefinitionAppli, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A149WWPSubscriptionRoleId, AV16WWPSubscriptionRoleId, A34WWPSubscriptionId, AV10NotifShowOnlySubscribedEvents, sPrefix) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV28Pgmname, A33WWPEntityId, AV13WWPEntityId, A155WWPNotificationDefinitionAppli, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A149WWPSubscriptionRoleId, AV16WWPSubscriptionRoleId, A34WWPSubscriptionId, AV10NotifShowOnlySubscribedEvents, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsByRoleWC" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdescription_Enabled), 5, 0), !bGXsfl_14_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup3P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e123P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_14 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_14"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV13WWPEntityId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV13WWPEntityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         wcpOAV10NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV10NotifShowOnlySubscribedEvents")) ;
         wcpOAV16WWPSubscriptionRoleId = httpContext.cgiGet( sPrefix+"wcpOAV16WWPSubscriptionRoleId") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
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
      e123P2 ();
      if (returnInSub) return;
   }

   public void e123P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavWwpnotificationdefinitionid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdefinitionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S112 ();
      if (returnInSub) return;
   }

   public void e133P2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
   }

   private void e143P2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV7GridRecordCount = (short)(0) ;
      /* Using cursor H003P2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV13WWPEntityId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A35WWPNotificationDefinitionId = H003P2_A35WWPNotificationDefinitionId[0] ;
         A155WWPNotificationDefinitionAppli = H003P2_A155WWPNotificationDefinitionAppli[0] ;
         A33WWPEntityId = H003P2_A33WWPEntityId[0] ;
         A154WWPNotificationDefinitionDescr = H003P2_A154WWPNotificationDefinitionDescr[0] ;
         AV5WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5WWPNotificationDefinitionId), 10, 0));
         AV15WWPNotificationDescriptionBase = A154WWPNotificationDefinitionDescr ;
         AV14WWPNotificationDescription = AV15WWPNotificationDescriptionBase ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdescription_Internalname, AV14WWPNotificationDescription);
         AV9IncludeNotification = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV9IncludeNotification);
         AV6WWPSubscriptionId = 0 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6WWPSubscriptionId), 10, 0));
         /* Using cursor H003P3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId), AV16WWPSubscriptionRoleId, Byte.valueOf(A155WWPNotificationDefinitionAppli)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A149WWPSubscriptionRoleId = H003P3_A149WWPSubscriptionRoleId[0] ;
            n149WWPSubscriptionRoleId = H003P3_n149WWPSubscriptionRoleId[0] ;
            A34WWPSubscriptionId = H003P3_A34WWPSubscriptionId[0] ;
            AV6WWPSubscriptionId = A34WWPSubscriptionId ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6WWPSubscriptionId), 10, 0));
            AV7GridRecordCount = (short)(AV7GridRecordCount+1) ;
            AV9IncludeNotification = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV9IncludeNotification);
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(14) ;
            }
            if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
            {
               sendrow_142( ) ;
               GRID_nEOF = (byte)(1) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
               if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
               {
                  GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
               }
            }
            if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
            {
               GRID_nEOF = (byte)(0) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
            GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
            if ( isFullAjaxMode( ) && ! bGXsfl_14_Refreshing )
            {
               httpContext.doAjaxLoad(14, GridRow);
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( ! AV9IncludeNotification && ! AV10NotifShowOnlySubscribedEvents )
         {
            AV7GridRecordCount = (short)(AV7GridRecordCount+1) ;
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(14) ;
            }
            if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
            {
               sendrow_142( ) ;
               GRID_nEOF = (byte)(1) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
               if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
               {
                  GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
               }
            }
            if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
            {
               GRID_nEOF = (byte)(0) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
            GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
            if ( isFullAjaxMode( ) && ! bGXsfl_14_Refreshing )
            {
               httpContext.doAjaxLoad(14, GridRow);
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV23GridPageCount = (short)(AV7GridRecordCount/ (double) (subGrid_Rows)+((((int)((AV7GridRecordCount) % (subGrid_Rows)))>0) ? 1 : 0)) ;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV11Session.getValue(AV28Pgmname+"GridState"), "") == 0 )
      {
         AV8GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV28Pgmname+"GridState"), null, null);
      }
      else
      {
         AV8GridState.fromxml(AV11Session.getValue(AV28Pgmname+"GridState"), null, null);
      }
      if ( ! (GXutil.strcmp("", GXutil.trim( AV8GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV8GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV8GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S122( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV8GridState.fromxml(AV11Session.getValue(AV28Pgmname+"GridState"), null, null);
      AV8GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV8GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV28Pgmname+"GridState", AV8GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e113P2( )
   {
      /* Tablesubscriptionitem_Click Routine */
      returnInSub = false ;
      AV9IncludeNotification = (boolean)(!AV9IncludeNotification) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV9IncludeNotification);
      GXv_int2[0] = AV6WWPSubscriptionId ;
      new com.mujermorena.wwpbaseobjects.subscriptions.wwp_roleupdatesubscription(remoteHandle, context).execute( AV9IncludeNotification, GXv_int2, AV5WWPNotificationDefinitionId, AV16WWPSubscriptionRoleId) ;
      wwp_subscriptionssettingsbyrolewc_impl.this.AV6WWPSubscriptionId = GXv_int2[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6WWPSubscriptionId), 10, 0));
      if ( 1 == 0 )
      {
         /* Start For Each Line */
         nRC_GXsfl_14 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_14"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_14_fel_idx = 0 ;
         while ( nGXsfl_14_fel_idx < nRC_GXsfl_14 )
         {
            nGXsfl_14_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_14_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_14_fel_idx+1) ;
            sGXsfl_14_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_142( ) ;
            AV9IncludeNotification = GXutil.strtobool( httpContext.cgiGet( chkavIncludenotification.getInternalname())) ;
            AV14WWPNotificationDescription = httpContext.cgiGet( edtavWwpnotificationdescription_Internalname) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpnotificationdefinitionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpnotificationdefinitionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPNOTIFICATIONDEFINITIONID");
               GX_FocusControl = edtavWwpnotificationdefinitionid_Internalname ;
               wbErr = true ;
               AV5WWPNotificationDefinitionId = 0 ;
            }
            else
            {
               AV5WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( edtavWwpnotificationdefinitionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPSUBSCRIPTIONID");
               GX_FocusControl = edtavWwpsubscriptionid_Internalname ;
               wbErr = true ;
               AV6WWPSubscriptionId = 0 ;
            }
            else
            {
               AV6WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            }
            /* End For Each Line */
         }
         if ( nGXsfl_14_fel_idx == 0 )
         {
            nGXsfl_14_idx = 1 ;
            sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_142( ) ;
         }
         nGXsfl_14_fel_idx = 1 ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_11_3P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SubscriptionsPanelCell'>") ;
         /*  Grid Control  */
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol14( ) ;
      }
      if ( wbEnd == 14 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_14 = (int)(nGXsfl_14_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_11_3P2e( true) ;
      }
      else
      {
         wb_table1_11_3P2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV13WWPEntityId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13WWPEntityId), 10, 0));
      AV10NotifShowOnlySubscribedEvents = ((Boolean) getParm(obj,1,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10NotifShowOnlySubscribedEvents", AV10NotifShowOnlySubscribedEvents);
      AV16WWPSubscriptionRoleId = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPSubscriptionRoleId", AV16WWPSubscriptionRoleId);
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
      pa3P2( ) ;
      ws3P2( ) ;
      we3P2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV13WWPEntityId = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV10NotifShowOnlySubscribedEvents = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV16WWPSubscriptionRoleId = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3P2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\subscriptions\\wwp_subscriptionssettingsbyrolewc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3P2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV13WWPEntityId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13WWPEntityId), 10, 0));
         AV10NotifShowOnlySubscribedEvents = ((Boolean) getParm(obj,3,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10NotifShowOnlySubscribedEvents", AV10NotifShowOnlySubscribedEvents);
         AV16WWPSubscriptionRoleId = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPSubscriptionRoleId", AV16WWPSubscriptionRoleId);
      }
      wcpOAV13WWPEntityId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV13WWPEntityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      wcpOAV10NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV10NotifShowOnlySubscribedEvents")) ;
      wcpOAV16WWPSubscriptionRoleId = httpContext.cgiGet( sPrefix+"wcpOAV16WWPSubscriptionRoleId") ;
      if ( ! GetJustCreated( ) && ( ( AV13WWPEntityId != wcpOAV13WWPEntityId ) || ( AV10NotifShowOnlySubscribedEvents != wcpOAV10NotifShowOnlySubscribedEvents ) || ( GXutil.strcmp(AV16WWPSubscriptionRoleId, wcpOAV16WWPSubscriptionRoleId) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV13WWPEntityId = AV13WWPEntityId ;
      wcpOAV10NotifShowOnlySubscribedEvents = AV10NotifShowOnlySubscribedEvents ;
      wcpOAV16WWPSubscriptionRoleId = AV16WWPSubscriptionRoleId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV13WWPEntityId = httpContext.cgiGet( sPrefix+"AV13WWPEntityId_CTRL") ;
      if ( GXutil.len( sCtrlAV13WWPEntityId) > 0 )
      {
         AV13WWPEntityId = localUtil.ctol( httpContext.cgiGet( sCtrlAV13WWPEntityId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13WWPEntityId), 10, 0));
      }
      else
      {
         AV13WWPEntityId = localUtil.ctol( httpContext.cgiGet( sPrefix+"AV13WWPEntityId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      sCtrlAV10NotifShowOnlySubscribedEvents = httpContext.cgiGet( sPrefix+"AV10NotifShowOnlySubscribedEvents_CTRL") ;
      if ( GXutil.len( sCtrlAV10NotifShowOnlySubscribedEvents) > 0 )
      {
         AV10NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sCtrlAV10NotifShowOnlySubscribedEvents)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10NotifShowOnlySubscribedEvents", AV10NotifShowOnlySubscribedEvents);
      }
      else
      {
         AV10NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV10NotifShowOnlySubscribedEvents_PARM")) ;
      }
      sCtrlAV16WWPSubscriptionRoleId = httpContext.cgiGet( sPrefix+"AV16WWPSubscriptionRoleId_CTRL") ;
      if ( GXutil.len( sCtrlAV16WWPSubscriptionRoleId) > 0 )
      {
         AV16WWPSubscriptionRoleId = httpContext.cgiGet( sCtrlAV16WWPSubscriptionRoleId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPSubscriptionRoleId", AV16WWPSubscriptionRoleId);
      }
      else
      {
         AV16WWPSubscriptionRoleId = httpContext.cgiGet( sPrefix+"AV16WWPSubscriptionRoleId_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa3P2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws3P2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13WWPEntityId_PARM", GXutil.ltrim( localUtil.ntoc( AV13WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV13WWPEntityId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13WWPEntityId_CTRL", GXutil.rtrim( sCtrlAV13WWPEntityId));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10NotifShowOnlySubscribedEvents_PARM", GXutil.booltostr( AV10NotifShowOnlySubscribedEvents));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10NotifShowOnlySubscribedEvents)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10NotifShowOnlySubscribedEvents_CTRL", GXutil.rtrim( sCtrlAV10NotifShowOnlySubscribedEvents));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16WWPSubscriptionRoleId_PARM", GXutil.rtrim( AV16WWPSubscriptionRoleId));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV16WWPSubscriptionRoleId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16WWPSubscriptionRoleId_CTRL", GXutil.rtrim( sCtrlAV16WWPSubscriptionRoleId));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we3P2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211162216", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/subscriptions/wwp_subscriptionssettingsbyrolewc.js", "?20241211162216", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_142( )
   {
      chkavIncludenotification.setInternalname( sPrefix+"vINCLUDENOTIFICATION_"+sGXsfl_14_idx );
      edtavWwpnotificationdescription_Internalname = sPrefix+"vWWPNOTIFICATIONDESCRIPTION_"+sGXsfl_14_idx ;
      edtavWwpnotificationdefinitionid_Internalname = sPrefix+"vWWPNOTIFICATIONDEFINITIONID_"+sGXsfl_14_idx ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID_"+sGXsfl_14_idx ;
   }

   public void subsflControlProps_fel_142( )
   {
      chkavIncludenotification.setInternalname( sPrefix+"vINCLUDENOTIFICATION_"+sGXsfl_14_fel_idx );
      edtavWwpnotificationdescription_Internalname = sPrefix+"vWWPNOTIFICATIONDESCRIPTION_"+sGXsfl_14_fel_idx ;
      edtavWwpnotificationdefinitionid_Internalname = sPrefix+"vWWPNOTIFICATIONDEFINITIONID_"+sGXsfl_14_fel_idx ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID_"+sGXsfl_14_fel_idx ;
   }

   public void sendrow_142( )
   {
      subsflControlProps_142( ) ;
      wb3P0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_14_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            subGrid_Backcolor = (int)(0xFFFFFF) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_14_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0xFFFFFF) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         /* Start of Columns property logic. */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr"+" class=\""+subGrid_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_14_idx+"\">") ;
         }
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgrid_Internalname+"_"+sGXsfl_14_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 SubscriptionItem","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablesubscriptionitem_Internalname+"_"+sGXsfl_14_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkavIncludenotification.getInternalname(),httpContext.getMessage( "Include Notification", ""),"gx-form-item AttributeCheckBoxLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Check box */
         TempTags = " " + ((chkavIncludenotification.getEnabled()!=0)&&(chkavIncludenotification.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 21,'"+sPrefix+"',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vINCLUDENOTIFICATION_" + sGXsfl_14_idx ;
         chkavIncludenotification.setName( GXCCtl );
         chkavIncludenotification.setWebtags( "" );
         chkavIncludenotification.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIncludenotification.getInternalname(), "TitleCaption", chkavIncludenotification.getCaption(), !bGXsfl_14_Refreshing);
         chkavIncludenotification.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIncludenotification.getInternalname(),GXutil.booltostr( AV9IncludeNotification),"",httpContext.getMessage( "Include Notification", ""),Integer.valueOf(1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(21, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+((chkavIncludenotification.getEnabled()!=0)&&(chkavIncludenotification.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,21);\"" : " ")});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationdescription_Internalname,httpContext.getMessage( "WWPNotification Description", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Multiple line edit */
         TempTags = " " + ((edtavWwpnotificationdescription_Enabled!=0)&&(edtavWwpnotificationdescription_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 24,'"+sPrefix+"',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationdescription_Internalname,AV14WWPNotificationDescription,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavWwpnotificationdescription_Enabled!=0)&&(edtavWwpnotificationdescription_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,24);\"" : " "),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavWwpnotificationdescription_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 Invisible","left","top","","","div"});
         /* Table start */
         GridRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgrid_Internalname+"_"+sGXsfl_14_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
         GridRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationdefinitionid_Internalname,httpContext.getMessage( "WWPNotification Definition Id", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         TempTags = " " + ((edtavWwpnotificationdefinitionid_Enabled!=0)&&(edtavWwpnotificationdefinitionid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 31,'"+sPrefix+"',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationdefinitionid_Internalname,GXutil.ltrim( localUtil.ntoc( AV5WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV5WWPNotificationDefinitionId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavWwpnotificationdefinitionid_Enabled!=0)&&(edtavWwpnotificationdefinitionid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,31);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWwpnotificationdefinitionid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavWwpnotificationdefinitionid_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionid_Internalname,httpContext.getMessage( "WWPSubscription Id", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         TempTags = " " + ((edtavWwpsubscriptionid_Enabled!=0)&&(edtavWwpsubscriptionid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 34,'"+sPrefix+"',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionid_Internalname,GXutil.ltrim( localUtil.ntoc( AV6WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV6WWPSubscriptionId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavWwpsubscriptionid_Enabled!=0)&&(edtavWwpsubscriptionid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWwpsubscriptionid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavWwpsubscriptionid_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("row");
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("table");
         }
         /* End of table */
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         send_integrity_lvl_hashes3P2( ) ;
         /* End of Columns property logic. */
         GridContainer.AddRow(GridRow);
         nGXsfl_14_idx = ((subGrid_Islastpage==1)&&(nGXsfl_14_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_14_idx+1) ;
         sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_142( ) ;
      }
      /* End function sendrow_142 */
   }

   public void startgridcontrol14( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"14\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         GridContainer.AddObjectProperty("Class", "FreeStyleGrid");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", sPrefix);
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV9IncludeNotification));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV14WWPNotificationDescription);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWwpnotificationdescription_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV5WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpnotificationdefinitionid_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV6WWPSubscriptionId, (byte)(10), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionid_Visible, (byte)(5), (byte)(0), ".", "")));
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
      chkavIncludenotification.setInternalname( sPrefix+"vINCLUDENOTIFICATION" );
      edtavWwpnotificationdescription_Internalname = sPrefix+"vWWPNOTIFICATIONDESCRIPTION" ;
      divTablesubscriptionitem_Internalname = sPrefix+"TABLESUBSCRIPTIONITEM" ;
      edtavWwpnotificationdefinitionid_Internalname = sPrefix+"vWWPNOTIFICATIONDEFINITIONID" ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID" ;
      tblUnnamedtablecontentfsgrid_Internalname = sPrefix+"UNNAMEDTABLECONTENTFSGRID" ;
      divUnnamedtablefsgrid_Internalname = sPrefix+"UNNAMEDTABLEFSGRID" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE1" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGrid_Allowcollapsing = (byte)(0) ;
      edtavWwpsubscriptionid_Jsonclick = "" ;
      edtavWwpsubscriptionid_Enabled = 1 ;
      edtavWwpnotificationdefinitionid_Jsonclick = "" ;
      edtavWwpnotificationdefinitionid_Enabled = 1 ;
      edtavWwpnotificationdescription_Visible = 1 ;
      edtavWwpnotificationdescription_Enabled = 1 ;
      chkavIncludenotification.setCaption( httpContext.getMessage( "Include Notification", "") );
      chkavIncludenotification.setVisible( 1 );
      chkavIncludenotification.setEnabled( 1 );
      subGrid_Class = "FreeStyleGrid" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = "" ;
      Dvpanel_unnamedtable1_Cls = "PanelNoHeader" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      edtavWwpsubscriptionid_Visible = 1 ;
      edtavWwpnotificationdefinitionid_Visible = 1 ;
      subGrid_Rows = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "vINCLUDENOTIFICATION_" + sGXsfl_14_idx ;
      chkavIncludenotification.setName( GXCCtl );
      chkavIncludenotification.setWebtags( "" );
      chkavIncludenotification.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIncludenotification.getInternalname(), "TitleCaption", chkavIncludenotification.getCaption(), !bGXsfl_14_Refreshing);
      chkavIncludenotification.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV13WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV10NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e143P2',iparms:[{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV13WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV10NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV5WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'AV14WWPNotificationDescription',fld:'vWWPNOTIFICATIONDESCRIPTION',pic:''},{av:'AV9IncludeNotification',fld:'vINCLUDENOTIFICATION',pic:''},{av:'AV6WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("TABLESUBSCRIPTIONITEM.CLICK","{handler:'e113P2',iparms:[{av:'AV9IncludeNotification',fld:'vINCLUDENOTIFICATION',grid:14,pic:''},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_14',ctrl:'GRID',grid:14,prop:'GridRC',grid:14},{av:'AV6WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',grid:14,pic:'ZZZZZZZZZ9'},{av:'AV5WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',grid:14,pic:'ZZZZZZZZZ9'},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''}]");
      setEventMetadata("TABLESUBSCRIPTIONITEM.CLICK",",oparms:[{av:'AV9IncludeNotification',fld:'vINCLUDENOTIFICATION',pic:''},{av:'AV6WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV13WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV10NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV13WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV10NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV13WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV10NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV13WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV16WWPSubscriptionRoleId',fld:'vWWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV10NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Wwpsubscriptionid',iparms:[]");
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
      wcpOAV16WWPSubscriptionRoleId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV16WWPSubscriptionRoleId = "" ;
      AV28Pgmname = "" ;
      A154WWPNotificationDefinitionDescr = "" ;
      A149WWPSubscriptionRoleId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV14WWPNotificationDescription = "" ;
      AV12WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H003P2_A35WWPNotificationDefinitionId = new long[1] ;
      H003P2_A155WWPNotificationDefinitionAppli = new byte[1] ;
      H003P2_A33WWPEntityId = new long[1] ;
      H003P2_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      AV15WWPNotificationDescriptionBase = "" ;
      H003P3_A35WWPNotificationDefinitionId = new long[1] ;
      H003P3_A149WWPSubscriptionRoleId = new String[] {""} ;
      H003P3_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      H003P3_A34WWPSubscriptionId = new long[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV11Session = httpContext.getWebSession();
      AV8GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      GXv_int2 = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV13WWPEntityId = "" ;
      sCtrlAV10NotifShowOnlySubscribedEvents = "" ;
      sCtrlAV16WWPSubscriptionRoleId = "" ;
      subGrid_Linesclass = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      subGrid_Header = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrolewc__default(),
         new Object[] {
             new Object[] {
            H003P2_A35WWPNotificationDefinitionId, H003P2_A155WWPNotificationDefinitionAppli, H003P2_A33WWPEntityId, H003P2_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            H003P3_A35WWPNotificationDefinitionId, H003P3_A149WWPSubscriptionRoleId, H003P3_n149WWPSubscriptionRoleId, H003P3_A34WWPSubscriptionId
            }
         }
      );
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsByRoleWC" ;
      /* GeneXus formulas. */
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsByRoleWC" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationdescription_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A155WWPNotificationDefinitionAppli ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV7GridRecordCount ;
   private short AV23GridPageCount ;
   private int edtavWwpnotificationdefinitionid_Visible ;
   private int edtavWwpsubscriptionid_Visible ;
   private int subGrid_Rows ;
   private int nRC_GXsfl_14 ;
   private int nGXsfl_14_idx=1 ;
   private int subGrid_Islastpage ;
   private int edtavWwpnotificationdescription_Enabled ;
   private int subGrid_Recordcount ;
   private int nGXsfl_14_fel_idx=1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavWwpnotificationdescription_Visible ;
   private int edtavWwpnotificationdefinitionid_Enabled ;
   private int edtavWwpsubscriptionid_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV13WWPEntityId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV13WWPEntityId ;
   private long A33WWPEntityId ;
   private long A35WWPNotificationDefinitionId ;
   private long A34WWPSubscriptionId ;
   private long AV5WWPNotificationDefinitionId ;
   private long AV6WWPSubscriptionId ;
   private long GRID_nCurrentRecord ;
   private long GXv_int2[] ;
   private String wcpOAV16WWPSubscriptionRoleId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV16WWPSubscriptionRoleId ;
   private String sGXsfl_14_idx="0001" ;
   private String edtavWwpnotificationdefinitionid_Internalname ;
   private String edtavWwpsubscriptionid_Internalname ;
   private String AV28Pgmname ;
   private String A149WWPSubscriptionRoleId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavWwpnotificationdescription_Internalname ;
   private String scmdbuf ;
   private String sGXsfl_14_fel_idx="0001" ;
   private String tblUnnamedtable1_Internalname ;
   private String sCtrlAV13WWPEntityId ;
   private String sCtrlAV10NotifShowOnlySubscribedEvents ;
   private String sCtrlAV16WWPSubscriptionRoleId ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String divUnnamedtablefsgrid_Internalname ;
   private String divTablesubscriptionitem_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String GXCCtl ;
   private String tblUnnamedtablecontentfsgrid_Internalname ;
   private String ROClassString ;
   private String edtavWwpnotificationdefinitionid_Jsonclick ;
   private String edtavWwpsubscriptionid_Jsonclick ;
   private String subGrid_Header ;
   private boolean wcpOAV10NotifShowOnlySubscribedEvents ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV10NotifShowOnlySubscribedEvents ;
   private boolean bGXsfl_14_Refreshing=false ;
   private boolean n149WWPSubscriptionRoleId ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV9IncludeNotification ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A154WWPNotificationDefinitionDescr ;
   private String AV14WWPNotificationDescription ;
   private String AV15WWPNotificationDescriptionBase ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private ICheckbox chkavIncludenotification ;
   private IDataStoreProvider pr_default ;
   private long[] H003P2_A35WWPNotificationDefinitionId ;
   private byte[] H003P2_A155WWPNotificationDefinitionAppli ;
   private long[] H003P2_A33WWPEntityId ;
   private String[] H003P2_A154WWPNotificationDefinitionDescr ;
   private long[] H003P3_A35WWPNotificationDefinitionId ;
   private String[] H003P3_A149WWPSubscriptionRoleId ;
   private boolean[] H003P3_n149WWPSubscriptionRoleId ;
   private long[] H003P3_A34WWPSubscriptionId ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV8GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class wwp_subscriptionssettingsbyrolewc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003P2", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionAppli], [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE ([WWPEntityId] = ?) AND ([WWPNotificationDefinitionAppli] = 1) ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003P3", "SELECT [WWPNotificationDefinitionId], [WWPSubscriptionRoleId], [WWPSubscriptionId] FROM [WWP_Subscription] WHERE ([WWPNotificationDefinitionId] = ?) AND ([WWPSubscriptionRoleId] = ?) AND (? = 1) ORDER BY [WWPNotificationDefinitionId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((long[]) buf[3])[0] = rslt.getLong(3);
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               return;
      }
   }

}

