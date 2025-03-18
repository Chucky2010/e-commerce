package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGxMap_Point extends GxUserType
{
   public SdtGxMap_Point( )
   {
      this(  new ModelContext(SdtGxMap_Point.class));
   }

   public SdtGxMap_Point( ModelContext context )
   {
      super( context, "SdtGxMap_Point");
   }

   public SdtGxMap_Point( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtGxMap_Point");
   }

   public SdtGxMap_Point( StructSdtGxMap_Point struct )
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
               gxTv_SdtGxMap_Point_Pointlat = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointLong") )
            {
               gxTv_SdtGxMap_Point_Pointlong = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointIcon") )
            {
               gxTv_SdtGxMap_Point_Pointicon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointDraggable") )
            {
               gxTv_SdtGxMap_Point_Pointdraggable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointFlat") )
            {
               gxTv_SdtGxMap_Point_Pointflat = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointClickeable") )
            {
               gxTv_SdtGxMap_Point_Pointclickeable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointDeletable") )
            {
               gxTv_SdtGxMap_Point_Pointdeletable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointVisible") )
            {
               gxTv_SdtGxMap_Point_Pointvisible = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointInfowinHtml") )
            {
               gxTv_SdtGxMap_Point_Pointinfowinhtml = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointStreet") )
            {
               gxTv_SdtGxMap_Point_Pointstreet = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointStreetNumber") )
            {
               gxTv_SdtGxMap_Point_Pointstreetnumber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointCrossStreet") )
            {
               gxTv_SdtGxMap_Point_Pointcrossstreet = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointInfowinTit") )
            {
               gxTv_SdtGxMap_Point_Pointinfowintit = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointInfowinDesc") )
            {
               gxTv_SdtGxMap_Point_Pointinfowindesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointInfowinLink") )
            {
               gxTv_SdtGxMap_Point_Pointinfowinlink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointInfowinLinkDsc") )
            {
               gxTv_SdtGxMap_Point_Pointinfowinlinkdsc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PointInfowinImg") )
            {
               gxTv_SdtGxMap_Point_Pointinfowinimg = oReader.getValue() ;
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
         sName = "GxMap.Point" ;
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
      oWriter.writeElement("PointLat", gxTv_SdtGxMap_Point_Pointlat);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointLong", gxTv_SdtGxMap_Point_Pointlong);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointIcon", gxTv_SdtGxMap_Point_Pointicon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointDraggable", GXutil.booltostr( gxTv_SdtGxMap_Point_Pointdraggable));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointFlat", GXutil.booltostr( gxTv_SdtGxMap_Point_Pointflat));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointClickeable", GXutil.booltostr( gxTv_SdtGxMap_Point_Pointclickeable));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointDeletable", GXutil.booltostr( gxTv_SdtGxMap_Point_Pointdeletable));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointVisible", GXutil.booltostr( gxTv_SdtGxMap_Point_Pointvisible));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointInfowinHtml", gxTv_SdtGxMap_Point_Pointinfowinhtml);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointStreet", gxTv_SdtGxMap_Point_Pointstreet);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointStreetNumber", gxTv_SdtGxMap_Point_Pointstreetnumber);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointCrossStreet", gxTv_SdtGxMap_Point_Pointcrossstreet);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointInfowinTit", gxTv_SdtGxMap_Point_Pointinfowintit);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointInfowinDesc", gxTv_SdtGxMap_Point_Pointinfowindesc);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointInfowinLink", gxTv_SdtGxMap_Point_Pointinfowinlink);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointInfowinLinkDsc", gxTv_SdtGxMap_Point_Pointinfowinlinkdsc);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PointInfowinImg", gxTv_SdtGxMap_Point_Pointinfowinimg);
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
      AddObjectProperty("PointLat", gxTv_SdtGxMap_Point_Pointlat, false, false);
      AddObjectProperty("PointLong", gxTv_SdtGxMap_Point_Pointlong, false, false);
      AddObjectProperty("PointIcon", gxTv_SdtGxMap_Point_Pointicon, false, false);
      AddObjectProperty("PointDraggable", gxTv_SdtGxMap_Point_Pointdraggable, false, false);
      AddObjectProperty("PointFlat", gxTv_SdtGxMap_Point_Pointflat, false, false);
      AddObjectProperty("PointClickeable", gxTv_SdtGxMap_Point_Pointclickeable, false, false);
      AddObjectProperty("PointDeletable", gxTv_SdtGxMap_Point_Pointdeletable, false, false);
      AddObjectProperty("PointVisible", gxTv_SdtGxMap_Point_Pointvisible, false, false);
      AddObjectProperty("PointInfowinHtml", gxTv_SdtGxMap_Point_Pointinfowinhtml, false, false);
      AddObjectProperty("PointStreet", gxTv_SdtGxMap_Point_Pointstreet, false, false);
      AddObjectProperty("PointStreetNumber", gxTv_SdtGxMap_Point_Pointstreetnumber, false, false);
      AddObjectProperty("PointCrossStreet", gxTv_SdtGxMap_Point_Pointcrossstreet, false, false);
      AddObjectProperty("PointInfowinTit", gxTv_SdtGxMap_Point_Pointinfowintit, false, false);
      AddObjectProperty("PointInfowinDesc", gxTv_SdtGxMap_Point_Pointinfowindesc, false, false);
      AddObjectProperty("PointInfowinLink", gxTv_SdtGxMap_Point_Pointinfowinlink, false, false);
      AddObjectProperty("PointInfowinLinkDsc", gxTv_SdtGxMap_Point_Pointinfowinlinkdsc, false, false);
      AddObjectProperty("PointInfowinImg", gxTv_SdtGxMap_Point_Pointinfowinimg, false, false);
   }

   public String getgxTv_SdtGxMap_Point_Pointlat( )
   {
      return gxTv_SdtGxMap_Point_Pointlat ;
   }

   public void setgxTv_SdtGxMap_Point_Pointlat( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointlat = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointlong( )
   {
      return gxTv_SdtGxMap_Point_Pointlong ;
   }

   public void setgxTv_SdtGxMap_Point_Pointlong( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointlong = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointicon( )
   {
      return gxTv_SdtGxMap_Point_Pointicon ;
   }

   public void setgxTv_SdtGxMap_Point_Pointicon( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointicon = value ;
   }

   public boolean getgxTv_SdtGxMap_Point_Pointdraggable( )
   {
      return gxTv_SdtGxMap_Point_Pointdraggable ;
   }

   public void setgxTv_SdtGxMap_Point_Pointdraggable( boolean value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointdraggable = value ;
   }

   public boolean getgxTv_SdtGxMap_Point_Pointflat( )
   {
      return gxTv_SdtGxMap_Point_Pointflat ;
   }

   public void setgxTv_SdtGxMap_Point_Pointflat( boolean value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointflat = value ;
   }

   public boolean getgxTv_SdtGxMap_Point_Pointclickeable( )
   {
      return gxTv_SdtGxMap_Point_Pointclickeable ;
   }

   public void setgxTv_SdtGxMap_Point_Pointclickeable( boolean value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointclickeable = value ;
   }

   public boolean getgxTv_SdtGxMap_Point_Pointdeletable( )
   {
      return gxTv_SdtGxMap_Point_Pointdeletable ;
   }

   public void setgxTv_SdtGxMap_Point_Pointdeletable( boolean value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointdeletable = value ;
   }

   public boolean getgxTv_SdtGxMap_Point_Pointvisible( )
   {
      return gxTv_SdtGxMap_Point_Pointvisible ;
   }

   public void setgxTv_SdtGxMap_Point_Pointvisible( boolean value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointvisible = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointinfowinhtml( )
   {
      return gxTv_SdtGxMap_Point_Pointinfowinhtml ;
   }

   public void setgxTv_SdtGxMap_Point_Pointinfowinhtml( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointinfowinhtml = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointstreet( )
   {
      return gxTv_SdtGxMap_Point_Pointstreet ;
   }

   public void setgxTv_SdtGxMap_Point_Pointstreet( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointstreet = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointstreetnumber( )
   {
      return gxTv_SdtGxMap_Point_Pointstreetnumber ;
   }

   public void setgxTv_SdtGxMap_Point_Pointstreetnumber( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointstreetnumber = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointcrossstreet( )
   {
      return gxTv_SdtGxMap_Point_Pointcrossstreet ;
   }

   public void setgxTv_SdtGxMap_Point_Pointcrossstreet( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointcrossstreet = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointinfowintit( )
   {
      return gxTv_SdtGxMap_Point_Pointinfowintit ;
   }

   public void setgxTv_SdtGxMap_Point_Pointinfowintit( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointinfowintit = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointinfowindesc( )
   {
      return gxTv_SdtGxMap_Point_Pointinfowindesc ;
   }

   public void setgxTv_SdtGxMap_Point_Pointinfowindesc( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointinfowindesc = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointinfowinlink( )
   {
      return gxTv_SdtGxMap_Point_Pointinfowinlink ;
   }

   public void setgxTv_SdtGxMap_Point_Pointinfowinlink( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointinfowinlink = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointinfowinlinkdsc( )
   {
      return gxTv_SdtGxMap_Point_Pointinfowinlinkdsc ;
   }

   public void setgxTv_SdtGxMap_Point_Pointinfowinlinkdsc( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointinfowinlinkdsc = value ;
   }

   public String getgxTv_SdtGxMap_Point_Pointinfowinimg( )
   {
      return gxTv_SdtGxMap_Point_Pointinfowinimg ;
   }

   public void setgxTv_SdtGxMap_Point_Pointinfowinimg( String value )
   {
      gxTv_SdtGxMap_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Point_Pointinfowinimg = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGxMap_Point_Pointlat = "" ;
      gxTv_SdtGxMap_Point_N = (byte)(1) ;
      gxTv_SdtGxMap_Point_Pointlong = "" ;
      gxTv_SdtGxMap_Point_Pointicon = "" ;
      gxTv_SdtGxMap_Point_Pointdraggable = false ;
      gxTv_SdtGxMap_Point_Pointflat = false ;
      gxTv_SdtGxMap_Point_Pointclickeable = true ;
      gxTv_SdtGxMap_Point_Pointvisible = true ;
      gxTv_SdtGxMap_Point_Pointinfowinhtml = "" ;
      gxTv_SdtGxMap_Point_Pointstreet = "" ;
      gxTv_SdtGxMap_Point_Pointstreetnumber = "" ;
      gxTv_SdtGxMap_Point_Pointcrossstreet = "" ;
      gxTv_SdtGxMap_Point_Pointinfowintit = "" ;
      gxTv_SdtGxMap_Point_Pointinfowindesc = "" ;
      gxTv_SdtGxMap_Point_Pointinfowinlink = "" ;
      gxTv_SdtGxMap_Point_Pointinfowinlinkdsc = "" ;
      gxTv_SdtGxMap_Point_Pointinfowinimg = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGxMap_Point_N ;
   }

   public com.mujermorena.SdtGxMap_Point Clone( )
   {
      return (com.mujermorena.SdtGxMap_Point)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGxMap_Point struct )
   {
      setgxTv_SdtGxMap_Point_Pointlat(struct.getPointlat());
      setgxTv_SdtGxMap_Point_Pointlong(struct.getPointlong());
      setgxTv_SdtGxMap_Point_Pointicon(struct.getPointicon());
      setgxTv_SdtGxMap_Point_Pointdraggable(struct.getPointdraggable());
      setgxTv_SdtGxMap_Point_Pointflat(struct.getPointflat());
      setgxTv_SdtGxMap_Point_Pointclickeable(struct.getPointclickeable());
      setgxTv_SdtGxMap_Point_Pointdeletable(struct.getPointdeletable());
      setgxTv_SdtGxMap_Point_Pointvisible(struct.getPointvisible());
      setgxTv_SdtGxMap_Point_Pointinfowinhtml(struct.getPointinfowinhtml());
      setgxTv_SdtGxMap_Point_Pointstreet(struct.getPointstreet());
      setgxTv_SdtGxMap_Point_Pointstreetnumber(struct.getPointstreetnumber());
      setgxTv_SdtGxMap_Point_Pointcrossstreet(struct.getPointcrossstreet());
      setgxTv_SdtGxMap_Point_Pointinfowintit(struct.getPointinfowintit());
      setgxTv_SdtGxMap_Point_Pointinfowindesc(struct.getPointinfowindesc());
      setgxTv_SdtGxMap_Point_Pointinfowinlink(struct.getPointinfowinlink());
      setgxTv_SdtGxMap_Point_Pointinfowinlinkdsc(struct.getPointinfowinlinkdsc());
      setgxTv_SdtGxMap_Point_Pointinfowinimg(struct.getPointinfowinimg());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGxMap_Point getStruct( )
   {
      com.mujermorena.StructSdtGxMap_Point struct = new com.mujermorena.StructSdtGxMap_Point ();
      struct.setPointlat(getgxTv_SdtGxMap_Point_Pointlat());
      struct.setPointlong(getgxTv_SdtGxMap_Point_Pointlong());
      struct.setPointicon(getgxTv_SdtGxMap_Point_Pointicon());
      struct.setPointdraggable(getgxTv_SdtGxMap_Point_Pointdraggable());
      struct.setPointflat(getgxTv_SdtGxMap_Point_Pointflat());
      struct.setPointclickeable(getgxTv_SdtGxMap_Point_Pointclickeable());
      struct.setPointdeletable(getgxTv_SdtGxMap_Point_Pointdeletable());
      struct.setPointvisible(getgxTv_SdtGxMap_Point_Pointvisible());
      struct.setPointinfowinhtml(getgxTv_SdtGxMap_Point_Pointinfowinhtml());
      struct.setPointstreet(getgxTv_SdtGxMap_Point_Pointstreet());
      struct.setPointstreetnumber(getgxTv_SdtGxMap_Point_Pointstreetnumber());
      struct.setPointcrossstreet(getgxTv_SdtGxMap_Point_Pointcrossstreet());
      struct.setPointinfowintit(getgxTv_SdtGxMap_Point_Pointinfowintit());
      struct.setPointinfowindesc(getgxTv_SdtGxMap_Point_Pointinfowindesc());
      struct.setPointinfowinlink(getgxTv_SdtGxMap_Point_Pointinfowinlink());
      struct.setPointinfowinlinkdsc(getgxTv_SdtGxMap_Point_Pointinfowinlinkdsc());
      struct.setPointinfowinimg(getgxTv_SdtGxMap_Point_Pointinfowinimg());
      return struct ;
   }

   protected byte gxTv_SdtGxMap_Point_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGxMap_Point_Pointlat ;
   protected String gxTv_SdtGxMap_Point_Pointlong ;
   protected String gxTv_SdtGxMap_Point_Pointicon ;
   protected String gxTv_SdtGxMap_Point_Pointstreet ;
   protected String gxTv_SdtGxMap_Point_Pointstreetnumber ;
   protected String gxTv_SdtGxMap_Point_Pointcrossstreet ;
   protected String gxTv_SdtGxMap_Point_Pointinfowintit ;
   protected String gxTv_SdtGxMap_Point_Pointinfowindesc ;
   protected String gxTv_SdtGxMap_Point_Pointinfowinlink ;
   protected String gxTv_SdtGxMap_Point_Pointinfowinlinkdsc ;
   protected String gxTv_SdtGxMap_Point_Pointinfowinimg ;
   protected String sTagName ;
   protected boolean gxTv_SdtGxMap_Point_Pointdraggable ;
   protected boolean gxTv_SdtGxMap_Point_Pointflat ;
   protected boolean gxTv_SdtGxMap_Point_Pointclickeable ;
   protected boolean gxTv_SdtGxMap_Point_Pointdeletable ;
   protected boolean gxTv_SdtGxMap_Point_Pointvisible ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGxMap_Point_Pointinfowinhtml ;
}

