package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenadmenuinfodp extends GXProcedure
{
   public mujermorenadmenuinfodp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenadmenuinfodp.class ), "" );
   }

   public mujermorenadmenuinfodp( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.SdtMenuInformation executeUdp( )
   {
      mujermorenadmenuinfodp.this.aP0 = new com.mujermorena.workwithplus.nativemobile.SdtMenuInformation[] {new com.mujermorena.workwithplus.nativemobile.SdtMenuInformation()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( com.mujermorena.workwithplus.nativemobile.SdtMenuInformation[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.mujermorena.workwithplus.nativemobile.SdtMenuInformation[] aP0 )
   {
      mujermorenadmenuinfodp.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1menuinformation.setgxTv_SdtMenuInformation_Titleinfo( new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getname() );
      Gxm1menuinformation.setgxTv_SdtMenuInformation_Secondaryinfo( new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getemail() );
      Gxm1menuinformation.setgxTv_SdtMenuInformation_Image( httpContext.convertURL( context.getHttpContext().getImagePath( "9b60406f-2e43-467c-92b6-b2d04aad0f71", "", context.getHttpContext().getTheme( ))) );
      Gxm1menuinformation.setgxTv_SdtMenuInformation_Infofield1( "Platinum" );
      Gxm1menuinformation.setgxTv_SdtMenuInformation_Infofield2( "2000" );
      Gxm1menuinformation.setgxTv_SdtMenuInformation_Infofieldnumeric1( DecimalUtil.doubleToDec(60) );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = mujermorenadmenuinfodp.this.Gxm1menuinformation;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm1menuinformation = new com.mujermorena.workwithplus.nativemobile.SdtMenuInformation(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuInformation[] aP0 ;
   private com.mujermorena.workwithplus.nativemobile.SdtMenuInformation Gxm1menuinformation ;
}

