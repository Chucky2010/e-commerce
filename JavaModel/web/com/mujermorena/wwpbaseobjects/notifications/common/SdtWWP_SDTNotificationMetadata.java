package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_SDTNotificationMetadata extends GxUserType
{
   public SdtWWP_SDTNotificationMetadata( )
   {
      this(  new ModelContext(SdtWWP_SDTNotificationMetadata.class));
   }

   public SdtWWP_SDTNotificationMetadata( ModelContext context )
   {
      super( context, "SdtWWP_SDTNotificationMetadata");
   }

   public SdtWWP_SDTNotificationMetadata( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_SDTNotificationMetadata");
   }

   public SdtWWP_SDTNotificationMetadata( StructSdtWWP_SDTNotificationMetadata struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Timeout") )
            {
               gxTv_SdtWWP_SDTNotificationMetadata_Timeout = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SessionKey") )
            {
               gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SessionValue") )
            {
               gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue = oReader.getValue() ;
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
         sName = "WWP_SDTNotificationMetadata" ;
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
      oWriter.writeElement("Timeout", GXutil.trim( GXutil.str( gxTv_SdtWWP_SDTNotificationMetadata_Timeout, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("SessionKey", gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("SessionValue", gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue);
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
      AddObjectProperty("Timeout", gxTv_SdtWWP_SDTNotificationMetadata_Timeout, false, false);
      AddObjectProperty("SessionKey", gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey, false, false);
      AddObjectProperty("SessionValue", gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue, false, false);
   }

   public int getgxTv_SdtWWP_SDTNotificationMetadata_Timeout( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_Timeout ;
   }

   public void setgxTv_SdtWWP_SDTNotificationMetadata_Timeout( int value )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Timeout = value ;
   }

   public String getgxTv_SdtWWP_SDTNotificationMetadata_Sessionkey( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey ;
   }

   public void setgxTv_SdtWWP_SDTNotificationMetadata_Sessionkey( String value )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey = value ;
   }

   public String getgxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue ;
   }

   public void setgxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue( String value )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWP_SDTNotificationMetadata_N = (byte)(1) ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey = "" ;
      gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_SDTNotificationMetadata_N ;
   }

   public com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationMetadata Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationMetadata)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_SDTNotificationMetadata struct )
   {
      setgxTv_SdtWWP_SDTNotificationMetadata_Timeout(struct.getTimeout());
      setgxTv_SdtWWP_SDTNotificationMetadata_Sessionkey(struct.getSessionkey());
      setgxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue(struct.getSessionvalue());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_SDTNotificationMetadata getStruct( )
   {
      com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_SDTNotificationMetadata struct = new com.mujermorena.wwpbaseobjects.notifications.common.StructSdtWWP_SDTNotificationMetadata ();
      struct.setTimeout(getgxTv_SdtWWP_SDTNotificationMetadata_Timeout());
      struct.setSessionkey(getgxTv_SdtWWP_SDTNotificationMetadata_Sessionkey());
      struct.setSessionvalue(getgxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue());
      return struct ;
   }

   protected byte gxTv_SdtWWP_SDTNotificationMetadata_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtWWP_SDTNotificationMetadata_Timeout ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWP_SDTNotificationMetadata_Sessionkey ;
   protected String gxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue ;
}

