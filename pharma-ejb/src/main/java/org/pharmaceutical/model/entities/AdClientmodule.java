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
@Table(name = "ad_clientmodule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdClientmodule.findAll", query = "SELECT a FROM AdClientmodule a"),
    @NamedQuery(name = "AdClientmodule.findByAdClientmoduleId", query = "SELECT a FROM AdClientmodule a WHERE a.adClientmoduleId = :adClientmoduleId"),
    @NamedQuery(name = "AdClientmodule.findByIsactive", query = "SELECT a FROM AdClientmodule a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdClientmodule.findByCreated", query = "SELECT a FROM AdClientmodule a WHERE a.created = :created"),
    @NamedQuery(name = "AdClientmodule.findByCreatedby", query = "SELECT a FROM AdClientmodule a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdClientmodule.findByUpdated", query = "SELECT a FROM AdClientmodule a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdClientmodule.findByUpdatedby", query = "SELECT a FROM AdClientmodule a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdClientmodule.findByVersion", query = "SELECT a FROM AdClientmodule a WHERE a.version = :version")})
public class AdClientmodule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_clientmodule_id")
    private String adClientmoduleId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdClientmodule() {
    }

    public AdClientmodule(String adClientmoduleId) {
        this.adClientmoduleId = adClientmoduleId;
    }

    public AdClientmodule(String adClientmoduleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String version) {
        this.adClientmoduleId = adClientmoduleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.version = version;
    }

    public String getAdClientmoduleId() {
        return adClientmoduleId;
    }

    public void setAdClientmoduleId(String adClientmoduleId) {
        this.adClientmoduleId = adClientmoduleId;
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
        hash += (adClientmoduleId != null ? adClientmoduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdClientmodule)) {
            return false;
        }
        AdClientmodule other = (AdClientmodule) object;
        if ((this.adClientmoduleId == null && other.adClientmoduleId != null) || (this.adClientmoduleId != null && !this.adClientmoduleId.equals(other.adClientmoduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdClientmodule[ adClientmoduleId=" + adClientmoduleId + " ]";
    }
    
}
