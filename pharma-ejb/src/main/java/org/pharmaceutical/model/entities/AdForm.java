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
@Table(name = "ad_form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdForm.findAll", query = "SELECT a FROM AdForm a"),
    @NamedQuery(name = "AdForm.findByAdFormId", query = "SELECT a FROM AdForm a WHERE a.adFormId = :adFormId"),
    @NamedQuery(name = "AdForm.findByIsactive", query = "SELECT a FROM AdForm a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdForm.findByCreated", query = "SELECT a FROM AdForm a WHERE a.created = :created"),
    @NamedQuery(name = "AdForm.findByCreatedby", query = "SELECT a FROM AdForm a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdForm.findByUpdated", query = "SELECT a FROM AdForm a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdForm.findByUpdatedby", query = "SELECT a FROM AdForm a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdForm.findByName", query = "SELECT a FROM AdForm a WHERE a.name = :name"),
    @NamedQuery(name = "AdForm.findByDescription", query = "SELECT a FROM AdForm a WHERE a.description = :description"),
    @NamedQuery(name = "AdForm.findByHelp", query = "SELECT a FROM AdForm a WHERE a.help = :help"),
    @NamedQuery(name = "AdForm.findByAccesslevel", query = "SELECT a FROM AdForm a WHERE a.accesslevel = :accesslevel"),
    @NamedQuery(name = "AdForm.findByClassname", query = "SELECT a FROM AdForm a WHERE a.classname = :classname")})
public class AdForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_form_id")
    private String adFormId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "classname")
    private String classname;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adFormId")
    private List<AdFormTrl> adFormTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adFormId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adFormId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adFormId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "editreference")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adFormId")
    private List<AdFormAccess> adFormAccessList;

    public AdForm() {
    }

    public AdForm(String adFormId) {
        this.adFormId = adFormId;
    }

    public AdForm(String adFormId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String accesslevel, String classname) {
        this.adFormId = adFormId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.accesslevel = accesslevel;
        this.classname = classname;
    }

    public String getAdFormId() {
        return adFormId;
    }

    public void setAdFormId(String adFormId) {
        this.adFormId = adFormId;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
    public List<AdFormTrl> getAdFormTrlList() {
        return adFormTrlList;
    }

    public void setAdFormTrlList(List<AdFormTrl> adFormTrlList) {
        this.adFormTrlList = adFormTrlList;
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
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdFormAccess> getAdFormAccessList() {
        return adFormAccessList;
    }

    public void setAdFormAccessList(List<AdFormAccess> adFormAccessList) {
        this.adFormAccessList = adFormAccessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adFormId != null ? adFormId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdForm)) {
            return false;
        }
        AdForm other = (AdForm) object;
        if ((this.adFormId == null && other.adFormId != null) || (this.adFormId != null && !this.adFormId.equals(other.adFormId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdForm[ adFormId=" + adFormId + " ]";
    }
    
}
