
package com.winit.label.manager.impl.us.usps.intl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FrozenDispatchesResult complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FrozenDispatchesResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FrozenDispatches" type="{http://www.usps-cpas.com/usps-cpas/GSSAPI/}ArrayOfFrozenDispatch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FrozenDispatchesResult", propOrder = {
    "responseCode",
    "message",
    "frozenDispatches"
})
public class FrozenDispatchesResult {

    @XmlElement(name = "ResponseCode")
    protected int responseCode;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "FrozenDispatches")
    protected ArrayOfFrozenDispatch frozenDispatches;

    /**
     * ��ȡresponseCode���Ե�ֵ��
     * 
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * ����responseCode���Ե�ֵ��
     * 
     */
    public void setResponseCode(int value) {
        this.responseCode = value;
    }

    /**
     * ��ȡmessage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * ����message���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * ��ȡfrozenDispatches���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFrozenDispatch }
     *     
     */
    public ArrayOfFrozenDispatch getFrozenDispatches() {
        return frozenDispatches;
    }

    /**
     * ����frozenDispatches���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFrozenDispatch }
     *     
     */
    public void setFrozenDispatches(ArrayOfFrozenDispatch value) {
        this.frozenDispatches = value;
    }

}
