package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtNMCartPayment extends GxUserType
{
   public SdtNMCartPayment( )
   {
      this(  new ModelContext(SdtNMCartPayment.class));
   }

   public SdtNMCartPayment( ModelContext context )
   {
      super( context, "SdtNMCartPayment");
   }

   public SdtNMCartPayment( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtNMCartPayment");
   }

   public SdtNMCartPayment( StructSdtNMCartPayment struct )
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
               gxTv_SdtNMCartPayment_Id = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "VisibleName") )
            {
               gxTv_SdtNMCartPayment_Visiblename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Owner") )
            {
               gxTv_SdtNMCartPayment_Owner = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Valid") )
            {
               gxTv_SdtNMCartPayment_Valid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Selected") )
            {
               gxTv_SdtNMCartPayment_Selected = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Imagen") )
            {
               gxTv_SdtNMCartPayment_Imagen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Imagen_GXI") )
            {
               gxTv_SdtNMCartPayment_Imagen_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NroComprobante") )
            {
               gxTv_SdtNMCartPayment_Nrocomprobante = oReader.getValue() ;
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
         sName = "NMCartPayment" ;
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
      oWriter.writeElement("Id", GXutil.trim( GXutil.str( gxTv_SdtNMCartPayment_Id, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("VisibleName", gxTv_SdtNMCartPayment_Visiblename);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Owner", gxTv_SdtNMCartPayment_Owner);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Valid", gxTv_SdtNMCartPayment_Valid);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Selected", GXutil.booltostr( gxTv_SdtNMCartPayment_Selected));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Imagen", gxTv_SdtNMCartPayment_Imagen);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Imagen_GXI", gxTv_SdtNMCartPayment_Imagen_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("NroComprobante", gxTv_SdtNMCartPayment_Nrocomprobante);
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
      AddObjectProperty("Id", gxTv_SdtNMCartPayment_Id, false, false);
      AddObjectProperty("VisibleName", gxTv_SdtNMCartPayment_Visiblename, false, false);
      AddObjectProperty("Owner", gxTv_SdtNMCartPayment_Owner, false, false);
      AddObjectProperty("Valid", gxTv_SdtNMCartPayment_Valid, false, false);
      AddObjectProperty("Selected", gxTv_SdtNMCartPayment_Selected, false, false);
      AddObjectProperty("Imagen", gxTv_SdtNMCartPayment_Imagen, false, false);
      AddObjectProperty("Imagen_GXI", gxTv_SdtNMCartPayment_Imagen_gxi, false, false);
      AddObjectProperty("NroComprobante", gxTv_SdtNMCartPayment_Nrocomprobante, false, false);
   }

   public long getgxTv_SdtNMCartPayment_Id( )
   {
      return gxTv_SdtNMCartPayment_Id ;
   }

   public void setgxTv_SdtNMCartPayment_Id( long value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Id = value ;
   }

   public String getgxTv_SdtNMCartPayment_Visiblename( )
   {
      return gxTv_SdtNMCartPayment_Visiblename ;
   }

   public void setgxTv_SdtNMCartPayment_Visiblename( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Visiblename = value ;
   }

   public String getgxTv_SdtNMCartPayment_Owner( )
   {
      return gxTv_SdtNMCartPayment_Owner ;
   }

   public void setgxTv_SdtNMCartPayment_Owner( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Owner = value ;
   }

   public String getgxTv_SdtNMCartPayment_Valid( )
   {
      return gxTv_SdtNMCartPayment_Valid ;
   }

   public void setgxTv_SdtNMCartPayment_Valid( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Valid = value ;
   }

   public boolean getgxTv_SdtNMCartPayment_Selected( )
   {
      return gxTv_SdtNMCartPayment_Selected ;
   }

   public void setgxTv_SdtNMCartPayment_Selected( boolean value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Selected = value ;
   }

   @GxUpload
   public String getgxTv_SdtNMCartPayment_Imagen( )
   {
      return gxTv_SdtNMCartPayment_Imagen ;
   }

   public void setgxTv_SdtNMCartPayment_Imagen( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Imagen = value ;
   }

   public String getgxTv_SdtNMCartPayment_Imagen_gxi( )
   {
      return gxTv_SdtNMCartPayment_Imagen_gxi ;
   }

   public void setgxTv_SdtNMCartPayment_Imagen_gxi( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Imagen_gxi = value ;
   }

   public String getgxTv_SdtNMCartPayment_Nrocomprobante( )
   {
      return gxTv_SdtNMCartPayment_Nrocomprobante ;
   }

   public void setgxTv_SdtNMCartPayment_Nrocomprobante( String value )
   {
      gxTv_SdtNMCartPayment_N = (byte)(0) ;
      gxTv_SdtNMCartPayment_Nrocomprobante = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtNMCartPayment_N = (byte)(1) ;
      gxTv_SdtNMCartPayment_Visiblename = "" ;
      gxTv_SdtNMCartPayment_Owner = "" ;
      gxTv_SdtNMCartPayment_Valid = "" ;
      gxTv_SdtNMCartPayment_Imagen = "" ;
      gxTv_SdtNMCartPayment_Imagen_gxi = "" ;
      gxTv_SdtNMCartPayment_Nrocomprobante = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtNMCartPayment_N ;
   }

   public com.mujermorena.SdtNMCartPayment Clone( )
   {
      return (com.mujermorena.SdtNMCartPayment)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtNMCartPayment struct )
   {
      setgxTv_SdtNMCartPayment_Id(struct.getId());
      setgxTv_SdtNMCartPayment_Visiblename(struct.getVisiblename());
      setgxTv_SdtNMCartPayment_Owner(struct.getOwner());
      setgxTv_SdtNMCartPayment_Valid(struct.getValid());
      setgxTv_SdtNMCartPayment_Selected(struct.getSelected());
      setgxTv_SdtNMCartPayment_Imagen(struct.getImagen());
      setgxTv_SdtNMCartPayment_Imagen_gxi(struct.getImagen_gxi());
      setgxTv_SdtNMCartPayment_Nrocomprobante(struct.getNrocomprobante());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtNMCartPayment getStruct( )
   {
      com.mujermorena.StructSdtNMCartPayment struct = new com.mujermorena.StructSdtNMCartPayment ();
      struct.setId(getgxTv_SdtNMCartPayment_Id());
      struct.setVisiblename(getgxTv_SdtNMCartPayment_Visiblename());
      struct.setOwner(getgxTv_SdtNMCartPayment_Owner());
      struct.setValid(getgxTv_SdtNMCartPayment_Valid());
      struct.setSelected(getgxTv_SdtNMCartPayment_Selected());
      struct.setImagen(getgxTv_SdtNMCartPayment_Imagen());
      struct.setImagen_gxi(getgxTv_SdtNMCartPayment_Imagen_gxi());
      struct.setNrocomprobante(getgxTv_SdtNMCartPayment_Nrocomprobante());
      return struct ;
   }

   protected byte gxTv_SdtNMCartPayment_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_SdtNMCartPayment_Id ;
   protected String sTagName ;
   protected boolean gxTv_SdtNMCartPayment_Selected ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtNMCartPayment_Visiblename ;
   protected String gxTv_SdtNMCartPayment_Owner ;
   protected String gxTv_SdtNMCartPayment_Valid ;
   protected String gxTv_SdtNMCartPayment_Imagen_gxi ;
   protected String gxTv_SdtNMCartPayment_Nrocomprobante ;
   protected String gxTv_SdtNMCartPayment_Imagen ;
}

