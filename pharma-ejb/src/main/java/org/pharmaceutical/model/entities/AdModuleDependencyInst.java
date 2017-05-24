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
@Table(name = "ad_module_dependency_inst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleDependencyInst.findAll", query = "SELECT a FROM AdModuleDependencyInst a"),
    @NamedQuery(name = "AdModuleDependencyInst.findByAdModuleDependencyInstId", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.adModuleDependencyInstId = :adModuleDependencyInstId"),
    @NamedQuery(name = "AdModuleDependencyInst.findByIsactive", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleDependencyInst.findByCreated", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleDependencyInst.findByCreatedby", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleDependencyInst.findByUpdated", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleDependencyInst.findByUpdatedby", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleDependencyInst.findByAdModuleDependencyId", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.adModuleDependencyId = :adModuleDependencyId"),
    @NamedQuery(name = "AdModuleDependencyInst.findByAdModuleId", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.adModuleId = :adModuleId"),
    @NamedQuery(name = "AdModuleDependencyInst.findByAdDependentModuleId", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.adDependentModuleId = :adDependentModuleId"),
    @NamedQuery(name = "AdModuleDependencyInst.findByStartversion", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.startversion = :startversion"),
    @NamedQuery(name = "AdModuleDependencyInst.findByEndversion", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.endversion = :endversion"),
    @NamedQuery(name = "AdModuleDependencyInst.findByIsincluded", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.isincluded = :isincluded"),
    @NamedQuery(name = "AdModuleDependencyInst.findByDependantModuleName", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.dependantModuleName = :dependantModuleName"),
    @NamedQuery(name = "AdModuleDependencyInst.findByDependencyEnforcement", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.dependencyEnforcement = :dependencyEnforcement"),
    @NamedQuery(name = "AdModuleDependencyInst.findByUserEditableEnforcement", query = "SELECT a FROM AdModuleDependencyInst a WHERE a.userEditableEnforcement = :userEditableEnforcement")})
public class AdModuleDependencyInst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_dependency_inst_id")
    private String adModuleDependencyInstId;
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
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_dependency_id")
    private String adModuleDependencyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_id")
    private String adModuleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_dependent_module_id")
    private String adDependentModuleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "startversion")
    private String startversion;
    @Size(max = 10)
    @Column(name = "endversion")
    private String endversion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isincluded")
    private Character isincluded;
    @Size(max = 60)
    @Column(name = "dependant_module_name")
    private String dependantModuleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "dependency_enforcement")
    private String dependencyEnforcement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_editable_enforcement")
    private Character userEditableEnforcement;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleDependencyInst() {
    }

    public AdModuleDependencyInst(String adModuleDependencyInstId) {
        this.adModuleDependencyInstId = adModuleDependencyInstId;
    }

    public AdModuleDependencyInst(String adModuleDependencyInstId, Character isactive, Date created, String createdby, Date updated, String updatedby, String adModuleDependencyId, String adModuleId, String adDependentModuleId, String startversion, Character isincluded, String dependencyEnforcement, Character userEditableEnforcement) {
        this.adModuleDependencyInstId = adModuleDependencyInstId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.adModuleDependencyId = adModuleDependencyId;
        this.adModuleId = adModuleId;
        this.adDependentModuleId = adDependentModuleId;
        this.startversion = startversion;
        this.isincluded = isincluded;
        this.dependencyEnforcement = dependencyEnforcement;
        this.userEditableEnforcement = userEditableEnforcement;
    }

    public String getAdModuleDependencyInstId() {
        return adModuleDependencyInstId;
    }

    public void setAdModuleDependencyInstId(String adModuleDependencyInstId) {
        this.adModuleDependencyInstId = adModuleDependencyInstId;
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

    public String getAdModuleDependencyId() {
        return adModuleDependencyId;
    }

    public void setAdModuleDependencyId(String adModuleDependencyId) {
        this.adModuleDependencyId = adModuleDependencyId;
    }

    public String getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(String adModuleId) {
        this.adModuleId = adModuleId;
    }

    public String getAdDependentModuleId() {
        return adDependentModuleId;
    }

    public void setAdDependentModuleId(String adDependentModuleId) {
        this.adDependentModuleId = adDependentModuleId;
    }

    public String getStartversion() {
        return startversion;
    }

    public void setStartversion(String startversion) {
        this.startversion = startversion;
    }

    public String getEndversion() {
        return endversion;
    }

    public void setEndversion(String endversion) {
        this.endversion = endversion;
    }

    public Character getIsincluded() {
        return isincluded;
    }

    public void setIsincluded(Character isincluded) {
        this.isincluded = isincluded;
    }

    public String getDependantModuleName() {
        return dependantModuleName;
    }

    public void setDependantModuleName(String dependantModuleName) {
        this.dependantModuleName = dependantModuleName;
    }

    public String getDependencyEnforcement() {
        return dependencyEnforcement;
    }

    public void setDependencyEnforcement(String dependencyEnforcement) {
        this.dependencyEnforcement = dependencyEnforcement;
    }

    public Character getUserEditableEnforcement() {
        return userEditableEnforcement;
    }

    public void setUserEditableEnforcement(Character userEditableEnforcement) {
        this.userEditableEnforcement = userEditableEnforcement;
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
        hash += (adModuleDependencyInstId != null ? adModuleDependencyInstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleDependencyInst)) {
            return false;
        }
        AdModuleDependencyInst other = (AdModuleDependencyInst) object;
        if ((this.adModuleDependencyInstId == null && other.adModuleDependencyInstId != null) || (this.adModuleDependencyInstId != null && !this.adModuleDependencyInstId.equals(other.adModuleDependencyInstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleDependencyInst[ adModuleDependencyInstId=" + adModuleDependencyInstId + " ]";
    }
    
}
