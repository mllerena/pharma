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
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.MovementTypeConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.MovementType;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTransaction.findAll", query = "SELECT m FROM MTransaction m"),
    @NamedQuery(name = "MTransaction.findByMTransactionId", query = "SELECT m FROM MTransaction m WHERE m.mTransactionId = :mTransactionId"),
    @NamedQuery(name = "MTransaction.findByIsactive", query = "SELECT m FROM MTransaction m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MTransaction.findByCreated", query = "SELECT m FROM MTransaction m WHERE m.created = :created"),
    @NamedQuery(name = "MTransaction.findByCreatedby", query = "SELECT m FROM MTransaction m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MTransaction.findByUpdated", query = "SELECT m FROM MTransaction m WHERE m.updated = :updated"),
    @NamedQuery(name = "MTransaction.findByUpdatedby", query = "SELECT m FROM MTransaction m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MTransaction.findByMovementtype", query = "SELECT m FROM MTransaction m WHERE m.movementtype = :movementtype"),
    @NamedQuery(name = "MTransaction.findByMovementdate", query = "SELECT m FROM MTransaction m WHERE m.movementdate = :movementdate"),
    @NamedQuery(name = "MTransaction.findByMovementqty", query = "SELECT m FROM MTransaction m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MTransaction.findByQuantityorder", query = "SELECT m FROM MTransaction m WHERE m.quantityorder = :quantityorder")})
public class MTransaction extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "m_transaction_id")
    private String mTransactionId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    
    
    @Basic(optional = false)
    @Column(name = "movementtype")
    @Convert(converter=MovementTypeConverter.class)   
    private MovementType movementtype;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementqty")
    private BigInteger movementqty;
    
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "c_projectissue_id", referencedColumnName = "c_projectissue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjectissue cProjectissueId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_inoutline_id", referencedColumnName = "m_inoutline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInoutline mInoutlineId;
    @JoinColumn(name = "m_internal_consumptionline_id", referencedColumnName = "m_internal_consumptionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInternalConsumptionline mInternalConsumptionlineId;
    @JoinColumn(name = "m_inventoryline_id", referencedColumnName = "m_inventoryline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInventoryline mInventorylineId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_movementline_id", referencedColumnName = "m_movementline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MMovementline mMovementlineId;
    @JoinColumn(name = "m_productionline_id", referencedColumnName = "m_productionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductionline mProductionlineId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;

    public MTransaction() {
    }

    public MTransaction(String mTransactionId) {
        this.mTransactionId = mTransactionId;
    }

    public String getMTransactionId() {
        return mTransactionId;
    }

    public void setMTransactionId(String mTransactionId) {
        this.mTransactionId = mTransactionId;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public MovementType getMovementtype() {
        return movementtype;
    }

    public void setMovementtype(MovementType movementtype) {
        this.movementtype = movementtype;
    }

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
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

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public CProjectissue getCProjectissueId() {
        return cProjectissueId;
    }

    public void setCProjectissueId(CProjectissue cProjectissueId) {
        this.cProjectissueId = cProjectissueId;
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

    public MInoutline getMInoutlineId() {
        return mInoutlineId;
    }

    public void setMInoutlineId(MInoutline mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
    }

    public MInternalConsumptionline getMInternalConsumptionlineId() {
        return mInternalConsumptionlineId;
    }

    public void setMInternalConsumptionlineId(MInternalConsumptionline mInternalConsumptionlineId) {
        this.mInternalConsumptionlineId = mInternalConsumptionlineId;
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

    public MMovementline getMMovementlineId() {
        return mMovementlineId;
    }

    public void setMMovementlineId(MMovementline mMovementlineId) {
        this.mMovementlineId = mMovementlineId;
    }

    public MProductionline getMProductionlineId() {
        return mProductionlineId;
    }

    public void setMProductionlineId(MProductionline mProductionlineId) {
        this.mProductionlineId = mProductionlineId;
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
        hash += (mTransactionId != null ? mTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MTransaction)) {
            return false;
        }
        MTransaction other = (MTransaction) object;
        if ((this.mTransactionId == null && other.mTransactionId != null) || (this.mTransactionId != null && !this.mTransactionId.equals(other.mTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MTransaction[ mTransactionId=" + mTransactionId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mTransactionId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mTransactionId = id;
	}
    
}
