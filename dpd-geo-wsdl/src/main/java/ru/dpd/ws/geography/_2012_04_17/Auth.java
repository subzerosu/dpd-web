
package ru.dpd.ws.geography._2012_04_17;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for auth complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="auth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="clientKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auth", propOrder = {
    "clientNumber",
    "clientKey"
})
public class Auth {

    protected long clientNumber;
    @XmlElement(required = true)
    protected String clientKey;

    /**
     * Gets the value of the clientNumber property.
     * 
     */
    public long getClientNumber() {
        return clientNumber;
    }

    /**
     * Sets the value of the clientNumber property.
     * 
     */
    public void setClientNumber(long value) {
        this.clientNumber = value;
    }

    /**
     * Gets the value of the clientKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientKey() {
        return clientKey;
    }

    /**
     * Sets the value of the clientKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientKey(String value) {
        this.clientKey = value;
    }

}
