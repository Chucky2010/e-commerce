package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwpgetrangedradialgaugefromconfig_impl extends GXWebProcedure
{
   public wwpgetrangedradialgaugefromconfig_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwpgetrangedradialgaugefromconfig_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpgetrangedradialgaugefromconfig_impl.class ));
   }

   public wwpgetrangedradialgaugefromconfig_impl( int remoteHandle ,
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
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfig");
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
            GXSoapXMLWriter.writeAttribute("name", "RangedRadialGaugeConfig");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Value");
            GXSoapXMLWriter.writeAttribute("type", "xsd:short");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Text");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Width");
            GXSoapXMLWriter.writeAttribute("type", "xsd:short");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Height");
            GXSoapXMLWriter.writeAttribute("type", "xsd:short");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range1ColorStart");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range1ColorEnd");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range2ColorStart");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range2ColorEnd");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range3ColorStart");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range3ColorEnd");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range4ColorStart");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range4ColorEnd");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range5ColorStart");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Range5ColorEnd");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "ValueMarkerColor");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfig.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Gaugeconfig");
            GXSoapXMLWriter.writeAttribute("type", "tns:RangedRadialGaugeConfig");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfig.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Html");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfig.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPGetRangedRadialGaugeFromConfig.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfig.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPGetRangedRadialGaugeFromConfig.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfigSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPGetRangedRadialGaugeFromConfig.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPGetRangedRadialGaugeFromConfig.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfigSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"WWPGetRangedRadialGaugeFromConfigSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "Mujer_Morenaaction/"+"workwithplus.nativemobile.AWWPGETRANGEDRADIALGAUGEFROMCONFIG.Execute");
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
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfig");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "WWPGetRangedRadialGaugeFromConfigSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"WWPGetRangedRadialGaugeFromConfigSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", "http://"+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"com.mujermorena.workwithplus.nativemobile.wwpgetrangedradialgaugefromconfig");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + "http://" + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "com.mujermorena.workwithplus.nativemobile.wwpgetrangedradialgaugefromconfig" + "?wsdl to get the WSDL." ;
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
                     AV9GaugeConfig = new com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig(remoteHandle, context);
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
                           if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Gaugeconfig") && ( GXSoapXMLReader.getNodeType() != 2 ) && ( GXutil.strcmp(GXSoapXMLReader.getNamespaceURI(), "Mujer_Morena") == 0 ) )
                           {
                              if ( AV9GaugeConfig == null )
                              {
                                 AV9GaugeConfig = new com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig(remoteHandle, context);
                              }
                              GXSoapError = AV9GaugeConfig.readxml(GXSoapXMLReader, "Gaugeconfig") ;
                              readElement = true ;
                              if ( GXSoapError > 0 )
                              {
                                 readOk = (short)(1) ;
                              }
                              GXSoapError = GXSoapXMLReader.read() ;
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
         GXSoapXMLWriter.writeStartElement("WWPGetRangedRadialGaugeFromConfig.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
         if ( currSoapErr == 0 )
         {
            GXSoapXMLWriter.writeElement("Html", AV8HTML);
            GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
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

   public void execute_int( com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig aP0 ,
                            String[] aP1 )
   {
      wwpgetrangedradialgaugefromconfig_impl.this.AV9GaugeConfig = aP0;
      wwpgetrangedradialgaugefromconfig_impl.this.aP1 = aP1;
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
      AV8HTML = "<meta name=\"viewport\" content= \"width=device-width, user-scalable=no\"><style>text{font-size:40px;font-family:Arial,Helvetica,sans-serif;fill:black}div{text-align:center}#valuePoint{stroke:white;fill:%valuecolor%;stroke-width:10px}g{stroke-width:15}</style>" ;
      AV8HTML += "<div><svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"%width%\" height=\"%height%\" viewBox=\"-20 -20 240 240\"> <defs> <linearGradient id=\"firstSection\" gradientUnits=\"objectBoundingBox\" x1=\"0\" y1=\"0\" x2=\"1\" y2=\"1\"> <stop offset=\"0%\" stop-color=\"%firstColorStart%\"/> <stop offset=\"100%\" stop-color=\"%firstColorEnd%\"/> </linearGradient> <linearGradient id=\"secondSection\" gradientUnits=\"objectBoundingBox\" x1=\"0\" y1=\"0\" x2=\"0\" y2=\"1\"> <stop offset=\"0%\" stop-color=\"%secondColorStart%\"/> <stop offset=\"100%\" stop-color=\"%secondColorEnd%\"/> </linearGradient> <linearGradient id=\"thirdSection\" gradientUnits=\"objectBoundingBox\" x1=\"1\" y1=\"0\" x2=\"0\" y2=\"1\"> <stop offset=\"0%\" stop-color=\"%thirdColorStart%\"/> <stop offset=\"100%\" stop-color=\"%thirdColorEnd%\"/> </linearGradient> <linearGradient id=\"fourthSection\" gradientUnits=\"objectBoundingBox\" x1=\"1\" y1=\"1\" x2=\"0\" y2=\"0\"> <stop offset=\"0%\" stop-color=\"%fourthColorStart%\"/> <stop offset=\"100%\" stop-color=\"%fourthColorEnd%\"/> </linearGradient> <linearGradient id=\"fiveSection\" gradientUnits=\"objectBoundingBox\" x1=\"0\" y1=\"1\" x2=\"0\" y2=\"0\"> <stop offset=\"0%\" stop-color=\"%fiveColorStart%\"/> <stop offset=\"100%\" stop-color=\"%fiveColorEnd%\"/> </linearGradient> </defs><g fill=\"none\" transform=\"translate(100,100), rotate(210)\"> <path d=\"M 0,-100 A 100,100 0 0,1 86.6,-50\" stroke=\"url(#firstSection)\" style=\"stroke-linecap: round;\"/> <path d=\"M 86.6,-50 A 100,100 0 0,1 86.6,50\" stroke=\"url(#secondSection)\"/> <path d=\"M 86.6,50 A 100,100 0 0,1 0,100\" stroke=\"url(#thirdSection)\"/> <path d=\"M 0,100 A 100,100 0 0,1 -86.6,50\" stroke=\"url(#fourthSection)\"/> <path d=\"M -86.6,50 A 100,100 0 0,1 -86.6,-50\" stroke=\"url(#fiveSection)\" style=\"stroke-linecap: round;\"/> </g> <circle id=\"valuePoint\" cx=\"170\" cy=\"170\" r=\"20\" /> <text x=\"100\" y=\"100\" dominant-baseline=\"middle\" text-anchor=\"middle\">%text%</text> </svg></div>" ;
      AV8HTML += "<script>var degrees=%degrees%+90;var radians=degrees_to_radians(degrees);var radius=100;var x=Math.cos(radians)*radius+100;var y=Math.sin(radians)*radius+100;setPosition(\"valuePoint\",x,y);function setPosition(id,x,y){var ctrl=document.getElementById(id);ctrl.setAttribute(\"cx\",x);ctrl.setAttribute(\"cy\",y);} function degrees_to_radians(degrees) {var pi=Math.PI;return degrees*(pi/180);}</script>" ;
      AV10propertyName = "height" ;
      AV11propertyValue = GXutil.str( AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Height(), 4, 0) ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "width" ;
      AV11propertyValue = GXutil.str( AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Width(), 4, 0) ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "degrees" ;
      AV12ValueNumeric = (int)(AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Value()*3+30) ;
      AV11propertyValue = GXutil.str( AV12ValueNumeric, 6, 0) ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "valuecolor" ;
      AV11propertyValue = "blue" ;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor()))==0) )
      {
         AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Valuemarkercolor() ;
      }
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "text" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Text() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "firstColorStart" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range1colorstart() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "firstColorEnd" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range1colorend() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "secondColorStart" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range2colorstart() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "secondColorEnd" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range2colorend() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "thirdColorStart" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range3colorstart() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "thirdColorEnd" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range3colorend() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "fourthColorStart" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range4colorstart() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "fourthColorEnd" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range4colorend() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = "fiveColorStart" ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range5colorstart() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10propertyName = httpContext.getMessage( "fiveColorEnd", "") ;
      AV11propertyValue = AV9GaugeConfig.getgxTv_SdtRangedRadialGaugeConfig_Range5colorend() ;
      /* Execute user subroutine: 'REPLACETEMPLATE' */
      S111 ();
      if ( returnInSub )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'REPLACETEMPLATE' Routine */
      returnInSub = false ;
      AV8HTML = GXutil.strReplace( AV8HTML, "%"+GXutil.trim( AV10propertyName)+"%", GXutil.trim( AV11propertyValue)) ;
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
         this.aP1[0] = wwpgetrangedradialgaugefromconfig_impl.this.AV8HTML;
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
      AV10propertyName = "" ;
      AV11propertyValue = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short readOk ;
   private short nOutParmCount ;
   private short initialized ;
   private short Gx_err ;
   private int AV12ValueNumeric ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private boolean sIncludeState ;
   private boolean returnInSub ;
   private String AV8HTML ;
   private String AV10propertyName ;
   private String AV11propertyValue ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private String[] aP1 ;
   private com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig AV9GaugeConfig ;
}

