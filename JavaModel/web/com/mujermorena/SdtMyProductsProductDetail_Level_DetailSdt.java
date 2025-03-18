package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMyProductsProductDetail_Level_DetailSdt extends GxUserType
{
   public SdtMyProductsProductDetail_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMyProductsProductDetail_Level_DetailSdt.class));
   }

   public SdtMyProductsProductDetail_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMyProductsProductDetail_Level_DetailSdt");
   }

   public SdtMyProductsProductDetail_Level_DetailSdt( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtMyProductsProductDetail_Level_DetailSdt");
   }

   public SdtMyProductsProductDetail_Level_DetailSdt( StructSdtMyProductsProductDetail_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Productdataimages") )
            {
               if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages == null )
               {
                  gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages.readxml(oReader, "Productdataimages") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Productdataimages") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Productdata") )
            {
               if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata == null )
               {
                  gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata.readxml(oReader, "Productdata") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Rating") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Cantidad") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Talle") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Productdispon") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Productid") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdesc_talle") )
            {
               gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle = oReader.getValue() ;
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
         sName = "MyProductsProductDetail_Level_DetailSdt" ;
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
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "http://tempuri.org/" ;
         }
         else
         {
            sNameSpace1 = "http://tempuri.org/" ;
         }
         gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages.writexml(oWriter, "Productdataimages", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "http://tempuri.org/" ;
         }
         else
         {
            sNameSpace1 = "http://tempuri.org/" ;
         }
         gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata.writexml(oWriter, "Productdata", sNameSpace1);
      }
      oWriter.writeElement("Rating", GXutil.trim( GXutil.str( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Cantidad", GXutil.trim( GXutil.str( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Talle", GXutil.trim( GXutil.str( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Productdispon", GXutil.trim( GXutil.str( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Productid", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdesc_talle", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
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
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages != null )
      {
         AddObjectProperty("Productdataimages", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages, false, false);
      }
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata != null )
      {
         AddObjectProperty("Productdata", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata, false, false);
      }
      AddObjectProperty("Rating", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating, false, false);
      AddObjectProperty("Cantidad", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad, false, false);
      AddObjectProperty("Talle", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle, false, false);
      AddObjectProperty("Productdispon", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon, false, false);
      AddObjectProperty("Productid", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid, false, false);
      AddObjectProperty("Gxdynprop", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop, false, false);
      AddObjectProperty("Gxdesc_talle", gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle, false, false);
   }

   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages( )
   {
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages == null )
      {
         gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages = value ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_SetNull( )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages = null ;
   }

   public boolean getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_IsNull( )
   {
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages == null )
      {
         return true ;
      }
      return false ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtWWPProductData getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata( )
   {
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata == null )
      {
         gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      }
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata( com.mujermorena.workwithplus.nativemobile.SdtWWPProductData value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata = value;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata_SetNull( )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)null;
   }

   public boolean getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata_IsNull( )
   {
      if ( gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata == null )
      {
         return true ;
      }
      return false ;
   }

   public short getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating( short value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating = value ;
   }

   public int getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad( int value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad = value ;
   }

   public int getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle( int value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle = value ;
   }

   public short getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon( short value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon = value ;
   }

   public String getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid( String value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid = value ;
   }

   public String getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop = value ;
   }

   public String getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle ;
   }

   public void setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle( String value )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid = "" ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop = "" ;
      gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMyProductsProductDetail_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMyProductsProductDetail_Level_DetailSdt struct )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages.class, "WWPProductDataImages", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductDataImages> gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux1 = struct.getProductdataimages();
      if (gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux1.size(); i++)
         {
            gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux.add(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages(gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages(gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux);
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(struct.getProductdata()));
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating(struct.getRating());
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad(struct.getCantidad());
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle(struct.getTalle());
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon(struct.getProductdispon());
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid(struct.getProductid());
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
      setgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle(struct.getGxdesc_talle());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMyProductsProductDetail_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMyProductsProductDetail_Level_DetailSdt struct = new com.mujermorena.StructSdtMyProductsProductDetail_Level_DetailSdt ();
      struct.setProductdataimages(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages().getStruct());
      struct.setProductdata(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata().getStruct());
      struct.setRating(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating());
      struct.setCantidad(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad());
      struct.setTalle(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle());
      struct.setProductdispon(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon());
      struct.setProductid(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid());
      struct.setGxdynprop(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop());
      struct.setGxdesc_talle(getgxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle());
      return struct ;
   }

   protected byte gxTv_SdtMyProductsProductDetail_Level_DetailSdt_N ;
   protected short gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Rating ;
   protected short gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdispon ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Cantidad ;
   protected int gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Talle ;
   protected String gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productid ;
   protected String gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Gxdesc_talle ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages_aux ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductDataImages> gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdataimages=null ;
   protected com.mujermorena.workwithplus.nativemobile.SdtWWPProductData gxTv_SdtMyProductsProductDetail_Level_DetailSdt_Productdata=null ;
}

