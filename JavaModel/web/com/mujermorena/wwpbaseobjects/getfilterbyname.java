package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getfilterbyname extends GXProcedure
{
   public getfilterbyname( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getfilterbyname.class ), "" );
   }

   public getfilterbyname( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      getfilterbyname.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getfilterbyname.this.AV12UserCustomKey = aP0;
      getfilterbyname.this.AV8FilterName = aP1;
      getfilterbyname.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10GridStateCollection.fromxml(new com.mujermorena.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( AV12UserCustomKey), null, null);
      AV15GXV1 = 1 ;
      while ( AV15GXV1 <= AV10GridStateCollection.size() )
      {
         AV11GridStateCollectionItem = (com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item)((com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item)AV10GridStateCollection.elementAt(-1+AV15GXV1));
         if ( GXutil.strcmp(AV11GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title(), AV8FilterName) == 0 )
         {
            AV9FilterXML = AV11GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml() ;
            if (true) break;
         }
         AV15GXV1 = (int)(AV15GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getfilterbyname.this.AV9FilterXML;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9FilterXML = "" ;
      AV10GridStateCollection = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item>(com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV11GridStateCollectionItem = new com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV15GXV1 ;
   private String AV9FilterXML ;
   private String AV12UserCustomKey ;
   private String AV8FilterName ;
   private String[] aP2 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item> AV10GridStateCollection ;
   private com.mujermorena.wwpbaseobjects.SdtGridStateCollection_Item AV11GridStateCollectionItem ;
}

