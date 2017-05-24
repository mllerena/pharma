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
@Table(name = "ad_process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcess.findAll", query = "SELECT a FROM AdProcess a"),
    @NamedQuery(name = "AdProcess.findByAdProcessId", query = "SELECT a FROM AdProcess a WHERE a.adProcessId = :adProcessId"),
    @NamedQuery(name = "AdProcess.findByIsactive", query = "SELECT a FROM AdProcess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcess.findByCreated", query = "SELECT a FROM AdProcess a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcess.findByCreatedby", query = "SELECT a FROM AdProcess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcess.findByUpdated", query = "SELECT a FROM AdProcess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcess.findByUpdatedby", query = "SELECT a FROM AdProcess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcess.findByValue", query = "SELECT a FROM AdProcess a WHERE a.value = :value"),
    @NamedQuery(name = "AdProcess.findByName", query = "SELECT a FROM AdProcess a WHERE a.name = :name"),
    @NamedQuery(name = "AdProcess.findByDescription", query = "SELECT a FROM AdProcess a WHERE a.description = :description"),
    @NamedQuery(name = "AdProcess.findByHelp", query = "SELECT a FROM AdProcess a WHERE a.help = :help"),
    @NamedQuery(name = "AdProcess.findByAccesslevel", query = "SELECT a FROM AdProcess a WHERE a.accesslevel = :accesslevel"),
    @NamedQuery(name = "AdProcess.findByIsuserstartable", query = "SELECT a FROM AdProcess a WHERE a.isuserstartable = :isuserstartable"),
    @NamedQuery(name = "AdProcess.findByProcedurename", query = "SELECT a FROM AdProcess a WHERE a.procedurename = :procedurename"),
    @NamedQuery(name = "AdProcess.findByIsreport", query = "SELECT a FROM AdProcess a WHERE a.isreport = :isreport"),
    @NamedQuery(name = "AdProcess.findByIsdirectprint", query = "SELECT a FROM AdProcess a WHERE a.isdirectprint = :isdirectprint"),
    @NamedQuery(name = "AdProcess.findByClassname", query = "SELECT a FROM AdProcess a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdProcess.findByIsbackground", query = "SELECT a FROM AdProcess a WHERE a.isbackground = :isbackground"),
    @NamedQuery(name = "AdProcess.findByIsjasper", query = "SELECT a FROM AdProcess a WHERE a.isjasper = :isjasper"),
    @NamedQuery(name = "AdProcess.findByJrname", query = "SELECT a FROM AdProcess a WHERE a.jrname = :jrname"),
    @NamedQuery(name = "AdProcess.findByServiceType", query = "SELECT a FROM AdProcess a WHERE a.serviceType = :serviceType"),
    @NamedQuery(name = "AdProcess.findByIsexternalservice", query = "SELECT a FROM AdProcess a WHERE a.isexternalservice = :isexternalservice"),
    @NamedQuery(name = "AdProcess.findByServiceSource", query = "SELECT a FROM AdProcess a WHERE a.serviceSource = :serviceSource"),
    @NamedQuery(name = "AdProcess.findByUipattern", query = "SELECT a FROM AdProcess a WHERE a.uipattern = :uipattern")})
