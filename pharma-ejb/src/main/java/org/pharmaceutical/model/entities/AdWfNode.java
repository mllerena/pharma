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
@Table(name = "ad_wf_node")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdWfNode.findAll", query = "SELECT a FROM AdWfNode a"),
    @NamedQuery(name = "AdWfNode.findByAdWfNodeId", query = "SELECT a FROM AdWfNode a WHERE a.adWfNodeId = :adWfNodeId"),
    @NamedQuery(name = "AdWfNode.findByIsactive", query = "SELECT a FROM AdWfNode a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdWfNode.findByCreated", query = "SELECT a FROM AdWfNode a WHERE a.created = :created"),
    @NamedQuery(name = "AdWfNode.findByCreatedby", query = "SELECT a FROM AdWfNode a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdWfNode.findByUpdated", query = "SELECT a FROM AdWfNode a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdWfNode.findByUpdatedby", query = "SELECT a FROM AdWfNode a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdWfNode.findByName", query = "SELECT a FROM AdWfNode a WHERE a.name = :name"),
    @NamedQuery(name = "AdWfNode.findByDescription", query = "SELECT a FROM AdWfNode a WHERE a.description = :description"),
    @NamedQuery(name = "AdWfNode.findByHelp", query = "SELECT a FROM AdWfNode a WHERE a.help = :help"),
    @NamedQuery(name = "AdWfNode.findByIscentrallymaintained", query = "SELECT a FROM AdWfNode a WHERE a.iscentrallymaintained = :iscentrallymaintained"),
    @NamedQuery(name = "AdWfNode.findByAction", query = "SELECT a FROM AdWfNode a WHERE a.action = :action"),
    @NamedQuery(name = "AdWfNode.findByXposition", query = "SELECT a FROM AdWfNode a WHERE a.xposition = :xposition"),
    @NamedQuery(name = "AdWfNode.findByYposition", query = "SELECT a FROM AdWfNode a WHERE a.yposition = :yposition")})
public class AdWfNode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_wf_node_id")
    private String adWfNodeId;
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
    @Column(name = "iscentrallymaintained")
    private Character iscentrallymaintained;
    @Size(max = 60)
    @Column(name = "action")
    private String action;
    @Column(name = "xposition")
    private Long xposition;
    @Column(name = "yposition")
    private Long yposition;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWfNodeId")
    private List<AdWfNodeTrl> adWfNodeTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_form_id", referencedColumnName = "ad_form_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdForm adFormId;
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
    @JoinColumn(name = "workflow_id", referencedColumnName = "ad_workflow_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWorkflow workflowId;
    @JoinColumn(name = "ad_workflow_id", referencedColumnName = "ad_workflow_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdWorkflow adWorkflowId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWfNodeId")
    private List<AdWfNodenext> adWfNodenextList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWfNextId")
    private List<AdWfNodenext> adWfNodenextList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWfNodeId")
    private List<AdWorkflow> adWorkflowList;

    public AdWfNode() {
    }

    public AdWfNode(String adWfNodeId) {
        this.adWfNodeId = adWfNodeId;
    }

    public AdWfNode(String adWfNodeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character iscentrallymaintained) {
        this.adWfNodeId = adWfNodeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.iscentrallymaintained = iscentrallymaintained;
    }

    public String getAdWfNodeId() {
        return adWfNodeId;
    }

    public void setAdWfNodeId(String adWfNodeId) {
        this.adWfNodeId = adWfNodeId;
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

    public Character getIscentrallymaintained() {
        return iscentrallymaintained;
    }

    public void setIscentrallymaintained(Character iscentrallymaintained) {
        this.iscentrallymaintained = iscentrallymaintained;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getXposition() {
        return xposition;
    }

    public void setXposition(Long xposition) {
        this.xposition = xposition;
    }

    public Long getYposition() {
        return yposition;
    }

    public void setYposition(Long yposition) {
        this.yposition = yposition;
    }

    @XmlTransient
    public List<AdWfNodeTrl> getAdWfNodeTrlList() {
        return adWfNodeTrlList;
    }

    public void setAdWfNodeTrlList(List<AdWfNodeTrl> adWfNodeTrlList) {
        this.adWfNodeTrlList = adWfNodeTrlList;
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

    public AdWorkflow getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(AdWorkflow workflowId) {
        this.workflowId = workflowId;
    }

    public AdWorkflow getAdWorkflowId() {
        return adWorkflowId;
    }

    public void setAdWorkflowId(AdWorkflow adWorkflowId) {
        this.adWorkflowId = adWorkflowId;
    }

    @XmlTransient
    public List<AdWfNodenext> getAdWfNodenextList() {
        return adWfNodenextList;
    }

    public void setAdWfNodenextList(List<AdWfNodenext> adWfNodenextList) {
        this.adWfNodenextList = adWfNodenextList;
    }

    @XmlTransient
    public List<AdWfNodenext> getAdWfNodenextList1() {
        return adWfNodenextList1;
    }

    public void setAdWfNodenextList1(List<AdWfNodenext> adWfNodenextList1) {
        this.adWfNodenextList1 = adWfNodenextList1;
    }

    @XmlTransient
    public List<AdWorkflow> getAdWorkflowList() {
        return adWorkflowList;
    }

    public void setAdWorkflowList(List<AdWorkflow> adWorkflowList) {
        this.adWorkflowList = adWorkflowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adWfNodeId != null ? adWfNodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdWfNode)) {
            return false;
        }
        AdWfNode other = (AdWfNode) object;
        if ((this.adWfNodeId == null && other.adWfNodeId != null) || (this.adWfNodeId != null && !this.adWfNodeId.equals(other.adWfNodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdWfNode[ adWfNodeId=" + adWfNodeId + " ]";
    }
    
}
