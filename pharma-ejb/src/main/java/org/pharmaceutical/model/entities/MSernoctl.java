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
@Table(name = "m_sernoctl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSernoctl.findAll", query = "SELECT m FROM MSernoctl m"),
    @NamedQuery(name = "MSernoctl.findByMSernoctlId", query = "SELECT m FROM MSernoctl m WHERE m.mSernoctlId = :mSernoctlId"),
    @NamedQuery(name = "MSernoctl.findByIsactive", query = "SELECT m FROM MSernoctl m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MSernoctl.findByCreated", query = "SELECT m FROM MSernoctl m WHERE m.created = :created"),
    @NamedQuery(name = "MSernoctl.findByUpdatedby", query = "SELECT m FROM MSernoctl m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MSernoctl.findByName", query = "SELECT m FROM MSernoctl m WHERE m.name = :name"),
    @NamedQuery(name = "MSernoctl.findByDescription", query = "SELECT m FROM MSernoctl m WHERE m.description = :description"),
    @NamedQuery(name = "MSernoctl.findByStartno", query = "SELECT m FROM MSernoctl m WHERE m.startno = :startno"),
    @NamedQuery(name = "MSernoctl.findByIncrementno", query = "SELECT m FROM MSernoctl m WHERE m.incrementno = :incrementno"),
    @NamedQuery(name = "MSernoctl.findByCurrentnext", query = "SELECT m FROM MSernoctl m WHERE m.currentnext = :currentnext"),
    @NamedQuery(name = "MSernoctl.findByPrefix", query = "SELECT m FROM MSernoctl m WHERE m.prefix = :prefix"),
    @NamedQuery(name = "MSernoctl.findBySuffix", query = "SELECT m FROM MSernoctl m WHERE m.suffix = :suffix"),
    @NamedQuery(name = "MSernoctl.findByCreatedby", query = "SELECT m FROM MSernoctl m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MSernoctl.findByUpdated", query = "SELECT m FROM MSernoctl m WHERE m.updated = :updated")})
public class MSernoctl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_sernoctl_id")
    private String mSernoctlId;
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
    @Column(name = "startno")
    private long startno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incrementno")
    private long incrementno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentnext")
    private long currentnext;
    @Size(max = 10)
    @Column(name = "prefix")
    private String prefix;
    @Size(max = 10)
    @Column(name = "suffix")
    private String suffix;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mSernoctlId")
    private List<MAttributeset> mAttributesetList;

    public MSernoctl() {
    }

    public MSernoctl(String mSernoctlId) {
        this.mSernoctlId = mSernoctlId;
    }

    public MSernoctl(String mSernoctlId, Character isactive, Date created, String updatedby, String name, long startno, long incrementno, long currentnext, String createdby, Date updated) {
        this.mSernoctlId = mSernoctlId;
        this.isactive = isactive;
        this.created = created;
        this.updatedby = updatedby;
        this.name = name;
        this.startno = startno;
        this.incrementno = incrementno;
        this.currentnext = currentnext;
        this.createdby = createdby;
        this.updated = updated;
    }

    public String getMSernoctlId() {
        return mSernoctlId;
    }

    public void setMSernoctlId(String mSernoctlId) {
        this.mSernoctlId = mSernoctlId;
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

    public long getStartno() {
        return startno;
    }

    public void setStartno(long startno) {
        this.startno = startno;
    }

    public long getIncrementno() {
        return incrementno;
    }

    public void setIncrementno(long incrementno) {
        this.incrementno = incrementno;
    }

    public long getCurrentnext() {
        return currentnext;
    }

    public void setCurrentnext(long currentnext) {
        this.currentnext = currentnext;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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

    @XmlTransient
    public List<MAttributeset> getMAttributesetList() {
        return mAttributesetList;
    }

    public void setMAttributesetList(List<MAttributeset> mAttributesetList) {
        this.mAttributesetList = mAttributesetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mSernoctlId != null ? mSernoctlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MSernoctl)) {
            return false;
        }
        MSernoctl other = (MSernoctl) object;
        if ((this.mSernoctlId == null && other.mSernoctlId != null) || (this.mSernoctlId != null && !this.mSernoctlId.equals(other.mSernoctlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MSernoctl[ mSernoctlId=" + mSernoctlId + " ]";
    }
    
}
