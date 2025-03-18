package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenasdhometab3_level_detail extends GXProcedure
{
   public mujermorenasdhometab3_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenasdhometab3_level_detail.class ), "" );
   }

   public mujermorenasdhometab3_level_detail( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt executeUdp( int aP0 )
   {
      mujermorenasdhometab3_level_detail.this.aP1 = new com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt[] {new com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt[] aP1 )
   {
      mujermorenasdhometab3_level_detail.this.AV10gxid = aP0;
      mujermorenasdhometab3_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV10gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxwebsession.setValue(Gxids+"gxvar_Userinfo_userimage", AV26Userinfo_userimage_GXI);
         Gxwebsession.setValue(Gxids+"gxvar_Menuoptions", AV8MenuOptions.toJSonString(false));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV8MenuOptions.fromJSonString(Gxwebsession.getValue(Gxids+"gxvar_Menuoptions"), null);
         AV26Userinfo_userimage_GXI = (Gxwebsession.getValue(Gxids+"gxvar_Userinfo_userimage")) ;
         AV9UserInfo_UserImage = "" ;
      }
      GXt_objcol_SdtMenuOptions_MenuOptionsItem1 = AV8MenuOptions ;
      GXv_objcol_SdtMenuOptions_MenuOptionsItem2[0] = GXt_objcol_SdtMenuOptions_MenuOptionsItem1 ;
      new com.mujermorena.workwithplus.nativemobile.templateusersettingsdp(remoteHandle, context).execute( GXv_objcol_SdtMenuOptions_MenuOptionsItem2) ;
      GXt_objcol_SdtMenuOptions_MenuOptionsItem1 = GXv_objcol_SdtMenuOptions_MenuOptionsItem2[0] ;
      AV8MenuOptions = GXt_objcol_SdtMenuOptions_MenuOptionsItem1 ;
      AV8MenuOptions.sort("OrderIndex");
      AV9UserInfo_UserImage = context.getHttpContext().getImagePath( "9b60406f-2e43-467c-92b6-b2d04aad0f71", "", context.getHttpContext().getTheme( )) ;
      AV26Userinfo_userimage_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "9b60406f-2e43-467c-92b6-b2d04aad0f71", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      Gxdynprop1 = GXutil.format( httpContext.getMessage( "Hi, %1", ""), "User", "", "", "", "", "", "", "", "") ;
      Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Userinfo_welcometext\",\"Caption\",\"" + GXutil.encodeJSON( Gxdynprop1) + "\"]" ;
      AV27GXV1 = 1 ;
      while ( AV27GXV1 <= AV8MenuOptions.size() )
      {
         AV8MenuOptions.currentItem( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)AV8MenuOptions.elementAt(-1+AV27GXV1)) );
         if ( ! (GXutil.strcmp("", ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon())==0) )
         {
            Gxdynprop2 = "FontIcon" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop2) + "\"]" ;
         }
         else if ( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Type() == 2 )
         {
            Gxdynprop3 = "MenuLink" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop3) + "\"]" ;
         }
         else if ( ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Type() == 9 )
         {
            Gxdynprop4 = "EmptyItem" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop4) + "\"]" ;
         }
         else
         {
            Gxdynprop5 = "Common" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Gridmenuoptions\",\"Itemlayout\",\"" + GXutil.encodeJSON( Gxdynprop5) + "\"]" ;
         }
         if ( (GXutil.strcmp("", ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass())==0) )
         {
            Gxdynprop6 = "MenuIconFontAwesome" ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Menuoptions__fonticon\",\"Class\",\"" + GXutil.encodeJSON( Gxdynprop6) + "\"]" ;
         }
         else
         {
            Gxdynprop7 = ((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(AV8MenuOptions.currentItem())).getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass() ;
            Gxdynpropsdt += ((GXutil.strcmp(Gxdynpropsdt, "")==0) ? "" : ", ") + "[\"Menuoptions__fonticon\",\"Class\",\"" + GXutil.encodeJSON( Gxdynprop7) + "\"]" ;
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
         AV27GXV1 = (int)(AV27GXV1+1) ;
      }
      AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions( Gxcol_gridmenuoptions_props.toJSonString(false) );
      Gxcol_gridmenuoptions_props.clear();
      AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage( AV9UserInfo_UserImage );
      AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi( AV26Userinfo_userimage_GXI );
      AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions( AV8MenuOptions );
      AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      Gxwebsession.setValue(Gxids+"gxvar_Menuoptions", AV8MenuOptions.toJSonString(false));
      Gxwebsession.setValue(Gxids+"gxvar_Userinfo_userimage", AV26Userinfo_userimage_GXI);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = mujermorenasdhometab3_level_detail.this.AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt = new com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV26Userinfo_userimage_GXI = "" ;
      AV8MenuOptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      AV9UserInfo_UserImage = "" ;
      GXt_objcol_SdtMenuOptions_MenuOptionsItem1 = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtMenuOptions_MenuOptionsItem2 = new GXBaseCollection[1] ;
      Gxdynprop1 = "" ;
      Gxdynprop = "" ;
      Gxdynprop2 = "" ;
      Gxdynpropsdt = "" ;
      Gxdynprop3 = "" ;
      Gxdynprop4 = "" ;
      Gxdynprop5 = "" ;
      Gxdynprop6 = "" ;
      Gxdynprop7 = "" ;
      Gxcol_gridmenuoptions_props = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10gxid ;
   private int AV27GXV1 ;
   private String Gxids ;
   private String Gxdynprop1 ;
   private String Gxdynprop2 ;
   private String Gxdynprop3 ;
   private String Gxdynprop4 ;
   private String Gxdynprop5 ;
   private String Gxdynprop6 ;
   private String AV26Userinfo_userimage_GXI ;
   private String Gxdynprop ;
   private String Gxdynpropsdt ;
   private String Gxdynprop7 ;
   private String AV9UserInfo_UserImage ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> AV8MenuOptions ;
   private com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXSimpleCollection<String> Gxcol_gridmenuoptions_props ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> GXt_objcol_SdtMenuOptions_MenuOptionsItem1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> GXv_objcol_SdtMenuOptions_MenuOptionsItem2[] ;
   private com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt AV23GXM8MujerMorenaSDHomeTab3_Level_DetailSdt ;
}

