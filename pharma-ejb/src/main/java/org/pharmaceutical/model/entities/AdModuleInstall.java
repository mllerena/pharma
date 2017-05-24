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
@Table(name = "ad_module_install")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleInstall.findAll", query = "SELECT a FROM AdModuleInstall a"),
    @NamedQuery(name = "AdModuleInstall.findByAdModuleInstallId", query = "SELECT a FROM AdModuleInstall a WHERE a.adModuleInstallId = :adModuleInstallId"),
    @NamedQuery(name = "AdModuleInstall.findByIsactive", query = "SELECT a FROM AdModuleInstall a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleInstall.findByCreated", query = "SELECT a FROM AdModuleInstall a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleInstall.findByCreatedby", query = "SELECT a FROM AdModuleInstall a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleInstall.findByUpdated", query = "SELECT a FROM AdModuleInstall a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleInstall.findByUpdatedby", query = "SELECT a FROM AdModuleInstall a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleInstall.findByAdModuleId", query = "SELECT a FROM AdModuleInstall a WHERE a.adModuleId = :adModuleId"),
    @NamedQuery(name = "AdModuleInstall.findByName", query = "SELECT a FROM AdModuleInstall a WHERE a.name = :name"),
    @NamedQuery(name = "AdModuleInstall.findByVersion", query = "SELECT a FROM AdModuleInstall a WHERE a.version = :version"),
    @NamedQuery(name = "AdModuleInstall.findByDescription", query = "SELECT a FROM AdModuleInstall a WHERE a.description = :description"),
    @NamedQuery(name = "AdModuleInstall.findByHelp", query = "SELECT a FROM AdModuleInstall a WHERE a.help = :help"),
    @NamedQuery(name = "AdModuleInstall.findByUrl", query = "SELECT a FROM AdModuleInstall a WHERE a.url = :url"),
    @NamedQuery(name = "AdModuleInstall.findByType", query = "SELECT a FROM AdModuleInstall a WHERE a.type = :type"),
    @NamedQuery(name = "AdModuleInstall.findByLicense", query = "SELECT a FROM AdModuleInstall a WHERE a.license = :license"),
    @NamedQuery(name = "AdModuleInstall.findByIsindevelopment", query = "SELECT a FROM AdModuleInstall a WHERE a.isindevelopment = :isindevelopment"),
    @NamedQuery(name = "AdModuleInstall.findByIsdefault", query = "SELECT a FROM AdModuleInstall a WHERE a.isdefault = :isdefault"),
    @NamedQuery(name = "AdModuleInstall.findBySeqno", query = "SELECT a FROM AdModuleInstall a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdModuleInstall.findByJavapackage", query = "SELECT a FROM AdModuleInstall a WHERE a.javapackage = :javapackage"),
    @NamedQuery(name = "AdModuleInstall.findByLicensetype", query = "SELECT a FROM AdModuleInstall a WHERE a.licensetype = :licensetype"),
    @NamedQuery(name = "AdModuleInstall.findByAuthor", query = "SELECT a FROM AdModuleInstall a WHERE a.author = :author"),
    @NamedQuery(name = "AdModuleInstall.findByStatus", query = "SELECT a FROM AdModuleInstall a WHERE a.status = :status"),
    @NamedQuery(name = "AdModuleInstall.findByUpdateAvailable", query = "SELECT a FROM AdModuleInstall a WHERE a.updateAvailable = :updateAvailable"),
    @NamedQuery(name = "AdModuleInstall.findByIstranslationrequired", query = "SELECT a FROM AdModuleInstall a WHERE a.istranslationrequired = :istranslationrequired"),
    @NamedQuery(name = "AdModuleInstall.findByAdLanguage", query = "SELECT a FROM AdModuleInstall a WHERE a.adLanguage = :adLanguage"),
    @NamedQuery(name = "AdModuleInstall.findByHaschartofaccounts", query = "SELECT a FROM AdModuleInstall a WHERE a.haschartofaccounts = :haschartofaccounts"),
    @NamedQuery(name = "AdModuleInstall.findByIstranslationmodule", query = "SELECT a FROM AdModuleInstall a WHERE a.istranslationmodule = :istranslationmodule"),
    @NamedQuery(name = "AdModuleInstall.findByHasreferencedata", query = "SELECT a FROM AdModuleInstall a WHERE a.hasreferencedata = :hasreferencedata"),
    @NamedQuery(name = "AdModuleInstall.findByIsregistered", query = "SELECT a FROM AdModuleInstall a WHERE a.isregistered = :isregistered"),
    @NamedQuery(name = "AdModuleInstall.findByUpdateinfo", query = "SELECT a FROM AdModuleInstall a WHERE a.updateinfo = :updateinfo"),
    @NamedQuery(name = "AdModuleInstall.findByUpdateVerId", query = "SELECT a FROM AdModuleInstall a WHERE a.updateVerId = :updateVerId"),
    @NamedQuery(name = "AdModuleInstall.findByReferencedatainfo", query = "SELECT a FROM AdModuleInstall a WHERE a.referencedatainfo = :referencedatainfo"),
    @NamedQuery(name = "AdModuleInstall.findByVersionLabel", query = "SELECT a FROM AdModuleInstall a WHERE a.versionLabel = :versionLabel"),
    @NamedQuery(name = "AdModuleInstall.findByVersionId", query = "SELECT a FROM AdModuleInstall a WHERE a.versionId = :versionId"),
    @NamedQuery(name = "AdModuleInstall.findByIscommercial", query = "SELECT a FROM AdModuleInstall a WHERE a.iscommercial = :iscommercial"),
    @NamedQuery(name = "AdModuleInstall.findByCommercialTier", query = "SELECT a FROM AdModuleInstall a WHERE a.commercialTier = :commercialTier"),
    @NamedQuery(name = "AdModuleInstall.findByEnabled", query = "SELECT a FROM AdModuleInstall a WHERE a.enabled = :enabled"),
    @NamedQuery(name = "AdModuleInstall.findByIsconfigscriptapplied", query = "SELECT a FROM AdModuleInstall a WHERE a.isconfigscriptapplied = :isconfigscriptapplied")})
