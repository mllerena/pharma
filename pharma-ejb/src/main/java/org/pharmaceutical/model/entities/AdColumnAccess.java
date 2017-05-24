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
@Table(name = "ad_column_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdColumnAccess.findAll", query = "SELECT a FROM AdColumnAccess a"),
    @NamedQuery(name = "AdColumnAccess.findByAdColumnAccessId", query = "SELECT a FROM AdColumnAccess a WHERE a.adColumnAccessId = :adColumnAccessId"),
    @NamedQuery(name = "AdColumnAccess.findByIsactive", query = "SELECT a FROM AdColumnAccess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdColumnAccess.findByCreated", query = "SELECT a FROM AdColumnAccess a WHERE a.created = :created"),
    @NamedQuery(name = "AdColumnAccess.findByCreatedby", query = "SELECT a FROM AdColumnAccess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdColumnAccess.findByUpdated", query = "SELECT a FROM AdColumnAccess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdColumnAccess.findByUpdatedby", query = "SELECT a FROM AdColumnAccess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdColumnAccess.findByIsreadonly", query = "SELECT a FROM AdColumnAccess a WHERE a.isreadonly = :isreadonly"),
    @NamedQuery(name = "AdColumnAccess.findByIsexclude", query = "SELECT a FROM AdColumnAccess a WHERE a.isexclude = :isexclude")})
public class AdColumnAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_column_access_id")
    private String adColumnAccessId;
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
    @Column(name = "isreadonly")
    private Character isreadonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isexclude")
    private Character isexclude;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRole adRoleId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTable adTableId;

    public AdColumnAccess() {
    }

    public AdColumnAccess(String adColumnAccessId) {
        this.adColumnAccessId = adColumnAccessId;
    }

    public AdColumnAccess(String adColumnAccessId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isreadonly, Character isexclude) {
        this.adColumnAccessId = adColumnAccessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isreadonly = isreadonly;
        this.isexclude = isexclude;
    }

    public String getAdColumnAccessId() {
        return adColumnAccessId;
    }

    public void setAdColumnAccessId(String adColumnAccessId) {
        this.adColumnAccessId = adColumnAccessId;
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

    public AdColumn getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(AdColumn adColumnId) {
        this.adColumnId = adColumnId;
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
        hash += (adColumnAccessId != null ? adColumnAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdColumnAccess)) {
            return false;
        }
        AdColumnAccess other = (AdColumnAccess) object;
        if ((this.adColumnAccessId == null && other.adColumnAccessId != null) || (this.adColumnAccessId != null && !this.adColumnAccessId.equals(other.adColumnAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdColumnAccess[ adColumnAccessId=" + adColumnAccessId + " ]";
    }
    
}
