/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ad_heartbeat_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdHeartbeatLog.findAll", query = "SELECT a FROM AdHeartbeatLog a"),
    @NamedQuery(name = "AdHeartbeatLog.findByAdHeartbeatLogId", query = "SELECT a FROM AdHeartbeatLog a WHERE a.adHeartbeatLogId = :adHeartbeatLogId"),
    @NamedQuery(name = "AdHeartbeatLog.findByIsactive", query = "SELECT a FROM AdHeartbeatLog a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdHeartbeatLog.findByCreated", query = "SELECT a FROM AdHeartbeatLog a WHERE a.created = :created"),
    @NamedQuery(name = "AdHeartbeatLog.findByCreatedby", query = "SELECT a FROM AdHeartbeatLog a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdHeartbeatLog.findByUpdated", query = "SELECT a FROM AdHeartbeatLog a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdHeartbeatLog.findByUpdatedby", query = "SELECT a FROM AdHeartbeatLog a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdHeartbeatLog.findBySystemIdentifier", query = "SELECT a FROM AdHeartbeatLog a WHERE a.systemIdentifier = :systemIdentifier"),
    @NamedQuery(name = "AdHeartbeatLog.findByIsheartbeatactive", query = "SELECT a FROM AdHeartbeatLog a WHERE a.isheartbeatactive = :isheartbeatactive"),
    @NamedQuery(name = "AdHeartbeatLog.findByIsproxyrequired", query = "SELECT a FROM AdHeartbeatLog a WHERE a.isproxyrequired = :isproxyrequired"),
    @NamedQuery(name = "AdHeartbeatLog.findByProxyServer", query = "SELECT a FROM AdHeartbeatLog a WHERE a.proxyServer = :proxyServer"),
    @NamedQuery(name = "AdHeartbeatLog.findByProxyPort", query = "SELECT a FROM AdHeartbeatLog a WHERE a.proxyPort = :proxyPort"),
    @NamedQuery(name = "AdHeartbeatLog.findByActivityRate", query = "SELECT a FROM AdHeartbeatLog a WHERE a.activityRate = :activityRate"),
    @NamedQuery(name = "AdHeartbeatLog.findByComplexityRate", query = "SELECT a FROM AdHeartbeatLog a WHERE a.complexityRate = :complexityRate"),
    @NamedQuery(name = "AdHeartbeatLog.findByOs", query = "SELECT a FROM AdHeartbeatLog a WHERE a.os = :os"),
    @NamedQuery(name = "AdHeartbeatLog.findByOsVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.osVersion = :osVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByDb", query = "SELECT a FROM AdHeartbeatLog a WHERE a.db = :db"),
    @NamedQuery(name = "AdHeartbeatLog.findByDbVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.dbVersion = :dbVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByServletContainer", query = "SELECT a FROM AdHeartbeatLog a WHERE a.servletContainer = :servletContainer"),
    @NamedQuery(name = "AdHeartbeatLog.findByServletContainerVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.servletContainerVersion = :servletContainerVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByWebserver", query = "SELECT a FROM AdHeartbeatLog a WHERE a.webserver = :webserver"),
    @NamedQuery(name = "AdHeartbeatLog.findByWebserverVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.webserverVersion = :webserverVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByJavaVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.javaVersion = :javaVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByAntVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.antVersion = :antVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByObVersion", query = "SELECT a FROM AdHeartbeatLog a WHERE a.obVersion = :obVersion"),
    @NamedQuery(name = "AdHeartbeatLog.findByObInstallmode", query = "SELECT a FROM AdHeartbeatLog a WHERE a.obInstallmode = :obInstallmode"),
    @NamedQuery(name = "AdHeartbeatLog.findByNumRegisteredUsers", query = "SELECT a FROM AdHeartbeatLog a WHERE a.numRegisteredUsers = :numRegisteredUsers"),
    @NamedQuery(name = "AdHeartbeatLog.findByCodeRevision", query = "SELECT a FROM AdHeartbeatLog a WHERE a.codeRevision = :codeRevision"),
    @NamedQuery(name = "AdHeartbeatLog.findByBeatType", query = "SELECT a FROM AdHeartbeatLog a WHERE a.beatType = :beatType"),
    @NamedQuery(name = "AdHeartbeatLog.findByDbIdentifier", query = "SELECT a FROM AdHeartbeatLog a WHERE a.dbIdentifier = :dbIdentifier"),
    @NamedQuery(name = "AdHeartbeatLog.findByMacIdentifier", query = "SELECT a FROM AdHeartbeatLog a WHERE a.macIdentifier = :macIdentifier"),
    @NamedQuery(name = "AdHeartbeatLog.findByInstalledModules", query = "SELECT a FROM AdHeartbeatLog a WHERE a.installedModules = :installedModules"),
    @NamedQuery(name = "AdHeartbeatLog.findByObpsIdentifier", query = "SELECT a FROM AdHeartbeatLog a WHERE a.obpsIdentifier = :obpsIdentifier"),
    @NamedQuery(name = "AdHeartbeatLog.findByFirstLogin", query = "SELECT a FROM AdHeartbeatLog a WHERE a.firstLogin = :firstLogin"),
    @NamedQuery(name = "AdHeartbeatLog.findByLastLogin", query = "SELECT a FROM AdHeartbeatLog a WHERE a.lastLogin = :lastLogin"),
    @NamedQuery(name = "AdHeartbeatLog.findByTotalLogins", query = "SELECT a FROM AdHeartbeatLog a WHERE a.totalLogins = :totalLogins"),
    @NamedQuery(name = "AdHeartbeatLog.findByTotalLoginsMonth", query = "SELECT a FROM AdHeartbeatLog a WHERE a.totalLoginsMonth = :totalLoginsMonth"),
    @NamedQuery(name = "AdHeartbeatLog.findByAvgConcurrentUsr", query = "SELECT a FROM AdHeartbeatLog a WHERE a.avgConcurrentUsr = :avgConcurrentUsr"),
    @NamedQuery(name = "AdHeartbeatLog.findByUsagePercentage", query = "SELECT a FROM AdHeartbeatLog a WHERE a.usagePercentage = :usagePercentage"),
    @NamedQuery(name = "AdHeartbeatLog.findByMaxConcurrentUsers", query = "SELECT a FROM AdHeartbeatLog a WHERE a.maxConcurrentUsers = :maxConcurrentUsers"),
    @NamedQuery(name = "AdHeartbeatLog.findByClientNumber", query = "SELECT a FROM AdHeartbeatLog a WHERE a.clientNumber = :clientNumber"),
    @NamedQuery(name = "AdHeartbeatLog.findByOrgNumber", query = "SELECT a FROM AdHeartbeatLog a WHERE a.orgNumber = :orgNumber"),
    @NamedQuery(name = "AdHeartbeatLog.findByIsUsageAuditEnabled", query = "SELECT a FROM AdHeartbeatLog a WHERE a.isUsageAuditEnabled = :isUsageAuditEnabled"),
    @NamedQuery(name = "AdHeartbeatLog.findByInstancePurpose", query = "SELECT a FROM AdHeartbeatLog a WHERE a.instancePurpose = :instancePurpose"),
    @NamedQuery(name = "AdHeartbeatLog.findByRejectedLoginsDueConcUsers", query = "SELECT a FROM AdHeartbeatLog a WHERE a.rejectedLoginsDueConcUsers = :rejectedLoginsDueConcUsers"),
    @NamedQuery(name = "AdHeartbeatLog.findByInstanceno", query = "SELECT a FROM AdHeartbeatLog a WHERE a.instanceno = :instanceno"),
    @NamedQuery(name = "AdHeartbeatLog.findByIscustomqueryenabled", query = "SELECT a FROM AdHeartbeatLog a WHERE a.iscustomqueryenabled = :iscustomqueryenabled")})
