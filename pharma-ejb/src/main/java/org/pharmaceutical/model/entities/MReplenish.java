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
@Table(name = "m_replenish")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MReplenish.findAll", query = "SELECT m FROM MReplenish m"),
    @NamedQuery(name = "MReplenish.findByMReplenishId", query = "SELECT m FROM MReplenish m WHERE m.mReplenishId = :mReplenishId"),
    @NamedQuery(name = "MReplenish.findByIsactive", query = "SELECT m FROM MReplenish m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MReplenish.findByCreated", query = "SELECT m FROM MReplenish m WHERE m.created = :created"),
    @NamedQuery(name = "MReplenish.findByCreatedby", query = "SELECT m FROM MReplenish m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MReplenish.findByUpdated", query = "SELECT m FROM MReplenish m WHERE m.updated = :updated"),
    @NamedQuery(name = "MReplenish.findByUpdatedby", query = "SELECT m FROM MReplenish m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MReplenish.findByReplenishtype", query = "SELECT m FROM MReplenish m WHERE m.replenishtype = :replenishtype"),
    @NamedQuery(name = "MReplenish.findByLevelMin", query = "SELECT m FROM MReplenish m WHERE m.levelMin = :levelMin"),
    @NamedQuery(name = "MReplenish.findByLevelMax", query = "SELECT m FROM MReplenish m WHERE m.levelMax = :levelMax")})
public class MReplenish implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_replenish_id")
    private String mReplenishId;
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
    @Column(name = "replenishtype")
    private String replenishtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level_min")
    private BigInteger levelMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level_max")
    private BigInteger levelMax;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;

    public MReplenish() {
    }

    public MReplenish(String mReplenishId) {
        this.mReplenishId = mReplenishId;
    }

    public MReplenish(String mReplenishId, Character isactive, Date created, String createdby, Date updated, String updatedby, String replenishtype, BigInteger levelMin, BigInteger levelMax) {
        this.mReplenishId = mReplenishId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.replenishtype = replenishtype;
        this.levelMin = levelMin;
        this.levelMax = levelMax;
    }

    public String getMReplenishId() {
        return mReplenishId;
    }

    public void setMReplenishId(String mReplenishId) {
        this.mReplenishId = mReplenishId;
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

    public String getReplenishtype() {
        return replenishtype;
    }

    public void setReplenishtype(String replenishtype) {
        this.replenishtype = replenishtype;
    }

    public BigInteger getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(BigInteger levelMin) {
        this.levelMin = levelMin;
    }

    public BigInteger getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(BigInteger levelMax) {
        this.levelMax = levelMax;
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

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mReplenishId != null ? mReplenishId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MReplenish)) {
            return false;
        }
        MReplenish other = (MReplenish) object;
        if ((this.mReplenishId == null && other.mReplenishId != null) || (this.mReplenishId != null && !this.mReplenishId.equals(other.mReplenishId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MReplenish[ mReplenishId=" + mReplenishId + " ]";
    }
    
}
