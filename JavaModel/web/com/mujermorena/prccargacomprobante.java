package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccargacomprobante extends GXProcedure
{
   public prccargacomprobante( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccargacomprobante.class ), "" );
   }

   public prccargacomprobante( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( long[] aP0 ,
                             String[] aP1 )
   {
      prccargacomprobante.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( long[] aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long[] aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      prccargacomprobante.this.AV8PedidosID = aP0[0];
      this.aP0 = aP0;
      prccargacomprobante.this.AV10PedidosComprobante = aP1[0];
      this.aP1 = aP1;
      prccargacomprobante.this.AV9PedidosComprobanteObs = aP2[0];
      this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P00702 */
      pr_default.execute(0, new Object[] {AV9PedidosComprobanteObs, AV14Pedidoscomprobante_GXI, AV10PedidosComprobante, Long.valueOf(AV8PedidosID)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prccargacomprobante.this.AV8PedidosID;
      this.aP1[0] = prccargacomprobante.this.AV10PedidosComprobante;
      this.aP2[0] = prccargacomprobante.this.AV9PedidosComprobanteObs;
      Application.commitDataStores(context, remoteHandle, pr_default, "prccargacomprobante");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pedidoscomprobante_GXI = "" ;
      A295PedidosComprobanteObs = "" ;
      A40000PedidosImagenComprobante_GXI = "" ;
      A296PedidosImagenComprobante = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.prccargacomprobante__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV8PedidosID ;
   private String AV9PedidosComprobanteObs ;
   private String AV14Pedidoscomprobante_GXI ;
   private String A295PedidosComprobanteObs ;
   private String A40000PedidosImagenComprobante_GXI ;
   private String AV10PedidosComprobante ;
   private String A296PedidosImagenComprobante ;
   private String[] aP2 ;
   private long[] aP0 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
}

final  class prccargacomprobante__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00702", "UPDATE [Pedidos] SET [PedidosComprobanteObs]=?, [PedidosImagenComprobante_GXI]=?, [PedidosImagenComprobante]=?  WHERE [PedidosID] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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

