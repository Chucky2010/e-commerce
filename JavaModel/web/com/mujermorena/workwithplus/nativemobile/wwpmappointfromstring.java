package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwpmappointfromstring extends GXProcedure
{
   public wwpmappointfromstring( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpmappointfromstring.class ), "" );
   }

   public wwpmappointfromstring( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXGeospatial executeUdp( String aP0 )
   {
      wwpmappointfromstring.this.aP1 = new GXGeospatial[] {new GXGeospatial()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXGeospatial[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXGeospatial[] aP1 )
   {
      wwpmappointfromstring.this.AV12SelectedItem = aP0;
      wwpmappointfromstring.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! GXutil.contains( AV12SelectedItem, "POINT") )
      {
         AV10Latitude = "-34" ;
         AV11Longitude = "-56" ;
         AV9ItemList = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV12SelectedItem,",")) ;
         if ( AV9ItemList.size() > 1 )
         {
            AV10Latitude = (String)AV9ItemList.elementAt(-1+1) ;
            AV11Longitude = (String)AV9ItemList.elementAt(-1+2) ;
         }
         AV8Geopoint = new GXGeospatial(GXutil.format( "POINT (%1 %2)", AV11Longitude, AV10Latitude, "", "", "", "", "", "", "")) ;
      }
      else
      {
         AV8Geopoint = new GXGeospatial(AV12SelectedItem) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwpmappointfromstring.this.AV8Geopoint;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Geopoint = new GXGeospatial() ;
      AV10Latitude = "" ;
      AV11Longitude = "" ;
      AV9ItemList = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV12SelectedItem ;
   private String AV10Latitude ;
   private String AV11Longitude ;
   private GXGeospatial AV8Geopoint ;
   private GXGeospatial[] aP1 ;
   private GXSimpleCollection<String> AV9ItemList ;
}

