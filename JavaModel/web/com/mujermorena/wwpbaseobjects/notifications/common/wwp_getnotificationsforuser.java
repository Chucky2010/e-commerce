package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getnotificationsforuser extends GXProcedure
{
   public wwp_getnotificationsforuser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getnotificationsforuser.class ), "" );
   }

   public wwp_getnotificationsforuser( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> executeUdp( )
   {
      wwp_getnotificationsforuser.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>[] aP0 )
   {
      wwp_getnotificationsforuser.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11Udparg3 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /* Using cursor P00082 */
      pr_default.execute(0, new Object[] {AV11Udparg3});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A203WWPNotificationIsRead = P00082_A203WWPNotificationIsRead[0] ;
         A32WWPUserExtendedId = P00082_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = P00082_n32WWPUserExtendedId[0] ;
         A37WWPNotificationId = P00082_A37WWPNotificationId[0] ;
         A198WWPNotificationIcon = P00082_A198WWPNotificationIcon[0] ;
         A199WWPNotificationTitle = P00082_A199WWPNotificationTitle[0] ;
         A200WWPNotificationShortDescriptio = P00082_A200WWPNotificationShortDescriptio[0] ;
         A201WWPNotificationLink = P00082_A201WWPNotificationLink[0] ;
         A40WWPNotificationCreated = P00082_A40WWPNotificationCreated[0] ;
         Gxm1wwp_sdtnotificationsdata = (com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem(remoteHandle, context);
         Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdata, 0);
         Gxm1wwp_sdtnotificationsdata.setgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid( (int)(A37WWPNotificationId) );
         Gxm1wwp_sdtnotificationsdata.setgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationiconclass( "NotificationFontIcon"+" "+A198WWPNotificationIcon );
         Gxm1wwp_sdtnotificationsdata.setgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationtitle( A199WWPNotificationTitle );
         Gxm1wwp_sdtnotificationsdata.setgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdescription( A200WWPNotificationShortDescriptio );
         Gxm1wwp_sdtnotificationsdata.setgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime( A40WWPNotificationCreated );
         Gxm1wwp_sdtnotificationsdata.setgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationlink( A201WWPNotificationLink );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_getnotificationsforuser.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>(com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem.class, "WWP_SDTNotificationsDataItem", "Mujer_Morena", remoteHandle);
      AV11Udparg3 = "" ;
      scmdbuf = "" ;
      P00082_A203WWPNotificationIsRead = new boolean[] {false} ;
      P00082_A32WWPUserExtendedId = new String[] {""} ;
      P00082_n32WWPUserExtendedId = new boolean[] {false} ;
      P00082_A37WWPNotificationId = new long[1] ;
      P00082_A198WWPNotificationIcon = new String[] {""} ;
      P00082_A199WWPNotificationTitle = new String[] {""} ;
      P00082_A200WWPNotificationShortDescriptio = new String[] {""} ;
      P00082_A201WWPNotificationLink = new String[] {""} ;
      P00082_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      A32WWPUserExtendedId = "" ;
      A198WWPNotificationIcon = "" ;
      A199WWPNotificationTitle = "" ;
      A200WWPNotificationShortDescriptio = "" ;
      A201WWPNotificationLink = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Gxm1wwp_sdtnotificationsdata = new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_getnotificationsforuser__default(),
         new Object[] {
             new Object[] {
            P00082_A203WWPNotificationIsRead, P00082_A32WWPUserExtendedId, P00082_n32WWPUserExtendedId, P00082_A37WWPNotificationId, P00082_A198WWPNotificationIcon, P00082_A199WWPNotificationTitle, P00082_A200WWPNotificationShortDescriptio, P00082_A201WWPNotificationLink, P00082_A40WWPNotificationCreated
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A37WWPNotificationId ;
   private String AV11Udparg3 ;
   private String scmdbuf ;
   private String A32WWPUserExtendedId ;
   private java.util.Date A40WWPNotificationCreated ;
   private boolean A203WWPNotificationIsRead ;
   private boolean n32WWPUserExtendedId ;
   private String A198WWPNotificationIcon ;
   private String A199WWPNotificationTitle ;
   private String A200WWPNotificationShortDescriptio ;
   private String A201WWPNotificationLink ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P00082_A203WWPNotificationIsRead ;
   private String[] P00082_A32WWPUserExtendedId ;
   private boolean[] P00082_n32WWPUserExtendedId ;
   private long[] P00082_A37WWPNotificationId ;
   private String[] P00082_A198WWPNotificationIcon ;
   private String[] P00082_A199WWPNotificationTitle ;
   private String[] P00082_A200WWPNotificationShortDescriptio ;
   private String[] P00082_A201WWPNotificationLink ;
   private java.util.Date[] P00082_A40WWPNotificationCreated ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> Gxm2rootcol ;
   private com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem Gxm1wwp_sdtnotificationsdata ;
}

final  class wwp_getnotificationsforuser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00082", "SELECT [WWPNotificationIsRead], [WWPUserExtendedId], [WWPNotificationId], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationCreated] FROM [WWP_Notification] WHERE (Not [WWPNotificationIsRead] = 1) AND ([WWPUserExtendedId] = ?) ORDER BY [WWPNotificationCreated] DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((long[]) buf[3])[0] = rslt.getLong(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(8, true);
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
               stmt.setString(1, (String)parms[0], 40);
               return;
      }
   }

}

