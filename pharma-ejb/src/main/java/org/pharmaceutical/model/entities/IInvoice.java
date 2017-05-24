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
@Table(name = "i_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IInvoice.findAll", query = "SELECT i FROM IInvoice i"),
    @NamedQuery(name = "IInvoice.findByIInvoiceId", query = "SELECT i FROM IInvoice i WHERE i.iInvoiceId = :iInvoiceId"),
    @NamedQuery(name = "IInvoice.findByIsactive", query = "SELECT i FROM IInvoice i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IInvoice.findByCreated", query = "SELECT i FROM IInvoice i WHERE i.created = :created"),
    @NamedQuery(name = "IInvoice.findByCreatedby", query = "SELECT i FROM IInvoice i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IInvoice.findByUpdated", query = "SELECT i FROM IInvoice i WHERE i.updated = :updated"),
    @NamedQuery(name = "IInvoice.findByUpdatedby", query = "SELECT i FROM IInvoice i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IInvoice.findByIIsimported", query = "SELECT i FROM IInvoice i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IInvoice.findByIErrormsg", query = "SELECT i FROM IInvoice i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IInvoice.findByProcessing", query = "SELECT i FROM IInvoice i WHERE i.processing = :processing"),
    @NamedQuery(name = "IInvoice.findByProcessed", query = "SELECT i FROM IInvoice i WHERE i.processed = :processed"),
    @NamedQuery(name = "IInvoice.findByIssotrx", query = "SELECT i FROM IInvoice i WHERE i.issotrx = :issotrx"),
    @NamedQuery(name = "IInvoice.findByBpartnervalue", query = "SELECT i FROM IInvoice i WHERE i.bpartnervalue = :bpartnervalue"),
    @NamedQuery(name = "IInvoice.findByName", query = "SELECT i FROM IInvoice i WHERE i.name = :name"),
    @NamedQuery(name = "IInvoice.findByAddress1", query = "SELECT i FROM IInvoice i WHERE i.address1 = :address1"),
    @NamedQuery(name = "IInvoice.findByAddress2", query = "SELECT i FROM IInvoice i WHERE i.address2 = :address2"),
    @NamedQuery(name = "IInvoice.findByPostal", query = "SELECT i FROM IInvoice i WHERE i.postal = :postal"),
    @NamedQuery(name = "IInvoice.findByCity", query = "SELECT i FROM IInvoice i WHERE i.city = :city"),
    @NamedQuery(name = "IInvoice.findByRegionname", query = "SELECT i FROM IInvoice i WHERE i.regionname = :regionname"),
    @NamedQuery(name = "IInvoice.findByEmail", query = "SELECT i FROM IInvoice i WHERE i.email = :email"),
    @NamedQuery(name = "IInvoice.findByContactname", query = "SELECT i FROM IInvoice i WHERE i.contactname = :contactname"),
    @NamedQuery(name = "IInvoice.findByPhone", query = "SELECT i FROM IInvoice i WHERE i.phone = :phone"),
    @NamedQuery(name = "IInvoice.findByCountrycode", query = "SELECT i FROM IInvoice i WHERE i.countrycode = :countrycode"),
    @NamedQuery(name = "IInvoice.findByDoctypename", query = "SELECT i FROM IInvoice i WHERE i.doctypename = :doctypename"),
    @NamedQuery(name = "IInvoice.findByPaymenttermvalue", query = "SELECT i FROM IInvoice i WHERE i.paymenttermvalue = :paymenttermvalue"),
    @NamedQuery(name = "IInvoice.findByDocumentno", query = "SELECT i FROM IInvoice i WHERE i.documentno = :documentno"),
    @NamedQuery(name = "IInvoice.findByDescription", query = "SELECT i FROM IInvoice i WHERE i.description = :description"),
    @NamedQuery(name = "IInvoice.findByProductvalue", query = "SELECT i FROM IInvoice i WHERE i.productvalue = :productvalue"),
    @NamedQuery(name = "IInvoice.findByUpc", query = "SELECT i FROM IInvoice i WHERE i.upc = :upc"),
    @NamedQuery(name = "IInvoice.findBySku", query = "SELECT i FROM IInvoice i WHERE i.sku = :sku"),
    @NamedQuery(name = "IInvoice.findByTaxindicator", query = "SELECT i FROM IInvoice i WHERE i.taxindicator = :taxindicator"),
    @NamedQuery(name = "IInvoice.findByTaxamt", query = "SELECT i FROM IInvoice i WHERE i.taxamt = :taxamt"),
    @NamedQuery(name = "IInvoice.findByLinedescription", query = "SELECT i FROM IInvoice i WHERE i.linedescription = :linedescription"),
    @NamedQuery(name = "IInvoice.findByQtyordered", query = "SELECT i FROM IInvoice i WHERE i.qtyordered = :qtyordered"),
    @NamedQuery(name = "IInvoice.findByPriceactual", query = "SELECT i FROM IInvoice i WHERE i.priceactual = :priceactual")})
public class IInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_invoice_id")
    private String iInvoiceId;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 60)
    @Column(name = "contactname")
    private String contactname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "phone")
    private String phone;
    @Size(max = 2)
    @Column(name = "countrycode")
    private String countrycode;
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
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;

    public IInvoice() {
    }

    public IInvoice(String iInvoiceId) {
        this.iInvoiceId = iInvoiceId;
    }

    public String getIInvoiceId() {
        return iInvoiceId;
    }

    public void setIInvoiceId(String iInvoiceId) {
        this.iInvoiceId = iInvoiceId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
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

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iInvoiceId != null ? iInvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IInvoice)) {
            return false;
        }
        IInvoice other = (IInvoice) object;
        if ((this.iInvoiceId == null && other.iInvoiceId != null) || (this.iInvoiceId != null && !this.iInvoiceId.equals(other.iInvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IInvoice[ iInvoiceId=" + iInvoiceId + " ]";
    }
    
}
