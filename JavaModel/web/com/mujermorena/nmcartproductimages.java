package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartproductimages extends GXProcedure
{
   public nmcartproductimages( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartproductimages.class ), "" );
   }

   public nmcartproductimages( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> executeUdp( String aP0 )
   {
      nmcartproductimages.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>[] aP1 )
   {
      nmcartproductimages.this.AV11ProductId = aP0;
      nmcartproductimages.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006G2 */
      pr_default.execute(0, new Object[] {AV11ProductId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13ArticuloId = P006G2_A13ArticuloId[0] ;
         A40000ArticuloGaleriaImagen_GXI = P006G2_A40000ArticuloGaleriaImagen_GXI[0] ;
         A230ArticuloGaleriaImagen = P006G2_A230ArticuloGaleriaImagen[0] ;
         A48ArticuloGaleriaId = P006G2_A48ArticuloGaleriaId[0] ;
         AV9ProductDataImage = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)new com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages(remoteHandle, context);
         AV9ProductDataImage.setgxTv_SdtWWPProductDataImages_Image( A230ArticuloGaleriaImagen );
         AV9ProductDataImage.setgxTv_SdtWWPProductDataImages_Image_gxi( A40000ArticuloGaleriaImagen_GXI );
         AV10ProductDataImages.add(AV9ProductDataImage, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = nmcartproductimages.this.AV10ProductDataImages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ProductDataImages = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
      scmdbuf = "" ;
      P006G2_A13ArticuloId = new long[1] ;
      P006G2_A40000ArticuloGaleriaImagen_GXI = new String[] {""} ;
      P006G2_A230ArticuloGaleriaImagen = new String[] {""} ;
      P006G2_A48ArticuloGaleriaId = new long[1] ;
      A40000ArticuloGaleriaImagen_GXI = "" ;
      A230ArticuloGaleriaImagen = "" ;
      AV9ProductDataImage = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.nmcartproductimages__default(),
         new Object[] {
             new Object[] {
            P006G2_A13ArticuloId, P006G2_A40000ArticuloGaleriaImagen_GXI, P006G2_A230ArticuloGaleriaImagen, P006G2_A48ArticuloGaleriaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A13ArticuloId ;
   private long A48ArticuloGaleriaId ;
   private String scmdbuf ;
   private String AV11ProductId ;
   private String A40000ArticuloGaleriaImagen_GXI ;
   private String A230ArticuloGaleriaImagen ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P006G2_A13ArticuloId ;
   private String[] P006G2_A40000ArticuloGaleriaImagen_GXI ;
   private String[] P006G2_A230ArticuloGaleriaImagen ;
   private long[] P006G2_A48ArticuloGaleriaId ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> AV10ProductDataImages ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages AV9ProductDataImage ;
}

final  class nmcartproductimages__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006G2", "SELECT [ArticuloId], [ArticuloGaleriaImagen_GXI], [ArticuloGaleriaImagen], [ArticuloGaleriaId] FROM [ArticuloGaleria] WHERE [ArticuloId] = CONVERT( DECIMAL(28,14), ?) ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(2));
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
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
      }
   }

}

