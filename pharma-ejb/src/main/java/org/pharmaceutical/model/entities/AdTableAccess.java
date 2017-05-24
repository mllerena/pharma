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
@Table(name = "ad_table_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTableAccess.findAll", query = "SELECT a FROM AdTableAccess a"),
    @NamedQuery(name = "AdTableAccess.findByAdTableAccessId", query = "SELECT a FROM AdTableAccess a WHERE a.adTableAccessId = :adTableAccessId"),
    @NamedQuery(name = "AdTableAccess.findByIsactive", query = "SELECT a FROM AdTableAccess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTableAccess.findByCreated", query = "SELECT a FROM AdTableAccess a WHERE a.created = :created"),
    @NamedQuery(name = "AdTableAccess.findByCreatedby", query = "SELECT a FROM AdTableAccess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTableAccess.findByUpdatedby", query = "SELECT a FROM AdTableAccess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTableAccess.findByUpdated", query = "SELECT a FROM AdTableAccess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTableAccess.findByIsreadonly", query = "SELECT a FROM AdTableAccess a WHERE a.isreadonly = :isreadonly"),
    @NamedQuery(name = "AdTableAccess.findByIsexclude", query = "SELECT a FROM AdTableAccess a WHERE a.isexclude = :isexclude")})
public class AdTableAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_table_access_id")
    private String adTableAccessId;
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
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isreadonly")
    private Character isreadonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isexclude")
    private Character isexclude;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRole adRoleId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdTableAccess() {
    }

    public AdTableAccess(String adTableAccessId) {
        this.adTableAccessId = adTableAccessId;
    }

    public AdTableAccess(String adTableAccessId, Character isactive, Date created, String createdby, String updatedby, Date updated, Character isreadonly, Character isexclude) {
        this.adTableAccessId = adTableAccessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.updated = updated;
        this.isreadonly = isreadonly;
        this.isexclude = isexclude;
    }

    public String getAdTableAccessId() {
        return adTableAccessId;
    }

    public void setAdTableAccessId(String adTableAccessId) {
        this.adTableAccessId = adTableAccessId;
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

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Character getIsreadonly() {
        return isreadonly;
    }

    public void setIsreadonly(Character isreadonly) {
        this.isreadonly = isreadonly;
    }

    public Character getIsexclude() {
        return isexclude;
    }

    public void setIsexclude(Character isexclude) {
        this.isexclude = isexclude;
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

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTableAccessId != null ? adTableAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTableAccess)) {
            return false;
        }
        AdTableAccess other = (AdTableAccess) object;
        if ((this.adTableAccessId == null && other.adTableAccessId != null) || (this.adTableAccessId != null && !this.adTableAccessId.equals(other.adTableAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTableAccess[ adTableAccessId=" + adTableAccessId + " ]";
    }
    
}
