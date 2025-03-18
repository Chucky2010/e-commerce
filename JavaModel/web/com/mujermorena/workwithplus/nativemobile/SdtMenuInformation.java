package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMenuInformation extends GxUserType
{
   public SdtMenuInformation( )
   {
      this(  new ModelContext(SdtMenuInformation.class));
   }

   public SdtMenuInformation( ModelContext context )
   {
      super( context, "SdtMenuInformation");
   }

   public SdtMenuInformation( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtMenuInformation");
   }

   public SdtMenuInformation( StructSdtMenuInformation struct )
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
               gxTv_SdtMenuInformation_Image = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Image_GXI") )
            {
               gxTv_SdtMenuInformation_Image_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TitleInfo") )
            {
               gxTv_SdtMenuInformation_Titleinfo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecondaryInfo") )
            {
               gxTv_SdtMenuInformation_Secondaryinfo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComponentToCall") )
            {
               gxTv_SdtMenuInformation_Componenttocall = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtMenuInformation_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "InfoField1") )
            {
               gxTv_SdtMenuInformation_Infofield1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "InfoField2") )
            {
               gxTv_SdtMenuInformation_Infofield2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "InfoField3") )
            {
               gxTv_SdtMenuInformation_Infofield3 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "InfoField4") )
            {
               gxTv_SdtMenuInformation_Infofield4 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "InfoFieldNumeric1") )
            {
               gxTv_SdtMenuInformation_Infofieldnumeric1 = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "InfoFieldNumeric2") )
            {
               gxTv_SdtMenuInformation_Infofieldnumeric2 = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "MenuInformation" ;
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
      oWriter.writeElement("Image", gxTv_SdtMenuInformation_Image);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Image_GXI", gxTv_SdtMenuInformation_Image_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("TitleInfo", gxTv_SdtMenuInformation_Titleinfo);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("SecondaryInfo", gxTv_SdtMenuInformation_Secondaryinfo);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ComponentToCall", gxTv_SdtMenuInformation_Componenttocall);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Id", gxTv_SdtMenuInformation_Id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("InfoField1", gxTv_SdtMenuInformation_Infofield1);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("InfoField2", gxTv_SdtMenuInformation_Infofield2);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("InfoField3", gxTv_SdtMenuInformation_Infofield3);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("InfoField4", gxTv_SdtMenuInformation_Infofield4);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("InfoFieldNumeric1", GXutil.trim( GXutil.strNoRound( gxTv_SdtMenuInformation_Infofieldnumeric1, 10, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("InfoFieldNumeric2", GXutil.trim( GXutil.strNoRound( gxTv_SdtMenuInformation_Infofieldnumeric2, 10, 2)));
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
      AddObjectProperty("Image", gxTv_SdtMenuInformation_Image, false, false);
      AddObjectProperty("Image_GXI", gxTv_SdtMenuInformation_Image_gxi, false, false);
      AddObjectProperty("TitleInfo", gxTv_SdtMenuInformation_Titleinfo, false, false);
      AddObjectProperty("SecondaryInfo", gxTv_SdtMenuInformation_Secondaryinfo, false, false);
      AddObjectProperty("ComponentToCall", gxTv_SdtMenuInformation_Componenttocall, false, false);
      AddObjectProperty("Id", gxTv_SdtMenuInformation_Id, false, false);
      AddObjectProperty("InfoField1", gxTv_SdtMenuInformation_Infofield1, false, false);
      AddObjectProperty("InfoField2", gxTv_SdtMenuInformation_Infofield2, false, false);
      AddObjectProperty("InfoField3", gxTv_SdtMenuInformation_Infofield3, false, false);
      AddObjectProperty("InfoField4", gxTv_SdtMenuInformation_Infofield4, false, false);
      AddObjectProperty("InfoFieldNumeric1", gxTv_SdtMenuInformation_Infofieldnumeric1, false, false);
      AddObjectProperty("InfoFieldNumeric2", gxTv_SdtMenuInformation_Infofieldnumeric2, false, false);
   }

   @GxUpload
   public String getgxTv_SdtMenuInformation_Image( )
   {
      return gxTv_SdtMenuInformation_Image ;
   }

   public void setgxTv_SdtMenuInformation_Image( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Image = value ;
   }

   public String getgxTv_SdtMenuInformation_Image_gxi( )
   {
      return gxTv_SdtMenuInformation_Image_gxi ;
   }

   public void setgxTv_SdtMenuInformation_Image_gxi( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Image_gxi = value ;
   }

   public String getgxTv_SdtMenuInformation_Titleinfo( )
   {
      return gxTv_SdtMenuInformation_Titleinfo ;
   }

   public void setgxTv_SdtMenuInformation_Titleinfo( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Titleinfo = value ;
   }

   public String getgxTv_SdtMenuInformation_Secondaryinfo( )
   {
      return gxTv_SdtMenuInformation_Secondaryinfo ;
   }

   public void setgxTv_SdtMenuInformation_Secondaryinfo( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Secondaryinfo = value ;
   }

   public String getgxTv_SdtMenuInformation_Componenttocall( )
   {
      return gxTv_SdtMenuInformation_Componenttocall ;
   }

   public void setgxTv_SdtMenuInformation_Componenttocall( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Componenttocall = value ;
   }

   public String getgxTv_SdtMenuInformation_Id( )
   {
      return gxTv_SdtMenuInformation_Id ;
   }

   public void setgxTv_SdtMenuInformation_Id( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Id = value ;
   }

   public String getgxTv_SdtMenuInformation_Infofield1( )
   {
      return gxTv_SdtMenuInformation_Infofield1 ;
   }

   public void setgxTv_SdtMenuInformation_Infofield1( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield1 = value ;
   }

   public String getgxTv_SdtMenuInformation_Infofield2( )
   {
      return gxTv_SdtMenuInformation_Infofield2 ;
   }

   public void setgxTv_SdtMenuInformation_Infofield2( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield2 = value ;
   }

   public String getgxTv_SdtMenuInformation_Infofield3( )
   {
      return gxTv_SdtMenuInformation_Infofield3 ;
   }

   public void setgxTv_SdtMenuInformation_Infofield3( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield3 = value ;
   }

   public String getgxTv_SdtMenuInformation_Infofield4( )
   {
      return gxTv_SdtMenuInformation_Infofield4 ;
   }

   public void setgxTv_SdtMenuInformation_Infofield4( String value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofield4 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtMenuInformation_Infofieldnumeric1( )
   {
      return gxTv_SdtMenuInformation_Infofieldnumeric1 ;
   }

   public void setgxTv_SdtMenuInformation_Infofieldnumeric1( java.math.BigDecimal value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofieldnumeric1 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtMenuInformation_Infofieldnumeric2( )
   {
      return gxTv_SdtMenuInformation_Infofieldnumeric2 ;
   }

   public void setgxTv_SdtMenuInformation_Infofieldnumeric2( java.math.BigDecimal value )
   {
      gxTv_SdtMenuInformation_N = (byte)(0) ;
      gxTv_SdtMenuInformation_Infofieldnumeric2 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMenuInformation_Image = "" ;
      gxTv_SdtMenuInformation_N = (byte)(1) ;
      gxTv_SdtMenuInformation_Image_gxi = "" ;
      gxTv_SdtMenuInformation_Titleinfo = "" ;
      gxTv_SdtMenuInformation_Secondaryinfo = "" ;
      gxTv_SdtMenuInformation_Componenttocall = "" ;
      gxTv_SdtMenuInformation_Id = "" ;
      gxTv_SdtMenuInformation_Infofield1 = "" ;
      gxTv_SdtMenuInformation_Infofield2 = "" ;
      gxTv_SdtMenuInformation_Infofield3 = "" ;
      gxTv_SdtMenuInformation_Infofield4 = "" ;
      gxTv_SdtMenuInformation_Infofieldnumeric1 = DecimalUtil.ZERO ;
      gxTv_SdtMenuInformation_Infofieldnumeric2 = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMenuInformation_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtMenuInformation Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtMenuInformation)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtMenuInformation struct )
   {
      setgxTv_SdtMenuInformation_Image(struct.getImage());
      setgxTv_SdtMenuInformation_Image_gxi(struct.getImage_gxi());
      setgxTv_SdtMenuInformation_Titleinfo(struct.getTitleinfo());
      setgxTv_SdtMenuInformation_Secondaryinfo(struct.getSecondaryinfo());
      setgxTv_SdtMenuInformation_Componenttocall(struct.getComponenttocall());
      setgxTv_SdtMenuInformation_Id(struct.getId());
      setgxTv_SdtMenuInformation_Infofield1(struct.getInfofield1());
      setgxTv_SdtMenuInformation_Infofield2(struct.getInfofield2());
      setgxTv_SdtMenuInformation_Infofield3(struct.getInfofield3());
      setgxTv_SdtMenuInformation_Infofield4(struct.getInfofield4());
      setgxTv_SdtMenuInformation_Infofieldnumeric1(struct.getInfofieldnumeric1());
      setgxTv_SdtMenuInformation_Infofieldnumeric2(struct.getInfofieldnumeric2());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtMenuInformation getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtMenuInformation struct = new com.mujermorena.workwithplus.nativemobile.StructSdtMenuInformation ();
      struct.setImage(getgxTv_SdtMenuInformation_Image());
      struct.setImage_gxi(getgxTv_SdtMenuInformation_Image_gxi());
      struct.setTitleinfo(getgxTv_SdtMenuInformation_Titleinfo());
      struct.setSecondaryinfo(getgxTv_SdtMenuInformation_Secondaryinfo());
      struct.setComponenttocall(getgxTv_SdtMenuInformation_Componenttocall());
      struct.setId(getgxTv_SdtMenuInformation_Id());
      struct.setInfofield1(getgxTv_SdtMenuInformation_Infofield1());
      struct.setInfofield2(getgxTv_SdtMenuInformation_Infofield2());
      struct.setInfofield3(getgxTv_SdtMenuInformation_Infofield3());
      struct.setInfofield4(getgxTv_SdtMenuInformation_Infofield4());
      struct.setInfofieldnumeric1(getgxTv_SdtMenuInformation_Infofieldnumeric1());
      struct.setInfofieldnumeric2(getgxTv_SdtMenuInformation_Infofieldnumeric2());
      return struct ;
   }

   protected byte gxTv_SdtMenuInformation_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtMenuInformation_Infofieldnumeric1 ;
   protected java.math.BigDecimal gxTv_SdtMenuInformation_Infofieldnumeric2 ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMenuInformation_Image_gxi ;
   protected String gxTv_SdtMenuInformation_Titleinfo ;
   protected String gxTv_SdtMenuInformation_Secondaryinfo ;
   protected String gxTv_SdtMenuInformation_Componenttocall ;
   protected String gxTv_SdtMenuInformation_Id ;
   protected String gxTv_SdtMenuInformation_Infofield1 ;
   protected String gxTv_SdtMenuInformation_Infofield2 ;
   protected String gxTv_SdtMenuInformation_Infofield3 ;
   protected String gxTv_SdtMenuInformation_Infofield4 ;
   protected String gxTv_SdtMenuInformation_Image ;
}

