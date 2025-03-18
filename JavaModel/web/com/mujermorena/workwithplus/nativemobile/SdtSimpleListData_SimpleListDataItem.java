package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSimpleListData_SimpleListDataItem extends GxUserType
{
   public SdtSimpleListData_SimpleListDataItem( )
   {
      this(  new ModelContext(SdtSimpleListData_SimpleListDataItem.class));
   }

   public SdtSimpleListData_SimpleListDataItem( ModelContext context )
   {
      super( context, "SdtSimpleListData_SimpleListDataItem");
   }

   public SdtSimpleListData_SimpleListDataItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSimpleListData_SimpleListDataItem");
   }

   public SdtSimpleListData_SimpleListDataItem( StructSdtSimpleListData_SimpleListDataItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Information") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Information = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image_GXI") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComponentToCall") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OrderIndex") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Orderindex = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Category") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Category = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TextData1") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TextData2") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NumericData1") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1 = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NumericData2") )
            {
               gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2 = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "SimpleListData.SimpleListDataItem" ;
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
      oWriter.writeElement("Id", gxTv_SdtSimpleListData_SimpleListDataItem_Id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Title", gxTv_SdtSimpleListData_SimpleListDataItem_Title);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Information", gxTv_SdtSimpleListData_SimpleListDataItem_Information);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image", gxTv_SdtSimpleListData_SimpleListDataItem_Image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image_GXI", gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ComponentToCall", gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("OrderIndex", GXutil.trim( GXutil.str( gxTv_SdtSimpleListData_SimpleListDataItem_Orderindex, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Category", gxTv_SdtSimpleListData_SimpleListDataItem_Category);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("TextData1", gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("TextData2", gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("NumericData1", GXutil.trim( GXutil.strNoRound( gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1, 8, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("NumericData2", GXutil.trim( GXutil.strNoRound( gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2, 10, 2)));
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
      AddObjectProperty("Id", gxTv_SdtSimpleListData_SimpleListDataItem_Id, false, false);
      AddObjectProperty("Title", gxTv_SdtSimpleListData_SimpleListDataItem_Title, false, false);
      AddObjectProperty("Information", gxTv_SdtSimpleListData_SimpleListDataItem_Information, false, false);
      AddObjectProperty("Image", gxTv_SdtSimpleListData_SimpleListDataItem_Image, false, false);
      AddObjectProperty("Image_GXI", gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi, false, false);
      AddObjectProperty("ComponentToCall", gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall, false, false);
      AddObjectProperty("OrderIndex", gxTv_SdtSimpleListData_SimpleListDataItem_Orderindex, false, false);
      AddObjectProperty("Category", gxTv_SdtSimpleListData_SimpleListDataItem_Category, false, false);
      AddObjectProperty("TextData1", gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1, false, false);
      AddObjectProperty("TextData2", gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2, false, false);
      AddObjectProperty("NumericData1", gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1, false, false);
      AddObjectProperty("NumericData2", gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2, false, false);
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Id( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Id ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Id( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Id = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Title( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Title ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Title( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Title = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Information( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Information ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Information( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Information = value ;
   }

   @GxUpload
   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Image( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Image ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Image( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Image = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall = value ;
   }

   public short getgxTv_SdtSimpleListData_SimpleListDataItem_Orderindex( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Orderindex ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Orderindex( short value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Orderindex = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Category( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Category ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Category( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Category = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Textdata1( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1 ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Textdata1( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1 = value ;
   }

   public String getgxTv_SdtSimpleListData_SimpleListDataItem_Textdata2( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2 ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Textdata2( String value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1 ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1( java.math.BigDecimal value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2 ;
   }

   public void setgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2( java.math.BigDecimal value )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(0) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSimpleListData_SimpleListDataItem_Id = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_N = (byte)(1) ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Title = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Information = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Image = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Category = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1 = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2 = "" ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1 = DecimalUtil.ZERO ;
      gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2 = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSimpleListData_SimpleListDataItem_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem struct )
   {
      setgxTv_SdtSimpleListData_SimpleListDataItem_Id(struct.getId());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Title(struct.getTitle());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Information(struct.getInformation());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Image(struct.getImage());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi(struct.getImage_gxi());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall(struct.getComponenttocall());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Orderindex(struct.getOrderindex());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Category(struct.getCategory());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Textdata1(struct.getTextdata1());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Textdata2(struct.getTextdata2());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1(struct.getNumericdata1());
      setgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2(struct.getNumericdata2());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem struct = new com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem ();
      struct.setId(getgxTv_SdtSimpleListData_SimpleListDataItem_Id());
      struct.setTitle(getgxTv_SdtSimpleListData_SimpleListDataItem_Title());
      struct.setInformation(getgxTv_SdtSimpleListData_SimpleListDataItem_Information());
      struct.setImage(getgxTv_SdtSimpleListData_SimpleListDataItem_Image());
      struct.setImage_gxi(getgxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi());
      struct.setComponenttocall(getgxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall());
      struct.setOrderindex(getgxTv_SdtSimpleListData_SimpleListDataItem_Orderindex());
      struct.setCategory(getgxTv_SdtSimpleListData_SimpleListDataItem_Category());
      struct.setTextdata1(getgxTv_SdtSimpleListData_SimpleListDataItem_Textdata1());
      struct.setTextdata2(getgxTv_SdtSimpleListData_SimpleListDataItem_Textdata2());
      struct.setNumericdata1(getgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1());
      struct.setNumericdata2(getgxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2());
      return struct ;
   }

   protected byte gxTv_SdtSimpleListData_SimpleListDataItem_N ;
   protected short gxTv_SdtSimpleListData_SimpleListDataItem_Orderindex ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata1 ;
   protected java.math.BigDecimal gxTv_SdtSimpleListData_SimpleListDataItem_Numericdata2 ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Id ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Title ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Information ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Image_gxi ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Componenttocall ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Category ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Textdata1 ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Textdata2 ;
   protected String gxTv_SdtSimpleListData_SimpleListDataItem_Image ;
}

