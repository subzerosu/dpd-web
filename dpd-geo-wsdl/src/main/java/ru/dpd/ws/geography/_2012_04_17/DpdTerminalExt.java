
package ru.dpd.ws.geography._2012_04_17;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dpdTerminalExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dpdTerminalExt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="terminal" type="{http://dpd.ru/ws/geography/2012-04-17}terminalExt" minOccurs="0"/>
 *         &lt;element name="city" type="{http://dpd.ru/ws/geography/2012-04-17}cityExt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dpdTerminalExt", propOrder = {
    "terminal",
    "city"
})
public class DpdTerminalExt {

    protected TerminalExt terminal;
    protected CityExt city;

    /**
     * Gets the value of the terminal property.
     * 
     * @return
     *     possible object is
     *     {@link TerminalExt }
     *     
     */
    public TerminalExt getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalExt }
     *     
     */
    public void setTerminal(TerminalExt value) {
        this.terminal = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link CityExt }
     *     
     */
    public CityExt getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link CityExt }
     *     
     */
    public void setCity(CityExt value) {
        this.city = value;
    }

}
