package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPProductDataImages extends GxUserType
{
   public SdtWWPProductDataImages( )
   {
      this(  new ModelContext(SdtWWPProductDataImages.class));
   }

   public SdtWWPProductDataImages( ModelContext context )
   {
      super( context, "SdtWWPProductDataImages");
   }

   public SdtWWPProductDataImages( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPProductDataImages");
   }

   public SdtWWPProductDataImages( StructSdtWWPProductDataImages struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image") )
            {
               gxTv_SdtWWPProductDataImages_Image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image_GXI") )
            {
               gxTv_SdtWWPProductDataImages_Image_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtWWPProductDataImages_Description = oReader.getValue() ;
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
         sName = "WWPProductDataImages" ;
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
      oWriter.writeElement("Image", gxTv_SdtWWPProductDataImages_Image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image_GXI", gxTv_SdtWWPProductDataImages_Image_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Description", gxTv_SdtWWPProductDataImages_Description);
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
      AddObjectProperty("Image", gxTv_SdtWWPProductDataImages_Image, false, false);
      AddObjectProperty("Image_GXI", gxTv_SdtWWPProductDataImages_Image_gxi, false, false);
      AddObjectProperty("Description", gxTv_SdtWWPProductDataImages_Description, false, false);
   }

   @GxUpload
   public String getgxTv_SdtWWPProductDataImages_Image( )
   {
      return gxTv_SdtWWPProductDataImages_Image ;
   }

   public void setgxTv_SdtWWPProductDataImages_Image( String value )
   {
      gxTv_SdtWWPProductDataImages_N = (byte)(0) ;
      gxTv_SdtWWPProductDataImages_Image = value ;
   }

   public String getgxTv_SdtWWPProductDataImages_Image_gxi( )
   {
      return gxTv_SdtWWPProductDataImages_Image_gxi ;
   }

   public void setgxTv_SdtWWPProductDataImages_Image_gxi( String value )
   {
      gxTv_SdtWWPProductDataImages_N = (byte)(0) ;
      gxTv_SdtWWPProductDataImages_Image_gxi = value ;
   }

   public String getgxTv_SdtWWPProductDataImages_Description( )
   {
      return gxTv_SdtWWPProductDataImages_Description ;
   }

   public void setgxTv_SdtWWPProductDataImages_Description( String value )
   {
      gxTv_SdtWWPProductDataImages_N = (byte)(0) ;
      gxTv_SdtWWPProductDataImages_Description = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPProductDataImages_Image = "" ;
      gxTv_SdtWWPProductDataImages_N = (byte)(1) ;
      gxTv_SdtWWPProductDataImages_Image_gxi = "" ;
      gxTv_SdtWWPProductDataImages_Description = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPProductDataImages_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages struct )
   {
      setgxTv_SdtWWPProductDataImages_Image(struct.getImage());
      setgxTv_SdtWWPProductDataImages_Image_gxi(struct.getImage_gxi());
      setgxTv_SdtWWPProductDataImages_Description(struct.getDescription());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages struct = new com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages ();
      struct.setImage(getgxTv_SdtWWPProductDataImages_Image());
      struct.setImage_gxi(getgxTv_SdtWWPProductDataImages_Image_gxi());
      struct.setDescription(getgxTv_SdtWWPProductDataImages_Description());
      return struct ;
   }

   protected byte gxTv_SdtWWPProductDataImages_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPProductDataImages_Image_gxi ;
   protected String gxTv_SdtWWPProductDataImages_Description ;
   protected String gxTv_SdtWWPProductDataImages_Image ;
}

