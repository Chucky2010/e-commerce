package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuauthorizedoptions extends GXProcedure
{
   public getmenuauthorizedoptions( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuauthorizedoptions.class ), "" );
   }

   public getmenuauthorizedoptions( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( )
   {
      getmenuauthorizedoptions.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      getmenuauthorizedoptions.this.AV9DVelop_Menu = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18GXV1 = 1 ;
      while ( AV18GXV1 <= AV9DVelop_Menu.size() )
      {
         AV10DVelop_Menu_Item = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)AV9DVelop_Menu.elementAt(-1+AV18GXV1));
         if ( AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().size() > 0 )
         {
            GXv_char1[0] = AV15ResultJson ;
            new com.mujermorena.wwpbaseobjects.getmenuauthorizedoptionsrecursive(remoteHandle, context).execute( AV10DVelop_Menu_Item.toJSonString(false, true), GXv_char1) ;
            getmenuauthorizedoptions.this.AV15ResultJson = GXv_char1[0] ;
            AV8Aux_DVelop_Menu_Item.fromJSonString(AV15ResultJson, null);
            if ( AV8Aux_DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().size() == 0 )
            {
               AV14RemoveIds.add(AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Id(), 0);
            }
            else
            {
               AV10DVelop_Menu_Item.fromJSonString(AV15ResultJson, null);
            }
         }
         else
         {
            GXt_boolean2 = AV12IsAuthorized ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new com.mujermorena.wwpbaseobjects.ismenuauthorizedoption(remoteHandle, context).execute( AV10DVelop_Menu_Item, GXv_boolean3) ;
            getmenuauthorizedoptions.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV12IsAuthorized = GXt_boolean2 ;
            if ( ! AV12IsAuthorized )
            {
               AV14RemoveIds.add(AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Id(), 0);
            }
         }
         AV18GXV1 = (int)(AV18GXV1+1) ;
      }
      AV11i = (short)(1) ;
      while ( AV11i <= AV14RemoveIds.size() )
      {
         AV13j = (short)(1) ;
         while ( AV13j <= AV9DVelop_Menu.size() )
         {
            if ( GXutil.strcmp(GXutil.trim( ((com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)AV9DVelop_Menu.elementAt(-1+AV13j)).getgxTv_SdtDVelop_Menu_Item_Id()), GXutil.trim( (String)AV14RemoveIds.elementAt(-1+AV11i))) == 0 )
            {
               AV9DVelop_Menu.removeItem(AV13j);
               if (true) break;
            }
            AV13j = (short)(AV13j+1) ;
         }
         AV11i = (short)(AV11i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getmenuauthorizedoptions.this.AV9DVelop_Menu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10DVelop_Menu_Item = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV15ResultJson = "" ;
      GXv_char1 = new String[1] ;
      AV8Aux_DVelop_Menu_Item = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV14RemoveIds = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean3 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11i ;
   private short AV13j ;
   private short Gx_err ;
   private int AV18GXV1 ;
   private String GXv_char1[] ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String AV15ResultJson ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 ;
   private GXSimpleCollection<String> AV14RemoveIds ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> AV9DVelop_Menu ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV10DVelop_Menu_Item ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV8Aux_DVelop_Menu_Item ;
}

