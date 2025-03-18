package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class anotificationsregistrationhandler extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      anotificationsregistrationhandler pgm = new anotificationsregistrationhandler (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      byte aP0 = 0;
      String aP1 = "";
      String aP2 = "";
      String aP3 = "";

      try
      {
         aP0 = (byte) GXutil.lval( args[0]);
         aP1 = (String) args[1];
         aP2 = (String) args[2];
         aP3 = (String) args[3];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1, aP2, aP3);
   }

   public anotificationsregistrationhandler( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( anotificationsregistrationhandler.class ), "" );
   }

   public anotificationsregistrationhandler( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( byte aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      anotificationsregistrationhandler.this.AV11DeviceType = aP0;
      anotificationsregistrationhandler.this.AV8DeviceId = aP1;
      anotificationsregistrationhandler.this.AV10DeviceToken = aP2;
      anotificationsregistrationhandler.this.AV9DeviceName = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      System.out.println( GXutil.trim( AV10DeviceToken) );
      AV12GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV13UserName = AV12GAMUser.getgxTv_SdtGAMUser_Name() ;
      AV17GXLvl11 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P000D2 */
      pr_default.execute(0, new Object[] {AV9DeviceName, AV10DeviceToken, Byte.valueOf(AV11DeviceType), AV8DeviceId});
      if ( (pr_default.getStatus(0) != 101) )
      {
         AV17GXLvl11 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Devices");
      /* End optimized UPDATE. */
      if ( AV17GXLvl11 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Devices

         */
         A15DeviceType = AV11DeviceType ;
         A16DeviceId = AV8DeviceId ;
         A269DeviceToken = AV10DeviceToken ;
         A270DeviceName = AV9DeviceName ;
         /* Using cursor P000D3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A15DeviceType), A16DeviceId, A269DeviceToken, A270DeviceName});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Devices");
         if ( (pr_default.getStatus(1) == 1) )
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
      GXt_int1 = AV14UsuarioID ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.numeradorids(remoteHandle, context).execute( httpContext.getMessage( "Usuario", ""), GXv_int2) ;
      anotificationsregistrationhandler.this.GXt_int1 = GXv_int2[0] ;
      AV14UsuarioID = GXt_int1 ;
      AV18GXLvl34 = (byte)(0) ;
      /* Optimized UPDATE. */
      /* Using cursor P000D4 */
      pr_default.execute(2, new Object[] {AV8DeviceId, Byte.valueOf(AV11DeviceType), AV13UserName});
      if ( (pr_default.getStatus(2) != 101) )
      {
         AV18GXLvl34 = (byte)(1) ;
      }
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Usuario");
      /* End optimized UPDATE. */
      if ( AV18GXLvl34 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Usuario

         */
         A14UsuarioId = AV14UsuarioID ;
         A1PersonaId = 1 ;
         A271UsuarioNom = AV13UserName ;
         A15DeviceType = AV11DeviceType ;
         A16DeviceId = AV8DeviceId ;
         /* Using cursor P000D5 */
         pr_default.execute(3, new Object[] {Long.valueOf(A14UsuarioId), A271UsuarioNom, Long.valueOf(A1PersonaId), A16DeviceId, Byte.valueOf(A15DeviceType)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Usuario");
         if ( (pr_default.getStatus(3) == 1) )
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
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(notificationsregistrationhandler.class);
      return new com.mujermorena.GXcfg();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "anotificationsregistrationhandler");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV13UserName = "" ;
      A270DeviceName = "" ;
      A269DeviceToken = "" ;
      A16DeviceId = "" ;
      Gx_emsg = "" ;
      GXv_int2 = new long[1] ;
      A271UsuarioNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.anotificationsregistrationhandler__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11DeviceType ;
   private byte AV17GXLvl11 ;
   private byte A15DeviceType ;
   private byte AV18GXLvl34 ;
   private short Gx_err ;
   private int GX_INS51 ;
   private int GX_INS13 ;
   private long AV14UsuarioID ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A14UsuarioId ;
   private long A1PersonaId ;
   private String AV8DeviceId ;
   private String AV10DeviceToken ;
   private String AV9DeviceName ;
   private String AV13UserName ;
   private String A270DeviceName ;
   private String A269DeviceToken ;
   private String A16DeviceId ;
   private String Gx_emsg ;
   private String A271UsuarioNom ;
   private IDataStoreProvider pr_default ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV12GAMUser ;
}

final  class anotificationsregistrationhandler__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P000D2", "UPDATE [Devices] SET [DeviceName]=?, [DeviceToken]=?  WHERE [DeviceType] = ? and [DeviceId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000D3", "INSERT INTO [Devices]([DeviceType], [DeviceId], [DeviceToken], [DeviceName]) VALUES(?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000D4", "UPDATE [Usuario] SET [DeviceId]=?, [DeviceType]=?  WHERE [UsuarioNom] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P000D5", "INSERT INTO [Usuario]([UsuarioId], [UsuarioNom], [PersonaId], [DeviceId], [DeviceType]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 128);
               stmt.setString(2, (String)parms[1], 1000);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 128);
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 128);
               stmt.setString(3, (String)parms[2], 1000);
               stmt.setString(4, (String)parms[3], 128);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 128);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setString(4, (String)parms[3], 128);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
      }
   }

}

