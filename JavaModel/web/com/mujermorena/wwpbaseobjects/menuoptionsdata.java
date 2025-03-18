package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuoptionsdata extends GXProcedure
{
   public menuoptionsdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuoptionsdata.class ), "" );
   }

   public menuoptionsdata( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( )
   {
      menuoptionsdata.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      menuoptionsdata.this.aP0 = aP0;
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
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Inicio" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "public" );
      Gxm1dvelop_menu = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Menú de Desarrollo" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Submenuimage( httpContext.convertURL( context.getHttpContext().getImagePath( "96e3e978-cac4-4e25-9a90-c43eb18787be", "", context.getHttpContext().getTheme( ))) );
      Gxv3skipcount = 0 ;
      AV18GXV2 = 1 ;
      GXt_objcol_SdtProgramNames_ProgramName1 = AV17GXV1 ;
      GXv_objcol_SdtProgramNames_ProgramName2[0] = GXt_objcol_SdtProgramNames_ProgramName1 ;
      new com.mujermorena.wwpbaseobjects.listwwpprograms(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName2) ;
      GXt_objcol_SdtProgramNames_ProgramName1 = GXv_objcol_SdtProgramNames_ProgramName2[0] ;
      AV17GXV1 = GXt_objcol_SdtProgramNames_ProgramName1 ;
      while ( AV18GXV2 <= AV17GXV1.size() )
      {
         AV6ProgramName = (com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName)((com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName)AV17GXV1.elementAt(-1+AV18GXV2));
         Gxv3skipcount = (int)(Gxv3skipcount+1) ;
         Gxm4dvelop_menu_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
         if ( ( 200 != 0 ) && ( Gxv3skipcount >= 200 ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         AV18GXV2 = (int)(AV18GXV2+1) ;
      }
      Gxm4dvelop_menu_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.wventas", new String[] {}, new String[] {})  );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Informe Ventas" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm4dvelop_menu_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.asignarcaja", new String[] {}, new String[] {})  );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Abrir Caja" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "WWP_GAM_SecurityOfTheApplication", "") );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "WWP_GAM_GAMSecurity" );
      Gxm4dvelop_menu_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "WWP_GAM_BasicConfigurations", "") );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "WWP_GAM_BasicConfigurations", "") );
      Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm5dvelop_menu_subitems_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm4dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm5dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "WWP_GAM_Users", "") );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.gamwwusers", new String[] {}, new String[] {})  );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "WWP_GAM_Users", "") );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm5dvelop_menu_subitems_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm4dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm5dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( httpContext.getMessage( "Roles", "") );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.gamwwroles", new String[] {}, new String[] {})  );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "WWP_GAM_Roles", "") );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm5dvelop_menu_subitems_subitems = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm4dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm5dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.mujermorena.gamchangeyourpassword", new String[] {}, new String[] {})  );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( httpContext.getMessage( "WWP_GAM_ChangePassword", "") );
      Gxm5dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = menuoptionsdata.this.Gxm2rootcol;
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
      AV17GXV1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>(com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtProgramNames_ProgramName1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>(com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtProgramNames_ProgramName2 = new GXBaseCollection[1] ;
      AV6ProgramName = new com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      Gxm4dvelop_menu_subitems = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm5dvelop_menu_subitems_subitems = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV5id ;
   private short Gx_err ;
   private int Gxv3skipcount ;
   private int AV18GXV2 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName> AV17GXV1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName> GXt_objcol_SdtProgramNames_ProgramName1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName> GXv_objcol_SdtProgramNames_ProgramName2[] ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> Gxm2rootcol ;
   private com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName AV6ProgramName ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item Gxm1dvelop_menu ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item Gxm4dvelop_menu_subitems ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item Gxm5dvelop_menu_subitems_subitems ;
}

