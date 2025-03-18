package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_Polygon_Path extends GxUserType
{
   public SdtGxMap_Polygon_Path( )
   {
      this(  new ModelContext(SdtGxMap_Polygon_Path.class));
   }

   public SdtGxMap_Polygon_Path( ModelContext context )
   {
      super( context, "SdtGxMap_Polygon_Path");
   }

   public SdtGxMap_Polygon_Path( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_Polygon_Path");
   }

   public SdtGxMap_Polygon_Path( StructSdtGxMap_Polygon_Path struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PathLat") )
            {
               gxTv_SdtGxMap_Polygon_Path_Pathlat = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PathLong") )
            {
               gxTv_SdtGxMap_Polygon_Path_Pathlong = oReader.getValue() ;
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
         sName = "GxMap.Polygon.Path" ;
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
      oWriter.writeElement("PathLat", gxTv_SdtGxMap_Polygon_Path_Pathlat);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PathLong", gxTv_SdtGxMap_Polygon_Path_Pathlong);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("PathLat", gxTv_SdtGxMap_Polygon_Path_Pathlat, false, false);
      AddObjectProperty("PathLong", gxTv_SdtGxMap_Polygon_Path_Pathlong, false, false);
   }

   public String getgxTv_SdtGxMap_Polygon_Path_Pathlat( )
   {
      return gxTv_SdtGxMap_Polygon_Path_Pathlat ;
   }

   public void setgxTv_SdtGxMap_Polygon_Path_Pathlat( String value )
   {
      gxTv_SdtGxMap_Polygon_Path_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Path_Pathlat = value ;
   }

   public String getgxTv_SdtGxMap_Polygon_Path_Pathlong( )
   {
      return gxTv_SdtGxMap_Polygon_Path_Pathlong ;
   }

   public void setgxTv_SdtGxMap_Polygon_Path_Pathlong( String value )
   {
      gxTv_SdtGxMap_Polygon_Path_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Path_Pathlong = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Polygon_Path_Pathlat = "" ;
      gxTv_SdtGxMap_Polygon_Path_N = (byte)(1) ;
      gxTv_SdtGxMap_Polygon_Path_Pathlong = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_Polygon_Path_N ;
   }

   public com.mujermorena.SdtGxMap_Polygon_Path Clone( )
   {
      return (com.mujermorena.SdtGxMap_Polygon_Path)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_Polygon_Path struct )
   {
      setgxTv_SdtGxMap_Polygon_Path_Pathlat(struct.getPathlat());
      setgxTv_SdtGxMap_Polygon_Path_Pathlong(struct.getPathlong());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_Polygon_Path getStruct( )
   {
      com.mujermorena.StructSdtGxMap_Polygon_Path struct = new com.mujermorena.StructSdtGxMap_Polygon_Path ();
      struct.setPathlat(getgxTv_SdtGxMap_Polygon_Path_Pathlat());
      struct.setPathlong(getgxTv_SdtGxMap_Polygon_Path_Pathlong());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_Polygon_Path_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGxMap_Polygon_Path_Pathlat ;
   protected String gxTv_SdtGxMap_Polygon_Path_Pathlong ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

