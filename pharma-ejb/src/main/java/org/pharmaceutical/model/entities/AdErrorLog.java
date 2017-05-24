/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ad_error_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdErrorLog.findAll", query = "SELECT a FROM AdErrorLog a"),
    @NamedQuery(name = "AdErrorLog.findByAdErrorLogId", query = "SELECT a FROM AdErrorLog a WHERE a.adErrorLogId = :adErrorLogId"),
    @NamedQuery(name = "AdErrorLog.findByIsactive", query = "SELECT a FROM AdErrorLog a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdErrorLog.findByCreated", query = "SELECT a FROM AdErrorLog a WHERE a.created = :created"),
    @NamedQuery(name = "AdErrorLog.findByCreatedby", query = "SELECT a FROM AdErrorLog a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdErrorLog.findByUpdated", query = "SELECT a FROM AdErrorLog a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdErrorLog.findByUpdatedby", query = "SELECT a FROM AdErrorLog a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdErrorLog.findBySystemStatus", query = "SELECT a FROM AdErrorLog a WHERE a.systemStatus = :systemStatus"),
    @NamedQuery(name = "AdErrorLog.findByErrorLevel", query = "SELECT a FROM AdErrorLog a WHERE a.errorLevel = :errorLevel"),
    @NamedQuery(name = "AdErrorLog.findByMessage", query = "SELECT a FROM AdErrorLog a WHERE a.message = :message"),
    @NamedQuery(name = "AdErrorLog.findByLineNumber", query = "SELECT a FROM AdErrorLog a WHERE a.lineNumber = :lineNumber")})
public class AdErrorLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_error_log_id")
    private String adErrorLogId;
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
    @Column(name = "system_status")
    private String systemStatus;
    @Size(max = 60)
    @Column(name = "error_level")
    private String errorLevel;
    @Size(max = 3000)
    @Column(name = "message")
    private String message;
    @Column(name = "line_number")
    private BigInteger lineNumber;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdErrorLog() {
    }

    public AdErrorLog(String adErrorLogId) {
        this.adErrorLogId = adErrorLogId;
    }

    public AdErrorLog(String adErrorLogId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adErrorLogId = adErrorLogId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdErrorLogId() {
        return adErrorLogId;
    }

    public void setAdErrorLogId(String adErrorLogId) {
        this.adErrorLogId = adErrorLogId;
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

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigInteger getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigInteger lineNumber) {
        this.lineNumber = lineNumber;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adErrorLogId != null ? adErrorLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdErrorLog)) {
            return false;
        }
        AdErrorLog other = (AdErrorLog) object;
        if ((this.adErrorLogId == null && other.adErrorLogId != null) || (this.adErrorLogId != null && !this.adErrorLogId.equals(other.adErrorLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdErrorLog[ adErrorLogId=" + adErrorLogId + " ]";
    }
    
}
