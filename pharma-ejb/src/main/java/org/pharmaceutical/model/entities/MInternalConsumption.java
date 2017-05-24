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
@Table(name = "m_internal_consumption")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInternalConsumption.findAll", query = "SELECT m FROM MInternalConsumption m"),
    @NamedQuery(name = "MInternalConsumption.findByMInternalConsumptionId", query = "SELECT m FROM MInternalConsumption m WHERE m.mInternalConsumptionId = :mInternalConsumptionId"),
    @NamedQuery(name = "MInternalConsumption.findByIsactive", query = "SELECT m FROM MInternalConsumption m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MInternalConsumption.findByCreated", query = "SELECT m FROM MInternalConsumption m WHERE m.created = :created"),
    @NamedQuery(name = "MInternalConsumption.findByCreatedby", query = "SELECT m FROM MInternalConsumption m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MInternalConsumption.findByUpdated", query = "SELECT m FROM MInternalConsumption m WHERE m.updated = :updated"),
    @NamedQuery(name = "MInternalConsumption.findByUpdatedby", query = "SELECT m FROM MInternalConsumption m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MInternalConsumption.findByName", query = "SELECT m FROM MInternalConsumption m WHERE m.name = :name"),
    @NamedQuery(name = "MInternalConsumption.findByDescription", query = "SELECT m FROM MInternalConsumption m WHERE m.description = :description"),
    @NamedQuery(name = "MInternalConsumption.findByMovementdate", query = "SELECT m FROM MInternalConsumption m WHERE m.movementdate = :movementdate"),
    @NamedQuery(name = "MInternalConsumption.findByPosted", query = "SELECT m FROM MInternalConsumption m WHERE m.posted = :posted"),
    @NamedQuery(name = "MInternalConsumption.findByProcessed", query = "SELECT m FROM MInternalConsumption m WHERE m.processed = :processed"),
    @NamedQuery(name = "MInternalConsumption.findByProcessing", query = "SELECT m FROM MInternalConsumption m WHERE m.processing = :processing")})
public class MInternalConsumption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_internal_consumption_id")
    private String mInternalConsumptionId;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInternalConsumptionId")
    private List<MaMaintScheduled> maMaintScheduledList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mInternalConsumptionId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;

    public MInternalConsumption() {
    }

    public MInternalConsumption(String mInternalConsumptionId) {
        this.mInternalConsumptionId = mInternalConsumptionId;
    }

    public MInternalConsumption(String mInternalConsumptionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date movementdate, String posted, Character processed) {
        this.mInternalConsumptionId = mInternalConsumptionId;
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

    public String getMInternalConsumptionId() {
        return mInternalConsumptionId;
    }

    public void setMInternalConsumptionId(String mInternalConsumptionId) {
        this.mInternalConsumptionId = mInternalConsumptionId;
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

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
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
    public List<MInternalConsumptionline> getMInternalConsumptionlineList() {
        return mInternalConsumptionlineList;
    }

    public void setMInternalConsumptionlineList(List<MInternalConsumptionline> mInternalConsumptionlineList) {
        this.mInternalConsumptionlineList = mInternalConsumptionlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mInternalConsumptionId != null ? mInternalConsumptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInternalConsumption)) {
            return false;
        }
        MInternalConsumption other = (MInternalConsumption) object;
        if ((this.mInternalConsumptionId == null && other.mInternalConsumptionId != null) || (this.mInternalConsumptionId != null && !this.mInternalConsumptionId.equals(other.mInternalConsumptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MInternalConsumption[ mInternalConsumptionId=" + mInternalConsumptionId + " ]";
    }
    
}
