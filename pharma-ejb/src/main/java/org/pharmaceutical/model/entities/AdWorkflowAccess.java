/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "ad_workflow_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdWorkflowAccess.findAll", query = "SELECT a FROM AdWorkflowAccess a"),
    @NamedQuery(name = "AdWorkflowAccess.findByAdWorkflowAccessId", query = "SELECT a FROM AdWorkflowAccess a WHERE a.adWorkflowAccessId = :adWorkflowAccessId"),
    @NamedQuery(name = "AdWorkflowAccess.findByIsactive", query = "SELECT a FROM AdWorkflowAccess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdWorkflowAccess.findByCreated", query = "SELECT a FROM AdWorkflowAccess a WHERE a.created = :created"),
    @NamedQuery(name = "AdWorkflowAccess.findByCreatedby", query = "SELECT a FROM AdWorkflowAccess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdWorkflowAccess.findByUpdated", query = "SELECT a FROM AdWorkflowAccess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdWorkflowAccess.findByUpdatedby", query = "SELECT a FROM AdWorkflowAccess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdWorkflowAccess.findByIsreadwrite", query = "SELECT a FROM AdWorkflowAccess a WHERE a.isreadwrite = :isreadwrite")})
public class AdWorkflowAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_workflow_access_id")
    private String adWorkflowAccessId;
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
    @Column(name = "isreadwrite")
    private Character isreadwrite;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRole adRoleId;
    @JoinColumn(name = "ad_workflow_id", referencedColumnName = "ad_workflow_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdWorkflow adWorkflowId;

    public AdWorkflowAccess() {
    }

    public AdWorkflowAccess(String adWorkflowAccessId) {
        this.adWorkflowAccessId = adWorkflowAccessId;
    }

    public AdWorkflowAccess(String adWorkflowAccessId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isreadwrite) {
        this.adWorkflowAccessId = adWorkflowAccessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isreadwrite = isreadwrite;
    }

    public String getAdWorkflowAccessId() {
        return adWorkflowAccessId;
    }

    public void setAdWorkflowAccessId(String adWorkflowAccessId) {
        this.adWorkflowAccessId = adWorkflowAccessId;
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

    public Character getIsreadwrite() {
        return isreadwrite;
    }

    public void setIsreadwrite(Character isreadwrite) {
        this.isreadwrite = isreadwrite;
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

    public AdRole getAdRoleId() {
        return adRoleId;
    }

    public void setAdRoleId(AdRole adRoleId) {
        this.adRoleId = adRoleId;
    }

    public AdWorkflow getAdWorkflowId() {
        return adWorkflowId;
    }

    public void setAdWorkflowId(AdWorkflow adWorkflowId) {
        this.adWorkflowId = adWorkflowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adWorkflowAccessId != null ? adWorkflowAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdWorkflowAccess)) {
            return false;
        }
        AdWorkflowAccess other = (AdWorkflowAccess) object;
        if ((this.adWorkflowAccessId == null && other.adWorkflowAccessId != null) || (this.adWorkflowAccessId != null && !this.adWorkflowAccessId.equals(other.adWorkflowAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdWorkflowAccess[ adWorkflowAccessId=" + adWorkflowAccessId + " ]";
    }
    
}
