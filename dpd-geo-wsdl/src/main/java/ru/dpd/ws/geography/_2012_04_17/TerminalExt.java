
package ru.dpd.ws.geography._2012_04_17;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for terminalExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="terminalExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="terminalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geoCoordinates" type="{http://dpd.ru/ws/geography/2012-04-17}geoCoordinates" minOccurs="0"/>
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
@XmlType(name = "terminalExt", propOrder = {
    "terminalCode",
    "terminalName",
    "terminalAddress",
    "geoCoordinates",
    "workingTime"
})
public class TerminalExt {

    protected String terminalCode;
    protected String terminalName;
    protected String terminalAddress;
    protected GeoCoordinates geoCoordinates;
    protected List<WorkingTime> workingTime;

    /**
     * Gets the value of the terminalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalCode() {
        return terminalCode;
    }

    /**
     * Sets the value of the terminalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalCode(String value) {
        this.terminalCode = value;
    }

    /**
     * Gets the value of the terminalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalName() {
        return terminalName;
    }

    /**
     * Sets the value of the terminalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalName(String value) {
        this.terminalName = value;
    }

    /**
     * Gets the value of the terminalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalAddress() {
        return terminalAddress;
    }

    /**
     * Sets the value of the terminalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalAddress(String value) {
        this.terminalAddress = value;
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
