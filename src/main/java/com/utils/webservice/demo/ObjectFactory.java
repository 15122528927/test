
package com.utils.webservice.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.ljl.sand.jws.chapter3.client.wsimport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GoOfficeNO_QNAME = new QName("http://controller.sms.com", "officeNO");
    private final static QName _GoContent_QNAME = new QName("http://controller.sms.com", "content");
    private final static QName _GoPhones_QNAME = new QName("http://controller.sms.com", "phones");
    private final static QName _GoMethod_QNAME = new QName("http://controller.sms.com", "method");
    private final static QName _GoWsurl_QNAME = new QName("http://controller.sms.com", "wsurl");
    private final static QName _GoMesNO_QNAME = new QName("http://controller.sms.com", "mesNO");
    private final static QName _GoSystem_QNAME = new QName("http://controller.sms.com", "system");
    private final static QName _GoResponseReturn_QNAME = new QName("http://controller.sms.com", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.ljl.sand.jws.chapter3.client.wsimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GoResponse }
     * 
     */
    public GoResponse createGoResponse() {
        return new GoResponse();
    }

    /**
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "officeNO", scope = Go.class)
    public JAXBElement<String> createGoOfficeNO(String value) {
        return new JAXBElement<String>(_GoOfficeNO_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "content", scope = Go.class)
    public JAXBElement<String> createGoContent(String value) {
        return new JAXBElement<String>(_GoContent_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "phones", scope = Go.class)
    public JAXBElement<String> createGoPhones(String value) {
        return new JAXBElement<String>(_GoPhones_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "method", scope = Go.class)
    public JAXBElement<String> createGoMethod(String value) {
        return new JAXBElement<String>(_GoMethod_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "wsurl", scope = Go.class)
    public JAXBElement<String> createGoWsurl(String value) {
        return new JAXBElement<String>(_GoWsurl_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "mesNO", scope = Go.class)
    public JAXBElement<String> createGoMesNO(String value) {
        return new JAXBElement<String>(_GoMesNO_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "system", scope = Go.class)
    public JAXBElement<String> createGoSystem(String value) {
        return new JAXBElement<String>(_GoSystem_QNAME, String.class, Go.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.sms.com", name = "return", scope = GoResponse.class)
    public JAXBElement<String> createGoResponseReturn(String value) {
        return new JAXBElement<String>(_GoResponseReturn_QNAME, String.class, GoResponse.class, value);
    }

}
