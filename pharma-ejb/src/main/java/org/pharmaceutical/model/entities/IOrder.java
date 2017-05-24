/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "i_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IOrder.findAll", query = "SELECT i FROM IOrder i"),
    @NamedQuery(name = "IOrder.findByIOrderId", query = "SELECT i FROM IOrder i WHERE i.iOrderId = :iOrderId"),
    @NamedQuery(name = "IOrder.findByIsactive", query = "SELECT i FROM IOrder i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IOrder.findByCreated", query = "SELECT i FROM IOrder i WHERE i.created = :created"),
    @NamedQuery(name = "IOrder.findByCreatedby", query = "SELECT i FROM IOrder i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IOrder.findByUpdated", query = "SELECT i FROM IOrder i WHERE i.updated = :updated"),
    @NamedQuery(name = "IOrder.findByUpdatedby", query = "SELECT i FROM IOrder i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IOrder.findByIIsimported", query = "SELECT i FROM IOrder i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IOrder.findByIErrormsg", query = "SELECT i FROM IOrder i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IOrder.findByProcessing", query = "SELECT i FROM IOrder i WHERE i.processing = :processing"),
    @NamedQuery(name = "IOrder.findByProcessed", query = "SELECT i FROM IOrder i WHERE i.processed = :processed"),
    @NamedQuery(name = "IOrder.findByIssotrx", query = "SELECT i FROM IOrder i WHERE i.issotrx = :issotrx"),
    @NamedQuery(name = "IOrder.findByCBpartnerId", query = "SELECT i FROM IOrder i WHERE i.cBpartnerId = :cBpartnerId"),
    @NamedQuery(name = "IOrder.findByBpartnervalue", query = "SELECT i FROM IOrder i WHERE i.bpartnervalue = :bpartnervalue"),
    @NamedQuery(name = "IOrder.findByName", query = "SELECT i FROM IOrder i WHERE i.name = :name"),
    @NamedQuery(name = "IOrder.findByAddress1", query = "SELECT i FROM IOrder i WHERE i.address1 = :address1"),
    @NamedQuery(name = "IOrder.findByAddress2", query = "SELECT i FROM IOrder i WHERE i.address2 = :address2"),
    @NamedQuery(name = "IOrder.findByPostal", query = "SELECT i FROM IOrder i WHERE i.postal = :postal"),
    @NamedQuery(name = "IOrder.findByCity", query = "SELECT i FROM IOrder i WHERE i.city = :city"),
    @NamedQuery(name = "IOrder.findByRegionname", query = "SELECT i FROM IOrder i WHERE i.regionname = :regionname"),
    @NamedQuery(name = "IOrder.findByCountrycode", query = "SELECT i FROM IOrder i WHERE i.countrycode = :countrycode"),
    @NamedQuery(name = "IOrder.findByContactname", query = "SELECT i FROM IOrder i WHERE i.contactname = :contactname"),
    @NamedQuery(name = "IOrder.findByEmail", query = "SELECT i FROM IOrder i WHERE i.email = :email"),
    @NamedQuery(name = "IOrder.findByPhone", query = "SELECT i FROM IOrder i WHERE i.phone = :phone"),
    @NamedQuery(name = "IOrder.findByDoctypename", query = "SELECT i FROM IOrder i WHERE i.doctypename = :doctypename"),
    @NamedQuery(name = "IOrder.findByPaymenttermvalue", query = "SELECT i FROM IOrder i WHERE i.paymenttermvalue = :paymenttermvalue"),
    @NamedQuery(name = "IOrder.findByDocumentno", query = "SELECT i FROM IOrder i WHERE i.documentno = :documentno"),
    @NamedQuery(name = "IOrder.findByDescription", query = "SELECT i FROM IOrder i WHERE i.description = :description"),
    @NamedQuery(name = "IOrder.findByMProductId", query = "SELECT i FROM IOrder i WHERE i.mProductId = :mProductId"),
    @NamedQuery(name = "IOrder.findByProductvalue", query = "SELECT i FROM IOrder i WHERE i.productvalue = :productvalue"),
    @NamedQuery(name = "IOrder.findByUpc", query = "SELECT i FROM IOrder i WHERE i.upc = :upc"),
    @NamedQuery(name = "IOrder.findBySku", query = "SELECT i FROM IOrder i WHERE i.sku = :sku"),
    @NamedQuery(name = "IOrder.findByTaxindicator", query = "SELECT i FROM IOrder i WHERE i.taxindicator = :taxindicator"),
    @NamedQuery(name = "IOrder.findByTaxamt", query = "SELECT i FROM IOrder i WHERE i.taxamt = :taxamt"),
    @NamedQuery(name = "IOrder.findByLinedescription", query = "SELECT i FROM IOrder i WHERE i.linedescription = :linedescription"),
    @NamedQuery(name = "IOrder.findByQtyordered", query = "SELECT i FROM IOrder i WHERE i.qtyordered = :qtyordered"),
    @NamedQuery(name = "IOrder.findByPriceactual", query = "SELECT i FROM IOrder i WHERE i.priceactual = :priceactual"),
    @NamedQuery(name = "IOrder.findByBilltoUpc", query = "SELECT i FROM IOrder i WHERE i.billtoUpc = :billtoUpc"),
    @NamedQuery(name = "IOrder.findByBpartnerupc", query = "SELECT i FROM IOrder i WHERE i.bpartnerupc = :bpartnerupc"),
    @NamedQuery(name = "IOrder.findByCBpartnerLocationUpc", query = "SELECT i FROM IOrder i WHERE i.cBpartnerLocationUpc = :cBpartnerLocationUpc"),
    @NamedQuery(name = "IOrder.findByDateordered", query = "SELECT i FROM IOrder i WHERE i.dateordered = :dateordered"),
    @NamedQuery(name = "IOrder.findByDatepromised", query = "SELECT i FROM IOrder i WHERE i.datepromised = :datepromised"),
    @NamedQuery(name = "IOrder.findByOrderReferenceno", query = "SELECT i FROM IOrder i WHERE i.orderReferenceno = :orderReferenceno"),
    @NamedQuery(name = "IOrder.findByPaymentamount1", query = "SELECT i FROM IOrder i WHERE i.paymentamount1 = :paymentamount1"),
    @NamedQuery(name = "IOrder.findByPaymentamount2", query = "SELECT i FROM IOrder i WHERE i.paymentamount2 = :paymentamount2"),
    @NamedQuery(name = "IOrder.findByPaymentrule1", query = "SELECT i FROM IOrder i WHERE i.paymentrule1 = :paymentrule1"),
    @NamedQuery(name = "IOrder.findByPaymentrule2", query = "SELECT i FROM IOrder i WHERE i.paymentrule2 = :paymentrule2"),
    @NamedQuery(name = "IOrder.findByPerformPost", query = "SELECT i FROM IOrder i WHERE i.performPost = :performPost"),
    @NamedQuery(name = "IOrder.findByVendorUpc", query = "SELECT i FROM IOrder i WHERE i.vendorUpc = :vendorUpc"),
    @NamedQuery(name = "IOrder.findByAttributesetident", query = "SELECT i FROM IOrder i WHERE i.attributesetident = :attributesetident"),
    @NamedQuery(name = "IOrder.findBySynchronized1", query = "SELECT i FROM IOrder i WHERE i.synchronized1 = :synchronized1")})
