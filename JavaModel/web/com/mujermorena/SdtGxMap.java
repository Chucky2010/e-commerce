package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap extends GxUserType
{
   public SdtGxMap( )
   {
      this(  new ModelContext(SdtGxMap.class));
   }

   public SdtGxMap( ModelContext context )
   {
      super( context, "SdtGxMap");
   }

   public SdtGxMap( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap");
   }

   public SdtGxMap( StructSdtGxMap struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "MapType") )
            {
               gxTv_SdtGxMap_Maptype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MapZoom") )
            {
               gxTv_SdtGxMap_Mapzoom = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MapLatitude") )
            {
               gxTv_SdtGxMap_Maplatitude = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MapLongitude") )
            {
               gxTv_SdtGxMap_Maplongitude = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Circles") )
            {
               if ( gxTv_SdtGxMap_Circles == null )
               {
                  gxTv_SdtGxMap_Circles = new GXBaseCollection<com.mujermorena.SdtGxMap_Circle>(com.mujermorena.SdtGxMap_Circle.class, "GxMap.Circle", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Circles.readxmlcollection(oReader, "Circles", "Circle") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Circles") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Points") )
            {
               if ( gxTv_SdtGxMap_Points == null )
               {
                  gxTv_SdtGxMap_Points = new GXBaseCollection<com.mujermorena.SdtGxMap_Point>(com.mujermorena.SdtGxMap_Point.class, "GxMap.Point", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Points.readxmlcollection(oReader, "Points", "Point") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Points") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Polygons") )
            {
               if ( gxTv_SdtGxMap_Polygons == null )
               {
                  gxTv_SdtGxMap_Polygons = new GXBaseCollection<com.mujermorena.SdtGxMap_Polygon>(com.mujermorena.SdtGxMap_Polygon.class, "GxMap.Polygon", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Polygons.readxmlcollection(oReader, "Polygons", "Polygon") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Polygons") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Lines") )
            {
               if ( gxTv_SdtGxMap_Lines == null )
               {
                  gxTv_SdtGxMap_Lines = new GXBaseCollection<com.mujermorena.SdtGxMap_Line>(com.mujermorena.SdtGxMap_Line.class, "GxMap.Line", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Lines.readxmlcollection(oReader, "Lines", "Line") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Lines") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Routing") )
            {
               if ( gxTv_SdtGxMap_Routing == null )
               {
                  gxTv_SdtGxMap_Routing = new GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint>(com.mujermorena.SdtGxMap_RoutePoint.class, "GxMap.RoutePoint", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Routing.readxmlcollection(oReader, "Routing", "RoutePoint") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Routing") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "GxMap" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "Mujer_Morena" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("MapType", gxTv_SdtGxMap_Maptype);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MapZoom", GXutil.trim( GXutil.str( gxTv_SdtGxMap_Mapzoom, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MapLatitude", gxTv_SdtGxMap_Maplatitude);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MapLongitude", gxTv_SdtGxMap_Maplongitude);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( gxTv_SdtGxMap_Circles != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtGxMap_Circles.writexmlcollection(oWriter, "Circles", sNameSpace1, "Circle", sNameSpace1);
      }
      if ( gxTv_SdtGxMap_Points != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtGxMap_Points.writexmlcollection(oWriter, "Points", sNameSpace1, "Point", sNameSpace1);
      }
      if ( gxTv_SdtGxMap_Polygons != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtGxMap_Polygons.writexmlcollection(oWriter, "Polygons", sNameSpace1, "Polygon", sNameSpace1);
      }
      if ( gxTv_SdtGxMap_Lines != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtGxMap_Lines.writexmlcollection(oWriter, "Lines", sNameSpace1, "Line", sNameSpace1);
      }
      if ( gxTv_SdtGxMap_Routing != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtGxMap_Routing.writexmlcollection(oWriter, "Routing", sNameSpace1, "RoutePoint", sNameSpace1);
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("MapType", gxTv_SdtGxMap_Maptype, false, false);
      AddObjectProperty("MapZoom", gxTv_SdtGxMap_Mapzoom, false, false);
      AddObjectProperty("MapLatitude", gxTv_SdtGxMap_Maplatitude, false, false);
      AddObjectProperty("MapLongitude", gxTv_SdtGxMap_Maplongitude, false, false);
      if ( gxTv_SdtGxMap_Circles != null )
      {
         AddObjectProperty("Circles", gxTv_SdtGxMap_Circles, false, false);
      }
      if ( gxTv_SdtGxMap_Points != null )
      {
         AddObjectProperty("Points", gxTv_SdtGxMap_Points, false, false);
      }
      if ( gxTv_SdtGxMap_Polygons != null )
      {
         AddObjectProperty("Polygons", gxTv_SdtGxMap_Polygons, false, false);
      }
      if ( gxTv_SdtGxMap_Lines != null )
      {
         AddObjectProperty("Lines", gxTv_SdtGxMap_Lines, false, false);
      }
      if ( gxTv_SdtGxMap_Routing != null )
      {
         AddObjectProperty("Routing", gxTv_SdtGxMap_Routing, false, false);
      }
   }

   public String getgxTv_SdtGxMap_Maptype( )
   {
      return gxTv_SdtGxMap_Maptype ;
   }

   public void setgxTv_SdtGxMap_Maptype( String value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Maptype = value ;
   }

   public short getgxTv_SdtGxMap_Mapzoom( )
   {
      return gxTv_SdtGxMap_Mapzoom ;
   }

   public void setgxTv_SdtGxMap_Mapzoom( short value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Mapzoom = value ;
   }

   public String getgxTv_SdtGxMap_Maplatitude( )
   {
      return gxTv_SdtGxMap_Maplatitude ;
   }

   public void setgxTv_SdtGxMap_Maplatitude( String value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Maplatitude = value ;
   }

   public String getgxTv_SdtGxMap_Maplongitude( )
   {
      return gxTv_SdtGxMap_Maplongitude ;
   }

   public void setgxTv_SdtGxMap_Maplongitude( String value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Maplongitude = value ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_Circle> getgxTv_SdtGxMap_Circles( )
   {
      if ( gxTv_SdtGxMap_Circles == null )
      {
         gxTv_SdtGxMap_Circles = new GXBaseCollection<com.mujermorena.SdtGxMap_Circle>(com.mujermorena.SdtGxMap_Circle.class, "GxMap.Circle", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Circles_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      return gxTv_SdtGxMap_Circles ;
   }

   public void setgxTv_SdtGxMap_Circles( GXBaseCollection<com.mujermorena.SdtGxMap_Circle> value )
   {
      gxTv_SdtGxMap_Circles_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Circles = value ;
   }

   public void setgxTv_SdtGxMap_Circles_SetNull( )
   {
      gxTv_SdtGxMap_Circles_N = (byte)(1) ;
      gxTv_SdtGxMap_Circles = null ;
   }

   public boolean getgxTv_SdtGxMap_Circles_IsNull( )
   {
      if ( gxTv_SdtGxMap_Circles == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Circles_N( )
   {
      return gxTv_SdtGxMap_Circles_N ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_Point> getgxTv_SdtGxMap_Points( )
   {
      if ( gxTv_SdtGxMap_Points == null )
      {
         gxTv_SdtGxMap_Points = new GXBaseCollection<com.mujermorena.SdtGxMap_Point>(com.mujermorena.SdtGxMap_Point.class, "GxMap.Point", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Points_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      return gxTv_SdtGxMap_Points ;
   }

   public void setgxTv_SdtGxMap_Points( GXBaseCollection<com.mujermorena.SdtGxMap_Point> value )
   {
      gxTv_SdtGxMap_Points_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Points = value ;
   }

   public void setgxTv_SdtGxMap_Points_SetNull( )
   {
      gxTv_SdtGxMap_Points_N = (byte)(1) ;
      gxTv_SdtGxMap_Points = null ;
   }

   public boolean getgxTv_SdtGxMap_Points_IsNull( )
   {
      if ( gxTv_SdtGxMap_Points == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Points_N( )
   {
      return gxTv_SdtGxMap_Points_N ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_Polygon> getgxTv_SdtGxMap_Polygons( )
   {
      if ( gxTv_SdtGxMap_Polygons == null )
      {
         gxTv_SdtGxMap_Polygons = new GXBaseCollection<com.mujermorena.SdtGxMap_Polygon>(com.mujermorena.SdtGxMap_Polygon.class, "GxMap.Polygon", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Polygons_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      return gxTv_SdtGxMap_Polygons ;
   }

   public void setgxTv_SdtGxMap_Polygons( GXBaseCollection<com.mujermorena.SdtGxMap_Polygon> value )
   {
      gxTv_SdtGxMap_Polygons_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygons = value ;
   }

   public void setgxTv_SdtGxMap_Polygons_SetNull( )
   {
      gxTv_SdtGxMap_Polygons_N = (byte)(1) ;
      gxTv_SdtGxMap_Polygons = null ;
   }

   public boolean getgxTv_SdtGxMap_Polygons_IsNull( )
   {
      if ( gxTv_SdtGxMap_Polygons == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Polygons_N( )
   {
      return gxTv_SdtGxMap_Polygons_N ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_Line> getgxTv_SdtGxMap_Lines( )
   {
      if ( gxTv_SdtGxMap_Lines == null )
      {
         gxTv_SdtGxMap_Lines = new GXBaseCollection<com.mujermorena.SdtGxMap_Line>(com.mujermorena.SdtGxMap_Line.class, "GxMap.Line", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Lines_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      return gxTv_SdtGxMap_Lines ;
   }

   public void setgxTv_SdtGxMap_Lines( GXBaseCollection<com.mujermorena.SdtGxMap_Line> value )
   {
      gxTv_SdtGxMap_Lines_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Lines = value ;
   }

   public void setgxTv_SdtGxMap_Lines_SetNull( )
   {
      gxTv_SdtGxMap_Lines_N = (byte)(1) ;
      gxTv_SdtGxMap_Lines = null ;
   }

   public boolean getgxTv_SdtGxMap_Lines_IsNull( )
   {
      if ( gxTv_SdtGxMap_Lines == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Lines_N( )
   {
      return gxTv_SdtGxMap_Lines_N ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint> getgxTv_SdtGxMap_Routing( )
   {
      if ( gxTv_SdtGxMap_Routing == null )
      {
         gxTv_SdtGxMap_Routing = new GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint>(com.mujermorena.SdtGxMap_RoutePoint.class, "GxMap.RoutePoint", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Routing_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      return gxTv_SdtGxMap_Routing ;
   }

   public void setgxTv_SdtGxMap_Routing( GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint> value )
   {
      gxTv_SdtGxMap_Routing_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Routing = value ;
   }

   public void setgxTv_SdtGxMap_Routing_SetNull( )
   {
      gxTv_SdtGxMap_Routing_N = (byte)(1) ;
      gxTv_SdtGxMap_Routing = null ;
   }

   public boolean getgxTv_SdtGxMap_Routing_IsNull( )
   {
      if ( gxTv_SdtGxMap_Routing == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Routing_N( )
   {
      return gxTv_SdtGxMap_Routing_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Maptype = "" ;
      gxTv_SdtGxMap_N = (byte)(1) ;
      gxTv_SdtGxMap_Maplatitude = "" ;
      gxTv_SdtGxMap_Maplongitude = "" ;
      gxTv_SdtGxMap_Circles_N = (byte)(1) ;
      gxTv_SdtGxMap_Points_N = (byte)(1) ;
      gxTv_SdtGxMap_Polygons_N = (byte)(1) ;
      gxTv_SdtGxMap_Lines_N = (byte)(1) ;
      gxTv_SdtGxMap_Routing_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_N ;
   }

   public com.mujermorena.SdtGxMap Clone( )
   {
      return (com.mujermorena.SdtGxMap)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap struct )
   {
      setgxTv_SdtGxMap_Maptype(struct.getMaptype());
      setgxTv_SdtGxMap_Mapzoom(struct.getMapzoom());
      setgxTv_SdtGxMap_Maplatitude(struct.getMaplatitude());
      setgxTv_SdtGxMap_Maplongitude(struct.getMaplongitude());
      GXBaseCollection<com.mujermorena.SdtGxMap_Circle> gxTv_SdtGxMap_Circles_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_Circle>(com.mujermorena.SdtGxMap_Circle.class, "GxMap.Circle", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_Circle> gxTv_SdtGxMap_Circles_aux1 = struct.getCircles();
      if (gxTv_SdtGxMap_Circles_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Circles_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Circles_aux.add(new com.mujermorena.SdtGxMap_Circle(gxTv_SdtGxMap_Circles_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Circles(gxTv_SdtGxMap_Circles_aux);
      GXBaseCollection<com.mujermorena.SdtGxMap_Point> gxTv_SdtGxMap_Points_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_Point>(com.mujermorena.SdtGxMap_Point.class, "GxMap.Point", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_Point> gxTv_SdtGxMap_Points_aux1 = struct.getPoints();
      if (gxTv_SdtGxMap_Points_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Points_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Points_aux.add(new com.mujermorena.SdtGxMap_Point(gxTv_SdtGxMap_Points_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Points(gxTv_SdtGxMap_Points_aux);
      GXBaseCollection<com.mujermorena.SdtGxMap_Polygon> gxTv_SdtGxMap_Polygons_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_Polygon>(com.mujermorena.SdtGxMap_Polygon.class, "GxMap.Polygon", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_Polygon> gxTv_SdtGxMap_Polygons_aux1 = struct.getPolygons();
      if (gxTv_SdtGxMap_Polygons_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Polygons_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Polygons_aux.add(new com.mujermorena.SdtGxMap_Polygon(gxTv_SdtGxMap_Polygons_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Polygons(gxTv_SdtGxMap_Polygons_aux);
      GXBaseCollection<com.mujermorena.SdtGxMap_Line> gxTv_SdtGxMap_Lines_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_Line>(com.mujermorena.SdtGxMap_Line.class, "GxMap.Line", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_Line> gxTv_SdtGxMap_Lines_aux1 = struct.getLines();
      if (gxTv_SdtGxMap_Lines_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Lines_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Lines_aux.add(new com.mujermorena.SdtGxMap_Line(gxTv_SdtGxMap_Lines_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Lines(gxTv_SdtGxMap_Lines_aux);
      GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint> gxTv_SdtGxMap_Routing_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint>(com.mujermorena.SdtGxMap_RoutePoint.class, "GxMap.RoutePoint", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_RoutePoint> gxTv_SdtGxMap_Routing_aux1 = struct.getRouting();
      if (gxTv_SdtGxMap_Routing_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Routing_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Routing_aux.add(new com.mujermorena.SdtGxMap_RoutePoint(gxTv_SdtGxMap_Routing_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Routing(gxTv_SdtGxMap_Routing_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap getStruct( )
   {
      com.mujermorena.StructSdtGxMap struct = new com.mujermorena.StructSdtGxMap ();
      struct.setMaptype(getgxTv_SdtGxMap_Maptype());
      struct.setMapzoom(getgxTv_SdtGxMap_Mapzoom());
      struct.setMaplatitude(getgxTv_SdtGxMap_Maplatitude());
      struct.setMaplongitude(getgxTv_SdtGxMap_Maplongitude());
      struct.setCircles(getgxTv_SdtGxMap_Circles().getStruct());
      struct.setPoints(getgxTv_SdtGxMap_Points().getStruct());
      struct.setPolygons(getgxTv_SdtGxMap_Polygons().getStruct());
      struct.setLines(getgxTv_SdtGxMap_Lines().getStruct());
      struct.setRouting(getgxTv_SdtGxMap_Routing().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_N ;
   protected byte gxTv_SdtGxMap_Circles_N ;
   protected byte gxTv_SdtGxMap_Points_N ;
   protected byte gxTv_SdtGxMap_Polygons_N ;
   protected byte gxTv_SdtGxMap_Lines_N ;
   protected byte gxTv_SdtGxMap_Routing_N ;
   protected short gxTv_SdtGxMap_Mapzoom ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGxMap_Maptype ;
   protected String gxTv_SdtGxMap_Maplatitude ;
   protected String gxTv_SdtGxMap_Maplongitude ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Circle> gxTv_SdtGxMap_Circles_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Point> gxTv_SdtGxMap_Points_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Polygon> gxTv_SdtGxMap_Polygons_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Line> gxTv_SdtGxMap_Lines_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint> gxTv_SdtGxMap_Routing_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Circle> gxTv_SdtGxMap_Circles=null ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Point> gxTv_SdtGxMap_Points=null ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Polygon> gxTv_SdtGxMap_Polygons=null ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Line> gxTv_SdtGxMap_Lines=null ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_RoutePoint> gxTv_SdtGxMap_Routing=null ;
}

