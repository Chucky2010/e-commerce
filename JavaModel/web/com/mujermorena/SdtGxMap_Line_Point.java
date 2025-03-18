package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_Line_Point extends GxUserType
{
   public SdtGxMap_Line_Point( )
   {
      this(  new ModelContext(SdtGxMap_Line_Point.class));
   }

   public SdtGxMap_Line_Point( ModelContext context )
   {
      super( context, "SdtGxMap_Line_Point");
   }

   public SdtGxMap_Line_Point( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_Line_Point");
   }

   public SdtGxMap_Line_Point( StructSdtGxMap_Line_Point struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointLat") )
            {
               gxTv_SdtGxMap_Line_Point_Pointlat = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointLong") )
            {
               gxTv_SdtGxMap_Line_Point_Pointlong = oReader.getValue() ;
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
         sName = "GxMap.Line.Point" ;
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
      oWriter.writeElement("PointLat", gxTv_SdtGxMap_Line_Point_Pointlat);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointLong", gxTv_SdtGxMap_Line_Point_Pointlong);
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
      AddObjectProperty("PointLat", gxTv_SdtGxMap_Line_Point_Pointlat, false, false);
      AddObjectProperty("PointLong", gxTv_SdtGxMap_Line_Point_Pointlong, false, false);
   }

   public String getgxTv_SdtGxMap_Line_Point_Pointlat( )
   {
      return gxTv_SdtGxMap_Line_Point_Pointlat ;
   }

   public void setgxTv_SdtGxMap_Line_Point_Pointlat( String value )
   {
      gxTv_SdtGxMap_Line_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Point_Pointlat = value ;
   }

   public String getgxTv_SdtGxMap_Line_Point_Pointlong( )
   {
      return gxTv_SdtGxMap_Line_Point_Pointlong ;
   }

   public void setgxTv_SdtGxMap_Line_Point_Pointlong( String value )
   {
      gxTv_SdtGxMap_Line_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Point_Pointlong = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Line_Point_Pointlat = "" ;
      gxTv_SdtGxMap_Line_Point_N = (byte)(1) ;
      gxTv_SdtGxMap_Line_Point_Pointlong = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_Line_Point_N ;
   }

   public com.mujermorena.SdtGxMap_Line_Point Clone( )
   {
      return (com.mujermorena.SdtGxMap_Line_Point)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_Line_Point struct )
   {
      setgxTv_SdtGxMap_Line_Point_Pointlat(struct.getPointlat());
      setgxTv_SdtGxMap_Line_Point_Pointlong(struct.getPointlong());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_Line_Point getStruct( )
   {
      com.mujermorena.StructSdtGxMap_Line_Point struct = new com.mujermorena.StructSdtGxMap_Line_Point ();
      struct.setPointlat(getgxTv_SdtGxMap_Line_Point_Pointlat());
      struct.setPointlong(getgxTv_SdtGxMap_Line_Point_Pointlong());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_Line_Point_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGxMap_Line_Point_Pointlat ;
   protected String gxTv_SdtGxMap_Line_Point_Pointlong ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

