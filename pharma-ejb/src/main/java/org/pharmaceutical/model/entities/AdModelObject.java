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
@Table(name = "ad_model_object")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModelObject.findAll", query = "SELECT a FROM AdModelObject a"),
    @NamedQuery(name = "AdModelObject.findByAdModelObjectId", query = "SELECT a FROM AdModelObject a WHERE a.adModelObjectId = :adModelObjectId"),
    @NamedQuery(name = "AdModelObject.findByIsactive", query = "SELECT a FROM AdModelObject a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModelObject.findByCreated", query = "SELECT a FROM AdModelObject a WHERE a.created = :created"),
    @NamedQuery(name = "AdModelObject.findByCreatedby", query = "SELECT a FROM AdModelObject a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModelObject.findByUpdated", query = "SELECT a FROM AdModelObject a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModelObject.findByUpdatedby", query = "SELECT a FROM AdModelObject a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModelObject.findByAction", query = "SELECT a FROM AdModelObject a WHERE a.action = :action"),
    @NamedQuery(name = "AdModelObject.findByClassname", query = "SELECT a FROM AdModelObject a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdModelObject.findByIsdefault", query = "SELECT a FROM AdModelObject a WHERE a.isdefault = :isdefault"),
    @NamedQuery(name = "AdModelObject.findByObjectType", query = "SELECT a FROM AdModelObject a WHERE a.objectType = :objectType"),
    @NamedQuery(name = "AdModelObject.findByLoadonstartup", query = "SELECT a FROM AdModelObject a WHERE a.loadonstartup = :loadonstartup"),
    @NamedQuery(name = "AdModelObject.findBySeqno", query = "SELECT a FROM AdModelObject a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdModelObject.findByName", query = "SELECT a FROM AdModelObject a WHERE a.name = :name")})
public class AdModelObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_model_object_id")
    private String adModelObjectId;
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
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "classname")
    private String classname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Size(max = 60)
    @Column(name = "object_type")
    private String objectType;
    @Column(name = "loadonstartup")
    private Long loadonstartup;
    @Column(name = "seqno")
    private BigInteger seqno;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModelObjectId")
    private List<AdModelObjectPara> adModelObjectParaList;
    @JoinColumn(name = "ad_callout_id", referencedColumnName = "ad_callout_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdCallout adCalloutId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_form_id", referencedColumnName = "ad_form_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdForm adFormId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdReference adReferenceId;
    @JoinColumn(name = "ad_tab_id", referencedColumnName = "ad_tab_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTab adTabId;
    @JoinColumn(name = "ad_task_id", referencedColumnName = "ad_task_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTask adTaskId;
    @JoinColumn(name = "ad_workflow_id", referencedColumnName = "ad_workflow_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWorkflow adWorkflowId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adModelObjectId")
    private List<AdModelObjectMapping> adModelObjectMappingList;

    public AdModelObject() {
    }

    public AdModelObject(String adModelObjectId) {
        this.adModelObjectId = adModelObjectId;
    }

    public AdModelObject(String adModelObjectId, Character isactive, Date created, String createdby, Date updated, String updatedby, String classname, Character isdefault) {
        this.adModelObjectId = adModelObjectId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.classname = classname;
        this.isdefault = isdefault;
    }

    public String getAdModelObjectId() {
        return adModelObjectId;
    }

    public void setAdModelObjectId(String adModelObjectId) {
        this.adModelObjectId = adModelObjectId;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Long getLoadonstartup() {
        return loadonstartup;
    }

    public void setLoadonstartup(Long loadonstartup) {
        this.loadonstartup = loadonstartup;
    }

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<AdModelObjectPara> getAdModelObjectParaList() {
        return adModelObjectParaList;
    }

    public void setAdModelObjectParaList(List<AdModelObjectPara> adModelObjectParaList) {
        this.adModelObjectParaList = adModelObjectParaList;
    }

    public AdCallout getAdCalloutId() {
        return adCalloutId;
    }

    public void setAdCalloutId(AdCallout adCalloutId) {
        this.adCalloutId = adCalloutId;
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

    public AdReference getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(AdReference adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    public AdTab getAdTabId() {
        return adTabId;
    }

    public void setAdTabId(AdTab adTabId) {
        this.adTabId = adTabId;
    }

    public AdTask getAdTaskId() {
        return adTaskId;
    }

    public void setAdTaskId(AdTask adTaskId) {
        this.adTaskId = adTaskId;
    }

    public AdWorkflow getAdWorkflowId() {
        return adWorkflowId;
    }

    public void setAdWorkflowId(AdWorkflow adWorkflowId) {
        this.adWorkflowId = adWorkflowId;
    }

    @XmlTransient
    public List<AdModelObjectMapping> getAdModelObjectMappingList() {
        return adModelObjectMappingList;
    }

    public void setAdModelObjectMappingList(List<AdModelObjectMapping> adModelObjectMappingList) {
        this.adModelObjectMappingList = adModelObjectMappingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adModelObjectId != null ? adModelObjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModelObject)) {
            return false;
        }
        AdModelObject other = (AdModelObject) object;
        if ((this.adModelObjectId == null && other.adModelObjectId != null) || (this.adModelObjectId != null && !this.adModelObjectId.equals(other.adModelObjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModelObject[ adModelObjectId=" + adModelObjectId + " ]";
    }
    
}
