package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamsdchangepassword_level_detail extends GXProcedure
{
   public gamsdchangepassword_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsdchangepassword_level_detail.class ), "" );
   }

   public gamsdchangepassword_level_detail( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt executeUdp( int aP0 )
   {
      gamsdchangepassword_level_detail.this.aP1 = new com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt[] {new com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt[] aP1 )
   {
      gamsdchangepassword_level_detail.this.AV15gxid = aP0;
      gamsdchangepassword_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV15gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         AV14isPasswordExpires = false ;
         AV10User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getusertochangepassword();
         if ( ! (GXutil.strcmp("", AV10User.getgxTv_SdtGAMUser_Name())==0) )
         {
            AV14isPasswordExpires = true ;
            AV5UserName = AV10User.getgxTv_SdtGAMUser_Name() ;
         }
         else
         {
            AV10User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
            if ( ! (GXutil.strcmp("", AV10User.getgxTv_SdtGAMUser_Name())==0) )
            {
               AV5UserName = AV10User.getgxTv_SdtGAMUser_Name() ;
            }
            else
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         Gxwebsession.setValue(Gxids+"gxvar_Username", AV5UserName);
         Gxwebsession.setValue(Gxids+"gxvar_Ispasswordexpires", GXutil.booltostr( AV14isPasswordExpires));
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV14isPasswordExpires = GXutil.boolval( Gxwebsession.getValue(Gxids+"gxvar_Ispasswordexpires")) ;
         AV5UserName = Gxwebsession.getValue(Gxids+"gxvar_Username") ;
      }
      AV18GXM1GAMSDChangePassword_Level_DetailSdt.setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username( AV5UserName );
      AV18GXM1GAMSDChangePassword_Level_DetailSdt.setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword( AV6UserPassword );
      AV18GXM1GAMSDChangePassword_Level_DetailSdt.setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew( AV7UserPasswordNew );
      AV18GXM1GAMSDChangePassword_Level_DetailSdt.setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf( AV8UserPasswordNewConf );
      AV18GXM1GAMSDChangePassword_Level_DetailSdt.setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires( AV14isPasswordExpires );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamsdchangepassword_level_detail.this.AV18GXM1GAMSDChangePassword_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18GXM1GAMSDChangePassword_Level_DetailSdt = new com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV10User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV5UserName = "" ;
      AV6UserPassword = "" ;
      AV7UserPasswordNew = "" ;
      AV8UserPasswordNewConf = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV15gxid ;
   private String Gxids ;
   private String AV6UserPassword ;
   private String AV7UserPasswordNew ;
   private String AV8UserPasswordNewConf ;
   private boolean AV14isPasswordExpires ;
   private boolean returnInSub ;
   private String AV5UserName ;
   private com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV10User ;
   private com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt AV18GXM1GAMSDChangePassword_Level_DetailSdt ;
}

