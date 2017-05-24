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
@Table(name = "m_rappel_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRappelProduct.findAll", query = "SELECT m FROM MRappelProduct m"),
    @NamedQuery(name = "MRappelProduct.findByMRappelProductId", query = "SELECT m FROM MRappelProduct m WHERE m.mRappelProductId = :mRappelProductId"),
    @NamedQuery(name = "MRappelProduct.findByIsactive", query = "SELECT m FROM MRappelProduct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRappelProduct.findByCreated", query = "SELECT m FROM MRappelProduct m WHERE m.created = :created"),
    @NamedQuery(name = "MRappelProduct.findByCreatedby", query = "SELECT m FROM MRappelProduct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRappelProduct.findByUpdated", query = "SELECT m FROM MRappelProduct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRappelProduct.findByUpdatedby", query = "SELECT m FROM MRappelProduct m WHERE m.updatedby = :updatedby")})
public class MRappelProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_rappel_product_id")
    private String mRappelProductId;
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
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_rappel_id", referencedColumnName = "m_rappel_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MRappel mRappelId;

    public MRappelProduct() {
    }

    public MRappelProduct(String mRappelProductId) {
        this.mRappelProductId = mRappelProductId;
    }

    public MRappelProduct(String mRappelProductId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mRappelProductId = mRappelProductId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMRappelProductId() {
        return mRappelProductId;
    }

    public void setMRappelProductId(String mRappelProductId) {
        this.mRappelProductId = mRappelProductId;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MRappel getMRappelId() {
        return mRappelId;
    }

    public void setMRappelId(MRappel mRappelId) {
        this.mRappelId = mRappelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRappelProductId != null ? mRappelProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRappelProduct)) {
            return false;
        }
        MRappelProduct other = (MRappelProduct) object;
        if ((this.mRappelProductId == null && other.mRappelProductId != null) || (this.mRappelProductId != null && !this.mRappelProductId.equals(other.mRappelProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRappelProduct[ mRappelProductId=" + mRappelProductId + " ]";
    }
    
}
