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
@Table(name = "m_inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInventory.findAll", query = "SELECT m FROM MInventory m"),
    @NamedQuery(name = "MInventory.findByMInventoryId", query = "SELECT m FROM MInventory m WHERE m.mInventoryId = :mInventoryId"),
    @NamedQuery(name = "MInventory.findByIsactive", query = "SELECT m FROM MInventory m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MInventory.findByCreated", query = "SELECT m FROM MInventory m WHERE m.created = :created"),
    @NamedQuery(name = "MInventory.findByCreatedby", query = "SELECT m FROM MInventory m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MInventory.findByUpdated", query = "SELECT m FROM MInventory m WHERE m.updated = :updated"),
    @NamedQuery(name = "MInventory.findByUpdatedby", query = "SELECT m FROM MInventory m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MInventory.findByName", query = "SELECT m FROM MInventory m WHERE m.name = :name"),
    @NamedQuery(name = "MInventory.findByDescription", query = "SELECT m FROM MInventory m WHERE m.description = :description"),
    @NamedQuery(name = "MInventory.findByMovementdate", query = "SELECT m FROM MInventory m WHERE m.movementdate = :movementdate"),
    @NamedQuery(name = "MInventory.findByPosted", query = "SELECT m FROM MInventory m WHERE m.posted = :posted"),
    @NamedQuery(name = "MInventory.findByProcessed", query = "SELECT m FROM MInventory m WHERE m.processed = :processed"),
    @NamedQuery(name = "MInventory.findByProcessing", query = "SELECT m FROM MInventory m WHERE m.processing = :processing"),
    @NamedQuery(name = "MInventory.findByUpdateqty", query = "SELECT m FROM MInventory m WHERE m.updateqty = :updateqty"),
    @NamedQuery(name = "MInventory.findByGeneratelist", query = "SELECT m FROM MInventory m WHERE m.generatelist = :generatelist"),
    @NamedQuery(name = "MInventory.findByUser1Id", query = "SELECT m FROM MInventory m WHERE m.user1Id = :user1Id"),
    @NamedQuery(name = "MInventory.findByUser2Id", query = "SELECT m FROM MInventory m WHERE m.user2Id = :user2Id")})
public class MInventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_inventory_id")
    private String mInventoryId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "updateqty")
    private Character updateqty;
    @Column(name = "generatelist")
    private Character generatelist;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "m_perpetualinv_id", referencedColumnName = "m_perpetualinv_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPerpetualinv mPerpetualinvId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInventoryId")
    private List<IInventory> iInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mInventoryId")
    private List<MInventoryline> mInventorylineList;

    public MInventory() {
    }

    public MInventory(String mInventoryId) {
        this.mInventoryId = mInventoryId;
    }

    public MInventory(String mInventoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date movementdate, String posted, Character processed) {
        this.mInventoryId = mInventoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.movementdate = movementdate;
        this.posted = posted;
        this.processed = processed;
    }

    public String getMInventoryId() {
        return mInventoryId;
    }

    public void setMInventoryId(String mInventoryId) {
        this.mInventoryId = mInventoryId;
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

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getUpdateqty() {
        return updateqty;
    }

    public void setUpdateqty(Character updateqty) {
        this.updateqty = updateqty;
    }

    public Character getGeneratelist() {
        return generatelist;
    }

    public void setGeneratelist(Character generatelist) {
        this.generatelist = generatelist;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MPerpetualinv getMPerpetualinvId() {
        return mPerpetualinvId;
    }

    public void setMPerpetualinvId(MPerpetualinv mPerpetualinvId) {
        this.mPerpetualinvId = mPerpetualinvId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @XmlTransient
    public List<IInventory> getIInventoryList() {
        return iInventoryList;
    }

    public void setIInventoryList(List<IInventory> iInventoryList) {
        this.iInventoryList = iInventoryList;
    }

    @XmlTransient
    public List<MInventoryline> getMInventorylineList() {
        return mInventorylineList;
    }

    public void setMInventorylineList(List<MInventoryline> mInventorylineList) {
        this.mInventorylineList = mInventorylineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mInventoryId != null ? mInventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInventory)) {
            return false;
        }
        MInventory other = (MInventory) object;
        if ((this.mInventoryId == null && other.mInventoryId != null) || (this.mInventoryId != null && !this.mInventoryId.equals(other.mInventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MInventory[ mInventoryId=" + mInventoryId + " ]";
    }
    
}
