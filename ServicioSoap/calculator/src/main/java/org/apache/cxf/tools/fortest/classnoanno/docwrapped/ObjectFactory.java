//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.02.08 a las 12:48:25 PM CET 
//


package org.apache.cxf.tools.fortest.classnoanno.docwrapped;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.cxf.tools.fortest.classnoanno.docwrapped package. 
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

    private final static QName _AddException_QNAME = new QName("http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/", "AddException");
    private final static QName _AddRequest_QNAME = new QName("http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/", "addRequest");
    private final static QName _AddResponse_QNAME = new QName("http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/", "addResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.cxf.tools.fortest.classnoanno.docwrapped
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddException }
     * 
     */
    public AddException createAddException() {
        return new AddException();
    }

    /**
     * Create an instance of {@link AddRequest }
     * 
     */
    public AddRequest createAddRequest() {
        return new AddRequest();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddException }{@code >}
     */
    @XmlElementDecl(namespace = "http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/", name = "AddException")
    public JAXBElement<AddException> createAddException(AddException value) {
        return new JAXBElement<AddException>(_AddException_QNAME, AddException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/", name = "addRequest")
    public JAXBElement<AddRequest> createAddRequest(AddRequest value) {
        return new JAXBElement<AddRequest>(_AddRequest_QNAME, AddRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

}
