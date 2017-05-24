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
@Table(name = "m_storage_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MStorageDetail.findAll", query = "SELECT m FROM MStorageDetail m"),
    @NamedQuery(name = "MStorageDetail.findByQtyonhand", query = "SELECT m FROM MStorageDetail m WHERE m.qtyonhand = :qtyonhand"),
    @NamedQuery(name = "MStorageDetail.findByQtyorderonhand", query = "SELECT m FROM MStorageDetail m WHERE m.qtyorderonhand = :qtyorderonhand"),
    @NamedQuery(name = "MStorageDetail.findByDatelastinventory", query = "SELECT m FROM MStorageDetail m WHERE m.datelastinventory = :datelastinventory"),
    @NamedQuery(name = "MStorageDetail.findByPreqtyonhand", query = "SELECT m FROM MStorageDetail m WHERE m.preqtyonhand = :preqtyonhand"),
    @NamedQuery(name = "MStorageDetail.findByPreqtyorderonhand", query = "SELECT m FROM MStorageDetail m WHERE m.preqtyorderonhand = :preqtyorderonhand"),
    @NamedQuery(name = "MStorageDetail.findByIsactive", query = "SELECT m FROM MStorageDetail m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MStorageDetail.findByCreated", query = "SELECT m FROM MStorageDetail m WHERE m.created = :created"),
    @NamedQuery(name = "MStorageDetail.findByCreatedby", query = "SELECT m FROM MStorageDetail m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MStorageDetail.findByUpdated", query = "SELECT m FROM MStorageDetail m WHERE m.updated = :updated"),
    @NamedQuery(name = "MStorageDetail.findByUpdatedby", query = "SELECT m FROM MStorageDetail m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MStorageDetail.findByMStorageDetailId", query = "SELECT m FROM MStorageDetail m WHERE m.mStorageDetailId = :mStorageDetailId")})
public class MStorageDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyonhand")
    private BigInteger qtyonhand;
    @Column(name = "qtyorderonhand")
    private BigInteger qtyorderonhand;
    @Column(name = "datelastinventory")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastinventory;
    @Column(name = "preqtyonhand")
    private BigInteger preqtyonhand;
    @Column(name = "preqtyorderonhand")
    private BigInteger preqtyorderonhand;
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
    @Column(name = "m_storage_detail_id")
    private String mStorageDetailId;
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

    public MStorageDetail() {
    }

    public MStorageDetail(String mStorageDetailId) {
        this.mStorageDetailId = mStorageDetailId;
    }

    public MStorageDetail(String mStorageDetailId, BigInteger qtyonhand, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mStorageDetailId = mStorageDetailId;
        this.qtyonhand = qtyonhand;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public BigInteger getQtyonhand() {
        return qtyonhand;
    }

    public void setQtyonhand(BigInteger qtyonhand) {
        this.qtyonhand = qtyonhand;
    }

    public BigInteger getQtyorderonhand() {
        return qtyorderonhand;
    }

    public void setQtyorderonhand(BigInteger qtyorderonhand) {
        this.qtyorderonhand = qtyorderonhand;
    }

    public Date getDatelastinventory() {
        return datelastinventory;
    }

    public void setDatelastinventory(Date datelastinventory) {
        this.datelastinventory = datelastinventory;
    }

    public BigInteger getPreqtyonhand() {
        return preqtyonhand;
    }

    public void setPreqtyonhand(BigInteger preqtyonhand) {
        this.preqtyonhand = preqtyonhand;
    }

    public BigInteger getPreqtyorderonhand() {
        return preqtyorderonhand;
    }

    public void setPreqtyorderonhand(BigInteger preqtyorderonhand) {
        this.preqtyorderonhand = preqtyorderonhand;
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

    public String getMStorageDetailId() {
        return mStorageDetailId;
    }

    public void setMStorageDetailId(String mStorageDetailId) {
        this.mStorageDetailId = mStorageDetailId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mStorageDetailId != null ? mStorageDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MStorageDetail)) {
            return false;
        }
        MStorageDetail other = (MStorageDetail) object;
        if ((this.mStorageDetailId == null && other.mStorageDetailId != null) || (this.mStorageDetailId != null && !this.mStorageDetailId.equals(other.mStorageDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MStorageDetail[ mStorageDetailId=" + mStorageDetailId + " ]";
    }
    
}
