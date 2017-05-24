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
import javax.persistence.FetchType;
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
@Table(name = "ad_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSession.findAll", query = "SELECT a FROM AdSession a"),
    @NamedQuery(name = "AdSession.findByAdSessionId", query = "SELECT a FROM AdSession a WHERE a.adSessionId = :adSessionId"),
    @NamedQuery(name = "AdSession.findByIsactive", query = "SELECT a FROM AdSession a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdSession.findByCreated", query = "SELECT a FROM AdSession a WHERE a.created = :created"),
    @NamedQuery(name = "AdSession.findByCreatedby", query = "SELECT a FROM AdSession a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdSession.findByUpdated", query = "SELECT a FROM AdSession a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdSession.findByUpdatedby", query = "SELECT a FROM AdSession a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdSession.findByWebsession", query = "SELECT a FROM AdSession a WHERE a.websession = :websession"),
    @NamedQuery(name = "AdSession.findByRemoteAddr", query = "SELECT a FROM AdSession a WHERE a.remoteAddr = :remoteAddr"),
    @NamedQuery(name = "AdSession.findByRemoteHost", query = "SELECT a FROM AdSession a WHERE a.remoteHost = :remoteHost"),
    @NamedQuery(name = "AdSession.findByProcessed", query = "SELECT a FROM AdSession a WHERE a.processed = :processed"),
    @NamedQuery(name = "AdSession.findBySessionActive", query = "SELECT a FROM AdSession a WHERE a.sessionActive = :sessionActive"),
    @NamedQuery(name = "AdSession.findByServerUrl", query = "SELECT a FROM AdSession a WHERE a.serverUrl = :serverUrl"),
    @NamedQuery(name = "AdSession.findByLastSessionPing", query = "SELECT a FROM AdSession a WHERE a.lastSessionPing = :lastSessionPing"),
    @NamedQuery(name = "AdSession.findByUsername", query = "SELECT a FROM AdSession a WHERE a.username = :username"),
    @NamedQuery(name = "AdSession.findByLoginStatus", query = "SELECT a FROM AdSession a WHERE a.loginStatus = :loginStatus")})
public class AdSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_session_id")
    private String adSessionId;
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
    @Size(max = 40)
    @Column(name = "websession")
    private String websession;
    @Size(max = 60)
    @Column(name = "remote_addr")
    private String remoteAddr;
    @Size(max = 120)
    @Column(name = "remote_host")
    private String remoteHost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "session_active")
    private Character sessionActive;
    @Size(max = 255)
    @Column(name = "server_url")
    private String serverUrl;
    @Column(name = "last_session_ping")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSessionPing;
    @Size(max = 60)
    @Column(name = "username")
    private String username;
    @Size(max = 60)
    @Column(name = "login_status")
    private String loginStatus;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adSessionId")
    private List<AdChangelog> adChangelogList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adSessionId")
    private List<AdSessionUsageAudit> adSessionUsageAuditList;

    public AdSession() {
    }

    public AdSession(String adSessionId) {
        this.adSessionId = adSessionId;
    }

    public AdSession(String adSessionId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character processed, Character sessionActive) {
        this.adSessionId = adSessionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.processed = processed;
        this.sessionActive = sessionActive;
    }

    public String getAdSessionId() {
        return adSessionId;
    }

    public void setAdSessionId(String adSessionId) {
        this.adSessionId = adSessionId;
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

    public String getWebsession() {
        return websession;
    }

    public void setWebsession(String websession) {
        this.websession = websession;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(Character sessionActive) {
        this.sessionActive = sessionActive;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public Date getLastSessionPing() {
        return lastSessionPing;
    }

    public void setLastSessionPing(Date lastSessionPing) {
        this.lastSessionPing = lastSessionPing;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @XmlTransient
    public List<AdChangelog> getAdChangelogList() {
        return adChangelogList;
    }

    public void setAdChangelogList(List<AdChangelog> adChangelogList) {
        this.adChangelogList = adChangelogList;
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
    public List<AdSessionUsageAudit> getAdSessionUsageAuditList() {
        return adSessionUsageAuditList;
    }

    public void setAdSessionUsageAuditList(List<AdSessionUsageAudit> adSessionUsageAuditList) {
        this.adSessionUsageAuditList = adSessionUsageAuditList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adSessionId != null ? adSessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdSession)) {
            return false;
        }
        AdSession other = (AdSession) object;
        if ((this.adSessionId == null && other.adSessionId != null) || (this.adSessionId != null && !this.adSessionId.equals(other.adSessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdSession[ adSessionId=" + adSessionId + " ]";
    }
    
}
