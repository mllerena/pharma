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
@Table(name = "m_perpetualinv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPerpetualinv.findAll", query = "SELECT m FROM MPerpetualinv m"),
    @NamedQuery(name = "MPerpetualinv.findByMPerpetualinvId", query = "SELECT m FROM MPerpetualinv m WHERE m.mPerpetualinvId = :mPerpetualinvId"),
    @NamedQuery(name = "MPerpetualinv.findByIsactive", query = "SELECT m FROM MPerpetualinv m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MPerpetualinv.findByCreated", query = "SELECT m FROM MPerpetualinv m WHERE m.created = :created"),
    @NamedQuery(name = "MPerpetualinv.findByCreatedby", query = "SELECT m FROM MPerpetualinv m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MPerpetualinv.findByUpdated", query = "SELECT m FROM MPerpetualinv m WHERE m.updated = :updated"),
    @NamedQuery(name = "MPerpetualinv.findByUpdatedby", query = "SELECT m FROM MPerpetualinv m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MPerpetualinv.findByName", query = "SELECT m FROM MPerpetualinv m WHERE m.name = :name"),
    @NamedQuery(name = "MPerpetualinv.findByDescription", query = "SELECT m FROM MPerpetualinv m WHERE m.description = :description"),
    @NamedQuery(name = "MPerpetualinv.findByNoinventorycount", query = "SELECT m FROM MPerpetualinv m WHERE m.noinventorycount = :noinventorycount"),
    @NamedQuery(name = "MPerpetualinv.findByNoproductcount", query = "SELECT m FROM MPerpetualinv m WHERE m.noproductcount = :noproductcount"),
    @NamedQuery(name = "MPerpetualinv.findByCounthighmovement", query = "SELECT m FROM MPerpetualinv m WHERE m.counthighmovement = :counthighmovement"),
    @NamedQuery(name = "MPerpetualinv.findByProcessing", query = "SELECT m FROM MPerpetualinv m WHERE m.processing = :processing"),
    @NamedQuery(name = "MPerpetualinv.findByDatelastrun", query = "SELECT m FROM MPerpetualinv m WHERE m.datelastrun = :datelastrun"),
    @NamedQuery(name = "MPerpetualinv.findByDatenextrun", query = "SELECT m FROM MPerpetualinv m WHERE m.datenextrun = :datenextrun"),
    @NamedQuery(name = "MPerpetualinv.findByNumberofruns", query = "SELECT m FROM MPerpetualinv m WHERE m.numberofruns = :numberofruns")})
public class MPerpetualinv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_perpetualinv_id")
    private String mPerpetualinvId;
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
    @Column(name = "noinventorycount")
    private long noinventorycount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noproductcount")
    private long noproductcount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "counthighmovement")
    private Character counthighmovement;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "datelastrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastrun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datenextrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenextrun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberofruns")
    private long numberofruns;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mPerpetualinvId")
    private List<MInventory> mInventoryList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse mWarehouseId;

    public MPerpetualinv() {
    }

    public MPerpetualinv(String mPerpetualinvId) {
        this.mPerpetualinvId = mPerpetualinvId;
    }

    public MPerpetualinv(String mPerpetualinvId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, long noinventorycount, long noproductcount, Character counthighmovement, Date datenextrun, long numberofruns) {
        this.mPerpetualinvId = mPerpetualinvId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.noinventorycount = noinventorycount;
        this.noproductcount = noproductcount;
        this.counthighmovement = counthighmovement;
        this.datenextrun = datenextrun;
        this.numberofruns = numberofruns;
    }

    public String getMPerpetualinvId() {
        return mPerpetualinvId;
    }

    public void setMPerpetualinvId(String mPerpetualinvId) {
        this.mPerpetualinvId = mPerpetualinvId;
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

    public long getNoinventorycount() {
        return noinventorycount;
    }

    public void setNoinventorycount(long noinventorycount) {
        this.noinventorycount = noinventorycount;
    }

    public long getNoproductcount() {
        return noproductcount;
    }

    public void setNoproductcount(long noproductcount) {
        this.noproductcount = noproductcount;
    }

    public Character getCounthighmovement() {
        return counthighmovement;
    }

    public void setCounthighmovement(Character counthighmovement) {
        this.counthighmovement = counthighmovement;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Date getDatelastrun() {
        return datelastrun;
    }

    public void setDatelastrun(Date datelastrun) {
        this.datelastrun = datelastrun;
    }

    public Date getDatenextrun() {
        return datenextrun;
    }

    public void setDatenextrun(Date datenextrun) {
        this.datenextrun = datenextrun;
    }

    public long getNumberofruns() {
        return numberofruns;
    }

    public void setNumberofruns(long numberofruns) {
        this.numberofruns = numberofruns;
    }

    @XmlTransient
    public List<MInventory> getMInventoryList() {
        return mInventoryList;
    }

    public void setMInventoryList(List<MInventory> mInventoryList) {
        this.mInventoryList = mInventoryList;
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

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
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
        hash += (mPerpetualinvId != null ? mPerpetualinvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPerpetualinv)) {
            return false;
        }
        MPerpetualinv other = (MPerpetualinv) object;
        if ((this.mPerpetualinvId == null && other.mPerpetualinvId != null) || (this.mPerpetualinvId != null && !this.mPerpetualinvId.equals(other.mPerpetualinvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MPerpetualinv[ mPerpetualinvId=" + mPerpetualinvId + " ]";
    }
    
}
