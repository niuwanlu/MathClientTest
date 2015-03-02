package com.webservice.soapclient;

import com.codereq.cxfservices.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import java.net.URL;
import java.util.*;

public class HelloWorldClient{
    private static final String WS_URL = "http://localhost:8080/cxf-service-one/HelloWorld?wsdl";

    public static void main(String[] args) throws Exception {
        URL url = new URL(WS_URL);
        QName qname = new QName("http://cxfservices.codereq.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        //username & password setting
        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("apple"));
        headers.put("Passname", Collections.singletonList("123456"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        System.out.println(hello.getHelloWorldAsString());

    }
}