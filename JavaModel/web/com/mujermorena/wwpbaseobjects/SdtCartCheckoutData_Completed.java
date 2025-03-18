package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCartCheckoutData_Completed extends GxUserType
{
   public SdtCartCheckoutData_Completed( )
   {
      this(  new ModelContext(SdtCartCheckoutData_Completed.class));
   }

   public SdtCartCheckoutData_Completed( ModelContext context )
   {
      super( context, "SdtCartCheckoutData_Completed");
   }

   public SdtCartCheckoutData_Completed( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtCartCheckoutData_Completed");
   }

   public SdtCartCheckoutData_Completed( StructSdtCartCheckoutData_Completed struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Calificacion") )
            {
               gxTv_SdtCartCheckoutData_Completed_Calificacion = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Comentario") )
            {
               gxTv_SdtCartCheckoutData_Completed_Comentario = oReader.getValue() ;
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
         sName = "CartCheckoutData.Completed" ;
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
      oWriter.writeElement("Calificacion", GXutil.trim( GXutil.str( gxTv_SdtCartCheckoutData_Completed_Calificacion, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Comentario", gxTv_SdtCartCheckoutData_Completed_Comentario);
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
      AddObjectProperty("Calificacion", gxTv_SdtCartCheckoutData_Completed_Calificacion, false, false);
      AddObjectProperty("Comentario", gxTv_SdtCartCheckoutData_Completed_Comentario, false, false);
   }

   public short getgxTv_SdtCartCheckoutData_Completed_Calificacion( )
   {
      return gxTv_SdtCartCheckoutData_Completed_Calificacion ;
   }

   public void setgxTv_SdtCartCheckoutData_Completed_Calificacion( short value )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Completed_Calificacion = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Completed_Comentario( )
   {
      return gxTv_SdtCartCheckoutData_Completed_Comentario ;
   }

   public void setgxTv_SdtCartCheckoutData_Completed_Comentario( String value )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Completed_Comentario = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Completed_Comentario = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCartCheckoutData_Completed_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed struct )
   {
      setgxTv_SdtCartCheckoutData_Completed_Calificacion(struct.getCalificacion());
      setgxTv_SdtCartCheckoutData_Completed_Comentario(struct.getComentario());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed struct = new com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Completed ();
      struct.setCalificacion(getgxTv_SdtCartCheckoutData_Completed_Calificacion());
      struct.setComentario(getgxTv_SdtCartCheckoutData_Completed_Comentario());
      return struct ;
   }

   protected byte gxTv_SdtCartCheckoutData_Completed_N ;
   protected short gxTv_SdtCartCheckoutData_Completed_Calificacion ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtCartCheckoutData_Completed_Comentario ;
}

