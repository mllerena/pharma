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
@Table(name = "ad_module_dbprefix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleDbprefix.findAll", query = "SELECT a FROM AdModuleDbprefix a"),
    @NamedQuery(name = "AdModuleDbprefix.findByAdModuleDbprefixId", query = "SELECT a FROM AdModuleDbprefix a WHERE a.adModuleDbprefixId = :adModuleDbprefixId"),
    @NamedQuery(name = "AdModuleDbprefix.findByIsactive", query = "SELECT a FROM AdModuleDbprefix a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleDbprefix.findByCreated", query = "SELECT a FROM AdModuleDbprefix a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleDbprefix.findByCreatedby", query = "SELECT a FROM AdModuleDbprefix a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleDbprefix.findByUpdated", query = "SELECT a FROM AdModuleDbprefix a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleDbprefix.findByUpdatedby", query = "SELECT a FROM AdModuleDbprefix a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleDbprefix.findByName", query = "SELECT a FROM AdModuleDbprefix a WHERE a.name = :name")})
public class AdModuleDbprefix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_dbprefix_id")
    private String adModuleDbprefixId;
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
    @Size(min = 1, max = 7)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleDbprefix() {
    }

    public AdModuleDbprefix(String adModuleDbprefixId) {
        this.adModuleDbprefixId = adModuleDbprefixId;
    }

    public AdModuleDbprefix(String adModuleDbprefixId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adModuleDbprefixId = adModuleDbprefixId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdModuleDbprefixId() {
        return adModuleDbprefixId;
    }

    public void setAdModuleDbprefixId(String adModuleDbprefixId) {
        this.adModuleDbprefixId = adModuleDbprefixId;
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
        hash += (adModuleDbprefixId != null ? adModuleDbprefixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleDbprefix)) {
            return false;
        }
        AdModuleDbprefix other = (AdModuleDbprefix) object;
        if ((this.adModuleDbprefixId == null && other.adModuleDbprefixId != null) || (this.adModuleDbprefixId != null && !this.adModuleDbprefixId.equals(other.adModuleDbprefixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleDbprefix[ adModuleDbprefixId=" + adModuleDbprefixId + " ]";
    }
    
}
