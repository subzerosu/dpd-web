
package ru.dpd.ws.calculator._2012_03_20;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getServiceCostByParcels complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getServiceCostByParcels">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://dpd.ru/ws/calculator/2012-03-20}serviceCostParcelsRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getServiceCostByParcels", propOrder = {
    "request"
})
public class GetServiceCostByParcels {

    protected ServiceCostParcelsRequest request;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCostParcelsRequest }
     *     
     */
    public ServiceCostParcelsRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCostParcelsRequest }
     *     
     */
    public void setRequest(ServiceCostParcelsRequest value) {
        this.request = value;
    }

}
