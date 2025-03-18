package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class personawwexportreport_impl extends GXWebReport
{
   public personawwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "personaww_Execute", GXv_boolean2) ;
         personawwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV28Title = httpContext.getMessage( "Lista de Persona", "") ;
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
         h3Z0( true, 0) ;
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
         h3Z0( false, 20) ;
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
      h3Z0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h3Z0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Persona Id", ""), 30, Gx_line+10, 76, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Tipo Persona Id", ""), 80, Gx_line+10, 126, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 130, Gx_line+10, 176, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Apellido", ""), 180, Gx_line+10, 226, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre Completo", ""), 230, Gx_line+10, 276, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Direccion", ""), 280, Gx_line+10, 326, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 330, Gx_line+10, 376, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 380, Gx_line+10, 426, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 430, Gx_line+10, 476, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 480, Gx_line+10, 527, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Barrio", ""), 531, Gx_line+10, 579, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Telefono", ""), 583, Gx_line+10, 631, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Telefono1", ""), 635, Gx_line+10, 683, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Telefono2", ""), 687, Gx_line+10, 735, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Correo", ""), 739, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Personawwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV35Personawwds_1_filterfulltext ,
                                           Long.valueOf(A1PersonaId) ,
                                           Long.valueOf(A2TipoPersonaId) ,
                                           A55PersonaNombre ,
                                           A56PersonaApellido ,
                                           A57PersonaDireccion ,
                                           Long.valueOf(A3LocalidadId) ,
                                           A64LocalidadNombre ,
                                           A62CiudadNombre ,
                                           A61DepartamentoNombre ,
                                           A65PersonaBarrio ,
                                           A66PersonaTelefono ,
                                           A67PersonaTelefono1 ,
                                           A68PersonaTelefono2 ,
                                           A69PersonaCorreo ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      lV35Personawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Personawwds_1_filterfulltext), "%", "") ;
      /* Using cursor P003Z2 */
      pr_default.execute(0, new Object[] {lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext, lV35Personawwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A7CiudadId = P003Z2_A7CiudadId[0] ;
         A6DepartamentoId = P003Z2_A6DepartamentoId[0] ;
         A3LocalidadId = P003Z2_A3LocalidadId[0] ;
         A2TipoPersonaId = P003Z2_A2TipoPersonaId[0] ;
         A1PersonaId = P003Z2_A1PersonaId[0] ;
         A69PersonaCorreo = P003Z2_A69PersonaCorreo[0] ;
         A68PersonaTelefono2 = P003Z2_A68PersonaTelefono2[0] ;
         A67PersonaTelefono1 = P003Z2_A67PersonaTelefono1[0] ;
         A66PersonaTelefono = P003Z2_A66PersonaTelefono[0] ;
         A65PersonaBarrio = P003Z2_A65PersonaBarrio[0] ;
         A61DepartamentoNombre = P003Z2_A61DepartamentoNombre[0] ;
         A62CiudadNombre = P003Z2_A62CiudadNombre[0] ;
         A64LocalidadNombre = P003Z2_A64LocalidadNombre[0] ;
         A57PersonaDireccion = P003Z2_A57PersonaDireccion[0] ;
         A56PersonaApellido = P003Z2_A56PersonaApellido[0] ;
         A55PersonaNombre = P003Z2_A55PersonaNombre[0] ;
         A7CiudadId = P003Z2_A7CiudadId[0] ;
         A64LocalidadNombre = P003Z2_A64LocalidadNombre[0] ;
         A6DepartamentoId = P003Z2_A6DepartamentoId[0] ;
         A62CiudadNombre = P003Z2_A62CiudadNombre[0] ;
         A61DepartamentoNombre = P003Z2_A61DepartamentoNombre[0] ;
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
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
         h3Z0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1PersonaId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 76, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2TipoPersonaId), "ZZZZZZZZZZ9")), 80, Gx_line+10, 126, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A55PersonaNombre, "")), 130, Gx_line+10, 176, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A56PersonaApellido, "")), 180, Gx_line+10, 226, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A59PersonaNombreCompleto, "")), 230, Gx_line+10, 276, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A57PersonaDireccion, "")), 280, Gx_line+10, 326, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3LocalidadId), "ZZZZZZZZZZ9")), 330, Gx_line+10, 376, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A64LocalidadNombre, "")), 380, Gx_line+10, 426, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A62CiudadNombre, "")), 430, Gx_line+10, 476, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A61DepartamentoNombre, "")), 480, Gx_line+10, 527, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A65PersonaBarrio, "")), 531, Gx_line+10, 579, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A66PersonaTelefono, "")), 583, Gx_line+10, 631, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A67PersonaTelefono1, "")), 635, Gx_line+10, 683, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A68PersonaTelefono2, "")), 687, Gx_line+10, 735, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A69PersonaCorreo, "")), 739, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
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
      if ( GXutil.strcmp(AV14Session.getValue("PersonaWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PersonaWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("PersonaWWGridState"), null, null);
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

   public void h3Z0( boolean bFoot ,
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
      A55PersonaNombre = "" ;
      A56PersonaApellido = "" ;
      A59PersonaNombreCompleto = "" ;
      A57PersonaDireccion = "" ;
      A64LocalidadNombre = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A65PersonaBarrio = "" ;
      A66PersonaTelefono = "" ;
      A67PersonaTelefono1 = "" ;
      A68PersonaTelefono2 = "" ;
      A69PersonaCorreo = "" ;
      AV35Personawwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV35Personawwds_1_filterfulltext = "" ;
      P003Z2_A7CiudadId = new long[1] ;
      P003Z2_A6DepartamentoId = new long[1] ;
      P003Z2_A3LocalidadId = new long[1] ;
      P003Z2_A2TipoPersonaId = new long[1] ;
      P003Z2_A1PersonaId = new long[1] ;
      P003Z2_A69PersonaCorreo = new String[] {""} ;
      P003Z2_A68PersonaTelefono2 = new String[] {""} ;
      P003Z2_A67PersonaTelefono1 = new String[] {""} ;
      P003Z2_A66PersonaTelefono = new String[] {""} ;
      P003Z2_A65PersonaBarrio = new String[] {""} ;
      P003Z2_A61DepartamentoNombre = new String[] {""} ;
      P003Z2_A62CiudadNombre = new String[] {""} ;
      P003Z2_A64LocalidadNombre = new String[] {""} ;
      P003Z2_A57PersonaDireccion = new String[] {""} ;
      P003Z2_A56PersonaApellido = new String[] {""} ;
      P003Z2_A55PersonaNombre = new String[] {""} ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.personawwexportreport__default(),
         new Object[] {
             new Object[] {
            P003Z2_A7CiudadId, P003Z2_A6DepartamentoId, P003Z2_A3LocalidadId, P003Z2_A2TipoPersonaId, P003Z2_A1PersonaId, P003Z2_A69PersonaCorreo, P003Z2_A68PersonaTelefono2, P003Z2_A67PersonaTelefono1, P003Z2_A66PersonaTelefono, P003Z2_A65PersonaBarrio,
            P003Z2_A61DepartamentoNombre, P003Z2_A62CiudadNombre, P003Z2_A64LocalidadNombre, P003Z2_A57PersonaDireccion, P003Z2_A56PersonaApellido, P003Z2_A55PersonaNombre
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
   private long A1PersonaId ;
   private long A2TipoPersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String A55PersonaNombre ;
   private String A56PersonaApellido ;
   private String A59PersonaNombreCompleto ;
   private String A64LocalidadNombre ;
   private String A62CiudadNombre ;
   private String A61DepartamentoNombre ;
   private String A65PersonaBarrio ;
   private String A66PersonaTelefono ;
   private String A67PersonaTelefono1 ;
   private String A68PersonaTelefono2 ;
   private String scmdbuf ;
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
   private String A69PersonaCorreo ;
   private String AV35Personawwds_1_filterfulltext ;
   private String lV35Personawwds_1_filterfulltext ;
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
   private long[] P003Z2_A7CiudadId ;
   private long[] P003Z2_A6DepartamentoId ;
   private long[] P003Z2_A3LocalidadId ;
   private long[] P003Z2_A2TipoPersonaId ;
   private long[] P003Z2_A1PersonaId ;
   private String[] P003Z2_A69PersonaCorreo ;
   private String[] P003Z2_A68PersonaTelefono2 ;
   private String[] P003Z2_A67PersonaTelefono1 ;
   private String[] P003Z2_A66PersonaTelefono ;
   private String[] P003Z2_A65PersonaBarrio ;
   private String[] P003Z2_A61DepartamentoNombre ;
   private String[] P003Z2_A62CiudadNombre ;
   private String[] P003Z2_A64LocalidadNombre ;
   private String[] P003Z2_A57PersonaDireccion ;
   private String[] P003Z2_A56PersonaApellido ;
   private String[] P003Z2_A55PersonaNombre ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class personawwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003Z2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV35Personawwds_1_filterfulltext ,
                                          long A1PersonaId ,
                                          long A2TipoPersonaId ,
                                          String A55PersonaNombre ,
                                          String A56PersonaApellido ,
                                          String A57PersonaDireccion ,
                                          long A3LocalidadId ,
                                          String A64LocalidadNombre ,
                                          String A62CiudadNombre ,
                                          String A61DepartamentoNombre ,
                                          String A65PersonaBarrio ,
                                          String A66PersonaTelefono ,
                                          String A67PersonaTelefono1 ,
                                          String A68PersonaTelefono2 ,
                                          String A69PersonaCorreo ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[15];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[CiudadId], T3.[DepartamentoId], T1.[LocalidadId], T1.[TipoPersonaId], T1.[PersonaId], T1.[PersonaCorreo], T1.[PersonaTelefono2], T1.[PersonaTelefono1]," ;
      scmdbuf += " T1.[PersonaTelefono], T1.[PersonaBarrio], T4.[DepartamentoNombre], T3.[CiudadNombre], T2.[LocalidadNombre], T1.[PersonaDireccion], T1.[PersonaApellido], T1.[PersonaNombre]" ;
      scmdbuf += " FROM ((([Persona] T1 INNER JOIN [Localidad] T2 ON T2.[LocalidadId] = T1.[LocalidadId]) INNER JOIN [Ciudad] T3 ON T3.[CiudadId] = T2.[CiudadId]) INNER JOIN [Departamento]" ;
      scmdbuf += " T4 ON T4.[DepartamentoId] = T3.[DepartamentoId])" ;
      if ( ! (GXutil.strcmp("", AV35Personawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[PersonaId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoPersonaId] AS decimal(11,0))) like '%' + ?) or ( T1.[PersonaNombre] like '%' + ?) or ( T1.[PersonaApellido] like '%' + ?) or ( RTRIM(LTRIM(T1.[PersonaNombre])) + ' ' + RTRIM(LTRIM(T1.[PersonaApellido])) like '%' + ?) or ( T1.[PersonaDireccion] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[LocalidadId] AS decimal(11,0))) like '%' + ?) or ( T2.[LocalidadNombre] like '%' + ?) or ( T3.[CiudadNombre] like '%' + ?) or ( T4.[DepartamentoNombre] like '%' + ?) or ( T1.[PersonaBarrio] like '%' + ?) or ( T1.[PersonaTelefono] like '%' + ?) or ( T1.[PersonaTelefono1] like '%' + ?) or ( T1.[PersonaTelefono2] like '%' + ?) or ( T1.[PersonaCorreo] like '%' + ?))");
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
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TipoPersonaId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TipoPersonaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaNombre]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaApellido]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaApellido] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaDireccion]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaDireccion] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LocalidadId]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LocalidadId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[LocalidadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[LocalidadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[CiudadNombre]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[CiudadNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[DepartamentoNombre]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[DepartamentoNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaBarrio]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaBarrio] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaTelefono]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaTelefono] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaTelefono1]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaTelefono1] DESC" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaTelefono2]" ;
      }
      else if ( ( AV11OrderedBy == 13 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaTelefono2] DESC" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 14 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaCorreo] DESC" ;
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
                  return conditional_P003Z2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).longValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).longValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003Z2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 25);
               ((String[]) buf[7])[0] = rslt.getString(8, 25);
               ((String[]) buf[8])[0] = rslt.getString(9, 25);
               ((String[]) buf[9])[0] = rslt.getString(10, 120);
               ((String[]) buf[10])[0] = rslt.getString(11, 80);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
               ((String[]) buf[12])[0] = rslt.getString(13, 80);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 80);
               ((String[]) buf[15])[0] = rslt.getString(16, 80);
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
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               return;
      }
   }

}

