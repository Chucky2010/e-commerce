package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_subscriptionspanel_impl extends GXWebComponent
{
   public wwp_subscriptionspanel_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_subscriptionspanel_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_subscriptionspanel_impl.class ));
   }

   public wwp_subscriptionspanel_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "WWPEntityName") ;
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
               AV6WWPEntityName = httpContext.GetPar( "WWPEntityName") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WWPEntityName", AV6WWPEntityName);
               AV7WWPNotificationAppliesTo = (byte)(GXutil.lval( httpContext.GetPar( "WWPNotificationAppliesTo"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7WWPNotificationAppliesTo", GXutil.str( AV7WWPNotificationAppliesTo, 1, 0));
               AV20WWPSubscriptionEntityRecordId = httpContext.GetPar( "WWPSubscriptionEntityRecordId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20WWPSubscriptionEntityRecordId", AV20WWPSubscriptionEntityRecordId);
               AV14RecordAttDescription = httpContext.GetPar( "RecordAttDescription") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14RecordAttDescription", AV14RecordAttDescription);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV6WWPEntityName,Byte.valueOf(AV7WWPNotificationAppliesTo),AV20WWPSubscriptionEntityRecordId,AV14RecordAttDescription});
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
               gxfirstwebparm = httpContext.GetFirstPar( "WWPEntityName") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WWPEntityName") ;
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
      nRC_GXsfl_9 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_9"))) ;
      nGXsfl_9_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_9_idx"))) ;
      sGXsfl_9_idx = httpContext.GetPar( "sGXsfl_9_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      edtWWPNotificationDefinitionId_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtWWPNotificationDefinitionId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionId_Visible), 5, 0), !bGXsfl_9_Refreshing);
      edtavWwpsubscriptionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_9_Refreshing);
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
      AV5WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
      AV7WWPNotificationAppliesTo = (byte)(GXutil.lval( httpContext.GetPar( "WWPNotificationAppliesTo"))) ;
      AV28Pgmname = httpContext.GetPar( "Pgmname") ;
      edtWWPNotificationDefinitionId_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtWWPNotificationDefinitionId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionId_Visible), 5, 0), !bGXsfl_9_Refreshing);
      edtavWwpsubscriptionid_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_9_Refreshing);
      A32WWPUserExtendedId = httpContext.GetPar( "WWPUserExtendedId") ;
      n32WWPUserExtendedId = false ;
      AV31Udparg1 = httpContext.GetPar( "Udparg1") ;
      A152WWPSubscriptionSubscribed = GXutil.strtobool( httpContext.GetPar( "WWPSubscriptionSubscribed")) ;
      A149WWPSubscriptionRoleId = httpContext.GetPar( "WWPSubscriptionRoleId") ;
      n149WWPSubscriptionRoleId = false ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23WWPSubscriptionRoleIdCollection);
      AV8WWPNotificationId = GXutil.lval( httpContext.GetPar( "WWPNotificationId")) ;
      A151WWPSubscriptionEntityRecordId = httpContext.GetPar( "WWPSubscriptionEntityRecordId") ;
      AV20WWPSubscriptionEntityRecordId = httpContext.GetPar( "WWPSubscriptionEntityRecordId") ;
      A34WWPSubscriptionId = GXutil.lval( httpContext.GetPar( "WWPSubscriptionId")) ;
      AV24WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV5WWPEntityId, AV7WWPNotificationAppliesTo, AV28Pgmname, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, AV23WWPSubscriptionRoleIdCollection, AV8WWPNotificationId, A151WWPSubscriptionEntityRecordId, AV20WWPSubscriptionEntityRecordId, A34WWPSubscriptionId, AV24WWPNotificationDefinitionId, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa3Q2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Subscriptions of an Entity/Record", "")) ;
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
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionspanel", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6WWPEntityName)),GXutil.URLEncode(GXutil.ltrimstr(AV7WWPNotificationAppliesTo,1,0)),GXutil.URLEncode(GXutil.rtrim(AV20WWPSubscriptionEntityRecordId)),GXutil.URLEncode(GXutil.rtrim(AV14RecordAttDescription))}, new String[] {"WWPEntityName","WWPNotificationAppliesTo","WWPSubscriptionEntityRecordId","RecordAttDescription"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUDPARG1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV31Udparg1, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPSUBSCRIPTIONROLEIDCOLLECTION", getSecureSignedToken( sPrefix, AV23WWPSubscriptionRoleIdCollection));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV8WWPNotificationId), "ZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONDEFINITIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV24WWPNotificationDefinitionId), "ZZZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_9", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_9, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6WWPEntityName", wcpOAV6WWPEntityName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7WWPNotificationAppliesTo", GXutil.ltrim( localUtil.ntoc( wcpOAV7WWPNotificationAppliesTo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV20WWPSubscriptionEntityRecordId", wcpOAV20WWPSubscriptionEntityRecordId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV14RecordAttDescription", wcpOAV14RecordAttDescription);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV28Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPUSEREXTENDEDID", GXutil.rtrim( A32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUDPARG1", GXutil.rtrim( AV31Udparg1));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUDPARG1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV31Udparg1, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONSUBSCRIBED", A152WWPSubscriptionSubscribed);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONROLEID", GXutil.rtrim( A149WWPSubscriptionRoleId));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWPSUBSCRIPTIONROLEIDCOLLECTION", AV23WWPSubscriptionRoleIdCollection);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWPSUBSCRIPTIONROLEIDCOLLECTION", AV23WWPSubscriptionRoleIdCollection);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPSUBSCRIPTIONROLEIDCOLLECTION", getSecureSignedToken( sPrefix, AV23WWPSubscriptionRoleIdCollection));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPNOTIFICATIONID", GXutil.ltrim( localUtil.ntoc( AV8WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV8WWPNotificationId), "ZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONENTITYRECORDID", A151WWPSubscriptionEntityRecordId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPSUBSCRIPTIONENTITYRECORDID", AV20WWPSubscriptionEntityRecordId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPSUBSCRIPTIONID", GXutil.ltrim( localUtil.ntoc( A34WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPNOTIFICATIONDEFINITIONID", GXutil.ltrim( localUtil.ntoc( AV24WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONDEFINITIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV24WWPNotificationDefinitionId), "ZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vRECORDATTDESCRIPTION", AV14RecordAttDescription);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPENTITYNAME", AV6WWPEntityName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPNOTIFICATIONAPPLIESTO", GXutil.ltrim( localUtil.ntoc( AV7WWPNotificationAppliesTo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPENTITYID", GXutil.ltrim( localUtil.ntoc( AV5WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONSECFU", A189WWPNotificationDefinitionSecFu);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONISAUT", A190WWPNotificationDefinitionIsAut);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"WWPNOTIFICATIONDEFINITIONID_Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationDefinitionId_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPSUBSCRIPTIONID_Visible", GXutil.ltrim( localUtil.ntoc( edtavWwpsubscriptionid_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm3Q2( )
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
      return "WWPBaseObjects.Subscriptions.WWP_SubscriptionsPanel" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Subscriptions of an Entity/Record", "") ;
   }

   public void wb3Q0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionspanel");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainSubscriptions", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SubscriptionsPanelCell", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol9( ) ;
      }
      if ( wbEnd == 9 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_9 = (int)(nGXsfl_9_idx-1) ;
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

   public void start3Q2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Subscriptions of an Entity/Record", ""), (short)(0)) ;
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
            strup3Q0( ) ;
         }
      }
   }

   public void ws3Q2( )
   {
      start3Q2( ) ;
      evt3Q2( ) ;
   }

   public void evt3Q2( )
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
                              strup3Q0( ) ;
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
                              strup3Q0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e113Q2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3Q0( ) ;
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
                              strup3Q0( ) ;
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
                              strup3Q0( ) ;
                           }
                           nGXsfl_9_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_92( ) ;
                           AV12IncludeNotification = GXutil.strtobool( httpContext.cgiGet( chkavIncludenotification.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV12IncludeNotification);
                           A154WWPNotificationDefinitionDescr = httpContext.cgiGet( edtWWPNotificationDefinitionDescr_Internalname) ;
                           A35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( edtWWPNotificationDefinitionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPSUBSCRIPTIONID");
                              GX_FocusControl = edtavWwpsubscriptionid_Internalname ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV22WWPSubscriptionId = 0 ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22WWPSubscriptionId), 10, 0));
                           }
                           else
                           {
                              AV22WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22WWPSubscriptionId), 10, 0));
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
                                       e123Q2 ();
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
                                       e133Q2 ();
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
                                       e143Q2 ();
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
                                       e113Q2 ();
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
                                    strup3Q0( ) ;
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

   public void we3Q2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3Q2( ) ;
         }
      }
   }

   public void pa3Q2( )
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
      subsflControlProps_92( ) ;
      while ( nGXsfl_9_idx <= nRC_GXsfl_9 )
      {
         sendrow_92( ) ;
         nGXsfl_9_idx = ((subGrid_Islastpage==1)&&(nGXsfl_9_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
         sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_92( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 long AV5WWPEntityId ,
                                 byte AV7WWPNotificationAppliesTo ,
                                 String AV28Pgmname ,
                                 String A32WWPUserExtendedId ,
                                 String AV31Udparg1 ,
                                 boolean A152WWPSubscriptionSubscribed ,
                                 String A149WWPSubscriptionRoleId ,
                                 GXSimpleCollection<String> AV23WWPSubscriptionRoleIdCollection ,
                                 long AV8WWPNotificationId ,
                                 String A151WWPSubscriptionEntityRecordId ,
                                 String AV20WWPSubscriptionEntityRecordId ,
                                 long A34WWPSubscriptionId ,
                                 long AV24WWPNotificationDefinitionId ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e133Q2 ();
      GRID_nCurrentRecord = 0 ;
      rf3Q2( ) ;
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
      rf3Q2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsPanel" ;
      Gx_err = (short)(0) ;
   }

   public int subgridclient_rec_count_fnc( )
   {
      GRID_nRecordCount = 0 ;
      /* Using cursor H003Q2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV5WWPEntityId), Byte.valueOf(AV7WWPNotificationAppliesTo)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A156WWPNotificationDefinitionAllow = H003Q2_A156WWPNotificationDefinitionAllow[0] ;
         A155WWPNotificationDefinitionAppli = H003Q2_A155WWPNotificationDefinitionAppli[0] ;
         A33WWPEntityId = H003Q2_A33WWPEntityId[0] ;
         A35WWPNotificationDefinitionId = H003Q2_A35WWPNotificationDefinitionId[0] ;
         A154WWPNotificationDefinitionDescr = H003Q2_A154WWPNotificationDefinitionDescr[0] ;
         A189WWPNotificationDefinitionSecFu = H003Q2_A189WWPNotificationDefinitionSecFu[0] ;
         if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
         {
            A190WWPNotificationDefinitionIsAut = true ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
         }
         else
         {
            GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
            wwp_subscriptionspanel_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
            A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
         }
         if ( A190WWPNotificationDefinitionIsAut )
         {
            GRID_nRecordCount = (long)(GRID_nRecordCount+1) ;
         }
         pr_default.readNext(0);
      }
      GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
      pr_default.close(0);
      return (int)(GRID_nRecordCount) ;
   }

   public void rf3Q2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(9) ;
      /* Execute user event: Refresh */
      e133Q2 ();
      nGXsfl_9_idx = 1 ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      bGXsfl_9_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_92( ) ;
         /* Using cursor H003Q3 */
         pr_default.execute(1, new Object[] {Long.valueOf(AV5WWPEntityId), Byte.valueOf(AV7WWPNotificationAppliesTo)});
         nGXsfl_9_idx = 1 ;
         sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_92( ) ;
         GRID_nEOF = (byte)(0) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         while ( ( (pr_default.getStatus(1) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A156WWPNotificationDefinitionAllow = H003Q3_A156WWPNotificationDefinitionAllow[0] ;
            A155WWPNotificationDefinitionAppli = H003Q3_A155WWPNotificationDefinitionAppli[0] ;
            A33WWPEntityId = H003Q3_A33WWPEntityId[0] ;
            A35WWPNotificationDefinitionId = H003Q3_A35WWPNotificationDefinitionId[0] ;
            A154WWPNotificationDefinitionDescr = H003Q3_A154WWPNotificationDefinitionDescr[0] ;
            A189WWPNotificationDefinitionSecFu = H003Q3_A189WWPNotificationDefinitionSecFu[0] ;
            if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
            {
               A190WWPNotificationDefinitionIsAut = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
            }
            else
            {
               GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
               GXv_boolean2[0] = GXt_boolean1 ;
               new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
               wwp_subscriptionspanel_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
               A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
            }
            if ( A190WWPNotificationDefinitionIsAut )
            {
               e143Q2 ();
            }
            pr_default.readNext(1);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(1) == 101) ? 1 : 0)) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(1);
         wbEnd = (short)(9) ;
         wb3Q0( ) ;
      }
      bGXsfl_9_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes3Q2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV28Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUDPARG1", GXutil.rtrim( AV31Udparg1));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUDPARG1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV31Udparg1, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWWPSUBSCRIPTIONROLEIDCOLLECTION", AV23WWPSubscriptionRoleIdCollection);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWWPSUBSCRIPTIONROLEIDCOLLECTION", AV23WWPSubscriptionRoleIdCollection);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPSUBSCRIPTIONROLEIDCOLLECTION", getSecureSignedToken( sPrefix, AV23WWPSubscriptionRoleIdCollection));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPNOTIFICATIONID", GXutil.ltrim( localUtil.ntoc( AV8WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV8WWPNotificationId), "ZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWWPNOTIFICATIONDEFINITIONID", GXutil.ltrim( localUtil.ntoc( AV24WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONDEFINITIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV24WWPNotificationDefinitionId), "ZZZZZZZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      return (int)(subgridclient_rec_count_fnc()) ;
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
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV5WWPEntityId, AV7WWPNotificationAppliesTo, AV28Pgmname, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, AV23WWPSubscriptionRoleIdCollection, AV8WWPNotificationId, A151WWPSubscriptionEntityRecordId, AV20WWPSubscriptionEntityRecordId, A34WWPSubscriptionId, AV24WWPNotificationDefinitionId, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5WWPEntityId, AV7WWPNotificationAppliesTo, AV28Pgmname, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, AV23WWPSubscriptionRoleIdCollection, AV8WWPNotificationId, A151WWPSubscriptionEntityRecordId, AV20WWPSubscriptionEntityRecordId, A34WWPSubscriptionId, AV24WWPNotificationDefinitionId, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5WWPEntityId, AV7WWPNotificationAppliesTo, AV28Pgmname, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, AV23WWPSubscriptionRoleIdCollection, AV8WWPNotificationId, A151WWPSubscriptionEntityRecordId, AV20WWPSubscriptionEntityRecordId, A34WWPSubscriptionId, AV24WWPNotificationDefinitionId, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV5WWPEntityId, AV7WWPNotificationAppliesTo, AV28Pgmname, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, AV23WWPSubscriptionRoleIdCollection, AV8WWPNotificationId, A151WWPSubscriptionEntityRecordId, AV20WWPSubscriptionEntityRecordId, A34WWPSubscriptionId, AV24WWPNotificationDefinitionId, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5WWPEntityId, AV7WWPNotificationAppliesTo, AV28Pgmname, A32WWPUserExtendedId, AV31Udparg1, A152WWPSubscriptionSubscribed, A149WWPSubscriptionRoleId, AV23WWPSubscriptionRoleIdCollection, AV8WWPNotificationId, A151WWPSubscriptionEntityRecordId, AV20WWPSubscriptionEntityRecordId, A34WWPSubscriptionId, AV24WWPNotificationDefinitionId, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsPanel" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup3Q0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e123Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_9 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_9"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV6WWPEntityName = httpContext.cgiGet( sPrefix+"wcpOAV6WWPEntityName") ;
         wcpOAV7WWPNotificationAppliesTo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7WWPNotificationAppliesTo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV20WWPSubscriptionEntityRecordId = httpContext.cgiGet( sPrefix+"wcpOAV20WWPSubscriptionEntityRecordId") ;
         wcpOAV14RecordAttDescription = httpContext.cgiGet( sPrefix+"wcpOAV14RecordAttDescription") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      e123Q2 ();
      if (returnInSub) return;
   }

   public void e123Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtWWPNotificationDefinitionId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtWWPNotificationDefinitionId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionId_Visible), 5, 0), !bGXsfl_9_Refreshing);
      edtavWwpsubscriptionid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWwpsubscriptionid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpsubscriptionid_Visible), 5, 0), !bGXsfl_9_Refreshing);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      /* Using cursor H003Q4 */
      pr_default.execute(2, new Object[] {AV6WWPEntityName});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A150WWPEntityName = H003Q4_A150WWPEntityName[0] ;
         A33WWPEntityId = H003Q4_A33WWPEntityId[0] ;
         AV5WWPEntityId = A33WWPEntityId ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5WWPEntityId), 10, 0));
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      GXt_objcol_char3 = AV23WWPSubscriptionRoleIdCollection ;
      GXv_objcol_char4[0] = GXt_objcol_char3 ;
      new com.mujermorena.wwpbaseobjects.wwp_getloggeduserroles(remoteHandle, context).execute( GXv_objcol_char4) ;
      GXt_objcol_char3 = GXv_objcol_char4[0] ;
      AV23WWPSubscriptionRoleIdCollection = GXt_objcol_char3 ;
   }

   public void e133Q2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext5[0] = AV19WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV19WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
   }

   private void e143Q2( )
   {
      if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
      {
         /* Grid_Load Routine */
         returnInSub = false ;
         AV8WWPNotificationId = A35WWPNotificationDefinitionId ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8WWPNotificationId), 10, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vWWPNOTIFICATIONID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV8WWPNotificationId), "ZZZZZZZZZ9")));
         /* Execute user subroutine: 'LOADCHECKINCLUDENOTIFICATIONS' */
         S142 ();
         if (returnInSub) return;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(9) ;
         }
         sendrow_92( ) ;
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
      if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
      {
         httpContext.doAjaxLoad(9, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV16Session.getValue(AV28Pgmname+"GridState"), "") == 0 )
      {
         AV9GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV28Pgmname+"GridState"), null, null);
      }
      else
      {
         AV9GridState.fromxml(AV16Session.getValue(AV28Pgmname+"GridState"), null, null);
      }
      if ( ! (GXutil.strcmp("", GXutil.trim( AV9GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV9GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV9GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S132( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV9GridState.fromxml(AV16Session.getValue(AV28Pgmname+"GridState"), null, null);
      AV9GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV9GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV28Pgmname+"GridState", AV9GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV17TrnContext = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext)new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV17TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV28Pgmname );
      AV17TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV17TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV17TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "WWPBaseObjects.Notifications.Common.WWP_NotificationDefinition" );
      AV16Session.setValue("TrnContext", AV17TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
   }

   public void e113Q2( )
   {
      /* Tablesubscriptionitem_Click Routine */
      returnInSub = false ;
      AV12IncludeNotification = (boolean)(!AV12IncludeNotification) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV12IncludeNotification);
      GXv_int6[0] = AV22WWPSubscriptionId ;
      new com.mujermorena.wwpbaseobjects.subscriptions.wwp_userupdatesubscription(remoteHandle, context).execute( AV12IncludeNotification, GXv_int6, A35WWPNotificationDefinitionId, AV20WWPSubscriptionEntityRecordId, AV14RecordAttDescription) ;
      wwp_subscriptionspanel_impl.this.AV22WWPSubscriptionId = GXv_int6[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22WWPSubscriptionId), 10, 0));
      if ( 1 == 0 )
      {
         /* Start For Each Line */
         nRC_GXsfl_9 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_9"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_9_fel_idx = 0 ;
         while ( nGXsfl_9_fel_idx < nRC_GXsfl_9 )
         {
            nGXsfl_9_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_9_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_9_fel_idx+1) ;
            sGXsfl_9_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_92( ) ;
            AV12IncludeNotification = GXutil.strtobool( httpContext.cgiGet( chkavIncludenotification.getInternalname())) ;
            A154WWPNotificationDefinitionDescr = httpContext.cgiGet( edtWWPNotificationDefinitionDescr_Internalname) ;
            A35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( edtWWPNotificationDefinitionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWWPSUBSCRIPTIONID");
               GX_FocusControl = edtavWwpsubscriptionid_Internalname ;
               wbErr = true ;
               AV22WWPSubscriptionId = 0 ;
            }
            else
            {
               AV22WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtavWwpsubscriptionid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            }
            /* End For Each Line */
         }
         if ( nGXsfl_9_fel_idx == 0 )
         {
            nGXsfl_9_idx = 1 ;
            sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_92( ) ;
         }
         nGXsfl_9_fel_idx = 1 ;
      }
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'LOADCHECKINCLUDENOTIFICATIONS' Routine */
      returnInSub = false ;
      AV12IncludeNotification = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV12IncludeNotification);
      AV31Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A149WWPSubscriptionRoleId ,
                                           AV23WWPSubscriptionRoleIdCollection ,
                                           AV20WWPSubscriptionEntityRecordId ,
                                           A151WWPSubscriptionEntityRecordId ,
                                           A32WWPUserExtendedId ,
                                           AV31Udparg1 ,
                                           Boolean.valueOf(A152WWPSubscriptionSubscribed) ,
                                           Long.valueOf(AV8WWPNotificationId) ,
                                           Long.valueOf(A35WWPNotificationDefinitionId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.LONG
                                           }
      });
      /* Using cursor H003Q5 */
      pr_default.execute(3, new Object[] {Long.valueOf(AV8WWPNotificationId), AV31Udparg1, AV20WWPSubscriptionEntityRecordId});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A151WWPSubscriptionEntityRecordId = H003Q5_A151WWPSubscriptionEntityRecordId[0] ;
         A35WWPNotificationDefinitionId = H003Q5_A35WWPNotificationDefinitionId[0] ;
         A149WWPSubscriptionRoleId = H003Q5_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = H003Q5_n149WWPSubscriptionRoleId[0] ;
         A152WWPSubscriptionSubscribed = H003Q5_A152WWPSubscriptionSubscribed[0] ;
         A32WWPUserExtendedId = H003Q5_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = H003Q5_n32WWPUserExtendedId[0] ;
         A34WWPSubscriptionId = H003Q5_A34WWPSubscriptionId[0] ;
         AV22WWPSubscriptionId = A34WWPSubscriptionId ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22WWPSubscriptionId), 10, 0));
         AV12IncludeNotification = true ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV12IncludeNotification);
         if ( ! (GXutil.strcmp("", A149WWPSubscriptionRoleId)==0) )
         {
            GXt_boolean1 = AV12IncludeNotification ;
            GXv_int6[0] = AV22WWPSubscriptionId ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new com.mujermorena.wwpbaseobjects.subscriptions.wwp_checkuserisnotunsubscribed(remoteHandle, context).execute( AV24WWPNotificationDefinitionId, GXv_int6, GXv_boolean2) ;
            wwp_subscriptionspanel_impl.this.AV22WWPSubscriptionId = GXv_int6[0] ;
            wwp_subscriptionspanel_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavWwpsubscriptionid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22WWPSubscriptionId), 10, 0));
            AV12IncludeNotification = GXt_boolean1 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, chkavIncludenotification.getInternalname(), AV12IncludeNotification);
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6WWPEntityName = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WWPEntityName", AV6WWPEntityName);
      AV7WWPNotificationAppliesTo = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7WWPNotificationAppliesTo", GXutil.str( AV7WWPNotificationAppliesTo, 1, 0));
      AV20WWPSubscriptionEntityRecordId = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20WWPSubscriptionEntityRecordId", AV20WWPSubscriptionEntityRecordId);
      AV14RecordAttDescription = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14RecordAttDescription", AV14RecordAttDescription);
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
      pa3Q2( ) ;
      ws3Q2( ) ;
      we3Q2( ) ;
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
      sCtrlAV6WWPEntityName = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV7WWPNotificationAppliesTo = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV20WWPSubscriptionEntityRecordId = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV14RecordAttDescription = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3Q2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\subscriptions\\wwp_subscriptionspanel", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3Q2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV6WWPEntityName = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WWPEntityName", AV6WWPEntityName);
         AV7WWPNotificationAppliesTo = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7WWPNotificationAppliesTo", GXutil.str( AV7WWPNotificationAppliesTo, 1, 0));
         AV20WWPSubscriptionEntityRecordId = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20WWPSubscriptionEntityRecordId", AV20WWPSubscriptionEntityRecordId);
         AV14RecordAttDescription = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14RecordAttDescription", AV14RecordAttDescription);
      }
      wcpOAV6WWPEntityName = httpContext.cgiGet( sPrefix+"wcpOAV6WWPEntityName") ;
      wcpOAV7WWPNotificationAppliesTo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7WWPNotificationAppliesTo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV20WWPSubscriptionEntityRecordId = httpContext.cgiGet( sPrefix+"wcpOAV20WWPSubscriptionEntityRecordId") ;
      wcpOAV14RecordAttDescription = httpContext.cgiGet( sPrefix+"wcpOAV14RecordAttDescription") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV6WWPEntityName, wcpOAV6WWPEntityName) != 0 ) || ( AV7WWPNotificationAppliesTo != wcpOAV7WWPNotificationAppliesTo ) || ( GXutil.strcmp(AV20WWPSubscriptionEntityRecordId, wcpOAV20WWPSubscriptionEntityRecordId) != 0 ) || ( GXutil.strcmp(AV14RecordAttDescription, wcpOAV14RecordAttDescription) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV6WWPEntityName = AV6WWPEntityName ;
      wcpOAV7WWPNotificationAppliesTo = AV7WWPNotificationAppliesTo ;
      wcpOAV20WWPSubscriptionEntityRecordId = AV20WWPSubscriptionEntityRecordId ;
      wcpOAV14RecordAttDescription = AV14RecordAttDescription ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV6WWPEntityName = httpContext.cgiGet( sPrefix+"AV6WWPEntityName_CTRL") ;
      if ( GXutil.len( sCtrlAV6WWPEntityName) > 0 )
      {
         AV6WWPEntityName = httpContext.cgiGet( sCtrlAV6WWPEntityName) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WWPEntityName", AV6WWPEntityName);
      }
      else
      {
         AV6WWPEntityName = httpContext.cgiGet( sPrefix+"AV6WWPEntityName_PARM") ;
      }
      sCtrlAV7WWPNotificationAppliesTo = httpContext.cgiGet( sPrefix+"AV7WWPNotificationAppliesTo_CTRL") ;
      if ( GXutil.len( sCtrlAV7WWPNotificationAppliesTo) > 0 )
      {
         AV7WWPNotificationAppliesTo = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlAV7WWPNotificationAppliesTo), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7WWPNotificationAppliesTo", GXutil.str( AV7WWPNotificationAppliesTo, 1, 0));
      }
      else
      {
         AV7WWPNotificationAppliesTo = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV7WWPNotificationAppliesTo_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV20WWPSubscriptionEntityRecordId = httpContext.cgiGet( sPrefix+"AV20WWPSubscriptionEntityRecordId_CTRL") ;
      if ( GXutil.len( sCtrlAV20WWPSubscriptionEntityRecordId) > 0 )
      {
         AV20WWPSubscriptionEntityRecordId = httpContext.cgiGet( sCtrlAV20WWPSubscriptionEntityRecordId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20WWPSubscriptionEntityRecordId", AV20WWPSubscriptionEntityRecordId);
      }
      else
      {
         AV20WWPSubscriptionEntityRecordId = httpContext.cgiGet( sPrefix+"AV20WWPSubscriptionEntityRecordId_PARM") ;
      }
      sCtrlAV14RecordAttDescription = httpContext.cgiGet( sPrefix+"AV14RecordAttDescription_CTRL") ;
      if ( GXutil.len( sCtrlAV14RecordAttDescription) > 0 )
      {
         AV14RecordAttDescription = httpContext.cgiGet( sCtrlAV14RecordAttDescription) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14RecordAttDescription", AV14RecordAttDescription);
      }
      else
      {
         AV14RecordAttDescription = httpContext.cgiGet( sPrefix+"AV14RecordAttDescription_PARM") ;
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
      pa3Q2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3Q2( ) ;
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
      ws3Q2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6WWPEntityName_PARM", AV6WWPEntityName);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6WWPEntityName)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6WWPEntityName_CTRL", GXutil.rtrim( sCtrlAV6WWPEntityName));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7WWPNotificationAppliesTo_PARM", GXutil.ltrim( localUtil.ntoc( AV7WWPNotificationAppliesTo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7WWPNotificationAppliesTo)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7WWPNotificationAppliesTo_CTRL", GXutil.rtrim( sCtrlAV7WWPNotificationAppliesTo));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV20WWPSubscriptionEntityRecordId_PARM", AV20WWPSubscriptionEntityRecordId);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV20WWPSubscriptionEntityRecordId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV20WWPSubscriptionEntityRecordId_CTRL", GXutil.rtrim( sCtrlAV20WWPSubscriptionEntityRecordId));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14RecordAttDescription_PARM", AV14RecordAttDescription);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV14RecordAttDescription)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14RecordAttDescription_CTRL", GXutil.rtrim( sCtrlAV14RecordAttDescription));
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
      we3Q2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111102610", true, true);
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
         httpContext.AddJavascriptSource("wwpbaseobjects/subscriptions/wwp_subscriptionspanel.js", "?202412111102610", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_92( )
   {
      chkavIncludenotification.setInternalname( sPrefix+"vINCLUDENOTIFICATION_"+sGXsfl_9_idx );
      edtWWPNotificationDefinitionDescr_Internalname = sPrefix+"WWPNOTIFICATIONDEFINITIONDESCR_"+sGXsfl_9_idx ;
      edtWWPNotificationDefinitionId_Internalname = sPrefix+"WWPNOTIFICATIONDEFINITIONID_"+sGXsfl_9_idx ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID_"+sGXsfl_9_idx ;
   }

   public void subsflControlProps_fel_92( )
   {
      chkavIncludenotification.setInternalname( sPrefix+"vINCLUDENOTIFICATION_"+sGXsfl_9_fel_idx );
      edtWWPNotificationDefinitionDescr_Internalname = sPrefix+"WWPNOTIFICATIONDEFINITIONDESCR_"+sGXsfl_9_fel_idx ;
      edtWWPNotificationDefinitionId_Internalname = sPrefix+"WWPNOTIFICATIONDEFINITIONID_"+sGXsfl_9_fel_idx ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID_"+sGXsfl_9_fel_idx ;
   }

   public void sendrow_92( )
   {
      subsflControlProps_92( ) ;
      wb3Q0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_9_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_9_idx) % (2))) == 0 )
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
            httpContext.writeText( "<tr"+" class=\""+subGrid_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_9_idx+"\">") ;
         }
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgrid_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 SubscriptionItem","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablesubscriptionitem_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkavIncludenotification.getInternalname(),httpContext.getMessage( "Include Notification", ""),"gx-form-item AttributeCheckBoxLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Check box */
         TempTags = " " + ((chkavIncludenotification.getEnabled()!=0)&&(chkavIncludenotification.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 16,'"+sPrefix+"',false,'"+sGXsfl_9_idx+"',9)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vINCLUDENOTIFICATION_" + sGXsfl_9_idx ;
         chkavIncludenotification.setName( GXCCtl );
         chkavIncludenotification.setWebtags( "" );
         chkavIncludenotification.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIncludenotification.getInternalname(), "TitleCaption", chkavIncludenotification.getCaption(), !bGXsfl_9_Refreshing);
         chkavIncludenotification.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIncludenotification.getInternalname(),GXutil.booltostr( AV12IncludeNotification),"",httpContext.getMessage( "Include Notification", ""),Integer.valueOf(1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(16, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+((chkavIncludenotification.getEnabled()!=0)&&(chkavIncludenotification.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,16);\"" : " ")});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationDefinitionDescr_Internalname,httpContext.getMessage( "Notification Definition Description", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationDefinitionDescr_Internalname,A154WWPNotificationDefinitionDescr,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
         GridRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgrid_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
         GridRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationDefinitionId_Internalname,httpContext.getMessage( "Notification Definition Id", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationDefinitionId_Internalname,GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtWWPNotificationDefinitionId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtWWPNotificationDefinitionId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"WWPBaseObjects\\WWP_Id","right",Boolean.valueOf(false),""});
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
         TempTags = " " + ((edtavWwpsubscriptionid_Enabled!=0)&&(edtavWwpsubscriptionid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 29,'"+sPrefix+"',false,'"+sGXsfl_9_idx+"',9)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpsubscriptionid_Internalname,GXutil.ltrim( localUtil.ntoc( AV22WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22WWPSubscriptionId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavWwpsubscriptionid_Enabled!=0)&&(edtavWwpsubscriptionid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavWwpsubscriptionid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavWwpsubscriptionid_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
         send_integrity_lvl_hashes3Q2( ) ;
         /* End of Columns property logic. */
         GridContainer.AddRow(GridRow);
         nGXsfl_9_idx = ((subGrid_Islastpage==1)&&(nGXsfl_9_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
         sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_92( ) ;
      }
      /* End function sendrow_92 */
   }

   public void startgridcontrol9( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"9\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
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
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV12IncludeNotification));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A154WWPNotificationDefinitionDescr);
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationDefinitionId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV22WWPSubscriptionId, (byte)(10), (byte)(0), ".", "")));
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
      edtWWPNotificationDefinitionDescr_Internalname = sPrefix+"WWPNOTIFICATIONDEFINITIONDESCR" ;
      divTablesubscriptionitem_Internalname = sPrefix+"TABLESUBSCRIPTIONITEM" ;
      edtWWPNotificationDefinitionId_Internalname = sPrefix+"WWPNOTIFICATIONDEFINITIONID" ;
      edtavWwpsubscriptionid_Internalname = sPrefix+"vWWPSUBSCRIPTIONID" ;
      tblUnnamedtablecontentfsgrid_Internalname = sPrefix+"UNNAMEDTABLECONTENTFSGRID" ;
      divUnnamedtablefsgrid_Internalname = sPrefix+"UNNAMEDTABLEFSGRID" ;
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
      edtWWPNotificationDefinitionId_Jsonclick = "" ;
      chkavIncludenotification.setCaption( httpContext.getMessage( "Include Notification", "") );
      chkavIncludenotification.setVisible( 1 );
      chkavIncludenotification.setEnabled( 1 );
      subGrid_Class = "FreeStyleGrid" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavWwpsubscriptionid_Visible = 1 ;
      edtWWPNotificationDefinitionId_Visible = 1 ;
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
      GXCCtl = "vINCLUDENOTIFICATION_" + sGXsfl_9_idx ;
      chkavIncludenotification.setName( GXCCtl );
      chkavIncludenotification.setWebtags( "" );
      chkavIncludenotification.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIncludenotification.getInternalname(), "TitleCaption", chkavIncludenotification.getCaption(), !bGXsfl_9_Refreshing);
      chkavIncludenotification.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV5WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV7WWPNotificationAppliesTo',fld:'vWWPNOTIFICATIONAPPLIESTO',pic:'9'},{av:'edtWWPNotificationDefinitionId_Visible',ctrl:'WWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'AV23WWPSubscriptionRoleIdCollection',fld:'vWWPSUBSCRIPTIONROLEIDCOLLECTION',pic:'',hsh:true},{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV24WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e143Q2',iparms:[{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV23WWPSubscriptionRoleIdCollection',fld:'vWWPSUBSCRIPTIONROLEIDCOLLECTION',pic:'',hsh:true},{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV24WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV12IncludeNotification',fld:'vINCLUDENOTIFICATION',pic:''},{av:'AV22WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("TABLESUBSCRIPTIONITEM.CLICK","{handler:'e113Q2',iparms:[{av:'AV12IncludeNotification',fld:'vINCLUDENOTIFICATION',grid:9,pic:''},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_9',ctrl:'GRID',grid:9,prop:'GridRC',grid:9},{av:'AV22WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',grid:9,pic:'ZZZZZZZZZ9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',grid:9,pic:'ZZZZZZZZZ9'},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV14RecordAttDescription',fld:'vRECORDATTDESCRIPTION',pic:''}]");
      setEventMetadata("TABLESUBSCRIPTIONITEM.CLICK",",oparms:[{av:'AV12IncludeNotification',fld:'vINCLUDENOTIFICATION',pic:''},{av:'AV22WWPSubscriptionId',fld:'vWWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV5WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV7WWPNotificationAppliesTo',fld:'vWWPNOTIFICATIONAPPLIESTO',pic:'9'},{av:'edtWWPNotificationDefinitionId_Visible',ctrl:'WWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV23WWPSubscriptionRoleIdCollection',fld:'vWWPSUBSCRIPTIONROLEIDCOLLECTION',pic:'',hsh:true},{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV24WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV5WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV7WWPNotificationAppliesTo',fld:'vWWPNOTIFICATIONAPPLIESTO',pic:'9'},{av:'edtWWPNotificationDefinitionId_Visible',ctrl:'WWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV23WWPSubscriptionRoleIdCollection',fld:'vWWPSUBSCRIPTIONROLEIDCOLLECTION',pic:'',hsh:true},{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV24WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV5WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV7WWPNotificationAppliesTo',fld:'vWWPNOTIFICATIONAPPLIESTO',pic:'9'},{av:'edtWWPNotificationDefinitionId_Visible',ctrl:'WWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV23WWPSubscriptionRoleIdCollection',fld:'vWWPSUBSCRIPTIONROLEIDCOLLECTION',pic:'',hsh:true},{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV24WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV5WWPEntityId',fld:'vWWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'AV7WWPNotificationAppliesTo',fld:'vWWPNOTIFICATIONAPPLIESTO',pic:'9'},{av:'edtWWPNotificationDefinitionId_Visible',ctrl:'WWPNOTIFICATIONDEFINITIONID',prop:'Visible'},{av:'edtavWwpsubscriptionid_Visible',ctrl:'vWWPSUBSCRIPTIONID',prop:'Visible'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'AV31Udparg1',fld:'vUDPARG1',pic:'',hsh:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'AV23WWPSubscriptionRoleIdCollection',fld:'vWWPSUBSCRIPTIONROLEIDCOLLECTION',pic:'',hsh:true},{av:'AV8WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'AV20WWPSubscriptionEntityRecordId',fld:'vWWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'AV24WWPNotificationDefinitionId',fld:'vWWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'AV28Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
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
      wcpOAV6WWPEntityName = "" ;
      wcpOAV20WWPSubscriptionEntityRecordId = "" ;
      wcpOAV14RecordAttDescription = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV6WWPEntityName = "" ;
      AV20WWPSubscriptionEntityRecordId = "" ;
      AV14RecordAttDescription = "" ;
      AV28Pgmname = "" ;
      A32WWPUserExtendedId = "" ;
      AV31Udparg1 = "" ;
      A149WWPSubscriptionRoleId = "" ;
      AV23WWPSubscriptionRoleIdCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      A151WWPSubscriptionEntityRecordId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      A189WWPNotificationDefinitionSecFu = "" ;
      GX_FocusControl = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A154WWPNotificationDefinitionDescr = "" ;
      scmdbuf = "" ;
      H003Q2_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      H003Q2_A155WWPNotificationDefinitionAppli = new byte[1] ;
      H003Q2_A33WWPEntityId = new long[1] ;
      H003Q2_A35WWPNotificationDefinitionId = new long[1] ;
      H003Q2_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      H003Q2_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      H003Q3_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      H003Q3_A155WWPNotificationDefinitionAppli = new byte[1] ;
      H003Q3_A33WWPEntityId = new long[1] ;
      H003Q3_A35WWPNotificationDefinitionId = new long[1] ;
      H003Q3_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      H003Q3_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      H003Q4_A150WWPEntityName = new String[] {""} ;
      H003Q4_A33WWPEntityId = new long[1] ;
      A150WWPEntityName = "" ;
      GXt_objcol_char3 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char4 = new GXSimpleCollection[1] ;
      AV19WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV16Session = httpContext.getWebSession();
      AV9GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      H003Q5_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      H003Q5_A35WWPNotificationDefinitionId = new long[1] ;
      H003Q5_A149WWPSubscriptionRoleId = new String[] {""} ;
      H003Q5_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      H003Q5_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      H003Q5_A32WWPUserExtendedId = new String[] {""} ;
      H003Q5_n32WWPUserExtendedId = new boolean[] {false} ;
      H003Q5_A34WWPSubscriptionId = new long[1] ;
      GXv_int6 = new long[1] ;
      GXv_boolean2 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6WWPEntityName = "" ;
      sCtrlAV7WWPNotificationAppliesTo = "" ;
      sCtrlAV20WWPSubscriptionEntityRecordId = "" ;
      sCtrlAV14RecordAttDescription = "" ;
      subGrid_Linesclass = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      subGrid_Header = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionspanel__default(),
         new Object[] {
             new Object[] {
            H003Q2_A156WWPNotificationDefinitionAllow, H003Q2_A155WWPNotificationDefinitionAppli, H003Q2_A33WWPEntityId, H003Q2_A35WWPNotificationDefinitionId, H003Q2_A154WWPNotificationDefinitionDescr, H003Q2_A189WWPNotificationDefinitionSecFu
            }
            , new Object[] {
            H003Q3_A156WWPNotificationDefinitionAllow, H003Q3_A155WWPNotificationDefinitionAppli, H003Q3_A33WWPEntityId, H003Q3_A35WWPNotificationDefinitionId, H003Q3_A154WWPNotificationDefinitionDescr, H003Q3_A189WWPNotificationDefinitionSecFu
            }
            , new Object[] {
            H003Q4_A150WWPEntityName, H003Q4_A33WWPEntityId
            }
            , new Object[] {
            H003Q5_A151WWPSubscriptionEntityRecordId, H003Q5_A35WWPNotificationDefinitionId, H003Q5_A149WWPSubscriptionRoleId, H003Q5_n149WWPSubscriptionRoleId, H003Q5_A152WWPSubscriptionSubscribed, H003Q5_A32WWPUserExtendedId, H003Q5_n32WWPUserExtendedId, H003Q5_A34WWPSubscriptionId
            }
         }
      );
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsPanel" ;
      /* GeneXus formulas. */
      AV28Pgmname = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsPanel" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOAV7WWPNotificationAppliesTo ;
   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV7WWPNotificationAppliesTo ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte A155WWPNotificationDefinitionAppli ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtWWPNotificationDefinitionId_Visible ;
   private int edtavWwpsubscriptionid_Visible ;
   private int subGrid_Rows ;
   private int nRC_GXsfl_9 ;
   private int nGXsfl_9_idx=1 ;
   private int subGrid_Islastpage ;
   private int nGXsfl_9_fel_idx=1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavWwpsubscriptionid_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV5WWPEntityId ;
   private long AV8WWPNotificationId ;
   private long A34WWPSubscriptionId ;
   private long AV24WWPNotificationDefinitionId ;
   private long A35WWPNotificationDefinitionId ;
   private long AV22WWPSubscriptionId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long A33WWPEntityId ;
   private long GXv_int6[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_9_idx="0001" ;
   private String edtWWPNotificationDefinitionId_Internalname ;
   private String edtavWwpsubscriptionid_Internalname ;
   private String AV28Pgmname ;
   private String A32WWPUserExtendedId ;
   private String AV31Udparg1 ;
   private String A149WWPSubscriptionRoleId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtWWPNotificationDefinitionDescr_Internalname ;
   private String scmdbuf ;
   private String sGXsfl_9_fel_idx="0001" ;
   private String sCtrlAV6WWPEntityName ;
   private String sCtrlAV7WWPNotificationAppliesTo ;
   private String sCtrlAV20WWPSubscriptionEntityRecordId ;
   private String sCtrlAV14RecordAttDescription ;
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
   private String edtWWPNotificationDefinitionId_Jsonclick ;
   private String edtavWwpsubscriptionid_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_9_Refreshing=false ;
   private boolean n32WWPUserExtendedId ;
   private boolean A152WWPSubscriptionSubscribed ;
   private boolean n149WWPSubscriptionRoleId ;
   private boolean A190WWPNotificationDefinitionIsAut ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV12IncludeNotification ;
   private boolean A156WWPNotificationDefinitionAllow ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String wcpOAV6WWPEntityName ;
   private String wcpOAV20WWPSubscriptionEntityRecordId ;
   private String wcpOAV14RecordAttDescription ;
   private String AV6WWPEntityName ;
   private String AV20WWPSubscriptionEntityRecordId ;
   private String AV14RecordAttDescription ;
   private String A151WWPSubscriptionEntityRecordId ;
   private String A189WWPNotificationDefinitionSecFu ;
   private String A154WWPNotificationDefinitionDescr ;
   private String A150WWPEntityName ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private ICheckbox chkavIncludenotification ;
   private IDataStoreProvider pr_default ;
   private boolean[] H003Q2_A156WWPNotificationDefinitionAllow ;
   private byte[] H003Q2_A155WWPNotificationDefinitionAppli ;
   private long[] H003Q2_A33WWPEntityId ;
   private long[] H003Q2_A35WWPNotificationDefinitionId ;
   private String[] H003Q2_A154WWPNotificationDefinitionDescr ;
   private String[] H003Q2_A189WWPNotificationDefinitionSecFu ;
   private boolean[] H003Q3_A156WWPNotificationDefinitionAllow ;
   private byte[] H003Q3_A155WWPNotificationDefinitionAppli ;
   private long[] H003Q3_A33WWPEntityId ;
   private long[] H003Q3_A35WWPNotificationDefinitionId ;
   private String[] H003Q3_A154WWPNotificationDefinitionDescr ;
   private String[] H003Q3_A189WWPNotificationDefinitionSecFu ;
   private String[] H003Q4_A150WWPEntityName ;
   private long[] H003Q4_A33WWPEntityId ;
   private String[] H003Q5_A151WWPSubscriptionEntityRecordId ;
   private long[] H003Q5_A35WWPNotificationDefinitionId ;
   private String[] H003Q5_A149WWPSubscriptionRoleId ;
   private boolean[] H003Q5_n149WWPSubscriptionRoleId ;
   private boolean[] H003Q5_A152WWPSubscriptionSubscribed ;
   private String[] H003Q5_A32WWPUserExtendedId ;
   private boolean[] H003Q5_n32WWPUserExtendedId ;
   private long[] H003Q5_A34WWPSubscriptionId ;
   private GXSimpleCollection<String> AV23WWPSubscriptionRoleIdCollection ;
   private GXSimpleCollection<String> GXt_objcol_char3 ;
   private GXSimpleCollection<String> GXv_objcol_char4[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV9GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV17TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV19WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
}

final  class wwp_subscriptionspanel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H003Q5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A149WWPSubscriptionRoleId ,
                                          GXSimpleCollection<String> AV23WWPSubscriptionRoleIdCollection ,
                                          String AV20WWPSubscriptionEntityRecordId ,
                                          String A151WWPSubscriptionEntityRecordId ,
                                          String A32WWPUserExtendedId ,
                                          String AV31Udparg1 ,
                                          boolean A152WWPSubscriptionSubscribed ,
                                          long AV8WWPNotificationId ,
                                          long A35WWPNotificationDefinitionId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[3];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT TOP 1 [WWPSubscriptionEntityRecordId], [WWPNotificationDefinitionId], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPUserExtendedId], [WWPSubscriptionId]" ;
      scmdbuf += " FROM [WWP_Subscription]" ;
      addWhere(sWhereString, "([WWPNotificationDefinitionId] = ?)");
      addWhere(sWhereString, "(( [WWPUserExtendedId] = ? and [WWPSubscriptionSubscribed] = 1) or "+GXutil.toValueList("sqlserver", AV23WWPSubscriptionRoleIdCollection, "[WWPSubscriptionRoleId] IN (", ")")+")");
      if ( GXutil.strcmp(AV20WWPSubscriptionEntityRecordId, "") != 0 )
      {
         addWhere(sWhereString, "([WWPSubscriptionEntityRecordId] = ?)");
      }
      else
      {
         GXv_int7[2] = (byte)(1) ;
      }
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
            case 3 :
                  return conditional_H003Q5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Boolean) dynConstraints[6]).booleanValue() , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003Q2", "SELECT [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionAppli], [WWPEntityId], [WWPNotificationDefinitionId], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionSecFu] FROM [WWP_NotificationDefinition] WHERE ([WWPEntityId] = ?) AND ([WWPNotificationDefinitionAllow] = 1) AND ([WWPNotificationDefinitionAppli] = ?) ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003Q3", "SELECT [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionAppli], [WWPEntityId], [WWPNotificationDefinitionId], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionSecFu] FROM [WWP_NotificationDefinition] WHERE ([WWPEntityId] = ?) AND ([WWPNotificationDefinitionAllow] = 1) AND ([WWPNotificationDefinitionAppli] = ?) ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003Q4", "SELECT TOP 1 [WWPEntityName], [WWPEntityId] FROM [WWP_Entity] WHERE LOWER([WWPEntityName]) = LOWER(?) ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H003Q5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((long[]) buf[7])[0] = rslt.getLong(6);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[3]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 2000);
               }
               return;
      }
   }

}

