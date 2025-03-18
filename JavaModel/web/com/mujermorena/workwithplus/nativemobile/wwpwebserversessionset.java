package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwpwebserversessionset extends GXProcedure
{
   public wwpwebserversessionset( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpwebserversessionset.class ), "" );
   }

   public wwpwebserversessionset( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      wwpwebserversessionset.this.AV8ParameterKey = aP0;
      wwpwebserversessionset.this.AV9ParameterValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10WebSession.setValue(AV8ParameterKey, AV9ParameterValue);
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
   private String AV8ParameterKey ;
   private String AV9ParameterValue ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
}

