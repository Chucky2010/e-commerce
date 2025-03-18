package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtRangedRadialGaugeConfig extends GxUserType
{
   public SdtRangedRadialGaugeConfig( )
   {
      this(  new ModelContext(SdtRangedRadialGaugeConfig.class));
   }

   public SdtRangedRadialGaugeConfig( ModelContext context )
   {
      super( context, "SdtRangedRadialGaugeConfig");
   }

   public SdtRangedRadialGaugeConfig( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtRangedRadialGaugeConfig");
   }

   public SdtRangedRadialGaugeConfig( StructSdtRangedRadialGaugeConfig struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Value = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Text") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Text = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Width") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Width = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Height") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Height = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range1ColorStart") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range1colorstart = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range1ColorEnd") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range1colorend = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range2ColorStart") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range2colorstart = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range2ColorEnd") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range2colorend = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range3ColorStart") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range3colorstart = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range3ColorEnd") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range3colorend = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range4ColorStart") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range4colorstart = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range4ColorEnd") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range4colorend = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range5ColorStart") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range5colorstart = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Range5ColorEnd") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Range5colorend = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValueMarkerColor") )
            {
               gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor = oReader.getValue() ;
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
         sName = "RangedRadialGaugeConfig" ;
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
      oWriter.writeElement("Value", GXutil.trim( GXutil.str( gxTv_SdtRangedRadialGaugeConfig_Value, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Text", gxTv_SdtRangedRadialGaugeConfig_Text);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Width", GXutil.trim( GXutil.str( gxTv_SdtRangedRadialGaugeConfig_Width, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Height", GXutil.trim( GXutil.str( gxTv_SdtRangedRadialGaugeConfig_Height, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range1ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range1colorstart);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range1ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range1colorend);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range2ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range2colorstart);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range2ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range2colorend);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range3ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range3colorstart);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range3ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range3colorend);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range4ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range4colorstart);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range4ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range4colorend);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range5ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range5colorstart);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Range5ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range5colorend);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ValueMarkerColor", gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor);
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
      AddObjectProperty("Value", gxTv_SdtRangedRadialGaugeConfig_Value, false, false);
      AddObjectProperty("Text", gxTv_SdtRangedRadialGaugeConfig_Text, false, false);
      AddObjectProperty("Width", gxTv_SdtRangedRadialGaugeConfig_Width, false, false);
      AddObjectProperty("Height", gxTv_SdtRangedRadialGaugeConfig_Height, false, false);
      AddObjectProperty("Range1ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range1colorstart, false, false);
      AddObjectProperty("Range1ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range1colorend, false, false);
      AddObjectProperty("Range2ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range2colorstart, false, false);
      AddObjectProperty("Range2ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range2colorend, false, false);
      AddObjectProperty("Range3ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range3colorstart, false, false);
      AddObjectProperty("Range3ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range3colorend, false, false);
      AddObjectProperty("Range4ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range4colorstart, false, false);
      AddObjectProperty("Range4ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range4colorend, false, false);
      AddObjectProperty("Range5ColorStart", gxTv_SdtRangedRadialGaugeConfig_Range5colorstart, false, false);
      AddObjectProperty("Range5ColorEnd", gxTv_SdtRangedRadialGaugeConfig_Range5colorend, false, false);
      AddObjectProperty("ValueMarkerColor", gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor, false, false);
   }

   public short getgxTv_SdtRangedRadialGaugeConfig_Value( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Value ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Value( short value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Value = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Text( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Text ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Text( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Text = value ;
   }

   public short getgxTv_SdtRangedRadialGaugeConfig_Width( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Width ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Width( short value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Width = value ;
   }

   public short getgxTv_SdtRangedRadialGaugeConfig_Height( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Height ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Height( short value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Height = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range1colorstart( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range1colorstart ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range1colorstart( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range1colorstart = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range1colorend( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range1colorend ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range1colorend( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range1colorend = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range2colorstart( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range2colorstart ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range2colorstart( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range2colorstart = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range2colorend( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range2colorend ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range2colorend( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range2colorend = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range3colorstart( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range3colorstart ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range3colorstart( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range3colorstart = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range3colorend( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range3colorend ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range3colorend( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range3colorend = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range4colorstart( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range4colorstart ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range4colorstart( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range4colorstart = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range4colorend( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range4colorend ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range4colorend( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range4colorend = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range5colorstart( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range5colorstart ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range5colorstart( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range5colorstart = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Range5colorend( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Range5colorend ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Range5colorend( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Range5colorend = value ;
   }

   public String getgxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor ;
   }

   public void setgxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor( String value )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(0) ;
      gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtRangedRadialGaugeConfig_N = (byte)(1) ;
      gxTv_SdtRangedRadialGaugeConfig_Text = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range1colorstart = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range1colorend = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range2colorstart = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range2colorend = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range3colorstart = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range3colorend = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range4colorstart = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range4colorend = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range5colorstart = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Range5colorend = "" ;
      gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtRangedRadialGaugeConfig_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtRangedRadialGaugeConfig struct )
   {
      setgxTv_SdtRangedRadialGaugeConfig_Value(struct.getValue());
      setgxTv_SdtRangedRadialGaugeConfig_Text(struct.getText());
      setgxTv_SdtRangedRadialGaugeConfig_Width(struct.getWidth());
      setgxTv_SdtRangedRadialGaugeConfig_Height(struct.getHeight());
      setgxTv_SdtRangedRadialGaugeConfig_Range1colorstart(struct.getRange1colorstart());
      setgxTv_SdtRangedRadialGaugeConfig_Range1colorend(struct.getRange1colorend());
      setgxTv_SdtRangedRadialGaugeConfig_Range2colorstart(struct.getRange2colorstart());
      setgxTv_SdtRangedRadialGaugeConfig_Range2colorend(struct.getRange2colorend());
      setgxTv_SdtRangedRadialGaugeConfig_Range3colorstart(struct.getRange3colorstart());
      setgxTv_SdtRangedRadialGaugeConfig_Range3colorend(struct.getRange3colorend());
      setgxTv_SdtRangedRadialGaugeConfig_Range4colorstart(struct.getRange4colorstart());
      setgxTv_SdtRangedRadialGaugeConfig_Range4colorend(struct.getRange4colorend());
      setgxTv_SdtRangedRadialGaugeConfig_Range5colorstart(struct.getRange5colorstart());
      setgxTv_SdtRangedRadialGaugeConfig_Range5colorend(struct.getRange5colorend());
      setgxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor(struct.getValuemarkercolor());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtRangedRadialGaugeConfig getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtRangedRadialGaugeConfig struct = new com.mujermorena.workwithplus.nativemobile.StructSdtRangedRadialGaugeConfig ();
      struct.setValue(getgxTv_SdtRangedRadialGaugeConfig_Value());
      struct.setText(getgxTv_SdtRangedRadialGaugeConfig_Text());
      struct.setWidth(getgxTv_SdtRangedRadialGaugeConfig_Width());
      struct.setHeight(getgxTv_SdtRangedRadialGaugeConfig_Height());
      struct.setRange1colorstart(getgxTv_SdtRangedRadialGaugeConfig_Range1colorstart());
      struct.setRange1colorend(getgxTv_SdtRangedRadialGaugeConfig_Range1colorend());
      struct.setRange2colorstart(getgxTv_SdtRangedRadialGaugeConfig_Range2colorstart());
      struct.setRange2colorend(getgxTv_SdtRangedRadialGaugeConfig_Range2colorend());
      struct.setRange3colorstart(getgxTv_SdtRangedRadialGaugeConfig_Range3colorstart());
      struct.setRange3colorend(getgxTv_SdtRangedRadialGaugeConfig_Range3colorend());
      struct.setRange4colorstart(getgxTv_SdtRangedRadialGaugeConfig_Range4colorstart());
      struct.setRange4colorend(getgxTv_SdtRangedRadialGaugeConfig_Range4colorend());
      struct.setRange5colorstart(getgxTv_SdtRangedRadialGaugeConfig_Range5colorstart());
      struct.setRange5colorend(getgxTv_SdtRangedRadialGaugeConfig_Range5colorend());
      struct.setValuemarkercolor(getgxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor());
      return struct ;
   }

   protected byte gxTv_SdtRangedRadialGaugeConfig_N ;
   protected short gxTv_SdtRangedRadialGaugeConfig_Value ;
   protected short gxTv_SdtRangedRadialGaugeConfig_Width ;
   protected short gxTv_SdtRangedRadialGaugeConfig_Height ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Text ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range1colorstart ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range1colorend ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range2colorstart ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range2colorend ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range3colorstart ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range3colorend ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range4colorstart ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range4colorend ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range5colorstart ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Range5colorend ;
   protected String gxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

