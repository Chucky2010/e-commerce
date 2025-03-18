package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class movimientocajawwexportreport_impl extends GXWebReport
{
   public movimientocajawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "movimientocajaww_Execute", GXv_boolean2) ;
         movimientocajawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV28Title = httpContext.getMessage( "Lista de Movimiento Caja", "") ;
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
         h4T0( true, 0) ;
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
         h4T0( false, 20) ;
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
      h4T0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4T0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Id", ""), 30, Gx_line+10, 84, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Hora", ""), 88, Gx_line+10, 142, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Ingreso", ""), 146, Gx_line+10, 200, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Egreso", ""), 204, Gx_line+10, 258, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Saldo", ""), 262, Gx_line+10, 316, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Fecha", ""), 320, Gx_line+10, 374, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Informacion", ""), 378, Gx_line+10, 432, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 436, Gx_line+10, 490, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 494, Gx_line+10, 549, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 553, Gx_line+10, 608, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Numero", ""), 612, Gx_line+10, 667, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Asignacion", ""), 671, Gx_line+10, 727, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Caja Estado", ""), 731, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Movimientocajawwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV35Movimientocajawwds_1_filterfulltext ,
                                           Long.valueOf(A27MovimientoCajaId) ,
                                           A117MovimientoCajaIngreso ,
                                           A118MovimientoCajaEgreso ,
                                           A119MovimientoCajaSaldo ,
                                           A266MovimientoCajaDocum ,
                                           Long.valueOf(A26CajeroId) ,
                                           A112CajeroNombre ,
                                           Long.valueOf(A25CajaId) ,
                                           Long.valueOf(A110CajaNumero) ,
                                           A256MovimientoCajaAsignacion ,
                                           A267MovimientoCajaEstado ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV35Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Movimientocajawwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004T2 */
      pr_default.execute(0, new Object[] {lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext, lV35Movimientocajawwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A110CajaNumero = P004T2_A110CajaNumero[0] ;
         A25CajaId = P004T2_A25CajaId[0] ;
         A26CajeroId = P004T2_A26CajeroId[0] ;
         A119MovimientoCajaSaldo = P004T2_A119MovimientoCajaSaldo[0] ;
         A118MovimientoCajaEgreso = P004T2_A118MovimientoCajaEgreso[0] ;
         A117MovimientoCajaIngreso = P004T2_A117MovimientoCajaIngreso[0] ;
         A27MovimientoCajaId = P004T2_A27MovimientoCajaId[0] ;
         A267MovimientoCajaEstado = P004T2_A267MovimientoCajaEstado[0] ;
         A256MovimientoCajaAsignacion = P004T2_A256MovimientoCajaAsignacion[0] ;
         A112CajeroNombre = P004T2_A112CajeroNombre[0] ;
         A266MovimientoCajaDocum = P004T2_A266MovimientoCajaDocum[0] ;
         A120MovimientoCajaFecha = P004T2_A120MovimientoCajaFecha[0] ;
         A116MovimientoCajaHora = P004T2_A116MovimientoCajaHora[0] ;
         A110CajaNumero = P004T2_A110CajaNumero[0] ;
         A112CajeroNombre = P004T2_A112CajeroNombre[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
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
         h4T0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A27MovimientoCajaId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 84, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A116MovimientoCajaHora, "99:99"), 88, Gx_line+10, 142, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A117MovimientoCajaIngreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 146, Gx_line+10, 200, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A118MovimientoCajaEgreso, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 204, Gx_line+10, 258, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A119MovimientoCajaSaldo, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 262, Gx_line+10, 316, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A120MovimientoCajaFecha, "99/99/99"), 320, Gx_line+10, 374, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A266MovimientoCajaDocum, "")), 378, Gx_line+10, 432, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A26CajeroId), "ZZZZZZZZZZ9")), 436, Gx_line+10, 490, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A112CajeroNombre, "")), 494, Gx_line+10, 549, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A25CajaId), "ZZZZZZZZZZ9")), 553, Gx_line+10, 608, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A110CajaNumero), "ZZZZZZZZZ9")), 612, Gx_line+10, 667, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A256MovimientoCajaAsignacion, "")), 671, Gx_line+10, 727, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A267MovimientoCajaEstado, "")), 731, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV14Session.getValue("MovimientoCajaWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MovimientoCajaWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("MovimientoCajaWWGridState"), null, null);
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

   public void h4T0( boolean bFoot ,
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
      A116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      A120MovimientoCajaFecha = GXutil.nullDate() ;
      A266MovimientoCajaDocum = "" ;
      A112CajeroNombre = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A267MovimientoCajaEstado = "" ;
      AV35Movimientocajawwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV35Movimientocajawwds_1_filterfulltext = "" ;
      P004T2_A110CajaNumero = new long[1] ;
      P004T2_A25CajaId = new long[1] ;
      P004T2_A26CajeroId = new long[1] ;
      P004T2_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004T2_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004T2_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004T2_A27MovimientoCajaId = new long[1] ;
      P004T2_A267MovimientoCajaEstado = new String[] {""} ;
      P004T2_A256MovimientoCajaAsignacion = new String[] {""} ;
      P004T2_A112CajeroNombre = new String[] {""} ;
      P004T2_A266MovimientoCajaDocum = new String[] {""} ;
      P004T2_A120MovimientoCajaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004T2_A116MovimientoCajaHora = new java.util.Date[] {GXutil.nullDate()} ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.movimientocajawwexportreport__default(),
         new Object[] {
             new Object[] {
            P004T2_A110CajaNumero, P004T2_A25CajaId, P004T2_A26CajeroId, P004T2_A119MovimientoCajaSaldo, P004T2_A118MovimientoCajaEgreso, P004T2_A117MovimientoCajaIngreso, P004T2_A27MovimientoCajaId, P004T2_A267MovimientoCajaEstado, P004T2_A256MovimientoCajaAsignacion, P004T2_A112CajeroNombre,
            P004T2_A266MovimientoCajaDocum, P004T2_A120MovimientoCajaFecha, P004T2_A116MovimientoCajaHora
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
   private long A27MovimientoCajaId ;
   private long A26CajeroId ;
   private long A25CajaId ;
   private long A110CajaNumero ;
   private java.math.BigDecimal A117MovimientoCajaIngreso ;
   private java.math.BigDecimal A118MovimientoCajaEgreso ;
   private java.math.BigDecimal A119MovimientoCajaSaldo ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String A112CajeroNombre ;
   private String A256MovimientoCajaAsignacion ;
   private String A267MovimientoCajaEstado ;
   private String scmdbuf ;
   private java.util.Date A116MovimientoCajaHora ;
   private java.util.Date A120MovimientoCajaFecha ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV28Title ;
   private String AV13FilterFullText ;
   private String A266MovimientoCajaDocum ;
   private String AV35Movimientocajawwds_1_filterfulltext ;
   private String lV35Movimientocajawwds_1_filterfulltext ;
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
   private long[] P004T2_A110CajaNumero ;
   private long[] P004T2_A25CajaId ;
   private long[] P004T2_A26CajeroId ;
   private java.math.BigDecimal[] P004T2_A119MovimientoCajaSaldo ;
   private java.math.BigDecimal[] P004T2_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] P004T2_A117MovimientoCajaIngreso ;
   private long[] P004T2_A27MovimientoCajaId ;
   private String[] P004T2_A267MovimientoCajaEstado ;
   private String[] P004T2_A256MovimientoCajaAsignacion ;
   private String[] P004T2_A112CajeroNombre ;
   private String[] P004T2_A266MovimientoCajaDocum ;
   private java.util.Date[] P004T2_A120MovimientoCajaFecha ;
   private java.util.Date[] P004T2_A116MovimientoCajaHora ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class movimientocajawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV35Movimientocajawwds_1_filterfulltext ,
                                          long A27MovimientoCajaId ,
                                          java.math.BigDecimal A117MovimientoCajaIngreso ,
                                          java.math.BigDecimal A118MovimientoCajaEgreso ,
                                          java.math.BigDecimal A119MovimientoCajaSaldo ,
                                          String A266MovimientoCajaDocum ,
                                          long A26CajeroId ,
                                          String A112CajeroNombre ,
                                          long A25CajaId ,
                                          long A110CajaNumero ,
                                          String A256MovimientoCajaAsignacion ,
                                          String A267MovimientoCajaEstado ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[11];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[CajaNumero], T1.[CajaId], T1.[CajeroId], T1.[MovimientoCajaSaldo], T1.[MovimientoCajaEgreso], T1.[MovimientoCajaIngreso], T1.[MovimientoCajaId], T1.[MovimientoCajaEstado]," ;
      scmdbuf += " T1.[MovimientoCajaAsignacion], T3.[CajeroNombre], T1.[MovimientoCajaDocum], T1.[MovimientoCajaFecha], T1.[MovimientoCajaHora] FROM (([MovimientoCaja] T1 INNER JOIN" ;
      scmdbuf += " [Caja] T2 ON T2.[CajaId] = T1.[CajaId]) INNER JOIN [Cajero] T3 ON T3.[CajeroId] = T1.[CajeroId])" ;
      if ( ! (GXutil.strcmp("", AV35Movimientocajawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[MovimientoCajaId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[MovimientoCajaIngreso] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[MovimientoCajaEgreso] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[MovimientoCajaSaldo] AS decimal(17,2))) like '%' + ?) or ( T1.[MovimientoCajaDocum] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[CajeroId] AS decimal(11,0))) like '%' + ?) or ( T3.[CajeroNombre] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[CajaId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T2.[CajaNumero] AS decimal(10,0))) like '%' + ?) or ( T1.[MovimientoCajaAsignacion] like '%' + ?) or ( T1.[MovimientoCajaEstado] like '%' + ?))");
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
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaHora]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaHora] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaIngreso]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaIngreso] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEgreso]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEgreso] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaSaldo]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaSaldo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaFecha]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaDocum]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaDocum] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CajeroId]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CajeroId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[CajeroNombre]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[CajeroNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CajaId]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CajaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[CajaNumero]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[CajaNumero] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaAsignacion]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaAsignacion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEstado]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEstado] DESC" ;
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
                  return conditional_P004T2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (java.math.BigDecimal)dynConstraints[2] , (java.math.BigDecimal)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).longValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).longValue() , ((Number) dynConstraints[9]).longValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getString(10, 80);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(12);
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(13));
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
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               return;
      }
   }

}

