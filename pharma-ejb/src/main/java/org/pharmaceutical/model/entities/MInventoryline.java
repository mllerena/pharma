/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "m_inventoryline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInventoryline.findAll", query = "SELECT m FROM MInventoryline m"),
    @NamedQuery(name = "MInventoryline.findByMInventorylineId", query = "SELECT m FROM MInventoryline m WHERE m.mInventorylineId = :mInventorylineId"),
    @NamedQuery(name = "MInventoryline.findByIsactive", query = "SELECT m FROM MInventoryline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MInventoryline.findByCreated", query = "SELECT m FROM MInventoryline m WHERE m.created = :created"),
    @NamedQuery(name = "MInventoryline.findByCreatedby", query = "SELECT m FROM MInventoryline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MInventoryline.findByUpdated", query = "SELECT m FROM MInventoryline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MInventoryline.findByUpdatedby", query = "SELECT m FROM MInventoryline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MInventoryline.findByLine", query = "SELECT m FROM MInventoryline m WHERE m.line = :line"),
    @NamedQuery(name = "MInventoryline.findByQtybook", query = "SELECT m FROM MInventoryline m WHERE m.qtybook = :qtybook"),
    @NamedQuery(name = "MInventoryline.findByQtycount", query = "SELECT m FROM MInventoryline m WHERE m.qtycount = :qtycount"),
    @NamedQuery(name = "MInventoryline.findByDescription", query = "SELECT m FROM MInventoryline m WHERE m.description = :description"),
    @NamedQuery(name = "MInventoryline.findByQuantityorder", query = "SELECT m FROM MInventoryline m WHERE m.quantityorder = :quantityorder"),
    @NamedQuery(name = "MInventoryline.findByQuantityorderbook", query = "SELECT m FROM MInventoryline m WHERE m.quantityorderbook = :quantityorderbook")})
public class MInventoryline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_inventoryline_id")
    private String mInventorylineId;
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
    @Column(name = "line")
    private Long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtybook")
    private BigInteger qtybook;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtycount")
    private BigInteger qtycount;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @Column(name = "quantityorderbook")
    private BigInteger quantityorderbook;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInventorylineId")
    private List<IInventory> iInventoryList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_inventory_id", referencedColumnName = "m_inventory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MInventory mInventoryId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInventorylineId")
    private List<MTransaction> mTransactionList;

    public MInventoryline() {
    }

    public MInventoryline(String mInventorylineId) {
        this.mInventorylineId = mInventorylineId;
    }

    public MInventoryline(String mInventorylineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger qtybook, BigInteger qtycount) {
        this.mInventorylineId = mInventorylineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.qtybook = qtybook;
        this.qtycount = qtycount;
    }

    public String getMInventorylineId() {
        return mInventorylineId;
    }

    public void setMInventorylineId(String mInventorylineId) {
        this.mInventorylineId = mInventorylineId;
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

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    public BigInteger getQuantityorderbook() {
        return quantityorderbook;
    }

    public void setQuantityorderbook(BigInteger quantityorderbook) {
        this.quantityorderbook = quantityorderbook;
    }

    @XmlTransient
    public List<IInventory> getIInventoryList() {
        return iInventoryList;
    }

    public void setIInventoryList(List<IInventory> iInventoryList) {
        this.iInventoryList = iInventoryList;
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

    public MInventory getMInventoryId() {
        return mInventoryId;
    }

    public void setMInventoryId(MInventory mInventoryId) {
        this.mInventoryId = mInventoryId;
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

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mInventorylineId != null ? mInventorylineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInventoryline)) {
            return false;
        }
        MInventoryline other = (MInventoryline) object;
        if ((this.mInventorylineId == null && other.mInventorylineId != null) || (this.mInventorylineId != null && !this.mInventorylineId.equals(other.mInventorylineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MInventoryline[ mInventorylineId=" + mInventorylineId + " ]";
    }
    
}
