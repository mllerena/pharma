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
@Table(name = "ad_process_run")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcessRun.findAll", query = "SELECT a FROM AdProcessRun a"),
    @NamedQuery(name = "AdProcessRun.findByAdProcessRunId", query = "SELECT a FROM AdProcessRun a WHERE a.adProcessRunId = :adProcessRunId"),
    @NamedQuery(name = "AdProcessRun.findByIsactive", query = "SELECT a FROM AdProcessRun a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcessRun.findByCreated", query = "SELECT a FROM AdProcessRun a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcessRun.findByCreatedby", query = "SELECT a FROM AdProcessRun a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcessRun.findByUpdated", query = "SELECT a FROM AdProcessRun a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcessRun.findByUpdatedby", query = "SELECT a FROM AdProcessRun a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcessRun.findByStatus", query = "SELECT a FROM AdProcessRun a WHERE a.status = :status"),
    @NamedQuery(name = "AdProcessRun.findByStartTime", query = "SELECT a FROM AdProcessRun a WHERE a.startTime = :startTime"),
    @NamedQuery(name = "AdProcessRun.findByRuntime", query = "SELECT a FROM AdProcessRun a WHERE a.runtime = :runtime"),
    @NamedQuery(name = "AdProcessRun.findByResult", query = "SELECT a FROM AdProcessRun a WHERE a.result = :result"),
    @NamedQuery(name = "AdProcessRun.findByReport", query = "SELECT a FROM AdProcessRun a WHERE a.report = :report"),
    @NamedQuery(name = "AdProcessRun.findByEndTime", query = "SELECT a FROM AdProcessRun a WHERE a.endTime = :endTime"),
    @NamedQuery(name = "AdProcessRun.findByLog", query = "SELECT a FROM AdProcessRun a WHERE a.log = :log")})
public class AdProcessRun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_run_id")
    private String adProcessRunId;
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
    @Size(max = 3)
    @Column(name = "status")
    private String status;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Size(max = 20)
    @Column(name = "runtime")
    private String runtime;
    @Column(name = "result")
    private Character result;
    @Size(max = 255)
    @Column(name = "report")
    private String report;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 2147483647)
    @Column(name = "log")
    private String log;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_request_id", referencedColumnName = "ad_process_request_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcessRequest adProcessRequestId;

    public AdProcessRun() {
    }

    public AdProcessRun(String adProcessRunId) {
        this.adProcessRunId = adProcessRunId;
    }

    public AdProcessRun(String adProcessRunId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adProcessRunId = adProcessRunId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdProcessRunId() {
        return adProcessRunId;
    }

    public void setAdProcessRunId(String adProcessRunId) {
        this.adProcessRunId = adProcessRunId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Character getResult() {
        return result;
    }

    public void setResult(Character result) {
        this.result = result;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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

    public AdProcessRequest getAdProcessRequestId() {
        return adProcessRequestId;
    }

    public void setAdProcessRequestId(AdProcessRequest adProcessRequestId) {
        this.adProcessRequestId = adProcessRequestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adProcessRunId != null ? adProcessRunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcessRun)) {
            return false;
        }
        AdProcessRun other = (AdProcessRun) object;
        if ((this.adProcessRunId == null && other.adProcessRunId != null) || (this.adProcessRunId != null && !this.adProcessRunId.equals(other.adProcessRunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcessRun[ adProcessRunId=" + adProcessRunId + " ]";
    }
    
}
