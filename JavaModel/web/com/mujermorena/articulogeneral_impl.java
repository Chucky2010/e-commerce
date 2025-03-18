package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class articulogeneral_impl extends GXWebComponent
{
   public articulogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public articulogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articulogeneral_impl.class ));
   }

   public articulogeneral_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "ArticuloId") ;
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
               A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Long.valueOf(A13ArticuloId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "ArticuloId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "ArticuloId") ;
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
         pa4M2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Articulo General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.articulogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A13ArticuloId,11,0))}, new String[] {"ArticuloId"}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ArticuloGeneral");
      forbiddenHiddens.add("TipoArticuloId", localUtil.format( DecimalUtil.doubleToDec(A17TipoArticuloId), "ZZZZZZZZZZ9"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("articulogeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA13ArticuloId", GXutil.ltrim( localUtil.ntoc( wcpOA13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void renderHtmlCloseForm4M2( )
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
      return "ArticuloGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Articulo General", "") ;
   }

   public void wb4M0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.articulogeneral");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloId_Internalname, httpContext.getMessage( "Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArticuloId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloNombre_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre), GXutil.rtrim( localUtil.format( A76ArticuloNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArticuloNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloDescripcionCorta_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloDescripcionCorta_Internalname, httpContext.getMessage( "Descripcion Corta", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtArticuloDescripcionCorta_Internalname, A214ArticuloDescripcionCorta, "", "", (short)(0), 1, edtArticuloDescripcionCorta_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloDescripcionLarga_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloDescripcionLarga_Internalname, httpContext.getMessage( "Descripcion Larga", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtArticuloDescripcionLarga_Internalname, A215ArticuloDescripcionLarga, "", "", (short)(0), 1, edtArticuloDescripcionLarga_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloPrecioCompra_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloPrecioCompra_Internalname, httpContext.getMessage( "Precio Compra", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloPrecioCompra_Internalname, GXutil.ltrim( localUtil.ntoc( A77ArticuloPrecioCompra, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloPrecioCompra_Enabled!=0) ? localUtil.format( A77ArticuloPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A77ArticuloPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloPrecioCompra_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArticuloPrecioCompra_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloPrecioVenta_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloPrecioVenta_Internalname, httpContext.getMessage( "Precio Venta", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloPrecioVenta_Enabled!=0) ? localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloPrecioVenta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArticuloPrecioVenta_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloPrecioPromedio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloPrecioPromedio_Internalname, httpContext.getMessage( "Precio Promedio", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloPrecioPromedio_Internalname, GXutil.ltrim( localUtil.ntoc( A222ArticuloPrecioPromedio, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloPrecioPromedio_Enabled!=0) ? localUtil.format( A222ArticuloPrecioPromedio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A222ArticuloPrecioPromedio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloPrecioPromedio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArticuloPrecioPromedio_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArticuloStock_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtArticuloStock_Internalname, httpContext.getMessage( "Stock", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtArticuloStock_Internalname, GXutil.ltrim( localUtil.ntoc( A79ArticuloStock, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtArticuloStock_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArticuloStock_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArticuloStock_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Stock", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoArticuloId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoArticuloId_Internalname, httpContext.getMessage( "Tipo Articulo Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A17TipoArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A17TipoArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A17TipoArticuloId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoArticuloId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoArticuloId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoArticuloNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoArticuloNombre_Internalname, httpContext.getMessage( "Tipo Articulo Nombre", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoArticuloNombre_Internalname, GXutil.rtrim( A103TipoArticuloNombre), GXutil.rtrim( localUtil.format( A103TipoArticuloNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtTipoArticuloNombre_Link, "", "", "", edtTipoArticuloNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoArticuloNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpuestoId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtImpuestoId_Internalname, httpContext.getMessage( "Impuesto Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtImpuestoId_Internalname, GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtImpuestoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A18ImpuestoId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A18ImpuestoId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpuestoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpuestoId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpuestoPorcentaje_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtImpuestoPorcentaje_Internalname, httpContext.getMessage( "Impuesto Porcentaje", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtImpuestoPorcentaje_Enabled!=0) ? localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99") : localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpuestoPorcentaje_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpuestoPorcentaje_Enabled, 0, "text", "", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Porcentaje", "right", false, "", "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgArticuloImagen_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Imagen", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A231ArticuloImagen_IsBlob = (boolean)(((GXutil.strcmp("", A231ArticuloImagen)==0)&&(GXutil.strcmp("", A40000ArticuloImagen_GXI)==0))||!(GXutil.strcmp("", A231ArticuloImagen)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.getResourceRelative(A231ArticuloImagen)) ;
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgArticuloImagen_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A231ArticuloImagen_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ArticuloGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e114m1_client"+"'", TempTags, "", 2, "HLP_ArticuloGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e124m1_client"+"'", TempTags, "", 2, "HLP_ArticuloGeneral.htm");
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

   public void start4M2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Articulo General", ""), (short)(0)) ;
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
            strup4M0( ) ;
         }
      }
   }

   public void ws4M2( )
   {
      start4M2( ) ;
      evt4M2( ) ;
   }

   public void evt4M2( )
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
                              strup4M0( ) ;
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
                              strup4M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e134M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4M0( ) ;
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
                              strup4M0( ) ;
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

   public void we4M2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4M2( ) ;
         }
      }
   }

   public void pa4M2( )
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
      rf4M2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "ArticuloGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf4M2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H004M2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A13ArticuloId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A231ArticuloImagen = H004M2_A231ArticuloImagen[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231ArticuloImagen", A231ArticuloImagen);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
            A40000ArticuloImagen_GXI = H004M2_A40000ArticuloImagen_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgArticuloImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A231ArticuloImagen))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgArticuloImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A231ArticuloImagen), true);
            A83ImpuestoPorcentaje = H004M2_A83ImpuestoPorcentaje[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
            A18ImpuestoId = H004M2_A18ImpuestoId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
            A103TipoArticuloNombre = H004M2_A103TipoArticuloNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
            A17TipoArticuloId = H004M2_A17TipoArticuloId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
            A79ArticuloStock = H004M2_A79ArticuloStock[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
            A222ArticuloPrecioPromedio = H004M2_A222ArticuloPrecioPromedio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
            A78ArticuloPrecioVenta = H004M2_A78ArticuloPrecioVenta[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
            A77ArticuloPrecioCompra = H004M2_A77ArticuloPrecioCompra[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
            A215ArticuloDescripcionLarga = H004M2_A215ArticuloDescripcionLarga[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A215ArticuloDescripcionLarga", A215ArticuloDescripcionLarga);
            A214ArticuloDescripcionCorta = H004M2_A214ArticuloDescripcionCorta[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A214ArticuloDescripcionCorta", A214ArticuloDescripcionCorta);
            A76ArticuloNombre = H004M2_A76ArticuloNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76ArticuloNombre", A76ArticuloNombre);
            A83ImpuestoPorcentaje = H004M2_A83ImpuestoPorcentaje[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
            A103TipoArticuloNombre = H004M2_A103TipoArticuloNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
            /* Execute user event: Load */
            e144M2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb4M0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4M2( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV12IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV12IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV13IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV13IsAuthorized_Delete));
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "ArticuloGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup4M0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e134M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA13ArticuloId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA13ArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV13IsAuthorized_Delete = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_DELETE")) ;
         AV12IsAuthorized_Update = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vISAUTHORIZED_UPDATE")) ;
         /* Read variables values. */
         A76ArticuloNombre = httpContext.cgiGet( edtArticuloNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76ArticuloNombre", A76ArticuloNombre);
         A214ArticuloDescripcionCorta = httpContext.cgiGet( edtArticuloDescripcionCorta_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A214ArticuloDescripcionCorta", A214ArticuloDescripcionCorta);
         A215ArticuloDescripcionLarga = httpContext.cgiGet( edtArticuloDescripcionLarga_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A215ArticuloDescripcionLarga", A215ArticuloDescripcionLarga);
         A77ArticuloPrecioCompra = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioCompra_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A77ArticuloPrecioCompra", GXutil.ltrimstr( A77ArticuloPrecioCompra, 17, 2));
         A78ArticuloPrecioVenta = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78ArticuloPrecioVenta", GXutil.ltrimstr( A78ArticuloPrecioVenta, 17, 2));
         A222ArticuloPrecioPromedio = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioPromedio_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ArticuloPrecioPromedio", GXutil.ltrimstr( A222ArticuloPrecioPromedio, 17, 2));
         A79ArticuloStock = localUtil.ctol( httpContext.cgiGet( edtArticuloStock_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A79ArticuloStock", GXutil.ltrimstr( DecimalUtil.doubleToDec(A79ArticuloStock), 10, 0));
         A17TipoArticuloId = localUtil.ctol( httpContext.cgiGet( edtTipoArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
         A103TipoArticuloNombre = httpContext.cgiGet( edtTipoArticuloNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103TipoArticuloNombre", A103TipoArticuloNombre);
         A18ImpuestoId = localUtil.ctol( httpContext.cgiGet( edtImpuestoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         A83ImpuestoPorcentaje = localUtil.ctond( httpContext.cgiGet( edtImpuestoPorcentaje_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A83ImpuestoPorcentaje", GXutil.ltrimstr( A83ImpuestoPorcentaje, 9, 2));
         A231ArticuloImagen = httpContext.cgiGet( imgArticuloImagen_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231ArticuloImagen", A231ArticuloImagen);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ArticuloGeneral");
         A17TipoArticuloId = localUtil.ctol( httpContext.cgiGet( edtTipoArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17TipoArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17TipoArticuloId), 11, 0));
         forbiddenHiddens.add("TipoArticuloId", localUtil.format( DecimalUtil.doubleToDec(A17TipoArticuloId), "ZZZZZZZZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("articulogeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e134M2 ();
      if (returnInSub) return;
   }

   public void e134M2( )
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

   protected void e144M2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV14TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "tipoarticuloview_Execute", GXv_boolean3) ;
      articulogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV14TempBoolean = GXt_boolean2 ;
      if ( AV14TempBoolean )
      {
         edtTipoArticuloNombre_Link = formatLink("com.mujermorena.tipoarticuloview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A17TipoArticuloId,11,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"TipoArticuloId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtTipoArticuloNombre_Internalname, "Link", edtTipoArticuloNombre_Link, true);
      }
      GXt_boolean2 = AV12IsAuthorized_Update ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "articulo_Update", GXv_boolean3) ;
      articulogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "articulo_Delete", GXv_boolean3) ;
      articulogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Articulo" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A13ArticuloId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
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
      pa4M2( ) ;
      ws4M2( ) ;
      we4M2( ) ;
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
      sCtrlA13ArticuloId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4M2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "articulogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4M2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A13ArticuloId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      }
      wcpOA13ArticuloId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA13ArticuloId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ! GetJustCreated( ) && ( ( A13ArticuloId != wcpOA13ArticuloId ) ) )
      {
         setjustcreated();
      }
      wcpOA13ArticuloId = A13ArticuloId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA13ArticuloId = httpContext.cgiGet( sPrefix+"A13ArticuloId_CTRL") ;
      if ( GXutil.len( sCtrlA13ArticuloId) > 0 )
      {
         A13ArticuloId = localUtil.ctol( httpContext.cgiGet( sCtrlA13ArticuloId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A13ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A13ArticuloId), 11, 0));
      }
      else
      {
         A13ArticuloId = localUtil.ctol( httpContext.cgiGet( sPrefix+"A13ArticuloId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
      pa4M2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4M2( ) ;
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
      ws4M2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A13ArticuloId_PARM", GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA13ArticuloId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A13ArticuloId_CTRL", GXutil.rtrim( sCtrlA13ArticuloId));
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
      we4M2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211191743", true, true);
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
      httpContext.AddJavascriptSource("articulogeneral.js", "?20241211191743", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtArticuloId_Internalname = sPrefix+"ARTICULOID" ;
      edtArticuloNombre_Internalname = sPrefix+"ARTICULONOMBRE" ;
      edtArticuloDescripcionCorta_Internalname = sPrefix+"ARTICULODESCRIPCIONCORTA" ;
      edtArticuloDescripcionLarga_Internalname = sPrefix+"ARTICULODESCRIPCIONLARGA" ;
      edtArticuloPrecioCompra_Internalname = sPrefix+"ARTICULOPRECIOCOMPRA" ;
      edtArticuloPrecioVenta_Internalname = sPrefix+"ARTICULOPRECIOVENTA" ;
      edtArticuloPrecioPromedio_Internalname = sPrefix+"ARTICULOPRECIOPROMEDIO" ;
      edtArticuloStock_Internalname = sPrefix+"ARTICULOSTOCK" ;
      edtTipoArticuloId_Internalname = sPrefix+"TIPOARTICULOID" ;
      edtTipoArticuloNombre_Internalname = sPrefix+"TIPOARTICULONOMBRE" ;
      edtImpuestoId_Internalname = sPrefix+"IMPUESTOID" ;
      edtImpuestoPorcentaje_Internalname = sPrefix+"IMPUESTOPORCENTAJE" ;
      imgArticuloImagen_Internalname = sPrefix+"ARTICULOIMAGEN" ;
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
      edtImpuestoPorcentaje_Jsonclick = "" ;
      edtImpuestoPorcentaje_Enabled = 0 ;
      edtImpuestoId_Jsonclick = "" ;
      edtImpuestoId_Enabled = 0 ;
      edtTipoArticuloNombre_Jsonclick = "" ;
      edtTipoArticuloNombre_Link = "" ;
      edtTipoArticuloNombre_Enabled = 0 ;
      edtTipoArticuloId_Jsonclick = "" ;
      edtTipoArticuloId_Enabled = 0 ;
      edtArticuloStock_Jsonclick = "" ;
      edtArticuloStock_Enabled = 0 ;
      edtArticuloPrecioPromedio_Jsonclick = "" ;
      edtArticuloPrecioPromedio_Enabled = 0 ;
      edtArticuloPrecioVenta_Jsonclick = "" ;
      edtArticuloPrecioVenta_Enabled = 0 ;
      edtArticuloPrecioCompra_Jsonclick = "" ;
      edtArticuloPrecioCompra_Enabled = 0 ;
      edtArticuloDescripcionLarga_Enabled = 0 ;
      edtArticuloDescripcionCorta_Enabled = 0 ;
      edtArticuloNombre_Jsonclick = "" ;
      edtArticuloNombre_Enabled = 0 ;
      edtArticuloId_Jsonclick = "" ;
      edtArticuloId_Enabled = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A17TipoArticuloId',fld:'TIPOARTICULOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e114M1',iparms:[{av:'AV12IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[{ctrl:'BTNUPDATE',prop:'Visible'}]}");
      setEventMetadata("'DODELETE'","{handler:'e124M1',iparms:[{av:'AV13IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[{ctrl:'BTNDELETE',prop:'Visible'}]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[]}");
      setEventMetadata("VALID_TIPOARTICULOID","{handler:'valid_Tipoarticuloid',iparms:[]");
      setEventMetadata("VALID_TIPOARTICULOID",",oparms:[]}");
      setEventMetadata("VALID_IMPUESTOID","{handler:'valid_Impuestoid',iparms:[]");
      setEventMetadata("VALID_IMPUESTOID",",oparms:[]}");
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
      forbiddenHiddens = new com.genexus.util.GXProperties();
      GX_FocusControl = "" ;
      A76ArticuloNombre = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A214ArticuloDescripcionCorta = "" ;
      A215ArticuloDescripcionLarga = "" ;
      A77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      A103TipoArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A231ArticuloImagen = "" ;
      A40000ArticuloImagen_GXI = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H004M2_A13ArticuloId = new long[1] ;
      H004M2_A231ArticuloImagen = new String[] {""} ;
      H004M2_A40000ArticuloImagen_GXI = new String[] {""} ;
      H004M2_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004M2_A18ImpuestoId = new long[1] ;
      H004M2_A103TipoArticuloNombre = new String[] {""} ;
      H004M2_A17TipoArticuloId = new long[1] ;
      H004M2_A79ArticuloStock = new long[1] ;
      H004M2_A222ArticuloPrecioPromedio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004M2_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004M2_A77ArticuloPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H004M2_A215ArticuloDescripcionLarga = new String[] {""} ;
      H004M2_A214ArticuloDescripcionCorta = new String[] {""} ;
      H004M2_A76ArticuloNombre = new String[] {""} ;
      hsh = "" ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA13ArticuloId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articulogeneral__default(),
         new Object[] {
             new Object[] {
            H004M2_A13ArticuloId, H004M2_A231ArticuloImagen, H004M2_A40000ArticuloImagen_GXI, H004M2_A83ImpuestoPorcentaje, H004M2_A18ImpuestoId, H004M2_A103TipoArticuloNombre, H004M2_A17TipoArticuloId, H004M2_A79ArticuloStock, H004M2_A222ArticuloPrecioPromedio, H004M2_A78ArticuloPrecioVenta,
            H004M2_A77ArticuloPrecioCompra, H004M2_A215ArticuloDescripcionLarga, H004M2_A214ArticuloDescripcionCorta, H004M2_A76ArticuloNombre
            }
         }
      );
      AV17Pgmname = "ArticuloGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "ArticuloGeneral" ;
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
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtArticuloDescripcionCorta_Enabled ;
   private int edtArticuloDescripcionLarga_Enabled ;
   private int edtArticuloPrecioCompra_Enabled ;
   private int edtArticuloPrecioVenta_Enabled ;
   private int edtArticuloPrecioPromedio_Enabled ;
   private int edtArticuloStock_Enabled ;
   private int edtTipoArticuloId_Enabled ;
   private int edtTipoArticuloNombre_Enabled ;
   private int edtImpuestoId_Enabled ;
   private int edtImpuestoPorcentaje_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private long wcpOA13ArticuloId ;
   private long A13ArticuloId ;
   private long A17TipoArticuloId ;
   private long A79ArticuloStock ;
   private long A18ImpuestoId ;
   private java.math.BigDecimal A77ArticuloPrecioCompra ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
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
   private String edtArticuloId_Internalname ;
   private String edtArticuloId_Jsonclick ;
   private String edtArticuloNombre_Internalname ;
   private String A76ArticuloNombre ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtArticuloDescripcionCorta_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtArticuloDescripcionLarga_Internalname ;
   private String edtArticuloPrecioCompra_Internalname ;
   private String edtArticuloPrecioCompra_Jsonclick ;
   private String edtArticuloPrecioVenta_Internalname ;
   private String edtArticuloPrecioVenta_Jsonclick ;
   private String edtArticuloPrecioPromedio_Internalname ;
   private String edtArticuloPrecioPromedio_Jsonclick ;
   private String edtArticuloStock_Internalname ;
   private String edtArticuloStock_Jsonclick ;
   private String edtTipoArticuloId_Internalname ;
   private String edtTipoArticuloId_Jsonclick ;
   private String edtTipoArticuloNombre_Internalname ;
   private String A103TipoArticuloNombre ;
   private String edtTipoArticuloNombre_Link ;
   private String edtTipoArticuloNombre_Jsonclick ;
   private String edtImpuestoId_Internalname ;
   private String edtImpuestoId_Jsonclick ;
   private String edtImpuestoPorcentaje_Internalname ;
   private String edtImpuestoPorcentaje_Jsonclick ;
   private String imgArticuloImagen_Internalname ;
   private String sImgUrl ;
   private String TempTags ;
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
   private String hsh ;
   private String sCtrlA13ArticuloId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV12IsAuthorized_Update ;
   private boolean AV13IsAuthorized_Delete ;
   private boolean wbLoad ;
   private boolean A231ArticuloImagen_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV14TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A215ArticuloDescripcionLarga ;
   private String A214ArticuloDescripcionCorta ;
   private String A40000ArticuloImagen_GXI ;
   private String A231ArticuloImagen ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private long[] H004M2_A13ArticuloId ;
   private String[] H004M2_A231ArticuloImagen ;
   private String[] H004M2_A40000ArticuloImagen_GXI ;
   private java.math.BigDecimal[] H004M2_A83ImpuestoPorcentaje ;
   private long[] H004M2_A18ImpuestoId ;
   private String[] H004M2_A103TipoArticuloNombre ;
   private long[] H004M2_A17TipoArticuloId ;
   private long[] H004M2_A79ArticuloStock ;
   private java.math.BigDecimal[] H004M2_A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal[] H004M2_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] H004M2_A77ArticuloPrecioCompra ;
   private String[] H004M2_A215ArticuloDescripcionLarga ;
   private String[] H004M2_A214ArticuloDescripcionCorta ;
   private String[] H004M2_A76ArticuloNombre ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class articulogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004M2", "SELECT T1.[ArticuloId], T1.[ArticuloImagen], T1.[ArticuloImagen_GXI], T2.[ImpuestoPorcentaje], T1.[ImpuestoId], T3.[TipoArticuloNombre], T1.[TipoArticuloId], T1.[ArticuloStock], T1.[ArticuloPrecioPromedio], T1.[ArticuloPrecioVenta], T1.[ArticuloPrecioCompra], T1.[ArticuloDescripcionLarga], T1.[ArticuloDescripcionCorta], T1.[ArticuloNombre] FROM (([Articulo] T1 INNER JOIN [Impuesto] T2 ON T2.[ImpuestoId] = T1.[ImpuestoId]) INNER JOIN [TipoArticulo] T3 ON T3.[TipoArticuloId] = T1.[TipoArticuloId]) WHERE T1.[ArticuloId] = ? ORDER BY T1.[ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 80);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 80);
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

