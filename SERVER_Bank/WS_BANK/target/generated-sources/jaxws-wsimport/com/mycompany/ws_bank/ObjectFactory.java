
package com.mycompany.ws_bank;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.ws_bank package. 
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

    private final static QName _GetOperationByID_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getOperationByID");
    private final static QName _GetContiResponse_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getContiResponse");
    private final static QName _GetClientByIDResponse_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getClientByIDResponse");
    private final static QName _GetConti_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getConti");
    private final static QName _GetOperationsByClientID_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getOperationsByClientID");
    private final static QName _GetClientIDs_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getClientIDs");
    private final static QName _GetOperationByIDResponse_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getOperationByIDResponse");
    private final static QName _GetOperationsByClientIDResponse_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getOperationsByClientIDResponse");
    private final static QName _GetDbop_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getDbop");
    private final static QName _GetDbopResponse_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getDbopResponse");
    private final static QName _GetClientIDsResponse_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getClientIDsResponse");
    private final static QName _GetClientByID_QNAME = new QName("http://Bank.server_bank.mycompany.com/", "getClientByID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.ws_bank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOperationByID }
     * 
     */
    public GetOperationByID createGetOperationByID() {
        return new GetOperationByID();
    }

    /**
     * Create an instance of {@link GetClientByIDResponse }
     * 
     */
    public GetClientByIDResponse createGetClientByIDResponse() {
        return new GetClientByIDResponse();
    }

    /**
     * Create an instance of {@link GetContiResponse }
     * 
     */
    public GetContiResponse createGetContiResponse() {
        return new GetContiResponse();
    }

    /**
     * Create an instance of {@link GetConti }
     * 
     */
    public GetConti createGetConti() {
        return new GetConti();
    }

    /**
     * Create an instance of {@link GetClientIDs }
     * 
     */
    public GetClientIDs createGetClientIDs() {
        return new GetClientIDs();
    }

    /**
     * Create an instance of {@link GetOperationByIDResponse }
     * 
     */
    public GetOperationByIDResponse createGetOperationByIDResponse() {
        return new GetOperationByIDResponse();
    }

    /**
     * Create an instance of {@link GetOperationsByClientIDResponse }
     * 
     */
    public GetOperationsByClientIDResponse createGetOperationsByClientIDResponse() {
        return new GetOperationsByClientIDResponse();
    }

    /**
     * Create an instance of {@link GetOperationsByClientID }
     * 
     */
    public GetOperationsByClientID createGetOperationsByClientID() {
        return new GetOperationsByClientID();
    }

    /**
     * Create an instance of {@link GetClientIDsResponse }
     * 
     */
    public GetClientIDsResponse createGetClientIDsResponse() {
        return new GetClientIDsResponse();
    }

    /**
     * Create an instance of {@link GetDbop }
     * 
     */
    public GetDbop createGetDbop() {
        return new GetDbop();
    }

    /**
     * Create an instance of {@link GetDbopResponse }
     * 
     */
    public GetDbopResponse createGetDbopResponse() {
        return new GetDbopResponse();
    }

    /**
     * Create an instance of {@link GetClientByID }
     * 
     */
    public GetClientByID createGetClientByID() {
        return new GetClientByID();
    }

    /**
     * Create an instance of {@link SET }
     * 
     */
    public SET createSET() {
        return new SET();
    }

    /**
     * Create an instance of {@link MAPEntry }
     * 
     */
    public MAPEntry createMAPEntry() {
        return new MAPEntry();
    }

    /**
     * Create an instance of {@link Conto }
     * 
     */
    public Conto createConto() {
        return new Conto();
    }

    /**
     * Create an instance of {@link MAP }
     * 
     */
    public MAP createMAP() {
        return new MAP();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getOperationByID")
    public JAXBElement<GetOperationByID> createGetOperationByID(GetOperationByID value) {
        return new JAXBElement<GetOperationByID>(_GetOperationByID_QNAME, GetOperationByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getContiResponse")
    public JAXBElement<GetContiResponse> createGetContiResponse(GetContiResponse value) {
        return new JAXBElement<GetContiResponse>(_GetContiResponse_QNAME, GetContiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getClientByIDResponse")
    public JAXBElement<GetClientByIDResponse> createGetClientByIDResponse(GetClientByIDResponse value) {
        return new JAXBElement<GetClientByIDResponse>(_GetClientByIDResponse_QNAME, GetClientByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getConti")
    public JAXBElement<GetConti> createGetConti(GetConti value) {
        return new JAXBElement<GetConti>(_GetConti_QNAME, GetConti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationsByClientID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getOperationsByClientID")
    public JAXBElement<GetOperationsByClientID> createGetOperationsByClientID(GetOperationsByClientID value) {
        return new JAXBElement<GetOperationsByClientID>(_GetOperationsByClientID_QNAME, GetOperationsByClientID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientIDs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getClientIDs")
    public JAXBElement<GetClientIDs> createGetClientIDs(GetClientIDs value) {
        return new JAXBElement<GetClientIDs>(_GetClientIDs_QNAME, GetClientIDs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getOperationByIDResponse")
    public JAXBElement<GetOperationByIDResponse> createGetOperationByIDResponse(GetOperationByIDResponse value) {
        return new JAXBElement<GetOperationByIDResponse>(_GetOperationByIDResponse_QNAME, GetOperationByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationsByClientIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getOperationsByClientIDResponse")
    public JAXBElement<GetOperationsByClientIDResponse> createGetOperationsByClientIDResponse(GetOperationsByClientIDResponse value) {
        return new JAXBElement<GetOperationsByClientIDResponse>(_GetOperationsByClientIDResponse_QNAME, GetOperationsByClientIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDbop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getDbop")
    public JAXBElement<GetDbop> createGetDbop(GetDbop value) {
        return new JAXBElement<GetDbop>(_GetDbop_QNAME, GetDbop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDbopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getDbopResponse")
    public JAXBElement<GetDbopResponse> createGetDbopResponse(GetDbopResponse value) {
        return new JAXBElement<GetDbopResponse>(_GetDbopResponse_QNAME, GetDbopResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientIDsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getClientIDsResponse")
    public JAXBElement<GetClientIDsResponse> createGetClientIDsResponse(GetClientIDsResponse value) {
        return new JAXBElement<GetClientIDsResponse>(_GetClientIDsResponse_QNAME, GetClientIDsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Bank.server_bank.mycompany.com/", name = "getClientByID")
    public JAXBElement<GetClientByID> createGetClientByID(GetClientByID value) {
        return new JAXBElement<GetClientByID>(_GetClientByID_QNAME, GetClientByID.class, null, value);
    }

}
