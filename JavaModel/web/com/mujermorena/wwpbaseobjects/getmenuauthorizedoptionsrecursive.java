package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuauthorizedoptionsrecursive extends GXProcedure
{
   public getmenuauthorizedoptionsrecursive( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuauthorizedoptionsrecursive.class ), "" );
   }

   public getmenuauthorizedoptionsrecursive( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getmenuauthorizedoptionsrecursive.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getmenuauthorizedoptionsrecursive.this.AV13ParentItemJson = aP0;
      getmenuauthorizedoptionsrecursive.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14RemoveIds.clear();
      AV10DVelop_Menu_Item.fromJSonString(AV13ParentItemJson, null);
      AV19GXV1 = 1 ;
      while ( AV19GXV1 <= AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().size() )
      {
         AV9AuxDVelop_Menu_Item = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().elementAt(-1+AV19GXV1));
         if ( AV9AuxDVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().size() > 0 )
         {
            GXv_char1[0] = AV15Result2Json ;
            new com.mujermorena.wwpbaseobjects.getmenuauthorizedoptionsrecursive(remoteHandle, context).execute( AV9AuxDVelop_Menu_Item.toJSonString(false, true), GXv_char1) ;
            getmenuauthorizedoptionsrecursive.this.AV15Result2Json = GXv_char1[0] ;
            AV9AuxDVelop_Menu_Item.fromJSonString(AV15Result2Json, null);
            if ( AV9AuxDVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().size() == 0 )
            {
               AV14RemoveIds.add(AV9AuxDVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Id(), 0);
            }
         }
         else
         {
            GXt_boolean2 = AV8IsAuthorized ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new com.mujermorena.wwpbaseobjects.ismenuauthorizedoption(remoteHandle, context).execute( AV9AuxDVelop_Menu_Item, GXv_boolean3) ;
            getmenuauthorizedoptionsrecursive.this.GXt_boolean2 = GXv_boolean3[0] ;
            AV8IsAuthorized = GXt_boolean2 ;
            if ( ! AV8IsAuthorized )
            {
               AV14RemoveIds.add(AV9AuxDVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Id(), 0);
            }
         }
         AV19GXV1 = (int)(AV19GXV1+1) ;
      }
      AV11i = (short)(1) ;
      while ( AV11i <= AV14RemoveIds.size() )
      {
         AV12j = (short)(0) ;
         AV20GXV2 = 1 ;
         while ( AV20GXV2 <= AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().size() )
         {
            AV9AuxDVelop_Menu_Item = (com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item)AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().elementAt(-1+AV20GXV2));
            AV12j = (short)(AV12j+1) ;
            if ( GXutil.strcmp(GXutil.trim( AV9AuxDVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Id()), GXutil.trim( (String)AV14RemoveIds.elementAt(-1+AV11i))) == 0 )
            {
               AV10DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Subitems().removeItem(AV12j);
               if (true) break;
            }
            AV20GXV2 = (int)(AV20GXV2+1) ;
         }
         AV11i = (short)(AV11i+1) ;
      }
      AV16ResultJson = AV10DVelop_Menu_Item.toJSonString(false, true) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmenuauthorizedoptionsrecursive.this.AV16ResultJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16ResultJson = "" ;
      AV14RemoveIds = new GXSimpleCollection<String>(String.class, "internal", "");
      AV10DVelop_Menu_Item = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV9AuxDVelop_Menu_Item = new com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV15Result2Json = "" ;
      GXv_char1 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11i ;
   private short AV12j ;
   private short Gx_err ;
   private int AV19GXV1 ;
   private int AV20GXV2 ;
   private String GXv_char1[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String AV13ParentItemJson ;
   private String AV16ResultJson ;
   private String AV15Result2Json ;
   private String[] aP1 ;
   private GXSimpleCollection<String> AV14RemoveIds ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV10DVelop_Menu_Item ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV9AuxDVelop_Menu_Item ;
}

