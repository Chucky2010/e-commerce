package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getproductssampledata extends GXProcedure
{
   public getproductssampledata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getproductssampledata.class ), "" );
   }

   public getproductssampledata( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> executeUdp( )
   {
      getproductssampledata.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 )
   {
      getproductssampledata.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00072 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13ArticuloId = P00072_A13ArticuloId[0] ;
         A76ArticuloNombre = P00072_A76ArticuloNombre[0] ;
         A214ArticuloDescripcionCorta = P00072_A214ArticuloDescripcionCorta[0] ;
         A78ArticuloPrecioVenta = P00072_A78ArticuloPrecioVenta[0] ;
         Gxm1dvelop_ecommercecart = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
         Gxm2rootcol.add(Gxm1dvelop_ecommercecart, 0);
         Gxm1dvelop_ecommercecart.setgxTv_SdtDVelop_ECommerceCart_Item_Productid( (int)(A13ArticuloId) );
         Gxm1dvelop_ecommercecart.setgxTv_SdtDVelop_ECommerceCart_Item_Productname( A76ArticuloNombre );
         Gxm1dvelop_ecommercecart.setgxTv_SdtDVelop_ECommerceCart_Item_Productdescription( A214ArticuloDescripcionCorta );
         Gxm1dvelop_ecommercecart.setgxTv_SdtDVelop_ECommerceCart_Item_Productprice( A78ArticuloPrecioVenta );
         Gxm1dvelop_ecommercecart.setgxTv_SdtDVelop_ECommerceCart_Item_Productsim( "Gs." );
         Gxm1dvelop_ecommercecart.setgxTv_SdtDVelop_ECommerceCart_Item_Productqty( (short)(1) );
         /* Using cursor P00073 */
         pr_default.execute(1, new Object[] {Long.valueOf(A13ArticuloId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A230ArticuloGaleriaImagen = P00073_A230ArticuloGaleriaImagen[0] ;
            A40001ArticuloGaleriaImagen_GXI = P00073_A40001ArticuloGaleriaImagen_GXI[0] ;
            A48ArticuloGaleriaId = P00073_A48ArticuloGaleriaId[0] ;
            Gxm1dvelop_ecommercecart.getgxTv_SdtDVelop_ECommerceCart_Item_Images().add(A230ArticuloGaleriaImagen, 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getproductssampledata.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      scmdbuf = "" ;
      P00072_A13ArticuloId = new long[1] ;
      P00072_A76ArticuloNombre = new String[] {""} ;
      P00072_A214ArticuloDescripcionCorta = new String[] {""} ;
      P00072_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A76ArticuloNombre = "" ;
      A214ArticuloDescripcionCorta = "" ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      Gxm1dvelop_ecommercecart = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      P00073_A13ArticuloId = new long[1] ;
      P00073_A230ArticuloGaleriaImagen = new String[] {""} ;
      P00073_A40001ArticuloGaleriaImagen_GXI = new String[] {""} ;
      P00073_A48ArticuloGaleriaId = new long[1] ;
      A230ArticuloGaleriaImagen = "" ;
      A40001ArticuloGaleriaImagen_GXI = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.getproductssampledata__default(),
         new Object[] {
             new Object[] {
            P00072_A13ArticuloId, P00072_A76ArticuloNombre, P00072_A214ArticuloDescripcionCorta, P00072_A78ArticuloPrecioVenta
            }
            , new Object[] {
            P00073_A13ArticuloId, P00073_A230ArticuloGaleriaImagen, P00073_A40001ArticuloGaleriaImagen_GXI, P00073_A48ArticuloGaleriaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A13ArticuloId ;
   private long A48ArticuloGaleriaId ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private String scmdbuf ;
   private String A76ArticuloNombre ;
   private String A214ArticuloDescripcionCorta ;
   private String A40001ArticuloGaleriaImagen_GXI ;
   private String A230ArticuloGaleriaImagen ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P00072_A13ArticuloId ;
   private String[] P00072_A76ArticuloNombre ;
   private String[] P00072_A214ArticuloDescripcionCorta ;
   private java.math.BigDecimal[] P00072_A78ArticuloPrecioVenta ;
   private long[] P00073_A13ArticuloId ;
   private String[] P00073_A230ArticuloGaleriaImagen ;
   private String[] P00073_A40001ArticuloGaleriaImagen_GXI ;
   private long[] P00073_A48ArticuloGaleriaId ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> Gxm2rootcol ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item Gxm1dvelop_ecommercecart ;
}

final  class getproductssampledata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00072", "SELECT [ArticuloId], [ArticuloNombre], [ArticuloDescripcionCorta], [ArticuloPrecioVenta] FROM [Articulo] ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00073", "SELECT [ArticuloId], [ArticuloGaleriaImagen], [ArticuloGaleriaImagen_GXI], [ArticuloGaleriaId] FROM [ArticuloGaleria] WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

