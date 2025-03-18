package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_selectimportfile_impl extends GXWebComponent
{
   public wwp_selectimportfile_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_selectimportfile_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_selectimportfile_impl.class ));
   }

   public wwp_selectimportfile_impl( int remoteHandle ,
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
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
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
               AV14TransactionName = httpContext.GetPar( "TransactionName") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14TransactionName", AV14TransactionName);
               AV9ImportType = httpContext.GetPar( "ImportType") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9ImportType", AV9ImportType);
               AV6ExtraParmsJson = httpContext.GetPar( "ExtraParmsJson") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ExtraParmsJson", AV6ExtraParmsJson);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV14TransactionName,AV9ImportType,AV6ExtraParmsJson});
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
               gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
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

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa2I2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Select file to import", "")) ;
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
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.wwp_selectimportfile", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14TransactionName)),GXutil.URLEncode(GXutil.rtrim(AV9ImportType)),GXutil.URLEncode(GXutil.rtrim(AV6ExtraParmsJson))}, new String[] {"TransactionName","ImportType","ExtraParmsJson"}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
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
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vERRORMSGS", getSecureSignedToken( sPrefix, AV5ErrorMsgs));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV14TransactionName", wcpOAV14TransactionName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9ImportType", wcpOAV9ImportType);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6ExtraParmsJson", wcpOAV6ExtraParmsJson);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTTYPE", AV9ImportType);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vERRORMSGS", AV5ErrorMsgs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vERRORMSGS", AV5ErrorMsgs);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vERRORMSGS", getSecureSignedToken( sPrefix, AV5ErrorMsgs));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEXTRAPARMSJSON", AV6ExtraParmsJson);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTRANSACTIONNAME", AV14TransactionName);
      GXCCtlgxBlob = "vFILTERTOUPLOAD" + "_gxBlob" ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+GXCCtlgxBlob, AV7FilterToUpload);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFILTERTOUPLOAD_Filename", GXutil.rtrim( edtavFiltertoupload_Filename));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFILTERTOUPLOAD_Filename", GXutil.rtrim( edtavFiltertoupload_Filename));
   }

   public void renderHtmlCloseForm2I2( )
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
         httpContext.writeTextNL( "</form>") ;
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
      return "WWPBaseObjects.WWP_SelectImportFile" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Select file to import", "") ;
   }

   public void wb2I0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.wwp_selectimportfile");
         }
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransactionPopUp", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell AttributeImportFileCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFiltertoupload_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFiltertoupload_Internalname, httpContext.getMessage( "File", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'" + sPrefix + "',false,'',0)\"" ;
         edtavFiltertoupload_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "Filetype", edtavFiltertoupload_Filetype, true);
         if ( ! (GXutil.strcmp("", AV7FilterToUpload)==0) )
         {
            gxblobfileaux.setSource( AV7FilterToUpload );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavFiltertoupload_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavFiltertoupload_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV7FilterToUpload = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
               edtavFiltertoupload_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "Filetype", edtavFiltertoupload_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
         }
         com.mujermorena.GxWebStd.gx_blob_field( httpContext, edtavFiltertoupload_Internalname, GXutil.rtrim( AV7FilterToUpload), httpContext.getResourceRelative(AV7FilterToUpload), ((GXutil.strcmp("", edtavFiltertoupload_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavFiltertoupload_Filetype)==0) ? AV7FilterToUpload : edtavFiltertoupload_Filetype)) : edtavFiltertoupload_Contenttype), false, "", edtavFiltertoupload_Parameters, 0, edtavFiltertoupload_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavFiltertoupload_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "", "", "HLP_WWPBaseObjects\\WWP_SelectImportFile.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupRight", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "Import", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_SelectImportFile.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnucancel_Internalname, "", httpContext.getMessage( "Cancel", ""), bttBtnucancel_Jsonclick, 7, httpContext.getMessage( "Cancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e112i1_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\WWP_SelectImportFile.htm");
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
      wbLoad = true ;
   }

   public void start2I2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Select file to import", ""), (short)(0)) ;
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
            strup2I0( ) ;
         }
      }
   }

   public void ws2I2( )
   {
      start2I2( ) ;
      evt2I2( ) ;
   }

   public void evt2I2( )
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
                              strup2I0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e122I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2I0( ) ;
                           }
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
                                       /* Execute user event: Enter */
                                       e132I2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e142I2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavFiltertoupload_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
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
   }

   public void we2I2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2I2( ) ;
         }
      }
   }

   public void pa2I2( )
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
            GX_FocusControl = edtavFiltertoupload_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      rf2I2( ) ;
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
   }

   public void rf2I2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e142I2 ();
         wb2I0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2I2( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vERRORMSGS", AV5ErrorMsgs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vERRORMSGS", AV5ErrorMsgs);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vERRORMSGS", getSecureSignedToken( sPrefix, AV5ErrorMsgs));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2I0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e122I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV14TransactionName = httpContext.cgiGet( sPrefix+"wcpOAV14TransactionName") ;
         wcpOAV9ImportType = httpContext.cgiGet( sPrefix+"wcpOAV9ImportType") ;
         wcpOAV6ExtraParmsJson = httpContext.cgiGet( sPrefix+"wcpOAV6ExtraParmsJson") ;
         edtavFiltertoupload_Filename = httpContext.cgiGet( sPrefix+"vFILTERTOUPLOAD_Filename") ;
         /* Read variables values. */
         AV7FilterToUpload = httpContext.cgiGet( edtavFiltertoupload_Internalname) ;
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( (GXutil.strcmp("", AV7FilterToUpload)==0) )
         {
            GXCCtlgxBlob = "vFILTERTOUPLOAD" + "_gxBlob" ;
            AV7FilterToUpload = httpContext.cgiGet( sPrefix+GXCCtlgxBlob) ;
         }
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
      e122I2 ();
      if (returnInSub) return;
   }

   public void e122I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e132I2 ();
      if (returnInSub) return;
   }

   public void e132I2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8FilterToUploadExt = edtavFiltertoupload_Filename ;
      AV8FilterToUploadExt = ((GXutil.strSearch( AV8FilterToUploadExt, ".", 1)>0) ? GXutil.substring( AV8FilterToUploadExt, GXutil.strSearchRev( AV8FilterToUploadExt, ".", -1)+1, GXutil.len( AV8FilterToUploadExt)-GXutil.strSearchRev( AV8FilterToUploadExt, ".", -1)) : "") ;
      AV15BlobId = AV7FilterToUpload ;
      AV17BlobRef = GXutil.strReplace( AV15BlobId, "gxupload:", "") ;
      AV18Cache = com.genexus.util.CacheAPI.getCache( "FL");
      AV19BlobData.fromJSonString(AV18Cache.get(AV17BlobRef), null);
      AV20BlobPath = AV19BlobData.getgxTv_SdtBlobData_Path() ;
      httpContext.GX_msglist.addItem("<#CLEAR#>");
      if ( ! (GXutil.strcmp("", AV7FilterToUpload)==0) )
      {
         if ( ( ( GXutil.strcmp(GXutil.upper( AV8FilterToUploadExt), "CSV") == 0 ) && ( GXutil.strcmp(AV9ImportType, "CSV") == 0 ) ) || ( ( GXutil.strcmp(GXutil.upper( AV8FilterToUploadExt), "XLSX") == 0 ) && ( GXutil.strcmp(AV9ImportType, "Excel") == 0 ) ) )
         {
            AV12ResultMsg = "" ;
            GXv_objcol_SdtMessages_Message1[0] = AV5ErrorMsgs ;
            if ( new com.mujermorena.wwpbaseobjects.wwp_importdata(remoteHandle, context).executeUdp( AV14TransactionName, AV9ImportType, AV20BlobPath, AV6ExtraParmsJson, GXv_objcol_SdtMessages_Message1) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            AV5ErrorMsgs = GXv_objcol_SdtMessages_Message1[0] ;
            if ( Cond_result )
            {
               AV10LastErrorType = (byte)(2) ;
               AV25GXV1 = 1 ;
               while ( AV25GXV1 <= AV5ErrorMsgs.size() )
               {
                  AV11Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV5ErrorMsgs.elementAt(-1+AV25GXV1));
                  if ( ! (GXutil.strcmp("", AV12ResultMsg)==0) )
                  {
                     AV12ResultMsg += GXutil.newLine( ) ;
                     if ( ( AV10LastErrorType == 0 ) && ( AV11Message.getgxTv_SdtMessages_Message_Type() == 2 ) )
                     {
                        AV12ResultMsg += GXutil.newLine( ) ;
                     }
                  }
                  AV10LastErrorType = AV11Message.getgxTv_SdtMessages_Message_Type() ;
                  AV12ResultMsg += AV11Message.getgxTv_SdtMessages_Message_Description() ;
                  AV25GXV1 = (int)(AV25GXV1+1) ;
               }
               httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( httpContext.getMessage( "WWP_ImportFile_ImportSuccessTitle", ""), AV12ResultMsg, "success", "", "na", ""));
               this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "WCPopup_Close", new Object[] {AV12ResultMsg}, false);
            }
            else
            {
               AV7FilterToUpload = "" ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
               AV26GXV2 = 1 ;
               while ( AV26GXV2 <= AV5ErrorMsgs.size() )
               {
                  AV11Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV5ErrorMsgs.elementAt(-1+AV26GXV2));
                  if ( ! (GXutil.strcmp("", AV12ResultMsg)==0) )
                  {
                     AV12ResultMsg += GXutil.newLine( ) ;
                     if ( GXutil.strcmp(AV11Message.getgxTv_SdtMessages_Message_Id(), "WWP_LineId") == 0 )
                     {
                        AV12ResultMsg += GXutil.newLine( ) ;
                     }
                  }
                  AV12ResultMsg += AV11Message.getgxTv_SdtMessages_Message_Description() ;
                  AV26GXV2 = (int)(AV26GXV2+1) ;
               }
               httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( httpContext.getMessage( "WWP_ImportFile_ErrorImportingTitle", ""), AV12ResultMsg, "error", "", "false", ""));
            }
         }
         else
         {
            AV7FilterToUpload = "" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
            AV12ResultMsg = GXutil.format( httpContext.getMessage( "WWP_ImportFile_ExpectedFileType", ""), ((GXutil.strcmp(AV9ImportType, "CSV")==0) ? "csv" : "xlsx"), "", "", "", "", "", "", "", "") ;
            httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( httpContext.getMessage( "WWP_ImportFile_ErrorImportingTitle", ""), AV12ResultMsg, "error", "", "na", ""));
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "File", ""), "", "", "", "", "", "", "", ""));
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e142I2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV14TransactionName = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14TransactionName", AV14TransactionName);
      AV9ImportType = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9ImportType", AV9ImportType);
      AV6ExtraParmsJson = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ExtraParmsJson", AV6ExtraParmsJson);
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
      pa2I2( ) ;
      ws2I2( ) ;
      we2I2( ) ;
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
      sCtrlAV14TransactionName = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV9ImportType = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV6ExtraParmsJson = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa2I2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_selectimportfile", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa2I2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV14TransactionName = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14TransactionName", AV14TransactionName);
         AV9ImportType = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9ImportType", AV9ImportType);
         AV6ExtraParmsJson = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ExtraParmsJson", AV6ExtraParmsJson);
      }
      wcpOAV14TransactionName = httpContext.cgiGet( sPrefix+"wcpOAV14TransactionName") ;
      wcpOAV9ImportType = httpContext.cgiGet( sPrefix+"wcpOAV9ImportType") ;
      wcpOAV6ExtraParmsJson = httpContext.cgiGet( sPrefix+"wcpOAV6ExtraParmsJson") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV14TransactionName, wcpOAV14TransactionName) != 0 ) || ( GXutil.strcmp(AV9ImportType, wcpOAV9ImportType) != 0 ) || ( GXutil.strcmp(AV6ExtraParmsJson, wcpOAV6ExtraParmsJson) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV14TransactionName = AV14TransactionName ;
      wcpOAV9ImportType = AV9ImportType ;
      wcpOAV6ExtraParmsJson = AV6ExtraParmsJson ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV14TransactionName = httpContext.cgiGet( sPrefix+"AV14TransactionName_CTRL") ;
      if ( GXutil.len( sCtrlAV14TransactionName) > 0 )
      {
         AV14TransactionName = httpContext.cgiGet( sCtrlAV14TransactionName) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14TransactionName", AV14TransactionName);
      }
      else
      {
         AV14TransactionName = httpContext.cgiGet( sPrefix+"AV14TransactionName_PARM") ;
      }
      sCtrlAV9ImportType = httpContext.cgiGet( sPrefix+"AV9ImportType_CTRL") ;
      if ( GXutil.len( sCtrlAV9ImportType) > 0 )
      {
         AV9ImportType = httpContext.cgiGet( sCtrlAV9ImportType) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9ImportType", AV9ImportType);
      }
      else
      {
         AV9ImportType = httpContext.cgiGet( sPrefix+"AV9ImportType_PARM") ;
      }
      sCtrlAV6ExtraParmsJson = httpContext.cgiGet( sPrefix+"AV6ExtraParmsJson_CTRL") ;
      if ( GXutil.len( sCtrlAV6ExtraParmsJson) > 0 )
      {
         AV6ExtraParmsJson = httpContext.cgiGet( sCtrlAV6ExtraParmsJson) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ExtraParmsJson", AV6ExtraParmsJson);
      }
      else
      {
         AV6ExtraParmsJson = httpContext.cgiGet( sPrefix+"AV6ExtraParmsJson_PARM") ;
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
      pa2I2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws2I2( ) ;
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
      ws2I2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14TransactionName_PARM", AV14TransactionName);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV14TransactionName)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14TransactionName_CTRL", GXutil.rtrim( sCtrlAV14TransactionName));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9ImportType_PARM", AV9ImportType);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV9ImportType)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9ImportType_CTRL", GXutil.rtrim( sCtrlAV9ImportType));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6ExtraParmsJson_PARM", AV6ExtraParmsJson);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6ExtraParmsJson)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6ExtraParmsJson_CTRL", GXutil.rtrim( sCtrlAV6ExtraParmsJson));
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
      we2I2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211164212", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_selectimportfile.js", "?20241211164212", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavFiltertoupload_Internalname = sPrefix+"vFILTERTOUPLOAD" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtnucancel_Internalname = sPrefix+"BTNUCANCEL" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      edtavFiltertoupload_Jsonclick = "" ;
      edtavFiltertoupload_Parameters = "" ;
      edtavFiltertoupload_Contenttype = "" ;
      edtavFiltertoupload_Filetype = "" ;
      edtavFiltertoupload_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      edtavFiltertoupload_Filename = "" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV5ErrorMsgs',fld:'vERRORMSGS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUCANCEL'","{handler:'e112I1',iparms:[]");
      setEventMetadata("'DOUCANCEL'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e132I2',iparms:[{av:'edtavFiltertoupload_Filename',ctrl:'vFILTERTOUPLOAD',prop:'Filename'},{av:'AV7FilterToUpload',fld:'vFILTERTOUPLOAD',pic:''},{av:'AV9ImportType',fld:'vIMPORTTYPE',pic:''},{av:'AV5ErrorMsgs',fld:'vERRORMSGS',pic:'',hsh:true},{av:'AV6ExtraParmsJson',fld:'vEXTRAPARMSJSON',pic:''},{av:'AV14TransactionName',fld:'vTRANSACTIONNAME',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7FilterToUpload',fld:'vFILTERTOUPLOAD',pic:''}]}");
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
      wcpOAV14TransactionName = "" ;
      wcpOAV9ImportType = "" ;
      wcpOAV6ExtraParmsJson = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV14TransactionName = "" ;
      AV9ImportType = "" ;
      AV6ExtraParmsJson = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV5ErrorMsgs = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXKey = "" ;
      GXCCtlgxBlob = "" ;
      AV7FilterToUpload = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      bttBtnenter_Jsonclick = "" ;
      bttBtnucancel_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8FilterToUploadExt = "" ;
      AV15BlobId = "" ;
      AV17BlobRef = "" ;
      AV18Cache = new com.genexus.util.CacheAPI();
      AV19BlobData = new com.mujermorena.wwpbaseobjects.SdtBlobData(remoteHandle, context);
      AV20BlobPath = "" ;
      AV12ResultMsg = "" ;
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      AV11Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV14TransactionName = "" ;
      sCtrlAV9ImportType = "" ;
      sCtrlAV6ExtraParmsJson = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte AV10LastErrorType ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavFiltertoupload_Enabled ;
   private int AV25GXV1 ;
   private int AV26GXV2 ;
   private int idxLst ;
   private String edtavFiltertoupload_Filename ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GXCCtlgxBlob ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableattributes_Internalname ;
   private String edtavFiltertoupload_Internalname ;
   private String TempTags ;
   private String edtavFiltertoupload_Filetype ;
   private String edtavFiltertoupload_Contenttype ;
   private String edtavFiltertoupload_Parameters ;
   private String edtavFiltertoupload_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtnucancel_Internalname ;
   private String bttBtnucancel_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV15BlobId ;
   private String AV17BlobRef ;
   private String AV20BlobPath ;
   private String sCtrlAV14TransactionName ;
   private String sCtrlAV9ImportType ;
   private String sCtrlAV6ExtraParmsJson ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String AV7FilterToUpload ;
   private String wcpOAV14TransactionName ;
   private String wcpOAV9ImportType ;
   private String wcpOAV6ExtraParmsJson ;
   private String AV14TransactionName ;
   private String AV9ImportType ;
   private String AV6ExtraParmsJson ;
   private String AV8FilterToUploadExt ;
   private String AV12ResultMsg ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.CacheAPI AV18Cache ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV5ErrorMsgs ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
   private com.genexus.SdtMessages_Message AV11Message ;
   private com.mujermorena.wwpbaseobjects.SdtBlobData AV19BlobData ;
}

