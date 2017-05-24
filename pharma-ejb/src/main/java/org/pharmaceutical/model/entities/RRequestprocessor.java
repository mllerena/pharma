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
@Table(name = "r_requestprocessor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RRequestprocessor.findAll", query = "SELECT r FROM RRequestprocessor r"),
    @NamedQuery(name = "RRequestprocessor.findByRRequestprocessorId", query = "SELECT r FROM RRequestprocessor r WHERE r.rRequestprocessorId = :rRequestprocessorId"),
    @NamedQuery(name = "RRequestprocessor.findByIsactive", query = "SELECT r FROM RRequestprocessor r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RRequestprocessor.findByCreated", query = "SELECT r FROM RRequestprocessor r WHERE r.created = :created"),
    @NamedQuery(name = "RRequestprocessor.findByCreatedby", query = "SELECT r FROM RRequestprocessor r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RRequestprocessor.findByUpdated", query = "SELECT r FROM RRequestprocessor r WHERE r.updated = :updated"),
    @NamedQuery(name = "RRequestprocessor.findByUpdatedby", query = "SELECT r FROM RRequestprocessor r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RRequestprocessor.findByName", query = "SELECT r FROM RRequestprocessor r WHERE r.name = :name"),
    @NamedQuery(name = "RRequestprocessor.findByDescription", query = "SELECT r FROM RRequestprocessor r WHERE r.description = :description"),
    @NamedQuery(name = "RRequestprocessor.findByFrequency", query = "SELECT r FROM RRequestprocessor r WHERE r.frequency = :frequency"),
    @NamedQuery(name = "RRequestprocessor.findByFrequencytype", query = "SELECT r FROM RRequestprocessor r WHERE r.frequencytype = :frequencytype"),
    @NamedQuery(name = "RRequestprocessor.findByDatelastrun", query = "SELECT r FROM RRequestprocessor r WHERE r.datelastrun = :datelastrun"),
    @NamedQuery(name = "RRequestprocessor.findByDatenextrun", query = "SELECT r FROM RRequestprocessor r WHERE r.datenextrun = :datenextrun"),
    @NamedQuery(name = "RRequestprocessor.findByProcessing", query = "SELECT r FROM RRequestprocessor r WHERE r.processing = :processing"),
    @NamedQuery(name = "RRequestprocessor.findByOverduealertdays", query = "SELECT r FROM RRequestprocessor r WHERE r.overduealertdays = :overduealertdays"),
    @NamedQuery(name = "RRequestprocessor.findByOverdueassigndays", query = "SELECT r FROM RRequestprocessor r WHERE r.overdueassigndays = :overdueassigndays")})
public class RRequestprocessor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_requestprocessor_id")
    private String rRequestprocessorId;
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
    @Column(name = "frequency")
    private long frequency;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "frequencytype")
    private String frequencytype;
    @Column(name = "datelastrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastrun;
    @Column(name = "datenextrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenextrun;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overduealertdays")
    private long overduealertdays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overdueassigndays")
    private long overdueassigndays;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "supervisor_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser supervisorId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "rRequestprocessorId")
    private List<RRequestprocessorRoute> rRequestprocessorRouteList;

    public RRequestprocessor() {
    }

    public RRequestprocessor(String rRequestprocessorId) {
        this.rRequestprocessorId = rRequestprocessorId;
    }

    public RRequestprocessor(String rRequestprocessorId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, long frequency, String frequencytype, long overduealertdays, long overdueassigndays) {
        this.rRequestprocessorId = rRequestprocessorId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.frequency = frequency;
        this.frequencytype = frequencytype;
        this.overduealertdays = overduealertdays;
        this.overdueassigndays = overdueassigndays;
    }

    public String getRRequestprocessorId() {
        return rRequestprocessorId;
    }

    public void setRRequestprocessorId(String rRequestprocessorId) {
        this.rRequestprocessorId = rRequestprocessorId;
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

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public String getFrequencytype() {
        return frequencytype;
    }

    public void setFrequencytype(String frequencytype) {
        this.frequencytype = frequencytype;
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

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public long getOverduealertdays() {
        return overduealertdays;
    }

    public void setOverduealertdays(long overduealertdays) {
        this.overduealertdays = overduealertdays;
    }

    public long getOverdueassigndays() {
        return overdueassigndays;
    }

    public void setOverdueassigndays(long overdueassigndays) {
        this.overdueassigndays = overdueassigndays;
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

    public AdUser getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(AdUser supervisorId) {
        this.supervisorId = supervisorId;
    }

    @XmlTransient
    public List<RRequestprocessorRoute> getRRequestprocessorRouteList() {
        return rRequestprocessorRouteList;
    }

    public void setRRequestprocessorRouteList(List<RRequestprocessorRoute> rRequestprocessorRouteList) {
        this.rRequestprocessorRouteList = rRequestprocessorRouteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rRequestprocessorId != null ? rRequestprocessorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RRequestprocessor)) {
            return false;
        }
        RRequestprocessor other = (RRequestprocessor) object;
        if ((this.rRequestprocessorId == null && other.rRequestprocessorId != null) || (this.rRequestprocessorId != null && !this.rRequestprocessorId.equals(other.rRequestprocessorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RRequestprocessor[ rRequestprocessorId=" + rRequestprocessorId + " ]";
    }
    
}
