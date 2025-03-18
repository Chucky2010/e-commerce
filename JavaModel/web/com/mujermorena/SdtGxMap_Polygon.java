package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_Polygon extends GxUserType
{
   public SdtGxMap_Polygon( )
   {
      this(  new ModelContext(SdtGxMap_Polygon.class));
   }

   public SdtGxMap_Polygon( ModelContext context )
   {
      super( context, "SdtGxMap_Polygon");
   }

   public SdtGxMap_Polygon( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_Polygon");
   }

   public SdtGxMap_Polygon( StructSdtGxMap_Polygon struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PolygonFill") )
            {
               gxTv_SdtGxMap_Polygon_Polygonfill = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PolygonFillOpacity") )
            {
               gxTv_SdtGxMap_Polygon_Polygonfillopacity = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PolygonStroke") )
            {
               gxTv_SdtGxMap_Polygon_Polygonstroke = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PolygonStrokeOpacity") )
            {
               gxTv_SdtGxMap_Polygon_Polygonstrokeopacity = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PolygonStrokeWeight") )
            {
               gxTv_SdtGxMap_Polygon_Polygonstrokeweight = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PolygonInfowinHtml") )
            {
               gxTv_SdtGxMap_Polygon_Polygoninfowinhtml = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Paths") )
            {
               if ( gxTv_SdtGxMap_Polygon_Paths == null )
               {
                  gxTv_SdtGxMap_Polygon_Paths = new GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path>(com.mujermorena.SdtGxMap_Polygon_Path.class, "GxMap.Polygon.Path", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Polygon_Paths.readxmlcollection(oReader, "Paths", "Path") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Paths") )
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
         sName = "GxMap.Polygon" ;
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
      oWriter.writeElement("PolygonFill", gxTv_SdtGxMap_Polygon_Polygonfill);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PolygonFillOpacity", GXutil.trim( GXutil.strNoRound( gxTv_SdtGxMap_Polygon_Polygonfillopacity, 3, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PolygonStroke", gxTv_SdtGxMap_Polygon_Polygonstroke);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PolygonStrokeOpacity", GXutil.trim( GXutil.strNoRound( gxTv_SdtGxMap_Polygon_Polygonstrokeopacity, 3, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PolygonStrokeWeight", GXutil.trim( GXutil.str( gxTv_SdtGxMap_Polygon_Polygonstrokeweight, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PolygonInfowinHtml", gxTv_SdtGxMap_Polygon_Polygoninfowinhtml);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( gxTv_SdtGxMap_Polygon_Paths != null )
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
         gxTv_SdtGxMap_Polygon_Paths.writexmlcollection(oWriter, "Paths", sNameSpace1, "Path", sNameSpace1);
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
      AddObjectProperty("PolygonFill", gxTv_SdtGxMap_Polygon_Polygonfill, false, false);
      AddObjectProperty("PolygonFillOpacity", gxTv_SdtGxMap_Polygon_Polygonfillopacity, false, false);
      AddObjectProperty("PolygonStroke", gxTv_SdtGxMap_Polygon_Polygonstroke, false, false);
      AddObjectProperty("PolygonStrokeOpacity", gxTv_SdtGxMap_Polygon_Polygonstrokeopacity, false, false);
      AddObjectProperty("PolygonStrokeWeight", gxTv_SdtGxMap_Polygon_Polygonstrokeweight, false, false);
      AddObjectProperty("PolygonInfowinHtml", gxTv_SdtGxMap_Polygon_Polygoninfowinhtml, false, false);
      if ( gxTv_SdtGxMap_Polygon_Paths != null )
      {
         AddObjectProperty("Paths", gxTv_SdtGxMap_Polygon_Paths, false, false);
      }
   }

   public String getgxTv_SdtGxMap_Polygon_Polygonfill( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonfill ;
   }

   public void setgxTv_SdtGxMap_Polygon_Polygonfill( String value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonfill = value ;
   }

   public java.math.BigDecimal getgxTv_SdtGxMap_Polygon_Polygonfillopacity( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonfillopacity ;
   }

   public void setgxTv_SdtGxMap_Polygon_Polygonfillopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonfillopacity = value ;
   }

   public String getgxTv_SdtGxMap_Polygon_Polygonstroke( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonstroke ;
   }

   public void setgxTv_SdtGxMap_Polygon_Polygonstroke( String value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstroke = value ;
   }

   public java.math.BigDecimal getgxTv_SdtGxMap_Polygon_Polygonstrokeopacity( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonstrokeopacity ;
   }

   public void setgxTv_SdtGxMap_Polygon_Polygonstrokeopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstrokeopacity = value ;
   }

   public short getgxTv_SdtGxMap_Polygon_Polygonstrokeweight( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonstrokeweight ;
   }

   public void setgxTv_SdtGxMap_Polygon_Polygonstrokeweight( short value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstrokeweight = value ;
   }

   public String getgxTv_SdtGxMap_Polygon_Polygoninfowinhtml( )
   {
      return gxTv_SdtGxMap_Polygon_Polygoninfowinhtml ;
   }

   public void setgxTv_SdtGxMap_Polygon_Polygoninfowinhtml( String value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygoninfowinhtml = value ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path> getgxTv_SdtGxMap_Polygon_Paths( )
   {
      if ( gxTv_SdtGxMap_Polygon_Paths == null )
      {
         gxTv_SdtGxMap_Polygon_Paths = new GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path>(com.mujermorena.SdtGxMap_Polygon_Path.class, "GxMap.Polygon.Path", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Polygon_Paths_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      return gxTv_SdtGxMap_Polygon_Paths ;
   }

   public void setgxTv_SdtGxMap_Polygon_Paths( GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path> value )
   {
      gxTv_SdtGxMap_Polygon_Paths_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Paths = value ;
   }

   public void setgxTv_SdtGxMap_Polygon_Paths_SetNull( )
   {
      gxTv_SdtGxMap_Polygon_Paths_N = (byte)(1) ;
      gxTv_SdtGxMap_Polygon_Paths = null ;
   }

   public boolean getgxTv_SdtGxMap_Polygon_Paths_IsNull( )
   {
      if ( gxTv_SdtGxMap_Polygon_Paths == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Polygon_Paths_N( )
   {
      return gxTv_SdtGxMap_Polygon_Paths_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Polygon_Polygonfill = "" ;
      gxTv_SdtGxMap_Polygon_N = (byte)(1) ;
      gxTv_SdtGxMap_Polygon_Polygonfillopacity = DecimalUtil.ZERO ;
      gxTv_SdtGxMap_Polygon_Polygonstroke = "" ;
      gxTv_SdtGxMap_Polygon_Polygonstrokeopacity = DecimalUtil.ZERO ;
      gxTv_SdtGxMap_Polygon_Polygoninfowinhtml = "" ;
      gxTv_SdtGxMap_Polygon_Paths_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_Polygon_N ;
   }

   public com.mujermorena.SdtGxMap_Polygon Clone( )
   {
      return (com.mujermorena.SdtGxMap_Polygon)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_Polygon struct )
   {
      setgxTv_SdtGxMap_Polygon_Polygonfill(struct.getPolygonfill());
      setgxTv_SdtGxMap_Polygon_Polygonfillopacity(struct.getPolygonfillopacity());
      setgxTv_SdtGxMap_Polygon_Polygonstroke(struct.getPolygonstroke());
      setgxTv_SdtGxMap_Polygon_Polygonstrokeopacity(struct.getPolygonstrokeopacity());
      setgxTv_SdtGxMap_Polygon_Polygonstrokeweight(struct.getPolygonstrokeweight());
      setgxTv_SdtGxMap_Polygon_Polygoninfowinhtml(struct.getPolygoninfowinhtml());
      GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path> gxTv_SdtGxMap_Polygon_Paths_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path>(com.mujermorena.SdtGxMap_Polygon_Path.class, "GxMap.Polygon.Path", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_Polygon_Path> gxTv_SdtGxMap_Polygon_Paths_aux1 = struct.getPaths();
      if (gxTv_SdtGxMap_Polygon_Paths_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Polygon_Paths_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Polygon_Paths_aux.add(new com.mujermorena.SdtGxMap_Polygon_Path(gxTv_SdtGxMap_Polygon_Paths_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Polygon_Paths(gxTv_SdtGxMap_Polygon_Paths_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_Polygon getStruct( )
   {
      com.mujermorena.StructSdtGxMap_Polygon struct = new com.mujermorena.StructSdtGxMap_Polygon ();
      struct.setPolygonfill(getgxTv_SdtGxMap_Polygon_Polygonfill());
      struct.setPolygonfillopacity(getgxTv_SdtGxMap_Polygon_Polygonfillopacity());
      struct.setPolygonstroke(getgxTv_SdtGxMap_Polygon_Polygonstroke());
      struct.setPolygonstrokeopacity(getgxTv_SdtGxMap_Polygon_Polygonstrokeopacity());
      struct.setPolygonstrokeweight(getgxTv_SdtGxMap_Polygon_Polygonstrokeweight());
      struct.setPolygoninfowinhtml(getgxTv_SdtGxMap_Polygon_Polygoninfowinhtml());
      struct.setPaths(getgxTv_SdtGxMap_Polygon_Paths().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_Polygon_N ;
   protected byte gxTv_SdtGxMap_Polygon_Paths_N ;
   protected short gxTv_SdtGxMap_Polygon_Polygonstrokeweight ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Polygon_Polygonfillopacity ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Polygon_Polygonstrokeopacity ;
   protected String gxTv_SdtGxMap_Polygon_Polygonfill ;
   protected String gxTv_SdtGxMap_Polygon_Polygonstroke ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGxMap_Polygon_Polygoninfowinhtml ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path> gxTv_SdtGxMap_Polygon_Paths_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Polygon_Path> gxTv_SdtGxMap_Polygon_Paths=null ;
}

