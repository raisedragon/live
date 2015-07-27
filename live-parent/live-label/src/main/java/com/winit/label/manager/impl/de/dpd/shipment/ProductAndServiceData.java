//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.21 at 03:30:12 ���� CST 
//


package com.winit.label.manager.impl.de.dpd.shipment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productAndServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productAndServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="consignment"/>
 *               &lt;enumeration value="collection request order"/>
 *               &lt;enumeration value="pickup information"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="saturdayDelivery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="exWorksDelivery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="guarantee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="personalDelivery" type="{http://dpd.com/common/service/types/ShipmentService/2.0}personalDelivery" minOccurs="0"/>
 *         &lt;element name="pickup" type="{http://dpd.com/common/service/types/ShipmentService/2.0}pickup" minOccurs="0"/>
 *         &lt;element name="parcelShopDelivery" type="{http://dpd.com/common/service/types/ShipmentService/2.0}parcelShopDelivery" minOccurs="0"/>
 *         &lt;element name="predict" type="{http://dpd.com/common/service/types/ShipmentService/2.0}notification" minOccurs="0"/>
 *         &lt;element name="personalDeliveryNotification" type="{http://dpd.com/common/service/types/ShipmentService/2.0}notification" minOccurs="0"/>
 *         &lt;element name="proactiveNotification" type="{http://dpd.com/common/service/types/ShipmentService/2.0}proactiveNotification" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="delivery" type="{http://dpd.com/common/service/types/ShipmentService/2.0}delivery" minOccurs="0"/>
 *         &lt;element name="invoiceAddress" type="{http://dpd.com/common/service/types/ShipmentService/2.0}address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productAndServiceData", propOrder = {
    "orderType",
    "saturdayDelivery",
    "exWorksDelivery",
    "guarantee",
    "personalDelivery",
    "pickup",
    "parcelShopDelivery",
    "predict",
    "personalDeliveryNotification",
    "proactiveNotification",
    "delivery",
    "invoiceAddress"
})
public class ProductAndServiceData {

    @XmlElement(required = true)
    protected String orderType;
    protected Boolean saturdayDelivery;
    protected Boolean exWorksDelivery;
    protected Boolean guarantee;
    protected PersonalDelivery personalDelivery;
    protected Pickup pickup;
    protected ParcelShopDelivery parcelShopDelivery;
    protected Notification predict;
    protected Notification personalDeliveryNotification;
    protected List<ProactiveNotification> proactiveNotification;
    protected Delivery delivery;
    protected Address invoiceAddress;

    /**
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * Gets the value of the saturdayDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSaturdayDelivery() {
        return saturdayDelivery;
    }

    /**
     * Sets the value of the saturdayDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSaturdayDelivery(Boolean value) {
        this.saturdayDelivery = value;
    }

    /**
     * Gets the value of the exWorksDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExWorksDelivery() {
        return exWorksDelivery;
    }

    /**
     * Sets the value of the exWorksDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExWorksDelivery(Boolean value) {
        this.exWorksDelivery = value;
    }

    /**
     * Gets the value of the guarantee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuarantee() {
        return guarantee;
    }

    /**
     * Sets the value of the guarantee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuarantee(Boolean value) {
        this.guarantee = value;
    }

    /**
     * Gets the value of the personalDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link PersonalDelivery }
     *     
     */
    public PersonalDelivery getPersonalDelivery() {
        return personalDelivery;
    }

    /**
     * Sets the value of the personalDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonalDelivery }
     *     
     */
    public void setPersonalDelivery(PersonalDelivery value) {
        this.personalDelivery = value;
    }

    /**
     * Gets the value of the pickup property.
     * 
     * @return
     *     possible object is
     *     {@link Pickup }
     *     
     */
    public Pickup getPickup() {
        return pickup;
    }

    /**
     * Sets the value of the pickup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pickup }
     *     
     */
    public void setPickup(Pickup value) {
        this.pickup = value;
    }

    /**
     * Gets the value of the parcelShopDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link ParcelShopDelivery }
     *     
     */
    public ParcelShopDelivery getParcelShopDelivery() {
        return parcelShopDelivery;
    }

    /**
     * Sets the value of the parcelShopDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParcelShopDelivery }
     *     
     */
    public void setParcelShopDelivery(ParcelShopDelivery value) {
        this.parcelShopDelivery = value;
    }

    /**
     * Gets the value of the predict property.
     * 
     * @return
     *     possible object is
     *     {@link Notification }
     *     
     */
    public Notification getPredict() {
        return predict;
    }

    /**
     * Sets the value of the predict property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notification }
     *     
     */
    public void setPredict(Notification value) {
        this.predict = value;
    }

    /**
     * Gets the value of the personalDeliveryNotification property.
     * 
     * @return
     *     possible object is
     *     {@link Notification }
     *     
     */
    public Notification getPersonalDeliveryNotification() {
        return personalDeliveryNotification;
    }

    /**
     * Sets the value of the personalDeliveryNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notification }
     *     
     */
    public void setPersonalDeliveryNotification(Notification value) {
        this.personalDeliveryNotification = value;
    }

    /**
     * Gets the value of the proactiveNotification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proactiveNotification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProactiveNotification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProactiveNotification }
     * 
     * 
     */
    public List<ProactiveNotification> getProactiveNotification() {
        if (proactiveNotification == null) {
            proactiveNotification = new ArrayList<ProactiveNotification>();
        }
        return this.proactiveNotification;
    }

    /**
     * Gets the value of the delivery property.
     * 
     * @return
     *     possible object is
     *     {@link Delivery }
     *     
     */
    public Delivery getDelivery() {
        return delivery;
    }

    /**
     * Sets the value of the delivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Delivery }
     *     
     */
    public void setDelivery(Delivery value) {
        this.delivery = value;
    }

    /**
     * Gets the value of the invoiceAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    /**
     * Sets the value of the invoiceAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setInvoiceAddress(Address value) {
        this.invoiceAddress = value;
    }

}