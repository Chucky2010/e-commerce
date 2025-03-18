package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class comprasgeneral_impl extends GXWebComponent
{
   public comprasgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public comprasgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( comprasgeneral_impl.class ));
   }

   public comprasgeneral_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "ComprasId") ;
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
               A11ComprasId = GXutil.lval( httpContext.GetPar( "ComprasId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Long.valueOf(A11ComprasId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "ComprasId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "ComprasId") ;
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
         pa4U2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Compras General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.comprasgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A11ComprasId,11,0))}, new String[] {"ComprasId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA11ComprasId", GXutil.ltrim( localUtil.ntoc( wcpOA11ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void renderHtmlCloseForm4U2( )
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
      return "ComprasGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Compras General", "") ;
   }

   public void wb4U0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.comprasgeneral");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasId_Internalname, httpContext.getMessage( "Compras Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasId_Internalname, GXutil.ltrim( localUtil.ntoc( A11ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasFecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasFecha_Internalname, httpContext.getMessage( "Fecha", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtComprasFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasFecha_Internalname, localUtil.format(A74ComprasFecha, "99/99/99"), localUtil.format( A74ComprasFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasFecha_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtComprasFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtComprasFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ComprasGeneral.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProveedorId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtProveedorId_Internalname, httpContext.getMessage( "Proveedor Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtProveedorId_Internalname, GXutil.ltrim( localUtil.ntoc( A10ProveedorId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtProveedorId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A10ProveedorId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A10ProveedorId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProveedorId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProveedorId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTimbrado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTimbrado_Internalname, httpContext.getMessage( "Timbrado", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTimbrado_Internalname, GXutil.ltrim( localUtil.ntoc( A226ComprasTimbrado, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTimbrado_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A226ComprasTimbrado), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A226ComprasTimbrado), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTimbrado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTimbrado_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Timbrado", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasNumeroFactura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasNumeroFactura_Internalname, httpContext.getMessage( "Numero Factura", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasNumeroFactura_Internalname, GXutil.ltrim( localUtil.ntoc( A227ComprasNumeroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasNumeroFactura_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasNumeroFactura_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasNumeroFactura_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Factura", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalExento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalExento_Internalname, httpContext.getMessage( "Total Exento", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalExento_Internalname, GXutil.ltrim( localUtil.ntoc( A90ComprasTotalExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalExento_Enabled!=0) ? localUtil.format( A90ComprasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A90ComprasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalExento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotalExento_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalIva5_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalIva5_Internalname, httpContext.getMessage( "Total Iva5", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalIva5_Internalname, GXutil.ltrim( localUtil.ntoc( A87ComprasTotalIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalIva5_Enabled!=0) ? localUtil.format( A87ComprasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A87ComprasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalIva5_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotalIva5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalIva10_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalIva10_Internalname, httpContext.getMessage( "Total Iva10", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalIva10_Internalname, GXutil.ltrim( localUtil.ntoc( A89ComprasTotalIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalIva10_Enabled!=0) ? localUtil.format( A89ComprasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A89ComprasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalIva10_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotalIva10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotal_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A229ComprasTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotal_Enabled!=0) ? localUtil.format( A229ComprasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A229ComprasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotal5_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotal5_Internalname, httpContext.getMessage( "Total5", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotal5_Internalname, GXutil.ltrim( localUtil.ntoc( A86ComprasTotal5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotal5_Enabled!=0) ? localUtil.format( A86ComprasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A86ComprasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotal5_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotal5_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotal10_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotal10_Internalname, httpContext.getMessage( "Total10", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotal10_Internalname, GXutil.ltrim( localUtil.ntoc( A88ComprasTotal10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotal10_Enabled!=0) ? localUtil.format( A88ComprasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A88ComprasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotal10_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotal10_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComprasTotalIva_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtComprasTotalIva_Internalname, httpContext.getMessage( "Total Iva", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtComprasTotalIva_Internalname, GXutil.ltrim( localUtil.ntoc( A225ComprasTotalIva, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtComprasTotalIva_Enabled!=0) ? localUtil.format( A225ComprasTotalIva, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A225ComprasTotalIva, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComprasTotalIva_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComprasTotalIva_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ComprasGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e114u1_client"+"'", TempTags, "", 2, "HLP_ComprasGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e124u1_client"+"'", TempTags, "", 2, "HLP_ComprasGeneral.htm");
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

   public void start4U2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Compras General", ""), (short)(0)) ;
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
            strup4U0( ) ;
         }
      }
   }

   public void ws4U2( )
   {
      start4U2( ) ;
      evt4U2( ) ;
   }

   public void evt4U2( )
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
                              strup4U0( ) ;
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
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e134U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
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
                              strup4U0( ) ;
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

   public void we4U2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4U2( ) ;
         }
      }
   }

   public void pa4U2( )
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
      rf4U2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "ComprasGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf4U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H004U3 */
         pr_default.execute(0, new Object[] {Long.valueOf(A11ComprasId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A227ComprasNumeroFactura = H004U3_A227ComprasNumeroFactura[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
            A226ComprasTimbrado = H004U3_A226ComprasTimbrado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
            A10ProveedorId = H004U3_A10ProveedorId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
            A74ComprasFecha = H004U3_A74ComprasFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
            A90ComprasTotalExento = H004U3_A90ComprasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A89ComprasTotalIva10 = H004U3_A89ComprasTotalIva10[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            A87ComprasTotalIva5 = H004U3_A87ComprasTotalIva5[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            A90ComprasTotalExento = H004U3_A90ComprasTotalExento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
            A89ComprasTotalIva10 = H004U3_A89ComprasTotalIva10[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
            A87ComprasTotalIva5 = H004U3_A87ComprasTotalIva5[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
            /* Execute user event: Load */
            e144U2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb4U0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4U2( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "ComprasGeneral" ;
      Gx_err = (short)(0) ;
      /* Using cursor H004U5 */
      pr_default.execute(1, new Object[] {Long.valueOf(A11ComprasId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A90ComprasTotalExento = H004U5_A90ComprasTotalExento[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A89ComprasTotalIva10 = H004U5_A89ComprasTotalIva10[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         A87ComprasTotalIva5 = H004U5_A87ComprasTotalIva5[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
      }
      else
      {
         A90ComprasTotalExento = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A87ComprasTotalIva5 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A89ComprasTotalIva10 = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
      }
      pr_default.close(1);
      A88ComprasTotal10 = GXutil.roundDecimal( A89ComprasTotalIva10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
      A229ComprasTotal = A90ComprasTotalExento.add(A87ComprasTotalIva5).add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
      A86ComprasTotal5 = GXutil.roundDecimal( A87ComprasTotalIva5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
      A225ComprasTotalIva = A87ComprasTotalIva5.add(A89ComprasTotalIva10) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup4U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e134U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA11ComprasId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA11ComprasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV13IsAuthorized_Delete = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_DELETE")) ;
         AV12IsAuthorized_Update = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_UPDATE")) ;
         /* Read variables values. */
         A74ComprasFecha = localUtil.ctod( httpContext.cgiGet( edtComprasFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74ComprasFecha", localUtil.format(A74ComprasFecha, "99/99/99"));
         A10ProveedorId = localUtil.ctol( httpContext.cgiGet( edtProveedorId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A10ProveedorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A10ProveedorId), 11, 0));
         A226ComprasTimbrado = localUtil.ctol( httpContext.cgiGet( edtComprasTimbrado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A226ComprasTimbrado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A226ComprasTimbrado), 15, 0));
         A227ComprasNumeroFactura = localUtil.ctol( httpContext.cgiGet( edtComprasNumeroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A227ComprasNumeroFactura", GXutil.ltrimstr( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), 15, 0));
         A90ComprasTotalExento = localUtil.ctond( httpContext.cgiGet( edtComprasTotalExento_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90ComprasTotalExento", GXutil.ltrimstr( A90ComprasTotalExento, 17, 2));
         A87ComprasTotalIva5 = localUtil.ctond( httpContext.cgiGet( edtComprasTotalIva5_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87ComprasTotalIva5", GXutil.ltrimstr( A87ComprasTotalIva5, 17, 2));
         A89ComprasTotalIva10 = localUtil.ctond( httpContext.cgiGet( edtComprasTotalIva10_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ComprasTotalIva10", GXutil.ltrimstr( A89ComprasTotalIva10, 17, 2));
         A229ComprasTotal = localUtil.ctond( httpContext.cgiGet( edtComprasTotal_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A229ComprasTotal", GXutil.ltrimstr( A229ComprasTotal, 17, 2));
         A86ComprasTotal5 = localUtil.ctond( httpContext.cgiGet( edtComprasTotal5_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A86ComprasTotal5", GXutil.ltrimstr( A86ComprasTotal5, 17, 2));
         A88ComprasTotal10 = localUtil.ctond( httpContext.cgiGet( edtComprasTotal10_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ComprasTotal10", GXutil.ltrimstr( A88ComprasTotal10, 17, 2));
         A225ComprasTotalIva = localUtil.ctond( httpContext.cgiGet( edtComprasTotalIva_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A225ComprasTotalIva", GXutil.ltrimstr( A225ComprasTotalIva, 17, 2));
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
      e134U2 ();
      if (returnInSub) return;
   }

   public void e134U2( )
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

   protected void e144U2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12IsAuthorized_Update ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "compras_Update", GXv_boolean3) ;
      comprasgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "compras_Delete", GXv_boolean3) ;
      comprasgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Compras" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A11ComprasId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
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
      pa4U2( ) ;
      ws4U2( ) ;
      we4U2( ) ;
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
      sCtrlA11ComprasId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4U2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "comprasgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4U2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A11ComprasId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      }
      wcpOA11ComprasId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA11ComprasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ! GetJustCreated( ) && ( ( A11ComprasId != wcpOA11ComprasId ) ) )
      {
         setjustcreated();
      }
      wcpOA11ComprasId = A11ComprasId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA11ComprasId = httpContext.cgiGet( sPrefix+"A11ComprasId_CTRL") ;
      if ( GXutil.len( sCtrlA11ComprasId) > 0 )
      {
         A11ComprasId = localUtil.ctol( httpContext.cgiGet( sCtrlA11ComprasId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11ComprasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A11ComprasId), 11, 0));
      }
      else
      {
         A11ComprasId = localUtil.ctol( httpContext.cgiGet( sPrefix+"A11ComprasId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
      pa4U2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4U2( ) ;
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
      ws4U2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A11ComprasId_PARM", GXutil.ltrim( localUtil.ntoc( A11ComprasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA11ComprasId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A11ComprasId_CTRL", GXutil.rtrim( sCtrlA11ComprasId));
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
      we4U2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211193315", true, true);
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
      httpContext.AddJavascriptSource("comprasgeneral.js", "?20241211193315", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtComprasId_Internalname = sPrefix+"COMPRASID" ;
      edtComprasFecha_Internalname = sPrefix+"COMPRASFECHA" ;
      edtProveedorId_Internalname = sPrefix+"PROVEEDORID" ;
      edtComprasTimbrado_Internalname = sPrefix+"COMPRASTIMBRADO" ;
      edtComprasNumeroFactura_Internalname = sPrefix+"COMPRASNUMEROFACTURA" ;
      edtComprasTotalExento_Internalname = sPrefix+"COMPRASTOTALEXENTO" ;
      edtComprasTotalIva5_Internalname = sPrefix+"COMPRASTOTALIVA5" ;
      edtComprasTotalIva10_Internalname = sPrefix+"COMPRASTOTALIVA10" ;
      edtComprasTotal_Internalname = sPrefix+"COMPRASTOTAL" ;
      edtComprasTotal5_Internalname = sPrefix+"COMPRASTOTAL5" ;
      edtComprasTotal10_Internalname = sPrefix+"COMPRASTOTAL10" ;
      edtComprasTotalIva_Internalname = sPrefix+"COMPRASTOTALIVA" ;
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
      edtComprasTotalIva_Jsonclick = "" ;
      edtComprasTotalIva_Enabled = 0 ;
      edtComprasTotal10_Jsonclick = "" ;
      edtComprasTotal10_Enabled = 0 ;
      edtComprasTotal5_Jsonclick = "" ;
      edtComprasTotal5_Enabled = 0 ;
      edtComprasTotal_Jsonclick = "" ;
      edtComprasTotal_Enabled = 0 ;
      edtComprasTotalIva10_Jsonclick = "" ;
      edtComprasTotalIva10_Enabled = 0 ;
      edtComprasTotalIva5_Jsonclick = "" ;
      edtComprasTotalIva5_Enabled = 0 ;
      edtComprasTotalExento_Jsonclick = "" ;
      edtComprasTotalExento_Enabled = 0 ;
      edtComprasNumeroFactura_Jsonclick = "" ;
      edtComprasNumeroFactura_Enabled = 0 ;
      edtComprasTimbrado_Jsonclick = "" ;
      edtComprasTimbrado_Enabled = 0 ;
      edtProveedorId_Jsonclick = "" ;
      edtProveedorId_Enabled = 0 ;
      edtComprasFecha_Jsonclick = "" ;
      edtComprasFecha_Enabled = 0 ;
      edtComprasId_Jsonclick = "" ;
      edtComprasId_Enabled = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A11ComprasId',fld:'COMPRASID',pic:'ZZZZZZZZZZ9'},{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e114U1',iparms:[{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A11ComprasId',fld:'COMPRASID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[{ctrl:'BTNUPDATE',prop:'Visible'}]}");
      setEventMetadata("'DODELETE'","{handler:'e124U1',iparms:[{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A11ComprasId',fld:'COMPRASID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[{ctrl:'BTNDELETE',prop:'Visible'}]}");
      setEventMetadata("VALID_COMPRASID","{handler:'valid_Comprasid',iparms:[]");
      setEventMetadata("VALID_COMPRASID",",oparms:[]}");
      setEventMetadata("VALID_COMPRASTOTALEXENTO","{handler:'valid_Comprastotalexento',iparms:[]");
      setEventMetadata("VALID_COMPRASTOTALEXENTO",",oparms:[]}");
      setEventMetadata("VALID_COMPRASTOTALIVA5","{handler:'valid_Comprastotaliva5',iparms:[]");
      setEventMetadata("VALID_COMPRASTOTALIVA5",",oparms:[]}");
      setEventMetadata("VALID_COMPRASTOTALIVA10","{handler:'valid_Comprastotaliva10',iparms:[]");
      setEventMetadata("VALID_COMPRASTOTALIVA10",",oparms:[]}");
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
      A74ComprasFecha = GXutil.nullDate() ;
      A90ComprasTotalExento = DecimalUtil.ZERO ;
      A87ComprasTotalIva5 = DecimalUtil.ZERO ;
      A89ComprasTotalIva10 = DecimalUtil.ZERO ;
      A229ComprasTotal = DecimalUtil.ZERO ;
      A86ComprasTotal5 = DecimalUtil.ZERO ;
      A88ComprasTotal10 = DecimalUtil.ZERO ;
      A225ComprasTotalIva = DecimalUtil.ZERO ;
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
      H004U3_A11ComprasId = new long[1] ;
      H004U3_A227ComprasNumeroFactura = new long[1] ;
      H004U3_A226ComprasTimbrado = new long[1] ;
      H004U3_A10ProveedorId = new long[1] ;
      H004U3_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H004U3_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004U3_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004U3_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004U5_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004U5_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004U5_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA11ComprasId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.comprasgeneral__default(),
         new Object[] {
             new Object[] {
            H004U3_A11ComprasId, H004U3_A227ComprasNumeroFactura, H004U3_A226ComprasTimbrado, H004U3_A10ProveedorId, H004U3_A74ComprasFecha, H004U3_A90ComprasTotalExento, H004U3_A89ComprasTotalIva10, H004U3_A87ComprasTotalIva5
            }
            , new Object[] {
            H004U5_A90ComprasTotalExento, H004U5_A89ComprasTotalIva10, H004U5_A87ComprasTotalIva5
            }
         }
      );
      AV17Pgmname = "ComprasGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "ComprasGeneral" ;
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
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtComprasId_Enabled ;
   private int edtComprasFecha_Enabled ;
   private int edtProveedorId_Enabled ;
   private int edtComprasTimbrado_Enabled ;
   private int edtComprasNumeroFactura_Enabled ;
   private int edtComprasTotalExento_Enabled ;
   private int edtComprasTotalIva5_Enabled ;
   private int edtComprasTotalIva10_Enabled ;
   private int edtComprasTotal_Enabled ;
   private int edtComprasTotal5_Enabled ;
   private int edtComprasTotal10_Enabled ;
   private int edtComprasTotalIva_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private long wcpOA11ComprasId ;
   private long A11ComprasId ;
   private long A10ProveedorId ;
   private long A226ComprasTimbrado ;
   private long A227ComprasNumeroFactura ;
   private java.math.BigDecimal A90ComprasTotalExento ;
   private java.math.BigDecimal A87ComprasTotalIva5 ;
   private java.math.BigDecimal A89ComprasTotalIva10 ;
   private java.math.BigDecimal A229ComprasTotal ;
   private java.math.BigDecimal A86ComprasTotal5 ;
   private java.math.BigDecimal A88ComprasTotal10 ;
   private java.math.BigDecimal A225ComprasTotalIva ;
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
   private String edtComprasId_Internalname ;
   private String edtComprasId_Jsonclick ;
   private String edtComprasFecha_Internalname ;
   private String edtComprasFecha_Jsonclick ;
   private String edtProveedorId_Internalname ;
   private String edtProveedorId_Jsonclick ;
   private String edtComprasTimbrado_Internalname ;
   private String edtComprasTimbrado_Jsonclick ;
   private String edtComprasNumeroFactura_Internalname ;
   private String edtComprasNumeroFactura_Jsonclick ;
   private String edtComprasTotalExento_Internalname ;
   private String edtComprasTotalExento_Jsonclick ;
   private String edtComprasTotalIva5_Internalname ;
   private String edtComprasTotalIva5_Jsonclick ;
   private String edtComprasTotalIva10_Internalname ;
   private String edtComprasTotalIva10_Jsonclick ;
   private String edtComprasTotal_Internalname ;
   private String edtComprasTotal_Jsonclick ;
   private String edtComprasTotal5_Internalname ;
   private String edtComprasTotal5_Jsonclick ;
   private String edtComprasTotal10_Internalname ;
   private String edtComprasTotal10_Jsonclick ;
   private String edtComprasTotalIva_Internalname ;
   private String edtComprasTotalIva_Jsonclick ;
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
   private String sCtrlA11ComprasId ;
   private java.util.Date A74ComprasFecha ;
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
   private long[] H004U3_A11ComprasId ;
   private long[] H004U3_A227ComprasNumeroFactura ;
   private long[] H004U3_A226ComprasTimbrado ;
   private long[] H004U3_A10ProveedorId ;
   private java.util.Date[] H004U3_A74ComprasFecha ;
   private java.math.BigDecimal[] H004U3_A90ComprasTotalExento ;
   private java.math.BigDecimal[] H004U3_A89ComprasTotalIva10 ;
   private java.math.BigDecimal[] H004U3_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] H004U5_A90ComprasTotalExento ;
   private java.math.BigDecimal[] H004U5_A89ComprasTotalIva10 ;
   private java.math.BigDecimal[] H004U5_A87ComprasTotalIva5 ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class comprasgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004U3", "SELECT T1.[ComprasId], T1.[ComprasNumeroFactura], T1.[ComprasTimbrado], T1.[ProveedorId], T1.[ComprasFecha], COALESCE( T2.[ComprasTotalExento], 0) AS ComprasTotalExento, COALESCE( T2.[ComprasTotalIva10], 0) AS ComprasTotalIva10, COALESCE( T2.[ComprasTotalIva5], 0) AS ComprasTotalIva5 FROM ([Compras] T1 LEFT JOIN (SELECT T3.[ComprasId], SUM(CASE  WHEN T5.[ImpuestoPorcentaje] = 0 THEN T3.[ComprasCantidad] * CAST(T3.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento, SUM(CASE  WHEN T5.[ImpuestoPorcentaje] = 5 THEN T3.[ComprasCantidad] * CAST(T3.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE  WHEN T5.[ImpuestoPorcentaje] = 10 THEN T3.[ComprasCantidad] * CAST(T3.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T3 INNER JOIN [Articulo] T4 ON T4.[ArticuloId] = T3.[ArticuloId]) INNER JOIN [Impuesto] T5 ON T5.[ImpuestoId] = T4.[ImpuestoId]) GROUP BY T3.[ComprasId] ) T2 ON T2.[ComprasId] = T1.[ComprasId]) WHERE T1.[ComprasId] = ? ORDER BY T1.[ComprasId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U5", "SELECT COALESCE( T1.[ComprasTotalExento], 0) AS ComprasTotalExento, COALESCE( T1.[ComprasTotalIva10], 0) AS ComprasTotalIva10, COALESCE( T1.[ComprasTotalIva5], 0) AS ComprasTotalIva5 FROM (SELECT T2.[ComprasId], SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 0 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 5 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE  WHEN T4.[ImpuestoPorcentaje] = 10 THEN T2.[ComprasCantidad] * CAST(T2.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T2 INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) INNER JOIN [Impuesto] T4 ON T4.[ImpuestoId] = T3.[ImpuestoId]) GROUP BY T2.[ComprasId] ) T1 WHERE T1.[ComprasId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
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

