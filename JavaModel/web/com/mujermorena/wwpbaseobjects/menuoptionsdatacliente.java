package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuoptionsdatacliente extends GXProcedure
{
   public menuoptionsdatacliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuoptionsdatacliente.class ), "" );
   }

   public menuoptionsdatacliente( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( )
   {
      menuoptionsdatacliente.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      menuoptionsdatacliente.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV5id = (short)(0) ;
      Gxm1dvelop_menu = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.home", new String[] {}, new String[] {})  );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "INICIO" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "public" );
      Gxm1dvelop_menu = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "PEDIDOS" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Submenuimage( httpContext.convertURL( context.getHttpContext().getImagePath( "96e3e978-cac4-4e25-9a90-c43eb18787be", "", context.getHttpContext().getTheme( ))) );
      Gxm3dvelop_menu_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.pedidoswwcliente", new String[] {}, new String[] {})  );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "PEDIDOS" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "public" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = menuoptionsdatacliente.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Mujer_Morena", remoteHandle);
      Gxm1dvelop_menu = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV5id ;
   private short Gx_err ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> Gxm2rootcol ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item Gxm1dvelop_menu ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item Gxm3dvelop_menu_subitems ;
}

