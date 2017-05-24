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
@Table(name = "m_productprice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductprice.findAll", query = "SELECT m FROM MProductprice m"),
    @NamedQuery(name = "MProductprice.findByMProductpriceId", query = "SELECT m FROM MProductprice m WHERE m.mProductpriceId = :mProductpriceId"),
    @NamedQuery(name = "MProductprice.findByIsactive", query = "SELECT m FROM MProductprice m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductprice.findByCreated", query = "SELECT m FROM MProductprice m WHERE m.created = :created"),
    @NamedQuery(name = "MProductprice.findByCreatedby", query = "SELECT m FROM MProductprice m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductprice.findByUpdated", query = "SELECT m FROM MProductprice m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductprice.findByUpdatedby", query = "SELECT m FROM MProductprice m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductprice.findByPricelist", query = "SELECT m FROM MProductprice m WHERE m.pricelist = :pricelist"),
    @NamedQuery(name = "MProductprice.findByPricestd", query = "SELECT m FROM MProductprice m WHERE m.pricestd = :pricestd"),
    @NamedQuery(name = "MProductprice.findByPricelimit", query = "SELECT m FROM MProductprice m WHERE m.pricelimit = :pricelimit")})
public class MProductprice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_productprice_id")
    private String mProductpriceId;
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
    @Column(name = "pricelist")
    private BigInteger pricelist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricestd")
    private BigInteger pricestd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricelimit")
    private BigInteger pricelimit;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_pricelist_version_id", referencedColumnName = "m_pricelist_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MPricelistVersion mPricelistVersionId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MProductprice() {
    }

    public MProductprice(String mProductpriceId) {
        this.mProductpriceId = mProductpriceId;
    }

    public MProductprice(String mProductpriceId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger pricelist, BigInteger pricestd, BigInteger pricelimit) {
        this.mProductpriceId = mProductpriceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.pricelist = pricelist;
        this.pricestd = pricestd;
        this.pricelimit = pricelimit;
    }

    public String getMProductpriceId() {
        return mProductpriceId;
    }

    public void setMProductpriceId(String mProductpriceId) {
        this.mProductpriceId = mProductpriceId;
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

    public BigInteger getPricelist() {
        return pricelist;
    }

    public void setPricelist(BigInteger pricelist) {
        this.pricelist = pricelist;
    }

    public BigInteger getPricestd() {
        return pricestd;
    }

    public void setPricestd(BigInteger pricestd) {
        this.pricestd = pricestd;
    }

    public BigInteger getPricelimit() {
        return pricelimit;
    }

    public void setPricelimit(BigInteger pricelimit) {
        this.pricelimit = pricelimit;
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

    public MPricelistVersion getMPricelistVersionId() {
        return mPricelistVersionId;
    }

    public void setMPricelistVersionId(MPricelistVersion mPricelistVersionId) {
        this.mPricelistVersionId = mPricelistVersionId;
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
        hash += (mProductpriceId != null ? mProductpriceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductprice)) {
            return false;
        }
        MProductprice other = (MProductprice) object;
        if ((this.mProductpriceId == null && other.mProductpriceId != null) || (this.mProductpriceId != null && !this.mProductpriceId.equals(other.mProductpriceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductprice[ mProductpriceId=" + mProductpriceId + " ]";
    }
    
}
