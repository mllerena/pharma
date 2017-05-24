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
@Table(name = "m_offer_prod_cat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MOfferProdCat.findAll", query = "SELECT m FROM MOfferProdCat m"),
    @NamedQuery(name = "MOfferProdCat.findByMOfferProdCatId", query = "SELECT m FROM MOfferProdCat m WHERE m.mOfferProdCatId = :mOfferProdCatId"),
    @NamedQuery(name = "MOfferProdCat.findByIsactive", query = "SELECT m FROM MOfferProdCat m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MOfferProdCat.findByCreated", query = "SELECT m FROM MOfferProdCat m WHERE m.created = :created"),
    @NamedQuery(name = "MOfferProdCat.findByCreatedby", query = "SELECT m FROM MOfferProdCat m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MOfferProdCat.findByUpdated", query = "SELECT m FROM MOfferProdCat m WHERE m.updated = :updated"),
    @NamedQuery(name = "MOfferProdCat.findByUpdatedby", query = "SELECT m FROM MOfferProdCat m WHERE m.updatedby = :updatedby")})
public class MOfferProdCat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_offer_prod_cat_id")
    private String mOfferProdCatId;
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
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductCategory mProductCategoryId;

    public MOfferProdCat() {
    }

    public MOfferProdCat(String mOfferProdCatId) {
        this.mOfferProdCatId = mOfferProdCatId;
    }

    public MOfferProdCat(String mOfferProdCatId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mOfferProdCatId = mOfferProdCatId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMOfferProdCatId() {
        return mOfferProdCatId;
    }

    public void setMOfferProdCatId(String mOfferProdCatId) {
        this.mOfferProdCatId = mOfferProdCatId;
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

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mOfferProdCatId != null ? mOfferProdCatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MOfferProdCat)) {
            return false;
        }
        MOfferProdCat other = (MOfferProdCat) object;
        if ((this.mOfferProdCatId == null && other.mOfferProdCatId != null) || (this.mOfferProdCatId != null && !this.mOfferProdCatId.equals(other.mOfferProdCatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MOfferProdCat[ mOfferProdCatId=" + mOfferProdCatId + " ]";
    }
    
}
