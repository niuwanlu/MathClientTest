package com.webservice.soapclient;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import com.codereq.cxfservices.MathModule;

public class MathModuleClient{
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:8080/cxf-service-one/MathModule?wsdl");

        QName qname = new QName("http://cxfservices.codereq.com/", "MathModuleImplService");
        Service service = Service.create(url,qname);
        MathModule math = service.getPort(MathModule.class);
        System.out.println(math.isOdd(3));
    }
}