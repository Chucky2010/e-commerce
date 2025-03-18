package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenasd_level_detail extends GXProcedure
{
   public mujermorenasd_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenasd_level_detail.class ), "" );
   }

   public mujermorenasd_level_detail( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt executeUdp( int aP0 )
   {
      mujermorenasd_level_detail.this.aP1 = new com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt[] {new com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt[] aP1 )
   {
      mujermorenasd_level_detail.this.AV14gxid = aP0;
      mujermorenasd_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV14gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxwebsession.setValue(Gxids+"gxvar_Userinfo_userimage", AV28Userinfo_userimage_GXI);
         Gxwebsession.setValue(Gxids+"gxvar_Userinfo_usertitle", AV10UserInfo_UserTitle);
         Gxwebsession.setValue(Gxids+"gxvar_Userinfo_userinformation", AV11UserInfo_UserInformation);
         Gxwebsession.setValue(Gxids+"gxvar_Menuoptions", AV8MenuOptions.toJSonString(false));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV8MenuOptions.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Menuoptions"), null);
         AV28Userinfo_userimage_GXI = (Gxwebsession.getValue(Gxids+"gxvar_Userinfo_userimage")) ;
         AV9UserInfo_UserImage = "" ;
         AV10UserInfo_UserTitle = Gxwebsession.getValue(Gxids+"gxvar_Userinfo_usertitle") ;
         AV11UserInfo_UserInformation = Gxwebsession.getValue(Gxids+"gxvar_Userinfo_userinformation") ;
      }
      GXt_objcol_SdtMenuOptions_MenuOptionsItem1 = AV8MenuOptions ;
      GXv_objcol_SdtMenuOptions_MenuOptionsItem2[0] = GXt_objcol_SdtMenuOptions_MenuOptionsItem1 ;
      new com.mujermorena.mujermorenasdoptionsdp(remoteHandle, context).execute( GXv_objcol_SdtMenuOptions_MenuOptionsItem2) ;
      GXt_objcol_SdtMenuOptions_MenuOptionsItem1 = GXv_objcol_SdtMenuOptions_MenuOptionsItem2[0] ;
      AV8MenuOptions = GXt_objcol_SdtMenuOptions_MenuOptionsItem1 ;
      AV8MenuOptions.sort("OrderIndex");
      GXt_SdtMenuInformation3 = AV13MenuInfo;
      GXv_SdtMenuInformation4[0] = GXt_SdtMenuInformation3;
      new com.mujermorena.mujermorenadmenuinfodp(remoteHandle, context).execute( GXv_SdtMenuInformation4) ;
      GXt_SdtMenuInformation3 = GXv_SdtMenuInformation4[0] ;
      AV13MenuInfo = GXt_SdtMenuInformation3;
      AV9UserInfo_UserImage = AV13MenuInfo.getgxTv_SdtMenuInformation_Image() ;
      AV28Userinfo_userimage_GXI = AV13MenuInfo.getgxTv_SdtMenuInformation_Image_gxi() ;
      AV10UserInfo_UserTitle = AV13MenuInfo.getgxTv_SdtMenuInformation_Titleinfo() ;
      AV11UserInfo_UserInformation = AV13MenuInfo.getgxTv_SdtMenuInformation_Secondaryinfo() ;
      AV29GXV1 = 1 ;
      while ( AV29GXV1 <= AV8MenuOptions.size() )
      {
         AV8MenuOptions.currentItem( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)AV8MenuOptions.elementAt(-1+AV29GXV1)) );
         if ( ! (GXutil.strcmp("", ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon())==0) )
         {
            Gxdynprop1 = "FontIcon" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop1) + "\"]" ;
         }
         else if ( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Type() == 2 )
         {
            Gxdynprop2 = "MenuLink" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop2) + "\"]" ;
         }
         else if ( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Type() == 9 )
         {
            Gxdynprop3 = "EmptyItem" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop3) + "\"]" ;
         }
         else
         {
            Gxdynprop4 = "Common" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop4) + "\"]" ;
         }
         if ( (GXutil.strcmp("", ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass())==0) )
         {
            Gxdynprop5 = "MenuIconFontAwesome" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Menuoptions__fonticon\",\"Class\",\"" + GXutil.encodeJSON( Gxdynprop5) + "\"]" ;
         }
         else
         {
            Gxdynprop6 = ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass() ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Menuoptions__fonticon\",\"Class\",\"" + GXutil.encodeJSON( Gxdynprop6) + "\"]" ;
         }
         if ( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Type() == 1 )
         {
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Rowlineseparator\",\"Visible\",\"" + "True" + "\"]" ;
         }
         else
         {
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Rowlineseparator\",\"Visible\",\"" + "False" + "\"]" ;
         }
         Gxdynpropsdt = "[" + Gxdynpropsdt + "]" ;
         Gxcol_gridmenuoptions_props.add(Gxdynpropsdt, 0);
         Gxdynpropsdt = "" ;
         AV29GXV1 = (int)(AV29GXV1+1) ;
      }
      AV25GXM7MujerMorenaSD_Level_DetailSdt.setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions( Gxcol_gridmenuoptions_props.toJSonString(false) );
      Gxcol_gridmenuoptions_props.clear();
      AV25GXM7MujerMorenaSD_Level_DetailSdt.setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage( AV9UserInfo_UserImage );
      AV25GXM7MujerMorenaSD_Level_DetailSdt.setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi( AV28Userinfo_userimage_GXI );
      AV25GXM7MujerMorenaSD_Level_DetailSdt.setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle( AV10UserInfo_UserTitle );
      AV25GXM7MujerMorenaSD_Level_DetailSdt.setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation( AV11UserInfo_UserInformation );
      AV25GXM7MujerMorenaSD_Level_DetailSdt.setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions( AV8MenuOptions );
      Gxwebsession.setValue(Gxids+"gxvar_Menuoptions", AV8MenuOptions.toJSonString(false));
      Gxwebsession.setValue(Gxids+"gxvar_Userinfo_userimage", AV28Userinfo_userimage_GXI);
      Gxwebsession.setValue(Gxids+"gxvar_Userinfo_usertitle", AV10UserInfo_UserTitle);
      Gxwebsession.setValue(Gxids+"gxvar_Userinfo_userinformation", AV11UserInfo_UserInformation);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = mujermorenasd_level_detail.this.AV25GXM7MujerMorenaSD_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25GXM7MujerMorenaSD_Level_DetailSdt = new com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV28Userinfo_userimage_GXI = "" ;
      AV10UserInfo_UserTitle = "" ;
      AV11UserInfo_UserInformation = "" ;
      AV8MenuOptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      AV9UserInfo_UserImage = "" ;
      GXt_objcol_SdtMenuOptions_MenuOptionsItem1 = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtMenuOptions_MenuOptionsItem2 = new GXBaseCollection[1] ;
      AV13MenuInfo = new com.mujermorena.workwithplus.nativemobile.SdtMenuInformation(remoteHandle, context);
      GXt_SdtMenuInformation3 = new com.mujermorena.workwithplus.nativemobile.SdtMenuInformation(remoteHandle, context);
      GXv_SdtMenuInformation4 = new com.mujermorena.workwithplus.nativemobile.SdtMenuInformation[1] ;
      Gxdynprop1 = "" ;
      Gxdynpropsdt = "" ;
      Gxdynprop2 = "" ;
      Gxdynprop3 = "" ;
      Gxdynprop4 = "" ;
      Gxdynprop5 = "" ;
      Gxdynprop6 = "" ;
      Gxcol_gridmenuoptions_props = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14gxid ;
   private int AV29GXV1 ;
   private String Gxids ;
   private String Gxdynprop1 ;
   private String Gxdynprop2 ;
   private String Gxdynprop3 ;
   private String Gxdynprop4 ;
   private String Gxdynprop5 ;
   private String AV28Userinfo_userimage_GXI ;
   private String AV10UserInfo_UserTitle ;
   private String AV11UserInfo_UserInformation ;
   private String Gxdynpropsdt ;
   private String Gxdynprop6 ;
   private String AV9UserInfo_UserImage ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> AV8MenuOptions ;
   private com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXSimpleCollection<String> Gxcol_gridmenuoptions_props ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> GXt_objcol_SdtMenuOptions_MenuOptionsItem1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> GXv_objcol_SdtMenuOptions_MenuOptionsItem2[] ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuInformation AV13MenuInfo ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuInformation GXt_SdtMenuInformation3 ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuInformation GXv_SdtMenuInformation4[] ;
   private com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt AV25GXM7MujerMorenaSD_Level_DetailSdt ;
}

