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
@Table(name = "ad_system_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSystemInfo.findAll", query = "SELECT a FROM AdSystemInfo a"),
    @NamedQuery(name = "AdSystemInfo.findByAdSystemInfoId", query = "SELECT a FROM AdSystemInfo a WHERE a.adSystemInfoId = :adSystemInfoId"),
    @NamedQuery(name = "AdSystemInfo.findByIsactive", query = "SELECT a FROM AdSystemInfo a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdSystemInfo.findByCreated", query = "SELECT a FROM AdSystemInfo a WHERE a.created = :created"),
    @NamedQuery(name = "AdSystemInfo.findByCreatedby", query = "SELECT a FROM AdSystemInfo a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdSystemInfo.findByUpdated", query = "SELECT a FROM AdSystemInfo a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdSystemInfo.findByUpdatedby", query = "SELECT a FROM AdSystemInfo a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdSystemInfo.findBySystemIdentifier", query = "SELECT a FROM AdSystemInfo a WHERE a.systemIdentifier = :systemIdentifier"),
    @NamedQuery(name = "AdSystemInfo.findByIsheartbeatactive", query = "SELECT a FROM AdSystemInfo a WHERE a.isheartbeatactive = :isheartbeatactive"),
    @NamedQuery(name = "AdSystemInfo.findByPostponeDate", query = "SELECT a FROM AdSystemInfo a WHERE a.postponeDate = :postponeDate"),
    @NamedQuery(name = "AdSystemInfo.findByIsproxyrequired", query = "SELECT a FROM AdSystemInfo a WHERE a.isproxyrequired = :isproxyrequired"),
    @NamedQuery(name = "AdSystemInfo.findByProxyServer", query = "SELECT a FROM AdSystemInfo a WHERE a.proxyServer = :proxyServer"),
    @NamedQuery(name = "AdSystemInfo.findByProxyPort", query = "SELECT a FROM AdSystemInfo a WHERE a.proxyPort = :proxyPort"),
    @NamedQuery(name = "AdSystemInfo.findByTestproxy", query = "SELECT a FROM AdSystemInfo a WHERE a.testproxy = :testproxy"),
    @NamedQuery(name = "AdSystemInfo.findByAntVersion", query = "SELECT a FROM AdSystemInfo a WHERE a.antVersion = :antVersion"),
    @NamedQuery(name = "AdSystemInfo.findByObVersion", query = "SELECT a FROM AdSystemInfo a WHERE a.obVersion = :obVersion"),
    @NamedQuery(name = "AdSystemInfo.findByObInstallmode", query = "SELECT a FROM AdSystemInfo a WHERE a.obInstallmode = :obInstallmode"),
    @NamedQuery(name = "AdSystemInfo.findByCodeRevision", query = "SELECT a FROM AdSystemInfo a WHERE a.codeRevision = :codeRevision"),
    @NamedQuery(name = "AdSystemInfo.findByServletContainer", query = "SELECT a FROM AdSystemInfo a WHERE a.servletContainer = :servletContainer"),
    @NamedQuery(name = "AdSystemInfo.findByServletContainerVersion", query = "SELECT a FROM AdSystemInfo a WHERE a.servletContainerVersion = :servletContainerVersion"),
    @NamedQuery(name = "AdSystemInfo.findByWebserver", query = "SELECT a FROM AdSystemInfo a WHERE a.webserver = :webserver"),
    @NamedQuery(name = "AdSystemInfo.findByWebserverVersion", query = "SELECT a FROM AdSystemInfo a WHERE a.webserverVersion = :webserverVersion"),
    @NamedQuery(name = "AdSystemInfo.findByCustomizationAllowed", query = "SELECT a FROM AdSystemInfo a WHERE a.customizationAllowed = :customizationAllowed"),
    @NamedQuery(name = "AdSystemInfo.findByLastBuild", query = "SELECT a FROM AdSystemInfo a WHERE a.lastBuild = :lastBuild"),
    @NamedQuery(name = "AdSystemInfo.findByLastDbupdate", query = "SELECT a FROM AdSystemInfo a WHERE a.lastDbupdate = :lastDbupdate"),
    @NamedQuery(name = "AdSystemInfo.findByDbChecksum", query = "SELECT a FROM AdSystemInfo a WHERE a.dbChecksum = :dbChecksum"),
    @NamedQuery(name = "AdSystemInfo.findBySupportContact", query = "SELECT a FROM AdSystemInfo a WHERE a.supportContact = :supportContact"),
    @NamedQuery(name = "AdSystemInfo.findBySystemStatus", query = "SELECT a FROM AdSystemInfo a WHERE a.systemStatus = :systemStatus"),
    @NamedQuery(name = "AdSystemInfo.findByMaturityUpdate", query = "SELECT a FROM AdSystemInfo a WHERE a.maturityUpdate = :maturityUpdate"),
    @NamedQuery(name = "AdSystemInfo.findByMaturitySearch", query = "SELECT a FROM AdSystemInfo a WHERE a.maturitySearch = :maturitySearch"),
    @NamedQuery(name = "AdSystemInfo.findByIsproxyAuthenticated", query = "SELECT a FROM AdSystemInfo a WHERE a.isproxyAuthenticated = :isproxyAuthenticated"),
    @NamedQuery(name = "AdSystemInfo.findByProxyUser", query = "SELECT a FROM AdSystemInfo a WHERE a.proxyUser = :proxyUser"),
    @NamedQuery(name = "AdSystemInfo.findByProxyPassword", query = "SELECT a FROM AdSystemInfo a WHERE a.proxyPassword = :proxyPassword"),
    @NamedQuery(name = "AdSystemInfo.findByInstancePurpose", query = "SELECT a FROM AdSystemInfo a WHERE a.instancePurpose = :instancePurpose"),
    @NamedQuery(name = "AdSystemInfo.findByIsusageauditenabled", query = "SELECT a FROM AdSystemInfo a WHERE a.isusageauditenabled = :isusageauditenabled"),
    @NamedQuery(name = "AdSystemInfo.findByChangeInstancePurpose", query = "SELECT a FROM AdSystemInfo a WHERE a.changeInstancePurpose = :changeInstancePurpose"),
    @NamedQuery(name = "AdSystemInfo.findByShowCommunityBranding", query = "SELECT a FROM AdSystemInfo a WHERE a.showCommunityBranding = :showCommunityBranding"),
    @NamedQuery(name = "AdSystemInfo.findByShowforgelogo", query = "SELECT a FROM AdSystemInfo a WHERE a.showforgelogo = :showforgelogo"),
    @NamedQuery(name = "AdSystemInfo.findByYourcompanyurl", query = "SELECT a FROM AdSystemInfo a WHERE a.yourcompanyurl = :yourcompanyurl"),
    @NamedQuery(name = "AdSystemInfo.findByIscustomqueryenabled", query = "SELECT a FROM AdSystemInfo a WHERE a.iscustomqueryenabled = :iscustomqueryenabled")})
