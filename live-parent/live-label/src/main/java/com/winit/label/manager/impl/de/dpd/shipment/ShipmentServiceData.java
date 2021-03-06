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
 * Bundles shipment service data.
 * 
 * <p>Java class for shipmentServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shipmentServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generalShipmentData" type="{http://dpd.com/common/service/types/ShipmentService/2.0}generalShipmentData"/>
 *         &lt;element name="parcels" type="{http://dpd.com/common/service/types/ShipmentService/2.0}parcel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productAndServiceData" type="{http://dpd.com/common/service/types/ShipmentService/2.0}productAndServiceData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipmentServiceData", propOrder = {
    "generalShipmentData",
    "parcels",
    "productAndServiceData"
})
public class ShipmentServiceData {

    @XmlElement(required = true)
    protected GeneralShipmentData generalShipmentData;
    protected List<Parcel> parcels;
    @XmlElement(required = true)
    protected ProductAndServiceData productAndServiceData;

    /**
     * Gets the value of the generalShipmentData property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralShipmentData }
     *     
     */
    public GeneralShipmentData getGeneralShipmentData() {
        return generalShipmentData;
    }

    /**
     * Sets the value of the generalShipmentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralShipmentData }
     *     
     */
    public void setGeneralShipmentData(GeneralShipmentData value) {
        this.generalShipmentData = value;
    }

    /**
     * Gets the value of the parcels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parcels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParcels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parcel }
     * 
     * 
     */
    public List<Parcel> getParcels() {
        if (parcels == null) {
            parcels = new ArrayList<Parcel>();
        }
        return this.parcels;
    }
    
    public void setParcels(List<Parcel> parcels) {
    	this.parcels = parcels;
    }

    /**
     * Gets the value of the productAndServiceData property.
     * 
     * @return
     *     possible object is
     *     {@link ProductAndServiceData }
     *     
     */
    public ProductAndServiceData getProductAndServiceData() {
        return productAndServiceData;
    }

    /**
     * Sets the value of the productAndServiceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductAndServiceData }
     *     
     */
    public void setProductAndServiceData(ProductAndServiceData value) {
        this.productAndServiceData = value;
    }

}
