package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ventasgeneral_impl extends GXWebComponent
{
   public ventasgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ventasgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ventasgeneral_impl.class ));
   }

   public ventasgeneral_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "VentasId") ;
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
               A19VentasId = GXutil.lval( httpContext.GetPar( "VentasId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Long.valueOf(A19VentasId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "VentasId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "VentasId") ;
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
         pa502( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Ventas General", "")) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.ventasgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19VentasId,11,0))}, new String[] {"VentasId"}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA19VentasId", GXutil.ltrim( localUtil.ntoc( wcpOA19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void renderHtmlCloseForm502( )
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
      return "VentasGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Ventas General", "") ;
   }

   public void wb500( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.ventasgeneral");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTransactiondetail_tableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasId_Internalname, httpContext.getMessage( "Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasId_Internalname, GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasFecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasFecha_Internalname, httpContext.getMessage( "Fecha", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtVentasFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasFecha_Internalname, localUtil.format(A91VentasFecha, "99/99/99"), localUtil.format( A91VentasFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasFecha_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtVentasFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtVentasFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_VentasGeneral.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteId_Internalname, httpContext.getMessage( "Cliente Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtClienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClienteId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasSerial_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasSerial_Internalname, httpContext.getMessage( "Serial", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasSerial_Internalname, GXutil.ltrim( localUtil.ntoc( A242VentasSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasSerial_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A242VentasSerial), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A242VentasSerial), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasSerial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasSerial_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Serial", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalExento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalExento_Internalname, httpContext.getMessage( "Total Exento", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalExento_Internalname, GXutil.ltrim( localUtil.ntoc( A239VentasTotalExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalExento_Enabled!=0) ? localUtil.format( A239VentasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A239VentasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalExento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotalExento_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotal5_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotal5_Internalname, httpContext.getMessage( "Total5", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotal5_Internalname, GXutil.ltrim( localUtil.ntoc( A236VentasTotal5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotal5_Enabled!=0) ? localUtil.format( A236VentasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A236VentasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotal5_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotal5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotal10_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotal10_Internalname, httpContext.getMessage( "Total10", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotal10_Internalname, GXutil.ltrim( localUtil.ntoc( A238VentasTotal10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotal10_Enabled!=0) ? localUtil.format( A238VentasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A238VentasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotal10_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotal10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotal_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A240VentasTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotal_Enabled!=0) ? localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalIva5_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalIva5_Internalname, httpContext.getMessage( "Total Iva5", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A235VentasTotalIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalIva5_Enabled!=0) ? localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalIva5_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotalIva5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalIva10_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalIva10_Internalname, httpContext.getMessage( "Total Iva10", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A237VentasTotalIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalIva10_Enabled!=0) ? localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalIva10_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotalIva10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasTotalIVA_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasTotalIVA_Internalname, httpContext.getMessage( "Total IVA", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasTotalIVA_Internalname, GXutil.ltrim( localUtil.ntoc( A241VentasTotalIVA, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasTotalIVA_Enabled!=0) ? localUtil.format( A241VentasTotalIVA, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A241VentasTotalIVA, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasTotalIVA_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasTotalIVA_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasPedido_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasPedido_Internalname, httpContext.getMessage( "Pedido", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasPedido_Internalname, GXutil.ltrim( localUtil.ntoc( A251VentasPedido, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasPedido_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A251VentasPedido), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A251VentasPedido), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasPedido_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasPedido_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoPagoId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoPagoId_Internalname, httpContext.getMessage( "Tipo Pago Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoPagoId_Internalname, GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoPagoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoPagoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoPagoId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoId_Internalname, httpContext.getMessage( "Timbrado Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoId_Internalname, GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTimbradoId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoNumero_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoNumero_Internalname, httpContext.getMessage( "Timbrado Numero", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTimbradoNumero_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Numero", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasSerie1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasSerie1_Internalname, httpContext.getMessage( "Serie1", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasSerie1_Internalname, GXutil.ltrim( localUtil.ntoc( A309VentasSerie1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasSerie1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A309VentasSerie1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A309VentasSerie1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasSerie1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasSerie1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "SerieFac", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasSerie2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasSerie2_Internalname, httpContext.getMessage( "Serie2", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasSerie2_Internalname, GXutil.ltrim( localUtil.ntoc( A310VentasSerie2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasSerie2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A310VentasSerie2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A310VentasSerie2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasSerie2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasSerie2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "SerieFac", "right", false, "", "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasNroFactura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasNroFactura_Internalname, httpContext.getMessage( "Nro Factura", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasNroFactura_Internalname, GXutil.ltrim( localUtil.ntoc( A311VentasNroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtVentasNroFactura_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasNroFactura_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtVentasNroFactura_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_VentasGeneral.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11501_client"+"'", TempTags, "", 2, "HLP_VentasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12501_client"+"'", TempTags, "", 2, "HLP_VentasGeneral.htm");
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

   public void start502( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Ventas General", ""), (short)(0)) ;
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
            strup500( ) ;
         }
      }
   }

   public void ws502( )
   {
      start502( ) ;
      evt502( ) ;
   }

   public void evt502( )
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
                              strup500( ) ;
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
                              strup500( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13502 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup500( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14502 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup500( ) ;
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
                              strup500( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
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

   public void we502( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm502( ) ;
         }
      }
   }

   public void pa502( )
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
      rf502( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "VentasGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf502( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00503 */
         pr_default.execute(0, new Object[] {Long.valueOf(A19VentasId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A311VentasNroFactura = H00503_A311VentasNroFactura[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
            A310VentasSerie2 = H00503_A310VentasSerie2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
            A309VentasSerie1 = H00503_A309VentasSerie1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
            A125TimbradoNumero = H00503_A125TimbradoNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
            A29TimbradoId = H00503_A29TimbradoId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
            A9TipoPagoId = H00503_A9TipoPagoId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
            A251VentasPedido = H00503_A251VentasPedido[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
            A242VentasSerial = H00503_A242VentasSerial[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
            A4ClienteId = H00503_A4ClienteId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
            A91VentasFecha = H00503_A91VentasFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
            A239VentasTotalExento = H00503_A239VentasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A238VentasTotal10 = H00503_A238VentasTotal10[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            A236VentasTotal5 = H00503_A236VentasTotal5[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            A125TimbradoNumero = H00503_A125TimbradoNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
            A239VentasTotalExento = H00503_A239VentasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
            A238VentasTotal10 = H00503_A238VentasTotal10[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
            A236VentasTotal5 = H00503_A236VentasTotal5[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
            /* Execute user event: Load */
            e14502 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb500( ) ;
      }
   }

   public void send_integrity_lvl_hashes502( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "VentasGeneral" ;
      Gx_err = (short)(0) ;
      /* Using cursor H00505 */
      pr_default.execute(1, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A239VentasTotalExento = H00505_A239VentasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A238VentasTotal10 = H00505_A238VentasTotal10[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         A236VentasTotal5 = H00505_A236VentasTotal5[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
      }
      else
      {
         A239VentasTotalExento = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A236VentasTotal5 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A238VentasTotal10 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
      }
      pr_default.close(1);
      A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
      A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
      A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
      A241VentasTotalIVA = A235VentasTotalIva5.add(A237VentasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup500( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13502 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA19VentasId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA19VentasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV13IsAuthorized_Delete = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_DELETE")) ;
         AV12IsAuthorized_Update = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_UPDATE")) ;
         /* Read variables values. */
         A91VentasFecha = localUtil.ctod( httpContext.cgiGet( edtVentasFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
         A4ClienteId = localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A242VentasSerial = localUtil.ctol( httpContext.cgiGet( edtVentasSerial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242VentasSerial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A242VentasSerial), 10, 0));
         A239VentasTotalExento = localUtil.ctond( httpContext.cgiGet( edtVentasTotalExento_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A239VentasTotalExento", GXutil.ltrimstr( A239VentasTotalExento, 17, 2));
         A236VentasTotal5 = localUtil.ctond( httpContext.cgiGet( edtVentasTotal5_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A236VentasTotal5", GXutil.ltrimstr( A236VentasTotal5, 17, 2));
         A238VentasTotal10 = localUtil.ctond( httpContext.cgiGet( edtVentasTotal10_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A238VentasTotal10", GXutil.ltrimstr( A238VentasTotal10, 17, 2));
         A240VentasTotal = localUtil.ctond( httpContext.cgiGet( edtVentasTotal_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A240VentasTotal", GXutil.ltrimstr( A240VentasTotal, 17, 2));
         A235VentasTotalIva5 = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIva5_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A235VentasTotalIva5", GXutil.ltrimstr( A235VentasTotalIva5, 17, 2));
         A237VentasTotalIva10 = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIva10_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A237VentasTotalIva10", GXutil.ltrimstr( A237VentasTotalIva10, 17, 2));
         A241VentasTotalIVA = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIVA_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A241VentasTotalIVA", GXutil.ltrimstr( A241VentasTotalIVA, 17, 2));
         A251VentasPedido = localUtil.ctol( httpContext.cgiGet( edtVentasPedido_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251VentasPedido", GXutil.ltrimstr( DecimalUtil.doubleToDec(A251VentasPedido), 11, 0));
         A9TipoPagoId = localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         A29TimbradoId = localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         A125TimbradoNumero = localUtil.ctol( httpContext.cgiGet( edtTimbradoNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A125TimbradoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125TimbradoNumero), 10, 0));
         A309VentasSerie1 = (short)(localUtil.ctol( httpContext.cgiGet( edtVentasSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A309VentasSerie1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A309VentasSerie1), 3, 0));
         A310VentasSerie2 = (short)(localUtil.ctol( httpContext.cgiGet( edtVentasSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310VentasSerie2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A310VentasSerie2), 3, 0));
         A311VentasNroFactura = localUtil.ctol( httpContext.cgiGet( edtVentasNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311VentasNroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311VentasNroFactura), 15, 0));
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
      e13502 ();
      if (returnInSub) return;
   }

   public void e13502( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14502( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12IsAuthorized_Update ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventas_Update", GXv_boolean3) ;
      ventasgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12IsAuthorized_Update = GXt_boolean2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12IsAuthorized_Update", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      if ( ! ( AV12IsAuthorized_Update ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV13IsAuthorized_Delete ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventas_Delete", GXv_boolean3) ;
      ventasgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13IsAuthorized_Delete = GXt_boolean2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13IsAuthorized_Delete", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
      if ( ! ( AV13IsAuthorized_Delete ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext)new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV17Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Ventas" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A19VentasId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
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
      pa502( ) ;
      ws502( ) ;
      we502( ) ;
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
      sCtrlA19VentasId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa502( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "ventasgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa502( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A19VentasId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      }
      wcpOA19VentasId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA19VentasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ! GetJustCreated( ) && ( ( A19VentasId != wcpOA19VentasId ) ) )
      {
         setjustcreated();
      }
      wcpOA19VentasId = A19VentasId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA19VentasId = httpContext.cgiGet( sPrefix+"A19VentasId_CTRL") ;
      if ( GXutil.len( sCtrlA19VentasId) > 0 )
      {
         A19VentasId = localUtil.ctol( httpContext.cgiGet( sCtrlA19VentasId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      }
      else
      {
         A19VentasId = localUtil.ctol( httpContext.cgiGet( sPrefix+"A19VentasId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
      pa502( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws502( ) ;
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
      ws502( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A19VentasId_PARM", GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA19VentasId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A19VentasId_CTRL", GXutil.rtrim( sCtrlA19VentasId));
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
      we502( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211195051", true, true);
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
      httpContext.AddJavascriptSource("ventasgeneral.js", "?20241211195051", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtVentasId_Internalname = sPrefix+"VENTASID" ;
      edtVentasFecha_Internalname = sPrefix+"VENTASFECHA" ;
      edtClienteId_Internalname = sPrefix+"CLIENTEID" ;
      edtVentasSerial_Internalname = sPrefix+"VENTASSERIAL" ;
      edtVentasTotalExento_Internalname = sPrefix+"VENTASTOTALEXENTO" ;
      edtVentasTotal5_Internalname = sPrefix+"VENTASTOTAL5" ;
      edtVentasTotal10_Internalname = sPrefix+"VENTASTOTAL10" ;
      edtVentasTotal_Internalname = sPrefix+"VENTASTOTAL" ;
      edtVentasTotalIva5_Internalname = sPrefix+"VENTASTOTALIVA5" ;
      edtVentasTotalIva10_Internalname = sPrefix+"VENTASTOTALIVA10" ;
      edtVentasTotalIVA_Internalname = sPrefix+"VENTASTOTALIVA" ;
      edtVentasPedido_Internalname = sPrefix+"VENTASPEDIDO" ;
      edtTipoPagoId_Internalname = sPrefix+"TIPOPAGOID" ;
      edtTimbradoId_Internalname = sPrefix+"TIMBRADOID" ;
      edtTimbradoNumero_Internalname = sPrefix+"TIMBRADONUMERO" ;
      edtVentasSerie1_Internalname = sPrefix+"VENTASSERIE1" ;
      edtVentasSerie2_Internalname = sPrefix+"VENTASSERIE2" ;
      edtVentasNroFactura_Internalname = sPrefix+"VENTASNROFACTURA" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
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
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtVentasNroFactura_Jsonclick = "" ;
      edtVentasNroFactura_Enabled = 0 ;
      edtVentasSerie2_Jsonclick = "" ;
      edtVentasSerie2_Enabled = 0 ;
      edtVentasSerie1_Jsonclick = "" ;
      edtVentasSerie1_Enabled = 0 ;
      edtTimbradoNumero_Jsonclick = "" ;
      edtTimbradoNumero_Enabled = 0 ;
      edtTimbradoId_Jsonclick = "" ;
      edtTimbradoId_Enabled = 0 ;
      edtTipoPagoId_Jsonclick = "" ;
      edtTipoPagoId_Enabled = 0 ;
      edtVentasPedido_Jsonclick = "" ;
      edtVentasPedido_Enabled = 0 ;
      edtVentasTotalIVA_Jsonclick = "" ;
      edtVentasTotalIVA_Enabled = 0 ;
      edtVentasTotalIva10_Jsonclick = "" ;
      edtVentasTotalIva10_Enabled = 0 ;
      edtVentasTotalIva5_Jsonclick = "" ;
      edtVentasTotalIva5_Enabled = 0 ;
      edtVentasTotal_Jsonclick = "" ;
      edtVentasTotal_Enabled = 0 ;
      edtVentasTotal10_Jsonclick = "" ;
      edtVentasTotal10_Enabled = 0 ;
      edtVentasTotal5_Jsonclick = "" ;
      edtVentasTotal5_Enabled = 0 ;
      edtVentasTotalExento_Jsonclick = "" ;
      edtVentasTotalExento_Enabled = 0 ;
      edtVentasSerial_Jsonclick = "" ;
      edtVentasSerial_Enabled = 0 ;
      edtClienteId_Jsonclick = "" ;
      edtClienteId_Enabled = 0 ;
      edtVentasFecha_Jsonclick = "" ;
      edtVentasFecha_Enabled = 0 ;
      edtVentasId_Jsonclick = "" ;
      edtVentasId_Enabled = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'},{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11501',iparms:[{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[{ctrl:'BTNUPDATE',prop:'Visible'}]}");
      setEventMetadata("'DODELETE'","{handler:'e12501',iparms:[{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[{ctrl:'BTNDELETE',prop:'Visible'}]}");
      setEventMetadata("VALID_VENTASID","{handler:'valid_Ventasid',iparms:[]");
      setEventMetadata("VALID_VENTASID",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTALEXENTO","{handler:'valid_Ventastotalexento',iparms:[]");
      setEventMetadata("VALID_VENTASTOTALEXENTO",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTAL5","{handler:'valid_Ventastotal5',iparms:[]");
      setEventMetadata("VALID_VENTASTOTAL5",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTAL10","{handler:'valid_Ventastotal10',iparms:[]");
      setEventMetadata("VALID_VENTASTOTAL10",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTALIVA5","{handler:'valid_Ventastotaliva5',iparms:[]");
      setEventMetadata("VALID_VENTASTOTALIVA5",",oparms:[]}");
      setEventMetadata("VALID_VENTASTOTALIVA10","{handler:'valid_Ventastotaliva10',iparms:[]");
      setEventMetadata("VALID_VENTASTOTALIVA10",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOID","{handler:'valid_Timbradoid',iparms:[]");
      setEventMetadata("VALID_TIMBRADOID",",oparms:[]}");
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
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A91VentasFecha = GXutil.nullDate() ;
      A239VentasTotalExento = DecimalUtil.ZERO ;
      A236VentasTotal5 = DecimalUtil.ZERO ;
      A238VentasTotal10 = DecimalUtil.ZERO ;
      A240VentasTotal = DecimalUtil.ZERO ;
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      A241VentasTotalIVA = DecimalUtil.ZERO ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H00503_A19VentasId = new long[1] ;
      H00503_A311VentasNroFactura = new long[1] ;
      H00503_A310VentasSerie2 = new short[1] ;
      H00503_A309VentasSerie1 = new short[1] ;
      H00503_A125TimbradoNumero = new long[1] ;
      H00503_A29TimbradoId = new long[1] ;
      H00503_A9TipoPagoId = new long[1] ;
      H00503_A251VentasPedido = new long[1] ;
      H00503_A242VentasSerial = new long[1] ;
      H00503_A4ClienteId = new long[1] ;
      H00503_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00503_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00503_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00503_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00505_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00505_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00505_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA19VentasId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ventasgeneral__default(),
         new Object[] {
             new Object[] {
            H00503_A19VentasId, H00503_A311VentasNroFactura, H00503_A310VentasSerie2, H00503_A309VentasSerie1, H00503_A125TimbradoNumero, H00503_A29TimbradoId, H00503_A9TipoPagoId, H00503_A251VentasPedido, H00503_A242VentasSerial, H00503_A4ClienteId,
            H00503_A91VentasFecha, H00503_A239VentasTotalExento, H00503_A238VentasTotal10, H00503_A236VentasTotal5
            }
            , new Object[] {
            H00505_A239VentasTotalExento, H00505_A238VentasTotal10, H00505_A236VentasTotal5
            }
         }
      );
      AV17Pgmname = "VentasGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "VentasGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short A309VentasSerie1 ;
   private short A310VentasSerie2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtVentasId_Enabled ;
   private int edtVentasFecha_Enabled ;
   private int edtClienteId_Enabled ;
   private int edtVentasSerial_Enabled ;
   private int edtVentasTotalExento_Enabled ;
   private int edtVentasTotal5_Enabled ;
   private int edtVentasTotal10_Enabled ;
   private int edtVentasTotal_Enabled ;
   private int edtVentasTotalIva5_Enabled ;
   private int edtVentasTotalIva10_Enabled ;
   private int edtVentasTotalIVA_Enabled ;
   private int edtVentasPedido_Enabled ;
   private int edtTipoPagoId_Enabled ;
   private int edtTimbradoId_Enabled ;
   private int edtTimbradoNumero_Enabled ;
   private int edtVentasSerie1_Enabled ;
   private int edtVentasSerie2_Enabled ;
   private int edtVentasNroFactura_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private long wcpOA19VentasId ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A242VentasSerial ;
   private long A251VentasPedido ;
   private long A9TipoPagoId ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A311VentasNroFactura ;
   private java.math.BigDecimal A239VentasTotalExento ;
   private java.math.BigDecimal A236VentasTotal5 ;
   private java.math.BigDecimal A238VentasTotal10 ;
   private java.math.BigDecimal A240VentasTotal ;
   private java.math.BigDecimal A235VentasTotalIva5 ;
   private java.math.BigDecimal A237VentasTotalIva10 ;
   private java.math.BigDecimal A241VentasTotalIVA ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtVentasId_Internalname ;
   private String edtVentasId_Jsonclick ;
   private String edtVentasFecha_Internalname ;
   private String edtVentasFecha_Jsonclick ;
   private String edtClienteId_Internalname ;
   private String edtClienteId_Jsonclick ;
   private String edtVentasSerial_Internalname ;
   private String edtVentasSerial_Jsonclick ;
   private String edtVentasTotalExento_Internalname ;
   private String edtVentasTotalExento_Jsonclick ;
   private String edtVentasTotal5_Internalname ;
   private String edtVentasTotal5_Jsonclick ;
   private String edtVentasTotal10_Internalname ;
   private String edtVentasTotal10_Jsonclick ;
   private String edtVentasTotal_Internalname ;
   private String edtVentasTotal_Jsonclick ;
   private String edtVentasTotalIva5_Internalname ;
   private String edtVentasTotalIva5_Jsonclick ;
   private String edtVentasTotalIva10_Internalname ;
   private String edtVentasTotalIva10_Jsonclick ;
   private String edtVentasTotalIVA_Internalname ;
   private String edtVentasTotalIVA_Jsonclick ;
   private String edtVentasPedido_Internalname ;
   private String edtVentasPedido_Jsonclick ;
   private String edtTipoPagoId_Internalname ;
   private String edtTipoPagoId_Jsonclick ;
   private String edtTimbradoId_Internalname ;
   private String edtTimbradoId_Jsonclick ;
   private String edtTimbradoNumero_Internalname ;
   private String edtTimbradoNumero_Jsonclick ;
   private String edtVentasSerie1_Internalname ;
   private String edtVentasSerie1_Jsonclick ;
   private String edtVentasSerie2_Internalname ;
   private String edtVentasSerie2_Jsonclick ;
   private String edtVentasNroFactura_Internalname ;
   private String edtVentasNroFactura_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlA19VentasId ;
   private java.util.Date A91VentasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV12IsAuthorized_Update ;
   private boolean AV13IsAuthorized_Delete ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private long[] H00503_A19VentasId ;
   private long[] H00503_A311VentasNroFactura ;
   private short[] H00503_A310VentasSerie2 ;
   private short[] H00503_A309VentasSerie1 ;
   private long[] H00503_A125TimbradoNumero ;
   private long[] H00503_A29TimbradoId ;
   private long[] H00503_A9TipoPagoId ;
   private long[] H00503_A251VentasPedido ;
   private long[] H00503_A242VentasSerial ;
   private long[] H00503_A4ClienteId ;
   private java.util.Date[] H00503_A91VentasFecha ;
   private java.math.BigDecimal[] H00503_A239VentasTotalExento ;
   private java.math.BigDecimal[] H00503_A238VentasTotal10 ;
   private java.math.BigDecimal[] H00503_A236VentasTotal5 ;
   private java.math.BigDecimal[] H00505_A239VentasTotalExento ;
   private java.math.BigDecimal[] H00505_A238VentasTotal10 ;
   private java.math.BigDecimal[] H00505_A236VentasTotal5 ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class ventasgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00503", "SELECT T1.[VentasId], T1.[VentasNroFactura], T1.[VentasSerie2], T1.[VentasSerie1], T2.[TimbradoNumero], T1.[TimbradoId], T1.[TipoPagoId], T1.[VentasPedido], T1.[VentasSerial], T1.[ClienteId], T1.[VentasFecha], COALESCE( T3.[VentasTotalExento], 0) AS VentasTotalExento, COALESCE( T3.[VentasTotal10], 0) AS VentasTotal10, COALESCE( T3.[VentasTotal5], 0) AS VentasTotal5 FROM (([Ventas] T1 INNER JOIN [Timbrado] T2 ON T2.[TimbradoId] = T1.[TimbradoId]) LEFT JOIN (SELECT T4.[VentasId], SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 0 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 5 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 10 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10 FROM (([VentasDetalle] T4 INNER JOIN [Articulo] T5 ON T5.[ArticuloId] = T4.[ArticuloId]) INNER JOIN [Impuesto] T6 ON T6.[ImpuestoId] = T5.[ImpuestoId]) GROUP BY T4.[VentasId] ) T3 ON T3.[VentasId] = T1.[VentasId]) WHERE T1.[VentasId] = ? ORDER BY T1.[VentasId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00505", "SELECT COALESCE( T1.[VentasTotalExento], 0) AS VentasTotalExento, COALESCE( T1.[VentasTotal10], 0) AS VentasTotal10, COALESCE( T1.[VentasTotal5], 0) AS VentasTotal5 FROM (SELECT T2.[VentasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[VentasDetalleCantidad] * CAST(T3.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10 FROM (([VentasDetalle] T2 INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[VentasId] ) T1 WHERE T1.[VentasId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
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
      }
   }

}

