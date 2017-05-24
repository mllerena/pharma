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
@Table(name = "m_rappel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRappel.findAll", query = "SELECT m FROM MRappel m"),
    @NamedQuery(name = "MRappel.findByMRappelId", query = "SELECT m FROM MRappel m WHERE m.mRappelId = :mRappelId"),
    @NamedQuery(name = "MRappel.findByIsactive", query = "SELECT m FROM MRappel m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRappel.findByCreated", query = "SELECT m FROM MRappel m WHERE m.created = :created"),
    @NamedQuery(name = "MRappel.findByCreatedby", query = "SELECT m FROM MRappel m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRappel.findByUpdated", query = "SELECT m FROM MRappel m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRappel.findByUpdatedby", query = "SELECT m FROM MRappel m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRappel.findByName", query = "SELECT m FROM MRappel m WHERE m.name = :name"),
    @NamedQuery(name = "MRappel.findByDescription", query = "SELECT m FROM MRappel m WHERE m.description = :description"),
    @NamedQuery(name = "MRappel.findByIncludeProduct", query = "SELECT m FROM MRappel m WHERE m.includeProduct = :includeProduct"),
    @NamedQuery(name = "MRappel.findByIncludeProductCategory", query = "SELECT m FROM MRappel m WHERE m.includeProductCategory = :includeProductCategory"),
    @NamedQuery(name = "MRappel.findByScaled", query = "SELECT m FROM MRappel m WHERE m.scaled = :scaled")})
public class MRappel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_rappel_id")
    private String mRappelId;
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
    @Size(max = 60)
    @Column(name = "include_product")
    private String includeProduct;
    @Size(max = 60)
    @Column(name = "include_product_category")
    private String includeProductCategory;
    @Column(name = "scaled")
    private Character scaled;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRappelId")
    private List<MRappelProductcategory> mRappelProductcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRappelId")
    private List<MRappelProduct> mRappelProductList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRappelId")
    private List<MRappelScale> mRappelScaleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRappelId")
    private List<MRappelBpartner> mRappelBpartnerList;

    public MRappel() {
    }

    public MRappel(String mRappelId) {
        this.mRappelId = mRappelId;
    }

    public MRappel(String mRappelId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.mRappelId = mRappelId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMRappelId() {
        return mRappelId;
    }

    public void setMRappelId(String mRappelId) {
        this.mRappelId = mRappelId;
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

    public String getIncludeProduct() {
        return includeProduct;
    }

    public void setIncludeProduct(String includeProduct) {
        this.includeProduct = includeProduct;
    }

    public String getIncludeProductCategory() {
        return includeProductCategory;
    }

    public void setIncludeProductCategory(String includeProductCategory) {
        this.includeProductCategory = includeProductCategory;
    }

    public Character getScaled() {
        return scaled;
    }

    public void setScaled(Character scaled) {
        this.scaled = scaled;
    }

    @XmlTransient
    public List<MRappelProductcategory> getMRappelProductcategoryList() {
        return mRappelProductcategoryList;
    }

    public void setMRappelProductcategoryList(List<MRappelProductcategory> mRappelProductcategoryList) {
        this.mRappelProductcategoryList = mRappelProductcategoryList;
    }

    @XmlTransient
    public List<MRappelProduct> getMRappelProductList() {
        return mRappelProductList;
    }

    public void setMRappelProductList(List<MRappelProduct> mRappelProductList) {
        this.mRappelProductList = mRappelProductList;
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
    public List<MRappelScale> getMRappelScaleList() {
        return mRappelScaleList;
    }

    public void setMRappelScaleList(List<MRappelScale> mRappelScaleList) {
        this.mRappelScaleList = mRappelScaleList;
    }

    @XmlTransient
    public List<MRappelBpartner> getMRappelBpartnerList() {
        return mRappelBpartnerList;
    }

    public void setMRappelBpartnerList(List<MRappelBpartner> mRappelBpartnerList) {
        this.mRappelBpartnerList = mRappelBpartnerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRappelId != null ? mRappelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRappel)) {
            return false;
        }
        MRappel other = (MRappel) object;
        if ((this.mRappelId == null && other.mRappelId != null) || (this.mRappelId != null && !this.mRappelId.equals(other.mRappelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRappel[ mRappelId=" + mRappelId + " ]";
    }
    
}
