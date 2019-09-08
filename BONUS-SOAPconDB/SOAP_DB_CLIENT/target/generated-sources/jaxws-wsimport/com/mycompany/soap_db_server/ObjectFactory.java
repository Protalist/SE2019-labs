
package com.mycompany.soap_db_server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.soap_db_server package. 
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

    private final static QName _GetMapAuto_QNAME = new QName("http://soap_db_server.mycompany.com/", "getMapAuto");
    private final static QName _GetAutoInDBResponse_QNAME = new QName("http://soap_db_server.mycompany.com/", "getAutoInDBResponse");
    private final static QName _GetMapAutoResponse_QNAME = new QName("http://soap_db_server.mycompany.com/", "getMapAutoResponse");
    private final static QName _GetAutoInDB_QNAME = new QName("http://soap_db_server.mycompany.com/", "getAutoInDB");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.soap_db_server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAutoInDBResponse }
     * 
     */
    public GetAutoInDBResponse createGetAutoInDBResponse() {
        return new GetAutoInDBResponse();
    }

    /**
     * Create an instance of {@link GetMapAuto }
     * 
     */
    public GetMapAuto createGetMapAuto() {
        return new GetMapAuto();
    }

    /**
     * Create an instance of {@link GetMapAutoResponse }
     * 
     */
    public GetMapAutoResponse createGetMapAutoResponse() {
        return new GetMapAutoResponse();
    }

    /**
     * Create an instance of {@link GetAutoInDB }
     * 
     */
    public GetAutoInDB createGetAutoInDB() {
        return new GetAutoInDB();
    }

    /**
     * Create an instance of {@link MAPPA }
     * 
     */
    public MAPPA createMAPPA() {
        return new MAPPA();
    }

    /**
     * Create an instance of {@link MAPPAEntry }
     * 
     */
    public MAPPAEntry createMAPPAEntry() {
        return new MAPPAEntry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMapAuto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_db_server.mycompany.com/", name = "getMapAuto")
    public JAXBElement<GetMapAuto> createGetMapAuto(GetMapAuto value) {
        return new JAXBElement<GetMapAuto>(_GetMapAuto_QNAME, GetMapAuto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAutoInDBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_db_server.mycompany.com/", name = "getAutoInDBResponse")
    public JAXBElement<GetAutoInDBResponse> createGetAutoInDBResponse(GetAutoInDBResponse value) {
        return new JAXBElement<GetAutoInDBResponse>(_GetAutoInDBResponse_QNAME, GetAutoInDBResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMapAutoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_db_server.mycompany.com/", name = "getMapAutoResponse")
    public JAXBElement<GetMapAutoResponse> createGetMapAutoResponse(GetMapAutoResponse value) {
        return new JAXBElement<GetMapAutoResponse>(_GetMapAutoResponse_QNAME, GetMapAutoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAutoInDB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_db_server.mycompany.com/", name = "getAutoInDB")
    public JAXBElement<GetAutoInDB> createGetAutoInDB(GetAutoInDB value) {
        return new JAXBElement<GetAutoInDB>(_GetAutoInDB_QNAME, GetAutoInDB.class, null, value);
    }

}
