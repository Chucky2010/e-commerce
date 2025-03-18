package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getsearchwcdata extends GXProcedure
{
   public wwp_getsearchwcdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getsearchwcdata.class ), "" );
   }

   public wwp_getsearchwcdata( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> executeUdp( String aP0 ,
                                                                                                                  short aP1 ,
                                                                                                                  short aP2 ,
                                                                                                                  GXSimpleCollection<String>[] aP3 )
   {
      wwp_getsearchwcdata.this.aP4 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        short aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             short aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>[] aP4 )
   {
      wwp_getsearchwcdata.this.AV11SearchText = aP0;
      wwp_getsearchwcdata.this.AV9MaxCategories = aP1;
      wwp_getsearchwcdata.this.AV10MaxItemsPerCategory = aP2;
      wwp_getsearchwcdata.this.AV8AdvFilterEntities = aP3[0];
      this.aP3 = aP3;
      wwp_getsearchwcdata.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV11SearchText)==0) )
      {
         /* Execute user subroutine: 'SEARCH IN TRANSACTIONS' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'SEARCH MENU ITEMS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         while ( AV12WWP_SearchResults.size() > AV9MaxCategories )
         {
            AV12WWP_SearchResults.removeItem(AV12WWP_SearchResults.size());
         }
      }
      else
      {
         if ( (0==AV10MaxItemsPerCategory) )
         {
            /* Execute user subroutine: 'GET ALL ENTITIES DESCRIPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'SEARCH IN TRANSACTIONS' Routine */
      returnInSub = false ;
      AV12WWP_SearchResults.sort("[OrderIndex]");
   }

   public void S121( )
   {
      /* 'SEARCH MENU ITEMS' Routine */
      returnInSub = false ;
      if ( ( AV8AdvFilterEntities.size() == 0 ) || ( AV8AdvFilterEntities.indexof(httpContext.getMessage( "WWP_Search_MenuOptions", "")) > 0 ) )
      {
         GXt_objcol_SdtDVelop_Menu_Item1 = AV18MenuData ;
         GXv_objcol_SdtDVelop_Menu_Item2[0] = GXt_objcol_SdtDVelop_Menu_Item1 ;
         new com.mujermorena.wwpbaseobjects.menuoptionsdata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item2) ;
         GXt_objcol_SdtDVelop_Menu_Item1 = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
         AV18MenuData = GXt_objcol_SdtDVelop_Menu_Item1 ;
         GXv_objcol_SdtDVelop_Menu_Item2[0] = AV20MenuOptions ;
         GXv_objcol_svchar3[0] = AV15MenuOptionsPaths ;
         new com.mujermorena.wwpbaseobjects.wwp_searchmenuoptions(remoteHandle, context).execute( AV11SearchText, AV18MenuData, AV13CurrentMenuOptionPath, GXv_objcol_SdtDVelop_Menu_Item2, GXv_objcol_svchar3) ;
         AV20MenuOptions = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
         AV15MenuOptionsPaths = GXv_objcol_svchar3[0] ;
         if ( AV20MenuOptions.size() > 0 )
         {
            AV21WWP_SearchResultItem = (com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)new com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem(remoteHandle, context);
            AV21WWP_SearchResultItem.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname( httpContext.getMessage( "WWP_Search_MenuOptions", "") );
            AV21WWP_SearchResultItem.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults( true );
            AV12WWP_SearchResults.add(AV21WWP_SearchResultItem, 0);
            AV14i = (short)(1) ;
            AV24GXV1 = 1 ;
            while ( AV24GXV1 <= AV20MenuOptions.size() )
            {
               AV19MenuDataItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)AV20MenuOptions.elementAt(-1+AV24GXV1));
               if ( AV21WWP_SearchResultItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size() >= AV10MaxItemsPerCategory )
               {
                  AV21WWP_SearchResultItem.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults( false );
                  if (true) break;
               }
               else
               {
                  AV17SearchResult = (com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)new com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem(remoteHandle, context);
                  AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description( AV19MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Caption() );
                  AV13CurrentMenuOptionPath.fromJSonString((String)AV15MenuOptionsPaths.elementAt(-1+AV14i), null);
                  if ( AV13CurrentMenuOptionPath.size() > 0 )
                  {
                     AV25GXV2 = 1 ;
                     while ( AV25GXV2 <= AV13CurrentMenuOptionPath.size() )
                     {
                        AV16OptionPath = (String)AV13CurrentMenuOptionPath.elementAt(-1+AV25GXV2) ;
                        if ( ! (GXutil.strcmp("", AV17SearchResult.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2())==0) )
                        {
                           AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2( AV17SearchResult.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2()+" > " );
                        }
                        AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2( AV17SearchResult.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2()+AV16OptionPath );
                        AV25GXV2 = (int)(AV25GXV2+1) ;
                     }
                     AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3( AV19MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Iconclass() );
                     AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype( ((GXutil.strcmp("", GXutil.trim( AV17SearchResult.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3()))==0) ? "Title and subtitle" : "Title, subtitle and icon image") );
                  }
                  else
                  {
                     AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2( AV19MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Iconclass() );
                     AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype( ((GXutil.strcmp("", GXutil.trim( AV17SearchResult.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2()))==0) ? "Title" : "Title and icon image") );
                  }
                  AV17SearchResult.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url( AV19MenuDataItem.getgxTv_SdtDVelop_Menu_Item_Link() );
                  AV21WWP_SearchResultItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().add(AV17SearchResult, 0);
               }
               AV14i = (short)(AV14i+1) ;
               AV24GXV1 = (int)(AV24GXV1+1) ;
            }
         }
      }
   }

   public void S131( )
   {
      /* 'GET ALL ENTITIES DESCRIPTIONS' Routine */
      returnInSub = false ;
      AV12WWP_SearchResults.sort("[OrderIndex]");
      AV8AdvFilterEntities = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26GXV3 = 1 ;
      while ( AV26GXV3 <= AV12WWP_SearchResults.size() )
      {
         AV21WWP_SearchResultItem = (com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)((com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV12WWP_SearchResults.elementAt(-1+AV26GXV3));
         AV8AdvFilterEntities.add(AV21WWP_SearchResultItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname(), 0);
         AV26GXV3 = (int)(AV26GXV3+1) ;
      }
      AV8AdvFilterEntities.add(httpContext.getMessage( "WWP_Search_MenuOptions", ""), 0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = wwp_getsearchwcdata.this.AV8AdvFilterEntities;
      this.aP4[0] = wwp_getsearchwcdata.this.AV12WWP_SearchResults;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12WWP_SearchResults = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Mujer_Morena", remoteHandle);
      AV18MenuData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Mujer_Morena", remoteHandle);
      AV13CurrentMenuOptionPath = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20MenuOptions = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtDVelop_Menu_Item2 = new GXBaseCollection[1] ;
      AV15MenuOptionsPaths = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar3 = new GXSimpleCollection[1] ;
      AV21WWP_SearchResultItem = new com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem(remoteHandle, context);
      AV19MenuDataItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV17SearchResult = new com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem(remoteHandle, context);
      AV16OptionPath = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9MaxCategories ;
   private short AV10MaxItemsPerCategory ;
   private short AV14i ;
   private short Gx_err ;
   private int AV24GXV1 ;
   private int AV25GXV2 ;
   private int AV26GXV3 ;
   private boolean returnInSub ;
   private String AV11SearchText ;
   private String AV16OptionPath ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>[] aP4 ;
   private GXSimpleCollection<String>[] aP3 ;
   private GXSimpleCollection<String> AV8AdvFilterEntities ;
   private GXSimpleCollection<String> AV13CurrentMenuOptionPath ;
   private GXSimpleCollection<String> AV15MenuOptionsPaths ;
   private GXSimpleCollection<String> GXv_objcol_svchar3[] ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV12WWP_SearchResults ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> AV18MenuData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> AV20MenuOptions ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem AV21WWP_SearchResultItem ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem AV17SearchResult ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV19MenuDataItem ;
}

