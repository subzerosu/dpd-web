
package ru.dpd.ws.geography._2012_04_17;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dpdParcelShops complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dpdParcelShops">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parcelShop" type="{http://dpd.ru/ws/geography/2012-04-17}parcelShop" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storagePeriod" type="{http://dpd.ru/ws/geography/2012-04-17}storagePeriod" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dpdParcelShops", propOrder = {
    "parcelShop",
    "storagePeriod"
})
public class DpdParcelShops {

    @XmlElement(nillable = true)
    protected List<ParcelShop> parcelShop;
    @XmlElement(nillable = true)
    protected List<StoragePeriod> storagePeriod;

    /**
     * Gets the value of the parcelShop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parcelShop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParcelShop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParcelShop }
     * 
     * 
     */
    public List<ParcelShop> getParcelShop() {
        if (parcelShop == null) {
            parcelShop = new ArrayList<ParcelShop>();
        }
        return this.parcelShop;
    }

    /**
     * Gets the value of the storagePeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storagePeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStoragePeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StoragePeriod }
     * 
     * 
     */
    public List<StoragePeriod> getStoragePeriod() {
        if (storagePeriod == null) {
            storagePeriod = new ArrayList<StoragePeriod>();
        }
        return this.storagePeriod;
    }

}
