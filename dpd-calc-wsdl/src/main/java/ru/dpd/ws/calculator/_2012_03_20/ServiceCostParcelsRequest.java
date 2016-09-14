
package ru.dpd.ws.calculator._2012_03_20;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for serviceCostParcelsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceCostParcelsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auth" type="{http://dpd.ru/ws/calculator/2012-03-20}auth"/>
 *         &lt;element name="pickup" type="{http://dpd.ru/ws/calculator/2012-03-20}cityRequest"/>
 *         &lt;element name="delivery" type="{http://dpd.ru/ws/calculator/2012-03-20}cityRequest"/>
 *         &lt;element name="selfPickup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="selfDelivery" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="serviceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pickupDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="maxDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="declaredValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="parcel" type="{http://dpd.ru/ws/calculator/2012-03-20}parcelRequest" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceCostParcelsRequest", propOrder = {
    "auth",
    "pickup",
    "delivery",
    "selfPickup",
    "selfDelivery",
    "serviceCode",
    "pickupDate",
    "maxDays",
    "maxCost",
    "declaredValue",
    "parcel"
})
public class ServiceCostParcelsRequest {

    @XmlElement(required = true)
    protected Auth auth;
    @XmlElement(required = true)
    protected CityRequest pickup;
    @XmlElement(required = true)
    protected CityRequest delivery;
    protected boolean selfPickup;
    protected boolean selfDelivery;
    protected String serviceCode;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar pickupDate;
    protected Integer maxDays;
    protected Double maxCost;
    protected Double declaredValue;
    @XmlElement(required = true)
    protected List<ParcelRequest> parcel;

    /**
     * Gets the value of the auth property.
     * 
     * @return
     *     possible object is
     *     {@link Auth }
     *     
     */
    public Auth getAuth() {
        return auth;
    }

    /**
     * Sets the value of the auth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Auth }
     *     
     */
    public void setAuth(Auth value) {
        this.auth = value;
    }

    /**
     * Gets the value of the pickup property.
     * 
     * @return
     *     possible object is
     *     {@link CityRequest }
     *     
     */
    public CityRequest getPickup() {
        return pickup;
    }

    /**
     * Sets the value of the pickup property.
     * 
     * @param value
     *     allowed object is
     *     {@link CityRequest }
     *     
     */
    public void setPickup(CityRequest value) {
        this.pickup = value;
    }

    /**
     * Gets the value of the delivery property.
     * 
     * @return
     *     possible object is
     *     {@link CityRequest }
     *     
     */
    public CityRequest getDelivery() {
        return delivery;
    }

    /**
     * Sets the value of the delivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link CityRequest }
     *     
     */
    public void setDelivery(CityRequest value) {
        this.delivery = value;
    }

    /**
     * Gets the value of the selfPickup property.
     * 
     */
    public boolean isSelfPickup() {
        return selfPickup;
    }

    /**
     * Sets the value of the selfPickup property.
     * 
     */
    public void setSelfPickup(boolean value) {
        this.selfPickup = value;
    }

    /**
     * Gets the value of the selfDelivery property.
     * 
     */
    public boolean isSelfDelivery() {
        return selfDelivery;
    }

    /**
     * Sets the value of the selfDelivery property.
     * 
     */
    public void setSelfDelivery(boolean value) {
        this.selfDelivery = value;
    }

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the pickupDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPickupDate() {
        return pickupDate;
    }

    /**
     * Sets the value of the pickupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPickupDate(XMLGregorianCalendar value) {
        this.pickupDate = value;
    }

    /**
     * Gets the value of the maxDays property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxDays() {
        return maxDays;
    }

    /**
     * Sets the value of the maxDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxDays(Integer value) {
        this.maxDays = value;
    }

    /**
     * Gets the value of the maxCost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxCost() {
        return maxCost;
    }

    /**
     * Sets the value of the maxCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxCost(Double value) {
        this.maxCost = value;
    }

    /**
     * Gets the value of the declaredValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeclaredValue() {
        return declaredValue;
    }

    /**
     * Sets the value of the declaredValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeclaredValue(Double value) {
        this.declaredValue = value;
    }

    /**
     * Gets the value of the parcel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parcel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParcel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParcelRequest }
     * 
     * 
     */
    public List<ParcelRequest> getParcel() {
        if (parcel == null) {
            parcel = new ArrayList<ParcelRequest>();
        }
        return this.parcel;
    }

}
