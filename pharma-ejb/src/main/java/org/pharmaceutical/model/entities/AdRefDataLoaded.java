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
@Table(name = "ad_ref_data_loaded")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRefDataLoaded.findAll", query = "SELECT a FROM AdRefDataLoaded a"),
    @NamedQuery(name = "AdRefDataLoaded.findByAdRefDataLoadedId", query = "SELECT a FROM AdRefDataLoaded a WHERE a.adRefDataLoadedId = :adRefDataLoadedId"),
    @NamedQuery(name = "AdRefDataLoaded.findByIsactive", query = "SELECT a FROM AdRefDataLoaded a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRefDataLoaded.findByCreated", query = "SELECT a FROM AdRefDataLoaded a WHERE a.created = :created"),
    @NamedQuery(name = "AdRefDataLoaded.findByCreatedby", query = "SELECT a FROM AdRefDataLoaded a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRefDataLoaded.findByUpdated", query = "SELECT a FROM AdRefDataLoaded a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRefDataLoaded.findByUpdatedby", query = "SELECT a FROM AdRefDataLoaded a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRefDataLoaded.findByGenericId", query = "SELECT a FROM AdRefDataLoaded a WHERE a.genericId = :genericId"),
    @NamedQuery(name = "AdRefDataLoaded.findBySpecificId", query = "SELECT a FROM AdRefDataLoaded a WHERE a.specificId = :specificId")})
public class AdRefDataLoaded implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ref_data_loaded_id")
    private String adRefDataLoadedId;
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
    @Column(name = "generic_id")
    private String genericId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "specific_id")
    private String specificId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdRefDataLoaded() {
    }

    public AdRefDataLoaded(String adRefDataLoadedId) {
        this.adRefDataLoadedId = adRefDataLoadedId;
    }

    public AdRefDataLoaded(String adRefDataLoadedId, Character isactive, Date created, String createdby, Date updated, String updatedby, String genericId, String specificId) {
        this.adRefDataLoadedId = adRefDataLoadedId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.genericId = genericId;
        this.specificId = specificId;
    }

    public String getAdRefDataLoadedId() {
        return adRefDataLoadedId;
    }

    public void setAdRefDataLoadedId(String adRefDataLoadedId) {
        this.adRefDataLoadedId = adRefDataLoadedId;
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

    public String getGenericId() {
        return genericId;
    }

    public void setGenericId(String genericId) {
        this.genericId = genericId;
    }

    public String getSpecificId() {
        return specificId;
    }

    public void setSpecificId(String specificId) {
        this.specificId = specificId;
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

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adRefDataLoadedId != null ? adRefDataLoadedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRefDataLoaded)) {
            return false;
        }
        AdRefDataLoaded other = (AdRefDataLoaded) object;
        if ((this.adRefDataLoadedId == null && other.adRefDataLoadedId != null) || (this.adRefDataLoadedId != null && !this.adRefDataLoadedId.equals(other.adRefDataLoadedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRefDataLoaded[ adRefDataLoadedId=" + adRefDataLoadedId + " ]";
    }
    
}
