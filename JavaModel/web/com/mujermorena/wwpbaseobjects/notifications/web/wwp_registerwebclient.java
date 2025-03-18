package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_registerwebclient extends GXProcedure
{
   public wwp_registerwebclient( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_registerwebclient.class ), "" );
   }

   public wwp_registerwebclient( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      wwp_registerwebclient.this.AV13ClientId = aP0;
      wwp_registerwebclient.this.AV11BrowserId = aP1;
      wwp_registerwebclient.this.AV12BrowserVersion = aP2;
      wwp_registerwebclient.this.AV15UserGUID = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( AV18Pgmname, "Begin Web Client Registration") ;
      if ( ! new com.mujermorena.wwpbaseobjects.wwp_existsuserextended(remoteHandle, context).executeUdp( AV15UserGUID) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( AV18Pgmname, GXutil.format( "Creating User Extended %1...", AV15UserGUID, "", "", "", "", "", "", "", "")) ;
         GXv_objcol_SdtGAMError1[0] = AV8GAMErrorCollection ;
         AV9GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getbyguid(AV15UserGUID, GXv_objcol_SdtGAMError1);
         AV8GAMErrorCollection = GXv_objcol_SdtGAMError1[0] ;
         GXv_objcol_SdtMessages_Message2[0] = AV10Messages ;
         new com.mujermorena.wwpbaseobjects.wwp_usersync(remoteHandle, context).execute( "INS", AV9GAMUser, GXv_objcol_SdtMessages_Message2) ;
         AV10Messages = GXv_objcol_SdtMessages_Message2[0] ;
      }
      AV19GXLvl7 = (byte)(0) ;
      /* Using cursor P00342 */
      pr_default.execute(0, new Object[] {AV13ClientId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A39WWPWebClientId = P00342_A39WWPWebClientId[0] ;
         A171WWPWebClientBrowserId = P00342_A171WWPWebClientBrowserId[0] ;
         A172WWPWebClientBrowserVersion = P00342_A172WWPWebClientBrowserVersion[0] ;
         A174WWPWebClientLastRegistered = P00342_A174WWPWebClientLastRegistered[0] ;
         A32WWPUserExtendedId = P00342_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = P00342_n32WWPUserExtendedId[0] ;
         AV19GXLvl7 = (byte)(1) ;
         new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( AV18Pgmname, "Updating Web Client") ;
         A171WWPWebClientBrowserId = AV11BrowserId ;
         A172WWPWebClientBrowserVersion = AV12BrowserVersion ;
         A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         A32WWPUserExtendedId = AV15UserGUID ;
         n32WWPUserExtendedId = false ;
         /* Using cursor P00343 */
         pr_default.execute(1, new Object[] {Short.valueOf(A171WWPWebClientBrowserId), A172WWPWebClientBrowserVersion, A174WWPWebClientLastRegistered, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, A39WWPWebClientId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebClient");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV19GXLvl7 == 0 )
      {
         new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( AV18Pgmname, "Creating Web Client") ;
         /*
            INSERT RECORD ON TABLE WWP_WebClient

         */
         A39WWPWebClientId = AV13ClientId ;
         A171WWPWebClientBrowserId = AV11BrowserId ;
         A172WWPWebClientBrowserVersion = AV12BrowserVersion ;
         A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         A32WWPUserExtendedId = AV15UserGUID ;
         n32WWPUserExtendedId = false ;
         /* Using cursor P00344 */
         pr_default.execute(2, new Object[] {A39WWPWebClientId, Short.valueOf(A171WWPWebClientBrowserId), A172WWPWebClientBrowserVersion, A173WWPWebClientFirstRegistered, A174WWPWebClientLastRegistered, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebClient");
         if ( (pr_default.getStatus(2) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( AV18Pgmname, "Completed Web Client Registration") ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_registerwebclient");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18Pgmname = "" ;
      AV9GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV8GAMErrorCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV10Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      scmdbuf = "" ;
      P00342_A39WWPWebClientId = new String[] {""} ;
      P00342_A171WWPWebClientBrowserId = new short[1] ;
      P00342_A172WWPWebClientBrowserVersion = new String[] {""} ;
      P00342_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      P00342_A32WWPUserExtendedId = new String[] {""} ;
      P00342_n32WWPUserExtendedId = new boolean[] {false} ;
      A39WWPWebClientId = "" ;
      A172WWPWebClientBrowserVersion = "" ;
      A174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      A32WWPUserExtendedId = "" ;
      A173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_registerwebclient__default(),
         new Object[] {
             new Object[] {
            P00342_A39WWPWebClientId, P00342_A171WWPWebClientBrowserId, P00342_A172WWPWebClientBrowserVersion, P00342_A174WWPWebClientLastRegistered, P00342_A32WWPUserExtendedId, P00342_n32WWPUserExtendedId
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV18Pgmname = "WWPBaseObjects.Notifications.Web.WWP_RegisterWebClient" ;
      /* GeneXus formulas. */
      AV18Pgmname = "WWPBaseObjects.Notifications.Web.WWP_RegisterWebClient" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19GXLvl7 ;
   private short AV11BrowserId ;
   private short A171WWPWebClientBrowserId ;
   private short Gx_err ;
   private int GX_INS35 ;
   private String AV13ClientId ;
   private String AV15UserGUID ;
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String A39WWPWebClientId ;
   private String A32WWPUserExtendedId ;
   private String Gx_emsg ;
   private java.util.Date A174WWPWebClientLastRegistered ;
   private java.util.Date A173WWPWebClientFirstRegistered ;
   private boolean Cond_result ;
   private boolean n32WWPUserExtendedId ;
   private String AV12BrowserVersion ;
   private String A172WWPWebClientBrowserVersion ;
   private IDataStoreProvider pr_default ;
   private String[] P00342_A39WWPWebClientId ;
   private short[] P00342_A171WWPWebClientBrowserId ;
   private String[] P00342_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] P00342_A174WWPWebClientLastRegistered ;
   private String[] P00342_A32WWPUserExtendedId ;
   private boolean[] P00342_n32WWPUserExtendedId ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV8GAMErrorCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV10Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV9GAMUser ;
}

final  class wwp_registerwebclient__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00342", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WITH (UPDLOCK) WHERE [WWPWebClientId] = ? ORDER BY [WWPWebClientId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00343", "UPDATE [WWP_WebClient] SET [WWPWebClientBrowserId]=?, [WWPWebClientBrowserVersion]=?, [WWPWebClientLastRegistered]=?, [WWPUserExtendedId]=?  WHERE [WWPWebClientId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00344", "INSERT INTO [WWP_WebClient]([WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 100);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setDateTime(3, (java.util.Date)parms[2], false, true);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 40);
               }
               stmt.setString(5, (String)parms[5], 100);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 100);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setDateTime(4, (java.util.Date)parms[3], false, true);
               stmt.setDateTime(5, (java.util.Date)parms[4], false, true);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 40);
               }
               return;
      }
   }

}

