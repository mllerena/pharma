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
@Table(name = "m_pricelist_version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPricelistVersion.findAll", query = "SELECT m FROM MPricelistVersion m"),
    @NamedQuery(name = "MPricelistVersion.findByMPricelistVersionId", query = "SELECT m FROM MPricelistVersion m WHERE m.mPricelistVersionId = :mPricelistVersionId"),
    @NamedQuery(name = "MPricelistVersion.findByIsactive", query = "SELECT m FROM MPricelistVersion m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MPricelistVersion.findByCreated", query = "SELECT m FROM MPricelistVersion m WHERE m.created = :created"),
    @NamedQuery(name = "MPricelistVersion.findByCreatedby", query = "SELECT m FROM MPricelistVersion m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MPricelistVersion.findByUpdated", query = "SELECT m FROM MPricelistVersion m WHERE m.updated = :updated"),
    @NamedQuery(name = "MPricelistVersion.findByUpdatedby", query = "SELECT m FROM MPricelistVersion m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MPricelistVersion.findByName", query = "SELECT m FROM MPricelistVersion m WHERE m.name = :name"),
    @NamedQuery(name = "MPricelistVersion.findByDescription", query = "SELECT m FROM MPricelistVersion m WHERE m.description = :description"),
    @NamedQuery(name = "MPricelistVersion.findByValidfrom", query = "SELECT m FROM MPricelistVersion m WHERE m.validfrom = :validfrom"),
    @NamedQuery(name = "MPricelistVersion.findByProccreate", query = "SELECT m FROM MPricelistVersion m WHERE m.proccreate = :proccreate"),
    @NamedQuery(name = "MPricelistVersion.findByMPricelistVersionGenerate", query = "SELECT m FROM MPricelistVersion m WHERE m.mPricelistVersionGenerate = :mPricelistVersionGenerate")})
public class MPricelistVersion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_pricelist_version_id")
    private String mPricelistVersionId;
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
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Column(name = "proccreate")
    private Character proccreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_pricelist_version_generate")
    private Character mPricelistVersionGenerate;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistVersionId")
    private List<CProjectVendor> cProjectVendorList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_discountschema_id", referencedColumnName = "m_discountschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MDiscountschema mDiscountschemaId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MPricelist mPricelistId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistVersionBaseId")
    private List<MPricelistVersion> mPricelistVersionList;
    @JoinColumn(name = "m_pricelist_version_base_id", referencedColumnName = "m_pricelist_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelistVersion mPricelistVersionBaseId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mPricelistVersionId")
    private List<MProductprice> mProductpriceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPricelistVersionId")
    private List<CProject> cProjectList;

    public MPricelistVersion() {
    }

    public MPricelistVersion(String mPricelistVersionId) {
        this.mPricelistVersionId = mPricelistVersionId;
    }

    public MPricelistVersion(String mPricelistVersionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date validfrom, Character mPricelistVersionGenerate) {
        this.mPricelistVersionId = mPricelistVersionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.validfrom = validfrom;
        this.mPricelistVersionGenerate = mPricelistVersionGenerate;
    }

    public String getMPricelistVersionId() {
        return mPricelistVersionId;
    }

    public void setMPricelistVersionId(String mPricelistVersionId) {
        this.mPricelistVersionId = mPricelistVersionId;
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

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Character getProccreate() {
        return proccreate;
    }

    public void setProccreate(Character proccreate) {
        this.proccreate = proccreate;
    }

    public Character getMPricelistVersionGenerate() {
        return mPricelistVersionGenerate;
    }

    public void setMPricelistVersionGenerate(Character mPricelistVersionGenerate) {
        this.mPricelistVersionGenerate = mPricelistVersionGenerate;
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

    public MDiscountschema getMDiscountschemaId() {
        return mDiscountschemaId;
    }

    public void setMDiscountschemaId(MDiscountschema mDiscountschemaId) {
        this.mDiscountschemaId = mDiscountschemaId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    @XmlTransient
    public List<MPricelistVersion> getMPricelistVersionList() {
        return mPricelistVersionList;
    }

    public void setMPricelistVersionList(List<MPricelistVersion> mPricelistVersionList) {
        this.mPricelistVersionList = mPricelistVersionList;
    }

    public MPricelistVersion getMPricelistVersionBaseId() {
        return mPricelistVersionBaseId;
    }

    public void setMPricelistVersionBaseId(MPricelistVersion mPricelistVersionBaseId) {
        this.mPricelistVersionBaseId = mPricelistVersionBaseId;
    }

    @XmlTransient
    public List<MProductprice> getMProductpriceList() {
        return mProductpriceList;
    }

    public void setMProductpriceList(List<MProductprice> mProductpriceList) {
        this.mProductpriceList = mProductpriceList;
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
        hash += (mPricelistVersionId != null ? mPricelistVersionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPricelistVersion)) {
            return false;
        }
        MPricelistVersion other = (MPricelistVersion) object;
        if ((this.mPricelistVersionId == null && other.mPricelistVersionId != null) || (this.mPricelistVersionId != null && !this.mPricelistVersionId.equals(other.mPricelistVersionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MPricelistVersion[ mPricelistVersionId=" + mPricelistVersionId + " ]";
    }
    
}
