
package ru.dpd.ws.geography._2012_04_17;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workingTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workingTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="weekDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workingTime", propOrder = {
    "weekDays",
    "workTime"
})
public class WorkingTime {

    protected String weekDays;
    protected String workTime;

    /**
     * Gets the value of the weekDays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeekDays() {
        return weekDays;
    }

    /**
     * Sets the value of the weekDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeekDays(String value) {
        this.weekDays = value;
    }

    /**
     * Gets the value of the workTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * Sets the value of the workTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkTime(String value) {
        this.workTime = value;
    }

}
