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
@Table(name = "m_offer_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MOfferProduct.findAll", query = "SELECT m FROM MOfferProduct m"),
    @NamedQuery(name = "MOfferProduct.findByMOfferProductId", query = "SELECT m FROM MOfferProduct m WHERE m.mOfferProductId = :mOfferProductId"),
    @NamedQuery(name = "MOfferProduct.findByIsactive", query = "SELECT m FROM MOfferProduct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MOfferProduct.findByCreated", query = "SELECT m FROM MOfferProduct m WHERE m.created = :created"),
    @NamedQuery(name = "MOfferProduct.findByCreatedby", query = "SELECT m FROM MOfferProduct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MOfferProduct.findByUpdated", query = "SELECT m FROM MOfferProduct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MOfferProduct.findByUpdatedby", query = "SELECT m FROM MOfferProduct m WHERE m.updatedby = :updatedby")})
public class MOfferProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_offer_product_id")
    private String mOfferProductId;
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
    @JoinColumn(name = "m_offer_id", referencedColumnName = "m_offer_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MOffer mOfferId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MOfferProduct() {
    }

    public MOfferProduct(String mOfferProductId) {
        this.mOfferProductId = mOfferProductId;
    }

    public MOfferProduct(String mOfferProductId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mOfferProductId = mOfferProductId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMOfferProductId() {
        return mOfferProductId;
    }

    public void setMOfferProductId(String mOfferProductId) {
        this.mOfferProductId = mOfferProductId;
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

    public MOffer getMOfferId() {
        return mOfferId;
    }

    public void setMOfferId(MOffer mOfferId) {
        this.mOfferId = mOfferId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mOfferProductId != null ? mOfferProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MOfferProduct)) {
            return false;
        }
        MOfferProduct other = (MOfferProduct) object;
        if ((this.mOfferProductId == null && other.mOfferProductId != null) || (this.mOfferProductId != null && !this.mOfferProductId.equals(other.mOfferProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MOfferProduct[ mOfferProductId=" + mOfferProductId + " ]";
    }
    
}
