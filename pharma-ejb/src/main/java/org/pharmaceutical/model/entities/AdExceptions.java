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
@Table(name = "ad_exceptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdExceptions.findAll", query = "SELECT a FROM AdExceptions a"),
    @NamedQuery(name = "AdExceptions.findByAdExceptionsId", query = "SELECT a FROM AdExceptions a WHERE a.adExceptionsId = :adExceptionsId"),
    @NamedQuery(name = "AdExceptions.findByIsactive", query = "SELECT a FROM AdExceptions a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdExceptions.findByCreated", query = "SELECT a FROM AdExceptions a WHERE a.created = :created"),
    @NamedQuery(name = "AdExceptions.findByCreatedby", query = "SELECT a FROM AdExceptions a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdExceptions.findByUpdated", query = "SELECT a FROM AdExceptions a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdExceptions.findByUpdatedby", query = "SELECT a FROM AdExceptions a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdExceptions.findByName1", query = "SELECT a FROM AdExceptions a WHERE a.name1 = :name1"),
    @NamedQuery(name = "AdExceptions.findByName2", query = "SELECT a FROM AdExceptions a WHERE a.name2 = :name2"),
    @NamedQuery(name = "AdExceptions.findByType", query = "SELECT a FROM AdExceptions a WHERE a.type = :type")})
public class AdExceptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_exceptions_id")
    private String adExceptionsId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name1")
    private String name1;
    @Size(max = 60)
    @Column(name = "name2")
    private String name2;
    @Size(max = 60)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdExceptions() {
    }

    public AdExceptions(String adExceptionsId) {
        this.adExceptionsId = adExceptionsId;
    }

    public AdExceptions(String adExceptionsId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name1) {
        this.adExceptionsId = adExceptionsId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name1 = name1;
    }

    public String getAdExceptionsId() {
        return adExceptionsId;
    }

    public void setAdExceptionsId(String adExceptionsId) {
        this.adExceptionsId = adExceptionsId;
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

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (adExceptionsId != null ? adExceptionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdExceptions)) {
            return false;
        }
        AdExceptions other = (AdExceptions) object;
        if ((this.adExceptionsId == null && other.adExceptionsId != null) || (this.adExceptionsId != null && !this.adExceptionsId.equals(other.adExceptionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdExceptions[ adExceptionsId=" + adExceptionsId + " ]";
    }
    
}
