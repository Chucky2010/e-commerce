package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dataprovidergallery extends GXProcedure
{
   public dataprovidergallery( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dataprovidergallery.class ), "" );
   }

   public dataprovidergallery( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem> executeUdp( )
   {
      dataprovidergallery.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem>[] aP0 )
   {
      dataprovidergallery.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = dataprovidergallery.this.Gxm1rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm1rootcol = new GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem>(com.mujermorena.SdtImagesData_ImagesDataItem.class, "ImagesDataItem", "Mujer_Morena", remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem>[] aP0 ;
   private GXBaseCollection<com.mujermorena.SdtImagesData_ImagesDataItem> Gxm1rootcol ;
}

