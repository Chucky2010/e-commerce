package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class generarfactura_impl extends GXWebReport
{
   public generarfactura_impl( com.genexus.internet.HttpContext context )
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
      gxfirstwebparm = httpContext.GetFirstPar( "VentasId") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         A19VentasId = GXutil.lval( gxfirstwebparm) ;
      }
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
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 256, 16834, 9936, 0, 1, 1, 0, 1, 1) )
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
         h4F0( false, 119) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Mujer Morena", ""), 244, Gx_line+22, 627, Gx_line+44, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+119) ;
         /* Using cursor P004F3 */
         pr_default.execute(0, new Object[] {Long.valueOf(A19VentasId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A4ClienteId = P004F3_A4ClienteId[0] ;
            A29TimbradoId = P004F3_A29TimbradoId[0] ;
            A125TimbradoNumero = P004F3_A125TimbradoNumero[0] ;
            A311VentasNroFactura = P004F3_A311VentasNroFactura[0] ;
            A91VentasFecha = P004F3_A91VentasFecha[0] ;
            A238VentasTotal10 = P004F3_A238VentasTotal10[0] ;
            A236VentasTotal5 = P004F3_A236VentasTotal5[0] ;
            A239VentasTotalExento = P004F3_A239VentasTotalExento[0] ;
            A125TimbradoNumero = P004F3_A125TimbradoNumero[0] ;
            A238VentasTotal10 = P004F3_A238VentasTotal10[0] ;
            A236VentasTotal5 = P004F3_A236VentasTotal5[0] ;
            A239VentasTotalExento = P004F3_A239VentasTotalExento[0] ;
            A240VentasTotal = A239VentasTotalExento.add(A236VentasTotal5).add(A238VentasTotal10) ;
            A235VentasTotalIva5 = GXutil.roundDecimal( A236VentasTotal5.divide(DecimalUtil.doubleToDec(21), 18, java.math.RoundingMode.DOWN), 0) ;
            A237VentasTotalIva10 = GXutil.roundDecimal( A238VentasTotal10.divide(DecimalUtil.doubleToDec(11), 18, java.math.RoundingMode.DOWN), 0) ;
            AV9ClienteId = A4ClienteId ;
            AV11TimbradoId = A29TimbradoId ;
            /* Execute user subroutine: 'DATOSCLIENTE' */
            S111 ();
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
               cleanup();
               if (true) return;
            }
            h4F0( false, 130) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Cliente", ""), 8, Gx_line+67, 136, Gx_line+89, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9")), 158, Gx_line+67, 228, Gx_line+82, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV8NombreCliente, "")), 250, Gx_line+67, 668, Gx_line+82, 0+256, 0, 0, 0) ;
            getPrinter().GxDrawText(localUtil.format( A91VentasFecha, "99/99/99"), 158, Gx_line+17, 207, Gx_line+32, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Fecha", ""), 8, Gx_line+17, 136, Gx_line+39, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Fecha", ""), 8, Gx_line+17, 136, Gx_line+39, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Timbrado", ""), 242, Gx_line+17, 342, Gx_line+39, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9")), 558, Gx_line+17, 653, Gx_line+32, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9")), 350, Gx_line+17, 414, Gx_line+32, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Nro Factura", ""), 425, Gx_line+17, 525, Gx_line+39, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+130) ;
            h4F0( false, 42) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Codigo", ""), 17, Gx_line+0, 134, Gx_line+22, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 150, Gx_line+0, 267, Gx_line+22, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Cantidad", ""), 289, Gx_line+0, 406, Gx_line+22, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "PrecioVenta", ""), 422, Gx_line+0, 539, Gx_line+22, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Total", ""), 567, Gx_line+0, 684, Gx_line+22, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+42) ;
            /* Using cursor P004F4 */
            pr_default.execute(1, new Object[] {Long.valueOf(A19VentasId)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A76ArticuloNombre = P004F4_A76ArticuloNombre[0] ;
               A13ArticuloId = P004F4_A13ArticuloId[0] ;
               A20VentasDetalleId = P004F4_A20VentasDetalleId[0] ;
               A78ArticuloPrecioVenta = P004F4_A78ArticuloPrecioVenta[0] ;
               A92VentasDetalleCantidad = P004F4_A92VentasDetalleCantidad[0] ;
               A76ArticuloNombre = P004F4_A76ArticuloNombre[0] ;
               A78ArticuloPrecioVenta = P004F4_A78ArticuloPrecioVenta[0] ;
               A252VentasDetalleSubTotal = DecimalUtil.doubleToDec(A92VentasDetalleCantidad).multiply(A78ArticuloPrecioVenta) ;
               h4F0( false, 34) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")), 17, Gx_line+0, 87, Gx_line+15, 0+256, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A76ArticuloNombre, "")), 150, Gx_line+0, 283, Gx_line+15, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 422, Gx_line+0, 554, Gx_line+15, 2+256, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A92VentasDetalleCantidad), "ZZZZ9")), 289, Gx_line+0, 321, Gx_line+15, 2+256, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A252VentasDetalleSubTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 567, Gx_line+0, 699, Gx_line+15, 2+256, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+34) ;
               pr_default.readNext(1);
            }
            pr_default.close(1);
            h4F0( false, 100) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Total 5", ""), 22, Gx_line+11, 139, Gx_line+33, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 144, Gx_line+18, 276, Gx_line+33, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Total10", ""), 22, Gx_line+44, 139, Gx_line+66, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 139, Gx_line+51, 271, Gx_line+66, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Ventas Total", ""), 22, Gx_line+78, 139, Gx_line+100, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 144, Gx_line+85, 276, Gx_line+100, 2+256, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+100) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h4F0( true, 0) ;
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
      /* 'DATOSCLIENTE' Routine */
      returnInSub = false ;
      /* Using cursor P004F5 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV9ClienteId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk4F4 = false ;
         A4ClienteId = P004F5_A4ClienteId[0] ;
         A1PersonaId = P004F5_A1PersonaId[0] ;
         A56PersonaApellido = P004F5_A56PersonaApellido[0] ;
         A55PersonaNombre = P004F5_A55PersonaNombre[0] ;
         A56PersonaApellido = P004F5_A56PersonaApellido[0] ;
         A55PersonaNombre = P004F5_A55PersonaNombre[0] ;
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         AV10PersonaId = A1PersonaId ;
         while ( (pr_default.getStatus(2) != 101) && ( P004F5_A4ClienteId[0] == A4ClienteId ) )
         {
            brk4F4 = false ;
            A1PersonaId = P004F5_A1PersonaId[0] ;
            A56PersonaApellido = P004F5_A56PersonaApellido[0] ;
            A55PersonaNombre = P004F5_A55PersonaNombre[0] ;
            A56PersonaApellido = P004F5_A56PersonaApellido[0] ;
            A55PersonaNombre = P004F5_A55PersonaNombre[0] ;
            if ( A1PersonaId == AV10PersonaId )
            {
               A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
               AV8NombreCliente = A59PersonaNombreCompleto ;
            }
            brk4F4 = true ;
            pr_default.readNext(2);
         }
         if ( ! brk4F4 )
         {
            brk4F4 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void h4F0( boolean bFoot ,
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
      scmdbuf = "" ;
      P004F3_A19VentasId = new long[1] ;
      P004F3_A4ClienteId = new long[1] ;
      P004F3_A29TimbradoId = new long[1] ;
      P004F3_A125TimbradoNumero = new long[1] ;
      P004F3_A311VentasNroFactura = new long[1] ;
      P004F3_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004F3_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004F3_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004F3_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A91VentasFecha = GXutil.nullDate() ;
      A238VentasTotal10 = DecimalUtil.ZERO ;
      A236VentasTotal5 = DecimalUtil.ZERO ;
      A239VentasTotalExento = DecimalUtil.ZERO ;
      A240VentasTotal = DecimalUtil.ZERO ;
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      AV8NombreCliente = "" ;
      P004F4_A19VentasId = new long[1] ;
      P004F4_A76ArticuloNombre = new String[] {""} ;
      P004F4_A13ArticuloId = new long[1] ;
      P004F4_A20VentasDetalleId = new long[1] ;
      P004F4_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004F4_A92VentasDetalleCantidad = new int[1] ;
      A76ArticuloNombre = "" ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A252VentasDetalleSubTotal = DecimalUtil.ZERO ;
      P004F5_A4ClienteId = new long[1] ;
      P004F5_A1PersonaId = new long[1] ;
      P004F5_A56PersonaApellido = new String[] {""} ;
      P004F5_A55PersonaNombre = new String[] {""} ;
      A56PersonaApellido = "" ;
      A55PersonaNombre = "" ;
      A59PersonaNombreCompleto = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.generarfactura__default(),
         new Object[] {
             new Object[] {
            P004F3_A19VentasId, P004F3_A4ClienteId, P004F3_A29TimbradoId, P004F3_A125TimbradoNumero, P004F3_A311VentasNroFactura, P004F3_A91VentasFecha, P004F3_A238VentasTotal10, P004F3_A236VentasTotal5, P004F3_A239VentasTotalExento
            }
            , new Object[] {
            P004F4_A19VentasId, P004F4_A76ArticuloNombre, P004F4_A13ArticuloId, P004F4_A20VentasDetalleId, P004F4_A78ArticuloPrecioVenta, P004F4_A92VentasDetalleCantidad
            }
            , new Object[] {
            P004F5_A4ClienteId, P004F5_A1PersonaId, P004F5_A56PersonaApellido, P004F5_A55PersonaNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int A92VentasDetalleCantidad ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A311VentasNroFactura ;
   private long AV9ClienteId ;
   private long AV11TimbradoId ;
   private long A13ArticuloId ;
   private long A20VentasDetalleId ;
   private long A1PersonaId ;
   private long AV10PersonaId ;
   private java.math.BigDecimal A238VentasTotal10 ;
   private java.math.BigDecimal A236VentasTotal5 ;
   private java.math.BigDecimal A239VentasTotalExento ;
   private java.math.BigDecimal A240VentasTotal ;
   private java.math.BigDecimal A235VentasTotalIva5 ;
   private java.math.BigDecimal A237VentasTotalIva10 ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A252VentasDetalleSubTotal ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String AV8NombreCliente ;
   private String A76ArticuloNombre ;
   private String A56PersonaApellido ;
   private String A55PersonaNombre ;
   private String A59PersonaNombreCompleto ;
   private java.util.Date A91VentasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean returnInSub ;
   private boolean brk4F4 ;
   private IDataStoreProvider pr_default ;
   private long[] P004F3_A19VentasId ;
   private long[] P004F3_A4ClienteId ;
   private long[] P004F3_A29TimbradoId ;
   private long[] P004F3_A125TimbradoNumero ;
   private long[] P004F3_A311VentasNroFactura ;
   private java.util.Date[] P004F3_A91VentasFecha ;
   private java.math.BigDecimal[] P004F3_A238VentasTotal10 ;
   private java.math.BigDecimal[] P004F3_A236VentasTotal5 ;
   private java.math.BigDecimal[] P004F3_A239VentasTotalExento ;
   private long[] P004F4_A19VentasId ;
   private String[] P004F4_A76ArticuloNombre ;
   private long[] P004F4_A13ArticuloId ;
   private long[] P004F4_A20VentasDetalleId ;
   private java.math.BigDecimal[] P004F4_A78ArticuloPrecioVenta ;
   private int[] P004F4_A92VentasDetalleCantidad ;
   private long[] P004F5_A4ClienteId ;
   private long[] P004F5_A1PersonaId ;
   private String[] P004F5_A56PersonaApellido ;
   private String[] P004F5_A55PersonaNombre ;
}

final  class generarfactura__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004F3", "SELECT T1.[VentasId], T1.[ClienteId], T1.[TimbradoId], T2.[TimbradoNumero], T1.[VentasNroFactura], T1.[VentasFecha], COALESCE( T3.[VentasTotal10], 0) AS VentasTotal10, COALESCE( T3.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T3.[VentasTotalExento], 0) AS VentasTotalExento FROM (([Ventas] T1 INNER JOIN [Timbrado] T2 ON T2.[TimbradoId] = T1.[TimbradoId]) LEFT JOIN (SELECT SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 0 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T4.[VentasId], SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 10 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T6.[ImpuestoPorcentaje] = 5 THEN T4.[VentasDetalleCantidad] * CAST(T5.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal5 FROM (([VentasDetalle] T4 INNER JOIN [Articulo] T5 ON T5.[ArticuloId] = T4.[ArticuloId]) INNER JOIN [Impuesto] T6 ON T6.[ImpuestoId] = T5.[ImpuestoId]) GROUP BY T4.[VentasId] ) T3 ON T3.[VentasId] = T1.[VentasId]) WHERE T1.[VentasId] = ? ORDER BY T1.[VentasId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P004F4", "SELECT T1.[VentasId], T2.[ArticuloNombre], T1.[ArticuloId], T1.[VentasDetalleId], T2.[ArticuloPrecioVenta], T1.[VentasDetalleCantidad] FROM ([VentasDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) WHERE T1.[VentasId] = ? ORDER BY T1.[VentasId], T1.[VentasDetalleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P004F5", "SELECT T1.[ClienteId], T1.[PersonaId], T2.[PersonaApellido], T2.[PersonaNombre] FROM ([Cliente] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = T1.[PersonaId]) WHERE T1.[ClienteId] = ? ORDER BY T1.[ClienteId], T1.[PersonaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
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
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

