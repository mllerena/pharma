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
@Table(name = "ad_workflow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdWorkflow.findAll", query = "SELECT a FROM AdWorkflow a"),
    @NamedQuery(name = "AdWorkflow.findByAdWorkflowId", query = "SELECT a FROM AdWorkflow a WHERE a.adWorkflowId = :adWorkflowId"),
    @NamedQuery(name = "AdWorkflow.findByIsactive", query = "SELECT a FROM AdWorkflow a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdWorkflow.findByCreated", query = "SELECT a FROM AdWorkflow a WHERE a.created = :created"),
    @NamedQuery(name = "AdWorkflow.findByCreatedby", query = "SELECT a FROM AdWorkflow a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdWorkflow.findByUpdated", query = "SELECT a FROM AdWorkflow a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdWorkflow.findByUpdatedby", query = "SELECT a FROM AdWorkflow a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdWorkflow.findByName", query = "SELECT a FROM AdWorkflow a WHERE a.name = :name"),
    @NamedQuery(name = "AdWorkflow.findByDescription", query = "SELECT a FROM AdWorkflow a WHERE a.description = :description"),
    @NamedQuery(name = "AdWorkflow.findByHelp", query = "SELECT a FROM AdWorkflow a WHERE a.help = :help"),
    @NamedQuery(name = "AdWorkflow.findByAccesslevel", query = "SELECT a FROM AdWorkflow a WHERE a.accesslevel = :accesslevel")})
public class AdWorkflow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_workflow_id")
    private String adWorkflowId;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWorkflowId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "workflowId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWorkflowId")
    private List<AdWfNode> adWfNodeList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWorkflowId")
    private List<AdWorkflowTrl> adWorkflowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWorkflowId")
    private List<AdModelObject> adModelObjectList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_wf_node_id", referencedColumnName = "ad_wf_node_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWfNode adWfNodeId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWorkflowId")
    private List<AdWorkflowAccess> adWorkflowAccessList;

    public AdWorkflow() {
    }

    public AdWorkflow(String adWorkflowId) {
        this.adWorkflowId = adWorkflowId;
    }

    public AdWorkflow(String adWorkflowId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String accesslevel) {
        this.adWorkflowId = adWorkflowId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.accesslevel = accesslevel;
    }

    public String getAdWorkflowId() {
        return adWorkflowId;
    }

    public void setAdWorkflowId(String adWorkflowId) {
        this.adWorkflowId = adWorkflowId;
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
    public List<AdWfNode> getAdWfNodeList1() {
        return adWfNodeList1;
    }

    public void setAdWfNodeList1(List<AdWfNode> adWfNodeList1) {
        this.adWfNodeList1 = adWfNodeList1;
    }

    @XmlTransient
    public List<AdWorkflowTrl> getAdWorkflowTrlList() {
        return adWorkflowTrlList;
    }

    public void setAdWorkflowTrlList(List<AdWorkflowTrl> adWorkflowTrlList) {
        this.adWorkflowTrlList = adWorkflowTrlList;
    }

    @XmlTransient
    public List<AdModelObject> getAdModelObjectList() {
        return adModelObjectList;
    }

    public void setAdModelObjectList(List<AdModelObject> adModelObjectList) {
        this.adModelObjectList = adModelObjectList;
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

    public AdWfNode getAdWfNodeId() {
        return adWfNodeId;
    }

    public void setAdWfNodeId(AdWfNode adWfNodeId) {
        this.adWfNodeId = adWfNodeId;
    }

    @XmlTransient
    public List<AdWorkflowAccess> getAdWorkflowAccessList() {
        return adWorkflowAccessList;
    }

    public void setAdWorkflowAccessList(List<AdWorkflowAccess> adWorkflowAccessList) {
        this.adWorkflowAccessList = adWorkflowAccessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adWorkflowId != null ? adWorkflowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdWorkflow)) {
            return false;
        }
        AdWorkflow other = (AdWorkflow) object;
        if ((this.adWorkflowId == null && other.adWorkflowId != null) || (this.adWorkflowId != null && !this.adWorkflowId.equals(other.adWorkflowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdWorkflow[ adWorkflowId=" + adWorkflowId + " ]";
    }
    
}
