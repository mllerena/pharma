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
@Table(name = "ad_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModule.findAll", query = "SELECT a FROM AdModule a"),
    @NamedQuery(name = "AdModule.findByAdModuleId", query = "SELECT a FROM AdModule a WHERE a.adModuleId = :adModuleId"),
    @NamedQuery(name = "AdModule.findByIsactive", query = "SELECT a FROM AdModule a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModule.findByCreated", query = "SELECT a FROM AdModule a WHERE a.created = :created"),
    @NamedQuery(name = "AdModule.findByCreatedby", query = "SELECT a FROM AdModule a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModule.findByUpdated", query = "SELECT a FROM AdModule a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModule.findByUpdatedby", query = "SELECT a FROM AdModule a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModule.findByName", query = "SELECT a FROM AdModule a WHERE a.name = :name"),
    @NamedQuery(name = "AdModule.findByVersion", query = "SELECT a FROM AdModule a WHERE a.version = :version"),
    @NamedQuery(name = "AdModule.findByDescription", query = "SELECT a FROM AdModule a WHERE a.description = :description"),
    @NamedQuery(name = "AdModule.findByHelp", query = "SELECT a FROM AdModule a WHERE a.help = :help"),
    @NamedQuery(name = "AdModule.findByUrl", query = "SELECT a FROM AdModule a WHERE a.url = :url"),
    @NamedQuery(name = "AdModule.findByType", query = "SELECT a FROM AdModule a WHERE a.type = :type"),
    @NamedQuery(name = "AdModule.findByLicense", query = "SELECT a FROM AdModule a WHERE a.license = :license"),
    @NamedQuery(name = "AdModule.findByIsindevelopment", query = "SELECT a FROM AdModule a WHERE a.isindevelopment = :isindevelopment"),
    @NamedQuery(name = "AdModule.findByIsdefault", query = "SELECT a FROM AdModule a WHERE a.isdefault = :isdefault"),
    @NamedQuery(name = "AdModule.findBySeqno", query = "SELECT a FROM AdModule a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdModule.findByJavapackage", query = "SELECT a FROM AdModule a WHERE a.javapackage = :javapackage"),
    @NamedQuery(name = "AdModule.findByLicensetype", query = "SELECT a FROM AdModule a WHERE a.licensetype = :licensetype"),
    @NamedQuery(name = "AdModule.findByAuthor", query = "SELECT a FROM AdModule a WHERE a.author = :author"),
    @NamedQuery(name = "AdModule.findByStatus", query = "SELECT a FROM AdModule a WHERE a.status = :status"),
    @NamedQuery(name = "AdModule.findByUpdateAvailable", query = "SELECT a FROM AdModule a WHERE a.updateAvailable = :updateAvailable"),
    @NamedQuery(name = "AdModule.findByIstranslationrequired", query = "SELECT a FROM AdModule a WHERE a.istranslationrequired = :istranslationrequired"),
    @NamedQuery(name = "AdModule.findByHaschartofaccounts", query = "SELECT a FROM AdModule a WHERE a.haschartofaccounts = :haschartofaccounts"),
    @NamedQuery(name = "AdModule.findByIstranslationmodule", query = "SELECT a FROM AdModule a WHERE a.istranslationmodule = :istranslationmodule"),
    @NamedQuery(name = "AdModule.findByHasreferencedata", query = "SELECT a FROM AdModule a WHERE a.hasreferencedata = :hasreferencedata"),
    @NamedQuery(name = "AdModule.findByIsregistered", query = "SELECT a FROM AdModule a WHERE a.isregistered = :isregistered"),
    @NamedQuery(name = "AdModule.findByUpdateinfo", query = "SELECT a FROM AdModule a WHERE a.updateinfo = :updateinfo"),
    @NamedQuery(name = "AdModule.findByUpdateVerId", query = "SELECT a FROM AdModule a WHERE a.updateVerId = :updateVerId"),
    @NamedQuery(name = "AdModule.findByReferencedatainfo", query = "SELECT a FROM AdModule a WHERE a.referencedatainfo = :referencedatainfo"),
    @NamedQuery(name = "AdModule.findByVersionLabel", query = "SELECT a FROM AdModule a WHERE a.versionLabel = :versionLabel"),
    @NamedQuery(name = "AdModule.findByVersionId", query = "SELECT a FROM AdModule a WHERE a.versionId = :versionId"),
    @NamedQuery(name = "AdModule.findByIscommercial", query = "SELECT a FROM AdModule a WHERE a.iscommercial = :iscommercial"),
    @NamedQuery(name = "AdModule.findByMaturityUpdate", query = "SELECT a FROM AdModule a WHERE a.maturityUpdate = :maturityUpdate"),
    @NamedQuery(name = "AdModule.findByCommercialTier", query = "SELECT a FROM AdModule a WHERE a.commercialTier = :commercialTier"),
    @NamedQuery(name = "AdModule.findByEnabled", query = "SELECT a FROM AdModule a WHERE a.enabled = :enabled"),
    @NamedQuery(name = "AdModule.findByUpgradeAvailable", query = "SELECT a FROM AdModule a WHERE a.upgradeAvailable = :upgradeAvailable"),
    @NamedQuery(name = "AdModule.findByIsconfigscriptapplied", query = "SELECT a FROM AdModule a WHERE a.isconfigscriptapplied = :isconfigscriptapplied")})
