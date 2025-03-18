package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_Circle extends GxUserType
{
   public SdtGxMap_Circle( )
   {
      this(  new ModelContext(SdtGxMap_Circle.class));
   }

   public SdtGxMap_Circle( ModelContext context )
   {
      super( context, "SdtGxMap_Circle");
   }

   public SdtGxMap_Circle( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_Circle");
   }

   public SdtGxMap_Circle( StructSdtGxMap_Circle struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Latitude") )
            {
               gxTv_SdtGxMap_Circle_Latitude = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Longitude") )
            {
               gxTv_SdtGxMap_Circle_Longitude = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Radius") )
            {
               gxTv_SdtGxMap_Circle_Radius = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CircleFill") )
            {
               gxTv_SdtGxMap_Circle_Circlefill = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CircleFillOpacity") )
            {
               gxTv_SdtGxMap_Circle_Circlefillopacity = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CircleStroke") )
            {
               gxTv_SdtGxMap_Circle_Circlestroke = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CircleStrokeOpacity") )
            {
               gxTv_SdtGxMap_Circle_Circlestrokeopacity = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CirclestrokeWeight") )
            {
               gxTv_SdtGxMap_Circle_Circlestrokeweight = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "GxMap.Circle" ;
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
      oWriter.writeElement("Latitude", gxTv_SdtGxMap_Circle_Latitude);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Longitude", gxTv_SdtGxMap_Circle_Longitude);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Radius", GXutil.trim( GXutil.str( gxTv_SdtGxMap_Circle_Radius, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CircleFill", gxTv_SdtGxMap_Circle_Circlefill);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CircleFillOpacity", GXutil.trim( GXutil.strNoRound( gxTv_SdtGxMap_Circle_Circlefillopacity, 3, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CircleStroke", gxTv_SdtGxMap_Circle_Circlestroke);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CircleStrokeOpacity", GXutil.trim( GXutil.strNoRound( gxTv_SdtGxMap_Circle_Circlestrokeopacity, 3, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CirclestrokeWeight", GXutil.trim( GXutil.str( gxTv_SdtGxMap_Circle_Circlestrokeweight, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
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
      AddObjectProperty("Latitude", gxTv_SdtGxMap_Circle_Latitude, false, false);
      AddObjectProperty("Longitude", gxTv_SdtGxMap_Circle_Longitude, false, false);
      AddObjectProperty("Radius", gxTv_SdtGxMap_Circle_Radius, false, false);
      AddObjectProperty("CircleFill", gxTv_SdtGxMap_Circle_Circlefill, false, false);
      AddObjectProperty("CircleFillOpacity", gxTv_SdtGxMap_Circle_Circlefillopacity, false, false);
      AddObjectProperty("CircleStroke", gxTv_SdtGxMap_Circle_Circlestroke, false, false);
      AddObjectProperty("CircleStrokeOpacity", gxTv_SdtGxMap_Circle_Circlestrokeopacity, false, false);
      AddObjectProperty("CirclestrokeWeight", gxTv_SdtGxMap_Circle_Circlestrokeweight, false, false);
   }

   public String getgxTv_SdtGxMap_Circle_Latitude( )
   {
      return gxTv_SdtGxMap_Circle_Latitude ;
   }

   public void setgxTv_SdtGxMap_Circle_Latitude( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Latitude = value ;
   }

   public String getgxTv_SdtGxMap_Circle_Longitude( )
   {
      return gxTv_SdtGxMap_Circle_Longitude ;
   }

   public void setgxTv_SdtGxMap_Circle_Longitude( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Longitude = value ;
   }

   public long getgxTv_SdtGxMap_Circle_Radius( )
   {
      return gxTv_SdtGxMap_Circle_Radius ;
   }

   public void setgxTv_SdtGxMap_Circle_Radius( long value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Radius = value ;
   }

   public String getgxTv_SdtGxMap_Circle_Circlefill( )
   {
      return gxTv_SdtGxMap_Circle_Circlefill ;
   }

   public void setgxTv_SdtGxMap_Circle_Circlefill( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlefill = value ;
   }

   public java.math.BigDecimal getgxTv_SdtGxMap_Circle_Circlefillopacity( )
   {
      return gxTv_SdtGxMap_Circle_Circlefillopacity ;
   }

   public void setgxTv_SdtGxMap_Circle_Circlefillopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlefillopacity = value ;
   }

   public String getgxTv_SdtGxMap_Circle_Circlestroke( )
   {
      return gxTv_SdtGxMap_Circle_Circlestroke ;
   }

   public void setgxTv_SdtGxMap_Circle_Circlestroke( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlestroke = value ;
   }

   public java.math.BigDecimal getgxTv_SdtGxMap_Circle_Circlestrokeopacity( )
   {
      return gxTv_SdtGxMap_Circle_Circlestrokeopacity ;
   }

   public void setgxTv_SdtGxMap_Circle_Circlestrokeopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlestrokeopacity = value ;
   }

   public short getgxTv_SdtGxMap_Circle_Circlestrokeweight( )
   {
      return gxTv_SdtGxMap_Circle_Circlestrokeweight ;
   }

   public void setgxTv_SdtGxMap_Circle_Circlestrokeweight( short value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlestrokeweight = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Circle_Latitude = "" ;
      gxTv_SdtGxMap_Circle_N = (byte)(1) ;
      gxTv_SdtGxMap_Circle_Longitude = "" ;
      gxTv_SdtGxMap_Circle_Circlefill = "" ;
      gxTv_SdtGxMap_Circle_Circlefillopacity = DecimalUtil.ZERO ;
      gxTv_SdtGxMap_Circle_Circlestroke = "" ;
      gxTv_SdtGxMap_Circle_Circlestrokeopacity = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_Circle_N ;
   }

   public com.mujermorena.SdtGxMap_Circle Clone( )
   {
      return (com.mujermorena.SdtGxMap_Circle)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_Circle struct )
   {
      setgxTv_SdtGxMap_Circle_Latitude(struct.getLatitude());
      setgxTv_SdtGxMap_Circle_Longitude(struct.getLongitude());
      setgxTv_SdtGxMap_Circle_Radius(struct.getRadius());
      setgxTv_SdtGxMap_Circle_Circlefill(struct.getCirclefill());
      setgxTv_SdtGxMap_Circle_Circlefillopacity(struct.getCirclefillopacity());
      setgxTv_SdtGxMap_Circle_Circlestroke(struct.getCirclestroke());
      setgxTv_SdtGxMap_Circle_Circlestrokeopacity(struct.getCirclestrokeopacity());
      setgxTv_SdtGxMap_Circle_Circlestrokeweight(struct.getCirclestrokeweight());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_Circle getStruct( )
   {
      com.mujermorena.StructSdtGxMap_Circle struct = new com.mujermorena.StructSdtGxMap_Circle ();
      struct.setLatitude(getgxTv_SdtGxMap_Circle_Latitude());
      struct.setLongitude(getgxTv_SdtGxMap_Circle_Longitude());
      struct.setRadius(getgxTv_SdtGxMap_Circle_Radius());
      struct.setCirclefill(getgxTv_SdtGxMap_Circle_Circlefill());
      struct.setCirclefillopacity(getgxTv_SdtGxMap_Circle_Circlefillopacity());
      struct.setCirclestroke(getgxTv_SdtGxMap_Circle_Circlestroke());
      struct.setCirclestrokeopacity(getgxTv_SdtGxMap_Circle_Circlestrokeopacity());
      struct.setCirclestrokeweight(getgxTv_SdtGxMap_Circle_Circlestrokeweight());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_Circle_N ;
   protected short gxTv_SdtGxMap_Circle_Circlestrokeweight ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtGxMap_Circle_Radius ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Circle_Circlefillopacity ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Circle_Circlestrokeopacity ;
   protected String gxTv_SdtGxMap_Circle_Latitude ;
   protected String gxTv_SdtGxMap_Circle_Longitude ;
   protected String gxTv_SdtGxMap_Circle_Circlefill ;
   protected String gxTv_SdtGxMap_Circle_Circlestroke ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

