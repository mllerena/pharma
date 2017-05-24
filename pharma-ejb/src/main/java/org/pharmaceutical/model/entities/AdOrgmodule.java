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
@Table(name = "ad_orgmodule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdOrgmodule.findAll", query = "SELECT a FROM AdOrgmodule a"),
    @NamedQuery(name = "AdOrgmodule.findByAdOrgmoduleId", query = "SELECT a FROM AdOrgmodule a WHERE a.adOrgmoduleId = :adOrgmoduleId"),
    @NamedQuery(name = "AdOrgmodule.findByIsactive", query = "SELECT a FROM AdOrgmodule a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdOrgmodule.findByCreated", query = "SELECT a FROM AdOrgmodule a WHERE a.created = :created"),
    @NamedQuery(name = "AdOrgmodule.findByCreatedby", query = "SELECT a FROM AdOrgmodule a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdOrgmodule.findByUpdated", query = "SELECT a FROM AdOrgmodule a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdOrgmodule.findByUpdatedby", query = "SELECT a FROM AdOrgmodule a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdOrgmodule.findByVersion", query = "SELECT a FROM AdOrgmodule a WHERE a.version = :version"),
    @NamedQuery(name = "AdOrgmodule.findByChecksum", query = "SELECT a FROM AdOrgmodule a WHERE a.checksum = :checksum")})
public class AdOrgmodule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_orgmodule_id")
    private String adOrgmoduleId;
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
    @Column(name = "version")
    private String version;
    @Size(max = 2147483647)
    @Column(name = "checksum")
    private String checksum;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdOrgmodule() {
    }

    public AdOrgmodule(String adOrgmoduleId) {
        this.adOrgmoduleId = adOrgmoduleId;
    }

    public AdOrgmodule(String adOrgmoduleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String version) {
        this.adOrgmoduleId = adOrgmoduleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.version = version;
    }

    public String getAdOrgmoduleId() {
        return adOrgmoduleId;
    }

    public void setAdOrgmoduleId(String adOrgmoduleId) {
        this.adOrgmoduleId = adOrgmoduleId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
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
        hash += (adOrgmoduleId != null ? adOrgmoduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdOrgmodule)) {
            return false;
        }
        AdOrgmodule other = (AdOrgmodule) object;
        if ((this.adOrgmoduleId == null && other.adOrgmoduleId != null) || (this.adOrgmoduleId != null && !this.adOrgmoduleId.equals(other.adOrgmoduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdOrgmodule[ adOrgmoduleId=" + adOrgmoduleId + " ]";
    }
    
}
