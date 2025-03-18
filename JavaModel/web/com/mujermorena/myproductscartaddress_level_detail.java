package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class myproductscartaddress_level_detail extends GXProcedure
{
   public myproductscartaddress_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( myproductscartaddress_level_detail.class ), "" );
   }

   public myproductscartaddress_level_detail( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt executeUdp( int aP0 )
   {
      myproductscartaddress_level_detail.this.aP1 = new com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt[] {new com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt[] aP1 )
   {
      myproductscartaddress_level_detail.this.AV17gxid = aP0;
      myproductscartaddress_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV17gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         AV13GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
         AV15ClienteUser = AV13GAMUser.getgxTv_SdtGAMUser_Name() ;
         AV10SelectedId = "" ;
         new com.mujermorena.nmcartaddresssetselected(remoteHandle, context).execute( AV10SelectedId) ;
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Btncontinue\",\"Enabled\",\"" + "False" + "\"]" ;
         Gxwebsession.setValue(Gxids+"gxvar_Cartuseraddresscollection", AV9CartUserAddressCollection.toJSonString(false));
         Gxwebsession.setValue(Gxids+"gxvar_Selectedid", AV10SelectedId);
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV9CartUserAddressCollection.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Cartuseraddresscollection"), null);
         AV10SelectedId = Gxwebsession.getValue(Gxids+"gxvar_Selectedid") ;
      }
      GXt_objcol_SdtNMCartUserAddress1 = AV9CartUserAddressCollection ;
      GXv_objcol_SdtNMCartUserAddress2[0] = GXt_objcol_SdtNMCartUserAddress1 ;
      new com.mujermorena.nmcartaddressgetavailable(remoteHandle, context).execute( GXv_objcol_SdtNMCartUserAddress2) ;
      GXt_objcol_SdtNMCartUserAddress1 = GXv_objcol_SdtNMCartUserAddress2[0] ;
      AV9CartUserAddressCollection = GXt_objcol_SdtNMCartUserAddress1 ;
      AV29GXV1 = 1 ;
      while ( AV29GXV1 <= AV9CartUserAddressCollection.size() )
      {
         AV9CartUserAddressCollection.currentItem( ((com.mujermorena.SdtNMCartUserAddress)AV9CartUserAddressCollection.elementAt(-1+AV29GXV1)) );
         Gxdynprop1 = ((1==0) ? "Selected" : "available") ;
         Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Datagrid\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop1) + "\"]" ;
         GXt_char3 = Gxdynprop2 ;
         GXv_char4[0] = GXt_char3 ;
         new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex(remoteHandle, context).execute( "f058", GXv_char4) ;
         myproductscartaddress_level_detail.this.GXt_char3 = GXv_char4[0] ;
         Gxdynprop2 = GXt_char3 ;
         Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Checked\",\"Caption\",\"" + GXutil.encodeJSON( Gxdynprop2) + "\"]" ;
         Gxdynprop3 = "Selected" ;
         Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Datagrid\",\"Itemselectedlayout\",\"" + GXutil.encodeJSON( Gxdynprop3) + "\"]" ;
         Gxdynpropsdt = "[" + Gxdynpropsdt + "]" ;
         Gxcol_datagrid_props.add(Gxdynpropsdt, 0);
         Gxdynpropsdt = "" ;
         AV29GXV1 = (int)(AV29GXV1+1) ;
      }
      AV26GXM4MyProductsCartAddress_Level_DetailSdt.setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxprops_cartuseraddresscollection( Gxcol_datagrid_props.toJSonString(false) );
      Gxcol_datagrid_props.clear();
      AV26GXM4MyProductsCartAddress_Level_DetailSdt.setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Cartuseraddresscollection( AV9CartUserAddressCollection );
      AV26GXM4MyProductsCartAddress_Level_DetailSdt.setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Selectedid( AV10SelectedId );
      AV26GXM4MyProductsCartAddress_Level_DetailSdt.setgxTv_SdtMyProductsCartAddress_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      Gxwebsession.setValue(Gxids+"gxvar_Cartuseraddresscollection", AV9CartUserAddressCollection.toJSonString(false));
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = myproductscartaddress_level_detail.this.AV26GXM4MyProductsCartAddress_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26GXM4MyProductsCartAddress_Level_DetailSdt = new com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV13GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV15ClienteUser = "" ;
      AV10SelectedId = "" ;
      Gxdynprop = "" ;
      AV9CartUserAddressCollection = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtNMCartUserAddress1 = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtNMCartUserAddress2 = new GXBaseCollection[1] ;
      Gxdynprop1 = "" ;
      Gxdynpropsdt = "" ;
      Gxdynprop2 = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      Gxdynprop3 = "" ;
      Gxcol_datagrid_props = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17gxid ;
   private int AV29GXV1 ;
   private String Gxids ;
   private String AV15ClienteUser ;
   private String Gxdynprop1 ;
   private String Gxdynprop2 ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String Gxdynprop3 ;
   private String AV10SelectedId ;
   private String Gxdynprop ;
   private String Gxdynpropsdt ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> AV9CartUserAddressCollection ;
   private com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXSimpleCollection<String> Gxcol_datagrid_props ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> GXt_objcol_SdtNMCartUserAddress1 ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> GXv_objcol_SdtNMCartUserAddress2[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV13GAMUser ;
   private com.mujermorena.SdtMyProductsCartAddress_Level_DetailSdt AV26GXM4MyProductsCartAddress_Level_DetailSdt ;
}

