package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class devolucioneswwexportreport_impl extends GXWebReport
{
   public devolucioneswwexportreport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("WorkWithPlusDS");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 1, 15840, 12240, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "devolucionesww_Execute", GXv_boolean2) ;
         devolucioneswwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV9WWPContext;
            new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV9WWPContext = GXv_SdtWWPContext3[0] ;
            /* Execute user subroutine: 'LOADGRIDSTATE' */
            S151 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV28Title = httpContext.getMessage( "Lista de Devoluciones", "") ;
            /* Execute user subroutine: 'PRINTFILTERS' */
            S111 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTCOLUMNTITLES' */
            S121 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTDATA' */
            S131 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTFOOTER' */
            S171 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h6T0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( ) throws ProcessInterruptedException
   {
      /* 'PRINTFILTERS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         h6T0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "WWP_FullTextFilterDescription", ""), 25, Gx_line+0, 99, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 99, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h6T0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h6T0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "ID", ""), 30, Gx_line+10, 90, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Fecha", ""), 94, Gx_line+10, 154, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 158, Gx_line+10, 218, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Fecha", ""), 222, Gx_line+10, 282, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 286, Gx_line+10, 346, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Pago Id", ""), 350, Gx_line+10, 410, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Devolucion ID", ""), 414, Gx_line+10, 474, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Devolucion Descripcion", ""), 478, Gx_line+10, 598, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Observacion", ""), 602, Gx_line+10, 722, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total", ""), 726, Gx_line+10, 787, Gx_line+27, 2, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Devolucioneswwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV35Devolucioneswwds_1_filterfulltext ,
                                           Long.valueOf(A272DevolucionesID) ,
                                           Long.valueOf(A19VentasId) ,
                                           Long.valueOf(A4ClienteId) ,
                                           Long.valueOf(A9TipoPagoId) ,
                                           Long.valueOf(A273MotivoDevolucionID) ,
                                           A280MotivoDevolucionDescripcion ,
                                           A279DevolucionesObservacion ,
                                           A276DevolucionesTotal ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV35Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Devolucioneswwds_1_filterfulltext), "%", "") ;
      /* Using cursor P006T3 */
      pr_default.execute(0, new Object[] {lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext, lV35Devolucioneswwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A273MotivoDevolucionID = P006T3_A273MotivoDevolucionID[0] ;
         A9TipoPagoId = P006T3_A9TipoPagoId[0] ;
         A4ClienteId = P006T3_A4ClienteId[0] ;
         A19VentasId = P006T3_A19VentasId[0] ;
         A272DevolucionesID = P006T3_A272DevolucionesID[0] ;
         A279DevolucionesObservacion = P006T3_A279DevolucionesObservacion[0] ;
         A280MotivoDevolucionDescripcion = P006T3_A280MotivoDevolucionDescripcion[0] ;
         A91VentasFecha = P006T3_A91VentasFecha[0] ;
         A275DevolucionesFecha = P006T3_A275DevolucionesFecha[0] ;
         A276DevolucionesTotal = P006T3_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = P006T3_n276DevolucionesTotal[0] ;
         A280MotivoDevolucionDescripcion = P006T3_A280MotivoDevolucionDescripcion[0] ;
         A9TipoPagoId = P006T3_A9TipoPagoId[0] ;
         A4ClienteId = P006T3_A4ClienteId[0] ;
         A91VentasFecha = P006T3_A91VentasFecha[0] ;
         A276DevolucionesTotal = P006T3_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = P006T3_n276DevolucionesTotal[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h6T0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A272DevolucionesID), "ZZZZZZZZZ9")), 30, Gx_line+10, 90, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A275DevolucionesFecha, "99/99/99"), 94, Gx_line+10, 154, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9")), 158, Gx_line+10, 218, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A91VentasFecha, "99/99/99"), 222, Gx_line+10, 282, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9")), 286, Gx_line+10, 346, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9")), 350, Gx_line+10, 410, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A273MotivoDevolucionID), "ZZZZZZZZZ9")), 414, Gx_line+10, 474, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A280MotivoDevolucionDescripcion, "")), 478, Gx_line+10, 598, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A279DevolucionesObservacion, 602, Gx_line+10, 722, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A276DevolucionesTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 726, Gx_line+10, 787, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV14Session.getValue("DevolucionesWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DevolucionesWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("DevolucionesWWGridState"), null, null);
      }
      AV11OrderedBy = AV16GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV16GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV36GXV1 = 1 ;
      while ( AV36GXV1 <= AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV17GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV36GXV1));
         if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV36GXV1 = (int)(AV36GXV1+1) ;
      }
   }

   public void S144( ) throws ProcessInterruptedException
   {
      /* 'BEFOREPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S161( ) throws ProcessInterruptedException
   {
      /* 'AFTERPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S171( ) throws ProcessInterruptedException
   {
      /* 'PRINTFOOTER' Routine */
      returnInSub = false ;
   }

   public void h6T0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               AV26PageInfo = httpContext.getMessage( "Page: ", "") + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV23DateInfo = httpContext.getMessage( "Date: ", "") + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 128, 128, 0, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+40) ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            AV21AppName = httpContext.getMessage( "DVelop Software Solutions", "") ;
            AV27Phone = "+1 550 8923" ;
            AV25Mail = "info@mail.com" ;
            AV29Website = "http://www.web.com" ;
            AV18AddressLine1 = "French Boulevard 2859" ;
            AV19AddressLine2 = "Downtown" ;
            AV20AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 128, 128, 0, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV18AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+128) ;
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
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
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Title = "" ;
      AV13FilterFullText = "" ;
      A275DevolucionesFecha = GXutil.nullDate() ;
      A91VentasFecha = GXutil.nullDate() ;
      A280MotivoDevolucionDescripcion = "" ;
      A279DevolucionesObservacion = "" ;
      A276DevolucionesTotal = DecimalUtil.ZERO ;
      AV35Devolucioneswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV35Devolucioneswwds_1_filterfulltext = "" ;
      P006T3_A273MotivoDevolucionID = new long[1] ;
      P006T3_A9TipoPagoId = new long[1] ;
      P006T3_A4ClienteId = new long[1] ;
      P006T3_A19VentasId = new long[1] ;
      P006T3_A272DevolucionesID = new long[1] ;
      P006T3_A279DevolucionesObservacion = new String[] {""} ;
      P006T3_A280MotivoDevolucionDescripcion = new String[] {""} ;
      P006T3_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006T3_A275DevolucionesFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006T3_A276DevolucionesTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006T3_n276DevolucionesTotal = new boolean[] {false} ;
      AV14Session = httpContext.getWebSession();
      AV16GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV26PageInfo = "" ;
      AV23DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV21AppName = "" ;
      AV27Phone = "" ;
      AV25Mail = "" ;
      AV29Website = "" ;
      AV18AddressLine1 = "" ;
      AV19AddressLine2 = "" ;
      AV20AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.devolucioneswwexportreport__default(),
         new Object[] {
             new Object[] {
            P006T3_A273MotivoDevolucionID, P006T3_A9TipoPagoId, P006T3_A4ClienteId, P006T3_A19VentasId, P006T3_A272DevolucionesID, P006T3_A279DevolucionesObservacion, P006T3_A280MotivoDevolucionDescripcion, P006T3_A91VentasFecha, P006T3_A275DevolucionesFecha, P006T3_A276DevolucionesTotal,
            P006T3_n276DevolucionesTotal
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV36GXV1 ;
   private long A272DevolucionesID ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A9TipoPagoId ;
   private long A273MotivoDevolucionID ;
   private java.math.BigDecimal A276DevolucionesTotal ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private java.util.Date A275DevolucionesFecha ;
   private java.util.Date A91VentasFecha ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n276DevolucionesTotal ;
   private String A279DevolucionesObservacion ;
   private String AV28Title ;
   private String AV13FilterFullText ;
   private String A280MotivoDevolucionDescripcion ;
   private String AV35Devolucioneswwds_1_filterfulltext ;
   private String lV35Devolucioneswwds_1_filterfulltext ;
   private String AV26PageInfo ;
   private String AV23DateInfo ;
   private String AV21AppName ;
   private String AV27Phone ;
   private String AV25Mail ;
   private String AV29Website ;
   private String AV18AddressLine1 ;
   private String AV19AddressLine2 ;
   private String AV20AddressLine3 ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private long[] P006T3_A273MotivoDevolucionID ;
   private long[] P006T3_A9TipoPagoId ;
   private long[] P006T3_A4ClienteId ;
   private long[] P006T3_A19VentasId ;
   private long[] P006T3_A272DevolucionesID ;
   private String[] P006T3_A279DevolucionesObservacion ;
   private String[] P006T3_A280MotivoDevolucionDescripcion ;
   private java.util.Date[] P006T3_A91VentasFecha ;
   private java.util.Date[] P006T3_A275DevolucionesFecha ;
   private java.math.BigDecimal[] P006T3_A276DevolucionesTotal ;
   private boolean[] P006T3_n276DevolucionesTotal ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class devolucioneswwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV35Devolucioneswwds_1_filterfulltext ,
                                          long A272DevolucionesID ,
                                          long A19VentasId ,
                                          long A4ClienteId ,
                                          long A9TipoPagoId ,
                                          long A273MotivoDevolucionID ,
                                          String A280MotivoDevolucionDescripcion ,
                                          String A279DevolucionesObservacion ,
                                          java.math.BigDecimal A276DevolucionesTotal ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[MotivoDevolucionID], T3.[TipoPagoId], T3.[ClienteId], T1.[VentasId], T1.[DevolucionesID], T1.[DevolucionesObservacion], T2.[MotivoDevolucionDescripcion]," ;
      scmdbuf += " T3.[VentasFecha], T1.[DevolucionesFecha], COALESCE( T4.[DevolucionesTotal], 0) AS DevolucionesTotal FROM ((([Devoluciones] T1 INNER JOIN [MotivoDevolucion] T2 ON" ;
      scmdbuf += " T2.[MotivoDevolucionID] = T1.[MotivoDevolucionID]) INNER JOIN [Ventas] T3 ON T3.[VentasId] = T1.[VentasId]) LEFT JOIN (SELECT SUM(T6.[ArticuloPrecioVenta] * CAST(T5.[DevolucionesDetalleCant]" ;
      scmdbuf += " AS decimal( 27, 10))) AS DevolucionesTotal, T5.[DevolucionesID] FROM ([DevolucionesDetalle] T5 INNER JOIN [Articulo] T6 ON T6.[ArticuloId] = T5.[ArticuloId]) GROUP" ;
      scmdbuf += " BY T5.[DevolucionesID] ) T4 ON T4.[DevolucionesID] = T1.[DevolucionesID])" ;
      if ( ! (GXutil.strcmp("", AV35Devolucioneswwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(10), CAST(T1.[DevolucionesID] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[VentasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[TipoPagoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T1.[MotivoDevolucionID] AS decimal(10,0))) like '%' + ?) or ( T2.[MotivoDevolucionDescripcion] like '%' + ?) or ( T1.[DevolucionesObservacion] like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T4.[DevolucionesTotal], 0) AS decimal(17,2))) like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesID]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesID] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesFecha]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[VentasFecha]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[VentasFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ClienteId]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ClienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[TipoPagoId]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[TipoPagoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MotivoDevolucionID]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MotivoDevolucionID] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MotivoDevolucionDescripcion]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MotivoDevolucionDescripcion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesObservacion]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesObservacion] DESC" ;
      }
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P006T3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Boolean) dynConstraints[10]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               return;
      }
   }

}

