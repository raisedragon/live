//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.21 at 03:30:12 ���� CST 
//


package com.winit.label.manager.impl.de.dpd.shipment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parcelShopDelivery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parcelShopDelivery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parcelShopId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parcelShopNotification" type="{http://dpd.com/common/service/types/ShipmentService/2.0}notification"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parcelShopDelivery", propOrder = {
    "parcelShopId",
    "parcelShopNotification"
})
public class ParcelShopDelivery {

    protected long parcelShopId;
    @XmlElement(required = true)
    protected Notification parcelShopNotification;

    /**
     * Gets the value of the parcelShopId property.
     * 
     */
    public long getParcelShopId() {
        return parcelShopId;
    }

    /**
     * Sets the value of the parcelShopId property.
     * 
     */
    public void setParcelShopId(long value) {
        this.parcelShopId = value;
    }

    /**
     * Gets the value of the parcelShopNotification property.
     * 
     * @return
     *     possible object is
     *     {@link Notification }
     *     
     */
    public Notification getParcelShopNotification() {
        return parcelShopNotification;
    }

    /**
     * Sets the value of the parcelShopNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notification }
     *     
     */
    public void setParcelShopNotification(Notification value) {
        this.parcelShopNotification = value;
    }

}