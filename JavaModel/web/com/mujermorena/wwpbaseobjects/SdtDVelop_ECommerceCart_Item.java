package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVelop_ECommerceCart_Item extends GxUserType
{
   public SdtDVelop_ECommerceCart_Item( )
   {
      this(  new ModelContext(SdtDVelop_ECommerceCart_Item.class));
   }

   public SdtDVelop_ECommerceCart_Item( ModelContext context )
   {
      super( context, "SdtDVelop_ECommerceCart_Item");
   }

   public SdtDVelop_ECommerceCart_Item( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtDVelop_ECommerceCart_Item");
   }

   public SdtDVelop_ECommerceCart_Item( StructSdtDVelop_ECommerceCart_Item struct )
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
               gxTv_SdtDVelop_ECommerceCart_Item_Productid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductName") )
            {
               gxTv_SdtDVelop_ECommerceCart_Item_Productname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductDescription") )
            {
               gxTv_SdtDVelop_ECommerceCart_Item_Productdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductSim") )
            {
               gxTv_SdtDVelop_ECommerceCart_Item_Productsim = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductPrice") )
            {
               gxTv_SdtDVelop_ECommerceCart_Item_Productprice = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductQty") )
            {
               gxTv_SdtDVelop_ECommerceCart_Item_Productqty = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductTalle") )
            {
               gxTv_SdtDVelop_ECommerceCart_Item_Producttalle = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Images") )
            {
               if ( gxTv_SdtDVelop_ECommerceCart_Item_Images == null )
               {
                  gxTv_SdtDVelop_ECommerceCart_Item_Images = new GXSimpleCollection<String>();
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtDVelop_ECommerceCart_Item_Images.readxmlcollection(oReader, "Images", "ProductImage") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Images") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Images_GXI") )
            {
               if ( gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi == null )
               {
                  gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi = new GXSimpleCollection<String>(String.class, "internal", "");
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi.readxml(oReader, "Images_GXI") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Images_GXI") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "DVelop_ECommerceCart.Item" ;
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
      oWriter.writeElement("ProductId", GXutil.trim( GXutil.str( gxTv_SdtDVelop_ECommerceCart_Item_Productid, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductName", gxTv_SdtDVelop_ECommerceCart_Item_Productname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductDescription", gxTv_SdtDVelop_ECommerceCart_Item_Productdescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductSim", gxTv_SdtDVelop_ECommerceCart_Item_Productsim);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductPrice", GXutil.trim( GXutil.strNoRound( gxTv_SdtDVelop_ECommerceCart_Item_Productprice, 8, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductQty", GXutil.trim( GXutil.str( gxTv_SdtDVelop_ECommerceCart_Item_Productqty, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ProductTalle", GXutil.trim( GXutil.str( gxTv_SdtDVelop_ECommerceCart_Item_Producttalle, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images != null )
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
         gxTv_SdtDVelop_ECommerceCart_Item_Images.writexmlcollection(oWriter, "Images", sNameSpace1, "ProductImage", sNameSpace1);
      }
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi != null )
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
         gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi.writexml(oWriter, "Images_GXI", sNameSpace1, sIncludeState);
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
      AddObjectProperty("ProductId", gxTv_SdtDVelop_ECommerceCart_Item_Productid, false, false);
      AddObjectProperty("ProductName", gxTv_SdtDVelop_ECommerceCart_Item_Productname, false, false);
      AddObjectProperty("ProductDescription", gxTv_SdtDVelop_ECommerceCart_Item_Productdescription, false, false);
      AddObjectProperty("ProductSim", gxTv_SdtDVelop_ECommerceCart_Item_Productsim, false, false);
      AddObjectProperty("ProductPrice", gxTv_SdtDVelop_ECommerceCart_Item_Productprice, false, false);
      AddObjectProperty("ProductQty", gxTv_SdtDVelop_ECommerceCart_Item_Productqty, false, false);
      AddObjectProperty("ProductTalle", gxTv_SdtDVelop_ECommerceCart_Item_Producttalle, false, false);
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images != null )
      {
         AddObjectProperty("Images", gxTv_SdtDVelop_ECommerceCart_Item_Images, false, false);
      }
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi != null )
      {
         AddObjectProperty("Images_GXI", gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi, false, false);
      }
   }

   public int getgxTv_SdtDVelop_ECommerceCart_Item_Productid( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productid ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Productid( int value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productid = value ;
   }

   public String getgxTv_SdtDVelop_ECommerceCart_Item_Productname( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productname ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Productname( String value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productname = value ;
   }

   public String getgxTv_SdtDVelop_ECommerceCart_Item_Productdescription( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productdescription ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Productdescription( String value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productdescription = value ;
   }

   public String getgxTv_SdtDVelop_ECommerceCart_Item_Productsim( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productsim ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Productsim( String value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productsim = value ;
   }

   public java.math.BigDecimal getgxTv_SdtDVelop_ECommerceCart_Item_Productprice( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productprice ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Productprice( java.math.BigDecimal value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productprice = value ;
   }

   public short getgxTv_SdtDVelop_ECommerceCart_Item_Productqty( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Productqty ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Productqty( short value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productqty = value ;
   }

   public short getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Producttalle ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Producttalle( short value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Producttalle = value ;
   }

   public GXSimpleCollection<String> getgxTv_SdtDVelop_ECommerceCart_Item_Images( )
   {
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images == null )
      {
         gxTv_SdtDVelop_ECommerceCart_Item_Images = new GXSimpleCollection<String>();
      }
      gxTv_SdtDVelop_ECommerceCart_Item_Images_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      return gxTv_SdtDVelop_ECommerceCart_Item_Images ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Images( GXSimpleCollection<String> value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_Images_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images = value ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Images_SetNull( )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_Images_N = (byte)(1) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images = null ;
   }

   public boolean getgxTv_SdtDVelop_ECommerceCart_Item_Images_IsNull( )
   {
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtDVelop_ECommerceCart_Item_Images_N( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_Images_N ;
   }

   public GXSimpleCollection<String> getgxTv_SdtDVelop_ECommerceCart_Item_Images_gxi( )
   {
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi == null )
      {
         gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi = new GXSimpleCollection<String>(String.class, "internal", "");
      }
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      return gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Images_gxi( GXSimpleCollection<String> value )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(0) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi = value ;
   }

   public void setgxTv_SdtDVelop_ECommerceCart_Item_Images_gxi_SetNull( )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi = null ;
   }

   public boolean getgxTv_SdtDVelop_ECommerceCart_Item_Images_gxi_IsNull( )
   {
      if ( gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi == null )
      {
         return true ;
      }
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVelop_ECommerceCart_Item_N = (byte)(1) ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productname = "" ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productdescription = "" ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productsim = "" ;
      gxTv_SdtDVelop_ECommerceCart_Item_Productprice = DecimalUtil.ZERO ;
      gxTv_SdtDVelop_ECommerceCart_Item_Images_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtDVelop_ECommerceCart_Item_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item struct )
   {
      setgxTv_SdtDVelop_ECommerceCart_Item_Productid(struct.getProductid());
      setgxTv_SdtDVelop_ECommerceCart_Item_Productname(struct.getProductname());
      setgxTv_SdtDVelop_ECommerceCart_Item_Productdescription(struct.getProductdescription());
      setgxTv_SdtDVelop_ECommerceCart_Item_Productsim(struct.getProductsim());
      setgxTv_SdtDVelop_ECommerceCart_Item_Productprice(struct.getProductprice());
      setgxTv_SdtDVelop_ECommerceCart_Item_Productqty(struct.getProductqty());
      setgxTv_SdtDVelop_ECommerceCart_Item_Producttalle(struct.getProducttalle());
      setgxTv_SdtDVelop_ECommerceCart_Item_Images(new GXSimpleCollection<String>());
      setgxTv_SdtDVelop_ECommerceCart_Item_Images_gxi(new GXSimpleCollection<String>(String.class, "internal", "", struct.getImages_gxi()));
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item struct = new com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item ();
      struct.setProductid(getgxTv_SdtDVelop_ECommerceCart_Item_Productid());
      struct.setProductname(getgxTv_SdtDVelop_ECommerceCart_Item_Productname());
      struct.setProductdescription(getgxTv_SdtDVelop_ECommerceCart_Item_Productdescription());
      struct.setProductsim(getgxTv_SdtDVelop_ECommerceCart_Item_Productsim());
      struct.setProductprice(getgxTv_SdtDVelop_ECommerceCart_Item_Productprice());
      struct.setProductqty(getgxTv_SdtDVelop_ECommerceCart_Item_Productqty());
      struct.setProducttalle(getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle());
      struct.setImages(getgxTv_SdtDVelop_ECommerceCart_Item_Images().getStruct());
      struct.setImages_gxi(getgxTv_SdtDVelop_ECommerceCart_Item_Images_gxi().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtDVelop_ECommerceCart_Item_N ;
   protected byte gxTv_SdtDVelop_ECommerceCart_Item_Images_N ;
   protected short gxTv_SdtDVelop_ECommerceCart_Item_Productqty ;
   protected short gxTv_SdtDVelop_ECommerceCart_Item_Producttalle ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtDVelop_ECommerceCart_Item_Productid ;
   protected java.math.BigDecimal gxTv_SdtDVelop_ECommerceCart_Item_Productprice ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVelop_ECommerceCart_Item_Productname ;
   protected String gxTv_SdtDVelop_ECommerceCart_Item_Productdescription ;
   protected String gxTv_SdtDVelop_ECommerceCart_Item_Productsim ;
   protected GXSimpleCollection<String> gxTv_SdtDVelop_ECommerceCart_Item_Images_gxi=null ;
   protected GXSimpleCollection<String> gxTv_SdtDVelop_ECommerceCart_Item_Images=null ;
}