public class AdHeartbeatLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_heartbeat_log_id")
    private String adHeartbeatLogId;
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
    @Column(name = "system_identifier")
    private String systemIdentifier;
    @Column(name = "isheartbeatactive")
    private Character isheartbeatactive;
    @Column(name = "isproxyrequired")
    private Character isproxyrequired;
    @Size(max = 100)
    @Column(name = "proxy_server")
    private String proxyServer;
    @Column(name = "proxy_port")
    private Long proxyPort;
    @Column(name = "activity_rate")
    private BigInteger activityRate;
    @Column(name = "complexity_rate")
    private BigInteger complexityRate;
    @Size(max = 60)
    @Column(name = "os")
    private String os;
    @Size(max = 100)
    @Column(name = "os_version")
    private String osVersion;
    @Size(max = 20)
    @Column(name = "db")
    private String db;
    @Size(max = 20)
    @Column(name = "db_version")
    private String dbVersion;
    @Size(max = 20)
    @Column(name = "servlet_container")
    private String servletContainer;
    @Size(max = 20)
    @Column(name = "servlet_container_version")
    private String servletContainerVersion;
    @Size(max = 20)
    @Column(name = "webserver")
    private String webserver;
    @Size(max = 20)
    @Column(name = "webserver_version")
    private String webserverVersion;
    @Size(max = 20)
    @Column(name = "java_version")
    private String javaVersion;
    @Size(max = 20)
    @Column(name = "ant_version")
    private String antVersion;
    @Size(max = 20)
    @Column(name = "ob_version")
    private String obVersion;
    @Size(max = 20)
    @Column(name = "ob_installmode")
    private String obInstallmode;
    @Column(name = "num_registered_users")
    private Long numRegisteredUsers;
    @Size(max = 60)
    @Column(name = "code_revision")
    private String codeRevision;
    @Size(max = 60)
    @Column(name = "beat_type")
    private String beatType;
    @Size(max = 10)
    @Column(name = "db_identifier")
    private String dbIdentifier;
    @Size(max = 10)
    @Column(name = "mac_identifier")
    private String macIdentifier;
    @Size(max = 2147483647)
    @Column(name = "installed_modules")
    private String installedModules;
    @Size(max = 10)
    @Column(name = "obps_identifier")
    private String obpsIdentifier;
    @Column(name = "first_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstLogin;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "total_logins")
    private BigInteger totalLogins;
    @Column(name = "total_logins_month")
    private BigInteger totalLoginsMonth;
    @Column(name = "avg_concurrent_usr")
    private BigInteger avgConcurrentUsr;
    @Column(name = "usage_percentage")
    private BigInteger usagePercentage;
    @Column(name = "max_concurrent_users")
    private BigInteger maxConcurrentUsers;
    @Column(name = "client_number")
    private BigInteger clientNumber;
    @Column(name = "org_number")
    private BigInteger orgNumber;
    @Column(name = "is_usage_audit_enabled")
    private Character isUsageAuditEnabled;
    @Size(max = 60)
    @Column(name = "instance_purpose")
    private String instancePurpose;
    @Column(name = "rejected_logins_due_conc_users")
    private BigInteger rejectedLoginsDueConcUsers;
    @Column(name = "instanceno")
    private BigInteger instanceno;
    @Column(name = "iscustomqueryenabled")
    private Character iscustomqueryenabled;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adHeartbeatLogId")
    private List<AdHbLogCquery> adHbLogCqueryList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdHeartbeatLog() {
    }

    public AdHeartbeatLog(String adHeartbeatLogId) {
        this.adHeartbeatLogId = adHeartbeatLogId;
    }

    public AdHeartbeatLog(String adHeartbeatLogId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adHeartbeatLogId = adHeartbeatLogId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdHeartbeatLogId() {
        return adHeartbeatLogId;
    }

    public void setAdHeartbeatLogId(String adHeartbeatLogId) {
        this.adHeartbeatLogId = adHeartbeatLogId;
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

    public String getSystemIdentifier() {
        return systemIdentifier;
    }

    public void setSystemIdentifier(String systemIdentifier) {
        this.systemIdentifier = systemIdentifier;
    }

    public Character getIsheartbeatactive() {
        return isheartbeatactive;
    }

    public void setIsheartbeatactive(Character isheartbeatactive) {
        this.isheartbeatactive = isheartbeatactive;
    }

    public Character getIsproxyrequired() {
        return isproxyrequired;
    }

    public void setIsproxyrequired(Character isproxyrequired) {
        this.isproxyrequired = isproxyrequired;
    }

    public String getProxyServer() {
        return proxyServer;
    }

    public void setProxyServer(String proxyServer) {
        this.proxyServer = proxyServer;
    }

    public Long getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Long proxyPort) {
        this.proxyPort = proxyPort;
    }

    public BigInteger getActivityRate() {
        return activityRate;
    }

    public void setActivityRate(BigInteger activityRate) {
        this.activityRate = activityRate;
    }

    public BigInteger getComplexityRate() {
        return complexityRate;
    }

    public void setComplexityRate(BigInteger complexityRate) {
        this.complexityRate = complexityRate;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getDbVersion() {
        return dbVersion;
    }

    public void setDbVersion(String dbVersion) {
        this.dbVersion = dbVersion;
    }

    public String getServletContainer() {
        return servletContainer;
    }

    public void setServletContainer(String servletContainer) {
        this.servletContainer = servletContainer;
    }

    public String getServletContainerVersion() {
        return servletContainerVersion;
    }

    public void setServletContainerVersion(String servletContainerVersion) {
        this.servletContainerVersion = servletContainerVersion;
    }

    public String getWebserver() {
        return webserver;
    }

    public void setWebserver(String webserver) {
        this.webserver = webserver;
    }

    public String getWebserverVersion() {
        return webserverVersion;
    }

    public void setWebserverVersion(String webserverVersion) {
        this.webserverVersion = webserverVersion;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getAntVersion() {
        return antVersion;
    }

    public void setAntVersion(String antVersion) {
        this.antVersion = antVersion;
    }

    public String getObVersion() {
        return obVersion;
    }

    public void setObVersion(String obVersion) {
        this.obVersion = obVersion;
    }

    public String getObInstallmode() {
        return obInstallmode;
    }

    public void setObInstallmode(String obInstallmode) {
        this.obInstallmode = obInstallmode;
    }

    public Long getNumRegisteredUsers() {
        return numRegisteredUsers;
    }

    public void setNumRegisteredUsers(Long numRegisteredUsers) {
        this.numRegisteredUsers = numRegisteredUsers;
    }

    public String getCodeRevision() {
        return codeRevision;
    }

    public void setCodeRevision(String codeRevision) {
        this.codeRevision = codeRevision;
    }

    public String getBeatType() {
        return beatType;
    }

    public void setBeatType(String beatType) {
        this.beatType = beatType;
    }

    public String getDbIdentifier() {
        return dbIdentifier;
    }

    public void setDbIdentifier(String dbIdentifier) {
        this.dbIdentifier = dbIdentifier;
    }

    public String getMacIdentifier() {
        return macIdentifier;
    }

    public void setMacIdentifier(String macIdentifier) {
        this.macIdentifier = macIdentifier;
    }

    public String getInstalledModules() {
        return installedModules;
    }

    public void setInstalledModules(String installedModules) {
        this.installedModules = installedModules;
    }

    public String getObpsIdentifier() {
        return obpsIdentifier;
    }

    public void setObpsIdentifier(String obpsIdentifier) {
        this.obpsIdentifier = obpsIdentifier;
    }

    public Date getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public BigInteger getTotalLogins() {
        return totalLogins;
    }

    public void setTotalLogins(BigInteger totalLogins) {
        this.totalLogins = totalLogins;
    }

    public BigInteger getTotalLoginsMonth() {
        return totalLoginsMonth;
    }

    public void setTotalLoginsMonth(BigInteger totalLoginsMonth) {
        this.totalLoginsMonth = totalLoginsMonth;
    }

    public BigInteger getAvgConcurrentUsr() {
        return avgConcurrentUsr;
    }

    public void setAvgConcurrentUsr(BigInteger avgConcurrentUsr) {
        this.avgConcurrentUsr = avgConcurrentUsr;
    }

    public BigInteger getUsagePercentage() {
        return usagePercentage;
    }

    public void setUsagePercentage(BigInteger usagePercentage) {
        this.usagePercentage = usagePercentage;
    }

    public BigInteger getMaxConcurrentUsers() {
        return maxConcurrentUsers;
    }

    public void setMaxConcurrentUsers(BigInteger maxConcurrentUsers) {
        this.maxConcurrentUsers = maxConcurrentUsers;
    }

    public BigInteger getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(BigInteger clientNumber) {
        this.clientNumber = clientNumber;
    }

    public BigInteger getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(BigInteger orgNumber) {
        this.orgNumber = orgNumber;
    }

    public Character getIsUsageAuditEnabled() {
        return isUsageAuditEnabled;
    }

    public void setIsUsageAuditEnabled(Character isUsageAuditEnabled) {
        this.isUsageAuditEnabled = isUsageAuditEnabled;
    }

    public String getInstancePurpose() {
        return instancePurpose;
    }

    public void setInstancePurpose(String instancePurpose) {
        this.instancePurpose = instancePurpose;
    }

    public BigInteger getRejectedLoginsDueConcUsers() {
        return rejectedLoginsDueConcUsers;
    }

    public void setRejectedLoginsDueConcUsers(BigInteger rejectedLoginsDueConcUsers) {
        this.rejectedLoginsDueConcUsers = rejectedLoginsDueConcUsers;
    }

    public BigInteger getInstanceno() {
        return instanceno;
    }

    public void setInstanceno(BigInteger instanceno) {
        this.instanceno = instanceno;
    }

    public Character getIscustomqueryenabled() {
        return iscustomqueryenabled;
    }

    public void setIscustomqueryenabled(Character iscustomqueryenabled) {
        this.iscustomqueryenabled = iscustomqueryenabled;
    }

    @XmlTransient
    public List<AdHbLogCquery> getAdHbLogCqueryList() {
        return adHbLogCqueryList;
    }

    public void setAdHbLogCqueryList(List<AdHbLogCquery> adHbLogCqueryList) {
        this.adHbLogCqueryList = adHbLogCqueryList;
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
        hash += (adHeartbeatLogId != null ? adHeartbeatLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdHeartbeatLog)) {
            return false;
        }
        AdHeartbeatLog other = (AdHeartbeatLog) object;
        if ((this.adHeartbeatLogId == null && other.adHeartbeatLogId != null) || (this.adHeartbeatLogId != null && !this.adHeartbeatLogId.equals(other.adHeartbeatLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdHeartbeatLog[ adHeartbeatLogId=" + adHeartbeatLogId + " ]";
    }
    
}
