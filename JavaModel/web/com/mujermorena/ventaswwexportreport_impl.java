package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ventaswwexportreport_impl extends GXWebReport
{
   public ventaswwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventasww_Execute", GXv_boolean2) ;
         ventaswwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV28Title = httpContext.getMessage( "Lista de Ventas", "") ;
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
         h4G0( true, 0) ;
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
         h4G0( false, 20) ;
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
      h4G0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4G0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 30, Gx_line+10, 66, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Fecha", ""), 70, Gx_line+10, 106, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 110, Gx_line+10, 146, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Pedido", ""), 150, Gx_line+10, 186, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Timbrado Id", ""), 190, Gx_line+10, 226, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Timbrado Numero", ""), 230, Gx_line+10, 266, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Serie1", ""), 270, Gx_line+10, 306, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Serie2", ""), 310, Gx_line+10, 346, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nro Factura", ""), 350, Gx_line+10, 386, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Tipo Pago Id", ""), 390, Gx_line+10, 426, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Tipo Pago Nombre", ""), 430, Gx_line+10, 466, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Serial", ""), 470, Gx_line+10, 506, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Exento", ""), 510, Gx_line+10, 546, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total5", ""), 550, Gx_line+10, 586, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total10", ""), 590, Gx_line+10, 626, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total", ""), 630, Gx_line+10, 666, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Iva5", ""), 670, Gx_line+10, 706, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Iva10", ""), 710, Gx_line+10, 746, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total IVA", ""), 750, Gx_line+10, 787, Gx_line+27, 2, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Ventaswwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV35Ventaswwds_1_filterfulltext ,
                                           Long.valueOf(A19VentasId) ,
                                           Long.valueOf(A4ClienteId) ,
                                           Long.valueOf(A251VentasPedido) ,
                                           Long.valueOf(A29TimbradoId) ,
                                           Long.valueOf(A125TimbradoNumero) ,
                                           Short.valueOf(A309VentasSerie1) ,
                                           Short.valueOf(A310VentasSerie2) ,
                                           Long.valueOf(A311VentasNroFactura) ,
                                           Long.valueOf(A9TipoPagoId) ,
                                           A71TipoPagoNombre ,
                                           Long.valueOf(A242VentasSerial) ,
                                           A239VentasTotalExento ,
                                           A236VentasTotal5 ,
                                           A238VentasTotal10 ,
                                           A240VentasTotal ,
                                           A235VentasTotalIva5 ,
                                           A237VentasTotalIva10 ,
                                           A241VentasTotalIVA } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN
                                           }
      });
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      lV35Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Ventaswwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004G8 */
      pr_default.execute(0, new Object[] {AV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext, lV35Ventaswwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A237VentasTotalIva10 = P004G8_A237VentasTotalIva10[0] ;
         n237VentasTotalIva10 = P004G8_n237VentasTotalIva10[0] ;
         A235VentasTotalIva5 = P004G8_A235VentasTotalIva5[0] ;
         n235VentasTotalIva5 = P004G8_n235VentasTotalIva5[0] ;
         A242VentasSerial = P004G8_A242VentasSerial[0] ;
         A9TipoPagoId = P004G8_A9TipoPagoId[0] ;
         A311VentasNroFactura = P004G8_A311VentasNroFactura[0] ;
         A310VentasSerie2 = P004G8_A310VentasSerie2[0] ;
         A309VentasSerie1 = P004G8_A309VentasSerie1[0] ;
         A125TimbradoNumero = P004G8_A125TimbradoNumero[0] ;
         A29TimbradoId = P004G8_A29TimbradoId[0] ;
         A251VentasPedido = P004G8_A251VentasPedido[0] ;
         A4ClienteId = P004G8_A4ClienteId[0] ;
         A19VentasId = P004G8_A19VentasId[0] ;
         A71TipoPagoNombre = P004G8_A71TipoPagoNombre[0] ;
         A91VentasFecha = P004G8_A91VentasFecha[0] ;
         A241VentasTotalIVA = P004G8_A241VentasTotalIVA[0] ;
         n241VentasTotalIVA = P004G8_n241VentasTotalIVA[0] ;
         A238VentasTotal10 = P004G8_A238VentasTotal10[0] ;
         n238VentasTotal10 = P004G8_n238VentasTotal10[0] ;
         A236VentasTotal5 = P004G8_A236VentasTotal5[0] ;
         n236VentasTotal5 = P004G8_n236VentasTotal5[0] ;
         A240VentasTotal = P004G8_A240VentasTotal[0] ;
         n240VentasTotal = P004G8_n240VentasTotal[0] ;
         A239VentasTotalExento = P004G8_A239VentasTotalExento[0] ;
         n239VentasTotalExento = P004G8_n239VentasTotalExento[0] ;
         A71TipoPagoNombre = P004G8_A71TipoPagoNombre[0] ;
         A125TimbradoNumero = P004G8_A125TimbradoNumero[0] ;
         A237VentasTotalIva10 = P004G8_A237VentasTotalIva10[0] ;
         n237VentasTotalIva10 = P004G8_n237VentasTotalIva10[0] ;
         A235VentasTotalIva5 = P004G8_A235VentasTotalIva5[0] ;
         n235VentasTotalIva5 = P004G8_n235VentasTotalIva5[0] ;
         A238VentasTotal10 = P004G8_A238VentasTotal10[0] ;
         n238VentasTotal10 = P004G8_n238VentasTotal10[0] ;
         A236VentasTotal5 = P004G8_A236VentasTotal5[0] ;
         n236VentasTotal5 = P004G8_n236VentasTotal5[0] ;
         A239VentasTotalExento = P004G8_A239VentasTotalExento[0] ;
         n239VentasTotalExento = P004G8_n239VentasTotalExento[0] ;
         A241VentasTotalIVA = P004G8_A241VentasTotalIVA[0] ;
         n241VentasTotalIVA = P004G8_n241VentasTotalIVA[0] ;
         A240VentasTotal = P004G8_A240VentasTotal[0] ;
         n240VentasTotal = P004G8_n240VentasTotal[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
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
         h4G0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 66, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A91VentasFecha, "99/99/99"), 70, Gx_line+10, 106, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9")), 110, Gx_line+10, 146, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A251VentasPedido), "ZZZZZZZZZZ9")), 150, Gx_line+10, 186, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9")), 190, Gx_line+10, 226, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9")), 230, Gx_line+10, 266, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A309VentasSerie1), "ZZ9")), 270, Gx_line+10, 306, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A310VentasSerie2), "ZZ9")), 310, Gx_line+10, 346, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9")), 350, Gx_line+10, 386, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9")), 390, Gx_line+10, 426, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A71TipoPagoNombre, "")), 430, Gx_line+10, 466, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A242VentasSerial), "ZZZZZZZZZ9")), 470, Gx_line+10, 506, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A239VentasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 510, Gx_line+10, 546, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A236VentasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 550, Gx_line+10, 586, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A238VentasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 590, Gx_line+10, 626, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 630, Gx_line+10, 666, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 670, Gx_line+10, 706, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 710, Gx_line+10, 746, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A241VentasTotalIVA, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 750, Gx_line+10, 787, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+36) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
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
      if ( GXutil.strcmp(AV14Session.getValue("VentasWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "VentasWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("VentasWWGridState"), null, null);
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

   public void h4G0( boolean bFoot ,
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
      A91VentasFecha = GXutil.nullDate() ;
      A71TipoPagoNombre = "" ;
      A239VentasTotalExento = DecimalUtil.ZERO ;
      A236VentasTotal5 = DecimalUtil.ZERO ;
      A238VentasTotal10 = DecimalUtil.ZERO ;
      A240VentasTotal = DecimalUtil.ZERO ;
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      A241VentasTotalIVA = DecimalUtil.ZERO ;
      AV35Ventaswwds_1_filterfulltext = "" ;
      lV35Ventaswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      P004G8_A237VentasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n237VentasTotalIva10 = new boolean[] {false} ;
      P004G8_A235VentasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n235VentasTotalIva5 = new boolean[] {false} ;
      P004G8_A242VentasSerial = new long[1] ;
      P004G8_A9TipoPagoId = new long[1] ;
      P004G8_A311VentasNroFactura = new long[1] ;
      P004G8_A310VentasSerie2 = new short[1] ;
      P004G8_A309VentasSerie1 = new short[1] ;
      P004G8_A125TimbradoNumero = new long[1] ;
      P004G8_A29TimbradoId = new long[1] ;
      P004G8_A251VentasPedido = new long[1] ;
      P004G8_A4ClienteId = new long[1] ;
      P004G8_A19VentasId = new long[1] ;
      P004G8_A71TipoPagoNombre = new String[] {""} ;
      P004G8_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004G8_A241VentasTotalIVA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n241VentasTotalIVA = new boolean[] {false} ;
      P004G8_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n238VentasTotal10 = new boolean[] {false} ;
      P004G8_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n236VentasTotal5 = new boolean[] {false} ;
      P004G8_A240VentasTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n240VentasTotal = new boolean[] {false} ;
      P004G8_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004G8_n239VentasTotalExento = new boolean[] {false} ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ventaswwexportreport__default(),
         new Object[] {
             new Object[] {
            P004G8_A237VentasTotalIva10, P004G8_n237VentasTotalIva10, P004G8_A235VentasTotalIva5, P004G8_n235VentasTotalIva5, P004G8_A242VentasSerial, P004G8_A9TipoPagoId, P004G8_A311VentasNroFactura, P004G8_A310VentasSerie2, P004G8_A309VentasSerie1, P004G8_A125TimbradoNumero,
            P004G8_A29TimbradoId, P004G8_A251VentasPedido, P004G8_A4ClienteId, P004G8_A19VentasId, P004G8_A71TipoPagoNombre, P004G8_A91VentasFecha, P004G8_A241VentasTotalIVA, P004G8_n241VentasTotalIVA, P004G8_A238VentasTotal10, P004G8_n238VentasTotal10,
            P004G8_A236VentasTotal5, P004G8_n236VentasTotal5, P004G8_A240VentasTotal, P004G8_n240VentasTotal, P004G8_A239VentasTotalExento
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
   private short A309VentasSerie1 ;
   private short A310VentasSerie2 ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV36GXV1 ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A251VentasPedido ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A311VentasNroFactura ;
   private long A9TipoPagoId ;
   private long A242VentasSerial ;
   private java.math.BigDecimal A239VentasTotalExento ;
   private java.math.BigDecimal A236VentasTotal5 ;
   private java.math.BigDecimal A238VentasTotal10 ;
   private java.math.BigDecimal A240VentasTotal ;
   private java.math.BigDecimal A235VentasTotalIva5 ;
   private java.math.BigDecimal A237VentasTotalIva10 ;
   private java.math.BigDecimal A241VentasTotalIVA ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String A71TipoPagoNombre ;
   private String scmdbuf ;
   private java.util.Date A91VentasFecha ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n237VentasTotalIva10 ;
   private boolean n235VentasTotalIva5 ;
   private boolean n241VentasTotalIVA ;
   private boolean n238VentasTotal10 ;
   private boolean n236VentasTotal5 ;
   private boolean n240VentasTotal ;
   private boolean n239VentasTotalExento ;
   private String AV28Title ;
   private String AV13FilterFullText ;
   private String AV35Ventaswwds_1_filterfulltext ;
   private String lV35Ventaswwds_1_filterfulltext ;
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
   private java.math.BigDecimal[] P004G8_A237VentasTotalIva10 ;
   private boolean[] P004G8_n237VentasTotalIva10 ;
   private java.math.BigDecimal[] P004G8_A235VentasTotalIva5 ;
   private boolean[] P004G8_n235VentasTotalIva5 ;
   private long[] P004G8_A242VentasSerial ;
   private long[] P004G8_A9TipoPagoId ;
   private long[] P004G8_A311VentasNroFactura ;
   private short[] P004G8_A310VentasSerie2 ;
   private short[] P004G8_A309VentasSerie1 ;
   private long[] P004G8_A125TimbradoNumero ;
   private long[] P004G8_A29TimbradoId ;
   private long[] P004G8_A251VentasPedido ;
   private long[] P004G8_A4ClienteId ;
   private long[] P004G8_A19VentasId ;
   private String[] P004G8_A71TipoPagoNombre ;
   private java.util.Date[] P004G8_A91VentasFecha ;
   private java.math.BigDecimal[] P004G8_A241VentasTotalIVA ;
   private boolean[] P004G8_n241VentasTotalIVA ;
   private java.math.BigDecimal[] P004G8_A238VentasTotal10 ;
   private boolean[] P004G8_n238VentasTotal10 ;
   private java.math.BigDecimal[] P004G8_A236VentasTotal5 ;
   private boolean[] P004G8_n236VentasTotal5 ;
   private java.math.BigDecimal[] P004G8_A240VentasTotal ;
   private boolean[] P004G8_n240VentasTotal ;
   private java.math.BigDecimal[] P004G8_A239VentasTotalExento ;
   private boolean[] P004G8_n239VentasTotalExento ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class ventaswwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004G8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV35Ventaswwds_1_filterfulltext ,
                                          long A19VentasId ,
                                          long A4ClienteId ,
                                          long A251VentasPedido ,
                                          long A29TimbradoId ,
                                          long A125TimbradoNumero ,
                                          short A309VentasSerie1 ,
                                          short A310VentasSerie2 ,
                                          long A311VentasNroFactura ,
                                          long A9TipoPagoId ,
                                          String A71TipoPagoNombre ,
                                          long A242VentasSerial ,
                                          java.math.BigDecimal A239VentasTotalExento ,
                                          java.math.BigDecimal A236VentasTotal5 ,
                                          java.math.BigDecimal A238VentasTotal10 ,
                                          java.math.BigDecimal A240VentasTotal ,
                                          java.math.BigDecimal A235VentasTotalIva5 ,
                                          java.math.BigDecimal A237VentasTotalIva10 ,
                                          java.math.BigDecimal A241VentasTotalIVA )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[19];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIva10, ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27," ;
      scmdbuf += " 10)) / 21, 0) AS VentasTotalIva5, T1.[VentasSerial], T1.[TipoPagoId], T1.[VentasNroFactura], T1.[VentasSerie2], T1.[VentasSerie1], T3.[TimbradoNumero], T1.[TimbradoId]," ;
      scmdbuf += " T1.[VentasPedido], T1.[ClienteId], T1.[VentasId], T2.[TipoPagoNombre], T1.[VentasFecha], COALESCE( T6.[VentasTotalIVA], 0) AS VentasTotalIVA, COALESCE( T5.[VentasTotal10]," ;
      scmdbuf += " 0) AS VentasTotal10, COALESCE( T5.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T6.[VentasTotal], 0) AS VentasTotal, COALESCE( T5.[VentasTotalExento], 0) AS VentasTotalExento" ;
      scmdbuf += " FROM ((((([Ventas] T1 INNER JOIN [TipoPago] T2 ON T2.[TipoPagoId] = T1.[TipoPagoId]) INNER JOIN [Timbrado] T3 ON T3.[TimbradoId] = T1.[TimbradoId]) LEFT JOIN (SELECT" ;
      scmdbuf += " SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T7.[VentasId]" ;
      scmdbuf += " FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId] = T8.[ImpuestoId]) GROUP BY" ;
      scmdbuf += " T7.[VentasId] ) T4 ON T4.[VentasId] = T1.[VentasId]) LEFT JOIN (SELECT T7.[VentasId], SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 5 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 0 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal(" ;
      scmdbuf += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId]" ;
      scmdbuf += " = T8.[ImpuestoId]) GROUP BY T7.[VentasId] ) T5 ON T5.[VentasId] = T1.[VentasId]) INNER JOIN (SELECT COALESCE( T8.[VentasTotalExento], 0) + COALESCE( COALESCE( T9.[VentasTotal5]," ;
      scmdbuf += " 0), 0) + COALESCE( COALESCE( T10.[VentasTotal10], 0), 0) AS VentasTotal, T7.[VentasId], ROUND(CAST(( ( COALESCE( T9.[VentasTotal5], 0))) AS decimal( 27, 10)) /" ;
      scmdbuf += " 21, 0) + ROUND(CAST(( ( COALESCE( T10.[VentasTotal10], 0))) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIVA FROM ((([Ventas] T7 LEFT JOIN (SELECT SUM(CASE  WHEN" ;
      scmdbuf += " T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T11.[VentasId] FROM" ;
      scmdbuf += " (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP" ;
      scmdbuf += " BY T11.[VentasId] ) T8 ON T8.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT T11.[VentasId], SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 5 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal(" ;
      scmdbuf += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId]" ;
      scmdbuf += " = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T9 ON T9.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T11.[VentasId] FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId]" ;
      scmdbuf += " = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T10 ON T10.[VentasId] = T7.[VentasId]) ) T6 ON T6.[VentasId]" ;
      scmdbuf += " = T1.[VentasId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(11), CAST(T1.[VentasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[VentasPedido] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TimbradoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T3.[TimbradoNumero] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie1] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie2] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(15), CAST(T1.[VentasNroFactura] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoPagoId] AS decimal(11,0))) like '%' + ?) or ( T2.[TipoPagoNombre] like '%' + ?) or ( CONVERT( char(10), CAST(T1.[VentasSerial] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotalExento], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal10], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotal], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27, 10)) / 21, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotalIVA], 0) AS decimal(17,2))) like '%' + ?)))");
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasFecha]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClienteId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasPedido]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasPedido] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TimbradoId]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TimbradoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[TimbradoNumero]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[TimbradoNumero] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie1]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie1] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie2]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie2] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasNroFactura]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasNroFactura] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TipoPagoId]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TipoPagoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[TipoPagoNombre]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[TipoPagoNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasSerial]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasSerial] DESC" ;
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
                  return conditional_P004G8(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).longValue() , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).longValue() , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004G8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(3);
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((long[]) buf[9])[0] = rslt.getLong(8);
               ((long[]) buf[10])[0] = rslt.getLong(9);
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((long[]) buf[13])[0] = rslt.getLong(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 80);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(14);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(15,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(16,2);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(17,2);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(18,2);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(19,2);
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
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               return;
      }
   }

}

