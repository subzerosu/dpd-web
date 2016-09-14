
package ru.dpd.ws.calculator._2012_03_20;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getServiceCostInternational complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getServiceCostInternational">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://dpd.ru/ws/calculator/2012-03-20}serviceCostInternationalRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getServiceCostInternational", propOrder = {
    "request"
})
public class GetServiceCostInternational {

    protected ServiceCostInternationalRequest request;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCostInternationalRequest }
     *     
     */
    public ServiceCostInternationalRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCostInternationalRequest }
     *     
     */
    public void setRequest(ServiceCostInternationalRequest value) {
        this.request = value;
    }

}
