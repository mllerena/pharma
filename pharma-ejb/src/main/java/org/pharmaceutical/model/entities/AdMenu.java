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
@Table(name = "ad_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdMenu.findAll", query = "SELECT a FROM AdMenu a"),
    @NamedQuery(name = "AdMenu.findByAdMenuId", query = "SELECT a FROM AdMenu a WHERE a.adMenuId = :adMenuId"),
    @NamedQuery(name = "AdMenu.findByIsactive", query = "SELECT a FROM AdMenu a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdMenu.findByCreated", query = "SELECT a FROM AdMenu a WHERE a.created = :created"),
    @NamedQuery(name = "AdMenu.findByCreatedby", query = "SELECT a FROM AdMenu a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdMenu.findByUpdated", query = "SELECT a FROM AdMenu a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdMenu.findByName", query = "SELECT a FROM AdMenu a WHERE a.name = :name"),
    @NamedQuery(name = "AdMenu.findByUpdatedby", query = "SELECT a FROM AdMenu a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdMenu.findByDescription", query = "SELECT a FROM AdMenu a WHERE a.description = :description"),
    @NamedQuery(name = "AdMenu.findByIssummary", query = "SELECT a FROM AdMenu a WHERE a.issummary = :issummary"),
    @NamedQuery(name = "AdMenu.findByAction", query = "SELECT a FROM AdMenu a WHERE a.action = :action"),
    @NamedQuery(name = "AdMenu.findByUrl", query = "SELECT a FROM AdMenu a WHERE a.url = :url")})
public class AdMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_menu_id")
    private String adMenuId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Size(max = 60)
    @Column(name = "action")
    private String action;
    @Size(max = 4000)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_form_id", referencedColumnName = "ad_form_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdForm adFormId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_task_id", referencedColumnName = "ad_task_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTask adTaskId;
    @JoinColumn(name = "ad_window_id", referencedColumnName = "ad_window_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWindow adWindowId;
    @JoinColumn(name = "ad_workflow_id", referencedColumnName = "ad_workflow_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWorkflow adWorkflowId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adMenuId")
    private List<AdMenuTrl> adMenuTrlList;

    public AdMenu() {
    }

    public AdMenu(String adMenuId) {
        this.adMenuId = adMenuId;
    }

    public AdMenu(String adMenuId, Character isactive, Date created, String createdby, Date updated, String name, String updatedby, Character issummary) {
        this.adMenuId = adMenuId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.name = name;
        this.updatedby = updatedby;
        this.issummary = issummary;
    }

    public String getAdMenuId() {
        return adMenuId;
    }

    public void setAdMenuId(String adMenuId) {
        this.adMenuId = adMenuId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdForm getAdFormId() {
        return adFormId;
    }

    public void setAdFormId(AdForm adFormId) {
        this.adFormId = adFormId;
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

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    public AdTask getAdTaskId() {
        return adTaskId;
    }

    public void setAdTaskId(AdTask adTaskId) {
        this.adTaskId = adTaskId;
    }

    public AdWindow getAdWindowId() {
        return adWindowId;
    }

    public void setAdWindowId(AdWindow adWindowId) {
        this.adWindowId = adWindowId;
    }

    public AdWorkflow getAdWorkflowId() {
        return adWorkflowId;
    }

    public void setAdWorkflowId(AdWorkflow adWorkflowId) {
        this.adWorkflowId = adWorkflowId;
    }

    @XmlTransient
    public List<AdMenuTrl> getAdMenuTrlList() {
        return adMenuTrlList;
    }

    public void setAdMenuTrlList(List<AdMenuTrl> adMenuTrlList) {
        this.adMenuTrlList = adMenuTrlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adMenuId != null ? adMenuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdMenu)) {
            return false;
        }
        AdMenu other = (AdMenu) object;
        if ((this.adMenuId == null && other.adMenuId != null) || (this.adMenuId != null && !this.adMenuId.equals(other.adMenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdMenu[ adMenuId=" + adMenuId + " ]";
    }
    
}
