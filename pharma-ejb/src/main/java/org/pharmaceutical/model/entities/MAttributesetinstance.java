/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "m_attributesetinstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAttributesetinstance.findAll", query = "SELECT m FROM MAttributesetinstance m"),
    @NamedQuery(name = "MAttributesetinstance.findByMAttributesetinstanceId", query = "SELECT m FROM MAttributesetinstance m WHERE m.mAttributesetinstanceId = :mAttributesetinstanceId"),
    @NamedQuery(name = "MAttributesetinstance.findByIsactive", query = "SELECT m FROM MAttributesetinstance m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MAttributesetinstance.findByCreated", query = "SELECT m FROM MAttributesetinstance m WHERE m.created = :created"),
    @NamedQuery(name = "MAttributesetinstance.findByCreatedby", query = "SELECT m FROM MAttributesetinstance m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MAttributesetinstance.findByUpdated", query = "SELECT m FROM MAttributesetinstance m WHERE m.updated = :updated"),
    @NamedQuery(name = "MAttributesetinstance.findByUpdatedby", query = "SELECT m FROM MAttributesetinstance m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MAttributesetinstance.findBySerno", query = "SELECT m FROM MAttributesetinstance m WHERE m.serno = :serno"),
    @NamedQuery(name = "MAttributesetinstance.findByLot", query = "SELECT m FROM MAttributesetinstance m WHERE m.lot = :lot"),
    @NamedQuery(name = "MAttributesetinstance.findByGuaranteedate", query = "SELECT m FROM MAttributesetinstance m WHERE m.guaranteedate = :guaranteedate"),
    @NamedQuery(name = "MAttributesetinstance.findByDescription", query = "SELECT m FROM MAttributesetinstance m WHERE m.description = :description"),
    @NamedQuery(name = "MAttributesetinstance.findByIslocked", query = "SELECT m FROM MAttributesetinstance m WHERE m.islocked = :islocked"),
    @NamedQuery(name = "MAttributesetinstance.findByLockDescription", query = "SELECT m FROM MAttributesetinstance m WHERE m.lockDescription = :lockDescription"),
    @NamedQuery(name = "MAttributesetinstance.findByReceptiondate", query = "SELECT m FROM MAttributesetinstance m WHERE m.receptiondate = :receptiondate")})
