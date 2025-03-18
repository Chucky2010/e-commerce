package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class movimientocajageneral_impl extends GXWebComponent
{
   public movimientocajageneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public movimientocajageneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( movimientocajageneral_impl.class ));
   }

   public movimientocajageneral_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "MovimientoCajaId") ;
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
               A27MovimientoCajaId = GXutil.lval( httpContext.GetPar( "MovimientoCajaId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Long.valueOf(A27MovimientoCajaId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "MovimientoCajaId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "MovimientoCajaId") ;
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
         pa5K2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Movimiento Caja General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.movimientocajageneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A27MovimientoCajaId,11,0))}, new String[] {"MovimientoCajaId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA27MovimientoCajaId", GXutil.ltrim( localUtil.ntoc( wcpOA27MovimientoCajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void renderHtmlCloseForm5K2( )
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
      return "MovimientoCajaGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Movimiento Caja General", "") ;
   }

   public void wb5K0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.movimientocajageneral");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaId_Internalname, httpContext.getMessage( "Caja Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaId_Internalname, GXutil.ltrim( localUtil.ntoc( A27MovimientoCajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A27MovimientoCajaId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A27MovimientoCajaId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaHora_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaHora_Internalname, httpContext.getMessage( "Caja Hora", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtMovimientoCajaHora_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaHora_Internalname, localUtil.ttoc( A116MovimientoCajaHora, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A116MovimientoCajaHora, "99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaHora_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaHora_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Time", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtMovimientoCajaHora_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMovimientoCajaHora_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_MovimientoCajaGeneral.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaIngreso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaIngreso_Internalname, httpContext.getMessage( "Caja Ingreso", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaIngreso_Internalname, GXutil.ltrim( localUtil.ntoc( A117MovimientoCajaIngreso, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaIngreso_Enabled!=0) ? localUtil.format( A117MovimientoCajaIngreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A117MovimientoCajaIngreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaIngreso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaIngreso_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaEgreso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaEgreso_Internalname, httpContext.getMessage( "Caja Egreso", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaEgreso_Internalname, GXutil.ltrim( localUtil.ntoc( A118MovimientoCajaEgreso, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaEgreso_Enabled!=0) ? localUtil.format( A118MovimientoCajaEgreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A118MovimientoCajaEgreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaEgreso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaEgreso_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaSaldo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaSaldo_Internalname, httpContext.getMessage( "Caja Saldo", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A119MovimientoCajaSaldo, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMovimientoCajaSaldo_Enabled!=0) ? localUtil.format( A119MovimientoCajaSaldo, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A119MovimientoCajaSaldo, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaSaldo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaSaldo_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaFecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaFecha_Internalname, httpContext.getMessage( "Caja Fecha", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtMovimientoCajaFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaFecha_Internalname, localUtil.format(A120MovimientoCajaFecha, "99/99/99"), localUtil.format( A120MovimientoCajaFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaFecha_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtMovimientoCajaFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMovimientoCajaFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_MovimientoCajaGeneral.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajeroId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajeroId_Internalname, httpContext.getMessage( "Cajero Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajeroId_Internalname, GXutil.ltrim( localUtil.ntoc( A26CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCajeroId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A26CajeroId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A26CajeroId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajeroId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCajeroId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajeroNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajeroNombre_Internalname, httpContext.getMessage( "Cajero Nombre", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajeroNombre_Internalname, GXutil.rtrim( A112CajeroNombre), GXutil.rtrim( localUtil.format( A112CajeroNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajeroNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCajeroNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajaId_Internalname, httpContext.getMessage( "Caja Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajaId_Internalname, GXutil.ltrim( localUtil.ntoc( A25CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCajaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A25CajaId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A25CajaId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCajaId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajaNumero_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajaNumero_Internalname, httpContext.getMessage( "Caja Numero", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajaNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A110CajaNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCajaNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A110CajaNumero), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A110CajaNumero), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajaNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCajaNumero_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Numero", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaAsignacion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaAsignacion_Internalname, httpContext.getMessage( "Caja Asignacion", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaAsignacion_Internalname, GXutil.rtrim( A256MovimientoCajaAsignacion), GXutil.rtrim( localUtil.format( A256MovimientoCajaAsignacion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaAsignacion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaAsignacion_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaDocum_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaDocum_Internalname, httpContext.getMessage( "Informacion", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaDocum_Internalname, A266MovimientoCajaDocum, GXutil.rtrim( localUtil.format( A266MovimientoCajaDocum, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaDocum_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaDocum_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMovimientoCajaEstado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMovimientoCajaEstado_Internalname, httpContext.getMessage( "Caja Estado", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMovimientoCajaEstado_Internalname, GXutil.rtrim( A267MovimientoCajaEstado), GXutil.rtrim( localUtil.format( A267MovimientoCajaEstado, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMovimientoCajaEstado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMovimientoCajaEstado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSaldoactual_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSaldoactual_Internalname, httpContext.getMessage( "Saldo Actual", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSaldoactual_Internalname, GXutil.ltrim( localUtil.ntoc( AV15SaldoActual, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavSaldoactual_Enabled!=0) ? localUtil.format( AV15SaldoActual, "ZZZZZZZZZZZZZZ9.99") : localUtil.format( AV15SaldoActual, "ZZZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,72);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSaldoactual_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSaldoactual_Enabled, 0, "text", "", 18, "chr", 1, "row", 18, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MovimientoCajaGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e115k1_client"+"'", TempTags, "", 2, "HLP_MovimientoCajaGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e125k1_client"+"'", TempTags, "", 2, "HLP_MovimientoCajaGeneral.htm");
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

   public void start5K2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Movimiento Caja General", ""), (short)(0)) ;
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
            strup5K0( ) ;
         }
      }
   }

   public void ws5K2( )
   {
      start5K2( ) ;
      evt5K2( ) ;
   }

   public void evt5K2( )
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
                              strup5K0( ) ;
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
                              strup5K0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e135K2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5K0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e145K2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5K0( ) ;
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
                              strup5K0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavSaldoactual_Internalname ;
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

   public void we5K2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm5K2( ) ;
         }
      }
   }

   public void pa5K2( )
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
            GX_FocusControl = edtavSaldoactual_Internalname ;
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
      rf5K2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "MovimientoCajaGeneral" ;
      Gx_err = (short)(0) ;
      edtavSaldoactual_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSaldoactual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSaldoactual_Enabled), 5, 0), true);
   }

   public void rf5K2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H005K2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A27MovimientoCajaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A267MovimientoCajaEstado = H005K2_A267MovimientoCajaEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A267MovimientoCajaEstado", A267MovimientoCajaEstado);
            A266MovimientoCajaDocum = H005K2_A266MovimientoCajaDocum[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A266MovimientoCajaDocum", A266MovimientoCajaDocum);
            A256MovimientoCajaAsignacion = H005K2_A256MovimientoCajaAsignacion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
            A110CajaNumero = H005K2_A110CajaNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
            A25CajaId = H005K2_A25CajaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
            A112CajeroNombre = H005K2_A112CajeroNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A112CajeroNombre", A112CajeroNombre);
            A26CajeroId = H005K2_A26CajeroId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
            A120MovimientoCajaFecha = H005K2_A120MovimientoCajaFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
            A119MovimientoCajaSaldo = H005K2_A119MovimientoCajaSaldo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
            A118MovimientoCajaEgreso = H005K2_A118MovimientoCajaEgreso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
            A117MovimientoCajaIngreso = H005K2_A117MovimientoCajaIngreso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
            A116MovimientoCajaHora = H005K2_A116MovimientoCajaHora[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            A110CajaNumero = H005K2_A110CajaNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
            A112CajeroNombre = H005K2_A112CajeroNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A112CajeroNombre", A112CajeroNombre);
            /* Execute user event: Load */
            e145K2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb5K0( ) ;
      }
   }

   public void send_integrity_lvl_hashes5K2( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "MovimientoCajaGeneral" ;
      Gx_err = (short)(0) ;
      edtavSaldoactual_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSaldoactual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSaldoactual_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup5K0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e135K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA27MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA27MovimientoCajaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV13IsAuthorized_Delete = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_DELETE")) ;
         AV12IsAuthorized_Update = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_UPDATE")) ;
         /* Read variables values. */
         A116MovimientoCajaHora = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtMovimientoCajaHora_Internalname))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A116MovimientoCajaHora", localUtil.ttoc( A116MovimientoCajaHora, 0, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A117MovimientoCajaIngreso = localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaIngreso_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A117MovimientoCajaIngreso", GXutil.ltrimstr( A117MovimientoCajaIngreso, 17, 2));
         A118MovimientoCajaEgreso = localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaEgreso_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A118MovimientoCajaEgreso", GXutil.ltrimstr( A118MovimientoCajaEgreso, 17, 2));
         A119MovimientoCajaSaldo = localUtil.ctond( httpContext.cgiGet( edtMovimientoCajaSaldo_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A119MovimientoCajaSaldo", GXutil.ltrimstr( A119MovimientoCajaSaldo, 17, 2));
         A120MovimientoCajaFecha = localUtil.ctod( httpContext.cgiGet( edtMovimientoCajaFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A120MovimientoCajaFecha", localUtil.format(A120MovimientoCajaFecha, "99/99/99"));
         A26CajeroId = localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         A112CajeroNombre = httpContext.cgiGet( edtCajeroNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A112CajeroNombre", A112CajeroNombre);
         A25CajaId = localUtil.ctol( httpContext.cgiGet( edtCajaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25CajaId), 11, 0));
         A110CajaNumero = localUtil.ctol( httpContext.cgiGet( edtCajaNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A110CajaNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A110CajaNumero), 10, 0));
         A256MovimientoCajaAsignacion = httpContext.cgiGet( edtMovimientoCajaAsignacion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A256MovimientoCajaAsignacion", A256MovimientoCajaAsignacion);
         A266MovimientoCajaDocum = httpContext.cgiGet( edtMovimientoCajaDocum_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A266MovimientoCajaDocum", A266MovimientoCajaDocum);
         A267MovimientoCajaEstado = httpContext.cgiGet( edtMovimientoCajaEstado_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A267MovimientoCajaEstado", A267MovimientoCajaEstado);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavSaldoactual_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavSaldoactual_Internalname)), DecimalUtil.stringToDec("999999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSALDOACTUAL");
            GX_FocusControl = edtavSaldoactual_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV15SaldoActual = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15SaldoActual", GXutil.ltrimstr( AV15SaldoActual, 18, 2));
         }
         else
         {
            AV15SaldoActual = localUtil.ctond( httpContext.cgiGet( edtavSaldoactual_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15SaldoActual", GXutil.ltrimstr( AV15SaldoActual, 18, 2));
         }
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
      e135K2 ();
      if (returnInSub) return;
   }

   public void e135K2( )
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

   protected void e145K2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12IsAuthorized_Update ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "movimientocaja_Update", GXv_boolean3) ;
      movimientocajageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "movimientocaja_Delete", GXv_boolean3) ;
      movimientocajageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV18Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "MovimientoCaja" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A27MovimientoCajaId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
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
      pa5K2( ) ;
      ws5K2( ) ;
      we5K2( ) ;
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
      sCtrlA27MovimientoCajaId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa5K2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "movimientocajageneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa5K2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A27MovimientoCajaId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      }
      wcpOA27MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA27MovimientoCajaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ! GetJustCreated( ) && ( ( A27MovimientoCajaId != wcpOA27MovimientoCajaId ) ) )
      {
         setjustcreated();
      }
      wcpOA27MovimientoCajaId = A27MovimientoCajaId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA27MovimientoCajaId = httpContext.cgiGet( sPrefix+"A27MovimientoCajaId_CTRL") ;
      if ( GXutil.len( sCtrlA27MovimientoCajaId) > 0 )
      {
         A27MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( sCtrlA27MovimientoCajaId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27MovimientoCajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27MovimientoCajaId), 11, 0));
      }
      else
      {
         A27MovimientoCajaId = localUtil.ctol( httpContext.cgiGet( sPrefix+"A27MovimientoCajaId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
      pa5K2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws5K2( ) ;
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
      ws5K2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A27MovimientoCajaId_PARM", GXutil.ltrim( localUtil.ntoc( A27MovimientoCajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA27MovimientoCajaId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A27MovimientoCajaId_CTRL", GXutil.rtrim( sCtrlA27MovimientoCajaId));
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
      we5K2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211194748", true, true);
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
      httpContext.AddJavascriptSource("movimientocajageneral.js", "?20241211194750", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtMovimientoCajaId_Internalname = sPrefix+"MOVIMIENTOCAJAID" ;
      edtMovimientoCajaHora_Internalname = sPrefix+"MOVIMIENTOCAJAHORA" ;
      edtMovimientoCajaIngreso_Internalname = sPrefix+"MOVIMIENTOCAJAINGRESO" ;
      edtMovimientoCajaEgreso_Internalname = sPrefix+"MOVIMIENTOCAJAEGRESO" ;
      edtMovimientoCajaSaldo_Internalname = sPrefix+"MOVIMIENTOCAJASALDO" ;
      edtMovimientoCajaFecha_Internalname = sPrefix+"MOVIMIENTOCAJAFECHA" ;
      edtCajeroId_Internalname = sPrefix+"CAJEROID" ;
      edtCajeroNombre_Internalname = sPrefix+"CAJERONOMBRE" ;
      edtCajaId_Internalname = sPrefix+"CAJAID" ;
      edtCajaNumero_Internalname = sPrefix+"CAJANUMERO" ;
      edtMovimientoCajaAsignacion_Internalname = sPrefix+"MOVIMIENTOCAJAASIGNACION" ;
      edtMovimientoCajaDocum_Internalname = sPrefix+"MOVIMIENTOCAJADOCUM" ;
      edtMovimientoCajaEstado_Internalname = sPrefix+"MOVIMIENTOCAJAESTADO" ;
      edtavSaldoactual_Internalname = sPrefix+"vSALDOACTUAL" ;
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
      edtavSaldoactual_Jsonclick = "" ;
      edtavSaldoactual_Enabled = 1 ;
      edtMovimientoCajaEstado_Jsonclick = "" ;
      edtMovimientoCajaEstado_Enabled = 0 ;
      edtMovimientoCajaDocum_Jsonclick = "" ;
      edtMovimientoCajaDocum_Enabled = 0 ;
      edtMovimientoCajaAsignacion_Jsonclick = "" ;
      edtMovimientoCajaAsignacion_Enabled = 0 ;
      edtCajaNumero_Jsonclick = "" ;
      edtCajaNumero_Enabled = 0 ;
      edtCajaId_Jsonclick = "" ;
      edtCajaId_Enabled = 0 ;
      edtCajeroNombre_Jsonclick = "" ;
      edtCajeroNombre_Enabled = 0 ;
      edtCajeroId_Jsonclick = "" ;
      edtCajeroId_Enabled = 0 ;
      edtMovimientoCajaFecha_Jsonclick = "" ;
      edtMovimientoCajaFecha_Enabled = 0 ;
      edtMovimientoCajaSaldo_Jsonclick = "" ;
      edtMovimientoCajaSaldo_Enabled = 0 ;
      edtMovimientoCajaEgreso_Jsonclick = "" ;
      edtMovimientoCajaEgreso_Enabled = 0 ;
      edtMovimientoCajaIngreso_Jsonclick = "" ;
      edtMovimientoCajaIngreso_Enabled = 0 ;
      edtMovimientoCajaHora_Jsonclick = "" ;
      edtMovimientoCajaHora_Enabled = 0 ;
      edtMovimientoCajaId_Jsonclick = "" ;
      edtMovimientoCajaId_Enabled = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A27MovimientoCajaId',fld:'MOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9'},{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e115K1',iparms:[{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A27MovimientoCajaId',fld:'MOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[{ctrl:'BTNUPDATE',prop:'Visible'}]}");
      setEventMetadata("'DODELETE'","{handler:'e125K1',iparms:[{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A27MovimientoCajaId',fld:'MOVIMIENTOCAJAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[{ctrl:'BTNDELETE',prop:'Visible'}]}");
      setEventMetadata("VALID_MOVIMIENTOCAJAID","{handler:'valid_Movimientocajaid',iparms:[]");
      setEventMetadata("VALID_MOVIMIENTOCAJAID",",oparms:[]}");
      setEventMetadata("VALID_CAJEROID","{handler:'valid_Cajeroid',iparms:[]");
      setEventMetadata("VALID_CAJEROID",",oparms:[]}");
      setEventMetadata("VALID_CAJAID","{handler:'valid_Cajaid',iparms:[]");
      setEventMetadata("VALID_CAJAID",",oparms:[]}");
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
      A116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      A120MovimientoCajaFecha = GXutil.nullDate() ;
      A112CajeroNombre = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A266MovimientoCajaDocum = "" ;
      A267MovimientoCajaEstado = "" ;
      TempTags = "" ;
      AV15SaldoActual = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV18Pgmname = "" ;
      scmdbuf = "" ;
      H005K2_A27MovimientoCajaId = new long[1] ;
      H005K2_A267MovimientoCajaEstado = new String[] {""} ;
      H005K2_A266MovimientoCajaDocum = new String[] {""} ;
      H005K2_A256MovimientoCajaAsignacion = new String[] {""} ;
      H005K2_A110CajaNumero = new long[1] ;
      H005K2_A25CajaId = new long[1] ;
      H005K2_A112CajeroNombre = new String[] {""} ;
      H005K2_A26CajeroId = new long[1] ;
      H005K2_A120MovimientoCajaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H005K2_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H005K2_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H005K2_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H005K2_A116MovimientoCajaHora = new java.util.Date[] {GXutil.nullDate()} ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA27MovimientoCajaId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.movimientocajageneral__default(),
         new Object[] {
             new Object[] {
            H005K2_A27MovimientoCajaId, H005K2_A267MovimientoCajaEstado, H005K2_A266MovimientoCajaDocum, H005K2_A256MovimientoCajaAsignacion, H005K2_A110CajaNumero, H005K2_A25CajaId, H005K2_A112CajeroNombre, H005K2_A26CajeroId, H005K2_A120MovimientoCajaFecha, H005K2_A119MovimientoCajaSaldo,
            H005K2_A118MovimientoCajaEgreso, H005K2_A117MovimientoCajaIngreso, H005K2_A116MovimientoCajaHora
            }
         }
      );
      AV18Pgmname = "MovimientoCajaGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "MovimientoCajaGeneral" ;
      Gx_err = (short)(0) ;
      edtavSaldoactual_Enabled = 0 ;
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
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtMovimientoCajaId_Enabled ;
   private int edtMovimientoCajaHora_Enabled ;
   private int edtMovimientoCajaIngreso_Enabled ;
   private int edtMovimientoCajaEgreso_Enabled ;
   private int edtMovimientoCajaSaldo_Enabled ;
   private int edtMovimientoCajaFecha_Enabled ;
   private int edtCajeroId_Enabled ;
   private int edtCajeroNombre_Enabled ;
   private int edtCajaId_Enabled ;
   private int edtCajaNumero_Enabled ;
   private int edtMovimientoCajaAsignacion_Enabled ;
   private int edtMovimientoCajaDocum_Enabled ;
   private int edtMovimientoCajaEstado_Enabled ;
   private int edtavSaldoactual_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private long wcpOA27MovimientoCajaId ;
   private long A27MovimientoCajaId ;
   private long A26CajeroId ;
   private long A25CajaId ;
   private long A110CajaNumero ;
   private java.math.BigDecimal A117MovimientoCajaIngreso ;
   private java.math.BigDecimal A118MovimientoCajaEgreso ;
   private java.math.BigDecimal A119MovimientoCajaSaldo ;
   private java.math.BigDecimal AV15SaldoActual ;
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
   private String edtMovimientoCajaId_Internalname ;
   private String edtMovimientoCajaId_Jsonclick ;
   private String edtMovimientoCajaHora_Internalname ;
   private String edtMovimientoCajaHora_Jsonclick ;
   private String edtMovimientoCajaIngreso_Internalname ;
   private String edtMovimientoCajaIngreso_Jsonclick ;
   private String edtMovimientoCajaEgreso_Internalname ;
   private String edtMovimientoCajaEgreso_Jsonclick ;
   private String edtMovimientoCajaSaldo_Internalname ;
   private String edtMovimientoCajaSaldo_Jsonclick ;
   private String edtMovimientoCajaFecha_Internalname ;
   private String edtMovimientoCajaFecha_Jsonclick ;
   private String edtCajeroId_Internalname ;
   private String edtCajeroId_Jsonclick ;
   private String edtCajeroNombre_Internalname ;
   private String A112CajeroNombre ;
   private String edtCajeroNombre_Jsonclick ;
   private String edtCajaId_Internalname ;
   private String edtCajaId_Jsonclick ;
   private String edtCajaNumero_Internalname ;
   private String edtCajaNumero_Jsonclick ;
   private String edtMovimientoCajaAsignacion_Internalname ;
   private String A256MovimientoCajaAsignacion ;
   private String edtMovimientoCajaAsignacion_Jsonclick ;
   private String edtMovimientoCajaDocum_Internalname ;
   private String edtMovimientoCajaDocum_Jsonclick ;
   private String edtMovimientoCajaEstado_Internalname ;
   private String A267MovimientoCajaEstado ;
   private String edtMovimientoCajaEstado_Jsonclick ;
   private String edtavSaldoactual_Internalname ;
   private String TempTags ;
   private String edtavSaldoactual_Jsonclick ;
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
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String sCtrlA27MovimientoCajaId ;
   private java.util.Date A116MovimientoCajaHora ;
   private java.util.Date A120MovimientoCajaFecha ;
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
   private String A266MovimientoCajaDocum ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private long[] H005K2_A27MovimientoCajaId ;
   private String[] H005K2_A267MovimientoCajaEstado ;
   private String[] H005K2_A266MovimientoCajaDocum ;
   private String[] H005K2_A256MovimientoCajaAsignacion ;
   private long[] H005K2_A110CajaNumero ;
   private long[] H005K2_A25CajaId ;
   private String[] H005K2_A112CajeroNombre ;
   private long[] H005K2_A26CajeroId ;
   private java.util.Date[] H005K2_A120MovimientoCajaFecha ;
   private java.math.BigDecimal[] H005K2_A119MovimientoCajaSaldo ;
   private java.math.BigDecimal[] H005K2_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] H005K2_A117MovimientoCajaIngreso ;
   private java.util.Date[] H005K2_A116MovimientoCajaHora ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class movimientocajageneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005K2", "SELECT T1.[MovimientoCajaId], T1.[MovimientoCajaEstado], T1.[MovimientoCajaDocum], T1.[MovimientoCajaAsignacion], T2.[CajaNumero], T1.[CajaId], T3.[CajeroNombre], T1.[CajeroId], T1.[MovimientoCajaFecha], T1.[MovimientoCajaSaldo], T1.[MovimientoCajaEgreso], T1.[MovimientoCajaIngreso], T1.[MovimientoCajaHora] FROM (([MovimientoCaja] T1 INNER JOIN [Caja] T2 ON T2.[CajaId] = T1.[CajaId]) INNER JOIN [Cajero] T3 ON T3.[CajeroId] = T1.[CajeroId]) WHERE T1.[MovimientoCajaId] = ? ORDER BY T1.[MovimientoCajaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(13));
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
      }
   }

}