public class AdProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_id")
    private String adProcessId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
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
    @Size(min = 1, max = 60)
    @Column(name = "accesslevel")
    private String accesslevel;
    @Column(name = "isuserstartable")
    private Character isuserstartable;
    @Size(max = 60)
    @Column(name = "procedurename")
    private String procedurename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isreport")
    private Character isreport;
    @Column(name = "isdirectprint")
    private Character isdirectprint;
    @Size(max = 200)
    @Column(name = "classname")
    private String classname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbackground")
    private Character isbackground;
    @Column(name = "isjasper")
    private Character isjasper;
    @Size(max = 256)
    @Column(name = "jrname")
    private String jrname;
    @Size(max = 60)
    @Column(name = "service_type")
    private String serviceType;
    @Column(name = "isexternalservice")
    private Character isexternalservice;
    @Size(max = 2000)
    @Column(name = "service_source")
    private String serviceSource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "uipattern")
    private String uipattern;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdProcessScheduling> adProcessSchedulingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adProcessId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adProcessId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adProcessId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adProcessId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdDimension> adDimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdPinstance> adPinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adProcessId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdProcessPara> adProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdProcessAccess> adProcessAccessList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdProcessTrl> adProcessTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessId")
    private List<AdProcessRequest> adProcessRequestList;

    public AdProcess() {
    }

    public AdProcess(String adProcessId) {
        this.adProcessId = adProcessId;
    }

    public AdProcess(String adProcessId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, String accesslevel, Character isreport, Character isbackground, String uipattern) {
        this.adProcessId = adProcessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.accesslevel = accesslevel;
        this.isreport = isreport;
        this.isbackground = isbackground;
        this.uipattern = uipattern;
    }

    public String getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(String adProcessId) {
        this.adProcessId = adProcessId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Character getIsuserstartable() {
        return isuserstartable;
    }

    public void setIsuserstartable(Character isuserstartable) {
        this.isuserstartable = isuserstartable;
    }

    public String getProcedurename() {
        return procedurename;
    }

    public void setProcedurename(String procedurename) {
        this.procedurename = procedurename;
    }

    public Character getIsreport() {
        return isreport;
    }

    public void setIsreport(Character isreport) {
        this.isreport = isreport;
    }

    public Character getIsdirectprint() {
        return isdirectprint;
    }

    public void setIsdirectprint(Character isdirectprint) {
        this.isdirectprint = isdirectprint;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Character getIsbackground() {
        return isbackground;
    }

    public void setIsbackground(Character isbackground) {
        this.isbackground = isbackground;
    }

    public Character getIsjasper() {
        return isjasper;
    }

    public void setIsjasper(Character isjasper) {
        this.isjasper = isjasper;
    }

    public String getJrname() {
        return jrname;
    }

    public void setJrname(String jrname) {
        this.jrname = jrname;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Character getIsexternalservice() {
        return isexternalservice;
    }

    public void setIsexternalservice(Character isexternalservice) {
        this.isexternalservice = isexternalservice;
    }

    public String getServiceSource() {
        return serviceSource;
    }

    public void setServiceSource(String serviceSource) {
        this.serviceSource = serviceSource;
    }

    public String getUipattern() {
        return uipattern;
    }

    public void setUipattern(String uipattern) {
        this.uipattern = uipattern;
    }

    @XmlTransient
    public List<AdProcessScheduling> getAdProcessSchedulingList() {
        return adProcessSchedulingList;
    }

    public void setAdProcessSchedulingList(List<AdProcessScheduling> adProcessSchedulingList) {
        this.adProcessSchedulingList = adProcessSchedulingList;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdMenu> getAdMenuList() {
        return adMenuList;
    }

    public void setAdMenuList(List<AdMenu> adMenuList) {
        this.adMenuList = adMenuList;
    }

    @XmlTransient
    public List<AdWfNode> getAdWfNodeList() {
        return adWfNodeList;
    }

    public void setAdWfNodeList(List<AdWfNode> adWfNodeList) {
        this.adWfNodeList = adWfNodeList;
    }

    @XmlTransient
    public List<AdModelObject> getAdModelObjectList() {
        return adModelObjectList;
    }

    public void setAdModelObjectList(List<AdModelObject> adModelObjectList) {
        this.adModelObjectList = adModelObjectList;
    }

    @XmlTransient
    public List<AdDimension> getAdDimensionList() {
        return adDimensionList;
    }

    public void setAdDimensionList(List<AdDimension> adDimensionList) {
        this.adDimensionList = adDimensionList;
    }

    @XmlTransient
    public List<AdPinstance> getAdPinstanceList() {
        return adPinstanceList;
    }

    public void setAdPinstanceList(List<AdPinstance> adPinstanceList) {
        this.adPinstanceList = adPinstanceList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdProcessPara> getAdProcessParaList() {
        return adProcessParaList;
    }

    public void setAdProcessParaList(List<AdProcessPara> adProcessParaList) {
        this.adProcessParaList = adProcessParaList;
    }

    @XmlTransient
    public List<AdProcessAccess> getAdProcessAccessList() {
        return adProcessAccessList;
    }

    public void setAdProcessAccessList(List<AdProcessAccess> adProcessAccessList) {
        this.adProcessAccessList = adProcessAccessList;
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

    @XmlTransient
    public List<AdProcessTrl> getAdProcessTrlList() {
        return adProcessTrlList;
    }

    public void setAdProcessTrlList(List<AdProcessTrl> adProcessTrlList) {
        this.adProcessTrlList = adProcessTrlList;
    }

    @XmlTransient
    public List<AdProcessRequest> getAdProcessRequestList() {
        return adProcessRequestList;
    }

    public void setAdProcessRequestList(List<AdProcessRequest> adProcessRequestList) {
        this.adProcessRequestList = adProcessRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adProcessId != null ? adProcessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcess)) {
            return false;
        }
        AdProcess other = (AdProcess) object;
        if ((this.adProcessId == null && other.adProcessId != null) || (this.adProcessId != null && !this.adProcessId.equals(other.adProcessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcess[ adProcessId=" + adProcessId + " ]";
    }
    
}
