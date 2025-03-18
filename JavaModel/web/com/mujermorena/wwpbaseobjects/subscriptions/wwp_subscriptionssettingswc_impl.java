package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_subscriptionssettingswc_impl extends GXWebComponent
{
   public wwp_subscriptionssettingswc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_subscriptionssettingswc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_subscriptionssettingswc_impl.class ));
   }

   public wwp_subscriptionssettingswc_impl( int remoteHandle ,
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
               AV16WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16WWPEntityId), 10, 0));
               AV12NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.GetPar( "NotifShowOnlySubscribedEvents")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12NotifShowOnlySubscribedEvents", AV12NotifShowOnlySubscribedEvents);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Long.valueOf(AV16WWPEntityId),Boolean.valueOf(AV12NotifShowOnlySubscribedEvents)});
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
      edtavWwpsubscriptionentityrecordid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionentityrecordid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionentityrecordid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionentityrecorddescription_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionentityrecorddescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionentityrecorddescription_Visible), 5, 0), !bGXsfl_14_Refreshing);
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
      AV32Pgmname = httpContext.GetPar( "Pgmname") ;
      edtavWwpnotificationdefinitionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdefinitionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionentityrecordid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionentityrecordid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionentityrecordid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionentityrecorddescription_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionentityrecorddescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionentityrecorddescription_Visible), 5, 0), !bGXsfl_14_Refreshing);
      A33WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
      AV16WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
      A156WWPNotificationDefinitionAllow = GXutil.strtobool( httpContext.GetPar( "WWPNotificationDefinitionAllow")) ;
      A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
      A154WWPNotificationDefinitionDescr = httpContext.GetPar( "WWPNotificationDefinitionDescr") ;
      A32WWPUserExtendedId = httpContext.GetPar( "WWPUserExtendedId") ;
      n32WWPUserExtendedId = false ;
      AV31Udparg1 = httpContext.GetPar( "Udparg1") ;
      A152WWPSubscriptionSubscribed = GXutil.strtobool( httpContext.GetPar( "WWPSubscriptionSubscribed")) ;
      A149WWPSubscriptionRoleId = httpContext.GetPar( "WWPSubscriptionRoleId") ;
      n149WWPSubscriptionRoleId = false ;
      A34WWPSubscriptionId = GXutil.lval( httpContext.GetPar( "WWPSubscriptionId")) ;
      A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionAppli"))) ;
      A151WWPSubscriptionEntityRecordId = httpContext.GetPar( "WWPSubscriptionEntityRecordId") ;
      A153WWPSubscriptionEntityRecordDes = httpContext.GetPar( "WWPSubscriptionEntityRecordDes") ;
      AV12NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.GetPar( "NotifShowOnlySubscribedEvents")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV32Pgmname, A33WWPEntityId, AV16WWPEntityId, A156WWPNotificationDefinitionAllow, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A34WWPSubscriptionId, A155WWPNotificationDefinitionAppli, A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, AV12NotifShowOnlySubscribedEvents, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa3O2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( " Subscriptions Settings", "")) ;
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
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV16WWPEntityId,10,0)),GXutil.URLEncode(GXutil.booltostr(AV12NotifShowOnlySubscribedEvents))}, new String[] {"WWPEntityId","NotifShowOnlySubscribedEvents"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV32Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUDPARG1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV31Udparg1, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_14", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_14, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV16WWPEntityId", GXutil.ltrim( localUtil.ntoc( wcpOAV16WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV12NotifShowOnlySubscribedEvents", wcpOAV12NotifShowOnlySubscribedEvents);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV32Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV32Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPENTITYID", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPENTITYID", GXutil.ltrim( localUtil.ntoc( AV16WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONALLOW", A156WWPNotificationDefinitionAllow);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONID", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONDESCR", A154WWPNotificationDefinitionDescr);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPUSEREXTENDEDID", GXutil.rtrim( A32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUDPARG1", GXutil.rtrim( AV31Udparg1));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUDPARG1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV31Udparg1, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONSUBSCRIBED", A152WWPSubscriptionSubscribed);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONROLEID", GXutil.rtrim( A149WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONID", GXutil.ltrim( localUtil.ntoc( A34WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONAPPLI", GXutil.ltrim( localUtil.ntoc( A155WWPNotificationDefinitionAppli, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONENTITYRECORDID", A151WWPSubscriptionEntityRecordId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONENTITYRECORDDES", A153WWPSubscriptionEntityRecordDes);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vNOTIFSHOWONLYSUBSCRIBEDEVENTS", AV12NotifShowOnlySubscribedEvents);
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDID_Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionentityrecordid_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION_Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionentityrecorddescription_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm3O2( )
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
      return "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Subscriptions Settings", "") ;
   }

   public void wb3O0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc");
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
         wb_table1_11_3O2( true) ;
      }
      else
      {
         wb_table1_11_3O2( false) ;
      }
      return  ;
   }

   public void wb_table1_11_3O2e( boolean wbgen )
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

   public void start3O2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( " Subscriptions Settings", ""), (short)(0)) ;
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
            strup3O0( ) ;
         }
      }
   }

   public void ws3O2( )
   {
      start3O2( ) ;
      evt3O2( ) ;
   }

   public void evt3O2( )
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
                              strup3O0( ) ;
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
                              strup3O0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e113O2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3O0( ) ;
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
                              strup3O0( ) ;
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
                              strup3O0( ) ;
                           }
                           nGXsfl_14_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_142( ) ;
                           AV11IncludeNotification = GXutil.strtobool( httpContext.cgiGet( chkavIncludenotification.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV11IncludeNotification);
                           AV17WWPNotificationDescription = httpContext.cgiGet( edtavWwpnotificationdescription_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdescription_Internalname, AV17WWPNotificationDescription);
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
                              AV7WWPSubscriptionId = 0 ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), 10, 0));
                           }
                           else
                           {
                              AV7WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), 10, 0));
                           }
                           AV19WWPSubscriptionEntityRecordId = httpContext.cgiGet( edtavWwpsubscriptionentityrecordid_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionentityrecordid_Internalname, AV19WWPSubscriptionEntityRecordId);
                           AV6WWPSubscriptionEntityRecordDescription = httpContext.cgiGet( edtavWwpsubscriptionentityrecorddescription_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionentityrecorddescription_Internalname, AV6WWPSubscriptionEntityRecordDescription);
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
                                       e123O2 ();
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
                                       e133O2 ();
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
                                       e143O2 ();
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
                                       e113O2 ();
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
                                    strup3O0( ) ;
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

   public void we3O2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3O2( ) ;
         }
      }
   }

   public void pa3O2( )
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
                                 String AV32Pgmname ,
                                 long A33WWPEntityId ,
                                 long AV16WWPEntityId ,
                                 boolean A156WWPNotificationDefinitionAllow ,
                                 long A35WWPNotificationDefinitionId ,
                                 String A154WWPNotificationDefinitionDescr ,
                                 String A32WWPUserExtendedId ,
                                 String AV31Udparg1 ,
                                 boolean A152WWPSubscriptionSubscribed ,
                                 String A149WWPSubscriptionRoleId ,
                                 long A34WWPSubscriptionId ,
                                 byte A155WWPNotificationDefinitionAppli ,
                                 String A151WWPSubscriptionEntityRecordId ,
                                 String A153WWPSubscriptionEntityRecordDes ,
                                 boolean AV12NotifShowOnlySubscribedEvents ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e133O2 ();
      GRID_nCurrentRecord = 0 ;
      rf3O2( ) ;
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
      rf3O2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV32Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsWC" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdescription_Enabled), 5, 0), !bGXsfl_14_Refreshing);
   }

   public void rf3O2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(14) ;
      /* Execute user event: Refresh */
      e133O2 ();
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
         e143O2 ();
         wbEnd = (short)(14) ;
         wb3O0( ) ;
      }
      bGXsfl_14_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes3O2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV32Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV32Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUDPARG1", GXutil.rtrim( AV31Udparg1));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUDPARG1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV31Udparg1, ""))));
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
         gxgrgrid_refresh( subGrid_Rows, AV32Pgmname, A33WWPEntityId, AV16WWPEntityId, A156WWPNotificationDefinitionAllow, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A34WWPSubscriptionId, A155WWPNotificationDefinitionAppli, A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, AV12NotifShowOnlySubscribedEvents, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV32Pgmname, A33WWPEntityId, AV16WWPEntityId, A156WWPNotificationDefinitionAllow, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A34WWPSubscriptionId, A155WWPNotificationDefinitionAppli, A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, AV12NotifShowOnlySubscribedEvents, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV32Pgmname, A33WWPEntityId, AV16WWPEntityId, A156WWPNotificationDefinitionAllow, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A34WWPSubscriptionId, A155WWPNotificationDefinitionAppli, A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, AV12NotifShowOnlySubscribedEvents, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV32Pgmname, A33WWPEntityId, AV16WWPEntityId, A156WWPNotificationDefinitionAllow, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A34WWPSubscriptionId, A155WWPNotificationDefinitionAppli, A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, AV12NotifShowOnlySubscribedEvents, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV32Pgmname, A33WWPEntityId, AV16WWPEntityId, A156WWPNotificationDefinitionAllow, A35WWPNotificationDefinitionId, A154WWPNotificationDefinitionDescr, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, A34WWPSubscriptionId, A155WWPNotificationDefinitionAppli, A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, AV12NotifShowOnlySubscribedEvents, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV32Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsWC" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdescription_Enabled), 5, 0), !bGXsfl_14_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup3O0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e123O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_14 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_14"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV16WWPEntityId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV16WWPEntityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         wcpOAV12NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV12NotifShowOnlySubscribedEvents")) ;
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
      e123O2 ();
      if (returnInSub) return;
   }

   public void e123O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavWwpnotificationdefinitionid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationdefinitionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionentityrecordid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionentityrecordid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionentityrecordid_Visible), 5, 0), !bGXsfl_14_Refreshing);
      edtavWwpsubscriptionentityrecorddescription_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionentityrecorddescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionentityrecorddescription_Visible), 5, 0), !bGXsfl_14_Refreshing);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S112 ();
      if (returnInSub) return;
   }

   public void e133O2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV15WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV15WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
   }

   private void e143O2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      GXt_objcol_char2 = AV20WWPSubscriptionRoleIdCollection ;
      GXv_objcol_char3[0] = GXt_objcol_char2 ;
      new com.mujermorena.wwpbaseobjects.wwp_getloggeduserroles(remoteHandle, context).execute( GXv_objcol_char3) ;
      GXt_objcol_char2 = GXv_objcol_char3[0] ;
      AV20WWPSubscriptionRoleIdCollection = GXt_objcol_char2 ;
      AV9GridRecordCount = (short)(0) ;
      /* Using cursor H003O2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV16WWPEntityId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A35WWPNotificationDefinitionId = H003O2_A35WWPNotificationDefinitionId[0] ;
         A155WWPNotificationDefinitionAppli = H003O2_A155WWPNotificationDefinitionAppli[0] ;
         A156WWPNotificationDefinitionAllow = H003O2_A156WWPNotificationDefinitionAllow[0] ;
         A33WWPEntityId = H003O2_A33WWPEntityId[0] ;
         A154WWPNotificationDefinitionDescr = H003O2_A154WWPNotificationDefinitionDescr[0] ;
         AV5WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdefinitionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5WWPNotificationDefinitionId), 10, 0));
         AV18WWPNotificationDescriptionBase = A154WWPNotificationDefinitionDescr ;
         AV17WWPNotificationDescription = AV18WWPNotificationDescriptionBase ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdescription_Internalname, AV17WWPNotificationDescription);
         AV11IncludeNotification = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV11IncludeNotification);
         AV14SubscriptionLoaded = false ;
         AV7WWPSubscriptionId = 0 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), 10, 0));
         AV31Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              A149WWPSubscriptionRoleId ,
                                              AV20WWPSubscriptionRoleIdCollection ,
                                              A32WWPUserExtendedId ,
                                              AV31Udparg1 ,
                                              Boolean.valueOf(A152WWPSubscriptionSubscribed) ,
                                              Long.valueOf(A35WWPNotificationDefinitionId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.LONG
                                              }
         });
         /* Using cursor H003O3 */
         pr_default.execute(1, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId), AV31Udparg1});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A149WWPSubscriptionRoleId = H003O3_A149WWPSubscriptionRoleId[0] ;
            n149WWPSubscriptionRoleId = H003O3_n149WWPSubscriptionRoleId[0] ;
            A152WWPSubscriptionSubscribed = H003O3_A152WWPSubscriptionSubscribed[0] ;
            A32WWPUserExtendedId = H003O3_A32WWPUserExtendedId[0] ;
            n32WWPUserExtendedId = H003O3_n32WWPUserExtendedId[0] ;
            A34WWPSubscriptionId = H003O3_A34WWPSubscriptionId[0] ;
            A151WWPSubscriptionEntityRecordId = H003O3_A151WWPSubscriptionEntityRecordId[0] ;
            A153WWPSubscriptionEntityRecordDes = H003O3_A153WWPSubscriptionEntityRecordDes[0] ;
            AV7WWPSubscriptionId = A34WWPSubscriptionId ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), 10, 0));
            if ( A155WWPNotificationDefinitionAppli != 1 )
            {
               if ( GXutil.strcmp(A151WWPSubscriptionEntityRecordId, "") != 0 )
               {
                  AV6WWPSubscriptionEntityRecordDescription = A153WWPSubscriptionEntityRecordDes ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionentityrecorddescription_Internalname, AV6WWPSubscriptionEntityRecordDescription);
                  AV19WWPSubscriptionEntityRecordId = A151WWPSubscriptionEntityRecordId ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionentityrecordid_Internalname, AV19WWPSubscriptionEntityRecordId);
                  AV17WWPNotificationDescription = GXutil.format( "%1 (%2)", AV18WWPNotificationDescriptionBase, AV6WWPSubscriptionEntityRecordDescription, "", "", "", "", "", "", "") ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpnotificationdescription_Internalname, AV17WWPNotificationDescription);
                  AV9GridRecordCount = (short)(AV9GridRecordCount+1) ;
                  AV11IncludeNotification = true ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV11IncludeNotification);
                  AV14SubscriptionLoaded = true ;
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
            }
            else
            {
               AV9GridRecordCount = (short)(AV9GridRecordCount+1) ;
               AV11IncludeNotification = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV11IncludeNotification);
               if ( ! (GXutil.strcmp("", A149WWPSubscriptionRoleId)==0) )
               {
                  GXt_boolean4 = AV11IncludeNotification ;
                  GXv_int5[0] = AV7WWPSubscriptionId ;
                  GXv_boolean6[0] = GXt_boolean4 ;
                  new com.mujermorena.wwpbaseobjects.subscriptions.wwp_checkuserisnotunsubscribed(remoteHandle, context).execute( AV5WWPNotificationDefinitionId, GXv_int5, GXv_boolean6) ;
                  wwp_subscriptionssettingswc_impl.this.AV7WWPSubscriptionId = GXv_int5[0] ;
                  wwp_subscriptionssettingswc_impl.this.GXt_boolean4 = GXv_boolean6[0] ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), 10, 0));
                  AV11IncludeNotification = GXt_boolean4 ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV11IncludeNotification);
               }
               if ( ! AV14SubscriptionLoaded )
               {
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
               AV14SubscriptionLoaded = true ;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( ! AV14SubscriptionLoaded && ! AV11IncludeNotification && ( A155WWPNotificationDefinitionAppli != 2 ) && ! AV12NotifShowOnlySubscribedEvents )
         {
            AV9GridRecordCount = (short)(AV9GridRecordCount+1) ;
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
      AV8GridPageCount = (short)(AV9GridRecordCount/ (double) (subGrid_Rows)+((((int)((AV9GridRecordCount) % (subGrid_Rows)))>0) ? 1 : 0)) ;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV13Session.getValue(AV32Pgmname+"GridState"), "") == 0 )
      {
         AV10GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV32Pgmname+"GridState"), null, null);
      }
      else
      {
         AV10GridState.fromxml(AV13Session.getValue(AV32Pgmname+"GridState"), null, null);
      }
      if ( ! (GXutil.strcmp("", GXutil.trim( AV10GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV10GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV10GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S122( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV10GridState.fromxml(AV13Session.getValue(AV32Pgmname+"GridState"), null, null);
      AV10GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV10GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV32Pgmname+"GridState", AV10GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e113O2( )
   {
      /* Tablesubscriptionitem_Click Routine */
      returnInSub = false ;
      AV11IncludeNotification = (boolean)(!AV11IncludeNotification) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV11IncludeNotification);
      GXv_int5[0] = AV7WWPSubscriptionId ;
      new com.mujermorena.wwpbaseobjects.subscriptions.wwp_userupdatesubscription(remoteHandle, context).execute( AV11IncludeNotification, GXv_int5, AV5WWPNotificationDefinitionId, AV19WWPSubscriptionEntityRecordId, AV6WWPSubscriptionEntityRecordDescription) ;
      wwp_subscriptionssettingswc_impl.this.AV7WWPSubscriptionId = GXv_int5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), 10, 0));
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
            AV11IncludeNotification = GXutil.strtobool( httpContext.cgiGet( chkavIncludenotification.getInternalname())) ;
            AV17WWPNotificationDescription = httpContext.cgiGet( edtavWwpnotificationdescription_Internalname) ;
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
               AV7WWPSubscriptionId = 0 ;
            }
            else
            {
               AV7WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            }
            AV19WWPSubscriptionEntityRecordId = httpContext.cgiGet( edtavWwpsubscriptionentityrecordid_Internalname) ;
            AV6WWPSubscriptionEntityRecordDescription = httpContext.cgiGet( edtavWwpsubscriptionentityrecorddescription_Internalname) ;
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

   public void wb_table1_11_3O2( boolean wbgen )
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
         wb_table1_11_3O2e( true) ;
      }
      else
      {
         wb_table1_11_3O2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV16WWPEntityId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16WWPEntityId), 10, 0));
      AV12NotifShowOnlySubscribedEvents = ((Boolean) getParm(obj,1,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12NotifShowOnlySubscribedEvents", AV12NotifShowOnlySubscribedEvents);
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
      pa3O2( ) ;
      ws3O2( ) ;
      we3O2( ) ;
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
      sCtrlAV16WWPEntityId = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV12NotifShowOnlySubscribedEvents = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3O2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\subscriptions\\wwp_subscriptionssettingswc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3O2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV16WWPEntityId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16WWPEntityId), 10, 0));
         AV12NotifShowOnlySubscribedEvents = ((Boolean) getParm(obj,3,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12NotifShowOnlySubscribedEvents", AV12NotifShowOnlySubscribedEvents);
      }
      wcpOAV16WWPEntityId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV16WWPEntityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      wcpOAV12NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV12NotifShowOnlySubscribedEvents")) ;
      if ( ! GetJustCreated( ) && ( ( AV16WWPEntityId != wcpOAV16WWPEntityId ) || ( AV12NotifShowOnlySubscribedEvents != wcpOAV12NotifShowOnlySubscribedEvents ) ) )
      {
         setjustcreated();
      }
      wcpOAV16WWPEntityId = AV16WWPEntityId ;
      wcpOAV12NotifShowOnlySubscribedEvents = AV12NotifShowOnlySubscribedEvents ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV16WWPEntityId = httpContext.cgiGet( sPrefix+"AV16WWPEntityId_CTRL") ;
      if ( GXutil.len( sCtrlAV16WWPEntityId) > 0 )
      {
         AV16WWPEntityId = localUtil.ctol( httpContext.cgiGet( sCtrlAV16WWPEntityId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16WWPEntityId), 10, 0));
      }
      else
      {
         AV16WWPEntityId = localUtil.ctol( httpContext.cgiGet( sPrefix+"AV16WWPEntityId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      sCtrlAV12NotifShowOnlySubscribedEvents = httpContext.cgiGet( sPrefix+"AV12NotifShowOnlySubscribedEvents_CTRL") ;
      if ( GXutil.len( sCtrlAV12NotifShowOnlySubscribedEvents) > 0 )
      {
         AV12NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sCtrlAV12NotifShowOnlySubscribedEvents)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12NotifShowOnlySubscribedEvents", AV12NotifShowOnlySubscribedEvents);
      }
      else
      {
         AV12NotifShowOnlySubscribedEvents = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV12NotifShowOnlySubscribedEvents_PARM")) ;
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
      pa3O2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3O2( ) ;
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
      ws3O2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16WWPEntityId_PARM", GXutil.ltrim( localUtil.ntoc( AV16WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV16WWPEntityId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16WWPEntityId_CTRL", GXutil.rtrim( sCtrlAV16WWPEntityId));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV12NotifShowOnlySubscribedEvents_PARM", GXutil.booltostr( AV12NotifShowOnlySubscribedEvents));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV12NotifShowOnlySubscribedEvents)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV12NotifShowOnlySubscribedEvents_CTRL", GXutil.rtrim( sCtrlAV12NotifShowOnlySubscribedEvents));
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
      we3O2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211162470", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/subscriptions/wwp_subscriptionssettingswc.js", "?20241211162470", false, true);
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
      edtavWwpsubscriptionentityrecordid_Internalname = sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDID_"+sGXsfl_14_idx ;
      edtavWwpsubscriptionentityrecorddescription_Internalname = sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION_"+sGXsfl_14_idx ;
   }

   public void subsflControlProps_fel_142( )
   {
      chkavIncludenotification.setInternalname( sPrefix+"vINCLUDENOTIFICATION_"+sGXsfl_14_fel_idx );
      edtavWwpnotificationdescription_Internalname = sPrefix+"vWWPNOTIFICATIONDESCRIPTION_"+sGXsfl_14_fel_idx ;
      edtavWwpnotificationdefinitionid_Internalname = sPrefix+"vWWPNOTIFICATIONDEFINITIONID_"+sGXsfl_14_fel_idx ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID_"+sGXsfl_14_fel_idx ;
      edtavWwpsubscriptionentityrecordid_Internalname = sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDID_"+sGXsfl_14_fel_idx ;
      edtavWwpsubscriptionentityrecorddescription_Internalname = sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION_"+sGXsfl_14_fel_idx ;
   }

   public void sendrow_142( )
   {
      subsflControlProps_142( ) ;
      wb3O0( ) ;
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
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIncludenotification.getInternalname(),GXutil.booltostr( AV11IncludeNotification),"",httpContext.getMessage( "Include Notification", ""),Integer.valueOf(1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(21, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+((chkavIncludenotification.getEnabled()!=0)&&(chkavIncludenotification.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,21);\"" : " ")});
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
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationdescription_Internalname,AV17WWPNotificationDescription,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavWwpnotificationdescription_Enabled!=0)&&(edtavWwpnotificationdescription_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,24);\"" : " "),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavWwpnotificationdescription_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionid_Internalname,GXutil.ltrim( localUtil.ntoc( AV7WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7WWPSubscriptionId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavWwpsubscriptionid_Enabled!=0)&&(edtavWwpsubscriptionid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWwpsubscriptionid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavWwpsubscriptionid_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionentityrecordid_Internalname,httpContext.getMessage( "WWPSubscription Entity Record Id", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Multiple line edit */
         TempTags = " " + ((edtavWwpsubscriptionentityrecordid_Enabled!=0)&&(edtavWwpsubscriptionentityrecordid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 37,'"+sPrefix+"',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionentityrecordid_Internalname,AV19WWPSubscriptionEntityRecordId,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavWwpsubscriptionentityrecordid_Enabled!=0)&&(edtavWwpsubscriptionentityrecordid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,37);\"" : " "),Integer.valueOf(0),Integer.valueOf(edtavWwpsubscriptionentityrecordid_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",Integer.valueOf(0),StyleString,ClassString,"","","2000",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionentityrecorddescription_Internalname,httpContext.getMessage( "WWPSubscription Entity Record Description", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Multiple line edit */
         TempTags = " " + ((edtavWwpsubscriptionentityrecorddescription_Enabled!=0)&&(edtavWwpsubscriptionentityrecorddescription_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 40,'"+sPrefix+"',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionentityrecorddescription_Internalname,AV6WWPSubscriptionEntityRecordDescription,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavWwpsubscriptionentityrecorddescription_Enabled!=0)&&(edtavWwpsubscriptionentityrecorddescription_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,40);\"" : " "),Integer.valueOf(0),Integer.valueOf(edtavWwpsubscriptionentityrecorddescription_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
         send_integrity_lvl_hashes3O2( ) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV11IncludeNotification));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV17WWPNotificationDescription);
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV7WWPSubscriptionId, (byte)(10), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionid_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV19WWPSubscriptionEntityRecordId);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionentityrecordid_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV6WWPSubscriptionEntityRecordDescription);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionentityrecorddescription_Visible, (byte)(5), (byte)(0), ".", "")));
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
      edtavWwpsubscriptionentityrecordid_Internalname = sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDID" ;
      edtavWwpsubscriptionentityrecorddescription_Internalname = sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION" ;
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
      edtavWwpsubscriptionentityrecorddescription_Enabled = 1 ;
      edtavWwpsubscriptionentityrecordid_Enabled = 1 ;
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
      edtavWwpsubscriptionentityrecorddescription_Visible = 1 ;
      edtavWwpsubscriptionentityrecordid_Visible = 1 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecordid_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecorddescription_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'AV12NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e143O2',iparms:[{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'AV12NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV5WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'AV17WWPNotificationDescription',fld:'vWWPNOTIFICATIONDESCRIPTION',pic:''},{av:'AV11IncludeNotification',fld:'vINCLUDENOTIFICATION',pic:''},{av:'AV7WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV6WWPSubscriptionEntityRecordDescription',fld:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',pic:''},{av:'AV19WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''}]}");
      setEventMetadata("TABLESUBSCRIPTIONITEM.CLICK","{handler:'e113O2',iparms:[{av:'AV11IncludeNotification',fld:'vINCLUDENOTIFICATION',grid:14,pic:''},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_14',ctrl:'GRID',grid:14,prop:'GridRC',grid:14},{av:'AV7WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',grid:14,pic:'ZZZZZZZZZ9'},{av:'AV5WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',grid:14,pic:'ZZZZZZZZZ9'},{av:'AV19WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',grid:14,pic:''},{av:'AV6WWPSubscriptionEntityRecordDescription',fld:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',grid:14,pic:''}]");
      setEventMetadata("TABLESUBSCRIPTIONITEM.CLICK",",oparms:[{av:'AV11IncludeNotification',fld:'vINCLUDENOTIFICATION',pic:''},{av:'AV7WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecordid_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecorddescription_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'AV12NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecordid_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecorddescription_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'AV12NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecordid_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecorddescription_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'AV12NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavWwpnotificationdefinitionid_Visible',ctrl:'vWWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecordid_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDID',prop:'Visible'},{av:'edtavWwpsubscriptionentityrecorddescription_Visible',ctrl:'vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION',prop:'Visible'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV16WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'AV12NotifShowOnlySubscribedEvents',fld:'vNOTIFSHOWONLYSUBSCRIBEDEVENTS',pic:''},{av:'sPrefix'},{av:'AV32Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Wwpsubscriptionentityrecorddescription',iparms:[]");
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
      sPrefix = "" ;
      AV32Pgmname = "" ;
      A154WWPNotificationDefinitionDescr = "" ;
      A32WWPUserExtendedId = "" ;
      AV31Udparg1 = "" ;
      A149WWPSubscriptionRoleId = "" ;
      A151WWPSubscriptionEntityRecordId = "" ;
      A153WWPSubscriptionEntityRecordDes = "" ;
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
      AV17WWPNotificationDescription = "" ;
      AV19WWPSubscriptionEntityRecordId = "" ;
      AV6WWPSubscriptionEntityRecordDescription = "" ;
      AV15WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV20WWPSubscriptionRoleIdCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_objcol_char2 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char3 = new GXSimpleCollection[1] ;
      scmdbuf = "" ;
      H003O2_A35WWPNotificationDefinitionId = new long[1] ;
      H003O2_A155WWPNotificationDefinitionAppli = new byte[1] ;
      H003O2_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      H003O2_A33WWPEntityId = new long[1] ;
      H003O2_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      AV18WWPNotificationDescriptionBase = "" ;
      H003O3_A35WWPNotificationDefinitionId = new long[1] ;
      H003O3_A149WWPSubscriptionRoleId = new String[] {""} ;
      H003O3_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      H003O3_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      H003O3_A32WWPUserExtendedId = new String[] {""} ;
      H003O3_n32WWPUserExtendedId = new boolean[] {false} ;
      H003O3_A34WWPSubscriptionId = new long[1] ;
      H003O3_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      H003O3_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_boolean6 = new boolean[1] ;
      AV13Session = httpContext.getWebSession();
      AV10GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      GXv_int5 = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV16WWPEntityId = "" ;
      sCtrlAV12NotifShowOnlySubscribedEvents = "" ;
      subGrid_Linesclass = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      subGrid_Header = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc__default(),
         new Object[] {
             new Object[] {
            H003O2_A35WWPNotificationDefinitionId, H003O2_A155WWPNotificationDefinitionAppli, H003O2_A156WWPNotificationDefinitionAllow, H003O2_A33WWPEntityId, H003O2_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            H003O3_A35WWPNotificationDefinitionId, H003O3_A149WWPSubscriptionRoleId, H003O3_n149WWPSubscriptionRoleId, H003O3_A152WWPSubscriptionSubscribed, H003O3_A32WWPUserExtendedId, H003O3_n32WWPUserExtendedId, H003O3_A34WWPSubscriptionId, H003O3_A151WWPSubscriptionEntityRecordId, H003O3_A153WWPSubscriptionEntityRecordDes
            }
         }
      );
      AV32Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsWC" ;
      /* GeneXus formulas. */
      AV32Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettingsWC" ;
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
   private short AV9GridRecordCount ;
   private short AV8GridPageCount ;
   private int edtavWwpnotificationdefinitionid_Visible ;
   private int edtavWwpsubscriptionid_Visible ;
   private int edtavWwpsubscriptionentityrecordid_Visible ;
   private int edtavWwpsubscriptionentityrecorddescription_Visible ;
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
   private int edtavWwpsubscriptionentityrecordid_Enabled ;
   private int edtavWwpsubscriptionentityrecorddescription_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV16WWPEntityId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV16WWPEntityId ;
   private long A33WWPEntityId ;
   private long A35WWPNotificationDefinitionId ;
   private long A34WWPSubscriptionId ;
   private long AV5WWPNotificationDefinitionId ;
   private long AV7WWPSubscriptionId ;
   private long GRID_nCurrentRecord ;
   private long GXv_int5[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_14_idx="0001" ;
   private String edtavWwpnotificationdefinitionid_Internalname ;
   private String edtavWwpsubscriptionid_Internalname ;
   private String edtavWwpsubscriptionentityrecordid_Internalname ;
   private String edtavWwpsubscriptionentityrecorddescription_Internalname ;
   private String AV32Pgmname ;
   private String A32WWPUserExtendedId ;
   private String AV31Udparg1 ;
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
   private String sCtrlAV16WWPEntityId ;
   private String sCtrlAV12NotifShowOnlySubscribedEvents ;
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
   private boolean wcpOAV12NotifShowOnlySubscribedEvents ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV12NotifShowOnlySubscribedEvents ;
   private boolean bGXsfl_14_Refreshing=false ;
   private boolean A156WWPNotificationDefinitionAllow ;
   private boolean n32WWPUserExtendedId ;
   private boolean A152WWPSubscriptionSubscribed ;
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
   private boolean AV11IncludeNotification ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV14SubscriptionLoaded ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean6[] ;
   private String A154WWPNotificationDefinitionDescr ;
   private String A151WWPSubscriptionEntityRecordId ;
   private String A153WWPSubscriptionEntityRecordDes ;
   private String AV17WWPNotificationDescription ;
   private String AV19WWPSubscriptionEntityRecordId ;
   private String AV6WWPSubscriptionEntityRecordDescription ;
   private String AV18WWPNotificationDescriptionBase ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV13Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private ICheckbox chkavIncludenotification ;
   private IDataStoreProvider pr_default ;
   private long[] H003O2_A35WWPNotificationDefinitionId ;
   private byte[] H003O2_A155WWPNotificationDefinitionAppli ;
   private boolean[] H003O2_A156WWPNotificationDefinitionAllow ;
   private long[] H003O2_A33WWPEntityId ;
   private String[] H003O2_A154WWPNotificationDefinitionDescr ;
   private long[] H003O3_A35WWPNotificationDefinitionId ;
   private String[] H003O3_A149WWPSubscriptionRoleId ;
   private boolean[] H003O3_n149WWPSubscriptionRoleId ;
   private boolean[] H003O3_A152WWPSubscriptionSubscribed ;
   private String[] H003O3_A32WWPUserExtendedId ;
   private boolean[] H003O3_n32WWPUserExtendedId ;
   private long[] H003O3_A34WWPSubscriptionId ;
   private String[] H003O3_A151WWPSubscriptionEntityRecordId ;
   private String[] H003O3_A153WWPSubscriptionEntityRecordDes ;
   private GXSimpleCollection<String> AV20WWPSubscriptionRoleIdCollection ;
   private GXSimpleCollection<String> GXt_objcol_char2 ;
   private GXSimpleCollection<String> GXv_objcol_char3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV10GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class wwp_subscriptionssettingswc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H003O3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A149WWPSubscriptionRoleId ,
                                          GXSimpleCollection<String> AV20WWPSubscriptionRoleIdCollection ,
                                          String A32WWPUserExtendedId ,
                                          String AV31Udparg1 ,
                                          boolean A152WWPSubscriptionSubscribed ,
                                          long A35WWPNotificationDefinitionId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[2];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [WWPNotificationDefinitionId], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPUserExtendedId], [WWPSubscriptionId], [WWPSubscriptionEntityRecordId]," ;
      scmdbuf += " [WWPSubscriptionEntityRecordDes] FROM [WWP_Subscription]" ;
      addWhere(sWhereString, "([WWPNotificationDefinitionId] = ?)");
      addWhere(sWhereString, "(( [WWPUserExtendedId] = ? and [WWPSubscriptionSubscribed] = 1) or "+GXutil.toValueList("sqlserver", AV20WWPSubscriptionRoleIdCollection, "[WWPSubscriptionRoleId] IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [WWPNotificationDefinitionId]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_H003O3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Boolean) dynConstraints[4]).booleanValue() , ((Number) dynConstraints[5]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003O2", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE ([WWPEntityId] = ?) AND ([WWPNotificationDefinitionAllow] = 1) ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003O3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 1 :
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

