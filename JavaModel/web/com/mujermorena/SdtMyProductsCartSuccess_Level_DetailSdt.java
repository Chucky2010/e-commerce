package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMyProductsCartSuccess_Level_DetailSdt extends GxUserType
{
   public SdtMyProductsCartSuccess_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMyProductsCartSuccess_Level_DetailSdt.class));
   }

   public SdtMyProductsCartSuccess_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMyProductsCartSuccess_Level_DetailSdt");
   }

   public SdtMyProductsCartSuccess_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtMyProductsCartSuccess_Level_DetailSdt");
   }

   public SdtMyProductsCartSuccess_Level_DetailSdt( StructSdtMyProductsCartSuccess_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Calificacionnro") )
            {
               gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "MyProductsCartSuccess_Level_DetailSdt" ;
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
      oWriter.writeElement("Calificacionnro", GXutil.trim( GXutil.str( gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro, 4, 0)));
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
      AddObjectProperty("Calificacionnro", gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro, false, false);
   }

   public short getgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro( )
   {
      return gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro ;
   }

   public void setgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro( short value )
   {
      gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMyProductsCartSuccess_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMyProductsCartSuccess_Level_DetailSdt struct )
   {
      setgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro(struct.getCalificacionnro());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMyProductsCartSuccess_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMyProductsCartSuccess_Level_DetailSdt struct = new com.mujermorena.StructSdtMyProductsCartSuccess_Level_DetailSdt ();
      struct.setCalificacionnro(getgxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro());
      return struct ;
   }

   protected byte gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_N ;
   protected short gxTv_SdtMyProductsCartSuccess_Level_DetailSdt_Calificacionnro ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

