package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPProductData extends GxUserType
{
   public SdtWWPProductData( )
   {
      this(  new ModelContext(SdtWWPProductData.class));
   }

   public SdtWWPProductData( ModelContext context )
   {
      super( context, "SdtWWPProductData");
   }

   public SdtWWPProductData( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPProductData");
   }

   public SdtWWPProductData( StructSdtWWPProductData struct )
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
               gxTv_SdtWWPProductData_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtWWPProductData_Type = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtWWPProductData_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtWWPProductData_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image") )
            {
               gxTv_SdtWWPProductData_Image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image_GXI") )
            {
               gxTv_SdtWWPProductData_Image_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Subtitle") )
            {
               gxTv_SdtWWPProductData_Subtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Information1") )
            {
               gxTv_SdtWWPProductData_Information1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Information2") )
            {
               gxTv_SdtWWPProductData_Information2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComponentToCall") )
            {
               gxTv_SdtWWPProductData_Componenttocall = oReader.getValue() ;
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
         sName = "WWPProductData" ;
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
      oWriter.writeElement("Id", gxTv_SdtWWPProductData_Id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Type", GXutil.trim( GXutil.str( gxTv_SdtWWPProductData_Type, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Title", gxTv_SdtWWPProductData_Title);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Description", gxTv_SdtWWPProductData_Description);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image", gxTv_SdtWWPProductData_Image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image_GXI", gxTv_SdtWWPProductData_Image_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Subtitle", gxTv_SdtWWPProductData_Subtitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Information1", gxTv_SdtWWPProductData_Information1);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Information2", gxTv_SdtWWPProductData_Information2);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ComponentToCall", gxTv_SdtWWPProductData_Componenttocall);
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
      AddObjectProperty("Id", gxTv_SdtWWPProductData_Id, false, false);
      AddObjectProperty("Type", gxTv_SdtWWPProductData_Type, false, false);
      AddObjectProperty("Title", gxTv_SdtWWPProductData_Title, false, false);
      AddObjectProperty("Description", gxTv_SdtWWPProductData_Description, false, false);
      AddObjectProperty("Image", gxTv_SdtWWPProductData_Image, false, false);
      AddObjectProperty("Image_GXI", gxTv_SdtWWPProductData_Image_gxi, false, false);
      AddObjectProperty("Subtitle", gxTv_SdtWWPProductData_Subtitle, false, false);
      AddObjectProperty("Information1", gxTv_SdtWWPProductData_Information1, false, false);
      AddObjectProperty("Information2", gxTv_SdtWWPProductData_Information2, false, false);
      AddObjectProperty("ComponentToCall", gxTv_SdtWWPProductData_Componenttocall, false, false);
   }

   public String getgxTv_SdtWWPProductData_Id( )
   {
      return gxTv_SdtWWPProductData_Id ;
   }

   public void setgxTv_SdtWWPProductData_Id( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Id = value ;
   }

   public short getgxTv_SdtWWPProductData_Type( )
   {
      return gxTv_SdtWWPProductData_Type ;
   }

   public void setgxTv_SdtWWPProductData_Type( short value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Type = value ;
   }

   public String getgxTv_SdtWWPProductData_Title( )
   {
      return gxTv_SdtWWPProductData_Title ;
   }

   public void setgxTv_SdtWWPProductData_Title( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Title = value ;
   }

   public String getgxTv_SdtWWPProductData_Description( )
   {
      return gxTv_SdtWWPProductData_Description ;
   }

   public void setgxTv_SdtWWPProductData_Description( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Description = value ;
   }

   @GxUpload
   public String getgxTv_SdtWWPProductData_Image( )
   {
      return gxTv_SdtWWPProductData_Image ;
   }

   public void setgxTv_SdtWWPProductData_Image( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Image = value ;
   }

   public String getgxTv_SdtWWPProductData_Image_gxi( )
   {
      return gxTv_SdtWWPProductData_Image_gxi ;
   }

   public void setgxTv_SdtWWPProductData_Image_gxi( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Image_gxi = value ;
   }

   public String getgxTv_SdtWWPProductData_Subtitle( )
   {
      return gxTv_SdtWWPProductData_Subtitle ;
   }

   public void setgxTv_SdtWWPProductData_Subtitle( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Subtitle = value ;
   }

   public String getgxTv_SdtWWPProductData_Information1( )
   {
      return gxTv_SdtWWPProductData_Information1 ;
   }

   public void setgxTv_SdtWWPProductData_Information1( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Information1 = value ;
   }

   public String getgxTv_SdtWWPProductData_Information2( )
   {
      return gxTv_SdtWWPProductData_Information2 ;
   }

   public void setgxTv_SdtWWPProductData_Information2( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Information2 = value ;
   }

   public String getgxTv_SdtWWPProductData_Componenttocall( )
   {
      return gxTv_SdtWWPProductData_Componenttocall ;
   }

   public void setgxTv_SdtWWPProductData_Componenttocall( String value )
   {
      gxTv_SdtWWPProductData_N = (byte)(0) ;
      gxTv_SdtWWPProductData_Componenttocall = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPProductData_Id = "" ;
      gxTv_SdtWWPProductData_N = (byte)(1) ;
      gxTv_SdtWWPProductData_Title = "" ;
      gxTv_SdtWWPProductData_Description = "" ;
      gxTv_SdtWWPProductData_Image = "" ;
      gxTv_SdtWWPProductData_Image_gxi = "" ;
      gxTv_SdtWWPProductData_Subtitle = "" ;
      gxTv_SdtWWPProductData_Information1 = "" ;
      gxTv_SdtWWPProductData_Information2 = "" ;
      gxTv_SdtWWPProductData_Componenttocall = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPProductData_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductData Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData struct )
   {
      setgxTv_SdtWWPProductData_Id(struct.getId());
      setgxTv_SdtWWPProductData_Type(struct.getType());
      setgxTv_SdtWWPProductData_Title(struct.getTitle());
      setgxTv_SdtWWPProductData_Description(struct.getDescription());
      setgxTv_SdtWWPProductData_Image(struct.getImage());
      setgxTv_SdtWWPProductData_Image_gxi(struct.getImage_gxi());
      setgxTv_SdtWWPProductData_Subtitle(struct.getSubtitle());
      setgxTv_SdtWWPProductData_Information1(struct.getInformation1());
      setgxTv_SdtWWPProductData_Information2(struct.getInformation2());
      setgxTv_SdtWWPProductData_Componenttocall(struct.getComponenttocall());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData struct = new com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData ();
      struct.setId(getgxTv_SdtWWPProductData_Id());
      struct.setType(getgxTv_SdtWWPProductData_Type());
      struct.setTitle(getgxTv_SdtWWPProductData_Title());
      struct.setDescription(getgxTv_SdtWWPProductData_Description());
      struct.setImage(getgxTv_SdtWWPProductData_Image());
      struct.setImage_gxi(getgxTv_SdtWWPProductData_Image_gxi());
      struct.setSubtitle(getgxTv_SdtWWPProductData_Subtitle());
      struct.setInformation1(getgxTv_SdtWWPProductData_Information1());
      struct.setInformation2(getgxTv_SdtWWPProductData_Information2());
      struct.setComponenttocall(getgxTv_SdtWWPProductData_Componenttocall());
      return struct ;
   }

   protected byte gxTv_SdtWWPProductData_N ;
   protected short gxTv_SdtWWPProductData_Type ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPProductData_Id ;
   protected String gxTv_SdtWWPProductData_Title ;
   protected String gxTv_SdtWWPProductData_Description ;
   protected String gxTv_SdtWWPProductData_Image_gxi ;
   protected String gxTv_SdtWWPProductData_Subtitle ;
   protected String gxTv_SdtWWPProductData_Information1 ;
   protected String gxTv_SdtWWPProductData_Information2 ;
   protected String gxTv_SdtWWPProductData_Componenttocall ;
   protected String gxTv_SdtWWPProductData_Image ;
}