public class MAttributesetinstance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_attributesetinstance_id")
    private String mAttributesetinstanceId;
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
    @Size(max = 20)
    @Column(name = "serno")
    private String serno;
    @Size(max = 20)
    @Column(name = "lot")
    private String lot;
    @Column(name = "guaranteedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guaranteedate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "islocked")
    private Character islocked;
    @Size(max = 255)
    @Column(name = "lock_description")
    private String lockDescription;
    @Column(name = "receptiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receptiondate;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MProductionline> mProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MInventoryline> mInventorylineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributesetinstanceId")
    private List<MAttributeinstance> mAttributeinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributesetinstanceId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MaPcCase> maPcCaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MStoragePending> mStoragePendingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MStorageDetail> mStorageDetailList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_attributeset_id", referencedColumnName = "m_attributeset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttributeset mAttributesetId;
    @JoinColumn(name = "m_lot_id", referencedColumnName = "m_lot_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLot mLotId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MMovementline> mMovementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetinstanceId")
    private List<MInoutline> mInoutlineList;

    public MAttributesetinstance() {
    }

    public MAttributesetinstance(String mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MAttributesetinstance(String mAttributesetinstanceId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(String mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
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

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Date getGuaranteedate() {
        return guaranteedate;
    }

    public void setGuaranteedate(Date guaranteedate) {
        this.guaranteedate = guaranteedate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIslocked() {
        return islocked;
    }

    public void setIslocked(Character islocked) {
        this.islocked = islocked;
    }

    public String getLockDescription() {
        return lockDescription;
    }

    public void setLockDescription(String lockDescription) {
        this.lockDescription = lockDescription;
    }

    public Date getReceptiondate() {
        return receptiondate;
    }

    public void setReceptiondate(Date receptiondate) {
        this.receptiondate = receptiondate;
    }

    @XmlTransient
    public List<CProjectissue> getCProjectissueList() {
        return cProjectissueList;
    }

    public void setCProjectissueList(List<CProjectissue> cProjectissueList) {
        this.cProjectissueList = cProjectissueList;
    }

    @XmlTransient
    public List<MProductionline> getMProductionlineList() {
        return mProductionlineList;
    }

    public void setMProductionlineList(List<MProductionline> mProductionlineList) {
        this.mProductionlineList = mProductionlineList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<MInternalConsumptionline> getMInternalConsumptionlineList() {
        return mInternalConsumptionlineList;
    }

    public void setMInternalConsumptionlineList(List<MInternalConsumptionline> mInternalConsumptionlineList) {
        this.mInternalConsumptionlineList = mInternalConsumptionlineList;
    }

    @XmlTransient
    public List<MaGlobaluse> getMaGlobaluseList() {
        return maGlobaluseList;
    }

    public void setMaGlobaluseList(List<MaGlobaluse> maGlobaluseList) {
        this.maGlobaluseList = maGlobaluseList;
    }

    @XmlTransient
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
    }

    @XmlTransient
    public List<MInventoryline> getMInventorylineList() {
        return mInventorylineList;
    }

    public void setMInventorylineList(List<MInventoryline> mInventorylineList) {
        this.mInventorylineList = mInventorylineList;
    }

    @XmlTransient
    public List<MAttributeinstance> getMAttributeinstanceList() {
        return mAttributeinstanceList;
    }

    public void setMAttributeinstanceList(List<MAttributeinstance> mAttributeinstanceList) {
        this.mAttributeinstanceList = mAttributeinstanceList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<MaPcCase> getMaPcCaseList() {
        return maPcCaseList;
    }

    public void setMaPcCaseList(List<MaPcCase> maPcCaseList) {
        this.maPcCaseList = maPcCaseList;
    }

    @XmlTransient
    public List<MStoragePending> getMStoragePendingList() {
        return mStoragePendingList;
    }

    public void setMStoragePendingList(List<MStoragePending> mStoragePendingList) {
        this.mStoragePendingList = mStoragePendingList;
    }

    @XmlTransient
    public List<MStorageDetail> getMStorageDetailList() {
        return mStorageDetailList;
    }

    public void setMStorageDetailList(List<MStorageDetail> mStorageDetailList) {
        this.mStorageDetailList = mStorageDetailList;
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

    public MAttributeset getMAttributesetId() {
        return mAttributesetId;
    }

    public void setMAttributesetId(MAttributeset mAttributesetId) {
        this.mAttributesetId = mAttributesetId;
    }

    public MLot getMLotId() {
        return mLotId;
    }

    public void setMLotId(MLot mLotId) {
        this.mLotId = mLotId;
    }

    @XmlTransient
    public List<MMovementline> getMMovementlineList() {
        return mMovementlineList;
    }

    public void setMMovementlineList(List<MMovementline> mMovementlineList) {
        this.mMovementlineList = mMovementlineList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @XmlTransient
    public List<MInoutline> getMInoutlineList() {
        return mInoutlineList;
    }

    public void setMInoutlineList(List<MInoutline> mInoutlineList) {
        this.mInoutlineList = mInoutlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mAttributesetinstanceId != null ? mAttributesetinstanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAttributesetinstance)) {
            return false;
        }
        MAttributesetinstance other = (MAttributesetinstance) object;
        if ((this.mAttributesetinstanceId == null && other.mAttributesetinstanceId != null) || (this.mAttributesetinstanceId != null && !this.mAttributesetinstanceId.equals(other.mAttributesetinstanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MAttributesetinstance[ mAttributesetinstanceId=" + mAttributesetinstanceId + " ]";
    }
    
}
