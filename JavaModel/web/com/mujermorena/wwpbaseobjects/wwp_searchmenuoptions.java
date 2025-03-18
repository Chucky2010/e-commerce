package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_searchmenuoptions extends GXProcedure
{
   public wwp_searchmenuoptions( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_searchmenuoptions.class ), "" );
   }

   public wwp_searchmenuoptions( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( String aP0 ,
                                                 GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> aP1 ,
                                                 GXSimpleCollection<String> aP2 ,
                                                 GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP3 )
   {
      wwp_searchmenuoptions.this.aP4 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> aP1 ,
                        GXSimpleCollection<String> aP2 ,
                        GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP3 ,
                        GXSimpleCollection<String>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> aP1 ,
                             GXSimpleCollection<String> aP2 ,
                             GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP3 ,
                             GXSimpleCollection<String>[] aP4 )
   {
      wwp_searchmenuoptions.this.AV8SearchText = aP0;
      wwp_searchmenuoptions.this.AV9MenuData = aP1;
      wwp_searchmenuoptions.this.AV14CurrentMenuOptionPath = aP2;
      wwp_searchmenuoptions.this.AV10MenuOptions = aP3[0];
      this.aP3 = aP3;
      wwp_searchmenuoptions.this.AV11MenuOptionsPaths = aP4[0];
      this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18GXV1 = 1 ;
      while ( AV18GXV1 <= AV9MenuData.size() )
      {
         AV13MenuDataItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)AV9MenuData.elementAt(-1+AV18GXV1));
         AV12MenuOptionsPath = AV14CurrentMenuOptionPath.toJSonString(false) ;
         if ( ( ! (GXutil.strcmp("", AV13MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Link())==0) ) && ( GXutil.contains( GXutil.lower( AV13MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Caption()), GXutil.lower( GXutil.trim( AV8SearchText))) || GXutil.contains( GXutil.lower( AV12MenuOptionsPath), GXutil.lower( GXutil.trim( AV8SearchText))) ) )
         {
            AV10MenuOptions.add(AV13MenuDataItem, 0);
            AV11MenuOptionsPaths.add(AV12MenuOptionsPath, 0);
         }
         if ( AV13MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Subitems().size() > 0 )
         {
            AV15NewMenuOptionPath.fromJSonString(AV12MenuOptionsPath, null);
            AV15NewMenuOptionPath.add(AV13MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Caption(), 0);
            GXv_objcol_SdtDVelop_Menu_Item1[0] = AV10MenuOptions ;
            GXv_objcol_svchar2[0] = AV11MenuOptionsPaths ;
            new com.mujermorena.wwpbaseobjects.wwp_searchmenuoptions(remoteHandle, context).execute( AV8SearchText, AV13MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Subitems(), AV15NewMenuOptionPath, GXv_objcol_SdtDVelop_Menu_Item1, GXv_objcol_svchar2) ;
            AV10MenuOptions = GXv_objcol_SdtDVelop_Menu_Item1[0] ;
            AV11MenuOptionsPaths = GXv_objcol_svchar2[0] ;
         }
         AV18GXV1 = (int)(AV18GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = wwp_searchmenuoptions.this.AV10MenuOptions;
      this.aP4[0] = wwp_searchmenuoptions.this.AV11MenuOptionsPaths;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13MenuDataItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV12MenuOptionsPath = "" ;
      AV15NewMenuOptionPath = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection[1] ;
      GXv_objcol_svchar2 = new GXSimpleCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18GXV1 ;
   private String AV8SearchText ;
   private String AV12MenuOptionsPath ;
   private GXSimpleCollection<String>[] aP4 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP3 ;
   private GXSimpleCollection<String> AV14CurrentMenuOptionPath ;
   private GXSimpleCollection<String> AV11MenuOptionsPaths ;
   private GXSimpleCollection<String> AV15NewMenuOptionPath ;
   private GXSimpleCollection<String> GXv_objcol_svchar2[] ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> AV9MenuData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> AV10MenuOptions ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item1[] ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV13MenuDataItem ;
}

