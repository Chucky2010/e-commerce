package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_export_securetext extends GXProcedure
{
   public wwp_export_securetext( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_export_securetext.class ), "" );
   }

   public wwp_export_securetext( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      wwp_export_securetext.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      wwp_export_securetext.this.AV8Text = aP0;
      wwp_export_securetext.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9SecureText = AV8Text ;
      if ( GXutil.strcmp(AV9SecureText, "<#Empty#>") == 0 )
      {
         AV9SecureText = httpContext.getMessage( "WWP_TitleFilter_EmptyOption", "") ;
      }
      if ( ( GXutil.len( AV9SecureText) > 0 ) && ( GXutil.startsWith( AV9SecureText, "=") || GXutil.startsWith( AV9SecureText, "+") || GXutil.startsWith( AV9SecureText, "-") || GXutil.startsWith( AV9SecureText, "@") ) )
      {
         AV9SecureText = "'" + AV9SecureText ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_export_securetext.this.AV9SecureText;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecureText = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8Text ;
   private String AV9SecureText ;
   private String[] aP1 ;
}

