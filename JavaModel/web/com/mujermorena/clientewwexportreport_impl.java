package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clientewwexportreport_impl extends GXWebReport
{
   public clientewwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "clienteww_Execute", GXv_boolean2) ;
         clientewwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV28Title = httpContext.getMessage( "Lista de Cliente", "") ;
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
         h410( true, 0) ;
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
         h410( false, 20) ;
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
      h410( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h410( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 30, Gx_line+10, 121, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre Completo", ""), 125, Gx_line+10, 216, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Direccion", ""), 220, Gx_line+10, 311, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Telefono", ""), 315, Gx_line+10, 406, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Localidad Nombre", ""), 410, Gx_line+10, 501, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Ciudad Nombre", ""), 505, Gx_line+10, 596, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Departamento Nombre", ""), 600, Gx_line+10, 691, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "User", ""), 695, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Clientewwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV35Clientewwds_1_filterfulltext ,
                                           Long.valueOf(A4ClienteId) ,
                                           A55PersonaNombre ,
                                           A56PersonaApellido ,
                                           A57PersonaDireccion ,
                                           A66PersonaTelefono ,
                                           A64LocalidadNombre ,
                                           A62CiudadNombre ,
                                           A61DepartamentoNombre ,
                                           A244ClienteUser ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      lV35Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Clientewwds_1_filterfulltext), "%", "") ;
      /* Using cursor P00412 */
      pr_default.execute(0, new Object[] {lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext, lV35Clientewwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1PersonaId = P00412_A1PersonaId[0] ;
         A3LocalidadId = P00412_A3LocalidadId[0] ;
         A7CiudadId = P00412_A7CiudadId[0] ;
         A6DepartamentoId = P00412_A6DepartamentoId[0] ;
         A4ClienteId = P00412_A4ClienteId[0] ;
         A244ClienteUser = P00412_A244ClienteUser[0] ;
         A61DepartamentoNombre = P00412_A61DepartamentoNombre[0] ;
         A62CiudadNombre = P00412_A62CiudadNombre[0] ;
         A64LocalidadNombre = P00412_A64LocalidadNombre[0] ;
         A66PersonaTelefono = P00412_A66PersonaTelefono[0] ;
         A57PersonaDireccion = P00412_A57PersonaDireccion[0] ;
         A56PersonaApellido = P00412_A56PersonaApellido[0] ;
         A55PersonaNombre = P00412_A55PersonaNombre[0] ;
         A3LocalidadId = P00412_A3LocalidadId[0] ;
         A66PersonaTelefono = P00412_A66PersonaTelefono[0] ;
         A57PersonaDireccion = P00412_A57PersonaDireccion[0] ;
         A56PersonaApellido = P00412_A56PersonaApellido[0] ;
         A55PersonaNombre = P00412_A55PersonaNombre[0] ;
         A7CiudadId = P00412_A7CiudadId[0] ;
         A64LocalidadNombre = P00412_A64LocalidadNombre[0] ;
         A6DepartamentoId = P00412_A6DepartamentoId[0] ;
         A62CiudadNombre = P00412_A62CiudadNombre[0] ;
         A61DepartamentoNombre = P00412_A61DepartamentoNombre[0] ;
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
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
         h410( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 121, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A59PersonaNombreCompleto, "")), 125, Gx_line+10, 216, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A57PersonaDireccion, "")), 220, Gx_line+10, 311, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A66PersonaTelefono, "")), 315, Gx_line+10, 406, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A64LocalidadNombre, "")), 410, Gx_line+10, 501, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A62CiudadNombre, "")), 505, Gx_line+10, 596, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A61DepartamentoNombre, "")), 600, Gx_line+10, 691, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A244ClienteUser, "")), 695, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV14Session.getValue("ClienteWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("ClienteWWGridState"), null, null);
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

   public void h410( boolean bFoot ,
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
      A59PersonaNombreCompleto = "" ;
      A57PersonaDireccion = "" ;
      A66PersonaTelefono = "" ;
      A64LocalidadNombre = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A244ClienteUser = "" ;
      AV35Clientewwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV35Clientewwds_1_filterfulltext = "" ;
      A55PersonaNombre = "" ;
      A56PersonaApellido = "" ;
      P00412_A1PersonaId = new long[1] ;
      P00412_A3LocalidadId = new long[1] ;
      P00412_A7CiudadId = new long[1] ;
      P00412_A6DepartamentoId = new long[1] ;
      P00412_A4ClienteId = new long[1] ;
      P00412_A244ClienteUser = new String[] {""} ;
      P00412_A61DepartamentoNombre = new String[] {""} ;
      P00412_A62CiudadNombre = new String[] {""} ;
      P00412_A64LocalidadNombre = new String[] {""} ;
      P00412_A66PersonaTelefono = new String[] {""} ;
      P00412_A57PersonaDireccion = new String[] {""} ;
      P00412_A56PersonaApellido = new String[] {""} ;
      P00412_A55PersonaNombre = new String[] {""} ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.clientewwexportreport__default(),
         new Object[] {
             new Object[] {
            P00412_A1PersonaId, P00412_A3LocalidadId, P00412_A7CiudadId, P00412_A6DepartamentoId, P00412_A4ClienteId, P00412_A244ClienteUser, P00412_A61DepartamentoNombre, P00412_A62CiudadNombre, P00412_A64LocalidadNombre, P00412_A66PersonaTelefono,
            P00412_A57PersonaDireccion, P00412_A56PersonaApellido, P00412_A55PersonaNombre
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
   private long A4ClienteId ;
   private long A1PersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String A59PersonaNombreCompleto ;
   private String A66PersonaTelefono ;
   private String A64LocalidadNombre ;
   private String A62CiudadNombre ;
   private String A61DepartamentoNombre ;
   private String A244ClienteUser ;
   private String scmdbuf ;
   private String A55PersonaNombre ;
   private String A56PersonaApellido ;
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
   private String A57PersonaDireccion ;
   private String AV35Clientewwds_1_filterfulltext ;
   private String lV35Clientewwds_1_filterfulltext ;
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
   private long[] P00412_A1PersonaId ;
   private long[] P00412_A3LocalidadId ;
   private long[] P00412_A7CiudadId ;
   private long[] P00412_A6DepartamentoId ;
   private long[] P00412_A4ClienteId ;
   private String[] P00412_A244ClienteUser ;
   private String[] P00412_A61DepartamentoNombre ;
   private String[] P00412_A62CiudadNombre ;
   private String[] P00412_A64LocalidadNombre ;
   private String[] P00412_A66PersonaTelefono ;
   private String[] P00412_A57PersonaDireccion ;
   private String[] P00412_A56PersonaApellido ;
   private String[] P00412_A55PersonaNombre ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class clientewwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00412( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV35Clientewwds_1_filterfulltext ,
                                          long A4ClienteId ,
                                          String A55PersonaNombre ,
                                          String A56PersonaApellido ,
                                          String A57PersonaDireccion ,
                                          String A66PersonaTelefono ,
                                          String A64LocalidadNombre ,
                                          String A62CiudadNombre ,
                                          String A61DepartamentoNombre ,
                                          String A244ClienteUser ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PersonaId], T2.[LocalidadId], T3.[CiudadId], T4.[DepartamentoId], T1.[ClienteId], T1.[ClienteUser], T5.[DepartamentoNombre], T4.[CiudadNombre], T3.[LocalidadNombre]," ;
      scmdbuf += " T2.[PersonaTelefono], T2.[PersonaDireccion], T2.[PersonaApellido], T2.[PersonaNombre] FROM (((([Cliente] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = T1.[PersonaId])" ;
      scmdbuf += " INNER JOIN [Localidad] T3 ON T3.[LocalidadId] = T2.[LocalidadId]) INNER JOIN [Ciudad] T4 ON T4.[CiudadId] = T3.[CiudadId]) INNER JOIN [Departamento] T5 ON T5.[DepartamentoId]" ;
      scmdbuf += " = T4.[DepartamentoId])" ;
      if ( ! (GXutil.strcmp("", AV35Clientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( RTRIM(LTRIM(T2.[PersonaNombre])) + ' ' + RTRIM(LTRIM(T2.[PersonaApellido])) like '%' + ?) or ( T2.[PersonaDireccion] like '%' + ?) or ( T2.[PersonaTelefono] like '%' + ?) or ( T3.[LocalidadNombre] like '%' + ?) or ( T4.[CiudadNombre] like '%' + ?) or ( T5.[DepartamentoNombre] like '%' + ?) or ( T1.[ClienteUser] like '%' + ?))");
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
         scmdbuf += " ORDER BY T1.[ClienteId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClienteId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PersonaDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PersonaDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PersonaTelefono]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PersonaTelefono] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[LocalidadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[LocalidadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[CiudadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[CiudadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T5.[DepartamentoNombre]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T5.[DepartamentoNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClienteUser]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClienteUser] DESC" ;
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
                  return conditional_P00412(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00412", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((String[]) buf[7])[0] = rslt.getString(8, 80);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((String[]) buf[9])[0] = rslt.getString(10, 25);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
               ((String[]) buf[12])[0] = rslt.getString(13, 80);
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

