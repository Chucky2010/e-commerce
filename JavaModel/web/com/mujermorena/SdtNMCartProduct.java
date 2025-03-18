package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtNMCartProduct extends GxUserType
{
   public SdtNMCartProduct( )
   {
      this(  new ModelContext(SdtNMCartProduct.class));
   }

   public SdtNMCartProduct( ModelContext context )
   {
      super( context, "SdtNMCartProduct");
   }

   public SdtNMCartProduct( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtNMCartProduct");
   }

   public SdtNMCartProduct( StructSdtNMCartProduct struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductId") )
            {
               gxTv_SdtNMCartProduct_Productid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Count") )
            {
               gxTv_SdtNMCartProduct_Count = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Color") )
            {
               gxTv_SdtNMCartProduct_Color = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Variant") )
            {
               gxTv_SdtNMCartProduct_Variant = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Promotion") )
            {
               gxTv_SdtNMCartProduct_Promotion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductData") )
            {
               if ( gxTv_SdtNMCartProduct_Productdata == null )
               {
                  gxTv_SdtNMCartProduct_Productdata = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtNMCartProduct_Productdata.readxml(oReader, "ProductData") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductDataTitle") )
            {
               gxTv_SdtNMCartProduct_Productdatatitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductDataInformation") )
            {
               gxTv_SdtNMCartProduct_Productdatainformation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductDataImage") )
            {
               gxTv_SdtNMCartProduct_Productdataimage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductDataImage_GXI") )
            {
               gxTv_SdtNMCartProduct_Productdataimage_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Talla") )
            {
               gxTv_SdtNMCartProduct_Talla = (long)(getnumericvalue(oReader.getValue())) ;
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
         sName = "NMCartProduct" ;
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
      oWriter.writeElement("ProductId", gxTv_SdtNMCartProduct_Productid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Count", GXutil.trim( GXutil.str( gxTv_SdtNMCartProduct_Count, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Color", gxTv_SdtNMCartProduct_Color);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Variant", gxTv_SdtNMCartProduct_Variant);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Promotion", gxTv_SdtNMCartProduct_Promotion);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( gxTv_SdtNMCartProduct_Productdata != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtNMCartProduct_Productdata.writexml(oWriter, "ProductData", sNameSpace1);
      }
      oWriter.writeElement("ProductDataTitle", gxTv_SdtNMCartProduct_Productdatatitle);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductDataInformation", gxTv_SdtNMCartProduct_Productdatainformation);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductDataImage", gxTv_SdtNMCartProduct_Productdataimage);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductDataImage_GXI", gxTv_SdtNMCartProduct_Productdataimage_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Talla", GXutil.trim( GXutil.str( gxTv_SdtNMCartProduct_Talla, 11, 0)));
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
      AddObjectProperty("ProductId", gxTv_SdtNMCartProduct_Productid, false, false);
      AddObjectProperty("Count", gxTv_SdtNMCartProduct_Count, false, false);
      AddObjectProperty("Color", gxTv_SdtNMCartProduct_Color, false, false);
      AddObjectProperty("Variant", gxTv_SdtNMCartProduct_Variant, false, false);
      AddObjectProperty("Promotion", gxTv_SdtNMCartProduct_Promotion, false, false);
      if ( gxTv_SdtNMCartProduct_Productdata != null )
      {
         AddObjectProperty("ProductData", gxTv_SdtNMCartProduct_Productdata, false, false);
      }
      AddObjectProperty("ProductDataTitle", gxTv_SdtNMCartProduct_Productdatatitle, false, false);
      AddObjectProperty("ProductDataInformation", gxTv_SdtNMCartProduct_Productdatainformation, false, false);
      AddObjectProperty("ProductDataImage", gxTv_SdtNMCartProduct_Productdataimage, false, false);
      AddObjectProperty("ProductDataImage_GXI", gxTv_SdtNMCartProduct_Productdataimage_gxi, false, false);
      AddObjectProperty("Talla", gxTv_SdtNMCartProduct_Talla, false, false);
   }

   public String getgxTv_SdtNMCartProduct_Productid( )
   {
      return gxTv_SdtNMCartProduct_Productid ;
   }

   public void setgxTv_SdtNMCartProduct_Productid( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productid = value ;
   }

   public short getgxTv_SdtNMCartProduct_Count( )
   {
      return gxTv_SdtNMCartProduct_Count ;
   }

   public void setgxTv_SdtNMCartProduct_Count( short value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Count = value ;
   }

   public String getgxTv_SdtNMCartProduct_Color( )
   {
      return gxTv_SdtNMCartProduct_Color ;
   }

   public void setgxTv_SdtNMCartProduct_Color( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Color = value ;
   }

   public String getgxTv_SdtNMCartProduct_Variant( )
   {
      return gxTv_SdtNMCartProduct_Variant ;
   }

   public void setgxTv_SdtNMCartProduct_Variant( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Variant = value ;
   }

   public String getgxTv_SdtNMCartProduct_Promotion( )
   {
      return gxTv_SdtNMCartProduct_Promotion ;
   }

   public void setgxTv_SdtNMCartProduct_Promotion( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Promotion = value ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductData getgxTv_SdtNMCartProduct_Productdata( )
   {
      if ( gxTv_SdtNMCartProduct_Productdata == null )
      {
         gxTv_SdtNMCartProduct_Productdata = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      }
      gxTv_SdtNMCartProduct_Productdata_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      return gxTv_SdtNMCartProduct_Productdata ;
   }

   public void setgxTv_SdtNMCartProduct_Productdata( com.mujermorena.workwithplus.nativemobile.SdtWWPProductData value )
   {
      gxTv_SdtNMCartProduct_Productdata_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdata = value;
   }

   public void setgxTv_SdtNMCartProduct_Productdata_SetNull( )
   {
      gxTv_SdtNMCartProduct_Productdata_N = (byte)(1) ;
      gxTv_SdtNMCartProduct_Productdata = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)null;
   }

   public boolean getgxTv_SdtNMCartProduct_Productdata_IsNull( )
   {
      if ( gxTv_SdtNMCartProduct_Productdata == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtNMCartProduct_Productdata_N( )
   {
      return gxTv_SdtNMCartProduct_Productdata_N ;
   }

   public String getgxTv_SdtNMCartProduct_Productdatatitle( )
   {
      return gxTv_SdtNMCartProduct_Productdatatitle ;
   }

   public void setgxTv_SdtNMCartProduct_Productdatatitle( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdatatitle = value ;
   }

   public String getgxTv_SdtNMCartProduct_Productdatainformation( )
   {
      return gxTv_SdtNMCartProduct_Productdatainformation ;
   }

   public void setgxTv_SdtNMCartProduct_Productdatainformation( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdatainformation = value ;
   }

   @GxUpload
   public String getgxTv_SdtNMCartProduct_Productdataimage( )
   {
      return gxTv_SdtNMCartProduct_Productdataimage ;
   }

   public void setgxTv_SdtNMCartProduct_Productdataimage( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdataimage = value ;
   }

   public String getgxTv_SdtNMCartProduct_Productdataimage_gxi( )
   {
      return gxTv_SdtNMCartProduct_Productdataimage_gxi ;
   }

   public void setgxTv_SdtNMCartProduct_Productdataimage_gxi( String value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Productdataimage_gxi = value ;
   }

   public long getgxTv_SdtNMCartProduct_Talla( )
   {
      return gxTv_SdtNMCartProduct_Talla ;
   }

   public void setgxTv_SdtNMCartProduct_Talla( long value )
   {
      gxTv_SdtNMCartProduct_N = (byte)(0) ;
      gxTv_SdtNMCartProduct_Talla = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtNMCartProduct_Productid = "" ;
      gxTv_SdtNMCartProduct_N = (byte)(1) ;
      gxTv_SdtNMCartProduct_Color = "" ;
      gxTv_SdtNMCartProduct_Variant = "" ;
      gxTv_SdtNMCartProduct_Promotion = "" ;
      gxTv_SdtNMCartProduct_Productdata_N = (byte)(1) ;
      gxTv_SdtNMCartProduct_Productdatatitle = "" ;
      gxTv_SdtNMCartProduct_Productdatainformation = "" ;
      gxTv_SdtNMCartProduct_Productdataimage = "" ;
      gxTv_SdtNMCartProduct_Productdataimage_gxi = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtNMCartProduct_N ;
   }

   public com.mujermorena.SdtNMCartProduct Clone( )
   {
      return (com.mujermorena.SdtNMCartProduct)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtNMCartProduct struct )
   {
      setgxTv_SdtNMCartProduct_Productid(struct.getProductid());
      setgxTv_SdtNMCartProduct_Count(struct.getCount());
      setgxTv_SdtNMCartProduct_Color(struct.getColor());
      setgxTv_SdtNMCartProduct_Variant(struct.getVariant());
      setgxTv_SdtNMCartProduct_Promotion(struct.getPromotion());
      setgxTv_SdtNMCartProduct_Productdata(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(struct.getProductdata()));
      setgxTv_SdtNMCartProduct_Productdatatitle(struct.getProductdatatitle());
      setgxTv_SdtNMCartProduct_Productdatainformation(struct.getProductdatainformation());
      setgxTv_SdtNMCartProduct_Productdataimage(struct.getProductdataimage());
      setgxTv_SdtNMCartProduct_Productdataimage_gxi(struct.getProductdataimage_gxi());
      setgxTv_SdtNMCartProduct_Talla(struct.getTalla());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtNMCartProduct getStruct( )
   {
      com.mujermorena.StructSdtNMCartProduct struct = new com.mujermorena.StructSdtNMCartProduct ();
      struct.setProductid(getgxTv_SdtNMCartProduct_Productid());
      struct.setCount(getgxTv_SdtNMCartProduct_Count());
      struct.setColor(getgxTv_SdtNMCartProduct_Color());
      struct.setVariant(getgxTv_SdtNMCartProduct_Variant());
      struct.setPromotion(getgxTv_SdtNMCartProduct_Promotion());
      struct.setProductdata(getgxTv_SdtNMCartProduct_Productdata().getStruct());
      struct.setProductdatatitle(getgxTv_SdtNMCartProduct_Productdatatitle());
      struct.setProductdatainformation(getgxTv_SdtNMCartProduct_Productdatainformation());
      struct.setProductdataimage(getgxTv_SdtNMCartProduct_Productdataimage());
      struct.setProductdataimage_gxi(getgxTv_SdtNMCartProduct_Productdataimage_gxi());
      struct.setTalla(getgxTv_SdtNMCartProduct_Talla());
      return struct ;
   }

   protected byte gxTv_SdtNMCartProduct_N ;
   protected byte gxTv_SdtNMCartProduct_Productdata_N ;
   protected short gxTv_SdtNMCartProduct_Count ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtNMCartProduct_Talla ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtNMCartProduct_Productid ;
   protected String gxTv_SdtNMCartProduct_Color ;
   protected String gxTv_SdtNMCartProduct_Variant ;
   protected String gxTv_SdtNMCartProduct_Promotion ;
   protected String gxTv_SdtNMCartProduct_Productdatatitle ;
   protected String gxTv_SdtNMCartProduct_Productdatainformation ;
   protected String gxTv_SdtNMCartProduct_Productdataimage_gxi ;
   protected String gxTv_SdtNMCartProduct_Productdataimage ;
   protected com.mujermorena.workwithplus.nativemobile.SdtWWPProductData gxTv_SdtNMCartProduct_Productdata=null ;
}

