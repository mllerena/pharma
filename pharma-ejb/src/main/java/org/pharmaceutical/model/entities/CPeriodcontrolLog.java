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
@Table(name = "c_periodcontrol_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPeriodcontrolLog.findAll", query = "SELECT c FROM CPeriodcontrolLog c"),
    @NamedQuery(name = "CPeriodcontrolLog.findByCPeriodcontrolLogId", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.cPeriodcontrolLogId = :cPeriodcontrolLogId"),
    @NamedQuery(name = "CPeriodcontrolLog.findByIsactive", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPeriodcontrolLog.findByCreated", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.created = :created"),
    @NamedQuery(name = "CPeriodcontrolLog.findByCreatedby", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPeriodcontrolLog.findByUpdated", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPeriodcontrolLog.findByUpdatedby", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPeriodcontrolLog.findByDescription", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.description = :description"),
    @NamedQuery(name = "CPeriodcontrolLog.findByProcessing", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.processing = :processing"),
    @NamedQuery(name = "CPeriodcontrolLog.findByProcessed", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.processed = :processed"),
    @NamedQuery(name = "CPeriodcontrolLog.findByIsrecursive", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.isrecursive = :isrecursive"),
    @NamedQuery(name = "CPeriodcontrolLog.findByDocbasetype", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.docbasetype = :docbasetype"),
    @NamedQuery(name = "CPeriodcontrolLog.findByPeriodaction", query = "SELECT c FROM CPeriodcontrolLog c WHERE c.periodaction = :periodaction")})
public class CPeriodcontrolLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_periodcontrol_log_id")
    private String cPeriodcontrolLogId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isrecursive")
    private Character isrecursive;
    @Size(max = 60)
    @Column(name = "docbasetype")
    private String docbasetype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "periodaction")
    private String periodaction;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_calendar_id", referencedColumnName = "c_calendar_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCalendar cCalendarId;
    @JoinColumn(name = "periodno", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPeriod periodno;
    @JoinColumn(name = "c_year_id", referencedColumnName = "c_year_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CYear cYearId;

    public CPeriodcontrolLog() {
    }

    public CPeriodcontrolLog(String cPeriodcontrolLogId) {
        this.cPeriodcontrolLogId = cPeriodcontrolLogId;
    }

    public CPeriodcontrolLog(String cPeriodcontrolLogId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character processing, Character processed, Character isrecursive, String periodaction) {
        this.cPeriodcontrolLogId = cPeriodcontrolLogId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.processing = processing;
        this.processed = processed;
        this.isrecursive = isrecursive;
        this.periodaction = periodaction;
    }

    public String getCPeriodcontrolLogId() {
        return cPeriodcontrolLogId;
    }

    public void setCPeriodcontrolLogId(String cPeriodcontrolLogId) {
        this.cPeriodcontrolLogId = cPeriodcontrolLogId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getIsrecursive() {
        return isrecursive;
    }

    public void setIsrecursive(Character isrecursive) {
        this.isrecursive = isrecursive;
    }

    public String getDocbasetype() {
        return docbasetype;
    }

    public void setDocbasetype(String docbasetype) {
        this.docbasetype = docbasetype;
    }

    public String getPeriodaction() {
        return periodaction;
    }

    public void setPeriodaction(String periodaction) {
        this.periodaction = periodaction;
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

    public CCalendar getCCalendarId() {
        return cCalendarId;
    }

    public void setCCalendarId(CCalendar cCalendarId) {
        this.cCalendarId = cCalendarId;
    }

    public CPeriod getPeriodno() {
        return periodno;
    }

    public void setPeriodno(CPeriod periodno) {
        this.periodno = periodno;
    }

    public CYear getCYearId() {
        return cYearId;
    }

    public void setCYearId(CYear cYearId) {
        this.cYearId = cYearId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPeriodcontrolLogId != null ? cPeriodcontrolLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPeriodcontrolLog)) {
            return false;
        }
        CPeriodcontrolLog other = (CPeriodcontrolLog) object;
        if ((this.cPeriodcontrolLogId == null && other.cPeriodcontrolLogId != null) || (this.cPeriodcontrolLogId != null && !this.cPeriodcontrolLogId.equals(other.cPeriodcontrolLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPeriodcontrolLog[ cPeriodcontrolLogId=" + cPeriodcontrolLogId + " ]";
    }
    
}
