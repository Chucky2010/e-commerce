package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtImagesData_ImagesDataItem extends GxUserType
{
   public SdtImagesData_ImagesDataItem( )
   {
      this(  new ModelContext(SdtImagesData_ImagesDataItem.class));
   }

   public SdtImagesData_ImagesDataItem( ModelContext context )
   {
      super( context, "SdtImagesData_ImagesDataItem");
   }

   public SdtImagesData_ImagesDataItem( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtImagesData_ImagesDataItem");
   }

   public SdtImagesData_ImagesDataItem( StructSdtImagesData_ImagesDataItem struct )
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
               gxTv_SdtImagesData_ImagesDataItem_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image") )
            {
               gxTv_SdtImagesData_ImagesDataItem_Image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Thumbnail") )
            {
               gxTv_SdtImagesData_ImagesDataItem_Thumbnail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Caption") )
            {
               gxTv_SdtImagesData_ImagesDataItem_Caption = oReader.getValue() ;
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
         sName = "ImagesData.ImagesDataItem" ;
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
      oWriter.writeElement("Id", gxTv_SdtImagesData_ImagesDataItem_Id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image", gxTv_SdtImagesData_ImagesDataItem_Image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Thumbnail", gxTv_SdtImagesData_ImagesDataItem_Thumbnail);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Caption", gxTv_SdtImagesData_ImagesDataItem_Caption);
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
      AddObjectProperty("Id", gxTv_SdtImagesData_ImagesDataItem_Id, false, false);
      AddObjectProperty("Image", gxTv_SdtImagesData_ImagesDataItem_Image, false, false);
      AddObjectProperty("Thumbnail", gxTv_SdtImagesData_ImagesDataItem_Thumbnail, false, false);
      AddObjectProperty("Caption", gxTv_SdtImagesData_ImagesDataItem_Caption, false, false);
   }

   public String getgxTv_SdtImagesData_ImagesDataItem_Id( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Id ;
   }

   public void setgxTv_SdtImagesData_ImagesDataItem_Id( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Id = value ;
   }

   public String getgxTv_SdtImagesData_ImagesDataItem_Image( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Image ;
   }

   public void setgxTv_SdtImagesData_ImagesDataItem_Image( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Image = value ;
   }

   public String getgxTv_SdtImagesData_ImagesDataItem_Thumbnail( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Thumbnail ;
   }

   public void setgxTv_SdtImagesData_ImagesDataItem_Thumbnail( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Thumbnail = value ;
   }

   public String getgxTv_SdtImagesData_ImagesDataItem_Caption( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_Caption ;
   }

   public void setgxTv_SdtImagesData_ImagesDataItem_Caption( String value )
   {
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(0) ;
      gxTv_SdtImagesData_ImagesDataItem_Caption = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtImagesData_ImagesDataItem_Id = "" ;
      gxTv_SdtImagesData_ImagesDataItem_N = (byte)(1) ;
      gxTv_SdtImagesData_ImagesDataItem_Image = "" ;
      gxTv_SdtImagesData_ImagesDataItem_Thumbnail = "" ;
      gxTv_SdtImagesData_ImagesDataItem_Caption = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtImagesData_ImagesDataItem_N ;
   }

   public com.mujermorena.SdtImagesData_ImagesDataItem Clone( )
   {
      return (com.mujermorena.SdtImagesData_ImagesDataItem)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtImagesData_ImagesDataItem struct )
   {
      setgxTv_SdtImagesData_ImagesDataItem_Id(struct.getId());
      setgxTv_SdtImagesData_ImagesDataItem_Image(struct.getImage());
      setgxTv_SdtImagesData_ImagesDataItem_Thumbnail(struct.getThumbnail());
      setgxTv_SdtImagesData_ImagesDataItem_Caption(struct.getCaption());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtImagesData_ImagesDataItem getStruct( )
   {
      com.mujermorena.StructSdtImagesData_ImagesDataItem struct = new com.mujermorena.StructSdtImagesData_ImagesDataItem ();
      struct.setId(getgxTv_SdtImagesData_ImagesDataItem_Id());
      struct.setImage(getgxTv_SdtImagesData_ImagesDataItem_Image());
      struct.setThumbnail(getgxTv_SdtImagesData_ImagesDataItem_Thumbnail());
      struct.setCaption(getgxTv_SdtImagesData_ImagesDataItem_Caption());
      return struct ;
   }

   protected byte gxTv_SdtImagesData_ImagesDataItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Id ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Image ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Thumbnail ;
   protected String gxTv_SdtImagesData_ImagesDataItem_Caption ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

