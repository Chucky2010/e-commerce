package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class usuariowwexportreport_impl extends GXWebReport
{
   public usuariowwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "usuarioww_Execute", GXv_boolean2) ;
         usuariowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV29Title = httpContext.getMessage( "Lista de Usuario", "") ;
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
         h6Q0( true, 0) ;
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
         h6Q0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "WWP_FullTextFilterDescription", ""), 25, Gx_line+0, 102, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 102, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h6Q0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h6Q0( false, 35) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 30, Gx_line+10, 103, Gx_line+25, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nom", ""), 107, Gx_line+10, 253, Gx_line+25, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Persona Id", ""), 257, Gx_line+10, 331, Gx_line+25, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Correo", ""), 335, Gx_line+10, 483, Gx_line+25, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Device Id", ""), 487, Gx_line+10, 635, Gx_line+25, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Type", ""), 639, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+35) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV36Usuariowwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV36Usuariowwds_1_filterfulltext ,
                                           Long.valueOf(A14UsuarioId) ,
                                           A271UsuarioNom ,
                                           Long.valueOf(A1PersonaId) ,
                                           A69PersonaCorreo ,
                                           A16DeviceId ,
                                           Byte.valueOf(A15DeviceType) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      /* Using cursor P006Q2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1PersonaId = P006Q2_A1PersonaId[0] ;
         A14UsuarioId = P006Q2_A14UsuarioId[0] ;
         A15DeviceType = P006Q2_A15DeviceType[0] ;
         A16DeviceId = P006Q2_A16DeviceId[0] ;
         A69PersonaCorreo = P006Q2_A69PersonaCorreo[0] ;
         A271UsuarioNom = P006Q2_A271UsuarioNom[0] ;
         A69PersonaCorreo = P006Q2_A69PersonaCorreo[0] ;
         if ( (GXutil.strcmp("", AV36Usuariowwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A14UsuarioId, 11, 0) , GXutil.padr( "%" + AV36Usuariowwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A271UsuarioNom , GXutil.padr( "%" + AV36Usuariowwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A1PersonaId, 11, 0) , GXutil.padr( "%" + AV36Usuariowwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A69PersonaCorreo , GXutil.padr( "%" + AV36Usuariowwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( A16DeviceId , GXutil.padr( "%" + AV36Usuariowwds_1_filterfulltext , 128 , "%"),  ' ' ) ) || ( GXutil.like( httpContext.getMessage( httpContext.getMessage( "ios", ""), "") , GXutil.padr( "%" + GXutil.lower( AV36Usuariowwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( A15DeviceType == 0 ) ) || ( GXutil.like( httpContext.getMessage( httpContext.getMessage( "android", ""), "") , GXutil.padr( "%" + GXutil.lower( AV36Usuariowwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( A15DeviceType == 1 ) ) || ( GXutil.like( httpContext.getMessage( httpContext.getMessage( "blackberry", ""), "") , GXutil.padr( "%" + GXutil.lower( AV36Usuariowwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( A15DeviceType == 2 ) ) || ( GXutil.like( httpContext.getMessage( httpContext.getMessage( "windows", ""), "") , GXutil.padr( "%" + GXutil.lower( AV36Usuariowwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( A15DeviceType == 3 ) ) ) )
         {
            AV14DeviceTypeDescription = httpContext.getMessage( com.genexuscore.genexus.gxdomainsmartdevicetype.getDescription(httpContext,(byte)A15DeviceType), "") ;
            /* Execute user subroutine: 'BEFOREPRINTLINE' */
            S144 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               pr_default.close(0);
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               if (true) return;
            }
            h6Q0( false, 36) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A14UsuarioId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 103, Gx_line+25, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A271UsuarioNom, "")), 107, Gx_line+10, 253, Gx_line+25, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1PersonaId), "ZZZZZZZZZZ9")), 257, Gx_line+10, 331, Gx_line+25, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A69PersonaCorreo, "")), 335, Gx_line+10, 483, Gx_line+25, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A16DeviceId, "")), 487, Gx_line+10, 635, Gx_line+25, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV14DeviceTypeDescription, "")), 639, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+36) ;
            /* Execute user subroutine: 'AFTERPRINTLINE' */
            S161 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               pr_default.close(0);
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               if (true) return;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV15Session.getValue("UsuarioWWGridState"), "") == 0 )
      {
         AV17GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "UsuarioWWGridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV15Session.getValue("UsuarioWWGridState"), null, null);
      }
      AV11OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV37GXV1));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV37GXV1 = (int)(AV37GXV1+1) ;
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

   public void h6Q0( boolean bFoot ,
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
               AV27PageInfo = httpContext.getMessage( "Page: ", "") + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV24DateInfo = httpContext.getMessage( "Date: ", "") + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 128, 128, 0, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
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
            AV22AppName = httpContext.getMessage( "DVelop Software Solutions", "") ;
            AV28Phone = "+1 550 8923" ;
            AV26Mail = "info@mail.com" ;
            AV30Website = "http://www.web.com" ;
            AV19AddressLine1 = "French Boulevard 2859" ;
            AV20AddressLine2 = "Downtown" ;
            AV21AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 128, 128, 0, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
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
      AV29Title = "" ;
      AV13FilterFullText = "" ;
      A271UsuarioNom = "" ;
      A69PersonaCorreo = "" ;
      A16DeviceId = "" ;
      AV36Usuariowwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      P006Q2_A1PersonaId = new long[1] ;
      P006Q2_A14UsuarioId = new long[1] ;
      P006Q2_A15DeviceType = new byte[1] ;
      P006Q2_A16DeviceId = new String[] {""} ;
      P006Q2_A69PersonaCorreo = new String[] {""} ;
      P006Q2_A271UsuarioNom = new String[] {""} ;
      AV14DeviceTypeDescription = "" ;
      AV15Session = httpContext.getWebSession();
      AV17GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV27PageInfo = "" ;
      AV24DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV22AppName = "" ;
      AV28Phone = "" ;
      AV26Mail = "" ;
      AV30Website = "" ;
      AV19AddressLine1 = "" ;
      AV20AddressLine2 = "" ;
      AV21AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.usuariowwexportreport__default(),
         new Object[] {
             new Object[] {
            P006Q2_A1PersonaId, P006Q2_A14UsuarioId, P006Q2_A15DeviceType, P006Q2_A16DeviceId, P006Q2_A69PersonaCorreo, P006Q2_A271UsuarioNom
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private byte A15DeviceType ;
   private short gxcookieaux ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV37GXV1 ;
   private long A14UsuarioId ;
   private long A1PersonaId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String A271UsuarioNom ;
   private String A16DeviceId ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV29Title ;
   private String AV13FilterFullText ;
   private String A69PersonaCorreo ;
   private String AV36Usuariowwds_1_filterfulltext ;
   private String AV14DeviceTypeDescription ;
   private String AV27PageInfo ;
   private String AV24DateInfo ;
   private String AV22AppName ;
   private String AV28Phone ;
   private String AV26Mail ;
   private String AV30Website ;
   private String AV19AddressLine1 ;
   private String AV20AddressLine2 ;
   private String AV21AddressLine3 ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private IDataStoreProvider pr_default ;
   private long[] P006Q2_A1PersonaId ;
   private long[] P006Q2_A14UsuarioId ;
   private byte[] P006Q2_A15DeviceType ;
   private String[] P006Q2_A16DeviceId ;
   private String[] P006Q2_A69PersonaCorreo ;
   private String[] P006Q2_A271UsuarioNom ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
}

final  class usuariowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006Q2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV36Usuariowwds_1_filterfulltext ,
                                          long A14UsuarioId ,
                                          String A271UsuarioNom ,
                                          long A1PersonaId ,
                                          String A69PersonaCorreo ,
                                          String A16DeviceId ,
                                          byte A15DeviceType )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT T1.[PersonaId], T1.[UsuarioId], T1.[DeviceType], T1.[DeviceId], T2.[PersonaCorreo], T1.[UsuarioNom] FROM ([Usuario] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId]" ;
      scmdbuf += " = T1.[PersonaId])" ;
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UsuarioId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UsuarioId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UsuarioNom]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UsuarioNom] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PersonaId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PersonaId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PersonaCorreo]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PersonaCorreo] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DeviceId]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DeviceId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DeviceType]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DeviceType] DESC" ;
      }
      GXv_Object4[0] = scmdbuf ;
      return GXv_Object4 ;
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
                  return conditional_P006Q2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).longValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006Q2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 128);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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
      }
   }

}