public class AdModuleInstall implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_install_id")
    private String adModuleInstallId;
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
    @Column(name = "ad_module_id")
    private String adModuleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 300)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "type")
    private String type;
    @Size(max = 2000)
    @Column(name = "license")
    private String license;
    @Column(name = "isindevelopment")
    private Character isindevelopment;
    @Column(name = "isdefault")
    private Character isdefault;
    @Column(name = "seqno")
    private BigInteger seqno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "javapackage")
    private String javapackage;
    @Size(max = 60)
    @Column(name = "licensetype")
    private String licensetype;
    @Size(max = 2000)
    @Column(name = "author")
    private String author;
    @Size(max = 60)
    @Column(name = "status")
    private String status;
    @Size(max = 10)
    @Column(name = "update_available")
    private String updateAvailable;
    @Column(name = "istranslationrequired")
    private Character istranslationrequired;
    @Size(max = 6)
    @Column(name = "ad_language")
    private String adLanguage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "haschartofaccounts")
    private Character haschartofaccounts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslationmodule")
    private Character istranslationmodule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasreferencedata")
    private Character hasreferencedata;
    @Column(name = "isregistered")
    private Character isregistered;
    @Size(max = 2000)
    @Column(name = "updateinfo")
    private String updateinfo;
    @Size(max = 32)
    @Column(name = "update_ver_id")
    private String updateVerId;
    @Size(max = 2000)
    @Column(name = "referencedatainfo")
    private String referencedatainfo;
    @Size(max = 60)
    @Column(name = "version_label")
    private String versionLabel;
    @Size(max = 60)
    @Column(name = "version_id")
    private String versionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscommercial")
    private Character iscommercial;
    @Size(max = 60)
    @Column(name = "commercial_tier")
    private String commercialTier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private Character enabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isconfigscriptapplied")
    private Character isconfigscriptapplied;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleInstall() {
    }

    public AdModuleInstall(String adModuleInstallId) {
        this.adModuleInstallId = adModuleInstallId;
    }

    public AdModuleInstall(String adModuleInstallId, Character isactive, Date created, String createdby, Date updated, String updatedby, String adModuleId, String name, String version, String description, String type, String javapackage, Character haschartofaccounts, Character istranslationmodule, Character hasreferencedata, Character iscommercial, Character enabled, Character isconfigscriptapplied) {
        this.adModuleInstallId = adModuleInstallId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.adModuleId = adModuleId;
        this.name = name;
        this.version = version;
        this.description = description;
        this.type = type;
        this.javapackage = javapackage;
        this.haschartofaccounts = haschartofaccounts;
        this.istranslationmodule = istranslationmodule;
        this.hasreferencedata = hasreferencedata;
        this.iscommercial = iscommercial;
        this.enabled = enabled;
        this.isconfigscriptapplied = isconfigscriptapplied;
    }

    public String getAdModuleInstallId() {
        return adModuleInstallId;
    }

    public void setAdModuleInstallId(String adModuleInstallId) {
        this.adModuleInstallId = adModuleInstallId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Character getIsindevelopment() {
        return isindevelopment;
    }

    public void setIsindevelopment(Character isindevelopment) {
        this.isindevelopment = isindevelopment;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
    }

    public String getJavapackage() {
        return javapackage;
    }

    public void setJavapackage(String javapackage) {
        this.javapackage = javapackage;
    }

    public String getLicensetype() {
        return licensetype;
    }

    public void setLicensetype(String licensetype) {
        this.licensetype = licensetype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateAvailable() {
        return updateAvailable;
    }

    public void setUpdateAvailable(String updateAvailable) {
        this.updateAvailable = updateAvailable;
    }

    public Character getIstranslationrequired() {
        return istranslationrequired;
    }

    public void setIstranslationrequired(Character istranslationrequired) {
        this.istranslationrequired = istranslationrequired;
    }

    public String getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(String adLanguage) {
        this.adLanguage = adLanguage;
    }

    public Character getHaschartofaccounts() {
        return haschartofaccounts;
    }

    public void setHaschartofaccounts(Character haschartofaccounts) {
        this.haschartofaccounts = haschartofaccounts;
    }

    public Character getIstranslationmodule() {
        return istranslationmodule;
    }

    public void setIstranslationmodule(Character istranslationmodule) {
        this.istranslationmodule = istranslationmodule;
    }

    public Character getHasreferencedata() {
        return hasreferencedata;
    }

    public void setHasreferencedata(Character hasreferencedata) {
        this.hasreferencedata = hasreferencedata;
    }

    public Character getIsregistered() {
        return isregistered;
    }

    public void setIsregistered(Character isregistered) {
        this.isregistered = isregistered;
    }

    public String getUpdateinfo() {
        return updateinfo;
    }

    public void setUpdateinfo(String updateinfo) {
        this.updateinfo = updateinfo;
    }

    public String getUpdateVerId() {
        return updateVerId;
    }

    public void setUpdateVerId(String updateVerId) {
        this.updateVerId = updateVerId;
    }

    public String getReferencedatainfo() {
        return referencedatainfo;
    }

    public void setReferencedatainfo(String referencedatainfo) {
        this.referencedatainfo = referencedatainfo;
    }

    public String getVersionLabel() {
        return versionLabel;
    }

    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Character getIscommercial() {
        return iscommercial;
    }

    public void setIscommercial(Character iscommercial) {
        this.iscommercial = iscommercial;
    }

    public String getCommercialTier() {
        return commercialTier;
    }

    public void setCommercialTier(String commercialTier) {
        this.commercialTier = commercialTier;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public Character getIsconfigscriptapplied() {
        return isconfigscriptapplied;
    }

    public void setIsconfigscriptapplied(Character isconfigscriptapplied) {
        this.isconfigscriptapplied = isconfigscriptapplied;
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
        hash += (adModuleInstallId != null ? adModuleInstallId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleInstall)) {
            return false;
        }
        AdModuleInstall other = (AdModuleInstall) object;
        if ((this.adModuleInstallId == null && other.adModuleInstallId != null) || (this.adModuleInstallId != null && !this.adModuleInstallId.equals(other.adModuleInstallId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleInstall[ adModuleInstallId=" + adModuleInstallId + " ]";
    }
    
}
