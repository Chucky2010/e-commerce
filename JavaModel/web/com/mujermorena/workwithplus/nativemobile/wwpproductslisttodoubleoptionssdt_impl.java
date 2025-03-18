package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwpproductslisttodoubleoptionssdt_impl extends GXWebProcedure
{
   public wwpproductslisttodoubleoptionssdt_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwpproductslisttodoubleoptionssdt_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpproductslisttodoubleoptionssdt_impl.class ));
   }

   public wwpproductslisttodoubleoptionssdt_impl( int remoteHandle ,
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
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDT");
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
            GXSoapXMLWriter.writeAttribute("name", "ArrayOfWWPProductData");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductData");
            GXSoapXMLWriter.writeAttribute("type", "tns:WWPProductData");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductData");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Id");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Type");
            GXSoapXMLWriter.writeAttribute("type", "xsd:short");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Title");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Description");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Image");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Image_GXI");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Subtitle");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Information1");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Information2");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ComponentToCall");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
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
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDT.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Productdatalist");
            GXSoapXMLWriter.writeAttribute("type", "tns:ArrayOfWWPProductData");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDT.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Doublemenuoptions");
            GXSoapXMLWriter.writeAttribute("type", "tns:DoubleItemListData");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDT.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPProductsListToDoubleOptionsSDT.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDT.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPProductsListToDoubleOptionsSDT.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDTSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPProductsListToDoubleOptionsSDT.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPProductsListToDoubleOptionsSDT.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDTSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"WWPProductsListToDoubleOptionsSDTSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "Mujer_Morenaaction/"+"workwithplus.nativemobile.AWWPPRODUCTSLISTTODOUBLEOPTIONSSDT.Execute");
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
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDT");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "WWPProductsListToDoubleOptionsSDTSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"WWPProductsListToDoubleOptionsSDTSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", "http://"+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + "http://" + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt" + "?wsdl to get the WSDL." ;
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
                           if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Productdatalist") && ( GXSoapXMLReader.getNodeType() != 2 ) && ( GXutil.strcmp(GXSoapXMLReader.getNamespaceURI(), "Mujer_Morena") == 0 ) )
                           {
                              if ( AV14ProductDataList == null )
                              {
                                 AV14ProductDataList = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
                              }
                              if ( GXSoapXMLReader.getIsSimple() == 0 )
                              {
                                 GXSoapError = AV14ProductDataList.readxmlcollection(GXSoapXMLReader, "Productdatalist", "WWPProductData") ;
                              }
                              readElement = true ;
                              if ( GXSoapError > 0 )
                              {
                                 readOk = (short)(1) ;
                              }
                              if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Productdatalist") )
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
         GXSoapXMLWriter.writeStartElement("WWPProductsListToDoubleOptionsSDT.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
         if ( currSoapErr == 0 )
         {
            if ( AV11DoubleMenuOptions != null )
            {
               AV11DoubleMenuOptions.writexmlcollection(GXSoapXMLWriter, "Doublemenuoptions", "Mujer_Morena", "DoubleItemListDataItem", "Mujer_Morena");
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

   public void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> aP0 ,
                            GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>[] aP1 )
   {
      wwpproductslisttodoubleoptionssdt_impl.this.AV14ProductDataList = aP0;
      wwpproductslisttodoubleoptionssdt_impl.this.aP1 = aP1;
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
      AV9IsFirstItem = true ;
      AV17GXV1 = 1 ;
      while ( AV17GXV1 <= AV14ProductDataList.size() )
      {
         AV8ProductData = (com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)AV14ProductDataList.elementAt(-1+AV17GXV1));
         if ( AV9IsFirstItem )
         {
            AV12DoubleMenuOptionsItem = (com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem)new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem(remoteHandle, context);
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1componenttocall( AV13ProductDataItem.getgxTv_SdtWWPProductData_Componenttocall() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1id( AV13ProductDataItem.getgxTv_SdtWWPProductData_Id() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image( AV13ProductDataItem.getgxTv_SdtWWPProductData_Image() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1image_gxi( AV13ProductDataItem.getgxTv_SdtWWPProductData_Image_gxi() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information1( AV13ProductDataItem.getgxTv_SdtWWPProductData_Information1() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1information2( AV13ProductDataItem.getgxTv_SdtWWPProductData_Information2() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1subtitle( AV13ProductDataItem.getgxTv_SdtWWPProductData_Subtitle() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option1title( AV13ProductDataItem.getgxTv_SdtWWPProductData_Title() );
            AV11DoubleMenuOptions.add(AV12DoubleMenuOptionsItem, 0);
            AV9IsFirstItem = false ;
         }
         else
         {
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2componenttocall( AV13ProductDataItem.getgxTv_SdtWWPProductData_Componenttocall() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2id( AV13ProductDataItem.getgxTv_SdtWWPProductData_Id() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image( AV13ProductDataItem.getgxTv_SdtWWPProductData_Image() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2image_gxi( AV13ProductDataItem.getgxTv_SdtWWPProductData_Image_gxi() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information1( AV13ProductDataItem.getgxTv_SdtWWPProductData_Information1() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2information2( AV13ProductDataItem.getgxTv_SdtWWPProductData_Information2() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2subtitle( AV13ProductDataItem.getgxTv_SdtWWPProductData_Subtitle() );
            AV12DoubleMenuOptionsItem.setgxTv_SdtDoubleItemListData_DoubleItemListDataItem_Option2title( AV13ProductDataItem.getgxTv_SdtWWPProductData_Title() );
            AV9IsFirstItem = true ;
         }
         AV17GXV1 = (int)(AV17GXV1+1) ;
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
         this.aP1[0] = wwpproductslisttodoubleoptionssdt_impl.this.AV11DoubleMenuOptions;
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
      AV11DoubleMenuOptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem.class, "DoubleItemListDataItem", "Mujer_Morena", remoteHandle);
      AV8ProductData = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      AV12DoubleMenuOptionsItem = new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem(remoteHandle, context);
      AV13ProductDataItem = new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short readOk ;
   private short nOutParmCount ;
   private short initialized ;
   private short Gx_err ;
   private int AV17GXV1 ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private boolean sIncludeState ;
   private boolean AV9IsFirstItem ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData AV13ProductDataItem ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>[] aP1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> AV14ProductDataList ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem> AV11DoubleMenuOptions ;
   private com.mujermorena.workwithplus.nativemobile.SdtWWPProductData AV8ProductData ;
   private com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem AV12DoubleMenuOptionsItem ;
}

