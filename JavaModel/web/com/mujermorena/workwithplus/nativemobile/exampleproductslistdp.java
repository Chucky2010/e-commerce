package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class exampleproductslistdp extends GXProcedure
{
   public exampleproductslistdp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( exampleproductslistdp.class ), "" );
   }

   public exampleproductslistdp( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> executeUdp( )
   {
      exampleproductslistdp.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>[] aP0 )
   {
      exampleproductslistdp.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00062 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A40000ArticuloImagen_GXI = P00062_A40000ArticuloImagen_GXI[0] ;
         A13ArticuloId = P00062_A13ArticuloId[0] ;
         A76ArticuloNombre = P00062_A76ArticuloNombre[0] ;
         A231ArticuloImagen = P00062_A231ArticuloImagen[0] ;
         A214ArticuloDescripcionCorta = P00062_A214ArticuloDescripcionCorta[0] ;
         A215ArticuloDescripcionLarga = P00062_A215ArticuloDescripcionLarga[0] ;
         A78ArticuloPrecioVenta = P00062_A78ArticuloPrecioVenta[0] ;
         Gxm1wwpproductdata = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
         Gxm2rootcol.add(Gxm1wwpproductdata, 0);
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Id( GXutil.str( A13ArticuloId, 11, 0) );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Title( A76ArticuloNombre );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Image( A231ArticuloImagen );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Image_gxi( A40000ArticuloImagen_GXI );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Subtitle( A214ArticuloDescripcionCorta );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Description( A215ArticuloDescripcionLarga );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Information1( "Gs. "+GXutil.str( A78ArticuloPrecioVenta, 17, 2) );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Information2( "Gs. " );
         Gxm1wwpproductdata.setgxTv_SdtWWPProductData_Componenttocall( "sd:MyProductsProductDetail?cookies" );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = exampleproductslistdp.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      scmdbuf = "" ;
      P00062_A40000ArticuloImagen_GXI = new String[] {""} ;
      P00062_A13ArticuloId = new long[1] ;
      P00062_A76ArticuloNombre = new String[] {""} ;
      P00062_A231ArticuloImagen = new String[] {""} ;
      P00062_A214ArticuloDescripcionCorta = new String[] {""} ;
      P00062_A215ArticuloDescripcionLarga = new String[] {""} ;
      P00062_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A40000ArticuloImagen_GXI = "" ;
      A76ArticuloNombre = "" ;
      A231ArticuloImagen = "" ;
      A214ArticuloDescripcionCorta = "" ;
      A215ArticuloDescripcionLarga = "" ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      Gxm1wwpproductdata = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.workwithplus.nativemobile.exampleproductslistdp__default(),
         new Object[] {
             new Object[] {
            P00062_A40000ArticuloImagen_GXI, P00062_A13ArticuloId, P00062_A76ArticuloNombre, P00062_A231ArticuloImagen, P00062_A214ArticuloDescripcionCorta, P00062_A215ArticuloDescripcionLarga, P00062_A78ArticuloPrecioVenta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A13ArticuloId ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private String scmdbuf ;
   private String A76ArticuloNombre ;
   private String A215ArticuloDescripcionLarga ;
   private String A40000ArticuloImagen_GXI ;
   private String A214ArticuloDescripcionCorta ;
   private String A231ArticuloImagen ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00062_A40000ArticuloImagen_GXI ;
   private long[] P00062_A13ArticuloId ;
   private String[] P00062_A76ArticuloNombre ;
   private String[] P00062_A231ArticuloImagen ;
   private String[] P00062_A214ArticuloDescripcionCorta ;
   private String[] P00062_A215ArticuloDescripcionLarga ;
   private java.math.BigDecimal[] P00062_A78ArticuloPrecioVenta ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> Gxm2rootcol ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData Gxm1wwpproductdata ;
}

final  class exampleproductslistdp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00062", "SELECT [ArticuloImagen_GXI], [ArticuloId], [ArticuloNombre], [ArticuloImagen], [ArticuloDescripcionCorta], [ArticuloDescripcionLarga], [ArticuloPrecioVenta] FROM [Articulo] ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getMultimediaUri(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(1));
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

