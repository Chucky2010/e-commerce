package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ismenuauthorizedoption extends GXProcedure
{
   public ismenuauthorizedoption( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ismenuauthorizedoption.class ), "" );
   }

   public ismenuauthorizedoption( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item aP0 )
   {
      ismenuauthorizedoption.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item aP0 ,
                             boolean[] aP1 )
   {
      ismenuauthorizedoption.this.AV9DVelop_Menu_Item = aP0;
      ismenuauthorizedoption.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(GXutil.lower( AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey()), "public") == 0 )
      {
         AV11IsAuthorized = true ;
      }
      else if ( ! (GXutil.strcmp("", AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey())==0) )
      {
         if ( GXutil.strcmp(AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey(), "is_gam_administrator") == 0 )
         {
            AV11IsAuthorized = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).checkrolebyexternalid("is_gam_administrator") ;
         }
         else
         {
            GXt_boolean1 = AV11IsAuthorized ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey(), GXv_boolean2) ;
            ismenuauthorizedoption.this.GXt_boolean1 = GXv_boolean2[0] ;
            AV11IsAuthorized = GXt_boolean1 ;
         }
      }
      else
      {
         AV13Url = AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Link() ;
         if ( ! (GXutil.strcmp("", AV13Url)==0) )
         {
            /* Execute user subroutine: 'GET AUTHORIZATION KEY FROM URL' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            GXt_boolean1 = AV11IsAuthorized ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( AV8AuthorizationKey, GXv_boolean2) ;
            ismenuauthorizedoption.this.GXt_boolean1 = GXv_boolean2[0] ;
            AV11IsAuthorized = GXt_boolean1 ;
         }
         else
         {
            AV11IsAuthorized = true ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GET AUTHORIZATION KEY FROM URL' Routine */
      returnInSub = false ;
      AV8AuthorizationKey = "" ;
      AV15UrlResourceName = "" ;
      AV13Url = GXutil.strReplace( AV13Url, httpContext.getMessage( ".aspx", ""), "") ;
      AV10i = (short)(GXutil.strSearchRev( AV13Url, "/", -1)) ;
      if ( AV10i > 0 )
      {
         AV13Url = GXutil.substring( AV13Url, AV10i+1, GXutil.len( GXutil.trim( AV13Url))-AV10i) ;
      }
      else
      {
         AV13Url = GXutil.trim( AV13Url) ;
      }
      if ( GXutil.strSearchRev( AV13Url, "?", -1) > 0 )
      {
         AV13Url = GXutil.substring( AV13Url, 1, GXutil.strSearchRev( AV13Url, "?", -1)-1) ;
      }
      AV10i = (short)(GXutil.strSearchRev( AV13Url, ".", -1)) ;
      AV15UrlResourceName = GXutil.substring( AV13Url, AV10i+1, GXutil.len( AV13Url)-AV10i) ;
      AV8AuthorizationKey = GXutil.lower( GXutil.trim( AV15UrlResourceName)) + "_Execute" ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = ismenuauthorizedoption.this.AV11IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Url = "" ;
      AV8AuthorizationKey = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV15UrlResourceName = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10i ;
   private short Gx_err ;
   private String AV15UrlResourceName ;
   private boolean AV11IsAuthorized ;
   private boolean returnInSub ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV13Url ;
   private String AV8AuthorizationKey ;
   private boolean[] aP1 ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item AV9DVelop_Menu_Item ;
}

