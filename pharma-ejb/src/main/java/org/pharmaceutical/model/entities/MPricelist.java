/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_pricelist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPricelist.findAll", query = "SELECT m FROM MPricelist m"),
    @NamedQuery(name = "MPricelist.findByMPricelistId", query = "SELECT m FROM MPricelist m WHERE m.mPricelistId = :mPricelistId"),
    @NamedQuery(name = "MPricelist.findByIsactive", query = "SELECT m FROM MPricelist m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MPricelist.findByCreated", query = "SELECT m FROM MPricelist m WHERE m.created = :created"),
    @NamedQuery(name = "MPricelist.findByCreatedby", query = "SELECT m FROM MPricelist m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MPricelist.findByUpdated", query = "SELECT m FROM MPricelist m WHERE m.updated = :updated"),
    @NamedQuery(name = "MPricelist.findByUpdatedby", query = "SELECT m FROM MPricelist m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MPricelist.findByName", query = "SELECT m FROM MPricelist m WHERE m.name = :name"),
    @NamedQuery(name = "MPricelist.findByDescription", query = "SELECT m FROM MPricelist m WHERE m.description = :description"),
    @NamedQuery(name = "MPricelist.findByIstaxincluded", query = "SELECT m FROM MPricelist m WHERE m.istaxincluded = :istaxincluded"),
    @NamedQuery(name = "MPricelist.findByIssopricelist", query = "SELECT m FROM MPricelist m WHERE m.issopricelist = :issopricelist"),
    @NamedQuery(name = "MPricelist.findByIsdefault", query = "SELECT m FROM MPricelist m WHERE m.isdefault = :isdefault"),
    @NamedQuery(name = "MPricelist.findByEnforcepricelimit", query = "SELECT m FROM MPricelist m WHERE m.enforcepricelimit = :enforcepricelimit")})
public class MPricelist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_pricelist_id")
    private String mPricelistId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istaxincluded")
    private Character istaxincluded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issopricelist")
    private Character issopricelist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enforcepricelimit")
    private Character enforcepricelimit;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poPricelistId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mPricelistId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mPricelistId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<CProjectVendor> cProjectVendorList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "basepricelistId")
    private List<MPricelist> mPricelistList;
    @JoinColumn(name = "basepricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist basepricelistId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mPricelistId")
    private List<MPricelistVersion> mPricelistVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mPricelistId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mPricelistId")
    private List<MOfferPricelist> mOfferPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<STimeexpense> sTimeexpenseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<MRequisition> mRequisitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistId")
    private List<CProject> cProjectList;

    public MPricelist() {
    }

    public MPricelist(String mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public MPricelist(String mPricelistId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istaxincluded, Character issopricelist, Character isdefault, Character enforcepricelimit) {
        this.mPricelistId = mPricelistId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istaxincluded = istaxincluded;
        this.issopricelist = issopricelist;
        this.isdefault = isdefault;
        this.enforcepricelimit = enforcepricelimit;
    }

    public String getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(String mPricelistId) {
        this.mPricelistId = mPricelistId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIstaxincluded() {
        return istaxincluded;
    }

    public void setIstaxincluded(Character istaxincluded) {
        this.istaxincluded = istaxincluded;
    }

    public Character getIssopricelist() {
        return issopricelist;
    }

    public void setIssopricelist(Character issopricelist) {
        this.issopricelist = issopricelist;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public Character getEnforcepricelimit() {
        return enforcepricelimit;
    }

    public void setEnforcepricelimit(Character enforcepricelimit) {
        this.enforcepricelimit = enforcepricelimit;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CProjectVendor> getCProjectVendorList() {
        return cProjectVendorList;
    }

    public void setCProjectVendorList(List<CProjectVendor> cProjectVendorList) {
        this.cProjectVendorList = cProjectVendorList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @XmlTransient
    public List<MPricelist> getMPricelistList() {
        return mPricelistList;
    }

    public void setMPricelistList(List<MPricelist> mPricelistList) {
        this.mPricelistList = mPricelistList;
    }

    public MPricelist getBasepricelistId() {
        return basepricelistId;
    }

    public void setBasepricelistId(MPricelist basepricelistId) {
        this.basepricelistId = basepricelistId;
    }

    @XmlTransient
    public List<MPricelistVersion> getMPricelistVersionList() {
        return mPricelistVersionList;
    }

    public void setMPricelistVersionList(List<MPricelistVersion> mPricelistVersionList) {
        this.mPricelistVersionList = mPricelistVersionList;
    }

    @XmlTransient
    public List<CExternalpos> getCExternalposList() {
        return cExternalposList;
    }

    public void setCExternalposList(List<CExternalpos> cExternalposList) {
        this.cExternalposList = cExternalposList;
    }

    @XmlTransient
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
    }

    @XmlTransient
    public List<MOfferPricelist> getMOfferPricelistList() {
        return mOfferPricelistList;
    }

    public void setMOfferPricelistList(List<MOfferPricelist> mOfferPricelistList) {
        this.mOfferPricelistList = mOfferPricelistList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<STimeexpense> getSTimeexpenseList() {
        return sTimeexpenseList;
    }

    public void setSTimeexpenseList(List<STimeexpense> sTimeexpenseList) {
        this.sTimeexpenseList = sTimeexpenseList;
    }

    @XmlTransient
    public List<MRequisition> getMRequisitionList() {
        return mRequisitionList;
    }

    public void setMRequisitionList(List<MRequisition> mRequisitionList) {
        this.mRequisitionList = mRequisitionList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mPricelistId != null ? mPricelistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPricelist)) {
            return false;
        }
        MPricelist other = (MPricelist) object;
        if ((this.mPricelistId == null && other.mPricelistId != null) || (this.mPricelistId != null && !this.mPricelistId.equals(other.mPricelistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MPricelist[ mPricelistId=" + mPricelistId + " ]";
    }
    
}
