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
@Table(name = "ad_session_usage_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSessionUsageAudit.findAll", query = "SELECT a FROM AdSessionUsageAudit a"),
    @NamedQuery(name = "AdSessionUsageAudit.findByAdSessionUsageAuditId", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.adSessionUsageAuditId = :adSessionUsageAuditId"),
    @NamedQuery(name = "AdSessionUsageAudit.findByIsactive", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdSessionUsageAudit.findByCreated", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.created = :created"),
    @NamedQuery(name = "AdSessionUsageAudit.findByCreatedby", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdSessionUsageAudit.findByUpdated", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdSessionUsageAudit.findByUpdatedby", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdSessionUsageAudit.findByObjectId", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.objectId = :objectId"),
    @NamedQuery(name = "AdSessionUsageAudit.findByCommand", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.command = :command"),
    @NamedQuery(name = "AdSessionUsageAudit.findByClassname", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdSessionUsageAudit.findByObjectType", query = "SELECT a FROM AdSessionUsageAudit a WHERE a.objectType = :objectType")})
public class AdSessionUsageAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_session_usage_audit_id")
    private String adSessionUsageAuditId;
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
    @Size(min = 1, max = 32)
    @Column(name = "object_id")
    private String objectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "command")
    private String command;
    @Size(max = 200)
    @Column(name = "classname")
    private String classname;
    @Size(max = 60)
    @Column(name = "object_type")
    private String objectType;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_session_id", referencedColumnName = "ad_session_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdSession adSessionId;

    public AdSessionUsageAudit() {
    }

    public AdSessionUsageAudit(String adSessionUsageAuditId) {
        this.adSessionUsageAuditId = adSessionUsageAuditId;
    }

    public AdSessionUsageAudit(String adSessionUsageAuditId, Character isactive, Date created, String createdby, Date updated, String updatedby, String objectId, String command) {
        this.adSessionUsageAuditId = adSessionUsageAuditId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.objectId = objectId;
        this.command = command;
    }

    public String getAdSessionUsageAuditId() {
        return adSessionUsageAuditId;
    }

    public void setAdSessionUsageAuditId(String adSessionUsageAuditId) {
        this.adSessionUsageAuditId = adSessionUsageAuditId;
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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdSession getAdSessionId() {
        return adSessionId;
    }

    public void setAdSessionId(AdSession adSessionId) {
        this.adSessionId = adSessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adSessionUsageAuditId != null ? adSessionUsageAuditId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdSessionUsageAudit)) {
            return false;
        }
        AdSessionUsageAudit other = (AdSessionUsageAudit) object;
        if ((this.adSessionUsageAuditId == null && other.adSessionUsageAuditId != null) || (this.adSessionUsageAuditId != null && !this.adSessionUsageAuditId.equals(other.adSessionUsageAuditId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdSessionUsageAudit[ adSessionUsageAuditId=" + adSessionUsageAuditId + " ]";
    }
    
}
