package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPCalendarEntry extends GxUserType
{
   public SdtWWPCalendarEntry( )
   {
      this(  new ModelContext(SdtWWPCalendarEntry.class));
   }

   public SdtWWPCalendarEntry( ModelContext context )
   {
      super( context, "SdtWWPCalendarEntry");
   }

   public SdtWWPCalendarEntry( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPCalendarEntry");
   }

   public SdtWWPCalendarEntry( StructSdtWWPCalendarEntry struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Year") )
            {
               gxTv_SdtWWPCalendarEntry_Year = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Month") )
            {
               gxTv_SdtWWPCalendarEntry_Month = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Day") )
            {
               gxTv_SdtWWPCalendarEntry_Day = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Color") )
            {
               gxTv_SdtWWPCalendarEntry_Color = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Text") )
            {
               gxTv_SdtWWPCalendarEntry_Text = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Status") )
            {
               gxTv_SdtWWPCalendarEntry_Status = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Content") )
            {
               gxTv_SdtWWPCalendarEntry_Content = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Time") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWPCalendarEntry_Time = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtWWPCalendarEntry_Time_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtWWPCalendarEntry_Time_N = (byte)(0) ;
                  gxTv_SdtWWPCalendarEntry_Time = GXutil.resetDate(localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), "."))))) ;
               }
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
         sName = "WWPCalendarEntry" ;
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
      oWriter.writeElement("Year", GXutil.trim( GXutil.str( gxTv_SdtWWPCalendarEntry_Year, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Month", GXutil.trim( GXutil.str( gxTv_SdtWWPCalendarEntry_Month, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Day", GXutil.trim( GXutil.str( gxTv_SdtWWPCalendarEntry_Day, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Color", gxTv_SdtWWPCalendarEntry_Color);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Text", gxTv_SdtWWPCalendarEntry_Text);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Status", GXutil.trim( GXutil.str( gxTv_SdtWWPCalendarEntry_Status, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Content", gxTv_SdtWWPCalendarEntry_Content);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtWWPCalendarEntry_Time) && ( gxTv_SdtWWPCalendarEntry_Time_N == 1 ) )
      {
         oWriter.writeElement("Time", "");
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWPCalendarEntry_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWPCalendarEntry_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWPCalendarEntry_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWPCalendarEntry_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWPCalendarEntry_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWPCalendarEntry_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("Time", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
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
      AddObjectProperty("Year", gxTv_SdtWWPCalendarEntry_Year, false, false);
      AddObjectProperty("Month", gxTv_SdtWWPCalendarEntry_Month, false, false);
      AddObjectProperty("Day", gxTv_SdtWWPCalendarEntry_Day, false, false);
      AddObjectProperty("Color", gxTv_SdtWWPCalendarEntry_Color, false, false);
      AddObjectProperty("Text", gxTv_SdtWWPCalendarEntry_Text, false, false);
      AddObjectProperty("Status", gxTv_SdtWWPCalendarEntry_Status, false, false);
      AddObjectProperty("Content", gxTv_SdtWWPCalendarEntry_Content, false, false);
      datetime_STZ = gxTv_SdtWWPCalendarEntry_Time ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("Time", sDateCnv, false, false);
   }

   public short getgxTv_SdtWWPCalendarEntry_Year( )
   {
      return gxTv_SdtWWPCalendarEntry_Year ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Year( short value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Year = value ;
   }

   public byte getgxTv_SdtWWPCalendarEntry_Month( )
   {
      return gxTv_SdtWWPCalendarEntry_Month ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Month( byte value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Month = value ;
   }

   public byte getgxTv_SdtWWPCalendarEntry_Day( )
   {
      return gxTv_SdtWWPCalendarEntry_Day ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Day( byte value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Day = value ;
   }

   public String getgxTv_SdtWWPCalendarEntry_Color( )
   {
      return gxTv_SdtWWPCalendarEntry_Color ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Color( String value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Color = value ;
   }

   public String getgxTv_SdtWWPCalendarEntry_Text( )
   {
      return gxTv_SdtWWPCalendarEntry_Text ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Text( String value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Text = value ;
   }

   public short getgxTv_SdtWWPCalendarEntry_Status( )
   {
      return gxTv_SdtWWPCalendarEntry_Status ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Status( short value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Status = value ;
   }

   public String getgxTv_SdtWWPCalendarEntry_Content( )
   {
      return gxTv_SdtWWPCalendarEntry_Content ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Content( String value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Content = value ;
   }

   public java.util.Date getgxTv_SdtWWPCalendarEntry_Time( )
   {
      return gxTv_SdtWWPCalendarEntry_Time ;
   }

   public void setgxTv_SdtWWPCalendarEntry_Time( java.util.Date value )
   {
      gxTv_SdtWWPCalendarEntry_Time_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Time = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(1) ;
      gxTv_SdtWWPCalendarEntry_Color = "" ;
      gxTv_SdtWWPCalendarEntry_Text = "" ;
      gxTv_SdtWWPCalendarEntry_Content = "" ;
      gxTv_SdtWWPCalendarEntry_Time = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWPCalendarEntry_Time_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPCalendarEntry_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtWWPCalendarEntry Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtWWPCalendarEntry)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtWWPCalendarEntry struct )
   {
      setgxTv_SdtWWPCalendarEntry_Year(struct.getYear());
      setgxTv_SdtWWPCalendarEntry_Month(struct.getMonth());
      setgxTv_SdtWWPCalendarEntry_Day(struct.getDay());
      setgxTv_SdtWWPCalendarEntry_Color(struct.getColor());
      setgxTv_SdtWWPCalendarEntry_Text(struct.getText());
      setgxTv_SdtWWPCalendarEntry_Status(struct.getStatus());
      setgxTv_SdtWWPCalendarEntry_Content(struct.getContent());
      if ( struct.gxTv_SdtWWPCalendarEntry_Time_N == 0 )
      {
         setgxTv_SdtWWPCalendarEntry_Time(struct.getTime());
      }
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtWWPCalendarEntry getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtWWPCalendarEntry struct = new com.mujermorena.workwithplus.nativemobile.StructSdtWWPCalendarEntry ();
      struct.setYear(getgxTv_SdtWWPCalendarEntry_Year());
      struct.setMonth(getgxTv_SdtWWPCalendarEntry_Month());
      struct.setDay(getgxTv_SdtWWPCalendarEntry_Day());
      struct.setColor(getgxTv_SdtWWPCalendarEntry_Color());
      struct.setText(getgxTv_SdtWWPCalendarEntry_Text());
      struct.setStatus(getgxTv_SdtWWPCalendarEntry_Status());
      struct.setContent(getgxTv_SdtWWPCalendarEntry_Content());
      if ( gxTv_SdtWWPCalendarEntry_Time_N == 0 )
      {
         struct.setTime(getgxTv_SdtWWPCalendarEntry_Time());
      }
      return struct ;
   }

   protected byte gxTv_SdtWWPCalendarEntry_N ;
   protected byte gxTv_SdtWWPCalendarEntry_Month ;
   protected byte gxTv_SdtWWPCalendarEntry_Day ;
   protected byte gxTv_SdtWWPCalendarEntry_Time_N ;
   protected short gxTv_SdtWWPCalendarEntry_Year ;
   protected short gxTv_SdtWWPCalendarEntry_Status ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtWWPCalendarEntry_Time ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPCalendarEntry_Color ;
   protected String gxTv_SdtWWPCalendarEntry_Text ;
   protected String gxTv_SdtWWPCalendarEntry_Content ;
}

