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
@Table(name = "m_storage_pending")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MStoragePending.findAll", query = "SELECT m FROM MStoragePending m"),
    @NamedQuery(name = "MStoragePending.findByQtyreserved", query = "SELECT m FROM MStoragePending m WHERE m.qtyreserved = :qtyreserved"),
    @NamedQuery(name = "MStoragePending.findByQtyorderreserved", query = "SELECT m FROM MStoragePending m WHERE m.qtyorderreserved = :qtyorderreserved"),
    @NamedQuery(name = "MStoragePending.findByQtyordered", query = "SELECT m FROM MStoragePending m WHERE m.qtyordered = :qtyordered"),
    @NamedQuery(name = "MStoragePending.findByQtyorderordered", query = "SELECT m FROM MStoragePending m WHERE m.qtyorderordered = :qtyorderordered"),
    @NamedQuery(name = "MStoragePending.findByIsactive", query = "SELECT m FROM MStoragePending m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MStoragePending.findByCreated", query = "SELECT m FROM MStoragePending m WHERE m.created = :created"),
    @NamedQuery(name = "MStoragePending.findByCreatedby", query = "SELECT m FROM MStoragePending m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MStoragePending.findByUpdated", query = "SELECT m FROM MStoragePending m WHERE m.updated = :updated"),
    @NamedQuery(name = "MStoragePending.findByUpdatedby", query = "SELECT m FROM MStoragePending m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MStoragePending.findByMStoragePendingId", query = "SELECT m FROM MStoragePending m WHERE m.mStoragePendingId = :mStoragePendingId")})
public class MStoragePending implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyreserved")
    private BigInteger qtyreserved;
    @Column(name = "qtyorderreserved")
    private BigInteger qtyorderreserved;
    @Column(name = "qtyordered")
    private BigInteger qtyordered;
    @Column(name = "qtyorderordered")
    private BigInteger qtyorderordered;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_storage_pending_id")
    private String mStoragePendingId;
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
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;

    public MStoragePending() {
    }

    public MStoragePending(String mStoragePendingId) {
        this.mStoragePendingId = mStoragePendingId;
    }

    public MStoragePending(String mStoragePendingId, BigInteger qtyreserved, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mStoragePendingId = mStoragePendingId;
        this.qtyreserved = qtyreserved;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public BigInteger getQtyreserved() {
        return qtyreserved;
    }

    public void setQtyreserved(BigInteger qtyreserved) {
        this.qtyreserved = qtyreserved;
    }

    public BigInteger getQtyorderreserved() {
        return qtyorderreserved;
    }

    public void setQtyorderreserved(BigInteger qtyorderreserved) {
        this.qtyorderreserved = qtyorderreserved;
    }

    public BigInteger getQtyordered() {
        return qtyordered;
    }

    public void setQtyordered(BigInteger qtyordered) {
        this.qtyordered = qtyordered;
    }

    public BigInteger getQtyorderordered() {
        return qtyorderordered;
    }

    public void setQtyorderordered(BigInteger qtyorderordered) {
        this.qtyorderordered = qtyorderordered;
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

    public String getMStoragePendingId() {
        return mStoragePendingId;
    }

    public void setMStoragePendingId(String mStoragePendingId) {
        this.mStoragePendingId = mStoragePendingId;
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

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mStoragePendingId != null ? mStoragePendingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MStoragePending)) {
            return false;
        }
        MStoragePending other = (MStoragePending) object;
        if ((this.mStoragePendingId == null && other.mStoragePendingId != null) || (this.mStoragePendingId != null && !this.mStoragePendingId.equals(other.mStoragePendingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MStoragePending[ mStoragePendingId=" + mStoragePendingId + " ]";
    }
    
}
