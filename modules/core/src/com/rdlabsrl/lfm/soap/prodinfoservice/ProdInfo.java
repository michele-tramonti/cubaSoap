//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.09 at 06:23:24 PM CEST 
//


package com.rdlabsrl.lfm.soap.prodinfoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prodInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prodInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="workOrder" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="gtin" type="{prodInfoService.soap.lfm.rdlabsrl.com}gtin"/&gt;
 *         &lt;element name="materiale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="serType" type="{prodInfoService.soap.lfm.rdlabsrl.com}serType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prodInfo", propOrder = {
    "workOrder",
    "gtin",
    "materiale",
    "info",
    "serType"
})
public class ProdInfo {

    @XmlElement(required = true)
    protected String workOrder;
    @XmlElement(required = true)
    protected String gtin;
    @XmlElement(required = true)
    protected String materiale;
    @XmlElement(required = true)
    protected String info;
    protected int serType;

    /**
     * Gets the value of the workOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkOrder() {
        return workOrder;
    }

    /**
     * Sets the value of the workOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkOrder(String value) {
        this.workOrder = value;
    }

    /**
     * Gets the value of the gtin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGtin() {
        return gtin;
    }

    /**
     * Sets the value of the gtin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGtin(String value) {
        this.gtin = value;
    }

    /**
     * Gets the value of the materiale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMateriale() {
        return materiale;
    }

    /**
     * Sets the value of the materiale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMateriale(String value) {
        this.materiale = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Gets the value of the serType property.
     * 
     */
    public int getSerType() {
        return serType;
    }

    /**
     * Sets the value of the serType property.
     * 
     */
    public void setSerType(int value) {
        this.serType = value;
    }

}