public class AdModule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_id")
    private String adModuleId;
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
    @Column(name = "maturity_update")
    private String maturityUpdate;
    @Size(max = 60)
    @Column(name = "commercial_tier")
    private String commercialTier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private Character enabled;
    @Size(max = 4000)
    @Column(name = "upgrade_available")
    private String upgradeAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isconfigscriptapplied")
    private Character isconfigscriptapplied;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdForm> adFormList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdExceptions> adExceptionsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdRefList> adRefListList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdClientmodule> adClientmoduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adModuleId")
    private List<AdPreference> adPreferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdModuleDbprefix> adModuleDbprefixList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdModuleTrl> adModuleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdTextinterfaces> adTextinterfacesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdDataset> adDatasetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdDatasetColumn> adDatasetColumnList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adModuleId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdDatasetTable> adDatasetTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdReference> adReferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdModuleMerge> adModuleMergeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdAuxiliarinput> adAuxiliarinputList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdWorkflow> adWorkflowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdValRule> adValRuleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdModuleDependency> adModuleDependencyList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adDependentModuleId")
    private List<AdModuleDependency> adModuleDependencyList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdExtensionPoints> adExtensionPointsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdElement> adElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adModuleId")
    private List<AdRefDataLoaded> adRefDataLoadedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdOrgmodule> adOrgmoduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdProcess> adProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdEpProcedures> adEpProceduresList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdSessionUsageAudit> adSessionUsageAuditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adModuleId")
    private List<AdPackage> adPackageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdPropertyConfiguration> adPropertyConfigurationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdCallout> adCalloutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdWindow> adWindowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdFieldgroup> adFieldgroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdMessage> adMessageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModuleId")
    private List<AdField> adFieldList;

    public AdModule() {
    }

    public AdModule(String adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdModule(String adModuleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String version, String description, String type, String javapackage, Character haschartofaccounts, Character istranslationmodule, Character hasreferencedata, Character iscommercial, Character enabled, Character isconfigscriptapplied) {
        this.adModuleId = adModuleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public String getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(String adModuleId) {
        this.adModuleId = adModuleId;
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

    public String getMaturityUpdate() {
        return maturityUpdate;
    }

    public void setMaturityUpdate(String maturityUpdate) {
        this.maturityUpdate = maturityUpdate;
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

    public String getUpgradeAvailable() {
        return upgradeAvailable;
    }

    public void setUpgradeAvailable(String upgradeAvailable) {
        this.upgradeAvailable = upgradeAvailable;
    }

    public Character getIsconfigscriptapplied() {
        return isconfigscriptapplied;
    }

    public void setIsconfigscriptapplied(Character isconfigscriptapplied) {
        this.isconfigscriptapplied = isconfigscriptapplied;
    }

    @XmlTransient
    public List<AdForm> getAdFormList() {
        return adFormList;
    }

    public void setAdFormList(List<AdForm> adFormList) {
        this.adFormList = adFormList;
    }

    @XmlTransient
    public List<AdExceptions> getAdExceptionsList() {
        return adExceptionsList;
    }

    public void setAdExceptionsList(List<AdExceptions> adExceptionsList) {
        this.adExceptionsList = adExceptionsList;
    }

    @XmlTransient
    public List<AdRefList> getAdRefListList() {
        return adRefListList;
    }

    public void setAdRefListList(List<AdRefList> adRefListList) {
        this.adRefListList = adRefListList;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdClientmodule> getAdClientmoduleList() {
        return adClientmoduleList;
    }

    public void setAdClientmoduleList(List<AdClientmodule> adClientmoduleList) {
        this.adClientmoduleList = adClientmoduleList;
    }

    @XmlTransient
    public List<AdPreference> getAdPreferenceList() {
        return adPreferenceList;
    }

    public void setAdPreferenceList(List<AdPreference> adPreferenceList) {
        this.adPreferenceList = adPreferenceList;
    }

    @XmlTransient
    public List<AdMenu> getAdMenuList() {
        return adMenuList;
    }

    public void setAdMenuList(List<AdMenu> adMenuList) {
        this.adMenuList = adMenuList;
    }

    @XmlTransient
    public List<AdModuleDbprefix> getAdModuleDbprefixList() {
        return adModuleDbprefixList;
    }

    public void setAdModuleDbprefixList(List<AdModuleDbprefix> adModuleDbprefixList) {
        this.adModuleDbprefixList = adModuleDbprefixList;
    }

    @XmlTransient
    public List<AdModuleTrl> getAdModuleTrlList() {
        return adModuleTrlList;
    }

    public void setAdModuleTrlList(List<AdModuleTrl> adModuleTrlList) {
        this.adModuleTrlList = adModuleTrlList;
    }

    @XmlTransient
    public List<AdTextinterfaces> getAdTextinterfacesList() {
        return adTextinterfacesList;
    }

    public void setAdTextinterfacesList(List<AdTextinterfaces> adTextinterfacesList) {
        this.adTextinterfacesList = adTextinterfacesList;
    }

    @XmlTransient
    public List<AdDataset> getAdDatasetList() {
        return adDatasetList;
    }

    public void setAdDatasetList(List<AdDataset> adDatasetList) {
        this.adDatasetList = adDatasetList;
    }

    @XmlTransient
    public List<AdDatasetColumn> getAdDatasetColumnList() {
        return adDatasetColumnList;
    }

    public void setAdDatasetColumnList(List<AdDatasetColumn> adDatasetColumnList) {
        this.adDatasetColumnList = adDatasetColumnList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdLanguage getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(AdLanguage adLanguage) {
        this.adLanguage = adLanguage;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @XmlTransient
    public List<AdModelObject> getAdModelObjectList() {
        return adModelObjectList;
    }

    public void setAdModelObjectList(List<AdModelObject> adModelObjectList) {
        this.adModelObjectList = adModelObjectList;
    }

    @XmlTransient
    public List<AdDatasetTable> getAdDatasetTableList() {
        return adDatasetTableList;
    }

    public void setAdDatasetTableList(List<AdDatasetTable> adDatasetTableList) {
        this.adDatasetTableList = adDatasetTableList;
    }

    @XmlTransient
    public List<AdReference> getAdReferenceList() {
        return adReferenceList;
    }

    public void setAdReferenceList(List<AdReference> adReferenceList) {
        this.adReferenceList = adReferenceList;
    }

    @XmlTransient
    public List<AdModuleMerge> getAdModuleMergeList() {
        return adModuleMergeList;
    }

    public void setAdModuleMergeList(List<AdModuleMerge> adModuleMergeList) {
        this.adModuleMergeList = adModuleMergeList;
    }

    @XmlTransient
    public List<AdAuxiliarinput> getAdAuxiliarinputList() {
        return adAuxiliarinputList;
    }

    public void setAdAuxiliarinputList(List<AdAuxiliarinput> adAuxiliarinputList) {
        this.adAuxiliarinputList = adAuxiliarinputList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdWorkflow> getAdWorkflowList() {
        return adWorkflowList;
    }

    public void setAdWorkflowList(List<AdWorkflow> adWorkflowList) {
        this.adWorkflowList = adWorkflowList;
    }

    @XmlTransient
    public List<AdValRule> getAdValRuleList() {
        return adValRuleList;
    }

    public void setAdValRuleList(List<AdValRule> adValRuleList) {
        this.adValRuleList = adValRuleList;
    }

    @XmlTransient
    public List<AdModuleDependency> getAdModuleDependencyList() {
        return adModuleDependencyList;
    }

    public void setAdModuleDependencyList(List<AdModuleDependency> adModuleDependencyList) {
        this.adModuleDependencyList = adModuleDependencyList;
    }

    @XmlTransient
    public List<AdModuleDependency> getAdModuleDependencyList1() {
        return adModuleDependencyList1;
    }

    public void setAdModuleDependencyList1(List<AdModuleDependency> adModuleDependencyList1) {
        this.adModuleDependencyList1 = adModuleDependencyList1;
    }

    @XmlTransient
    public List<AdExtensionPoints> getAdExtensionPointsList() {
        return adExtensionPointsList;
    }

    public void setAdExtensionPointsList(List<AdExtensionPoints> adExtensionPointsList) {
        this.adExtensionPointsList = adExtensionPointsList;
    }

    @XmlTransient
    public List<AdElement> getAdElementList() {
        return adElementList;
    }

    public void setAdElementList(List<AdElement> adElementList) {
        this.adElementList = adElementList;
    }

    @XmlTransient
    public List<AdRefDataLoaded> getAdRefDataLoadedList() {
        return adRefDataLoadedList;
    }

    public void setAdRefDataLoadedList(List<AdRefDataLoaded> adRefDataLoadedList) {
        this.adRefDataLoadedList = adRefDataLoadedList;
    }

    @XmlTransient
    public List<AdOrgmodule> getAdOrgmoduleList() {
        return adOrgmoduleList;
    }

    public void setAdOrgmoduleList(List<AdOrgmodule> adOrgmoduleList) {
        this.adOrgmoduleList = adOrgmoduleList;
    }

    @XmlTransient
    public List<AdProcess> getAdProcessList() {
        return adProcessList;
    }

    public void setAdProcessList(List<AdProcess> adProcessList) {
        this.adProcessList = adProcessList;
    }

    @XmlTransient
    public List<AdEpProcedures> getAdEpProceduresList() {
        return adEpProceduresList;
    }

    public void setAdEpProceduresList(List<AdEpProcedures> adEpProceduresList) {
        this.adEpProceduresList = adEpProceduresList;
    }

    @XmlTransient
    public List<AdSessionUsageAudit> getAdSessionUsageAuditList() {
        return adSessionUsageAuditList;
    }

    public void setAdSessionUsageAuditList(List<AdSessionUsageAudit> adSessionUsageAuditList) {
        this.adSessionUsageAuditList = adSessionUsageAuditList;
    }

    @XmlTransient
    public List<AdPackage> getAdPackageList() {
        return adPackageList;
    }

    public void setAdPackageList(List<AdPackage> adPackageList) {
        this.adPackageList = adPackageList;
    }

    @XmlTransient
    public List<AdPropertyConfiguration> getAdPropertyConfigurationList() {
        return adPropertyConfigurationList;
    }

    public void setAdPropertyConfigurationList(List<AdPropertyConfiguration> adPropertyConfigurationList) {
        this.adPropertyConfigurationList = adPropertyConfigurationList;
    }

    @XmlTransient
    public List<AdCallout> getAdCalloutList() {
        return adCalloutList;
    }

    public void setAdCalloutList(List<AdCallout> adCalloutList) {
        this.adCalloutList = adCalloutList;
    }

    @XmlTransient
    public List<AdWindow> getAdWindowList() {
        return adWindowList;
    }

    public void setAdWindowList(List<AdWindow> adWindowList) {
        this.adWindowList = adWindowList;
    }

    @XmlTransient
    public List<AdFieldgroup> getAdFieldgroupList() {
        return adFieldgroupList;
    }

    public void setAdFieldgroupList(List<AdFieldgroup> adFieldgroupList) {
        this.adFieldgroupList = adFieldgroupList;
    }

    @XmlTransient
    public List<AdMessage> getAdMessageList() {
        return adMessageList;
    }

    public void setAdMessageList(List<AdMessage> adMessageList) {
        this.adMessageList = adMessageList;
    }

    @XmlTransient
    public List<AdField> getAdFieldList() {
        return adFieldList;
    }

    public void setAdFieldList(List<AdField> adFieldList) {
        this.adFieldList = adFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adModuleId != null ? adModuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModule)) {
            return false;
        }
        AdModule other = (AdModule) object;
        if ((this.adModuleId == null && other.adModuleId != null) || (this.adModuleId != null && !this.adModuleId.equals(other.adModuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModule[ adModuleId=" + adModuleId + " ]";
    }
    
}
