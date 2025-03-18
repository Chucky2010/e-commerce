package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class additemtocart extends GXProcedure
{
   public additemtocart( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( additemtocart.class ), "" );
   }

   public additemtocart( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item aP0 ,
                            short aP1 ,
                            short[] aP2 )
   {
      additemtocart.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item aP0 ,
                        short aP1 ,
                        short[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item aP0 ,
                             short aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      additemtocart.this.AV10CartItem = aP0;
      additemtocart.this.AV12ProductDispon = aP1;
      additemtocart.this.aP2 = aP2;
      additemtocart.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8WebSession.getValue("WWPCartContent"), "") != 0 )
      {
         AV9Cart.fromJSonString(AV8WebSession.getValue("WWPCartContent"), null);
      }
      else
      {
         AV9Cart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle) ;
      }
      AV13CantidadComprada = (short)(0) ;
      AV14Result = (short)(0) ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV9Cart.size() )
      {
         AV11CartOneItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV9Cart.elementAt(-1+AV20GXV1));
         if ( ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() == AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() ) && ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() == AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() ) )
         {
            AV13CantidadComprada = (short)(AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()+AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()) ;
            AV16CantidadSele = AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty() ;
         }
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      if ( AV13CantidadComprada > AV12ProductDispon )
      {
         AV17Saldo = (short)(AV12ProductDispon-AV16CantidadSele) ;
         if ( AV17Saldo > 0 )
         {
         }
         else
         {
            if ( AV17Saldo < 0 )
            {
               AV17Saldo = (short)(0) ;
            }
         }
         AV14Result = (short)(1) ;
      }
      else
      {
         AV21GXV2 = 1 ;
         while ( AV21GXV2 <= AV9Cart.size() )
         {
            AV11CartOneItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV9Cart.elementAt(-1+AV21GXV2));
            if ( ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() == AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() ) && ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() == AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() ) )
            {
               AV11CartOneItem.setgxTv_SdtDVelop_ECommerceCart_Item_Productqty( (short)(AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()+(AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty())) );
               if (true) break;
            }
            AV21GXV2 = (int)(AV21GXV2+1) ;
         }
         if ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() != AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() )
         {
            AV9Cart.add(AV10CartItem, 0);
         }
         else
         {
            if ( ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() == AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid() ) && ( AV11CartOneItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() != AV10CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() ) )
            {
               AV9Cart.add(AV10CartItem, 0);
            }
         }
         AV8WebSession.setValue("WWPCartContent", AV9Cart.toJSonString(false));
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = additemtocart.this.AV14Result;
      this.aP3[0] = additemtocart.this.AV17Saldo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8WebSession = httpContext.getWebSession();
      AV9Cart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      AV11CartOneItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12ProductDispon ;
   private short AV14Result ;
   private short AV17Saldo ;
   private short AV13CantidadComprada ;
   private short AV16CantidadSele ;
   private short Gx_err ;
   private int AV20GXV1 ;
   private int AV21GXV2 ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private short[] aP3 ;
   private short[] aP2 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV9Cart ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV10CartItem ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV11CartOneItem ;
}

