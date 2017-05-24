/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "c_externalpos_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CExternalposCategory.findAll", query = "SELECT c FROM CExternalposCategory c"),
    @NamedQuery(name = "CExternalposCategory.findByCExternalposCategoryId", query = "SELECT c FROM CExternalposCategory c WHERE c.cExternalposCategoryId = :cExternalposCategoryId"),
    @NamedQuery(name = "CExternalposCategory.findByIsactive", query = "SELECT c FROM CExternalposCategory c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CExternalposCategory.findByCreated", query = "SELECT c FROM CExternalposCategory c WHERE c.created = :created"),
    @NamedQuery(name = "CExternalposCategory.findByCreatedby", query = "SELECT c FROM CExternalposCategory c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CExternalposCategory.findByUpdated", query = "SELECT c FROM CExternalposCategory c WHERE c.updated = :updated"),
    @NamedQuery(name = "CExternalposCategory.findByUpdatedby", query = "SELECT c FROM CExternalposCategory c WHERE c.updatedby = :updatedby")})
public class CExternalposCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_externalpos_category_id")
    private String cExternalposCategoryId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_externalpos_id", referencedColumnName = "c_externalpos_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CExternalpos cExternalposId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;

    public CExternalposCategory() {
    }

    public CExternalposCategory(String cExternalposCategoryId) {
        this.cExternalposCategoryId = cExternalposCategoryId;
    }

    public CExternalposCategory(String cExternalposCategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cExternalposCategoryId = cExternalposCategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCExternalposCategoryId() {
        return cExternalposCategoryId;
    }

    public void setCExternalposCategoryId(String cExternalposCategoryId) {
        this.cExternalposCategoryId = cExternalposCategoryId;
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

    public CExternalpos getCExternalposId() {
        return cExternalposId;
    }

    public void setCExternalposId(CExternalpos cExternalposId) {
        this.cExternalposId = cExternalposId;
    }

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cExternalposCategoryId != null ? cExternalposCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CExternalposCategory)) {
            return false;
        }
        CExternalposCategory other = (CExternalposCategory) object;
        if ((this.cExternalposCategoryId == null && other.cExternalposCategoryId != null) || (this.cExternalposCategoryId != null && !this.cExternalposCategoryId.equals(other.cExternalposCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CExternalposCategory[ cExternalposCategoryId=" + cExternalposCategoryId + " ]";
    }
    
}
