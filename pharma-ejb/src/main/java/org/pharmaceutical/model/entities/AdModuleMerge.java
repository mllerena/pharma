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
@Table(name = "ad_module_merge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleMerge.findAll", query = "SELECT a FROM AdModuleMerge a"),
    @NamedQuery(name = "AdModuleMerge.findByAdModuleMergeId", query = "SELECT a FROM AdModuleMerge a WHERE a.adModuleMergeId = :adModuleMergeId"),
    @NamedQuery(name = "AdModuleMerge.findByIsactive", query = "SELECT a FROM AdModuleMerge a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleMerge.findByCreated", query = "SELECT a FROM AdModuleMerge a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleMerge.findByCreatedby", query = "SELECT a FROM AdModuleMerge a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleMerge.findByUpdated", query = "SELECT a FROM AdModuleMerge a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleMerge.findByUpdatedby", query = "SELECT a FROM AdModuleMerge a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleMerge.findByMergedModuleUuid", query = "SELECT a FROM AdModuleMerge a WHERE a.mergedModuleUuid = :mergedModuleUuid"),
    @NamedQuery(name = "AdModuleMerge.findByMergedModuleName", query = "SELECT a FROM AdModuleMerge a WHERE a.mergedModuleName = :mergedModuleName")})
public class AdModuleMerge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_merge_id")
    private String adModuleMergeId;
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
    @Column(name = "merged_module_uuid")
    private String mergedModuleUuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "merged_module_name")
    private String mergedModuleName;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleMerge() {
    }

    public AdModuleMerge(String adModuleMergeId) {
        this.adModuleMergeId = adModuleMergeId;
    }

    public AdModuleMerge(String adModuleMergeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String mergedModuleUuid, String mergedModuleName) {
        this.adModuleMergeId = adModuleMergeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.mergedModuleUuid = mergedModuleUuid;
        this.mergedModuleName = mergedModuleName;
    }

    public String getAdModuleMergeId() {
        return adModuleMergeId;
    }

    public void setAdModuleMergeId(String adModuleMergeId) {
        this.adModuleMergeId = adModuleMergeId;
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

    public String getMergedModuleUuid() {
        return mergedModuleUuid;
    }

    public void setMergedModuleUuid(String mergedModuleUuid) {
        this.mergedModuleUuid = mergedModuleUuid;
    }

    public String getMergedModuleName() {
        return mergedModuleName;
    }

    public void setMergedModuleName(String mergedModuleName) {
        this.mergedModuleName = mergedModuleName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adModuleMergeId != null ? adModuleMergeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleMerge)) {
            return false;
        }
        AdModuleMerge other = (AdModuleMerge) object;
        if ((this.adModuleMergeId == null && other.adModuleMergeId != null) || (this.adModuleMergeId != null && !this.adModuleMergeId.equals(other.adModuleMergeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleMerge[ adModuleMergeId=" + adModuleMergeId + " ]";
    }
    
}
