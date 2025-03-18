package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPColumnsSelector extends GxUserType
{
   public SdtWWPColumnsSelector( )
   {
      this(  new ModelContext(SdtWWPColumnsSelector.class));
   }

   public SdtWWPColumnsSelector( ModelContext context )
   {
      super( context, "SdtWWPColumnsSelector");
   }

   public SdtWWPColumnsSelector( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPColumnsSelector");
   }

   public SdtWWPColumnsSelector( StructSdtWWPColumnsSelector struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Columns") )
            {
               if ( gxTv_SdtWWPColumnsSelector_Columns == null )
               {
                  gxTv_SdtWWPColumnsSelector_Columns = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column>(com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column.class, "WWPColumnsSelector.Column", "Mujer_Morena", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtWWPColumnsSelector_Columns.readxmlcollection(oReader, "Columns", "Column") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Columns") )
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
         sName = "WWPColumnsSelector" ;
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
      if ( gxTv_SdtWWPColumnsSelector_Columns != null )
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
         gxTv_SdtWWPColumnsSelector_Columns.writexmlcollection(oWriter, "Columns", sNameSpace1, "Column", sNameSpace1);
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
      if ( gxTv_SdtWWPColumnsSelector_Columns != null )
      {
         AddObjectProperty("Columns", gxTv_SdtWWPColumnsSelector_Columns, false, false);
      }
   }

   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column> getgxTv_SdtWWPColumnsSelector_Columns( )
   {
      if ( gxTv_SdtWWPColumnsSelector_Columns == null )
      {
         gxTv_SdtWWPColumnsSelector_Columns = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column>(com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column.class, "WWPColumnsSelector.Column", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtWWPColumnsSelector_Columns_N = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_N = (byte)(0) ;
      return gxTv_SdtWWPColumnsSelector_Columns ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Columns( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column> value )
   {
      gxTv_SdtWWPColumnsSelector_Columns_N = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_N = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Columns = value ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Columns_SetNull( )
   {
      gxTv_SdtWWPColumnsSelector_Columns_N = (byte)(1) ;
      gxTv_SdtWWPColumnsSelector_Columns = null ;
   }

   public boolean getgxTv_SdtWWPColumnsSelector_Columns_IsNull( )
   {
      if ( gxTv_SdtWWPColumnsSelector_Columns == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtWWPColumnsSelector_Columns_N( )
   {
      return gxTv_SdtWWPColumnsSelector_Columns_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPColumnsSelector_Columns_N = (byte)(1) ;
      gxTv_SdtWWPColumnsSelector_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPColumnsSelector_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector struct )
   {
      GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column> gxTv_SdtWWPColumnsSelector_Columns_aux = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column>(com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column.class, "WWPColumnsSelector.Column", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector_Column> gxTv_SdtWWPColumnsSelector_Columns_aux1 = struct.getColumns();
      if (gxTv_SdtWWPColumnsSelector_Columns_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtWWPColumnsSelector_Columns_aux1.size(); i++)
         {
            gxTv_SdtWWPColumnsSelector_Columns_aux.add(new com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column(gxTv_SdtWWPColumnsSelector_Columns_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtWWPColumnsSelector_Columns(gxTv_SdtWWPColumnsSelector_Columns_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector struct = new com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector ();
      struct.setColumns(getgxTv_SdtWWPColumnsSelector_Columns().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtWWPColumnsSelector_Columns_N ;
   protected byte gxTv_SdtWWPColumnsSelector_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column> gxTv_SdtWWPColumnsSelector_Columns_aux ;
   protected GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWWPColumnsSelector_Column> gxTv_SdtWWPColumnsSelector_Columns=null ;
}

