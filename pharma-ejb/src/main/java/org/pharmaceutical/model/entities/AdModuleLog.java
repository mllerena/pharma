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
@Table(name = "ad_module_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleLog.findAll", query = "SELECT a FROM AdModuleLog a"),
    @NamedQuery(name = "AdModuleLog.findByAdModuleLogId", query = "SELECT a FROM AdModuleLog a WHERE a.adModuleLogId = :adModuleLogId"),
    @NamedQuery(name = "AdModuleLog.findByIsactive", query = "SELECT a FROM AdModuleLog a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleLog.findByCreated", query = "SELECT a FROM AdModuleLog a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleLog.findByCreatedby", query = "SELECT a FROM AdModuleLog a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleLog.findByUpdated", query = "SELECT a FROM AdModuleLog a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleLog.findByUpdatedby", query = "SELECT a FROM AdModuleLog a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleLog.findByAdModuleId", query = "SELECT a FROM AdModuleLog a WHERE a.adModuleId = :adModuleId"),
    @NamedQuery(name = "AdModuleLog.findByAdModuleVersionId", query = "SELECT a FROM AdModuleLog a WHERE a.adModuleVersionId = :adModuleVersionId"),
    @NamedQuery(name = "AdModuleLog.findByModulename", query = "SELECT a FROM AdModuleLog a WHERE a.modulename = :modulename"),
    @NamedQuery(name = "AdModuleLog.findByLog", query = "SELECT a FROM AdModuleLog a WHERE a.log = :log"),
    @NamedQuery(name = "AdModuleLog.findByAction", query = "SELECT a FROM AdModuleLog a WHERE a.action = :action")})
public class AdModuleLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_log_id")
    private String adModuleLogId;
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
    @Size(max = 32)
    @Column(name = "ad_module_id")
    private String adModuleId;
    @Size(max = 32)
    @Column(name = "ad_module_version_id")
    private String adModuleVersionId;
    @Size(max = 60)
    @Column(name = "modulename")
    private String modulename;
    @Size(max = 2000)
    @Column(name = "log")
    private String log;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "action")
    private String action;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleLog() {
    }

    public AdModuleLog(String adModuleLogId) {
        this.adModuleLogId = adModuleLogId;
    }

    public AdModuleLog(String adModuleLogId, Character isactive, Date created, String createdby, Date updated, String updatedby, String action) {
        this.adModuleLogId = adModuleLogId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.action = action;
    }

    public String getAdModuleLogId() {
        return adModuleLogId;
    }

    public void setAdModuleLogId(String adModuleLogId) {
        this.adModuleLogId = adModuleLogId;
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

    public String getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(String adModuleId) {
        this.adModuleId = adModuleId;
    }

    public String getAdModuleVersionId() {
        return adModuleVersionId;
    }

    public void setAdModuleVersionId(String adModuleVersionId) {
        this.adModuleVersionId = adModuleVersionId;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
        hash += (adModuleLogId != null ? adModuleLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleLog)) {
            return false;
        }
        AdModuleLog other = (AdModuleLog) object;
        if ((this.adModuleLogId == null && other.adModuleLogId != null) || (this.adModuleLogId != null && !this.adModuleLogId.equals(other.adModuleLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleLog[ adModuleLogId=" + adModuleLogId + " ]";
    }
    
}
