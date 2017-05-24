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
@Table(name = "ad_process_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcessAccess.findAll", query = "SELECT a FROM AdProcessAccess a"),
    @NamedQuery(name = "AdProcessAccess.findByAdProcessAccessId", query = "SELECT a FROM AdProcessAccess a WHERE a.adProcessAccessId = :adProcessAccessId"),
    @NamedQuery(name = "AdProcessAccess.findByIsactive", query = "SELECT a FROM AdProcessAccess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcessAccess.findByCreated", query = "SELECT a FROM AdProcessAccess a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcessAccess.findByCreatedby", query = "SELECT a FROM AdProcessAccess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcessAccess.findByUpdated", query = "SELECT a FROM AdProcessAccess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcessAccess.findByUpdatedby", query = "SELECT a FROM AdProcessAccess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcessAccess.findByIsreadwrite", query = "SELECT a FROM AdProcessAccess a WHERE a.isreadwrite = :isreadwrite")})
public class AdProcessAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_access_id")
    private String adProcessAccessId;
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
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRole adRoleId;

    public AdProcessAccess() {
    }

    public AdProcessAccess(String adProcessAccessId) {
        this.adProcessAccessId = adProcessAccessId;
    }

    public AdProcessAccess(String adProcessAccessId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isreadwrite) {
        this.adProcessAccessId = adProcessAccessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isreadwrite = isreadwrite;
    }

    public String getAdProcessAccessId() {
        return adProcessAccessId;
    }

    public void setAdProcessAccessId(String adProcessAccessId) {
        this.adProcessAccessId = adProcessAccessId;
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

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
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
        hash += (adProcessAccessId != null ? adProcessAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcessAccess)) {
            return false;
        }
        AdProcessAccess other = (AdProcessAccess) object;
        if ((this.adProcessAccessId == null && other.adProcessAccessId != null) || (this.adProcessAccessId != null && !this.adProcessAccessId.equals(other.adProcessAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcessAccess[ adProcessAccessId=" + adProcessAccessId + " ]";
    }
    
}
