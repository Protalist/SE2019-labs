
package com.mycompany.ws_bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Conto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Conto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conto", propOrder = {
    "id",
    "saldo"
})
public class Conto {

    @XmlElement(name = "ID")
    protected int id;
    protected int saldo;

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà saldo.
     * 
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Imposta il valore della proprietà saldo.
     * 
     */
    public void setSaldo(int value) {
        this.saldo = value;
    }

}
