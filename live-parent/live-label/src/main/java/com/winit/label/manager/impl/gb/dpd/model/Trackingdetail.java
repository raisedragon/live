//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.03 at 10:27:01 ���� CST 
//


package com.winit.label.manager.impl.gb.dpd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trackingdetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trackingdetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trackingnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parcelnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consignmentnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryaddress1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveryaddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverylocality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverycity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverypostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverycountrycode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackingevents" type="{http://www.example.org/trackingresponse}trackingevents"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trackingdetail")
public class Trackingdetail {
	protected String error;
    protected String trackingnumber;
    protected String parcelnumber;
    protected String consignmentnumber;
    @XmlElement(required = true)
    protected String deliveryaddress1;
    protected String deliveryaddress2;
    protected String deliverylocality;
    protected String deliverycity;
    protected String deliverypostcode;
    protected String deliverycountrycode;
    @XmlElement(required = true)
    protected Trackingevents trackingevents;
    
    
    
    public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	/**
     * Gets the value of the trackingnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingnumber() {
        return trackingnumber;
    }

    /**
     * Sets the value of the trackingnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingnumber(String value) {
        this.trackingnumber = value;
    }

    /**
     * Gets the value of the parcelnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParcelnumber() {
        return parcelnumber;
    }

    /**
     * Sets the value of the parcelnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParcelnumber(String value) {
        this.parcelnumber = value;
    }

    /**
     * Gets the value of the consignmentnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsignmentnumber() {
        return consignmentnumber;
    }

    /**
     * Sets the value of the consignmentnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsignmentnumber(String value) {
        this.consignmentnumber = value;
    }

    /**
     * Gets the value of the deliveryaddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryaddress1() {
        return deliveryaddress1;
    }

    /**
     * Sets the value of the deliveryaddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryaddress1(String value) {
        this.deliveryaddress1 = value;
    }

    /**
     * Gets the value of the deliveryaddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryaddress2() {
        return deliveryaddress2;
    }

    /**
     * Sets the value of the deliveryaddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryaddress2(String value) {
        this.deliveryaddress2 = value;
    }

    /**
     * Gets the value of the deliverylocality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverylocality() {
        return deliverylocality;
    }

    /**
     * Sets the value of the deliverylocality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverylocality(String value) {
        this.deliverylocality = value;
    }

    /**
     * Gets the value of the deliverycity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverycity() {
        return deliverycity;
    }

    /**
     * Sets the value of the deliverycity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverycity(String value) {
        this.deliverycity = value;
    }

    /**
     * Gets the value of the deliverypostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverypostcode() {
        return deliverypostcode;
    }

    /**
     * Sets the value of the deliverypostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverypostcode(String value) {
        this.deliverypostcode = value;
    }

    /**
     * Gets the value of the deliverycountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverycountrycode() {
        return deliverycountrycode;
    }

    /**
     * Sets the value of the deliverycountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverycountrycode(String value) {
        this.deliverycountrycode = value;
    }

    /**
     * Gets the value of the trackingevents property.
     * 
     * @return
     *     possible object is
     *     {@link Trackingevents }
     *     
     */
    public Trackingevents getTrackingevents() {
        return trackingevents;
    }

    /**
     * Sets the value of the trackingevents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Trackingevents }
     *     
     */
    public void setTrackingevents(Trackingevents value) {
        this.trackingevents = value;
    }

}
