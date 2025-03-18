package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwpwebserversessionsetnum extends GXProcedure
{
   public wwpwebserversessionsetnum( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpwebserversessionsetnum.class ), "" );
   }

   public wwpwebserversessionsetnum( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal aP1 )
   {
      wwpwebserversessionsetnum.this.AV8ParameterKey = aP0;
      wwpwebserversessionsetnum.this.AV9ParameterValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10WebSession.setValue(AV8ParameterKey, GXutil.trim( GXutil.str( AV9ParameterValue, 8, 2)));
      cleanup();
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
      AV10WebSession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV9ParameterValue ;
   private String AV8ParameterKey ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
}

