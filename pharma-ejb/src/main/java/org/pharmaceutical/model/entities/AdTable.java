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
@Table(name = "ad_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTable.findAll", query = "SELECT a FROM AdTable a"),
    @NamedQuery(name = "AdTable.findByAdTableId", query = "SELECT a FROM AdTable a WHERE a.adTableId = :adTableId"),
    @NamedQuery(name = "AdTable.findByIsactive", query = "SELECT a FROM AdTable a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTable.findByCreated", query = "SELECT a FROM AdTable a WHERE a.created = :created"),
    @NamedQuery(name = "AdTable.findByCreatedby", query = "SELECT a FROM AdTable a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTable.findByUpdated", query = "SELECT a FROM AdTable a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTable.findByUpdatedby", query = "SELECT a FROM AdTable a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTable.findByName", query = "SELECT a FROM AdTable a WHERE a.name = :name"),
    @NamedQuery(name = "AdTable.findByDescription", query = "SELECT a FROM AdTable a WHERE a.description = :description"),
    @NamedQuery(name = "AdTable.findByHelp", query = "SELECT a FROM AdTable a WHERE a.help = :help"),
    @NamedQuery(name = "AdTable.findByTablename", query = "SELECT a FROM AdTable a WHERE a.tablename = :tablename"),
    @NamedQuery(name = "AdTable.findByClassname", query = "SELECT a FROM AdTable a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdTable.findByIsview", query = "SELECT a FROM AdTable a WHERE a.isview = :isview"),
    @NamedQuery(name = "AdTable.findByAccesslevel", query = "SELECT a FROM AdTable a WHERE a.accesslevel = :accesslevel"),
    @NamedQuery(name = "AdTable.findByIssecurityenabled", query = "SELECT a FROM AdTable a WHERE a.issecurityenabled = :issecurityenabled"),
    @NamedQuery(name = "AdTable.findByIsdeleteable", query = "SELECT a FROM AdTable a WHERE a.isdeleteable = :isdeleteable"),
    @NamedQuery(name = "AdTable.findByIshighvolume", query = "SELECT a FROM AdTable a WHERE a.ishighvolume = :ishighvolume"),
    @NamedQuery(name = "AdTable.findByImporttable", query = "SELECT a FROM AdTable a WHERE a.importtable = :importtable"),
    @NamedQuery(name = "AdTable.findByIschangelog", query = "SELECT a FROM AdTable a WHERE a.ischangelog = :ischangelog"),
    @NamedQuery(name = "AdTable.findByIsdefaultacct", query = "SELECT a FROM AdTable a WHERE a.isdefaultacct = :isdefaultacct"),
    @NamedQuery(name = "AdTable.findBySqlRecordIdentifier", query = "SELECT a FROM AdTable a WHERE a.sqlRecordIdentifier = :sqlRecordIdentifier"),
    @NamedQuery(name = "AdTable.findByDevelopmentstatus", query = "SELECT a FROM AdTable a WHERE a.developmentstatus = :developmentstatus"),
    @NamedQuery(name = "AdTable.findByTreetype", query = "SELECT a FROM AdTable a WHERE a.treetype = :treetype"),
    @NamedQuery(name = "AdTable.findByAcctclassname", query = "SELECT a FROM AdTable a WHERE a.acctclassname = :acctclassname"),
    @NamedQuery(name = "AdTable.findByIsfullyaudited", query = "SELECT a FROM AdTable a WHERE a.isfullyaudited = :isfullyaudited")})
