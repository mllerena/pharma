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
@Table(name = "i_inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IInventory.findAll", query = "SELECT i FROM IInventory i"),
    @NamedQuery(name = "IInventory.findByIInventoryId", query = "SELECT i FROM IInventory i WHERE i.iInventoryId = :iInventoryId"),
    @NamedQuery(name = "IInventory.findByIsactive", query = "SELECT i FROM IInventory i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IInventory.findByCreated", query = "SELECT i FROM IInventory i WHERE i.created = :created"),
    @NamedQuery(name = "IInventory.findByCreatedby", query = "SELECT i FROM IInventory i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IInventory.findByUpdated", query = "SELECT i FROM IInventory i WHERE i.updated = :updated"),
    @NamedQuery(name = "IInventory.findByUpdatedby", query = "SELECT i FROM IInventory i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IInventory.findByProcessing", query = "SELECT i FROM IInventory i WHERE i.processing = :processing"),
    @NamedQuery(name = "IInventory.findByProcessed", query = "SELECT i FROM IInventory i WHERE i.processed = :processed"),
    @NamedQuery(name = "IInventory.findByDescription", query = "SELECT i FROM IInventory i WHERE i.description = :description"),
    @NamedQuery(name = "IInventory.findByLot", query = "SELECT i FROM IInventory i WHERE i.lot = :lot"),
    @NamedQuery(name = "IInventory.findByQtybook", query = "SELECT i FROM IInventory i WHERE i.qtybook = :qtybook"),
    @NamedQuery(name = "IInventory.findByQtycount", query = "SELECT i FROM IInventory i WHERE i.qtycount = :qtycount"),
    @NamedQuery(name = "IInventory.findBySerno", query = "SELECT i FROM IInventory i WHERE i.serno = :serno"),
    @NamedQuery(name = "IInventory.findByUpc", query = "SELECT i FROM IInventory i WHERE i.upc = :upc"),
    @NamedQuery(name = "IInventory.findByValue", query = "SELECT i FROM IInventory i WHERE i.value = :value"),
    @NamedQuery(name = "IInventory.findByWarehousevalue", query = "SELECT i FROM IInventory i WHERE i.warehousevalue = :warehousevalue"),
    @NamedQuery(name = "IInventory.findByX", query = "SELECT i FROM IInventory i WHERE i.x = :x"),
    @NamedQuery(name = "IInventory.findByY", query = "SELECT i FROM IInventory i WHERE i.y = :y"),
    @NamedQuery(name = "IInventory.findByZ", query = "SELECT i FROM IInventory i WHERE i.z = :z"),
    @NamedQuery(name = "IInventory.findByLocatorvalue", query = "SELECT i FROM IInventory i WHERE i.locatorvalue = :locatorvalue"),
    @NamedQuery(name = "IInventory.findByIErrormsg", query = "SELECT i FROM IInventory i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IInventory.findByIIsimported", query = "SELECT i FROM IInventory i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IInventory.findByMovementdate", query = "SELECT i FROM IInventory i WHERE i.movementdate = :movementdate")})
public class IInventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_inventory_id")
    private String iInventoryId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 20)
    @Column(name = "lot")
    private String lot;
    @Column(name = "qtybook")
    private BigInteger qtybook;
    @Column(name = "qtycount")
    private BigInteger qtycount;
    @Size(max = 20)
    @Column(name = "serno")
    private String serno;
    @Size(max = 30)
    @Column(name = "upc")
    private String upc;
    @Size(max = 40)
    @Column(name = "value")
    private String value;
    @Size(max = 40)
    @Column(name = "warehousevalue")
    private String warehousevalue;
    @Size(max = 60)
    @Column(name = "x")
    private String x;
    @Size(max = 60)
    @Column(name = "y")
    private String y;
    @Size(max = 60)
    @Column(name = "z")
    private String z;
    @Size(max = 40)
    @Column(name = "locatorvalue")
    private String locatorvalue;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_inventory_id", referencedColumnName = "m_inventory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInventory mInventoryId;
    @JoinColumn(name = "m_inventoryline_id", referencedColumnName = "m_inventoryline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInventoryline mInventorylineId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse mWarehouseId;

    public IInventory() {
    }

    public IInventory(String iInventoryId) {
        this.iInventoryId = iInventoryId;
    }

    public String getIInventoryId() {
        return iInventoryId;
    }

    public void setIInventoryId(String iInventoryId) {
        this.iInventoryId = iInventoryId;
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

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public BigInteger getQtybook() {
        return qtybook;
    }

    public void setQtybook(BigInteger qtybook) {
        this.qtybook = qtybook;
    }

    public BigInteger getQtycount() {
        return qtycount;
    }

    public void setQtycount(BigInteger qtycount) {
        this.qtycount = qtycount;
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWarehousevalue() {
        return warehousevalue;
    }

    public void setWarehousevalue(String warehousevalue) {
        this.warehousevalue = warehousevalue;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public String getLocatorvalue() {
        return locatorvalue;
    }

    public void setLocatorvalue(String locatorvalue) {
        this.locatorvalue = locatorvalue;
    }

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
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

    public MInventory getMInventoryId() {
        return mInventoryId;
    }

    public void setMInventoryId(MInventory mInventoryId) {
        this.mInventoryId = mInventoryId;
    }

    public MInventoryline getMInventorylineId() {
        return mInventorylineId;
    }

    public void setMInventorylineId(MInventoryline mInventorylineId) {
        this.mInventorylineId = mInventorylineId;
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

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iInventoryId != null ? iInventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IInventory)) {
            return false;
        }
        IInventory other = (IInventory) object;
        if ((this.iInventoryId == null && other.iInventoryId != null) || (this.iInventoryId != null && !this.iInventoryId.equals(other.iInventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IInventory[ iInventoryId=" + iInventoryId + " ]";
    }
    
}
