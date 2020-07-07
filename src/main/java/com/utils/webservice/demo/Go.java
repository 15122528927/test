
package com.utils.webservice.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="phones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="officeNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mesNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsurl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="system" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "phones",
    "content",
    "officeNO",
    "mesNO",
    "wsurl",
    "method",
    "system"
})
@XmlRootElement(name = "go")
public class Go {

    @XmlElementRef(name = "phones", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> phones;
    @XmlElementRef(name = "content", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> content;
    @XmlElementRef(name = "officeNO", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> officeNO;
    @XmlElementRef(name = "mesNO", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mesNO;
    @XmlElementRef(name = "wsurl", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> wsurl;
    @XmlElementRef(name = "method", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> method;
    @XmlElementRef(name = "system", namespace = "http://controller.sms.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> system;

    /**
     * ��ȡphones���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhones() {
        return phones;
    }

    /**
     * ����phones���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhones(JAXBElement<String> value) {
        this.phones = value;
    }

    /**
     * ��ȡcontent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContent() {
        return content;
    }

    /**
     * ����content���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContent(JAXBElement<String> value) {
        this.content = value;
    }

    /**
     * ��ȡofficeNO���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOfficeNO() {
        return officeNO;
    }

    /**
     * ����officeNO���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfficeNO(JAXBElement<String> value) {
        this.officeNO = value;
    }

    /**
     * ��ȡmesNO���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMesNO() {
        return mesNO;
    }

    /**
     * ����mesNO���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMesNO(JAXBElement<String> value) {
        this.mesNO = value;
    }

    /**
     * ��ȡwsurl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWsurl() {
        return wsurl;
    }

    /**
     * ����wsurl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWsurl(JAXBElement<String> value) {
        this.wsurl = value;
    }

    /**
     * ��ȡmethod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMethod() {
        return method;
    }

    /**
     * ����method���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMethod(JAXBElement<String> value) {
        this.method = value;
    }

    /**
     * ��ȡsystem���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSystem() {
        return system;
    }

    /**
     * ����system���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSystem(JAXBElement<String> value) {
        this.system = value;
    }

}
