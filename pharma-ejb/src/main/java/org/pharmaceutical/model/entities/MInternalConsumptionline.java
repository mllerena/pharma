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
@Table(name = "m_internal_consumptionline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInternalConsumptionline.findAll", query = "SELECT m FROM MInternalConsumptionline m"),
    @NamedQuery(name = "MInternalConsumptionline.findByMInternalConsumptionlineId", query = "SELECT m FROM MInternalConsumptionline m WHERE m.mInternalConsumptionlineId = :mInternalConsumptionlineId"),
    @NamedQuery(name = "MInternalConsumptionline.findByIsactive", query = "SELECT m FROM MInternalConsumptionline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MInternalConsumptionline.findByCreated", query = "SELECT m FROM MInternalConsumptionline m WHERE m.created = :created"),
    @NamedQuery(name = "MInternalConsumptionline.findByCreatedby", query = "SELECT m FROM MInternalConsumptionline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MInternalConsumptionline.findByUpdated", query = "SELECT m FROM MInternalConsumptionline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MInternalConsumptionline.findByUpdatedby", query = "SELECT m FROM MInternalConsumptionline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MInternalConsumptionline.findByLine", query = "SELECT m FROM MInternalConsumptionline m WHERE m.line = :line"),
    @NamedQuery(name = "MInternalConsumptionline.findByMovementqty", query = "SELECT m FROM MInternalConsumptionline m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MInternalConsumptionline.findByDescription", query = "SELECT m FROM MInternalConsumptionline m WHERE m.description = :description"),
    @NamedQuery(name = "MInternalConsumptionline.findByQuantityorder", query = "SELECT m FROM MInternalConsumptionline m WHERE m.quantityorder = :quantityorder")})
public class MInternalConsumptionline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_internal_consumptionline_id")
    private String mInternalConsumptionlineId;
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
    @Column(name = "movementqty")
    private BigInteger movementqty;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
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
    @JoinColumn(name = "m_internal_consumption_id", referencedColumnName = "m_internal_consumption_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MInternalConsumption mInternalConsumptionId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInternalConsumptionlineId")
    private List<MTransaction> mTransactionList;

    public MInternalConsumptionline() {
    }

    public MInternalConsumptionline(String mInternalConsumptionlineId) {
        this.mInternalConsumptionlineId = mInternalConsumptionlineId;
    }

    public MInternalConsumptionline(String mInternalConsumptionlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger movementqty) {
        this.mInternalConsumptionlineId = mInternalConsumptionlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.movementqty = movementqty;
    }

    public String getMInternalConsumptionlineId() {
        return mInternalConsumptionlineId;
    }

    public void setMInternalConsumptionlineId(String mInternalConsumptionlineId) {
        this.mInternalConsumptionlineId = mInternalConsumptionlineId;
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

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
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

    public MInternalConsumption getMInternalConsumptionId() {
        return mInternalConsumptionId;
    }

    public void setMInternalConsumptionId(MInternalConsumption mInternalConsumptionId) {
        this.mInternalConsumptionId = mInternalConsumptionId;
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
        hash += (mInternalConsumptionlineId != null ? mInternalConsumptionlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInternalConsumptionline)) {
            return false;
        }
        MInternalConsumptionline other = (MInternalConsumptionline) object;
        if ((this.mInternalConsumptionlineId == null && other.mInternalConsumptionlineId != null) || (this.mInternalConsumptionlineId != null && !this.mInternalConsumptionlineId.equals(other.mInternalConsumptionlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MInternalConsumptionline[ mInternalConsumptionlineId=" + mInternalConsumptionlineId + " ]";
    }
    
}
