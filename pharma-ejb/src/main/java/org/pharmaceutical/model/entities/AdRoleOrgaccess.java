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
@Table(name = "ad_role_orgaccess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRoleOrgaccess.findAll", query = "SELECT a FROM AdRoleOrgaccess a"),
    @NamedQuery(name = "AdRoleOrgaccess.findByAdRoleOrgaccessId", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.adRoleOrgaccessId = :adRoleOrgaccessId"),
    @NamedQuery(name = "AdRoleOrgaccess.findByIsactive", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRoleOrgaccess.findByCreated", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.created = :created"),
    @NamedQuery(name = "AdRoleOrgaccess.findByCreatedby", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRoleOrgaccess.findByUpdated", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRoleOrgaccess.findByUpdatedby", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRoleOrgaccess.findByIsOrgAdmin", query = "SELECT a FROM AdRoleOrgaccess a WHERE a.isOrgAdmin = :isOrgAdmin")})
public class AdRoleOrgaccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_role_orgaccess_id")
    private String adRoleOrgaccessId;
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
    @Column(name = "is_org_admin")
    private Character isOrgAdmin;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRole adRoleId;

    public AdRoleOrgaccess() {
    }

    public AdRoleOrgaccess(String adRoleOrgaccessId) {
        this.adRoleOrgaccessId = adRoleOrgaccessId;
    }

    public AdRoleOrgaccess(String adRoleOrgaccessId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isOrgAdmin) {
        this.adRoleOrgaccessId = adRoleOrgaccessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isOrgAdmin = isOrgAdmin;
    }

    public String getAdRoleOrgaccessId() {
        return adRoleOrgaccessId;
    }

    public void setAdRoleOrgaccessId(String adRoleOrgaccessId) {
        this.adRoleOrgaccessId = adRoleOrgaccessId;
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

    public Character getIsOrgAdmin() {
        return isOrgAdmin;
    }

    public void setIsOrgAdmin(Character isOrgAdmin) {
        this.isOrgAdmin = isOrgAdmin;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adRoleOrgaccessId != null ? adRoleOrgaccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRoleOrgaccess)) {
            return false;
        }
        AdRoleOrgaccess other = (AdRoleOrgaccess) object;
        if ((this.adRoleOrgaccessId == null && other.adRoleOrgaccessId != null) || (this.adRoleOrgaccessId != null && !this.adRoleOrgaccessId.equals(other.adRoleOrgaccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRoleOrgaccess[ adRoleOrgaccessId=" + adRoleOrgaccessId + " ]";
    }
    
}
