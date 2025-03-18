package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class templatebannerdp extends GXProcedure
{
   public templatebannerdp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( templatebannerdp.class ), "" );
   }

   public templatebannerdp( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> executeUdp( )
   {
      templatebannerdp.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>[] aP0 )
   {
      templatebannerdp.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1simplelistdata = (com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1simplelistdata, 0);
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Image( httpContext.convertURL( context.getHttpContext().getImagePath( "de098494-e980-42c1-a1a1-3bca32bd2d04", "", context.getHttpContext().getTheme( ))) );
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall( "" );
      Gxm1simplelistdata = (com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1simplelistdata, 0);
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Image( httpContext.convertURL( context.getHttpContext().getImagePath( "6922fd14-f63f-46ac-a45d-f3a2869c12d7", "", context.getHttpContext().getTheme( ))) );
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall( "" );
      Gxm1simplelistdata = (com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1simplelistdata, 0);
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Image( httpContext.convertURL( context.getHttpContext().getImagePath( "579f2c7e-99d6-4b99-8fa7-7d66b115a324", "", context.getHttpContext().getTheme( ))) );
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?1" );
      Gxm1simplelistdata = (com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1simplelistdata, 0);
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Image( httpContext.convertURL( context.getHttpContext().getImagePath( "cb6db89b-bb52-4959-ade5-050a72da0aeb", "", context.getHttpContext().getTheme( ))) );
      Gxm1simplelistdata.setgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall( "sd:WorkWithPlus.NativeMobile.ExampleMenuOption?3" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = templatebannerdp.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListDataItem", "Mujer_Morena", remoteHandle);
      Gxm1simplelistdata = new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>[] aP0 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> Gxm2rootcol ;
   private com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem Gxm1simplelistdata ;
}

