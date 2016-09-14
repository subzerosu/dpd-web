
package ru.dpd.ws.geography._2012_04_17;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parcelShop complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parcelShop">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parcelShopType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://dpd.ru/ws/geography/2012-04-17}address" minOccurs="0"/>
 *         &lt;element name="geoCoordinates" type="{http://dpd.ru/ws/geography/2012-04-17}geoCoordinates" minOccurs="0"/>
 *         &lt;element name="limits" type="{http://dpd.ru/ws/geography/2012-04-17}limits" minOccurs="0"/>
 *         &lt;element name="workingTime" type="{http://dpd.ru/ws/geography/2012-04-17}workingTime" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parcelShop", propOrder = {
    "code",
    "parcelShopType",
    "address",
    "geoCoordinates",
    "limits",
    "workingTime"
})
public class ParcelShop {

    protected String code;
    protected String parcelShopType;
    protected Address address;
    protected GeoCoordinates geoCoordinates;
    protected Limits limits;
    protected List<WorkingTime> workingTime;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the parcelShopType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParcelShopType() {
        return parcelShopType;
    }

    /**
     * Sets the value of the parcelShopType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParcelShopType(String value) {
        this.parcelShopType = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the geoCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link GeoCoordinates }
     *     
     */
    public GeoCoordinates getGeoCoordinates() {
        return geoCoordinates;
    }

    /**
     * Sets the value of the geoCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoCoordinates }
     *     
     */
    public void setGeoCoordinates(GeoCoordinates value) {
        this.geoCoordinates = value;
    }

    /**
     * Gets the value of the limits property.
     * 
     * @return
     *     possible object is
     *     {@link Limits }
     *     
     */
    public Limits getLimits() {
        return limits;
    }

    /**
     * Sets the value of the limits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Limits }
     *     
     */
    public void setLimits(Limits value) {
        this.limits = value;
    }

    /**
     * Gets the value of the workingTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workingTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkingTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkingTime }
     * 
     * 
     */
    public List<WorkingTime> getWorkingTime() {
        if (workingTime == null) {
            workingTime = new ArrayList<WorkingTime>();
        }
        return this.workingTime;
    }

}
