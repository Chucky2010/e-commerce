package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secgamisauthbyfunctionalitykey extends GXProcedure
{
   public secgamisauthbyfunctionalitykey( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secgamisauthbyfunctionalitykey.class ), "" );
   }

   public secgamisauthbyfunctionalitykey( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      secgamisauthbyfunctionalitykey.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      secgamisauthbyfunctionalitykey.this.AV10SecGAMFunctionalityKey = aP0;
      secgamisauthbyfunctionalitykey.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV10SecGAMFunctionalityKey, "<Check_Is_Authenticated>") == 0 )
      {
         GXv_objcol_SdtGAMError1[0] = AV8GAMErrors ;
         AV9IsAuthorized = (boolean)(!(new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context).isanonymoususer(GXv_objcol_SdtGAMError1))) ;
         AV8GAMErrors = GXv_objcol_SdtGAMError1[0] ;
      }
      else
      {
         AV9IsAuthorized = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).checkpermission(AV10SecGAMFunctionalityKey) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = secgamisauthbyfunctionalitykey.this.AV9IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8GAMErrors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV9IsAuthorized ;
   private String AV10SecGAMFunctionalityKey ;
   private boolean[] aP1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV8GAMErrors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
}

