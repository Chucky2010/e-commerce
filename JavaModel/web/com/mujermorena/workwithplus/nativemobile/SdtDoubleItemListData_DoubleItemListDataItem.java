package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDoubleItemListData_DoubleItemListDataItem extends GxUserType
{
   public SdtDoubleItemListData_DoubleItemListDataItem( )
   {
      this(  new ModelContext(SdtDoubleItemListData_DoubleItemListDataItem.class));
   }

   public SdtDoubleItemListData_DoubleItemListDataItem( ModelContext context )
   {
      super( context, "SdtDoubleItemListData_DoubleItemListDataItem");
   }

   public SdtDoubleItemListData_DoubleItemListDataItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtDoubleItemListData_DoubleItemListDataItem");
   }

   public SdtDoubleItemListData_DoubleItemListDataItem( StructSdtDoubleItemListData_DoubleItemListDataItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Title") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Image") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Image_GXI") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Subtitle") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Information1") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Information2") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1Id") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option1ComponentToCall") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Title") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Image") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Image_GXI") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Subtitle") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Id") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2ComponentToCall") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Information1") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Option2Information2") )
            {
               gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2 = oReader.getValue() ;
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
         sName = "DoubleItemListData.DoubleItemListDataItem" ;
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
      oWriter.writeElement("Type", GXutil.trim( GXutil.str( gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Title", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Image", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Image_GXI", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Subtitle", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Information1", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Information2", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1Id", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option1ComponentToCall", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Title", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Image", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Image_GXI", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Subtitle", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Id", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2ComponentToCall", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Information1", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Option2Information2", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2);
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
      AddObjectProperty("Type", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type, false, false);
      AddObjectProperty("Option1Title", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title, false, false);
      AddObjectProperty("Option1Image", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image, false, false);
      AddObjectProperty("Option1Image_GXI", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi, false, false);
      AddObjectProperty("Option1Subtitle", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle, false, false);
      AddObjectProperty("Option1Information1", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1, false, false);
      AddObjectProperty("Option1Information2", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2, false, false);
      AddObjectProperty("Option1Id", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id, false, false);
      AddObjectProperty("Option1ComponentToCall", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall, false, false);
      AddObjectProperty("Option2Title", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title, false, false);
      AddObjectProperty("Option2Image", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image, false, false);
      AddObjectProperty("Option2Image_GXI", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi, false, false);
      AddObjectProperty("Option2Subtitle", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle, false, false);
      AddObjectProperty("Option2Id", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id, false, false);
      AddObjectProperty("Option2ComponentToCall", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall, false, false);
      AddObjectProperty("Option2Information1", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1, false, false);
      AddObjectProperty("Option2Information2", gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2, false, false);
   }

   public short getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type( short value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title = value ;
   }

   @GxUpload
   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1 ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1 = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2 ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2 = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title = value ;
   }

   @GxUpload
   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1 ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1 = value ;
   }

   public String getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2 ;
   }

   public void setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2( String value )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(0) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N = (byte)(1) ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1 = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2 = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1 = "" ;
      gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2 = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtDoubleItemListData_DoubleItemListDataItem struct )
   {
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type(struct.getType());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title(struct.getOption1title());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image(struct.getOption1image());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi(struct.getOption1image_gxi());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle(struct.getOption1subtitle());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1(struct.getOption1information1());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2(struct.getOption1information2());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id(struct.getOption1id());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall(struct.getOption1componenttocall());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title(struct.getOption2title());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image(struct.getOption2image());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi(struct.getOption2image_gxi());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle(struct.getOption2subtitle());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id(struct.getOption2id());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall(struct.getOption2componenttocall());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1(struct.getOption2information1());
      setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2(struct.getOption2information2());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtDoubleItemListData_DoubleItemListDataItem getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtDoubleItemListData_DoubleItemListDataItem struct = new com.mujermorena.workwithplus.nativemobile.StructSdtDoubleItemListData_DoubleItemListDataItem ();
      struct.setType(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type());
      struct.setOption1title(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title());
      struct.setOption1image(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image());
      struct.setOption1image_gxi(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi());
      struct.setOption1subtitle(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle());
      struct.setOption1information1(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1());
      struct.setOption1information2(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2());
      struct.setOption1id(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id());
      struct.setOption1componenttocall(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall());
      struct.setOption2title(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title());
      struct.setOption2image(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image());
      struct.setOption2image_gxi(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi());
      struct.setOption2subtitle(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle());
      struct.setOption2id(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id());
      struct.setOption2componenttocall(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall());
      struct.setOption2information1(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1());
      struct.setOption2information2(getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2());
      return struct ;
   }

   protected byte gxTv_SdtDoubleItemListData_DoubleItemListDataItem_N ;
   protected short gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1 ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2 ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1 ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2 ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image ;
   protected String gxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image ;
}

