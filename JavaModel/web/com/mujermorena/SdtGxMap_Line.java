package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_Line extends GxUserType
{
   public SdtGxMap_Line( )
   {
      this(  new ModelContext(SdtGxMap_Line.class));
   }

   public SdtGxMap_Line( ModelContext context )
   {
      super( context, "SdtGxMap_Line");
   }

   public SdtGxMap_Line( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_Line");
   }

   public SdtGxMap_Line( StructSdtGxMap_Line struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LineStrokeColor") )
            {
               gxTv_SdtGxMap_Line_Linestrokecolor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LineStrokeOpacity") )
            {
               gxTv_SdtGxMap_Line_Linestrokeopacity = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LineStrokeWeight") )
            {
               gxTv_SdtGxMap_Line_Linestrokeweight = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Points") )
            {
               if ( gxTv_SdtGxMap_Line_Points == null )
               {
                  gxTv_SdtGxMap_Line_Points = new GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point>(com.mujermorena.SdtGxMap_Line_Point.class, "GxMap.Line.Point", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGxMap_Line_Points.readxmlcollection(oReader, "Points", "Point") ;
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
         sName = "GxMap.Line" ;
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
      oWriter.writeElement("LineStrokeColor", gxTv_SdtGxMap_Line_Linestrokecolor);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("LineStrokeOpacity", GXutil.trim( GXutil.strNoRound( gxTv_SdtGxMap_Line_Linestrokeopacity, 3, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("LineStrokeWeight", GXutil.trim( GXutil.str( gxTv_SdtGxMap_Line_Linestrokeweight, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( gxTv_SdtGxMap_Line_Points != null )
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
         gxTv_SdtGxMap_Line_Points.writexmlcollection(oWriter, "Points", sNameSpace1, "Point", sNameSpace1);
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
      AddObjectProperty("LineStrokeColor", gxTv_SdtGxMap_Line_Linestrokecolor, false, false);
      AddObjectProperty("LineStrokeOpacity", gxTv_SdtGxMap_Line_Linestrokeopacity, false, false);
      AddObjectProperty("LineStrokeWeight", gxTv_SdtGxMap_Line_Linestrokeweight, false, false);
      if ( gxTv_SdtGxMap_Line_Points != null )
      {
         AddObjectProperty("Points", gxTv_SdtGxMap_Line_Points, false, false);
      }
   }

   public String getgxTv_SdtGxMap_Line_Linestrokecolor( )
   {
      return gxTv_SdtGxMap_Line_Linestrokecolor ;
   }

   public void setgxTv_SdtGxMap_Line_Linestrokecolor( String value )
   {
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Linestrokecolor = value ;
   }

   public java.math.BigDecimal getgxTv_SdtGxMap_Line_Linestrokeopacity( )
   {
      return gxTv_SdtGxMap_Line_Linestrokeopacity ;
   }

   public void setgxTv_SdtGxMap_Line_Linestrokeopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Linestrokeopacity = value ;
   }

   public short getgxTv_SdtGxMap_Line_Linestrokeweight( )
   {
      return gxTv_SdtGxMap_Line_Linestrokeweight ;
   }

   public void setgxTv_SdtGxMap_Line_Linestrokeweight( short value )
   {
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Linestrokeweight = value ;
   }

   public GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point> getgxTv_SdtGxMap_Line_Points( )
   {
      if ( gxTv_SdtGxMap_Line_Points == null )
      {
         gxTv_SdtGxMap_Line_Points = new GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point>(com.mujermorena.SdtGxMap_Line_Point.class, "GxMap.Line.Point", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtGxMap_Line_Points_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      return gxTv_SdtGxMap_Line_Points ;
   }

   public void setgxTv_SdtGxMap_Line_Points( GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point> value )
   {
      gxTv_SdtGxMap_Line_Points_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Points = value ;
   }

   public void setgxTv_SdtGxMap_Line_Points_SetNull( )
   {
      gxTv_SdtGxMap_Line_Points_N = (byte)(1) ;
      gxTv_SdtGxMap_Line_Points = null ;
   }

   public boolean getgxTv_SdtGxMap_Line_Points_IsNull( )
   {
      if ( gxTv_SdtGxMap_Line_Points == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGxMap_Line_Points_N( )
   {
      return gxTv_SdtGxMap_Line_Points_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Line_Linestrokecolor = "" ;
      gxTv_SdtGxMap_Line_N = (byte)(1) ;
      gxTv_SdtGxMap_Line_Linestrokeopacity = DecimalUtil.ZERO ;
      gxTv_SdtGxMap_Line_Points_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_Line_N ;
   }

   public com.mujermorena.SdtGxMap_Line Clone( )
   {
      return (com.mujermorena.SdtGxMap_Line)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_Line struct )
   {
      setgxTv_SdtGxMap_Line_Linestrokecolor(struct.getLinestrokecolor());
      setgxTv_SdtGxMap_Line_Linestrokeopacity(struct.getLinestrokeopacity());
      setgxTv_SdtGxMap_Line_Linestrokeweight(struct.getLinestrokeweight());
      GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point> gxTv_SdtGxMap_Line_Points_aux = new GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point>(com.mujermorena.SdtGxMap_Line_Point.class, "GxMap.Line.Point", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.StructSdtGxMap_Line_Point> gxTv_SdtGxMap_Line_Points_aux1 = struct.getPoints();
      if (gxTv_SdtGxMap_Line_Points_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtGxMap_Line_Points_aux1.size(); i++)
         {
            gxTv_SdtGxMap_Line_Points_aux.add(new com.mujermorena.SdtGxMap_Line_Point(gxTv_SdtGxMap_Line_Points_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtGxMap_Line_Points(gxTv_SdtGxMap_Line_Points_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_Line getStruct( )
   {
      com.mujermorena.StructSdtGxMap_Line struct = new com.mujermorena.StructSdtGxMap_Line ();
      struct.setLinestrokecolor(getgxTv_SdtGxMap_Line_Linestrokecolor());
      struct.setLinestrokeopacity(getgxTv_SdtGxMap_Line_Linestrokeopacity());
      struct.setLinestrokeweight(getgxTv_SdtGxMap_Line_Linestrokeweight());
      struct.setPoints(getgxTv_SdtGxMap_Line_Points().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_Line_N ;
   protected byte gxTv_SdtGxMap_Line_Points_N ;
   protected short gxTv_SdtGxMap_Line_Linestrokeweight ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Line_Linestrokeopacity ;
   protected String gxTv_SdtGxMap_Line_Linestrokecolor ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point> gxTv_SdtGxMap_Line_Points_aux ;
   protected GXBaseCollection<com.mujermorena.SdtGxMap_Line_Point> gxTv_SdtGxMap_Line_Points=null ;
}

