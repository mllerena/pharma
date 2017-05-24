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
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_locator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MLocator.findAll", query = "SELECT m FROM MLocator m"),
    @NamedQuery(name = "MLocator.findByMLocatorId", query = "SELECT m FROM MLocator m WHERE m.mLocatorId = :mLocatorId"),
    @NamedQuery(name = "MLocator.findByIsactive", query = "SELECT m FROM MLocator m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MLocator.findByCreated", query = "SELECT m FROM MLocator m WHERE m.created = :created"),
    @NamedQuery(name = "MLocator.findByCreatedby", query = "SELECT m FROM MLocator m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MLocator.findByUpdated", query = "SELECT m FROM MLocator m WHERE m.updated = :updated"),
    @NamedQuery(name = "MLocator.findByUpdatedby", query = "SELECT m FROM MLocator m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MLocator.findByValue", query = "SELECT m FROM MLocator m WHERE m.value = :value"),
    @NamedQuery(name = "MLocator.findByPriorityno", query = "SELECT m FROM MLocator m WHERE m.priorityno = :priorityno"),
    @NamedQuery(name = "MLocator.findByIsdefault", query = "SELECT m FROM MLocator m WHERE m.isdefault = :isdefault"),
    @NamedQuery(name = "MLocator.findByX", query = "SELECT m FROM MLocator m WHERE m.x = :x"),
    @NamedQuery(name = "MLocator.findByY", query = "SELECT m FROM MLocator m WHERE m.y = :y"),
    @NamedQuery(name = "MLocator.findByZ", query = "SELECT m FROM MLocator m WHERE m.z = :z"),
    @NamedQuery(name = "MLocator.findByMWarehouseId", query = "SELECT m FROM MLocator m WHERE m.mWarehouseId = :mWarehouseId and m.isactive = :isactive")
    
    
})
public class MLocator extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "m_locator_id")
    private String mLocatorId;
    
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
    @Column(name = "value")
    private String value;
    
    @Basic(optional = false)
    @Column(name = "priorityno")
    private long priorityno;
    
    @Basic(optional = false)
    @Column(name = "isdefault")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isdefault;
    
    @Column(name = "x")
    private String x;
    
    @Column(name = "y")
    private String y;
    
    @Column(name = "z")
    private String z;
    
    @Column(name = "name") 
    private String name;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MProductionline> mProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<MProductOrg> mProductOrgList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<IInventory> iInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MaToolset> maToolsetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MInventoryline> mInventorylineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MStorageDetail> mStorageDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatorId")
    private List<MMovementline> mMovementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mLocatortoId")
    private List<MMovementline> mMovementlineList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<MProductionplan> mProductionplanList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLocatorId")
    private List<MInoutline> mInoutlineList;

    public MLocator() {
    }

    public MLocator(String mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public String getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(String mLocatorId) {
        this.mLocatorId = mLocatorId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getPriorityno() {
        return priorityno;
    }

    public void setPriorityno(long priorityno) {
        this.priorityno = priorityno;
    }

    public YesNo getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(YesNo isdefault) {
        this.isdefault = isdefault;
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
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<MProductOrg> getMProductOrgList() {
        return mProductOrgList;
    }

    public void setMProductOrgList(List<MProductOrg> mProductOrgList) {
        this.mProductOrgList = mProductOrgList;
    }

    @XmlTransient
    public List<IInventory> getIInventoryList() {
        return iInventoryList;
    }

    public void setIInventoryList(List<IInventory> iInventoryList) {
        this.iInventoryList = iInventoryList;
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
    public List<MaToolset> getMaToolsetList() {
        return maToolsetList;
    }

    public void setMaToolsetList(List<MaToolset> maToolsetList) {
        this.maToolsetList = maToolsetList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<MInventoryline> getMInventorylineList() {
        return mInventorylineList;
    }

    public void setMInventorylineList(List<MInventoryline> mInventorylineList) {
        this.mInventorylineList = mInventorylineList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<MStorageDetail> getMStorageDetailList() {
        return mStorageDetailList;
    }

    public void setMStorageDetailList(List<MStorageDetail> mStorageDetailList) {
        this.mStorageDetailList = mStorageDetailList;
    }

    @XmlTransient
    public List<MMovementline> getMMovementlineList() {
        return mMovementlineList;
    }

    public void setMMovementlineList(List<MMovementline> mMovementlineList) {
        this.mMovementlineList = mMovementlineList;
    }

    @XmlTransient
    public List<MMovementline> getMMovementlineList1() {
        return mMovementlineList1;
    }

    public void setMMovementlineList1(List<MMovementline> mMovementlineList1) {
        this.mMovementlineList1 = mMovementlineList1;
    }

    @XmlTransient
    public List<MProductionplan> getMProductionplanList() {
        return mProductionplanList;
    }

    public void setMProductionplanList(List<MProductionplan> mProductionplanList) {
        this.mProductionplanList = mProductionplanList;
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

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
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
    
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (mLocatorId != null ? mLocatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MLocator)) {
            return false;
        }
        MLocator other = (MLocator) object;
        if ((this.mLocatorId == null && other.mLocatorId != null) || (this.mLocatorId != null && !this.mLocatorId.equals(other.mLocatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MLocator[ mLocatorId=" + mLocatorId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mLocatorId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mLocatorId = id;
	}
    
}