public class IOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_order_id")
    private String iOrderId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Column(name = "issotrx")
    private Character issotrx;
    @Size(max = 32)
    @Column(name = "c_bpartner_id")
    private String cBpartnerId;
    @Size(max = 40)
    @Column(name = "bpartnervalue")
    private String bpartnervalue;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 60)
    @Column(name = "address1")
    private String address1;
    @Size(max = 60)
    @Column(name = "address2")
    private String address2;
    @Size(max = 10)
    @Column(name = "postal")
    private String postal;
    @Size(max = 60)
    @Column(name = "city")
    private String city;
    @Size(max = 60)
    @Column(name = "regionname")
    private String regionname;
    @Size(max = 2)
    @Column(name = "countrycode")
    private String countrycode;
    @Size(max = 60)
    @Column(name = "contactname")
    private String contactname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "phone")
    private String phone;
    @Size(max = 60)
    @Column(name = "doctypename")
    private String doctypename;
    @Size(max = 40)
    @Column(name = "paymenttermvalue")
    private String paymenttermvalue;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 32)
    @Column(name = "m_product_id")
    private String mProductId;
    @Size(max = 40)
    @Column(name = "productvalue")
    private String productvalue;
    @Size(max = 30)
    @Column(name = "upc")
    private String upc;
    @Size(max = 30)
    @Column(name = "sku")
    private String sku;
    @Size(max = 5)
    @Column(name = "taxindicator")
    private String taxindicator;
    @Column(name = "taxamt")
    private BigInteger taxamt;
    @Size(max = 255)
    @Column(name = "linedescription")
    private String linedescription;
    @Column(name = "qtyordered")
    private BigInteger qtyordered;
    @Column(name = "priceactual")
    private BigInteger priceactual;
    @Size(max = 30)
    @Column(name = "billto_upc")
    private String billtoUpc;
    @Size(max = 30)
    @Column(name = "bpartnerupc")
    private String bpartnerupc;
    @Size(max = 30)
    @Column(name = "c_bpartner_location_upc")
    private String cBpartnerLocationUpc;
    @Column(name = "dateordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateordered;
    @Column(name = "datepromised")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepromised;
    @Size(max = 40)
    @Column(name = "order_referenceno")
    private String orderReferenceno;
    @Column(name = "paymentamount1")
    private BigInteger paymentamount1;
    @Column(name = "paymentamount2")
    private BigInteger paymentamount2;
    @Size(max = 60)
    @Column(name = "paymentrule1")
    private String paymentrule1;
    @Size(max = 60)
    @Column(name = "paymentrule2")
    private String paymentrule2;
    @Column(name = "perform_post")
    private Character performPost;
    @Size(max = 30)
    @Column(name = "vendor_upc")
    private String vendorUpc;
    @Size(max = 100)
    @Column(name = "attributesetident")
    private String attributesetident;
    @Column(name = "synchronized")
    private Character synchronized1;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "billto_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation billtoId;
    @JoinColumn(name = "m_shipper_id", referencedColumnName = "m_shipper_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MShipper mShipperId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse mWarehouseId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;

    public IOrder() {
    }

    public IOrder(String iOrderId) {
        this.iOrderId = iOrderId;
    }

    public String getIOrderId() {
        return iOrderId;
    }

    public void setIOrderId(String iOrderId) {
        this.iOrderId = iOrderId;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public String getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(String cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public String getBpartnervalue() {
        return bpartnervalue;
    }

    public void setBpartnervalue(String bpartnervalue) {
        this.bpartnervalue = bpartnervalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDoctypename() {
        return doctypename;
    }

    public void setDoctypename(String doctypename) {
        this.doctypename = doctypename;
    }

    public String getPaymenttermvalue() {
        return paymenttermvalue;
    }

    public void setPaymenttermvalue(String paymenttermvalue) {
        this.paymenttermvalue = paymenttermvalue;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMProductId() {
        return mProductId;
    }

    public void setMProductId(String mProductId) {
        this.mProductId = mProductId;
    }

    public String getProductvalue() {
        return productvalue;
    }

    public void setProductvalue(String productvalue) {
        this.productvalue = productvalue;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTaxindicator() {
        return taxindicator;
    }

    public void setTaxindicator(String taxindicator) {
        this.taxindicator = taxindicator;
    }

    public BigInteger getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigInteger taxamt) {
        this.taxamt = taxamt;
    }

    public String getLinedescription() {
        return linedescription;
    }

    public void setLinedescription(String linedescription) {
        this.linedescription = linedescription;
    }

    public BigInteger getQtyordered() {
        return qtyordered;
    }

    public void setQtyordered(BigInteger qtyordered) {
        this.qtyordered = qtyordered;
    }

    public BigInteger getPriceactual() {
        return priceactual;
    }

    public void setPriceactual(BigInteger priceactual) {
        this.priceactual = priceactual;
    }

    public String getBilltoUpc() {
        return billtoUpc;
    }

    public void setBilltoUpc(String billtoUpc) {
        this.billtoUpc = billtoUpc;
    }

    public String getBpartnerupc() {
        return bpartnerupc;
    }

    public void setBpartnerupc(String bpartnerupc) {
        this.bpartnerupc = bpartnerupc;
    }

    public String getCBpartnerLocationUpc() {
        return cBpartnerLocationUpc;
    }

    public void setCBpartnerLocationUpc(String cBpartnerLocationUpc) {
        this.cBpartnerLocationUpc = cBpartnerLocationUpc;
    }

    public Date getDateordered() {
        return dateordered;
    }

    public void setDateordered(Date dateordered) {
        this.dateordered = dateordered;
    }

    public Date getDatepromised() {
        return datepromised;
    }

    public void setDatepromised(Date datepromised) {
        this.datepromised = datepromised;
    }

    public String getOrderReferenceno() {
        return orderReferenceno;
    }

    public void setOrderReferenceno(String orderReferenceno) {
        this.orderReferenceno = orderReferenceno;
    }

    public BigInteger getPaymentamount1() {
        return paymentamount1;
    }

    public void setPaymentamount1(BigInteger paymentamount1) {
        this.paymentamount1 = paymentamount1;
    }

    public BigInteger getPaymentamount2() {
        return paymentamount2;
    }

    public void setPaymentamount2(BigInteger paymentamount2) {
        this.paymentamount2 = paymentamount2;
    }

    public String getPaymentrule1() {
        return paymentrule1;
    }

    public void setPaymentrule1(String paymentrule1) {
        this.paymentrule1 = paymentrule1;
    }

    public String getPaymentrule2() {
        return paymentrule2;
    }

    public void setPaymentrule2(String paymentrule2) {
        this.paymentrule2 = paymentrule2;
    }

    public Character getPerformPost() {
        return performPost;
    }

    public void setPerformPost(Character performPost) {
        this.performPost = performPost;
    }

    public String getVendorUpc() {
        return vendorUpc;
    }

    public void setVendorUpc(String vendorUpc) {
        this.vendorUpc = vendorUpc;
    }

    public String getAttributesetident() {
        return attributesetident;
    }

    public void setAttributesetident(String attributesetident) {
        this.attributesetident = attributesetident;
    }

    public Character getSynchronized1() {
        return synchronized1;
    }

    public void setSynchronized1(Character synchronized1) {
        this.synchronized1 = synchronized1;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CBpartnerLocation getBilltoId() {
        return billtoId;
    }

    public void setBilltoId(CBpartnerLocation billtoId) {
        this.billtoId = billtoId;
    }

    public MShipper getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(MShipper mShipperId) {
        this.mShipperId = mShipperId;
    }

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iOrderId != null ? iOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IOrder)) {
            return false;
        }
        IOrder other = (IOrder) object;
        if ((this.iOrderId == null && other.iOrderId != null) || (this.iOrderId != null && !this.iOrderId.equals(other.iOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IOrder[ iOrderId=" + iOrderId + " ]";
    }
    
}
