package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class asdsendnotificacion extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      asdsendnotificacion pgm = new asdsendnotificacion (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public asdsendnotificacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( asdsendnotificacion.class ), "" );
   }

   public asdsendnotificacion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12EventName = httpContext.getMessage( "MujerMorena", "") ;
      AV10Event_ItemName = "p_propietarioci" ;
      AV11Event_ItemValue = "12569" ;
      AV14MensajeNotif = httpContext.getMessage( "Que su Pedido ha sido Confirmado", "") ;
      /* Using cursor P006M2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A269DeviceToken = P006M2_A269DeviceToken[0] ;
         A16DeviceId = P006M2_A16DeviceId[0] ;
         A15DeviceType = P006M2_A15DeviceType[0] ;
         AV8Event = (com.genexuscore.genexus.common.notifications.SdtEvent)new com.genexuscore.genexus.common.notifications.SdtEvent(remoteHandle, context);
         AV8Event.setgxTv_SdtEvent_Name( AV12EventName );
         AV9Event_Item.setgxTv_SdtEvent_Parameter_Name( AV10Event_ItemName );
         AV9Event_Item.setgxTv_SdtEvent_Parameter_Value( AV11Event_ItemValue );
         AV8Event.getgxTv_SdtEvent_Parameters().add(AV9Event_Item, 0);
         AV17TheNotification.getgxTv_SdtNotification_Title().setgxTv_SdtLocalizedText_Defaulttext( httpContext.getMessage( " Mujer Morena le informa", "") );
         AV17TheNotification.getgxTv_SdtNotification_Text().setgxTv_SdtLocalizedText_Defaulttext( AV14MensajeNotif );
         AV19TheNotificationDelivery.setgxTv_SdtDelivery_Expiration( 3000 );
         AV19TheNotificationDelivery.setgxTv_SdtDelivery_Priority( "Normal" );
         AV18TheNotificationConfiguration.setgxTv_SdtConfiguration_Applicationid( "MujerMorena" );
         GXv_objcol_SdtMessages_Message1[0] = AV15OutMessages ;
         GXv_boolean2[0] = AV13IsSuccessful ;
         new com.genexuscore.genexus.common.notifications.sendnotification(remoteHandle, context).execute( AV18TheNotificationConfiguration, A269DeviceToken, AV17TheNotification, AV19TheNotificationDelivery, GXv_objcol_SdtMessages_Message1, GXv_boolean2) ;
         AV15OutMessages = GXv_objcol_SdtMessages_Message1[0] ;
         asdsendnotificacion.this.AV13IsSuccessful = GXv_boolean2[0] ;
         System.out.println( AV23Pgmname+httpContext.getMessage( " :: OutMessages: ", "")+AV15OutMessages.toJSonString(false) );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(sdsendnotificacion.class);
      return new com.mujermorena.GXcfg();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12EventName = "" ;
      AV10Event_ItemName = "" ;
      AV11Event_ItemValue = "" ;
      AV14MensajeNotif = "" ;
      scmdbuf = "" ;
      P006M2_A269DeviceToken = new String[] {""} ;
      P006M2_A16DeviceId = new String[] {""} ;
      P006M2_A15DeviceType = new byte[1] ;
      A269DeviceToken = "" ;
      A16DeviceId = "" ;
      AV8Event = new com.genexuscore.genexus.common.notifications.SdtEvent(remoteHandle, context);
      AV9Event_Item = new com.genexuscore.genexus.common.notifications.SdtEvent_Parameter(remoteHandle, context);
      AV17TheNotification = new com.genexuscore.genexus.common.notifications.SdtNotification(remoteHandle, context);
      AV19TheNotificationDelivery = new com.genexuscore.genexus.common.notifications.SdtDelivery(remoteHandle, context);
      AV18TheNotificationConfiguration = new com.genexuscore.genexus.common.notifications.SdtConfiguration(remoteHandle, context);
      AV15OutMessages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV23Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.asdsendnotificacion__default(),
         new Object[] {
             new Object[] {
            P006M2_A269DeviceToken, P006M2_A16DeviceId, P006M2_A15DeviceType
            }
         }
      );
      AV23Pgmname = "ASDSendNotificacion" ;
      /* GeneXus formulas. */
      AV23Pgmname = "ASDSendNotificacion" ;
      Gx_err = (short)(0) ;
   }

   private byte A15DeviceType ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A269DeviceToken ;
   private String A16DeviceId ;
   private String AV23Pgmname ;
   private boolean AV13IsSuccessful ;
   private boolean GXv_boolean2[] ;
   private String AV12EventName ;
   private String AV10Event_ItemName ;
   private String AV11Event_ItemValue ;
   private String AV14MensajeNotif ;
   private com.genexuscore.genexus.common.notifications.SdtEvent_Parameter AV9Event_Item ;
   private com.genexuscore.genexus.common.notifications.SdtConfiguration AV18TheNotificationConfiguration ;
   private com.genexuscore.genexus.common.notifications.SdtDelivery AV19TheNotificationDelivery ;
   private IDataStoreProvider pr_default ;
   private String[] P006M2_A269DeviceToken ;
   private String[] P006M2_A16DeviceId ;
   private byte[] P006M2_A15DeviceType ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV15OutMessages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
   private com.genexuscore.genexus.common.notifications.SdtEvent AV8Event ;
   private com.genexuscore.genexus.common.notifications.SdtNotification AV17TheNotification ;
}

final  class asdsendnotificacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006M2", "SELECT [DeviceToken], [DeviceId], [DeviceType] FROM [Devices] ORDER BY [DeviceId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1000);
               ((String[]) buf[1])[0] = rslt.getString(2, 128);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

