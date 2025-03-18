package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class addcomprobantes extends GXProcedure
{
   public addcomprobantes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( addcomprobantes.class ), "" );
   }

   public addcomprobantes( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      addcomprobantes.this.AV16PedidosID = aP0;
      addcomprobantes.this.AV17PedidosImagenComprobante = aP1;
      addcomprobantes.this.AV18PedidosComprobanteObs = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P007L2 */
      pr_default.execute(0, new Object[] {AV18PedidosComprobanteObs, AV22Pedidosimagencomprobante_GXI, AV17PedidosImagenComprobante, Long.valueOf(AV16PedidosID)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "addcomprobantes");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22Pedidosimagencomprobante_GXI = "" ;
      A295PedidosComprobanteObs = "" ;
      A40000PedidosImagenComprobante_GXI = "" ;
      A296PedidosImagenComprobante = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.addcomprobantes__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV16PedidosID ;
   private String AV18PedidosComprobanteObs ;
   private String AV22Pedidosimagencomprobante_GXI ;
   private String A295PedidosComprobanteObs ;
   private String A40000PedidosImagenComprobante_GXI ;
   private String AV17PedidosImagenComprobante ;
   private String A296PedidosImagenComprobante ;
   private IDataStoreProvider pr_default ;
}

final  class addcomprobantes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P007L2", "UPDATE [Pedidos] SET [PedidosComprobanteObs]=?, [PedidosImagenComprobante_GXI]=?, [PedidosImagenComprobante]=?  WHERE [PedidosID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 512, false);
               stmt.setVarchar(2, (String)parms[1], 2048, false);
               stmt.setBLOBFile(3, (String)parms[2], true);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
      }
   }

}

