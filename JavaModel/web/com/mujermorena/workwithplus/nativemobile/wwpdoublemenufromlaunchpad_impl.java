package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwpdoublemenufromlaunchpad_impl extends GXWebProcedure
{
   public wwpdoublemenufromlaunchpad_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwpdoublemenufromlaunchpad_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpdoublemenufromlaunchpad_impl.class ));
   }

   public wwpdoublemenufromlaunchpad_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void webExecute( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GXSoapHTTPResponse.addHeader("Content-type", "text/xml;charset=utf-8");
      }
      if ( GXutil.strcmp(GXutil.lower( GXSoapHTTPRequest.getMethod()), "get") == 0 )
      {
         if ( GXutil.strcmp(GXutil.lower( GXSoapHTTPRequest.getQuerystring()), "wsdl") == 0 )
         {
            GXSoapXMLWriter.openResponse(GXSoapHTTPResponse);
            GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
            GXSoapXMLWriter.writeStartElement("definitions");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpad");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns:wsdlns", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns:soap", "http://schemas.xmlsoap.org/wsdl/soap/");
            GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://schemas.xmlsoap.org/wsdl/");
            GXSoapXMLWriter.writeAttribute("xmlns:tns", "Mujer_Morena");
            GXSoapXMLWriter.writeStartElement("types");
            GXSoapXMLWriter.writeStartElement("schema");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
            GXSoapXMLWriter.writeAttribute("elementFormDefault", "qualified");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "LaunchpadOptions");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "Option");
            GXSoapXMLWriter.writeAttribute("type", "tns:WorkWithPlus.NativeMobile.LaunchpadOptions.Option");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "WorkWithPlus.NativeMobile.LaunchpadOptions.Option");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Name");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Description");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Information");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Link");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Icon");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Icon_GXI");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "OrderIndex");
            GXSoapXMLWriter.writeAttribute("type", "xsd:int");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "TileSize");
            GXSoapXMLWriter.writeAttribute("type", "xsd:byte");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "TileType");
            GXSoapXMLWriter.writeAttribute("type", "xsd:byte");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "DoubleItemListData");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "DoubleItemListDataItem");
            GXSoapXMLWriter.writeAttribute("type", "tns:WorkWithPlus.NativeMobile.DoubleItemListData.DoubleItemListDataItem");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "WorkWithPlus.NativeMobile.DoubleItemListData.DoubleItemListDataItem");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Type");
            GXSoapXMLWriter.writeAttribute("type", "xsd:short");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Title");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Image");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Image_GXI");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Subtitle");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Information1");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Information2");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1Id");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option1ComponentToCall");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Title");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Image");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Image_GXI");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Subtitle");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Id");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2ComponentToCall");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Information1");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Option2Information2");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpad.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Sdplaunchpadoptions");
            GXSoapXMLWriter.writeAttribute("type", "tns:LaunchpadOptions");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpad.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Sdpdoublemenuoptions");
            GXSoapXMLWriter.writeAttribute("type", "tns:DoubleItemListData");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpad.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPDoubleMenuFromLaunchpad.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpad.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPDoubleMenuFromLaunchpad.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpadSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPDoubleMenuFromLaunchpad.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPDoubleMenuFromLaunchpad.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpadSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"WWPDoubleMenuFromLaunchpadSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "Mujer_Morenaaction/"+"workwithplus.nativemobile.AWWPDOUBLEMENUFROMLAUNCHPAD.Execute");
            GXSoapXMLWriter.writeStartElement("input");
            GXSoapXMLWriter.writeElement("soap:body", "");
            GXSoapXMLWriter.writeAttribute("use", "literal");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("output");
            GXSoapXMLWriter.writeElement("soap:body", "");
            GXSoapXMLWriter.writeAttribute("use", "literal");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("service");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpad");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "WWPDoubleMenuFromLaunchpadSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"WWPDoubleMenuFromLaunchpadSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", "http://"+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"com.mujermorena.workwithplus.nativemobile.wwpdoublemenufromlaunchpad");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + "http://" + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "com.mujermorena.workwithplus.nativemobile.wwpdoublemenufromlaunchpad" + "?wsdl to get the WSDL." ;
         }
      }
      if ( currSoapErr == 0 )
      {
         GXSoapXMLReader.openRequest(GXSoapHTTPRequest);
         GXSoapError = GXSoapXMLReader.read() ;
         while ( GXSoapError > 0 )
         {
            if ( GXutil.strSearch( GXSoapXMLReader.getName(), "Body", 1) > 0 )
            {
               if (true) break;
            }
            GXSoapError = GXSoapXMLReader.read() ;
         }
         if ( GXSoapError > 0 )
         {
            GXSoapError = GXSoapXMLReader.read() ;
            if ( GXSoapError > 0 )
            {
               currMethod = GXSoapXMLReader.getName() ;
               if ( ( GXutil.strSearch( currMethod+"&", "Execute&", 1) > 0 ) || ( currSoapErr != 0 ) )
               {
                  if ( currSoapErr == 0 )
                  {
                     formatError = false ;
                     sTagName = GXSoapXMLReader.getName() ;
                     if ( GXSoapXMLReader.getIsSimple() == 0 )
                     {
                        GXSoapError = GXSoapXMLReader.read() ;
                        nOutParmCount = (short)(0) ;
                        while ( ( ( GXutil.strcmp(GXSoapXMLReader.getName(), sTagName) != 0 ) || ( GXSoapXMLReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
                        {
                           readOk = (short)(0) ;
                           readElement = false ;
                           if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Sdplaunchpadoptions") && ( GXSoapXMLReader.getNodeType() != 2 ) && ( GXutil.strcmp(GXSoapXMLReader.getNamespaceURI(), "Mujer_Morena") == 0 ) )
                           {
                              if ( AV11SDPLaunchpadOptions == null )
                              {
                                 AV11SDPLaunchpadOptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option>(com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option.class, "Option", "Mujer_Morena", remoteHandle);
                              }
                              if ( GXSoapXMLReader.getIsSimple() == 0 )
                              {
                                 GXSoapError = AV11SDPLaunchpadOptions.readxmlcollection(GXSoapXMLReader, "Sdplaunchpadoptions", "Option") ;
                              }
                              readElement = true ;
                              if ( GXSoapError > 0 )
                              {
                                 readOk = (short)(1) ;
                              }
                              if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Sdplaunchpadoptions") )
                              {
                                 GXSoapError = GXSoapXMLReader.read() ;
                              }
                           }
                           if ( ! readElement )
                           {
                              readOk = (short)(1) ;
                              GXSoapError = GXSoapXMLReader.read() ;
                           }
                           nOutParmCount = (short)(nOutParmCount+1) ;
                           if ( ( readOk == 0 ) || formatError )
                           {
                              context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
                              context.globals.sSOAPErrMsg += "Message: " + GXSoapXMLReader.readRawXML() ;
                              GXSoapError = (short)(nOutParmCount*-1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  currSoapErr = (short)(-20002) ;
                  currSoapErrmsg = "Wrong method called. Expected method: " + "Execute" ;
               }
            }
         }
         GXSoapXMLReader.close();
      }
      if ( currSoapErr == 0 )
      {
         if ( GXSoapError < 0 )
         {
            currSoapErr = (short)(GXSoapError*-1) ;
            currSoapErrmsg = context.globals.sSOAPErrMsg ;
         }
         else
         {
            if ( GXSoapXMLReader.getErrCode() > 0 )
            {
               currSoapErr = (short)(GXSoapXMLReader.getErrCode()*-1) ;
               currSoapErrmsg = GXSoapXMLReader.getErrDescription() ;
            }
            else
            {
               if ( GXSoapError == 0 )
               {
                  currSoapErr = (short)(-20001) ;
                  currSoapErrmsg = "Malformed SOAP message." ;
               }
               else
               {
                  currSoapErr = (short)(0) ;
                  currSoapErrmsg = "No error." ;
               }
            }
         }
      }
      if ( currSoapErr == 0 )
      {
         execute_internal();
      }
      sIncludeState = true ;
      GXSoapXMLWriter.openResponse(GXSoapHTTPResponse);
      GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
      GXSoapXMLWriter.writeStartElement("SOAP-ENV:Envelope");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
      if ( ( GXutil.strSearch( currMethod+"&", "Execute&", 1) > 0 ) || ( currSoapErr != 0 ) )
      {
         GXSoapXMLWriter.writeStartElement("SOAP-ENV:Body");
         GXSoapXMLWriter.writeStartElement("WWPDoubleMenuFromLaunchpad.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
         if ( currSoapErr == 0 )
         {
            if ( AV8SDPDoubleMenuOptions != null )
            {
               AV8SDPDoubleMenuOptions.writexmlcollection(GXSoapXMLWriter, "Sdpdoublemenuoptions", "Mujer_Morena", "DoubleItemListDataItem", "Mujer_Morena");
            }
         }
         else
         {
            GXSoapXMLWriter.writeStartElement("SOAP-ENV:Fault");
            GXSoapXMLWriter.writeElement("faultcode", "SOAP-ENV:Client");
            GXSoapXMLWriter.writeElement("faultstring", currSoapErrmsg);
            GXSoapXMLWriter.writeElement("detail", GXutil.trim( GXutil.str( currSoapErr, 10, 0)));
            GXSoapXMLWriter.writeEndElement();
         }
         GXSoapXMLWriter.writeEndElement();
         GXSoapXMLWriter.writeEndElement();
      }
      GXSoapXMLWriter.writeEndElement();
      GXSoapXMLWriter.close();
   }

   public void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option> aP0 ,
                            GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>[] aP1 )
   {
      wwpdoublemenufromlaunchpad_impl.this.AV11SDPLaunchpadOptions = aP0;
      wwpdoublemenufromlaunchpad_impl.this.aP1 = aP1;
      initialize();
      privateExecute();
   }

   public void execute_internal( )
   {
      initialized = (short)(1) ;
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10SDPDoubleMenuOptionsLastItem = (com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem(remoteHandle, context);
      AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type( (short)(10) );
      AV15GXV1 = 1 ;
      while ( AV15GXV1 <= AV11SDPLaunchpadOptions.size() )
      {
         AV12SDPLaunchpadOptionsItem = (com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)((com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option)AV11SDPLaunchpadOptions.elementAt(-1+AV15GXV1));
         AV9SDPDoubleMenuOptionsItem = (com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem(remoteHandle, context);
         if ( ( AV10SDPDoubleMenuOptionsLastItem.getgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type() == 2 ) && ( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Tiletype() == 0 ) )
         {
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Link() );
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Name() );
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Icon() );
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Icon_gxi() );
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Description() );
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Information() );
            AV10SDPDoubleMenuOptionsLastItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type( (short)(0) );
         }
         else
         {
            AV8SDPDoubleMenuOptions.add(AV9SDPDoubleMenuOptionsItem, 0);
            AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Link() );
            AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Name() );
            AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Icon() );
            AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Icon_gxi() );
            AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Description() );
            AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Information() );
            if ( AV12SDPLaunchpadOptionsItem.getgxTv_SdtLaunchpadOptions_Option_Tiletype() == 1 )
            {
               AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type( (short)(1) );
            }
            else
            {
               AV9SDPDoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Type( (short)(2) );
            }
         }
         AV10SDPDoubleMenuOptionsLastItem = AV9SDPDoubleMenuOptionsItem;
         AV15GXV1 = (int)(AV15GXV1+1) ;
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      if ( initialized != 1 )
      {
         this.aP1[0] = wwpdoublemenufromlaunchpad_impl.this.AV8SDPDoubleMenuOptions;
      }
      CloseOpenCursors();
      if ( initialized == 1 )
      {
         super.cleanup();
      }
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXSoapHTTPRequest = httpContext.getHttpRequest();
      GXSoapXMLReader = new com.genexus.xml.XMLReader();
      GXSoapHTTPResponse = httpContext.getHttpResponse();
      GXSoapXMLWriter = new com.genexus.xml.XMLWriter();
      currSoapErrmsg = "" ;
      currMethod = "" ;
      sTagName = "" ;
      AV8SDPDoubleMenuOptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem.class, "DoubleItemListDataItem", "Mujer_Morena", remoteHandle);
      AV10SDPDoubleMenuOptionsLastItem = new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem(remoteHandle, context);
      AV12SDPLaunchpadOptionsItem = new com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option(remoteHandle, context);
      AV9SDPDoubleMenuOptionsItem = new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short readOk ;
   private short nOutParmCount ;
   private short initialized ;
   private short Gx_err ;
   private int AV15GXV1 ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private boolean sIncludeState ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>[] aP1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem> AV8SDPDoubleMenuOptions ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option> AV11SDPLaunchpadOptions ;
   private com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem AV10SDPDoubleMenuOptionsLastItem ;
   private com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem AV9SDPDoubleMenuOptionsItem ;
   private com.mujermorena.workwithplus.nativemobile.SdtLaunchpadOptions_Option AV12SDPLaunchpadOptionsItem ;
}

