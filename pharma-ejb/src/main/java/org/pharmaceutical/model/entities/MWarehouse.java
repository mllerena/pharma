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
@Table(name = "m_warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MWarehouse.findAll", query = "SELECT m FROM MWarehouse m"),
    @NamedQuery(name = "MWarehouse.findByMWarehouseId", query = "SELECT m FROM MWarehouse m WHERE m.mWarehouseId = :mWarehouseId"),
    @NamedQuery(name = "MWarehouse.findByIsactive", query = "SELECT m FROM MWarehouse m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MWarehouse.findByCreated", query = "SELECT m FROM MWarehouse m WHERE m.created = :created"),
    @NamedQuery(name = "MWarehouse.findByCreatedby", query = "SELECT m FROM MWarehouse m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MWarehouse.findByUpdated", query = "SELECT m FROM MWarehouse m WHERE m.updated = :updated"),
    @NamedQuery(name = "MWarehouse.findByUpdatedby", query = "SELECT m FROM MWarehouse m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MWarehouse.findByValue", query = "SELECT m FROM MWarehouse m WHERE m.value = :value"),
    @NamedQuery(name = "MWarehouse.findByName", query = "SELECT m FROM MWarehouse m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MWarehouse.findByDescription", query = "SELECT m FROM MWarehouse m WHERE m.description = :description"),
    @NamedQuery(name = "MWarehouse.findBySeparator", query = "SELECT m FROM MWarehouse m WHERE m.separator = :separator"),
    @NamedQuery(name = "MWarehouse.findByIsshipper", query = "SELECT m FROM MWarehouse m WHERE m.isshipper = :isshipper"),
    @NamedQuery(name = "MWarehouse.findByShippercode", query = "SELECT m FROM MWarehouse m WHERE m.shippercode = :shippercode"),
    @NamedQuery(name = "MWarehouse.findByFromdocumentno", query = "SELECT m FROM MWarehouse m WHERE m.fromdocumentno = :fromdocumentno"),
    @NamedQuery(name = "MWarehouse.findByTodocumentno", query = "SELECT m FROM MWarehouse m WHERE m.todocumentno = :todocumentno")})
public class MWarehouse extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "m_warehouse_id")
    private String mWarehouseId;
    
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
    @Column(name = "name")
    private String name;
    
    
    @Column(name = "description")
    private String description;
    
        
    @Column(name = "separator")
    private Character separator;
    
    @Column(name = "isshipper")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isshipper;
    
    @Column(name = "shippercode")
    private String shippercode;
    
    @Column(name = "fromdocumentno")
    private Long fromdocumentno;
    
    @Column(name = "todocumentno")
    private Long todocumentno;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<MInventory> mInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<SResource> sResourceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CLocation cLocationId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<MWarehouseAcct> mWarehouseAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "defaultMWarehouseId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<IInventory> iInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<MReplenish> mReplenishList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<MPerpetualinv> mPerpetualinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<MStoragePending> mStoragePendingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<MWarehouseShipper> mWarehouseShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<MLocator> mLocatorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<STimeexpense> sTimeexpenseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<AdAlert> adAlertList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWarehouseId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mWarehouseId")
    private List<CProject> cProjectList;

    public MWarehouse() {
    }

    public MWarehouse(String mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    public String getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(String mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getSeparator() {
        return separator;
    }

    public void setSeparator(Character separator) {
        this.separator = separator;
    }

    public YesNo getIsshipper() {
        return isshipper;
    }

    public void setIsshipper(YesNo isshipper) {
        this.isshipper = isshipper;
    }

    public String getShippercode() {
        return shippercode;
    }

    public void setShippercode(String shippercode) {
        this.shippercode = shippercode;
    }

    public Long getFromdocumentno() {
        return fromdocumentno;
    }

    public void setFromdocumentno(Long fromdocumentno) {
        this.fromdocumentno = fromdocumentno;
    }

    public Long getTodocumentno() {
        return todocumentno;
    }

    public void setTodocumentno(Long todocumentno) {
        this.todocumentno = todocumentno;
    }

    @XmlTransient
    public List<MInventory> getMInventoryList() {
        return mInventoryList;
    }

    public void setMInventoryList(List<MInventory> mInventoryList) {
        this.mInventoryList = mInventoryList;
    }

    @XmlTransient
    public List<SResource> getSResourceList() {
        return sResourceList;
    }

    public void setSResourceList(List<SResource> sResourceList) {
        this.sResourceList = sResourceList;
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

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList() {
        return mWarehouseAcctList;
    }

    public void setMWarehouseAcctList(List<MWarehouseAcct> mWarehouseAcctList) {
        this.mWarehouseAcctList = mWarehouseAcctList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    @XmlTransient
    public List<IInventory> getIInventoryList() {
        return iInventoryList;
    }

    public void setIInventoryList(List<IInventory> iInventoryList) {
        this.iInventoryList = iInventoryList;
    }

    @XmlTransient
    public List<CExternalpos> getCExternalposList() {
        return cExternalposList;
    }

    public void setCExternalposList(List<CExternalpos> cExternalposList) {
        this.cExternalposList = cExternalposList;
    }

    @XmlTransient
    public List<MReplenish> getMReplenishList() {
        return mReplenishList;
    }

    public void setMReplenishList(List<MReplenish> mReplenishList) {
        this.mReplenishList = mReplenishList;
    }

    @XmlTransient
    public List<MPerpetualinv> getMPerpetualinvList() {
        return mPerpetualinvList;
    }

    public void setMPerpetualinvList(List<MPerpetualinv> mPerpetualinvList) {
        this.mPerpetualinvList = mPerpetualinvList;
    }

    @XmlTransient
    public List<MStoragePending> getMStoragePendingList() {
        return mStoragePendingList;
    }

    public void setMStoragePendingList(List<MStoragePending> mStoragePendingList) {
        this.mStoragePendingList = mStoragePendingList;
    }

    @XmlTransient
    public List<MWarehouseShipper> getMWarehouseShipperList() {
        return mWarehouseShipperList;
    }

    public void setMWarehouseShipperList(List<MWarehouseShipper> mWarehouseShipperList) {
        this.mWarehouseShipperList = mWarehouseShipperList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<MLocator> getMLocatorList() {
        return mLocatorList;
    }

    public void setMLocatorList(List<MLocator> mLocatorList) {
        this.mLocatorList = mLocatorList;
    }

    @XmlTransient
    public List<STimeexpense> getSTimeexpenseList() {
        return sTimeexpenseList;
    }

    public void setSTimeexpenseList(List<STimeexpense> sTimeexpenseList) {
        this.sTimeexpenseList = sTimeexpenseList;
    }

    @XmlTransient
    public List<AdAlert> getAdAlertList() {
        return adAlertList;
    }

    public void setAdAlertList(List<AdAlert> adAlertList) {
        this.adAlertList = adAlertList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mWarehouseId != null ? mWarehouseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MWarehouse)) {
            return false;
        }
        MWarehouse other = (MWarehouse) object;
        if ((this.mWarehouseId == null && other.mWarehouseId != null) || (this.mWarehouseId != null && !this.mWarehouseId.equals(other.mWarehouseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MWarehouse[ mWarehouseId=" + mWarehouseId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mWarehouseId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mWarehouseId = id;
	}
    
}
