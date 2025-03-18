package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_loadlanguageandtheme extends GXProcedure
{
   public wwp_loadlanguageandtheme( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_loadlanguageandtheme.class ), "" );
   }

   public wwp_loadlanguageandtheme( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String[] aP0 )
   {
      wwp_loadlanguageandtheme.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             boolean[] aP1 )
   {
      wwp_loadlanguageandtheme.this.aP0 = aP0;
      wwp_loadlanguageandtheme.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8RefreshNeeded = false ;
      if ( GXutil.strcmp(AV12WebSession.getValue("isLangLoaded"), "true") != 0 )
      {
         AV9BrowserLanguage = AV10Httprequest.getHeader("Accept-Language") ;
         if ( GXutil.like( AV9BrowserLanguage , GXutil.padr( "ES" , 40 , "%"),  ' ' ) )
         {
            AV11Language = "Spanish" ;
         }
         else if ( GXutil.like( AV9BrowserLanguage , GXutil.padr( "EN" , 40 , "%"),  ' ' ) )
         {
            AV11Language = "English" ;
         }
         else
         {
            AV11Language = "Spanish" ;
         }
         if ( setLanguage( AV11Language) != 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "The language is not available", ""));
         }
         else
         {
            AV12WebSession.setValue("isLangLoaded", "true");
         }
      }
      else
      {
         AV11Language = httpContext.getLanguage( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_loadlanguageandtheme.this.AV11Language;
      this.aP1[0] = wwp_loadlanguageandtheme.this.AV8RefreshNeeded;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Language = "" ;
      AV12WebSession = httpContext.getWebSession();
      AV9BrowserLanguage = "" ;
      AV10Httprequest = httpContext.getHttpRequest();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV8RefreshNeeded ;
   private String AV11Language ;
   private String AV9BrowserLanguage ;
   private com.genexus.internet.HttpRequest AV10Httprequest ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private boolean[] aP1 ;
   private String[] aP0 ;
}

