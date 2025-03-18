package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartaddressgetselected extends GXProcedure
{
   public nmcartaddressgetselected( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartaddressgetselected.class ), "" );
   }

   public nmcartaddressgetselected( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtNMCartUserAddress executeUdp( )
   {
      nmcartaddressgetselected.this.aP0 = new com.mujermorena.SdtNMCartUserAddress[] {new com.mujermorena.SdtNMCartUserAddress()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( com.mujermorena.SdtNMCartUserAddress[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.mujermorena.SdtNMCartUserAddress[] aP0 )
   {
      nmcartaddressgetselected.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV10Selected ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.workwithplus.nativemobile.wwpwebserversessionget(remoteHandle, context).execute( "SelectedAddress", GXv_char2) ;
      nmcartaddressgetselected.this.GXt_char1 = GXv_char2[0] ;
      AV10Selected = GXt_char1 ;
      GXt_objcol_SdtNMCartUserAddress3 = AV9UserAddressCollection ;
      GXv_objcol_SdtNMCartUserAddress4[0] = GXt_objcol_SdtNMCartUserAddress3 ;
      new com.mujermorena.nmcartaddressgetavailable(remoteHandle, context).execute( GXv_objcol_SdtNMCartUserAddress4) ;
      GXt_objcol_SdtNMCartUserAddress3 = GXv_objcol_SdtNMCartUserAddress4[0] ;
      AV9UserAddressCollection = GXt_objcol_SdtNMCartUserAddress3 ;
      AV13GXV1 = 1 ;
      while ( AV13GXV1 <= AV9UserAddressCollection.size() )
      {
         AV8CartUserAddress = (com.mujermorena.SdtNMCartUserAddress)((com.mujermorena.SdtNMCartUserAddress)AV9UserAddressCollection.elementAt(-1+AV13GXV1));
         if ( GXutil.strcmp(AV10Selected, AV8CartUserAddress.getgxTv_SdtNMCartUserAddress_Id()) == 0 )
         {
            if (true) break;
         }
         AV13GXV1 = (int)(AV13GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = nmcartaddressgetselected.this.AV8CartUserAddress;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CartUserAddress = new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
      AV10Selected = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV9UserAddressCollection = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtNMCartUserAddress3 = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtNMCartUserAddress4 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13GXV1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV10Selected ;
   private com.mujermorena.SdtNMCartUserAddress[] aP0 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> AV9UserAddressCollection ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> GXt_objcol_SdtNMCartUserAddress3 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> GXv_objcol_SdtNMCartUserAddress4[] ;
   private com.mujermorena.SdtNMCartUserAddress AV8CartUserAddress ;
}

