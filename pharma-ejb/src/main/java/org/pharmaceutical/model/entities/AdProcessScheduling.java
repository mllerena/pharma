/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_process_scheduling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcessScheduling.findAll", query = "SELECT a FROM AdProcessScheduling a"),
    @NamedQuery(name = "AdProcessScheduling.findByAdProcessSchedulingId", query = "SELECT a FROM AdProcessScheduling a WHERE a.adProcessSchedulingId = :adProcessSchedulingId"),
    @NamedQuery(name = "AdProcessScheduling.findByIsactive", query = "SELECT a FROM AdProcessScheduling a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcessScheduling.findByCreated", query = "SELECT a FROM AdProcessScheduling a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcessScheduling.findByCreatedby", query = "SELECT a FROM AdProcessScheduling a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcessScheduling.findByUpdated", query = "SELECT a FROM AdProcessScheduling a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcessScheduling.findByUpdatedby", query = "SELECT a FROM AdProcessScheduling a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcessScheduling.findByWeekday", query = "SELECT a FROM AdProcessScheduling a WHERE a.weekday = :weekday"),
    @NamedQuery(name = "AdProcessScheduling.findByDescription", query = "SELECT a FROM AdProcessScheduling a WHERE a.description = :description"),
    @NamedQuery(name = "AdProcessScheduling.findByTimefrom", query = "SELECT a FROM AdProcessScheduling a WHERE a.timefrom = :timefrom"),
    @NamedQuery(name = "AdProcessScheduling.findByTimeto", query = "SELECT a FROM AdProcessScheduling a WHERE a.timeto = :timeto"),
    @NamedQuery(name = "AdProcessScheduling.findByIsfulltime", query = "SELECT a FROM AdProcessScheduling a WHERE a.isfulltime = :isfulltime")})
public class AdProcessScheduling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_scheduling_id")
    private String adProcessSchedulingId;
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
    @Size(max = 60)
    @Column(name = "weekday")
    private String weekday;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timefrom;
    @Column(name = "timeto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfulltime")
    private Character isfulltime;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcess adProcessId;

    public AdProcessScheduling() {
    }

    public AdProcessScheduling(String adProcessSchedulingId) {
        this.adProcessSchedulingId = adProcessSchedulingId;
    }

    public AdProcessScheduling(String adProcessSchedulingId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date timefrom, Character isfulltime) {
        this.adProcessSchedulingId = adProcessSchedulingId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.timefrom = timefrom;
        this.isfulltime = isfulltime;
    }

    public String getAdProcessSchedulingId() {
        return adProcessSchedulingId;
    }

    public void setAdProcessSchedulingId(String adProcessSchedulingId) {
        this.adProcessSchedulingId = adProcessSchedulingId;
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

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(Date timefrom) {
        this.timefrom = timefrom;
    }

    public Date getTimeto() {
        return timeto;
    }

    public void setTimeto(Date timeto) {
        this.timeto = timeto;
    }

    public Character getIsfulltime() {
        return isfulltime;
    }

    public void setIsfulltime(Character isfulltime) {
        this.isfulltime = isfulltime;
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

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adProcessSchedulingId != null ? adProcessSchedulingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcessScheduling)) {
            return false;
        }
        AdProcessScheduling other = (AdProcessScheduling) object;
        if ((this.adProcessSchedulingId == null && other.adProcessSchedulingId != null) || (this.adProcessSchedulingId != null && !this.adProcessSchedulingId.equals(other.adProcessSchedulingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcessScheduling[ adProcessSchedulingId=" + adProcessSchedulingId + " ]";
    }
    
}
