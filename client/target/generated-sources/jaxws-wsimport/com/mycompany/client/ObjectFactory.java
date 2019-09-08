
package com.mycompany.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.client package. 
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

    private final static QName _GetDBclientSaldoResponse_QNAME = new QName("http://ws_bank.mycompany.com/", "getDBclientSaldoResponse");
    private final static QName _GetDBclientSaldo_QNAME = new QName("http://ws_bank.mycompany.com/", "getDBclientSaldo");
    private final static QName _GetLoanersResponse_QNAME = new QName("http://ws_bank.mycompany.com/", "getLoanersResponse");
    private final static QName _GetLoaners_QNAME = new QName("http://ws_bank.mycompany.com/", "getLoaners");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLoaners }
     * 
     */
    public GetLoaners createGetLoaners() {
        return new GetLoaners();
    }

    /**
     * Create an instance of {@link GetDBclientSaldo }
     * 
     */
    public GetDBclientSaldo createGetDBclientSaldo() {
        return new GetDBclientSaldo();
    }

    /**
     * Create an instance of {@link GetLoanersResponse }
     * 
     */
    public GetLoanersResponse createGetLoanersResponse() {
        return new GetLoanersResponse();
    }

    /**
     * Create an instance of {@link GetDBclientSaldoResponse }
     * 
     */
    public GetDBclientSaldoResponse createGetDBclientSaldoResponse() {
        return new GetDBclientSaldoResponse();
    }

    /**
     * Create an instance of {@link MAP2 }
     * 
     */
    public MAP2 createMAP2() {
        return new MAP2();
    }

    /**
     * Create an instance of {@link LoanAccount }
     * 
     */
    public LoanAccount createLoanAccount() {
        return new LoanAccount();
    }

    /**
     * Create an instance of {@link MAP2Entry }
     * 
     */
    public MAP2Entry createMAP2Entry() {
        return new MAP2Entry();
    }

    /**
     * Create an instance of {@link ListofAccount }
     * 
     */
    public ListofAccount createListofAccount() {
        return new ListofAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDBclientSaldoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_bank.mycompany.com/", name = "getDBclientSaldoResponse")
    public JAXBElement<GetDBclientSaldoResponse> createGetDBclientSaldoResponse(GetDBclientSaldoResponse value) {
        return new JAXBElement<GetDBclientSaldoResponse>(_GetDBclientSaldoResponse_QNAME, GetDBclientSaldoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDBclientSaldo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_bank.mycompany.com/", name = "getDBclientSaldo")
    public JAXBElement<GetDBclientSaldo> createGetDBclientSaldo(GetDBclientSaldo value) {
        return new JAXBElement<GetDBclientSaldo>(_GetDBclientSaldo_QNAME, GetDBclientSaldo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoanersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_bank.mycompany.com/", name = "getLoanersResponse")
    public JAXBElement<GetLoanersResponse> createGetLoanersResponse(GetLoanersResponse value) {
        return new JAXBElement<GetLoanersResponse>(_GetLoanersResponse_QNAME, GetLoanersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoaners }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_bank.mycompany.com/", name = "getLoaners")
    public JAXBElement<GetLoaners> createGetLoaners(GetLoaners value) {
        return new JAXBElement<GetLoaners>(_GetLoaners_QNAME, GetLoaners.class, null, value);
    }

}
