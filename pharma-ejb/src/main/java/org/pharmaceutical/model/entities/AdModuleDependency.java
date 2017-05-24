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
@Table(name = "ad_module_dependency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleDependency.findAll", query = "SELECT a FROM AdModuleDependency a"),
    @NamedQuery(name = "AdModuleDependency.findByAdModuleDependencyId", query = "SELECT a FROM AdModuleDependency a WHERE a.adModuleDependencyId = :adModuleDependencyId"),
    @NamedQuery(name = "AdModuleDependency.findByIsactive", query = "SELECT a FROM AdModuleDependency a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleDependency.findByCreated", query = "SELECT a FROM AdModuleDependency a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleDependency.findByCreatedby", query = "SELECT a FROM AdModuleDependency a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleDependency.findByUpdated", query = "SELECT a FROM AdModuleDependency a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleDependency.findByUpdatedby", query = "SELECT a FROM AdModuleDependency a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleDependency.findByStartversion", query = "SELECT a FROM AdModuleDependency a WHERE a.startversion = :startversion"),
    @NamedQuery(name = "AdModuleDependency.findByEndversion", query = "SELECT a FROM AdModuleDependency a WHERE a.endversion = :endversion"),
    @NamedQuery(name = "AdModuleDependency.findByIsincluded", query = "SELECT a FROM AdModuleDependency a WHERE a.isincluded = :isincluded"),
    @NamedQuery(name = "AdModuleDependency.findByDependantModuleName", query = "SELECT a FROM AdModuleDependency a WHERE a.dependantModuleName = :dependantModuleName"),
    @NamedQuery(name = "AdModuleDependency.findByDependencyEnforcement", query = "SELECT a FROM AdModuleDependency a WHERE a.dependencyEnforcement = :dependencyEnforcement"),
    @NamedQuery(name = "AdModuleDependency.findByUserEditableEnforcement", query = "SELECT a FROM AdModuleDependency a WHERE a.userEditableEnforcement = :userEditableEnforcement"),
    @NamedQuery(name = "AdModuleDependency.findByInstanceEnforcement", query = "SELECT a FROM AdModuleDependency a WHERE a.instanceEnforcement = :instanceEnforcement")})
public class AdModuleDependency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_dependency_id")
    private String adModuleDependencyId;
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
    @Size(max = 60)
    @Column(name = "instance_enforcement")
    private String instanceEnforcement;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_dependent_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adDependentModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleDependency() {
    }

    public AdModuleDependency(String adModuleDependencyId) {
        this.adModuleDependencyId = adModuleDependencyId;
    }

    public AdModuleDependency(String adModuleDependencyId, Character isactive, Date created, String createdby, Date updated, String updatedby, String startversion, Character isincluded, String dependencyEnforcement, Character userEditableEnforcement) {
        this.adModuleDependencyId = adModuleDependencyId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.startversion = startversion;
        this.isincluded = isincluded;
        this.dependencyEnforcement = dependencyEnforcement;
        this.userEditableEnforcement = userEditableEnforcement;
    }

    public String getAdModuleDependencyId() {
        return adModuleDependencyId;
    }

    public void setAdModuleDependencyId(String adModuleDependencyId) {
        this.adModuleDependencyId = adModuleDependencyId;
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

    public String getInstanceEnforcement() {
        return instanceEnforcement;
    }

    public void setInstanceEnforcement(String instanceEnforcement) {
        this.instanceEnforcement = instanceEnforcement;
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

    public AdModule getAdDependentModuleId() {
        return adDependentModuleId;
    }

    public void setAdDependentModuleId(AdModule adDependentModuleId) {
        this.adDependentModuleId = adDependentModuleId;
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
        hash += (adModuleDependencyId != null ? adModuleDependencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleDependency)) {
            return false;
        }
        AdModuleDependency other = (AdModuleDependency) object;
        if ((this.adModuleDependencyId == null && other.adModuleDependencyId != null) || (this.adModuleDependencyId != null && !this.adModuleDependencyId.equals(other.adModuleDependencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleDependency[ adModuleDependencyId=" + adModuleDependencyId + " ]";
    }
    
}
