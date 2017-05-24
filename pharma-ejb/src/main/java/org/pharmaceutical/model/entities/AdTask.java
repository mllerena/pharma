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
@Table(name = "ad_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTask.findAll", query = "SELECT a FROM AdTask a"),
    @NamedQuery(name = "AdTask.findByAdTaskId", query = "SELECT a FROM AdTask a WHERE a.adTaskId = :adTaskId"),
    @NamedQuery(name = "AdTask.findByIsactive", query = "SELECT a FROM AdTask a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTask.findByCreated", query = "SELECT a FROM AdTask a WHERE a.created = :created"),
    @NamedQuery(name = "AdTask.findByCreatedby", query = "SELECT a FROM AdTask a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTask.findByUpdated", query = "SELECT a FROM AdTask a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTask.findByUpdatedby", query = "SELECT a FROM AdTask a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTask.findByName", query = "SELECT a FROM AdTask a WHERE a.name = :name"),
    @NamedQuery(name = "AdTask.findByDescription", query = "SELECT a FROM AdTask a WHERE a.description = :description"),
    @NamedQuery(name = "AdTask.findByHelp", query = "SELECT a FROM AdTask a WHERE a.help = :help"),
    @NamedQuery(name = "AdTask.findByAccesslevel", query = "SELECT a FROM AdTask a WHERE a.accesslevel = :accesslevel"),
    @NamedQuery(name = "AdTask.findByOsCommand", query = "SELECT a FROM AdTask a WHERE a.osCommand = :osCommand"),
    @NamedQuery(name = "AdTask.findByClassname", query = "SELECT a FROM AdTask a WHERE a.classname = :classname")})
public class AdTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_task_id")
    private String adTaskId;
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
    @Size(min = 1, max = 60)
    @Column(name = "accesslevel")
    private String accesslevel;
    @Size(max = 2000)
    @Column(name = "os_command")
    private String osCommand;
    @Size(max = 100)
    @Column(name = "classname")
    private String classname;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTaskId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTaskId")
    private List<AdTaskTrl> adTaskTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTaskId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTaskId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTaskId")
    private List<AdTaskAccess> adTaskAccessList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdTask() {
    }

    public AdTask(String adTaskId) {
        this.adTaskId = adTaskId;
    }

    public AdTask(String adTaskId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String accesslevel) {
        this.adTaskId = adTaskId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.accesslevel = accesslevel;
    }

    public String getAdTaskId() {
        return adTaskId;
    }

    public void setAdTaskId(String adTaskId) {
        this.adTaskId = adTaskId;
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

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getOsCommand() {
        return osCommand;
    }

    public void setOsCommand(String osCommand) {
        this.osCommand = osCommand;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @XmlTransient
    public List<AdMenu> getAdMenuList() {
        return adMenuList;
    }

    public void setAdMenuList(List<AdMenu> adMenuList) {
        this.adMenuList = adMenuList;
    }

    @XmlTransient
    public List<AdTaskTrl> getAdTaskTrlList() {
        return adTaskTrlList;
    }

    public void setAdTaskTrlList(List<AdTaskTrl> adTaskTrlList) {
        this.adTaskTrlList = adTaskTrlList;
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
    public List<AdTaskAccess> getAdTaskAccessList() {
        return adTaskAccessList;
    }

    public void setAdTaskAccessList(List<AdTaskAccess> adTaskAccessList) {
        this.adTaskAccessList = adTaskAccessList;
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
        hash += (adTaskId != null ? adTaskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTask)) {
            return false;
        }
        AdTask other = (AdTask) object;
        if ((this.adTaskId == null && other.adTaskId != null) || (this.adTaskId != null && !this.adTaskId.equals(other.adTaskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTask[ adTaskId=" + adTaskId + " ]";
    }
    
}
