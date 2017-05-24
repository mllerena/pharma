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
@Table(name = "ma_globaluse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaGlobaluse.findAll", query = "SELECT m FROM MaGlobaluse m"),
    @NamedQuery(name = "MaGlobaluse.findByMaGlobaluseId", query = "SELECT m FROM MaGlobaluse m WHERE m.maGlobaluseId = :maGlobaluseId"),
    @NamedQuery(name = "MaGlobaluse.findByIsactive", query = "SELECT m FROM MaGlobaluse m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaGlobaluse.findByCreated", query = "SELECT m FROM MaGlobaluse m WHERE m.created = :created"),
    @NamedQuery(name = "MaGlobaluse.findByCreatedby", query = "SELECT m FROM MaGlobaluse m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaGlobaluse.findByUpdated", query = "SELECT m FROM MaGlobaluse m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaGlobaluse.findByUpdatedby", query = "SELECT m FROM MaGlobaluse m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaGlobaluse.findByMovementqty", query = "SELECT m FROM MaGlobaluse m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MaGlobaluse.findByQuantityorder", query = "SELECT m FROM MaGlobaluse m WHERE m.quantityorder = :quantityorder")})
public class MaGlobaluse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_globaluse_id")
    private String maGlobaluseId;
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
    @Column(name = "movementqty")
    private BigInteger movementqty;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "m_production_id", referencedColumnName = "m_production_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduction mProductionId;

    public MaGlobaluse() {
    }

    public MaGlobaluse(String maGlobaluseId) {
        this.maGlobaluseId = maGlobaluseId;
    }

    public MaGlobaluse(String maGlobaluseId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger movementqty) {
        this.maGlobaluseId = maGlobaluseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.movementqty = movementqty;
    }

    public String getMaGlobaluseId() {
        return maGlobaluseId;
    }

    public void setMaGlobaluseId(String maGlobaluseId) {
        this.maGlobaluseId = maGlobaluseId;
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

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
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

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MProductUom getMProductUomId() {
        return mProductUomId;
    }

    public void setMProductUomId(MProductUom mProductUomId) {
        this.mProductUomId = mProductUomId;
    }

    public MProduction getMProductionId() {
        return mProductionId;
    }

    public void setMProductionId(MProduction mProductionId) {
        this.mProductionId = mProductionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGlobaluseId != null ? maGlobaluseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaGlobaluse)) {
            return false;
        }
        MaGlobaluse other = (MaGlobaluse) object;
        if ((this.maGlobaluseId == null && other.maGlobaluseId != null) || (this.maGlobaluseId != null && !this.maGlobaluseId.equals(other.maGlobaluseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaGlobaluse[ maGlobaluseId=" + maGlobaluseId + " ]";
    }
    
}