public class AdSystemInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_system_info_id")
    private String adSystemInfoId;
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
    @Column(name = "postpone_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postponeDate;
    @Column(name = "isproxyrequired")
    private Character isproxyrequired;
    @Size(max = 100)
    @Column(name = "proxy_server")
    private String proxyServer;
    @Column(name = "proxy_port")
    private Long proxyPort;
    @Size(max = 60)
    @Column(name = "testproxy")
    private String testproxy;
    @Size(max = 60)
    @Column(name = "ant_version")
    private String antVersion;
    @Size(max = 20)
    @Column(name = "ob_version")
    private String obVersion;
    @Size(max = 20)
    @Column(name = "ob_installmode")
    private String obInstallmode;
    @Size(max = 60)
    @Column(name = "code_revision")
    private String codeRevision;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "customization_allowed")
    private Character customizationAllowed;
    @Column(name = "last_build")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastBuild;
    @Column(name = "last_dbupdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDbupdate;
    @Size(max = 32)
    @Column(name = "db_checksum")
    private String dbChecksum;
    @Size(max = 200)
    @Column(name = "support_contact")
    private String supportContact;
    @Size(max = 60)
    @Column(name = "system_status")
    private String systemStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "maturity_update")
    private String maturityUpdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "maturity_search")
    private String maturitySearch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isproxy_authenticated")
    private Character isproxyAuthenticated;
    @Size(max = 100)
    @Column(name = "proxy_user")
    private String proxyUser;
    @Size(max = 100)
    @Column(name = "proxy_password")
    private String proxyPassword;
    @Size(max = 60)
    @Column(name = "instance_purpose")
    private String instancePurpose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isusageauditenabled")
    private Character isusageauditenabled;
    @Column(name = "change_instance_purpose")
    private Character changeInstancePurpose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_community_branding")
    private Character showCommunityBranding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showforgelogo")
    private Character showforgelogo;
    @Size(max = 200)
    @Column(name = "yourcompanyurl")
    private String yourcompanyurl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscustomqueryenabled")
    private Character iscustomqueryenabled;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "your_company_menu_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyMenuImage;
    @JoinColumn(name = "your_it_service_login_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourItServiceLoginImage;
    @JoinColumn(name = "your_company_login_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyLoginImage;
    @JoinColumn(name = "production_banner_image_id", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage productionBannerImageId;
    @JoinColumn(name = "your_company_big_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyBigImage;
    @JoinColumn(name = "your_company_document_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyDocumentImage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdSystemInfo() {
    }

    public AdSystemInfo(String adSystemInfoId) {
        this.adSystemInfoId = adSystemInfoId;
    }

    public AdSystemInfo(String adSystemInfoId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character customizationAllowed, String maturityUpdate, String maturitySearch, Character isproxyAuthenticated, Character isusageauditenabled, Character showCommunityBranding, Character showforgelogo, Character iscustomqueryenabled) {
        this.adSystemInfoId = adSystemInfoId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.customizationAllowed = customizationAllowed;
        this.maturityUpdate = maturityUpdate;
        this.maturitySearch = maturitySearch;
        this.isproxyAuthenticated = isproxyAuthenticated;
        this.isusageauditenabled = isusageauditenabled;
        this.showCommunityBranding = showCommunityBranding;
        this.showforgelogo = showforgelogo;
        this.iscustomqueryenabled = iscustomqueryenabled;
    }

    public String getAdSystemInfoId() {
        return adSystemInfoId;
    }

    public void setAdSystemInfoId(String adSystemInfoId) {
        this.adSystemInfoId = adSystemInfoId;
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

    public Date getPostponeDate() {
        return postponeDate;
    }

    public void setPostponeDate(Date postponeDate) {
        this.postponeDate = postponeDate;
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

    public String getTestproxy() {
        return testproxy;
    }

    public void setTestproxy(String testproxy) {
        this.testproxy = testproxy;
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

    public String getCodeRevision() {
        return codeRevision;
    }

    public void setCodeRevision(String codeRevision) {
        this.codeRevision = codeRevision;
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

    public Character getCustomizationAllowed() {
        return customizationAllowed;
    }

    public void setCustomizationAllowed(Character customizationAllowed) {
        this.customizationAllowed = customizationAllowed;
    }

    public Date getLastBuild() {
        return lastBuild;
    }

    public void setLastBuild(Date lastBuild) {
        this.lastBuild = lastBuild;
    }

    public Date getLastDbupdate() {
        return lastDbupdate;
    }

    public void setLastDbupdate(Date lastDbupdate) {
        this.lastDbupdate = lastDbupdate;
    }

    public String getDbChecksum() {
        return dbChecksum;
    }

    public void setDbChecksum(String dbChecksum) {
        this.dbChecksum = dbChecksum;
    }

    public String getSupportContact() {
        return supportContact;
    }

    public void setSupportContact(String supportContact) {
        this.supportContact = supportContact;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getMaturityUpdate() {
        return maturityUpdate;
    }

    public void setMaturityUpdate(String maturityUpdate) {
        this.maturityUpdate = maturityUpdate;
    }

    public String getMaturitySearch() {
        return maturitySearch;
    }

    public void setMaturitySearch(String maturitySearch) {
        this.maturitySearch = maturitySearch;
    }

    public Character getIsproxyAuthenticated() {
        return isproxyAuthenticated;
    }

    public void setIsproxyAuthenticated(Character isproxyAuthenticated) {
        this.isproxyAuthenticated = isproxyAuthenticated;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getInstancePurpose() {
        return instancePurpose;
    }

    public void setInstancePurpose(String instancePurpose) {
        this.instancePurpose = instancePurpose;
    }

    public Character getIsusageauditenabled() {
        return isusageauditenabled;
    }

    public void setIsusageauditenabled(Character isusageauditenabled) {
        this.isusageauditenabled = isusageauditenabled;
    }

    public Character getChangeInstancePurpose() {
        return changeInstancePurpose;
    }

    public void setChangeInstancePurpose(Character changeInstancePurpose) {
        this.changeInstancePurpose = changeInstancePurpose;
    }

    public Character getShowCommunityBranding() {
        return showCommunityBranding;
    }

    public void setShowCommunityBranding(Character showCommunityBranding) {
        this.showCommunityBranding = showCommunityBranding;
    }

    public Character getShowforgelogo() {
        return showforgelogo;
    }

    public void setShowforgelogo(Character showforgelogo) {
        this.showforgelogo = showforgelogo;
    }

    public String getYourcompanyurl() {
        return yourcompanyurl;
    }

    public void setYourcompanyurl(String yourcompanyurl) {
        this.yourcompanyurl = yourcompanyurl;
    }

    public Character getIscustomqueryenabled() {
        return iscustomqueryenabled;
    }

    public void setIscustomqueryenabled(Character iscustomqueryenabled) {
        this.iscustomqueryenabled = iscustomqueryenabled;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdImage getYourCompanyMenuImage() {
        return yourCompanyMenuImage;
    }

    public void setYourCompanyMenuImage(AdImage yourCompanyMenuImage) {
        this.yourCompanyMenuImage = yourCompanyMenuImage;
    }

    public AdImage getYourItServiceLoginImage() {
        return yourItServiceLoginImage;
    }

    public void setYourItServiceLoginImage(AdImage yourItServiceLoginImage) {
        this.yourItServiceLoginImage = yourItServiceLoginImage;
    }

    public AdImage getYourCompanyLoginImage() {
        return yourCompanyLoginImage;
    }

    public void setYourCompanyLoginImage(AdImage yourCompanyLoginImage) {
        this.yourCompanyLoginImage = yourCompanyLoginImage;
    }

    public AdImage getProductionBannerImageId() {
        return productionBannerImageId;
    }

    public void setProductionBannerImageId(AdImage productionBannerImageId) {
        this.productionBannerImageId = productionBannerImageId;
    }

    public AdImage getYourCompanyBigImage() {
        return yourCompanyBigImage;
    }

    public void setYourCompanyBigImage(AdImage yourCompanyBigImage) {
        this.yourCompanyBigImage = yourCompanyBigImage;
    }

    public AdImage getYourCompanyDocumentImage() {
        return yourCompanyDocumentImage;
    }

    public void setYourCompanyDocumentImage(AdImage yourCompanyDocumentImage) {
        this.yourCompanyDocumentImage = yourCompanyDocumentImage;
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
        hash += (adSystemInfoId != null ? adSystemInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdSystemInfo)) {
            return false;
        }
        AdSystemInfo other = (AdSystemInfo) object;
        if ((this.adSystemInfoId == null && other.adSystemInfoId != null) || (this.adSystemInfoId != null && !this.adSystemInfoId.equals(other.adSystemInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdSystemInfo[ adSystemInfoId=" + adSystemInfoId + " ]";
    }
    
}