public class AdTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_table_id")
    private String adTableId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "tablename")
    private String tablename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "classname")
    private String classname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isview")
    private Character isview;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "accesslevel")
    private String accesslevel;
    @Column(name = "issecurityenabled")
    private Character issecurityenabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdeleteable")
    private Character isdeleteable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ishighvolume")
    private Character ishighvolume;
    @Column(name = "importtable")
    private Character importtable;
    @Column(name = "ischangelog")
    private Character ischangelog;
    @Column(name = "isdefaultacct")
    private Character isdefaultacct;
    @Size(max = 4000)
    @Column(name = "sql_record_identifier")
    private String sqlRecordIdentifier;
    @Size(max = 60)
    @Column(name = "developmentstatus")
    private String developmentstatus;
    @Size(max = 60)
    @Column(name = "treetype")
    private String treetype;
    @Size(max = 1000)
    @Column(name = "acctclassname")
    private String acctclassname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfullyaudited")
    private Character isfullyaudited;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdTableAccess> adTableAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTableId")
    private List<CDoctype> cDoctypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdRefSearch> adRefSearchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<CFile> cFileList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdRefTable> adRefTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTableId")
    private List<AdNote> adNoteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdChangelog> adChangelogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdDatasetTable> adDatasetTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTableId")
    private List<AdCreatefactTemplate> adCreatefactTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdTab> adTabList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "acctdate_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdColumn acctdateColumnId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_package_id", referencedColumnName = "ad_package_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdPackage adPackageId;
    @JoinColumn(name = "ad_window_id", referencedColumnName = "ad_window_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWindow adWindowId;
    @JoinColumn(name = "po_window_id", referencedColumnName = "ad_window_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWindow poWindowId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdAttachment> adAttachmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdRefDataLoaded> adRefDataLoadedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<CAcctschemaTable> cAcctschemaTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdImpformat> adImpformatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTableId")
    private List<AdColumnAccess> adColumnAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTableId")
    private List<AdRecordAccess> adRecordAccessList;

    public AdTable() {
    }

    public AdTable(String adTableId) {
        this.adTableId = adTableId;
    }

    public AdTable(String adTableId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String tablename, String classname, Character isview, String accesslevel, Character isdeleteable, Character ishighvolume, Character isfullyaudited) {
        this.adTableId = adTableId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.tablename = tablename;
        this.classname = classname;
        this.isview = isview;
        this.accesslevel = accesslevel;
        this.isdeleteable = isdeleteable;
        this.ishighvolume = ishighvolume;
        this.isfullyaudited = isfullyaudited;
    }

    public String getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(String adTableId) {
        this.adTableId = adTableId;
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

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Character getIsview() {
        return isview;
    }

    public void setIsview(Character isview) {
        this.isview = isview;
    }

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Character getIssecurityenabled() {
        return issecurityenabled;
    }

    public void setIssecurityenabled(Character issecurityenabled) {
        this.issecurityenabled = issecurityenabled;
    }

    public Character getIsdeleteable() {
        return isdeleteable;
    }

    public void setIsdeleteable(Character isdeleteable) {
        this.isdeleteable = isdeleteable;
    }

    public Character getIshighvolume() {
        return ishighvolume;
    }

    public void setIshighvolume(Character ishighvolume) {
        this.ishighvolume = ishighvolume;
    }

    public Character getImporttable() {
        return importtable;
    }

    public void setImporttable(Character importtable) {
        this.importtable = importtable;
    }

    public Character getIschangelog() {
        return ischangelog;
    }

    public void setIschangelog(Character ischangelog) {
        this.ischangelog = ischangelog;
    }

    public Character getIsdefaultacct() {
        return isdefaultacct;
    }

    public void setIsdefaultacct(Character isdefaultacct) {
        this.isdefaultacct = isdefaultacct;
    }

    public String getSqlRecordIdentifier() {
        return sqlRecordIdentifier;
    }

    public void setSqlRecordIdentifier(String sqlRecordIdentifier) {
        this.sqlRecordIdentifier = sqlRecordIdentifier;
    }

    public String getDevelopmentstatus() {
        return developmentstatus;
    }

    public void setDevelopmentstatus(String developmentstatus) {
        this.developmentstatus = developmentstatus;
    }

    public String getTreetype() {
        return treetype;
    }

    public void setTreetype(String treetype) {
        this.treetype = treetype;
    }

    public String getAcctclassname() {
        return acctclassname;
    }

    public void setAcctclassname(String acctclassname) {
        this.acctclassname = acctclassname;
    }

    public Character getIsfullyaudited() {
        return isfullyaudited;
    }

    public void setIsfullyaudited(Character isfullyaudited) {
        this.isfullyaudited = isfullyaudited;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdTableAccess> getAdTableAccessList() {
        return adTableAccessList;
    }

    public void setAdTableAccessList(List<AdTableAccess> adTableAccessList) {
        this.adTableAccessList = adTableAccessList;
    }

    @XmlTransient
    public List<CDoctype> getCDoctypeList() {
        return cDoctypeList;
    }

    public void setCDoctypeList(List<CDoctype> cDoctypeList) {
        this.cDoctypeList = cDoctypeList;
    }

    @XmlTransient
    public List<AdRefSearch> getAdRefSearchList() {
        return adRefSearchList;
    }

    public void setAdRefSearchList(List<AdRefSearch> adRefSearchList) {
        this.adRefSearchList = adRefSearchList;
    }

    @XmlTransient
    public List<CFile> getCFileList() {
        return cFileList;
    }

    public void setCFileList(List<CFile> cFileList) {
        this.cFileList = cFileList;
    }

    @XmlTransient
    public List<AdRefTable> getAdRefTableList() {
        return adRefTableList;
    }

    public void setAdRefTableList(List<AdRefTable> adRefTableList) {
        this.adRefTableList = adRefTableList;
    }

    @XmlTransient
    public List<AdNote> getAdNoteList() {
        return adNoteList;
    }

    public void setAdNoteList(List<AdNote> adNoteList) {
        this.adNoteList = adNoteList;
    }

    @XmlTransient
    public List<AdChangelog> getAdChangelogList() {
        return adChangelogList;
    }

    public void setAdChangelogList(List<AdChangelog> adChangelogList) {
        this.adChangelogList = adChangelogList;
    }

    @XmlTransient
    public List<AdDatasetTable> getAdDatasetTableList() {
        return adDatasetTableList;
    }

    public void setAdDatasetTableList(List<AdDatasetTable> adDatasetTableList) {
        this.adDatasetTableList = adDatasetTableList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<AdCreatefactTemplate> getAdCreatefactTemplateList() {
        return adCreatefactTemplateList;
    }

    public void setAdCreatefactTemplateList(List<AdCreatefactTemplate> adCreatefactTemplateList) {
        this.adCreatefactTemplateList = adCreatefactTemplateList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdColumn getAcctdateColumnId() {
        return acctdateColumnId;
    }

    public void setAcctdateColumnId(AdColumn acctdateColumnId) {
        this.acctdateColumnId = acctdateColumnId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdPackage getAdPackageId() {
        return adPackageId;
    }

    public void setAdPackageId(AdPackage adPackageId) {
        this.adPackageId = adPackageId;
    }

    public AdWindow getAdWindowId() {
        return adWindowId;
    }

    public void setAdWindowId(AdWindow adWindowId) {
        this.adWindowId = adWindowId;
    }

    public AdWindow getPoWindowId() {
        return poWindowId;
    }

    public void setPoWindowId(AdWindow poWindowId) {
        this.poWindowId = poWindowId;
    }

    @XmlTransient
    public List<AdAttachment> getAdAttachmentList() {
        return adAttachmentList;
    }

    public void setAdAttachmentList(List<AdAttachment> adAttachmentList) {
        this.adAttachmentList = adAttachmentList;
    }

    @XmlTransient
    public List<AdRefDataLoaded> getAdRefDataLoadedList() {
        return adRefDataLoadedList;
    }

    public void setAdRefDataLoadedList(List<AdRefDataLoaded> adRefDataLoadedList) {
        this.adRefDataLoadedList = adRefDataLoadedList;
    }

    @XmlTransient
    public List<CAcctschemaTable> getCAcctschemaTableList() {
        return cAcctschemaTableList;
    }

    public void setCAcctschemaTableList(List<CAcctschemaTable> cAcctschemaTableList) {
        this.cAcctschemaTableList = cAcctschemaTableList;
    }

    @XmlTransient
    public List<AdImpformat> getAdImpformatList() {
        return adImpformatList;
    }

    public void setAdImpformatList(List<AdImpformat> adImpformatList) {
        this.adImpformatList = adImpformatList;
    }

    @XmlTransient
    public List<AdColumnAccess> getAdColumnAccessList() {
        return adColumnAccessList;
    }

    public void setAdColumnAccessList(List<AdColumnAccess> adColumnAccessList) {
        this.adColumnAccessList = adColumnAccessList;
    }

    @XmlTransient
    public List<AdRecordAccess> getAdRecordAccessList() {
        return adRecordAccessList;
    }

    public void setAdRecordAccessList(List<AdRecordAccess> adRecordAccessList) {
        this.adRecordAccessList = adRecordAccessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTableId != null ? adTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTable)) {
            return false;
        }
        AdTable other = (AdTable) object;
        if ((this.adTableId == null && other.adTableId != null) || (this.adTableId != null && !this.adTableId.equals(other.adTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTable[ adTableId=" + adTableId + " ]";
    }
    
}
