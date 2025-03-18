package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_RoutePoint extends GxUserType
{
   public SdtGxMap_RoutePoint( )
   {
      this(  new ModelContext(SdtGxMap_RoutePoint.class));
   }

   public SdtGxMap_RoutePoint( ModelContext context )
   {
      super( context, "SdtGxMap_RoutePoint");
   }

   public SdtGxMap_RoutePoint( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_RoutePoint");
   }

   public SdtGxMap_RoutePoint( StructSdtGxMap_RoutePoint struct )
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
               gxTv_SdtGxMap_RoutePoint_Latitude = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Longitude") )
            {
               gxTv_SdtGxMap_RoutePoint_Longitude = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Pin") )
            {
               gxTv_SdtGxMap_RoutePoint_Pin = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtGxMap_RoutePoint_Description = oReader.getValue() ;
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
         sName = "GxMap.RoutePoint" ;
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
      oWriter.writeElement("Latitude", gxTv_SdtGxMap_RoutePoint_Latitude);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Longitude", gxTv_SdtGxMap_RoutePoint_Longitude);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Pin", gxTv_SdtGxMap_RoutePoint_Pin);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Description", gxTv_SdtGxMap_RoutePoint_Description);
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
      AddObjectProperty("Latitude", gxTv_SdtGxMap_RoutePoint_Latitude, false, false);
      AddObjectProperty("Longitude", gxTv_SdtGxMap_RoutePoint_Longitude, false, false);
      AddObjectProperty("Pin", gxTv_SdtGxMap_RoutePoint_Pin, false, false);
      AddObjectProperty("Description", gxTv_SdtGxMap_RoutePoint_Description, false, false);
   }

   public String getgxTv_SdtGxMap_RoutePoint_Latitude( )
   {
      return gxTv_SdtGxMap_RoutePoint_Latitude ;
   }

   public void setgxTv_SdtGxMap_RoutePoint_Latitude( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Latitude = value ;
   }

   public String getgxTv_SdtGxMap_RoutePoint_Longitude( )
   {
      return gxTv_SdtGxMap_RoutePoint_Longitude ;
   }

   public void setgxTv_SdtGxMap_RoutePoint_Longitude( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Longitude = value ;
   }

   public String getgxTv_SdtGxMap_RoutePoint_Pin( )
   {
      return gxTv_SdtGxMap_RoutePoint_Pin ;
   }

   public void setgxTv_SdtGxMap_RoutePoint_Pin( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Pin = value ;
   }

   public String getgxTv_SdtGxMap_RoutePoint_Description( )
   {
      return gxTv_SdtGxMap_RoutePoint_Description ;
   }

   public void setgxTv_SdtGxMap_RoutePoint_Description( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Description = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_RoutePoint_Latitude = "" ;
      gxTv_SdtGxMap_RoutePoint_N = (byte)(1) ;
      gxTv_SdtGxMap_RoutePoint_Longitude = "" ;
      gxTv_SdtGxMap_RoutePoint_Pin = "" ;
      gxTv_SdtGxMap_RoutePoint_Description = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_RoutePoint_N ;
   }

   public com.mujermorena.SdtGxMap_RoutePoint Clone( )
   {
      return (com.mujermorena.SdtGxMap_RoutePoint)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_RoutePoint struct )
   {
      setgxTv_SdtGxMap_RoutePoint_Latitude(struct.getLatitude());
      setgxTv_SdtGxMap_RoutePoint_Longitude(struct.getLongitude());
      setgxTv_SdtGxMap_RoutePoint_Pin(struct.getPin());
      setgxTv_SdtGxMap_RoutePoint_Description(struct.getDescription());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_RoutePoint getStruct( )
   {
      com.mujermorena.StructSdtGxMap_RoutePoint struct = new com.mujermorena.StructSdtGxMap_RoutePoint ();
      struct.setLatitude(getgxTv_SdtGxMap_RoutePoint_Latitude());
      struct.setLongitude(getgxTv_SdtGxMap_RoutePoint_Longitude());
      struct.setPin(getgxTv_SdtGxMap_RoutePoint_Pin());
      struct.setDescription(getgxTv_SdtGxMap_RoutePoint_Description());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_RoutePoint_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGxMap_RoutePoint_Latitude ;
   protected String gxTv_SdtGxMap_RoutePoint_Longitude ;
   protected String gxTv_SdtGxMap_RoutePoint_Pin ;
   protected String gxTv_SdtGxMap_RoutePoint_Description ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

