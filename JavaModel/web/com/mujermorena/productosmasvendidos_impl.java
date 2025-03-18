package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class productosmasvendidos_impl extends GXWebReport
{
   public productosmasvendidos_impl( com.genexus.internet.HttpContext context )
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
      gxfirstwebparm = httpContext.GetFirstPar( "FechaDesde") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV8FechaDesde = localUtil.parseDateParm( gxfirstwebparm) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV9FechaHasta = localUtil.parseDateParm( httpContext.GetPar( "FechaHasta")) ;
         }
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
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 9, 16834, 11909, 0, 1, 1, 0, 1, 1) )
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
         /* Using cursor P00742 */
         pr_default.execute(0, new Object[] {AV8FechaDesde, AV9FechaHasta});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A19VentasId = P00742_A19VentasId[0] ;
            A91VentasFecha = P00742_A91VentasFecha[0] ;
            /* Using cursor P00743 */
            pr_default.execute(1, new Object[] {Long.valueOf(A19VentasId)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A13ArticuloId = P00743_A13ArticuloId[0] ;
               A76ArticuloNombre = P00743_A76ArticuloNombre[0] ;
               A92VentasDetalleCantidad = P00743_A92VentasDetalleCantidad[0] ;
               A20VentasDetalleId = P00743_A20VentasDetalleId[0] ;
               A76ArticuloNombre = P00743_A76ArticuloNombre[0] ;
               AV10ArticuloId = A13ArticuloId ;
               AV15ArticuloNombre = A76ArticuloNombre ;
               AV11VentasDetalleCantidad = A92VentasDetalleCantidad ;
               /* Execute user subroutine: 'CARGACANTIDAD' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  pr_default.close(1);
                  pr_default.close(0);
                  getPrinter().GxEndPage() ;
                  /* Close printer file */
                  getPrinter().GxEndDocument() ;
                  endPrinter();
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               pr_default.readNext(1);
            }
            pr_default.close(1);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         h740( false, 100) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Informe Productos Vendidos", ""), 107, Gx_line+13, 274, Gx_line+27, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Fecha Desde", ""), 100, Gx_line+53, 179, Gx_line+67, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText(httpContext.getMessage( "FechaHasta", ""), 347, Gx_line+53, 419, Gx_line+67, 0+256, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(localUtil.format( AV8FechaDesde, "99/99/99"), 207, Gx_line+53, 256, Gx_line+68, 2+256, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( AV9FechaHasta, "99/99/99"), 447, Gx_line+53, 496, Gx_line+68, 2+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+100) ;
         h740( false, 28) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Cod Articulos", ""), 47, Gx_line+0, 125, Gx_line+14, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Descripcion", ""), 200, Gx_line+0, 293, Gx_line+14, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Cantidad", ""), 480, Gx_line+0, 533, Gx_line+14, 0+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+28) ;
         AV12SDTArticuloVentas.sort(httpContext.getMessage( "[CantidadVendida]", ""));
         AV23GXV1 = 1 ;
         while ( AV23GXV1 <= AV12SDTArticuloVentas.size() )
         {
            AV13SDTArticuloVentasItem = (com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem)((com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem)AV12SDTArticuloVentas.elementAt(-1+AV23GXV1));
            AV16ID = AV13SDTArticuloVentasItem.getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid() ;
            AV17Nombre = AV13SDTArticuloVentasItem.getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre() ;
            AV18Total = AV13SDTArticuloVentasItem.getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida() ;
            h740( false, 31) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV16ID), "ZZZZZZZZZ9")), 47, Gx_line+0, 111, Gx_line+15, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV17Nombre, "")), 200, Gx_line+0, 400, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18Total), "ZZZ9")), 520, Gx_line+0, 546, Gx_line+15, 2+256, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+31) ;
            AV23GXV1 = (int)(AV23GXV1+1) ;
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h740( true, 0) ;
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
      /* 'CARGACANTIDAD' Routine */
      returnInSub = false ;
      AV14Encontro = httpContext.getMessage( "N", "") ;
      AV24GXV2 = 1 ;
      while ( AV24GXV2 <= AV12SDTArticuloVentas.size() )
      {
         AV13SDTArticuloVentasItem = (com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem)((com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem)AV12SDTArticuloVentas.elementAt(-1+AV24GXV2));
         if ( AV13SDTArticuloVentasItem.getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid() == AV10ArticuloId )
         {
            AV13SDTArticuloVentasItem.setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida( (short)(AV13SDTArticuloVentasItem.getgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida()+AV11VentasDetalleCantidad) );
            AV14Encontro = httpContext.getMessage( "S", "") ;
         }
         AV24GXV2 = (int)(AV24GXV2+1) ;
      }
      if ( GXutil.strcmp(AV14Encontro, httpContext.getMessage( "N", "")) == 0 )
      {
         AV13SDTArticuloVentasItem = (com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem)new com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem(remoteHandle, context);
         AV13SDTArticuloVentasItem.setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articuloid( AV10ArticuloId );
         AV13SDTArticuloVentasItem.setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Articulonombre( AV15ArticuloNombre );
         AV13SDTArticuloVentasItem.setgxTv_SdtSDTArticuloVentas_SDTArticuloVentasItem_Cantidadvendida( (short)(AV11VentasDetalleCantidad) );
         AV12SDTArticuloVentas.add(AV13SDTArticuloVentasItem, 0);
      }
   }

   public void h740( boolean bFoot ,
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
      add_metrics1( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", true, false, 57, 15, 72, 163,  new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 19, 29, 34, 34, 55, 45, 15, 21, 21, 24, 36, 17, 21, 17, 17, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 21, 21, 36, 36, 36, 38, 60, 43, 45, 45, 45, 41, 38, 48, 45, 17, 34, 45, 38, 53, 45, 48, 41, 48, 45, 41, 38, 45, 41, 57, 41, 41, 38, 21, 17, 21, 36, 34, 21, 34, 38, 34, 38, 34, 21, 38, 38, 17, 17, 34, 17, 55, 38, 38, 38, 38, 24, 34, 21, 38, 33, 49, 34, 34, 31, 24, 17, 24, 36, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 21, 34, 34, 34, 34, 17, 34, 21, 46, 23, 34, 36, 21, 46, 34, 25, 34, 21, 21, 21, 36, 34, 21, 20, 21, 23, 34, 52, 52, 52, 38, 45, 45, 45, 45, 45, 45, 62, 45, 41, 41, 41, 41, 17, 17, 17, 17, 45, 45, 48, 48, 48, 48, 48, 36, 48, 45, 45, 45, 45, 41, 41, 38, 34, 34, 34, 34, 34, 34, 55, 34, 34, 34, 34, 34, 17, 17, 17, 17, 38, 38, 38, 38, 38, 38, 38, 34, 38, 38, 38, 38, 38, 34, 38, 34}) ;
   }

   public void add_metrics1( )
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
      AV8FechaDesde = GXutil.nullDate() ;
      AV9FechaHasta = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00742_A19VentasId = new long[1] ;
      P00742_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A91VentasFecha = GXutil.nullDate() ;
      P00743_A19VentasId = new long[1] ;
      P00743_A13ArticuloId = new long[1] ;
      P00743_A76ArticuloNombre = new String[] {""} ;
      P00743_A92VentasDetalleCantidad = new int[1] ;
      P00743_A20VentasDetalleId = new long[1] ;
      A76ArticuloNombre = "" ;
      AV15ArticuloNombre = "" ;
      AV12SDTArticuloVentas = new GXBaseCollection<com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem>(com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem.class, "SDTArticuloVentasItem", "Mujer_Morena", remoteHandle);
      AV13SDTArticuloVentasItem = new com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem(remoteHandle, context);
      AV17Nombre = "" ;
      AV14Encontro = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.productosmasvendidos__default(),
         new Object[] {
             new Object[] {
            P00742_A19VentasId, P00742_A91VentasFecha
            }
            , new Object[] {
            P00743_A19VentasId, P00743_A13ArticuloId, P00743_A76ArticuloNombre, P00743_A92VentasDetalleCantidad, P00743_A20VentasDetalleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV18Total ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int A92VentasDetalleCantidad ;
   private int AV11VentasDetalleCantidad ;
   private int Gx_OldLine ;
   private int AV23GXV1 ;
   private int AV24GXV2 ;
   private long A19VentasId ;
   private long A13ArticuloId ;
   private long A20VentasDetalleId ;
   private long AV10ArticuloId ;
   private long AV16ID ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String A76ArticuloNombre ;
   private String AV15ArticuloNombre ;
   private String AV17Nombre ;
   private String AV14Encontro ;
   private java.util.Date AV8FechaDesde ;
   private java.util.Date AV9FechaHasta ;
   private java.util.Date A91VentasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private long[] P00742_A19VentasId ;
   private java.util.Date[] P00742_A91VentasFecha ;
   private long[] P00743_A19VentasId ;
   private long[] P00743_A13ArticuloId ;
   private String[] P00743_A76ArticuloNombre ;
   private int[] P00743_A92VentasDetalleCantidad ;
   private long[] P00743_A20VentasDetalleId ;
   private GXBaseCollection<com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem> AV12SDTArticuloVentas ;
   private com.mujermorena.SdtSDTArticuloVentas_SDTArticuloVentasItem AV13SDTArticuloVentasItem ;
}

final  class productosmasvendidos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00742", "SELECT [VentasId], [VentasFecha] FROM [Ventas] WHERE ([VentasFecha] >= ?) AND ([VentasFecha] <= ?) ORDER BY [VentasFecha] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00743", "SELECT T1.[VentasId], T1.[ArticuloId], T2.[ArticuloNombre], T1.[VentasDetalleCantidad], T1.[VentasDetalleId] FROM ([VentasDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) WHERE T1.[VentasId] = ? ORDER BY T1.[VentasId], T1.[VentasDetalleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
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
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

