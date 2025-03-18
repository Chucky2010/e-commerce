package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamisauthbyfunctionalitykey extends GXProcedure
{
   public gamisauthbyfunctionalitykey( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamisauthbyfunctionalitykey.class ), "" );
   }

   public gamisauthbyfunctionalitykey( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      gamisauthbyfunctionalitykey.this.aP1 = new boolean[] {false};
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
      gamisauthbyfunctionalitykey.this.AV8FunctionalityKey = aP0;
      gamisauthbyfunctionalitykey.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8FunctionalityKey, "<Check_Is_Authenticated>") == 0 )
      {
         GXv_objcol_SdtGAMError1[0] = AV9GAMErrors ;
         AV10IsAuthorized = (boolean)(!(new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context).isanonymoususer(GXv_objcol_SdtGAMError1))) ;
         AV9GAMErrors = GXv_objcol_SdtGAMError1[0] ;
      }
      else
      {
         AV10IsAuthorized = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).checkpermission(AV8FunctionalityKey) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamisauthbyfunctionalitykey.this.AV10IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9GAMErrors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV10IsAuthorized ;
   private String AV8FunctionalityKey ;
   private boolean[] aP1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV9GAMErrors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
}

