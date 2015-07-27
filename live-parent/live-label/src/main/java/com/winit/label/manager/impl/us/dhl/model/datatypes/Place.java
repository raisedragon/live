//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.04 at 03:48:22 ���� CST 
//


package com.winit.label.manager.impl.us.dhl.model.datatypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Place complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Place">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResidenceOrBusiness" type="{http://www.dhl.com/datatypes}ResidenceOrBusiness" minOccurs="0"/>
 *         &lt;element name="CompanyName" type="{http://www.dhl.com/datatypes}CompanyNameValidator" minOccurs="0"/>
 *         &lt;element name="AddressLine" type="{http://www.dhl.com/datatypes}AddressLine" maxOccurs="3" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.dhl.com/datatypes}City"/>
 *         &lt;element name="CountryCode" type="{http://www.dhl.com/datatypes}CountryCode"/>
 *         &lt;element name="DivisionCode" type="{http://www.dhl.com/datatypes}StateCode" minOccurs="0"/>
 *         &lt;element name="Division" type="{http://www.dhl.com/datatypes}State"/>
 *         &lt;element name="PostalCode" type="{http://www.dhl.com/datatypes}PostalCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Place", propOrder = {
    "residenceOrBusiness",
    "companyName",
    "addressLine",
    "city",
    "countryCode",
    "divisionCode",
    "division",
    "postalCode"
})
public class Place {

    @XmlElement(name = "ResidenceOrBusiness")
    protected ResidenceOrBusiness residenceOrBusiness;
    @XmlElement(name = "CompanyName")
    protected String companyName;
    @XmlElement(name = "AddressLine")
    protected List<String> addressLine;
    @XmlElement(name = "City", required = true)
    protected String city;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "DivisionCode")
    protected String divisionCode;
    @XmlElement(name = "Division", required = true)
    protected String division;
    @XmlElement(name = "PostalCode", required = true)
    protected String postalCode;

    /**
     * Gets the value of the residenceOrBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link ResidenceOrBusiness }
     *     
     */
    public ResidenceOrBusiness getResidenceOrBusiness() {
        return residenceOrBusiness;
    }

    /**
     * Sets the value of the residenceOrBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidenceOrBusiness }
     *     
     */
    public void setResidenceOrBusiness(ResidenceOrBusiness value) {
        this.residenceOrBusiness = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the addressLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<String>();
        }
        return this.addressLine;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the divisionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivisionCode() {
        return divisionCode;
    }

    /**
     * Sets the value of the divisionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivisionCode(String value) {
        this.divisionCode = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

}